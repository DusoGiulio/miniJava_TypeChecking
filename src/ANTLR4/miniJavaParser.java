// Generated from miniJava.g4 by ANTLR 4.4

    package ANTLR4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, INSTANCEOF=2, CLASS=3, ELSE=4, EXTENDS=5, IF=6, INT=7, NEW=8, 
		PUBLIC=9, RETURN=10, STATIC=11, THIS=12, VOID=13, WHILE=14, MAIN=15, STRING=16, 
		SOP=17, LENGTH=18, COEFCLASS=19, COEFSUBCLASS=20, DECIMAL_LITERAL=21, 
		BOOL_LITERAL=22, LPAREN=23, RPAREN=24, LBRACE=25, RBRACE=26, LBRACK=27, 
		RBRACK=28, SEMI=29, COMMA=30, DOT=31, ASSIGN=32, GT=33, LT=34, AND=35, 
		OR=36, BANG=37, ADD=38, SUB=39, MUL=40, DIV=41, DQ=42, WS=43, COMMENT=44, 
		LINE_COMMENT=45, IDENTIFIER=46;
	public static final String[] tokenNames = {
		"<INVALID>", "'boolean'", "'instanceof'", "'class'", "'else'", "'extends'", 
		"'if'", "'int'", "'new'", "'public'", "'return'", "'static'", "'this'", 
		"'void'", "'while'", "'main'", "'String'", "'System.out.println'", "'lenght'", 
		"'@CoeffectClass'", "'@CoeffectSubClass'", "DECIMAL_LITERAL", "BOOL_LITERAL", 
		"'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'='", 
		"'>'", "'<'", "'&&'", "'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'\"'", 
		"WS", "COMMENT", "LINE_COMMENT", "IDENTIFIER"
	};
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDecl = 2, RULE_coefClass = 3, 
		RULE_varDecl = 4, RULE_varDeclp = 5, RULE_methodDecl = 6, RULE_type = 7, 
		RULE_statement = 8, RULE_exp = 9;
	public static final String[] ruleNames = {
		"program", "mainClass", "classDecl", "coefClass", "varDecl", "varDeclp", 
		"methodDecl", "type", "statement", "exp"
	};

	@Override
	public String getGrammarFileName() { return "miniJava.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public miniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); mainClass();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << COEFCLASS) | (1L << COEFSUBCLASS))) != 0)) {
				{
				{
				setState(21); classDecl();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainClassContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SOP() { return getToken(miniJavaParser.SOP, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(miniJavaParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(miniJavaParser.LBRACE, i);
		}
		public TerminalNode STRING() { return getToken(miniJavaParser.STRING, 0); }
		public List<TerminalNode> RPAREN() { return getTokens(miniJavaParser.RPAREN); }
		public TerminalNode RBRACK() { return getToken(miniJavaParser.RBRACK, 0); }
		public TerminalNode LBRACK() { return getToken(miniJavaParser.LBRACK, 0); }
		public TerminalNode MAIN() { return getToken(miniJavaParser.MAIN, 0); }
		public TerminalNode RBRACE(int i) {
			return getToken(miniJavaParser.RBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(miniJavaParser.RBRACE); }
		public TerminalNode STATIC() { return getToken(miniJavaParser.STATIC, 0); }
		public TerminalNode RPAREN(int i) {
			return getToken(miniJavaParser.RPAREN, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(miniJavaParser.LPAREN); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public TerminalNode VOID() { return getToken(miniJavaParser.VOID, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(miniJavaParser.IDENTIFIER, i);
		}
		public TerminalNode PUBLIC() { return getToken(miniJavaParser.PUBLIC, 0); }
		public TerminalNode CLASS() { return getToken(miniJavaParser.CLASS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(miniJavaParser.IDENTIFIER); }
		public TerminalNode LPAREN(int i) {
			return getToken(miniJavaParser.LPAREN, i);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitMainClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); match(CLASS);
			setState(28); match(IDENTIFIER);
			setState(29); match(LBRACE);
			setState(30); match(PUBLIC);
			setState(31); match(STATIC);
			setState(32); match(VOID);
			setState(33); match(MAIN);
			setState(34); match(LPAREN);
			setState(35); match(STRING);
			setState(36); match(LBRACK);
			setState(37); match(RBRACK);
			setState(38); match(IDENTIFIER);
			setState(39); match(RPAREN);
			setState(40); match(LBRACE);
			setState(41); match(SOP);
			setState(42); match(LPAREN);
			setState(43); exp(0);
			setState(44); match(RPAREN);
			setState(45); match(SEMI);
			setState(46); match(RBRACE);
			setState(47); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public CoefClassContext coefClass() {
			return getRuleContext(CoefClassContext.class,0);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public TerminalNode RBRACE() { return getToken(miniJavaParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(miniJavaParser.LBRACE, 0); }
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public TerminalNode IDENTIFIER(int i) {
			return getToken(miniJavaParser.IDENTIFIER, i);
		}
		public TerminalNode CLASS() { return getToken(miniJavaParser.CLASS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(miniJavaParser.IDENTIFIER); }
		public TerminalNode EXTENDS() { return getToken(miniJavaParser.EXTENDS, 0); }
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if (_la==COEFCLASS || _la==COEFSUBCLASS) {
				{
				setState(49); coefClass();
				}
			}

			setState(52); match(CLASS);
			setState(53); match(IDENTIFIER);
			setState(56);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(54); match(EXTENDS);
				setState(55); match(IDENTIFIER);
				}
			}

			setState(58); match(LBRACE);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(59); varDecl();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(65); methodDecl();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CoefClassContext extends ParserRuleContext {
		public TerminalNode DQ(int i) {
			return getToken(miniJavaParser.DQ, i);
		}
		public List<TerminalNode> DQ() { return getTokens(miniJavaParser.DQ); }
		public TerminalNode COEFCLASS() { return getToken(miniJavaParser.COEFCLASS, 0); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public TerminalNode COEFSUBCLASS() { return getToken(miniJavaParser.COEFSUBCLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public CoefClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitCoefClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefClassContext coefClass() throws RecognitionException {
		CoefClassContext _localctx = new CoefClassContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_coefClass);
		try {
			setState(80);
			switch (_input.LA(1)) {
			case COEFCLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); match(COEFCLASS);
				}
				break;
			case COEFSUBCLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(74); match(COEFSUBCLASS);
				setState(75); match(LPAREN);
				setState(76); match(DQ);
				setState(77); match(IDENTIFIER);
				setState(78); match(DQ);
				setState(79); match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); type();
			setState(83); match(IDENTIFIER);
			setState(84); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclpContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public VarDeclpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitVarDeclp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclpContext varDeclp() throws RecognitionException {
		VarDeclpContext _localctx = new VarDeclpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDeclp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); type();
			setState(87); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarDeclpContext varDeclp(int i) {
			return getRuleContext(VarDeclpContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(miniJavaParser.LBRACE, 0); }
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<VarDeclpContext> varDeclp() {
			return getRuleContexts(VarDeclpContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(miniJavaParser.COMMA, i);
		}
		public TerminalNode RETURN() { return getToken(miniJavaParser.RETURN, 0); }
		public TerminalNode RBRACE() { return getToken(miniJavaParser.RBRACE, 0); }
		public TerminalNode STATIC() { return getToken(miniJavaParser.STATIC, 0); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(miniJavaParser.COMMA); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public TerminalNode PUBLIC() { return getToken(miniJavaParser.PUBLIC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89); match(PUBLIC);
			setState(91);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(90); match(STATIC);
				}
			}

			setState(93); type();
			setState(94); match(IDENTIFIER);
			setState(95); match(LPAREN);
			setState(104);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(96); varDeclp();
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(97); match(COMMA);
					setState(98); varDeclp();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(106); match(RPAREN);
			setState(107); match(LBRACE);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(108); varDecl();
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SOP) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(114); statement();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120); match(RETURN);
			setState(121); exp(0);
			setState(122); match(SEMI);
			setState(123); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode RBRACK() { return getToken(miniJavaParser.RBRACK, 0); }
		public TerminalNode BOOLEAN() { return getToken(miniJavaParser.BOOLEAN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public TerminalNode INT() { return getToken(miniJavaParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(miniJavaParser.LBRACK, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125); match(IDENTIFIER);
				setState(126); match(LBRACK);
				setState(127); match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128); match(BOOLEAN);
				setState(129); match(LBRACK);
				setState(130); match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131); match(INT);
				setState(132); match(LBRACK);
				setState(133); match(RBRACK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(134); match(BOOLEAN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(135); match(INT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(136); match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode ELSE() { return getToken(miniJavaParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(miniJavaParser.IF, 0); }
		public TerminalNode SOP() { return getToken(miniJavaParser.SOP, 0); }
		public TerminalNode LBRACE() { return getToken(miniJavaParser.LBRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public TerminalNode RBRACK() { return getToken(miniJavaParser.RBRACK, 0); }
		public TerminalNode WHILE() { return getToken(miniJavaParser.WHILE, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(miniJavaParser.LBRACK, 0); }
		public TerminalNode ASSIGN() { return getToken(miniJavaParser.ASSIGN, 0); }
		public TerminalNode RBRACE() { return getToken(miniJavaParser.RBRACE, 0); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(180);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139); match(LBRACE);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SOP) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(140); statement();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146); match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147); match(IF);
				setState(148); match(LPAREN);
				setState(149); exp(0);
				setState(150); match(RPAREN);
				setState(151); statement();
				setState(152); match(ELSE);
				setState(153); statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(155); match(WHILE);
				setState(156); match(LPAREN);
				setState(157); exp(0);
				setState(158); match(RPAREN);
				setState(159); statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(161); match(SOP);
				setState(162); match(LPAREN);
				setState(163); exp(0);
				setState(164); match(RPAREN);
				setState(165); match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(167); match(IDENTIFIER);
				setState(168); match(ASSIGN);
				setState(169); exp(0);
				setState(170); match(SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(172); match(IDENTIFIER);
				setState(173); match(LBRACK);
				setState(174); exp(0);
				setState(175); match(RBRACK);
				setState(176); match(ASSIGN);
				setState(177); exp(0);
				setState(178); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode RBRACK() { return getToken(miniJavaParser.RBRACK, 0); }
		public TerminalNode INT() { return getToken(miniJavaParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(miniJavaParser.LBRACK, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(miniJavaParser.COMMA, i);
		}
		public TerminalNode MUL() { return getToken(miniJavaParser.MUL, 0); }
		public TerminalNode DOT() { return getToken(miniJavaParser.DOT, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(miniJavaParser.BOOL_LITERAL, 0); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(miniJavaParser.COMMA); }
		public TerminalNode ADD() { return getToken(miniJavaParser.ADD, 0); }
		public TerminalNode AND() { return getToken(miniJavaParser.AND, 0); }
		public TerminalNode DIV() { return getToken(miniJavaParser.DIV, 0); }
		public TerminalNode LENGTH() { return getToken(miniJavaParser.LENGTH, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(miniJavaParser.DECIMAL_LITERAL, 0); }
		public TerminalNode SUB() { return getToken(miniJavaParser.SUB, 0); }
		public TerminalNode LT() { return getToken(miniJavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(miniJavaParser.GT, 0); }
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public TerminalNode BOOLEAN() { return getToken(miniJavaParser.BOOLEAN, 0); }
		public TerminalNode THIS() { return getToken(miniJavaParser.THIS, 0); }
		public TerminalNode OR() { return getToken(miniJavaParser.OR, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NEW() { return getToken(miniJavaParser.NEW, 0); }
		public TerminalNode INSTANCEOF() { return getToken(miniJavaParser.INSTANCEOF, 0); }
		public TerminalNode ASSIGN() { return getToken(miniJavaParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public TerminalNode BANG() { return getToken(miniJavaParser.BANG, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(183);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(184); exp(17);
				}
				break;
			case 2:
				{
				setState(185); match(LPAREN);
				setState(186); match(IDENTIFIER);
				setState(187); match(RPAREN);
				setState(188); exp(6);
				}
				break;
			case 3:
				{
				setState(189); match(NEW);
				setState(190); match(IDENTIFIER);
				setState(191); match(LBRACK);
				setState(192); exp(0);
				setState(193); match(RBRACK);
				}
				break;
			case 4:
				{
				setState(195); match(NEW);
				setState(196); match(BOOLEAN);
				setState(197); match(LBRACK);
				setState(198); exp(0);
				setState(199); match(RBRACK);
				}
				break;
			case 5:
				{
				setState(201); match(NEW);
				setState(202); match(INT);
				setState(203); match(LBRACK);
				setState(204); exp(0);
				setState(205); match(RBRACK);
				}
				break;
			case 6:
				{
				setState(207); match(NEW);
				setState(208); match(IDENTIFIER);
				setState(209); match(LPAREN);
				setState(210); match(RPAREN);
				}
				break;
			case 7:
				{
				setState(211); match(DECIMAL_LITERAL);
				}
				break;
			case 8:
				{
				setState(212); match(BOOL_LITERAL);
				}
				break;
			case 9:
				{
				setState(213); match(IDENTIFIER);
				}
				break;
			case 10:
				{
				setState(214); match(THIS);
				}
				break;
			case 11:
				{
				setState(215); match(LPAREN);
				setState(216); exp(0);
				setState(217); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(259);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(221);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(222);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(223); exp(16);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(224);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(225);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(226); exp(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(227);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(228);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(229); exp(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(230);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(231);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << GT) | (1L << LT))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(232); exp(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(233);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(234); match(LBRACK);
						setState(235); exp(0);
						setState(236); match(RBRACK);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(238);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(239); match(INSTANCEOF);
						setState(240); match(IDENTIFIER);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(241);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(242); match(DOT);
						setState(243); match(LENGTH);
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(244);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(245); match(DOT);
						setState(246); match(IDENTIFIER);
						setState(247); match(LPAREN);
						setState(256);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << LPAREN) | (1L << BANG) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
							{
							setState(248); exp(0);
							setState(253);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(249); match(COMMA);
								setState(250); exp(0);
								}
								}
								setState(255);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(258); match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 15);
		case 1: return precpred(_ctx, 14);
		case 2: return precpred(_ctx, 13);
		case 3: return precpred(_ctx, 12);
		case 4: return precpred(_ctx, 19);
		case 5: return precpred(_ctx, 18);
		case 6: return precpred(_ctx, 16);
		case 7: return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u010b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\5\4\65"+
		"\n\4\3\4\3\4\3\4\3\4\5\4;\n\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13\4\3\4\7\4"+
		"E\n\4\f\4\16\4H\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5S\n\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\5\b^\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b"+
		"f\n\b\f\b\16\bi\13\b\5\bk\n\b\3\b\3\b\3\b\7\bp\n\b\f\b\16\bs\13\b\3\b"+
		"\7\bv\n\b\f\b\16\by\13\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u008c\n\t\3\n\3\n\7\n\u0090\n\n\f\n\16\n\u0093"+
		"\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u00b7\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00de"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00fe\n\13\f\13\16\13\u0101\13\13\5\13\u0103\n\13"+
		"\3\13\7\13\u0106\n\13\f\13\16\13\u0109\13\13\3\13\2\3\24\f\2\4\6\b\n\f"+
		"\16\20\22\24\2\7\4\2\'\'))\3\2*+\3\2()\3\2%&\3\2\"$\u012a\2\26\3\2\2\2"+
		"\4\35\3\2\2\2\6\64\3\2\2\2\bR\3\2\2\2\nT\3\2\2\2\fX\3\2\2\2\16[\3\2\2"+
		"\2\20\u008b\3\2\2\2\22\u00b6\3\2\2\2\24\u00dd\3\2\2\2\26\32\5\4\3\2\27"+
		"\31\5\6\4\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33"+
		"\3\3\2\2\2\34\32\3\2\2\2\35\36\7\5\2\2\36\37\7\60\2\2\37 \7\33\2\2 !\7"+
		"\13\2\2!\"\7\r\2\2\"#\7\17\2\2#$\7\21\2\2$%\7\31\2\2%&\7\22\2\2&\'\7\35"+
		"\2\2\'(\7\36\2\2()\7\60\2\2)*\7\32\2\2*+\7\33\2\2+,\7\23\2\2,-\7\31\2"+
		"\2-.\5\24\13\2./\7\32\2\2/\60\7\37\2\2\60\61\7\34\2\2\61\62\7\34\2\2\62"+
		"\5\3\2\2\2\63\65\5\b\5\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66"+
		"\67\7\5\2\2\67:\7\60\2\289\7\7\2\29;\7\60\2\2:8\3\2\2\2:;\3\2\2\2;<\3"+
		"\2\2\2<@\7\33\2\2=?\5\n\6\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AF"+
		"\3\2\2\2B@\3\2\2\2CE\5\16\b\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2"+
		"GI\3\2\2\2HF\3\2\2\2IJ\7\34\2\2J\7\3\2\2\2KS\7\25\2\2LM\7\26\2\2MN\7\31"+
		"\2\2NO\7,\2\2OP\7\60\2\2PQ\7,\2\2QS\7\32\2\2RK\3\2\2\2RL\3\2\2\2S\t\3"+
		"\2\2\2TU\5\20\t\2UV\7\60\2\2VW\7\37\2\2W\13\3\2\2\2XY\5\20\t\2YZ\7\60"+
		"\2\2Z\r\3\2\2\2[]\7\13\2\2\\^\7\r\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_"+
		"`\5\20\t\2`a\7\60\2\2aj\7\31\2\2bg\5\f\7\2cd\7 \2\2df\5\f\7\2ec\3\2\2"+
		"\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jb\3\2\2\2jk\3\2\2"+
		"\2kl\3\2\2\2lm\7\32\2\2mq\7\33\2\2np\5\n\6\2on\3\2\2\2ps\3\2\2\2qo\3\2"+
		"\2\2qr\3\2\2\2rw\3\2\2\2sq\3\2\2\2tv\5\22\n\2ut\3\2\2\2vy\3\2\2\2wu\3"+
		"\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\f\2\2{|\5\24\13\2|}\7\37\2\2"+
		"}~\7\34\2\2~\17\3\2\2\2\177\u0080\7\60\2\2\u0080\u0081\7\35\2\2\u0081"+
		"\u008c\7\36\2\2\u0082\u0083\7\3\2\2\u0083\u0084\7\35\2\2\u0084\u008c\7"+
		"\36\2\2\u0085\u0086\7\t\2\2\u0086\u0087\7\35\2\2\u0087\u008c\7\36\2\2"+
		"\u0088\u008c\7\3\2\2\u0089\u008c\7\t\2\2\u008a\u008c\7\60\2\2\u008b\177"+
		"\3\2\2\2\u008b\u0082\3\2\2\2\u008b\u0085\3\2\2\2\u008b\u0088\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\21\3\2\2\2\u008d\u0091\7\33\2"+
		"\2\u008e\u0090\5\22\n\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0094\u00b7\7\34\2\2\u0095\u0096\7\b\2\2\u0096\u0097\7\31\2\2\u0097"+
		"\u0098\5\24\13\2\u0098\u0099\7\32\2\2\u0099\u009a\5\22\n\2\u009a\u009b"+
		"\7\6\2\2\u009b\u009c\5\22\n\2\u009c\u00b7\3\2\2\2\u009d\u009e\7\20\2\2"+
		"\u009e\u009f\7\31\2\2\u009f\u00a0\5\24\13\2\u00a0\u00a1\7\32\2\2\u00a1"+
		"\u00a2\5\22\n\2\u00a2\u00b7\3\2\2\2\u00a3\u00a4\7\23\2\2\u00a4\u00a5\7"+
		"\31\2\2\u00a5\u00a6\5\24\13\2\u00a6\u00a7\7\32\2\2\u00a7\u00a8\7\37\2"+
		"\2\u00a8\u00b7\3\2\2\2\u00a9\u00aa\7\60\2\2\u00aa\u00ab\7\"\2\2\u00ab"+
		"\u00ac\5\24\13\2\u00ac\u00ad\7\37\2\2\u00ad\u00b7\3\2\2\2\u00ae\u00af"+
		"\7\60\2\2\u00af\u00b0\7\35\2\2\u00b0\u00b1\5\24\13\2\u00b1\u00b2\7\36"+
		"\2\2\u00b2\u00b3\7\"\2\2\u00b3\u00b4\5\24\13\2\u00b4\u00b5\7\37\2\2\u00b5"+
		"\u00b7\3\2\2\2\u00b6\u008d\3\2\2\2\u00b6\u0095\3\2\2\2\u00b6\u009d\3\2"+
		"\2\2\u00b6\u00a3\3\2\2\2\u00b6\u00a9\3\2\2\2\u00b6\u00ae\3\2\2\2\u00b7"+
		"\23\3\2\2\2\u00b8\u00b9\b\13\1\2\u00b9\u00ba\t\2\2\2\u00ba\u00de\5\24"+
		"\13\23\u00bb\u00bc\7\31\2\2\u00bc\u00bd\7\60\2\2\u00bd\u00be\7\32\2\2"+
		"\u00be\u00de\5\24\13\b\u00bf\u00c0\7\n\2\2\u00c0\u00c1\7\60\2\2\u00c1"+
		"\u00c2\7\35\2\2\u00c2\u00c3\5\24\13\2\u00c3\u00c4\7\36\2\2\u00c4\u00de"+
		"\3\2\2\2\u00c5\u00c6\7\n\2\2\u00c6\u00c7\7\3\2\2\u00c7\u00c8\7\35\2\2"+
		"\u00c8\u00c9\5\24\13\2\u00c9\u00ca\7\36\2\2\u00ca\u00de\3\2\2\2\u00cb"+
		"\u00cc\7\n\2\2\u00cc\u00cd\7\t\2\2\u00cd\u00ce\7\35\2\2\u00ce\u00cf\5"+
		"\24\13\2\u00cf\u00d0\7\36\2\2\u00d0\u00de\3\2\2\2\u00d1\u00d2\7\n\2\2"+
		"\u00d2\u00d3\7\60\2\2\u00d3\u00d4\7\31\2\2\u00d4\u00de\7\32\2\2\u00d5"+
		"\u00de\7\27\2\2\u00d6\u00de\7\30\2\2\u00d7\u00de\7\60\2\2\u00d8\u00de"+
		"\7\16\2\2\u00d9\u00da\7\31\2\2\u00da\u00db\5\24\13\2\u00db\u00dc\7\32"+
		"\2\2\u00dc\u00de\3\2\2\2\u00dd\u00b8\3\2\2\2\u00dd\u00bb\3\2\2\2\u00dd"+
		"\u00bf\3\2\2\2\u00dd\u00c5\3\2\2\2\u00dd\u00cb\3\2\2\2\u00dd\u00d1\3\2"+
		"\2\2\u00dd\u00d5\3\2\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd"+
		"\u00d8\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\u0107\3\2\2\2\u00df\u00e0\f\21"+
		"\2\2\u00e0\u00e1\t\3\2\2\u00e1\u0106\5\24\13\22\u00e2\u00e3\f\20\2\2\u00e3"+
		"\u00e4\t\4\2\2\u00e4\u0106\5\24\13\21\u00e5\u00e6\f\17\2\2\u00e6\u00e7"+
		"\t\5\2\2\u00e7\u0106\5\24\13\20\u00e8\u00e9\f\16\2\2\u00e9\u00ea\t\6\2"+
		"\2\u00ea\u0106\5\24\13\17\u00eb\u00ec\f\25\2\2\u00ec\u00ed\7\35\2\2\u00ed"+
		"\u00ee\5\24\13\2\u00ee\u00ef\7\36\2\2\u00ef\u0106\3\2\2\2\u00f0\u00f1"+
		"\f\24\2\2\u00f1\u00f2\7\4\2\2\u00f2\u0106\7\60\2\2\u00f3\u00f4\f\22\2"+
		"\2\u00f4\u00f5\7!\2\2\u00f5\u0106\7\24\2\2\u00f6\u00f7\f\r\2\2\u00f7\u00f8"+
		"\7!\2\2\u00f8\u00f9\7\60\2\2\u00f9\u0102\7\31\2\2\u00fa\u00ff\5\24\13"+
		"\2\u00fb\u00fc\7 \2\2\u00fc\u00fe\5\24\13\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0103\3\2"+
		"\2\2\u0101\u00ff\3\2\2\2\u0102\u00fa\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0106\7\32\2\2\u0105\u00df\3\2\2\2\u0105\u00e2\3"+
		"\2\2\2\u0105\u00e5\3\2\2\2\u0105\u00e8\3\2\2\2\u0105\u00eb\3\2\2\2\u0105"+
		"\u00f0\3\2\2\2\u0105\u00f3\3\2\2\2\u0105\u00f6\3\2\2\2\u0106\u0109\3\2"+
		"\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\25\3\2\2\2\u0109\u0107"+
		"\3\2\2\2\25\32\64:@FR]gjqw\u008b\u0091\u00b6\u00dd\u00ff\u0102\u0105\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}