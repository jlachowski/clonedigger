// $ANTLR 3.1.1 JavaScript.g 2009-03-06 21:11:52

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class JavaScriptParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NULL", "TRUE", "FALSE", "BREAK", "CASE", "CATCH", "CONTINUE", "DEFAULT", "DELETE", "DO", "ELSE", "FINALLY", "FOR", "FUNCTION", "IF", "IN", "INSTANCEOF", "NEW", "RETURN", "SWITCH", "THIS", "THROW", "TRY", "TYPEOF", "VAR", "VOID", "WHILE", "WITH", "ABSTRACT", "BOOLEAN", "BYTE", "CHAR", "CLASS", "CONST", "DEBUGGER", "DOUBLE", "ENUM", "EXPORT", "EXTENDS", "FINAL", "FLOAT", "GOTO", "IMPLEMENTS", "IMPORT", "INT", "INTERFACE", "LONG", "NATIVE", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "SHORT", "STATIC", "SUPER", "SYNCHRONIZED", "THROWS", "TRANSIENT", "VOLATILE", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "DOT", "SEMIC", "COMMA", "LT", "GT", "LTE", "GTE", "EQ", "NEQ", "SAME", "NSAME", "ADD", "SUB", "MUL", "MOD", "INC", "DEC", "SHL", "SHR", "SHU", "AND", "OR", "XOR", "NOT", "INV", "LAND", "LOR", "QUE", "COLON", "ASSIGN", "ADDASS", "SUBASS", "MULASS", "MODASS", "SHLASS", "SHRASS", "SHUASS", "ANDASS", "ORASS", "XORASS", "DIV", "DIVASS", "ARGS", "ARRAY", "BLOCK", "BYFIELD", "BYINDEX", "CALL", "CEXPR", "EXPR", "FORITER", "FORSTEP", "ITEM", "LABELLED", "NAMEDVALUE", "NEG", "OBJECT", "PAREXPR", "PDEC", "PINC", "POS", "BSLASH", "DQUOTE", "SQUOTE", "TAB", "VT", "FF", "SP", "NBSP", "USP", "WhiteSpace", "LF", "CR", "LS", "PS", "LineTerminator", "EOL", "MultiLineComment", "SingleLineComment", "Identifier", "StringLiteral", "HexDigit", "IdentifierStartASCII", "DecimalDigit", "IdentifierPart", "IdentifierNameASCIIStart", "RegularExpressionLiteral", "OctalDigit", "ExponentPart", "DecimalIntegerLiteral", "DecimalLiteral", "OctalIntegerLiteral", "HexIntegerLiteral", "CharacterEscapeSequence", "ZeroToThree", "OctalEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "EscapeSequence", "BackslashSequence", "RegularExpressionFirstChar", "RegularExpressionChar"
    };
    public static final int BackslashSequence=168;
    public static final int CONST=37;
    public static final int COMMA=71;
    public static final int RegularExpressionLiteral=155;
    public static final int ARGS=111;
    public static final int ARRAY=112;
    public static final int LF=140;
    public static final int SYNCHRONIZED=59;
    public static final int HexDigit=150;
    public static final int DOUBLE=39;
    public static final int EXPR=118;
    public static final int ADDASS=99;
    public static final int DecimalDigit=152;
    public static final int FALSE=6;
    public static final int USP=138;
    public static final int ABSTRACT=32;
    public static final int SP=136;
    public static final int DQUOTE=131;
    public static final int IMPORT=47;
    public static final int SEMIC=70;
    public static final int MODASS=102;
    public static final int PACKAGE=52;
    public static final int SQUOTE=132;
    public static final int SHR=87;
    public static final int CONTINUE=10;
    public static final int DOT=69;
    public static final int PRIVATE=53;
    public static final int MultiLineComment=146;
    public static final int HexIntegerLiteral=161;
    public static final int AND=89;
    public static final int RegularExpressionFirstChar=169;
    public static final int DIVASS=110;
    public static final int FUNCTION=17;
    public static final int GTE=75;
    public static final int OctalEscapeSequence=164;
    public static final int HexEscapeSequence=165;
    public static final int SingleLineComment=147;
    public static final int UnicodeEscapeSequence=166;
    public static final int POS=129;
    public static final int RPAREN=66;
    public static final int IdentifierStartASCII=151;
    public static final int FINALLY=15;
    public static final int IdentifierNameASCIIStart=154;
    public static final int EXTENDS=42;
    public static final int IdentifierPart=153;
    public static final int SUPER=58;
    public static final int Identifier=148;
    public static final int SAME=78;
    public static final int CHAR=35;
    public static final int NEW=21;
    public static final int EQ=76;
    public static final int LT=72;
    public static final int FINAL=43;
    public static final int SUBASS=100;
    public static final int VT=134;
    public static final int LAND=94;
    public static final int LBRACK=67;
    public static final int CATCH=9;
    public static final int STATIC=57;
    public static final int CASE=8;
    public static final int MUL=82;
    public static final int INTERFACE=49;
    public static final int ExponentPart=157;
    public static final int INV=93;
    public static final int BOOLEAN=33;
    public static final int ELSE=14;
    public static final int CharacterEscapeSequence=162;
    public static final int BSLASH=130;
    public static final int SHLASS=103;
    public static final int DecimalLiteral=159;
    public static final int BREAK=7;
    public static final int NULL=4;
    public static final int XOR=91;
    public static final int COLON=97;
    public static final int DIV=109;
    public static final int ORASS=107;
    public static final int TRUE=5;
    public static final int ADD=80;
    public static final int THROW=25;
    public static final int SHORT=56;
    public static final int LABELLED=122;
    public static final int CR=141;
    public static final int RegularExpressionChar=170;
    public static final int PUBLIC=55;
    public static final int SHL=86;
    public static final int LONG=50;
    public static final int LOR=95;
    public static final int TYPEOF=27;
    public static final int INC=84;
    public static final int TRANSIENT=61;
    public static final int TAB=133;
    public static final int FLOAT=44;
    public static final int ZeroToThree=163;
    public static final int THROWS=60;
    public static final int FF=135;
    public static final int FORITER=119;
    public static final int GOTO=45;
    public static final int MOD=83;
    public static final int EXPORT=41;
    public static final int OR=90;
    public static final int MULASS=101;
    public static final int LBRACE=63;
    public static final int BLOCK=113;
    public static final int RBRACE=64;
    public static final int PROTECTED=54;
    public static final int ANDASS=106;
    public static final int LineTerminator=144;
    public static final int SHU=88;
    public static final int EscapeSequence=167;
    public static final int PAREXPR=126;
    public static final int INT=48;
    public static final int LS=142;
    public static final int CEXPR=117;
    public static final int ASSIGN=98;
    public static final int VOID=29;
    public static final int INSTANCEOF=20;
    public static final int LPAREN=65;
    public static final int WhiteSpace=139;
    public static final int XORASS=108;
    public static final int QUE=96;
    public static final int NEQ=77;
    public static final int NAMEDVALUE=123;
    public static final int ENUM=40;
    public static final int PS=143;
    public static final int DEBUGGER=38;
    public static final int DELETE=12;
    public static final int OBJECT=125;
    public static final int DO=13;
    public static final int IMPLEMENTS=46;
    public static final int OctalIntegerLiteral=160;
    public static final int WHILE=30;
    public static final int SWITCH=23;
    public static final int BYINDEX=115;
    public static final int FORSTEP=120;
    public static final int OctalDigit=156;
    public static final int PINC=128;
    public static final int GT=73;
    public static final int StringLiteral=149;
    public static final int DecimalIntegerLiteral=158;
    public static final int SHRASS=104;
    public static final int ITEM=121;
    public static final int SHUASS=105;
    public static final int THIS=24;
    public static final int WITH=31;
    public static final int IN=19;
    public static final int VAR=28;
    public static final int LTE=74;
    public static final int CLASS=36;
    public static final int NATIVE=51;
    public static final int DEC=85;
    public static final int RETURN=22;
    public static final int BYTE=34;
    public static final int VOLATILE=62;
    public static final int IF=18;
    public static final int EOF=-1;
    public static final int EOL=145;
    public static final int NBSP=137;
    public static final int CALL=116;
    public static final int FOR=16;
    public static final int RBRACK=68;
    public static final int DEFAULT=11;
    public static final int NEG=124;
    public static final int SUB=81;
    public static final int NOT=92;
    public static final int TRY=26;
    public static final int PDEC=127;
    public static final int BYFIELD=114;
    public static final int NSAME=79;

    // delegates
    // delegators


        public JavaScriptParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public JavaScriptParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return JavaScriptParser.tokenNames; }
    public String getGrammarFileName() { return "JavaScript.g"; }


    private final boolean isLeftHandSideAssign(RuleReturnScope lhs, Object[] cached)
    {
    	if (cached[0] != null)
    	{
    		return ((Boolean)cached[0]).booleanValue();
    	}
    	
    	boolean result;
    	if (isLeftHandSideExpression(lhs))
    	{
    		switch (input.LA(1))
    		{
    			case ASSIGN:
    			case MULASS:
    			case DIVASS:
    			case MODASS:
    			case ADDASS:
    			case SUBASS:
    			case SHLASS:
    			case SHRASS:
    			case SHUASS:
    			case ANDASS:
    			case XORASS:
    			case ORASS:
    				result = true;
    				break;
    			default:
    				result = false;
    				break;
    		}
    	}
    	else
    	{
    		result = false;
    	}
    	
    	cached[0] = new Boolean(result);
    	return result;
    }

    private final static boolean isLeftHandSideExpression(RuleReturnScope lhs)
    {
    	if (lhs.getTree() == null) // e.g. during backtracking
    	{
    		return true;
    	}
    	else
    	{
    		switch (((Tree)lhs.getTree()).getType())
    		{
    		// primaryExpression
    			case THIS:
    			case Identifier:
    			case NULL:
    			case TRUE:
    			case FALSE:
    			case DecimalLiteral:
    			case OctalIntegerLiteral:
    			case HexIntegerLiteral:
    			case StringLiteral:
    			case RegularExpressionLiteral:
    			case ARRAY:
    			case OBJECT:
    			case PAREXPR:
    		// functionExpression
    			case FUNCTION:
    		// newExpression
    			case NEW:
    		// leftHandSideExpression
    			case CALL:
    			case BYFIELD:
    			case BYINDEX:
    				return true;
    			
    			default:
    				return false;
    		}
    	}
    }
    	
    private final boolean isLeftHandSideIn(RuleReturnScope lhs, Object[] cached)
    {
    	if (cached[0] != null)
    	{
    		return ((Boolean)cached[0]).booleanValue();
    	}
    	
    	boolean result = isLeftHandSideExpression(lhs) && (input.LA(1) == IN);
    	cached[0] = new Boolean(result);
    	return result;
    }

    private final void promoteEOL(ParserRuleReturnScope rule)
    {
    	// Get current token and its type (the possibly offending token).
    	Token lt = input.LT(1);
    	int la = lt.getType();
    	
    	// We only need to promote an EOL when the current token is offending (not a SEMIC, EOF, RBRACE, EOL or MultiLineComment).
    	// EOL and MultiLineComment are not offending as they're already promoted in a previous call to this method.
    	// Promoting an EOL means switching it from off channel to on channel.
    	// A MultiLineComment gets promoted when it contains an EOL.
    	if (!(la == SEMIC || la == EOF || la == RBRACE || la == EOL || la == MultiLineComment))
    	{
    		// Start on the possition before the current token and scan backwards off channel tokens until the previous on channel token.
    		for (int ix = lt.getTokenIndex() - 1; ix > 0; ix--)
    		{
    			lt = input.get(ix);
    			if (lt.getChannel() == Token.DEFAULT_CHANNEL)
    			{
    				// On channel token found: stop scanning.
    				break;
    			}
    			else if (lt.getType() == EOL || (lt.getType() == MultiLineComment && lt.getText().matches("/.*\r\n|\r|\n")))
    			{
    				// We found our EOL: promote the token to on channel, position the input on it and reset the rule start.
    				lt.setChannel(Token.DEFAULT_CHANNEL);
    				input.seek(lt.getTokenIndex());
    				if (rule != null)
    				{
    					rule.start = lt;
    				}
    				break;
    			}
    		}
    	}
    }	


    public static class token_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "token"
    // JavaScript.g:511:1: token : ( reservedWord | Identifier | punctuator | numericLiteral | StringLiteral );
    public final JavaScriptParser.token_return token() throws RecognitionException {
        JavaScriptParser.token_return retval = new JavaScriptParser.token_return();
        retval.start = input.LT(1);
        int token_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token Identifier2=null;
        Token StringLiteral5=null;
        JavaScriptParser.reservedWord_return reservedWord1 = null;

        JavaScriptParser.punctuator_return punctuator3 = null;

        JavaScriptParser.numericLiteral_return numericLiteral4 = null;


        MyAstNode Identifier2_tree=null;
        MyAstNode StringLiteral5_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // JavaScript.g:512:2: ( reservedWord | Identifier | punctuator | numericLiteral | StringLiteral )
            int alt1=5;
            switch ( input.LA(1) ) {
            case NULL:
            case TRUE:
            case FALSE:
            case BREAK:
            case CASE:
            case CATCH:
            case CONTINUE:
            case DEFAULT:
            case DELETE:
            case DO:
            case ELSE:
            case FINALLY:
            case FOR:
            case FUNCTION:
            case IF:
            case IN:
            case INSTANCEOF:
            case NEW:
            case RETURN:
            case SWITCH:
            case THIS:
            case THROW:
            case TRY:
            case TYPEOF:
            case VAR:
            case VOID:
            case WHILE:
            case WITH:
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case CONST:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
                {
                alt1=1;
                }
                break;
            case Identifier:
                {
                alt1=2;
                }
                break;
            case LBRACE:
            case RBRACE:
            case LPAREN:
            case RPAREN:
            case LBRACK:
            case RBRACK:
            case DOT:
            case SEMIC:
            case COMMA:
            case LT:
            case GT:
            case LTE:
            case GTE:
            case EQ:
            case NEQ:
            case SAME:
            case NSAME:
            case ADD:
            case SUB:
            case MUL:
            case MOD:
            case INC:
            case DEC:
            case SHL:
            case SHR:
            case SHU:
            case AND:
            case OR:
            case XOR:
            case NOT:
            case INV:
            case LAND:
            case LOR:
            case QUE:
            case COLON:
            case ASSIGN:
            case ADDASS:
            case SUBASS:
            case MULASS:
            case MODASS:
            case SHLASS:
            case SHRASS:
            case SHUASS:
            case ANDASS:
            case ORASS:
            case XORASS:
            case DIV:
            case DIVASS:
                {
                alt1=3;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt1=4;
                }
                break;
            case StringLiteral:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // JavaScript.g:512:4: reservedWord
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_reservedWord_in_token1756);
                    reservedWord1=reservedWord();

                    state._fsp--;

                    adaptor.addChild(root_0, reservedWord1.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:513:4: Identifier
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_token1761); 
                    Identifier2_tree = (MyAstNode)adaptor.create(Identifier2);
                    adaptor.addChild(root_0, Identifier2_tree);


                    }
                    break;
                case 3 :
                    // JavaScript.g:514:4: punctuator
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_punctuator_in_token1766);
                    punctuator3=punctuator();

                    state._fsp--;

                    adaptor.addChild(root_0, punctuator3.getTree());

                    }
                    break;
                case 4 :
                    // JavaScript.g:515:4: numericLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_token1771);
                    numericLiteral4=numericLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, numericLiteral4.getTree());

                    }
                    break;
                case 5 :
                    // JavaScript.g:516:4: StringLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    StringLiteral5=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_token1776); 
                    StringLiteral5_tree = (MyAstNode)adaptor.create(StringLiteral5);
                    adaptor.addChild(root_0, StringLiteral5_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "token"

    public static class reservedWord_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "reservedWord"
    // JavaScript.g:521:1: reservedWord : ( keyword | futureReservedWord | NULL | booleanLiteral );
    public final JavaScriptParser.reservedWord_return reservedWord() throws RecognitionException {
        JavaScriptParser.reservedWord_return retval = new JavaScriptParser.reservedWord_return();
        retval.start = input.LT(1);
        int reservedWord_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token NULL8=null;
        JavaScriptParser.keyword_return keyword6 = null;

        JavaScriptParser.futureReservedWord_return futureReservedWord7 = null;

        JavaScriptParser.booleanLiteral_return booleanLiteral9 = null;


        MyAstNode NULL8_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // JavaScript.g:522:2: ( keyword | futureReservedWord | NULL | booleanLiteral )
            int alt2=4;
            switch ( input.LA(1) ) {
            case BREAK:
            case CASE:
            case CATCH:
            case CONTINUE:
            case DEFAULT:
            case DELETE:
            case DO:
            case ELSE:
            case FINALLY:
            case FOR:
            case FUNCTION:
            case IF:
            case IN:
            case INSTANCEOF:
            case NEW:
            case RETURN:
            case SWITCH:
            case THIS:
            case THROW:
            case TRY:
            case TYPEOF:
            case VAR:
            case VOID:
            case WHILE:
            case WITH:
                {
                alt2=1;
                }
                break;
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case CONST:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
                {
                alt2=2;
                }
                break;
            case NULL:
                {
                alt2=3;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // JavaScript.g:522:4: keyword
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_keyword_in_reservedWord1789);
                    keyword6=keyword();

                    state._fsp--;

                    adaptor.addChild(root_0, keyword6.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:523:4: futureReservedWord
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_futureReservedWord_in_reservedWord1794);
                    futureReservedWord7=futureReservedWord();

                    state._fsp--;

                    adaptor.addChild(root_0, futureReservedWord7.getTree());

                    }
                    break;
                case 3 :
                    // JavaScript.g:524:4: NULL
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    NULL8=(Token)match(input,NULL,FOLLOW_NULL_in_reservedWord1799); 
                    NULL8_tree = (MyAstNode)adaptor.create(NULL8);
                    adaptor.addChild(root_0, NULL8_tree);


                    }
                    break;
                case 4 :
                    // JavaScript.g:525:4: booleanLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_booleanLiteral_in_reservedWord1804);
                    booleanLiteral9=booleanLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, booleanLiteral9.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "reservedWord"

    public static class keyword_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyword"
    // JavaScript.g:532:1: keyword : ( BREAK | CASE | CATCH | CONTINUE | DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | FUNCTION | IF | IN | INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF | VAR | VOID | WHILE | WITH );
    public final JavaScriptParser.keyword_return keyword() throws RecognitionException {
        JavaScriptParser.keyword_return retval = new JavaScriptParser.keyword_return();
        retval.start = input.LT(1);
        int keyword_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set10=null;

        MyAstNode set10_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // JavaScript.g:533:2: ( BREAK | CASE | CATCH | CONTINUE | DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | FUNCTION | IF | IN | INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF | VAR | VOID | WHILE | WITH )
            // JavaScript.g:
            {
            root_0 = (MyAstNode)adaptor.nil();

            set10=(Token)input.LT(1);
            if ( (input.LA(1)>=BREAK && input.LA(1)<=WITH) ) {
                input.consume();
                adaptor.addChild(root_0, (MyAstNode)adaptor.create(set10));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyword"

    public static class futureReservedWord_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "futureReservedWord"
    // JavaScript.g:564:1: futureReservedWord : ( ABSTRACT | BOOLEAN | BYTE | CHAR | CLASS | CONST | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL | FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE | PACKAGE | PRIVATE | PROTECTED | PUBLIC | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS | TRANSIENT | VOLATILE );
    public final JavaScriptParser.futureReservedWord_return futureReservedWord() throws RecognitionException {
        JavaScriptParser.futureReservedWord_return retval = new JavaScriptParser.futureReservedWord_return();
        retval.start = input.LT(1);
        int futureReservedWord_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set11=null;

        MyAstNode set11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // JavaScript.g:565:2: ( ABSTRACT | BOOLEAN | BYTE | CHAR | CLASS | CONST | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL | FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE | PACKAGE | PRIVATE | PROTECTED | PUBLIC | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS | TRANSIENT | VOLATILE )
            // JavaScript.g:
            {
            root_0 = (MyAstNode)adaptor.nil();

            set11=(Token)input.LT(1);
            if ( (input.LA(1)>=ABSTRACT && input.LA(1)<=VOLATILE) ) {
                input.consume();
                adaptor.addChild(root_0, (MyAstNode)adaptor.create(set11));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "futureReservedWord"

    public static class punctuator_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "punctuator"
    // JavaScript.g:642:1: punctuator : ( LBRACE | RBRACE | LPAREN | RPAREN | LBRACK | RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND | OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS | SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS | XORASS | DIV | DIVASS );
    public final JavaScriptParser.punctuator_return punctuator() throws RecognitionException {
        JavaScriptParser.punctuator_return retval = new JavaScriptParser.punctuator_return();
        retval.start = input.LT(1);
        int punctuator_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set12=null;

        MyAstNode set12_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // JavaScript.g:643:2: ( LBRACE | RBRACE | LPAREN | RPAREN | LBRACK | RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND | OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS | SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS | XORASS | DIV | DIVASS )
            // JavaScript.g:
            {
            root_0 = (MyAstNode)adaptor.nil();

            set12=(Token)input.LT(1);
            if ( (input.LA(1)>=LBRACE && input.LA(1)<=DIVASS) ) {
                input.consume();
                adaptor.addChild(root_0, (MyAstNode)adaptor.create(set12));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "punctuator"

    public static class literal_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // JavaScript.g:697:1: literal : ( NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral );
    public final JavaScriptParser.literal_return literal() throws RecognitionException {
        JavaScriptParser.literal_return retval = new JavaScriptParser.literal_return();
        retval.start = input.LT(1);
        int literal_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token NULL13=null;
        Token StringLiteral16=null;
        Token RegularExpressionLiteral17=null;
        JavaScriptParser.booleanLiteral_return booleanLiteral14 = null;

        JavaScriptParser.numericLiteral_return numericLiteral15 = null;


        MyAstNode NULL13_tree=null;
        MyAstNode StringLiteral16_tree=null;
        MyAstNode RegularExpressionLiteral17_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // JavaScript.g:698:2: ( NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral )
            int alt3=5;
            switch ( input.LA(1) ) {
            case NULL:
                {
                alt3=1;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt3=2;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt3=3;
                }
                break;
            case StringLiteral:
                {
                alt3=4;
                }
                break;
            case RegularExpressionLiteral:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // JavaScript.g:698:4: NULL
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    NULL13=(Token)match(input,NULL,FOLLOW_NULL_in_literal2485); 
                    NULL13_tree = (MyAstNode)adaptor.create(NULL13);
                    adaptor.addChild(root_0, NULL13_tree);


                    }
                    break;
                case 2 :
                    // JavaScript.g:699:4: booleanLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_booleanLiteral_in_literal2490);
                    booleanLiteral14=booleanLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, booleanLiteral14.getTree());

                    }
                    break;
                case 3 :
                    // JavaScript.g:700:4: numericLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_literal2495);
                    numericLiteral15=numericLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, numericLiteral15.getTree());

                    }
                    break;
                case 4 :
                    // JavaScript.g:701:4: StringLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    StringLiteral16=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_literal2500); 
                    StringLiteral16_tree = (MyAstNode)adaptor.create(StringLiteral16);
                    adaptor.addChild(root_0, StringLiteral16_tree);


                    }
                    break;
                case 5 :
                    // JavaScript.g:702:4: RegularExpressionLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    RegularExpressionLiteral17=(Token)match(input,RegularExpressionLiteral,FOLLOW_RegularExpressionLiteral_in_literal2505); 
                    RegularExpressionLiteral17_tree = (MyAstNode)adaptor.create(RegularExpressionLiteral17);
                    adaptor.addChild(root_0, RegularExpressionLiteral17_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    public static class booleanLiteral_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booleanLiteral"
    // JavaScript.g:705:1: booleanLiteral : ( TRUE | FALSE );
    public final JavaScriptParser.booleanLiteral_return booleanLiteral() throws RecognitionException {
        JavaScriptParser.booleanLiteral_return retval = new JavaScriptParser.booleanLiteral_return();
        retval.start = input.LT(1);
        int booleanLiteral_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set18=null;

        MyAstNode set18_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // JavaScript.g:706:2: ( TRUE | FALSE )
            // JavaScript.g:
            {
            root_0 = (MyAstNode)adaptor.nil();

            set18=(Token)input.LT(1);
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                adaptor.addChild(root_0, (MyAstNode)adaptor.create(set18));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "booleanLiteral"

    public static class numericLiteral_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numericLiteral"
    // JavaScript.g:752:1: numericLiteral : ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral );
    public final JavaScriptParser.numericLiteral_return numericLiteral() throws RecognitionException {
        JavaScriptParser.numericLiteral_return retval = new JavaScriptParser.numericLiteral_return();
        retval.start = input.LT(1);
        int numericLiteral_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set19=null;

        MyAstNode set19_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // JavaScript.g:753:2: ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral )
            // JavaScript.g:
            {
            root_0 = (MyAstNode)adaptor.nil();

            set19=(Token)input.LT(1);
            if ( (input.LA(1)>=DecimalLiteral && input.LA(1)<=HexIntegerLiteral) ) {
                input.consume();
                adaptor.addChild(root_0, (MyAstNode)adaptor.create(set19));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "numericLiteral"

    public static class primaryExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primaryExpression"
    // JavaScript.g:840:1: primaryExpression : ( THIS | Identifier | literal | arrayLiteral | objectLiteral | lpar= LPAREN expression RPAREN -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression ) );
    public final JavaScriptParser.primaryExpression_return primaryExpression() throws RecognitionException {
        JavaScriptParser.primaryExpression_return retval = new JavaScriptParser.primaryExpression_return();
        retval.start = input.LT(1);
        int primaryExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token lpar=null;
        Token THIS20=null;
        Token Identifier21=null;
        Token RPAREN26=null;
        JavaScriptParser.literal_return literal22 = null;

        JavaScriptParser.arrayLiteral_return arrayLiteral23 = null;

        JavaScriptParser.objectLiteral_return objectLiteral24 = null;

        JavaScriptParser.expression_return expression25 = null;


        MyAstNode lpar_tree=null;
        MyAstNode THIS20_tree=null;
        MyAstNode Identifier21_tree=null;
        MyAstNode RPAREN26_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // JavaScript.g:841:2: ( THIS | Identifier | literal | arrayLiteral | objectLiteral | lpar= LPAREN expression RPAREN -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case THIS:
                {
                alt4=1;
                }
                break;
            case Identifier:
                {
                alt4=2;
                }
                break;
            case NULL:
            case TRUE:
            case FALSE:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt4=3;
                }
                break;
            case LBRACK:
                {
                alt4=4;
                }
                break;
            case LBRACE:
                {
                alt4=5;
                }
                break;
            case LPAREN:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // JavaScript.g:841:4: THIS
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    THIS20=(Token)match(input,THIS,FOLLOW_THIS_in_primaryExpression3118); 
                    THIS20_tree = (MyAstNode)adaptor.create(THIS20);
                    adaptor.addChild(root_0, THIS20_tree);


                    }
                    break;
                case 2 :
                    // JavaScript.g:842:4: Identifier
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    Identifier21=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryExpression3123); 
                    Identifier21_tree = (MyAstNode)adaptor.create(Identifier21);
                    adaptor.addChild(root_0, Identifier21_tree);


                    }
                    break;
                case 3 :
                    // JavaScript.g:843:4: literal
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primaryExpression3128);
                    literal22=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, literal22.getTree());

                    }
                    break;
                case 4 :
                    // JavaScript.g:844:4: arrayLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_arrayLiteral_in_primaryExpression3133);
                    arrayLiteral23=arrayLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayLiteral23.getTree());

                    }
                    break;
                case 5 :
                    // JavaScript.g:845:4: objectLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_objectLiteral_in_primaryExpression3138);
                    objectLiteral24=objectLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, objectLiteral24.getTree());

                    }
                    break;
                case 6 :
                    // JavaScript.g:846:4: lpar= LPAREN expression RPAREN
                    {
                    lpar=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression3145);  
                    stream_LPAREN.add(lpar);

                    pushFollow(FOLLOW_expression_in_primaryExpression3147);
                    expression25=expression();

                    state._fsp--;

                    stream_expression.add(expression25.getTree());
                    RPAREN26=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression3149);  
                    stream_RPAREN.add(RPAREN26);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (MyAstNode)adaptor.nil();
                    // 846:34: -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression )
                    {
                        // JavaScript.g:846:37: ^( PAREXPR[$lpar, \"PAREXPR\"] expression )
                        {
                        MyAstNode root_1 = (MyAstNode)adaptor.nil();
                        root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(PAREXPR, lpar, "PAREXPR"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primaryExpression"

    public static class arrayLiteral_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayLiteral"
    // JavaScript.g:849:1: arrayLiteral : lb= LBRACK ( arrayItem ( COMMA arrayItem )* )? RBRACK -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* ) ;
    public final JavaScriptParser.arrayLiteral_return arrayLiteral() throws RecognitionException {
        JavaScriptParser.arrayLiteral_return retval = new JavaScriptParser.arrayLiteral_return();
        retval.start = input.LT(1);
        int arrayLiteral_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token lb=null;
        Token COMMA28=null;
        Token RBRACK30=null;
        JavaScriptParser.arrayItem_return arrayItem27 = null;

        JavaScriptParser.arrayItem_return arrayItem29 = null;


        MyAstNode lb_tree=null;
        MyAstNode COMMA28_tree=null;
        MyAstNode RBRACK30_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleSubtreeStream stream_arrayItem=new RewriteRuleSubtreeStream(adaptor,"rule arrayItem");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // JavaScript.g:850:2: (lb= LBRACK ( arrayItem ( COMMA arrayItem )* )? RBRACK -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* ) )
            // JavaScript.g:850:4: lb= LBRACK ( arrayItem ( COMMA arrayItem )* )? RBRACK
            {
            lb=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayLiteral3173);  
            stream_LBRACK.add(lb);

            // JavaScript.g:850:14: ( arrayItem ( COMMA arrayItem )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=NULL && LA6_0<=FALSE)||LA6_0==DELETE||LA6_0==FUNCTION||LA6_0==NEW||LA6_0==THIS||LA6_0==TYPEOF||LA6_0==VOID||LA6_0==LBRACE||LA6_0==LPAREN||LA6_0==LBRACK||LA6_0==COMMA||(LA6_0>=ADD && LA6_0<=SUB)||(LA6_0>=INC && LA6_0<=DEC)||(LA6_0>=NOT && LA6_0<=INV)||(LA6_0>=Identifier && LA6_0<=StringLiteral)||LA6_0==RegularExpressionLiteral||(LA6_0>=DecimalLiteral && LA6_0<=HexIntegerLiteral)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RBRACK) ) {
                int LA6_2 = input.LA(2);

                if ( (( input.LA(1) == COMMA )) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // JavaScript.g:850:16: arrayItem ( COMMA arrayItem )*
                    {
                    pushFollow(FOLLOW_arrayItem_in_arrayLiteral3177);
                    arrayItem27=arrayItem();

                    state._fsp--;

                    stream_arrayItem.add(arrayItem27.getTree());
                    // JavaScript.g:850:26: ( COMMA arrayItem )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==COMMA) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // JavaScript.g:850:28: COMMA arrayItem
                    	    {
                    	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayLiteral3181);  
                    	    stream_COMMA.add(COMMA28);

                    	    pushFollow(FOLLOW_arrayItem_in_arrayLiteral3183);
                    	    arrayItem29=arrayItem();

                    	    state._fsp--;

                    	    stream_arrayItem.add(arrayItem29.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACK30=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayLiteral3191);  
            stream_RBRACK.add(RBRACK30);



            // AST REWRITE
            // elements: arrayItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 851:2: -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* )
            {
                // JavaScript.g:851:5: ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(ARRAY, lb, "ARRAY"), root_1);

                // JavaScript.g:851:28: ( arrayItem )*
                while ( stream_arrayItem.hasNext() ) {
                    adaptor.addChild(root_1, stream_arrayItem.nextTree());

                }
                stream_arrayItem.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayLiteral"

    public static class arrayItem_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayItem"
    // JavaScript.g:854:1: arrayItem : (expr= assignmentExpression | {...}?) -> ^( ITEM ( $expr)? ) ;
    public final JavaScriptParser.arrayItem_return arrayItem() throws RecognitionException {
        JavaScriptParser.arrayItem_return retval = new JavaScriptParser.arrayItem_return();
        retval.start = input.LT(1);
        int arrayItem_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.assignmentExpression_return expr = null;


        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // JavaScript.g:855:2: ( (expr= assignmentExpression | {...}?) -> ^( ITEM ( $expr)? ) )
            // JavaScript.g:855:4: (expr= assignmentExpression | {...}?)
            {
            // JavaScript.g:855:4: (expr= assignmentExpression | {...}?)
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=NULL && LA7_0<=FALSE)||LA7_0==DELETE||LA7_0==FUNCTION||LA7_0==NEW||LA7_0==THIS||LA7_0==TYPEOF||LA7_0==VOID||LA7_0==LBRACE||LA7_0==LPAREN||LA7_0==LBRACK||(LA7_0>=ADD && LA7_0<=SUB)||(LA7_0>=INC && LA7_0<=DEC)||(LA7_0>=NOT && LA7_0<=INV)||(LA7_0>=Identifier && LA7_0<=StringLiteral)||LA7_0==RegularExpressionLiteral||(LA7_0>=DecimalLiteral && LA7_0<=HexIntegerLiteral)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RBRACK||LA7_0==COMMA) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // JavaScript.g:855:6: expr= assignmentExpression
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_arrayItem3219);
                    expr=assignmentExpression();

                    state._fsp--;

                    stream_assignmentExpression.add(expr.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:855:34: {...}?
                    {
                    if ( !(( input.LA(1) == COMMA )) ) {
                        throw new FailedPredicateException(input, "arrayItem", " input.LA(1) == COMMA ");
                    }

                    }
                    break;

            }



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: expr, retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"token expr",expr!=null?expr.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 856:2: -> ^( ITEM ( $expr)? )
            {
                // JavaScript.g:856:5: ^( ITEM ( $expr)? )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(ITEM, "ITEM"), root_1);

                // JavaScript.g:856:13: ( $expr)?
                if ( stream_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayItem"

    public static class objectLiteral_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectLiteral"
    // JavaScript.g:859:1: objectLiteral : lb= LBRACE ( nameValuePair ( COMMA nameValuePair )* )? RBRACE -> ^( OBJECT[$lb, \"OBJECT\"] ( nameValuePair )* ) ;
    public final JavaScriptParser.objectLiteral_return objectLiteral() throws RecognitionException {
        JavaScriptParser.objectLiteral_return retval = new JavaScriptParser.objectLiteral_return();
        retval.start = input.LT(1);
        int objectLiteral_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token lb=null;
        Token COMMA32=null;
        Token RBRACE34=null;
        JavaScriptParser.nameValuePair_return nameValuePair31 = null;

        JavaScriptParser.nameValuePair_return nameValuePair33 = null;


        MyAstNode lb_tree=null;
        MyAstNode COMMA32_tree=null;
        MyAstNode RBRACE34_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_nameValuePair=new RewriteRuleSubtreeStream(adaptor,"rule nameValuePair");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // JavaScript.g:860:2: (lb= LBRACE ( nameValuePair ( COMMA nameValuePair )* )? RBRACE -> ^( OBJECT[$lb, \"OBJECT\"] ( nameValuePair )* ) )
            // JavaScript.g:860:4: lb= LBRACE ( nameValuePair ( COMMA nameValuePair )* )? RBRACE
            {
            lb=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_objectLiteral3251);  
            stream_LBRACE.add(lb);

            // JavaScript.g:860:14: ( nameValuePair ( COMMA nameValuePair )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=Identifier && LA9_0<=StringLiteral)||(LA9_0>=DecimalLiteral && LA9_0<=HexIntegerLiteral)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // JavaScript.g:860:16: nameValuePair ( COMMA nameValuePair )*
                    {
                    pushFollow(FOLLOW_nameValuePair_in_objectLiteral3255);
                    nameValuePair31=nameValuePair();

                    state._fsp--;

                    stream_nameValuePair.add(nameValuePair31.getTree());
                    // JavaScript.g:860:30: ( COMMA nameValuePair )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // JavaScript.g:860:32: COMMA nameValuePair
                    	    {
                    	    COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_objectLiteral3259);  
                    	    stream_COMMA.add(COMMA32);

                    	    pushFollow(FOLLOW_nameValuePair_in_objectLiteral3261);
                    	    nameValuePair33=nameValuePair();

                    	    state._fsp--;

                    	    stream_nameValuePair.add(nameValuePair33.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACE34=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_objectLiteral3269);  
            stream_RBRACE.add(RBRACE34);



            // AST REWRITE
            // elements: nameValuePair
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 861:2: -> ^( OBJECT[$lb, \"OBJECT\"] ( nameValuePair )* )
            {
                // JavaScript.g:861:5: ^( OBJECT[$lb, \"OBJECT\"] ( nameValuePair )* )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(OBJECT, lb, "OBJECT"), root_1);

                // JavaScript.g:861:30: ( nameValuePair )*
                while ( stream_nameValuePair.hasNext() ) {
                    adaptor.addChild(root_1, stream_nameValuePair.nextTree());

                }
                stream_nameValuePair.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "objectLiteral"

    public static class nameValuePair_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nameValuePair"
    // JavaScript.g:864:1: nameValuePair : propertyName COLON assignmentExpression -> ^( NAMEDVALUE propertyName assignmentExpression ) ;
    public final JavaScriptParser.nameValuePair_return nameValuePair() throws RecognitionException {
        JavaScriptParser.nameValuePair_return retval = new JavaScriptParser.nameValuePair_return();
        retval.start = input.LT(1);
        int nameValuePair_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token COLON36=null;
        JavaScriptParser.propertyName_return propertyName35 = null;

        JavaScriptParser.assignmentExpression_return assignmentExpression37 = null;


        MyAstNode COLON36_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_propertyName=new RewriteRuleSubtreeStream(adaptor,"rule propertyName");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // JavaScript.g:865:2: ( propertyName COLON assignmentExpression -> ^( NAMEDVALUE propertyName assignmentExpression ) )
            // JavaScript.g:865:4: propertyName COLON assignmentExpression
            {
            pushFollow(FOLLOW_propertyName_in_nameValuePair3294);
            propertyName35=propertyName();

            state._fsp--;

            stream_propertyName.add(propertyName35.getTree());
            COLON36=(Token)match(input,COLON,FOLLOW_COLON_in_nameValuePair3296);  
            stream_COLON.add(COLON36);

            pushFollow(FOLLOW_assignmentExpression_in_nameValuePair3298);
            assignmentExpression37=assignmentExpression();

            state._fsp--;

            stream_assignmentExpression.add(assignmentExpression37.getTree());


            // AST REWRITE
            // elements: assignmentExpression, propertyName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 866:2: -> ^( NAMEDVALUE propertyName assignmentExpression )
            {
                // JavaScript.g:866:5: ^( NAMEDVALUE propertyName assignmentExpression )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(NAMEDVALUE, "NAMEDVALUE"), root_1);

                adaptor.addChild(root_1, stream_propertyName.nextTree());
                adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nameValuePair"

    public static class propertyName_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyName"
    // JavaScript.g:869:1: propertyName : ( Identifier | StringLiteral | numericLiteral );
    public final JavaScriptParser.propertyName_return propertyName() throws RecognitionException {
        JavaScriptParser.propertyName_return retval = new JavaScriptParser.propertyName_return();
        retval.start = input.LT(1);
        int propertyName_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token Identifier38=null;
        Token StringLiteral39=null;
        JavaScriptParser.numericLiteral_return numericLiteral40 = null;


        MyAstNode Identifier38_tree=null;
        MyAstNode StringLiteral39_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // JavaScript.g:870:2: ( Identifier | StringLiteral | numericLiteral )
            int alt10=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt10=1;
                }
                break;
            case StringLiteral:
                {
                alt10=2;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // JavaScript.g:870:4: Identifier
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    Identifier38=(Token)match(input,Identifier,FOLLOW_Identifier_in_propertyName3322); 
                    Identifier38_tree = (MyAstNode)adaptor.create(Identifier38);
                    adaptor.addChild(root_0, Identifier38_tree);


                    }
                    break;
                case 2 :
                    // JavaScript.g:871:4: StringLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    StringLiteral39=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_propertyName3327); 
                    StringLiteral39_tree = (MyAstNode)adaptor.create(StringLiteral39);
                    adaptor.addChild(root_0, StringLiteral39_tree);


                    }
                    break;
                case 3 :
                    // JavaScript.g:872:4: numericLiteral
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_propertyName3332);
                    numericLiteral40=numericLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, numericLiteral40.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "propertyName"

    public static class memberExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "memberExpression"
    // JavaScript.g:884:1: memberExpression : ( primaryExpression | functionExpression | newExpression );
    public final JavaScriptParser.memberExpression_return memberExpression() throws RecognitionException {
        JavaScriptParser.memberExpression_return retval = new JavaScriptParser.memberExpression_return();
        retval.start = input.LT(1);
        int memberExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.primaryExpression_return primaryExpression41 = null;

        JavaScriptParser.functionExpression_return functionExpression42 = null;

        JavaScriptParser.newExpression_return newExpression43 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // JavaScript.g:885:2: ( primaryExpression | functionExpression | newExpression )
            int alt11=3;
            switch ( input.LA(1) ) {
            case NULL:
            case TRUE:
            case FALSE:
            case THIS:
            case LBRACE:
            case LPAREN:
            case LBRACK:
            case Identifier:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt11=1;
                }
                break;
            case FUNCTION:
                {
                alt11=2;
                }
                break;
            case NEW:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // JavaScript.g:885:4: primaryExpression
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_primaryExpression_in_memberExpression3350);
                    primaryExpression41=primaryExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, primaryExpression41.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:886:4: functionExpression
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_functionExpression_in_memberExpression3355);
                    functionExpression42=functionExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, functionExpression42.getTree());

                    }
                    break;
                case 3 :
                    // JavaScript.g:887:4: newExpression
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_memberExpression3360);
                    newExpression43=newExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, newExpression43.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "memberExpression"

    public static class newExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newExpression"
    // JavaScript.g:890:1: newExpression : ( NEW primaryExpression | NEW functionExpression );
    public final JavaScriptParser.newExpression_return newExpression() throws RecognitionException {
        JavaScriptParser.newExpression_return retval = new JavaScriptParser.newExpression_return();
        retval.start = input.LT(1);
        int newExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token NEW44=null;
        Token NEW46=null;
        JavaScriptParser.primaryExpression_return primaryExpression45 = null;

        JavaScriptParser.functionExpression_return functionExpression47 = null;


        MyAstNode NEW44_tree=null;
        MyAstNode NEW46_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // JavaScript.g:891:2: ( NEW primaryExpression | NEW functionExpression )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NEW) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==FUNCTION) ) {
                    alt12=2;
                }
                else if ( ((LA12_1>=NULL && LA12_1<=FALSE)||LA12_1==THIS||LA12_1==LBRACE||LA12_1==LPAREN||LA12_1==LBRACK||(LA12_1>=Identifier && LA12_1<=StringLiteral)||LA12_1==RegularExpressionLiteral||(LA12_1>=DecimalLiteral && LA12_1<=HexIntegerLiteral)) ) {
                    alt12=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // JavaScript.g:891:4: NEW primaryExpression
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    NEW44=(Token)match(input,NEW,FOLLOW_NEW_in_newExpression3371); 
                    NEW44_tree = (MyAstNode)adaptor.create(NEW44);
                    root_0 = (MyAstNode)adaptor.becomeRoot(NEW44_tree, root_0);

                    pushFollow(FOLLOW_primaryExpression_in_newExpression3374);
                    primaryExpression45=primaryExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, primaryExpression45.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:892:7: NEW functionExpression
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    NEW46=(Token)match(input,NEW,FOLLOW_NEW_in_newExpression3382); 
                    NEW46_tree = (MyAstNode)adaptor.create(NEW46);
                    root_0 = (MyAstNode)adaptor.becomeRoot(NEW46_tree, root_0);

                    pushFollow(FOLLOW_functionExpression_in_newExpression3385);
                    functionExpression47=functionExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, functionExpression47.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "newExpression"

    public static class arguments_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // JavaScript.g:896:1: arguments : LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN -> ^( ARGS ( assignmentExpression )* ) ;
    public final JavaScriptParser.arguments_return arguments() throws RecognitionException {
        JavaScriptParser.arguments_return retval = new JavaScriptParser.arguments_return();
        retval.start = input.LT(1);
        int arguments_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token LPAREN48=null;
        Token COMMA50=null;
        Token RPAREN52=null;
        JavaScriptParser.assignmentExpression_return assignmentExpression49 = null;

        JavaScriptParser.assignmentExpression_return assignmentExpression51 = null;


        MyAstNode LPAREN48_tree=null;
        MyAstNode COMMA50_tree=null;
        MyAstNode RPAREN52_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // JavaScript.g:897:2: ( LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN -> ^( ARGS ( assignmentExpression )* ) )
            // JavaScript.g:897:4: LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN
            {
            LPAREN48=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_arguments3398);  
            stream_LPAREN.add(LPAREN48);

            // JavaScript.g:897:11: ( assignmentExpression ( COMMA assignmentExpression )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=NULL && LA14_0<=FALSE)||LA14_0==DELETE||LA14_0==FUNCTION||LA14_0==NEW||LA14_0==THIS||LA14_0==TYPEOF||LA14_0==VOID||LA14_0==LBRACE||LA14_0==LPAREN||LA14_0==LBRACK||(LA14_0>=ADD && LA14_0<=SUB)||(LA14_0>=INC && LA14_0<=DEC)||(LA14_0>=NOT && LA14_0<=INV)||(LA14_0>=Identifier && LA14_0<=StringLiteral)||LA14_0==RegularExpressionLiteral||(LA14_0>=DecimalLiteral && LA14_0<=HexIntegerLiteral)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // JavaScript.g:897:13: assignmentExpression ( COMMA assignmentExpression )*
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_arguments3402);
                    assignmentExpression49=assignmentExpression();

                    state._fsp--;

                    stream_assignmentExpression.add(assignmentExpression49.getTree());
                    // JavaScript.g:897:34: ( COMMA assignmentExpression )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // JavaScript.g:897:36: COMMA assignmentExpression
                    	    {
                    	    COMMA50=(Token)match(input,COMMA,FOLLOW_COMMA_in_arguments3406);  
                    	    stream_COMMA.add(COMMA50);

                    	    pushFollow(FOLLOW_assignmentExpression_in_arguments3408);
                    	    assignmentExpression51=assignmentExpression();

                    	    state._fsp--;

                    	    stream_assignmentExpression.add(assignmentExpression51.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAREN52=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_arguments3416);  
            stream_RPAREN.add(RPAREN52);



            // AST REWRITE
            // elements: assignmentExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 898:2: -> ^( ARGS ( assignmentExpression )* )
            {
                // JavaScript.g:898:5: ^( ARGS ( assignmentExpression )* )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(ARGS, "ARGS"), root_1);

                // JavaScript.g:898:13: ( assignmentExpression )*
                while ( stream_assignmentExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                }
                stream_assignmentExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arguments"

    public static class leftHandSideExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "leftHandSideExpression"
    // JavaScript.g:901:1: leftHandSideExpression : ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | LBRACK expression RBRACK -> ^( BYINDEX $leftHandSideExpression expression ) | DOT Identifier -> ^( BYFIELD $leftHandSideExpression Identifier ) )* ;
    public final JavaScriptParser.leftHandSideExpression_return leftHandSideExpression() throws RecognitionException {
        JavaScriptParser.leftHandSideExpression_return retval = new JavaScriptParser.leftHandSideExpression_return();
        retval.start = input.LT(1);
        int leftHandSideExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token LBRACK55=null;
        Token RBRACK57=null;
        Token DOT58=null;
        Token Identifier59=null;
        JavaScriptParser.memberExpression_return memberExpression53 = null;

        JavaScriptParser.arguments_return arguments54 = null;

        JavaScriptParser.expression_return expression56 = null;


        MyAstNode LBRACK55_tree=null;
        MyAstNode RBRACK57_tree=null;
        MyAstNode DOT58_tree=null;
        MyAstNode Identifier59_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_memberExpression=new RewriteRuleSubtreeStream(adaptor,"rule memberExpression");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // JavaScript.g:902:2: ( ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | LBRACK expression RBRACK -> ^( BYINDEX $leftHandSideExpression expression ) | DOT Identifier -> ^( BYFIELD $leftHandSideExpression Identifier ) )* )
            // JavaScript.g:903:2: ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | LBRACK expression RBRACK -> ^( BYINDEX $leftHandSideExpression expression ) | DOT Identifier -> ^( BYFIELD $leftHandSideExpression Identifier ) )*
            {
            // JavaScript.g:903:2: ( memberExpression -> memberExpression )
            // JavaScript.g:904:3: memberExpression
            {
            pushFollow(FOLLOW_memberExpression_in_leftHandSideExpression3445);
            memberExpression53=memberExpression();

            state._fsp--;

            stream_memberExpression.add(memberExpression53.getTree());


            // AST REWRITE
            // elements: memberExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 904:22: -> memberExpression
            {
                adaptor.addChild(root_0, stream_memberExpression.nextTree());

            }

            retval.tree = root_0;
            }

            // JavaScript.g:906:2: ( arguments -> ^( CALL $leftHandSideExpression arguments ) | LBRACK expression RBRACK -> ^( BYINDEX $leftHandSideExpression expression ) | DOT Identifier -> ^( BYFIELD $leftHandSideExpression Identifier ) )*
            loop15:
            do {
                int alt15=4;
                switch ( input.LA(1) ) {
                case LPAREN:
                    {
                    alt15=1;
                    }
                    break;
                case LBRACK:
                    {
                    alt15=2;
                    }
                    break;
                case DOT:
                    {
                    alt15=3;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // JavaScript.g:907:3: arguments
            	    {
            	    pushFollow(FOLLOW_arguments_in_leftHandSideExpression3461);
            	    arguments54=arguments();

            	    state._fsp--;

            	    stream_arguments.add(arguments54.getTree());


            	    // AST REWRITE
            	    // elements: arguments, leftHandSideExpression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (MyAstNode)adaptor.nil();
            	    // 907:15: -> ^( CALL $leftHandSideExpression arguments )
            	    {
            	        // JavaScript.g:907:18: ^( CALL $leftHandSideExpression arguments )
            	        {
            	        MyAstNode root_1 = (MyAstNode)adaptor.nil();
            	        root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(CALL, "CALL"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_arguments.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;
            	case 2 :
            	    // JavaScript.g:908:5: LBRACK expression RBRACK
            	    {
            	    LBRACK55=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_leftHandSideExpression3482);  
            	    stream_LBRACK.add(LBRACK55);

            	    pushFollow(FOLLOW_expression_in_leftHandSideExpression3484);
            	    expression56=expression();

            	    state._fsp--;

            	    stream_expression.add(expression56.getTree());
            	    RBRACK57=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_leftHandSideExpression3486);  
            	    stream_RBRACK.add(RBRACK57);



            	    // AST REWRITE
            	    // elements: expression, leftHandSideExpression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (MyAstNode)adaptor.nil();
            	    // 908:30: -> ^( BYINDEX $leftHandSideExpression expression )
            	    {
            	        // JavaScript.g:908:33: ^( BYINDEX $leftHandSideExpression expression )
            	        {
            	        MyAstNode root_1 = (MyAstNode)adaptor.nil();
            	        root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(BYINDEX, "BYINDEX"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_expression.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;
            	case 3 :
            	    // JavaScript.g:909:5: DOT Identifier
            	    {
            	    DOT58=(Token)match(input,DOT,FOLLOW_DOT_in_leftHandSideExpression3505);  
            	    stream_DOT.add(DOT58);

            	    Identifier59=(Token)match(input,Identifier,FOLLOW_Identifier_in_leftHandSideExpression3507);  
            	    stream_Identifier.add(Identifier59);



            	    // AST REWRITE
            	    // elements: Identifier, leftHandSideExpression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (MyAstNode)adaptor.nil();
            	    // 909:21: -> ^( BYFIELD $leftHandSideExpression Identifier )
            	    {
            	        // JavaScript.g:909:24: ^( BYFIELD $leftHandSideExpression Identifier )
            	        {
            	        MyAstNode root_1 = (MyAstNode)adaptor.nil();
            	        root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(BYFIELD, "BYFIELD"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_Identifier.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "leftHandSideExpression"

    public static class postfixExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfixExpression"
    // JavaScript.g:923:1: postfixExpression : leftHandSideExpression ( postfixOperator )? ;
    public final JavaScriptParser.postfixExpression_return postfixExpression() throws RecognitionException {
        JavaScriptParser.postfixExpression_return retval = new JavaScriptParser.postfixExpression_return();
        retval.start = input.LT(1);
        int postfixExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.leftHandSideExpression_return leftHandSideExpression60 = null;

        JavaScriptParser.postfixOperator_return postfixOperator61 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // JavaScript.g:924:2: ( leftHandSideExpression ( postfixOperator )? )
            // JavaScript.g:924:4: leftHandSideExpression ( postfixOperator )?
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_leftHandSideExpression_in_postfixExpression3542);
            leftHandSideExpression60=leftHandSideExpression();

            state._fsp--;

            adaptor.addChild(root_0, leftHandSideExpression60.getTree());
             if (input.LA(1) == INC || input.LA(1) == DEC) promoteEOL(null); 
            // JavaScript.g:924:95: ( postfixOperator )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=INC && LA16_0<=DEC)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // JavaScript.g:924:97: postfixOperator
                    {
                    pushFollow(FOLLOW_postfixOperator_in_postfixExpression3548);
                    postfixOperator61=postfixOperator();

                    state._fsp--;

                    root_0 = (MyAstNode)adaptor.becomeRoot(postfixOperator61.getTree(), root_0);

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "postfixExpression"

    public static class postfixOperator_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfixOperator"
    // JavaScript.g:927:1: postfixOperator : (op= INC | op= DEC );
    public final JavaScriptParser.postfixOperator_return postfixOperator() throws RecognitionException {
        JavaScriptParser.postfixOperator_return retval = new JavaScriptParser.postfixOperator_return();
        retval.start = input.LT(1);
        int postfixOperator_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token op=null;

        MyAstNode op_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // JavaScript.g:928:2: (op= INC | op= DEC )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==INC) ) {
                alt17=1;
            }
            else if ( (LA17_0==DEC) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // JavaScript.g:928:4: op= INC
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    op=(Token)match(input,INC,FOLLOW_INC_in_postfixOperator3566); 
                    op_tree = (MyAstNode)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(PINC); 

                    }
                    break;
                case 2 :
                    // JavaScript.g:929:4: op= DEC
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    op=(Token)match(input,DEC,FOLLOW_DEC_in_postfixOperator3575); 
                    op_tree = (MyAstNode)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(PDEC); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "postfixOperator"

    public static class unaryExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpression"
    // JavaScript.g:936:1: unaryExpression : ( postfixExpression | unaryOperator unaryExpression );
    public final JavaScriptParser.unaryExpression_return unaryExpression() throws RecognitionException {
        JavaScriptParser.unaryExpression_return retval = new JavaScriptParser.unaryExpression_return();
        retval.start = input.LT(1);
        int unaryExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.postfixExpression_return postfixExpression62 = null;

        JavaScriptParser.unaryOperator_return unaryOperator63 = null;

        JavaScriptParser.unaryExpression_return unaryExpression64 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // JavaScript.g:937:2: ( postfixExpression | unaryOperator unaryExpression )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=NULL && LA18_0<=FALSE)||LA18_0==FUNCTION||LA18_0==NEW||LA18_0==THIS||LA18_0==LBRACE||LA18_0==LPAREN||LA18_0==LBRACK||(LA18_0>=Identifier && LA18_0<=StringLiteral)||LA18_0==RegularExpressionLiteral||(LA18_0>=DecimalLiteral && LA18_0<=HexIntegerLiteral)) ) {
                alt18=1;
            }
            else if ( (LA18_0==DELETE||LA18_0==TYPEOF||LA18_0==VOID||(LA18_0>=ADD && LA18_0<=SUB)||(LA18_0>=INC && LA18_0<=DEC)||(LA18_0>=NOT && LA18_0<=INV)) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // JavaScript.g:937:4: postfixExpression
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_postfixExpression_in_unaryExpression3592);
                    postfixExpression62=postfixExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, postfixExpression62.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:938:4: unaryOperator unaryExpression
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_unaryOperator_in_unaryExpression3597);
                    unaryOperator63=unaryOperator();

                    state._fsp--;

                    root_0 = (MyAstNode)adaptor.becomeRoot(unaryOperator63.getTree(), root_0);
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression3600);
                    unaryExpression64=unaryExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, unaryExpression64.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryExpression"

    public static class unaryOperator_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryOperator"
    // JavaScript.g:941:1: unaryOperator : ( DELETE | VOID | TYPEOF | INC | DEC | op= ADD | op= SUB | INV | NOT );
    public final JavaScriptParser.unaryOperator_return unaryOperator() throws RecognitionException {
        JavaScriptParser.unaryOperator_return retval = new JavaScriptParser.unaryOperator_return();
        retval.start = input.LT(1);
        int unaryOperator_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token op=null;
        Token DELETE65=null;
        Token VOID66=null;
        Token TYPEOF67=null;
        Token INC68=null;
        Token DEC69=null;
        Token INV70=null;
        Token NOT71=null;

        MyAstNode op_tree=null;
        MyAstNode DELETE65_tree=null;
        MyAstNode VOID66_tree=null;
        MyAstNode TYPEOF67_tree=null;
        MyAstNode INC68_tree=null;
        MyAstNode DEC69_tree=null;
        MyAstNode INV70_tree=null;
        MyAstNode NOT71_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // JavaScript.g:942:2: ( DELETE | VOID | TYPEOF | INC | DEC | op= ADD | op= SUB | INV | NOT )
            int alt19=9;
            switch ( input.LA(1) ) {
            case DELETE:
                {
                alt19=1;
                }
                break;
            case VOID:
                {
                alt19=2;
                }
                break;
            case TYPEOF:
                {
                alt19=3;
                }
                break;
            case INC:
                {
                alt19=4;
                }
                break;
            case DEC:
                {
                alt19=5;
                }
                break;
            case ADD:
                {
                alt19=6;
                }
                break;
            case SUB:
                {
                alt19=7;
                }
                break;
            case INV:
                {
                alt19=8;
                }
                break;
            case NOT:
                {
                alt19=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // JavaScript.g:942:4: DELETE
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    DELETE65=(Token)match(input,DELETE,FOLLOW_DELETE_in_unaryOperator3612); 
                    DELETE65_tree = (MyAstNode)adaptor.create(DELETE65);
                    adaptor.addChild(root_0, DELETE65_tree);


                    }
                    break;
                case 2 :
                    // JavaScript.g:943:4: VOID
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    VOID66=(Token)match(input,VOID,FOLLOW_VOID_in_unaryOperator3617); 
                    VOID66_tree = (MyAstNode)adaptor.create(VOID66);
                    adaptor.addChild(root_0, VOID66_tree);


                    }
                    break;
                case 3 :
                    // JavaScript.g:944:4: TYPEOF
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    TYPEOF67=(Token)match(input,TYPEOF,FOLLOW_TYPEOF_in_unaryOperator3622); 
                    TYPEOF67_tree = (MyAstNode)adaptor.create(TYPEOF67);
                    adaptor.addChild(root_0, TYPEOF67_tree);


                    }
                    break;
                case 4 :
                    // JavaScript.g:945:4: INC
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    INC68=(Token)match(input,INC,FOLLOW_INC_in_unaryOperator3627); 
                    INC68_tree = (MyAstNode)adaptor.create(INC68);
                    adaptor.addChild(root_0, INC68_tree);


                    }
                    break;
                case 5 :
                    // JavaScript.g:946:4: DEC
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    DEC69=(Token)match(input,DEC,FOLLOW_DEC_in_unaryOperator3632); 
                    DEC69_tree = (MyAstNode)adaptor.create(DEC69);
                    adaptor.addChild(root_0, DEC69_tree);


                    }
                    break;
                case 6 :
                    // JavaScript.g:947:4: op= ADD
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    op=(Token)match(input,ADD,FOLLOW_ADD_in_unaryOperator3639); 
                    op_tree = (MyAstNode)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(POS); 

                    }
                    break;
                case 7 :
                    // JavaScript.g:948:4: op= SUB
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    op=(Token)match(input,SUB,FOLLOW_SUB_in_unaryOperator3648); 
                    op_tree = (MyAstNode)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(NEG); 

                    }
                    break;
                case 8 :
                    // JavaScript.g:949:4: INV
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    INV70=(Token)match(input,INV,FOLLOW_INV_in_unaryOperator3655); 
                    INV70_tree = (MyAstNode)adaptor.create(INV70);
                    adaptor.addChild(root_0, INV70_tree);


                    }
                    break;
                case 9 :
                    // JavaScript.g:950:4: NOT
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    NOT71=(Token)match(input,NOT,FOLLOW_NOT_in_unaryOperator3660); 
                    NOT71_tree = (MyAstNode)adaptor.create(NOT71);
                    adaptor.addChild(root_0, NOT71_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryOperator"

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplicativeExpression"
    // JavaScript.g:957:1: multiplicativeExpression : unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )* ;
    public final JavaScriptParser.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        JavaScriptParser.multiplicativeExpression_return retval = new JavaScriptParser.multiplicativeExpression_return();
        retval.start = input.LT(1);
        int multiplicativeExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set73=null;
        JavaScriptParser.unaryExpression_return unaryExpression72 = null;

        JavaScriptParser.unaryExpression_return unaryExpression74 = null;


        MyAstNode set73_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // JavaScript.g:958:2: ( unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )* )
            // JavaScript.g:958:4: unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression3675);
            unaryExpression72=unaryExpression();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpression72.getTree());
            // JavaScript.g:958:20: ( ( MUL | DIV | MOD ) unaryExpression )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=MUL && LA20_0<=MOD)||LA20_0==DIV) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // JavaScript.g:958:22: ( MUL | DIV | MOD ) unaryExpression
            	    {
            	    set73=(Token)input.LT(1);
            	    set73=(Token)input.LT(1);
            	    if ( (input.LA(1)>=MUL && input.LA(1)<=MOD)||input.LA(1)==DIV ) {
            	        input.consume();
            	        root_0 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(set73), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression3694);
            	    unaryExpression74=unaryExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpression74.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multiplicativeExpression"

    public static class additiveExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "additiveExpression"
    // JavaScript.g:965:1: additiveExpression : multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )* ;
    public final JavaScriptParser.additiveExpression_return additiveExpression() throws RecognitionException {
        JavaScriptParser.additiveExpression_return retval = new JavaScriptParser.additiveExpression_return();
        retval.start = input.LT(1);
        int additiveExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set76=null;
        JavaScriptParser.multiplicativeExpression_return multiplicativeExpression75 = null;

        JavaScriptParser.multiplicativeExpression_return multiplicativeExpression77 = null;


        MyAstNode set76_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // JavaScript.g:966:2: ( multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )* )
            // JavaScript.g:966:4: multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression3712);
            multiplicativeExpression75=multiplicativeExpression();

            state._fsp--;

            adaptor.addChild(root_0, multiplicativeExpression75.getTree());
            // JavaScript.g:966:29: ( ( ADD | SUB ) multiplicativeExpression )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=ADD && LA21_0<=SUB)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // JavaScript.g:966:31: ( ADD | SUB ) multiplicativeExpression
            	    {
            	    set76=(Token)input.LT(1);
            	    set76=(Token)input.LT(1);
            	    if ( (input.LA(1)>=ADD && input.LA(1)<=SUB) ) {
            	        input.consume();
            	        root_0 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(set76), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression3727);
            	    multiplicativeExpression77=multiplicativeExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multiplicativeExpression77.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "additiveExpression"

    public static class shiftExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shiftExpression"
    // JavaScript.g:973:1: shiftExpression : additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )* ;
    public final JavaScriptParser.shiftExpression_return shiftExpression() throws RecognitionException {
        JavaScriptParser.shiftExpression_return retval = new JavaScriptParser.shiftExpression_return();
        retval.start = input.LT(1);
        int shiftExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set79=null;
        JavaScriptParser.additiveExpression_return additiveExpression78 = null;

        JavaScriptParser.additiveExpression_return additiveExpression80 = null;


        MyAstNode set79_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // JavaScript.g:974:2: ( additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )* )
            // JavaScript.g:974:4: additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_shiftExpression3746);
            additiveExpression78=additiveExpression();

            state._fsp--;

            adaptor.addChild(root_0, additiveExpression78.getTree());
            // JavaScript.g:974:23: ( ( SHL | SHR | SHU ) additiveExpression )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=SHL && LA22_0<=SHU)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // JavaScript.g:974:25: ( SHL | SHR | SHU ) additiveExpression
            	    {
            	    set79=(Token)input.LT(1);
            	    set79=(Token)input.LT(1);
            	    if ( (input.LA(1)>=SHL && input.LA(1)<=SHU) ) {
            	        input.consume();
            	        root_0 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(set79), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression3765);
            	    additiveExpression80=additiveExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, additiveExpression80.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shiftExpression"

    public static class relationalExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalExpression"
    // JavaScript.g:981:1: relationalExpression : shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )* ;
    public final JavaScriptParser.relationalExpression_return relationalExpression() throws RecognitionException {
        JavaScriptParser.relationalExpression_return retval = new JavaScriptParser.relationalExpression_return();
        retval.start = input.LT(1);
        int relationalExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set82=null;
        JavaScriptParser.shiftExpression_return shiftExpression81 = null;

        JavaScriptParser.shiftExpression_return shiftExpression83 = null;


        MyAstNode set82_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // JavaScript.g:982:2: ( shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )* )
            // JavaScript.g:982:4: shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_shiftExpression_in_relationalExpression3784);
            shiftExpression81=shiftExpression();

            state._fsp--;

            adaptor.addChild(root_0, shiftExpression81.getTree());
            // JavaScript.g:982:20: ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=IN && LA23_0<=INSTANCEOF)||(LA23_0>=LT && LA23_0<=GTE)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // JavaScript.g:982:22: ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression
            	    {
            	    set82=(Token)input.LT(1);
            	    set82=(Token)input.LT(1);
            	    if ( (input.LA(1)>=IN && input.LA(1)<=INSTANCEOF)||(input.LA(1)>=LT && input.LA(1)<=GTE) ) {
            	        input.consume();
            	        root_0 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(set82), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression3815);
            	    shiftExpression83=shiftExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, shiftExpression83.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relationalExpression"

    public static class relationalExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalExpressionNoIn"
    // JavaScript.g:985:1: relationalExpressionNoIn : shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )* ;
    public final JavaScriptParser.relationalExpressionNoIn_return relationalExpressionNoIn() throws RecognitionException {
        JavaScriptParser.relationalExpressionNoIn_return retval = new JavaScriptParser.relationalExpressionNoIn_return();
        retval.start = input.LT(1);
        int relationalExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set85=null;
        JavaScriptParser.shiftExpression_return shiftExpression84 = null;

        JavaScriptParser.shiftExpression_return shiftExpression86 = null;


        MyAstNode set85_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // JavaScript.g:986:2: ( shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )* )
            // JavaScript.g:986:4: shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_shiftExpression_in_relationalExpressionNoIn3829);
            shiftExpression84=shiftExpression();

            state._fsp--;

            adaptor.addChild(root_0, shiftExpression84.getTree());
            // JavaScript.g:986:20: ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==INSTANCEOF||(LA24_0>=LT && LA24_0<=GTE)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // JavaScript.g:986:22: ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression
            	    {
            	    set85=(Token)input.LT(1);
            	    set85=(Token)input.LT(1);
            	    if ( input.LA(1)==INSTANCEOF||(input.LA(1)>=LT && input.LA(1)<=GTE) ) {
            	        input.consume();
            	        root_0 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(set85), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpressionNoIn3856);
            	    shiftExpression86=shiftExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, shiftExpression86.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relationalExpressionNoIn"

    public static class equalityExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalityExpression"
    // JavaScript.g:993:1: equalityExpression : relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )* ;
    public final JavaScriptParser.equalityExpression_return equalityExpression() throws RecognitionException {
        JavaScriptParser.equalityExpression_return retval = new JavaScriptParser.equalityExpression_return();
        retval.start = input.LT(1);
        int equalityExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set88=null;
        JavaScriptParser.relationalExpression_return relationalExpression87 = null;

        JavaScriptParser.relationalExpression_return relationalExpression89 = null;


        MyAstNode set88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // JavaScript.g:994:2: ( relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )* )
            // JavaScript.g:994:4: relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_equalityExpression3875);
            relationalExpression87=relationalExpression();

            state._fsp--;

            adaptor.addChild(root_0, relationalExpression87.getTree());
            // JavaScript.g:994:25: ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=EQ && LA25_0<=NSAME)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // JavaScript.g:994:27: ( EQ | NEQ | SAME | NSAME ) relationalExpression
            	    {
            	    set88=(Token)input.LT(1);
            	    set88=(Token)input.LT(1);
            	    if ( (input.LA(1)>=EQ && input.LA(1)<=NSAME) ) {
            	        input.consume();
            	        root_0 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(set88), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression3898);
            	    relationalExpression89=relationalExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, relationalExpression89.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equalityExpression"

    public static class equalityExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalityExpressionNoIn"
    // JavaScript.g:997:1: equalityExpressionNoIn : relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )* ;
    public final JavaScriptParser.equalityExpressionNoIn_return equalityExpressionNoIn() throws RecognitionException {
        JavaScriptParser.equalityExpressionNoIn_return retval = new JavaScriptParser.equalityExpressionNoIn_return();
        retval.start = input.LT(1);
        int equalityExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set91=null;
        JavaScriptParser.relationalExpressionNoIn_return relationalExpressionNoIn90 = null;

        JavaScriptParser.relationalExpressionNoIn_return relationalExpressionNoIn92 = null;


        MyAstNode set91_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // JavaScript.g:998:2: ( relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )* )
            // JavaScript.g:998:4: relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn3912);
            relationalExpressionNoIn90=relationalExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, relationalExpressionNoIn90.getTree());
            // JavaScript.g:998:29: ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=EQ && LA26_0<=NSAME)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // JavaScript.g:998:31: ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn
            	    {
            	    set91=(Token)input.LT(1);
            	    set91=(Token)input.LT(1);
            	    if ( (input.LA(1)>=EQ && input.LA(1)<=NSAME) ) {
            	        input.consume();
            	        root_0 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(set91), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn3935);
            	    relationalExpressionNoIn92=relationalExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, relationalExpressionNoIn92.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equalityExpressionNoIn"

    public static class bitwiseANDExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseANDExpression"
    // JavaScript.g:1005:1: bitwiseANDExpression : equalityExpression ( AND equalityExpression )* ;
    public final JavaScriptParser.bitwiseANDExpression_return bitwiseANDExpression() throws RecognitionException {
        JavaScriptParser.bitwiseANDExpression_return retval = new JavaScriptParser.bitwiseANDExpression_return();
        retval.start = input.LT(1);
        int bitwiseANDExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token AND94=null;
        JavaScriptParser.equalityExpression_return equalityExpression93 = null;

        JavaScriptParser.equalityExpression_return equalityExpression95 = null;


        MyAstNode AND94_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // JavaScript.g:1006:2: ( equalityExpression ( AND equalityExpression )* )
            // JavaScript.g:1006:4: equalityExpression ( AND equalityExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_equalityExpression_in_bitwiseANDExpression3955);
            equalityExpression93=equalityExpression();

            state._fsp--;

            adaptor.addChild(root_0, equalityExpression93.getTree());
            // JavaScript.g:1006:23: ( AND equalityExpression )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==AND) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // JavaScript.g:1006:25: AND equalityExpression
            	    {
            	    AND94=(Token)match(input,AND,FOLLOW_AND_in_bitwiseANDExpression3959); 
            	    AND94_tree = (MyAstNode)adaptor.create(AND94);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(AND94_tree, root_0);

            	    pushFollow(FOLLOW_equalityExpression_in_bitwiseANDExpression3962);
            	    equalityExpression95=equalityExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, equalityExpression95.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseANDExpression"

    public static class bitwiseANDExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseANDExpressionNoIn"
    // JavaScript.g:1009:1: bitwiseANDExpressionNoIn : equalityExpressionNoIn ( AND equalityExpressionNoIn )* ;
    public final JavaScriptParser.bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn() throws RecognitionException {
        JavaScriptParser.bitwiseANDExpressionNoIn_return retval = new JavaScriptParser.bitwiseANDExpressionNoIn_return();
        retval.start = input.LT(1);
        int bitwiseANDExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token AND97=null;
        JavaScriptParser.equalityExpressionNoIn_return equalityExpressionNoIn96 = null;

        JavaScriptParser.equalityExpressionNoIn_return equalityExpressionNoIn98 = null;


        MyAstNode AND97_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // JavaScript.g:1010:2: ( equalityExpressionNoIn ( AND equalityExpressionNoIn )* )
            // JavaScript.g:1010:4: equalityExpressionNoIn ( AND equalityExpressionNoIn )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn3976);
            equalityExpressionNoIn96=equalityExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, equalityExpressionNoIn96.getTree());
            // JavaScript.g:1010:27: ( AND equalityExpressionNoIn )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==AND) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // JavaScript.g:1010:29: AND equalityExpressionNoIn
            	    {
            	    AND97=(Token)match(input,AND,FOLLOW_AND_in_bitwiseANDExpressionNoIn3980); 
            	    AND97_tree = (MyAstNode)adaptor.create(AND97);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(AND97_tree, root_0);

            	    pushFollow(FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn3983);
            	    equalityExpressionNoIn98=equalityExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, equalityExpressionNoIn98.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseANDExpressionNoIn"

    public static class bitwiseXORExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseXORExpression"
    // JavaScript.g:1013:1: bitwiseXORExpression : bitwiseANDExpression ( XOR bitwiseANDExpression )* ;
    public final JavaScriptParser.bitwiseXORExpression_return bitwiseXORExpression() throws RecognitionException {
        JavaScriptParser.bitwiseXORExpression_return retval = new JavaScriptParser.bitwiseXORExpression_return();
        retval.start = input.LT(1);
        int bitwiseXORExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token XOR100=null;
        JavaScriptParser.bitwiseANDExpression_return bitwiseANDExpression99 = null;

        JavaScriptParser.bitwiseANDExpression_return bitwiseANDExpression101 = null;


        MyAstNode XOR100_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // JavaScript.g:1014:2: ( bitwiseANDExpression ( XOR bitwiseANDExpression )* )
            // JavaScript.g:1014:4: bitwiseANDExpression ( XOR bitwiseANDExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression3999);
            bitwiseANDExpression99=bitwiseANDExpression();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseANDExpression99.getTree());
            // JavaScript.g:1014:25: ( XOR bitwiseANDExpression )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==XOR) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // JavaScript.g:1014:27: XOR bitwiseANDExpression
            	    {
            	    XOR100=(Token)match(input,XOR,FOLLOW_XOR_in_bitwiseXORExpression4003); 
            	    XOR100_tree = (MyAstNode)adaptor.create(XOR100);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(XOR100_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression4006);
            	    bitwiseANDExpression101=bitwiseANDExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseANDExpression101.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseXORExpression"

    public static class bitwiseXORExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseXORExpressionNoIn"
    // JavaScript.g:1017:1: bitwiseXORExpressionNoIn : bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )* ;
    public final JavaScriptParser.bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn() throws RecognitionException {
        JavaScriptParser.bitwiseXORExpressionNoIn_return retval = new JavaScriptParser.bitwiseXORExpressionNoIn_return();
        retval.start = input.LT(1);
        int bitwiseXORExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token XOR103=null;
        JavaScriptParser.bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn102 = null;

        JavaScriptParser.bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn104 = null;


        MyAstNode XOR103_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // JavaScript.g:1018:2: ( bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )* )
            // JavaScript.g:1018:4: bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn4022);
            bitwiseANDExpressionNoIn102=bitwiseANDExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseANDExpressionNoIn102.getTree());
            // JavaScript.g:1018:29: ( XOR bitwiseANDExpressionNoIn )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==XOR) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // JavaScript.g:1018:31: XOR bitwiseANDExpressionNoIn
            	    {
            	    XOR103=(Token)match(input,XOR,FOLLOW_XOR_in_bitwiseXORExpressionNoIn4026); 
            	    XOR103_tree = (MyAstNode)adaptor.create(XOR103);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(XOR103_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn4029);
            	    bitwiseANDExpressionNoIn104=bitwiseANDExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseANDExpressionNoIn104.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseXORExpressionNoIn"

    public static class bitwiseORExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseORExpression"
    // JavaScript.g:1021:1: bitwiseORExpression : bitwiseXORExpression ( OR bitwiseXORExpression )* ;
    public final JavaScriptParser.bitwiseORExpression_return bitwiseORExpression() throws RecognitionException {
        JavaScriptParser.bitwiseORExpression_return retval = new JavaScriptParser.bitwiseORExpression_return();
        retval.start = input.LT(1);
        int bitwiseORExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token OR106=null;
        JavaScriptParser.bitwiseXORExpression_return bitwiseXORExpression105 = null;

        JavaScriptParser.bitwiseXORExpression_return bitwiseXORExpression107 = null;


        MyAstNode OR106_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // JavaScript.g:1022:2: ( bitwiseXORExpression ( OR bitwiseXORExpression )* )
            // JavaScript.g:1022:4: bitwiseXORExpression ( OR bitwiseXORExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_bitwiseXORExpression_in_bitwiseORExpression4044);
            bitwiseXORExpression105=bitwiseXORExpression();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseXORExpression105.getTree());
            // JavaScript.g:1022:25: ( OR bitwiseXORExpression )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==OR) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // JavaScript.g:1022:27: OR bitwiseXORExpression
            	    {
            	    OR106=(Token)match(input,OR,FOLLOW_OR_in_bitwiseORExpression4048); 
            	    OR106_tree = (MyAstNode)adaptor.create(OR106);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(OR106_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseXORExpression_in_bitwiseORExpression4051);
            	    bitwiseXORExpression107=bitwiseXORExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseXORExpression107.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseORExpression"

    public static class bitwiseORExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseORExpressionNoIn"
    // JavaScript.g:1025:1: bitwiseORExpressionNoIn : bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )* ;
    public final JavaScriptParser.bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn() throws RecognitionException {
        JavaScriptParser.bitwiseORExpressionNoIn_return retval = new JavaScriptParser.bitwiseORExpressionNoIn_return();
        retval.start = input.LT(1);
        int bitwiseORExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token OR109=null;
        JavaScriptParser.bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn108 = null;

        JavaScriptParser.bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn110 = null;


        MyAstNode OR109_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // JavaScript.g:1026:2: ( bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )* )
            // JavaScript.g:1026:4: bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn4066);
            bitwiseXORExpressionNoIn108=bitwiseXORExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseXORExpressionNoIn108.getTree());
            // JavaScript.g:1026:29: ( OR bitwiseXORExpressionNoIn )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==OR) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // JavaScript.g:1026:31: OR bitwiseXORExpressionNoIn
            	    {
            	    OR109=(Token)match(input,OR,FOLLOW_OR_in_bitwiseORExpressionNoIn4070); 
            	    OR109_tree = (MyAstNode)adaptor.create(OR109);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(OR109_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn4073);
            	    bitwiseXORExpressionNoIn110=bitwiseXORExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseXORExpressionNoIn110.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseORExpressionNoIn"

    public static class logicalANDExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalANDExpression"
    // JavaScript.g:1033:1: logicalANDExpression : bitwiseORExpression ( LAND bitwiseORExpression )* ;
    public final JavaScriptParser.logicalANDExpression_return logicalANDExpression() throws RecognitionException {
        JavaScriptParser.logicalANDExpression_return retval = new JavaScriptParser.logicalANDExpression_return();
        retval.start = input.LT(1);
        int logicalANDExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token LAND112=null;
        JavaScriptParser.bitwiseORExpression_return bitwiseORExpression111 = null;

        JavaScriptParser.bitwiseORExpression_return bitwiseORExpression113 = null;


        MyAstNode LAND112_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // JavaScript.g:1034:2: ( bitwiseORExpression ( LAND bitwiseORExpression )* )
            // JavaScript.g:1034:4: bitwiseORExpression ( LAND bitwiseORExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_bitwiseORExpression_in_logicalANDExpression4092);
            bitwiseORExpression111=bitwiseORExpression();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseORExpression111.getTree());
            // JavaScript.g:1034:24: ( LAND bitwiseORExpression )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==LAND) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // JavaScript.g:1034:26: LAND bitwiseORExpression
            	    {
            	    LAND112=(Token)match(input,LAND,FOLLOW_LAND_in_logicalANDExpression4096); 
            	    LAND112_tree = (MyAstNode)adaptor.create(LAND112);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(LAND112_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseORExpression_in_logicalANDExpression4099);
            	    bitwiseORExpression113=bitwiseORExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseORExpression113.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalANDExpression"

    public static class logicalANDExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalANDExpressionNoIn"
    // JavaScript.g:1037:1: logicalANDExpressionNoIn : bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )* ;
    public final JavaScriptParser.logicalANDExpressionNoIn_return logicalANDExpressionNoIn() throws RecognitionException {
        JavaScriptParser.logicalANDExpressionNoIn_return retval = new JavaScriptParser.logicalANDExpressionNoIn_return();
        retval.start = input.LT(1);
        int logicalANDExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token LAND115=null;
        JavaScriptParser.bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn114 = null;

        JavaScriptParser.bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn116 = null;


        MyAstNode LAND115_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // JavaScript.g:1038:2: ( bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )* )
            // JavaScript.g:1038:4: bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn4113);
            bitwiseORExpressionNoIn114=bitwiseORExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseORExpressionNoIn114.getTree());
            // JavaScript.g:1038:28: ( LAND bitwiseORExpressionNoIn )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==LAND) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // JavaScript.g:1038:30: LAND bitwiseORExpressionNoIn
            	    {
            	    LAND115=(Token)match(input,LAND,FOLLOW_LAND_in_logicalANDExpressionNoIn4117); 
            	    LAND115_tree = (MyAstNode)adaptor.create(LAND115);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(LAND115_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn4120);
            	    bitwiseORExpressionNoIn116=bitwiseORExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseORExpressionNoIn116.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalANDExpressionNoIn"

    public static class logicalORExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalORExpression"
    // JavaScript.g:1041:1: logicalORExpression : logicalANDExpression ( LOR logicalANDExpression )* ;
    public final JavaScriptParser.logicalORExpression_return logicalORExpression() throws RecognitionException {
        JavaScriptParser.logicalORExpression_return retval = new JavaScriptParser.logicalORExpression_return();
        retval.start = input.LT(1);
        int logicalORExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token LOR118=null;
        JavaScriptParser.logicalANDExpression_return logicalANDExpression117 = null;

        JavaScriptParser.logicalANDExpression_return logicalANDExpression119 = null;


        MyAstNode LOR118_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // JavaScript.g:1042:2: ( logicalANDExpression ( LOR logicalANDExpression )* )
            // JavaScript.g:1042:4: logicalANDExpression ( LOR logicalANDExpression )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_logicalANDExpression_in_logicalORExpression4135);
            logicalANDExpression117=logicalANDExpression();

            state._fsp--;

            adaptor.addChild(root_0, logicalANDExpression117.getTree());
            // JavaScript.g:1042:25: ( LOR logicalANDExpression )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==LOR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // JavaScript.g:1042:27: LOR logicalANDExpression
            	    {
            	    LOR118=(Token)match(input,LOR,FOLLOW_LOR_in_logicalORExpression4139); 
            	    LOR118_tree = (MyAstNode)adaptor.create(LOR118);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(LOR118_tree, root_0);

            	    pushFollow(FOLLOW_logicalANDExpression_in_logicalORExpression4142);
            	    logicalANDExpression119=logicalANDExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicalANDExpression119.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalORExpression"

    public static class logicalORExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalORExpressionNoIn"
    // JavaScript.g:1045:1: logicalORExpressionNoIn : logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )* ;
    public final JavaScriptParser.logicalORExpressionNoIn_return logicalORExpressionNoIn() throws RecognitionException {
        JavaScriptParser.logicalORExpressionNoIn_return retval = new JavaScriptParser.logicalORExpressionNoIn_return();
        retval.start = input.LT(1);
        int logicalORExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token LOR121=null;
        JavaScriptParser.logicalANDExpressionNoIn_return logicalANDExpressionNoIn120 = null;

        JavaScriptParser.logicalANDExpressionNoIn_return logicalANDExpressionNoIn122 = null;


        MyAstNode LOR121_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // JavaScript.g:1046:2: ( logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )* )
            // JavaScript.g:1046:4: logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn4157);
            logicalANDExpressionNoIn120=logicalANDExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, logicalANDExpressionNoIn120.getTree());
            // JavaScript.g:1046:29: ( LOR logicalANDExpressionNoIn )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==LOR) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // JavaScript.g:1046:31: LOR logicalANDExpressionNoIn
            	    {
            	    LOR121=(Token)match(input,LOR,FOLLOW_LOR_in_logicalORExpressionNoIn4161); 
            	    LOR121_tree = (MyAstNode)adaptor.create(LOR121);
            	    root_0 = (MyAstNode)adaptor.becomeRoot(LOR121_tree, root_0);

            	    pushFollow(FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn4164);
            	    logicalANDExpressionNoIn122=logicalANDExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicalANDExpressionNoIn122.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalORExpressionNoIn"

    public static class conditionalExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionalExpression"
    // JavaScript.g:1053:1: conditionalExpression : logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )? ;
    public final JavaScriptParser.conditionalExpression_return conditionalExpression() throws RecognitionException {
        JavaScriptParser.conditionalExpression_return retval = new JavaScriptParser.conditionalExpression_return();
        retval.start = input.LT(1);
        int conditionalExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token QUE124=null;
        Token COLON126=null;
        JavaScriptParser.logicalORExpression_return logicalORExpression123 = null;

        JavaScriptParser.assignmentExpression_return assignmentExpression125 = null;

        JavaScriptParser.assignmentExpression_return assignmentExpression127 = null;


        MyAstNode QUE124_tree=null;
        MyAstNode COLON126_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // JavaScript.g:1054:2: ( logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )? )
            // JavaScript.g:1054:4: logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )?
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_logicalORExpression_in_conditionalExpression4183);
            logicalORExpression123=logicalORExpression();

            state._fsp--;

            adaptor.addChild(root_0, logicalORExpression123.getTree());
            // JavaScript.g:1054:24: ( QUE assignmentExpression COLON assignmentExpression )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==QUE) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // JavaScript.g:1054:26: QUE assignmentExpression COLON assignmentExpression
                    {
                    QUE124=(Token)match(input,QUE,FOLLOW_QUE_in_conditionalExpression4187); 
                    QUE124_tree = (MyAstNode)adaptor.create(QUE124);
                    root_0 = (MyAstNode)adaptor.becomeRoot(QUE124_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression4190);
                    assignmentExpression125=assignmentExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpression125.getTree());
                    COLON126=(Token)match(input,COLON,FOLLOW_COLON_in_conditionalExpression4192); 
                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression4195);
                    assignmentExpression127=assignmentExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpression127.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conditionalExpression"

    public static class conditionalExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionalExpressionNoIn"
    // JavaScript.g:1057:1: conditionalExpressionNoIn : logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )? ;
    public final JavaScriptParser.conditionalExpressionNoIn_return conditionalExpressionNoIn() throws RecognitionException {
        JavaScriptParser.conditionalExpressionNoIn_return retval = new JavaScriptParser.conditionalExpressionNoIn_return();
        retval.start = input.LT(1);
        int conditionalExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token QUE129=null;
        Token COLON131=null;
        JavaScriptParser.logicalORExpressionNoIn_return logicalORExpressionNoIn128 = null;

        JavaScriptParser.assignmentExpressionNoIn_return assignmentExpressionNoIn130 = null;

        JavaScriptParser.assignmentExpressionNoIn_return assignmentExpressionNoIn132 = null;


        MyAstNode QUE129_tree=null;
        MyAstNode COLON131_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // JavaScript.g:1058:2: ( logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )? )
            // JavaScript.g:1058:4: logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )?
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_logicalORExpressionNoIn_in_conditionalExpressionNoIn4209);
            logicalORExpressionNoIn128=logicalORExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, logicalORExpressionNoIn128.getTree());
            // JavaScript.g:1058:28: ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==QUE) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // JavaScript.g:1058:30: QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn
                    {
                    QUE129=(Token)match(input,QUE,FOLLOW_QUE_in_conditionalExpressionNoIn4213); 
                    QUE129_tree = (MyAstNode)adaptor.create(QUE129);
                    root_0 = (MyAstNode)adaptor.becomeRoot(QUE129_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn4216);
                    assignmentExpressionNoIn130=assignmentExpressionNoIn();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn130.getTree());
                    COLON131=(Token)match(input,COLON,FOLLOW_COLON_in_conditionalExpressionNoIn4218); 
                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn4221);
                    assignmentExpressionNoIn132=assignmentExpressionNoIn();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn132.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conditionalExpressionNoIn"

    public static class assignmentExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentExpression"
    // JavaScript.g:1087:1: assignmentExpression : lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )? ;
    public final JavaScriptParser.assignmentExpression_return assignmentExpression() throws RecognitionException {
        JavaScriptParser.assignmentExpression_return retval = new JavaScriptParser.assignmentExpression_return();
        retval.start = input.LT(1);
        int assignmentExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.conditionalExpression_return lhs = null;

        JavaScriptParser.assignmentOperator_return assignmentOperator133 = null;

        JavaScriptParser.assignmentExpression_return assignmentExpression134 = null;




        	Object[] isLhs = new Object[1];

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // JavaScript.g:1092:2: (lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )? )
            // JavaScript.g:1092:4: lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )?
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_conditionalExpression_in_assignmentExpression4249);
            lhs=conditionalExpression();

            state._fsp--;

            adaptor.addChild(root_0, lhs.getTree());
            // JavaScript.g:1093:2: ({...}? assignmentOperator assignmentExpression )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=ASSIGN && LA39_0<=XORASS)||LA39_0==DIVASS) ) {
                int LA39_1 = input.LA(2);

                if ( (( isLeftHandSideAssign(lhs, isLhs) )) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // JavaScript.g:1093:4: {...}? assignmentOperator assignmentExpression
                    {
                    if ( !(( isLeftHandSideAssign(lhs, isLhs) )) ) {
                        throw new FailedPredicateException(input, "assignmentExpression", " isLeftHandSideAssign(lhs, isLhs) ");
                    }
                    pushFollow(FOLLOW_assignmentOperator_in_assignmentExpression4256);
                    assignmentOperator133=assignmentOperator();

                    state._fsp--;

                    root_0 = (MyAstNode)adaptor.becomeRoot(assignmentOperator133.getTree(), root_0);
                    pushFollow(FOLLOW_assignmentExpression_in_assignmentExpression4259);
                    assignmentExpression134=assignmentExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpression134.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignmentExpression"

    public static class assignmentOperator_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentOperator"
    // JavaScript.g:1096:1: assignmentOperator : ( ASSIGN | MULASS | DIVASS | MODASS | ADDASS | SUBASS | SHLASS | SHRASS | SHUASS | ANDASS | XORASS | ORASS );
    public final JavaScriptParser.assignmentOperator_return assignmentOperator() throws RecognitionException {
        JavaScriptParser.assignmentOperator_return retval = new JavaScriptParser.assignmentOperator_return();
        retval.start = input.LT(1);
        int assignmentOperator_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token set135=null;

        MyAstNode set135_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // JavaScript.g:1097:2: ( ASSIGN | MULASS | DIVASS | MODASS | ADDASS | SUBASS | SHLASS | SHRASS | SHUASS | ANDASS | XORASS | ORASS )
            // JavaScript.g:
            {
            root_0 = (MyAstNode)adaptor.nil();

            set135=(Token)input.LT(1);
            if ( (input.LA(1)>=ASSIGN && input.LA(1)<=XORASS)||input.LA(1)==DIVASS ) {
                input.consume();
                adaptor.addChild(root_0, (MyAstNode)adaptor.create(set135));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignmentOperator"

    public static class assignmentExpressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentExpressionNoIn"
    // JavaScript.g:1100:1: assignmentExpressionNoIn : lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )? ;
    public final JavaScriptParser.assignmentExpressionNoIn_return assignmentExpressionNoIn() throws RecognitionException {
        JavaScriptParser.assignmentExpressionNoIn_return retval = new JavaScriptParser.assignmentExpressionNoIn_return();
        retval.start = input.LT(1);
        int assignmentExpressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.conditionalExpressionNoIn_return lhs = null;

        JavaScriptParser.assignmentOperator_return assignmentOperator136 = null;

        JavaScriptParser.assignmentExpressionNoIn_return assignmentExpressionNoIn137 = null;




        	Object[] isLhs = new Object[1];

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // JavaScript.g:1105:2: (lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )? )
            // JavaScript.g:1105:4: lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )?
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_conditionalExpressionNoIn_in_assignmentExpressionNoIn4336);
            lhs=conditionalExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, lhs.getTree());
            // JavaScript.g:1106:2: ({...}? assignmentOperator assignmentExpressionNoIn )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=ASSIGN && LA40_0<=XORASS)||LA40_0==DIVASS) ) {
                int LA40_1 = input.LA(2);

                if ( (( isLeftHandSideAssign(lhs, isLhs) )) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // JavaScript.g:1106:4: {...}? assignmentOperator assignmentExpressionNoIn
                    {
                    if ( !(( isLeftHandSideAssign(lhs, isLhs) )) ) {
                        throw new FailedPredicateException(input, "assignmentExpressionNoIn", " isLeftHandSideAssign(lhs, isLhs) ");
                    }
                    pushFollow(FOLLOW_assignmentOperator_in_assignmentExpressionNoIn4343);
                    assignmentOperator136=assignmentOperator();

                    state._fsp--;

                    root_0 = (MyAstNode)adaptor.becomeRoot(assignmentOperator136.getTree(), root_0);
                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_assignmentExpressionNoIn4346);
                    assignmentExpressionNoIn137=assignmentExpressionNoIn();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn137.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignmentExpressionNoIn"

    public static class expression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // JavaScript.g:1113:1: expression : exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs;
    public final JavaScriptParser.expression_return expression() throws RecognitionException {
        JavaScriptParser.expression_return retval = new JavaScriptParser.expression_return();
        retval.start = input.LT(1);
        int expression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token COMMA138=null;
        List list_exprs=null;
        RuleReturnScope exprs = null;
        MyAstNode COMMA138_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // JavaScript.g:1114:2: (exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs)
            // JavaScript.g:1114:4: exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )*
            {
            pushFollow(FOLLOW_assignmentExpression_in_expression4368);
            exprs=assignmentExpression();

            state._fsp--;

            stream_assignmentExpression.add(exprs.getTree());
            if (list_exprs==null) list_exprs=new ArrayList();
            list_exprs.add(exprs.getTree());

            // JavaScript.g:1114:32: ( COMMA exprs+= assignmentExpression )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==COMMA) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // JavaScript.g:1114:34: COMMA exprs+= assignmentExpression
            	    {
            	    COMMA138=(Token)match(input,COMMA,FOLLOW_COMMA_in_expression4372);  
            	    stream_COMMA.add(COMMA138);

            	    pushFollow(FOLLOW_assignmentExpression_in_expression4376);
            	    exprs=assignmentExpression();

            	    state._fsp--;

            	    stream_assignmentExpression.add(exprs.getTree());
            	    if (list_exprs==null) list_exprs=new ArrayList();
            	    list_exprs.add(exprs.getTree());


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);



            // AST REWRITE
            // elements: exprs, exprs
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: exprs
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"token exprs",list_exprs);
            root_0 = (MyAstNode)adaptor.nil();
            // 1115:2: -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ )
            if ( list_exprs.size() > 1 ) {
                // JavaScript.g:1115:28: ^( CEXPR ( $exprs)+ )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(CEXPR, "CEXPR"), root_1);

                if ( !(stream_exprs.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_exprs.hasNext() ) {
                    adaptor.addChild(root_1, stream_exprs.nextTree());

                }
                stream_exprs.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 1116:2: -> $exprs
            {
                adaptor.addChild(root_0, stream_exprs.nextTree());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class expressionNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expressionNoIn"
    // JavaScript.g:1119:1: expressionNoIn : exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs;
    public final JavaScriptParser.expressionNoIn_return expressionNoIn() throws RecognitionException {
        JavaScriptParser.expressionNoIn_return retval = new JavaScriptParser.expressionNoIn_return();
        retval.start = input.LT(1);
        int expressionNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token COMMA139=null;
        List list_exprs=null;
        RuleReturnScope exprs = null;
        MyAstNode COMMA139_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignmentExpressionNoIn=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpressionNoIn");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // JavaScript.g:1120:2: (exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs)
            // JavaScript.g:1120:4: exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )*
            {
            pushFollow(FOLLOW_assignmentExpressionNoIn_in_expressionNoIn4413);
            exprs=assignmentExpressionNoIn();

            state._fsp--;

            stream_assignmentExpressionNoIn.add(exprs.getTree());
            if (list_exprs==null) list_exprs=new ArrayList();
            list_exprs.add(exprs.getTree());

            // JavaScript.g:1120:36: ( COMMA exprs+= assignmentExpressionNoIn )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==COMMA) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // JavaScript.g:1120:38: COMMA exprs+= assignmentExpressionNoIn
            	    {
            	    COMMA139=(Token)match(input,COMMA,FOLLOW_COMMA_in_expressionNoIn4417);  
            	    stream_COMMA.add(COMMA139);

            	    pushFollow(FOLLOW_assignmentExpressionNoIn_in_expressionNoIn4421);
            	    exprs=assignmentExpressionNoIn();

            	    state._fsp--;

            	    stream_assignmentExpressionNoIn.add(exprs.getTree());
            	    if (list_exprs==null) list_exprs=new ArrayList();
            	    list_exprs.add(exprs.getTree());


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);



            // AST REWRITE
            // elements: exprs, exprs
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: exprs
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"token exprs",list_exprs);
            root_0 = (MyAstNode)adaptor.nil();
            // 1121:2: -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ )
            if ( list_exprs.size() > 1 ) {
                // JavaScript.g:1121:28: ^( CEXPR ( $exprs)+ )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(CEXPR, "CEXPR"), root_1);

                if ( !(stream_exprs.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_exprs.hasNext() ) {
                    adaptor.addChild(root_1, stream_exprs.nextTree());

                }
                stream_exprs.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 1122:2: -> $exprs
            {
                adaptor.addChild(root_0, stream_exprs.nextTree());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expressionNoIn"

    public static class semic_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "semic"
    // JavaScript.g:1147:1: semic : ( SEMIC | EOF | RBRACE | EOL | MultiLineComment );
    public final JavaScriptParser.semic_return semic() throws RecognitionException {
        JavaScriptParser.semic_return retval = new JavaScriptParser.semic_return();
        retval.start = input.LT(1);
        int semic_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token SEMIC140=null;
        Token EOF141=null;
        Token RBRACE142=null;
        Token EOL143=null;
        Token MultiLineComment144=null;

        MyAstNode SEMIC140_tree=null;
        MyAstNode EOF141_tree=null;
        MyAstNode RBRACE142_tree=null;
        MyAstNode EOL143_tree=null;
        MyAstNode MultiLineComment144_tree=null;


        	// Mark current position so we can unconsume a RBRACE.
        	int marker = input.mark();
        	// Promote EOL if appropriate	
        	promoteEOL(retval);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // JavaScript.g:1155:2: ( SEMIC | EOF | RBRACE | EOL | MultiLineComment )
            int alt43=5;
            switch ( input.LA(1) ) {
            case SEMIC:
                {
                alt43=1;
                }
                break;
            case EOF:
                {
                alt43=2;
                }
                break;
            case RBRACE:
                {
                alt43=3;
                }
                break;
            case EOL:
                {
                alt43=4;
                }
                break;
            case MultiLineComment:
                {
                alt43=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // JavaScript.g:1155:4: SEMIC
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    SEMIC140=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_semic4472); 
                    SEMIC140_tree = (MyAstNode)adaptor.create(SEMIC140);
                    adaptor.addChild(root_0, SEMIC140_tree);


                    }
                    break;
                case 2 :
                    // JavaScript.g:1156:4: EOF
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    EOF141=(Token)match(input,EOF,FOLLOW_EOF_in_semic4477); 
                    EOF141_tree = (MyAstNode)adaptor.create(EOF141);
                    adaptor.addChild(root_0, EOF141_tree);


                    }
                    break;
                case 3 :
                    // JavaScript.g:1157:4: RBRACE
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    RBRACE142=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_semic4482); 
                    RBRACE142_tree = (MyAstNode)adaptor.create(RBRACE142);
                    adaptor.addChild(root_0, RBRACE142_tree);

                     input.rewind(marker); 

                    }
                    break;
                case 4 :
                    // JavaScript.g:1158:4: EOL
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    EOL143=(Token)match(input,EOL,FOLLOW_EOL_in_semic4489); 
                    EOL143_tree = (MyAstNode)adaptor.create(EOL143);
                    adaptor.addChild(root_0, EOL143_tree);


                    }
                    break;
                case 5 :
                    // JavaScript.g:1158:10: MultiLineComment
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    MultiLineComment144=(Token)match(input,MultiLineComment,FOLLOW_MultiLineComment_in_semic4493); 
                    MultiLineComment144_tree = (MyAstNode)adaptor.create(MultiLineComment144);
                    adaptor.addChild(root_0, MultiLineComment144_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "semic"

    public static class statement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // JavaScript.g:1166:1: statement options {k=1; } : ({...}? block | statementTail );
    public final JavaScriptParser.statement_return statement() throws RecognitionException {
        JavaScriptParser.statement_return retval = new JavaScriptParser.statement_return();
        retval.start = input.LT(1);
        int statement_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.block_return block145 = null;

        JavaScriptParser.statementTail_return statementTail146 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // JavaScript.g:1175:2: ({...}? block | statementTail )
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // JavaScript.g:1175:4: {...}? block
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    if ( !(( input.LA(1) == LBRACE )) ) {
                        throw new FailedPredicateException(input, "statement", " input.LA(1) == LBRACE ");
                    }
                    pushFollow(FOLLOW_block_in_statement4527);
                    block145=block();

                    state._fsp--;

                    adaptor.addChild(root_0, block145.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:1176:4: statementTail
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_statementTail_in_statement4532);
                    statementTail146=statementTail();

                    state._fsp--;

                    adaptor.addChild(root_0, statementTail146.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


                    if(retval.tree != null)
                        retval.tree.is_statement = true;
                
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class statementTail_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statementTail"
    // JavaScript.g:1179:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement );
    public final JavaScriptParser.statementTail_return statementTail() throws RecognitionException {
        JavaScriptParser.statementTail_return retval = new JavaScriptParser.statementTail_return();
        retval.start = input.LT(1);
        int statementTail_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.variableStatement_return variableStatement147 = null;

        JavaScriptParser.emptyStatement_return emptyStatement148 = null;

        JavaScriptParser.expressionStatement_return expressionStatement149 = null;

        JavaScriptParser.ifStatement_return ifStatement150 = null;

        JavaScriptParser.iterationStatement_return iterationStatement151 = null;

        JavaScriptParser.continueStatement_return continueStatement152 = null;

        JavaScriptParser.breakStatement_return breakStatement153 = null;

        JavaScriptParser.returnStatement_return returnStatement154 = null;

        JavaScriptParser.withStatement_return withStatement155 = null;

        JavaScriptParser.labelledStatement_return labelledStatement156 = null;

        JavaScriptParser.switchStatement_return switchStatement157 = null;

        JavaScriptParser.throwStatement_return throwStatement158 = null;

        JavaScriptParser.tryStatement_return tryStatement159 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // JavaScript.g:1180:2: ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement )
            int alt45=13;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // JavaScript.g:1180:4: variableStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_variableStatement_in_statementTail4544);
                    variableStatement147=variableStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, variableStatement147.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:1181:4: emptyStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_emptyStatement_in_statementTail4549);
                    emptyStatement148=emptyStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, emptyStatement148.getTree());

                    }
                    break;
                case 3 :
                    // JavaScript.g:1182:4: expressionStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementTail4554);
                    expressionStatement149=expressionStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, expressionStatement149.getTree());

                    }
                    break;
                case 4 :
                    // JavaScript.g:1183:4: ifStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementTail4559);
                    ifStatement150=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement150.getTree());

                    }
                    break;
                case 5 :
                    // JavaScript.g:1184:4: iterationStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_iterationStatement_in_statementTail4564);
                    iterationStatement151=iterationStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, iterationStatement151.getTree());

                    }
                    break;
                case 6 :
                    // JavaScript.g:1185:4: continueStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementTail4569);
                    continueStatement152=continueStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, continueStatement152.getTree());

                    }
                    break;
                case 7 :
                    // JavaScript.g:1186:4: breakStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementTail4574);
                    breakStatement153=breakStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, breakStatement153.getTree());

                    }
                    break;
                case 8 :
                    // JavaScript.g:1187:4: returnStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementTail4579);
                    returnStatement154=returnStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, returnStatement154.getTree());

                    }
                    break;
                case 9 :
                    // JavaScript.g:1188:4: withStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_withStatement_in_statementTail4584);
                    withStatement155=withStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, withStatement155.getTree());

                    }
                    break;
                case 10 :
                    // JavaScript.g:1189:4: labelledStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_labelledStatement_in_statementTail4589);
                    labelledStatement156=labelledStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, labelledStatement156.getTree());

                    }
                    break;
                case 11 :
                    // JavaScript.g:1190:4: switchStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementTail4594);
                    switchStatement157=switchStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, switchStatement157.getTree());

                    }
                    break;
                case 12 :
                    // JavaScript.g:1191:4: throwStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementTail4599);
                    throwStatement158=throwStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, throwStatement158.getTree());

                    }
                    break;
                case 13 :
                    // JavaScript.g:1192:4: tryStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_tryStatement_in_statementTail4604);
                    tryStatement159=tryStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, tryStatement159.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statementTail"

    public static class block_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // JavaScript.g:1197:1: block : lb= LBRACE ( sourceElement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* ) ;
    public final JavaScriptParser.block_return block() throws RecognitionException {
        JavaScriptParser.block_return retval = new JavaScriptParser.block_return();
        retval.start = input.LT(1);
        int block_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token lb=null;
        Token RBRACE161=null;
        JavaScriptParser.sourceElement_return sourceElement160 = null;


        MyAstNode lb_tree=null;
        MyAstNode RBRACE161_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_sourceElement=new RewriteRuleSubtreeStream(adaptor,"rule sourceElement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // JavaScript.g:1198:2: (lb= LBRACE ( sourceElement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* ) )
            // JavaScript.g:1198:4: lb= LBRACE ( sourceElement )* RBRACE
            {
            lb=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_block4619);  
            stream_LBRACE.add(lb);

            // JavaScript.g:1198:14: ( sourceElement )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=NULL && LA46_0<=BREAK)||LA46_0==CONTINUE||(LA46_0>=DELETE && LA46_0<=DO)||(LA46_0>=FOR && LA46_0<=IF)||(LA46_0>=NEW && LA46_0<=WITH)||LA46_0==LBRACE||LA46_0==LPAREN||LA46_0==LBRACK||LA46_0==SEMIC||(LA46_0>=ADD && LA46_0<=SUB)||(LA46_0>=INC && LA46_0<=DEC)||(LA46_0>=NOT && LA46_0<=INV)||(LA46_0>=Identifier && LA46_0<=StringLiteral)||LA46_0==RegularExpressionLiteral||(LA46_0>=DecimalLiteral && LA46_0<=HexIntegerLiteral)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // JavaScript.g:1198:14: sourceElement
            	    {
            	    pushFollow(FOLLOW_sourceElement_in_block4621);
            	    sourceElement160=sourceElement();

            	    state._fsp--;

            	    stream_sourceElement.add(sourceElement160.getTree());

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            RBRACE161=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_block4624);  
            stream_RBRACE.add(RBRACE161);



            // AST REWRITE
            // elements: sourceElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1199:2: -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* )
            {
                // JavaScript.g:1199:5: ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(BLOCK, lb, "BLOCK"), root_1);

                // JavaScript.g:1199:28: ( sourceElement )*
                while ( stream_sourceElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_sourceElement.nextTree());

                }
                stream_sourceElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class variableStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableStatement"
    // JavaScript.g:1206:1: variableStatement : VAR variableDeclaration ( COMMA variableDeclaration )* semic -> ^( VAR ( variableDeclaration )+ ) ;
    public final JavaScriptParser.variableStatement_return variableStatement() throws RecognitionException {
        JavaScriptParser.variableStatement_return retval = new JavaScriptParser.variableStatement_return();
        retval.start = input.LT(1);
        int variableStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token VAR162=null;
        Token COMMA164=null;
        JavaScriptParser.variableDeclaration_return variableDeclaration163 = null;

        JavaScriptParser.variableDeclaration_return variableDeclaration165 = null;

        JavaScriptParser.semic_return semic166 = null;


        MyAstNode VAR162_tree=null;
        MyAstNode COMMA164_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleSubtreeStream stream_variableDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclaration");
        RewriteRuleSubtreeStream stream_semic=new RewriteRuleSubtreeStream(adaptor,"rule semic");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // JavaScript.g:1207:2: ( VAR variableDeclaration ( COMMA variableDeclaration )* semic -> ^( VAR ( variableDeclaration )+ ) )
            // JavaScript.g:1207:4: VAR variableDeclaration ( COMMA variableDeclaration )* semic
            {
            VAR162=(Token)match(input,VAR,FOLLOW_VAR_in_variableStatement4653);  
            stream_VAR.add(VAR162);

            pushFollow(FOLLOW_variableDeclaration_in_variableStatement4655);
            variableDeclaration163=variableDeclaration();

            state._fsp--;

            stream_variableDeclaration.add(variableDeclaration163.getTree());
            // JavaScript.g:1207:28: ( COMMA variableDeclaration )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==COMMA) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // JavaScript.g:1207:30: COMMA variableDeclaration
            	    {
            	    COMMA164=(Token)match(input,COMMA,FOLLOW_COMMA_in_variableStatement4659);  
            	    stream_COMMA.add(COMMA164);

            	    pushFollow(FOLLOW_variableDeclaration_in_variableStatement4661);
            	    variableDeclaration165=variableDeclaration();

            	    state._fsp--;

            	    stream_variableDeclaration.add(variableDeclaration165.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            pushFollow(FOLLOW_semic_in_variableStatement4666);
            semic166=semic();

            state._fsp--;

            stream_semic.add(semic166.getTree());


            // AST REWRITE
            // elements: variableDeclaration, VAR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1208:2: -> ^( VAR ( variableDeclaration )+ )
            {
                // JavaScript.g:1208:5: ^( VAR ( variableDeclaration )+ )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot(stream_VAR.nextNode(), root_1);

                if ( !(stream_variableDeclaration.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_variableDeclaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_variableDeclaration.nextTree());

                }
                stream_variableDeclaration.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variableStatement"

    public static class variableDeclaration_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableDeclaration"
    // JavaScript.g:1211:1: variableDeclaration : Identifier ( ASSIGN assignmentExpression )? ;
    public final JavaScriptParser.variableDeclaration_return variableDeclaration() throws RecognitionException {
        JavaScriptParser.variableDeclaration_return retval = new JavaScriptParser.variableDeclaration_return();
        retval.start = input.LT(1);
        int variableDeclaration_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token Identifier167=null;
        Token ASSIGN168=null;
        JavaScriptParser.assignmentExpression_return assignmentExpression169 = null;


        MyAstNode Identifier167_tree=null;
        MyAstNode ASSIGN168_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // JavaScript.g:1212:2: ( Identifier ( ASSIGN assignmentExpression )? )
            // JavaScript.g:1212:4: Identifier ( ASSIGN assignmentExpression )?
            {
            root_0 = (MyAstNode)adaptor.nil();

            Identifier167=(Token)match(input,Identifier,FOLLOW_Identifier_in_variableDeclaration4689); 
            Identifier167_tree = (MyAstNode)adaptor.create(Identifier167);
            adaptor.addChild(root_0, Identifier167_tree);

            // JavaScript.g:1212:15: ( ASSIGN assignmentExpression )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==ASSIGN) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // JavaScript.g:1212:17: ASSIGN assignmentExpression
                    {
                    ASSIGN168=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclaration4693); 
                    ASSIGN168_tree = (MyAstNode)adaptor.create(ASSIGN168);
                    root_0 = (MyAstNode)adaptor.becomeRoot(ASSIGN168_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpression_in_variableDeclaration4696);
                    assignmentExpression169=assignmentExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpression169.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variableDeclaration"

    public static class variableDeclarationNoIn_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableDeclarationNoIn"
    // JavaScript.g:1215:1: variableDeclarationNoIn : Identifier ( ASSIGN assignmentExpressionNoIn )? ;
    public final JavaScriptParser.variableDeclarationNoIn_return variableDeclarationNoIn() throws RecognitionException {
        JavaScriptParser.variableDeclarationNoIn_return retval = new JavaScriptParser.variableDeclarationNoIn_return();
        retval.start = input.LT(1);
        int variableDeclarationNoIn_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token Identifier170=null;
        Token ASSIGN171=null;
        JavaScriptParser.assignmentExpressionNoIn_return assignmentExpressionNoIn172 = null;


        MyAstNode Identifier170_tree=null;
        MyAstNode ASSIGN171_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // JavaScript.g:1216:2: ( Identifier ( ASSIGN assignmentExpressionNoIn )? )
            // JavaScript.g:1216:4: Identifier ( ASSIGN assignmentExpressionNoIn )?
            {
            root_0 = (MyAstNode)adaptor.nil();

            Identifier170=(Token)match(input,Identifier,FOLLOW_Identifier_in_variableDeclarationNoIn4711); 
            Identifier170_tree = (MyAstNode)adaptor.create(Identifier170);
            adaptor.addChild(root_0, Identifier170_tree);

            // JavaScript.g:1216:15: ( ASSIGN assignmentExpressionNoIn )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==ASSIGN) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // JavaScript.g:1216:17: ASSIGN assignmentExpressionNoIn
                    {
                    ASSIGN171=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclarationNoIn4715); 
                    ASSIGN171_tree = (MyAstNode)adaptor.create(ASSIGN171);
                    root_0 = (MyAstNode)adaptor.becomeRoot(ASSIGN171_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_variableDeclarationNoIn4718);
                    assignmentExpressionNoIn172=assignmentExpressionNoIn();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn172.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variableDeclarationNoIn"

    public static class emptyStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "emptyStatement"
    // JavaScript.g:1223:1: emptyStatement : SEMIC ;
    public final JavaScriptParser.emptyStatement_return emptyStatement() throws RecognitionException {
        JavaScriptParser.emptyStatement_return retval = new JavaScriptParser.emptyStatement_return();
        retval.start = input.LT(1);
        int emptyStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token SEMIC173=null;

        MyAstNode SEMIC173_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // JavaScript.g:1224:2: ( SEMIC )
            // JavaScript.g:1224:4: SEMIC
            {
            root_0 = (MyAstNode)adaptor.nil();

            SEMIC173=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_emptyStatement4737); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "emptyStatement"

    public static class expressionStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expressionStatement"
    // JavaScript.g:1237:1: expressionStatement : expression semic ;
    public final JavaScriptParser.expressionStatement_return expressionStatement() throws RecognitionException {
        JavaScriptParser.expressionStatement_return retval = new JavaScriptParser.expressionStatement_return();
        retval.start = input.LT(1);
        int expressionStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.expression_return expression174 = null;

        JavaScriptParser.semic_return semic175 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // JavaScript.g:1238:2: ( expression semic )
            // JavaScript.g:1238:4: expression semic
            {
            root_0 = (MyAstNode)adaptor.nil();

            pushFollow(FOLLOW_expression_in_expressionStatement4756);
            expression174=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression174.getTree());
            pushFollow(FOLLOW_semic_in_expressionStatement4758);
            semic175=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expressionStatement"

    public static class ifStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // JavaScript.g:1245:1: ifStatement : IF LPAREN expression RPAREN statement ({...}? ELSE statement )? -> ^( IF expression ( statement )+ ) ;
    public final JavaScriptParser.ifStatement_return ifStatement() throws RecognitionException {
        JavaScriptParser.ifStatement_return retval = new JavaScriptParser.ifStatement_return();
        retval.start = input.LT(1);
        int ifStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token IF176=null;
        Token LPAREN177=null;
        Token RPAREN179=null;
        Token ELSE181=null;
        JavaScriptParser.expression_return expression178 = null;

        JavaScriptParser.statement_return statement180 = null;

        JavaScriptParser.statement_return statement182 = null;


        MyAstNode IF176_tree=null;
        MyAstNode LPAREN177_tree=null;
        MyAstNode RPAREN179_tree=null;
        MyAstNode ELSE181_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // JavaScript.g:1247:2: ( IF LPAREN expression RPAREN statement ({...}? ELSE statement )? -> ^( IF expression ( statement )+ ) )
            // JavaScript.g:1247:4: IF LPAREN expression RPAREN statement ({...}? ELSE statement )?
            {
            IF176=(Token)match(input,IF,FOLLOW_IF_in_ifStatement4776);  
            stream_IF.add(IF176);

            LPAREN177=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_ifStatement4778);  
            stream_LPAREN.add(LPAREN177);

            pushFollow(FOLLOW_expression_in_ifStatement4780);
            expression178=expression();

            state._fsp--;

            stream_expression.add(expression178.getTree());
            RPAREN179=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_ifStatement4782);  
            stream_RPAREN.add(RPAREN179);

            pushFollow(FOLLOW_statement_in_ifStatement4784);
            statement180=statement();

            state._fsp--;

            stream_statement.add(statement180.getTree());
            // JavaScript.g:1247:42: ({...}? ELSE statement )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==ELSE) ) {
                int LA50_1 = input.LA(2);

                if ( (( input.LA(1) == ELSE )) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // JavaScript.g:1247:44: {...}? ELSE statement
                    {
                    if ( !(( input.LA(1) == ELSE )) ) {
                        throw new FailedPredicateException(input, "ifStatement", " input.LA(1) == ELSE ");
                    }
                    ELSE181=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStatement4790);  
                    stream_ELSE.add(ELSE181);

                    pushFollow(FOLLOW_statement_in_ifStatement4792);
                    statement182=statement();

                    state._fsp--;

                    stream_statement.add(statement182.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: IF, statement, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1248:2: -> ^( IF expression ( statement )+ )
            {
                // JavaScript.g:1248:5: ^( IF expression ( statement )+ )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifStatement"

    public static class iterationStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iterationStatement"
    // JavaScript.g:1255:1: iterationStatement : ( doStatement | whileStatement | forStatement );
    public final JavaScriptParser.iterationStatement_return iterationStatement() throws RecognitionException {
        JavaScriptParser.iterationStatement_return retval = new JavaScriptParser.iterationStatement_return();
        retval.start = input.LT(1);
        int iterationStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.doStatement_return doStatement183 = null;

        JavaScriptParser.whileStatement_return whileStatement184 = null;

        JavaScriptParser.forStatement_return forStatement185 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // JavaScript.g:1256:2: ( doStatement | whileStatement | forStatement )
            int alt51=3;
            switch ( input.LA(1) ) {
            case DO:
                {
                alt51=1;
                }
                break;
            case WHILE:
                {
                alt51=2;
                }
                break;
            case FOR:
                {
                alt51=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // JavaScript.g:1256:4: doStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_doStatement_in_iterationStatement4825);
                    doStatement183=doStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, doStatement183.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:1257:4: whileStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_iterationStatement4830);
                    whileStatement184=whileStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, whileStatement184.getTree());

                    }
                    break;
                case 3 :
                    // JavaScript.g:1258:4: forStatement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_iterationStatement4835);
                    forStatement185=forStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, forStatement185.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "iterationStatement"

    public static class doStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "doStatement"
    // JavaScript.g:1261:1: doStatement : DO statement WHILE LPAREN expression RPAREN semic -> ^( DO statement expression ) ;
    public final JavaScriptParser.doStatement_return doStatement() throws RecognitionException {
        JavaScriptParser.doStatement_return retval = new JavaScriptParser.doStatement_return();
        retval.start = input.LT(1);
        int doStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token DO186=null;
        Token WHILE188=null;
        Token LPAREN189=null;
        Token RPAREN191=null;
        JavaScriptParser.statement_return statement187 = null;

        JavaScriptParser.expression_return expression190 = null;

        JavaScriptParser.semic_return semic192 = null;


        MyAstNode DO186_tree=null;
        MyAstNode WHILE188_tree=null;
        MyAstNode LPAREN189_tree=null;
        MyAstNode RPAREN191_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_semic=new RewriteRuleSubtreeStream(adaptor,"rule semic");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // JavaScript.g:1262:2: ( DO statement WHILE LPAREN expression RPAREN semic -> ^( DO statement expression ) )
            // JavaScript.g:1262:4: DO statement WHILE LPAREN expression RPAREN semic
            {
            DO186=(Token)match(input,DO,FOLLOW_DO_in_doStatement4847);  
            stream_DO.add(DO186);

            pushFollow(FOLLOW_statement_in_doStatement4849);
            statement187=statement();

            state._fsp--;

            stream_statement.add(statement187.getTree());
            WHILE188=(Token)match(input,WHILE,FOLLOW_WHILE_in_doStatement4851);  
            stream_WHILE.add(WHILE188);

            LPAREN189=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_doStatement4853);  
            stream_LPAREN.add(LPAREN189);

            pushFollow(FOLLOW_expression_in_doStatement4855);
            expression190=expression();

            state._fsp--;

            stream_expression.add(expression190.getTree());
            RPAREN191=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_doStatement4857);  
            stream_RPAREN.add(RPAREN191);

            pushFollow(FOLLOW_semic_in_doStatement4859);
            semic192=semic();

            state._fsp--;

            stream_semic.add(semic192.getTree());


            // AST REWRITE
            // elements: statement, expression, DO
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1263:2: -> ^( DO statement expression )
            {
                // JavaScript.g:1263:5: ^( DO statement expression )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot(stream_DO.nextNode(), root_1);

                adaptor.addChild(root_1, stream_statement.nextTree());
                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "doStatement"

    public static class whileStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whileStatement"
    // JavaScript.g:1266:1: whileStatement : WHILE LPAREN expression RPAREN statement ;
    public final JavaScriptParser.whileStatement_return whileStatement() throws RecognitionException {
        JavaScriptParser.whileStatement_return retval = new JavaScriptParser.whileStatement_return();
        retval.start = input.LT(1);
        int whileStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token WHILE193=null;
        Token LPAREN194=null;
        Token RPAREN196=null;
        JavaScriptParser.expression_return expression195 = null;

        JavaScriptParser.statement_return statement197 = null;


        MyAstNode WHILE193_tree=null;
        MyAstNode LPAREN194_tree=null;
        MyAstNode RPAREN196_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // JavaScript.g:1267:2: ( WHILE LPAREN expression RPAREN statement )
            // JavaScript.g:1267:4: WHILE LPAREN expression RPAREN statement
            {
            root_0 = (MyAstNode)adaptor.nil();

            WHILE193=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStatement4884); 
            WHILE193_tree = (MyAstNode)adaptor.create(WHILE193);
            root_0 = (MyAstNode)adaptor.becomeRoot(WHILE193_tree, root_0);

            LPAREN194=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_whileStatement4887); 
            pushFollow(FOLLOW_expression_in_whileStatement4890);
            expression195=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression195.getTree());
            RPAREN196=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_whileStatement4892); 
            pushFollow(FOLLOW_statement_in_whileStatement4895);
            statement197=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement197.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "whileStatement"

    public static class forStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forStatement"
    // JavaScript.g:1311:1: forStatement : FOR LPAREN forControl RPAREN statement ;
    public final JavaScriptParser.forStatement_return forStatement() throws RecognitionException {
        JavaScriptParser.forStatement_return retval = new JavaScriptParser.forStatement_return();
        retval.start = input.LT(1);
        int forStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token FOR198=null;
        Token LPAREN199=null;
        Token RPAREN201=null;
        JavaScriptParser.forControl_return forControl200 = null;

        JavaScriptParser.statement_return statement202 = null;


        MyAstNode FOR198_tree=null;
        MyAstNode LPAREN199_tree=null;
        MyAstNode RPAREN201_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // JavaScript.g:1312:2: ( FOR LPAREN forControl RPAREN statement )
            // JavaScript.g:1312:4: FOR LPAREN forControl RPAREN statement
            {
            root_0 = (MyAstNode)adaptor.nil();

            FOR198=(Token)match(input,FOR,FOLLOW_FOR_in_forStatement4908); 
            FOR198_tree = (MyAstNode)adaptor.create(FOR198);
            root_0 = (MyAstNode)adaptor.becomeRoot(FOR198_tree, root_0);

            LPAREN199=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_forStatement4911); 
            pushFollow(FOLLOW_forControl_in_forStatement4914);
            forControl200=forControl();

            state._fsp--;

            adaptor.addChild(root_0, forControl200.getTree());
            RPAREN201=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_forStatement4916); 
            pushFollow(FOLLOW_statement_in_forStatement4919);
            statement202=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement202.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forStatement"

    public static class forControl_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forControl"
    // JavaScript.g:1315:1: forControl : ( forControlVar | forControlExpression | forControlSemic );
    public final JavaScriptParser.forControl_return forControl() throws RecognitionException {
        JavaScriptParser.forControl_return retval = new JavaScriptParser.forControl_return();
        retval.start = input.LT(1);
        int forControl_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.forControlVar_return forControlVar203 = null;

        JavaScriptParser.forControlExpression_return forControlExpression204 = null;

        JavaScriptParser.forControlSemic_return forControlSemic205 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // JavaScript.g:1316:2: ( forControlVar | forControlExpression | forControlSemic )
            int alt52=3;
            switch ( input.LA(1) ) {
            case VAR:
                {
                alt52=1;
                }
                break;
            case NULL:
            case TRUE:
            case FALSE:
            case DELETE:
            case FUNCTION:
            case NEW:
            case THIS:
            case TYPEOF:
            case VOID:
            case LBRACE:
            case LPAREN:
            case LBRACK:
            case ADD:
            case SUB:
            case INC:
            case DEC:
            case NOT:
            case INV:
            case Identifier:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt52=2;
                }
                break;
            case SEMIC:
                {
                alt52=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // JavaScript.g:1316:4: forControlVar
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_forControlVar_in_forControl4930);
                    forControlVar203=forControlVar();

                    state._fsp--;

                    adaptor.addChild(root_0, forControlVar203.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:1317:4: forControlExpression
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_forControlExpression_in_forControl4935);
                    forControlExpression204=forControlExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, forControlExpression204.getTree());

                    }
                    break;
                case 3 :
                    // JavaScript.g:1318:4: forControlSemic
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_forControlSemic_in_forControl4940);
                    forControlSemic205=forControlSemic();

                    state._fsp--;

                    adaptor.addChild(root_0, forControlSemic205.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forControl"

    public static class forControlVar_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forControlVar"
    // JavaScript.g:1321:1: forControlVar : VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ) ) ;
    public final JavaScriptParser.forControlVar_return forControlVar() throws RecognitionException {
        JavaScriptParser.forControlVar_return retval = new JavaScriptParser.forControlVar_return();
        retval.start = input.LT(1);
        int forControlVar_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token VAR206=null;
        Token IN208=null;
        Token COMMA210=null;
        Token SEMIC212=null;
        Token SEMIC213=null;
        JavaScriptParser.expression_return ex1 = null;

        JavaScriptParser.expression_return ex2 = null;

        JavaScriptParser.variableDeclarationNoIn_return variableDeclarationNoIn207 = null;

        JavaScriptParser.expression_return expression209 = null;

        JavaScriptParser.variableDeclarationNoIn_return variableDeclarationNoIn211 = null;


        MyAstNode VAR206_tree=null;
        MyAstNode IN208_tree=null;
        MyAstNode COMMA210_tree=null;
        MyAstNode SEMIC212_tree=null;
        MyAstNode SEMIC213_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleSubtreeStream stream_variableDeclarationNoIn=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclarationNoIn");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // JavaScript.g:1322:2: ( VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ) ) )
            // JavaScript.g:1322:4: VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ) )
            {
            VAR206=(Token)match(input,VAR,FOLLOW_VAR_in_forControlVar4951);  
            stream_VAR.add(VAR206);

            pushFollow(FOLLOW_variableDeclarationNoIn_in_forControlVar4953);
            variableDeclarationNoIn207=variableDeclarationNoIn();

            state._fsp--;

            stream_variableDeclarationNoIn.add(variableDeclarationNoIn207.getTree());
            // JavaScript.g:1323:2: ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==IN) ) {
                alt56=1;
            }
            else if ( ((LA56_0>=SEMIC && LA56_0<=COMMA)) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // JavaScript.g:1324:3: ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) )
                    {
                    // JavaScript.g:1324:3: ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) )
                    // JavaScript.g:1325:4: IN expression
                    {
                    IN208=(Token)match(input,IN,FOLLOW_IN_in_forControlVar4965);  
                    stream_IN.add(IN208);

                    pushFollow(FOLLOW_expression_in_forControlVar4967);
                    expression209=expression();

                    state._fsp--;

                    stream_expression.add(expression209.getTree());


                    // AST REWRITE
                    // elements: expression, VAR, variableDeclarationNoIn
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (MyAstNode)adaptor.nil();
                    // 1326:4: -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) )
                    {
                        // JavaScript.g:1326:7: ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) )
                        {
                        MyAstNode root_1 = (MyAstNode)adaptor.nil();
                        root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(FORITER, "FORITER"), root_1);

                        // JavaScript.g:1326:18: ^( VAR variableDeclarationNoIn )
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot(stream_VAR.nextNode(), root_2);

                        adaptor.addChild(root_2, stream_variableDeclarationNoIn.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // JavaScript.g:1326:51: ^( EXPR expression )
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;
                case 2 :
                    // JavaScript.g:1329:3: ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) )
                    {
                    // JavaScript.g:1329:3: ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) )
                    // JavaScript.g:1330:4: ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )?
                    {
                    // JavaScript.g:1330:4: ( COMMA variableDeclarationNoIn )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==COMMA) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // JavaScript.g:1330:6: COMMA variableDeclarationNoIn
                    	    {
                    	    COMMA210=(Token)match(input,COMMA,FOLLOW_COMMA_in_forControlVar5013);  
                    	    stream_COMMA.add(COMMA210);

                    	    pushFollow(FOLLOW_variableDeclarationNoIn_in_forControlVar5015);
                    	    variableDeclarationNoIn211=variableDeclarationNoIn();

                    	    state._fsp--;

                    	    stream_variableDeclarationNoIn.add(variableDeclarationNoIn211.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    SEMIC212=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlVar5020);  
                    stream_SEMIC.add(SEMIC212);

                    // JavaScript.g:1330:48: (ex1= expression )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( ((LA54_0>=NULL && LA54_0<=FALSE)||LA54_0==DELETE||LA54_0==FUNCTION||LA54_0==NEW||LA54_0==THIS||LA54_0==TYPEOF||LA54_0==VOID||LA54_0==LBRACE||LA54_0==LPAREN||LA54_0==LBRACK||(LA54_0>=ADD && LA54_0<=SUB)||(LA54_0>=INC && LA54_0<=DEC)||(LA54_0>=NOT && LA54_0<=INV)||(LA54_0>=Identifier && LA54_0<=StringLiteral)||LA54_0==RegularExpressionLiteral||(LA54_0>=DecimalLiteral && LA54_0<=HexIntegerLiteral)) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // JavaScript.g:1330:48: ex1= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlVar5024);
                            ex1=expression();

                            state._fsp--;

                            stream_expression.add(ex1.getTree());

                            }
                            break;

                    }

                    SEMIC213=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlVar5027);  
                    stream_SEMIC.add(SEMIC213);

                    // JavaScript.g:1330:70: (ex2= expression )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( ((LA55_0>=NULL && LA55_0<=FALSE)||LA55_0==DELETE||LA55_0==FUNCTION||LA55_0==NEW||LA55_0==THIS||LA55_0==TYPEOF||LA55_0==VOID||LA55_0==LBRACE||LA55_0==LPAREN||LA55_0==LBRACK||(LA55_0>=ADD && LA55_0<=SUB)||(LA55_0>=INC && LA55_0<=DEC)||(LA55_0>=NOT && LA55_0<=INV)||(LA55_0>=Identifier && LA55_0<=StringLiteral)||LA55_0==RegularExpressionLiteral||(LA55_0>=DecimalLiteral && LA55_0<=HexIntegerLiteral)) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // JavaScript.g:1330:70: ex2= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlVar5031);
                            ex2=expression();

                            state._fsp--;

                            stream_expression.add(ex2.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: ex1, variableDeclarationNoIn, ex2, VAR
                    // token labels: 
                    // rule labels: ex2, retval, ex1
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

                    root_0 = (MyAstNode)adaptor.nil();
                    // 1331:4: -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) )
                    {
                        // JavaScript.g:1331:7: ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) )
                        {
                        MyAstNode root_1 = (MyAstNode)adaptor.nil();
                        root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(FORSTEP, "FORSTEP"), root_1);

                        // JavaScript.g:1331:18: ^( VAR ( variableDeclarationNoIn )+ )
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot(stream_VAR.nextNode(), root_2);

                        if ( !(stream_variableDeclarationNoIn.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_variableDeclarationNoIn.hasNext() ) {
                            adaptor.addChild(root_2, stream_variableDeclarationNoIn.nextTree());

                        }
                        stream_variableDeclarationNoIn.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // JavaScript.g:1331:52: ^( EXPR ( $ex1)? )
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                        // JavaScript.g:1331:60: ( $ex1)?
                        if ( stream_ex1.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex1.nextTree());

                        }
                        stream_ex1.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // JavaScript.g:1331:68: ^( EXPR ( $ex2)? )
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                        // JavaScript.g:1331:76: ( $ex2)?
                        if ( stream_ex2.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex2.nextTree());

                        }
                        stream_ex2.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forControlVar"

    public static class forControlExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forControlExpression"
    // JavaScript.g:1336:1: forControlExpression : ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) ) ) ;
    public final JavaScriptParser.forControlExpression_return forControlExpression() throws RecognitionException {
        JavaScriptParser.forControlExpression_return retval = new JavaScriptParser.forControlExpression_return();
        retval.start = input.LT(1);
        int forControlExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token IN214=null;
        Token SEMIC215=null;
        Token SEMIC216=null;
        JavaScriptParser.expressionNoIn_return ex1 = null;

        JavaScriptParser.expression_return ex2 = null;

        JavaScriptParser.expression_return ex3 = null;


        MyAstNode IN214_tree=null;
        MyAstNode SEMIC215_tree=null;
        MyAstNode SEMIC216_tree=null;
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleSubtreeStream stream_expressionNoIn=new RewriteRuleSubtreeStream(adaptor,"rule expressionNoIn");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

        	Object[] isLhs = new Object[1];

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // JavaScript.g:1341:2: (ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) ) ) )
            // JavaScript.g:1341:4: ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) ) )
            {
            pushFollow(FOLLOW_expressionNoIn_in_forControlExpression5097);
            ex1=expressionNoIn();

            state._fsp--;

            stream_expressionNoIn.add(ex1.getTree());
            // JavaScript.g:1342:2: ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==IN) ) {
                alt59=1;
            }
            else if ( (LA59_0==SEMIC) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // JavaScript.g:1343:3: {...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) )
                    {
                    if ( !(( isLeftHandSideIn(ex1, isLhs) )) ) {
                        throw new FailedPredicateException(input, "forControlExpression", " isLeftHandSideIn(ex1, isLhs) ");
                    }
                    // JavaScript.g:1343:37: ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) )
                    // JavaScript.g:1344:4: IN ex2= expression
                    {
                    IN214=(Token)match(input,IN,FOLLOW_IN_in_forControlExpression5112);  
                    stream_IN.add(IN214);

                    pushFollow(FOLLOW_expression_in_forControlExpression5116);
                    ex2=expression();

                    state._fsp--;

                    stream_expression.add(ex2.getTree());


                    // AST REWRITE
                    // elements: ex2, ex1
                    // token labels: 
                    // rule labels: ex2, retval, ex1
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

                    root_0 = (MyAstNode)adaptor.nil();
                    // 1345:4: -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) )
                    {
                        // JavaScript.g:1345:7: ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) )
                        {
                        MyAstNode root_1 = (MyAstNode)adaptor.nil();
                        root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(FORITER, "FORITER"), root_1);

                        // JavaScript.g:1345:18: ^( EXPR $ex1)
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex1.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // JavaScript.g:1345:33: ^( EXPR $ex2)
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex2.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;
                case 2 :
                    // JavaScript.g:1348:3: ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) )
                    {
                    // JavaScript.g:1348:3: ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) )
                    // JavaScript.g:1349:4: SEMIC (ex2= expression )? SEMIC (ex3= expression )?
                    {
                    SEMIC215=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlExpression5162);  
                    stream_SEMIC.add(SEMIC215);

                    // JavaScript.g:1349:13: (ex2= expression )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( ((LA57_0>=NULL && LA57_0<=FALSE)||LA57_0==DELETE||LA57_0==FUNCTION||LA57_0==NEW||LA57_0==THIS||LA57_0==TYPEOF||LA57_0==VOID||LA57_0==LBRACE||LA57_0==LPAREN||LA57_0==LBRACK||(LA57_0>=ADD && LA57_0<=SUB)||(LA57_0>=INC && LA57_0<=DEC)||(LA57_0>=NOT && LA57_0<=INV)||(LA57_0>=Identifier && LA57_0<=StringLiteral)||LA57_0==RegularExpressionLiteral||(LA57_0>=DecimalLiteral && LA57_0<=HexIntegerLiteral)) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // JavaScript.g:1349:13: ex2= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlExpression5166);
                            ex2=expression();

                            state._fsp--;

                            stream_expression.add(ex2.getTree());

                            }
                            break;

                    }

                    SEMIC216=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlExpression5169);  
                    stream_SEMIC.add(SEMIC216);

                    // JavaScript.g:1349:35: (ex3= expression )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( ((LA58_0>=NULL && LA58_0<=FALSE)||LA58_0==DELETE||LA58_0==FUNCTION||LA58_0==NEW||LA58_0==THIS||LA58_0==TYPEOF||LA58_0==VOID||LA58_0==LBRACE||LA58_0==LPAREN||LA58_0==LBRACK||(LA58_0>=ADD && LA58_0<=SUB)||(LA58_0>=INC && LA58_0<=DEC)||(LA58_0>=NOT && LA58_0<=INV)||(LA58_0>=Identifier && LA58_0<=StringLiteral)||LA58_0==RegularExpressionLiteral||(LA58_0>=DecimalLiteral && LA58_0<=HexIntegerLiteral)) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // JavaScript.g:1349:35: ex3= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlExpression5173);
                            ex3=expression();

                            state._fsp--;

                            stream_expression.add(ex3.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: ex1, ex2, ex3
                    // token labels: 
                    // rule labels: ex2, retval, ex1, ex3
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);
                    RewriteRuleSubtreeStream stream_ex3=new RewriteRuleSubtreeStream(adaptor,"token ex3",ex3!=null?ex3.tree:null);

                    root_0 = (MyAstNode)adaptor.nil();
                    // 1350:4: -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) )
                    {
                        // JavaScript.g:1350:7: ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) )
                        {
                        MyAstNode root_1 = (MyAstNode)adaptor.nil();
                        root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(FORSTEP, "FORSTEP"), root_1);

                        // JavaScript.g:1350:18: ^( EXPR $ex1)
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex1.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // JavaScript.g:1350:33: ^( EXPR ( $ex2)? )
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                        // JavaScript.g:1350:41: ( $ex2)?
                        if ( stream_ex2.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex2.nextTree());

                        }
                        stream_ex2.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // JavaScript.g:1350:49: ^( EXPR ( $ex3)? )
                        {
                        MyAstNode root_2 = (MyAstNode)adaptor.nil();
                        root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                        // JavaScript.g:1350:57: ( $ex3)?
                        if ( stream_ex3.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex3.nextTree());

                        }
                        stream_ex3.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forControlExpression"

    public static class forControlSemic_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forControlSemic"
    // JavaScript.g:1355:1: forControlSemic : SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( EXPR ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ;
    public final JavaScriptParser.forControlSemic_return forControlSemic() throws RecognitionException {
        JavaScriptParser.forControlSemic_return retval = new JavaScriptParser.forControlSemic_return();
        retval.start = input.LT(1);
        int forControlSemic_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token SEMIC217=null;
        Token SEMIC218=null;
        JavaScriptParser.expression_return ex1 = null;

        JavaScriptParser.expression_return ex2 = null;


        MyAstNode SEMIC217_tree=null;
        MyAstNode SEMIC218_tree=null;
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // JavaScript.g:1356:2: ( SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( EXPR ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) )
            // JavaScript.g:1356:4: SEMIC (ex1= expression )? SEMIC (ex2= expression )?
            {
            SEMIC217=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlSemic5232);  
            stream_SEMIC.add(SEMIC217);

            // JavaScript.g:1356:13: (ex1= expression )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=NULL && LA60_0<=FALSE)||LA60_0==DELETE||LA60_0==FUNCTION||LA60_0==NEW||LA60_0==THIS||LA60_0==TYPEOF||LA60_0==VOID||LA60_0==LBRACE||LA60_0==LPAREN||LA60_0==LBRACK||(LA60_0>=ADD && LA60_0<=SUB)||(LA60_0>=INC && LA60_0<=DEC)||(LA60_0>=NOT && LA60_0<=INV)||(LA60_0>=Identifier && LA60_0<=StringLiteral)||LA60_0==RegularExpressionLiteral||(LA60_0>=DecimalLiteral && LA60_0<=HexIntegerLiteral)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // JavaScript.g:1356:13: ex1= expression
                    {
                    pushFollow(FOLLOW_expression_in_forControlSemic5236);
                    ex1=expression();

                    state._fsp--;

                    stream_expression.add(ex1.getTree());

                    }
                    break;

            }

            SEMIC218=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlSemic5239);  
            stream_SEMIC.add(SEMIC218);

            // JavaScript.g:1356:35: (ex2= expression )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=NULL && LA61_0<=FALSE)||LA61_0==DELETE||LA61_0==FUNCTION||LA61_0==NEW||LA61_0==THIS||LA61_0==TYPEOF||LA61_0==VOID||LA61_0==LBRACE||LA61_0==LPAREN||LA61_0==LBRACK||(LA61_0>=ADD && LA61_0<=SUB)||(LA61_0>=INC && LA61_0<=DEC)||(LA61_0>=NOT && LA61_0<=INV)||(LA61_0>=Identifier && LA61_0<=StringLiteral)||LA61_0==RegularExpressionLiteral||(LA61_0>=DecimalLiteral && LA61_0<=HexIntegerLiteral)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // JavaScript.g:1356:35: ex2= expression
                    {
                    pushFollow(FOLLOW_expression_in_forControlSemic5243);
                    ex2=expression();

                    state._fsp--;

                    stream_expression.add(ex2.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: ex2, ex1
            // token labels: 
            // rule labels: ex2, retval, ex1
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1357:2: -> ^( FORSTEP ^( EXPR ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) )
            {
                // JavaScript.g:1357:5: ^( FORSTEP ^( EXPR ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(FORSTEP, "FORSTEP"), root_1);

                // JavaScript.g:1357:16: ^( EXPR )
                {
                MyAstNode root_2 = (MyAstNode)adaptor.nil();
                root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // JavaScript.g:1357:26: ^( EXPR ( $ex1)? )
                {
                MyAstNode root_2 = (MyAstNode)adaptor.nil();
                root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                // JavaScript.g:1357:34: ( $ex1)?
                if ( stream_ex1.hasNext() ) {
                    adaptor.addChild(root_2, stream_ex1.nextTree());

                }
                stream_ex1.reset();

                adaptor.addChild(root_1, root_2);
                }
                // JavaScript.g:1357:42: ^( EXPR ( $ex2)? )
                {
                MyAstNode root_2 = (MyAstNode)adaptor.nil();
                root_2 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(EXPR, "EXPR"), root_2);

                // JavaScript.g:1357:50: ( $ex2)?
                if ( stream_ex2.hasNext() ) {
                    adaptor.addChild(root_2, stream_ex2.nextTree());

                }
                stream_ex2.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forControlSemic"

    public static class continueStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "continueStatement"
    // JavaScript.g:1369:1: continueStatement : CONTINUE ( Identifier )? semic ;
    public final JavaScriptParser.continueStatement_return continueStatement() throws RecognitionException {
        JavaScriptParser.continueStatement_return retval = new JavaScriptParser.continueStatement_return();
        retval.start = input.LT(1);
        int continueStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token CONTINUE219=null;
        Token Identifier220=null;
        JavaScriptParser.semic_return semic221 = null;


        MyAstNode CONTINUE219_tree=null;
        MyAstNode Identifier220_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // JavaScript.g:1370:2: ( CONTINUE ( Identifier )? semic )
            // JavaScript.g:1370:4: CONTINUE ( Identifier )? semic
            {
            root_0 = (MyAstNode)adaptor.nil();

            CONTINUE219=(Token)match(input,CONTINUE,FOLLOW_CONTINUE_in_continueStatement5297); 
            CONTINUE219_tree = (MyAstNode)adaptor.create(CONTINUE219);
            root_0 = (MyAstNode)adaptor.becomeRoot(CONTINUE219_tree, root_0);

             if (input.LA(1) == Identifier) promoteEOL(null); 
            // JavaScript.g:1370:67: ( Identifier )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==Identifier) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // JavaScript.g:1370:67: Identifier
                    {
                    Identifier220=(Token)match(input,Identifier,FOLLOW_Identifier_in_continueStatement5302); 
                    Identifier220_tree = (MyAstNode)adaptor.create(Identifier220);
                    adaptor.addChild(root_0, Identifier220_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_continueStatement5305);
            semic221=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "continueStatement"

    public static class breakStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "breakStatement"
    // JavaScript.g:1382:1: breakStatement : BREAK ( Identifier )? semic ;
    public final JavaScriptParser.breakStatement_return breakStatement() throws RecognitionException {
        JavaScriptParser.breakStatement_return retval = new JavaScriptParser.breakStatement_return();
        retval.start = input.LT(1);
        int breakStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token BREAK222=null;
        Token Identifier223=null;
        JavaScriptParser.semic_return semic224 = null;


        MyAstNode BREAK222_tree=null;
        MyAstNode Identifier223_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // JavaScript.g:1383:2: ( BREAK ( Identifier )? semic )
            // JavaScript.g:1383:4: BREAK ( Identifier )? semic
            {
            root_0 = (MyAstNode)adaptor.nil();

            BREAK222=(Token)match(input,BREAK,FOLLOW_BREAK_in_breakStatement5324); 
            BREAK222_tree = (MyAstNode)adaptor.create(BREAK222);
            root_0 = (MyAstNode)adaptor.becomeRoot(BREAK222_tree, root_0);

             if (input.LA(1) == Identifier) promoteEOL(null); 
            // JavaScript.g:1383:64: ( Identifier )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==Identifier) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // JavaScript.g:1383:64: Identifier
                    {
                    Identifier223=(Token)match(input,Identifier,FOLLOW_Identifier_in_breakStatement5329); 
                    Identifier223_tree = (MyAstNode)adaptor.create(Identifier223);
                    adaptor.addChild(root_0, Identifier223_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_breakStatement5332);
            semic224=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "breakStatement"

    public static class returnStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "returnStatement"
    // JavaScript.g:1403:1: returnStatement : RETURN ( expression )? semic ;
    public final JavaScriptParser.returnStatement_return returnStatement() throws RecognitionException {
        JavaScriptParser.returnStatement_return retval = new JavaScriptParser.returnStatement_return();
        retval.start = input.LT(1);
        int returnStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token RETURN225=null;
        JavaScriptParser.expression_return expression226 = null;

        JavaScriptParser.semic_return semic227 = null;


        MyAstNode RETURN225_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // JavaScript.g:1404:2: ( RETURN ( expression )? semic )
            // JavaScript.g:1404:4: RETURN ( expression )? semic
            {
            root_0 = (MyAstNode)adaptor.nil();

            RETURN225=(Token)match(input,RETURN,FOLLOW_RETURN_in_returnStatement5351); 
            RETURN225_tree = (MyAstNode)adaptor.create(RETURN225);
            root_0 = (MyAstNode)adaptor.becomeRoot(RETURN225_tree, root_0);

             promoteEOL(null); 
            // JavaScript.g:1404:34: ( expression )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=NULL && LA64_0<=FALSE)||LA64_0==DELETE||LA64_0==FUNCTION||LA64_0==NEW||LA64_0==THIS||LA64_0==TYPEOF||LA64_0==VOID||LA64_0==LBRACE||LA64_0==LPAREN||LA64_0==LBRACK||(LA64_0>=ADD && LA64_0<=SUB)||(LA64_0>=INC && LA64_0<=DEC)||(LA64_0>=NOT && LA64_0<=INV)||(LA64_0>=Identifier && LA64_0<=StringLiteral)||LA64_0==RegularExpressionLiteral||(LA64_0>=DecimalLiteral && LA64_0<=HexIntegerLiteral)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // JavaScript.g:1404:34: expression
                    {
                    pushFollow(FOLLOW_expression_in_returnStatement5356);
                    expression226=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression226.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_returnStatement5359);
            semic227=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "returnStatement"

    public static class withStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "withStatement"
    // JavaScript.g:1411:1: withStatement : WITH LPAREN expression RPAREN statement ;
    public final JavaScriptParser.withStatement_return withStatement() throws RecognitionException {
        JavaScriptParser.withStatement_return retval = new JavaScriptParser.withStatement_return();
        retval.start = input.LT(1);
        int withStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token WITH228=null;
        Token LPAREN229=null;
        Token RPAREN231=null;
        JavaScriptParser.expression_return expression230 = null;

        JavaScriptParser.statement_return statement232 = null;


        MyAstNode WITH228_tree=null;
        MyAstNode LPAREN229_tree=null;
        MyAstNode RPAREN231_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // JavaScript.g:1412:2: ( WITH LPAREN expression RPAREN statement )
            // JavaScript.g:1412:4: WITH LPAREN expression RPAREN statement
            {
            root_0 = (MyAstNode)adaptor.nil();

            WITH228=(Token)match(input,WITH,FOLLOW_WITH_in_withStatement5376); 
            WITH228_tree = (MyAstNode)adaptor.create(WITH228);
            root_0 = (MyAstNode)adaptor.becomeRoot(WITH228_tree, root_0);

            LPAREN229=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_withStatement5379); 
            pushFollow(FOLLOW_expression_in_withStatement5382);
            expression230=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression230.getTree());
            RPAREN231=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_withStatement5384); 
            pushFollow(FOLLOW_statement_in_withStatement5387);
            statement232=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement232.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "withStatement"

    public static class switchStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "switchStatement"
    // JavaScript.g:1419:1: switchStatement : SWITCH LPAREN expression RPAREN LBRACE ({...}? => defaultClause | caseClause )* RBRACE -> ^( SWITCH expression ( defaultClause )? ( caseClause )* ) ;
    public final JavaScriptParser.switchStatement_return switchStatement() throws RecognitionException {
        JavaScriptParser.switchStatement_return retval = new JavaScriptParser.switchStatement_return();
        retval.start = input.LT(1);
        int switchStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token SWITCH233=null;
        Token LPAREN234=null;
        Token RPAREN236=null;
        Token LBRACE237=null;
        Token RBRACE240=null;
        JavaScriptParser.expression_return expression235 = null;

        JavaScriptParser.defaultClause_return defaultClause238 = null;

        JavaScriptParser.caseClause_return caseClause239 = null;


        MyAstNode SWITCH233_tree=null;
        MyAstNode LPAREN234_tree=null;
        MyAstNode RPAREN236_tree=null;
        MyAstNode LBRACE237_tree=null;
        MyAstNode RBRACE240_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_SWITCH=new RewriteRuleTokenStream(adaptor,"token SWITCH");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_caseClause=new RewriteRuleSubtreeStream(adaptor,"rule caseClause");
        RewriteRuleSubtreeStream stream_defaultClause=new RewriteRuleSubtreeStream(adaptor,"rule defaultClause");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

        	int defaultClauseCount = 0;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // JavaScript.g:1424:2: ( SWITCH LPAREN expression RPAREN LBRACE ({...}? => defaultClause | caseClause )* RBRACE -> ^( SWITCH expression ( defaultClause )? ( caseClause )* ) )
            // JavaScript.g:1424:4: SWITCH LPAREN expression RPAREN LBRACE ({...}? => defaultClause | caseClause )* RBRACE
            {
            SWITCH233=(Token)match(input,SWITCH,FOLLOW_SWITCH_in_switchStatement5408);  
            stream_SWITCH.add(SWITCH233);

            LPAREN234=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_switchStatement5410);  
            stream_LPAREN.add(LPAREN234);

            pushFollow(FOLLOW_expression_in_switchStatement5412);
            expression235=expression();

            state._fsp--;

            stream_expression.add(expression235.getTree());
            RPAREN236=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_switchStatement5414);  
            stream_RPAREN.add(RPAREN236);

            LBRACE237=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_switchStatement5416);  
            stream_LBRACE.add(LBRACE237);

            // JavaScript.g:1424:43: ({...}? => defaultClause | caseClause )*
            loop65:
            do {
                int alt65=3;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==DEFAULT) && (( defaultClauseCount == 0 ))) {
                    alt65=1;
                }
                else if ( (LA65_0==CASE) ) {
                    alt65=2;
                }


                switch (alt65) {
            	case 1 :
            	    // JavaScript.g:1424:45: {...}? => defaultClause
            	    {
            	    if ( !(( defaultClauseCount == 0 )) ) {
            	        throw new FailedPredicateException(input, "switchStatement", " defaultClauseCount == 0 ");
            	    }
            	    pushFollow(FOLLOW_defaultClause_in_switchStatement5423);
            	    defaultClause238=defaultClause();

            	    state._fsp--;

            	    stream_defaultClause.add(defaultClause238.getTree());
            	     defaultClauseCount++; 

            	    }
            	    break;
            	case 2 :
            	    // JavaScript.g:1424:118: caseClause
            	    {
            	    pushFollow(FOLLOW_caseClause_in_switchStatement5429);
            	    caseClause239=caseClause();

            	    state._fsp--;

            	    stream_caseClause.add(caseClause239.getTree());

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            RBRACE240=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_switchStatement5434);  
            stream_RBRACE.add(RBRACE240);



            // AST REWRITE
            // elements: defaultClause, SWITCH, expression, caseClause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1425:2: -> ^( SWITCH expression ( defaultClause )? ( caseClause )* )
            {
                // JavaScript.g:1425:5: ^( SWITCH expression ( defaultClause )? ( caseClause )* )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot(stream_SWITCH.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                // JavaScript.g:1425:26: ( defaultClause )?
                if ( stream_defaultClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_defaultClause.nextTree());

                }
                stream_defaultClause.reset();
                // JavaScript.g:1425:41: ( caseClause )*
                while ( stream_caseClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_caseClause.nextTree());

                }
                stream_caseClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "switchStatement"

    public static class caseClause_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseClause"
    // JavaScript.g:1428:1: caseClause : CASE expression COLON ( statement )* ;
    public final JavaScriptParser.caseClause_return caseClause() throws RecognitionException {
        JavaScriptParser.caseClause_return retval = new JavaScriptParser.caseClause_return();
        retval.start = input.LT(1);
        int caseClause_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token CASE241=null;
        Token COLON243=null;
        JavaScriptParser.expression_return expression242 = null;

        JavaScriptParser.statement_return statement244 = null;


        MyAstNode CASE241_tree=null;
        MyAstNode COLON243_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // JavaScript.g:1429:2: ( CASE expression COLON ( statement )* )
            // JavaScript.g:1429:4: CASE expression COLON ( statement )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            CASE241=(Token)match(input,CASE,FOLLOW_CASE_in_caseClause5462); 
            CASE241_tree = (MyAstNode)adaptor.create(CASE241);
            root_0 = (MyAstNode)adaptor.becomeRoot(CASE241_tree, root_0);

            pushFollow(FOLLOW_expression_in_caseClause5465);
            expression242=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression242.getTree());
            COLON243=(Token)match(input,COLON,FOLLOW_COLON_in_caseClause5467); 
            // JavaScript.g:1429:28: ( statement )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=NULL && LA66_0<=BREAK)||LA66_0==CONTINUE||(LA66_0>=DELETE && LA66_0<=DO)||(LA66_0>=FOR && LA66_0<=IF)||(LA66_0>=NEW && LA66_0<=WITH)||LA66_0==LBRACE||LA66_0==LPAREN||LA66_0==LBRACK||LA66_0==SEMIC||(LA66_0>=ADD && LA66_0<=SUB)||(LA66_0>=INC && LA66_0<=DEC)||(LA66_0>=NOT && LA66_0<=INV)||(LA66_0>=Identifier && LA66_0<=StringLiteral)||LA66_0==RegularExpressionLiteral||(LA66_0>=DecimalLiteral && LA66_0<=HexIntegerLiteral)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // JavaScript.g:1429:28: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_caseClause5470);
            	    statement244=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement244.getTree());

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseClause"

    public static class defaultClause_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultClause"
    // JavaScript.g:1432:1: defaultClause : DEFAULT COLON ( statement )* ;
    public final JavaScriptParser.defaultClause_return defaultClause() throws RecognitionException {
        JavaScriptParser.defaultClause_return retval = new JavaScriptParser.defaultClause_return();
        retval.start = input.LT(1);
        int defaultClause_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token DEFAULT245=null;
        Token COLON246=null;
        JavaScriptParser.statement_return statement247 = null;


        MyAstNode DEFAULT245_tree=null;
        MyAstNode COLON246_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // JavaScript.g:1433:2: ( DEFAULT COLON ( statement )* )
            // JavaScript.g:1433:4: DEFAULT COLON ( statement )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            DEFAULT245=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_defaultClause5483); 
            DEFAULT245_tree = (MyAstNode)adaptor.create(DEFAULT245);
            root_0 = (MyAstNode)adaptor.becomeRoot(DEFAULT245_tree, root_0);

            COLON246=(Token)match(input,COLON,FOLLOW_COLON_in_defaultClause5486); 
            // JavaScript.g:1433:20: ( statement )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( ((LA67_0>=NULL && LA67_0<=BREAK)||LA67_0==CONTINUE||(LA67_0>=DELETE && LA67_0<=DO)||(LA67_0>=FOR && LA67_0<=IF)||(LA67_0>=NEW && LA67_0<=WITH)||LA67_0==LBRACE||LA67_0==LPAREN||LA67_0==LBRACK||LA67_0==SEMIC||(LA67_0>=ADD && LA67_0<=SUB)||(LA67_0>=INC && LA67_0<=DEC)||(LA67_0>=NOT && LA67_0<=INV)||(LA67_0>=Identifier && LA67_0<=StringLiteral)||LA67_0==RegularExpressionLiteral||(LA67_0>=DecimalLiteral && LA67_0<=HexIntegerLiteral)) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // JavaScript.g:1433:20: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_defaultClause5489);
            	    statement247=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement247.getTree());

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defaultClause"

    public static class labelledStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "labelledStatement"
    // JavaScript.g:1440:1: labelledStatement : Identifier COLON statement -> ^( LABELLED Identifier statement ) ;
    public final JavaScriptParser.labelledStatement_return labelledStatement() throws RecognitionException {
        JavaScriptParser.labelledStatement_return retval = new JavaScriptParser.labelledStatement_return();
        retval.start = input.LT(1);
        int labelledStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token Identifier248=null;
        Token COLON249=null;
        JavaScriptParser.statement_return statement250 = null;


        MyAstNode Identifier248_tree=null;
        MyAstNode COLON249_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // JavaScript.g:1441:2: ( Identifier COLON statement -> ^( LABELLED Identifier statement ) )
            // JavaScript.g:1441:4: Identifier COLON statement
            {
            Identifier248=(Token)match(input,Identifier,FOLLOW_Identifier_in_labelledStatement5506);  
            stream_Identifier.add(Identifier248);

            COLON249=(Token)match(input,COLON,FOLLOW_COLON_in_labelledStatement5508);  
            stream_COLON.add(COLON249);

            pushFollow(FOLLOW_statement_in_labelledStatement5510);
            statement250=statement();

            state._fsp--;

            stream_statement.add(statement250.getTree());


            // AST REWRITE
            // elements: statement, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1442:2: -> ^( LABELLED Identifier statement )
            {
                // JavaScript.g:1442:5: ^( LABELLED Identifier statement )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(LABELLED, "LABELLED"), root_1);

                adaptor.addChild(root_1, stream_Identifier.nextNode());
                adaptor.addChild(root_1, stream_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "labelledStatement"

    public static class throwStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "throwStatement"
    // JavaScript.g:1464:1: throwStatement : THROW expression semic ;
    public final JavaScriptParser.throwStatement_return throwStatement() throws RecognitionException {
        JavaScriptParser.throwStatement_return retval = new JavaScriptParser.throwStatement_return();
        retval.start = input.LT(1);
        int throwStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token THROW251=null;
        JavaScriptParser.expression_return expression252 = null;

        JavaScriptParser.semic_return semic253 = null;


        MyAstNode THROW251_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // JavaScript.g:1465:2: ( THROW expression semic )
            // JavaScript.g:1465:4: THROW expression semic
            {
            root_0 = (MyAstNode)adaptor.nil();

            THROW251=(Token)match(input,THROW,FOLLOW_THROW_in_throwStatement5541); 
            THROW251_tree = (MyAstNode)adaptor.create(THROW251);
            root_0 = (MyAstNode)adaptor.becomeRoot(THROW251_tree, root_0);

             promoteEOL(null); 
            pushFollow(FOLLOW_expression_in_throwStatement5546);
            expression252=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression252.getTree());
            pushFollow(FOLLOW_semic_in_throwStatement5548);
            semic253=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "throwStatement"

    public static class tryStatement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tryStatement"
    // JavaScript.g:1472:1: tryStatement : TRY block ( catchClause ( finallyClause )? | finallyClause ) ;
    public final JavaScriptParser.tryStatement_return tryStatement() throws RecognitionException {
        JavaScriptParser.tryStatement_return retval = new JavaScriptParser.tryStatement_return();
        retval.start = input.LT(1);
        int tryStatement_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token TRY254=null;
        JavaScriptParser.block_return block255 = null;

        JavaScriptParser.catchClause_return catchClause256 = null;

        JavaScriptParser.finallyClause_return finallyClause257 = null;

        JavaScriptParser.finallyClause_return finallyClause258 = null;


        MyAstNode TRY254_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // JavaScript.g:1473:2: ( TRY block ( catchClause ( finallyClause )? | finallyClause ) )
            // JavaScript.g:1473:4: TRY block ( catchClause ( finallyClause )? | finallyClause )
            {
            root_0 = (MyAstNode)adaptor.nil();

            TRY254=(Token)match(input,TRY,FOLLOW_TRY_in_tryStatement5565); 
            TRY254_tree = (MyAstNode)adaptor.create(TRY254);
            root_0 = (MyAstNode)adaptor.becomeRoot(TRY254_tree, root_0);

            pushFollow(FOLLOW_block_in_tryStatement5568);
            block255=block();

            state._fsp--;

            adaptor.addChild(root_0, block255.getTree());
            // JavaScript.g:1473:15: ( catchClause ( finallyClause )? | finallyClause )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==CATCH) ) {
                alt69=1;
            }
            else if ( (LA69_0==FINALLY) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // JavaScript.g:1473:17: catchClause ( finallyClause )?
                    {
                    pushFollow(FOLLOW_catchClause_in_tryStatement5572);
                    catchClause256=catchClause();

                    state._fsp--;

                    adaptor.addChild(root_0, catchClause256.getTree());
                    // JavaScript.g:1473:29: ( finallyClause )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==FINALLY) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // JavaScript.g:1473:29: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_tryStatement5574);
                            finallyClause257=finallyClause();

                            state._fsp--;

                            adaptor.addChild(root_0, finallyClause257.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // JavaScript.g:1473:46: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_tryStatement5579);
                    finallyClause258=finallyClause();

                    state._fsp--;

                    adaptor.addChild(root_0, finallyClause258.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tryStatement"

    public static class catchClause_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "catchClause"
    // JavaScript.g:1476:1: catchClause : CATCH LPAREN Identifier RPAREN block ;
    public final JavaScriptParser.catchClause_return catchClause() throws RecognitionException {
        JavaScriptParser.catchClause_return retval = new JavaScriptParser.catchClause_return();
        retval.start = input.LT(1);
        int catchClause_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token CATCH259=null;
        Token LPAREN260=null;
        Token Identifier261=null;
        Token RPAREN262=null;
        JavaScriptParser.block_return block263 = null;


        MyAstNode CATCH259_tree=null;
        MyAstNode LPAREN260_tree=null;
        MyAstNode Identifier261_tree=null;
        MyAstNode RPAREN262_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // JavaScript.g:1477:2: ( CATCH LPAREN Identifier RPAREN block )
            // JavaScript.g:1477:4: CATCH LPAREN Identifier RPAREN block
            {
            root_0 = (MyAstNode)adaptor.nil();

            CATCH259=(Token)match(input,CATCH,FOLLOW_CATCH_in_catchClause5593); 
            CATCH259_tree = (MyAstNode)adaptor.create(CATCH259);
            root_0 = (MyAstNode)adaptor.becomeRoot(CATCH259_tree, root_0);

            LPAREN260=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_catchClause5596); 
            Identifier261=(Token)match(input,Identifier,FOLLOW_Identifier_in_catchClause5599); 
            Identifier261_tree = (MyAstNode)adaptor.create(Identifier261);
            adaptor.addChild(root_0, Identifier261_tree);

            RPAREN262=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_catchClause5601); 
            pushFollow(FOLLOW_block_in_catchClause5604);
            block263=block();

            state._fsp--;

            adaptor.addChild(root_0, block263.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "catchClause"

    public static class finallyClause_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "finallyClause"
    // JavaScript.g:1480:1: finallyClause : FINALLY block ;
    public final JavaScriptParser.finallyClause_return finallyClause() throws RecognitionException {
        JavaScriptParser.finallyClause_return retval = new JavaScriptParser.finallyClause_return();
        retval.start = input.LT(1);
        int finallyClause_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token FINALLY264=null;
        JavaScriptParser.block_return block265 = null;


        MyAstNode FINALLY264_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // JavaScript.g:1481:2: ( FINALLY block )
            // JavaScript.g:1481:4: FINALLY block
            {
            root_0 = (MyAstNode)adaptor.nil();

            FINALLY264=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause5616); 
            FINALLY264_tree = (MyAstNode)adaptor.create(FINALLY264);
            root_0 = (MyAstNode)adaptor.becomeRoot(FINALLY264_tree, root_0);

            pushFollow(FOLLOW_block_in_finallyClause5619);
            block265=block();

            state._fsp--;

            adaptor.addChild(root_0, block265.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "finallyClause"

    public static class functionDeclaration_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionDeclaration"
    // JavaScript.g:1494:1: functionDeclaration : FUNCTION name= Identifier formalParameterList functionBody -> ^( FUNCTION $name formalParameterList functionBody ) ;
    public final JavaScriptParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        JavaScriptParser.functionDeclaration_return retval = new JavaScriptParser.functionDeclaration_return();
        retval.start = input.LT(1);
        int functionDeclaration_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token name=null;
        Token FUNCTION266=null;
        JavaScriptParser.formalParameterList_return formalParameterList267 = null;

        JavaScriptParser.functionBody_return functionBody268 = null;


        MyAstNode name_tree=null;
        MyAstNode FUNCTION266_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }
            // JavaScript.g:1495:2: ( FUNCTION name= Identifier formalParameterList functionBody -> ^( FUNCTION $name formalParameterList functionBody ) )
            // JavaScript.g:1495:4: FUNCTION name= Identifier formalParameterList functionBody
            {
            FUNCTION266=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_functionDeclaration5640);  
            stream_FUNCTION.add(FUNCTION266);

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionDeclaration5644);  
            stream_Identifier.add(name);

            pushFollow(FOLLOW_formalParameterList_in_functionDeclaration5646);
            formalParameterList267=formalParameterList();

            state._fsp--;

            stream_formalParameterList.add(formalParameterList267.getTree());
            pushFollow(FOLLOW_functionBody_in_functionDeclaration5648);
            functionBody268=functionBody();

            state._fsp--;

            stream_functionBody.add(functionBody268.getTree());


            // AST REWRITE
            // elements: name, FUNCTION, functionBody, formalParameterList
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1496:2: -> ^( FUNCTION $name formalParameterList functionBody )
            {
                // JavaScript.g:1496:5: ^( FUNCTION $name formalParameterList functionBody )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_formalParameterList.nextTree());
                adaptor.addChild(root_1, stream_functionBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionDeclaration"

    public static class functionExpression_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionExpression"
    // JavaScript.g:1499:1: functionExpression : FUNCTION (name= Identifier )? formalParameterList functionBody -> ^( FUNCTION ( $name)? formalParameterList functionBody ) ;
    public final JavaScriptParser.functionExpression_return functionExpression() throws RecognitionException {
        JavaScriptParser.functionExpression_return retval = new JavaScriptParser.functionExpression_return();
        retval.start = input.LT(1);
        int functionExpression_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token name=null;
        Token FUNCTION269=null;
        JavaScriptParser.formalParameterList_return formalParameterList270 = null;

        JavaScriptParser.functionBody_return functionBody271 = null;


        MyAstNode name_tree=null;
        MyAstNode FUNCTION269_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }
            // JavaScript.g:1500:2: ( FUNCTION (name= Identifier )? formalParameterList functionBody -> ^( FUNCTION ( $name)? formalParameterList functionBody ) )
            // JavaScript.g:1500:4: FUNCTION (name= Identifier )? formalParameterList functionBody
            {
            FUNCTION269=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_functionExpression5675);  
            stream_FUNCTION.add(FUNCTION269);

            // JavaScript.g:1500:17: (name= Identifier )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==Identifier) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // JavaScript.g:1500:17: name= Identifier
                    {
                    name=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionExpression5679);  
                    stream_Identifier.add(name);


                    }
                    break;

            }

            pushFollow(FOLLOW_formalParameterList_in_functionExpression5682);
            formalParameterList270=formalParameterList();

            state._fsp--;

            stream_formalParameterList.add(formalParameterList270.getTree());
            pushFollow(FOLLOW_functionBody_in_functionExpression5684);
            functionBody271=functionBody();

            state._fsp--;

            stream_functionBody.add(functionBody271.getTree());


            // AST REWRITE
            // elements: functionBody, formalParameterList, FUNCTION, name
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1501:2: -> ^( FUNCTION ( $name)? formalParameterList functionBody )
            {
                // JavaScript.g:1501:5: ^( FUNCTION ( $name)? formalParameterList functionBody )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);

                // JavaScript.g:1501:17: ( $name)?
                if ( stream_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_name.nextNode());

                }
                stream_name.reset();
                adaptor.addChild(root_1, stream_formalParameterList.nextTree());
                adaptor.addChild(root_1, stream_functionBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionExpression"

    public static class formalParameterList_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameterList"
    // JavaScript.g:1504:1: formalParameterList : LPAREN (args+= Identifier ( COMMA args+= Identifier )* )? RPAREN -> ^( ARGS ( $args)* ) ;
    public final JavaScriptParser.formalParameterList_return formalParameterList() throws RecognitionException {
        JavaScriptParser.formalParameterList_return retval = new JavaScriptParser.formalParameterList_return();
        retval.start = input.LT(1);
        int formalParameterList_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token LPAREN272=null;
        Token COMMA273=null;
        Token RPAREN274=null;
        Token args=null;
        List list_args=null;

        MyAstNode LPAREN272_tree=null;
        MyAstNode COMMA273_tree=null;
        MyAstNode RPAREN274_tree=null;
        MyAstNode args_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }
            // JavaScript.g:1505:2: ( LPAREN (args+= Identifier ( COMMA args+= Identifier )* )? RPAREN -> ^( ARGS ( $args)* ) )
            // JavaScript.g:1505:4: LPAREN (args+= Identifier ( COMMA args+= Identifier )* )? RPAREN
            {
            LPAREN272=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_formalParameterList5712);  
            stream_LPAREN.add(LPAREN272);

            // JavaScript.g:1505:11: (args+= Identifier ( COMMA args+= Identifier )* )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==Identifier) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // JavaScript.g:1505:13: args+= Identifier ( COMMA args+= Identifier )*
                    {
                    args=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterList5718);  
                    stream_Identifier.add(args);

                    if (list_args==null) list_args=new ArrayList();
                    list_args.add(args);

                    // JavaScript.g:1505:30: ( COMMA args+= Identifier )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==COMMA) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // JavaScript.g:1505:32: COMMA args+= Identifier
                    	    {
                    	    COMMA273=(Token)match(input,COMMA,FOLLOW_COMMA_in_formalParameterList5722);  
                    	    stream_COMMA.add(COMMA273);

                    	    args=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterList5726);  
                    	    stream_Identifier.add(args);

                    	    if (list_args==null) list_args=new ArrayList();
                    	    list_args.add(args);


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAREN274=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_formalParameterList5734);  
            stream_RPAREN.add(RPAREN274);



            // AST REWRITE
            // elements: args
            // token labels: 
            // rule labels: retval
            // token list labels: args
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_args=new RewriteRuleTokenStream(adaptor,"token args", list_args);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1506:2: -> ^( ARGS ( $args)* )
            {
                // JavaScript.g:1506:5: ^( ARGS ( $args)* )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(ARGS, "ARGS"), root_1);

                // JavaScript.g:1506:13: ( $args)*
                while ( stream_args.hasNext() ) {
                    adaptor.addChild(root_1, stream_args.nextNode());

                }
                stream_args.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "formalParameterList"

    public static class functionBody_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionBody"
    // JavaScript.g:1509:1: functionBody : lb= LBRACE ( sourceElement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* ) ;
    public final JavaScriptParser.functionBody_return functionBody() throws RecognitionException {
        JavaScriptParser.functionBody_return retval = new JavaScriptParser.functionBody_return();
        retval.start = input.LT(1);
        int functionBody_StartIndex = input.index();
        MyAstNode root_0 = null;

        Token lb=null;
        Token RBRACE276=null;
        JavaScriptParser.sourceElement_return sourceElement275 = null;


        MyAstNode lb_tree=null;
        MyAstNode RBRACE276_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_sourceElement=new RewriteRuleSubtreeStream(adaptor,"rule sourceElement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return retval; }
            // JavaScript.g:1510:2: (lb= LBRACE ( sourceElement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* ) )
            // JavaScript.g:1510:4: lb= LBRACE ( sourceElement )* RBRACE
            {
            lb=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_functionBody5760);  
            stream_LBRACE.add(lb);

            // JavaScript.g:1510:14: ( sourceElement )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( ((LA73_0>=NULL && LA73_0<=BREAK)||LA73_0==CONTINUE||(LA73_0>=DELETE && LA73_0<=DO)||(LA73_0>=FOR && LA73_0<=IF)||(LA73_0>=NEW && LA73_0<=WITH)||LA73_0==LBRACE||LA73_0==LPAREN||LA73_0==LBRACK||LA73_0==SEMIC||(LA73_0>=ADD && LA73_0<=SUB)||(LA73_0>=INC && LA73_0<=DEC)||(LA73_0>=NOT && LA73_0<=INV)||(LA73_0>=Identifier && LA73_0<=StringLiteral)||LA73_0==RegularExpressionLiteral||(LA73_0>=DecimalLiteral && LA73_0<=HexIntegerLiteral)) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // JavaScript.g:1510:14: sourceElement
            	    {
            	    pushFollow(FOLLOW_sourceElement_in_functionBody5762);
            	    sourceElement275=sourceElement();

            	    state._fsp--;

            	    stream_sourceElement.add(sourceElement275.getTree());

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            RBRACE276=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_functionBody5765);  
            stream_RBRACE.add(RBRACE276);



            // AST REWRITE
            // elements: sourceElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (MyAstNode)adaptor.nil();
            // 1511:2: -> ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* )
            {
                // JavaScript.g:1511:5: ^( BLOCK[$lb, \"BLOCK\"] ( sourceElement )* )
                {
                MyAstNode root_1 = (MyAstNode)adaptor.nil();
                root_1 = (MyAstNode)adaptor.becomeRoot((MyAstNode)adaptor.create(BLOCK, lb, "BLOCK"), root_1);

                // JavaScript.g:1511:28: ( sourceElement )*
                while ( stream_sourceElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_sourceElement.nextTree());

                }
                stream_sourceElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionBody"

    public static class program_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // JavaScript.g:1518:1: program : ( sourceElement )* ;
    public final JavaScriptParser.program_return program() throws RecognitionException {
        JavaScriptParser.program_return retval = new JavaScriptParser.program_return();
        retval.start = input.LT(1);
        int program_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.sourceElement_return sourceElement277 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return retval; }
            // JavaScript.g:1519:2: ( ( sourceElement )* )
            // JavaScript.g:1519:4: ( sourceElement )*
            {
            root_0 = (MyAstNode)adaptor.nil();

            // JavaScript.g:1519:4: ( sourceElement )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=NULL && LA74_0<=BREAK)||LA74_0==CONTINUE||(LA74_0>=DELETE && LA74_0<=DO)||(LA74_0>=FOR && LA74_0<=IF)||(LA74_0>=NEW && LA74_0<=WITH)||LA74_0==LBRACE||LA74_0==LPAREN||LA74_0==LBRACK||LA74_0==SEMIC||(LA74_0>=ADD && LA74_0<=SUB)||(LA74_0>=INC && LA74_0<=DEC)||(LA74_0>=NOT && LA74_0<=INV)||(LA74_0>=Identifier && LA74_0<=StringLiteral)||LA74_0==RegularExpressionLiteral||(LA74_0>=DecimalLiteral && LA74_0<=HexIntegerLiteral)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // JavaScript.g:1519:4: sourceElement
            	    {
            	    pushFollow(FOLLOW_sourceElement_in_program5794);
            	    sourceElement277=sourceElement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, sourceElement277.getTree());

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class sourceElement_return extends ParserRuleReturnScope {
        MyAstNode tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceElement"
    // JavaScript.g:1527:1: sourceElement options {k=1; } : ({...}? functionDeclaration | statement );
    public final JavaScriptParser.sourceElement_return sourceElement() throws RecognitionException {
        JavaScriptParser.sourceElement_return retval = new JavaScriptParser.sourceElement_return();
        retval.start = input.LT(1);
        int sourceElement_StartIndex = input.index();
        MyAstNode root_0 = null;

        JavaScriptParser.functionDeclaration_return functionDeclaration278 = null;

        JavaScriptParser.statement_return statement279 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return retval; }
            // JavaScript.g:1532:2: ({...}? functionDeclaration | statement )
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // JavaScript.g:1532:4: {...}? functionDeclaration
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    if ( !(( input.LA(1) == FUNCTION )) ) {
                        throw new FailedPredicateException(input, "sourceElement", " input.LA(1) == FUNCTION ");
                    }
                    pushFollow(FOLLOW_functionDeclaration_in_sourceElement5823);
                    functionDeclaration278=functionDeclaration();

                    state._fsp--;

                    adaptor.addChild(root_0, functionDeclaration278.getTree());

                    }
                    break;
                case 2 :
                    // JavaScript.g:1533:4: statement
                    {
                    root_0 = (MyAstNode)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_sourceElement5828);
                    statement279=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement279.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (MyAstNode)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (MyAstNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sourceElement"

    // Delegated rules


    protected DFA44 dfa44 = new DFA44(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA75 dfa75 = new DFA75(this);
    static final String DFA44_eotS =
        "\44\uffff";
    static final String DFA44_eofS =
        "\44\uffff";
    static final String DFA44_minS =
        "\1\4\1\0\42\uffff";
    static final String DFA44_maxS =
        "\1\u00a1\1\0\42\uffff";
    static final String DFA44_acceptS =
        "\2\uffff\1\2\40\uffff\1\1";
    static final String DFA44_specialS =
        "\1\uffff\1\0\42\uffff}>";
    static final String[] DFA44_transitionS = {
            "\4\2\2\uffff\1\2\1\uffff\2\2\2\uffff\3\2\2\uffff\13\2\37\uffff"+
            "\1\1\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\11\uffff\2\2\2\uffff"+
            "\2\2\6\uffff\2\2\66\uffff\2\2\5\uffff\1\2\3\uffff\3\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "1166:1: statement options {k=1; } : ({...}? block | statementTail );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_1 = input.LA(1);

                         
                        int index44_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( input.LA(1) == LBRACE )) ) {s = 35;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index44_1);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA45_eotS =
        "\17\uffff";
    static final String DFA45_eofS =
        "\4\uffff\1\3\12\uffff";
    static final String DFA45_minS =
        "\1\4\3\uffff\1\23\12\uffff";
    static final String DFA45_maxS =
        "\1\u00a1\3\uffff\1\u0092\12\uffff";
    static final String DFA45_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\13\1\14"+
        "\1\15\1\12";
    static final String DFA45_specialS =
        "\17\uffff}>";
    static final String[] DFA45_transitionS = {
            "\3\3\1\10\2\uffff\1\7\1\uffff\1\3\1\6\2\uffff\1\6\1\3\1\5\2"+
            "\uffff\1\3\1\11\1\13\1\3\1\14\1\15\1\3\1\1\1\3\1\6\1\12\37\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\1\2\11\uffff\2\3\2\uffff"+
            "\2\3\6\uffff\2\3\66\uffff\1\4\1\3\5\uffff\1\3\3\uffff\3\3",
            "",
            "",
            "",
            "\2\3\53\uffff\2\3\1\uffff\1\3\1\uffff\27\3\2\uffff\3\3\1\16"+
            "\15\3\42\uffff\2\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "1179:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement );";
        }
    }
    static final String DFA75_eotS =
        "\44\uffff";
    static final String DFA75_eofS =
        "\44\uffff";
    static final String DFA75_minS =
        "\1\4\1\0\42\uffff";
    static final String DFA75_maxS =
        "\1\u00a1\1\0\42\uffff";
    static final String DFA75_acceptS =
        "\2\uffff\1\2\40\uffff\1\1";
    static final String DFA75_specialS =
        "\1\uffff\1\0\42\uffff}>";
    static final String[] DFA75_transitionS = {
            "\4\2\2\uffff\1\2\1\uffff\2\2\2\uffff\1\2\1\1\1\2\2\uffff\13"+
            "\2\37\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\11\uffff"+
            "\2\2\2\uffff\2\2\6\uffff\2\2\66\uffff\2\2\5\uffff\1\2\3\uffff"+
            "\3\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA75_eot = DFA.unpackEncodedString(DFA75_eotS);
    static final short[] DFA75_eof = DFA.unpackEncodedString(DFA75_eofS);
    static final char[] DFA75_min = DFA.unpackEncodedStringToUnsignedChars(DFA75_minS);
    static final char[] DFA75_max = DFA.unpackEncodedStringToUnsignedChars(DFA75_maxS);
    static final short[] DFA75_accept = DFA.unpackEncodedString(DFA75_acceptS);
    static final short[] DFA75_special = DFA.unpackEncodedString(DFA75_specialS);
    static final short[][] DFA75_transition;

    static {
        int numStates = DFA75_transitionS.length;
        DFA75_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA75_transition[i] = DFA.unpackEncodedString(DFA75_transitionS[i]);
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = DFA75_eot;
            this.eof = DFA75_eof;
            this.min = DFA75_min;
            this.max = DFA75_max;
            this.accept = DFA75_accept;
            this.special = DFA75_special;
            this.transition = DFA75_transition;
        }
        public String getDescription() {
            return "1527:1: sourceElement options {k=1; } : ({...}? functionDeclaration | statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA75_1 = input.LA(1);

                         
                        int index75_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( input.LA(1) == FUNCTION )) ) {s = 35;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index75_1);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 75, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_reservedWord_in_token1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_token1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_punctuator_in_token1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_token1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_token1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyword_in_reservedWord1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_futureReservedWord_in_reservedWord1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_reservedWord1799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_reservedWord1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_keyword0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_futureReservedWord0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_punctuator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal2485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_literal2490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal2500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RegularExpressionLiteral_in_literal2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_booleanLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_numericLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_primaryExpression3118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_primaryExpression3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpression3128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayLiteral_in_primaryExpression3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectLiteral_in_primaryExpression3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression3145 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_primaryExpression3147 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression3149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayLiteral3173 = new BitSet(new long[]{0x8000000029221070L,0x000000003033009AL,0x0000000388300000L});
    public static final BitSet FOLLOW_arrayItem_in_arrayLiteral3177 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000090L});
    public static final BitSet FOLLOW_COMMA_in_arrayLiteral3181 = new BitSet(new long[]{0x8000000029221070L,0x000000003033009AL,0x0000000388300000L});
    public static final BitSet FOLLOW_arrayItem_in_arrayLiteral3183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000090L});
    public static final BitSet FOLLOW_RBRACK_in_arrayLiteral3191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_arrayItem3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_objectLiteral3251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000380300000L});
    public static final BitSet FOLLOW_nameValuePair_in_objectLiteral3255 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000081L});
    public static final BitSet FOLLOW_COMMA_in_objectLiteral3259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000380300000L});
    public static final BitSet FOLLOW_nameValuePair_in_objectLiteral3261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000081L});
    public static final BitSet FOLLOW_RBRACE_in_objectLiteral3269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyName_in_nameValuePair3294 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_nameValuePair3296 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_nameValuePair3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_propertyName3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_propertyName3327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_propertyName3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_memberExpression3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionExpression_in_memberExpression3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_memberExpression3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_newExpression3371 = new BitSet(new long[]{0x8000000001000070L,0x000000000000000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_primaryExpression_in_newExpression3374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_newExpression3382 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_functionExpression_in_newExpression3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments3398 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000EL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_arguments3402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000084L});
    public static final BitSet FOLLOW_COMMA_in_arguments3406 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_arguments3408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000084L});
    public static final BitSet FOLLOW_RPAREN_in_arguments3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberExpression_in_leftHandSideExpression3445 = new BitSet(new long[]{0x0000000000000002L,0x000000000000002AL});
    public static final BitSet FOLLOW_arguments_in_leftHandSideExpression3461 = new BitSet(new long[]{0x0000000000000002L,0x000000000000002AL});
    public static final BitSet FOLLOW_LBRACK_in_leftHandSideExpression3482 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_leftHandSideExpression3484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RBRACK_in_leftHandSideExpression3486 = new BitSet(new long[]{0x0000000000000002L,0x000000000000002AL});
    public static final BitSet FOLLOW_DOT_in_leftHandSideExpression3505 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_leftHandSideExpression3507 = new BitSet(new long[]{0x0000000000000002L,0x000000000000002AL});
    public static final BitSet FOLLOW_leftHandSideExpression_in_postfixExpression3542 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_postfixOperator_in_postfixExpression3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_postfixOperator3566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_postfixOperator3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression3592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOperator_in_unaryExpression3597 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_unaryOperator3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_unaryOperator3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEOF_in_unaryOperator3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_unaryOperator3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_unaryOperator3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_unaryOperator3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_in_unaryOperator3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INV_in_unaryOperator3655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryOperator3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression3675 = new BitSet(new long[]{0x0000000000000002L,0x00002000000C0000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression3679 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression3694 = new BitSet(new long[]{0x0000000000000002L,0x00002000000C0000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression3712 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_set_in_additiveExpression3716 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression3727 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression3746 = new BitSet(new long[]{0x0000000000000002L,0x0000000001C00000L});
    public static final BitSet FOLLOW_set_in_shiftExpression3750 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression3765 = new BitSet(new long[]{0x0000000000000002L,0x0000000001C00000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression3784 = new BitSet(new long[]{0x0000000000180002L,0x0000000000000F00L});
    public static final BitSet FOLLOW_set_in_relationalExpression3788 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression3815 = new BitSet(new long[]{0x0000000000180002L,0x0000000000000F00L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpressionNoIn3829 = new BitSet(new long[]{0x0000000000100002L,0x0000000000000F00L});
    public static final BitSet FOLLOW_set_in_relationalExpressionNoIn3833 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpressionNoIn3856 = new BitSet(new long[]{0x0000000000100002L,0x0000000000000F00L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression3875 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_set_in_equalityExpression3879 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression3898 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn3912 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_set_in_equalityExpressionNoIn3916 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn3935 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_equalityExpression_in_bitwiseANDExpression3955 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_AND_in_bitwiseANDExpression3959 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_equalityExpression_in_bitwiseANDExpression3962 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn3976 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_AND_in_bitwiseANDExpressionNoIn3980 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn3983 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression3999 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_XOR_in_bitwiseXORExpression4003 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression4006 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn4022 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_XOR_in_bitwiseXORExpressionNoIn4026 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn4029 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_bitwiseXORExpression_in_bitwiseORExpression4044 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_OR_in_bitwiseORExpression4048 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseXORExpression_in_bitwiseORExpression4051 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn4066 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_OR_in_bitwiseORExpressionNoIn4070 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn4073 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_bitwiseORExpression_in_logicalANDExpression4092 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_LAND_in_logicalANDExpression4096 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseORExpression_in_logicalANDExpression4099 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn4113 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_LAND_in_logicalANDExpressionNoIn4117 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn4120 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_logicalANDExpression_in_logicalORExpression4135 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_LOR_in_logicalORExpression4139 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_logicalANDExpression_in_logicalORExpression4142 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn4157 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_LOR_in_logicalORExpressionNoIn4161 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn4164 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_logicalORExpression_in_conditionalExpression4183 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_QUE_in_conditionalExpression4187 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression4190 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression4192 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression4195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalORExpressionNoIn_in_conditionalExpressionNoIn4209 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_QUE_in_conditionalExpressionNoIn4213 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn4216 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpressionNoIn4218 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn4221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_assignmentExpression4249 = new BitSet(new long[]{0x0000000000000002L,0x00005FFC00000000L});
    public static final BitSet FOLLOW_assignmentOperator_in_assignmentExpression4256 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_assignmentExpression4259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignmentOperator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpressionNoIn_in_assignmentExpressionNoIn4336 = new BitSet(new long[]{0x0000000000000002L,0x00005FFC00000000L});
    public static final BitSet FOLLOW_assignmentOperator_in_assignmentExpressionNoIn4343 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_assignmentExpressionNoIn4346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_expression4368 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_COMMA_in_expression4372 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_expression4376 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_expressionNoIn4413 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_COMMA_in_expressionNoIn4417 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_expressionNoIn4421 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_SEMIC_in_semic4472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_semic4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RBRACE_in_semic4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOL_in_semic4489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MultiLineComment_in_semic4493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement4527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementTail_in_statement4532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableStatement_in_statementTail4544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyStatement_in_statementTail4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementTail4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementTail4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterationStatement_in_statementTail4564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementTail4569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementTail4574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementTail4579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withStatement_in_statementTail4584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelledStatement_in_statementTail4589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementTail4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementTail4599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tryStatement_in_statementTail4604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_block4619 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004BL,0x0000000388300000L});
    public static final BitSet FOLLOW_sourceElement_in_block4621 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004BL,0x0000000388300000L});
    public static final BitSet FOLLOW_RBRACE_in_block4624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_variableStatement4653 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableStatement4655 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000060000L});
    public static final BitSet FOLLOW_COMMA_in_variableStatement4659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableStatement4661 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_variableStatement4666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclaration4689 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclaration4693 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_variableDeclaration4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclarationNoIn4711 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclarationNoIn4715 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_variableDeclarationNoIn4718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_emptyStatement4737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionStatement4756 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_expressionStatement4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement4776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_ifStatement4778 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_ifStatement4780 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RPAREN_in_ifStatement4782 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_ifStatement4784 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement4790 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_ifStatement4792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doStatement_in_iterationStatement4825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_iterationStatement4830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_iterationStatement4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_doStatement4847 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_doStatement4849 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_WHILE_in_doStatement4851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_doStatement4853 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_doStatement4855 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RPAREN_in_doStatement4857 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_doStatement4859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStatement4884 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_whileStatement4887 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_whileStatement4890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RPAREN_in_whileStatement4892 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_whileStatement4895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStatement4908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_forStatement4911 = new BitSet(new long[]{0x8000000039221070L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_forControl_in_forStatement4914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RPAREN_in_forStatement4916 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_forStatement4919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlVar_in_forControl4930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlExpression_in_forControl4935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlSemic_in_forControl4940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_forControlVar4951 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclarationNoIn_in_forControlVar4953 = new BitSet(new long[]{0x0000000000080000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_IN_in_forControlVar4965 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlVar4967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_forControlVar5013 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclarationNoIn_in_forControlVar5015 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_SEMIC_in_forControlVar5020 = new BitSet(new long[]{0x8000000029221070L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlVar5024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_SEMIC_in_forControlVar5027 = new BitSet(new long[]{0x8000000029221072L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlVar5031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionNoIn_in_forControlExpression5097 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IN_in_forControlExpression5112 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_forControlExpression5162 = new BitSet(new long[]{0x8000000029221070L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression5166 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_SEMIC_in_forControlExpression5169 = new BitSet(new long[]{0x8000000029221072L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression5173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_forControlSemic5232 = new BitSet(new long[]{0x8000000029221070L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlSemic5236 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_SEMIC_in_forControlSemic5239 = new BitSet(new long[]{0x8000000029221072L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlSemic5243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_continueStatement5297 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000160000L});
    public static final BitSet FOLLOW_Identifier_in_continueStatement5302 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_continueStatement5305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_breakStatement5324 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000160000L});
    public static final BitSet FOLLOW_Identifier_in_breakStatement5329 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_breakStatement5332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement5351 = new BitSet(new long[]{0x8000000029221070L,0x00000000303300CBL,0x0000000388360000L});
    public static final BitSet FOLLOW_expression_in_returnStatement5356 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_returnStatement5359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_withStatement5376 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_withStatement5379 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_withStatement5382 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RPAREN_in_withStatement5384 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_withStatement5387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_switchStatement5408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_switchStatement5410 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_switchStatement5412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RPAREN_in_switchStatement5414 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_LBRACE_in_switchStatement5416 = new BitSet(new long[]{0x0000000000000900L,0x0000000000000001L});
    public static final BitSet FOLLOW_defaultClause_in_switchStatement5423 = new BitSet(new long[]{0x0000000000000900L,0x0000000000000001L});
    public static final BitSet FOLLOW_caseClause_in_switchStatement5429 = new BitSet(new long[]{0x0000000000000900L,0x0000000000000001L});
    public static final BitSet FOLLOW_RBRACE_in_switchStatement5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_caseClause5462 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_caseClause5465 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_caseClause5467 = new BitSet(new long[]{0x80000000FFE734F2L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_caseClause5470 = new BitSet(new long[]{0x80000000FFE734F2L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_DEFAULT_in_defaultClause5483 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_defaultClause5486 = new BitSet(new long[]{0x80000000FFE734F2L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_defaultClause5489 = new BitSet(new long[]{0x80000000FFE734F2L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_Identifier_in_labelledStatement5506 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_labelledStatement5508 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_labelledStatement5510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROW_in_throwStatement5541 = new BitSet(new long[]{0x8000000029221070L,0x000000003033000AL,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_throwStatement5546 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C1L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_throwStatement5548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRY_in_tryStatement5565 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_block_in_tryStatement5568 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_catchClause_in_tryStatement5572 = new BitSet(new long[]{0x0000000000008202L});
    public static final BitSet FOLLOW_finallyClause_in_tryStatement5574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_tryStatement5579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_catchClause5593 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_catchClause5596 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_catchClause5599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RPAREN_in_catchClause5601 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_block_in_catchClause5604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause5616 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_block_in_finallyClause5619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionDeclaration5640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_functionDeclaration5644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameterList_in_functionDeclaration5646 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_functionBody_in_functionDeclaration5648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionExpression5675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_functionExpression5679 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameterList_in_functionExpression5682 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_functionBody_in_functionExpression5684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameterList5712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterList5718 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000084L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterList5722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterList5726 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000084L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameterList5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_functionBody5760 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004BL,0x0000000388300000L});
    public static final BitSet FOLLOW_sourceElement_in_functionBody5762 = new BitSet(new long[]{0x80000000FFE734F0L,0x000000003033004BL,0x0000000388300000L});
    public static final BitSet FOLLOW_RBRACE_in_functionBody5765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceElement_in_program5794 = new BitSet(new long[]{0x80000000FFE734F2L,0x000000003033004AL,0x0000000388300000L});
    public static final BitSet FOLLOW_functionDeclaration_in_sourceElement5823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_sourceElement5828 = new BitSet(new long[]{0x0000000000000002L});

}