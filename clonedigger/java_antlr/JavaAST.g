/** A Java 1.5 grammar for ANTLR v3 derived from the spec
 *
 *  This is a very close representation of the spec; the changes
 *  are comestic (remove left recursion) and also fixes (the spec
 *  isn't exactly perfect).  I have run this on the 1.4.2 source
 *  and some nasty looking enums from 1.5, but have not really
 *  tested for 1.5 compatibility.
 *
 *  I built this with: java -Xmx100M org.antlr.Tool java.g 
 *  and got two errors that are ok (for now):
 *  java.g:691:9: Decision can match input such as
 *    "'0'..'9'{'E', 'e'}{'+', '-'}'0'..'9'{'D', 'F', 'd', 'f'}"
 *    using multiple alternatives: 3, 4
 *  As a result, alternative(s) 4 were disabled for that input
 *  java.g:734:35: Decision can match input such as "{'$', 'A'..'Z',
 *    '_', 'a'..'z', '\u00C0'..'\u00D6', '\u00D8'..'\u00F6',
 *    '\u00F8'..'\u1FFF', '\u3040'..'\u318F', '\u3300'..'\u337F',
 *    '\u3400'..'\u3D2D', '\u4E00'..'\u9FFF', '\uF900'..'\uFAFF'}"
 *    using multiple alternatives: 1, 2
 *  As a result, alternative(s) 2 were disabled for that input
 *
 *  You can turn enum on/off as a keyword :)
 *
 *  Version 1.0 -- initial release July 5, 2006 (requires 3.0b2 or higher)
 *
 *  Primary author: Terence Parr, July 2006
 *
 *  Version 1.0.1 -- corrections by Koen Vanderkimpen & Marko van Dooren,
 *      October 25, 2006;
 *      fixed normalInterfaceDeclaration: now uses typeParameters instead
 *          of typeParameter (according to JLS, 3rd edition)
 *      fixed castExpression: no longer allows expression next to type
 *          (according to semantics in JLS, in contrast with syntax in JLS)
 *
 *  Version 1.0.2 -- Terence Parr, Nov 27, 2006
 *      java spec I built this from had some bizarre for-loop control.
 *          Looked weird and so I looked elsewhere...Yep, it's messed up.
 *          simplified.
 *
 *  Version 1.0.3 -- Chris Hogue, Feb 26, 2007
 *      Factored out an annotationName rule and used it in the annotation rule.
 *          Not sure why, but typeName wasn't recognizing references to inner
 *          annotations (e.g. @InterfaceName.InnerAnnotation())
 *      Factored out the elementValue section of an annotation reference.  Created 
 *          elementValuePair and elementValuePairs rules, then used them in the 
 *          annotation rule.  Allows it to recognize annotation references with 
 *          multiple, comma separated attributes.
 *      Updated elementValueArrayInitializer so that it allows multiple elements.
 *          (It was only allowing 0 or 1 element).
 *      Updated localVariableDeclaration to allow annotations.  Interestingly the JLS
 *          doesn't appear to indicate this is legal, but it does work as of at least
 *          JDK 1.5.0_06.
 *      Moved the Identifier portion of annotationTypeElementRest to annotationMethodRest.
 *          Because annotationConstantRest already references variableDeclarator which 
 *          has the Identifier portion in it, the parser would fail on constants in 
 *          annotation definitions because it expected two identifiers.  
 *      Added optional trailing ';' to the alternatives in annotationTypeElementRest.
 *          Wouldn't handle an inner interface that has a trailing ';'.
 *      Swapped the expression and type rule reference order in castExpression to 
 *          make it check for genericized casts first.  It was failing to recognize a
 *          statement like  "Class<Byte> TYPE = (Class<Byte>)...;" because it was seeing
 *          'Class<Byte' in the cast expression as a less than expression, then failing 
 *          on the '>'.
 *      Changed createdName to use typeArguments instead of nonWildcardTypeArguments.
 *          Again, JLS doesn't seem to allow this, but java.lang.Class has an example of
 *          of this construct.
 *      Changed the 'this' alternative in primary to allow 'identifierSuffix' rather than
 *          just 'arguments'.  The case it couldn't handle was a call to an explicit
 *          generic method invocation (e.g. this.<E>doSomething()).  Using identifierSuffix
 *          may be overly aggressive--perhaps should create a more constrained thisSuffix rule?
 *      
 *  Version 1.0.4 -- Hiroaki Nakamura, May 3, 2007
 *
 *  Fixed formalParameterDecls, localVariableDeclaration, forInit,
 *  and forVarControl to use variableModifier* not 'final'? (annotation)?
 *
 *  Version 1.0.5 -- Terence, June 21, 2007
 *  --a[i].foo didn't work. Fixed unaryExpression
 *
 *  Version 1.0.6 -- John Ridgway, March 17, 2008
 *      Made "assert" a switchable keyword like "enum".
 *      Fixed compilationUnit to disallow "annotation importDeclaration ...".
 *      Changed "Identifier ('.' Identifier)*" to "qualifiedName" in more 
 *          places.
 *      Changed modifier* and/or variableModifier* to classOrInterfaceModifiers,
 *          modifiers or variableModifiers, as appropriate.
 *      Renamed "bound" to "typeBound" to better match language in the JLS.
 *      Added "memberDeclaration" which rewrites to methodDeclaration or 
 *      fieldDeclaration and pulled type into memberDeclaration.  So we parse 
 *          type and then move on to decide whether we're dealing with a field
 *          or a method.
 *      Modified "constructorDeclaration" to use "constructorBody" instead of
 *          "methodBody".  constructorBody starts with explicitConstructorInvocation,
 *          then goes on to blockStatement*.  Pulling explicitConstructorInvocation
 *          out of expressions allowed me to simplify "primary".
 *      Changed variableDeclarator to simplify it.
 *      Changed type to use classOrInterfaceType, thus simplifying it; of course
 *          I then had to add classOrInterfaceType, but it is used in several 
 *          places.
 *      Fixed annotations, old version allowed "@X(y,z)", which is illegal.
 *      Added optional comma to end of "elementValueArrayInitializer"; as per JLS.
 *      Changed annotationTypeElementRest to use normalClassDeclaration and 
 *          normalInterfaceDeclaration rather than classDeclaration and 
 *          interfaceDeclaration, thus getting rid of a couple of grammar ambiguities.
 *      Split localVariableDeclaration into localVariableDeclarationStatement
 *          (includes the terminating semi-colon) and localVariableDeclaration.  
 *          This allowed me to use localVariableDeclaration in "forInit" clauses,
 *           simplifying them.
 *      Changed switchBlockStatementGroup to use multiple labels.  This adds an
 *          ambiguity, but if one uses appropriately greedy parsing it yields the
 *           parse that is closest to the meaning of the switch statement.
 *      Renamed "forVarControl" to "enhancedForControl" -- JLS language.
 *      Added semantic predicates to test for shift operations rather than other
 *          things.  Thus, for instance, the string "< <" will never be treated
 *          as a left-shift operator.
 *      In "creator" we rule out "nonWildcardTypeArguments" on arrayCreation, 
 *          which are illegal.
 *      Moved "nonWildcardTypeArguments into innerCreator.
 *      Removed 'super' superSuffix from explicitGenericInvocation, since that
 *          is only used in explicitConstructorInvocation at the beginning of a
 *           constructorBody.  (This is part of the simplification of expressions
 *           mentioned earlier.)
 *      Simplified primary (got rid of those things that are only used in
 *          explicitConstructorInvocation).
 *      Lexer -- removed "Exponent?" from FloatingPointLiteral choice 4, since it
 *          led to an ambiguity.
 *
 *      This grammar successfully parses every .java file in the JDK 1.5 source 
 *          tree (excluding those whose file names include '-', which are not
 *          valid Java compilation units).
 *
 *  Version 1.0.6.CD -- Peter Bulychev, April 25, 2008
 *	Small modifications for supporting Clone Digger
 *
 *  Known remaining problems:
 *      "Letter" and "JavaIDDigit" are wrong.  The actual specification of
 *      "Letter" should be "a character for which the method
 *      Character.isJavaIdentifierStart(int) returns true."  A "Java 
 *      letter-or-digit is a character for which the method 
 *      Character.isJavaIdentifierPart(int) returns true."
 */
grammar JavaAST;
options {
    k=2; 
    backtrack=true; 
    memoize=true;
    output=AST;
    ASTLabelType=MyAstNode;
}

tokens {
    COMPILATION_UNIT;
    PACKAGE_DECLARATION;
    SINGLE_TYPE_IMPORT_DECLARATION;
    TYPE_IMPORT_ON_DEMAND_DECLARATION;
    SINGLE_STATIC_IMPORT_DECLARATION;
    STATIC_IMPORT_ON_DEMAND_DECLARATION;
    MODIFIERS;
    CLASS_DECLARATION;
    TYPE_PARAMETERS;
    TYPE_PARAMETER;
    TYPE_BOUND;
    ENUM_DECLARATION;
    ENUM_BODY;
    ENUM_CONSTANTS;
    ENUM_CONSTANT;
    ENUM_BODY_DECLARATIONS;
    INTERFACE_DECLARATION;
    CLASS_BODY;
    INTERFACE_BODY;
    STATIC_INITIALIZER;
    INSTANCE_INITIALIZER;
    VOID;
    FIELD_DECLARATION;
    METHOD_DECLARATION;
    ABSTRACT_METHOD_DECLARATION;
    CONSTRUCTOR_DECLARATION;
    VARIABLE_DECLARATOR;
    CONSTANT_DECLARATION;
    ARRAY_OF;
    ARRAY_INITIALIZER;
    CONSTRUCTOR_BODY;
    INSTANTIATION;
    SELECT;
    TYPE_ARGUMENTS;
    WILDCARD;
    FORMAL_PARAMETERS;
    FORMAL_PARAMETER;
    LAST_FORMAL_PARAMETER;
    ALTERNATE_CONSTRUCTOR_INVOCATION;
    UNQUALIFIED_SUPERCLASS_CONSTRUCTOR_INVOCATION;
    QUALIFIED_SUPERCLASS_CONSTRUCTOR_INVOCATION;
    NORMAL_ANNOTATION;
    SINGLE_ELEMENT_ANNOTATION;
    MARKER_ANNOTATION;
    ELEMENT_VALUE_PAIR;
    ELEMENT_VALUE_ARRAY_INITIALIZER;
    ANNOTATION_INTERFACE;
    ANNOTATION_TYPE_BODY;
    ANNOTATION_METHOD;
    BLOCK;
    LOCAL_VARIABLE_DECLARATION;
    ASSERT_STATEMENT;
    EMPTY_STATEMENT;
    EXPRESSION_STATEMENT;
    SWITCH_BLOCK_STATEMENT_GROUP;
    BASIC_FOR_CONTROL;
    FOR_INIT_DECLARATION;
    FOR_INIT_EXPRESSION_LIST;
    ENHANCED_FOR_CONTROL;
    FOR_UPDATE;
    EXPRESSION_LIST;
    LEFT_SHIFT_ASSIGN;
    UNSIGNED_RIGHT_SHIFT_ASSIGN;
    SIGNED_RIGHT_SHIFT_ASSIGN;
    LESS_THAN_OR_EQUAL_TO;
    GREATER_THAN_OR_EQUAL_TO;
    LEFT_SHIFT;
    UNSIGNED_RIGHT_SHIFT;
    SIGNED_RIGHT_SHIFT;
    PREFIX_EXPRESSION;
    POST_INCREMENT_EXPRESSION;
    POST_DECREMENT_EXPRESSION;
    CAST;
    THIS;
    UNQUALIFIED_SUPER;
    CLASS_DESIGNATOR;
    ARRAY_ACCESS;
    CALL;
    QUALIFIED_THIS;
    QUALIFIED_SUPER;
    UNQUALIFIED_CLASS_INSTANCE_CREATION;
    QUALIFIED_CLASS_INSTANCE_CREATION;
    NEW_INITIALIZED_ARRAY;
    NEW_ARRAY;
    EXPLICIT_GENERIC_INVOCATIONS;
    NON_WILD_TYPE_ARGUMENTS;
    INNER_THIS;
    ARGUMENTS;
}

@lexer::members {
  protected boolean enumIsKeyword = true;
  protected boolean assertIsKeyword = true;
}

// starting point for parsing a java file
/* The annotations are separated out to make parsing faster, but must be associated with
   a packageDeclaration or a typeDeclaration (and not an empty one). */
compilationUnit
    :   ('@')=> annotations
        (   packageDeclaration[$annotations.tree] importDeclaration* typeDeclaration*
            -> ^(COMPILATION_UNIT packageDeclaration importDeclaration* typeDeclaration*)
        |   classOrInterfaceDeclaration[$annotations.tree] typeDeclaration*
            -> ^(COMPILATION_UNIT classOrInterfaceDeclaration typeDeclaration*)
       )
    |   (packageDeclaration[null])? importDeclaration* typeDeclaration*
        -> ^(COMPILATION_UNIT packageDeclaration? importDeclaration* typeDeclaration*)
    ;

packageDeclaration[Tree annotations]
    :   'package' qualifiedName ';'
        -> ^(PACKAGE_DECLARATION {annotations} qualifiedName)
    ;
    
importDeclaration
    :   'import' (staticModifier='static')? qualifiedName ('.' wildcard='*')? ';'
        -> {staticModifier == null && wildcard == null}?
            ^(SINGLE_TYPE_IMPORT_DECLARATION qualifiedName)
        -> {staticModifier == null && wildcard != null}?
            ^(TYPE_IMPORT_ON_DEMAND_DECLARATION qualifiedName)
        -> {staticModifier != null && wildcard == null}?
            ^(SINGLE_STATIC_IMPORT_DECLARATION qualifiedName)
        -> /*{staticModifier != null && wildcard != null}? */
            ^(STATIC_IMPORT_ON_DEMAND_DECLARATION qualifiedName)
    ;
    
typeDeclaration
    :   classOrInterfaceDeclaration[null]
    |   ';'
        ->
    ;
    
classOrInterfaceDeclaration[Tree annotations]
    :   classOrInterfaceModifiers[annotations]! (classDeclaration[$classOrInterfaceModifiers.tree] | interfaceDeclaration[$classOrInterfaceModifiers.tree])
    ;
    
classOrInterfaceModifiers[Tree annotations]
    :   classOrInterfaceModifier*
        -> ^(MODIFIERS {annotations} classOrInterfaceModifier*)
    ;

classOrInterfaceModifier
    :   annotation   // class or interface
    |   'public'     // class or interface
    |   'protected'  // class or interface
    |   'private'    // class or interface
    |   'abstract'   // class or interface
    |   'static'     // class or interface
    |   'final'      // class only -- does not apply to interfaces
    |   'strictfp'   // class or interface
    ;

modifiers
    :   modifier*
        -> ^(MODIFIERS modifier*)
    ;

classDeclaration[Tree modifiers]
    :   normalClassDeclaration[modifiers]
    |   enumDeclaration[modifiers]
    ;
    
normalClassDeclaration[Tree modifiers]
@after {retval.tree.is_statement = true;}
    :   'class' identifier (typeParameters)?
        (extendsPhrase)?
        (implementsPhrase)?
        classBody
        -> ^(CLASS_DECLARATION {modifiers} identifier typeParameters? extendsPhrase? implementsPhrase? classBody)
    ;

extendsPhrase
    :   'extends' type
        -> ^('extends' type)
    ;

implementsPhrase
    :   'implements' typeList
        -> ^('implements' typeList)
    ;

typeParameters
    :   '<' typeParameter (',' typeParameter)* '>'
        -> ^(TYPE_PARAMETERS typeParameter+)
    ;

typeParameter
    :   identifier ('extends' typeBound)?
        -> ^(TYPE_PARAMETER identifier typeBound?)
    ;
        
typeBound
    :   type ('&' type)*
        -> ^(TYPE_BOUND type+)
    ;

enumDeclaration[Tree modifiers]
    :   ENUM identifier (implementsPhrase)? enumBody
        -> ^(ENUM_DECLARATION {modifiers} identifier implementsPhrase? enumBody)
    ;

enumBody
    :   '{' enumConstants? ','? enumBodyDeclarations? '}'
        -> ^(ENUM_BODY enumConstants? enumBodyDeclarations?)
    ;

enumConstants
    :   enumConstant (',' enumConstant)*
        -> ^(ENUM_CONSTANTS enumConstant+)
    ;
    
enumConstant
    :   annotations? identifier (arguments)? (classBody)?
        -> ^(ENUM_CONSTANT annotations? identifier arguments? classBody?)
    ;
    
enumBodyDeclarations
    :   ';' (classBodyDeclaration)*
        -> ^(ENUM_BODY_DECLARATIONS classBodyDeclaration*)
    ;
    
interfaceDeclaration[Tree modifiers]
    :   normalInterfaceDeclaration[modifiers]
    |   annotationTypeDeclaration[modifiers]
    ;
    
normalInterfaceDeclaration[Tree modifiers]
    :   'interface' identifier typeParameters? (extendsInterfaces)? interfaceBody
        -> ^(INTERFACE_DECLARATION {modifiers} identifier typeParameters? extendsInterfaces? interfaceBody)
    ;

extendsInterfaces
    :   'extends' typeList
        -> ^('extends' typeList)
    ;
    
typeList
    :   type (','! type)*
    ;
    
classBody
    :   '{' classBodyDeclaration* '}'
        -> ^(CLASS_BODY classBodyDeclaration*)
    ;
    
interfaceBody
    :   '{' interfaceBodyDeclaration* '}'
        -> ^(INTERFACE_BODY interfaceBodyDeclaration*)
    ;

classBodyDeclaration
    :   ';'
        ->
    |   'static' block
        -> ^(STATIC_INITIALIZER block)
    |   block
        -> ^(INSTANCE_INITIALIZER block)
    |   modifiers! memberDecl[$modifiers.tree]
    ;
    
memberDecl[Tree modifiers]
    :   genericMethodOrConstructorDecl[modifiers]
    |   memberDeclaration[modifiers]
    |   'void' identifier voidMethodDeclaratorRest[modifiers, $identifier.tree]
        -> voidMethodDeclaratorRest
    |   identifier constructorDeclaratorRest[modifiers, null, $identifier.tree]
        -> constructorDeclaratorRest
    |   interfaceDeclaration[modifiers]
    |   classDeclaration[modifiers]
    ;
    
memberDeclaration[Tree modifiers]
    :   type! (methodDeclaration[modifiers, $type.tree]
              | fieldDeclaration[modifiers, $type.tree])
    ;

genericMethodOrConstructorDecl[Tree modifiers]
    :   typeParameters! genericMethodOrConstructorRest[modifiers, $typeParameters.tree]
    ;
    
genericMethodOrConstructorRest[Tree modifiers, Tree typeParameters]
    :   rt=resultType! identifier! 
        methodDeclaratorRest[modifiers, typeParameters, $rt.tree, $identifier.tree]
    |   identifier! constructorDeclaratorRest[modifiers, typeParameters, $identifier.tree]
    ;

resultType 
    :   type
    |   'void' -> VOID
    ;

methodDeclaration[Tree modifiers, Tree returnType]
    :   identifier! methodDeclaratorRest[modifiers, returnType, null, $identifier.tree]
    ;

fieldDeclaration[Tree modifiers, Tree fieldType]
    :   variableDeclarators ';'
        -> ^(FIELD_DECLARATION {modifiers} {fieldType} variableDeclarators)
    ;
        
interfaceBodyDeclaration
    :   modifiers! interfaceMemberDecl[$modifiers.tree]
    |   ';'!
    ;

interfaceMemberDecl[Tree modifiers]
    :   interfaceMethodOrFieldDecl[modifiers]
    |   interfaceGenericMethodDecl[modifiers]
    |   'void'! identifier! voidInterfaceMethodDeclaratorRest[modifiers, $identifier.tree]
    |   interfaceDeclaration[ modifiers]
    |   classDeclaration[modifiers]
    ;
    
interfaceMethodOrFieldDecl[Tree modifiers]
    :   t=type! identifier! interfaceMethodOrFieldRest[modifiers, t.tree, $identifier.tree]
    ;
    
interfaceMethodOrFieldRest[Tree modifiers, Tree type, Tree identifier]
    :   constantDeclaratorsRest[modifiers, type, identifier] ';'!
    |   interfaceMethodDeclaratorRest[modifiers, null, type, identifier]
    ;

/* This converts obsolete post-formal '[]' array specifiers to array specifiers on the
   return type in the AST. */    
methodDeclaratorRest[Tree modifiers, Tree type, Tree typeParameters, Tree identifier]
@after {retval.tree.is_statement = true;}
    :   formalParameters 
        ( '[' ']'
          { type = (Tree)adaptor.becomeRoot(adaptor.create(ARRAY_OF, "ARRAY_OF"), type); }
        )*
        (throwsPhrase)?
        (  methodBody
            -> ^(METHOD_DECLARATION {modifiers} {$type} {typeParameters} {identifier}
                 formalParameters (throwsPhrase)? methodBody)
        |   ';'
            -> ^(METHOD_DECLARATION {modifiers} {$type} {typeParameters} {identifier}
                 formalParameters (throwsPhrase)?)
        )
    ;

throwsPhrase
    :   'throws' qualifiedNameList -> ^('throws' qualifiedNameList)
    ;
    
voidMethodDeclaratorRest[Tree modifiers, Tree identifier]
@after {retval.tree.is_statement = true;}
    :   formalParameters (throwsPhrase)?
        (  methodBody
            -> ^(METHOD_DECLARATION {modifiers} VOID {identifier} formalParameters 
                (throwsPhrase)? methodBody)
        |   ';'
            -> ^(METHOD_DECLARATION {modifiers} VOID {identifier} formalParameters 
                (throwsPhrase)?)
       )
    ;
    
interfaceMethodDeclaratorRest[Tree modifiers, Tree typeParameters, Tree type, Tree identifier]
@after {retval.tree.is_statement = true;}
    :   formalParameters 
        ('[' ']'
            { type = (Tree)adaptor.becomeRoot(adaptor.create(ARRAY_OF, "ARRAY_OF"), type); })*
        (throwsPhrase)? ';'
        -> ^(ABSTRACT_METHOD_DECLARATION {modifiers} {typeParameters} {type} {identifier} formalParameters (throwsPhrase)?)
    ;
    
interfaceGenericMethodDecl[Tree modifiers]
    :   typeParameters! rt=resultType! identifier!
        interfaceMethodDeclaratorRest[modifiers, $typeParameters.tree, rt.tree, $identifier.tree]
    ;
    
voidInterfaceMethodDeclaratorRest[Tree modifiers, Tree identifier]
@after {retval.tree.is_statement = true;}
    :   formalParameters (throwsPhrase)? ';'
        -> ^(ABSTRACT_METHOD_DECLARATION {modifiers} VOID {identifier} formalParameters (throwsPhrase)?)
    ;
    
constructorDeclaratorRest[Tree modifiers, Tree typeParameters, Tree identifier]
    :   formalParameters (throwsPhrase)? constructorBody
        -> ^(CONSTRUCTOR_DECLARATION {modifiers} {typeParameters} {identifier}
             formalParameters (throwsPhrase)? constructorBody)
    ;

constantDeclarator[Tree modifiers, Tree type]
    :   identifier! constantDeclaratorRest[modifiers, type, $identifier.tree]
    ;
    
variableDeclarators
    :   variableDeclarator (',' variableDeclarator)*
        -> variableDeclarator+
    ;

variableDeclarator
    :   variableDeclaratorId ('=' variableInitializer)?
        -> ^(VARIABLE_DECLARATOR variableDeclaratorId variableInitializer?)
    ;
    
constantDeclaratorsRest[Tree modifiers, Tree type, Tree identifier]
    :   constantDeclaratorRest[modifiers, type, identifier] (','! constantDeclarator[modifiers, type])*
    ;

constantDeclaratorRest[Tree modifiers, Tree type, Tree identifier]
    :   ('[' ']'
            { type = (Tree)adaptor.becomeRoot(adaptor.create(ARRAY_OF, "ARRAY_OF"), type); })*
        '=' variableInitializer
        -> ^(CONSTANT_DECLARATION {modifiers} {type} {identifier} variableInitializer)
        ;
    
variableDeclaratorId
    :   (identifier -> identifier) 
        ('[' ']' -> ^(ARRAY_OF $variableDeclaratorId) )*
    ;

variableInitializer
    :   arrayInitializer
    |   expression
    ;
        
arrayInitializer
    :   '{' (variableInitializer (',' variableInitializer)* (',')? )? '}'
        -> ^(ARRAY_INITIALIZER variableInitializer*)
    ;

modifier
    :   annotation
    |   'public'
    |   'protected'
    |   'private'
    |   'static'
    |   'abstract'
    |   'final'
    |   'native'
    |   'synchronized'
    |   'transient'
    |   'volatile'
    |   'strictfp'
    ;

packageOrTypeName
    :   qualifiedName
    ;

enumConstantName
    :   identifier
    ;

typeName
    :   qualifiedName
    ;

// 4.1 -- The Kinds of Types and Values
type
	:	( classOrInterfaceType -> classOrInterfaceType )
        ( '[' ']' -> ^(ARRAY_OF $type) )*
	|	( primitiveType -> primitiveType )
        ( '[' ']' -> ^(ARRAY_OF $type) )*
	;

classOrInterfaceType
	:	( identifier -> identifier )
        ( typeArguments -> ^(INSTANTIATION $classOrInterfaceType typeArguments) )?
        ( ( '.' identifier -> ^(SELECT $classOrInterfaceType identifier) )
          (typeArguments -> ^(INSTANTIATION $classOrInterfaceType typeArguments) )? 
        )*
	;

primitiveType
    :   'boolean'
    |   'char'
    |   'byte'
    |   'short'
    |   'int'
    |   'long'
    |   'float'
    |   'double'
    ;

variableModifier
    :   'final'
    |   annotation
    ;

typeArguments
    :   '<' typeArgument (',' typeArgument)* '>'
        -> ^(TYPE_ARGUMENTS typeArgument+)
    ;
    
typeArgument
    :   type
        -> type
    |   '?' ((kind='extends' | kind='super') type)?
        -> ^(WILDCARD $kind? type?)
    ;
    
qualifiedNameList
    :   qualifiedName (','! qualifiedName)*
    ;

formalParameters
    :   '(' formalParameterDecls? ')'
        -> ^(FORMAL_PARAMETERS formalParameterDecls?)
    ;
    
formalParameterDecls
    :   variableModifiers! pType=type! formalParameterDeclsRest[$variableModifiers.tree, pType.tree]
    ;
    
formalParameterDeclsRest[Tree modifiers, Tree type]
    :   variableDeclaratorId 
        (',' formalParameterDecls
            -> ^(FORMAL_PARAMETER {modifiers} {type} variableDeclaratorId) formalParameterDecls
        |
            -> ^(FORMAL_PARAMETER {modifiers} {type} variableDeclaratorId)
        )
    |   '...' variableDeclaratorId
        -> ^(LAST_FORMAL_PARAMETER {modifiers} {type} variableDeclaratorId)
    ;
    
methodBody
    :   block
    ;

constructorBody
    :   '{' explicitConstructorInvocation? blockStatement* '}'
        -> ^(CONSTRUCTOR_BODY explicitConstructorInvocation? blockStatement*)
    ;

explicitConstructorInvocation
    :   (nonWildcardTypeArguments)?
        ( ( 'this' arguments ';' 
            -> ^(ALTERNATE_CONSTRUCTOR_INVOCATION nonWildcardTypeArguments? arguments) )
        | ( 'super' arguments ';'
            -> ^(UNQUALIFIED_SUPERCLASS_CONSTRUCTOR_INVOCATION nonWildcardTypeArguments? arguments) )
        )
    |   primary '.' nonWildcardTypeArguments? 'super' arguments ';'
        -> ^(QUALIFIED_SUPERCLASS_CONSTRUCTOR_INVOCATION primary nonWildcardTypeArguments? arguments)
    ;


qualifiedName
    :   (identifier->identifier)
        ('.' identifier -> ^(SELECT $qualifiedName identifier))*
    ;
    
literal 
    :   integerLiteral
    |   FloatingPointLiteral
    |   CharacterLiteral
    |   StringLiteral
    |   booleanLiteral
    |   'null'
    ;

integerLiteral
    :   HexLiteral
    |   OctalLiteral
    |   DecimalLiteral
    ;

booleanLiteral
    :   'true'
    |   'false'
    ;

// ANNOTATIONS

annotations
    :   annotation+
    ;

annotation
    :   '@' annotationName 
        ( '(' ( elementValuePairs
                -> ^(NORMAL_ANNOTATION annotationName elementValuePairs)
              | elementValue 
                -> ^(SINGLE_ELEMENT_ANNOTATION annotationName elementValue)
              )? 
          ')'
        | // Nothing
          -> ^(MARKER_ANNOTATION annotationName)
        )
    ;
    
annotationName
    :   (identifier -> identifier)
        ('.' id=identifier -> ^(SELECT $annotationName $id))*
    ;

elementValuePairs
    :   elementValuePair (',' elementValuePair)*
        -> elementValuePair+
    ;

elementValuePair
    :   identifier '=' elementValue
        -> ^(ELEMENT_VALUE_PAIR identifier elementValue)
    ;
    
elementValue
    :   conditionalExpression
    |   annotation
    |   elementValueArrayInitializer
    ;
    
elementValueArrayInitializer
    :   '{' (elementValue (',' elementValue)*)? (',')? '}'
        -> ^(ELEMENT_VALUE_ARRAY_INITIALIZER elementValue+)
    ;
    
annotationTypeDeclaration[Tree modifiers]
    :   '@' 'interface' identifier annotationTypeBody
        -> ^(ANNOTATION_INTERFACE {modifiers} identifier annotationTypeBody)
    ;
    
annotationTypeBody
    :   '{' (annotationTypeElementDeclaration)* '}'
        -> ^(ANNOTATION_TYPE_BODY annotationTypeElementDeclaration*)
    ;
    
annotationTypeElementDeclaration
    :   modifiers! annotationTypeElementRest[$modifiers.tree]
    ;
    
annotationTypeElementRest[Tree modifiers]
    :   type annotationMethodOrConstantRest[modifiers, $type.tree] ';'
        -> annotationMethodOrConstantRest
    |   normalClassDeclaration[modifiers] ';'!?
    |   normalInterfaceDeclaration[modifiers] ';'!?
    |   enumDeclaration[modifiers] ';'!?
    |   annotationTypeDeclaration[modifiers] ';'!?
    ;
    
annotationMethodOrConstantRest[Tree modifiers, Tree type]
    :   annotationMethodRest[modifiers, type]
    |   annotationConstantRest[modifiers, type]
    ;
    
annotationMethodRest[Tree modifiers, Tree type]
    :   identifier '(' ')' (defaultValue)?
        -> ^(ANNOTATION_METHOD {modifiers} {type} identifier defaultValue?)
    ;
    
annotationConstantRest[Tree modifiers, Tree type]
    :   variableDeclarators
        -> ^(FIELD_DECLARATION {$modifiers} {$type} variableDeclarators)
    ;
    
defaultValue
    :   'default' elementValue
        -> ^('default' elementValue)
    ;

// STATEMENTS / BLOCKS

block
@after {retval.tree.is_statement = true;}
    :   '{' blockStatement* '}'
        -> ^(BLOCK blockStatement*)
    ;
    
blockStatement
    :   localVariableDeclarationStatement
    |   classOrInterfaceDeclaration[null]
    |   statement
    ;
    
localVariableDeclarationStatement
    :    localVariableDeclaration ';'!
    ;

localVariableDeclaration
@after {retval.tree.is_statement = true;}
    :   variableModifiers type variableDeclarators
        -> ^(LOCAL_VARIABLE_DECLARATION variableModifiers type variableDeclarators)
    ;
    
variableModifiers
    :   variableModifier*
        -> ^(MODIFIERS variableModifier*)
    ;

statement
@after {retval.tree.is_statement = true;}
    : block
    |   ASSERT e1=expression (':' e2=expression)? ';'
        -> ^(ASSERT_STATEMENT $e1 $e2?)
    |   'if' parExpression statement (options {k=1;}:'else' statement)?
        -> ^('if' parExpression statement+)
    |   'for' '(' forControl ')' statement
        -> ^('for' forControl statement)
    |   'while'^ parExpression statement
        -> ^('while' parExpression statement)
    |   'do' statement 'while' parExpression ';'
        -> ^('do' statement parExpression)
    |   'try' tryBlock=block
        ( catches 'finally' finallyBlock=block
            -> ^('try' $tryBlock catches ^('finally' $finallyBlock))
        | catches
            -> ^('try' $tryBlock catches)
        |   'finally' finallyBlock=block
            -> ^('try' $tryBlock ^('finally' $finallyBlock))
        )
    |   'switch' parExpression '{' switchBlockStatementGroups '}'
        -> ^('switch' parExpression switchBlockStatementGroups)
    |   'synchronized' parExpression block
        -> ^('synchronized' parExpression block)
    |   'return' expression? ';'
        -> ^('return' expression?)
    |   'throw' expression ';'
        -> ^('throw' expression)
    |   'break' identifier? ';'
        -> ^('break' identifier?)
    |   'continue' identifier? ';'
        -> ^('continue' identifier?)
    |   ';' 
        -> EMPTY_STATEMENT
    |   statementExpression ';'
        -> ^(EXPRESSION_STATEMENT statementExpression)
    |   identifier ':' statement
        -> ^(':' identifier statement)
    ;
    
catches
    :   catchClause (catchClause)*
    ;
    
catchClause
    :   'catch' '(' formalParameter ')' block
        -> ^('catch' formalParameter block)
    ;

formalParameter
    :   variableModifiers type variableDeclaratorId
        -> ^(FORMAL_PARAMETER variableModifiers type variableDeclaratorId)
    ;
        
switchBlockStatementGroups
    :   (switchBlockStatementGroup)*
    ;
    
/* The change here (switchLabel -> switchLabel+) technically makes this grammar
   ambiguous; but with appropriately greedy parsing it yields the most
   appropriate AST, one in which each group, except possibly the last one, has
   labels and statements. */
switchBlockStatementGroup
    :   switchLabel+ blockStatement*
        -> ^(SWITCH_BLOCK_STATEMENT_GROUP switchLabel+ blockStatement*)
    ;
    
switchLabel
    :   'case'^ constantExpression ':'!
    |   'case'^ enumConstantName ':'!
    |   'default'^ ':'!
    ;
    
forControl
options {k=3;} // be efficient for common case: for (ID ID : ID) ...
    :   enhancedForControl
    |   forInit? ';' expression? ';' forUpdate?
        -> ^(BASIC_FOR_CONTROL forInit? ';' expression? ';' forUpdate?)
    ;

forInit
    :   localVariableDeclaration
        -> ^(FOR_INIT_DECLARATION localVariableDeclaration)
    |   expressionList
        -> ^(FOR_INIT_EXPRESSION_LIST expressionList)
    ;
    
enhancedForControl
    :   variableModifiers type identifier ':' expression
        -> ^(ENHANCED_FOR_CONTROL variableModifiers type identifier expression)
    ;

forUpdate
    :   expressionList
        -> ^(FOR_UPDATE expressionList)
    ;

// EXPRESSIONS

parExpression
    :   '('! expression ')'!
    ;
    
expressionList
    :   expression (',' expression)*
        -> ^(EXPRESSION_LIST expression+)
    ;

statementExpression
    :   expression
    ;
    
constantExpression
    :   expression
    ;
    
expression
    :   conditionalExpression (assignmentOperator^ expression)?
    ;
    
assignmentOperator
    :   '='
    |   '+='
    |   '-='
    |   '*='
    |   '/='
    |   '&='
    |   '|='
    |   '^='
    |   '%='
    |   ('<' '<' '=')=> t1='<' t2='<' t3='=' 
        { $t1.getLine() == $t2.getLine() &&
          $t1.getCharPositionInLine() + 1 == $t2.getCharPositionInLine() && 
          $t2.getLine() == $t3.getLine() && 
          $t2.getCharPositionInLine() + 1 == $t3.getCharPositionInLine() }?
        -> LEFT_SHIFT_ASSIGN
    |   ('>' '>' '>' '=')=> t1='>' t2='>' t3='>' t4='='
        { $t1.getLine() == $t2.getLine() && 
          $t1.getCharPositionInLine() + 1 == $t2.getCharPositionInLine() &&
          $t2.getLine() == $t3.getLine() && 
          $t2.getCharPositionInLine() + 1 == $t3.getCharPositionInLine() &&
          $t3.getLine() == $t4.getLine() && 
          $t3.getCharPositionInLine() + 1 == $t4.getCharPositionInLine() }?
        -> UNSIGNED_RIGHT_SHIFT_ASSIGN
    |   ('>' '>' '=')=> t1='>' t2='>' t3='='
        { $t1.getLine() == $t2.getLine() && 
          $t1.getCharPositionInLine() + 1 == $t2.getCharPositionInLine() && 
          $t2.getLine() == $t3.getLine() && 
          $t2.getCharPositionInLine() + 1 == $t3.getCharPositionInLine() }?
        -> SIGNED_RIGHT_SHIFT_ASSIGN
    ;

conditionalExpression
    :   conditionalOrExpression ( '?'^ expression ':'! expression )?
    ;

conditionalOrExpression
    :   conditionalAndExpression ( '||'^ conditionalAndExpression )*
    ;

conditionalAndExpression
    :   inclusiveOrExpression ('&&'^ inclusiveOrExpression)*
    ;

inclusiveOrExpression
    :   exclusiveOrExpression ('|'^ exclusiveOrExpression)*
    ;

exclusiveOrExpression
    :   andExpression ('^'^ andExpression)*
    ;

andExpression
    :   equalityExpression ('&'^ equalityExpression)*
    ;

equalityExpression
    :   instanceOfExpression (('==' | '!=')^ instanceOfExpression)*
    ;

instanceOfExpression
    :   relationalExpression ('instanceof'^ type)?
    ;

relationalExpression
    :   shiftExpression (relationalOp^ shiftExpression)*
    ;
    
relationalOp
    :   ('<' '=')=> t1='<' t2='=' 
        { $t1.getLine() == $t2.getLine() && 
          $t1.getCharPositionInLine() + 1 == $t2.getCharPositionInLine() }?
        -> LESS_THAN_OR_EQUAL_TO
    |   ('>' '=')=> t1='>' t2='=' 
        { $t1.getLine() == $t2.getLine() && 
          $t1.getCharPositionInLine() + 1 == $t2.getCharPositionInLine() }?
        -> GREATER_THAN_OR_EQUAL_TO
    |   '<' 
    |   '>' 
    ;

shiftExpression
    :   additiveExpression (shiftOp^ additiveExpression)*
    ;

shiftOp
    :   ('<' '<')=> t1='<' t2='<' 
        { $t1.getLine() == $t2.getLine() && 
          $t1.getCharPositionInLine() + 1 == $t2.getCharPositionInLine() }?
        -> LEFT_SHIFT
    |   ('>' '>' '>')=> t1='>' t2='>' t3='>' 
        { $t1.getLine() == $t2.getLine() && 
          $t1.getCharPositionInLine() + 1 == $t2.getCharPositionInLine() &&
          $t2.getLine() == $t3.getLine() && 
          $t2.getCharPositionInLine() + 1 == $t3.getCharPositionInLine() }?
        -> UNSIGNED_RIGHT_SHIFT
    |   ('>' '>')=> t1='>' t2='>'
        { $t1.getLine() == $t2.getLine() && 
          $t1.getCharPositionInLine() + 1 == $t2.getCharPositionInLine() }?
        -> SIGNED_RIGHT_SHIFT 
    ;


additiveExpression
    :   multiplicativeExpression (('+' | '-')^ multiplicativeExpression)*
    ;

multiplicativeExpression
    :   unaryExpression (('*' | '/' | '%')^ unaryExpression)*
    ;
    
unaryExpression
    :   '+' unaryExpression
        -> ^(PREFIX_EXPRESSION '+' unaryExpression)
    |   '-' unaryExpression
        -> ^(PREFIX_EXPRESSION '-' unaryExpression)
    |   '++' unaryExpression
        -> ^(PREFIX_EXPRESSION '++' unaryExpression)
    |   '--' unaryExpression
        -> ^(PREFIX_EXPRESSION '--' unaryExpression)
    |   unaryExpressionNotPlusMinus
    ;

unaryExpressionNotPlusMinus
    :   '~' unaryExpression     -> ^(PREFIX_EXPRESSION '~' unaryExpression)
    |   '!' unaryExpression     -> ^(PREFIX_EXPRESSION '!' unaryExpression)
    |   castExpression
    |   ( primary -> primary )
        ( (selector[null])=> selector[$unaryExpressionNotPlusMinus.tree]
            -> selector )*
        (  ( '++' -> ^(POST_INCREMENT_EXPRESSION $unaryExpressionNotPlusMinus )
           | '--' -> ^(POST_DECREMENT_EXPRESSION $unaryExpressionNotPlusMinus )
           ) )?
    ;

castExpression
    :  '(' primitiveType ')' unaryExpression
        -> ^(CAST primitiveType unaryExpression)
    |  '(' (type | expression) ')' unaryExpressionNotPlusMinus
        -> ^(CAST type? expression? unaryExpressionNotPlusMinus)
    ;

primary
    :   parExpression
    |   ( 'this' -> THIS)
        ( '.' identifier -> ^(SELECT $primary identifier) )*
        ( (identifierSuffix[null])=> identifierSuffix[$primary.tree] -> identifierSuffix )?
    |   ( 'super' -> UNQUALIFIED_SUPER ) 
        superSuffix[$primary.tree] -> superSuffix
    |   literal
    |   'new' creator
        -> creator
    |   ( identifier -> identifier )
        ( '.' identifier -> ^(SELECT $primary identifier) )*
        ( (identifierSuffix[null])=> identifierSuffix[$primary.tree] -> identifierSuffix )?
    |   ( primitiveType -> primitiveType )
        ( '[' ']' -> ^(ARRAY_OF $primary) )*
        '.' 'class' -> ^(CLASS_DESIGNATOR $primary)
    |   'void' '.' 'class'
        -> ^(CLASS_DESIGNATOR VOID)
    ;

identifierSuffix[Tree expr]
    :   ( '[' ']' -> ^(ARRAY_OF {expr}))
        ( '[' ']' -> ^(ARRAY_OF $identifierSuffix) )*
        ( '.' 'class' -> ^(CLASS_DESIGNATOR $identifierSuffix) )
    |   (-> {expr})
        ('[' expression ']' -> ^(ARRAY_ACCESS $identifierSuffix expression))+
    |   arguments
        -> ^(CALL {expr} arguments)
    |   '.' 'class'
        -> ^(CLASS_DESIGNATOR {expr})
    |   '.' explicitGenericInvocation[expr]
        -> explicitGenericInvocation
    |   '.' 'this'
        -> ^(QUALIFIED_THIS {expr})
    |   '.' 'super' arguments
        -> ^(CALL ^(QUALIFIED_SUPER {expr}) arguments)
    |   '.' 'new' innerCreator[expr]
        -> innerCreator
    ;

creator
    :   nonWildcardTypeArguments createdName classCreatorRest
        -> ^(UNQUALIFIED_CLASS_INSTANCE_CREATION nonWildcardTypeArguments createdName classCreatorRest)
    |   createdName
        (   (arrayCreatorRest[$createdName.tree]
            -> arrayCreatorRest)
        |   classCreatorRest
            -> ^(UNQUALIFIED_CLASS_INSTANCE_CREATION createdName classCreatorRest)
        )
    ;

createdName
    :   classOrInterfaceType
    |   primitiveType
    ;
    
innerCreator[Tree expr]
    :   (nonWildcardTypeArguments)? identifier classCreatorRest
        -> ^(QUALIFIED_CLASS_INSTANCE_CREATION {expr} nonWildcardTypeArguments? identifier classCreatorRest)
    ;

arrayCreatorRest[Tree name]
    :   
        dims arrayInitializer
        -> ^(NEW_INITIALIZED_ARRAY {$name} dims arrayInitializer)
    |   '[' dimExprs+=expression ']' ('[' dimExprs+=expression ']')* dims?
        -> ^(NEW_ARRAY {$name} $dimExprs dims?)
    ;

dims
    :   (result+='[' ']')+
        -> $result
    ;

classCreatorRest
    :   arguments classBody?
    ;
    
explicitGenericInvocation[Tree expr]
    :   nonWildcardTypeArguments identifier arguments
        -> ^(EXPLICIT_GENERIC_INVOCATIONS {expr} nonWildcardTypeArguments identifier arguments)
    ;
    
nonWildcardTypeArguments
    :   '<' typeList '>'
        -> ^(NON_WILD_TYPE_ARGUMENTS typeList)
    ;
    
selector[Tree expr]
    :   ('.' identifier -> ^(SELECT {expr} identifier))
        (arguments -> ^(CALL $selector arguments))?
    |   '.' 'this'
        -> ^(INNER_THIS {expr})
    |   ( '.' 'super' -> ^(QUALIFIED_SUPER {expr}) )
        superSuffix[$selector.tree]
        -> superSuffix
    |   '.' 'new' innerCreator[expr]
        -> innerCreator
    |   '[' expression ']'
        -> ^(ARRAY_ACCESS {expr} expression)
    ;
    
superSuffix[Tree expr]
    :   arguments
        -> ^(CALL {expr} arguments)
    |   ('.' identifier -> ^(SELECT {$expr} identifier))
        ( arguments -> ^(CALL $superSuffix arguments))?
    ;

arguments
    :   '(' expressionList? ')'
        -> ^(ARGUMENTS expressionList?)
    ;

identifier
    :   Identifier
    ;

// LEXER

HexLiteral : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

OctalLiteral : '0' ('0'..'7')+ IntegerTypeSuffix? ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
IntegerTypeSuffix : ('l'|'L') ;

FloatingPointLiteral
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent FloatTypeSuffix?
    |   ('0'..'9')+ FloatTypeSuffix
    ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;

CharacterLiteral
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

ENUM:   'enum' {if (!enumIsKeyword) $type=Identifier;}
    ;
    
ASSERT
    :   'assert' {if (!assertIsKeyword) $type=Identifier;}
    ;
    
Identifier 
    :   Letter (Letter|JavaIDDigit)*
    ;

/**I found this char range in JavaCC's grammar, but Letter and Digit overlap.
   Still works, but...
 */
fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

COMMENT
    :   '/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
