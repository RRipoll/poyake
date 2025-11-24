package com.jsantos.metadata.plugin.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMetaDslLexer extends Lexer {
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int RULE_ML_STRING=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_ML_SQLBLOCK=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_NATURAL=6;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_DOUBLE=7;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_NEGATIVEINT=8;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators

    public InternalMetaDslLexer() {;} 
    public InternalMetaDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMetaDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMetaDsl.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:11:7: ( 'CONFIGURATION' )
            // InternalMetaDsl.g:11:9: 'CONFIGURATION'
            {
            match("CONFIGURATION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:12:7: ( '{' )
            // InternalMetaDsl.g:12:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:13:7: ( 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' )
            // InternalMetaDsl.g:13:9: 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY'
            {
            match("DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:14:7: ( 'NONE' )
            // InternalMetaDsl.g:14:9: 'NONE'
            {
            match("NONE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:15:7: ( 'SEQUENCE' )
            // InternalMetaDsl.g:15:9: 'SEQUENCE'
            {
            match("SEQUENCE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:16:7: ( 'IDENTITY' )
            // InternalMetaDsl.g:16:9: 'IDENTITY'
            {
            match("IDENTITY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:17:7: ( 'MTCLASSNAME' )
            // InternalMetaDsl.g:17:9: 'MTCLASSNAME'
            {
            match("MTCLASSNAME"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:18:7: ( '}' )
            // InternalMetaDsl.g:18:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:19:7: ( 'LANG' )
            // InternalMetaDsl.g:19:9: 'LANG'
            {
            match("LANG"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:20:7: ( ';' )
            // InternalMetaDsl.g:20:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:21:7: ( 'CONSTANT' )
            // InternalMetaDsl.g:21:9: 'CONSTANT'
            {
            match("CONSTANT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:22:7: ( 'DATATYPE' )
            // InternalMetaDsl.g:22:9: 'DATATYPE'
            {
            match("DATATYPE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:23:7: ( 'SQLNATIVETYPE' )
            // InternalMetaDsl.g:23:9: 'SQLNATIVETYPE'
            {
            match("SQLNATIVETYPE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:24:7: ( 'WITHPRECISSIONANDSCALE' )
            // InternalMetaDsl.g:24:9: 'WITHPRECISSIONANDSCALE'
            {
            match("WITHPRECISSIONANDSCALE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:25:7: ( 'WITHLENGTH' )
            // InternalMetaDsl.g:25:9: 'WITHLENGTH'
            {
            match("WITHLENGTH"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:26:7: ( 'JAVATYPE' )
            // InternalMetaDsl.g:26:9: 'JAVATYPE'
            {
            match("JAVATYPE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:27:7: ( 'SUBTYPEOF' )
            // InternalMetaDsl.g:27:9: 'SUBTYPEOF'
            {
            match("SUBTYPEOF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:28:7: ( '(' )
            // InternalMetaDsl.g:28:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:29:7: ( 'MAX' )
            // InternalMetaDsl.g:29:9: 'MAX'
            {
            match("MAX"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:30:7: ( ',' )
            // InternalMetaDsl.g:30:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:31:7: ( ')' )
            // InternalMetaDsl.g:31:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:32:7: ( 'TABLESTEREOTYPE' )
            // InternalMetaDsl.g:32:9: 'TABLESTEREOTYPE'
            {
            match("TABLESTEREOTYPE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:33:7: ( 'COLUMNSTEREOTYPE' )
            // InternalMetaDsl.g:33:9: 'COLUMNSTEREOTYPE'
            {
            match("COLUMNSTEREOTYPE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:34:7: ( 'PATTERN' )
            // InternalMetaDsl.g:34:9: 'PATTERN'
            {
            match("PATTERN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:35:7: ( '.' )
            // InternalMetaDsl.g:35:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:36:7: ( 'FROMSQLFILE' )
            // InternalMetaDsl.g:36:9: 'FROMSQLFILE'
            {
            match("FROMSQLFILE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:37:7: ( 'TABLE' )
            // InternalMetaDsl.g:37:9: 'TABLE'
            {
            match("TABLE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:38:7: ( 'VIEW' )
            // InternalMetaDsl.g:38:9: 'VIEW'
            {
            match("VIEW"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:39:7: ( 'SQLQUERY' )
            // InternalMetaDsl.g:39:9: 'SQLQUERY'
            {
            match("SQLQUERY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:40:7: ( 'ENTITY' )
            // InternalMetaDsl.g:40:9: 'ENTITY'
            {
            match("ENTITY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:41:7: ( 'EXTENDS' )
            // InternalMetaDsl.g:41:9: 'EXTENDS'
            {
            match("EXTENDS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:42:7: ( 'STEREOTYPES' )
            // InternalMetaDsl.g:42:9: 'STEREOTYPES'
            {
            match("STEREOTYPES"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:43:7: ( 'SQLFILEDEPENDENCY' )
            // InternalMetaDsl.g:43:9: 'SQLFILEDEPENDENCY'
            {
            match("SQLFILEDEPENDENCY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:44:7: ( 'START' )
            // InternalMetaDsl.g:44:9: 'START'
            {
            match("START"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:45:7: ( 'WITH' )
            // InternalMetaDsl.g:45:9: 'WITH'
            {
            match("WITH"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:46:7: ( 'INCREMENT' )
            // InternalMetaDsl.g:46:9: 'INCREMENT'
            {
            match("INCREMENT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:47:7: ( 'BY' )
            // InternalMetaDsl.g:47:9: 'BY'
            {
            match("BY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:48:7: ( 'MINVALUE' )
            // InternalMetaDsl.g:48:9: 'MINVALUE'
            {
            match("MINVALUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:49:7: ( 'MAXVALUE' )
            // InternalMetaDsl.g:49:9: 'MAXVALUE'
            {
            match("MAXVALUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:50:7: ( 'CYCLE' )
            // InternalMetaDsl.g:50:9: 'CYCLE'
            {
            match("CYCLE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:51:7: ( 'CACHE' )
            // InternalMetaDsl.g:51:9: 'CACHE'
            {
            match("CACHE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:52:7: ( 'UQ' )
            // InternalMetaDsl.g:52:9: 'UQ'
            {
            match("UQ"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:53:7: ( 'PK' )
            // InternalMetaDsl.g:53:9: 'PK'
            {
            match("PK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:54:7: ( 'NOTNULL' )
            // InternalMetaDsl.g:54:9: 'NOTNULL'
            {
            match("NOTNULL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:55:7: ( 'SAMEAS' )
            // InternalMetaDsl.g:55:9: 'SAMEAS'
            {
            match("SAMEAS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:56:7: ( 'FKTO' )
            // InternalMetaDsl.g:56:9: 'FKTO'
            {
            match("FKTO"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:57:7: ( 'MULTIREFTO' )
            // InternalMetaDsl.g:57:9: 'MULTIREFTO'
            {
            match("MULTIREFTO"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:58:7: ( 'DEFAULT' )
            // InternalMetaDsl.g:58:9: 'DEFAULT'
            {
            match("DEFAULT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:59:7: ( 'TRANSIENT' )
            // InternalMetaDsl.g:59:9: 'TRANSIENT'
            {
            match("TRANSIENT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:60:7: ( 'IDGENERATOR' )
            // InternalMetaDsl.g:60:9: 'IDGENERATOR'
            {
            match("IDGENERATOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:61:7: ( 'BYRULE' )
            // InternalMetaDsl.g:61:9: 'BYRULE'
            {
            match("BYRULE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:62:7: ( 'GUID' )
            // InternalMetaDsl.g:62:9: 'GUID'
            {
            match("GUID"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:63:7: ( 'APPLICATION' )
            // InternalMetaDsl.g:63:9: 'APPLICATION'
            {
            match("APPLICATION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:64:7: ( 'ENUMETADATA' )
            // InternalMetaDsl.g:64:9: 'ENUMETADATA'
            {
            match("ENUMETADATA"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:65:7: ( 'METADATA' )
            // InternalMetaDsl.g:65:9: 'METADATA'
            {
            match("METADATA"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:66:7: ( 'FOR' )
            // InternalMetaDsl.g:66:9: 'FOR'
            {
            match("FOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:67:7: ( 'SHORTCODE' )
            // InternalMetaDsl.g:67:9: 'SHORTCODE'
            {
            match("SHORTCODE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:68:7: ( 'NULL' )
            // InternalMetaDsl.g:68:9: 'NULL'
            {
            match("NULL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:69:7: ( 'LABELS' )
            // InternalMetaDsl.g:69:9: 'LABELS'
            {
            match("LABELS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:70:7: ( 'SHORTLABEL' )
            // InternalMetaDsl.g:70:9: 'SHORTLABEL'
            {
            match("SHORTLABEL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:71:7: ( 'LONGLABEL' )
            // InternalMetaDsl.g:71:9: 'LONGLABEL'
            {
            match("LONGLABEL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:72:7: ( 'KEY' )
            // InternalMetaDsl.g:72:9: 'KEY'
            {
            match("KEY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:73:7: ( 'ATTRIBUTE' )
            // InternalMetaDsl.g:73:9: 'ATTRIBUTE'
            {
            match("ATTRIBUTE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:74:7: ( 'ENUMERATIONITEM' )
            // InternalMetaDsl.g:74:9: 'ENUMERATIONITEM'
            {
            match("ENUMERATIONITEM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:75:7: ( 'ENULABELS' )
            // InternalMetaDsl.g:75:9: 'ENULABELS'
            {
            match("ENULABELS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:76:7: ( 'DOCUMENTATION' )
            // InternalMetaDsl.g:76:9: 'DOCUMENTATION'
            {
            match("DOCUMENTATION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:77:7: ( 'QUERYSOURCE' )
            // InternalMetaDsl.g:77:9: 'QUERYSOURCE'
            {
            match("QUERYSOURCE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:78:7: ( 'FUNCTION' )
            // InternalMetaDsl.g:78:9: 'FUNCTION'
            {
            match("FUNCTION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:79:7: ( 'SQLFILE' )
            // InternalMetaDsl.g:79:9: 'SQLFILE'
            {
            match("SQLFILE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:80:7: ( 'SQLNATIVE' )
            // InternalMetaDsl.g:80:9: 'SQLNATIVE'
            {
            match("SQLNATIVE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:81:7: ( 'ID' )
            // InternalMetaDsl.g:81:9: 'ID'
            {
            match("ID"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:82:7: ( 'FILESTART' )
            // InternalMetaDsl.g:82:9: 'FILESTART'
            {
            match("FILESTART"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:83:7: ( 'FILEEND' )
            // InternalMetaDsl.g:83:9: 'FILEEND'
            {
            match("FILEEND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:84:7: ( 'DBTYPE' )
            // InternalMetaDsl.g:84:9: 'DBTYPE'
            {
            match("DBTYPE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:85:7: ( 'H2' )
            // InternalMetaDsl.g:85:9: 'H2'
            {
            match("H2"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:86:7: ( 'POSTGRESQL' )
            // InternalMetaDsl.g:86:9: 'POSTGRESQL'
            {
            match("POSTGRESQL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:87:7: ( 'MYSQL' )
            // InternalMetaDsl.g:87:9: 'MYSQL'
            {
            match("MYSQL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:88:7: ( 'SQLSERVER' )
            // InternalMetaDsl.g:88:9: 'SQLSERVER'
            {
            match("SQLSERVER"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:89:7: ( 'ORACLE' )
            // InternalMetaDsl.g:89:9: 'ORACLE'
            {
            match("ORACLE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3745:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalMetaDsl.g:3745:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalMetaDsl.g:3745:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalMetaDsl.g:3745:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalMetaDsl.g:3745:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMetaDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_NATURAL"
    public final void mRULE_NATURAL() throws RecognitionException {
        try {
            int _type = RULE_NATURAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3747:14: ( ( '0' .. '9' )+ )
            // InternalMetaDsl.g:3747:16: ( '0' .. '9' )+
            {
            // InternalMetaDsl.g:3747:16: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMetaDsl.g:3747:17: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NATURAL"

    // $ANTLR start "RULE_NEGATIVEINT"
    public final void mRULE_NEGATIVEINT() throws RecognitionException {
        try {
            int _type = RULE_NEGATIVEINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3749:18: ( ( '-' '0' .. '9' )+ )
            // InternalMetaDsl.g:3749:20: ( '-' '0' .. '9' )+
            {
            // InternalMetaDsl.g:3749:20: ( '-' '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='-') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMetaDsl.g:3749:21: '-' '0' .. '9'
            	    {
            	    match('-'); 
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEGATIVEINT"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3751:13: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // InternalMetaDsl.g:3751:15: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // InternalMetaDsl.g:3751:15: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMetaDsl.g:3751:15: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalMetaDsl.g:3751:20: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMetaDsl.g:3751:21: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            match('.'); 
            // InternalMetaDsl.g:3751:36: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMetaDsl.g:3751:37: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3753:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalMetaDsl.g:3753:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalMetaDsl.g:3753:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalMetaDsl.g:3753:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalMetaDsl.g:3753:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalMetaDsl.g:3753:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMetaDsl.g:3753:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:3753:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalMetaDsl.g:3753:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMetaDsl.g:3753:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMetaDsl.g:3753:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_STRING"
    public final void mRULE_ML_STRING() throws RecognitionException {
        try {
            int _type = RULE_ML_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3755:16: ( '<<<' ( options {greedy=false; } : . )* '>>>' )
            // InternalMetaDsl.g:3755:18: '<<<' ( options {greedy=false; } : . )* '>>>'
            {
            match("<<<"); 

            // InternalMetaDsl.g:3755:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='>') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='>') ) {
                        int LA11_3 = input.LA(3);

                        if ( (LA11_3=='>') ) {
                            alt11=2;
                        }
                        else if ( ((LA11_3>='\u0000' && LA11_3<='=')||(LA11_3>='?' && LA11_3<='\uFFFF')) ) {
                            alt11=1;
                        }


                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='=')||(LA11_1>='?' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='=')||(LA11_0>='?' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMetaDsl.g:3755:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match(">>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_STRING"

    // $ANTLR start "RULE_ML_SQLBLOCK"
    public final void mRULE_ML_SQLBLOCK() throws RecognitionException {
        try {
            int _type = RULE_ML_SQLBLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3757:18: ( '<SQLNATIVESTART>' ( options {greedy=false; } : . )* '</SQLNATIVEEND>' )
            // InternalMetaDsl.g:3757:20: '<SQLNATIVESTART>' ( options {greedy=false; } : . )* '</SQLNATIVEEND>'
            {
            match("<SQLNATIVESTART>"); 

            // InternalMetaDsl.g:3757:39: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // InternalMetaDsl.g:3757:67: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match("</SQLNATIVEEND>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_SQLBLOCK"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3759:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalMetaDsl.g:3759:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalMetaDsl.g:3759:24: ( options {greedy=false; } : . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='*') ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1=='/') ) {
                        alt13=2;
                    }
                    else if ( ((LA13_1>='\u0000' && LA13_1<='.')||(LA13_1>='0' && LA13_1<='\uFFFF')) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0>='\u0000' && LA13_0<=')')||(LA13_0>='+' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMetaDsl.g:3759:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3761:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalMetaDsl.g:3761:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalMetaDsl.g:3761:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMetaDsl.g:3761:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // InternalMetaDsl.g:3761:40: ( ( '\\r' )? '\\n' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\n'||LA16_0=='\r') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMetaDsl.g:3761:41: ( '\\r' )? '\\n'
                    {
                    // InternalMetaDsl.g:3761:41: ( '\\r' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='\r') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalMetaDsl.g:3761:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3763:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalMetaDsl.g:3763:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalMetaDsl.g:3763:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMetaDsl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMetaDsl.g:3765:16: ( . )
            // InternalMetaDsl.g:3765:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalMetaDsl.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | RULE_ID | RULE_NATURAL | RULE_NEGATIVEINT | RULE_DOUBLE | RULE_STRING | RULE_ML_STRING | RULE_ML_SQLBLOCK | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt18=90;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // InternalMetaDsl.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // InternalMetaDsl.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // InternalMetaDsl.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // InternalMetaDsl.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // InternalMetaDsl.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // InternalMetaDsl.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // InternalMetaDsl.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // InternalMetaDsl.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // InternalMetaDsl.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // InternalMetaDsl.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // InternalMetaDsl.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // InternalMetaDsl.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // InternalMetaDsl.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // InternalMetaDsl.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // InternalMetaDsl.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // InternalMetaDsl.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // InternalMetaDsl.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // InternalMetaDsl.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // InternalMetaDsl.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // InternalMetaDsl.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // InternalMetaDsl.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // InternalMetaDsl.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // InternalMetaDsl.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // InternalMetaDsl.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // InternalMetaDsl.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // InternalMetaDsl.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // InternalMetaDsl.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // InternalMetaDsl.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // InternalMetaDsl.g:1:178: T__43
                {
                mT__43(); 

                }
                break;
            case 30 :
                // InternalMetaDsl.g:1:184: T__44
                {
                mT__44(); 

                }
                break;
            case 31 :
                // InternalMetaDsl.g:1:190: T__45
                {
                mT__45(); 

                }
                break;
            case 32 :
                // InternalMetaDsl.g:1:196: T__46
                {
                mT__46(); 

                }
                break;
            case 33 :
                // InternalMetaDsl.g:1:202: T__47
                {
                mT__47(); 

                }
                break;
            case 34 :
                // InternalMetaDsl.g:1:208: T__48
                {
                mT__48(); 

                }
                break;
            case 35 :
                // InternalMetaDsl.g:1:214: T__49
                {
                mT__49(); 

                }
                break;
            case 36 :
                // InternalMetaDsl.g:1:220: T__50
                {
                mT__50(); 

                }
                break;
            case 37 :
                // InternalMetaDsl.g:1:226: T__51
                {
                mT__51(); 

                }
                break;
            case 38 :
                // InternalMetaDsl.g:1:232: T__52
                {
                mT__52(); 

                }
                break;
            case 39 :
                // InternalMetaDsl.g:1:238: T__53
                {
                mT__53(); 

                }
                break;
            case 40 :
                // InternalMetaDsl.g:1:244: T__54
                {
                mT__54(); 

                }
                break;
            case 41 :
                // InternalMetaDsl.g:1:250: T__55
                {
                mT__55(); 

                }
                break;
            case 42 :
                // InternalMetaDsl.g:1:256: T__56
                {
                mT__56(); 

                }
                break;
            case 43 :
                // InternalMetaDsl.g:1:262: T__57
                {
                mT__57(); 

                }
                break;
            case 44 :
                // InternalMetaDsl.g:1:268: T__58
                {
                mT__58(); 

                }
                break;
            case 45 :
                // InternalMetaDsl.g:1:274: T__59
                {
                mT__59(); 

                }
                break;
            case 46 :
                // InternalMetaDsl.g:1:280: T__60
                {
                mT__60(); 

                }
                break;
            case 47 :
                // InternalMetaDsl.g:1:286: T__61
                {
                mT__61(); 

                }
                break;
            case 48 :
                // InternalMetaDsl.g:1:292: T__62
                {
                mT__62(); 

                }
                break;
            case 49 :
                // InternalMetaDsl.g:1:298: T__63
                {
                mT__63(); 

                }
                break;
            case 50 :
                // InternalMetaDsl.g:1:304: T__64
                {
                mT__64(); 

                }
                break;
            case 51 :
                // InternalMetaDsl.g:1:310: T__65
                {
                mT__65(); 

                }
                break;
            case 52 :
                // InternalMetaDsl.g:1:316: T__66
                {
                mT__66(); 

                }
                break;
            case 53 :
                // InternalMetaDsl.g:1:322: T__67
                {
                mT__67(); 

                }
                break;
            case 54 :
                // InternalMetaDsl.g:1:328: T__68
                {
                mT__68(); 

                }
                break;
            case 55 :
                // InternalMetaDsl.g:1:334: T__69
                {
                mT__69(); 

                }
                break;
            case 56 :
                // InternalMetaDsl.g:1:340: T__70
                {
                mT__70(); 

                }
                break;
            case 57 :
                // InternalMetaDsl.g:1:346: T__71
                {
                mT__71(); 

                }
                break;
            case 58 :
                // InternalMetaDsl.g:1:352: T__72
                {
                mT__72(); 

                }
                break;
            case 59 :
                // InternalMetaDsl.g:1:358: T__73
                {
                mT__73(); 

                }
                break;
            case 60 :
                // InternalMetaDsl.g:1:364: T__74
                {
                mT__74(); 

                }
                break;
            case 61 :
                // InternalMetaDsl.g:1:370: T__75
                {
                mT__75(); 

                }
                break;
            case 62 :
                // InternalMetaDsl.g:1:376: T__76
                {
                mT__76(); 

                }
                break;
            case 63 :
                // InternalMetaDsl.g:1:382: T__77
                {
                mT__77(); 

                }
                break;
            case 64 :
                // InternalMetaDsl.g:1:388: T__78
                {
                mT__78(); 

                }
                break;
            case 65 :
                // InternalMetaDsl.g:1:394: T__79
                {
                mT__79(); 

                }
                break;
            case 66 :
                // InternalMetaDsl.g:1:400: T__80
                {
                mT__80(); 

                }
                break;
            case 67 :
                // InternalMetaDsl.g:1:406: T__81
                {
                mT__81(); 

                }
                break;
            case 68 :
                // InternalMetaDsl.g:1:412: T__82
                {
                mT__82(); 

                }
                break;
            case 69 :
                // InternalMetaDsl.g:1:418: T__83
                {
                mT__83(); 

                }
                break;
            case 70 :
                // InternalMetaDsl.g:1:424: T__84
                {
                mT__84(); 

                }
                break;
            case 71 :
                // InternalMetaDsl.g:1:430: T__85
                {
                mT__85(); 

                }
                break;
            case 72 :
                // InternalMetaDsl.g:1:436: T__86
                {
                mT__86(); 

                }
                break;
            case 73 :
                // InternalMetaDsl.g:1:442: T__87
                {
                mT__87(); 

                }
                break;
            case 74 :
                // InternalMetaDsl.g:1:448: T__88
                {
                mT__88(); 

                }
                break;
            case 75 :
                // InternalMetaDsl.g:1:454: T__89
                {
                mT__89(); 

                }
                break;
            case 76 :
                // InternalMetaDsl.g:1:460: T__90
                {
                mT__90(); 

                }
                break;
            case 77 :
                // InternalMetaDsl.g:1:466: T__91
                {
                mT__91(); 

                }
                break;
            case 78 :
                // InternalMetaDsl.g:1:472: T__92
                {
                mT__92(); 

                }
                break;
            case 79 :
                // InternalMetaDsl.g:1:478: T__93
                {
                mT__93(); 

                }
                break;
            case 80 :
                // InternalMetaDsl.g:1:484: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 81 :
                // InternalMetaDsl.g:1:492: RULE_NATURAL
                {
                mRULE_NATURAL(); 

                }
                break;
            case 82 :
                // InternalMetaDsl.g:1:505: RULE_NEGATIVEINT
                {
                mRULE_NEGATIVEINT(); 

                }
                break;
            case 83 :
                // InternalMetaDsl.g:1:522: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 84 :
                // InternalMetaDsl.g:1:534: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 85 :
                // InternalMetaDsl.g:1:546: RULE_ML_STRING
                {
                mRULE_ML_STRING(); 

                }
                break;
            case 86 :
                // InternalMetaDsl.g:1:561: RULE_ML_SQLBLOCK
                {
                mRULE_ML_SQLBLOCK(); 

                }
                break;
            case 87 :
                // InternalMetaDsl.g:1:578: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 88 :
                // InternalMetaDsl.g:1:594: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 89 :
                // InternalMetaDsl.g:1:610: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 90 :
                // InternalMetaDsl.g:1:618: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA12_eotS =
        "\21\uffff";
    static final String DFA12_eofS =
        "\21\uffff";
    static final String DFA12_minS =
        "\2\0\1\uffff\15\0\1\uffff";
    static final String DFA12_maxS =
        "\2\uffff\1\uffff\15\uffff\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\1\15\uffff\1\2";
    static final String DFA12_specialS =
        "\1\2\1\5\1\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\0\1\1\1\3\1\4\1\uffff}>";
    static final String[] DFA12_transitionS = {
            "\74\2\1\1\uffc3\2",
            "\57\2\1\3\uffd0\2",
            "",
            "\123\2\1\4\uffac\2",
            "\121\2\1\5\uffae\2",
            "\114\2\1\6\uffb3\2",
            "\116\2\1\7\uffb1\2",
            "\101\2\1\10\uffbe\2",
            "\124\2\1\11\uffab\2",
            "\111\2\1\12\uffb6\2",
            "\126\2\1\13\uffa9\2",
            "\105\2\1\14\uffba\2",
            "\105\2\1\15\uffba\2",
            "\116\2\1\16\uffb1\2",
            "\104\2\1\17\uffbb\2",
            "\76\2\1\20\uffc1\2",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "()* loopback of 3757:39: ( options {greedy=false; } : . )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_12 = input.LA(1);

                        s = -1;
                        if ( (LA12_12=='E') ) {s = 13;}

                        else if ( ((LA12_12>='\u0000' && LA12_12<='D')||(LA12_12>='F' && LA12_12<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_13 = input.LA(1);

                        s = -1;
                        if ( (LA12_13=='N') ) {s = 14;}

                        else if ( ((LA12_13>='\u0000' && LA12_13<='M')||(LA12_13>='O' && LA12_13<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='<') ) {s = 1;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<=';')||(LA12_0>='=' && LA12_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_14 = input.LA(1);

                        s = -1;
                        if ( (LA12_14=='D') ) {s = 15;}

                        else if ( ((LA12_14>='\u0000' && LA12_14<='C')||(LA12_14>='E' && LA12_14<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_15 = input.LA(1);

                        s = -1;
                        if ( (LA12_15=='>') ) {s = 16;}

                        else if ( ((LA12_15>='\u0000' && LA12_15<='=')||(LA12_15>='?' && LA12_15<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_1 = input.LA(1);

                        s = -1;
                        if ( (LA12_1=='/') ) {s = 3;}

                        else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA12_3 = input.LA(1);

                        s = -1;
                        if ( (LA12_3=='S') ) {s = 4;}

                        else if ( ((LA12_3>='\u0000' && LA12_3<='R')||(LA12_3>='T' && LA12_3<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA12_4 = input.LA(1);

                        s = -1;
                        if ( (LA12_4=='Q') ) {s = 5;}

                        else if ( ((LA12_4>='\u0000' && LA12_4<='P')||(LA12_4>='R' && LA12_4<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA12_5 = input.LA(1);

                        s = -1;
                        if ( (LA12_5=='L') ) {s = 6;}

                        else if ( ((LA12_5>='\u0000' && LA12_5<='K')||(LA12_5>='M' && LA12_5<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA12_6 = input.LA(1);

                        s = -1;
                        if ( (LA12_6=='N') ) {s = 7;}

                        else if ( ((LA12_6>='\u0000' && LA12_6<='M')||(LA12_6>='O' && LA12_6<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA12_7 = input.LA(1);

                        s = -1;
                        if ( (LA12_7=='A') ) {s = 8;}

                        else if ( ((LA12_7>='\u0000' && LA12_7<='@')||(LA12_7>='B' && LA12_7<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA12_8 = input.LA(1);

                        s = -1;
                        if ( (LA12_8=='T') ) {s = 9;}

                        else if ( ((LA12_8>='\u0000' && LA12_8<='S')||(LA12_8>='U' && LA12_8<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA12_9 = input.LA(1);

                        s = -1;
                        if ( (LA12_9=='I') ) {s = 10;}

                        else if ( ((LA12_9>='\u0000' && LA12_9<='H')||(LA12_9>='J' && LA12_9<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA12_10 = input.LA(1);

                        s = -1;
                        if ( (LA12_10=='V') ) {s = 11;}

                        else if ( ((LA12_10>='\u0000' && LA12_10<='U')||(LA12_10>='W' && LA12_10<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA12_11 = input.LA(1);

                        s = -1;
                        if ( (LA12_11=='E') ) {s = 12;}

                        else if ( ((LA12_11>='\u0000' && LA12_11<='D')||(LA12_11>='F' && LA12_11<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA18_eotS =
        "\1\uffff\1\53\1\uffff\5\53\1\uffff\1\53\1\uffff\2\53\3\uffff\2\53\1\uffff\13\53\1\47\1\uffff\1\141\5\47\2\uffff\3\53\2\uffff\14\53\1\177\7\53\1\uffff\2\53\1\uffff\2\53\3\uffff\3\53\1\u008f\1\53\1\uffff\10\53\1\u009b\1\u009c\5\53\1\u00a2\1\53\1\uffff\1\141\1\uffff\1\u00a4\6\uffff\24\53\1\uffff\2\53\1\u00c0\14\53\1\uffff\3\53\1\u00d0\7\53\2\uffff\3\53\1\u00dc\1\53\1\uffff\1\53\1\uffff\11\53\1\u00e8\1\53\1\u00ea\17\53\1\uffff\4\53\1\u00fe\2\53\1\u0103\6\53\1\u010a\1\uffff\2\53\1\u010e\5\53\1\u0114\2\53\1\uffff\5\53\1\u011c\1\u011d\4\53\1\uffff\1\53\1\uffff\7\53\1\u012a\12\53\1\u0136\1\uffff\4\53\1\uffff\1\53\1\u013d\4\53\1\uffff\3\53\1\uffff\5\53\1\uffff\7\53\2\uffff\3\53\1\u0155\10\53\1\uffff\1\u015e\12\53\1\uffff\1\u0169\5\53\1\uffff\7\53\1\u0176\4\53\1\u017b\3\53\1\u017f\3\53\1\u0184\2\53\1\uffff\1\u0187\3\53\1\u018c\3\53\1\uffff\12\53\1\uffff\6\53\1\u01a0\4\53\1\u01a5\1\uffff\3\53\1\u01a9\1\uffff\3\53\1\uffff\1\53\1\u01ae\2\53\1\uffff\1\u01b1\1\53\1\uffff\1\u01b3\1\53\1\u01b5\1\53\1\uffff\5\53\1\u01bc\3\53\1\u01c0\1\u01c1\1\53\1\u01c3\3\53\1\u01c7\2\53\1\uffff\2\53\1\u01cc\1\53\1\uffff\3\53\1\uffff\4\53\1\uffff\2\53\1\uffff\1\53\1\uffff\1\u01d9\1\uffff\1\53\1\u01db\1\u01dc\1\53\1\u01de\1\53\1\uffff\1\53\1\u01e1\1\53\2\uffff\1\53\1\uffff\1\u01e4\2\53\1\uffff\1\53\1\u01e8\2\53\1\uffff\1\u01eb\2\53\1\u01ee\1\53\1\u01f0\6\53\1\uffff\1\53\2\uffff\1\53\1\uffff\1\u01f9\1\53\1\uffff\1\53\1\u01fc\1\uffff\1\53\1\u01fe\1\53\1\uffff\1\u0200\1\53\1\uffff\2\53\1\uffff\1\53\1\uffff\7\53\1\u020c\1\uffff\1\u020d\1\u020e\1\uffff\1\53\1\uffff\1\53\1\uffff\1\u0211\1\u0212\1\53\1\u0214\1\u0215\6\53\3\uffff\2\53\2\uffff\1\53\2\uffff\1\u021f\2\53\1\u0222\1\u0223\4\53\1\uffff\2\53\2\uffff\10\53\1\u0232\1\u0233\1\u0234\3\53\3\uffff\1\53\1\u0239\2\53\1\uffff\10\53\1\u0244\1\53\1\uffff\17\53\1\u0255\1\uffff";
    static final String DFA18_eofS =
        "\u0256\uffff";
    static final String DFA18_minS =
        "\1\0\1\101\1\uffff\1\101\1\117\1\101\1\104\1\101\1\uffff\1\101\1\uffff\1\111\1\101\3\uffff\2\101\1\uffff\2\111\1\116\1\131\1\121\1\125\1\120\1\105\1\125\1\62\1\122\1\101\1\uffff\1\56\1\60\2\0\1\74\1\52\2\uffff\1\114\2\103\2\uffff\1\106\1\124\1\103\1\124\1\116\1\114\1\121\1\114\1\102\1\101\1\115\1\117\1\60\2\103\1\130\1\116\1\114\1\124\1\123\1\uffff\1\102\1\116\1\uffff\1\124\1\126\3\uffff\1\102\1\101\1\124\1\60\1\123\1\uffff\1\117\1\124\1\122\1\116\1\114\1\105\2\124\2\60\1\111\1\120\1\124\1\131\1\105\1\60\1\101\1\uffff\1\56\1\uffff\1\56\6\uffff\1\106\1\125\1\114\1\110\2\101\1\125\1\131\1\105\1\116\1\114\1\125\1\106\1\124\2\122\1\105\1\122\1\116\1\105\1\uffff\1\122\1\114\1\60\1\126\1\124\1\101\1\121\1\107\1\105\1\107\1\110\1\101\1\114\1\116\1\124\1\uffff\1\124\1\115\1\117\1\60\1\103\1\105\1\127\1\111\1\114\1\105\1\125\2\uffff\1\104\1\114\1\122\1\60\1\122\1\uffff\1\103\1\uffff\1\111\1\124\1\115\2\105\1\125\1\124\1\115\1\120\1\60\1\125\1\60\1\105\1\101\1\125\1\111\1\105\1\131\1\105\1\124\1\101\2\124\1\116\1\105\2\101\1\uffff\1\101\1\111\1\104\1\114\1\60\2\114\1\60\1\124\1\105\1\123\1\105\1\107\1\123\1\60\1\uffff\1\124\1\105\1\60\1\124\1\105\1\101\1\116\1\114\1\60\2\111\1\uffff\1\131\1\114\1\107\1\101\1\116\2\60\1\114\1\131\2\105\1\uffff\1\114\1\uffff\1\116\1\124\1\105\1\114\1\122\1\120\1\117\1\60\1\123\1\103\1\111\1\105\1\115\1\123\2\114\1\122\1\101\1\60\1\uffff\1\123\1\101\1\122\1\105\1\uffff\1\131\1\60\1\111\2\122\1\121\1\uffff\1\111\1\124\1\116\1\uffff\1\131\1\122\1\102\1\104\1\105\1\uffff\1\103\1\102\1\123\1\105\1\125\1\116\1\123\2\uffff\1\124\1\120\1\116\1\60\1\114\1\103\1\111\1\122\1\105\1\126\1\105\1\124\1\uffff\1\60\1\117\1\101\1\124\1\122\1\105\1\123\2\125\1\105\1\124\1\uffff\1\60\1\102\1\105\1\116\1\120\1\124\1\uffff\1\105\1\116\1\105\1\114\1\117\1\101\1\104\1\60\2\101\1\105\1\123\1\60\1\101\1\125\1\117\1\60\1\122\2\124\1\60\1\105\1\124\1\uffff\1\60\1\105\1\126\1\131\1\60\1\105\1\117\1\131\1\uffff\1\104\1\102\1\131\1\101\2\116\2\105\1\106\1\101\1\uffff\1\105\1\103\1\107\2\105\1\116\1\60\1\123\1\106\1\116\1\122\1\60\1\uffff\1\104\1\124\1\114\1\60\1\uffff\2\124\1\125\1\uffff\1\101\1\60\1\105\1\120\1\uffff\1\60\1\101\1\uffff\1\60\1\105\1\60\1\105\1\uffff\1\122\1\106\1\120\2\105\1\60\2\124\1\101\2\60\1\124\1\60\1\114\1\111\1\124\1\60\1\122\1\124\1\uffff\1\121\1\111\1\60\1\124\1\uffff\1\101\1\111\1\123\1\uffff\1\111\1\105\1\122\1\124\1\uffff\2\122\1\uffff\1\124\1\uffff\1\60\1\uffff\1\120\2\60\1\105\1\60\1\114\1\uffff\1\117\1\60\1\115\2\uffff\1\117\1\uffff\1\60\1\123\1\110\1\uffff\1\105\1\60\2\114\1\uffff\1\60\1\124\1\117\1\60\1\117\1\60\1\103\1\111\1\105\2\111\1\131\1\uffff\1\105\2\uffff\1\123\1\uffff\1\60\1\122\1\uffff\1\105\1\60\1\uffff\1\123\1\60\1\117\1\uffff\1\60\1\105\1\uffff\1\101\1\116\1\uffff\1\116\1\uffff\1\105\2\117\1\115\1\117\1\120\1\116\1\60\1\uffff\2\60\1\uffff\1\111\1\uffff\1\124\1\uffff\2\60\1\111\2\60\1\116\1\124\1\101\1\116\1\105\1\104\3\uffff\1\117\1\131\2\uffff\1\124\2\uffff\1\60\1\131\1\122\2\60\1\105\1\116\1\120\1\105\1\uffff\1\120\1\131\2\uffff\1\116\1\101\1\105\1\115\1\105\1\137\1\103\1\116\3\60\1\113\1\131\1\104\3\uffff\1\105\1\60\1\123\1\131\1\uffff\1\103\1\137\1\101\1\107\1\114\2\105\1\116\1\60\1\105\1\uffff\1\122\1\101\1\124\1\111\1\117\1\116\1\137\1\123\1\124\1\122\1\101\1\124\1\105\1\107\1\131\1\60\1\uffff";
    static final String DFA18_maxS =
        "\1\uffff\1\131\1\uffff\1\117\2\125\1\116\1\131\1\uffff\1\117\1\uffff\1\111\1\101\3\uffff\1\122\1\117\1\uffff\1\125\1\111\1\130\1\131\1\121\1\125\1\124\1\105\1\125\1\62\1\122\1\172\1\uffff\2\71\2\uffff\1\123\1\57\2\uffff\1\116\2\103\2\uffff\1\106\1\124\1\103\2\124\1\114\1\121\1\114\1\102\1\105\1\115\1\117\1\172\2\103\1\130\1\116\1\114\1\124\1\123\1\uffff\2\116\1\uffff\1\124\1\126\3\uffff\1\102\1\101\1\124\1\172\1\123\1\uffff\1\117\1\124\1\122\1\116\1\114\1\105\1\125\1\124\2\172\1\111\1\120\1\124\1\131\1\105\1\172\1\101\1\uffff\1\71\1\uffff\1\71\6\uffff\1\123\1\125\1\114\1\110\2\101\1\125\1\131\1\105\1\116\1\114\1\125\1\123\1\124\2\122\1\105\1\122\1\116\1\105\1\uffff\1\122\1\114\1\172\1\126\1\124\1\101\1\121\1\107\1\105\1\107\1\110\1\101\1\114\1\116\1\124\1\uffff\1\124\1\115\1\117\1\172\1\103\1\105\1\127\1\111\1\115\1\105\1\125\2\uffff\1\104\1\114\1\122\1\172\1\122\1\uffff\1\103\1\uffff\1\111\1\124\1\115\2\105\1\125\1\124\1\115\1\120\1\172\1\125\1\172\1\105\1\101\1\125\1\111\1\105\1\131\1\105\1\124\1\101\2\124\1\116\1\105\2\101\1\uffff\1\101\1\111\1\104\1\114\1\172\2\114\1\172\1\124\1\105\1\123\1\105\1\107\1\123\1\172\1\uffff\1\124\1\123\1\172\1\124\1\105\1\101\1\116\1\114\1\172\2\111\1\uffff\1\131\1\114\1\107\1\101\1\116\2\172\1\114\1\131\2\105\1\uffff\1\114\1\uffff\1\116\1\124\1\105\1\114\1\122\1\120\1\117\1\172\1\123\1\114\1\111\1\105\1\115\1\123\2\114\1\122\1\101\1\172\1\uffff\1\123\1\101\1\122\1\105\1\uffff\1\131\1\172\1\111\2\122\1\121\1\uffff\1\111\1\124\1\116\1\uffff\1\131\1\124\1\102\1\104\1\105\1\uffff\1\103\1\102\1\123\1\105\1\125\1\116\1\123\2\uffff\1\124\1\120\1\116\1\172\1\114\1\103\1\111\1\122\1\105\1\126\1\105\1\124\1\uffff\1\172\1\117\1\101\1\124\1\122\1\105\1\123\2\125\1\105\1\124\1\uffff\1\172\1\102\1\105\1\116\1\120\1\124\1\uffff\1\105\1\116\1\105\1\114\1\117\1\101\1\104\1\172\2\101\1\105\1\123\1\172\1\101\1\125\1\117\1\172\1\122\2\124\1\172\1\105\1\124\1\uffff\1\172\1\105\1\126\1\131\1\172\1\105\1\117\1\131\1\uffff\1\104\1\102\1\131\1\101\2\116\2\105\1\106\1\101\1\uffff\1\105\1\103\1\107\2\105\1\116\1\172\1\123\1\106\1\116\1\122\1\172\1\uffff\1\104\1\124\1\114\1\172\1\uffff\2\124\1\125\1\uffff\1\101\1\172\1\105\1\120\1\uffff\1\172\1\101\1\uffff\1\172\1\105\1\172\1\105\1\uffff\1\122\1\106\1\120\2\105\1\172\2\124\1\101\2\172\1\124\1\172\1\114\1\111\1\124\1\172\1\122\1\124\1\uffff\1\121\1\111\1\172\1\124\1\uffff\1\101\1\111\1\123\1\uffff\1\111\1\105\1\122\1\124\1\uffff\2\122\1\uffff\1\124\1\uffff\1\172\1\uffff\1\120\2\172\1\105\1\172\1\114\1\uffff\1\117\1\172\1\115\2\uffff\1\117\1\uffff\1\172\1\123\1\110\1\uffff\1\105\1\172\2\114\1\uffff\1\172\1\124\1\117\1\172\1\117\1\172\1\103\1\111\1\105\2\111\1\131\1\uffff\1\105\2\uffff\1\123\1\uffff\1\172\1\122\1\uffff\1\105\1\172\1\uffff\1\123\1\172\1\117\1\uffff\1\172\1\105\1\uffff\1\101\1\116\1\uffff\1\116\1\uffff\1\105\2\117\1\115\1\117\1\120\1\116\1\172\1\uffff\2\172\1\uffff\1\111\1\uffff\1\124\1\uffff\2\172\1\111\2\172\1\116\1\124\1\101\1\116\1\105\1\104\3\uffff\1\117\1\131\2\uffff\1\124\2\uffff\1\172\1\131\1\122\2\172\1\105\1\116\1\120\1\105\1\uffff\1\120\1\131\2\uffff\1\116\1\101\1\105\1\115\1\105\1\137\1\103\1\116\3\172\1\113\1\131\1\104\3\uffff\1\105\1\172\1\123\1\131\1\uffff\1\103\1\137\1\101\1\107\1\114\2\105\1\116\1\172\1\105\1\uffff\1\122\1\101\1\124\1\111\1\117\1\116\1\137\1\123\1\124\1\122\1\101\1\124\1\105\1\107\1\131\1\172\1\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\5\uffff\1\10\1\uffff\1\12\2\uffff\1\22\1\24\1\25\2\uffff\1\31\14\uffff\1\120\6\uffff\1\131\1\132\3\uffff\1\120\1\2\24\uffff\1\10\2\uffff\1\12\2\uffff\1\22\1\24\1\25\5\uffff\1\31\21\uffff\1\121\1\uffff\1\123\1\uffff\1\124\1\125\1\126\1\127\1\130\1\131\24\uffff\1\107\17\uffff\1\53\13\uffff\1\45\1\52\5\uffff\1\113\1\uffff\1\122\33\uffff\1\23\17\uffff\1\70\13\uffff\1\76\13\uffff\1\4\1\uffff\1\72\23\uffff\1\11\4\uffff\1\43\6\uffff\1\56\3\uffff\1\34\5\uffff\1\64\7\uffff\1\50\1\51\14\uffff\1\42\13\uffff\1\115\6\uffff\1\33\27\uffff\1\112\10\uffff\1\55\12\uffff\1\73\14\uffff\1\36\4\uffff\1\63\3\uffff\1\117\4\uffff\1\60\2\uffff\1\54\4\uffff\1\105\23\uffff\1\30\4\uffff\1\111\3\uffff\1\37\4\uffff\1\13\2\uffff\1\14\1\uffff\1\5\1\uffff\1\35\6\uffff\1\6\3\uffff\1\47\1\46\1\uffff\1\67\3\uffff\1\20\4\uffff\1\104\14\uffff\1\106\1\uffff\1\116\1\21\1\uffff\1\71\2\uffff\1\44\2\uffff\1\75\3\uffff\1\61\2\uffff\1\110\2\uffff\1\101\1\uffff\1\77\10\uffff\1\74\2\uffff\1\57\1\uffff\1\17\1\uffff\1\114\13\uffff\1\40\1\62\1\7\2\uffff\1\32\1\66\1\uffff\1\65\1\103\11\uffff\1\1\2\uffff\1\102\1\15\16\uffff\1\26\1\100\1\27\4\uffff\1\41\12\uffff\1\16\20\uffff\1\3";
    static final String DFA18_specialS =
        "\1\1\41\uffff\1\2\1\0\u0232\uffff}>";
    static final String[] DFA18_transitionS = {
            "\11\47\2\46\2\47\1\46\22\47\1\46\1\47\1\42\4\47\1\43\1\15\1\17\2\47\1\16\1\41\1\22\1\45\12\40\1\47\1\12\1\44\4\47\1\31\1\26\1\1\1\3\1\25\1\23\1\30\1\34\1\6\1\14\1\32\1\11\1\7\1\4\1\35\1\21\1\33\1\37\1\5\1\20\1\27\1\24\1\13\3\37\3\47\1\36\1\37\1\47\32\37\1\2\1\47\1\10\uff82\47",
            "\1\52\15\uffff\1\50\11\uffff\1\51",
            "",
            "\1\56\1\60\2\uffff\1\55\11\uffff\1\57",
            "\1\61\5\uffff\1\62",
            "\1\67\3\uffff\1\63\2\uffff\1\70\10\uffff\1\64\2\uffff\1\66\1\65",
            "\1\71\11\uffff\1\72",
            "\1\74\3\uffff\1\77\3\uffff\1\75\12\uffff\1\73\1\76\3\uffff\1\100",
            "",
            "\1\102\15\uffff\1\103",
            "",
            "\1\105",
            "\1\106",
            "",
            "",
            "",
            "\1\112\20\uffff\1\113",
            "\1\114\11\uffff\1\115\3\uffff\1\116",
            "",
            "\1\124\1\uffff\1\121\3\uffff\1\122\2\uffff\1\120\2\uffff\1\123",
            "\1\125",
            "\1\126\11\uffff\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133\3\uffff\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\143\1\uffff\12\142",
            "\12\144",
            "\0\145",
            "\0\145",
            "\1\146\26\uffff\1\147",
            "\1\150\4\uffff\1\151",
            "",
            "",
            "\1\154\1\uffff\1\153",
            "\1\155",
            "\1\156",
            "",
            "",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163\5\uffff\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\172\3\uffff\1\171",
            "\1\173",
            "\1\174",
            "\12\53\7\uffff\4\53\1\175\1\53\1\176\23\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0088\13\uffff\1\u0087",
            "\1\u0089",
            "",
            "\1\u008a",
            "\1\u008b",
            "",
            "",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0090",
            "",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097\1\u0098",
            "\1\u0099",
            "\12\53\7\uffff\21\53\1\u009a\10\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00a3",
            "",
            "\1\143\1\uffff\12\142",
            "",
            "\1\143\1\uffff\12\143",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a5\14\uffff\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b4\7\uffff\1\u00b2\2\uffff\1\u00b3\1\uffff\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "\1\u00be",
            "\12\53\7\uffff\25\53\1\u00bf\4\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d6\1\u00d5",
            "\1\u00d7",
            "\1\u00d8",
            "",
            "",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00dd",
            "",
            "\1\u00de",
            "",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00e9",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00ff",
            "\1\u0100",
            "\12\53\7\uffff\13\53\1\u0102\3\53\1\u0101\12\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u010b",
            "\1\u010d\15\uffff\1\u010c",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0115",
            "\1\u0116",
            "",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "",
            "\1\u0122",
            "",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u012b",
            "\1\u012c\10\uffff\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "",
            "\1\u013b",
            "\12\53\7\uffff\22\53\1\u013c\7\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "",
            "\1\u0145",
            "\1\u0147\1\uffff\1\u0146",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "",
            "",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\12\53\7\uffff\32\53\4\uffff\1\u0183\1\uffff\32\53",
            "\1\u0185",
            "\1\u0186",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\12\53\7\uffff\3\53\1\u018b\26\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "",
            "\1\u0190",
            "\1\u0191",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "",
            "\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "",
            "\1\u01ad",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01af",
            "\1\u01b0",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01b2",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01b4",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01b6",
            "",
            "\1\u01b7",
            "\1\u01b8",
            "\1\u01b9",
            "\1\u01ba",
            "\1\u01bb",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01bd",
            "\1\u01be",
            "\1\u01bf",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01c2",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01c8",
            "\1\u01c9",
            "",
            "\1\u01ca",
            "\1\u01cb",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01cd",
            "",
            "\1\u01ce",
            "\1\u01cf",
            "\1\u01d0",
            "",
            "\1\u01d1",
            "\1\u01d2",
            "\1\u01d3",
            "\1\u01d4",
            "",
            "\1\u01d5",
            "\1\u01d6",
            "",
            "\1\u01d7",
            "",
            "\12\53\7\uffff\23\53\1\u01d8\6\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01da",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01dd",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01df",
            "",
            "\1\u01e0",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01e2",
            "",
            "",
            "\1\u01e3",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01e5",
            "\1\u01e6",
            "",
            "\1\u01e7",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01e9",
            "\1\u01ea",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01ec",
            "\1\u01ed",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01ef",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01f1",
            "\1\u01f2",
            "\1\u01f3",
            "\1\u01f4",
            "\1\u01f5",
            "\1\u01f6",
            "",
            "\1\u01f7",
            "",
            "",
            "\1\u01f8",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01fa",
            "",
            "\1\u01fb",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01fd",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01ff",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0201",
            "",
            "\1\u0202",
            "\1\u0203",
            "",
            "\1\u0204",
            "",
            "\1\u0205",
            "\1\u0206",
            "\1\u0207",
            "\1\u0208",
            "\1\u0209",
            "\1\u020a",
            "\1\u020b",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u020f",
            "",
            "\1\u0210",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0213",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0216",
            "\1\u0217",
            "\1\u0218",
            "\1\u0219",
            "\1\u021a",
            "\1\u021b",
            "",
            "",
            "",
            "\1\u021c",
            "\1\u021d",
            "",
            "",
            "\1\u021e",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0220",
            "\1\u0221",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0224",
            "\1\u0225",
            "\1\u0226",
            "\1\u0227",
            "",
            "\1\u0228",
            "\1\u0229",
            "",
            "",
            "\1\u022a",
            "\1\u022b",
            "\1\u022c",
            "\1\u022d",
            "\1\u022e",
            "\1\u022f",
            "\1\u0230",
            "\1\u0231",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0235",
            "\1\u0236",
            "\1\u0237",
            "",
            "",
            "",
            "\1\u0238",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u023a",
            "\1\u023b",
            "",
            "\1\u023c",
            "\1\u023d",
            "\1\u023e",
            "\1\u023f",
            "\1\u0240",
            "\1\u0241",
            "\1\u0242",
            "\1\u0243",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0245",
            "",
            "\1\u0246",
            "\1\u0247",
            "\1\u0248",
            "\1\u0249",
            "\1\u024a",
            "\1\u024b",
            "\1\u024c",
            "\1\u024d",
            "\1\u024e",
            "\1\u024f",
            "\1\u0250",
            "\1\u0251",
            "\1\u0252",
            "\1\u0253",
            "\1\u0254",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | RULE_ID | RULE_NATURAL | RULE_NEGATIVEINT | RULE_DOUBLE | RULE_STRING | RULE_ML_STRING | RULE_ML_SQLBLOCK | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_35 = input.LA(1);

                        s = -1;
                        if ( ((LA18_35>='\u0000' && LA18_35<='\uFFFF')) ) {s = 101;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_0 = input.LA(1);

                        s = -1;
                        if ( (LA18_0=='C') ) {s = 1;}

                        else if ( (LA18_0=='{') ) {s = 2;}

                        else if ( (LA18_0=='D') ) {s = 3;}

                        else if ( (LA18_0=='N') ) {s = 4;}

                        else if ( (LA18_0=='S') ) {s = 5;}

                        else if ( (LA18_0=='I') ) {s = 6;}

                        else if ( (LA18_0=='M') ) {s = 7;}

                        else if ( (LA18_0=='}') ) {s = 8;}

                        else if ( (LA18_0=='L') ) {s = 9;}

                        else if ( (LA18_0==';') ) {s = 10;}

                        else if ( (LA18_0=='W') ) {s = 11;}

                        else if ( (LA18_0=='J') ) {s = 12;}

                        else if ( (LA18_0=='(') ) {s = 13;}

                        else if ( (LA18_0==',') ) {s = 14;}

                        else if ( (LA18_0==')') ) {s = 15;}

                        else if ( (LA18_0=='T') ) {s = 16;}

                        else if ( (LA18_0=='P') ) {s = 17;}

                        else if ( (LA18_0=='.') ) {s = 18;}

                        else if ( (LA18_0=='F') ) {s = 19;}

                        else if ( (LA18_0=='V') ) {s = 20;}

                        else if ( (LA18_0=='E') ) {s = 21;}

                        else if ( (LA18_0=='B') ) {s = 22;}

                        else if ( (LA18_0=='U') ) {s = 23;}

                        else if ( (LA18_0=='G') ) {s = 24;}

                        else if ( (LA18_0=='A') ) {s = 25;}

                        else if ( (LA18_0=='K') ) {s = 26;}

                        else if ( (LA18_0=='Q') ) {s = 27;}

                        else if ( (LA18_0=='H') ) {s = 28;}

                        else if ( (LA18_0=='O') ) {s = 29;}

                        else if ( (LA18_0=='^') ) {s = 30;}

                        else if ( (LA18_0=='R'||(LA18_0>='X' && LA18_0<='Z')||LA18_0=='_'||(LA18_0>='a' && LA18_0<='z')) ) {s = 31;}

                        else if ( ((LA18_0>='0' && LA18_0<='9')) ) {s = 32;}

                        else if ( (LA18_0=='-') ) {s = 33;}

                        else if ( (LA18_0=='\"') ) {s = 34;}

                        else if ( (LA18_0=='\'') ) {s = 35;}

                        else if ( (LA18_0=='<') ) {s = 36;}

                        else if ( (LA18_0=='/') ) {s = 37;}

                        else if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {s = 38;}

                        else if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||LA18_0=='!'||(LA18_0>='#' && LA18_0<='&')||(LA18_0>='*' && LA18_0<='+')||LA18_0==':'||(LA18_0>='=' && LA18_0<='@')||(LA18_0>='[' && LA18_0<=']')||LA18_0=='`'||LA18_0=='|'||(LA18_0>='~' && LA18_0<='\uFFFF')) ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_34 = input.LA(1);

                        s = -1;
                        if ( ((LA18_34>='\u0000' && LA18_34<='\uFFFF')) ) {s = 101;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}