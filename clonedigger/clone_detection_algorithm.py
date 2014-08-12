#    Copyright 2008 Peter Bulychev
#
#    This file is part of Clone Digger.
#
#    Clone Digger is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    Clone Digger is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#   You should have received a copy of the GNU General Public License
#   along with Clone Digger.  If not, see <http://www.gnu.org/licenses/>.

import sys

from anti_unification import *
from abstract_syntax_tree import *

def findDuplicateCode(source_files, report):
    statement_sequences = []
    statement_count = 0
    sequences_lengths = []
    for source_file in source_files:
        sequences = source_file.getTree().getAllStatementSequences()
        statement_sequences.extend(sequences)
        sequences_lengths.extend([len(s) for s in sequences])
        statement_count += sum([len(s) for s in sequences])

    if not sequences_lengths:
        print 'Input is empty or the size of the input is below the size threshold'
        # sys.exit(0)
        return []

    if verbose:
        n_sequences = len(sequences_lengths)    
        avg_seq_length = sum(sequences_lengths)/float(n_sequences)
        max_seq_length = max(sequences_lengths)

        print '%d sequences' %(n_sequences,)
        print 'average sequence length: %f' % (avg_seq_length,)
        print 'maximum sequence length: %d' % (max_seq_length,)
        sequences_without_restriction = statement_sequences
        sequences = []
        if not arguments.force:
            for sequence in sequences_without_restriction:
                if len(sequence) > 1000:
                    first_statement = sequence[0]
                    print
                    print '-----------------------------------------'
                    print 'Warning: sequences of statements, consists of %d elements is too long.' %(len(sequence),)
                    print 'It starts at %s:%d.'%(first_statement.getSourceFile().getFileName(), min(first_statement.getCoveredLineNumbers()))
                    print 'It will be ignored. Use --force to override this restriction.'
                    print 'Please refer to http://clonedigger.sourceforge.net/documentation.html'
                    print '-----------------------------------------'
                else:
                    sequences.append(sequence)
  
    def calc_statement_sizes():
        for sequence in statement_sequences:
            for statement in sequence:
                statement.storeSize()

    def build_hash_to_statement(dcup_hash = True):
        hash_to_statement = {}
        for statement_sequence in statement_sequences:
            for statement in statement_sequence:
                if dcup_hash:
                    # 3 - CONSTANT HERE!
                    h = statement.getDCupHash(arguments.hashing_depth)
                else:
                    h = statement.getFullHash()
                if not hash_to_statement.has_key(h):
                    hash_to_statement[h] = [statement]
                else:
                    hash_to_statement[h].append(statement)                  
        return hash_to_statement
    def build_unifiers(hash_to_statement):
        processed_statements_count = 0
        clusters = []
        ret = {}
        for h in hash_to_statement.keys():
            local_clusters = []
            statements = hash_to_statement[h]
            for statement in statements:
                processed_statements_count += 1
                if verbose and ((processed_statements_count % 1000) == 0):
                    print '%d,' %(processed_statements_count,),
                    sys.stdout.flush()
                bestcluster = None
                mincost = sys.maxint
                for cluster in local_clusters:
                    cost = cluster.getAddCost(statement)
                    if cost < mincost:
                        mincost = cost
                        bestcluster = cluster
                assert(local_clusters==[] or bestcluster)
                if mincost < 0:
                    pdb.set_trace()
                assert(mincost >= 0)
                if bestcluster == None or mincost > arguments.clustering_threshold:
                    newcluster = Cluster(statement)
                    local_clusters.append(newcluster)
                else:
                    bestcluster.unify(statement)                
            ret[h] = local_clusters 
            clusters.extend(local_clusters)
        return ret

    def clusterize(hash_to_statement, clusters_map):
        processed_statements_count = 0
        # clusters_map contain hash values for statements, not unifiers
        # therefore it will work correct even if unifiers are smaller than hashing depth value
        for h in hash_to_statement.keys():
            clusters = clusters_map[h]
            for statement in hash_to_statement[h]:
                processed_statements_count += 1
                if verbose and ((processed_statements_count % 1000) == 0):
                    print '%d,' %(processed_statements_count,),
                    sys.stdout.flush()
                mincost = sys.maxint
                for cluster in clusters:
                    new_u = Unifier(cluster.getUnifierTree(), statement)
#                   assert(new_u.getSubstitutions()[0].getSize() == 0)
                    cost = new_u.getSize()
                    if cost < mincost:
                        mincost = cost
                        statement.setMark(cluster)
                        cluster.addWithoutUnification(statement)
    def filterOutLongEquallyLabeledSequences(statement_sequences):
        #TODO - refactor, combine with the previous warning
        sequences_without_restriction = statement_sequences
        statement_sequences = []
        for sequence in sequences_without_restriction:
            new_sequence = copy.copy(sequence._sequence) 
            current_mark = None
            length = 0
            first_statement_index = None
            flag = False 
            for i in range(len(sequence)):
                statement = sequence[i]
                if statement.getMark() != current_mark:
                    if flag == True:
                        flag = False 
                    current_mark=statement.getMark()
                    length=0
                    first_statement_index = i
                else:
                    length += 1
                    if length>10:
                        new_sequence[i] = None
                        if not flag:
                            for i in range(first_statement_index, i):
                                new_sequence[i] = None
                            first_statement = sequence[first_statement_index]                        
                            print
                            print '-----------------------------------------'
                            print 'Warning: sequence of statements starting at %s:%d'%(first_statement.getSourceFile().getFileName(), min(first_statement.getCoveredLineNumbers()))
                            print 'consists of many similar statements.'
                            print 'It will be ignored. Use --force to override this restriction.'
                            print 'Please refer to http://clonedigger.sourceforge.net/documentation.html'
                            print '-----------------------------------------'
                            flag = True 
            new_sequence = new_sequence + [None]
            cur_sequence = StatementSequence() 
            for statement in new_sequence:
                if statement == None:
                    if cur_sequence:
                        statement_sequences.append(cur_sequence)
                        cur_sequence = StatementSequence() 
                else:
                    cur_sequence.addStatement(statement)
        return statement_sequences

    def mark_using_hash(hash_to_statement):     
        for h in hash_to_statement:
            cluster = Cluster()
            for statement in hash_to_statement[h]:
                cluster.addWithoutUnification(statement)
                statement.setMark(cluster)              
    def findHugeSequences():
        def f_size(x):    
            return x.getMaxCoveredLines()
        def f_elem(x):
            return StatementSequence(x).getCoveredLineNumbersCount()
        def fcode(x):
            return x.getMark()
        f = f_size
        suffix_tree_instance = suffix_tree.SuffixTree(fcode)
        for sequence in statement_sequences:
            suffix_tree_instance.add(sequence)
        return [PairSequences([StatementSequence(s1), StatementSequence(s2)]) for (s1,s2) in suffix_tree_instance.getBestMaxSubstrings(arguments.size_threshold, f, f_elem)]
    def refineDuplicates(pairs_sequences):
        r = []
        flag = False
        while pairs_sequences:      
            pair_sequences = pairs_sequences.pop()
            def all_pairsubsequences_size_n_threshold(n):
                lr = []
                for first in range(0, pair_sequences.getLength()-n+1):
                    new_pair_sequences = pair_sequences.subSequence(first, n)
                    size = new_pair_sequences.getMaxCoveredLineNumbersCount()
                    if size >= arguments.size_threshold:
                        lr.append((new_pair_sequences, first))
                return lr
            n = pair_sequences.getLength() + 1
            while 1:
                n-=1
                if n == 0:
                    break
                new_pairs_sequences = all_pairsubsequences_size_n_threshold(n)
                for (candidate_sequence, first) in new_pairs_sequences:             
                    distance = candidate_sequence.calcDistance()
                    if (distance < arguments.distance_threshold):
                        r.append(candidate_sequence)
                        if first > 0:
                            pairs_sequences.append(pair_sequences.subSequence(0, first-1))
                        if first+n < pair_sequences.getLength():
                            pairs_sequences.append(pair_sequences.subSequence(first+n, pair_sequences.getLength() - first - n))
                        n+=1
                        flag = True
                        break
                if flag:
                    flag = False
                    break
        return r
    def remove_dominated_clones(clones):
        ret_clones = []
#       def f_cmp(a, b):
#           return a.getLevel().__cmp__(b.getLevel())
#       clones.sort(f_cmp)
        statement_to_clone = {}
        for clone in clones:
            for sequence in clone:
                for statement in sequence:
                    if not statement_to_clone.has_key(statement):
                        statement_to_clone[statement] = []
                    statement_to_clone[statement].append(clone)
        for clone in clones:
            ancestors_2 = clone[1].getAncestors()
            flag = True
            for s1 in clone[0].getAncestors():
                if statement_to_clone.has_key(s1):
                    for clone2 in statement_to_clone[s1]:
                        if s1 in clone2[0]:
                            seq = clone2[1]
                        else:
                            assert(s1 in clone2[1])
                            seq = clone2[0]
                        for s2 in seq:
                            if s2 in ancestors_2:
                                flag = False
                                break
                        if not flag:
                            break
                if not flag:
                    break
            if flag:
                ret_clones.append(clone)
        return ret_clones

    if verbose:
        print 'Number of statements: ', statement_count
        print 'Calculating size for each statement...',
        sys.stdout.flush()
    calc_statement_sizes() 
    if verbose:
        print 'done'

    if verbose:
        print 'Building statement hash...',
        sys.stdout.flush()
    report.startTimer('Building statement hash')
    if arguments.clusterize_using_hash:
        hash_to_statement = build_hash_to_statement(dcup_hash = False)
    else:
        hash_to_statement = build_hash_to_statement(dcup_hash = True)
    report.stopTimer()
    if verbose:
        print 'done'
        print 'Number of different hash values: ', len(hash_to_statement)
    
    if arguments.clusterize_using_dcup or arguments.clusterize_using_hash:
        print 'Marking each statement with its hash value'
        mark_using_hash(hash_to_statement)
    else:
        if verbose:
            print 'Building patterns...',
            sys.stdout.flush()
        report.startTimer('Building patterns')
        clusters_map = build_unifiers(hash_to_statement)    
        report.stopTimer()
        if verbose:
            print Cluster.count, 'patterns were discovered'
            print 'Choosing pattern for each statement...',
            sys.stdout.flush()
        report.startTimer('Marking similar statements')
        clusterize(hash_to_statement, clusters_map)
        report.stopTimer()
        if verbose:
            print 'done'

    if arguments.report_unifiers:
        if verbose:
            print 'Building reverse hash for reporting ...',
            sys.stdout.flush()
        reverse_hash = {}
        for sequence in statement_sequences:
            for statement in sequence:
                mark = statement.getMark()
                if not reverse_hash.has_key(mark):
                    reverse_hash[mark] = []
                reverse_hash[mark].append(statement)
        report.setMarkToStatementHash(reverse_hash)
        if verbose:
            print 'done'

    if verbose:
        print 'Finding similar sequences of statements...',
        sys.stdout.flush()
    
    if not arguments.force:
        statement_sequences = filterOutLongEquallyLabeledSequences(statement_sequences)

    report.startTimer('Finding similar sequences of statements')
    duplicate_candidates = findHugeSequences()
    report.stopTimer()
    if verbose:
        print len(duplicate_candidates), ' sequences were found'
        print 'Refining candidates...',
        sys.stdout.flush()    
    if arguments.distance_threshold!=-1:
        report.startTimer('Refining candidates')
        clones = refineDuplicates(duplicate_candidates)
        report.stopTimer()
    else:
        clones = duplicate_candidates
    if verbose:
        print len(clones), 'clones were found'
    if arguments.distance_threshold!=-1:
        if verbose:
            print 'Removing dominated clones...',
            sys.stdout.flush()
        old_clone_count = len(clones)
        clones = remove_dominated_clones(clones)
        if verbose:
            print len(clones) - old_clone_count, 'clones were removed' 

    ## get covered source lines for all detected clones (set of all)
    covered_source_lines = set()
    for clone in clones:
        for sequence in clone:
            covered_source_lines |= sequence.getLineNumberHashables()

    ## get source lines for all files/sequences (set of all)
    source_lines = set()
    for sequence in statement_sequences:
        source_lines |= sequence.getLineNumberHashables()

    report.all_source_lines_count = len(source_lines)
    report.covered_source_lines_count = len(covered_source_lines)

    return clones
