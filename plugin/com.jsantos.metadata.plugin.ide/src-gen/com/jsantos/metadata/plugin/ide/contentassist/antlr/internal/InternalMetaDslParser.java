package com.jsantos.metadata.plugin.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import com.jsantos.metadata.plugin.services.MetaDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMetaDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_DOUBLE", "RULE_NATURAL", "RULE_NEGATIVEINT", "RULE_ML_STRING", "RULE_ID", "RULE_ML_SQLBLOCK", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'NONE'", "'SEQUENCE'", "'IDENTITY'", "'TABLE'", "'VIEW'", "'SQLQUERY'", "'GUID'", "'APPLICATION'", "'SHORTLABEL'", "'LONGLABEL'", "'ENTITY'", "'FILESTART'", "'FILEEND'", "'H2'", "'POSTGRESQL'", "'MYSQL'", "'SQLSERVER'", "'ORACLE'", "'DEFAULT'", "'CONFIGURATION'", "'{'", "'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY'", "'}'", "'MTCLASSNAME'", "'LANG'", "';'", "'CONSTANT'", "'DATATYPE'", "'SQLNATIVETYPE'", "'JAVATYPE'", "'SUBTYPEOF'", "'('", "')'", "','", "'TABLESTEREOTYPE'", "'COLUMNSTEREOTYPE'", "'PATTERN'", "'.'", "'FROMSQLFILE'", "'EXTENDS'", "'STEREOTYPES'", "'SQLFILEDEPENDENCY'", "'START'", "'WITH'", "'INCREMENT'", "'BY'", "'MINVALUE'", "'MAXVALUE'", "'CACHE'", "'SAMEAS'", "'FKTO'", "'MULTIREFTO'", "'IDGENERATOR'", "'ENUMETADATA'", "'FOR'", "'SHORTCODE'", "'KEY'", "'ATTRIBUTE'", "'ENUMERATIONITEM'", "'ENULABELS'", "'QUERYSOURCE'", "'FUNCTION'", "'SQLFILE'", "'SQLNATIVE'", "'ID'", "'DBTYPE'", "'WITHPRECISSIONANDSCALE'", "'WITHLENGTH'", "'MAX'", "'CYCLE'", "'UQ'", "'PK'", "'NOTNULL'", "'TRANSIENT'", "'BYRULE'", "'METADATA'", "'NULL'", "'LABELS'", "'DOCUMENTATION'"
    };
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
    public static final int RULE_ID=9;
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
    public static final int RULE_ML_STRING=8;
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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_DOUBLE=5;
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
    public static final int RULE_NEGATIVEINT=7;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalMetaDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMetaDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMetaDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMetaDsl.g"; }


    	private MetaDslGrammarAccess grammarAccess;

    	public void setGrammarAccess(MetaDslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalMetaDsl.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalMetaDsl.g:54:1: ( ruleModel EOF )
            // InternalMetaDsl.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMetaDsl.g:62:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:66:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalMetaDsl.g:67:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalMetaDsl.g:67:2: ( ( rule__Model__Group__0 ) )
            // InternalMetaDsl.g:68:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalMetaDsl.g:69:3: ( rule__Model__Group__0 )
            // InternalMetaDsl.g:69:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleConfiguration"
    // InternalMetaDsl.g:78:1: entryRuleConfiguration : ruleConfiguration EOF ;
    public final void entryRuleConfiguration() throws RecognitionException {
        try {
            // InternalMetaDsl.g:79:1: ( ruleConfiguration EOF )
            // InternalMetaDsl.g:80:1: ruleConfiguration EOF
            {
             before(grammarAccess.getConfigurationRule()); 
            pushFollow(FOLLOW_1);
            ruleConfiguration();

            state._fsp--;

             after(grammarAccess.getConfigurationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // InternalMetaDsl.g:87:1: ruleConfiguration : ( ( rule__Configuration__Group__0 ) ) ;
    public final void ruleConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:91:2: ( ( ( rule__Configuration__Group__0 ) ) )
            // InternalMetaDsl.g:92:2: ( ( rule__Configuration__Group__0 ) )
            {
            // InternalMetaDsl.g:92:2: ( ( rule__Configuration__Group__0 ) )
            // InternalMetaDsl.g:93:3: ( rule__Configuration__Group__0 )
            {
             before(grammarAccess.getConfigurationAccess().getGroup()); 
            // InternalMetaDsl.g:94:3: ( rule__Configuration__Group__0 )
            // InternalMetaDsl.g:94:4: rule__Configuration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleLanguage"
    // InternalMetaDsl.g:103:1: entryRuleLanguage : ruleLanguage EOF ;
    public final void entryRuleLanguage() throws RecognitionException {
        try {
            // InternalMetaDsl.g:104:1: ( ruleLanguage EOF )
            // InternalMetaDsl.g:105:1: ruleLanguage EOF
            {
             before(grammarAccess.getLanguageRule()); 
            pushFollow(FOLLOW_1);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getLanguageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLanguage"


    // $ANTLR start "ruleLanguage"
    // InternalMetaDsl.g:112:1: ruleLanguage : ( ( rule__Language__Group__0 ) ) ;
    public final void ruleLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:116:2: ( ( ( rule__Language__Group__0 ) ) )
            // InternalMetaDsl.g:117:2: ( ( rule__Language__Group__0 ) )
            {
            // InternalMetaDsl.g:117:2: ( ( rule__Language__Group__0 ) )
            // InternalMetaDsl.g:118:3: ( rule__Language__Group__0 )
            {
             before(grammarAccess.getLanguageAccess().getGroup()); 
            // InternalMetaDsl.g:119:3: ( rule__Language__Group__0 )
            // InternalMetaDsl.g:119:4: rule__Language__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Language__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLanguageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLanguage"


    // $ANTLR start "entryRuleConstant"
    // InternalMetaDsl.g:128:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalMetaDsl.g:129:1: ( ruleConstant EOF )
            // InternalMetaDsl.g:130:1: ruleConstant EOF
            {
             before(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalMetaDsl.g:137:1: ruleConstant : ( ( rule__Constant__Group__0 ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:141:2: ( ( ( rule__Constant__Group__0 ) ) )
            // InternalMetaDsl.g:142:2: ( ( rule__Constant__Group__0 ) )
            {
            // InternalMetaDsl.g:142:2: ( ( rule__Constant__Group__0 ) )
            // InternalMetaDsl.g:143:3: ( rule__Constant__Group__0 )
            {
             before(grammarAccess.getConstantAccess().getGroup()); 
            // InternalMetaDsl.g:144:3: ( rule__Constant__Group__0 )
            // InternalMetaDsl.g:144:4: rule__Constant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleDataType"
    // InternalMetaDsl.g:153:1: entryRuleDataType : ruleDataType EOF ;
    public final void entryRuleDataType() throws RecognitionException {
        try {
            // InternalMetaDsl.g:154:1: ( ruleDataType EOF )
            // InternalMetaDsl.g:155:1: ruleDataType EOF
            {
             before(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getDataTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalMetaDsl.g:162:1: ruleDataType : ( ( rule__DataType__Group__0 ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:166:2: ( ( ( rule__DataType__Group__0 ) ) )
            // InternalMetaDsl.g:167:2: ( ( rule__DataType__Group__0 ) )
            {
            // InternalMetaDsl.g:167:2: ( ( rule__DataType__Group__0 ) )
            // InternalMetaDsl.g:168:3: ( rule__DataType__Group__0 )
            {
             before(grammarAccess.getDataTypeAccess().getGroup()); 
            // InternalMetaDsl.g:169:3: ( rule__DataType__Group__0 )
            // InternalMetaDsl.g:169:4: rule__DataType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleDataTypeDefinition"
    // InternalMetaDsl.g:178:1: entryRuleDataTypeDefinition : ruleDataTypeDefinition EOF ;
    public final void entryRuleDataTypeDefinition() throws RecognitionException {
        try {
            // InternalMetaDsl.g:179:1: ( ruleDataTypeDefinition EOF )
            // InternalMetaDsl.g:180:1: ruleDataTypeDefinition EOF
            {
             before(grammarAccess.getDataTypeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            ruleDataTypeDefinition();

            state._fsp--;

             after(grammarAccess.getDataTypeDefinitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataTypeDefinition"


    // $ANTLR start "ruleDataTypeDefinition"
    // InternalMetaDsl.g:187:1: ruleDataTypeDefinition : ( ( rule__DataTypeDefinition__Alternatives ) ) ;
    public final void ruleDataTypeDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:191:2: ( ( ( rule__DataTypeDefinition__Alternatives ) ) )
            // InternalMetaDsl.g:192:2: ( ( rule__DataTypeDefinition__Alternatives ) )
            {
            // InternalMetaDsl.g:192:2: ( ( rule__DataTypeDefinition__Alternatives ) )
            // InternalMetaDsl.g:193:3: ( rule__DataTypeDefinition__Alternatives )
            {
             before(grammarAccess.getDataTypeDefinitionAccess().getAlternatives()); 
            // InternalMetaDsl.g:194:3: ( rule__DataTypeDefinition__Alternatives )
            // InternalMetaDsl.g:194:4: rule__DataTypeDefinition__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDefinition__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeDefinitionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataTypeDefinition"


    // $ANTLR start "entryRuleDataTypeDetails"
    // InternalMetaDsl.g:203:1: entryRuleDataTypeDetails : ruleDataTypeDetails EOF ;
    public final void entryRuleDataTypeDetails() throws RecognitionException {
        try {
            // InternalMetaDsl.g:204:1: ( ruleDataTypeDetails EOF )
            // InternalMetaDsl.g:205:1: ruleDataTypeDetails EOF
            {
             before(grammarAccess.getDataTypeDetailsRule()); 
            pushFollow(FOLLOW_1);
            ruleDataTypeDetails();

            state._fsp--;

             after(grammarAccess.getDataTypeDetailsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataTypeDetails"


    // $ANTLR start "ruleDataTypeDetails"
    // InternalMetaDsl.g:212:1: ruleDataTypeDetails : ( ( rule__DataTypeDetails__Group__0 ) ) ;
    public final void ruleDataTypeDetails() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:216:2: ( ( ( rule__DataTypeDetails__Group__0 ) ) )
            // InternalMetaDsl.g:217:2: ( ( rule__DataTypeDetails__Group__0 ) )
            {
            // InternalMetaDsl.g:217:2: ( ( rule__DataTypeDetails__Group__0 ) )
            // InternalMetaDsl.g:218:3: ( rule__DataTypeDetails__Group__0 )
            {
             before(grammarAccess.getDataTypeDetailsAccess().getGroup()); 
            // InternalMetaDsl.g:219:3: ( rule__DataTypeDetails__Group__0 )
            // InternalMetaDsl.g:219:4: rule__DataTypeDetails__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDetails__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeDetailsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataTypeDetails"


    // $ANTLR start "entryRuleSubTypeDataType"
    // InternalMetaDsl.g:228:1: entryRuleSubTypeDataType : ruleSubTypeDataType EOF ;
    public final void entryRuleSubTypeDataType() throws RecognitionException {
        try {
            // InternalMetaDsl.g:229:1: ( ruleSubTypeDataType EOF )
            // InternalMetaDsl.g:230:1: ruleSubTypeDataType EOF
            {
             before(grammarAccess.getSubTypeDataTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleSubTypeDataType();

            state._fsp--;

             after(grammarAccess.getSubTypeDataTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubTypeDataType"


    // $ANTLR start "ruleSubTypeDataType"
    // InternalMetaDsl.g:237:1: ruleSubTypeDataType : ( ( rule__SubTypeDataType__Group__0 ) ) ;
    public final void ruleSubTypeDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:241:2: ( ( ( rule__SubTypeDataType__Group__0 ) ) )
            // InternalMetaDsl.g:242:2: ( ( rule__SubTypeDataType__Group__0 ) )
            {
            // InternalMetaDsl.g:242:2: ( ( rule__SubTypeDataType__Group__0 ) )
            // InternalMetaDsl.g:243:3: ( rule__SubTypeDataType__Group__0 )
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getGroup()); 
            // InternalMetaDsl.g:244:3: ( rule__SubTypeDataType__Group__0 )
            // InternalMetaDsl.g:244:4: rule__SubTypeDataType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeDataTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubTypeDataType"


    // $ANTLR start "entryRuleTableStereotype"
    // InternalMetaDsl.g:253:1: entryRuleTableStereotype : ruleTableStereotype EOF ;
    public final void entryRuleTableStereotype() throws RecognitionException {
        try {
            // InternalMetaDsl.g:254:1: ( ruleTableStereotype EOF )
            // InternalMetaDsl.g:255:1: ruleTableStereotype EOF
            {
             before(grammarAccess.getTableStereotypeRule()); 
            pushFollow(FOLLOW_1);
            ruleTableStereotype();

            state._fsp--;

             after(grammarAccess.getTableStereotypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTableStereotype"


    // $ANTLR start "ruleTableStereotype"
    // InternalMetaDsl.g:262:1: ruleTableStereotype : ( ( rule__TableStereotype__Group__0 ) ) ;
    public final void ruleTableStereotype() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:266:2: ( ( ( rule__TableStereotype__Group__0 ) ) )
            // InternalMetaDsl.g:267:2: ( ( rule__TableStereotype__Group__0 ) )
            {
            // InternalMetaDsl.g:267:2: ( ( rule__TableStereotype__Group__0 ) )
            // InternalMetaDsl.g:268:3: ( rule__TableStereotype__Group__0 )
            {
             before(grammarAccess.getTableStereotypeAccess().getGroup()); 
            // InternalMetaDsl.g:269:3: ( rule__TableStereotype__Group__0 )
            // InternalMetaDsl.g:269:4: rule__TableStereotype__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TableStereotype__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableStereotypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTableStereotype"


    // $ANTLR start "entryRuleColumnStereotype"
    // InternalMetaDsl.g:278:1: entryRuleColumnStereotype : ruleColumnStereotype EOF ;
    public final void entryRuleColumnStereotype() throws RecognitionException {
        try {
            // InternalMetaDsl.g:279:1: ( ruleColumnStereotype EOF )
            // InternalMetaDsl.g:280:1: ruleColumnStereotype EOF
            {
             before(grammarAccess.getColumnStereotypeRule()); 
            pushFollow(FOLLOW_1);
            ruleColumnStereotype();

            state._fsp--;

             after(grammarAccess.getColumnStereotypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColumnStereotype"


    // $ANTLR start "ruleColumnStereotype"
    // InternalMetaDsl.g:287:1: ruleColumnStereotype : ( ( rule__ColumnStereotype__Group__0 ) ) ;
    public final void ruleColumnStereotype() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:291:2: ( ( ( rule__ColumnStereotype__Group__0 ) ) )
            // InternalMetaDsl.g:292:2: ( ( rule__ColumnStereotype__Group__0 ) )
            {
            // InternalMetaDsl.g:292:2: ( ( rule__ColumnStereotype__Group__0 ) )
            // InternalMetaDsl.g:293:3: ( rule__ColumnStereotype__Group__0 )
            {
             before(grammarAccess.getColumnStereotypeAccess().getGroup()); 
            // InternalMetaDsl.g:294:3: ( rule__ColumnStereotype__Group__0 )
            // InternalMetaDsl.g:294:4: rule__ColumnStereotype__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ColumnStereotype__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColumnStereotypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColumnStereotype"


    // $ANTLR start "entryRulePattern"
    // InternalMetaDsl.g:303:1: entryRulePattern : rulePattern EOF ;
    public final void entryRulePattern() throws RecognitionException {
        try {
            // InternalMetaDsl.g:304:1: ( rulePattern EOF )
            // InternalMetaDsl.g:305:1: rulePattern EOF
            {
             before(grammarAccess.getPatternRule()); 
            pushFollow(FOLLOW_1);
            rulePattern();

            state._fsp--;

             after(grammarAccess.getPatternRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalMetaDsl.g:312:1: rulePattern : ( ( rule__Pattern__Group__0 ) ) ;
    public final void rulePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:316:2: ( ( ( rule__Pattern__Group__0 ) ) )
            // InternalMetaDsl.g:317:2: ( ( rule__Pattern__Group__0 ) )
            {
            // InternalMetaDsl.g:317:2: ( ( rule__Pattern__Group__0 ) )
            // InternalMetaDsl.g:318:3: ( rule__Pattern__Group__0 )
            {
             before(grammarAccess.getPatternAccess().getGroup()); 
            // InternalMetaDsl.g:319:3: ( rule__Pattern__Group__0 )
            // InternalMetaDsl.g:319:4: rule__Pattern__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Pattern__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPatternAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleFQN"
    // InternalMetaDsl.g:328:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalMetaDsl.g:329:1: ( ruleFQN EOF )
            // InternalMetaDsl.g:330:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalMetaDsl.g:337:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:341:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalMetaDsl.g:342:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalMetaDsl.g:342:2: ( ( rule__FQN__Group__0 ) )
            // InternalMetaDsl.g:343:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalMetaDsl.g:344:3: ( rule__FQN__Group__0 )
            // InternalMetaDsl.g:344:4: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleEntity"
    // InternalMetaDsl.g:353:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // InternalMetaDsl.g:354:1: ( ruleEntity EOF )
            // InternalMetaDsl.g:355:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalMetaDsl.g:362:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:366:2: ( ( ( rule__Entity__Group__0 ) ) )
            // InternalMetaDsl.g:367:2: ( ( rule__Entity__Group__0 ) )
            {
            // InternalMetaDsl.g:367:2: ( ( rule__Entity__Group__0 ) )
            // InternalMetaDsl.g:368:3: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // InternalMetaDsl.g:369:3: ( rule__Entity__Group__0 )
            // InternalMetaDsl.g:369:4: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleSqlFileDependency"
    // InternalMetaDsl.g:378:1: entryRuleSqlFileDependency : ruleSqlFileDependency EOF ;
    public final void entryRuleSqlFileDependency() throws RecognitionException {
        try {
            // InternalMetaDsl.g:379:1: ( ruleSqlFileDependency EOF )
            // InternalMetaDsl.g:380:1: ruleSqlFileDependency EOF
            {
             before(grammarAccess.getSqlFileDependencyRule()); 
            pushFollow(FOLLOW_1);
            ruleSqlFileDependency();

            state._fsp--;

             after(grammarAccess.getSqlFileDependencyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSqlFileDependency"


    // $ANTLR start "ruleSqlFileDependency"
    // InternalMetaDsl.g:387:1: ruleSqlFileDependency : ( ( rule__SqlFileDependency__Group__0 ) ) ;
    public final void ruleSqlFileDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:391:2: ( ( ( rule__SqlFileDependency__Group__0 ) ) )
            // InternalMetaDsl.g:392:2: ( ( rule__SqlFileDependency__Group__0 ) )
            {
            // InternalMetaDsl.g:392:2: ( ( rule__SqlFileDependency__Group__0 ) )
            // InternalMetaDsl.g:393:3: ( rule__SqlFileDependency__Group__0 )
            {
             before(grammarAccess.getSqlFileDependencyAccess().getGroup()); 
            // InternalMetaDsl.g:394:3: ( rule__SqlFileDependency__Group__0 )
            // InternalMetaDsl.g:394:4: rule__SqlFileDependency__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SqlFileDependency__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSqlFileDependencyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSqlFileDependency"


    // $ANTLR start "entryRuleSequence"
    // InternalMetaDsl.g:403:1: entryRuleSequence : ruleSequence EOF ;
    public final void entryRuleSequence() throws RecognitionException {
        try {
            // InternalMetaDsl.g:404:1: ( ruleSequence EOF )
            // InternalMetaDsl.g:405:1: ruleSequence EOF
            {
             before(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_1);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getSequenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // InternalMetaDsl.g:412:1: ruleSequence : ( ( rule__Sequence__Group__0 ) ) ;
    public final void ruleSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:416:2: ( ( ( rule__Sequence__Group__0 ) ) )
            // InternalMetaDsl.g:417:2: ( ( rule__Sequence__Group__0 ) )
            {
            // InternalMetaDsl.g:417:2: ( ( rule__Sequence__Group__0 ) )
            // InternalMetaDsl.g:418:3: ( rule__Sequence__Group__0 )
            {
             before(grammarAccess.getSequenceAccess().getGroup()); 
            // InternalMetaDsl.g:419:3: ( rule__Sequence__Group__0 )
            // InternalMetaDsl.g:419:4: rule__Sequence__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleAttribute"
    // InternalMetaDsl.g:428:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalMetaDsl.g:429:1: ( ruleAttribute EOF )
            // InternalMetaDsl.g:430:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalMetaDsl.g:437:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:441:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalMetaDsl.g:442:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalMetaDsl.g:442:2: ( ( rule__Attribute__Group__0 ) )
            // InternalMetaDsl.g:443:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalMetaDsl.g:444:3: ( rule__Attribute__Group__0 )
            // InternalMetaDsl.g:444:4: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleIdGenerator"
    // InternalMetaDsl.g:453:1: entryRuleIdGenerator : ruleIdGenerator EOF ;
    public final void entryRuleIdGenerator() throws RecognitionException {
        try {
            // InternalMetaDsl.g:454:1: ( ruleIdGenerator EOF )
            // InternalMetaDsl.g:455:1: ruleIdGenerator EOF
            {
             before(grammarAccess.getIdGeneratorRule()); 
            pushFollow(FOLLOW_1);
            ruleIdGenerator();

            state._fsp--;

             after(grammarAccess.getIdGeneratorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdGenerator"


    // $ANTLR start "ruleIdGenerator"
    // InternalMetaDsl.g:462:1: ruleIdGenerator : ( ( rule__IdGenerator__Group__0 ) ) ;
    public final void ruleIdGenerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:466:2: ( ( ( rule__IdGenerator__Group__0 ) ) )
            // InternalMetaDsl.g:467:2: ( ( rule__IdGenerator__Group__0 ) )
            {
            // InternalMetaDsl.g:467:2: ( ( rule__IdGenerator__Group__0 ) )
            // InternalMetaDsl.g:468:3: ( rule__IdGenerator__Group__0 )
            {
             before(grammarAccess.getIdGeneratorAccess().getGroup()); 
            // InternalMetaDsl.g:469:3: ( rule__IdGenerator__Group__0 )
            // InternalMetaDsl.g:469:4: rule__IdGenerator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IdGenerator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdGenerator"


    // $ANTLR start "entryRuleIdGeneratorTypeBlock"
    // InternalMetaDsl.g:478:1: entryRuleIdGeneratorTypeBlock : ruleIdGeneratorTypeBlock EOF ;
    public final void entryRuleIdGeneratorTypeBlock() throws RecognitionException {
        try {
            // InternalMetaDsl.g:479:1: ( ruleIdGeneratorTypeBlock EOF )
            // InternalMetaDsl.g:480:1: ruleIdGeneratorTypeBlock EOF
            {
             before(grammarAccess.getIdGeneratorTypeBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleIdGeneratorTypeBlock();

            state._fsp--;

             after(grammarAccess.getIdGeneratorTypeBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdGeneratorTypeBlock"


    // $ANTLR start "ruleIdGeneratorTypeBlock"
    // InternalMetaDsl.g:487:1: ruleIdGeneratorTypeBlock : ( ( rule__IdGeneratorTypeBlock__Alternatives ) ) ;
    public final void ruleIdGeneratorTypeBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:491:2: ( ( ( rule__IdGeneratorTypeBlock__Alternatives ) ) )
            // InternalMetaDsl.g:492:2: ( ( rule__IdGeneratorTypeBlock__Alternatives ) )
            {
            // InternalMetaDsl.g:492:2: ( ( rule__IdGeneratorTypeBlock__Alternatives ) )
            // InternalMetaDsl.g:493:3: ( rule__IdGeneratorTypeBlock__Alternatives )
            {
             before(grammarAccess.getIdGeneratorTypeBlockAccess().getAlternatives()); 
            // InternalMetaDsl.g:494:3: ( rule__IdGeneratorTypeBlock__Alternatives )
            // InternalMetaDsl.g:494:4: rule__IdGeneratorTypeBlock__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__IdGeneratorTypeBlock__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorTypeBlockAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdGeneratorTypeBlock"


    // $ANTLR start "entryRuleIdGeneratorSimple"
    // InternalMetaDsl.g:503:1: entryRuleIdGeneratorSimple : ruleIdGeneratorSimple EOF ;
    public final void entryRuleIdGeneratorSimple() throws RecognitionException {
        try {
            // InternalMetaDsl.g:504:1: ( ruleIdGeneratorSimple EOF )
            // InternalMetaDsl.g:505:1: ruleIdGeneratorSimple EOF
            {
             before(grammarAccess.getIdGeneratorSimpleRule()); 
            pushFollow(FOLLOW_1);
            ruleIdGeneratorSimple();

            state._fsp--;

             after(grammarAccess.getIdGeneratorSimpleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdGeneratorSimple"


    // $ANTLR start "ruleIdGeneratorSimple"
    // InternalMetaDsl.g:512:1: ruleIdGeneratorSimple : ( ( rule__IdGeneratorSimple__Alternatives ) ) ;
    public final void ruleIdGeneratorSimple() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:516:2: ( ( ( rule__IdGeneratorSimple__Alternatives ) ) )
            // InternalMetaDsl.g:517:2: ( ( rule__IdGeneratorSimple__Alternatives ) )
            {
            // InternalMetaDsl.g:517:2: ( ( rule__IdGeneratorSimple__Alternatives ) )
            // InternalMetaDsl.g:518:3: ( rule__IdGeneratorSimple__Alternatives )
            {
             before(grammarAccess.getIdGeneratorSimpleAccess().getAlternatives()); 
            // InternalMetaDsl.g:519:3: ( rule__IdGeneratorSimple__Alternatives )
            // InternalMetaDsl.g:519:4: rule__IdGeneratorSimple__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__IdGeneratorSimple__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorSimpleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdGeneratorSimple"


    // $ANTLR start "entryRuleIdGeneratorSequence"
    // InternalMetaDsl.g:528:1: entryRuleIdGeneratorSequence : ruleIdGeneratorSequence EOF ;
    public final void entryRuleIdGeneratorSequence() throws RecognitionException {
        try {
            // InternalMetaDsl.g:529:1: ( ruleIdGeneratorSequence EOF )
            // InternalMetaDsl.g:530:1: ruleIdGeneratorSequence EOF
            {
             before(grammarAccess.getIdGeneratorSequenceRule()); 
            pushFollow(FOLLOW_1);
            ruleIdGeneratorSequence();

            state._fsp--;

             after(grammarAccess.getIdGeneratorSequenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdGeneratorSequence"


    // $ANTLR start "ruleIdGeneratorSequence"
    // InternalMetaDsl.g:537:1: ruleIdGeneratorSequence : ( ( rule__IdGeneratorSequence__Group__0 ) ) ;
    public final void ruleIdGeneratorSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:541:2: ( ( ( rule__IdGeneratorSequence__Group__0 ) ) )
            // InternalMetaDsl.g:542:2: ( ( rule__IdGeneratorSequence__Group__0 ) )
            {
            // InternalMetaDsl.g:542:2: ( ( rule__IdGeneratorSequence__Group__0 ) )
            // InternalMetaDsl.g:543:3: ( rule__IdGeneratorSequence__Group__0 )
            {
             before(grammarAccess.getIdGeneratorSequenceAccess().getGroup()); 
            // InternalMetaDsl.g:544:3: ( rule__IdGeneratorSequence__Group__0 )
            // InternalMetaDsl.g:544:4: rule__IdGeneratorSequence__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IdGeneratorSequence__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorSequenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdGeneratorSequence"


    // $ANTLR start "entryRuleEnuMetadata"
    // InternalMetaDsl.g:553:1: entryRuleEnuMetadata : ruleEnuMetadata EOF ;
    public final void entryRuleEnuMetadata() throws RecognitionException {
        try {
            // InternalMetaDsl.g:554:1: ( ruleEnuMetadata EOF )
            // InternalMetaDsl.g:555:1: ruleEnuMetadata EOF
            {
             before(grammarAccess.getEnuMetadataRule()); 
            pushFollow(FOLLOW_1);
            ruleEnuMetadata();

            state._fsp--;

             after(grammarAccess.getEnuMetadataRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnuMetadata"


    // $ANTLR start "ruleEnuMetadata"
    // InternalMetaDsl.g:562:1: ruleEnuMetadata : ( ( rule__EnuMetadata__Group__0 ) ) ;
    public final void ruleEnuMetadata() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:566:2: ( ( ( rule__EnuMetadata__Group__0 ) ) )
            // InternalMetaDsl.g:567:2: ( ( rule__EnuMetadata__Group__0 ) )
            {
            // InternalMetaDsl.g:567:2: ( ( rule__EnuMetadata__Group__0 ) )
            // InternalMetaDsl.g:568:3: ( rule__EnuMetadata__Group__0 )
            {
             before(grammarAccess.getEnuMetadataAccess().getGroup()); 
            // InternalMetaDsl.g:569:3: ( rule__EnuMetadata__Group__0 )
            // InternalMetaDsl.g:569:4: rule__EnuMetadata__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadata__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnuMetadataAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnuMetadata"


    // $ANTLR start "entryRuleEnuMetadataRow"
    // InternalMetaDsl.g:578:1: entryRuleEnuMetadataRow : ruleEnuMetadataRow EOF ;
    public final void entryRuleEnuMetadataRow() throws RecognitionException {
        try {
            // InternalMetaDsl.g:579:1: ( ruleEnuMetadataRow EOF )
            // InternalMetaDsl.g:580:1: ruleEnuMetadataRow EOF
            {
             before(grammarAccess.getEnuMetadataRowRule()); 
            pushFollow(FOLLOW_1);
            ruleEnuMetadataRow();

            state._fsp--;

             after(grammarAccess.getEnuMetadataRowRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnuMetadataRow"


    // $ANTLR start "ruleEnuMetadataRow"
    // InternalMetaDsl.g:587:1: ruleEnuMetadataRow : ( ( rule__EnuMetadataRow__Group__0 ) ) ;
    public final void ruleEnuMetadataRow() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:591:2: ( ( ( rule__EnuMetadataRow__Group__0 ) ) )
            // InternalMetaDsl.g:592:2: ( ( rule__EnuMetadataRow__Group__0 ) )
            {
            // InternalMetaDsl.g:592:2: ( ( rule__EnuMetadataRow__Group__0 ) )
            // InternalMetaDsl.g:593:3: ( rule__EnuMetadataRow__Group__0 )
            {
             before(grammarAccess.getEnuMetadataRowAccess().getGroup()); 
            // InternalMetaDsl.g:594:3: ( rule__EnuMetadataRow__Group__0 )
            // InternalMetaDsl.g:594:4: rule__EnuMetadataRow__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnuMetadataRowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnuMetadataRow"


    // $ANTLR start "entryRuleMetadata"
    // InternalMetaDsl.g:603:1: entryRuleMetadata : ruleMetadata EOF ;
    public final void entryRuleMetadata() throws RecognitionException {
        try {
            // InternalMetaDsl.g:604:1: ( ruleMetadata EOF )
            // InternalMetaDsl.g:605:1: ruleMetadata EOF
            {
             before(grammarAccess.getMetadataRule()); 
            pushFollow(FOLLOW_1);
            ruleMetadata();

            state._fsp--;

             after(grammarAccess.getMetadataRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetadata"


    // $ANTLR start "ruleMetadata"
    // InternalMetaDsl.g:612:1: ruleMetadata : ( ( rule__Metadata__Group__0 ) ) ;
    public final void ruleMetadata() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:616:2: ( ( ( rule__Metadata__Group__0 ) ) )
            // InternalMetaDsl.g:617:2: ( ( rule__Metadata__Group__0 ) )
            {
            // InternalMetaDsl.g:617:2: ( ( rule__Metadata__Group__0 ) )
            // InternalMetaDsl.g:618:3: ( rule__Metadata__Group__0 )
            {
             before(grammarAccess.getMetadataAccess().getGroup()); 
            // InternalMetaDsl.g:619:3: ( rule__Metadata__Group__0 )
            // InternalMetaDsl.g:619:4: rule__Metadata__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Metadata__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMetadataAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetadata"


    // $ANTLR start "entryRuleShortCode"
    // InternalMetaDsl.g:628:1: entryRuleShortCode : ruleShortCode EOF ;
    public final void entryRuleShortCode() throws RecognitionException {
        try {
            // InternalMetaDsl.g:629:1: ( ruleShortCode EOF )
            // InternalMetaDsl.g:630:1: ruleShortCode EOF
            {
             before(grammarAccess.getShortCodeRule()); 
            pushFollow(FOLLOW_1);
            ruleShortCode();

            state._fsp--;

             after(grammarAccess.getShortCodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleShortCode"


    // $ANTLR start "ruleShortCode"
    // InternalMetaDsl.g:637:1: ruleShortCode : ( ( rule__ShortCode__Group__0 ) ) ;
    public final void ruleShortCode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:641:2: ( ( ( rule__ShortCode__Group__0 ) ) )
            // InternalMetaDsl.g:642:2: ( ( rule__ShortCode__Group__0 ) )
            {
            // InternalMetaDsl.g:642:2: ( ( rule__ShortCode__Group__0 ) )
            // InternalMetaDsl.g:643:3: ( rule__ShortCode__Group__0 )
            {
             before(grammarAccess.getShortCodeAccess().getGroup()); 
            // InternalMetaDsl.g:644:3: ( rule__ShortCode__Group__0 )
            // InternalMetaDsl.g:644:4: rule__ShortCode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ShortCode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getShortCodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShortCode"


    // $ANTLR start "entryRuleMetadataRow"
    // InternalMetaDsl.g:653:1: entryRuleMetadataRow : ruleMetadataRow EOF ;
    public final void entryRuleMetadataRow() throws RecognitionException {
        try {
            // InternalMetaDsl.g:654:1: ( ruleMetadataRow EOF )
            // InternalMetaDsl.g:655:1: ruleMetadataRow EOF
            {
             before(grammarAccess.getMetadataRowRule()); 
            pushFollow(FOLLOW_1);
            ruleMetadataRow();

            state._fsp--;

             after(grammarAccess.getMetadataRowRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetadataRow"


    // $ANTLR start "ruleMetadataRow"
    // InternalMetaDsl.g:662:1: ruleMetadataRow : ( ( rule__MetadataRow__Group__0 ) ) ;
    public final void ruleMetadataRow() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:666:2: ( ( ( rule__MetadataRow__Group__0 ) ) )
            // InternalMetaDsl.g:667:2: ( ( rule__MetadataRow__Group__0 ) )
            {
            // InternalMetaDsl.g:667:2: ( ( rule__MetadataRow__Group__0 ) )
            // InternalMetaDsl.g:668:3: ( rule__MetadataRow__Group__0 )
            {
             before(grammarAccess.getMetadataRowAccess().getGroup()); 
            // InternalMetaDsl.g:669:3: ( rule__MetadataRow__Group__0 )
            // InternalMetaDsl.g:669:4: rule__MetadataRow__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MetadataRow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMetadataRowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetadataRow"


    // $ANTLR start "entryRuleMetadataRowCell"
    // InternalMetaDsl.g:678:1: entryRuleMetadataRowCell : ruleMetadataRowCell EOF ;
    public final void entryRuleMetadataRowCell() throws RecognitionException {
        try {
            // InternalMetaDsl.g:679:1: ( ruleMetadataRowCell EOF )
            // InternalMetaDsl.g:680:1: ruleMetadataRowCell EOF
            {
             before(grammarAccess.getMetadataRowCellRule()); 
            pushFollow(FOLLOW_1);
            ruleMetadataRowCell();

            state._fsp--;

             after(grammarAccess.getMetadataRowCellRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetadataRowCell"


    // $ANTLR start "ruleMetadataRowCell"
    // InternalMetaDsl.g:687:1: ruleMetadataRowCell : ( ( rule__MetadataRowCell__Alternatives ) ) ;
    public final void ruleMetadataRowCell() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:691:2: ( ( ( rule__MetadataRowCell__Alternatives ) ) )
            // InternalMetaDsl.g:692:2: ( ( rule__MetadataRowCell__Alternatives ) )
            {
            // InternalMetaDsl.g:692:2: ( ( rule__MetadataRowCell__Alternatives ) )
            // InternalMetaDsl.g:693:3: ( rule__MetadataRowCell__Alternatives )
            {
             before(grammarAccess.getMetadataRowCellAccess().getAlternatives()); 
            // InternalMetaDsl.g:694:3: ( rule__MetadataRowCell__Alternatives )
            // InternalMetaDsl.g:694:4: rule__MetadataRowCell__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MetadataRowCell__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMetadataRowCellAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetadataRowCell"


    // $ANTLR start "entryRuleLabelSection"
    // InternalMetaDsl.g:703:1: entryRuleLabelSection : ruleLabelSection EOF ;
    public final void entryRuleLabelSection() throws RecognitionException {
        try {
            // InternalMetaDsl.g:704:1: ( ruleLabelSection EOF )
            // InternalMetaDsl.g:705:1: ruleLabelSection EOF
            {
             before(grammarAccess.getLabelSectionRule()); 
            pushFollow(FOLLOW_1);
            ruleLabelSection();

            state._fsp--;

             after(grammarAccess.getLabelSectionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLabelSection"


    // $ANTLR start "ruleLabelSection"
    // InternalMetaDsl.g:712:1: ruleLabelSection : ( ( rule__LabelSection__Group__0 ) ) ;
    public final void ruleLabelSection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:716:2: ( ( ( rule__LabelSection__Group__0 ) ) )
            // InternalMetaDsl.g:717:2: ( ( rule__LabelSection__Group__0 ) )
            {
            // InternalMetaDsl.g:717:2: ( ( rule__LabelSection__Group__0 ) )
            // InternalMetaDsl.g:718:3: ( rule__LabelSection__Group__0 )
            {
             before(grammarAccess.getLabelSectionAccess().getGroup()); 
            // InternalMetaDsl.g:719:3: ( rule__LabelSection__Group__0 )
            // InternalMetaDsl.g:719:4: rule__LabelSection__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LabelSection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLabelSectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLabelSection"


    // $ANTLR start "entryRuleLabelBlock"
    // InternalMetaDsl.g:728:1: entryRuleLabelBlock : ruleLabelBlock EOF ;
    public final void entryRuleLabelBlock() throws RecognitionException {
        try {
            // InternalMetaDsl.g:729:1: ( ruleLabelBlock EOF )
            // InternalMetaDsl.g:730:1: ruleLabelBlock EOF
            {
             before(grammarAccess.getLabelBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleLabelBlock();

            state._fsp--;

             after(grammarAccess.getLabelBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLabelBlock"


    // $ANTLR start "ruleLabelBlock"
    // InternalMetaDsl.g:737:1: ruleLabelBlock : ( ( rule__LabelBlock__Group__0 ) ) ;
    public final void ruleLabelBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:741:2: ( ( ( rule__LabelBlock__Group__0 ) ) )
            // InternalMetaDsl.g:742:2: ( ( rule__LabelBlock__Group__0 ) )
            {
            // InternalMetaDsl.g:742:2: ( ( rule__LabelBlock__Group__0 ) )
            // InternalMetaDsl.g:743:3: ( rule__LabelBlock__Group__0 )
            {
             before(grammarAccess.getLabelBlockAccess().getGroup()); 
            // InternalMetaDsl.g:744:3: ( rule__LabelBlock__Group__0 )
            // InternalMetaDsl.g:744:4: rule__LabelBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LabelBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLabelBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLabelBlock"


    // $ANTLR start "entryRuleGeneralLabelSection"
    // InternalMetaDsl.g:753:1: entryRuleGeneralLabelSection : ruleGeneralLabelSection EOF ;
    public final void entryRuleGeneralLabelSection() throws RecognitionException {
        try {
            // InternalMetaDsl.g:754:1: ( ruleGeneralLabelSection EOF )
            // InternalMetaDsl.g:755:1: ruleGeneralLabelSection EOF
            {
             before(grammarAccess.getGeneralLabelSectionRule()); 
            pushFollow(FOLLOW_1);
            ruleGeneralLabelSection();

            state._fsp--;

             after(grammarAccess.getGeneralLabelSectionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGeneralLabelSection"


    // $ANTLR start "ruleGeneralLabelSection"
    // InternalMetaDsl.g:762:1: ruleGeneralLabelSection : ( ( rule__GeneralLabelSection__Group__0 ) ) ;
    public final void ruleGeneralLabelSection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:766:2: ( ( ( rule__GeneralLabelSection__Group__0 ) ) )
            // InternalMetaDsl.g:767:2: ( ( rule__GeneralLabelSection__Group__0 ) )
            {
            // InternalMetaDsl.g:767:2: ( ( rule__GeneralLabelSection__Group__0 ) )
            // InternalMetaDsl.g:768:3: ( rule__GeneralLabelSection__Group__0 )
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getGroup()); 
            // InternalMetaDsl.g:769:3: ( rule__GeneralLabelSection__Group__0 )
            // InternalMetaDsl.g:769:4: rule__GeneralLabelSection__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GeneralLabelSection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGeneralLabelSectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGeneralLabelSection"


    // $ANTLR start "entryRuleKeyLabel"
    // InternalMetaDsl.g:778:1: entryRuleKeyLabel : ruleKeyLabel EOF ;
    public final void entryRuleKeyLabel() throws RecognitionException {
        try {
            // InternalMetaDsl.g:779:1: ( ruleKeyLabel EOF )
            // InternalMetaDsl.g:780:1: ruleKeyLabel EOF
            {
             before(grammarAccess.getKeyLabelRule()); 
            pushFollow(FOLLOW_1);
            ruleKeyLabel();

            state._fsp--;

             after(grammarAccess.getKeyLabelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKeyLabel"


    // $ANTLR start "ruleKeyLabel"
    // InternalMetaDsl.g:787:1: ruleKeyLabel : ( ( rule__KeyLabel__Group__0 ) ) ;
    public final void ruleKeyLabel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:791:2: ( ( ( rule__KeyLabel__Group__0 ) ) )
            // InternalMetaDsl.g:792:2: ( ( rule__KeyLabel__Group__0 ) )
            {
            // InternalMetaDsl.g:792:2: ( ( rule__KeyLabel__Group__0 ) )
            // InternalMetaDsl.g:793:3: ( rule__KeyLabel__Group__0 )
            {
             before(grammarAccess.getKeyLabelAccess().getGroup()); 
            // InternalMetaDsl.g:794:3: ( rule__KeyLabel__Group__0 )
            // InternalMetaDsl.g:794:4: rule__KeyLabel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__KeyLabel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKeyLabelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyLabel"


    // $ANTLR start "entryRuleOverrideLabelBlock"
    // InternalMetaDsl.g:803:1: entryRuleOverrideLabelBlock : ruleOverrideLabelBlock EOF ;
    public final void entryRuleOverrideLabelBlock() throws RecognitionException {
        try {
            // InternalMetaDsl.g:804:1: ( ruleOverrideLabelBlock EOF )
            // InternalMetaDsl.g:805:1: ruleOverrideLabelBlock EOF
            {
             before(grammarAccess.getOverrideLabelBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleOverrideLabelBlock();

            state._fsp--;

             after(grammarAccess.getOverrideLabelBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOverrideLabelBlock"


    // $ANTLR start "ruleOverrideLabelBlock"
    // InternalMetaDsl.g:812:1: ruleOverrideLabelBlock : ( ( rule__OverrideLabelBlock__Group__0 ) ) ;
    public final void ruleOverrideLabelBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:816:2: ( ( ( rule__OverrideLabelBlock__Group__0 ) ) )
            // InternalMetaDsl.g:817:2: ( ( rule__OverrideLabelBlock__Group__0 ) )
            {
            // InternalMetaDsl.g:817:2: ( ( rule__OverrideLabelBlock__Group__0 ) )
            // InternalMetaDsl.g:818:3: ( rule__OverrideLabelBlock__Group__0 )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getGroup()); 
            // InternalMetaDsl.g:819:3: ( rule__OverrideLabelBlock__Group__0 )
            // InternalMetaDsl.g:819:4: rule__OverrideLabelBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOverrideLabelBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOverrideLabelBlock"


    // $ANTLR start "entryRuleEnumerationLabels"
    // InternalMetaDsl.g:828:1: entryRuleEnumerationLabels : ruleEnumerationLabels EOF ;
    public final void entryRuleEnumerationLabels() throws RecognitionException {
        try {
            // InternalMetaDsl.g:829:1: ( ruleEnumerationLabels EOF )
            // InternalMetaDsl.g:830:1: ruleEnumerationLabels EOF
            {
             before(grammarAccess.getEnumerationLabelsRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumerationLabels();

            state._fsp--;

             after(grammarAccess.getEnumerationLabelsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumerationLabels"


    // $ANTLR start "ruleEnumerationLabels"
    // InternalMetaDsl.g:837:1: ruleEnumerationLabels : ( ( rule__EnumerationLabels__Group__0 ) ) ;
    public final void ruleEnumerationLabels() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:841:2: ( ( ( rule__EnumerationLabels__Group__0 ) ) )
            // InternalMetaDsl.g:842:2: ( ( rule__EnumerationLabels__Group__0 ) )
            {
            // InternalMetaDsl.g:842:2: ( ( rule__EnumerationLabels__Group__0 ) )
            // InternalMetaDsl.g:843:3: ( rule__EnumerationLabels__Group__0 )
            {
             before(grammarAccess.getEnumerationLabelsAccess().getGroup()); 
            // InternalMetaDsl.g:844:3: ( rule__EnumerationLabels__Group__0 )
            // InternalMetaDsl.g:844:4: rule__EnumerationLabels__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationLabels__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationLabelsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumerationLabels"


    // $ANTLR start "entryRuleEnumerationLabel"
    // InternalMetaDsl.g:853:1: entryRuleEnumerationLabel : ruleEnumerationLabel EOF ;
    public final void entryRuleEnumerationLabel() throws RecognitionException {
        try {
            // InternalMetaDsl.g:854:1: ( ruleEnumerationLabel EOF )
            // InternalMetaDsl.g:855:1: ruleEnumerationLabel EOF
            {
             before(grammarAccess.getEnumerationLabelRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumerationLabel();

            state._fsp--;

             after(grammarAccess.getEnumerationLabelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumerationLabel"


    // $ANTLR start "ruleEnumerationLabel"
    // InternalMetaDsl.g:862:1: ruleEnumerationLabel : ( ( rule__EnumerationLabel__Group__0 ) ) ;
    public final void ruleEnumerationLabel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:866:2: ( ( ( rule__EnumerationLabel__Group__0 ) ) )
            // InternalMetaDsl.g:867:2: ( ( rule__EnumerationLabel__Group__0 ) )
            {
            // InternalMetaDsl.g:867:2: ( ( rule__EnumerationLabel__Group__0 ) )
            // InternalMetaDsl.g:868:3: ( rule__EnumerationLabel__Group__0 )
            {
             before(grammarAccess.getEnumerationLabelAccess().getGroup()); 
            // InternalMetaDsl.g:869:3: ( rule__EnumerationLabel__Group__0 )
            // InternalMetaDsl.g:869:4: rule__EnumerationLabel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationLabel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationLabelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumerationLabel"


    // $ANTLR start "entryRuleLabel"
    // InternalMetaDsl.g:878:1: entryRuleLabel : ruleLabel EOF ;
    public final void entryRuleLabel() throws RecognitionException {
        try {
            // InternalMetaDsl.g:879:1: ( ruleLabel EOF )
            // InternalMetaDsl.g:880:1: ruleLabel EOF
            {
             before(grammarAccess.getLabelRule()); 
            pushFollow(FOLLOW_1);
            ruleLabel();

            state._fsp--;

             after(grammarAccess.getLabelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLabel"


    // $ANTLR start "ruleLabel"
    // InternalMetaDsl.g:887:1: ruleLabel : ( ( rule__Label__Group__0 ) ) ;
    public final void ruleLabel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:891:2: ( ( ( rule__Label__Group__0 ) ) )
            // InternalMetaDsl.g:892:2: ( ( rule__Label__Group__0 ) )
            {
            // InternalMetaDsl.g:892:2: ( ( rule__Label__Group__0 ) )
            // InternalMetaDsl.g:893:3: ( rule__Label__Group__0 )
            {
             before(grammarAccess.getLabelAccess().getGroup()); 
            // InternalMetaDsl.g:894:3: ( rule__Label__Group__0 )
            // InternalMetaDsl.g:894:4: rule__Label__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Label__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLabelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLabel"


    // $ANTLR start "entryRuleDocumentationSection"
    // InternalMetaDsl.g:903:1: entryRuleDocumentationSection : ruleDocumentationSection EOF ;
    public final void entryRuleDocumentationSection() throws RecognitionException {
        try {
            // InternalMetaDsl.g:904:1: ( ruleDocumentationSection EOF )
            // InternalMetaDsl.g:905:1: ruleDocumentationSection EOF
            {
             before(grammarAccess.getDocumentationSectionRule()); 
            pushFollow(FOLLOW_1);
            ruleDocumentationSection();

            state._fsp--;

             after(grammarAccess.getDocumentationSectionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDocumentationSection"


    // $ANTLR start "ruleDocumentationSection"
    // InternalMetaDsl.g:912:1: ruleDocumentationSection : ( ( rule__DocumentationSection__Group__0 ) ) ;
    public final void ruleDocumentationSection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:916:2: ( ( ( rule__DocumentationSection__Group__0 ) ) )
            // InternalMetaDsl.g:917:2: ( ( rule__DocumentationSection__Group__0 ) )
            {
            // InternalMetaDsl.g:917:2: ( ( rule__DocumentationSection__Group__0 ) )
            // InternalMetaDsl.g:918:3: ( rule__DocumentationSection__Group__0 )
            {
             before(grammarAccess.getDocumentationSectionAccess().getGroup()); 
            // InternalMetaDsl.g:919:3: ( rule__DocumentationSection__Group__0 )
            // InternalMetaDsl.g:919:4: rule__DocumentationSection__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DocumentationSection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationSectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDocumentationSection"


    // $ANTLR start "entryRuleDocumentationBlock"
    // InternalMetaDsl.g:928:1: entryRuleDocumentationBlock : ruleDocumentationBlock EOF ;
    public final void entryRuleDocumentationBlock() throws RecognitionException {
        try {
            // InternalMetaDsl.g:929:1: ( ruleDocumentationBlock EOF )
            // InternalMetaDsl.g:930:1: ruleDocumentationBlock EOF
            {
             before(grammarAccess.getDocumentationBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleDocumentationBlock();

            state._fsp--;

             after(grammarAccess.getDocumentationBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDocumentationBlock"


    // $ANTLR start "ruleDocumentationBlock"
    // InternalMetaDsl.g:937:1: ruleDocumentationBlock : ( ( rule__DocumentationBlock__Group__0 ) ) ;
    public final void ruleDocumentationBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:941:2: ( ( ( rule__DocumentationBlock__Group__0 ) ) )
            // InternalMetaDsl.g:942:2: ( ( rule__DocumentationBlock__Group__0 ) )
            {
            // InternalMetaDsl.g:942:2: ( ( rule__DocumentationBlock__Group__0 ) )
            // InternalMetaDsl.g:943:3: ( rule__DocumentationBlock__Group__0 )
            {
             before(grammarAccess.getDocumentationBlockAccess().getGroup()); 
            // InternalMetaDsl.g:944:3: ( rule__DocumentationBlock__Group__0 )
            // InternalMetaDsl.g:944:4: rule__DocumentationBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DocumentationBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDocumentationBlock"


    // $ANTLR start "entryRuleQuerySourceBlock"
    // InternalMetaDsl.g:953:1: entryRuleQuerySourceBlock : ruleQuerySourceBlock EOF ;
    public final void entryRuleQuerySourceBlock() throws RecognitionException {
        try {
            // InternalMetaDsl.g:954:1: ( ruleQuerySourceBlock EOF )
            // InternalMetaDsl.g:955:1: ruleQuerySourceBlock EOF
            {
             before(grammarAccess.getQuerySourceBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleQuerySourceBlock();

            state._fsp--;

             after(grammarAccess.getQuerySourceBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuerySourceBlock"


    // $ANTLR start "ruleQuerySourceBlock"
    // InternalMetaDsl.g:962:1: ruleQuerySourceBlock : ( ( rule__QuerySourceBlock__Group__0 ) ) ;
    public final void ruleQuerySourceBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:966:2: ( ( ( rule__QuerySourceBlock__Group__0 ) ) )
            // InternalMetaDsl.g:967:2: ( ( rule__QuerySourceBlock__Group__0 ) )
            {
            // InternalMetaDsl.g:967:2: ( ( rule__QuerySourceBlock__Group__0 ) )
            // InternalMetaDsl.g:968:3: ( rule__QuerySourceBlock__Group__0 )
            {
             before(grammarAccess.getQuerySourceBlockAccess().getGroup()); 
            // InternalMetaDsl.g:969:3: ( rule__QuerySourceBlock__Group__0 )
            // InternalMetaDsl.g:969:4: rule__QuerySourceBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuerySourceBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuerySourceBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuerySourceBlock"


    // $ANTLR start "entryRuleSQLFunction"
    // InternalMetaDsl.g:978:1: entryRuleSQLFunction : ruleSQLFunction EOF ;
    public final void entryRuleSQLFunction() throws RecognitionException {
        try {
            // InternalMetaDsl.g:979:1: ( ruleSQLFunction EOF )
            // InternalMetaDsl.g:980:1: ruleSQLFunction EOF
            {
             before(grammarAccess.getSQLFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleSQLFunction();

            state._fsp--;

             after(grammarAccess.getSQLFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSQLFunction"


    // $ANTLR start "ruleSQLFunction"
    // InternalMetaDsl.g:987:1: ruleSQLFunction : ( ( rule__SQLFunction__Group__0 ) ) ;
    public final void ruleSQLFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:991:2: ( ( ( rule__SQLFunction__Group__0 ) ) )
            // InternalMetaDsl.g:992:2: ( ( rule__SQLFunction__Group__0 ) )
            {
            // InternalMetaDsl.g:992:2: ( ( rule__SQLFunction__Group__0 ) )
            // InternalMetaDsl.g:993:3: ( rule__SQLFunction__Group__0 )
            {
             before(grammarAccess.getSQLFunctionAccess().getGroup()); 
            // InternalMetaDsl.g:994:3: ( rule__SQLFunction__Group__0 )
            // InternalMetaDsl.g:994:4: rule__SQLFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SQLFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSQLFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSQLFunction"


    // $ANTLR start "entryRuleSqlNative"
    // InternalMetaDsl.g:1003:1: entryRuleSqlNative : ruleSqlNative EOF ;
    public final void entryRuleSqlNative() throws RecognitionException {
        try {
            // InternalMetaDsl.g:1004:1: ( ruleSqlNative EOF )
            // InternalMetaDsl.g:1005:1: ruleSqlNative EOF
            {
             before(grammarAccess.getSqlNativeRule()); 
            pushFollow(FOLLOW_1);
            ruleSqlNative();

            state._fsp--;

             after(grammarAccess.getSqlNativeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSqlNative"


    // $ANTLR start "ruleSqlNative"
    // InternalMetaDsl.g:1012:1: ruleSqlNative : ( ( rule__SqlNative__Group__0 ) ) ;
    public final void ruleSqlNative() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1016:2: ( ( ( rule__SqlNative__Group__0 ) ) )
            // InternalMetaDsl.g:1017:2: ( ( rule__SqlNative__Group__0 ) )
            {
            // InternalMetaDsl.g:1017:2: ( ( rule__SqlNative__Group__0 ) )
            // InternalMetaDsl.g:1018:3: ( rule__SqlNative__Group__0 )
            {
             before(grammarAccess.getSqlNativeAccess().getGroup()); 
            // InternalMetaDsl.g:1019:3: ( rule__SqlNative__Group__0 )
            // InternalMetaDsl.g:1019:4: rule__SqlNative__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SqlNative__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSqlNativeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSqlNative"


    // $ANTLR start "entryRuleSqlNativeBlock"
    // InternalMetaDsl.g:1028:1: entryRuleSqlNativeBlock : ruleSqlNativeBlock EOF ;
    public final void entryRuleSqlNativeBlock() throws RecognitionException {
        try {
            // InternalMetaDsl.g:1029:1: ( ruleSqlNativeBlock EOF )
            // InternalMetaDsl.g:1030:1: ruleSqlNativeBlock EOF
            {
             before(grammarAccess.getSqlNativeBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleSqlNativeBlock();

            state._fsp--;

             after(grammarAccess.getSqlNativeBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSqlNativeBlock"


    // $ANTLR start "ruleSqlNativeBlock"
    // InternalMetaDsl.g:1037:1: ruleSqlNativeBlock : ( ( rule__SqlNativeBlock__Group__0 ) ) ;
    public final void ruleSqlNativeBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1041:2: ( ( ( rule__SqlNativeBlock__Group__0 ) ) )
            // InternalMetaDsl.g:1042:2: ( ( rule__SqlNativeBlock__Group__0 ) )
            {
            // InternalMetaDsl.g:1042:2: ( ( rule__SqlNativeBlock__Group__0 ) )
            // InternalMetaDsl.g:1043:3: ( rule__SqlNativeBlock__Group__0 )
            {
             before(grammarAccess.getSqlNativeBlockAccess().getGroup()); 
            // InternalMetaDsl.g:1044:3: ( rule__SqlNativeBlock__Group__0 )
            // InternalMetaDsl.g:1044:4: rule__SqlNativeBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSqlNativeBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSqlNativeBlock"


    // $ANTLR start "rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0"
    // InternalMetaDsl.g:1052:1: rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0 : ( ( 'NONE' ) | ( 'SEQUENCE' ) | ( 'IDENTITY' ) );
    public final void rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1056:1: ( ( 'NONE' ) | ( 'SEQUENCE' ) | ( 'IDENTITY' ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt1=1;
                }
                break;
            case 16:
                {
                alt1=2;
                }
                break;
            case 17:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalMetaDsl.g:1057:2: ( 'NONE' )
                    {
                    // InternalMetaDsl.g:1057:2: ( 'NONE' )
                    // InternalMetaDsl.g:1058:3: 'NONE'
                    {
                     before(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyNONEKeyword_9_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyNONEKeyword_9_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1063:2: ( 'SEQUENCE' )
                    {
                    // InternalMetaDsl.g:1063:2: ( 'SEQUENCE' )
                    // InternalMetaDsl.g:1064:3: 'SEQUENCE'
                    {
                     before(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategySEQUENCEKeyword_9_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategySEQUENCEKeyword_9_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:1069:2: ( 'IDENTITY' )
                    {
                    // InternalMetaDsl.g:1069:2: ( 'IDENTITY' )
                    // InternalMetaDsl.g:1070:3: 'IDENTITY'
                    {
                     before(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyIDENTITYKeyword_9_0_2()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyIDENTITYKeyword_9_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0"


    // $ANTLR start "rule__DataTypeDefinition__Alternatives"
    // InternalMetaDsl.g:1079:1: rule__DataTypeDefinition__Alternatives : ( ( ruleDataTypeDetails ) | ( ruleSubTypeDataType ) );
    public final void rule__DataTypeDefinition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1083:1: ( ( ruleDataTypeDetails ) | ( ruleSubTypeDataType ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==43) ) {
                alt2=1;
            }
            else if ( (LA2_0==45) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMetaDsl.g:1084:2: ( ruleDataTypeDetails )
                    {
                    // InternalMetaDsl.g:1084:2: ( ruleDataTypeDetails )
                    // InternalMetaDsl.g:1085:3: ruleDataTypeDetails
                    {
                     before(grammarAccess.getDataTypeDefinitionAccess().getDataTypeDetailsParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDataTypeDetails();

                    state._fsp--;

                     after(grammarAccess.getDataTypeDefinitionAccess().getDataTypeDetailsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1090:2: ( ruleSubTypeDataType )
                    {
                    // InternalMetaDsl.g:1090:2: ( ruleSubTypeDataType )
                    // InternalMetaDsl.g:1091:3: ruleSubTypeDataType
                    {
                     before(grammarAccess.getDataTypeDefinitionAccess().getSubTypeDataTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleSubTypeDataType();

                    state._fsp--;

                     after(grammarAccess.getDataTypeDefinitionAccess().getSubTypeDataTypeParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDefinition__Alternatives"


    // $ANTLR start "rule__DataTypeDetails__Alternatives_2"
    // InternalMetaDsl.g:1100:1: rule__DataTypeDetails__Alternatives_2 : ( ( ( rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0 ) ) | ( ( rule__DataTypeDetails__WithLengthAssignment_2_1 ) ) );
    public final void rule__DataTypeDetails__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1104:1: ( ( ( rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0 ) ) | ( ( rule__DataTypeDetails__WithLengthAssignment_2_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==81) ) {
                alt3=1;
            }
            else if ( (LA3_0==82) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMetaDsl.g:1105:2: ( ( rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0 ) )
                    {
                    // InternalMetaDsl.g:1105:2: ( ( rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0 ) )
                    // InternalMetaDsl.g:1106:3: ( rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0 )
                    {
                     before(grammarAccess.getDataTypeDetailsAccess().getWithPrecissionAndScaleAssignment_2_0()); 
                    // InternalMetaDsl.g:1107:3: ( rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0 )
                    // InternalMetaDsl.g:1107:4: rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataTypeDetailsAccess().getWithPrecissionAndScaleAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1111:2: ( ( rule__DataTypeDetails__WithLengthAssignment_2_1 ) )
                    {
                    // InternalMetaDsl.g:1111:2: ( ( rule__DataTypeDetails__WithLengthAssignment_2_1 ) )
                    // InternalMetaDsl.g:1112:3: ( rule__DataTypeDetails__WithLengthAssignment_2_1 )
                    {
                     before(grammarAccess.getDataTypeDetailsAccess().getWithLengthAssignment_2_1()); 
                    // InternalMetaDsl.g:1113:3: ( rule__DataTypeDetails__WithLengthAssignment_2_1 )
                    // InternalMetaDsl.g:1113:4: rule__DataTypeDetails__WithLengthAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataTypeDetails__WithLengthAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDataTypeDetailsAccess().getWithLengthAssignment_2_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Alternatives_2"


    // $ANTLR start "rule__SubTypeDataType__Alternatives_2_1"
    // InternalMetaDsl.g:1121:1: rule__SubTypeDataType__Alternatives_2_1 : ( ( ( rule__SubTypeDataType__LengthAssignment_2_1_0 ) ) | ( ( rule__SubTypeDataType__MaxlengthAssignment_2_1_1 ) ) );
    public final void rule__SubTypeDataType__Alternatives_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1125:1: ( ( ( rule__SubTypeDataType__LengthAssignment_2_1_0 ) ) | ( ( rule__SubTypeDataType__MaxlengthAssignment_2_1_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_NATURAL) ) {
                alt4=1;
            }
            else if ( (LA4_0==83) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMetaDsl.g:1126:2: ( ( rule__SubTypeDataType__LengthAssignment_2_1_0 ) )
                    {
                    // InternalMetaDsl.g:1126:2: ( ( rule__SubTypeDataType__LengthAssignment_2_1_0 ) )
                    // InternalMetaDsl.g:1127:3: ( rule__SubTypeDataType__LengthAssignment_2_1_0 )
                    {
                     before(grammarAccess.getSubTypeDataTypeAccess().getLengthAssignment_2_1_0()); 
                    // InternalMetaDsl.g:1128:3: ( rule__SubTypeDataType__LengthAssignment_2_1_0 )
                    // InternalMetaDsl.g:1128:4: rule__SubTypeDataType__LengthAssignment_2_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubTypeDataType__LengthAssignment_2_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSubTypeDataTypeAccess().getLengthAssignment_2_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1132:2: ( ( rule__SubTypeDataType__MaxlengthAssignment_2_1_1 ) )
                    {
                    // InternalMetaDsl.g:1132:2: ( ( rule__SubTypeDataType__MaxlengthAssignment_2_1_1 ) )
                    // InternalMetaDsl.g:1133:3: ( rule__SubTypeDataType__MaxlengthAssignment_2_1_1 )
                    {
                     before(grammarAccess.getSubTypeDataTypeAccess().getMaxlengthAssignment_2_1_1()); 
                    // InternalMetaDsl.g:1134:3: ( rule__SubTypeDataType__MaxlengthAssignment_2_1_1 )
                    // InternalMetaDsl.g:1134:4: rule__SubTypeDataType__MaxlengthAssignment_2_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubTypeDataType__MaxlengthAssignment_2_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSubTypeDataTypeAccess().getMaxlengthAssignment_2_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Alternatives_2_1"


    // $ANTLR start "rule__Entity__EntityTypeAlternatives_2_0"
    // InternalMetaDsl.g:1142:1: rule__Entity__EntityTypeAlternatives_2_0 : ( ( 'TABLE' ) | ( 'VIEW' ) | ( 'SQLQUERY' ) );
    public final void rule__Entity__EntityTypeAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1146:1: ( ( 'TABLE' ) | ( 'VIEW' ) | ( 'SQLQUERY' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt5=1;
                }
                break;
            case 19:
                {
                alt5=2;
                }
                break;
            case 20:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalMetaDsl.g:1147:2: ( 'TABLE' )
                    {
                    // InternalMetaDsl.g:1147:2: ( 'TABLE' )
                    // InternalMetaDsl.g:1148:3: 'TABLE'
                    {
                     before(grammarAccess.getEntityAccess().getEntityTypeTABLEKeyword_2_0_0()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getEntityAccess().getEntityTypeTABLEKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1153:2: ( 'VIEW' )
                    {
                    // InternalMetaDsl.g:1153:2: ( 'VIEW' )
                    // InternalMetaDsl.g:1154:3: 'VIEW'
                    {
                     before(grammarAccess.getEntityAccess().getEntityTypeVIEWKeyword_2_0_1()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getEntityAccess().getEntityTypeVIEWKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:1159:2: ( 'SQLQUERY' )
                    {
                    // InternalMetaDsl.g:1159:2: ( 'SQLQUERY' )
                    // InternalMetaDsl.g:1160:3: 'SQLQUERY'
                    {
                     before(grammarAccess.getEntityAccess().getEntityTypeSQLQUERYKeyword_2_0_2()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getEntityAccess().getEntityTypeSQLQUERYKeyword_2_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__EntityTypeAlternatives_2_0"


    // $ANTLR start "rule__Attribute__Alternatives_4_1"
    // InternalMetaDsl.g:1169:1: rule__Attribute__Alternatives_4_1 : ( ( ( rule__Attribute__LengthAssignment_4_1_0 ) ) | ( ( rule__Attribute__MaxlengthAssignment_4_1_1 ) ) );
    public final void rule__Attribute__Alternatives_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1173:1: ( ( ( rule__Attribute__LengthAssignment_4_1_0 ) ) | ( ( rule__Attribute__MaxlengthAssignment_4_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_NATURAL) ) {
                alt6=1;
            }
            else if ( (LA6_0==83) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMetaDsl.g:1174:2: ( ( rule__Attribute__LengthAssignment_4_1_0 ) )
                    {
                    // InternalMetaDsl.g:1174:2: ( ( rule__Attribute__LengthAssignment_4_1_0 ) )
                    // InternalMetaDsl.g:1175:3: ( rule__Attribute__LengthAssignment_4_1_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getLengthAssignment_4_1_0()); 
                    // InternalMetaDsl.g:1176:3: ( rule__Attribute__LengthAssignment_4_1_0 )
                    // InternalMetaDsl.g:1176:4: rule__Attribute__LengthAssignment_4_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__LengthAssignment_4_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeAccess().getLengthAssignment_4_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1180:2: ( ( rule__Attribute__MaxlengthAssignment_4_1_1 ) )
                    {
                    // InternalMetaDsl.g:1180:2: ( ( rule__Attribute__MaxlengthAssignment_4_1_1 ) )
                    // InternalMetaDsl.g:1181:3: ( rule__Attribute__MaxlengthAssignment_4_1_1 )
                    {
                     before(grammarAccess.getAttributeAccess().getMaxlengthAssignment_4_1_1()); 
                    // InternalMetaDsl.g:1182:3: ( rule__Attribute__MaxlengthAssignment_4_1_1 )
                    // InternalMetaDsl.g:1182:4: rule__Attribute__MaxlengthAssignment_4_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__MaxlengthAssignment_4_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeAccess().getMaxlengthAssignment_4_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Alternatives_4_1"


    // $ANTLR start "rule__Attribute__Alternatives_9_1"
    // InternalMetaDsl.g:1190:1: rule__Attribute__Alternatives_9_1 : ( ( ( rule__Attribute__DefaultAssignment_9_1_0 ) ) | ( ( rule__Attribute__DefaultConstantAssignment_9_1_1 ) ) );
    public final void rule__Attribute__Alternatives_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1194:1: ( ( ( rule__Attribute__DefaultAssignment_9_1_0 ) ) | ( ( rule__Attribute__DefaultConstantAssignment_9_1_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMetaDsl.g:1195:2: ( ( rule__Attribute__DefaultAssignment_9_1_0 ) )
                    {
                    // InternalMetaDsl.g:1195:2: ( ( rule__Attribute__DefaultAssignment_9_1_0 ) )
                    // InternalMetaDsl.g:1196:3: ( rule__Attribute__DefaultAssignment_9_1_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getDefaultAssignment_9_1_0()); 
                    // InternalMetaDsl.g:1197:3: ( rule__Attribute__DefaultAssignment_9_1_0 )
                    // InternalMetaDsl.g:1197:4: rule__Attribute__DefaultAssignment_9_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__DefaultAssignment_9_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeAccess().getDefaultAssignment_9_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1201:2: ( ( rule__Attribute__DefaultConstantAssignment_9_1_1 ) )
                    {
                    // InternalMetaDsl.g:1201:2: ( ( rule__Attribute__DefaultConstantAssignment_9_1_1 ) )
                    // InternalMetaDsl.g:1202:3: ( rule__Attribute__DefaultConstantAssignment_9_1_1 )
                    {
                     before(grammarAccess.getAttributeAccess().getDefaultConstantAssignment_9_1_1()); 
                    // InternalMetaDsl.g:1203:3: ( rule__Attribute__DefaultConstantAssignment_9_1_1 )
                    // InternalMetaDsl.g:1203:4: rule__Attribute__DefaultConstantAssignment_9_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__DefaultConstantAssignment_9_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeAccess().getDefaultConstantAssignment_9_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Alternatives_9_1"


    // $ANTLR start "rule__IdGeneratorTypeBlock__Alternatives"
    // InternalMetaDsl.g:1211:1: rule__IdGeneratorTypeBlock__Alternatives : ( ( ruleIdGeneratorSimple ) | ( ruleIdGeneratorSequence ) );
    public final void rule__IdGeneratorTypeBlock__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1215:1: ( ( ruleIdGeneratorSimple ) | ( ruleIdGeneratorSequence ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15||LA8_0==17||(LA8_0>=21 && LA8_0<=22)||LA8_0==89) ) {
                alt8=1;
            }
            else if ( (LA8_0==16) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalMetaDsl.g:1216:2: ( ruleIdGeneratorSimple )
                    {
                    // InternalMetaDsl.g:1216:2: ( ruleIdGeneratorSimple )
                    // InternalMetaDsl.g:1217:3: ruleIdGeneratorSimple
                    {
                     before(grammarAccess.getIdGeneratorTypeBlockAccess().getIdGeneratorSimpleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIdGeneratorSimple();

                    state._fsp--;

                     after(grammarAccess.getIdGeneratorTypeBlockAccess().getIdGeneratorSimpleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1222:2: ( ruleIdGeneratorSequence )
                    {
                    // InternalMetaDsl.g:1222:2: ( ruleIdGeneratorSequence )
                    // InternalMetaDsl.g:1223:3: ruleIdGeneratorSequence
                    {
                     before(grammarAccess.getIdGeneratorTypeBlockAccess().getIdGeneratorSequenceParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleIdGeneratorSequence();

                    state._fsp--;

                     after(grammarAccess.getIdGeneratorTypeBlockAccess().getIdGeneratorSequenceParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorTypeBlock__Alternatives"


    // $ANTLR start "rule__IdGeneratorSimple__Alternatives"
    // InternalMetaDsl.g:1232:1: rule__IdGeneratorSimple__Alternatives : ( ( ( rule__IdGeneratorSimple__Group_0__0 ) ) | ( 'GUID' ) | ( 'IDENTITY' ) | ( 'NONE' ) | ( 'APPLICATION' ) );
    public final void rule__IdGeneratorSimple__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1236:1: ( ( ( rule__IdGeneratorSimple__Group_0__0 ) ) | ( 'GUID' ) | ( 'IDENTITY' ) | ( 'NONE' ) | ( 'APPLICATION' ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt9=1;
                }
                break;
            case 21:
                {
                alt9=2;
                }
                break;
            case 17:
                {
                alt9=3;
                }
                break;
            case 15:
                {
                alt9=4;
                }
                break;
            case 22:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalMetaDsl.g:1237:2: ( ( rule__IdGeneratorSimple__Group_0__0 ) )
                    {
                    // InternalMetaDsl.g:1237:2: ( ( rule__IdGeneratorSimple__Group_0__0 ) )
                    // InternalMetaDsl.g:1238:3: ( rule__IdGeneratorSimple__Group_0__0 )
                    {
                     before(grammarAccess.getIdGeneratorSimpleAccess().getGroup_0()); 
                    // InternalMetaDsl.g:1239:3: ( rule__IdGeneratorSimple__Group_0__0 )
                    // InternalMetaDsl.g:1239:4: rule__IdGeneratorSimple__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IdGeneratorSimple__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIdGeneratorSimpleAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1243:2: ( 'GUID' )
                    {
                    // InternalMetaDsl.g:1243:2: ( 'GUID' )
                    // InternalMetaDsl.g:1244:3: 'GUID'
                    {
                     before(grammarAccess.getIdGeneratorSimpleAccess().getGUIDKeyword_1()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getIdGeneratorSimpleAccess().getGUIDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:1249:2: ( 'IDENTITY' )
                    {
                    // InternalMetaDsl.g:1249:2: ( 'IDENTITY' )
                    // InternalMetaDsl.g:1250:3: 'IDENTITY'
                    {
                     before(grammarAccess.getIdGeneratorSimpleAccess().getIDENTITYKeyword_2()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getIdGeneratorSimpleAccess().getIDENTITYKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMetaDsl.g:1255:2: ( 'NONE' )
                    {
                    // InternalMetaDsl.g:1255:2: ( 'NONE' )
                    // InternalMetaDsl.g:1256:3: 'NONE'
                    {
                     before(grammarAccess.getIdGeneratorSimpleAccess().getNONEKeyword_3()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getIdGeneratorSimpleAccess().getNONEKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMetaDsl.g:1261:2: ( 'APPLICATION' )
                    {
                    // InternalMetaDsl.g:1261:2: ( 'APPLICATION' )
                    // InternalMetaDsl.g:1262:3: 'APPLICATION'
                    {
                     before(grammarAccess.getIdGeneratorSimpleAccess().getAPPLICATIONKeyword_4()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getIdGeneratorSimpleAccess().getAPPLICATIONKeyword_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSimple__Alternatives"


    // $ANTLR start "rule__MetadataRowCell__Alternatives"
    // InternalMetaDsl.g:1271:1: rule__MetadataRowCell__Alternatives : ( ( ( rule__MetadataRowCell__StringValueAssignment_0 ) ) | ( ( rule__MetadataRowCell__ShortCodeAssignment_1 ) ) | ( ( rule__MetadataRowCell__IsNullAssignment_2 ) ) | ( ( rule__MetadataRowCell__IsDefaultAssignment_3 ) ) );
    public final void rule__MetadataRowCell__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1275:1: ( ( ( rule__MetadataRowCell__StringValueAssignment_0 ) ) | ( ( rule__MetadataRowCell__ShortCodeAssignment_1 ) ) | ( ( rule__MetadataRowCell__IsNullAssignment_2 ) ) | ( ( rule__MetadataRowCell__IsDefaultAssignment_3 ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_DOUBLE:
            case RULE_NATURAL:
            case RULE_NEGATIVEINT:
                {
                alt10=1;
                }
                break;
            case 70:
                {
                alt10=2;
                }
                break;
            case 91:
                {
                alt10=3;
                }
                break;
            case 33:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalMetaDsl.g:1276:2: ( ( rule__MetadataRowCell__StringValueAssignment_0 ) )
                    {
                    // InternalMetaDsl.g:1276:2: ( ( rule__MetadataRowCell__StringValueAssignment_0 ) )
                    // InternalMetaDsl.g:1277:3: ( rule__MetadataRowCell__StringValueAssignment_0 )
                    {
                     before(grammarAccess.getMetadataRowCellAccess().getStringValueAssignment_0()); 
                    // InternalMetaDsl.g:1278:3: ( rule__MetadataRowCell__StringValueAssignment_0 )
                    // InternalMetaDsl.g:1278:4: rule__MetadataRowCell__StringValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MetadataRowCell__StringValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetadataRowCellAccess().getStringValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1282:2: ( ( rule__MetadataRowCell__ShortCodeAssignment_1 ) )
                    {
                    // InternalMetaDsl.g:1282:2: ( ( rule__MetadataRowCell__ShortCodeAssignment_1 ) )
                    // InternalMetaDsl.g:1283:3: ( rule__MetadataRowCell__ShortCodeAssignment_1 )
                    {
                     before(grammarAccess.getMetadataRowCellAccess().getShortCodeAssignment_1()); 
                    // InternalMetaDsl.g:1284:3: ( rule__MetadataRowCell__ShortCodeAssignment_1 )
                    // InternalMetaDsl.g:1284:4: rule__MetadataRowCell__ShortCodeAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__MetadataRowCell__ShortCodeAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetadataRowCellAccess().getShortCodeAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:1288:2: ( ( rule__MetadataRowCell__IsNullAssignment_2 ) )
                    {
                    // InternalMetaDsl.g:1288:2: ( ( rule__MetadataRowCell__IsNullAssignment_2 ) )
                    // InternalMetaDsl.g:1289:3: ( rule__MetadataRowCell__IsNullAssignment_2 )
                    {
                     before(grammarAccess.getMetadataRowCellAccess().getIsNullAssignment_2()); 
                    // InternalMetaDsl.g:1290:3: ( rule__MetadataRowCell__IsNullAssignment_2 )
                    // InternalMetaDsl.g:1290:4: rule__MetadataRowCell__IsNullAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__MetadataRowCell__IsNullAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetadataRowCellAccess().getIsNullAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMetaDsl.g:1294:2: ( ( rule__MetadataRowCell__IsDefaultAssignment_3 ) )
                    {
                    // InternalMetaDsl.g:1294:2: ( ( rule__MetadataRowCell__IsDefaultAssignment_3 ) )
                    // InternalMetaDsl.g:1295:3: ( rule__MetadataRowCell__IsDefaultAssignment_3 )
                    {
                     before(grammarAccess.getMetadataRowCellAccess().getIsDefaultAssignment_3()); 
                    // InternalMetaDsl.g:1296:3: ( rule__MetadataRowCell__IsDefaultAssignment_3 )
                    // InternalMetaDsl.g:1296:4: rule__MetadataRowCell__IsDefaultAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__MetadataRowCell__IsDefaultAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getMetadataRowCellAccess().getIsDefaultAssignment_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRowCell__Alternatives"


    // $ANTLR start "rule__MetadataRowCell__StringValueAlternatives_0_0"
    // InternalMetaDsl.g:1304:1: rule__MetadataRowCell__StringValueAlternatives_0_0 : ( ( RULE_STRING ) | ( RULE_DOUBLE ) | ( RULE_NATURAL ) | ( RULE_NEGATIVEINT ) );
    public final void rule__MetadataRowCell__StringValueAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1308:1: ( ( RULE_STRING ) | ( RULE_DOUBLE ) | ( RULE_NATURAL ) | ( RULE_NEGATIVEINT ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt11=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt11=2;
                }
                break;
            case RULE_NATURAL:
                {
                alt11=3;
                }
                break;
            case RULE_NEGATIVEINT:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalMetaDsl.g:1309:2: ( RULE_STRING )
                    {
                    // InternalMetaDsl.g:1309:2: ( RULE_STRING )
                    // InternalMetaDsl.g:1310:3: RULE_STRING
                    {
                     before(grammarAccess.getMetadataRowCellAccess().getStringValueSTRINGTerminalRuleCall_0_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getMetadataRowCellAccess().getStringValueSTRINGTerminalRuleCall_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1315:2: ( RULE_DOUBLE )
                    {
                    // InternalMetaDsl.g:1315:2: ( RULE_DOUBLE )
                    // InternalMetaDsl.g:1316:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getMetadataRowCellAccess().getStringValueDOUBLETerminalRuleCall_0_0_1()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getMetadataRowCellAccess().getStringValueDOUBLETerminalRuleCall_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:1321:2: ( RULE_NATURAL )
                    {
                    // InternalMetaDsl.g:1321:2: ( RULE_NATURAL )
                    // InternalMetaDsl.g:1322:3: RULE_NATURAL
                    {
                     before(grammarAccess.getMetadataRowCellAccess().getStringValueNATURALTerminalRuleCall_0_0_2()); 
                    match(input,RULE_NATURAL,FOLLOW_2); 
                     after(grammarAccess.getMetadataRowCellAccess().getStringValueNATURALTerminalRuleCall_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMetaDsl.g:1327:2: ( RULE_NEGATIVEINT )
                    {
                    // InternalMetaDsl.g:1327:2: ( RULE_NEGATIVEINT )
                    // InternalMetaDsl.g:1328:3: RULE_NEGATIVEINT
                    {
                     before(grammarAccess.getMetadataRowCellAccess().getStringValueNEGATIVEINTTerminalRuleCall_0_0_3()); 
                    match(input,RULE_NEGATIVEINT,FOLLOW_2); 
                     after(grammarAccess.getMetadataRowCellAccess().getStringValueNEGATIVEINTTerminalRuleCall_0_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRowCell__StringValueAlternatives_0_0"


    // $ANTLR start "rule__LabelBlock__Alternatives_1"
    // InternalMetaDsl.g:1337:1: rule__LabelBlock__Alternatives_1 : ( ( ( rule__LabelBlock__EntityAssignment_1_0 ) ) | ( ( rule__LabelBlock__AttributeAssignment_1_1 ) ) );
    public final void rule__LabelBlock__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1341:1: ( ( ( rule__LabelBlock__EntityAssignment_1_0 ) ) | ( ( rule__LabelBlock__AttributeAssignment_1_1 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalMetaDsl.g:1342:2: ( ( rule__LabelBlock__EntityAssignment_1_0 ) )
                    {
                    // InternalMetaDsl.g:1342:2: ( ( rule__LabelBlock__EntityAssignment_1_0 ) )
                    // InternalMetaDsl.g:1343:3: ( rule__LabelBlock__EntityAssignment_1_0 )
                    {
                     before(grammarAccess.getLabelBlockAccess().getEntityAssignment_1_0()); 
                    // InternalMetaDsl.g:1344:3: ( rule__LabelBlock__EntityAssignment_1_0 )
                    // InternalMetaDsl.g:1344:4: rule__LabelBlock__EntityAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__LabelBlock__EntityAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLabelBlockAccess().getEntityAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1348:2: ( ( rule__LabelBlock__AttributeAssignment_1_1 ) )
                    {
                    // InternalMetaDsl.g:1348:2: ( ( rule__LabelBlock__AttributeAssignment_1_1 ) )
                    // InternalMetaDsl.g:1349:3: ( rule__LabelBlock__AttributeAssignment_1_1 )
                    {
                     before(grammarAccess.getLabelBlockAccess().getAttributeAssignment_1_1()); 
                    // InternalMetaDsl.g:1350:3: ( rule__LabelBlock__AttributeAssignment_1_1 )
                    // InternalMetaDsl.g:1350:4: rule__LabelBlock__AttributeAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__LabelBlock__AttributeAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLabelBlockAccess().getAttributeAssignment_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Alternatives_1"


    // $ANTLR start "rule__LabelBlock__TypeAlternatives_3_0"
    // InternalMetaDsl.g:1358:1: rule__LabelBlock__TypeAlternatives_3_0 : ( ( 'SHORTLABEL' ) | ( 'LONGLABEL' ) );
    public final void rule__LabelBlock__TypeAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1362:1: ( ( 'SHORTLABEL' ) | ( 'LONGLABEL' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            else if ( (LA13_0==24) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalMetaDsl.g:1363:2: ( 'SHORTLABEL' )
                    {
                    // InternalMetaDsl.g:1363:2: ( 'SHORTLABEL' )
                    // InternalMetaDsl.g:1364:3: 'SHORTLABEL'
                    {
                     before(grammarAccess.getLabelBlockAccess().getTypeSHORTLABELKeyword_3_0_0()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getLabelBlockAccess().getTypeSHORTLABELKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1369:2: ( 'LONGLABEL' )
                    {
                    // InternalMetaDsl.g:1369:2: ( 'LONGLABEL' )
                    // InternalMetaDsl.g:1370:3: 'LONGLABEL'
                    {
                     before(grammarAccess.getLabelBlockAccess().getTypeLONGLABELKeyword_3_0_1()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getLabelBlockAccess().getTypeLONGLABELKeyword_3_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__TypeAlternatives_3_0"


    // $ANTLR start "rule__OverrideLabelBlock__Alternatives_1"
    // InternalMetaDsl.g:1379:1: rule__OverrideLabelBlock__Alternatives_1 : ( ( ( rule__OverrideLabelBlock__Group_1_0__0 ) ) | ( ( rule__OverrideLabelBlock__Group_1_1__0 ) ) | ( ( rule__OverrideLabelBlock__Group_1_2__0 ) ) );
    public final void rule__OverrideLabelBlock__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1383:1: ( ( ( rule__OverrideLabelBlock__Group_1_0__0 ) ) | ( ( rule__OverrideLabelBlock__Group_1_1__0 ) ) | ( ( rule__OverrideLabelBlock__Group_1_2__0 ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt14=1;
                }
                break;
            case 25:
                {
                alt14=2;
                }
                break;
            case 73:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalMetaDsl.g:1384:2: ( ( rule__OverrideLabelBlock__Group_1_0__0 ) )
                    {
                    // InternalMetaDsl.g:1384:2: ( ( rule__OverrideLabelBlock__Group_1_0__0 ) )
                    // InternalMetaDsl.g:1385:3: ( rule__OverrideLabelBlock__Group_1_0__0 )
                    {
                     before(grammarAccess.getOverrideLabelBlockAccess().getGroup_1_0()); 
                    // InternalMetaDsl.g:1386:3: ( rule__OverrideLabelBlock__Group_1_0__0 )
                    // InternalMetaDsl.g:1386:4: rule__OverrideLabelBlock__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OverrideLabelBlock__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOverrideLabelBlockAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1390:2: ( ( rule__OverrideLabelBlock__Group_1_1__0 ) )
                    {
                    // InternalMetaDsl.g:1390:2: ( ( rule__OverrideLabelBlock__Group_1_1__0 ) )
                    // InternalMetaDsl.g:1391:3: ( rule__OverrideLabelBlock__Group_1_1__0 )
                    {
                     before(grammarAccess.getOverrideLabelBlockAccess().getGroup_1_1()); 
                    // InternalMetaDsl.g:1392:3: ( rule__OverrideLabelBlock__Group_1_1__0 )
                    // InternalMetaDsl.g:1392:4: rule__OverrideLabelBlock__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OverrideLabelBlock__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOverrideLabelBlockAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:1396:2: ( ( rule__OverrideLabelBlock__Group_1_2__0 ) )
                    {
                    // InternalMetaDsl.g:1396:2: ( ( rule__OverrideLabelBlock__Group_1_2__0 ) )
                    // InternalMetaDsl.g:1397:3: ( rule__OverrideLabelBlock__Group_1_2__0 )
                    {
                     before(grammarAccess.getOverrideLabelBlockAccess().getGroup_1_2()); 
                    // InternalMetaDsl.g:1398:3: ( rule__OverrideLabelBlock__Group_1_2__0 )
                    // InternalMetaDsl.g:1398:4: rule__OverrideLabelBlock__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OverrideLabelBlock__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOverrideLabelBlockAccess().getGroup_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Alternatives_1"


    // $ANTLR start "rule__OverrideLabelBlock__TypeAlternatives_3_0"
    // InternalMetaDsl.g:1406:1: rule__OverrideLabelBlock__TypeAlternatives_3_0 : ( ( 'SHORTLABEL' ) | ( 'LONGLABEL' ) );
    public final void rule__OverrideLabelBlock__TypeAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1410:1: ( ( 'SHORTLABEL' ) | ( 'LONGLABEL' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            else if ( (LA15_0==24) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalMetaDsl.g:1411:2: ( 'SHORTLABEL' )
                    {
                    // InternalMetaDsl.g:1411:2: ( 'SHORTLABEL' )
                    // InternalMetaDsl.g:1412:3: 'SHORTLABEL'
                    {
                     before(grammarAccess.getOverrideLabelBlockAccess().getTypeSHORTLABELKeyword_3_0_0()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getOverrideLabelBlockAccess().getTypeSHORTLABELKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1417:2: ( 'LONGLABEL' )
                    {
                    // InternalMetaDsl.g:1417:2: ( 'LONGLABEL' )
                    // InternalMetaDsl.g:1418:3: 'LONGLABEL'
                    {
                     before(grammarAccess.getOverrideLabelBlockAccess().getTypeLONGLABELKeyword_3_0_1()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getOverrideLabelBlockAccess().getTypeLONGLABELKeyword_3_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__TypeAlternatives_3_0"


    // $ANTLR start "rule__EnumerationLabel__TypeAlternatives_2_0"
    // InternalMetaDsl.g:1427:1: rule__EnumerationLabel__TypeAlternatives_2_0 : ( ( 'SHORTLABEL' ) | ( 'LONGLABEL' ) );
    public final void rule__EnumerationLabel__TypeAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1431:1: ( ( 'SHORTLABEL' ) | ( 'LONGLABEL' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==23) ) {
                alt16=1;
            }
            else if ( (LA16_0==24) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalMetaDsl.g:1432:2: ( 'SHORTLABEL' )
                    {
                    // InternalMetaDsl.g:1432:2: ( 'SHORTLABEL' )
                    // InternalMetaDsl.g:1433:3: 'SHORTLABEL'
                    {
                     before(grammarAccess.getEnumerationLabelAccess().getTypeSHORTLABELKeyword_2_0_0()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getEnumerationLabelAccess().getTypeSHORTLABELKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1438:2: ( 'LONGLABEL' )
                    {
                    // InternalMetaDsl.g:1438:2: ( 'LONGLABEL' )
                    // InternalMetaDsl.g:1439:3: 'LONGLABEL'
                    {
                     before(grammarAccess.getEnumerationLabelAccess().getTypeLONGLABELKeyword_2_0_1()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getEnumerationLabelAccess().getTypeLONGLABELKeyword_2_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__TypeAlternatives_2_0"


    // $ANTLR start "rule__DocumentationBlock__Alternatives_0"
    // InternalMetaDsl.g:1448:1: rule__DocumentationBlock__Alternatives_0 : ( ( 'ENTITY' ) | ( ( rule__DocumentationBlock__AttributeAssignment_0_1 ) ) );
    public final void rule__DocumentationBlock__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1452:1: ( ( 'ENTITY' ) | ( ( rule__DocumentationBlock__AttributeAssignment_0_1 ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMetaDsl.g:1453:2: ( 'ENTITY' )
                    {
                    // InternalMetaDsl.g:1453:2: ( 'ENTITY' )
                    // InternalMetaDsl.g:1454:3: 'ENTITY'
                    {
                     before(grammarAccess.getDocumentationBlockAccess().getENTITYKeyword_0_0()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getDocumentationBlockAccess().getENTITYKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1459:2: ( ( rule__DocumentationBlock__AttributeAssignment_0_1 ) )
                    {
                    // InternalMetaDsl.g:1459:2: ( ( rule__DocumentationBlock__AttributeAssignment_0_1 ) )
                    // InternalMetaDsl.g:1460:3: ( rule__DocumentationBlock__AttributeAssignment_0_1 )
                    {
                     before(grammarAccess.getDocumentationBlockAccess().getAttributeAssignment_0_1()); 
                    // InternalMetaDsl.g:1461:3: ( rule__DocumentationBlock__AttributeAssignment_0_1 )
                    // InternalMetaDsl.g:1461:4: rule__DocumentationBlock__AttributeAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__DocumentationBlock__AttributeAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDocumentationBlockAccess().getAttributeAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationBlock__Alternatives_0"


    // $ANTLR start "rule__DocumentationBlock__DocumentationTextAlternatives_1_0"
    // InternalMetaDsl.g:1469:1: rule__DocumentationBlock__DocumentationTextAlternatives_1_0 : ( ( RULE_ML_STRING ) | ( RULE_STRING ) );
    public final void rule__DocumentationBlock__DocumentationTextAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1473:1: ( ( RULE_ML_STRING ) | ( RULE_STRING ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ML_STRING) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_STRING) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalMetaDsl.g:1474:2: ( RULE_ML_STRING )
                    {
                    // InternalMetaDsl.g:1474:2: ( RULE_ML_STRING )
                    // InternalMetaDsl.g:1475:3: RULE_ML_STRING
                    {
                     before(grammarAccess.getDocumentationBlockAccess().getDocumentationTextML_STRINGTerminalRuleCall_1_0_0()); 
                    match(input,RULE_ML_STRING,FOLLOW_2); 
                     after(grammarAccess.getDocumentationBlockAccess().getDocumentationTextML_STRINGTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1480:2: ( RULE_STRING )
                    {
                    // InternalMetaDsl.g:1480:2: ( RULE_STRING )
                    // InternalMetaDsl.g:1481:3: RULE_STRING
                    {
                     before(grammarAccess.getDocumentationBlockAccess().getDocumentationTextSTRINGTerminalRuleCall_1_0_1()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getDocumentationBlockAccess().getDocumentationTextSTRINGTerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationBlock__DocumentationTextAlternatives_1_0"


    // $ANTLR start "rule__SqlNative__SqlPositionAlternatives_2_0"
    // InternalMetaDsl.g:1490:1: rule__SqlNative__SqlPositionAlternatives_2_0 : ( ( 'FILESTART' ) | ( 'FILEEND' ) );
    public final void rule__SqlNative__SqlPositionAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1494:1: ( ( 'FILESTART' ) | ( 'FILEEND' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==26) ) {
                alt19=1;
            }
            else if ( (LA19_0==27) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalMetaDsl.g:1495:2: ( 'FILESTART' )
                    {
                    // InternalMetaDsl.g:1495:2: ( 'FILESTART' )
                    // InternalMetaDsl.g:1496:3: 'FILESTART'
                    {
                     before(grammarAccess.getSqlNativeAccess().getSqlPositionFILESTARTKeyword_2_0_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getSqlNativeAccess().getSqlPositionFILESTARTKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1501:2: ( 'FILEEND' )
                    {
                    // InternalMetaDsl.g:1501:2: ( 'FILEEND' )
                    // InternalMetaDsl.g:1502:3: 'FILEEND'
                    {
                     before(grammarAccess.getSqlNativeAccess().getSqlPositionFILEENDKeyword_2_0_1()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getSqlNativeAccess().getSqlPositionFILEENDKeyword_2_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__SqlPositionAlternatives_2_0"


    // $ANTLR start "rule__SqlNativeBlock__DbTypeAlternatives_0_1_0"
    // InternalMetaDsl.g:1511:1: rule__SqlNativeBlock__DbTypeAlternatives_0_1_0 : ( ( 'H2' ) | ( 'POSTGRESQL' ) | ( 'MYSQL' ) | ( 'SQLSERVER' ) | ( 'ORACLE' ) | ( 'DEFAULT' ) );
    public final void rule__SqlNativeBlock__DbTypeAlternatives_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1515:1: ( ( 'H2' ) | ( 'POSTGRESQL' ) | ( 'MYSQL' ) | ( 'SQLSERVER' ) | ( 'ORACLE' ) | ( 'DEFAULT' ) )
            int alt20=6;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt20=1;
                }
                break;
            case 29:
                {
                alt20=2;
                }
                break;
            case 30:
                {
                alt20=3;
                }
                break;
            case 31:
                {
                alt20=4;
                }
                break;
            case 32:
                {
                alt20=5;
                }
                break;
            case 33:
                {
                alt20=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalMetaDsl.g:1516:2: ( 'H2' )
                    {
                    // InternalMetaDsl.g:1516:2: ( 'H2' )
                    // InternalMetaDsl.g:1517:3: 'H2'
                    {
                     before(grammarAccess.getSqlNativeBlockAccess().getDbTypeH2Keyword_0_1_0_0()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getSqlNativeBlockAccess().getDbTypeH2Keyword_0_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:1522:2: ( 'POSTGRESQL' )
                    {
                    // InternalMetaDsl.g:1522:2: ( 'POSTGRESQL' )
                    // InternalMetaDsl.g:1523:3: 'POSTGRESQL'
                    {
                     before(grammarAccess.getSqlNativeBlockAccess().getDbTypePOSTGRESQLKeyword_0_1_0_1()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getSqlNativeBlockAccess().getDbTypePOSTGRESQLKeyword_0_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:1528:2: ( 'MYSQL' )
                    {
                    // InternalMetaDsl.g:1528:2: ( 'MYSQL' )
                    // InternalMetaDsl.g:1529:3: 'MYSQL'
                    {
                     before(grammarAccess.getSqlNativeBlockAccess().getDbTypeMYSQLKeyword_0_1_0_2()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getSqlNativeBlockAccess().getDbTypeMYSQLKeyword_0_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMetaDsl.g:1534:2: ( 'SQLSERVER' )
                    {
                    // InternalMetaDsl.g:1534:2: ( 'SQLSERVER' )
                    // InternalMetaDsl.g:1535:3: 'SQLSERVER'
                    {
                     before(grammarAccess.getSqlNativeBlockAccess().getDbTypeSQLSERVERKeyword_0_1_0_3()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getSqlNativeBlockAccess().getDbTypeSQLSERVERKeyword_0_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMetaDsl.g:1540:2: ( 'ORACLE' )
                    {
                    // InternalMetaDsl.g:1540:2: ( 'ORACLE' )
                    // InternalMetaDsl.g:1541:3: 'ORACLE'
                    {
                     before(grammarAccess.getSqlNativeBlockAccess().getDbTypeORACLEKeyword_0_1_0_4()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getSqlNativeBlockAccess().getDbTypeORACLEKeyword_0_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMetaDsl.g:1546:2: ( 'DEFAULT' )
                    {
                    // InternalMetaDsl.g:1546:2: ( 'DEFAULT' )
                    // InternalMetaDsl.g:1547:3: 'DEFAULT'
                    {
                     before(grammarAccess.getSqlNativeBlockAccess().getDbTypeDEFAULTKeyword_0_1_0_5()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getSqlNativeBlockAccess().getDbTypeDEFAULTKeyword_0_1_0_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__DbTypeAlternatives_0_1_0"


    // $ANTLR start "rule__Model__Group__0"
    // InternalMetaDsl.g:1556:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1560:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalMetaDsl.g:1561:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalMetaDsl.g:1568:1: rule__Model__Group__0__Impl : ( ( rule__Model__EntitiesAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1572:1: ( ( ( rule__Model__EntitiesAssignment_0 )* ) )
            // InternalMetaDsl.g:1573:1: ( ( rule__Model__EntitiesAssignment_0 )* )
            {
            // InternalMetaDsl.g:1573:1: ( ( rule__Model__EntitiesAssignment_0 )* )
            // InternalMetaDsl.g:1574:2: ( rule__Model__EntitiesAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getEntitiesAssignment_0()); 
            // InternalMetaDsl.g:1575:2: ( rule__Model__EntitiesAssignment_0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=18 && LA21_0<=20)||LA21_0==25||LA21_0==53||LA21_0==56) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMetaDsl.g:1575:3: rule__Model__EntitiesAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Model__EntitiesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getEntitiesAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalMetaDsl.g:1583:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1587:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalMetaDsl.g:1588:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalMetaDsl.g:1595:1: rule__Model__Group__1__Impl : ( ( rule__Model__SequencesAssignment_1 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1599:1: ( ( ( rule__Model__SequencesAssignment_1 )* ) )
            // InternalMetaDsl.g:1600:1: ( ( rule__Model__SequencesAssignment_1 )* )
            {
            // InternalMetaDsl.g:1600:1: ( ( rule__Model__SequencesAssignment_1 )* )
            // InternalMetaDsl.g:1601:2: ( rule__Model__SequencesAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getSequencesAssignment_1()); 
            // InternalMetaDsl.g:1602:2: ( rule__Model__SequencesAssignment_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==16) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMetaDsl.g:1602:3: rule__Model__SequencesAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__SequencesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getSequencesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalMetaDsl.g:1610:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1614:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalMetaDsl.g:1615:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalMetaDsl.g:1622:1: rule__Model__Group__2__Impl : ( ( rule__Model__ConfigurationAssignment_2 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1626:1: ( ( ( rule__Model__ConfigurationAssignment_2 )? ) )
            // InternalMetaDsl.g:1627:1: ( ( rule__Model__ConfigurationAssignment_2 )? )
            {
            // InternalMetaDsl.g:1627:1: ( ( rule__Model__ConfigurationAssignment_2 )? )
            // InternalMetaDsl.g:1628:2: ( rule__Model__ConfigurationAssignment_2 )?
            {
             before(grammarAccess.getModelAccess().getConfigurationAssignment_2()); 
            // InternalMetaDsl.g:1629:2: ( rule__Model__ConfigurationAssignment_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMetaDsl.g:1629:3: rule__Model__ConfigurationAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__ConfigurationAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getConfigurationAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // InternalMetaDsl.g:1637:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1641:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalMetaDsl.g:1642:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // InternalMetaDsl.g:1649:1: rule__Model__Group__3__Impl : ( ( rule__Model__GeneralLabelSectionAssignment_3 )? ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1653:1: ( ( ( rule__Model__GeneralLabelSectionAssignment_3 )? ) )
            // InternalMetaDsl.g:1654:1: ( ( rule__Model__GeneralLabelSectionAssignment_3 )? )
            {
            // InternalMetaDsl.g:1654:1: ( ( rule__Model__GeneralLabelSectionAssignment_3 )? )
            // InternalMetaDsl.g:1655:2: ( rule__Model__GeneralLabelSectionAssignment_3 )?
            {
             before(grammarAccess.getModelAccess().getGeneralLabelSectionAssignment_3()); 
            // InternalMetaDsl.g:1656:2: ( rule__Model__GeneralLabelSectionAssignment_3 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==92) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMetaDsl.g:1656:3: rule__Model__GeneralLabelSectionAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__GeneralLabelSectionAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGeneralLabelSectionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // InternalMetaDsl.g:1664:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1668:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // InternalMetaDsl.g:1669:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // InternalMetaDsl.g:1676:1: rule__Model__Group__4__Impl : ( ( rule__Model__SqlNativesAssignment_4 )* ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1680:1: ( ( ( rule__Model__SqlNativesAssignment_4 )* ) )
            // InternalMetaDsl.g:1681:1: ( ( rule__Model__SqlNativesAssignment_4 )* )
            {
            // InternalMetaDsl.g:1681:1: ( ( rule__Model__SqlNativesAssignment_4 )* )
            // InternalMetaDsl.g:1682:2: ( rule__Model__SqlNativesAssignment_4 )*
            {
             before(grammarAccess.getModelAccess().getSqlNativesAssignment_4()); 
            // InternalMetaDsl.g:1683:2: ( rule__Model__SqlNativesAssignment_4 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==78) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalMetaDsl.g:1683:3: rule__Model__SqlNativesAssignment_4
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Model__SqlNativesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getSqlNativesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Model__Group__5"
    // InternalMetaDsl.g:1691:1: rule__Model__Group__5 : rule__Model__Group__5__Impl ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1695:1: ( rule__Model__Group__5__Impl )
            // InternalMetaDsl.g:1696:2: rule__Model__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5"


    // $ANTLR start "rule__Model__Group__5__Impl"
    // InternalMetaDsl.g:1702:1: rule__Model__Group__5__Impl : ( ( rule__Model__MetadatasAssignment_5 )* ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1706:1: ( ( ( rule__Model__MetadatasAssignment_5 )* ) )
            // InternalMetaDsl.g:1707:1: ( ( rule__Model__MetadatasAssignment_5 )* )
            {
            // InternalMetaDsl.g:1707:1: ( ( rule__Model__MetadatasAssignment_5 )* )
            // InternalMetaDsl.g:1708:2: ( rule__Model__MetadatasAssignment_5 )*
            {
             before(grammarAccess.getModelAccess().getMetadatasAssignment_5()); 
            // InternalMetaDsl.g:1709:2: ( rule__Model__MetadatasAssignment_5 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==90) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMetaDsl.g:1709:3: rule__Model__MetadatasAssignment_5
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Model__MetadatasAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getMetadatasAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5__Impl"


    // $ANTLR start "rule__Configuration__Group__0"
    // InternalMetaDsl.g:1718:1: rule__Configuration__Group__0 : rule__Configuration__Group__0__Impl rule__Configuration__Group__1 ;
    public final void rule__Configuration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1722:1: ( rule__Configuration__Group__0__Impl rule__Configuration__Group__1 )
            // InternalMetaDsl.g:1723:2: rule__Configuration__Group__0__Impl rule__Configuration__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Configuration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__0"


    // $ANTLR start "rule__Configuration__Group__0__Impl"
    // InternalMetaDsl.g:1730:1: rule__Configuration__Group__0__Impl : ( 'CONFIGURATION' ) ;
    public final void rule__Configuration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1734:1: ( ( 'CONFIGURATION' ) )
            // InternalMetaDsl.g:1735:1: ( 'CONFIGURATION' )
            {
            // InternalMetaDsl.g:1735:1: ( 'CONFIGURATION' )
            // InternalMetaDsl.g:1736:2: 'CONFIGURATION'
            {
             before(grammarAccess.getConfigurationAccess().getCONFIGURATIONKeyword_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getConfigurationAccess().getCONFIGURATIONKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__0__Impl"


    // $ANTLR start "rule__Configuration__Group__1"
    // InternalMetaDsl.g:1745:1: rule__Configuration__Group__1 : rule__Configuration__Group__1__Impl rule__Configuration__Group__2 ;
    public final void rule__Configuration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1749:1: ( rule__Configuration__Group__1__Impl rule__Configuration__Group__2 )
            // InternalMetaDsl.g:1750:2: rule__Configuration__Group__1__Impl rule__Configuration__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__Configuration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__1"


    // $ANTLR start "rule__Configuration__Group__1__Impl"
    // InternalMetaDsl.g:1757:1: rule__Configuration__Group__1__Impl : ( '{' ) ;
    public final void rule__Configuration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1761:1: ( ( '{' ) )
            // InternalMetaDsl.g:1762:1: ( '{' )
            {
            // InternalMetaDsl.g:1762:1: ( '{' )
            // InternalMetaDsl.g:1763:2: '{'
            {
             before(grammarAccess.getConfigurationAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getConfigurationAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__1__Impl"


    // $ANTLR start "rule__Configuration__Group__2"
    // InternalMetaDsl.g:1772:1: rule__Configuration__Group__2 : rule__Configuration__Group__2__Impl rule__Configuration__Group__3 ;
    public final void rule__Configuration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1776:1: ( rule__Configuration__Group__2__Impl rule__Configuration__Group__3 )
            // InternalMetaDsl.g:1777:2: rule__Configuration__Group__2__Impl rule__Configuration__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__Configuration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__2"


    // $ANTLR start "rule__Configuration__Group__2__Impl"
    // InternalMetaDsl.g:1784:1: rule__Configuration__Group__2__Impl : ( ( ( rule__Configuration__LanguagesAssignment_2 ) ) ( ( rule__Configuration__LanguagesAssignment_2 )* ) ) ;
    public final void rule__Configuration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1788:1: ( ( ( ( rule__Configuration__LanguagesAssignment_2 ) ) ( ( rule__Configuration__LanguagesAssignment_2 )* ) ) )
            // InternalMetaDsl.g:1789:1: ( ( ( rule__Configuration__LanguagesAssignment_2 ) ) ( ( rule__Configuration__LanguagesAssignment_2 )* ) )
            {
            // InternalMetaDsl.g:1789:1: ( ( ( rule__Configuration__LanguagesAssignment_2 ) ) ( ( rule__Configuration__LanguagesAssignment_2 )* ) )
            // InternalMetaDsl.g:1790:2: ( ( rule__Configuration__LanguagesAssignment_2 ) ) ( ( rule__Configuration__LanguagesAssignment_2 )* )
            {
            // InternalMetaDsl.g:1790:2: ( ( rule__Configuration__LanguagesAssignment_2 ) )
            // InternalMetaDsl.g:1791:3: ( rule__Configuration__LanguagesAssignment_2 )
            {
             before(grammarAccess.getConfigurationAccess().getLanguagesAssignment_2()); 
            // InternalMetaDsl.g:1792:3: ( rule__Configuration__LanguagesAssignment_2 )
            // InternalMetaDsl.g:1792:4: rule__Configuration__LanguagesAssignment_2
            {
            pushFollow(FOLLOW_11);
            rule__Configuration__LanguagesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getLanguagesAssignment_2()); 

            }

            // InternalMetaDsl.g:1795:2: ( ( rule__Configuration__LanguagesAssignment_2 )* )
            // InternalMetaDsl.g:1796:3: ( rule__Configuration__LanguagesAssignment_2 )*
            {
             before(grammarAccess.getConfigurationAccess().getLanguagesAssignment_2()); 
            // InternalMetaDsl.g:1797:3: ( rule__Configuration__LanguagesAssignment_2 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==39) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMetaDsl.g:1797:4: rule__Configuration__LanguagesAssignment_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Configuration__LanguagesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getLanguagesAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__2__Impl"


    // $ANTLR start "rule__Configuration__Group__3"
    // InternalMetaDsl.g:1806:1: rule__Configuration__Group__3 : rule__Configuration__Group__3__Impl rule__Configuration__Group__4 ;
    public final void rule__Configuration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1810:1: ( rule__Configuration__Group__3__Impl rule__Configuration__Group__4 )
            // InternalMetaDsl.g:1811:2: rule__Configuration__Group__3__Impl rule__Configuration__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__Configuration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__3"


    // $ANTLR start "rule__Configuration__Group__3__Impl"
    // InternalMetaDsl.g:1818:1: rule__Configuration__Group__3__Impl : ( ( ( rule__Configuration__DataTypesAssignment_3 ) ) ( ( rule__Configuration__DataTypesAssignment_3 )* ) ) ;
    public final void rule__Configuration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1822:1: ( ( ( ( rule__Configuration__DataTypesAssignment_3 ) ) ( ( rule__Configuration__DataTypesAssignment_3 )* ) ) )
            // InternalMetaDsl.g:1823:1: ( ( ( rule__Configuration__DataTypesAssignment_3 ) ) ( ( rule__Configuration__DataTypesAssignment_3 )* ) )
            {
            // InternalMetaDsl.g:1823:1: ( ( ( rule__Configuration__DataTypesAssignment_3 ) ) ( ( rule__Configuration__DataTypesAssignment_3 )* ) )
            // InternalMetaDsl.g:1824:2: ( ( rule__Configuration__DataTypesAssignment_3 ) ) ( ( rule__Configuration__DataTypesAssignment_3 )* )
            {
            // InternalMetaDsl.g:1824:2: ( ( rule__Configuration__DataTypesAssignment_3 ) )
            // InternalMetaDsl.g:1825:3: ( rule__Configuration__DataTypesAssignment_3 )
            {
             before(grammarAccess.getConfigurationAccess().getDataTypesAssignment_3()); 
            // InternalMetaDsl.g:1826:3: ( rule__Configuration__DataTypesAssignment_3 )
            // InternalMetaDsl.g:1826:4: rule__Configuration__DataTypesAssignment_3
            {
            pushFollow(FOLLOW_13);
            rule__Configuration__DataTypesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getDataTypesAssignment_3()); 

            }

            // InternalMetaDsl.g:1829:2: ( ( rule__Configuration__DataTypesAssignment_3 )* )
            // InternalMetaDsl.g:1830:3: ( rule__Configuration__DataTypesAssignment_3 )*
            {
             before(grammarAccess.getConfigurationAccess().getDataTypesAssignment_3()); 
            // InternalMetaDsl.g:1831:3: ( rule__Configuration__DataTypesAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==42) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalMetaDsl.g:1831:4: rule__Configuration__DataTypesAssignment_3
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Configuration__DataTypesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getDataTypesAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__3__Impl"


    // $ANTLR start "rule__Configuration__Group__4"
    // InternalMetaDsl.g:1840:1: rule__Configuration__Group__4 : rule__Configuration__Group__4__Impl rule__Configuration__Group__5 ;
    public final void rule__Configuration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1844:1: ( rule__Configuration__Group__4__Impl rule__Configuration__Group__5 )
            // InternalMetaDsl.g:1845:2: rule__Configuration__Group__4__Impl rule__Configuration__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__Configuration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__4"


    // $ANTLR start "rule__Configuration__Group__4__Impl"
    // InternalMetaDsl.g:1852:1: rule__Configuration__Group__4__Impl : ( ( rule__Configuration__ConstantsAssignment_4 )* ) ;
    public final void rule__Configuration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1856:1: ( ( ( rule__Configuration__ConstantsAssignment_4 )* ) )
            // InternalMetaDsl.g:1857:1: ( ( rule__Configuration__ConstantsAssignment_4 )* )
            {
            // InternalMetaDsl.g:1857:1: ( ( rule__Configuration__ConstantsAssignment_4 )* )
            // InternalMetaDsl.g:1858:2: ( rule__Configuration__ConstantsAssignment_4 )*
            {
             before(grammarAccess.getConfigurationAccess().getConstantsAssignment_4()); 
            // InternalMetaDsl.g:1859:2: ( rule__Configuration__ConstantsAssignment_4 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==41) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalMetaDsl.g:1859:3: rule__Configuration__ConstantsAssignment_4
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Configuration__ConstantsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getConstantsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__4__Impl"


    // $ANTLR start "rule__Configuration__Group__5"
    // InternalMetaDsl.g:1867:1: rule__Configuration__Group__5 : rule__Configuration__Group__5__Impl rule__Configuration__Group__6 ;
    public final void rule__Configuration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1871:1: ( rule__Configuration__Group__5__Impl rule__Configuration__Group__6 )
            // InternalMetaDsl.g:1872:2: rule__Configuration__Group__5__Impl rule__Configuration__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__Configuration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__5"


    // $ANTLR start "rule__Configuration__Group__5__Impl"
    // InternalMetaDsl.g:1879:1: rule__Configuration__Group__5__Impl : ( ( rule__Configuration__TableStereotypesAssignment_5 )* ) ;
    public final void rule__Configuration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1883:1: ( ( ( rule__Configuration__TableStereotypesAssignment_5 )* ) )
            // InternalMetaDsl.g:1884:1: ( ( rule__Configuration__TableStereotypesAssignment_5 )* )
            {
            // InternalMetaDsl.g:1884:1: ( ( rule__Configuration__TableStereotypesAssignment_5 )* )
            // InternalMetaDsl.g:1885:2: ( rule__Configuration__TableStereotypesAssignment_5 )*
            {
             before(grammarAccess.getConfigurationAccess().getTableStereotypesAssignment_5()); 
            // InternalMetaDsl.g:1886:2: ( rule__Configuration__TableStereotypesAssignment_5 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==49) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalMetaDsl.g:1886:3: rule__Configuration__TableStereotypesAssignment_5
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Configuration__TableStereotypesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getTableStereotypesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__5__Impl"


    // $ANTLR start "rule__Configuration__Group__6"
    // InternalMetaDsl.g:1894:1: rule__Configuration__Group__6 : rule__Configuration__Group__6__Impl rule__Configuration__Group__7 ;
    public final void rule__Configuration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1898:1: ( rule__Configuration__Group__6__Impl rule__Configuration__Group__7 )
            // InternalMetaDsl.g:1899:2: rule__Configuration__Group__6__Impl rule__Configuration__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__Configuration__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__6"


    // $ANTLR start "rule__Configuration__Group__6__Impl"
    // InternalMetaDsl.g:1906:1: rule__Configuration__Group__6__Impl : ( ( rule__Configuration__ColumnStereotypesAssignment_6 )* ) ;
    public final void rule__Configuration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1910:1: ( ( ( rule__Configuration__ColumnStereotypesAssignment_6 )* ) )
            // InternalMetaDsl.g:1911:1: ( ( rule__Configuration__ColumnStereotypesAssignment_6 )* )
            {
            // InternalMetaDsl.g:1911:1: ( ( rule__Configuration__ColumnStereotypesAssignment_6 )* )
            // InternalMetaDsl.g:1912:2: ( rule__Configuration__ColumnStereotypesAssignment_6 )*
            {
             before(grammarAccess.getConfigurationAccess().getColumnStereotypesAssignment_6()); 
            // InternalMetaDsl.g:1913:2: ( rule__Configuration__ColumnStereotypesAssignment_6 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==50) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMetaDsl.g:1913:3: rule__Configuration__ColumnStereotypesAssignment_6
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Configuration__ColumnStereotypesAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getColumnStereotypesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__6__Impl"


    // $ANTLR start "rule__Configuration__Group__7"
    // InternalMetaDsl.g:1921:1: rule__Configuration__Group__7 : rule__Configuration__Group__7__Impl rule__Configuration__Group__8 ;
    public final void rule__Configuration__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1925:1: ( rule__Configuration__Group__7__Impl rule__Configuration__Group__8 )
            // InternalMetaDsl.g:1926:2: rule__Configuration__Group__7__Impl rule__Configuration__Group__8
            {
            pushFollow(FOLLOW_12);
            rule__Configuration__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__7"


    // $ANTLR start "rule__Configuration__Group__7__Impl"
    // InternalMetaDsl.g:1933:1: rule__Configuration__Group__7__Impl : ( ( rule__Configuration__PatternsAssignment_7 )* ) ;
    public final void rule__Configuration__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1937:1: ( ( ( rule__Configuration__PatternsAssignment_7 )* ) )
            // InternalMetaDsl.g:1938:1: ( ( rule__Configuration__PatternsAssignment_7 )* )
            {
            // InternalMetaDsl.g:1938:1: ( ( rule__Configuration__PatternsAssignment_7 )* )
            // InternalMetaDsl.g:1939:2: ( rule__Configuration__PatternsAssignment_7 )*
            {
             before(grammarAccess.getConfigurationAccess().getPatternsAssignment_7()); 
            // InternalMetaDsl.g:1940:2: ( rule__Configuration__PatternsAssignment_7 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==51) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalMetaDsl.g:1940:3: rule__Configuration__PatternsAssignment_7
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Configuration__PatternsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getPatternsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__7__Impl"


    // $ANTLR start "rule__Configuration__Group__8"
    // InternalMetaDsl.g:1948:1: rule__Configuration__Group__8 : rule__Configuration__Group__8__Impl rule__Configuration__Group__9 ;
    public final void rule__Configuration__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1952:1: ( rule__Configuration__Group__8__Impl rule__Configuration__Group__9 )
            // InternalMetaDsl.g:1953:2: rule__Configuration__Group__8__Impl rule__Configuration__Group__9
            {
            pushFollow(FOLLOW_18);
            rule__Configuration__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__8"


    // $ANTLR start "rule__Configuration__Group__8__Impl"
    // InternalMetaDsl.g:1960:1: rule__Configuration__Group__8__Impl : ( 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' ) ;
    public final void rule__Configuration__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1964:1: ( ( 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' ) )
            // InternalMetaDsl.g:1965:1: ( 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' )
            {
            // InternalMetaDsl.g:1965:1: ( 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' )
            // InternalMetaDsl.g:1966:2: 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY'
            {
             before(grammarAccess.getConfigurationAccess().getDEFAULT_PRIMARY_KEY_GENERATION_STRATEGYKeyword_8()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getConfigurationAccess().getDEFAULT_PRIMARY_KEY_GENERATION_STRATEGYKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__8__Impl"


    // $ANTLR start "rule__Configuration__Group__9"
    // InternalMetaDsl.g:1975:1: rule__Configuration__Group__9 : rule__Configuration__Group__9__Impl rule__Configuration__Group__10 ;
    public final void rule__Configuration__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1979:1: ( rule__Configuration__Group__9__Impl rule__Configuration__Group__10 )
            // InternalMetaDsl.g:1980:2: rule__Configuration__Group__9__Impl rule__Configuration__Group__10
            {
            pushFollow(FOLLOW_19);
            rule__Configuration__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__9"


    // $ANTLR start "rule__Configuration__Group__9__Impl"
    // InternalMetaDsl.g:1987:1: rule__Configuration__Group__9__Impl : ( ( rule__Configuration__DefaultPkGenerationStrategyAssignment_9 ) ) ;
    public final void rule__Configuration__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:1991:1: ( ( ( rule__Configuration__DefaultPkGenerationStrategyAssignment_9 ) ) )
            // InternalMetaDsl.g:1992:1: ( ( rule__Configuration__DefaultPkGenerationStrategyAssignment_9 ) )
            {
            // InternalMetaDsl.g:1992:1: ( ( rule__Configuration__DefaultPkGenerationStrategyAssignment_9 ) )
            // InternalMetaDsl.g:1993:2: ( rule__Configuration__DefaultPkGenerationStrategyAssignment_9 )
            {
             before(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyAssignment_9()); 
            // InternalMetaDsl.g:1994:2: ( rule__Configuration__DefaultPkGenerationStrategyAssignment_9 )
            // InternalMetaDsl.g:1994:3: rule__Configuration__DefaultPkGenerationStrategyAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__DefaultPkGenerationStrategyAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__9__Impl"


    // $ANTLR start "rule__Configuration__Group__10"
    // InternalMetaDsl.g:2002:1: rule__Configuration__Group__10 : rule__Configuration__Group__10__Impl rule__Configuration__Group__11 ;
    public final void rule__Configuration__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2006:1: ( rule__Configuration__Group__10__Impl rule__Configuration__Group__11 )
            // InternalMetaDsl.g:2007:2: rule__Configuration__Group__10__Impl rule__Configuration__Group__11
            {
            pushFollow(FOLLOW_19);
            rule__Configuration__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__10"


    // $ANTLR start "rule__Configuration__Group__10__Impl"
    // InternalMetaDsl.g:2014:1: rule__Configuration__Group__10__Impl : ( ( rule__Configuration__Group_10__0 )? ) ;
    public final void rule__Configuration__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2018:1: ( ( ( rule__Configuration__Group_10__0 )? ) )
            // InternalMetaDsl.g:2019:1: ( ( rule__Configuration__Group_10__0 )? )
            {
            // InternalMetaDsl.g:2019:1: ( ( rule__Configuration__Group_10__0 )? )
            // InternalMetaDsl.g:2020:2: ( rule__Configuration__Group_10__0 )?
            {
             before(grammarAccess.getConfigurationAccess().getGroup_10()); 
            // InternalMetaDsl.g:2021:2: ( rule__Configuration__Group_10__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMetaDsl.g:2021:3: rule__Configuration__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Configuration__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConfigurationAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__10__Impl"


    // $ANTLR start "rule__Configuration__Group__11"
    // InternalMetaDsl.g:2029:1: rule__Configuration__Group__11 : rule__Configuration__Group__11__Impl ;
    public final void rule__Configuration__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2033:1: ( rule__Configuration__Group__11__Impl )
            // InternalMetaDsl.g:2034:2: rule__Configuration__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__11"


    // $ANTLR start "rule__Configuration__Group__11__Impl"
    // InternalMetaDsl.g:2040:1: rule__Configuration__Group__11__Impl : ( '}' ) ;
    public final void rule__Configuration__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2044:1: ( ( '}' ) )
            // InternalMetaDsl.g:2045:1: ( '}' )
            {
            // InternalMetaDsl.g:2045:1: ( '}' )
            // InternalMetaDsl.g:2046:2: '}'
            {
             before(grammarAccess.getConfigurationAccess().getRightCurlyBracketKeyword_11()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getConfigurationAccess().getRightCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__11__Impl"


    // $ANTLR start "rule__Configuration__Group_10__0"
    // InternalMetaDsl.g:2056:1: rule__Configuration__Group_10__0 : rule__Configuration__Group_10__0__Impl rule__Configuration__Group_10__1 ;
    public final void rule__Configuration__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2060:1: ( rule__Configuration__Group_10__0__Impl rule__Configuration__Group_10__1 )
            // InternalMetaDsl.g:2061:2: rule__Configuration__Group_10__0__Impl rule__Configuration__Group_10__1
            {
            pushFollow(FOLLOW_20);
            rule__Configuration__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group_10__0"


    // $ANTLR start "rule__Configuration__Group_10__0__Impl"
    // InternalMetaDsl.g:2068:1: rule__Configuration__Group_10__0__Impl : ( 'MTCLASSNAME' ) ;
    public final void rule__Configuration__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2072:1: ( ( 'MTCLASSNAME' ) )
            // InternalMetaDsl.g:2073:1: ( 'MTCLASSNAME' )
            {
            // InternalMetaDsl.g:2073:1: ( 'MTCLASSNAME' )
            // InternalMetaDsl.g:2074:2: 'MTCLASSNAME'
            {
             before(grammarAccess.getConfigurationAccess().getMTCLASSNAMEKeyword_10_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getConfigurationAccess().getMTCLASSNAMEKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group_10__0__Impl"


    // $ANTLR start "rule__Configuration__Group_10__1"
    // InternalMetaDsl.g:2083:1: rule__Configuration__Group_10__1 : rule__Configuration__Group_10__1__Impl ;
    public final void rule__Configuration__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2087:1: ( rule__Configuration__Group_10__1__Impl )
            // InternalMetaDsl.g:2088:2: rule__Configuration__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group_10__1"


    // $ANTLR start "rule__Configuration__Group_10__1__Impl"
    // InternalMetaDsl.g:2094:1: rule__Configuration__Group_10__1__Impl : ( ( rule__Configuration__MtClassNameAssignment_10_1 ) ) ;
    public final void rule__Configuration__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2098:1: ( ( ( rule__Configuration__MtClassNameAssignment_10_1 ) ) )
            // InternalMetaDsl.g:2099:1: ( ( rule__Configuration__MtClassNameAssignment_10_1 ) )
            {
            // InternalMetaDsl.g:2099:1: ( ( rule__Configuration__MtClassNameAssignment_10_1 ) )
            // InternalMetaDsl.g:2100:2: ( rule__Configuration__MtClassNameAssignment_10_1 )
            {
             before(grammarAccess.getConfigurationAccess().getMtClassNameAssignment_10_1()); 
            // InternalMetaDsl.g:2101:2: ( rule__Configuration__MtClassNameAssignment_10_1 )
            // InternalMetaDsl.g:2101:3: rule__Configuration__MtClassNameAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__MtClassNameAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getMtClassNameAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group_10__1__Impl"


    // $ANTLR start "rule__Language__Group__0"
    // InternalMetaDsl.g:2110:1: rule__Language__Group__0 : rule__Language__Group__0__Impl rule__Language__Group__1 ;
    public final void rule__Language__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2114:1: ( rule__Language__Group__0__Impl rule__Language__Group__1 )
            // InternalMetaDsl.g:2115:2: rule__Language__Group__0__Impl rule__Language__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Language__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Language__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__Group__0"


    // $ANTLR start "rule__Language__Group__0__Impl"
    // InternalMetaDsl.g:2122:1: rule__Language__Group__0__Impl : ( 'LANG' ) ;
    public final void rule__Language__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2126:1: ( ( 'LANG' ) )
            // InternalMetaDsl.g:2127:1: ( 'LANG' )
            {
            // InternalMetaDsl.g:2127:1: ( 'LANG' )
            // InternalMetaDsl.g:2128:2: 'LANG'
            {
             before(grammarAccess.getLanguageAccess().getLANGKeyword_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getLanguageAccess().getLANGKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__Group__0__Impl"


    // $ANTLR start "rule__Language__Group__1"
    // InternalMetaDsl.g:2137:1: rule__Language__Group__1 : rule__Language__Group__1__Impl rule__Language__Group__2 ;
    public final void rule__Language__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2141:1: ( rule__Language__Group__1__Impl rule__Language__Group__2 )
            // InternalMetaDsl.g:2142:2: rule__Language__Group__1__Impl rule__Language__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__Language__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Language__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__Group__1"


    // $ANTLR start "rule__Language__Group__1__Impl"
    // InternalMetaDsl.g:2149:1: rule__Language__Group__1__Impl : ( ( rule__Language__NameAssignment_1 ) ) ;
    public final void rule__Language__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2153:1: ( ( ( rule__Language__NameAssignment_1 ) ) )
            // InternalMetaDsl.g:2154:1: ( ( rule__Language__NameAssignment_1 ) )
            {
            // InternalMetaDsl.g:2154:1: ( ( rule__Language__NameAssignment_1 ) )
            // InternalMetaDsl.g:2155:2: ( rule__Language__NameAssignment_1 )
            {
             before(grammarAccess.getLanguageAccess().getNameAssignment_1()); 
            // InternalMetaDsl.g:2156:2: ( rule__Language__NameAssignment_1 )
            // InternalMetaDsl.g:2156:3: rule__Language__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Language__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLanguageAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__Group__1__Impl"


    // $ANTLR start "rule__Language__Group__2"
    // InternalMetaDsl.g:2164:1: rule__Language__Group__2 : rule__Language__Group__2__Impl ;
    public final void rule__Language__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2168:1: ( rule__Language__Group__2__Impl )
            // InternalMetaDsl.g:2169:2: rule__Language__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Language__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__Group__2"


    // $ANTLR start "rule__Language__Group__2__Impl"
    // InternalMetaDsl.g:2175:1: rule__Language__Group__2__Impl : ( ';' ) ;
    public final void rule__Language__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2179:1: ( ( ';' ) )
            // InternalMetaDsl.g:2180:1: ( ';' )
            {
            // InternalMetaDsl.g:2180:1: ( ';' )
            // InternalMetaDsl.g:2181:2: ';'
            {
             before(grammarAccess.getLanguageAccess().getSemicolonKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getLanguageAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__Group__2__Impl"


    // $ANTLR start "rule__Constant__Group__0"
    // InternalMetaDsl.g:2191:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2195:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // InternalMetaDsl.g:2196:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Constant__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__0"


    // $ANTLR start "rule__Constant__Group__0__Impl"
    // InternalMetaDsl.g:2203:1: rule__Constant__Group__0__Impl : ( 'CONSTANT' ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2207:1: ( ( 'CONSTANT' ) )
            // InternalMetaDsl.g:2208:1: ( 'CONSTANT' )
            {
            // InternalMetaDsl.g:2208:1: ( 'CONSTANT' )
            // InternalMetaDsl.g:2209:2: 'CONSTANT'
            {
             before(grammarAccess.getConstantAccess().getCONSTANTKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getConstantAccess().getCONSTANTKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__0__Impl"


    // $ANTLR start "rule__Constant__Group__1"
    // InternalMetaDsl.g:2218:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl rule__Constant__Group__2 ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2222:1: ( rule__Constant__Group__1__Impl rule__Constant__Group__2 )
            // InternalMetaDsl.g:2223:2: rule__Constant__Group__1__Impl rule__Constant__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__Constant__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constant__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__1"


    // $ANTLR start "rule__Constant__Group__1__Impl"
    // InternalMetaDsl.g:2230:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__NameAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2234:1: ( ( ( rule__Constant__NameAssignment_1 ) ) )
            // InternalMetaDsl.g:2235:1: ( ( rule__Constant__NameAssignment_1 ) )
            {
            // InternalMetaDsl.g:2235:1: ( ( rule__Constant__NameAssignment_1 ) )
            // InternalMetaDsl.g:2236:2: ( rule__Constant__NameAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getNameAssignment_1()); 
            // InternalMetaDsl.g:2237:2: ( rule__Constant__NameAssignment_1 )
            // InternalMetaDsl.g:2237:3: rule__Constant__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Constant__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__1__Impl"


    // $ANTLR start "rule__Constant__Group__2"
    // InternalMetaDsl.g:2245:1: rule__Constant__Group__2 : rule__Constant__Group__2__Impl ;
    public final void rule__Constant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2249:1: ( rule__Constant__Group__2__Impl )
            // InternalMetaDsl.g:2250:2: rule__Constant__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__2"


    // $ANTLR start "rule__Constant__Group__2__Impl"
    // InternalMetaDsl.g:2256:1: rule__Constant__Group__2__Impl : ( ( rule__Constant__ValueAssignment_2 ) ) ;
    public final void rule__Constant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2260:1: ( ( ( rule__Constant__ValueAssignment_2 ) ) )
            // InternalMetaDsl.g:2261:1: ( ( rule__Constant__ValueAssignment_2 ) )
            {
            // InternalMetaDsl.g:2261:1: ( ( rule__Constant__ValueAssignment_2 ) )
            // InternalMetaDsl.g:2262:2: ( rule__Constant__ValueAssignment_2 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_2()); 
            // InternalMetaDsl.g:2263:2: ( rule__Constant__ValueAssignment_2 )
            // InternalMetaDsl.g:2263:3: rule__Constant__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Constant__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__2__Impl"


    // $ANTLR start "rule__DataType__Group__0"
    // InternalMetaDsl.g:2272:1: rule__DataType__Group__0 : rule__DataType__Group__0__Impl rule__DataType__Group__1 ;
    public final void rule__DataType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2276:1: ( rule__DataType__Group__0__Impl rule__DataType__Group__1 )
            // InternalMetaDsl.g:2277:2: rule__DataType__Group__0__Impl rule__DataType__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__DataType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Group__0"


    // $ANTLR start "rule__DataType__Group__0__Impl"
    // InternalMetaDsl.g:2284:1: rule__DataType__Group__0__Impl : ( 'DATATYPE' ) ;
    public final void rule__DataType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2288:1: ( ( 'DATATYPE' ) )
            // InternalMetaDsl.g:2289:1: ( 'DATATYPE' )
            {
            // InternalMetaDsl.g:2289:1: ( 'DATATYPE' )
            // InternalMetaDsl.g:2290:2: 'DATATYPE'
            {
             before(grammarAccess.getDataTypeAccess().getDATATYPEKeyword_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getDataTypeAccess().getDATATYPEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Group__0__Impl"


    // $ANTLR start "rule__DataType__Group__1"
    // InternalMetaDsl.g:2299:1: rule__DataType__Group__1 : rule__DataType__Group__1__Impl rule__DataType__Group__2 ;
    public final void rule__DataType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2303:1: ( rule__DataType__Group__1__Impl rule__DataType__Group__2 )
            // InternalMetaDsl.g:2304:2: rule__DataType__Group__1__Impl rule__DataType__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__DataType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Group__1"


    // $ANTLR start "rule__DataType__Group__1__Impl"
    // InternalMetaDsl.g:2311:1: rule__DataType__Group__1__Impl : ( ( rule__DataType__NameAssignment_1 ) ) ;
    public final void rule__DataType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2315:1: ( ( ( rule__DataType__NameAssignment_1 ) ) )
            // InternalMetaDsl.g:2316:1: ( ( rule__DataType__NameAssignment_1 ) )
            {
            // InternalMetaDsl.g:2316:1: ( ( rule__DataType__NameAssignment_1 ) )
            // InternalMetaDsl.g:2317:2: ( rule__DataType__NameAssignment_1 )
            {
             before(grammarAccess.getDataTypeAccess().getNameAssignment_1()); 
            // InternalMetaDsl.g:2318:2: ( rule__DataType__NameAssignment_1 )
            // InternalMetaDsl.g:2318:3: rule__DataType__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DataType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Group__1__Impl"


    // $ANTLR start "rule__DataType__Group__2"
    // InternalMetaDsl.g:2326:1: rule__DataType__Group__2 : rule__DataType__Group__2__Impl rule__DataType__Group__3 ;
    public final void rule__DataType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2330:1: ( rule__DataType__Group__2__Impl rule__DataType__Group__3 )
            // InternalMetaDsl.g:2331:2: rule__DataType__Group__2__Impl rule__DataType__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__DataType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Group__2"


    // $ANTLR start "rule__DataType__Group__2__Impl"
    // InternalMetaDsl.g:2338:1: rule__DataType__Group__2__Impl : ( ( rule__DataType__DetailsAssignment_2 ) ) ;
    public final void rule__DataType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2342:1: ( ( ( rule__DataType__DetailsAssignment_2 ) ) )
            // InternalMetaDsl.g:2343:1: ( ( rule__DataType__DetailsAssignment_2 ) )
            {
            // InternalMetaDsl.g:2343:1: ( ( rule__DataType__DetailsAssignment_2 ) )
            // InternalMetaDsl.g:2344:2: ( rule__DataType__DetailsAssignment_2 )
            {
             before(grammarAccess.getDataTypeAccess().getDetailsAssignment_2()); 
            // InternalMetaDsl.g:2345:2: ( rule__DataType__DetailsAssignment_2 )
            // InternalMetaDsl.g:2345:3: rule__DataType__DetailsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataType__DetailsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getDetailsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Group__2__Impl"


    // $ANTLR start "rule__DataType__Group__3"
    // InternalMetaDsl.g:2353:1: rule__DataType__Group__3 : rule__DataType__Group__3__Impl ;
    public final void rule__DataType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2357:1: ( rule__DataType__Group__3__Impl )
            // InternalMetaDsl.g:2358:2: rule__DataType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Group__3"


    // $ANTLR start "rule__DataType__Group__3__Impl"
    // InternalMetaDsl.g:2364:1: rule__DataType__Group__3__Impl : ( ';' ) ;
    public final void rule__DataType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2368:1: ( ( ';' ) )
            // InternalMetaDsl.g:2369:1: ( ';' )
            {
            // InternalMetaDsl.g:2369:1: ( ';' )
            // InternalMetaDsl.g:2370:2: ';'
            {
             before(grammarAccess.getDataTypeAccess().getSemicolonKeyword_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDataTypeAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Group__3__Impl"


    // $ANTLR start "rule__DataTypeDetails__Group__0"
    // InternalMetaDsl.g:2380:1: rule__DataTypeDetails__Group__0 : rule__DataTypeDetails__Group__0__Impl rule__DataTypeDetails__Group__1 ;
    public final void rule__DataTypeDetails__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2384:1: ( rule__DataTypeDetails__Group__0__Impl rule__DataTypeDetails__Group__1 )
            // InternalMetaDsl.g:2385:2: rule__DataTypeDetails__Group__0__Impl rule__DataTypeDetails__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__DataTypeDetails__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataTypeDetails__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__0"


    // $ANTLR start "rule__DataTypeDetails__Group__0__Impl"
    // InternalMetaDsl.g:2392:1: rule__DataTypeDetails__Group__0__Impl : ( 'SQLNATIVETYPE' ) ;
    public final void rule__DataTypeDetails__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2396:1: ( ( 'SQLNATIVETYPE' ) )
            // InternalMetaDsl.g:2397:1: ( 'SQLNATIVETYPE' )
            {
            // InternalMetaDsl.g:2397:1: ( 'SQLNATIVETYPE' )
            // InternalMetaDsl.g:2398:2: 'SQLNATIVETYPE'
            {
             before(grammarAccess.getDataTypeDetailsAccess().getSQLNATIVETYPEKeyword_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getDataTypeDetailsAccess().getSQLNATIVETYPEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__0__Impl"


    // $ANTLR start "rule__DataTypeDetails__Group__1"
    // InternalMetaDsl.g:2407:1: rule__DataTypeDetails__Group__1 : rule__DataTypeDetails__Group__1__Impl rule__DataTypeDetails__Group__2 ;
    public final void rule__DataTypeDetails__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2411:1: ( rule__DataTypeDetails__Group__1__Impl rule__DataTypeDetails__Group__2 )
            // InternalMetaDsl.g:2412:2: rule__DataTypeDetails__Group__1__Impl rule__DataTypeDetails__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__DataTypeDetails__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataTypeDetails__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__1"


    // $ANTLR start "rule__DataTypeDetails__Group__1__Impl"
    // InternalMetaDsl.g:2419:1: rule__DataTypeDetails__Group__1__Impl : ( ( rule__DataTypeDetails__DbNativeTypeAssignment_1 ) ) ;
    public final void rule__DataTypeDetails__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2423:1: ( ( ( rule__DataTypeDetails__DbNativeTypeAssignment_1 ) ) )
            // InternalMetaDsl.g:2424:1: ( ( rule__DataTypeDetails__DbNativeTypeAssignment_1 ) )
            {
            // InternalMetaDsl.g:2424:1: ( ( rule__DataTypeDetails__DbNativeTypeAssignment_1 ) )
            // InternalMetaDsl.g:2425:2: ( rule__DataTypeDetails__DbNativeTypeAssignment_1 )
            {
             before(grammarAccess.getDataTypeDetailsAccess().getDbNativeTypeAssignment_1()); 
            // InternalMetaDsl.g:2426:2: ( rule__DataTypeDetails__DbNativeTypeAssignment_1 )
            // InternalMetaDsl.g:2426:3: rule__DataTypeDetails__DbNativeTypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDetails__DbNativeTypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeDetailsAccess().getDbNativeTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__1__Impl"


    // $ANTLR start "rule__DataTypeDetails__Group__2"
    // InternalMetaDsl.g:2434:1: rule__DataTypeDetails__Group__2 : rule__DataTypeDetails__Group__2__Impl rule__DataTypeDetails__Group__3 ;
    public final void rule__DataTypeDetails__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2438:1: ( rule__DataTypeDetails__Group__2__Impl rule__DataTypeDetails__Group__3 )
            // InternalMetaDsl.g:2439:2: rule__DataTypeDetails__Group__2__Impl rule__DataTypeDetails__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__DataTypeDetails__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataTypeDetails__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__2"


    // $ANTLR start "rule__DataTypeDetails__Group__2__Impl"
    // InternalMetaDsl.g:2446:1: rule__DataTypeDetails__Group__2__Impl : ( ( rule__DataTypeDetails__Alternatives_2 )? ) ;
    public final void rule__DataTypeDetails__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2450:1: ( ( ( rule__DataTypeDetails__Alternatives_2 )? ) )
            // InternalMetaDsl.g:2451:1: ( ( rule__DataTypeDetails__Alternatives_2 )? )
            {
            // InternalMetaDsl.g:2451:1: ( ( rule__DataTypeDetails__Alternatives_2 )? )
            // InternalMetaDsl.g:2452:2: ( rule__DataTypeDetails__Alternatives_2 )?
            {
             before(grammarAccess.getDataTypeDetailsAccess().getAlternatives_2()); 
            // InternalMetaDsl.g:2453:2: ( rule__DataTypeDetails__Alternatives_2 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=81 && LA34_0<=82)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMetaDsl.g:2453:3: rule__DataTypeDetails__Alternatives_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataTypeDetails__Alternatives_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataTypeDetailsAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__2__Impl"


    // $ANTLR start "rule__DataTypeDetails__Group__3"
    // InternalMetaDsl.g:2461:1: rule__DataTypeDetails__Group__3 : rule__DataTypeDetails__Group__3__Impl rule__DataTypeDetails__Group__4 ;
    public final void rule__DataTypeDetails__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2465:1: ( rule__DataTypeDetails__Group__3__Impl rule__DataTypeDetails__Group__4 )
            // InternalMetaDsl.g:2466:2: rule__DataTypeDetails__Group__3__Impl rule__DataTypeDetails__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__DataTypeDetails__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataTypeDetails__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__3"


    // $ANTLR start "rule__DataTypeDetails__Group__3__Impl"
    // InternalMetaDsl.g:2473:1: rule__DataTypeDetails__Group__3__Impl : ( 'JAVATYPE' ) ;
    public final void rule__DataTypeDetails__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2477:1: ( ( 'JAVATYPE' ) )
            // InternalMetaDsl.g:2478:1: ( 'JAVATYPE' )
            {
            // InternalMetaDsl.g:2478:1: ( 'JAVATYPE' )
            // InternalMetaDsl.g:2479:2: 'JAVATYPE'
            {
             before(grammarAccess.getDataTypeDetailsAccess().getJAVATYPEKeyword_3()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getDataTypeDetailsAccess().getJAVATYPEKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__3__Impl"


    // $ANTLR start "rule__DataTypeDetails__Group__4"
    // InternalMetaDsl.g:2488:1: rule__DataTypeDetails__Group__4 : rule__DataTypeDetails__Group__4__Impl ;
    public final void rule__DataTypeDetails__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2492:1: ( rule__DataTypeDetails__Group__4__Impl )
            // InternalMetaDsl.g:2493:2: rule__DataTypeDetails__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDetails__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__4"


    // $ANTLR start "rule__DataTypeDetails__Group__4__Impl"
    // InternalMetaDsl.g:2499:1: rule__DataTypeDetails__Group__4__Impl : ( ( rule__DataTypeDetails__JavaTypeAssignment_4 ) ) ;
    public final void rule__DataTypeDetails__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2503:1: ( ( ( rule__DataTypeDetails__JavaTypeAssignment_4 ) ) )
            // InternalMetaDsl.g:2504:1: ( ( rule__DataTypeDetails__JavaTypeAssignment_4 ) )
            {
            // InternalMetaDsl.g:2504:1: ( ( rule__DataTypeDetails__JavaTypeAssignment_4 ) )
            // InternalMetaDsl.g:2505:2: ( rule__DataTypeDetails__JavaTypeAssignment_4 )
            {
             before(grammarAccess.getDataTypeDetailsAccess().getJavaTypeAssignment_4()); 
            // InternalMetaDsl.g:2506:2: ( rule__DataTypeDetails__JavaTypeAssignment_4 )
            // InternalMetaDsl.g:2506:3: rule__DataTypeDetails__JavaTypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeDetails__JavaTypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeDetailsAccess().getJavaTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__Group__4__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group__0"
    // InternalMetaDsl.g:2515:1: rule__SubTypeDataType__Group__0 : rule__SubTypeDataType__Group__0__Impl rule__SubTypeDataType__Group__1 ;
    public final void rule__SubTypeDataType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2519:1: ( rule__SubTypeDataType__Group__0__Impl rule__SubTypeDataType__Group__1 )
            // InternalMetaDsl.g:2520:2: rule__SubTypeDataType__Group__0__Impl rule__SubTypeDataType__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__SubTypeDataType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group__0"


    // $ANTLR start "rule__SubTypeDataType__Group__0__Impl"
    // InternalMetaDsl.g:2527:1: rule__SubTypeDataType__Group__0__Impl : ( 'SUBTYPEOF' ) ;
    public final void rule__SubTypeDataType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2531:1: ( ( 'SUBTYPEOF' ) )
            // InternalMetaDsl.g:2532:1: ( 'SUBTYPEOF' )
            {
            // InternalMetaDsl.g:2532:1: ( 'SUBTYPEOF' )
            // InternalMetaDsl.g:2533:2: 'SUBTYPEOF'
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getSUBTYPEOFKeyword_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getSubTypeDataTypeAccess().getSUBTYPEOFKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group__0__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group__1"
    // InternalMetaDsl.g:2542:1: rule__SubTypeDataType__Group__1 : rule__SubTypeDataType__Group__1__Impl rule__SubTypeDataType__Group__2 ;
    public final void rule__SubTypeDataType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2546:1: ( rule__SubTypeDataType__Group__1__Impl rule__SubTypeDataType__Group__2 )
            // InternalMetaDsl.g:2547:2: rule__SubTypeDataType__Group__1__Impl rule__SubTypeDataType__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__SubTypeDataType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group__1"


    // $ANTLR start "rule__SubTypeDataType__Group__1__Impl"
    // InternalMetaDsl.g:2554:1: rule__SubTypeDataType__Group__1__Impl : ( ( rule__SubTypeDataType__SubTypeOfAssignment_1 ) ) ;
    public final void rule__SubTypeDataType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2558:1: ( ( ( rule__SubTypeDataType__SubTypeOfAssignment_1 ) ) )
            // InternalMetaDsl.g:2559:1: ( ( rule__SubTypeDataType__SubTypeOfAssignment_1 ) )
            {
            // InternalMetaDsl.g:2559:1: ( ( rule__SubTypeDataType__SubTypeOfAssignment_1 ) )
            // InternalMetaDsl.g:2560:2: ( rule__SubTypeDataType__SubTypeOfAssignment_1 )
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getSubTypeOfAssignment_1()); 
            // InternalMetaDsl.g:2561:2: ( rule__SubTypeDataType__SubTypeOfAssignment_1 )
            // InternalMetaDsl.g:2561:3: rule__SubTypeDataType__SubTypeOfAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__SubTypeOfAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeDataTypeAccess().getSubTypeOfAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group__1__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group__2"
    // InternalMetaDsl.g:2569:1: rule__SubTypeDataType__Group__2 : rule__SubTypeDataType__Group__2__Impl ;
    public final void rule__SubTypeDataType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2573:1: ( rule__SubTypeDataType__Group__2__Impl )
            // InternalMetaDsl.g:2574:2: rule__SubTypeDataType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group__2"


    // $ANTLR start "rule__SubTypeDataType__Group__2__Impl"
    // InternalMetaDsl.g:2580:1: rule__SubTypeDataType__Group__2__Impl : ( ( rule__SubTypeDataType__Group_2__0 )? ) ;
    public final void rule__SubTypeDataType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2584:1: ( ( ( rule__SubTypeDataType__Group_2__0 )? ) )
            // InternalMetaDsl.g:2585:1: ( ( rule__SubTypeDataType__Group_2__0 )? )
            {
            // InternalMetaDsl.g:2585:1: ( ( rule__SubTypeDataType__Group_2__0 )? )
            // InternalMetaDsl.g:2586:2: ( rule__SubTypeDataType__Group_2__0 )?
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getGroup_2()); 
            // InternalMetaDsl.g:2587:2: ( rule__SubTypeDataType__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==46) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMetaDsl.g:2587:3: rule__SubTypeDataType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubTypeDataType__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubTypeDataTypeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group__2__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group_2__0"
    // InternalMetaDsl.g:2596:1: rule__SubTypeDataType__Group_2__0 : rule__SubTypeDataType__Group_2__0__Impl rule__SubTypeDataType__Group_2__1 ;
    public final void rule__SubTypeDataType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2600:1: ( rule__SubTypeDataType__Group_2__0__Impl rule__SubTypeDataType__Group_2__1 )
            // InternalMetaDsl.g:2601:2: rule__SubTypeDataType__Group_2__0__Impl rule__SubTypeDataType__Group_2__1
            {
            pushFollow(FOLLOW_26);
            rule__SubTypeDataType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2__0"


    // $ANTLR start "rule__SubTypeDataType__Group_2__0__Impl"
    // InternalMetaDsl.g:2608:1: rule__SubTypeDataType__Group_2__0__Impl : ( '(' ) ;
    public final void rule__SubTypeDataType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2612:1: ( ( '(' ) )
            // InternalMetaDsl.g:2613:1: ( '(' )
            {
            // InternalMetaDsl.g:2613:1: ( '(' )
            // InternalMetaDsl.g:2614:2: '('
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getSubTypeDataTypeAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2__0__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group_2__1"
    // InternalMetaDsl.g:2623:1: rule__SubTypeDataType__Group_2__1 : rule__SubTypeDataType__Group_2__1__Impl rule__SubTypeDataType__Group_2__2 ;
    public final void rule__SubTypeDataType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2627:1: ( rule__SubTypeDataType__Group_2__1__Impl rule__SubTypeDataType__Group_2__2 )
            // InternalMetaDsl.g:2628:2: rule__SubTypeDataType__Group_2__1__Impl rule__SubTypeDataType__Group_2__2
            {
            pushFollow(FOLLOW_27);
            rule__SubTypeDataType__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2__1"


    // $ANTLR start "rule__SubTypeDataType__Group_2__1__Impl"
    // InternalMetaDsl.g:2635:1: rule__SubTypeDataType__Group_2__1__Impl : ( ( rule__SubTypeDataType__Alternatives_2_1 ) ) ;
    public final void rule__SubTypeDataType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2639:1: ( ( ( rule__SubTypeDataType__Alternatives_2_1 ) ) )
            // InternalMetaDsl.g:2640:1: ( ( rule__SubTypeDataType__Alternatives_2_1 ) )
            {
            // InternalMetaDsl.g:2640:1: ( ( rule__SubTypeDataType__Alternatives_2_1 ) )
            // InternalMetaDsl.g:2641:2: ( rule__SubTypeDataType__Alternatives_2_1 )
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getAlternatives_2_1()); 
            // InternalMetaDsl.g:2642:2: ( rule__SubTypeDataType__Alternatives_2_1 )
            // InternalMetaDsl.g:2642:3: rule__SubTypeDataType__Alternatives_2_1
            {
            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Alternatives_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeDataTypeAccess().getAlternatives_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2__1__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group_2__2"
    // InternalMetaDsl.g:2650:1: rule__SubTypeDataType__Group_2__2 : rule__SubTypeDataType__Group_2__2__Impl rule__SubTypeDataType__Group_2__3 ;
    public final void rule__SubTypeDataType__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2654:1: ( rule__SubTypeDataType__Group_2__2__Impl rule__SubTypeDataType__Group_2__3 )
            // InternalMetaDsl.g:2655:2: rule__SubTypeDataType__Group_2__2__Impl rule__SubTypeDataType__Group_2__3
            {
            pushFollow(FOLLOW_27);
            rule__SubTypeDataType__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2__2"


    // $ANTLR start "rule__SubTypeDataType__Group_2__2__Impl"
    // InternalMetaDsl.g:2662:1: rule__SubTypeDataType__Group_2__2__Impl : ( ( rule__SubTypeDataType__Group_2_2__0 )? ) ;
    public final void rule__SubTypeDataType__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2666:1: ( ( ( rule__SubTypeDataType__Group_2_2__0 )? ) )
            // InternalMetaDsl.g:2667:1: ( ( rule__SubTypeDataType__Group_2_2__0 )? )
            {
            // InternalMetaDsl.g:2667:1: ( ( rule__SubTypeDataType__Group_2_2__0 )? )
            // InternalMetaDsl.g:2668:2: ( rule__SubTypeDataType__Group_2_2__0 )?
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getGroup_2_2()); 
            // InternalMetaDsl.g:2669:2: ( rule__SubTypeDataType__Group_2_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==48) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMetaDsl.g:2669:3: rule__SubTypeDataType__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubTypeDataType__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubTypeDataTypeAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2__2__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group_2__3"
    // InternalMetaDsl.g:2677:1: rule__SubTypeDataType__Group_2__3 : rule__SubTypeDataType__Group_2__3__Impl ;
    public final void rule__SubTypeDataType__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2681:1: ( rule__SubTypeDataType__Group_2__3__Impl )
            // InternalMetaDsl.g:2682:2: rule__SubTypeDataType__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2__3"


    // $ANTLR start "rule__SubTypeDataType__Group_2__3__Impl"
    // InternalMetaDsl.g:2688:1: rule__SubTypeDataType__Group_2__3__Impl : ( ')' ) ;
    public final void rule__SubTypeDataType__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2692:1: ( ( ')' ) )
            // InternalMetaDsl.g:2693:1: ( ')' )
            {
            // InternalMetaDsl.g:2693:1: ( ')' )
            // InternalMetaDsl.g:2694:2: ')'
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getRightParenthesisKeyword_2_3()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getSubTypeDataTypeAccess().getRightParenthesisKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2__3__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group_2_2__0"
    // InternalMetaDsl.g:2704:1: rule__SubTypeDataType__Group_2_2__0 : rule__SubTypeDataType__Group_2_2__0__Impl rule__SubTypeDataType__Group_2_2__1 ;
    public final void rule__SubTypeDataType__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2708:1: ( rule__SubTypeDataType__Group_2_2__0__Impl rule__SubTypeDataType__Group_2_2__1 )
            // InternalMetaDsl.g:2709:2: rule__SubTypeDataType__Group_2_2__0__Impl rule__SubTypeDataType__Group_2_2__1
            {
            pushFollow(FOLLOW_28);
            rule__SubTypeDataType__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2_2__0"


    // $ANTLR start "rule__SubTypeDataType__Group_2_2__0__Impl"
    // InternalMetaDsl.g:2716:1: rule__SubTypeDataType__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__SubTypeDataType__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2720:1: ( ( ',' ) )
            // InternalMetaDsl.g:2721:1: ( ',' )
            {
            // InternalMetaDsl.g:2721:1: ( ',' )
            // InternalMetaDsl.g:2722:2: ','
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getCommaKeyword_2_2_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getSubTypeDataTypeAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2_2__0__Impl"


    // $ANTLR start "rule__SubTypeDataType__Group_2_2__1"
    // InternalMetaDsl.g:2731:1: rule__SubTypeDataType__Group_2_2__1 : rule__SubTypeDataType__Group_2_2__1__Impl ;
    public final void rule__SubTypeDataType__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2735:1: ( rule__SubTypeDataType__Group_2_2__1__Impl )
            // InternalMetaDsl.g:2736:2: rule__SubTypeDataType__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2_2__1"


    // $ANTLR start "rule__SubTypeDataType__Group_2_2__1__Impl"
    // InternalMetaDsl.g:2742:1: rule__SubTypeDataType__Group_2_2__1__Impl : ( ( rule__SubTypeDataType__ScaleAssignment_2_2_1 ) ) ;
    public final void rule__SubTypeDataType__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2746:1: ( ( ( rule__SubTypeDataType__ScaleAssignment_2_2_1 ) ) )
            // InternalMetaDsl.g:2747:1: ( ( rule__SubTypeDataType__ScaleAssignment_2_2_1 ) )
            {
            // InternalMetaDsl.g:2747:1: ( ( rule__SubTypeDataType__ScaleAssignment_2_2_1 ) )
            // InternalMetaDsl.g:2748:2: ( rule__SubTypeDataType__ScaleAssignment_2_2_1 )
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getScaleAssignment_2_2_1()); 
            // InternalMetaDsl.g:2749:2: ( rule__SubTypeDataType__ScaleAssignment_2_2_1 )
            // InternalMetaDsl.g:2749:3: rule__SubTypeDataType__ScaleAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__SubTypeDataType__ScaleAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSubTypeDataTypeAccess().getScaleAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__Group_2_2__1__Impl"


    // $ANTLR start "rule__TableStereotype__Group__0"
    // InternalMetaDsl.g:2758:1: rule__TableStereotype__Group__0 : rule__TableStereotype__Group__0__Impl rule__TableStereotype__Group__1 ;
    public final void rule__TableStereotype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2762:1: ( rule__TableStereotype__Group__0__Impl rule__TableStereotype__Group__1 )
            // InternalMetaDsl.g:2763:2: rule__TableStereotype__Group__0__Impl rule__TableStereotype__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__TableStereotype__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableStereotype__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableStereotype__Group__0"


    // $ANTLR start "rule__TableStereotype__Group__0__Impl"
    // InternalMetaDsl.g:2770:1: rule__TableStereotype__Group__0__Impl : ( 'TABLESTEREOTYPE' ) ;
    public final void rule__TableStereotype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2774:1: ( ( 'TABLESTEREOTYPE' ) )
            // InternalMetaDsl.g:2775:1: ( 'TABLESTEREOTYPE' )
            {
            // InternalMetaDsl.g:2775:1: ( 'TABLESTEREOTYPE' )
            // InternalMetaDsl.g:2776:2: 'TABLESTEREOTYPE'
            {
             before(grammarAccess.getTableStereotypeAccess().getTABLESTEREOTYPEKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getTableStereotypeAccess().getTABLESTEREOTYPEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableStereotype__Group__0__Impl"


    // $ANTLR start "rule__TableStereotype__Group__1"
    // InternalMetaDsl.g:2785:1: rule__TableStereotype__Group__1 : rule__TableStereotype__Group__1__Impl rule__TableStereotype__Group__2 ;
    public final void rule__TableStereotype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2789:1: ( rule__TableStereotype__Group__1__Impl rule__TableStereotype__Group__2 )
            // InternalMetaDsl.g:2790:2: rule__TableStereotype__Group__1__Impl rule__TableStereotype__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__TableStereotype__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableStereotype__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableStereotype__Group__1"


    // $ANTLR start "rule__TableStereotype__Group__1__Impl"
    // InternalMetaDsl.g:2797:1: rule__TableStereotype__Group__1__Impl : ( ( rule__TableStereotype__NameAssignment_1 ) ) ;
    public final void rule__TableStereotype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2801:1: ( ( ( rule__TableStereotype__NameAssignment_1 ) ) )
            // InternalMetaDsl.g:2802:1: ( ( rule__TableStereotype__NameAssignment_1 ) )
            {
            // InternalMetaDsl.g:2802:1: ( ( rule__TableStereotype__NameAssignment_1 ) )
            // InternalMetaDsl.g:2803:2: ( rule__TableStereotype__NameAssignment_1 )
            {
             before(grammarAccess.getTableStereotypeAccess().getNameAssignment_1()); 
            // InternalMetaDsl.g:2804:2: ( rule__TableStereotype__NameAssignment_1 )
            // InternalMetaDsl.g:2804:3: rule__TableStereotype__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TableStereotype__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTableStereotypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableStereotype__Group__1__Impl"


    // $ANTLR start "rule__TableStereotype__Group__2"
    // InternalMetaDsl.g:2812:1: rule__TableStereotype__Group__2 : rule__TableStereotype__Group__2__Impl ;
    public final void rule__TableStereotype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2816:1: ( rule__TableStereotype__Group__2__Impl )
            // InternalMetaDsl.g:2817:2: rule__TableStereotype__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TableStereotype__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableStereotype__Group__2"


    // $ANTLR start "rule__TableStereotype__Group__2__Impl"
    // InternalMetaDsl.g:2823:1: rule__TableStereotype__Group__2__Impl : ( ';' ) ;
    public final void rule__TableStereotype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2827:1: ( ( ';' ) )
            // InternalMetaDsl.g:2828:1: ( ';' )
            {
            // InternalMetaDsl.g:2828:1: ( ';' )
            // InternalMetaDsl.g:2829:2: ';'
            {
             before(grammarAccess.getTableStereotypeAccess().getSemicolonKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getTableStereotypeAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableStereotype__Group__2__Impl"


    // $ANTLR start "rule__ColumnStereotype__Group__0"
    // InternalMetaDsl.g:2839:1: rule__ColumnStereotype__Group__0 : rule__ColumnStereotype__Group__0__Impl rule__ColumnStereotype__Group__1 ;
    public final void rule__ColumnStereotype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2843:1: ( rule__ColumnStereotype__Group__0__Impl rule__ColumnStereotype__Group__1 )
            // InternalMetaDsl.g:2844:2: rule__ColumnStereotype__Group__0__Impl rule__ColumnStereotype__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__ColumnStereotype__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColumnStereotype__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnStereotype__Group__0"


    // $ANTLR start "rule__ColumnStereotype__Group__0__Impl"
    // InternalMetaDsl.g:2851:1: rule__ColumnStereotype__Group__0__Impl : ( 'COLUMNSTEREOTYPE' ) ;
    public final void rule__ColumnStereotype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2855:1: ( ( 'COLUMNSTEREOTYPE' ) )
            // InternalMetaDsl.g:2856:1: ( 'COLUMNSTEREOTYPE' )
            {
            // InternalMetaDsl.g:2856:1: ( 'COLUMNSTEREOTYPE' )
            // InternalMetaDsl.g:2857:2: 'COLUMNSTEREOTYPE'
            {
             before(grammarAccess.getColumnStereotypeAccess().getCOLUMNSTEREOTYPEKeyword_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getColumnStereotypeAccess().getCOLUMNSTEREOTYPEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnStereotype__Group__0__Impl"


    // $ANTLR start "rule__ColumnStereotype__Group__1"
    // InternalMetaDsl.g:2866:1: rule__ColumnStereotype__Group__1 : rule__ColumnStereotype__Group__1__Impl rule__ColumnStereotype__Group__2 ;
    public final void rule__ColumnStereotype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2870:1: ( rule__ColumnStereotype__Group__1__Impl rule__ColumnStereotype__Group__2 )
            // InternalMetaDsl.g:2871:2: rule__ColumnStereotype__Group__1__Impl rule__ColumnStereotype__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__ColumnStereotype__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColumnStereotype__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnStereotype__Group__1"


    // $ANTLR start "rule__ColumnStereotype__Group__1__Impl"
    // InternalMetaDsl.g:2878:1: rule__ColumnStereotype__Group__1__Impl : ( ( rule__ColumnStereotype__NameAssignment_1 ) ) ;
    public final void rule__ColumnStereotype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2882:1: ( ( ( rule__ColumnStereotype__NameAssignment_1 ) ) )
            // InternalMetaDsl.g:2883:1: ( ( rule__ColumnStereotype__NameAssignment_1 ) )
            {
            // InternalMetaDsl.g:2883:1: ( ( rule__ColumnStereotype__NameAssignment_1 ) )
            // InternalMetaDsl.g:2884:2: ( rule__ColumnStereotype__NameAssignment_1 )
            {
             before(grammarAccess.getColumnStereotypeAccess().getNameAssignment_1()); 
            // InternalMetaDsl.g:2885:2: ( rule__ColumnStereotype__NameAssignment_1 )
            // InternalMetaDsl.g:2885:3: rule__ColumnStereotype__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ColumnStereotype__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getColumnStereotypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnStereotype__Group__1__Impl"


    // $ANTLR start "rule__ColumnStereotype__Group__2"
    // InternalMetaDsl.g:2893:1: rule__ColumnStereotype__Group__2 : rule__ColumnStereotype__Group__2__Impl ;
    public final void rule__ColumnStereotype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2897:1: ( rule__ColumnStereotype__Group__2__Impl )
            // InternalMetaDsl.g:2898:2: rule__ColumnStereotype__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ColumnStereotype__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnStereotype__Group__2"


    // $ANTLR start "rule__ColumnStereotype__Group__2__Impl"
    // InternalMetaDsl.g:2904:1: rule__ColumnStereotype__Group__2__Impl : ( ';' ) ;
    public final void rule__ColumnStereotype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2908:1: ( ( ';' ) )
            // InternalMetaDsl.g:2909:1: ( ';' )
            {
            // InternalMetaDsl.g:2909:1: ( ';' )
            // InternalMetaDsl.g:2910:2: ';'
            {
             before(grammarAccess.getColumnStereotypeAccess().getSemicolonKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getColumnStereotypeAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnStereotype__Group__2__Impl"


    // $ANTLR start "rule__Pattern__Group__0"
    // InternalMetaDsl.g:2920:1: rule__Pattern__Group__0 : rule__Pattern__Group__0__Impl rule__Pattern__Group__1 ;
    public final void rule__Pattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2924:1: ( rule__Pattern__Group__0__Impl rule__Pattern__Group__1 )
            // InternalMetaDsl.g:2925:2: rule__Pattern__Group__0__Impl rule__Pattern__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Pattern__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Pattern__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__0"


    // $ANTLR start "rule__Pattern__Group__0__Impl"
    // InternalMetaDsl.g:2932:1: rule__Pattern__Group__0__Impl : ( 'PATTERN' ) ;
    public final void rule__Pattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2936:1: ( ( 'PATTERN' ) )
            // InternalMetaDsl.g:2937:1: ( 'PATTERN' )
            {
            // InternalMetaDsl.g:2937:1: ( 'PATTERN' )
            // InternalMetaDsl.g:2938:2: 'PATTERN'
            {
             before(grammarAccess.getPatternAccess().getPATTERNKeyword_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getPatternAccess().getPATTERNKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__0__Impl"


    // $ANTLR start "rule__Pattern__Group__1"
    // InternalMetaDsl.g:2947:1: rule__Pattern__Group__1 : rule__Pattern__Group__1__Impl rule__Pattern__Group__2 ;
    public final void rule__Pattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2951:1: ( rule__Pattern__Group__1__Impl rule__Pattern__Group__2 )
            // InternalMetaDsl.g:2952:2: rule__Pattern__Group__1__Impl rule__Pattern__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Pattern__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Pattern__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__1"


    // $ANTLR start "rule__Pattern__Group__1__Impl"
    // InternalMetaDsl.g:2959:1: rule__Pattern__Group__1__Impl : ( ( rule__Pattern__NameAssignment_1 ) ) ;
    public final void rule__Pattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2963:1: ( ( ( rule__Pattern__NameAssignment_1 ) ) )
            // InternalMetaDsl.g:2964:1: ( ( rule__Pattern__NameAssignment_1 ) )
            {
            // InternalMetaDsl.g:2964:1: ( ( rule__Pattern__NameAssignment_1 ) )
            // InternalMetaDsl.g:2965:2: ( rule__Pattern__NameAssignment_1 )
            {
             before(grammarAccess.getPatternAccess().getNameAssignment_1()); 
            // InternalMetaDsl.g:2966:2: ( rule__Pattern__NameAssignment_1 )
            // InternalMetaDsl.g:2966:3: rule__Pattern__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Pattern__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPatternAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__1__Impl"


    // $ANTLR start "rule__Pattern__Group__2"
    // InternalMetaDsl.g:2974:1: rule__Pattern__Group__2 : rule__Pattern__Group__2__Impl rule__Pattern__Group__3 ;
    public final void rule__Pattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2978:1: ( rule__Pattern__Group__2__Impl rule__Pattern__Group__3 )
            // InternalMetaDsl.g:2979:2: rule__Pattern__Group__2__Impl rule__Pattern__Group__3
            {
            pushFollow(FOLLOW_29);
            rule__Pattern__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Pattern__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__2"


    // $ANTLR start "rule__Pattern__Group__2__Impl"
    // InternalMetaDsl.g:2986:1: rule__Pattern__Group__2__Impl : ( '{' ) ;
    public final void rule__Pattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:2990:1: ( ( '{' ) )
            // InternalMetaDsl.g:2991:1: ( '{' )
            {
            // InternalMetaDsl.g:2991:1: ( '{' )
            // InternalMetaDsl.g:2992:2: '{'
            {
             before(grammarAccess.getPatternAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getPatternAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__2__Impl"


    // $ANTLR start "rule__Pattern__Group__3"
    // InternalMetaDsl.g:3001:1: rule__Pattern__Group__3 : rule__Pattern__Group__3__Impl rule__Pattern__Group__4 ;
    public final void rule__Pattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3005:1: ( rule__Pattern__Group__3__Impl rule__Pattern__Group__4 )
            // InternalMetaDsl.g:3006:2: rule__Pattern__Group__3__Impl rule__Pattern__Group__4
            {
            pushFollow(FOLLOW_29);
            rule__Pattern__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Pattern__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__3"


    // $ANTLR start "rule__Pattern__Group__3__Impl"
    // InternalMetaDsl.g:3013:1: rule__Pattern__Group__3__Impl : ( ( rule__Pattern__AttributesAssignment_3 )* ) ;
    public final void rule__Pattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3017:1: ( ( ( rule__Pattern__AttributesAssignment_3 )* ) )
            // InternalMetaDsl.g:3018:1: ( ( rule__Pattern__AttributesAssignment_3 )* )
            {
            // InternalMetaDsl.g:3018:1: ( ( rule__Pattern__AttributesAssignment_3 )* )
            // InternalMetaDsl.g:3019:2: ( rule__Pattern__AttributesAssignment_3 )*
            {
             before(grammarAccess.getPatternAccess().getAttributesAssignment_3()); 
            // InternalMetaDsl.g:3020:2: ( rule__Pattern__AttributesAssignment_3 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID||(LA37_0>=85 && LA37_0<=86)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalMetaDsl.g:3020:3: rule__Pattern__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__Pattern__AttributesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getPatternAccess().getAttributesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__3__Impl"


    // $ANTLR start "rule__Pattern__Group__4"
    // InternalMetaDsl.g:3028:1: rule__Pattern__Group__4 : rule__Pattern__Group__4__Impl ;
    public final void rule__Pattern__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3032:1: ( rule__Pattern__Group__4__Impl )
            // InternalMetaDsl.g:3033:2: rule__Pattern__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Pattern__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__4"


    // $ANTLR start "rule__Pattern__Group__4__Impl"
    // InternalMetaDsl.g:3039:1: rule__Pattern__Group__4__Impl : ( '}' ) ;
    public final void rule__Pattern__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3043:1: ( ( '}' ) )
            // InternalMetaDsl.g:3044:1: ( '}' )
            {
            // InternalMetaDsl.g:3044:1: ( '}' )
            // InternalMetaDsl.g:3045:2: '}'
            {
             before(grammarAccess.getPatternAccess().getRightCurlyBracketKeyword_4()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPatternAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__Group__4__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalMetaDsl.g:3055:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3059:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalMetaDsl.g:3060:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // InternalMetaDsl.g:3067:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3071:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:3072:1: ( RULE_ID )
            {
            // InternalMetaDsl.g:3072:1: ( RULE_ID )
            // InternalMetaDsl.g:3073:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // InternalMetaDsl.g:3082:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3086:1: ( rule__FQN__Group__1__Impl )
            // InternalMetaDsl.g:3087:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // InternalMetaDsl.g:3093:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3097:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalMetaDsl.g:3098:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalMetaDsl.g:3098:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalMetaDsl.g:3099:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalMetaDsl.g:3100:2: ( rule__FQN__Group_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==52) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalMetaDsl.g:3100:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // InternalMetaDsl.g:3109:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3113:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalMetaDsl.g:3114:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FQN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // InternalMetaDsl.g:3121:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3125:1: ( ( '.' ) )
            // InternalMetaDsl.g:3126:1: ( '.' )
            {
            // InternalMetaDsl.g:3126:1: ( '.' )
            // InternalMetaDsl.g:3127:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // InternalMetaDsl.g:3136:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3140:1: ( rule__FQN__Group_1__1__Impl )
            // InternalMetaDsl.g:3141:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // InternalMetaDsl.g:3147:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3151:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:3152:1: ( RULE_ID )
            {
            // InternalMetaDsl.g:3152:1: ( RULE_ID )
            // InternalMetaDsl.g:3153:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__Entity__Group__0"
    // InternalMetaDsl.g:3163:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3167:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // InternalMetaDsl.g:3168:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__Entity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0"


    // $ANTLR start "rule__Entity__Group__0__Impl"
    // InternalMetaDsl.g:3175:1: rule__Entity__Group__0__Impl : ( ( rule__Entity__Group_0__0 )? ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3179:1: ( ( ( rule__Entity__Group_0__0 )? ) )
            // InternalMetaDsl.g:3180:1: ( ( rule__Entity__Group_0__0 )? )
            {
            // InternalMetaDsl.g:3180:1: ( ( rule__Entity__Group_0__0 )? )
            // InternalMetaDsl.g:3181:2: ( rule__Entity__Group_0__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_0()); 
            // InternalMetaDsl.g:3182:2: ( rule__Entity__Group_0__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==53) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMetaDsl.g:3182:3: rule__Entity__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0__Impl"


    // $ANTLR start "rule__Entity__Group__1"
    // InternalMetaDsl.g:3190:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3194:1: ( rule__Entity__Group__1__Impl rule__Entity__Group__2 )
            // InternalMetaDsl.g:3195:2: rule__Entity__Group__1__Impl rule__Entity__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__Entity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1"


    // $ANTLR start "rule__Entity__Group__1__Impl"
    // InternalMetaDsl.g:3202:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__SqlFileDependenciesAssignment_1 )* ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3206:1: ( ( ( rule__Entity__SqlFileDependenciesAssignment_1 )* ) )
            // InternalMetaDsl.g:3207:1: ( ( rule__Entity__SqlFileDependenciesAssignment_1 )* )
            {
            // InternalMetaDsl.g:3207:1: ( ( rule__Entity__SqlFileDependenciesAssignment_1 )* )
            // InternalMetaDsl.g:3208:2: ( rule__Entity__SqlFileDependenciesAssignment_1 )*
            {
             before(grammarAccess.getEntityAccess().getSqlFileDependenciesAssignment_1()); 
            // InternalMetaDsl.g:3209:2: ( rule__Entity__SqlFileDependenciesAssignment_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==56) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalMetaDsl.g:3209:3: rule__Entity__SqlFileDependenciesAssignment_1
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__Entity__SqlFileDependenciesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getSqlFileDependenciesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1__Impl"


    // $ANTLR start "rule__Entity__Group__2"
    // InternalMetaDsl.g:3217:1: rule__Entity__Group__2 : rule__Entity__Group__2__Impl rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3221:1: ( rule__Entity__Group__2__Impl rule__Entity__Group__3 )
            // InternalMetaDsl.g:3222:2: rule__Entity__Group__2__Impl rule__Entity__Group__3
            {
            pushFollow(FOLLOW_33);
            rule__Entity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2"


    // $ANTLR start "rule__Entity__Group__2__Impl"
    // InternalMetaDsl.g:3229:1: rule__Entity__Group__2__Impl : ( ( rule__Entity__EntityTypeAssignment_2 )? ) ;
    public final void rule__Entity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3233:1: ( ( ( rule__Entity__EntityTypeAssignment_2 )? ) )
            // InternalMetaDsl.g:3234:1: ( ( rule__Entity__EntityTypeAssignment_2 )? )
            {
            // InternalMetaDsl.g:3234:1: ( ( rule__Entity__EntityTypeAssignment_2 )? )
            // InternalMetaDsl.g:3235:2: ( rule__Entity__EntityTypeAssignment_2 )?
            {
             before(grammarAccess.getEntityAccess().getEntityTypeAssignment_2()); 
            // InternalMetaDsl.g:3236:2: ( rule__Entity__EntityTypeAssignment_2 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=18 && LA41_0<=20)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalMetaDsl.g:3236:3: rule__Entity__EntityTypeAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__EntityTypeAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getEntityTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2__Impl"


    // $ANTLR start "rule__Entity__Group__3"
    // InternalMetaDsl.g:3244:1: rule__Entity__Group__3 : rule__Entity__Group__3__Impl rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3248:1: ( rule__Entity__Group__3__Impl rule__Entity__Group__4 )
            // InternalMetaDsl.g:3249:2: rule__Entity__Group__3__Impl rule__Entity__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Entity__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3"


    // $ANTLR start "rule__Entity__Group__3__Impl"
    // InternalMetaDsl.g:3256:1: rule__Entity__Group__3__Impl : ( 'ENTITY' ) ;
    public final void rule__Entity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3260:1: ( ( 'ENTITY' ) )
            // InternalMetaDsl.g:3261:1: ( 'ENTITY' )
            {
            // InternalMetaDsl.g:3261:1: ( 'ENTITY' )
            // InternalMetaDsl.g:3262:2: 'ENTITY'
            {
             before(grammarAccess.getEntityAccess().getENTITYKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getENTITYKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3__Impl"


    // $ANTLR start "rule__Entity__Group__4"
    // InternalMetaDsl.g:3271:1: rule__Entity__Group__4 : rule__Entity__Group__4__Impl rule__Entity__Group__5 ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3275:1: ( rule__Entity__Group__4__Impl rule__Entity__Group__5 )
            // InternalMetaDsl.g:3276:2: rule__Entity__Group__4__Impl rule__Entity__Group__5
            {
            pushFollow(FOLLOW_35);
            rule__Entity__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__4"


    // $ANTLR start "rule__Entity__Group__4__Impl"
    // InternalMetaDsl.g:3283:1: rule__Entity__Group__4__Impl : ( ( rule__Entity__NameAssignment_4 ) ) ;
    public final void rule__Entity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3287:1: ( ( ( rule__Entity__NameAssignment_4 ) ) )
            // InternalMetaDsl.g:3288:1: ( ( rule__Entity__NameAssignment_4 ) )
            {
            // InternalMetaDsl.g:3288:1: ( ( rule__Entity__NameAssignment_4 ) )
            // InternalMetaDsl.g:3289:2: ( rule__Entity__NameAssignment_4 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_4()); 
            // InternalMetaDsl.g:3290:2: ( rule__Entity__NameAssignment_4 )
            // InternalMetaDsl.g:3290:3: rule__Entity__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Entity__NameAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__4__Impl"


    // $ANTLR start "rule__Entity__Group__5"
    // InternalMetaDsl.g:3298:1: rule__Entity__Group__5 : rule__Entity__Group__5__Impl rule__Entity__Group__6 ;
    public final void rule__Entity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3302:1: ( rule__Entity__Group__5__Impl rule__Entity__Group__6 )
            // InternalMetaDsl.g:3303:2: rule__Entity__Group__5__Impl rule__Entity__Group__6
            {
            pushFollow(FOLLOW_35);
            rule__Entity__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__5"


    // $ANTLR start "rule__Entity__Group__5__Impl"
    // InternalMetaDsl.g:3310:1: rule__Entity__Group__5__Impl : ( ( rule__Entity__Group_5__0 )? ) ;
    public final void rule__Entity__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3314:1: ( ( ( rule__Entity__Group_5__0 )? ) )
            // InternalMetaDsl.g:3315:1: ( ( rule__Entity__Group_5__0 )? )
            {
            // InternalMetaDsl.g:3315:1: ( ( rule__Entity__Group_5__0 )? )
            // InternalMetaDsl.g:3316:2: ( rule__Entity__Group_5__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_5()); 
            // InternalMetaDsl.g:3317:2: ( rule__Entity__Group_5__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==54) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMetaDsl.g:3317:3: rule__Entity__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__5__Impl"


    // $ANTLR start "rule__Entity__Group__6"
    // InternalMetaDsl.g:3325:1: rule__Entity__Group__6 : rule__Entity__Group__6__Impl rule__Entity__Group__7 ;
    public final void rule__Entity__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3329:1: ( rule__Entity__Group__6__Impl rule__Entity__Group__7 )
            // InternalMetaDsl.g:3330:2: rule__Entity__Group__6__Impl rule__Entity__Group__7
            {
            pushFollow(FOLLOW_35);
            rule__Entity__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__6"


    // $ANTLR start "rule__Entity__Group__6__Impl"
    // InternalMetaDsl.g:3337:1: rule__Entity__Group__6__Impl : ( ( rule__Entity__Group_6__0 )? ) ;
    public final void rule__Entity__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3341:1: ( ( ( rule__Entity__Group_6__0 )? ) )
            // InternalMetaDsl.g:3342:1: ( ( rule__Entity__Group_6__0 )? )
            {
            // InternalMetaDsl.g:3342:1: ( ( rule__Entity__Group_6__0 )? )
            // InternalMetaDsl.g:3343:2: ( rule__Entity__Group_6__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_6()); 
            // InternalMetaDsl.g:3344:2: ( rule__Entity__Group_6__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==51) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalMetaDsl.g:3344:3: rule__Entity__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__6__Impl"


    // $ANTLR start "rule__Entity__Group__7"
    // InternalMetaDsl.g:3352:1: rule__Entity__Group__7 : rule__Entity__Group__7__Impl rule__Entity__Group__8 ;
    public final void rule__Entity__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3356:1: ( rule__Entity__Group__7__Impl rule__Entity__Group__8 )
            // InternalMetaDsl.g:3357:2: rule__Entity__Group__7__Impl rule__Entity__Group__8
            {
            pushFollow(FOLLOW_35);
            rule__Entity__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__7"


    // $ANTLR start "rule__Entity__Group__7__Impl"
    // InternalMetaDsl.g:3364:1: rule__Entity__Group__7__Impl : ( ( rule__Entity__Group_7__0 )? ) ;
    public final void rule__Entity__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3368:1: ( ( ( rule__Entity__Group_7__0 )? ) )
            // InternalMetaDsl.g:3369:1: ( ( rule__Entity__Group_7__0 )? )
            {
            // InternalMetaDsl.g:3369:1: ( ( rule__Entity__Group_7__0 )? )
            // InternalMetaDsl.g:3370:2: ( rule__Entity__Group_7__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_7()); 
            // InternalMetaDsl.g:3371:2: ( rule__Entity__Group_7__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==55) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalMetaDsl.g:3371:3: rule__Entity__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__7__Impl"


    // $ANTLR start "rule__Entity__Group__8"
    // InternalMetaDsl.g:3379:1: rule__Entity__Group__8 : rule__Entity__Group__8__Impl rule__Entity__Group__9 ;
    public final void rule__Entity__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3383:1: ( rule__Entity__Group__8__Impl rule__Entity__Group__9 )
            // InternalMetaDsl.g:3384:2: rule__Entity__Group__8__Impl rule__Entity__Group__9
            {
            pushFollow(FOLLOW_36);
            rule__Entity__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__8"


    // $ANTLR start "rule__Entity__Group__8__Impl"
    // InternalMetaDsl.g:3391:1: rule__Entity__Group__8__Impl : ( '{' ) ;
    public final void rule__Entity__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3395:1: ( ( '{' ) )
            // InternalMetaDsl.g:3396:1: ( '{' )
            {
            // InternalMetaDsl.g:3396:1: ( '{' )
            // InternalMetaDsl.g:3397:2: '{'
            {
             before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_8()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__8__Impl"


    // $ANTLR start "rule__Entity__Group__9"
    // InternalMetaDsl.g:3406:1: rule__Entity__Group__9 : rule__Entity__Group__9__Impl rule__Entity__Group__10 ;
    public final void rule__Entity__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3410:1: ( rule__Entity__Group__9__Impl rule__Entity__Group__10 )
            // InternalMetaDsl.g:3411:2: rule__Entity__Group__9__Impl rule__Entity__Group__10
            {
            pushFollow(FOLLOW_36);
            rule__Entity__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__9"


    // $ANTLR start "rule__Entity__Group__9__Impl"
    // InternalMetaDsl.g:3418:1: rule__Entity__Group__9__Impl : ( ( rule__Entity__AttributesAssignment_9 )* ) ;
    public final void rule__Entity__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3422:1: ( ( ( rule__Entity__AttributesAssignment_9 )* ) )
            // InternalMetaDsl.g:3423:1: ( ( rule__Entity__AttributesAssignment_9 )* )
            {
            // InternalMetaDsl.g:3423:1: ( ( rule__Entity__AttributesAssignment_9 )* )
            // InternalMetaDsl.g:3424:2: ( rule__Entity__AttributesAssignment_9 )*
            {
             before(grammarAccess.getEntityAccess().getAttributesAssignment_9()); 
            // InternalMetaDsl.g:3425:2: ( rule__Entity__AttributesAssignment_9 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_ID||(LA45_0>=85 && LA45_0<=86)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalMetaDsl.g:3425:3: rule__Entity__AttributesAssignment_9
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__Entity__AttributesAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getAttributesAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__9__Impl"


    // $ANTLR start "rule__Entity__Group__10"
    // InternalMetaDsl.g:3433:1: rule__Entity__Group__10 : rule__Entity__Group__10__Impl rule__Entity__Group__11 ;
    public final void rule__Entity__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3437:1: ( rule__Entity__Group__10__Impl rule__Entity__Group__11 )
            // InternalMetaDsl.g:3438:2: rule__Entity__Group__10__Impl rule__Entity__Group__11
            {
            pushFollow(FOLLOW_36);
            rule__Entity__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__10"


    // $ANTLR start "rule__Entity__Group__10__Impl"
    // InternalMetaDsl.g:3445:1: rule__Entity__Group__10__Impl : ( ( rule__Entity__MetadataAssignment_10 )? ) ;
    public final void rule__Entity__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3449:1: ( ( ( rule__Entity__MetadataAssignment_10 )? ) )
            // InternalMetaDsl.g:3450:1: ( ( rule__Entity__MetadataAssignment_10 )? )
            {
            // InternalMetaDsl.g:3450:1: ( ( rule__Entity__MetadataAssignment_10 )? )
            // InternalMetaDsl.g:3451:2: ( rule__Entity__MetadataAssignment_10 )?
            {
             before(grammarAccess.getEntityAccess().getMetadataAssignment_10()); 
            // InternalMetaDsl.g:3452:2: ( rule__Entity__MetadataAssignment_10 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==90) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalMetaDsl.g:3452:3: rule__Entity__MetadataAssignment_10
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__MetadataAssignment_10();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getMetadataAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__10__Impl"


    // $ANTLR start "rule__Entity__Group__11"
    // InternalMetaDsl.g:3460:1: rule__Entity__Group__11 : rule__Entity__Group__11__Impl rule__Entity__Group__12 ;
    public final void rule__Entity__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3464:1: ( rule__Entity__Group__11__Impl rule__Entity__Group__12 )
            // InternalMetaDsl.g:3465:2: rule__Entity__Group__11__Impl rule__Entity__Group__12
            {
            pushFollow(FOLLOW_36);
            rule__Entity__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__11"


    // $ANTLR start "rule__Entity__Group__11__Impl"
    // InternalMetaDsl.g:3472:1: rule__Entity__Group__11__Impl : ( ( rule__Entity__EnuMetadataAssignment_11 )? ) ;
    public final void rule__Entity__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3476:1: ( ( ( rule__Entity__EnuMetadataAssignment_11 )? ) )
            // InternalMetaDsl.g:3477:1: ( ( rule__Entity__EnuMetadataAssignment_11 )? )
            {
            // InternalMetaDsl.g:3477:1: ( ( rule__Entity__EnuMetadataAssignment_11 )? )
            // InternalMetaDsl.g:3478:2: ( rule__Entity__EnuMetadataAssignment_11 )?
            {
             before(grammarAccess.getEntityAccess().getEnuMetadataAssignment_11()); 
            // InternalMetaDsl.g:3479:2: ( rule__Entity__EnuMetadataAssignment_11 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==68) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalMetaDsl.g:3479:3: rule__Entity__EnuMetadataAssignment_11
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__EnuMetadataAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getEnuMetadataAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__11__Impl"


    // $ANTLR start "rule__Entity__Group__12"
    // InternalMetaDsl.g:3487:1: rule__Entity__Group__12 : rule__Entity__Group__12__Impl rule__Entity__Group__13 ;
    public final void rule__Entity__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3491:1: ( rule__Entity__Group__12__Impl rule__Entity__Group__13 )
            // InternalMetaDsl.g:3492:2: rule__Entity__Group__12__Impl rule__Entity__Group__13
            {
            pushFollow(FOLLOW_36);
            rule__Entity__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__12"


    // $ANTLR start "rule__Entity__Group__12__Impl"
    // InternalMetaDsl.g:3499:1: rule__Entity__Group__12__Impl : ( ( rule__Entity__LabelSectionAssignment_12 )? ) ;
    public final void rule__Entity__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3503:1: ( ( ( rule__Entity__LabelSectionAssignment_12 )? ) )
            // InternalMetaDsl.g:3504:1: ( ( rule__Entity__LabelSectionAssignment_12 )? )
            {
            // InternalMetaDsl.g:3504:1: ( ( rule__Entity__LabelSectionAssignment_12 )? )
            // InternalMetaDsl.g:3505:2: ( rule__Entity__LabelSectionAssignment_12 )?
            {
             before(grammarAccess.getEntityAccess().getLabelSectionAssignment_12()); 
            // InternalMetaDsl.g:3506:2: ( rule__Entity__LabelSectionAssignment_12 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==92) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalMetaDsl.g:3506:3: rule__Entity__LabelSectionAssignment_12
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__LabelSectionAssignment_12();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getLabelSectionAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__12__Impl"


    // $ANTLR start "rule__Entity__Group__13"
    // InternalMetaDsl.g:3514:1: rule__Entity__Group__13 : rule__Entity__Group__13__Impl rule__Entity__Group__14 ;
    public final void rule__Entity__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3518:1: ( rule__Entity__Group__13__Impl rule__Entity__Group__14 )
            // InternalMetaDsl.g:3519:2: rule__Entity__Group__13__Impl rule__Entity__Group__14
            {
            pushFollow(FOLLOW_36);
            rule__Entity__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__13"


    // $ANTLR start "rule__Entity__Group__13__Impl"
    // InternalMetaDsl.g:3526:1: rule__Entity__Group__13__Impl : ( ( rule__Entity__EnumerationLabelsAssignment_13 )? ) ;
    public final void rule__Entity__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3530:1: ( ( ( rule__Entity__EnumerationLabelsAssignment_13 )? ) )
            // InternalMetaDsl.g:3531:1: ( ( rule__Entity__EnumerationLabelsAssignment_13 )? )
            {
            // InternalMetaDsl.g:3531:1: ( ( rule__Entity__EnumerationLabelsAssignment_13 )? )
            // InternalMetaDsl.g:3532:2: ( rule__Entity__EnumerationLabelsAssignment_13 )?
            {
             before(grammarAccess.getEntityAccess().getEnumerationLabelsAssignment_13()); 
            // InternalMetaDsl.g:3533:2: ( rule__Entity__EnumerationLabelsAssignment_13 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==74) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalMetaDsl.g:3533:3: rule__Entity__EnumerationLabelsAssignment_13
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__EnumerationLabelsAssignment_13();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getEnumerationLabelsAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__13__Impl"


    // $ANTLR start "rule__Entity__Group__14"
    // InternalMetaDsl.g:3541:1: rule__Entity__Group__14 : rule__Entity__Group__14__Impl rule__Entity__Group__15 ;
    public final void rule__Entity__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3545:1: ( rule__Entity__Group__14__Impl rule__Entity__Group__15 )
            // InternalMetaDsl.g:3546:2: rule__Entity__Group__14__Impl rule__Entity__Group__15
            {
            pushFollow(FOLLOW_36);
            rule__Entity__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__14"


    // $ANTLR start "rule__Entity__Group__14__Impl"
    // InternalMetaDsl.g:3553:1: rule__Entity__Group__14__Impl : ( ( rule__Entity__DocumentationSectionAssignment_14 )? ) ;
    public final void rule__Entity__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3557:1: ( ( ( rule__Entity__DocumentationSectionAssignment_14 )? ) )
            // InternalMetaDsl.g:3558:1: ( ( rule__Entity__DocumentationSectionAssignment_14 )? )
            {
            // InternalMetaDsl.g:3558:1: ( ( rule__Entity__DocumentationSectionAssignment_14 )? )
            // InternalMetaDsl.g:3559:2: ( rule__Entity__DocumentationSectionAssignment_14 )?
            {
             before(grammarAccess.getEntityAccess().getDocumentationSectionAssignment_14()); 
            // InternalMetaDsl.g:3560:2: ( rule__Entity__DocumentationSectionAssignment_14 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==93) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalMetaDsl.g:3560:3: rule__Entity__DocumentationSectionAssignment_14
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__DocumentationSectionAssignment_14();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getDocumentationSectionAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__14__Impl"


    // $ANTLR start "rule__Entity__Group__15"
    // InternalMetaDsl.g:3568:1: rule__Entity__Group__15 : rule__Entity__Group__15__Impl rule__Entity__Group__16 ;
    public final void rule__Entity__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3572:1: ( rule__Entity__Group__15__Impl rule__Entity__Group__16 )
            // InternalMetaDsl.g:3573:2: rule__Entity__Group__15__Impl rule__Entity__Group__16
            {
            pushFollow(FOLLOW_36);
            rule__Entity__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__15"


    // $ANTLR start "rule__Entity__Group__15__Impl"
    // InternalMetaDsl.g:3580:1: rule__Entity__Group__15__Impl : ( ( rule__Entity__QuerySourceBlockAssignment_15 )? ) ;
    public final void rule__Entity__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3584:1: ( ( ( rule__Entity__QuerySourceBlockAssignment_15 )? ) )
            // InternalMetaDsl.g:3585:1: ( ( rule__Entity__QuerySourceBlockAssignment_15 )? )
            {
            // InternalMetaDsl.g:3585:1: ( ( rule__Entity__QuerySourceBlockAssignment_15 )? )
            // InternalMetaDsl.g:3586:2: ( rule__Entity__QuerySourceBlockAssignment_15 )?
            {
             before(grammarAccess.getEntityAccess().getQuerySourceBlockAssignment_15()); 
            // InternalMetaDsl.g:3587:2: ( rule__Entity__QuerySourceBlockAssignment_15 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==75) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalMetaDsl.g:3587:3: rule__Entity__QuerySourceBlockAssignment_15
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__QuerySourceBlockAssignment_15();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getQuerySourceBlockAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__15__Impl"


    // $ANTLR start "rule__Entity__Group__16"
    // InternalMetaDsl.g:3595:1: rule__Entity__Group__16 : rule__Entity__Group__16__Impl ;
    public final void rule__Entity__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3599:1: ( rule__Entity__Group__16__Impl )
            // InternalMetaDsl.g:3600:2: rule__Entity__Group__16__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__16__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__16"


    // $ANTLR start "rule__Entity__Group__16__Impl"
    // InternalMetaDsl.g:3606:1: rule__Entity__Group__16__Impl : ( '}' ) ;
    public final void rule__Entity__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3610:1: ( ( '}' ) )
            // InternalMetaDsl.g:3611:1: ( '}' )
            {
            // InternalMetaDsl.g:3611:1: ( '}' )
            // InternalMetaDsl.g:3612:2: '}'
            {
             before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_16()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__16__Impl"


    // $ANTLR start "rule__Entity__Group_0__0"
    // InternalMetaDsl.g:3622:1: rule__Entity__Group_0__0 : rule__Entity__Group_0__0__Impl rule__Entity__Group_0__1 ;
    public final void rule__Entity__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3626:1: ( rule__Entity__Group_0__0__Impl rule__Entity__Group_0__1 )
            // InternalMetaDsl.g:3627:2: rule__Entity__Group_0__0__Impl rule__Entity__Group_0__1
            {
            pushFollow(FOLLOW_22);
            rule__Entity__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_0__0"


    // $ANTLR start "rule__Entity__Group_0__0__Impl"
    // InternalMetaDsl.g:3634:1: rule__Entity__Group_0__0__Impl : ( 'FROMSQLFILE' ) ;
    public final void rule__Entity__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3638:1: ( ( 'FROMSQLFILE' ) )
            // InternalMetaDsl.g:3639:1: ( 'FROMSQLFILE' )
            {
            // InternalMetaDsl.g:3639:1: ( 'FROMSQLFILE' )
            // InternalMetaDsl.g:3640:2: 'FROMSQLFILE'
            {
             before(grammarAccess.getEntityAccess().getFROMSQLFILEKeyword_0_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getFROMSQLFILEKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_0__0__Impl"


    // $ANTLR start "rule__Entity__Group_0__1"
    // InternalMetaDsl.g:3649:1: rule__Entity__Group_0__1 : rule__Entity__Group_0__1__Impl ;
    public final void rule__Entity__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3653:1: ( rule__Entity__Group_0__1__Impl )
            // InternalMetaDsl.g:3654:2: rule__Entity__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_0__1"


    // $ANTLR start "rule__Entity__Group_0__1__Impl"
    // InternalMetaDsl.g:3660:1: rule__Entity__Group_0__1__Impl : ( ( rule__Entity__FromSQLFileAssignment_0_1 ) ) ;
    public final void rule__Entity__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3664:1: ( ( ( rule__Entity__FromSQLFileAssignment_0_1 ) ) )
            // InternalMetaDsl.g:3665:1: ( ( rule__Entity__FromSQLFileAssignment_0_1 ) )
            {
            // InternalMetaDsl.g:3665:1: ( ( rule__Entity__FromSQLFileAssignment_0_1 ) )
            // InternalMetaDsl.g:3666:2: ( rule__Entity__FromSQLFileAssignment_0_1 )
            {
             before(grammarAccess.getEntityAccess().getFromSQLFileAssignment_0_1()); 
            // InternalMetaDsl.g:3667:2: ( rule__Entity__FromSQLFileAssignment_0_1 )
            // InternalMetaDsl.g:3667:3: rule__Entity__FromSQLFileAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__FromSQLFileAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getFromSQLFileAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_0__1__Impl"


    // $ANTLR start "rule__Entity__Group_5__0"
    // InternalMetaDsl.g:3676:1: rule__Entity__Group_5__0 : rule__Entity__Group_5__0__Impl rule__Entity__Group_5__1 ;
    public final void rule__Entity__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3680:1: ( rule__Entity__Group_5__0__Impl rule__Entity__Group_5__1 )
            // InternalMetaDsl.g:3681:2: rule__Entity__Group_5__0__Impl rule__Entity__Group_5__1
            {
            pushFollow(FOLLOW_20);
            rule__Entity__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_5__0"


    // $ANTLR start "rule__Entity__Group_5__0__Impl"
    // InternalMetaDsl.g:3688:1: rule__Entity__Group_5__0__Impl : ( 'EXTENDS' ) ;
    public final void rule__Entity__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3692:1: ( ( 'EXTENDS' ) )
            // InternalMetaDsl.g:3693:1: ( 'EXTENDS' )
            {
            // InternalMetaDsl.g:3693:1: ( 'EXTENDS' )
            // InternalMetaDsl.g:3694:2: 'EXTENDS'
            {
             before(grammarAccess.getEntityAccess().getEXTENDSKeyword_5_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getEXTENDSKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_5__0__Impl"


    // $ANTLR start "rule__Entity__Group_5__1"
    // InternalMetaDsl.g:3703:1: rule__Entity__Group_5__1 : rule__Entity__Group_5__1__Impl ;
    public final void rule__Entity__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3707:1: ( rule__Entity__Group_5__1__Impl )
            // InternalMetaDsl.g:3708:2: rule__Entity__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_5__1"


    // $ANTLR start "rule__Entity__Group_5__1__Impl"
    // InternalMetaDsl.g:3714:1: rule__Entity__Group_5__1__Impl : ( ( rule__Entity__ExtendsAssignment_5_1 ) ) ;
    public final void rule__Entity__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3718:1: ( ( ( rule__Entity__ExtendsAssignment_5_1 ) ) )
            // InternalMetaDsl.g:3719:1: ( ( rule__Entity__ExtendsAssignment_5_1 ) )
            {
            // InternalMetaDsl.g:3719:1: ( ( rule__Entity__ExtendsAssignment_5_1 ) )
            // InternalMetaDsl.g:3720:2: ( rule__Entity__ExtendsAssignment_5_1 )
            {
             before(grammarAccess.getEntityAccess().getExtendsAssignment_5_1()); 
            // InternalMetaDsl.g:3721:2: ( rule__Entity__ExtendsAssignment_5_1 )
            // InternalMetaDsl.g:3721:3: rule__Entity__ExtendsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__ExtendsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getExtendsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_5__1__Impl"


    // $ANTLR start "rule__Entity__Group_6__0"
    // InternalMetaDsl.g:3730:1: rule__Entity__Group_6__0 : rule__Entity__Group_6__0__Impl rule__Entity__Group_6__1 ;
    public final void rule__Entity__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3734:1: ( rule__Entity__Group_6__0__Impl rule__Entity__Group_6__1 )
            // InternalMetaDsl.g:3735:2: rule__Entity__Group_6__0__Impl rule__Entity__Group_6__1
            {
            pushFollow(FOLLOW_20);
            rule__Entity__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6__0"


    // $ANTLR start "rule__Entity__Group_6__0__Impl"
    // InternalMetaDsl.g:3742:1: rule__Entity__Group_6__0__Impl : ( 'PATTERN' ) ;
    public final void rule__Entity__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3746:1: ( ( 'PATTERN' ) )
            // InternalMetaDsl.g:3747:1: ( 'PATTERN' )
            {
            // InternalMetaDsl.g:3747:1: ( 'PATTERN' )
            // InternalMetaDsl.g:3748:2: 'PATTERN'
            {
             before(grammarAccess.getEntityAccess().getPATTERNKeyword_6_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getPATTERNKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6__0__Impl"


    // $ANTLR start "rule__Entity__Group_6__1"
    // InternalMetaDsl.g:3757:1: rule__Entity__Group_6__1 : rule__Entity__Group_6__1__Impl rule__Entity__Group_6__2 ;
    public final void rule__Entity__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3761:1: ( rule__Entity__Group_6__1__Impl rule__Entity__Group_6__2 )
            // InternalMetaDsl.g:3762:2: rule__Entity__Group_6__1__Impl rule__Entity__Group_6__2
            {
            pushFollow(FOLLOW_37);
            rule__Entity__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6__1"


    // $ANTLR start "rule__Entity__Group_6__1__Impl"
    // InternalMetaDsl.g:3769:1: rule__Entity__Group_6__1__Impl : ( ( rule__Entity__PatternsAssignment_6_1 ) ) ;
    public final void rule__Entity__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3773:1: ( ( ( rule__Entity__PatternsAssignment_6_1 ) ) )
            // InternalMetaDsl.g:3774:1: ( ( rule__Entity__PatternsAssignment_6_1 ) )
            {
            // InternalMetaDsl.g:3774:1: ( ( rule__Entity__PatternsAssignment_6_1 ) )
            // InternalMetaDsl.g:3775:2: ( rule__Entity__PatternsAssignment_6_1 )
            {
             before(grammarAccess.getEntityAccess().getPatternsAssignment_6_1()); 
            // InternalMetaDsl.g:3776:2: ( rule__Entity__PatternsAssignment_6_1 )
            // InternalMetaDsl.g:3776:3: rule__Entity__PatternsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__PatternsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getPatternsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6__1__Impl"


    // $ANTLR start "rule__Entity__Group_6__2"
    // InternalMetaDsl.g:3784:1: rule__Entity__Group_6__2 : rule__Entity__Group_6__2__Impl ;
    public final void rule__Entity__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3788:1: ( rule__Entity__Group_6__2__Impl )
            // InternalMetaDsl.g:3789:2: rule__Entity__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6__2"


    // $ANTLR start "rule__Entity__Group_6__2__Impl"
    // InternalMetaDsl.g:3795:1: rule__Entity__Group_6__2__Impl : ( ( rule__Entity__Group_6_2__0 )? ) ;
    public final void rule__Entity__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3799:1: ( ( ( rule__Entity__Group_6_2__0 )? ) )
            // InternalMetaDsl.g:3800:1: ( ( rule__Entity__Group_6_2__0 )? )
            {
            // InternalMetaDsl.g:3800:1: ( ( rule__Entity__Group_6_2__0 )? )
            // InternalMetaDsl.g:3801:2: ( rule__Entity__Group_6_2__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_6_2()); 
            // InternalMetaDsl.g:3802:2: ( rule__Entity__Group_6_2__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==48) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMetaDsl.g:3802:3: rule__Entity__Group_6_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__Group_6_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6__2__Impl"


    // $ANTLR start "rule__Entity__Group_6_2__0"
    // InternalMetaDsl.g:3811:1: rule__Entity__Group_6_2__0 : rule__Entity__Group_6_2__0__Impl rule__Entity__Group_6_2__1 ;
    public final void rule__Entity__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3815:1: ( rule__Entity__Group_6_2__0__Impl rule__Entity__Group_6_2__1 )
            // InternalMetaDsl.g:3816:2: rule__Entity__Group_6_2__0__Impl rule__Entity__Group_6_2__1
            {
            pushFollow(FOLLOW_20);
            rule__Entity__Group_6_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group_6_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6_2__0"


    // $ANTLR start "rule__Entity__Group_6_2__0__Impl"
    // InternalMetaDsl.g:3823:1: rule__Entity__Group_6_2__0__Impl : ( ',' ) ;
    public final void rule__Entity__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3827:1: ( ( ',' ) )
            // InternalMetaDsl.g:3828:1: ( ',' )
            {
            // InternalMetaDsl.g:3828:1: ( ',' )
            // InternalMetaDsl.g:3829:2: ','
            {
             before(grammarAccess.getEntityAccess().getCommaKeyword_6_2_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getCommaKeyword_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6_2__0__Impl"


    // $ANTLR start "rule__Entity__Group_6_2__1"
    // InternalMetaDsl.g:3838:1: rule__Entity__Group_6_2__1 : rule__Entity__Group_6_2__1__Impl ;
    public final void rule__Entity__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3842:1: ( rule__Entity__Group_6_2__1__Impl )
            // InternalMetaDsl.g:3843:2: rule__Entity__Group_6_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group_6_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6_2__1"


    // $ANTLR start "rule__Entity__Group_6_2__1__Impl"
    // InternalMetaDsl.g:3849:1: rule__Entity__Group_6_2__1__Impl : ( ( rule__Entity__PatternsAssignment_6_2_1 ) ) ;
    public final void rule__Entity__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3853:1: ( ( ( rule__Entity__PatternsAssignment_6_2_1 ) ) )
            // InternalMetaDsl.g:3854:1: ( ( rule__Entity__PatternsAssignment_6_2_1 ) )
            {
            // InternalMetaDsl.g:3854:1: ( ( rule__Entity__PatternsAssignment_6_2_1 ) )
            // InternalMetaDsl.g:3855:2: ( rule__Entity__PatternsAssignment_6_2_1 )
            {
             before(grammarAccess.getEntityAccess().getPatternsAssignment_6_2_1()); 
            // InternalMetaDsl.g:3856:2: ( rule__Entity__PatternsAssignment_6_2_1 )
            // InternalMetaDsl.g:3856:3: rule__Entity__PatternsAssignment_6_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__PatternsAssignment_6_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getPatternsAssignment_6_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_6_2__1__Impl"


    // $ANTLR start "rule__Entity__Group_7__0"
    // InternalMetaDsl.g:3865:1: rule__Entity__Group_7__0 : rule__Entity__Group_7__0__Impl rule__Entity__Group_7__1 ;
    public final void rule__Entity__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3869:1: ( rule__Entity__Group_7__0__Impl rule__Entity__Group_7__1 )
            // InternalMetaDsl.g:3870:2: rule__Entity__Group_7__0__Impl rule__Entity__Group_7__1
            {
            pushFollow(FOLLOW_20);
            rule__Entity__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7__0"


    // $ANTLR start "rule__Entity__Group_7__0__Impl"
    // InternalMetaDsl.g:3877:1: rule__Entity__Group_7__0__Impl : ( 'STEREOTYPES' ) ;
    public final void rule__Entity__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3881:1: ( ( 'STEREOTYPES' ) )
            // InternalMetaDsl.g:3882:1: ( 'STEREOTYPES' )
            {
            // InternalMetaDsl.g:3882:1: ( 'STEREOTYPES' )
            // InternalMetaDsl.g:3883:2: 'STEREOTYPES'
            {
             before(grammarAccess.getEntityAccess().getSTEREOTYPESKeyword_7_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getSTEREOTYPESKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7__0__Impl"


    // $ANTLR start "rule__Entity__Group_7__1"
    // InternalMetaDsl.g:3892:1: rule__Entity__Group_7__1 : rule__Entity__Group_7__1__Impl rule__Entity__Group_7__2 ;
    public final void rule__Entity__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3896:1: ( rule__Entity__Group_7__1__Impl rule__Entity__Group_7__2 )
            // InternalMetaDsl.g:3897:2: rule__Entity__Group_7__1__Impl rule__Entity__Group_7__2
            {
            pushFollow(FOLLOW_37);
            rule__Entity__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7__1"


    // $ANTLR start "rule__Entity__Group_7__1__Impl"
    // InternalMetaDsl.g:3904:1: rule__Entity__Group_7__1__Impl : ( ( rule__Entity__StereotypesAssignment_7_1 ) ) ;
    public final void rule__Entity__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3908:1: ( ( ( rule__Entity__StereotypesAssignment_7_1 ) ) )
            // InternalMetaDsl.g:3909:1: ( ( rule__Entity__StereotypesAssignment_7_1 ) )
            {
            // InternalMetaDsl.g:3909:1: ( ( rule__Entity__StereotypesAssignment_7_1 ) )
            // InternalMetaDsl.g:3910:2: ( rule__Entity__StereotypesAssignment_7_1 )
            {
             before(grammarAccess.getEntityAccess().getStereotypesAssignment_7_1()); 
            // InternalMetaDsl.g:3911:2: ( rule__Entity__StereotypesAssignment_7_1 )
            // InternalMetaDsl.g:3911:3: rule__Entity__StereotypesAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__StereotypesAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getStereotypesAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7__1__Impl"


    // $ANTLR start "rule__Entity__Group_7__2"
    // InternalMetaDsl.g:3919:1: rule__Entity__Group_7__2 : rule__Entity__Group_7__2__Impl ;
    public final void rule__Entity__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3923:1: ( rule__Entity__Group_7__2__Impl )
            // InternalMetaDsl.g:3924:2: rule__Entity__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7__2"


    // $ANTLR start "rule__Entity__Group_7__2__Impl"
    // InternalMetaDsl.g:3930:1: rule__Entity__Group_7__2__Impl : ( ( rule__Entity__Group_7_2__0 )? ) ;
    public final void rule__Entity__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3934:1: ( ( ( rule__Entity__Group_7_2__0 )? ) )
            // InternalMetaDsl.g:3935:1: ( ( rule__Entity__Group_7_2__0 )? )
            {
            // InternalMetaDsl.g:3935:1: ( ( rule__Entity__Group_7_2__0 )? )
            // InternalMetaDsl.g:3936:2: ( rule__Entity__Group_7_2__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_7_2()); 
            // InternalMetaDsl.g:3937:2: ( rule__Entity__Group_7_2__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==48) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalMetaDsl.g:3937:3: rule__Entity__Group_7_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entity__Group_7_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7__2__Impl"


    // $ANTLR start "rule__Entity__Group_7_2__0"
    // InternalMetaDsl.g:3946:1: rule__Entity__Group_7_2__0 : rule__Entity__Group_7_2__0__Impl rule__Entity__Group_7_2__1 ;
    public final void rule__Entity__Group_7_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3950:1: ( rule__Entity__Group_7_2__0__Impl rule__Entity__Group_7_2__1 )
            // InternalMetaDsl.g:3951:2: rule__Entity__Group_7_2__0__Impl rule__Entity__Group_7_2__1
            {
            pushFollow(FOLLOW_20);
            rule__Entity__Group_7_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group_7_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7_2__0"


    // $ANTLR start "rule__Entity__Group_7_2__0__Impl"
    // InternalMetaDsl.g:3958:1: rule__Entity__Group_7_2__0__Impl : ( ',' ) ;
    public final void rule__Entity__Group_7_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3962:1: ( ( ',' ) )
            // InternalMetaDsl.g:3963:1: ( ',' )
            {
            // InternalMetaDsl.g:3963:1: ( ',' )
            // InternalMetaDsl.g:3964:2: ','
            {
             before(grammarAccess.getEntityAccess().getCommaKeyword_7_2_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getCommaKeyword_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7_2__0__Impl"


    // $ANTLR start "rule__Entity__Group_7_2__1"
    // InternalMetaDsl.g:3973:1: rule__Entity__Group_7_2__1 : rule__Entity__Group_7_2__1__Impl ;
    public final void rule__Entity__Group_7_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3977:1: ( rule__Entity__Group_7_2__1__Impl )
            // InternalMetaDsl.g:3978:2: rule__Entity__Group_7_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group_7_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7_2__1"


    // $ANTLR start "rule__Entity__Group_7_2__1__Impl"
    // InternalMetaDsl.g:3984:1: rule__Entity__Group_7_2__1__Impl : ( ( rule__Entity__StereotypesAssignment_7_2_1 ) ) ;
    public final void rule__Entity__Group_7_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:3988:1: ( ( ( rule__Entity__StereotypesAssignment_7_2_1 ) ) )
            // InternalMetaDsl.g:3989:1: ( ( rule__Entity__StereotypesAssignment_7_2_1 ) )
            {
            // InternalMetaDsl.g:3989:1: ( ( rule__Entity__StereotypesAssignment_7_2_1 ) )
            // InternalMetaDsl.g:3990:2: ( rule__Entity__StereotypesAssignment_7_2_1 )
            {
             before(grammarAccess.getEntityAccess().getStereotypesAssignment_7_2_1()); 
            // InternalMetaDsl.g:3991:2: ( rule__Entity__StereotypesAssignment_7_2_1 )
            // InternalMetaDsl.g:3991:3: rule__Entity__StereotypesAssignment_7_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__StereotypesAssignment_7_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getStereotypesAssignment_7_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group_7_2__1__Impl"


    // $ANTLR start "rule__SqlFileDependency__Group__0"
    // InternalMetaDsl.g:4000:1: rule__SqlFileDependency__Group__0 : rule__SqlFileDependency__Group__0__Impl rule__SqlFileDependency__Group__1 ;
    public final void rule__SqlFileDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4004:1: ( rule__SqlFileDependency__Group__0__Impl rule__SqlFileDependency__Group__1 )
            // InternalMetaDsl.g:4005:2: rule__SqlFileDependency__Group__0__Impl rule__SqlFileDependency__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__SqlFileDependency__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlFileDependency__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlFileDependency__Group__0"


    // $ANTLR start "rule__SqlFileDependency__Group__0__Impl"
    // InternalMetaDsl.g:4012:1: rule__SqlFileDependency__Group__0__Impl : ( 'SQLFILEDEPENDENCY' ) ;
    public final void rule__SqlFileDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4016:1: ( ( 'SQLFILEDEPENDENCY' ) )
            // InternalMetaDsl.g:4017:1: ( 'SQLFILEDEPENDENCY' )
            {
            // InternalMetaDsl.g:4017:1: ( 'SQLFILEDEPENDENCY' )
            // InternalMetaDsl.g:4018:2: 'SQLFILEDEPENDENCY'
            {
             before(grammarAccess.getSqlFileDependencyAccess().getSQLFILEDEPENDENCYKeyword_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getSqlFileDependencyAccess().getSQLFILEDEPENDENCYKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlFileDependency__Group__0__Impl"


    // $ANTLR start "rule__SqlFileDependency__Group__1"
    // InternalMetaDsl.g:4027:1: rule__SqlFileDependency__Group__1 : rule__SqlFileDependency__Group__1__Impl ;
    public final void rule__SqlFileDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4031:1: ( rule__SqlFileDependency__Group__1__Impl )
            // InternalMetaDsl.g:4032:2: rule__SqlFileDependency__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SqlFileDependency__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlFileDependency__Group__1"


    // $ANTLR start "rule__SqlFileDependency__Group__1__Impl"
    // InternalMetaDsl.g:4038:1: rule__SqlFileDependency__Group__1__Impl : ( ( rule__SqlFileDependency__SqlFileDependencyAssignment_1 ) ) ;
    public final void rule__SqlFileDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4042:1: ( ( ( rule__SqlFileDependency__SqlFileDependencyAssignment_1 ) ) )
            // InternalMetaDsl.g:4043:1: ( ( rule__SqlFileDependency__SqlFileDependencyAssignment_1 ) )
            {
            // InternalMetaDsl.g:4043:1: ( ( rule__SqlFileDependency__SqlFileDependencyAssignment_1 ) )
            // InternalMetaDsl.g:4044:2: ( rule__SqlFileDependency__SqlFileDependencyAssignment_1 )
            {
             before(grammarAccess.getSqlFileDependencyAccess().getSqlFileDependencyAssignment_1()); 
            // InternalMetaDsl.g:4045:2: ( rule__SqlFileDependency__SqlFileDependencyAssignment_1 )
            // InternalMetaDsl.g:4045:3: rule__SqlFileDependency__SqlFileDependencyAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SqlFileDependency__SqlFileDependencyAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSqlFileDependencyAccess().getSqlFileDependencyAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlFileDependency__Group__1__Impl"


    // $ANTLR start "rule__Sequence__Group__0"
    // InternalMetaDsl.g:4054:1: rule__Sequence__Group__0 : rule__Sequence__Group__0__Impl rule__Sequence__Group__1 ;
    public final void rule__Sequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4058:1: ( rule__Sequence__Group__0__Impl rule__Sequence__Group__1 )
            // InternalMetaDsl.g:4059:2: rule__Sequence__Group__0__Impl rule__Sequence__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Sequence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__0"


    // $ANTLR start "rule__Sequence__Group__0__Impl"
    // InternalMetaDsl.g:4066:1: rule__Sequence__Group__0__Impl : ( 'SEQUENCE' ) ;
    public final void rule__Sequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4070:1: ( ( 'SEQUENCE' ) )
            // InternalMetaDsl.g:4071:1: ( 'SEQUENCE' )
            {
            // InternalMetaDsl.g:4071:1: ( 'SEQUENCE' )
            // InternalMetaDsl.g:4072:2: 'SEQUENCE'
            {
             before(grammarAccess.getSequenceAccess().getSEQUENCEKeyword_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getSEQUENCEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__0__Impl"


    // $ANTLR start "rule__Sequence__Group__1"
    // InternalMetaDsl.g:4081:1: rule__Sequence__Group__1 : rule__Sequence__Group__1__Impl rule__Sequence__Group__2 ;
    public final void rule__Sequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4085:1: ( rule__Sequence__Group__1__Impl rule__Sequence__Group__2 )
            // InternalMetaDsl.g:4086:2: rule__Sequence__Group__1__Impl rule__Sequence__Group__2
            {
            pushFollow(FOLLOW_38);
            rule__Sequence__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__1"


    // $ANTLR start "rule__Sequence__Group__1__Impl"
    // InternalMetaDsl.g:4093:1: rule__Sequence__Group__1__Impl : ( ( rule__Sequence__NameAssignment_1 ) ) ;
    public final void rule__Sequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4097:1: ( ( ( rule__Sequence__NameAssignment_1 ) ) )
            // InternalMetaDsl.g:4098:1: ( ( rule__Sequence__NameAssignment_1 ) )
            {
            // InternalMetaDsl.g:4098:1: ( ( rule__Sequence__NameAssignment_1 ) )
            // InternalMetaDsl.g:4099:2: ( rule__Sequence__NameAssignment_1 )
            {
             before(grammarAccess.getSequenceAccess().getNameAssignment_1()); 
            // InternalMetaDsl.g:4100:2: ( rule__Sequence__NameAssignment_1 )
            // InternalMetaDsl.g:4100:3: rule__Sequence__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__1__Impl"


    // $ANTLR start "rule__Sequence__Group__2"
    // InternalMetaDsl.g:4108:1: rule__Sequence__Group__2 : rule__Sequence__Group__2__Impl rule__Sequence__Group__3 ;
    public final void rule__Sequence__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4112:1: ( rule__Sequence__Group__2__Impl rule__Sequence__Group__3 )
            // InternalMetaDsl.g:4113:2: rule__Sequence__Group__2__Impl rule__Sequence__Group__3
            {
            pushFollow(FOLLOW_38);
            rule__Sequence__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__2"


    // $ANTLR start "rule__Sequence__Group__2__Impl"
    // InternalMetaDsl.g:4120:1: rule__Sequence__Group__2__Impl : ( ( rule__Sequence__Group_2__0 )? ) ;
    public final void rule__Sequence__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4124:1: ( ( ( rule__Sequence__Group_2__0 )? ) )
            // InternalMetaDsl.g:4125:1: ( ( rule__Sequence__Group_2__0 )? )
            {
            // InternalMetaDsl.g:4125:1: ( ( rule__Sequence__Group_2__0 )? )
            // InternalMetaDsl.g:4126:2: ( rule__Sequence__Group_2__0 )?
            {
             before(grammarAccess.getSequenceAccess().getGroup_2()); 
            // InternalMetaDsl.g:4127:2: ( rule__Sequence__Group_2__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==57) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMetaDsl.g:4127:3: rule__Sequence__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Sequence__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__2__Impl"


    // $ANTLR start "rule__Sequence__Group__3"
    // InternalMetaDsl.g:4135:1: rule__Sequence__Group__3 : rule__Sequence__Group__3__Impl rule__Sequence__Group__4 ;
    public final void rule__Sequence__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4139:1: ( rule__Sequence__Group__3__Impl rule__Sequence__Group__4 )
            // InternalMetaDsl.g:4140:2: rule__Sequence__Group__3__Impl rule__Sequence__Group__4
            {
            pushFollow(FOLLOW_38);
            rule__Sequence__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__3"


    // $ANTLR start "rule__Sequence__Group__3__Impl"
    // InternalMetaDsl.g:4147:1: rule__Sequence__Group__3__Impl : ( ( rule__Sequence__Group_3__0 )? ) ;
    public final void rule__Sequence__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4151:1: ( ( ( rule__Sequence__Group_3__0 )? ) )
            // InternalMetaDsl.g:4152:1: ( ( rule__Sequence__Group_3__0 )? )
            {
            // InternalMetaDsl.g:4152:1: ( ( rule__Sequence__Group_3__0 )? )
            // InternalMetaDsl.g:4153:2: ( rule__Sequence__Group_3__0 )?
            {
             before(grammarAccess.getSequenceAccess().getGroup_3()); 
            // InternalMetaDsl.g:4154:2: ( rule__Sequence__Group_3__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==59) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalMetaDsl.g:4154:3: rule__Sequence__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Sequence__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__3__Impl"


    // $ANTLR start "rule__Sequence__Group__4"
    // InternalMetaDsl.g:4162:1: rule__Sequence__Group__4 : rule__Sequence__Group__4__Impl rule__Sequence__Group__5 ;
    public final void rule__Sequence__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4166:1: ( rule__Sequence__Group__4__Impl rule__Sequence__Group__5 )
            // InternalMetaDsl.g:4167:2: rule__Sequence__Group__4__Impl rule__Sequence__Group__5
            {
            pushFollow(FOLLOW_38);
            rule__Sequence__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__4"


    // $ANTLR start "rule__Sequence__Group__4__Impl"
    // InternalMetaDsl.g:4174:1: rule__Sequence__Group__4__Impl : ( ( rule__Sequence__Group_4__0 )? ) ;
    public final void rule__Sequence__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4178:1: ( ( ( rule__Sequence__Group_4__0 )? ) )
            // InternalMetaDsl.g:4179:1: ( ( rule__Sequence__Group_4__0 )? )
            {
            // InternalMetaDsl.g:4179:1: ( ( rule__Sequence__Group_4__0 )? )
            // InternalMetaDsl.g:4180:2: ( rule__Sequence__Group_4__0 )?
            {
             before(grammarAccess.getSequenceAccess().getGroup_4()); 
            // InternalMetaDsl.g:4181:2: ( rule__Sequence__Group_4__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==61) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalMetaDsl.g:4181:3: rule__Sequence__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Sequence__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__4__Impl"


    // $ANTLR start "rule__Sequence__Group__5"
    // InternalMetaDsl.g:4189:1: rule__Sequence__Group__5 : rule__Sequence__Group__5__Impl rule__Sequence__Group__6 ;
    public final void rule__Sequence__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4193:1: ( rule__Sequence__Group__5__Impl rule__Sequence__Group__6 )
            // InternalMetaDsl.g:4194:2: rule__Sequence__Group__5__Impl rule__Sequence__Group__6
            {
            pushFollow(FOLLOW_38);
            rule__Sequence__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__5"


    // $ANTLR start "rule__Sequence__Group__5__Impl"
    // InternalMetaDsl.g:4201:1: rule__Sequence__Group__5__Impl : ( ( rule__Sequence__Group_5__0 )? ) ;
    public final void rule__Sequence__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4205:1: ( ( ( rule__Sequence__Group_5__0 )? ) )
            // InternalMetaDsl.g:4206:1: ( ( rule__Sequence__Group_5__0 )? )
            {
            // InternalMetaDsl.g:4206:1: ( ( rule__Sequence__Group_5__0 )? )
            // InternalMetaDsl.g:4207:2: ( rule__Sequence__Group_5__0 )?
            {
             before(grammarAccess.getSequenceAccess().getGroup_5()); 
            // InternalMetaDsl.g:4208:2: ( rule__Sequence__Group_5__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==62) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalMetaDsl.g:4208:3: rule__Sequence__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Sequence__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__5__Impl"


    // $ANTLR start "rule__Sequence__Group__6"
    // InternalMetaDsl.g:4216:1: rule__Sequence__Group__6 : rule__Sequence__Group__6__Impl rule__Sequence__Group__7 ;
    public final void rule__Sequence__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4220:1: ( rule__Sequence__Group__6__Impl rule__Sequence__Group__7 )
            // InternalMetaDsl.g:4221:2: rule__Sequence__Group__6__Impl rule__Sequence__Group__7
            {
            pushFollow(FOLLOW_38);
            rule__Sequence__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__6"


    // $ANTLR start "rule__Sequence__Group__6__Impl"
    // InternalMetaDsl.g:4228:1: rule__Sequence__Group__6__Impl : ( ( rule__Sequence__CycleAssignment_6 )? ) ;
    public final void rule__Sequence__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4232:1: ( ( ( rule__Sequence__CycleAssignment_6 )? ) )
            // InternalMetaDsl.g:4233:1: ( ( rule__Sequence__CycleAssignment_6 )? )
            {
            // InternalMetaDsl.g:4233:1: ( ( rule__Sequence__CycleAssignment_6 )? )
            // InternalMetaDsl.g:4234:2: ( rule__Sequence__CycleAssignment_6 )?
            {
             before(grammarAccess.getSequenceAccess().getCycleAssignment_6()); 
            // InternalMetaDsl.g:4235:2: ( rule__Sequence__CycleAssignment_6 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==84) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalMetaDsl.g:4235:3: rule__Sequence__CycleAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__Sequence__CycleAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceAccess().getCycleAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__6__Impl"


    // $ANTLR start "rule__Sequence__Group__7"
    // InternalMetaDsl.g:4243:1: rule__Sequence__Group__7 : rule__Sequence__Group__7__Impl ;
    public final void rule__Sequence__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4247:1: ( rule__Sequence__Group__7__Impl )
            // InternalMetaDsl.g:4248:2: rule__Sequence__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__7"


    // $ANTLR start "rule__Sequence__Group__7__Impl"
    // InternalMetaDsl.g:4254:1: rule__Sequence__Group__7__Impl : ( ( rule__Sequence__Group_7__0 )? ) ;
    public final void rule__Sequence__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4258:1: ( ( ( rule__Sequence__Group_7__0 )? ) )
            // InternalMetaDsl.g:4259:1: ( ( rule__Sequence__Group_7__0 )? )
            {
            // InternalMetaDsl.g:4259:1: ( ( rule__Sequence__Group_7__0 )? )
            // InternalMetaDsl.g:4260:2: ( rule__Sequence__Group_7__0 )?
            {
             before(grammarAccess.getSequenceAccess().getGroup_7()); 
            // InternalMetaDsl.g:4261:2: ( rule__Sequence__Group_7__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==63) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalMetaDsl.g:4261:3: rule__Sequence__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Sequence__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__7__Impl"


    // $ANTLR start "rule__Sequence__Group_2__0"
    // InternalMetaDsl.g:4270:1: rule__Sequence__Group_2__0 : rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 ;
    public final void rule__Sequence__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4274:1: ( rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1 )
            // InternalMetaDsl.g:4275:2: rule__Sequence__Group_2__0__Impl rule__Sequence__Group_2__1
            {
            pushFollow(FOLLOW_39);
            rule__Sequence__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__0"


    // $ANTLR start "rule__Sequence__Group_2__0__Impl"
    // InternalMetaDsl.g:4282:1: rule__Sequence__Group_2__0__Impl : ( 'START' ) ;
    public final void rule__Sequence__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4286:1: ( ( 'START' ) )
            // InternalMetaDsl.g:4287:1: ( 'START' )
            {
            // InternalMetaDsl.g:4287:1: ( 'START' )
            // InternalMetaDsl.g:4288:2: 'START'
            {
             before(grammarAccess.getSequenceAccess().getSTARTKeyword_2_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getSTARTKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__0__Impl"


    // $ANTLR start "rule__Sequence__Group_2__1"
    // InternalMetaDsl.g:4297:1: rule__Sequence__Group_2__1 : rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 ;
    public final void rule__Sequence__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4301:1: ( rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2 )
            // InternalMetaDsl.g:4302:2: rule__Sequence__Group_2__1__Impl rule__Sequence__Group_2__2
            {
            pushFollow(FOLLOW_28);
            rule__Sequence__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__1"


    // $ANTLR start "rule__Sequence__Group_2__1__Impl"
    // InternalMetaDsl.g:4309:1: rule__Sequence__Group_2__1__Impl : ( 'WITH' ) ;
    public final void rule__Sequence__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4313:1: ( ( 'WITH' ) )
            // InternalMetaDsl.g:4314:1: ( 'WITH' )
            {
            // InternalMetaDsl.g:4314:1: ( 'WITH' )
            // InternalMetaDsl.g:4315:2: 'WITH'
            {
             before(grammarAccess.getSequenceAccess().getWITHKeyword_2_1()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getWITHKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__1__Impl"


    // $ANTLR start "rule__Sequence__Group_2__2"
    // InternalMetaDsl.g:4324:1: rule__Sequence__Group_2__2 : rule__Sequence__Group_2__2__Impl ;
    public final void rule__Sequence__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4328:1: ( rule__Sequence__Group_2__2__Impl )
            // InternalMetaDsl.g:4329:2: rule__Sequence__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__2"


    // $ANTLR start "rule__Sequence__Group_2__2__Impl"
    // InternalMetaDsl.g:4335:1: rule__Sequence__Group_2__2__Impl : ( ( rule__Sequence__StartWithAssignment_2_2 ) ) ;
    public final void rule__Sequence__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4339:1: ( ( ( rule__Sequence__StartWithAssignment_2_2 ) ) )
            // InternalMetaDsl.g:4340:1: ( ( rule__Sequence__StartWithAssignment_2_2 ) )
            {
            // InternalMetaDsl.g:4340:1: ( ( rule__Sequence__StartWithAssignment_2_2 ) )
            // InternalMetaDsl.g:4341:2: ( rule__Sequence__StartWithAssignment_2_2 )
            {
             before(grammarAccess.getSequenceAccess().getStartWithAssignment_2_2()); 
            // InternalMetaDsl.g:4342:2: ( rule__Sequence__StartWithAssignment_2_2 )
            // InternalMetaDsl.g:4342:3: rule__Sequence__StartWithAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__StartWithAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getStartWithAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_2__2__Impl"


    // $ANTLR start "rule__Sequence__Group_3__0"
    // InternalMetaDsl.g:4351:1: rule__Sequence__Group_3__0 : rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 ;
    public final void rule__Sequence__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4355:1: ( rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1 )
            // InternalMetaDsl.g:4356:2: rule__Sequence__Group_3__0__Impl rule__Sequence__Group_3__1
            {
            pushFollow(FOLLOW_40);
            rule__Sequence__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__0"


    // $ANTLR start "rule__Sequence__Group_3__0__Impl"
    // InternalMetaDsl.g:4363:1: rule__Sequence__Group_3__0__Impl : ( 'INCREMENT' ) ;
    public final void rule__Sequence__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4367:1: ( ( 'INCREMENT' ) )
            // InternalMetaDsl.g:4368:1: ( 'INCREMENT' )
            {
            // InternalMetaDsl.g:4368:1: ( 'INCREMENT' )
            // InternalMetaDsl.g:4369:2: 'INCREMENT'
            {
             before(grammarAccess.getSequenceAccess().getINCREMENTKeyword_3_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getINCREMENTKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__0__Impl"


    // $ANTLR start "rule__Sequence__Group_3__1"
    // InternalMetaDsl.g:4378:1: rule__Sequence__Group_3__1 : rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 ;
    public final void rule__Sequence__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4382:1: ( rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2 )
            // InternalMetaDsl.g:4383:2: rule__Sequence__Group_3__1__Impl rule__Sequence__Group_3__2
            {
            pushFollow(FOLLOW_28);
            rule__Sequence__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__1"


    // $ANTLR start "rule__Sequence__Group_3__1__Impl"
    // InternalMetaDsl.g:4390:1: rule__Sequence__Group_3__1__Impl : ( 'BY' ) ;
    public final void rule__Sequence__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4394:1: ( ( 'BY' ) )
            // InternalMetaDsl.g:4395:1: ( 'BY' )
            {
            // InternalMetaDsl.g:4395:1: ( 'BY' )
            // InternalMetaDsl.g:4396:2: 'BY'
            {
             before(grammarAccess.getSequenceAccess().getBYKeyword_3_1()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getBYKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__1__Impl"


    // $ANTLR start "rule__Sequence__Group_3__2"
    // InternalMetaDsl.g:4405:1: rule__Sequence__Group_3__2 : rule__Sequence__Group_3__2__Impl ;
    public final void rule__Sequence__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4409:1: ( rule__Sequence__Group_3__2__Impl )
            // InternalMetaDsl.g:4410:2: rule__Sequence__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__2"


    // $ANTLR start "rule__Sequence__Group_3__2__Impl"
    // InternalMetaDsl.g:4416:1: rule__Sequence__Group_3__2__Impl : ( ( rule__Sequence__IncrementByAssignment_3_2 ) ) ;
    public final void rule__Sequence__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4420:1: ( ( ( rule__Sequence__IncrementByAssignment_3_2 ) ) )
            // InternalMetaDsl.g:4421:1: ( ( rule__Sequence__IncrementByAssignment_3_2 ) )
            {
            // InternalMetaDsl.g:4421:1: ( ( rule__Sequence__IncrementByAssignment_3_2 ) )
            // InternalMetaDsl.g:4422:2: ( rule__Sequence__IncrementByAssignment_3_2 )
            {
             before(grammarAccess.getSequenceAccess().getIncrementByAssignment_3_2()); 
            // InternalMetaDsl.g:4423:2: ( rule__Sequence__IncrementByAssignment_3_2 )
            // InternalMetaDsl.g:4423:3: rule__Sequence__IncrementByAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__IncrementByAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getIncrementByAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_3__2__Impl"


    // $ANTLR start "rule__Sequence__Group_4__0"
    // InternalMetaDsl.g:4432:1: rule__Sequence__Group_4__0 : rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 ;
    public final void rule__Sequence__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4436:1: ( rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1 )
            // InternalMetaDsl.g:4437:2: rule__Sequence__Group_4__0__Impl rule__Sequence__Group_4__1
            {
            pushFollow(FOLLOW_28);
            rule__Sequence__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__0"


    // $ANTLR start "rule__Sequence__Group_4__0__Impl"
    // InternalMetaDsl.g:4444:1: rule__Sequence__Group_4__0__Impl : ( 'MINVALUE' ) ;
    public final void rule__Sequence__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4448:1: ( ( 'MINVALUE' ) )
            // InternalMetaDsl.g:4449:1: ( 'MINVALUE' )
            {
            // InternalMetaDsl.g:4449:1: ( 'MINVALUE' )
            // InternalMetaDsl.g:4450:2: 'MINVALUE'
            {
             before(grammarAccess.getSequenceAccess().getMINVALUEKeyword_4_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getMINVALUEKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__0__Impl"


    // $ANTLR start "rule__Sequence__Group_4__1"
    // InternalMetaDsl.g:4459:1: rule__Sequence__Group_4__1 : rule__Sequence__Group_4__1__Impl ;
    public final void rule__Sequence__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4463:1: ( rule__Sequence__Group_4__1__Impl )
            // InternalMetaDsl.g:4464:2: rule__Sequence__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__1"


    // $ANTLR start "rule__Sequence__Group_4__1__Impl"
    // InternalMetaDsl.g:4470:1: rule__Sequence__Group_4__1__Impl : ( ( rule__Sequence__MinValueAssignment_4_1 ) ) ;
    public final void rule__Sequence__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4474:1: ( ( ( rule__Sequence__MinValueAssignment_4_1 ) ) )
            // InternalMetaDsl.g:4475:1: ( ( rule__Sequence__MinValueAssignment_4_1 ) )
            {
            // InternalMetaDsl.g:4475:1: ( ( rule__Sequence__MinValueAssignment_4_1 ) )
            // InternalMetaDsl.g:4476:2: ( rule__Sequence__MinValueAssignment_4_1 )
            {
             before(grammarAccess.getSequenceAccess().getMinValueAssignment_4_1()); 
            // InternalMetaDsl.g:4477:2: ( rule__Sequence__MinValueAssignment_4_1 )
            // InternalMetaDsl.g:4477:3: rule__Sequence__MinValueAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__MinValueAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getMinValueAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_4__1__Impl"


    // $ANTLR start "rule__Sequence__Group_5__0"
    // InternalMetaDsl.g:4486:1: rule__Sequence__Group_5__0 : rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 ;
    public final void rule__Sequence__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4490:1: ( rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 )
            // InternalMetaDsl.g:4491:2: rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1
            {
            pushFollow(FOLLOW_28);
            rule__Sequence__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__0"


    // $ANTLR start "rule__Sequence__Group_5__0__Impl"
    // InternalMetaDsl.g:4498:1: rule__Sequence__Group_5__0__Impl : ( 'MAXVALUE' ) ;
    public final void rule__Sequence__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4502:1: ( ( 'MAXVALUE' ) )
            // InternalMetaDsl.g:4503:1: ( 'MAXVALUE' )
            {
            // InternalMetaDsl.g:4503:1: ( 'MAXVALUE' )
            // InternalMetaDsl.g:4504:2: 'MAXVALUE'
            {
             before(grammarAccess.getSequenceAccess().getMAXVALUEKeyword_5_0()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getMAXVALUEKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__0__Impl"


    // $ANTLR start "rule__Sequence__Group_5__1"
    // InternalMetaDsl.g:4513:1: rule__Sequence__Group_5__1 : rule__Sequence__Group_5__1__Impl ;
    public final void rule__Sequence__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4517:1: ( rule__Sequence__Group_5__1__Impl )
            // InternalMetaDsl.g:4518:2: rule__Sequence__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__1"


    // $ANTLR start "rule__Sequence__Group_5__1__Impl"
    // InternalMetaDsl.g:4524:1: rule__Sequence__Group_5__1__Impl : ( ( rule__Sequence__MaxValueAssignment_5_1 ) ) ;
    public final void rule__Sequence__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4528:1: ( ( ( rule__Sequence__MaxValueAssignment_5_1 ) ) )
            // InternalMetaDsl.g:4529:1: ( ( rule__Sequence__MaxValueAssignment_5_1 ) )
            {
            // InternalMetaDsl.g:4529:1: ( ( rule__Sequence__MaxValueAssignment_5_1 ) )
            // InternalMetaDsl.g:4530:2: ( rule__Sequence__MaxValueAssignment_5_1 )
            {
             before(grammarAccess.getSequenceAccess().getMaxValueAssignment_5_1()); 
            // InternalMetaDsl.g:4531:2: ( rule__Sequence__MaxValueAssignment_5_1 )
            // InternalMetaDsl.g:4531:3: rule__Sequence__MaxValueAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__MaxValueAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getMaxValueAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__1__Impl"


    // $ANTLR start "rule__Sequence__Group_7__0"
    // InternalMetaDsl.g:4540:1: rule__Sequence__Group_7__0 : rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 ;
    public final void rule__Sequence__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4544:1: ( rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1 )
            // InternalMetaDsl.g:4545:2: rule__Sequence__Group_7__0__Impl rule__Sequence__Group_7__1
            {
            pushFollow(FOLLOW_28);
            rule__Sequence__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__0"


    // $ANTLR start "rule__Sequence__Group_7__0__Impl"
    // InternalMetaDsl.g:4552:1: rule__Sequence__Group_7__0__Impl : ( 'CACHE' ) ;
    public final void rule__Sequence__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4556:1: ( ( 'CACHE' ) )
            // InternalMetaDsl.g:4557:1: ( 'CACHE' )
            {
            // InternalMetaDsl.g:4557:1: ( 'CACHE' )
            // InternalMetaDsl.g:4558:2: 'CACHE'
            {
             before(grammarAccess.getSequenceAccess().getCACHEKeyword_7_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getCACHEKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__0__Impl"


    // $ANTLR start "rule__Sequence__Group_7__1"
    // InternalMetaDsl.g:4567:1: rule__Sequence__Group_7__1 : rule__Sequence__Group_7__1__Impl ;
    public final void rule__Sequence__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4571:1: ( rule__Sequence__Group_7__1__Impl )
            // InternalMetaDsl.g:4572:2: rule__Sequence__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__1"


    // $ANTLR start "rule__Sequence__Group_7__1__Impl"
    // InternalMetaDsl.g:4578:1: rule__Sequence__Group_7__1__Impl : ( ( rule__Sequence__CacheAssignment_7_1 ) ) ;
    public final void rule__Sequence__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4582:1: ( ( ( rule__Sequence__CacheAssignment_7_1 ) ) )
            // InternalMetaDsl.g:4583:1: ( ( rule__Sequence__CacheAssignment_7_1 ) )
            {
            // InternalMetaDsl.g:4583:1: ( ( rule__Sequence__CacheAssignment_7_1 ) )
            // InternalMetaDsl.g:4584:2: ( rule__Sequence__CacheAssignment_7_1 )
            {
             before(grammarAccess.getSequenceAccess().getCacheAssignment_7_1()); 
            // InternalMetaDsl.g:4585:2: ( rule__Sequence__CacheAssignment_7_1 )
            // InternalMetaDsl.g:4585:3: rule__Sequence__CacheAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__CacheAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getCacheAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_7__1__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalMetaDsl.g:4594:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4598:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalMetaDsl.g:4599:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalMetaDsl.g:4606:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__UniqueAssignment_0 )? ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4610:1: ( ( ( rule__Attribute__UniqueAssignment_0 )? ) )
            // InternalMetaDsl.g:4611:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            {
            // InternalMetaDsl.g:4611:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            // InternalMetaDsl.g:4612:2: ( rule__Attribute__UniqueAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getUniqueAssignment_0()); 
            // InternalMetaDsl.g:4613:2: ( rule__Attribute__UniqueAssignment_0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==85) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalMetaDsl.g:4613:3: rule__Attribute__UniqueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__UniqueAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getUniqueAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalMetaDsl.g:4621:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4625:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalMetaDsl.g:4626:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_41);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalMetaDsl.g:4633:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__PkAssignment_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4637:1: ( ( ( rule__Attribute__PkAssignment_1 )? ) )
            // InternalMetaDsl.g:4638:1: ( ( rule__Attribute__PkAssignment_1 )? )
            {
            // InternalMetaDsl.g:4638:1: ( ( rule__Attribute__PkAssignment_1 )? )
            // InternalMetaDsl.g:4639:2: ( rule__Attribute__PkAssignment_1 )?
            {
             before(grammarAccess.getAttributeAccess().getPkAssignment_1()); 
            // InternalMetaDsl.g:4640:2: ( rule__Attribute__PkAssignment_1 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==86) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalMetaDsl.g:4640:3: rule__Attribute__PkAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__PkAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getPkAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalMetaDsl.g:4648:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4652:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalMetaDsl.g:4653:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Attribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalMetaDsl.g:4660:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__NameAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4664:1: ( ( ( rule__Attribute__NameAssignment_2 ) ) )
            // InternalMetaDsl.g:4665:1: ( ( rule__Attribute__NameAssignment_2 ) )
            {
            // InternalMetaDsl.g:4665:1: ( ( rule__Attribute__NameAssignment_2 ) )
            // InternalMetaDsl.g:4666:2: ( rule__Attribute__NameAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            // InternalMetaDsl.g:4667:2: ( rule__Attribute__NameAssignment_2 )
            // InternalMetaDsl.g:4667:3: rule__Attribute__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Attribute__Group__3"
    // InternalMetaDsl.g:4675:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4679:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // InternalMetaDsl.g:4680:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3"


    // $ANTLR start "rule__Attribute__Group__3__Impl"
    // InternalMetaDsl.g:4687:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__TypeAssignment_3 ) ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4691:1: ( ( ( rule__Attribute__TypeAssignment_3 ) ) )
            // InternalMetaDsl.g:4692:1: ( ( rule__Attribute__TypeAssignment_3 ) )
            {
            // InternalMetaDsl.g:4692:1: ( ( rule__Attribute__TypeAssignment_3 ) )
            // InternalMetaDsl.g:4693:2: ( rule__Attribute__TypeAssignment_3 )
            {
             before(grammarAccess.getAttributeAccess().getTypeAssignment_3()); 
            // InternalMetaDsl.g:4694:2: ( rule__Attribute__TypeAssignment_3 )
            // InternalMetaDsl.g:4694:3: rule__Attribute__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3__Impl"


    // $ANTLR start "rule__Attribute__Group__4"
    // InternalMetaDsl.g:4702:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl rule__Attribute__Group__5 ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4706:1: ( rule__Attribute__Group__4__Impl rule__Attribute__Group__5 )
            // InternalMetaDsl.g:4707:2: rule__Attribute__Group__4__Impl rule__Attribute__Group__5
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__4"


    // $ANTLR start "rule__Attribute__Group__4__Impl"
    // InternalMetaDsl.g:4714:1: rule__Attribute__Group__4__Impl : ( ( rule__Attribute__Group_4__0 )? ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4718:1: ( ( ( rule__Attribute__Group_4__0 )? ) )
            // InternalMetaDsl.g:4719:1: ( ( rule__Attribute__Group_4__0 )? )
            {
            // InternalMetaDsl.g:4719:1: ( ( rule__Attribute__Group_4__0 )? )
            // InternalMetaDsl.g:4720:2: ( rule__Attribute__Group_4__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_4()); 
            // InternalMetaDsl.g:4721:2: ( rule__Attribute__Group_4__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==46) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalMetaDsl.g:4721:3: rule__Attribute__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__4__Impl"


    // $ANTLR start "rule__Attribute__Group__5"
    // InternalMetaDsl.g:4729:1: rule__Attribute__Group__5 : rule__Attribute__Group__5__Impl rule__Attribute__Group__6 ;
    public final void rule__Attribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4733:1: ( rule__Attribute__Group__5__Impl rule__Attribute__Group__6 )
            // InternalMetaDsl.g:4734:2: rule__Attribute__Group__5__Impl rule__Attribute__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__5"


    // $ANTLR start "rule__Attribute__Group__5__Impl"
    // InternalMetaDsl.g:4741:1: rule__Attribute__Group__5__Impl : ( ( rule__Attribute__NotNullableAssignment_5 )? ) ;
    public final void rule__Attribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4745:1: ( ( ( rule__Attribute__NotNullableAssignment_5 )? ) )
            // InternalMetaDsl.g:4746:1: ( ( rule__Attribute__NotNullableAssignment_5 )? )
            {
            // InternalMetaDsl.g:4746:1: ( ( rule__Attribute__NotNullableAssignment_5 )? )
            // InternalMetaDsl.g:4747:2: ( rule__Attribute__NotNullableAssignment_5 )?
            {
             before(grammarAccess.getAttributeAccess().getNotNullableAssignment_5()); 
            // InternalMetaDsl.g:4748:2: ( rule__Attribute__NotNullableAssignment_5 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==87) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalMetaDsl.g:4748:3: rule__Attribute__NotNullableAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__NotNullableAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getNotNullableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__5__Impl"


    // $ANTLR start "rule__Attribute__Group__6"
    // InternalMetaDsl.g:4756:1: rule__Attribute__Group__6 : rule__Attribute__Group__6__Impl rule__Attribute__Group__7 ;
    public final void rule__Attribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4760:1: ( rule__Attribute__Group__6__Impl rule__Attribute__Group__7 )
            // InternalMetaDsl.g:4761:2: rule__Attribute__Group__6__Impl rule__Attribute__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__6"


    // $ANTLR start "rule__Attribute__Group__6__Impl"
    // InternalMetaDsl.g:4768:1: rule__Attribute__Group__6__Impl : ( ( rule__Attribute__Group_6__0 )? ) ;
    public final void rule__Attribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4772:1: ( ( ( rule__Attribute__Group_6__0 )? ) )
            // InternalMetaDsl.g:4773:1: ( ( rule__Attribute__Group_6__0 )? )
            {
            // InternalMetaDsl.g:4773:1: ( ( rule__Attribute__Group_6__0 )? )
            // InternalMetaDsl.g:4774:2: ( rule__Attribute__Group_6__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_6()); 
            // InternalMetaDsl.g:4775:2: ( rule__Attribute__Group_6__0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==64) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalMetaDsl.g:4775:3: rule__Attribute__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__6__Impl"


    // $ANTLR start "rule__Attribute__Group__7"
    // InternalMetaDsl.g:4783:1: rule__Attribute__Group__7 : rule__Attribute__Group__7__Impl rule__Attribute__Group__8 ;
    public final void rule__Attribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4787:1: ( rule__Attribute__Group__7__Impl rule__Attribute__Group__8 )
            // InternalMetaDsl.g:4788:2: rule__Attribute__Group__7__Impl rule__Attribute__Group__8
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__7"


    // $ANTLR start "rule__Attribute__Group__7__Impl"
    // InternalMetaDsl.g:4795:1: rule__Attribute__Group__7__Impl : ( ( rule__Attribute__Group_7__0 )? ) ;
    public final void rule__Attribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4799:1: ( ( ( rule__Attribute__Group_7__0 )? ) )
            // InternalMetaDsl.g:4800:1: ( ( rule__Attribute__Group_7__0 )? )
            {
            // InternalMetaDsl.g:4800:1: ( ( rule__Attribute__Group_7__0 )? )
            // InternalMetaDsl.g:4801:2: ( rule__Attribute__Group_7__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_7()); 
            // InternalMetaDsl.g:4802:2: ( rule__Attribute__Group_7__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==65) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalMetaDsl.g:4802:3: rule__Attribute__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__7__Impl"


    // $ANTLR start "rule__Attribute__Group__8"
    // InternalMetaDsl.g:4810:1: rule__Attribute__Group__8 : rule__Attribute__Group__8__Impl rule__Attribute__Group__9 ;
    public final void rule__Attribute__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4814:1: ( rule__Attribute__Group__8__Impl rule__Attribute__Group__9 )
            // InternalMetaDsl.g:4815:2: rule__Attribute__Group__8__Impl rule__Attribute__Group__9
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__8"


    // $ANTLR start "rule__Attribute__Group__8__Impl"
    // InternalMetaDsl.g:4822:1: rule__Attribute__Group__8__Impl : ( ( rule__Attribute__Group_8__0 )? ) ;
    public final void rule__Attribute__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4826:1: ( ( ( rule__Attribute__Group_8__0 )? ) )
            // InternalMetaDsl.g:4827:1: ( ( rule__Attribute__Group_8__0 )? )
            {
            // InternalMetaDsl.g:4827:1: ( ( rule__Attribute__Group_8__0 )? )
            // InternalMetaDsl.g:4828:2: ( rule__Attribute__Group_8__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_8()); 
            // InternalMetaDsl.g:4829:2: ( rule__Attribute__Group_8__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==66) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalMetaDsl.g:4829:3: rule__Attribute__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__8__Impl"


    // $ANTLR start "rule__Attribute__Group__9"
    // InternalMetaDsl.g:4837:1: rule__Attribute__Group__9 : rule__Attribute__Group__9__Impl rule__Attribute__Group__10 ;
    public final void rule__Attribute__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4841:1: ( rule__Attribute__Group__9__Impl rule__Attribute__Group__10 )
            // InternalMetaDsl.g:4842:2: rule__Attribute__Group__9__Impl rule__Attribute__Group__10
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__9"


    // $ANTLR start "rule__Attribute__Group__9__Impl"
    // InternalMetaDsl.g:4849:1: rule__Attribute__Group__9__Impl : ( ( rule__Attribute__Group_9__0 )? ) ;
    public final void rule__Attribute__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4853:1: ( ( ( rule__Attribute__Group_9__0 )? ) )
            // InternalMetaDsl.g:4854:1: ( ( rule__Attribute__Group_9__0 )? )
            {
            // InternalMetaDsl.g:4854:1: ( ( rule__Attribute__Group_9__0 )? )
            // InternalMetaDsl.g:4855:2: ( rule__Attribute__Group_9__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_9()); 
            // InternalMetaDsl.g:4856:2: ( rule__Attribute__Group_9__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==33) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalMetaDsl.g:4856:3: rule__Attribute__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__9__Impl"


    // $ANTLR start "rule__Attribute__Group__10"
    // InternalMetaDsl.g:4864:1: rule__Attribute__Group__10 : rule__Attribute__Group__10__Impl rule__Attribute__Group__11 ;
    public final void rule__Attribute__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4868:1: ( rule__Attribute__Group__10__Impl rule__Attribute__Group__11 )
            // InternalMetaDsl.g:4869:2: rule__Attribute__Group__10__Impl rule__Attribute__Group__11
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__10"


    // $ANTLR start "rule__Attribute__Group__10__Impl"
    // InternalMetaDsl.g:4876:1: rule__Attribute__Group__10__Impl : ( ( rule__Attribute__TransientAssignment_10 )? ) ;
    public final void rule__Attribute__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4880:1: ( ( ( rule__Attribute__TransientAssignment_10 )? ) )
            // InternalMetaDsl.g:4881:1: ( ( rule__Attribute__TransientAssignment_10 )? )
            {
            // InternalMetaDsl.g:4881:1: ( ( rule__Attribute__TransientAssignment_10 )? )
            // InternalMetaDsl.g:4882:2: ( rule__Attribute__TransientAssignment_10 )?
            {
             before(grammarAccess.getAttributeAccess().getTransientAssignment_10()); 
            // InternalMetaDsl.g:4883:2: ( rule__Attribute__TransientAssignment_10 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==88) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalMetaDsl.g:4883:3: rule__Attribute__TransientAssignment_10
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__TransientAssignment_10();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getTransientAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__10__Impl"


    // $ANTLR start "rule__Attribute__Group__11"
    // InternalMetaDsl.g:4891:1: rule__Attribute__Group__11 : rule__Attribute__Group__11__Impl rule__Attribute__Group__12 ;
    public final void rule__Attribute__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4895:1: ( rule__Attribute__Group__11__Impl rule__Attribute__Group__12 )
            // InternalMetaDsl.g:4896:2: rule__Attribute__Group__11__Impl rule__Attribute__Group__12
            {
            pushFollow(FOLLOW_42);
            rule__Attribute__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__11"


    // $ANTLR start "rule__Attribute__Group__11__Impl"
    // InternalMetaDsl.g:4903:1: rule__Attribute__Group__11__Impl : ( ( rule__Attribute__Group_11__0 )? ) ;
    public final void rule__Attribute__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4907:1: ( ( ( rule__Attribute__Group_11__0 )? ) )
            // InternalMetaDsl.g:4908:1: ( ( rule__Attribute__Group_11__0 )? )
            {
            // InternalMetaDsl.g:4908:1: ( ( rule__Attribute__Group_11__0 )? )
            // InternalMetaDsl.g:4909:2: ( rule__Attribute__Group_11__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_11()); 
            // InternalMetaDsl.g:4910:2: ( rule__Attribute__Group_11__0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==55) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalMetaDsl.g:4910:3: rule__Attribute__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__11__Impl"


    // $ANTLR start "rule__Attribute__Group__12"
    // InternalMetaDsl.g:4918:1: rule__Attribute__Group__12 : rule__Attribute__Group__12__Impl ;
    public final void rule__Attribute__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4922:1: ( rule__Attribute__Group__12__Impl )
            // InternalMetaDsl.g:4923:2: rule__Attribute__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__12"


    // $ANTLR start "rule__Attribute__Group__12__Impl"
    // InternalMetaDsl.g:4929:1: rule__Attribute__Group__12__Impl : ( ( rule__Attribute__IdGeneratorAssignment_12 )? ) ;
    public final void rule__Attribute__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4933:1: ( ( ( rule__Attribute__IdGeneratorAssignment_12 )? ) )
            // InternalMetaDsl.g:4934:1: ( ( rule__Attribute__IdGeneratorAssignment_12 )? )
            {
            // InternalMetaDsl.g:4934:1: ( ( rule__Attribute__IdGeneratorAssignment_12 )? )
            // InternalMetaDsl.g:4935:2: ( rule__Attribute__IdGeneratorAssignment_12 )?
            {
             before(grammarAccess.getAttributeAccess().getIdGeneratorAssignment_12()); 
            // InternalMetaDsl.g:4936:2: ( rule__Attribute__IdGeneratorAssignment_12 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==67) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalMetaDsl.g:4936:3: rule__Attribute__IdGeneratorAssignment_12
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__IdGeneratorAssignment_12();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getIdGeneratorAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__12__Impl"


    // $ANTLR start "rule__Attribute__Group_4__0"
    // InternalMetaDsl.g:4945:1: rule__Attribute__Group_4__0 : rule__Attribute__Group_4__0__Impl rule__Attribute__Group_4__1 ;
    public final void rule__Attribute__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4949:1: ( rule__Attribute__Group_4__0__Impl rule__Attribute__Group_4__1 )
            // InternalMetaDsl.g:4950:2: rule__Attribute__Group_4__0__Impl rule__Attribute__Group_4__1
            {
            pushFollow(FOLLOW_26);
            rule__Attribute__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4__0"


    // $ANTLR start "rule__Attribute__Group_4__0__Impl"
    // InternalMetaDsl.g:4957:1: rule__Attribute__Group_4__0__Impl : ( '(' ) ;
    public final void rule__Attribute__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4961:1: ( ( '(' ) )
            // InternalMetaDsl.g:4962:1: ( '(' )
            {
            // InternalMetaDsl.g:4962:1: ( '(' )
            // InternalMetaDsl.g:4963:2: '('
            {
             before(grammarAccess.getAttributeAccess().getLeftParenthesisKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getLeftParenthesisKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4__0__Impl"


    // $ANTLR start "rule__Attribute__Group_4__1"
    // InternalMetaDsl.g:4972:1: rule__Attribute__Group_4__1 : rule__Attribute__Group_4__1__Impl rule__Attribute__Group_4__2 ;
    public final void rule__Attribute__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4976:1: ( rule__Attribute__Group_4__1__Impl rule__Attribute__Group_4__2 )
            // InternalMetaDsl.g:4977:2: rule__Attribute__Group_4__1__Impl rule__Attribute__Group_4__2
            {
            pushFollow(FOLLOW_27);
            rule__Attribute__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4__1"


    // $ANTLR start "rule__Attribute__Group_4__1__Impl"
    // InternalMetaDsl.g:4984:1: rule__Attribute__Group_4__1__Impl : ( ( rule__Attribute__Alternatives_4_1 ) ) ;
    public final void rule__Attribute__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:4988:1: ( ( ( rule__Attribute__Alternatives_4_1 ) ) )
            // InternalMetaDsl.g:4989:1: ( ( rule__Attribute__Alternatives_4_1 ) )
            {
            // InternalMetaDsl.g:4989:1: ( ( rule__Attribute__Alternatives_4_1 ) )
            // InternalMetaDsl.g:4990:2: ( rule__Attribute__Alternatives_4_1 )
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_4_1()); 
            // InternalMetaDsl.g:4991:2: ( rule__Attribute__Alternatives_4_1 )
            // InternalMetaDsl.g:4991:3: rule__Attribute__Alternatives_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Alternatives_4_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getAlternatives_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4__1__Impl"


    // $ANTLR start "rule__Attribute__Group_4__2"
    // InternalMetaDsl.g:4999:1: rule__Attribute__Group_4__2 : rule__Attribute__Group_4__2__Impl rule__Attribute__Group_4__3 ;
    public final void rule__Attribute__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5003:1: ( rule__Attribute__Group_4__2__Impl rule__Attribute__Group_4__3 )
            // InternalMetaDsl.g:5004:2: rule__Attribute__Group_4__2__Impl rule__Attribute__Group_4__3
            {
            pushFollow(FOLLOW_27);
            rule__Attribute__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4__2"


    // $ANTLR start "rule__Attribute__Group_4__2__Impl"
    // InternalMetaDsl.g:5011:1: rule__Attribute__Group_4__2__Impl : ( ( rule__Attribute__Group_4_2__0 )? ) ;
    public final void rule__Attribute__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5015:1: ( ( ( rule__Attribute__Group_4_2__0 )? ) )
            // InternalMetaDsl.g:5016:1: ( ( rule__Attribute__Group_4_2__0 )? )
            {
            // InternalMetaDsl.g:5016:1: ( ( rule__Attribute__Group_4_2__0 )? )
            // InternalMetaDsl.g:5017:2: ( rule__Attribute__Group_4_2__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_4_2()); 
            // InternalMetaDsl.g:5018:2: ( rule__Attribute__Group_4_2__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==48) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalMetaDsl.g:5018:3: rule__Attribute__Group_4_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_4_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4__2__Impl"


    // $ANTLR start "rule__Attribute__Group_4__3"
    // InternalMetaDsl.g:5026:1: rule__Attribute__Group_4__3 : rule__Attribute__Group_4__3__Impl ;
    public final void rule__Attribute__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5030:1: ( rule__Attribute__Group_4__3__Impl )
            // InternalMetaDsl.g:5031:2: rule__Attribute__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4__3"


    // $ANTLR start "rule__Attribute__Group_4__3__Impl"
    // InternalMetaDsl.g:5037:1: rule__Attribute__Group_4__3__Impl : ( ')' ) ;
    public final void rule__Attribute__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5041:1: ( ( ')' ) )
            // InternalMetaDsl.g:5042:1: ( ')' )
            {
            // InternalMetaDsl.g:5042:1: ( ')' )
            // InternalMetaDsl.g:5043:2: ')'
            {
             before(grammarAccess.getAttributeAccess().getRightParenthesisKeyword_4_3()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getRightParenthesisKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4__3__Impl"


    // $ANTLR start "rule__Attribute__Group_4_2__0"
    // InternalMetaDsl.g:5053:1: rule__Attribute__Group_4_2__0 : rule__Attribute__Group_4_2__0__Impl rule__Attribute__Group_4_2__1 ;
    public final void rule__Attribute__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5057:1: ( rule__Attribute__Group_4_2__0__Impl rule__Attribute__Group_4_2__1 )
            // InternalMetaDsl.g:5058:2: rule__Attribute__Group_4_2__0__Impl rule__Attribute__Group_4_2__1
            {
            pushFollow(FOLLOW_28);
            rule__Attribute__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4_2__0"


    // $ANTLR start "rule__Attribute__Group_4_2__0__Impl"
    // InternalMetaDsl.g:5065:1: rule__Attribute__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Attribute__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5069:1: ( ( ',' ) )
            // InternalMetaDsl.g:5070:1: ( ',' )
            {
            // InternalMetaDsl.g:5070:1: ( ',' )
            // InternalMetaDsl.g:5071:2: ','
            {
             before(grammarAccess.getAttributeAccess().getCommaKeyword_4_2_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4_2__0__Impl"


    // $ANTLR start "rule__Attribute__Group_4_2__1"
    // InternalMetaDsl.g:5080:1: rule__Attribute__Group_4_2__1 : rule__Attribute__Group_4_2__1__Impl ;
    public final void rule__Attribute__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5084:1: ( rule__Attribute__Group_4_2__1__Impl )
            // InternalMetaDsl.g:5085:2: rule__Attribute__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4_2__1"


    // $ANTLR start "rule__Attribute__Group_4_2__1__Impl"
    // InternalMetaDsl.g:5091:1: rule__Attribute__Group_4_2__1__Impl : ( ( rule__Attribute__ScaleAssignment_4_2_1 ) ) ;
    public final void rule__Attribute__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5095:1: ( ( ( rule__Attribute__ScaleAssignment_4_2_1 ) ) )
            // InternalMetaDsl.g:5096:1: ( ( rule__Attribute__ScaleAssignment_4_2_1 ) )
            {
            // InternalMetaDsl.g:5096:1: ( ( rule__Attribute__ScaleAssignment_4_2_1 ) )
            // InternalMetaDsl.g:5097:2: ( rule__Attribute__ScaleAssignment_4_2_1 )
            {
             before(grammarAccess.getAttributeAccess().getScaleAssignment_4_2_1()); 
            // InternalMetaDsl.g:5098:2: ( rule__Attribute__ScaleAssignment_4_2_1 )
            // InternalMetaDsl.g:5098:3: rule__Attribute__ScaleAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__ScaleAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getScaleAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_4_2__1__Impl"


    // $ANTLR start "rule__Attribute__Group_6__0"
    // InternalMetaDsl.g:5107:1: rule__Attribute__Group_6__0 : rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 ;
    public final void rule__Attribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5111:1: ( rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 )
            // InternalMetaDsl.g:5112:2: rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1
            {
            pushFollow(FOLLOW_20);
            rule__Attribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_6__0"


    // $ANTLR start "rule__Attribute__Group_6__0__Impl"
    // InternalMetaDsl.g:5119:1: rule__Attribute__Group_6__0__Impl : ( 'SAMEAS' ) ;
    public final void rule__Attribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5123:1: ( ( 'SAMEAS' ) )
            // InternalMetaDsl.g:5124:1: ( 'SAMEAS' )
            {
            // InternalMetaDsl.g:5124:1: ( 'SAMEAS' )
            // InternalMetaDsl.g:5125:2: 'SAMEAS'
            {
             before(grammarAccess.getAttributeAccess().getSAMEASKeyword_6_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getSAMEASKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_6__0__Impl"


    // $ANTLR start "rule__Attribute__Group_6__1"
    // InternalMetaDsl.g:5134:1: rule__Attribute__Group_6__1 : rule__Attribute__Group_6__1__Impl ;
    public final void rule__Attribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5138:1: ( rule__Attribute__Group_6__1__Impl )
            // InternalMetaDsl.g:5139:2: rule__Attribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_6__1"


    // $ANTLR start "rule__Attribute__Group_6__1__Impl"
    // InternalMetaDsl.g:5145:1: rule__Attribute__Group_6__1__Impl : ( ( rule__Attribute__SameAsAttributeAssignment_6_1 ) ) ;
    public final void rule__Attribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5149:1: ( ( ( rule__Attribute__SameAsAttributeAssignment_6_1 ) ) )
            // InternalMetaDsl.g:5150:1: ( ( rule__Attribute__SameAsAttributeAssignment_6_1 ) )
            {
            // InternalMetaDsl.g:5150:1: ( ( rule__Attribute__SameAsAttributeAssignment_6_1 ) )
            // InternalMetaDsl.g:5151:2: ( rule__Attribute__SameAsAttributeAssignment_6_1 )
            {
             before(grammarAccess.getAttributeAccess().getSameAsAttributeAssignment_6_1()); 
            // InternalMetaDsl.g:5152:2: ( rule__Attribute__SameAsAttributeAssignment_6_1 )
            // InternalMetaDsl.g:5152:3: rule__Attribute__SameAsAttributeAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__SameAsAttributeAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getSameAsAttributeAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_6__1__Impl"


    // $ANTLR start "rule__Attribute__Group_7__0"
    // InternalMetaDsl.g:5161:1: rule__Attribute__Group_7__0 : rule__Attribute__Group_7__0__Impl rule__Attribute__Group_7__1 ;
    public final void rule__Attribute__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5165:1: ( rule__Attribute__Group_7__0__Impl rule__Attribute__Group_7__1 )
            // InternalMetaDsl.g:5166:2: rule__Attribute__Group_7__0__Impl rule__Attribute__Group_7__1
            {
            pushFollow(FOLLOW_20);
            rule__Attribute__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_7__0"


    // $ANTLR start "rule__Attribute__Group_7__0__Impl"
    // InternalMetaDsl.g:5173:1: rule__Attribute__Group_7__0__Impl : ( 'FKTO' ) ;
    public final void rule__Attribute__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5177:1: ( ( 'FKTO' ) )
            // InternalMetaDsl.g:5178:1: ( 'FKTO' )
            {
            // InternalMetaDsl.g:5178:1: ( 'FKTO' )
            // InternalMetaDsl.g:5179:2: 'FKTO'
            {
             before(grammarAccess.getAttributeAccess().getFKTOKeyword_7_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getFKTOKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_7__0__Impl"


    // $ANTLR start "rule__Attribute__Group_7__1"
    // InternalMetaDsl.g:5188:1: rule__Attribute__Group_7__1 : rule__Attribute__Group_7__1__Impl ;
    public final void rule__Attribute__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5192:1: ( rule__Attribute__Group_7__1__Impl )
            // InternalMetaDsl.g:5193:2: rule__Attribute__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_7__1"


    // $ANTLR start "rule__Attribute__Group_7__1__Impl"
    // InternalMetaDsl.g:5199:1: rule__Attribute__Group_7__1__Impl : ( ( rule__Attribute__FktoAssignment_7_1 ) ) ;
    public final void rule__Attribute__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5203:1: ( ( ( rule__Attribute__FktoAssignment_7_1 ) ) )
            // InternalMetaDsl.g:5204:1: ( ( rule__Attribute__FktoAssignment_7_1 ) )
            {
            // InternalMetaDsl.g:5204:1: ( ( rule__Attribute__FktoAssignment_7_1 ) )
            // InternalMetaDsl.g:5205:2: ( rule__Attribute__FktoAssignment_7_1 )
            {
             before(grammarAccess.getAttributeAccess().getFktoAssignment_7_1()); 
            // InternalMetaDsl.g:5206:2: ( rule__Attribute__FktoAssignment_7_1 )
            // InternalMetaDsl.g:5206:3: rule__Attribute__FktoAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__FktoAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getFktoAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_7__1__Impl"


    // $ANTLR start "rule__Attribute__Group_8__0"
    // InternalMetaDsl.g:5215:1: rule__Attribute__Group_8__0 : rule__Attribute__Group_8__0__Impl rule__Attribute__Group_8__1 ;
    public final void rule__Attribute__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5219:1: ( rule__Attribute__Group_8__0__Impl rule__Attribute__Group_8__1 )
            // InternalMetaDsl.g:5220:2: rule__Attribute__Group_8__0__Impl rule__Attribute__Group_8__1
            {
            pushFollow(FOLLOW_20);
            rule__Attribute__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_8__0"


    // $ANTLR start "rule__Attribute__Group_8__0__Impl"
    // InternalMetaDsl.g:5227:1: rule__Attribute__Group_8__0__Impl : ( 'MULTIREFTO' ) ;
    public final void rule__Attribute__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5231:1: ( ( 'MULTIREFTO' ) )
            // InternalMetaDsl.g:5232:1: ( 'MULTIREFTO' )
            {
            // InternalMetaDsl.g:5232:1: ( 'MULTIREFTO' )
            // InternalMetaDsl.g:5233:2: 'MULTIREFTO'
            {
             before(grammarAccess.getAttributeAccess().getMULTIREFTOKeyword_8_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getMULTIREFTOKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_8__0__Impl"


    // $ANTLR start "rule__Attribute__Group_8__1"
    // InternalMetaDsl.g:5242:1: rule__Attribute__Group_8__1 : rule__Attribute__Group_8__1__Impl ;
    public final void rule__Attribute__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5246:1: ( rule__Attribute__Group_8__1__Impl )
            // InternalMetaDsl.g:5247:2: rule__Attribute__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_8__1"


    // $ANTLR start "rule__Attribute__Group_8__1__Impl"
    // InternalMetaDsl.g:5253:1: rule__Attribute__Group_8__1__Impl : ( ( rule__Attribute__MultiRefToAssignment_8_1 ) ) ;
    public final void rule__Attribute__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5257:1: ( ( ( rule__Attribute__MultiRefToAssignment_8_1 ) ) )
            // InternalMetaDsl.g:5258:1: ( ( rule__Attribute__MultiRefToAssignment_8_1 ) )
            {
            // InternalMetaDsl.g:5258:1: ( ( rule__Attribute__MultiRefToAssignment_8_1 ) )
            // InternalMetaDsl.g:5259:2: ( rule__Attribute__MultiRefToAssignment_8_1 )
            {
             before(grammarAccess.getAttributeAccess().getMultiRefToAssignment_8_1()); 
            // InternalMetaDsl.g:5260:2: ( rule__Attribute__MultiRefToAssignment_8_1 )
            // InternalMetaDsl.g:5260:3: rule__Attribute__MultiRefToAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__MultiRefToAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getMultiRefToAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_8__1__Impl"


    // $ANTLR start "rule__Attribute__Group_9__0"
    // InternalMetaDsl.g:5269:1: rule__Attribute__Group_9__0 : rule__Attribute__Group_9__0__Impl rule__Attribute__Group_9__1 ;
    public final void rule__Attribute__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5273:1: ( rule__Attribute__Group_9__0__Impl rule__Attribute__Group_9__1 )
            // InternalMetaDsl.g:5274:2: rule__Attribute__Group_9__0__Impl rule__Attribute__Group_9__1
            {
            pushFollow(FOLLOW_43);
            rule__Attribute__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_9__0"


    // $ANTLR start "rule__Attribute__Group_9__0__Impl"
    // InternalMetaDsl.g:5281:1: rule__Attribute__Group_9__0__Impl : ( 'DEFAULT' ) ;
    public final void rule__Attribute__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5285:1: ( ( 'DEFAULT' ) )
            // InternalMetaDsl.g:5286:1: ( 'DEFAULT' )
            {
            // InternalMetaDsl.g:5286:1: ( 'DEFAULT' )
            // InternalMetaDsl.g:5287:2: 'DEFAULT'
            {
             before(grammarAccess.getAttributeAccess().getDEFAULTKeyword_9_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getDEFAULTKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_9__0__Impl"


    // $ANTLR start "rule__Attribute__Group_9__1"
    // InternalMetaDsl.g:5296:1: rule__Attribute__Group_9__1 : rule__Attribute__Group_9__1__Impl ;
    public final void rule__Attribute__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5300:1: ( rule__Attribute__Group_9__1__Impl )
            // InternalMetaDsl.g:5301:2: rule__Attribute__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_9__1"


    // $ANTLR start "rule__Attribute__Group_9__1__Impl"
    // InternalMetaDsl.g:5307:1: rule__Attribute__Group_9__1__Impl : ( ( rule__Attribute__Alternatives_9_1 ) ) ;
    public final void rule__Attribute__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5311:1: ( ( ( rule__Attribute__Alternatives_9_1 ) ) )
            // InternalMetaDsl.g:5312:1: ( ( rule__Attribute__Alternatives_9_1 ) )
            {
            // InternalMetaDsl.g:5312:1: ( ( rule__Attribute__Alternatives_9_1 ) )
            // InternalMetaDsl.g:5313:2: ( rule__Attribute__Alternatives_9_1 )
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_9_1()); 
            // InternalMetaDsl.g:5314:2: ( rule__Attribute__Alternatives_9_1 )
            // InternalMetaDsl.g:5314:3: rule__Attribute__Alternatives_9_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Alternatives_9_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getAlternatives_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_9__1__Impl"


    // $ANTLR start "rule__Attribute__Group_11__0"
    // InternalMetaDsl.g:5323:1: rule__Attribute__Group_11__0 : rule__Attribute__Group_11__0__Impl rule__Attribute__Group_11__1 ;
    public final void rule__Attribute__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5327:1: ( rule__Attribute__Group_11__0__Impl rule__Attribute__Group_11__1 )
            // InternalMetaDsl.g:5328:2: rule__Attribute__Group_11__0__Impl rule__Attribute__Group_11__1
            {
            pushFollow(FOLLOW_20);
            rule__Attribute__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11__0"


    // $ANTLR start "rule__Attribute__Group_11__0__Impl"
    // InternalMetaDsl.g:5335:1: rule__Attribute__Group_11__0__Impl : ( 'STEREOTYPES' ) ;
    public final void rule__Attribute__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5339:1: ( ( 'STEREOTYPES' ) )
            // InternalMetaDsl.g:5340:1: ( 'STEREOTYPES' )
            {
            // InternalMetaDsl.g:5340:1: ( 'STEREOTYPES' )
            // InternalMetaDsl.g:5341:2: 'STEREOTYPES'
            {
             before(grammarAccess.getAttributeAccess().getSTEREOTYPESKeyword_11_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getSTEREOTYPESKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11__0__Impl"


    // $ANTLR start "rule__Attribute__Group_11__1"
    // InternalMetaDsl.g:5350:1: rule__Attribute__Group_11__1 : rule__Attribute__Group_11__1__Impl rule__Attribute__Group_11__2 ;
    public final void rule__Attribute__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5354:1: ( rule__Attribute__Group_11__1__Impl rule__Attribute__Group_11__2 )
            // InternalMetaDsl.g:5355:2: rule__Attribute__Group_11__1__Impl rule__Attribute__Group_11__2
            {
            pushFollow(FOLLOW_37);
            rule__Attribute__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11__1"


    // $ANTLR start "rule__Attribute__Group_11__1__Impl"
    // InternalMetaDsl.g:5362:1: rule__Attribute__Group_11__1__Impl : ( ( rule__Attribute__StereotypesAssignment_11_1 ) ) ;
    public final void rule__Attribute__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5366:1: ( ( ( rule__Attribute__StereotypesAssignment_11_1 ) ) )
            // InternalMetaDsl.g:5367:1: ( ( rule__Attribute__StereotypesAssignment_11_1 ) )
            {
            // InternalMetaDsl.g:5367:1: ( ( rule__Attribute__StereotypesAssignment_11_1 ) )
            // InternalMetaDsl.g:5368:2: ( rule__Attribute__StereotypesAssignment_11_1 )
            {
             before(grammarAccess.getAttributeAccess().getStereotypesAssignment_11_1()); 
            // InternalMetaDsl.g:5369:2: ( rule__Attribute__StereotypesAssignment_11_1 )
            // InternalMetaDsl.g:5369:3: rule__Attribute__StereotypesAssignment_11_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__StereotypesAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getStereotypesAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11__1__Impl"


    // $ANTLR start "rule__Attribute__Group_11__2"
    // InternalMetaDsl.g:5377:1: rule__Attribute__Group_11__2 : rule__Attribute__Group_11__2__Impl ;
    public final void rule__Attribute__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5381:1: ( rule__Attribute__Group_11__2__Impl )
            // InternalMetaDsl.g:5382:2: rule__Attribute__Group_11__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_11__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11__2"


    // $ANTLR start "rule__Attribute__Group_11__2__Impl"
    // InternalMetaDsl.g:5388:1: rule__Attribute__Group_11__2__Impl : ( ( rule__Attribute__Group_11_2__0 )? ) ;
    public final void rule__Attribute__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5392:1: ( ( ( rule__Attribute__Group_11_2__0 )? ) )
            // InternalMetaDsl.g:5393:1: ( ( rule__Attribute__Group_11_2__0 )? )
            {
            // InternalMetaDsl.g:5393:1: ( ( rule__Attribute__Group_11_2__0 )? )
            // InternalMetaDsl.g:5394:2: ( rule__Attribute__Group_11_2__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_11_2()); 
            // InternalMetaDsl.g:5395:2: ( rule__Attribute__Group_11_2__0 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==48) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalMetaDsl.g:5395:3: rule__Attribute__Group_11_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_11_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11__2__Impl"


    // $ANTLR start "rule__Attribute__Group_11_2__0"
    // InternalMetaDsl.g:5404:1: rule__Attribute__Group_11_2__0 : rule__Attribute__Group_11_2__0__Impl rule__Attribute__Group_11_2__1 ;
    public final void rule__Attribute__Group_11_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5408:1: ( rule__Attribute__Group_11_2__0__Impl rule__Attribute__Group_11_2__1 )
            // InternalMetaDsl.g:5409:2: rule__Attribute__Group_11_2__0__Impl rule__Attribute__Group_11_2__1
            {
            pushFollow(FOLLOW_20);
            rule__Attribute__Group_11_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_11_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11_2__0"


    // $ANTLR start "rule__Attribute__Group_11_2__0__Impl"
    // InternalMetaDsl.g:5416:1: rule__Attribute__Group_11_2__0__Impl : ( ',' ) ;
    public final void rule__Attribute__Group_11_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5420:1: ( ( ',' ) )
            // InternalMetaDsl.g:5421:1: ( ',' )
            {
            // InternalMetaDsl.g:5421:1: ( ',' )
            // InternalMetaDsl.g:5422:2: ','
            {
             before(grammarAccess.getAttributeAccess().getCommaKeyword_11_2_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getCommaKeyword_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11_2__0__Impl"


    // $ANTLR start "rule__Attribute__Group_11_2__1"
    // InternalMetaDsl.g:5431:1: rule__Attribute__Group_11_2__1 : rule__Attribute__Group_11_2__1__Impl ;
    public final void rule__Attribute__Group_11_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5435:1: ( rule__Attribute__Group_11_2__1__Impl )
            // InternalMetaDsl.g:5436:2: rule__Attribute__Group_11_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_11_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11_2__1"


    // $ANTLR start "rule__Attribute__Group_11_2__1__Impl"
    // InternalMetaDsl.g:5442:1: rule__Attribute__Group_11_2__1__Impl : ( ( rule__Attribute__StereotypesAssignment_11_2_1 ) ) ;
    public final void rule__Attribute__Group_11_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5446:1: ( ( ( rule__Attribute__StereotypesAssignment_11_2_1 ) ) )
            // InternalMetaDsl.g:5447:1: ( ( rule__Attribute__StereotypesAssignment_11_2_1 ) )
            {
            // InternalMetaDsl.g:5447:1: ( ( rule__Attribute__StereotypesAssignment_11_2_1 ) )
            // InternalMetaDsl.g:5448:2: ( rule__Attribute__StereotypesAssignment_11_2_1 )
            {
             before(grammarAccess.getAttributeAccess().getStereotypesAssignment_11_2_1()); 
            // InternalMetaDsl.g:5449:2: ( rule__Attribute__StereotypesAssignment_11_2_1 )
            // InternalMetaDsl.g:5449:3: rule__Attribute__StereotypesAssignment_11_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__StereotypesAssignment_11_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getStereotypesAssignment_11_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_11_2__1__Impl"


    // $ANTLR start "rule__IdGenerator__Group__0"
    // InternalMetaDsl.g:5458:1: rule__IdGenerator__Group__0 : rule__IdGenerator__Group__0__Impl rule__IdGenerator__Group__1 ;
    public final void rule__IdGenerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5462:1: ( rule__IdGenerator__Group__0__Impl rule__IdGenerator__Group__1 )
            // InternalMetaDsl.g:5463:2: rule__IdGenerator__Group__0__Impl rule__IdGenerator__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__IdGenerator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdGenerator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGenerator__Group__0"


    // $ANTLR start "rule__IdGenerator__Group__0__Impl"
    // InternalMetaDsl.g:5470:1: rule__IdGenerator__Group__0__Impl : ( 'IDGENERATOR' ) ;
    public final void rule__IdGenerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5474:1: ( ( 'IDGENERATOR' ) )
            // InternalMetaDsl.g:5475:1: ( 'IDGENERATOR' )
            {
            // InternalMetaDsl.g:5475:1: ( 'IDGENERATOR' )
            // InternalMetaDsl.g:5476:2: 'IDGENERATOR'
            {
             before(grammarAccess.getIdGeneratorAccess().getIDGENERATORKeyword_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getIdGeneratorAccess().getIDGENERATORKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGenerator__Group__0__Impl"


    // $ANTLR start "rule__IdGenerator__Group__1"
    // InternalMetaDsl.g:5485:1: rule__IdGenerator__Group__1 : rule__IdGenerator__Group__1__Impl rule__IdGenerator__Group__2 ;
    public final void rule__IdGenerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5489:1: ( rule__IdGenerator__Group__1__Impl rule__IdGenerator__Group__2 )
            // InternalMetaDsl.g:5490:2: rule__IdGenerator__Group__1__Impl rule__IdGenerator__Group__2
            {
            pushFollow(FOLLOW_44);
            rule__IdGenerator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdGenerator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGenerator__Group__1"


    // $ANTLR start "rule__IdGenerator__Group__1__Impl"
    // InternalMetaDsl.g:5497:1: rule__IdGenerator__Group__1__Impl : ( ( rule__IdGenerator__AttributeAssignment_1 ) ) ;
    public final void rule__IdGenerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5501:1: ( ( ( rule__IdGenerator__AttributeAssignment_1 ) ) )
            // InternalMetaDsl.g:5502:1: ( ( rule__IdGenerator__AttributeAssignment_1 ) )
            {
            // InternalMetaDsl.g:5502:1: ( ( rule__IdGenerator__AttributeAssignment_1 ) )
            // InternalMetaDsl.g:5503:2: ( rule__IdGenerator__AttributeAssignment_1 )
            {
             before(grammarAccess.getIdGeneratorAccess().getAttributeAssignment_1()); 
            // InternalMetaDsl.g:5504:2: ( rule__IdGenerator__AttributeAssignment_1 )
            // InternalMetaDsl.g:5504:3: rule__IdGenerator__AttributeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IdGenerator__AttributeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorAccess().getAttributeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGenerator__Group__1__Impl"


    // $ANTLR start "rule__IdGenerator__Group__2"
    // InternalMetaDsl.g:5512:1: rule__IdGenerator__Group__2 : rule__IdGenerator__Group__2__Impl ;
    public final void rule__IdGenerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5516:1: ( rule__IdGenerator__Group__2__Impl )
            // InternalMetaDsl.g:5517:2: rule__IdGenerator__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IdGenerator__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGenerator__Group__2"


    // $ANTLR start "rule__IdGenerator__Group__2__Impl"
    // InternalMetaDsl.g:5523:1: rule__IdGenerator__Group__2__Impl : ( ( rule__IdGenerator__TypeBlockAssignment_2 ) ) ;
    public final void rule__IdGenerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5527:1: ( ( ( rule__IdGenerator__TypeBlockAssignment_2 ) ) )
            // InternalMetaDsl.g:5528:1: ( ( rule__IdGenerator__TypeBlockAssignment_2 ) )
            {
            // InternalMetaDsl.g:5528:1: ( ( rule__IdGenerator__TypeBlockAssignment_2 ) )
            // InternalMetaDsl.g:5529:2: ( rule__IdGenerator__TypeBlockAssignment_2 )
            {
             before(grammarAccess.getIdGeneratorAccess().getTypeBlockAssignment_2()); 
            // InternalMetaDsl.g:5530:2: ( rule__IdGenerator__TypeBlockAssignment_2 )
            // InternalMetaDsl.g:5530:3: rule__IdGenerator__TypeBlockAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IdGenerator__TypeBlockAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorAccess().getTypeBlockAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGenerator__Group__2__Impl"


    // $ANTLR start "rule__IdGeneratorSimple__Group_0__0"
    // InternalMetaDsl.g:5539:1: rule__IdGeneratorSimple__Group_0__0 : rule__IdGeneratorSimple__Group_0__0__Impl rule__IdGeneratorSimple__Group_0__1 ;
    public final void rule__IdGeneratorSimple__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5543:1: ( rule__IdGeneratorSimple__Group_0__0__Impl rule__IdGeneratorSimple__Group_0__1 )
            // InternalMetaDsl.g:5544:2: rule__IdGeneratorSimple__Group_0__0__Impl rule__IdGeneratorSimple__Group_0__1
            {
            pushFollow(FOLLOW_45);
            rule__IdGeneratorSimple__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdGeneratorSimple__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSimple__Group_0__0"


    // $ANTLR start "rule__IdGeneratorSimple__Group_0__0__Impl"
    // InternalMetaDsl.g:5551:1: rule__IdGeneratorSimple__Group_0__0__Impl : ( () ) ;
    public final void rule__IdGeneratorSimple__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5555:1: ( ( () ) )
            // InternalMetaDsl.g:5556:1: ( () )
            {
            // InternalMetaDsl.g:5556:1: ( () )
            // InternalMetaDsl.g:5557:2: ()
            {
             before(grammarAccess.getIdGeneratorSimpleAccess().getIdGeneratorSimpleAction_0_0()); 
            // InternalMetaDsl.g:5558:2: ()
            // InternalMetaDsl.g:5558:3: 
            {
            }

             after(grammarAccess.getIdGeneratorSimpleAccess().getIdGeneratorSimpleAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSimple__Group_0__0__Impl"


    // $ANTLR start "rule__IdGeneratorSimple__Group_0__1"
    // InternalMetaDsl.g:5566:1: rule__IdGeneratorSimple__Group_0__1 : rule__IdGeneratorSimple__Group_0__1__Impl ;
    public final void rule__IdGeneratorSimple__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5570:1: ( rule__IdGeneratorSimple__Group_0__1__Impl )
            // InternalMetaDsl.g:5571:2: rule__IdGeneratorSimple__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IdGeneratorSimple__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSimple__Group_0__1"


    // $ANTLR start "rule__IdGeneratorSimple__Group_0__1__Impl"
    // InternalMetaDsl.g:5577:1: rule__IdGeneratorSimple__Group_0__1__Impl : ( ( rule__IdGeneratorSimple__TypeAssignment_0_1 ) ) ;
    public final void rule__IdGeneratorSimple__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5581:1: ( ( ( rule__IdGeneratorSimple__TypeAssignment_0_1 ) ) )
            // InternalMetaDsl.g:5582:1: ( ( rule__IdGeneratorSimple__TypeAssignment_0_1 ) )
            {
            // InternalMetaDsl.g:5582:1: ( ( rule__IdGeneratorSimple__TypeAssignment_0_1 ) )
            // InternalMetaDsl.g:5583:2: ( rule__IdGeneratorSimple__TypeAssignment_0_1 )
            {
             before(grammarAccess.getIdGeneratorSimpleAccess().getTypeAssignment_0_1()); 
            // InternalMetaDsl.g:5584:2: ( rule__IdGeneratorSimple__TypeAssignment_0_1 )
            // InternalMetaDsl.g:5584:3: rule__IdGeneratorSimple__TypeAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__IdGeneratorSimple__TypeAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorSimpleAccess().getTypeAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSimple__Group_0__1__Impl"


    // $ANTLR start "rule__IdGeneratorSequence__Group__0"
    // InternalMetaDsl.g:5593:1: rule__IdGeneratorSequence__Group__0 : rule__IdGeneratorSequence__Group__0__Impl rule__IdGeneratorSequence__Group__1 ;
    public final void rule__IdGeneratorSequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5597:1: ( rule__IdGeneratorSequence__Group__0__Impl rule__IdGeneratorSequence__Group__1 )
            // InternalMetaDsl.g:5598:2: rule__IdGeneratorSequence__Group__0__Impl rule__IdGeneratorSequence__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__IdGeneratorSequence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdGeneratorSequence__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSequence__Group__0"


    // $ANTLR start "rule__IdGeneratorSequence__Group__0__Impl"
    // InternalMetaDsl.g:5605:1: rule__IdGeneratorSequence__Group__0__Impl : ( () ) ;
    public final void rule__IdGeneratorSequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5609:1: ( ( () ) )
            // InternalMetaDsl.g:5610:1: ( () )
            {
            // InternalMetaDsl.g:5610:1: ( () )
            // InternalMetaDsl.g:5611:2: ()
            {
             before(grammarAccess.getIdGeneratorSequenceAccess().getIdGeneratorSequenceAction_0()); 
            // InternalMetaDsl.g:5612:2: ()
            // InternalMetaDsl.g:5612:3: 
            {
            }

             after(grammarAccess.getIdGeneratorSequenceAccess().getIdGeneratorSequenceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSequence__Group__0__Impl"


    // $ANTLR start "rule__IdGeneratorSequence__Group__1"
    // InternalMetaDsl.g:5620:1: rule__IdGeneratorSequence__Group__1 : rule__IdGeneratorSequence__Group__1__Impl rule__IdGeneratorSequence__Group__2 ;
    public final void rule__IdGeneratorSequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5624:1: ( rule__IdGeneratorSequence__Group__1__Impl rule__IdGeneratorSequence__Group__2 )
            // InternalMetaDsl.g:5625:2: rule__IdGeneratorSequence__Group__1__Impl rule__IdGeneratorSequence__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__IdGeneratorSequence__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdGeneratorSequence__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSequence__Group__1"


    // $ANTLR start "rule__IdGeneratorSequence__Group__1__Impl"
    // InternalMetaDsl.g:5632:1: rule__IdGeneratorSequence__Group__1__Impl : ( ( rule__IdGeneratorSequence__TypeAssignment_1 ) ) ;
    public final void rule__IdGeneratorSequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5636:1: ( ( ( rule__IdGeneratorSequence__TypeAssignment_1 ) ) )
            // InternalMetaDsl.g:5637:1: ( ( rule__IdGeneratorSequence__TypeAssignment_1 ) )
            {
            // InternalMetaDsl.g:5637:1: ( ( rule__IdGeneratorSequence__TypeAssignment_1 ) )
            // InternalMetaDsl.g:5638:2: ( rule__IdGeneratorSequence__TypeAssignment_1 )
            {
             before(grammarAccess.getIdGeneratorSequenceAccess().getTypeAssignment_1()); 
            // InternalMetaDsl.g:5639:2: ( rule__IdGeneratorSequence__TypeAssignment_1 )
            // InternalMetaDsl.g:5639:3: rule__IdGeneratorSequence__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IdGeneratorSequence__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorSequenceAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSequence__Group__1__Impl"


    // $ANTLR start "rule__IdGeneratorSequence__Group__2"
    // InternalMetaDsl.g:5647:1: rule__IdGeneratorSequence__Group__2 : rule__IdGeneratorSequence__Group__2__Impl ;
    public final void rule__IdGeneratorSequence__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5651:1: ( rule__IdGeneratorSequence__Group__2__Impl )
            // InternalMetaDsl.g:5652:2: rule__IdGeneratorSequence__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IdGeneratorSequence__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSequence__Group__2"


    // $ANTLR start "rule__IdGeneratorSequence__Group__2__Impl"
    // InternalMetaDsl.g:5658:1: rule__IdGeneratorSequence__Group__2__Impl : ( ( rule__IdGeneratorSequence__SequenceAssignment_2 ) ) ;
    public final void rule__IdGeneratorSequence__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5662:1: ( ( ( rule__IdGeneratorSequence__SequenceAssignment_2 ) ) )
            // InternalMetaDsl.g:5663:1: ( ( rule__IdGeneratorSequence__SequenceAssignment_2 ) )
            {
            // InternalMetaDsl.g:5663:1: ( ( rule__IdGeneratorSequence__SequenceAssignment_2 ) )
            // InternalMetaDsl.g:5664:2: ( rule__IdGeneratorSequence__SequenceAssignment_2 )
            {
             before(grammarAccess.getIdGeneratorSequenceAccess().getSequenceAssignment_2()); 
            // InternalMetaDsl.g:5665:2: ( rule__IdGeneratorSequence__SequenceAssignment_2 )
            // InternalMetaDsl.g:5665:3: rule__IdGeneratorSequence__SequenceAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IdGeneratorSequence__SequenceAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIdGeneratorSequenceAccess().getSequenceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSequence__Group__2__Impl"


    // $ANTLR start "rule__EnuMetadata__Group__0"
    // InternalMetaDsl.g:5674:1: rule__EnuMetadata__Group__0 : rule__EnuMetadata__Group__0__Impl rule__EnuMetadata__Group__1 ;
    public final void rule__EnuMetadata__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5678:1: ( rule__EnuMetadata__Group__0__Impl rule__EnuMetadata__Group__1 )
            // InternalMetaDsl.g:5679:2: rule__EnuMetadata__Group__0__Impl rule__EnuMetadata__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EnuMetadata__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadata__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__Group__0"


    // $ANTLR start "rule__EnuMetadata__Group__0__Impl"
    // InternalMetaDsl.g:5686:1: rule__EnuMetadata__Group__0__Impl : ( 'ENUMETADATA' ) ;
    public final void rule__EnuMetadata__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5690:1: ( ( 'ENUMETADATA' ) )
            // InternalMetaDsl.g:5691:1: ( 'ENUMETADATA' )
            {
            // InternalMetaDsl.g:5691:1: ( 'ENUMETADATA' )
            // InternalMetaDsl.g:5692:2: 'ENUMETADATA'
            {
             before(grammarAccess.getEnuMetadataAccess().getENUMETADATAKeyword_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataAccess().getENUMETADATAKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__Group__0__Impl"


    // $ANTLR start "rule__EnuMetadata__Group__1"
    // InternalMetaDsl.g:5701:1: rule__EnuMetadata__Group__1 : rule__EnuMetadata__Group__1__Impl rule__EnuMetadata__Group__2 ;
    public final void rule__EnuMetadata__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5705:1: ( rule__EnuMetadata__Group__1__Impl rule__EnuMetadata__Group__2 )
            // InternalMetaDsl.g:5706:2: rule__EnuMetadata__Group__1__Impl rule__EnuMetadata__Group__2
            {
            pushFollow(FOLLOW_46);
            rule__EnuMetadata__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadata__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__Group__1"


    // $ANTLR start "rule__EnuMetadata__Group__1__Impl"
    // InternalMetaDsl.g:5713:1: rule__EnuMetadata__Group__1__Impl : ( '{' ) ;
    public final void rule__EnuMetadata__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5717:1: ( ( '{' ) )
            // InternalMetaDsl.g:5718:1: ( '{' )
            {
            // InternalMetaDsl.g:5718:1: ( '{' )
            // InternalMetaDsl.g:5719:2: '{'
            {
             before(grammarAccess.getEnuMetadataAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__Group__1__Impl"


    // $ANTLR start "rule__EnuMetadata__Group__2"
    // InternalMetaDsl.g:5728:1: rule__EnuMetadata__Group__2 : rule__EnuMetadata__Group__2__Impl rule__EnuMetadata__Group__3 ;
    public final void rule__EnuMetadata__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5732:1: ( rule__EnuMetadata__Group__2__Impl rule__EnuMetadata__Group__3 )
            // InternalMetaDsl.g:5733:2: rule__EnuMetadata__Group__2__Impl rule__EnuMetadata__Group__3
            {
            pushFollow(FOLLOW_46);
            rule__EnuMetadata__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadata__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__Group__2"


    // $ANTLR start "rule__EnuMetadata__Group__2__Impl"
    // InternalMetaDsl.g:5740:1: rule__EnuMetadata__Group__2__Impl : ( ( rule__EnuMetadata__EnuMetadataRowsAssignment_2 )* ) ;
    public final void rule__EnuMetadata__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5744:1: ( ( ( rule__EnuMetadata__EnuMetadataRowsAssignment_2 )* ) )
            // InternalMetaDsl.g:5745:1: ( ( rule__EnuMetadata__EnuMetadataRowsAssignment_2 )* )
            {
            // InternalMetaDsl.g:5745:1: ( ( rule__EnuMetadata__EnuMetadataRowsAssignment_2 )* )
            // InternalMetaDsl.g:5746:2: ( rule__EnuMetadata__EnuMetadataRowsAssignment_2 )*
            {
             before(grammarAccess.getEnuMetadataAccess().getEnuMetadataRowsAssignment_2()); 
            // InternalMetaDsl.g:5747:2: ( rule__EnuMetadata__EnuMetadataRowsAssignment_2 )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_NATURAL) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalMetaDsl.g:5747:3: rule__EnuMetadata__EnuMetadataRowsAssignment_2
            	    {
            	    pushFollow(FOLLOW_47);
            	    rule__EnuMetadata__EnuMetadataRowsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

             after(grammarAccess.getEnuMetadataAccess().getEnuMetadataRowsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__Group__2__Impl"


    // $ANTLR start "rule__EnuMetadata__Group__3"
    // InternalMetaDsl.g:5755:1: rule__EnuMetadata__Group__3 : rule__EnuMetadata__Group__3__Impl ;
    public final void rule__EnuMetadata__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5759:1: ( rule__EnuMetadata__Group__3__Impl )
            // InternalMetaDsl.g:5760:2: rule__EnuMetadata__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadata__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__Group__3"


    // $ANTLR start "rule__EnuMetadata__Group__3__Impl"
    // InternalMetaDsl.g:5766:1: rule__EnuMetadata__Group__3__Impl : ( '}' ) ;
    public final void rule__EnuMetadata__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5770:1: ( ( '}' ) )
            // InternalMetaDsl.g:5771:1: ( '}' )
            {
            // InternalMetaDsl.g:5771:1: ( '}' )
            // InternalMetaDsl.g:5772:2: '}'
            {
             before(grammarAccess.getEnuMetadataAccess().getRightCurlyBracketKeyword_3()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__Group__3__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group__0"
    // InternalMetaDsl.g:5782:1: rule__EnuMetadataRow__Group__0 : rule__EnuMetadataRow__Group__0__Impl rule__EnuMetadataRow__Group__1 ;
    public final void rule__EnuMetadataRow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5786:1: ( rule__EnuMetadataRow__Group__0__Impl rule__EnuMetadataRow__Group__1 )
            // InternalMetaDsl.g:5787:2: rule__EnuMetadataRow__Group__0__Impl rule__EnuMetadataRow__Group__1
            {
            pushFollow(FOLLOW_37);
            rule__EnuMetadataRow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__0"


    // $ANTLR start "rule__EnuMetadataRow__Group__0__Impl"
    // InternalMetaDsl.g:5794:1: rule__EnuMetadataRow__Group__0__Impl : ( ( rule__EnuMetadataRow__KeyAssignment_0 ) ) ;
    public final void rule__EnuMetadataRow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5798:1: ( ( ( rule__EnuMetadataRow__KeyAssignment_0 ) ) )
            // InternalMetaDsl.g:5799:1: ( ( rule__EnuMetadataRow__KeyAssignment_0 ) )
            {
            // InternalMetaDsl.g:5799:1: ( ( rule__EnuMetadataRow__KeyAssignment_0 ) )
            // InternalMetaDsl.g:5800:2: ( rule__EnuMetadataRow__KeyAssignment_0 )
            {
             before(grammarAccess.getEnuMetadataRowAccess().getKeyAssignment_0()); 
            // InternalMetaDsl.g:5801:2: ( rule__EnuMetadataRow__KeyAssignment_0 )
            // InternalMetaDsl.g:5801:3: rule__EnuMetadataRow__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEnuMetadataRowAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__0__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group__1"
    // InternalMetaDsl.g:5809:1: rule__EnuMetadataRow__Group__1 : rule__EnuMetadataRow__Group__1__Impl rule__EnuMetadataRow__Group__2 ;
    public final void rule__EnuMetadataRow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5813:1: ( rule__EnuMetadataRow__Group__1__Impl rule__EnuMetadataRow__Group__2 )
            // InternalMetaDsl.g:5814:2: rule__EnuMetadataRow__Group__1__Impl rule__EnuMetadataRow__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__EnuMetadataRow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__1"


    // $ANTLR start "rule__EnuMetadataRow__Group__1__Impl"
    // InternalMetaDsl.g:5821:1: rule__EnuMetadataRow__Group__1__Impl : ( ',' ) ;
    public final void rule__EnuMetadataRow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5825:1: ( ( ',' ) )
            // InternalMetaDsl.g:5826:1: ( ',' )
            {
            // InternalMetaDsl.g:5826:1: ( ',' )
            // InternalMetaDsl.g:5827:2: ','
            {
             before(grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_1()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__1__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group__2"
    // InternalMetaDsl.g:5836:1: rule__EnuMetadataRow__Group__2 : rule__EnuMetadataRow__Group__2__Impl rule__EnuMetadataRow__Group__3 ;
    public final void rule__EnuMetadataRow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5840:1: ( rule__EnuMetadataRow__Group__2__Impl rule__EnuMetadataRow__Group__3 )
            // InternalMetaDsl.g:5841:2: rule__EnuMetadataRow__Group__2__Impl rule__EnuMetadataRow__Group__3
            {
            pushFollow(FOLLOW_37);
            rule__EnuMetadataRow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__2"


    // $ANTLR start "rule__EnuMetadataRow__Group__2__Impl"
    // InternalMetaDsl.g:5848:1: rule__EnuMetadataRow__Group__2__Impl : ( ( rule__EnuMetadataRow__NameAssignment_2 ) ) ;
    public final void rule__EnuMetadataRow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5852:1: ( ( ( rule__EnuMetadataRow__NameAssignment_2 ) ) )
            // InternalMetaDsl.g:5853:1: ( ( rule__EnuMetadataRow__NameAssignment_2 ) )
            {
            // InternalMetaDsl.g:5853:1: ( ( rule__EnuMetadataRow__NameAssignment_2 ) )
            // InternalMetaDsl.g:5854:2: ( rule__EnuMetadataRow__NameAssignment_2 )
            {
             before(grammarAccess.getEnuMetadataRowAccess().getNameAssignment_2()); 
            // InternalMetaDsl.g:5855:2: ( rule__EnuMetadataRow__NameAssignment_2 )
            // InternalMetaDsl.g:5855:3: rule__EnuMetadataRow__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEnuMetadataRowAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__2__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group__3"
    // InternalMetaDsl.g:5863:1: rule__EnuMetadataRow__Group__3 : rule__EnuMetadataRow__Group__3__Impl rule__EnuMetadataRow__Group__4 ;
    public final void rule__EnuMetadataRow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5867:1: ( rule__EnuMetadataRow__Group__3__Impl rule__EnuMetadataRow__Group__4 )
            // InternalMetaDsl.g:5868:2: rule__EnuMetadataRow__Group__3__Impl rule__EnuMetadataRow__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__EnuMetadataRow__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__3"


    // $ANTLR start "rule__EnuMetadataRow__Group__3__Impl"
    // InternalMetaDsl.g:5875:1: rule__EnuMetadataRow__Group__3__Impl : ( ',' ) ;
    public final void rule__EnuMetadataRow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5879:1: ( ( ',' ) )
            // InternalMetaDsl.g:5880:1: ( ',' )
            {
            // InternalMetaDsl.g:5880:1: ( ',' )
            // InternalMetaDsl.g:5881:2: ','
            {
             before(grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_3()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__3__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group__4"
    // InternalMetaDsl.g:5890:1: rule__EnuMetadataRow__Group__4 : rule__EnuMetadataRow__Group__4__Impl rule__EnuMetadataRow__Group__5 ;
    public final void rule__EnuMetadataRow__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5894:1: ( rule__EnuMetadataRow__Group__4__Impl rule__EnuMetadataRow__Group__5 )
            // InternalMetaDsl.g:5895:2: rule__EnuMetadataRow__Group__4__Impl rule__EnuMetadataRow__Group__5
            {
            pushFollow(FOLLOW_48);
            rule__EnuMetadataRow__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__4"


    // $ANTLR start "rule__EnuMetadataRow__Group__4__Impl"
    // InternalMetaDsl.g:5902:1: rule__EnuMetadataRow__Group__4__Impl : ( ( rule__EnuMetadataRow__DescriptionAssignment_4 ) ) ;
    public final void rule__EnuMetadataRow__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5906:1: ( ( ( rule__EnuMetadataRow__DescriptionAssignment_4 ) ) )
            // InternalMetaDsl.g:5907:1: ( ( rule__EnuMetadataRow__DescriptionAssignment_4 ) )
            {
            // InternalMetaDsl.g:5907:1: ( ( rule__EnuMetadataRow__DescriptionAssignment_4 ) )
            // InternalMetaDsl.g:5908:2: ( rule__EnuMetadataRow__DescriptionAssignment_4 )
            {
             before(grammarAccess.getEnuMetadataRowAccess().getDescriptionAssignment_4()); 
            // InternalMetaDsl.g:5909:2: ( rule__EnuMetadataRow__DescriptionAssignment_4 )
            // InternalMetaDsl.g:5909:3: rule__EnuMetadataRow__DescriptionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__DescriptionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getEnuMetadataRowAccess().getDescriptionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__4__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group__5"
    // InternalMetaDsl.g:5917:1: rule__EnuMetadataRow__Group__5 : rule__EnuMetadataRow__Group__5__Impl rule__EnuMetadataRow__Group__6 ;
    public final void rule__EnuMetadataRow__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5921:1: ( rule__EnuMetadataRow__Group__5__Impl rule__EnuMetadataRow__Group__6 )
            // InternalMetaDsl.g:5922:2: rule__EnuMetadataRow__Group__5__Impl rule__EnuMetadataRow__Group__6
            {
            pushFollow(FOLLOW_48);
            rule__EnuMetadataRow__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__5"


    // $ANTLR start "rule__EnuMetadataRow__Group__5__Impl"
    // InternalMetaDsl.g:5929:1: rule__EnuMetadataRow__Group__5__Impl : ( ( rule__EnuMetadataRow__Group_5__0 )* ) ;
    public final void rule__EnuMetadataRow__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5933:1: ( ( ( rule__EnuMetadataRow__Group_5__0 )* ) )
            // InternalMetaDsl.g:5934:1: ( ( rule__EnuMetadataRow__Group_5__0 )* )
            {
            // InternalMetaDsl.g:5934:1: ( ( rule__EnuMetadataRow__Group_5__0 )* )
            // InternalMetaDsl.g:5935:2: ( rule__EnuMetadataRow__Group_5__0 )*
            {
             before(grammarAccess.getEnuMetadataRowAccess().getGroup_5()); 
            // InternalMetaDsl.g:5936:2: ( rule__EnuMetadataRow__Group_5__0 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==48) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalMetaDsl.g:5936:3: rule__EnuMetadataRow__Group_5__0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__EnuMetadataRow__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

             after(grammarAccess.getEnuMetadataRowAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__5__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group__6"
    // InternalMetaDsl.g:5944:1: rule__EnuMetadataRow__Group__6 : rule__EnuMetadataRow__Group__6__Impl ;
    public final void rule__EnuMetadataRow__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5948:1: ( rule__EnuMetadataRow__Group__6__Impl )
            // InternalMetaDsl.g:5949:2: rule__EnuMetadataRow__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__6"


    // $ANTLR start "rule__EnuMetadataRow__Group__6__Impl"
    // InternalMetaDsl.g:5955:1: rule__EnuMetadataRow__Group__6__Impl : ( ';' ) ;
    public final void rule__EnuMetadataRow__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5959:1: ( ( ';' ) )
            // InternalMetaDsl.g:5960:1: ( ';' )
            {
            // InternalMetaDsl.g:5960:1: ( ';' )
            // InternalMetaDsl.g:5961:2: ';'
            {
             before(grammarAccess.getEnuMetadataRowAccess().getSemicolonKeyword_6()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataRowAccess().getSemicolonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group__6__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group_5__0"
    // InternalMetaDsl.g:5971:1: rule__EnuMetadataRow__Group_5__0 : rule__EnuMetadataRow__Group_5__0__Impl rule__EnuMetadataRow__Group_5__1 ;
    public final void rule__EnuMetadataRow__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5975:1: ( rule__EnuMetadataRow__Group_5__0__Impl rule__EnuMetadataRow__Group_5__1 )
            // InternalMetaDsl.g:5976:2: rule__EnuMetadataRow__Group_5__0__Impl rule__EnuMetadataRow__Group_5__1
            {
            pushFollow(FOLLOW_50);
            rule__EnuMetadataRow__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group_5__0"


    // $ANTLR start "rule__EnuMetadataRow__Group_5__0__Impl"
    // InternalMetaDsl.g:5983:1: rule__EnuMetadataRow__Group_5__0__Impl : ( ',' ) ;
    public final void rule__EnuMetadataRow__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:5987:1: ( ( ',' ) )
            // InternalMetaDsl.g:5988:1: ( ',' )
            {
            // InternalMetaDsl.g:5988:1: ( ',' )
            // InternalMetaDsl.g:5989:2: ','
            {
             before(grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_5_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group_5__0__Impl"


    // $ANTLR start "rule__EnuMetadataRow__Group_5__1"
    // InternalMetaDsl.g:5998:1: rule__EnuMetadataRow__Group_5__1 : rule__EnuMetadataRow__Group_5__1__Impl ;
    public final void rule__EnuMetadataRow__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6002:1: ( rule__EnuMetadataRow__Group_5__1__Impl )
            // InternalMetaDsl.g:6003:2: rule__EnuMetadataRow__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group_5__1"


    // $ANTLR start "rule__EnuMetadataRow__Group_5__1__Impl"
    // InternalMetaDsl.g:6009:1: rule__EnuMetadataRow__Group_5__1__Impl : ( ( rule__EnuMetadataRow__RowValuesAssignment_5_1 ) ) ;
    public final void rule__EnuMetadataRow__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6013:1: ( ( ( rule__EnuMetadataRow__RowValuesAssignment_5_1 ) ) )
            // InternalMetaDsl.g:6014:1: ( ( rule__EnuMetadataRow__RowValuesAssignment_5_1 ) )
            {
            // InternalMetaDsl.g:6014:1: ( ( rule__EnuMetadataRow__RowValuesAssignment_5_1 ) )
            // InternalMetaDsl.g:6015:2: ( rule__EnuMetadataRow__RowValuesAssignment_5_1 )
            {
             before(grammarAccess.getEnuMetadataRowAccess().getRowValuesAssignment_5_1()); 
            // InternalMetaDsl.g:6016:2: ( rule__EnuMetadataRow__RowValuesAssignment_5_1 )
            // InternalMetaDsl.g:6016:3: rule__EnuMetadataRow__RowValuesAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__EnuMetadataRow__RowValuesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getEnuMetadataRowAccess().getRowValuesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__Group_5__1__Impl"


    // $ANTLR start "rule__Metadata__Group__0"
    // InternalMetaDsl.g:6025:1: rule__Metadata__Group__0 : rule__Metadata__Group__0__Impl rule__Metadata__Group__1 ;
    public final void rule__Metadata__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6029:1: ( rule__Metadata__Group__0__Impl rule__Metadata__Group__1 )
            // InternalMetaDsl.g:6030:2: rule__Metadata__Group__0__Impl rule__Metadata__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__Metadata__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metadata__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__0"


    // $ANTLR start "rule__Metadata__Group__0__Impl"
    // InternalMetaDsl.g:6037:1: rule__Metadata__Group__0__Impl : ( ( rule__Metadata__NameAssignment_0 ) ) ;
    public final void rule__Metadata__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6041:1: ( ( ( rule__Metadata__NameAssignment_0 ) ) )
            // InternalMetaDsl.g:6042:1: ( ( rule__Metadata__NameAssignment_0 ) )
            {
            // InternalMetaDsl.g:6042:1: ( ( rule__Metadata__NameAssignment_0 ) )
            // InternalMetaDsl.g:6043:2: ( rule__Metadata__NameAssignment_0 )
            {
             before(grammarAccess.getMetadataAccess().getNameAssignment_0()); 
            // InternalMetaDsl.g:6044:2: ( rule__Metadata__NameAssignment_0 )
            // InternalMetaDsl.g:6044:3: rule__Metadata__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Metadata__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMetadataAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__0__Impl"


    // $ANTLR start "rule__Metadata__Group__1"
    // InternalMetaDsl.g:6052:1: rule__Metadata__Group__1 : rule__Metadata__Group__1__Impl rule__Metadata__Group__2 ;
    public final void rule__Metadata__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6056:1: ( rule__Metadata__Group__1__Impl rule__Metadata__Group__2 )
            // InternalMetaDsl.g:6057:2: rule__Metadata__Group__1__Impl rule__Metadata__Group__2
            {
            pushFollow(FOLLOW_51);
            rule__Metadata__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metadata__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__1"


    // $ANTLR start "rule__Metadata__Group__1__Impl"
    // InternalMetaDsl.g:6064:1: rule__Metadata__Group__1__Impl : ( ( rule__Metadata__Group_1__0 )? ) ;
    public final void rule__Metadata__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6068:1: ( ( ( rule__Metadata__Group_1__0 )? ) )
            // InternalMetaDsl.g:6069:1: ( ( rule__Metadata__Group_1__0 )? )
            {
            // InternalMetaDsl.g:6069:1: ( ( rule__Metadata__Group_1__0 )? )
            // InternalMetaDsl.g:6070:2: ( rule__Metadata__Group_1__0 )?
            {
             before(grammarAccess.getMetadataAccess().getGroup_1()); 
            // InternalMetaDsl.g:6071:2: ( rule__Metadata__Group_1__0 )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==69) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalMetaDsl.g:6071:3: rule__Metadata__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Metadata__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMetadataAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__1__Impl"


    // $ANTLR start "rule__Metadata__Group__2"
    // InternalMetaDsl.g:6079:1: rule__Metadata__Group__2 : rule__Metadata__Group__2__Impl rule__Metadata__Group__3 ;
    public final void rule__Metadata__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6083:1: ( rule__Metadata__Group__2__Impl rule__Metadata__Group__3 )
            // InternalMetaDsl.g:6084:2: rule__Metadata__Group__2__Impl rule__Metadata__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__Metadata__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metadata__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__2"


    // $ANTLR start "rule__Metadata__Group__2__Impl"
    // InternalMetaDsl.g:6091:1: rule__Metadata__Group__2__Impl : ( '{' ) ;
    public final void rule__Metadata__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6095:1: ( ( '{' ) )
            // InternalMetaDsl.g:6096:1: ( '{' )
            {
            // InternalMetaDsl.g:6096:1: ( '{' )
            // InternalMetaDsl.g:6097:2: '{'
            {
             before(grammarAccess.getMetadataAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getMetadataAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__2__Impl"


    // $ANTLR start "rule__Metadata__Group__3"
    // InternalMetaDsl.g:6106:1: rule__Metadata__Group__3 : rule__Metadata__Group__3__Impl rule__Metadata__Group__4 ;
    public final void rule__Metadata__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6110:1: ( rule__Metadata__Group__3__Impl rule__Metadata__Group__4 )
            // InternalMetaDsl.g:6111:2: rule__Metadata__Group__3__Impl rule__Metadata__Group__4
            {
            pushFollow(FOLLOW_52);
            rule__Metadata__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metadata__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__3"


    // $ANTLR start "rule__Metadata__Group__3__Impl"
    // InternalMetaDsl.g:6118:1: rule__Metadata__Group__3__Impl : ( ( rule__Metadata__MetadataRowsAssignment_3 )* ) ;
    public final void rule__Metadata__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6122:1: ( ( ( rule__Metadata__MetadataRowsAssignment_3 )* ) )
            // InternalMetaDsl.g:6123:1: ( ( rule__Metadata__MetadataRowsAssignment_3 )* )
            {
            // InternalMetaDsl.g:6123:1: ( ( rule__Metadata__MetadataRowsAssignment_3 )* )
            // InternalMetaDsl.g:6124:2: ( rule__Metadata__MetadataRowsAssignment_3 )*
            {
             before(grammarAccess.getMetadataAccess().getMetadataRowsAssignment_3()); 
            // InternalMetaDsl.g:6125:2: ( rule__Metadata__MetadataRowsAssignment_3 )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( ((LA76_0>=RULE_STRING && LA76_0<=RULE_NEGATIVEINT)||LA76_0==33||LA76_0==70||LA76_0==91) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalMetaDsl.g:6125:3: rule__Metadata__MetadataRowsAssignment_3
            	    {
            	    pushFollow(FOLLOW_53);
            	    rule__Metadata__MetadataRowsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

             after(grammarAccess.getMetadataAccess().getMetadataRowsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__3__Impl"


    // $ANTLR start "rule__Metadata__Group__4"
    // InternalMetaDsl.g:6133:1: rule__Metadata__Group__4 : rule__Metadata__Group__4__Impl ;
    public final void rule__Metadata__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6137:1: ( rule__Metadata__Group__4__Impl )
            // InternalMetaDsl.g:6138:2: rule__Metadata__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metadata__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__4"


    // $ANTLR start "rule__Metadata__Group__4__Impl"
    // InternalMetaDsl.g:6144:1: rule__Metadata__Group__4__Impl : ( '}' ) ;
    public final void rule__Metadata__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6148:1: ( ( '}' ) )
            // InternalMetaDsl.g:6149:1: ( '}' )
            {
            // InternalMetaDsl.g:6149:1: ( '}' )
            // InternalMetaDsl.g:6150:2: '}'
            {
             before(grammarAccess.getMetadataAccess().getRightCurlyBracketKeyword_4()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getMetadataAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group__4__Impl"


    // $ANTLR start "rule__Metadata__Group_1__0"
    // InternalMetaDsl.g:6160:1: rule__Metadata__Group_1__0 : rule__Metadata__Group_1__0__Impl rule__Metadata__Group_1__1 ;
    public final void rule__Metadata__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6164:1: ( rule__Metadata__Group_1__0__Impl rule__Metadata__Group_1__1 )
            // InternalMetaDsl.g:6165:2: rule__Metadata__Group_1__0__Impl rule__Metadata__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__Metadata__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Metadata__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group_1__0"


    // $ANTLR start "rule__Metadata__Group_1__0__Impl"
    // InternalMetaDsl.g:6172:1: rule__Metadata__Group_1__0__Impl : ( 'FOR' ) ;
    public final void rule__Metadata__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6176:1: ( ( 'FOR' ) )
            // InternalMetaDsl.g:6177:1: ( 'FOR' )
            {
            // InternalMetaDsl.g:6177:1: ( 'FOR' )
            // InternalMetaDsl.g:6178:2: 'FOR'
            {
             before(grammarAccess.getMetadataAccess().getFORKeyword_1_0()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getMetadataAccess().getFORKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group_1__0__Impl"


    // $ANTLR start "rule__Metadata__Group_1__1"
    // InternalMetaDsl.g:6187:1: rule__Metadata__Group_1__1 : rule__Metadata__Group_1__1__Impl ;
    public final void rule__Metadata__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6191:1: ( rule__Metadata__Group_1__1__Impl )
            // InternalMetaDsl.g:6192:2: rule__Metadata__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Metadata__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group_1__1"


    // $ANTLR start "rule__Metadata__Group_1__1__Impl"
    // InternalMetaDsl.g:6198:1: rule__Metadata__Group_1__1__Impl : ( ( rule__Metadata__EntityAssignment_1_1 ) ) ;
    public final void rule__Metadata__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6202:1: ( ( ( rule__Metadata__EntityAssignment_1_1 ) ) )
            // InternalMetaDsl.g:6203:1: ( ( rule__Metadata__EntityAssignment_1_1 ) )
            {
            // InternalMetaDsl.g:6203:1: ( ( rule__Metadata__EntityAssignment_1_1 ) )
            // InternalMetaDsl.g:6204:2: ( rule__Metadata__EntityAssignment_1_1 )
            {
             before(grammarAccess.getMetadataAccess().getEntityAssignment_1_1()); 
            // InternalMetaDsl.g:6205:2: ( rule__Metadata__EntityAssignment_1_1 )
            // InternalMetaDsl.g:6205:3: rule__Metadata__EntityAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Metadata__EntityAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMetadataAccess().getEntityAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__Group_1__1__Impl"


    // $ANTLR start "rule__ShortCode__Group__0"
    // InternalMetaDsl.g:6214:1: rule__ShortCode__Group__0 : rule__ShortCode__Group__0__Impl rule__ShortCode__Group__1 ;
    public final void rule__ShortCode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6218:1: ( rule__ShortCode__Group__0__Impl rule__ShortCode__Group__1 )
            // InternalMetaDsl.g:6219:2: rule__ShortCode__Group__0__Impl rule__ShortCode__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__ShortCode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ShortCode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShortCode__Group__0"


    // $ANTLR start "rule__ShortCode__Group__0__Impl"
    // InternalMetaDsl.g:6226:1: rule__ShortCode__Group__0__Impl : ( 'SHORTCODE' ) ;
    public final void rule__ShortCode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6230:1: ( ( 'SHORTCODE' ) )
            // InternalMetaDsl.g:6231:1: ( 'SHORTCODE' )
            {
            // InternalMetaDsl.g:6231:1: ( 'SHORTCODE' )
            // InternalMetaDsl.g:6232:2: 'SHORTCODE'
            {
             before(grammarAccess.getShortCodeAccess().getSHORTCODEKeyword_0()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getShortCodeAccess().getSHORTCODEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShortCode__Group__0__Impl"


    // $ANTLR start "rule__ShortCode__Group__1"
    // InternalMetaDsl.g:6241:1: rule__ShortCode__Group__1 : rule__ShortCode__Group__1__Impl ;
    public final void rule__ShortCode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6245:1: ( rule__ShortCode__Group__1__Impl )
            // InternalMetaDsl.g:6246:2: rule__ShortCode__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ShortCode__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShortCode__Group__1"


    // $ANTLR start "rule__ShortCode__Group__1__Impl"
    // InternalMetaDsl.g:6252:1: rule__ShortCode__Group__1__Impl : ( ( rule__ShortCode__ShortCodeValueAssignment_1 ) ) ;
    public final void rule__ShortCode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6256:1: ( ( ( rule__ShortCode__ShortCodeValueAssignment_1 ) ) )
            // InternalMetaDsl.g:6257:1: ( ( rule__ShortCode__ShortCodeValueAssignment_1 ) )
            {
            // InternalMetaDsl.g:6257:1: ( ( rule__ShortCode__ShortCodeValueAssignment_1 ) )
            // InternalMetaDsl.g:6258:2: ( rule__ShortCode__ShortCodeValueAssignment_1 )
            {
             before(grammarAccess.getShortCodeAccess().getShortCodeValueAssignment_1()); 
            // InternalMetaDsl.g:6259:2: ( rule__ShortCode__ShortCodeValueAssignment_1 )
            // InternalMetaDsl.g:6259:3: rule__ShortCode__ShortCodeValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ShortCode__ShortCodeValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getShortCodeAccess().getShortCodeValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShortCode__Group__1__Impl"


    // $ANTLR start "rule__MetadataRow__Group__0"
    // InternalMetaDsl.g:6268:1: rule__MetadataRow__Group__0 : rule__MetadataRow__Group__0__Impl rule__MetadataRow__Group__1 ;
    public final void rule__MetadataRow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6272:1: ( rule__MetadataRow__Group__0__Impl rule__MetadataRow__Group__1 )
            // InternalMetaDsl.g:6273:2: rule__MetadataRow__Group__0__Impl rule__MetadataRow__Group__1
            {
            pushFollow(FOLLOW_48);
            rule__MetadataRow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetadataRow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group__0"


    // $ANTLR start "rule__MetadataRow__Group__0__Impl"
    // InternalMetaDsl.g:6280:1: rule__MetadataRow__Group__0__Impl : ( ( rule__MetadataRow__RowValuesAssignment_0 ) ) ;
    public final void rule__MetadataRow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6284:1: ( ( ( rule__MetadataRow__RowValuesAssignment_0 ) ) )
            // InternalMetaDsl.g:6285:1: ( ( rule__MetadataRow__RowValuesAssignment_0 ) )
            {
            // InternalMetaDsl.g:6285:1: ( ( rule__MetadataRow__RowValuesAssignment_0 ) )
            // InternalMetaDsl.g:6286:2: ( rule__MetadataRow__RowValuesAssignment_0 )
            {
             before(grammarAccess.getMetadataRowAccess().getRowValuesAssignment_0()); 
            // InternalMetaDsl.g:6287:2: ( rule__MetadataRow__RowValuesAssignment_0 )
            // InternalMetaDsl.g:6287:3: rule__MetadataRow__RowValuesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MetadataRow__RowValuesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMetadataRowAccess().getRowValuesAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group__0__Impl"


    // $ANTLR start "rule__MetadataRow__Group__1"
    // InternalMetaDsl.g:6295:1: rule__MetadataRow__Group__1 : rule__MetadataRow__Group__1__Impl rule__MetadataRow__Group__2 ;
    public final void rule__MetadataRow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6299:1: ( rule__MetadataRow__Group__1__Impl rule__MetadataRow__Group__2 )
            // InternalMetaDsl.g:6300:2: rule__MetadataRow__Group__1__Impl rule__MetadataRow__Group__2
            {
            pushFollow(FOLLOW_48);
            rule__MetadataRow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetadataRow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group__1"


    // $ANTLR start "rule__MetadataRow__Group__1__Impl"
    // InternalMetaDsl.g:6307:1: rule__MetadataRow__Group__1__Impl : ( ( rule__MetadataRow__Group_1__0 )* ) ;
    public final void rule__MetadataRow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6311:1: ( ( ( rule__MetadataRow__Group_1__0 )* ) )
            // InternalMetaDsl.g:6312:1: ( ( rule__MetadataRow__Group_1__0 )* )
            {
            // InternalMetaDsl.g:6312:1: ( ( rule__MetadataRow__Group_1__0 )* )
            // InternalMetaDsl.g:6313:2: ( rule__MetadataRow__Group_1__0 )*
            {
             before(grammarAccess.getMetadataRowAccess().getGroup_1()); 
            // InternalMetaDsl.g:6314:2: ( rule__MetadataRow__Group_1__0 )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==48) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalMetaDsl.g:6314:3: rule__MetadataRow__Group_1__0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__MetadataRow__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

             after(grammarAccess.getMetadataRowAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group__1__Impl"


    // $ANTLR start "rule__MetadataRow__Group__2"
    // InternalMetaDsl.g:6322:1: rule__MetadataRow__Group__2 : rule__MetadataRow__Group__2__Impl ;
    public final void rule__MetadataRow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6326:1: ( rule__MetadataRow__Group__2__Impl )
            // InternalMetaDsl.g:6327:2: rule__MetadataRow__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MetadataRow__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group__2"


    // $ANTLR start "rule__MetadataRow__Group__2__Impl"
    // InternalMetaDsl.g:6333:1: rule__MetadataRow__Group__2__Impl : ( ';' ) ;
    public final void rule__MetadataRow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6337:1: ( ( ';' ) )
            // InternalMetaDsl.g:6338:1: ( ';' )
            {
            // InternalMetaDsl.g:6338:1: ( ';' )
            // InternalMetaDsl.g:6339:2: ';'
            {
             before(grammarAccess.getMetadataRowAccess().getSemicolonKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getMetadataRowAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group__2__Impl"


    // $ANTLR start "rule__MetadataRow__Group_1__0"
    // InternalMetaDsl.g:6349:1: rule__MetadataRow__Group_1__0 : rule__MetadataRow__Group_1__0__Impl rule__MetadataRow__Group_1__1 ;
    public final void rule__MetadataRow__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6353:1: ( rule__MetadataRow__Group_1__0__Impl rule__MetadataRow__Group_1__1 )
            // InternalMetaDsl.g:6354:2: rule__MetadataRow__Group_1__0__Impl rule__MetadataRow__Group_1__1
            {
            pushFollow(FOLLOW_50);
            rule__MetadataRow__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetadataRow__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group_1__0"


    // $ANTLR start "rule__MetadataRow__Group_1__0__Impl"
    // InternalMetaDsl.g:6361:1: rule__MetadataRow__Group_1__0__Impl : ( ',' ) ;
    public final void rule__MetadataRow__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6365:1: ( ( ',' ) )
            // InternalMetaDsl.g:6366:1: ( ',' )
            {
            // InternalMetaDsl.g:6366:1: ( ',' )
            // InternalMetaDsl.g:6367:2: ','
            {
             before(grammarAccess.getMetadataRowAccess().getCommaKeyword_1_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getMetadataRowAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group_1__0__Impl"


    // $ANTLR start "rule__MetadataRow__Group_1__1"
    // InternalMetaDsl.g:6376:1: rule__MetadataRow__Group_1__1 : rule__MetadataRow__Group_1__1__Impl ;
    public final void rule__MetadataRow__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6380:1: ( rule__MetadataRow__Group_1__1__Impl )
            // InternalMetaDsl.g:6381:2: rule__MetadataRow__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MetadataRow__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group_1__1"


    // $ANTLR start "rule__MetadataRow__Group_1__1__Impl"
    // InternalMetaDsl.g:6387:1: rule__MetadataRow__Group_1__1__Impl : ( ( rule__MetadataRow__RowValuesAssignment_1_1 ) ) ;
    public final void rule__MetadataRow__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6391:1: ( ( ( rule__MetadataRow__RowValuesAssignment_1_1 ) ) )
            // InternalMetaDsl.g:6392:1: ( ( rule__MetadataRow__RowValuesAssignment_1_1 ) )
            {
            // InternalMetaDsl.g:6392:1: ( ( rule__MetadataRow__RowValuesAssignment_1_1 ) )
            // InternalMetaDsl.g:6393:2: ( rule__MetadataRow__RowValuesAssignment_1_1 )
            {
             before(grammarAccess.getMetadataRowAccess().getRowValuesAssignment_1_1()); 
            // InternalMetaDsl.g:6394:2: ( rule__MetadataRow__RowValuesAssignment_1_1 )
            // InternalMetaDsl.g:6394:3: rule__MetadataRow__RowValuesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MetadataRow__RowValuesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMetadataRowAccess().getRowValuesAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__Group_1__1__Impl"


    // $ANTLR start "rule__LabelSection__Group__0"
    // InternalMetaDsl.g:6403:1: rule__LabelSection__Group__0 : rule__LabelSection__Group__0__Impl rule__LabelSection__Group__1 ;
    public final void rule__LabelSection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6407:1: ( rule__LabelSection__Group__0__Impl rule__LabelSection__Group__1 )
            // InternalMetaDsl.g:6408:2: rule__LabelSection__Group__0__Impl rule__LabelSection__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__LabelSection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LabelSection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__Group__0"


    // $ANTLR start "rule__LabelSection__Group__0__Impl"
    // InternalMetaDsl.g:6415:1: rule__LabelSection__Group__0__Impl : ( ( rule__LabelSection__NameAssignment_0 ) ) ;
    public final void rule__LabelSection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6419:1: ( ( ( rule__LabelSection__NameAssignment_0 ) ) )
            // InternalMetaDsl.g:6420:1: ( ( rule__LabelSection__NameAssignment_0 ) )
            {
            // InternalMetaDsl.g:6420:1: ( ( rule__LabelSection__NameAssignment_0 ) )
            // InternalMetaDsl.g:6421:2: ( rule__LabelSection__NameAssignment_0 )
            {
             before(grammarAccess.getLabelSectionAccess().getNameAssignment_0()); 
            // InternalMetaDsl.g:6422:2: ( rule__LabelSection__NameAssignment_0 )
            // InternalMetaDsl.g:6422:3: rule__LabelSection__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LabelSection__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLabelSectionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__Group__0__Impl"


    // $ANTLR start "rule__LabelSection__Group__1"
    // InternalMetaDsl.g:6430:1: rule__LabelSection__Group__1 : rule__LabelSection__Group__1__Impl rule__LabelSection__Group__2 ;
    public final void rule__LabelSection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6434:1: ( rule__LabelSection__Group__1__Impl rule__LabelSection__Group__2 )
            // InternalMetaDsl.g:6435:2: rule__LabelSection__Group__1__Impl rule__LabelSection__Group__2
            {
            pushFollow(FOLLOW_54);
            rule__LabelSection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LabelSection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__Group__1"


    // $ANTLR start "rule__LabelSection__Group__1__Impl"
    // InternalMetaDsl.g:6442:1: rule__LabelSection__Group__1__Impl : ( '{' ) ;
    public final void rule__LabelSection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6446:1: ( ( '{' ) )
            // InternalMetaDsl.g:6447:1: ( '{' )
            {
            // InternalMetaDsl.g:6447:1: ( '{' )
            // InternalMetaDsl.g:6448:2: '{'
            {
             before(grammarAccess.getLabelSectionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLabelSectionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__Group__1__Impl"


    // $ANTLR start "rule__LabelSection__Group__2"
    // InternalMetaDsl.g:6457:1: rule__LabelSection__Group__2 : rule__LabelSection__Group__2__Impl rule__LabelSection__Group__3 ;
    public final void rule__LabelSection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6461:1: ( rule__LabelSection__Group__2__Impl rule__LabelSection__Group__3 )
            // InternalMetaDsl.g:6462:2: rule__LabelSection__Group__2__Impl rule__LabelSection__Group__3
            {
            pushFollow(FOLLOW_55);
            rule__LabelSection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LabelSection__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__Group__2"


    // $ANTLR start "rule__LabelSection__Group__2__Impl"
    // InternalMetaDsl.g:6469:1: rule__LabelSection__Group__2__Impl : ( ( ( rule__LabelSection__LabelsAssignment_2 ) ) ( ( rule__LabelSection__LabelsAssignment_2 )* ) ) ;
    public final void rule__LabelSection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6473:1: ( ( ( ( rule__LabelSection__LabelsAssignment_2 ) ) ( ( rule__LabelSection__LabelsAssignment_2 )* ) ) )
            // InternalMetaDsl.g:6474:1: ( ( ( rule__LabelSection__LabelsAssignment_2 ) ) ( ( rule__LabelSection__LabelsAssignment_2 )* ) )
            {
            // InternalMetaDsl.g:6474:1: ( ( ( rule__LabelSection__LabelsAssignment_2 ) ) ( ( rule__LabelSection__LabelsAssignment_2 )* ) )
            // InternalMetaDsl.g:6475:2: ( ( rule__LabelSection__LabelsAssignment_2 ) ) ( ( rule__LabelSection__LabelsAssignment_2 )* )
            {
            // InternalMetaDsl.g:6475:2: ( ( rule__LabelSection__LabelsAssignment_2 ) )
            // InternalMetaDsl.g:6476:3: ( rule__LabelSection__LabelsAssignment_2 )
            {
             before(grammarAccess.getLabelSectionAccess().getLabelsAssignment_2()); 
            // InternalMetaDsl.g:6477:3: ( rule__LabelSection__LabelsAssignment_2 )
            // InternalMetaDsl.g:6477:4: rule__LabelSection__LabelsAssignment_2
            {
            pushFollow(FOLLOW_56);
            rule__LabelSection__LabelsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLabelSectionAccess().getLabelsAssignment_2()); 

            }

            // InternalMetaDsl.g:6480:2: ( ( rule__LabelSection__LabelsAssignment_2 )* )
            // InternalMetaDsl.g:6481:3: ( rule__LabelSection__LabelsAssignment_2 )*
            {
             before(grammarAccess.getLabelSectionAccess().getLabelsAssignment_2()); 
            // InternalMetaDsl.g:6482:3: ( rule__LabelSection__LabelsAssignment_2 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID||LA78_0==25) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalMetaDsl.g:6482:4: rule__LabelSection__LabelsAssignment_2
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__LabelSection__LabelsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

             after(grammarAccess.getLabelSectionAccess().getLabelsAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__Group__2__Impl"


    // $ANTLR start "rule__LabelSection__Group__3"
    // InternalMetaDsl.g:6491:1: rule__LabelSection__Group__3 : rule__LabelSection__Group__3__Impl ;
    public final void rule__LabelSection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6495:1: ( rule__LabelSection__Group__3__Impl )
            // InternalMetaDsl.g:6496:2: rule__LabelSection__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LabelSection__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__Group__3"


    // $ANTLR start "rule__LabelSection__Group__3__Impl"
    // InternalMetaDsl.g:6502:1: rule__LabelSection__Group__3__Impl : ( '}' ) ;
    public final void rule__LabelSection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6506:1: ( ( '}' ) )
            // InternalMetaDsl.g:6507:1: ( '}' )
            {
            // InternalMetaDsl.g:6507:1: ( '}' )
            // InternalMetaDsl.g:6508:2: '}'
            {
             before(grammarAccess.getLabelSectionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getLabelSectionAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__Group__3__Impl"


    // $ANTLR start "rule__LabelBlock__Group__0"
    // InternalMetaDsl.g:6518:1: rule__LabelBlock__Group__0 : rule__LabelBlock__Group__0__Impl rule__LabelBlock__Group__1 ;
    public final void rule__LabelBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6522:1: ( rule__LabelBlock__Group__0__Impl rule__LabelBlock__Group__1 )
            // InternalMetaDsl.g:6523:2: rule__LabelBlock__Group__0__Impl rule__LabelBlock__Group__1
            {
            pushFollow(FOLLOW_54);
            rule__LabelBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LabelBlock__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__0"


    // $ANTLR start "rule__LabelBlock__Group__0__Impl"
    // InternalMetaDsl.g:6530:1: rule__LabelBlock__Group__0__Impl : ( () ) ;
    public final void rule__LabelBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6534:1: ( ( () ) )
            // InternalMetaDsl.g:6535:1: ( () )
            {
            // InternalMetaDsl.g:6535:1: ( () )
            // InternalMetaDsl.g:6536:2: ()
            {
             before(grammarAccess.getLabelBlockAccess().getLabelBlockAction_0()); 
            // InternalMetaDsl.g:6537:2: ()
            // InternalMetaDsl.g:6537:3: 
            {
            }

             after(grammarAccess.getLabelBlockAccess().getLabelBlockAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__0__Impl"


    // $ANTLR start "rule__LabelBlock__Group__1"
    // InternalMetaDsl.g:6545:1: rule__LabelBlock__Group__1 : rule__LabelBlock__Group__1__Impl rule__LabelBlock__Group__2 ;
    public final void rule__LabelBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6549:1: ( rule__LabelBlock__Group__1__Impl rule__LabelBlock__Group__2 )
            // InternalMetaDsl.g:6550:2: rule__LabelBlock__Group__1__Impl rule__LabelBlock__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__LabelBlock__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LabelBlock__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__1"


    // $ANTLR start "rule__LabelBlock__Group__1__Impl"
    // InternalMetaDsl.g:6557:1: rule__LabelBlock__Group__1__Impl : ( ( rule__LabelBlock__Alternatives_1 ) ) ;
    public final void rule__LabelBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6561:1: ( ( ( rule__LabelBlock__Alternatives_1 ) ) )
            // InternalMetaDsl.g:6562:1: ( ( rule__LabelBlock__Alternatives_1 ) )
            {
            // InternalMetaDsl.g:6562:1: ( ( rule__LabelBlock__Alternatives_1 ) )
            // InternalMetaDsl.g:6563:2: ( rule__LabelBlock__Alternatives_1 )
            {
             before(grammarAccess.getLabelBlockAccess().getAlternatives_1()); 
            // InternalMetaDsl.g:6564:2: ( rule__LabelBlock__Alternatives_1 )
            // InternalMetaDsl.g:6564:3: rule__LabelBlock__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__LabelBlock__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getLabelBlockAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__1__Impl"


    // $ANTLR start "rule__LabelBlock__Group__2"
    // InternalMetaDsl.g:6572:1: rule__LabelBlock__Group__2 : rule__LabelBlock__Group__2__Impl rule__LabelBlock__Group__3 ;
    public final void rule__LabelBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6576:1: ( rule__LabelBlock__Group__2__Impl rule__LabelBlock__Group__3 )
            // InternalMetaDsl.g:6577:2: rule__LabelBlock__Group__2__Impl rule__LabelBlock__Group__3
            {
            pushFollow(FOLLOW_57);
            rule__LabelBlock__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LabelBlock__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__2"


    // $ANTLR start "rule__LabelBlock__Group__2__Impl"
    // InternalMetaDsl.g:6584:1: rule__LabelBlock__Group__2__Impl : ( '{' ) ;
    public final void rule__LabelBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6588:1: ( ( '{' ) )
            // InternalMetaDsl.g:6589:1: ( '{' )
            {
            // InternalMetaDsl.g:6589:1: ( '{' )
            // InternalMetaDsl.g:6590:2: '{'
            {
             before(grammarAccess.getLabelBlockAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLabelBlockAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__2__Impl"


    // $ANTLR start "rule__LabelBlock__Group__3"
    // InternalMetaDsl.g:6599:1: rule__LabelBlock__Group__3 : rule__LabelBlock__Group__3__Impl rule__LabelBlock__Group__4 ;
    public final void rule__LabelBlock__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6603:1: ( rule__LabelBlock__Group__3__Impl rule__LabelBlock__Group__4 )
            // InternalMetaDsl.g:6604:2: rule__LabelBlock__Group__3__Impl rule__LabelBlock__Group__4
            {
            pushFollow(FOLLOW_57);
            rule__LabelBlock__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LabelBlock__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__3"


    // $ANTLR start "rule__LabelBlock__Group__3__Impl"
    // InternalMetaDsl.g:6611:1: rule__LabelBlock__Group__3__Impl : ( ( rule__LabelBlock__TypeAssignment_3 )? ) ;
    public final void rule__LabelBlock__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6615:1: ( ( ( rule__LabelBlock__TypeAssignment_3 )? ) )
            // InternalMetaDsl.g:6616:1: ( ( rule__LabelBlock__TypeAssignment_3 )? )
            {
            // InternalMetaDsl.g:6616:1: ( ( rule__LabelBlock__TypeAssignment_3 )? )
            // InternalMetaDsl.g:6617:2: ( rule__LabelBlock__TypeAssignment_3 )?
            {
             before(grammarAccess.getLabelBlockAccess().getTypeAssignment_3()); 
            // InternalMetaDsl.g:6618:2: ( rule__LabelBlock__TypeAssignment_3 )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=23 && LA79_0<=24)) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalMetaDsl.g:6618:3: rule__LabelBlock__TypeAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__LabelBlock__TypeAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLabelBlockAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__3__Impl"


    // $ANTLR start "rule__LabelBlock__Group__4"
    // InternalMetaDsl.g:6626:1: rule__LabelBlock__Group__4 : rule__LabelBlock__Group__4__Impl rule__LabelBlock__Group__5 ;
    public final void rule__LabelBlock__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6630:1: ( rule__LabelBlock__Group__4__Impl rule__LabelBlock__Group__5 )
            // InternalMetaDsl.g:6631:2: rule__LabelBlock__Group__4__Impl rule__LabelBlock__Group__5
            {
            pushFollow(FOLLOW_57);
            rule__LabelBlock__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LabelBlock__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__4"


    // $ANTLR start "rule__LabelBlock__Group__4__Impl"
    // InternalMetaDsl.g:6638:1: rule__LabelBlock__Group__4__Impl : ( ( rule__LabelBlock__LabelsAssignment_4 )* ) ;
    public final void rule__LabelBlock__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6642:1: ( ( ( rule__LabelBlock__LabelsAssignment_4 )* ) )
            // InternalMetaDsl.g:6643:1: ( ( rule__LabelBlock__LabelsAssignment_4 )* )
            {
            // InternalMetaDsl.g:6643:1: ( ( rule__LabelBlock__LabelsAssignment_4 )* )
            // InternalMetaDsl.g:6644:2: ( rule__LabelBlock__LabelsAssignment_4 )*
            {
             before(grammarAccess.getLabelBlockAccess().getLabelsAssignment_4()); 
            // InternalMetaDsl.g:6645:2: ( rule__LabelBlock__LabelsAssignment_4 )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==RULE_STRING||LA80_0==RULE_ID) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalMetaDsl.g:6645:3: rule__LabelBlock__LabelsAssignment_4
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__LabelBlock__LabelsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

             after(grammarAccess.getLabelBlockAccess().getLabelsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__4__Impl"


    // $ANTLR start "rule__LabelBlock__Group__5"
    // InternalMetaDsl.g:6653:1: rule__LabelBlock__Group__5 : rule__LabelBlock__Group__5__Impl ;
    public final void rule__LabelBlock__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6657:1: ( rule__LabelBlock__Group__5__Impl )
            // InternalMetaDsl.g:6658:2: rule__LabelBlock__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LabelBlock__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__5"


    // $ANTLR start "rule__LabelBlock__Group__5__Impl"
    // InternalMetaDsl.g:6664:1: rule__LabelBlock__Group__5__Impl : ( '}' ) ;
    public final void rule__LabelBlock__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6668:1: ( ( '}' ) )
            // InternalMetaDsl.g:6669:1: ( '}' )
            {
            // InternalMetaDsl.g:6669:1: ( '}' )
            // InternalMetaDsl.g:6670:2: '}'
            {
             before(grammarAccess.getLabelBlockAccess().getRightCurlyBracketKeyword_5()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getLabelBlockAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__Group__5__Impl"


    // $ANTLR start "rule__GeneralLabelSection__Group__0"
    // InternalMetaDsl.g:6680:1: rule__GeneralLabelSection__Group__0 : rule__GeneralLabelSection__Group__0__Impl rule__GeneralLabelSection__Group__1 ;
    public final void rule__GeneralLabelSection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6684:1: ( rule__GeneralLabelSection__Group__0__Impl rule__GeneralLabelSection__Group__1 )
            // InternalMetaDsl.g:6685:2: rule__GeneralLabelSection__Group__0__Impl rule__GeneralLabelSection__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__GeneralLabelSection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GeneralLabelSection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__0"


    // $ANTLR start "rule__GeneralLabelSection__Group__0__Impl"
    // InternalMetaDsl.g:6692:1: rule__GeneralLabelSection__Group__0__Impl : ( ( rule__GeneralLabelSection__NameAssignment_0 ) ) ;
    public final void rule__GeneralLabelSection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6696:1: ( ( ( rule__GeneralLabelSection__NameAssignment_0 ) ) )
            // InternalMetaDsl.g:6697:1: ( ( rule__GeneralLabelSection__NameAssignment_0 ) )
            {
            // InternalMetaDsl.g:6697:1: ( ( rule__GeneralLabelSection__NameAssignment_0 ) )
            // InternalMetaDsl.g:6698:2: ( rule__GeneralLabelSection__NameAssignment_0 )
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getNameAssignment_0()); 
            // InternalMetaDsl.g:6699:2: ( rule__GeneralLabelSection__NameAssignment_0 )
            // InternalMetaDsl.g:6699:3: rule__GeneralLabelSection__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__GeneralLabelSection__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getGeneralLabelSectionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__0__Impl"


    // $ANTLR start "rule__GeneralLabelSection__Group__1"
    // InternalMetaDsl.g:6707:1: rule__GeneralLabelSection__Group__1 : rule__GeneralLabelSection__Group__1__Impl rule__GeneralLabelSection__Group__2 ;
    public final void rule__GeneralLabelSection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6711:1: ( rule__GeneralLabelSection__Group__1__Impl rule__GeneralLabelSection__Group__2 )
            // InternalMetaDsl.g:6712:2: rule__GeneralLabelSection__Group__1__Impl rule__GeneralLabelSection__Group__2
            {
            pushFollow(FOLLOW_59);
            rule__GeneralLabelSection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GeneralLabelSection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__1"


    // $ANTLR start "rule__GeneralLabelSection__Group__1__Impl"
    // InternalMetaDsl.g:6719:1: rule__GeneralLabelSection__Group__1__Impl : ( '{' ) ;
    public final void rule__GeneralLabelSection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6723:1: ( ( '{' ) )
            // InternalMetaDsl.g:6724:1: ( '{' )
            {
            // InternalMetaDsl.g:6724:1: ( '{' )
            // InternalMetaDsl.g:6725:2: '{'
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getGeneralLabelSectionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__1__Impl"


    // $ANTLR start "rule__GeneralLabelSection__Group__2"
    // InternalMetaDsl.g:6734:1: rule__GeneralLabelSection__Group__2 : rule__GeneralLabelSection__Group__2__Impl rule__GeneralLabelSection__Group__3 ;
    public final void rule__GeneralLabelSection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6738:1: ( rule__GeneralLabelSection__Group__2__Impl rule__GeneralLabelSection__Group__3 )
            // InternalMetaDsl.g:6739:2: rule__GeneralLabelSection__Group__2__Impl rule__GeneralLabelSection__Group__3
            {
            pushFollow(FOLLOW_59);
            rule__GeneralLabelSection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GeneralLabelSection__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__2"


    // $ANTLR start "rule__GeneralLabelSection__Group__2__Impl"
    // InternalMetaDsl.g:6746:1: rule__GeneralLabelSection__Group__2__Impl : ( ( rule__GeneralLabelSection__KeyLabelAssignment_2 )* ) ;
    public final void rule__GeneralLabelSection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6750:1: ( ( ( rule__GeneralLabelSection__KeyLabelAssignment_2 )* ) )
            // InternalMetaDsl.g:6751:1: ( ( rule__GeneralLabelSection__KeyLabelAssignment_2 )* )
            {
            // InternalMetaDsl.g:6751:1: ( ( rule__GeneralLabelSection__KeyLabelAssignment_2 )* )
            // InternalMetaDsl.g:6752:2: ( rule__GeneralLabelSection__KeyLabelAssignment_2 )*
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getKeyLabelAssignment_2()); 
            // InternalMetaDsl.g:6753:2: ( rule__GeneralLabelSection__KeyLabelAssignment_2 )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==71) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalMetaDsl.g:6753:3: rule__GeneralLabelSection__KeyLabelAssignment_2
            	    {
            	    pushFollow(FOLLOW_60);
            	    rule__GeneralLabelSection__KeyLabelAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

             after(grammarAccess.getGeneralLabelSectionAccess().getKeyLabelAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__2__Impl"


    // $ANTLR start "rule__GeneralLabelSection__Group__3"
    // InternalMetaDsl.g:6761:1: rule__GeneralLabelSection__Group__3 : rule__GeneralLabelSection__Group__3__Impl rule__GeneralLabelSection__Group__4 ;
    public final void rule__GeneralLabelSection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6765:1: ( rule__GeneralLabelSection__Group__3__Impl rule__GeneralLabelSection__Group__4 )
            // InternalMetaDsl.g:6766:2: rule__GeneralLabelSection__Group__3__Impl rule__GeneralLabelSection__Group__4
            {
            pushFollow(FOLLOW_59);
            rule__GeneralLabelSection__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GeneralLabelSection__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__3"


    // $ANTLR start "rule__GeneralLabelSection__Group__3__Impl"
    // InternalMetaDsl.g:6773:1: rule__GeneralLabelSection__Group__3__Impl : ( ( rule__GeneralLabelSection__OverrideLabelBlockAssignment_3 )* ) ;
    public final void rule__GeneralLabelSection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6777:1: ( ( ( rule__GeneralLabelSection__OverrideLabelBlockAssignment_3 )* ) )
            // InternalMetaDsl.g:6778:1: ( ( rule__GeneralLabelSection__OverrideLabelBlockAssignment_3 )* )
            {
            // InternalMetaDsl.g:6778:1: ( ( rule__GeneralLabelSection__OverrideLabelBlockAssignment_3 )* )
            // InternalMetaDsl.g:6779:2: ( rule__GeneralLabelSection__OverrideLabelBlockAssignment_3 )*
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getOverrideLabelBlockAssignment_3()); 
            // InternalMetaDsl.g:6780:2: ( rule__GeneralLabelSection__OverrideLabelBlockAssignment_3 )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==25||(LA82_0>=72 && LA82_0<=73)) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalMetaDsl.g:6780:3: rule__GeneralLabelSection__OverrideLabelBlockAssignment_3
            	    {
            	    pushFollow(FOLLOW_61);
            	    rule__GeneralLabelSection__OverrideLabelBlockAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);

             after(grammarAccess.getGeneralLabelSectionAccess().getOverrideLabelBlockAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__3__Impl"


    // $ANTLR start "rule__GeneralLabelSection__Group__4"
    // InternalMetaDsl.g:6788:1: rule__GeneralLabelSection__Group__4 : rule__GeneralLabelSection__Group__4__Impl ;
    public final void rule__GeneralLabelSection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6792:1: ( rule__GeneralLabelSection__Group__4__Impl )
            // InternalMetaDsl.g:6793:2: rule__GeneralLabelSection__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GeneralLabelSection__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__4"


    // $ANTLR start "rule__GeneralLabelSection__Group__4__Impl"
    // InternalMetaDsl.g:6799:1: rule__GeneralLabelSection__Group__4__Impl : ( '}' ) ;
    public final void rule__GeneralLabelSection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6803:1: ( ( '}' ) )
            // InternalMetaDsl.g:6804:1: ( '}' )
            {
            // InternalMetaDsl.g:6804:1: ( '}' )
            // InternalMetaDsl.g:6805:2: '}'
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getGeneralLabelSectionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__Group__4__Impl"


    // $ANTLR start "rule__KeyLabel__Group__0"
    // InternalMetaDsl.g:6815:1: rule__KeyLabel__Group__0 : rule__KeyLabel__Group__0__Impl rule__KeyLabel__Group__1 ;
    public final void rule__KeyLabel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6819:1: ( rule__KeyLabel__Group__0__Impl rule__KeyLabel__Group__1 )
            // InternalMetaDsl.g:6820:2: rule__KeyLabel__Group__0__Impl rule__KeyLabel__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__KeyLabel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__KeyLabel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__0"


    // $ANTLR start "rule__KeyLabel__Group__0__Impl"
    // InternalMetaDsl.g:6827:1: rule__KeyLabel__Group__0__Impl : ( 'KEY' ) ;
    public final void rule__KeyLabel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6831:1: ( ( 'KEY' ) )
            // InternalMetaDsl.g:6832:1: ( 'KEY' )
            {
            // InternalMetaDsl.g:6832:1: ( 'KEY' )
            // InternalMetaDsl.g:6833:2: 'KEY'
            {
             before(grammarAccess.getKeyLabelAccess().getKEYKeyword_0()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getKeyLabelAccess().getKEYKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__0__Impl"


    // $ANTLR start "rule__KeyLabel__Group__1"
    // InternalMetaDsl.g:6842:1: rule__KeyLabel__Group__1 : rule__KeyLabel__Group__1__Impl rule__KeyLabel__Group__2 ;
    public final void rule__KeyLabel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6846:1: ( rule__KeyLabel__Group__1__Impl rule__KeyLabel__Group__2 )
            // InternalMetaDsl.g:6847:2: rule__KeyLabel__Group__1__Impl rule__KeyLabel__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__KeyLabel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__KeyLabel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__1"


    // $ANTLR start "rule__KeyLabel__Group__1__Impl"
    // InternalMetaDsl.g:6854:1: rule__KeyLabel__Group__1__Impl : ( ( rule__KeyLabel__KeyAssignment_1 ) ) ;
    public final void rule__KeyLabel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6858:1: ( ( ( rule__KeyLabel__KeyAssignment_1 ) ) )
            // InternalMetaDsl.g:6859:1: ( ( rule__KeyLabel__KeyAssignment_1 ) )
            {
            // InternalMetaDsl.g:6859:1: ( ( rule__KeyLabel__KeyAssignment_1 ) )
            // InternalMetaDsl.g:6860:2: ( rule__KeyLabel__KeyAssignment_1 )
            {
             before(grammarAccess.getKeyLabelAccess().getKeyAssignment_1()); 
            // InternalMetaDsl.g:6861:2: ( rule__KeyLabel__KeyAssignment_1 )
            // InternalMetaDsl.g:6861:3: rule__KeyLabel__KeyAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__KeyLabel__KeyAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getKeyLabelAccess().getKeyAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__1__Impl"


    // $ANTLR start "rule__KeyLabel__Group__2"
    // InternalMetaDsl.g:6869:1: rule__KeyLabel__Group__2 : rule__KeyLabel__Group__2__Impl rule__KeyLabel__Group__3 ;
    public final void rule__KeyLabel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6873:1: ( rule__KeyLabel__Group__2__Impl rule__KeyLabel__Group__3 )
            // InternalMetaDsl.g:6874:2: rule__KeyLabel__Group__2__Impl rule__KeyLabel__Group__3
            {
            pushFollow(FOLLOW_62);
            rule__KeyLabel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__KeyLabel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__2"


    // $ANTLR start "rule__KeyLabel__Group__2__Impl"
    // InternalMetaDsl.g:6881:1: rule__KeyLabel__Group__2__Impl : ( '{' ) ;
    public final void rule__KeyLabel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6885:1: ( ( '{' ) )
            // InternalMetaDsl.g:6886:1: ( '{' )
            {
            // InternalMetaDsl.g:6886:1: ( '{' )
            // InternalMetaDsl.g:6887:2: '{'
            {
             before(grammarAccess.getKeyLabelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getKeyLabelAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__2__Impl"


    // $ANTLR start "rule__KeyLabel__Group__3"
    // InternalMetaDsl.g:6896:1: rule__KeyLabel__Group__3 : rule__KeyLabel__Group__3__Impl rule__KeyLabel__Group__4 ;
    public final void rule__KeyLabel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6900:1: ( rule__KeyLabel__Group__3__Impl rule__KeyLabel__Group__4 )
            // InternalMetaDsl.g:6901:2: rule__KeyLabel__Group__3__Impl rule__KeyLabel__Group__4
            {
            pushFollow(FOLLOW_62);
            rule__KeyLabel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__KeyLabel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__3"


    // $ANTLR start "rule__KeyLabel__Group__3__Impl"
    // InternalMetaDsl.g:6908:1: rule__KeyLabel__Group__3__Impl : ( ( rule__KeyLabel__LabelsAssignment_3 )* ) ;
    public final void rule__KeyLabel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6912:1: ( ( ( rule__KeyLabel__LabelsAssignment_3 )* ) )
            // InternalMetaDsl.g:6913:1: ( ( rule__KeyLabel__LabelsAssignment_3 )* )
            {
            // InternalMetaDsl.g:6913:1: ( ( rule__KeyLabel__LabelsAssignment_3 )* )
            // InternalMetaDsl.g:6914:2: ( rule__KeyLabel__LabelsAssignment_3 )*
            {
             before(grammarAccess.getKeyLabelAccess().getLabelsAssignment_3()); 
            // InternalMetaDsl.g:6915:2: ( rule__KeyLabel__LabelsAssignment_3 )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==RULE_STRING||LA83_0==RULE_ID) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalMetaDsl.g:6915:3: rule__KeyLabel__LabelsAssignment_3
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__KeyLabel__LabelsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

             after(grammarAccess.getKeyLabelAccess().getLabelsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__3__Impl"


    // $ANTLR start "rule__KeyLabel__Group__4"
    // InternalMetaDsl.g:6923:1: rule__KeyLabel__Group__4 : rule__KeyLabel__Group__4__Impl ;
    public final void rule__KeyLabel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6927:1: ( rule__KeyLabel__Group__4__Impl )
            // InternalMetaDsl.g:6928:2: rule__KeyLabel__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__KeyLabel__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__4"


    // $ANTLR start "rule__KeyLabel__Group__4__Impl"
    // InternalMetaDsl.g:6934:1: rule__KeyLabel__Group__4__Impl : ( '}' ) ;
    public final void rule__KeyLabel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6938:1: ( ( '}' ) )
            // InternalMetaDsl.g:6939:1: ( '}' )
            {
            // InternalMetaDsl.g:6939:1: ( '}' )
            // InternalMetaDsl.g:6940:2: '}'
            {
             before(grammarAccess.getKeyLabelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getKeyLabelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__Group__4__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group__0"
    // InternalMetaDsl.g:6950:1: rule__OverrideLabelBlock__Group__0 : rule__OverrideLabelBlock__Group__0__Impl rule__OverrideLabelBlock__Group__1 ;
    public final void rule__OverrideLabelBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6954:1: ( rule__OverrideLabelBlock__Group__0__Impl rule__OverrideLabelBlock__Group__1 )
            // InternalMetaDsl.g:6955:2: rule__OverrideLabelBlock__Group__0__Impl rule__OverrideLabelBlock__Group__1
            {
            pushFollow(FOLLOW_63);
            rule__OverrideLabelBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__0"


    // $ANTLR start "rule__OverrideLabelBlock__Group__0__Impl"
    // InternalMetaDsl.g:6962:1: rule__OverrideLabelBlock__Group__0__Impl : ( () ) ;
    public final void rule__OverrideLabelBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6966:1: ( ( () ) )
            // InternalMetaDsl.g:6967:1: ( () )
            {
            // InternalMetaDsl.g:6967:1: ( () )
            // InternalMetaDsl.g:6968:2: ()
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getOverrideLabelBlockAction_0()); 
            // InternalMetaDsl.g:6969:2: ()
            // InternalMetaDsl.g:6969:3: 
            {
            }

             after(grammarAccess.getOverrideLabelBlockAccess().getOverrideLabelBlockAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__0__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group__1"
    // InternalMetaDsl.g:6977:1: rule__OverrideLabelBlock__Group__1 : rule__OverrideLabelBlock__Group__1__Impl rule__OverrideLabelBlock__Group__2 ;
    public final void rule__OverrideLabelBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6981:1: ( rule__OverrideLabelBlock__Group__1__Impl rule__OverrideLabelBlock__Group__2 )
            // InternalMetaDsl.g:6982:2: rule__OverrideLabelBlock__Group__1__Impl rule__OverrideLabelBlock__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__OverrideLabelBlock__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__1"


    // $ANTLR start "rule__OverrideLabelBlock__Group__1__Impl"
    // InternalMetaDsl.g:6989:1: rule__OverrideLabelBlock__Group__1__Impl : ( ( rule__OverrideLabelBlock__Alternatives_1 ) ) ;
    public final void rule__OverrideLabelBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:6993:1: ( ( ( rule__OverrideLabelBlock__Alternatives_1 ) ) )
            // InternalMetaDsl.g:6994:1: ( ( rule__OverrideLabelBlock__Alternatives_1 ) )
            {
            // InternalMetaDsl.g:6994:1: ( ( rule__OverrideLabelBlock__Alternatives_1 ) )
            // InternalMetaDsl.g:6995:2: ( rule__OverrideLabelBlock__Alternatives_1 )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getAlternatives_1()); 
            // InternalMetaDsl.g:6996:2: ( rule__OverrideLabelBlock__Alternatives_1 )
            // InternalMetaDsl.g:6996:3: rule__OverrideLabelBlock__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getOverrideLabelBlockAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__1__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group__2"
    // InternalMetaDsl.g:7004:1: rule__OverrideLabelBlock__Group__2 : rule__OverrideLabelBlock__Group__2__Impl rule__OverrideLabelBlock__Group__3 ;
    public final void rule__OverrideLabelBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7008:1: ( rule__OverrideLabelBlock__Group__2__Impl rule__OverrideLabelBlock__Group__3 )
            // InternalMetaDsl.g:7009:2: rule__OverrideLabelBlock__Group__2__Impl rule__OverrideLabelBlock__Group__3
            {
            pushFollow(FOLLOW_57);
            rule__OverrideLabelBlock__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__2"


    // $ANTLR start "rule__OverrideLabelBlock__Group__2__Impl"
    // InternalMetaDsl.g:7016:1: rule__OverrideLabelBlock__Group__2__Impl : ( '{' ) ;
    public final void rule__OverrideLabelBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7020:1: ( ( '{' ) )
            // InternalMetaDsl.g:7021:1: ( '{' )
            {
            // InternalMetaDsl.g:7021:1: ( '{' )
            // InternalMetaDsl.g:7022:2: '{'
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getOverrideLabelBlockAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__2__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group__3"
    // InternalMetaDsl.g:7031:1: rule__OverrideLabelBlock__Group__3 : rule__OverrideLabelBlock__Group__3__Impl rule__OverrideLabelBlock__Group__4 ;
    public final void rule__OverrideLabelBlock__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7035:1: ( rule__OverrideLabelBlock__Group__3__Impl rule__OverrideLabelBlock__Group__4 )
            // InternalMetaDsl.g:7036:2: rule__OverrideLabelBlock__Group__3__Impl rule__OverrideLabelBlock__Group__4
            {
            pushFollow(FOLLOW_57);
            rule__OverrideLabelBlock__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__3"


    // $ANTLR start "rule__OverrideLabelBlock__Group__3__Impl"
    // InternalMetaDsl.g:7043:1: rule__OverrideLabelBlock__Group__3__Impl : ( ( rule__OverrideLabelBlock__TypeAssignment_3 )? ) ;
    public final void rule__OverrideLabelBlock__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7047:1: ( ( ( rule__OverrideLabelBlock__TypeAssignment_3 )? ) )
            // InternalMetaDsl.g:7048:1: ( ( rule__OverrideLabelBlock__TypeAssignment_3 )? )
            {
            // InternalMetaDsl.g:7048:1: ( ( rule__OverrideLabelBlock__TypeAssignment_3 )? )
            // InternalMetaDsl.g:7049:2: ( rule__OverrideLabelBlock__TypeAssignment_3 )?
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getTypeAssignment_3()); 
            // InternalMetaDsl.g:7050:2: ( rule__OverrideLabelBlock__TypeAssignment_3 )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=23 && LA84_0<=24)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalMetaDsl.g:7050:3: rule__OverrideLabelBlock__TypeAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__OverrideLabelBlock__TypeAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOverrideLabelBlockAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__3__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group__4"
    // InternalMetaDsl.g:7058:1: rule__OverrideLabelBlock__Group__4 : rule__OverrideLabelBlock__Group__4__Impl rule__OverrideLabelBlock__Group__5 ;
    public final void rule__OverrideLabelBlock__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7062:1: ( rule__OverrideLabelBlock__Group__4__Impl rule__OverrideLabelBlock__Group__5 )
            // InternalMetaDsl.g:7063:2: rule__OverrideLabelBlock__Group__4__Impl rule__OverrideLabelBlock__Group__5
            {
            pushFollow(FOLLOW_57);
            rule__OverrideLabelBlock__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__4"


    // $ANTLR start "rule__OverrideLabelBlock__Group__4__Impl"
    // InternalMetaDsl.g:7070:1: rule__OverrideLabelBlock__Group__4__Impl : ( ( rule__OverrideLabelBlock__LabelsAssignment_4 )* ) ;
    public final void rule__OverrideLabelBlock__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7074:1: ( ( ( rule__OverrideLabelBlock__LabelsAssignment_4 )* ) )
            // InternalMetaDsl.g:7075:1: ( ( rule__OverrideLabelBlock__LabelsAssignment_4 )* )
            {
            // InternalMetaDsl.g:7075:1: ( ( rule__OverrideLabelBlock__LabelsAssignment_4 )* )
            // InternalMetaDsl.g:7076:2: ( rule__OverrideLabelBlock__LabelsAssignment_4 )*
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getLabelsAssignment_4()); 
            // InternalMetaDsl.g:7077:2: ( rule__OverrideLabelBlock__LabelsAssignment_4 )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==RULE_STRING||LA85_0==RULE_ID) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalMetaDsl.g:7077:3: rule__OverrideLabelBlock__LabelsAssignment_4
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__OverrideLabelBlock__LabelsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);

             after(grammarAccess.getOverrideLabelBlockAccess().getLabelsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__4__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group__5"
    // InternalMetaDsl.g:7085:1: rule__OverrideLabelBlock__Group__5 : rule__OverrideLabelBlock__Group__5__Impl ;
    public final void rule__OverrideLabelBlock__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7089:1: ( rule__OverrideLabelBlock__Group__5__Impl )
            // InternalMetaDsl.g:7090:2: rule__OverrideLabelBlock__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__5"


    // $ANTLR start "rule__OverrideLabelBlock__Group__5__Impl"
    // InternalMetaDsl.g:7096:1: rule__OverrideLabelBlock__Group__5__Impl : ( '}' ) ;
    public final void rule__OverrideLabelBlock__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7100:1: ( ( '}' ) )
            // InternalMetaDsl.g:7101:1: ( '}' )
            {
            // InternalMetaDsl.g:7101:1: ( '}' )
            // InternalMetaDsl.g:7102:2: '}'
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getRightCurlyBracketKeyword_5()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getOverrideLabelBlockAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group__5__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_0__0"
    // InternalMetaDsl.g:7112:1: rule__OverrideLabelBlock__Group_1_0__0 : rule__OverrideLabelBlock__Group_1_0__0__Impl rule__OverrideLabelBlock__Group_1_0__1 ;
    public final void rule__OverrideLabelBlock__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7116:1: ( rule__OverrideLabelBlock__Group_1_0__0__Impl rule__OverrideLabelBlock__Group_1_0__1 )
            // InternalMetaDsl.g:7117:2: rule__OverrideLabelBlock__Group_1_0__0__Impl rule__OverrideLabelBlock__Group_1_0__1
            {
            pushFollow(FOLLOW_20);
            rule__OverrideLabelBlock__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_0__0"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_0__0__Impl"
    // InternalMetaDsl.g:7124:1: rule__OverrideLabelBlock__Group_1_0__0__Impl : ( 'ATTRIBUTE' ) ;
    public final void rule__OverrideLabelBlock__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7128:1: ( ( 'ATTRIBUTE' ) )
            // InternalMetaDsl.g:7129:1: ( 'ATTRIBUTE' )
            {
            // InternalMetaDsl.g:7129:1: ( 'ATTRIBUTE' )
            // InternalMetaDsl.g:7130:2: 'ATTRIBUTE'
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getATTRIBUTEKeyword_1_0_0()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getOverrideLabelBlockAccess().getATTRIBUTEKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_0__0__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_0__1"
    // InternalMetaDsl.g:7139:1: rule__OverrideLabelBlock__Group_1_0__1 : rule__OverrideLabelBlock__Group_1_0__1__Impl ;
    public final void rule__OverrideLabelBlock__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7143:1: ( rule__OverrideLabelBlock__Group_1_0__1__Impl )
            // InternalMetaDsl.g:7144:2: rule__OverrideLabelBlock__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_0__1"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_0__1__Impl"
    // InternalMetaDsl.g:7150:1: rule__OverrideLabelBlock__Group_1_0__1__Impl : ( ( rule__OverrideLabelBlock__AttributeAssignment_1_0_1 ) ) ;
    public final void rule__OverrideLabelBlock__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7154:1: ( ( ( rule__OverrideLabelBlock__AttributeAssignment_1_0_1 ) ) )
            // InternalMetaDsl.g:7155:1: ( ( rule__OverrideLabelBlock__AttributeAssignment_1_0_1 ) )
            {
            // InternalMetaDsl.g:7155:1: ( ( rule__OverrideLabelBlock__AttributeAssignment_1_0_1 ) )
            // InternalMetaDsl.g:7156:2: ( rule__OverrideLabelBlock__AttributeAssignment_1_0_1 )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getAttributeAssignment_1_0_1()); 
            // InternalMetaDsl.g:7157:2: ( rule__OverrideLabelBlock__AttributeAssignment_1_0_1 )
            // InternalMetaDsl.g:7157:3: rule__OverrideLabelBlock__AttributeAssignment_1_0_1
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__AttributeAssignment_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getOverrideLabelBlockAccess().getAttributeAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_0__1__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_1__0"
    // InternalMetaDsl.g:7166:1: rule__OverrideLabelBlock__Group_1_1__0 : rule__OverrideLabelBlock__Group_1_1__0__Impl rule__OverrideLabelBlock__Group_1_1__1 ;
    public final void rule__OverrideLabelBlock__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7170:1: ( rule__OverrideLabelBlock__Group_1_1__0__Impl rule__OverrideLabelBlock__Group_1_1__1 )
            // InternalMetaDsl.g:7171:2: rule__OverrideLabelBlock__Group_1_1__0__Impl rule__OverrideLabelBlock__Group_1_1__1
            {
            pushFollow(FOLLOW_20);
            rule__OverrideLabelBlock__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_1__0"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_1__0__Impl"
    // InternalMetaDsl.g:7178:1: rule__OverrideLabelBlock__Group_1_1__0__Impl : ( 'ENTITY' ) ;
    public final void rule__OverrideLabelBlock__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7182:1: ( ( 'ENTITY' ) )
            // InternalMetaDsl.g:7183:1: ( 'ENTITY' )
            {
            // InternalMetaDsl.g:7183:1: ( 'ENTITY' )
            // InternalMetaDsl.g:7184:2: 'ENTITY'
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getENTITYKeyword_1_1_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getOverrideLabelBlockAccess().getENTITYKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_1__0__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_1__1"
    // InternalMetaDsl.g:7193:1: rule__OverrideLabelBlock__Group_1_1__1 : rule__OverrideLabelBlock__Group_1_1__1__Impl ;
    public final void rule__OverrideLabelBlock__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7197:1: ( rule__OverrideLabelBlock__Group_1_1__1__Impl )
            // InternalMetaDsl.g:7198:2: rule__OverrideLabelBlock__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_1__1"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_1__1__Impl"
    // InternalMetaDsl.g:7204:1: rule__OverrideLabelBlock__Group_1_1__1__Impl : ( ( rule__OverrideLabelBlock__EntityAssignment_1_1_1 ) ) ;
    public final void rule__OverrideLabelBlock__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7208:1: ( ( ( rule__OverrideLabelBlock__EntityAssignment_1_1_1 ) ) )
            // InternalMetaDsl.g:7209:1: ( ( rule__OverrideLabelBlock__EntityAssignment_1_1_1 ) )
            {
            // InternalMetaDsl.g:7209:1: ( ( rule__OverrideLabelBlock__EntityAssignment_1_1_1 ) )
            // InternalMetaDsl.g:7210:2: ( rule__OverrideLabelBlock__EntityAssignment_1_1_1 )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getEntityAssignment_1_1_1()); 
            // InternalMetaDsl.g:7211:2: ( rule__OverrideLabelBlock__EntityAssignment_1_1_1 )
            // InternalMetaDsl.g:7211:3: rule__OverrideLabelBlock__EntityAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__EntityAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOverrideLabelBlockAccess().getEntityAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_1__1__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_2__0"
    // InternalMetaDsl.g:7220:1: rule__OverrideLabelBlock__Group_1_2__0 : rule__OverrideLabelBlock__Group_1_2__0__Impl rule__OverrideLabelBlock__Group_1_2__1 ;
    public final void rule__OverrideLabelBlock__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7224:1: ( rule__OverrideLabelBlock__Group_1_2__0__Impl rule__OverrideLabelBlock__Group_1_2__1 )
            // InternalMetaDsl.g:7225:2: rule__OverrideLabelBlock__Group_1_2__0__Impl rule__OverrideLabelBlock__Group_1_2__1
            {
            pushFollow(FOLLOW_20);
            rule__OverrideLabelBlock__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_2__0"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_2__0__Impl"
    // InternalMetaDsl.g:7232:1: rule__OverrideLabelBlock__Group_1_2__0__Impl : ( 'ENUMERATIONITEM' ) ;
    public final void rule__OverrideLabelBlock__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7236:1: ( ( 'ENUMERATIONITEM' ) )
            // InternalMetaDsl.g:7237:1: ( 'ENUMERATIONITEM' )
            {
            // InternalMetaDsl.g:7237:1: ( 'ENUMERATIONITEM' )
            // InternalMetaDsl.g:7238:2: 'ENUMERATIONITEM'
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getENUMERATIONITEMKeyword_1_2_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getOverrideLabelBlockAccess().getENUMERATIONITEMKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_2__0__Impl"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_2__1"
    // InternalMetaDsl.g:7247:1: rule__OverrideLabelBlock__Group_1_2__1 : rule__OverrideLabelBlock__Group_1_2__1__Impl ;
    public final void rule__OverrideLabelBlock__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7251:1: ( rule__OverrideLabelBlock__Group_1_2__1__Impl )
            // InternalMetaDsl.g:7252:2: rule__OverrideLabelBlock__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__Group_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_2__1"


    // $ANTLR start "rule__OverrideLabelBlock__Group_1_2__1__Impl"
    // InternalMetaDsl.g:7258:1: rule__OverrideLabelBlock__Group_1_2__1__Impl : ( ( rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1 ) ) ;
    public final void rule__OverrideLabelBlock__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7262:1: ( ( ( rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1 ) ) )
            // InternalMetaDsl.g:7263:1: ( ( rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1 ) )
            {
            // InternalMetaDsl.g:7263:1: ( ( rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1 ) )
            // InternalMetaDsl.g:7264:2: ( rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1 )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getEnuMetadataRowAssignment_1_2_1()); 
            // InternalMetaDsl.g:7265:2: ( rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1 )
            // InternalMetaDsl.g:7265:3: rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getOverrideLabelBlockAccess().getEnuMetadataRowAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__Group_1_2__1__Impl"


    // $ANTLR start "rule__EnumerationLabels__Group__0"
    // InternalMetaDsl.g:7274:1: rule__EnumerationLabels__Group__0 : rule__EnumerationLabels__Group__0__Impl rule__EnumerationLabels__Group__1 ;
    public final void rule__EnumerationLabels__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7278:1: ( rule__EnumerationLabels__Group__0__Impl rule__EnumerationLabels__Group__1 )
            // InternalMetaDsl.g:7279:2: rule__EnumerationLabels__Group__0__Impl rule__EnumerationLabels__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EnumerationLabels__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationLabels__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__Group__0"


    // $ANTLR start "rule__EnumerationLabels__Group__0__Impl"
    // InternalMetaDsl.g:7286:1: rule__EnumerationLabels__Group__0__Impl : ( 'ENULABELS' ) ;
    public final void rule__EnumerationLabels__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7290:1: ( ( 'ENULABELS' ) )
            // InternalMetaDsl.g:7291:1: ( 'ENULABELS' )
            {
            // InternalMetaDsl.g:7291:1: ( 'ENULABELS' )
            // InternalMetaDsl.g:7292:2: 'ENULABELS'
            {
             before(grammarAccess.getEnumerationLabelsAccess().getENULABELSKeyword_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getEnumerationLabelsAccess().getENULABELSKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__Group__0__Impl"


    // $ANTLR start "rule__EnumerationLabels__Group__1"
    // InternalMetaDsl.g:7301:1: rule__EnumerationLabels__Group__1 : rule__EnumerationLabels__Group__1__Impl rule__EnumerationLabels__Group__2 ;
    public final void rule__EnumerationLabels__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7305:1: ( rule__EnumerationLabels__Group__1__Impl rule__EnumerationLabels__Group__2 )
            // InternalMetaDsl.g:7306:2: rule__EnumerationLabels__Group__1__Impl rule__EnumerationLabels__Group__2
            {
            pushFollow(FOLLOW_64);
            rule__EnumerationLabels__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationLabels__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__Group__1"


    // $ANTLR start "rule__EnumerationLabels__Group__1__Impl"
    // InternalMetaDsl.g:7313:1: rule__EnumerationLabels__Group__1__Impl : ( '{' ) ;
    public final void rule__EnumerationLabels__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7317:1: ( ( '{' ) )
            // InternalMetaDsl.g:7318:1: ( '{' )
            {
            // InternalMetaDsl.g:7318:1: ( '{' )
            // InternalMetaDsl.g:7319:2: '{'
            {
             before(grammarAccess.getEnumerationLabelsAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEnumerationLabelsAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__Group__1__Impl"


    // $ANTLR start "rule__EnumerationLabels__Group__2"
    // InternalMetaDsl.g:7328:1: rule__EnumerationLabels__Group__2 : rule__EnumerationLabels__Group__2__Impl rule__EnumerationLabels__Group__3 ;
    public final void rule__EnumerationLabels__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7332:1: ( rule__EnumerationLabels__Group__2__Impl rule__EnumerationLabels__Group__3 )
            // InternalMetaDsl.g:7333:2: rule__EnumerationLabels__Group__2__Impl rule__EnumerationLabels__Group__3
            {
            pushFollow(FOLLOW_64);
            rule__EnumerationLabels__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationLabels__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__Group__2"


    // $ANTLR start "rule__EnumerationLabels__Group__2__Impl"
    // InternalMetaDsl.g:7340:1: rule__EnumerationLabels__Group__2__Impl : ( ( rule__EnumerationLabels__EnumerationLabelAssignment_2 )* ) ;
    public final void rule__EnumerationLabels__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7344:1: ( ( ( rule__EnumerationLabels__EnumerationLabelAssignment_2 )* ) )
            // InternalMetaDsl.g:7345:1: ( ( rule__EnumerationLabels__EnumerationLabelAssignment_2 )* )
            {
            // InternalMetaDsl.g:7345:1: ( ( rule__EnumerationLabels__EnumerationLabelAssignment_2 )* )
            // InternalMetaDsl.g:7346:2: ( rule__EnumerationLabels__EnumerationLabelAssignment_2 )*
            {
             before(grammarAccess.getEnumerationLabelsAccess().getEnumerationLabelAssignment_2()); 
            // InternalMetaDsl.g:7347:2: ( rule__EnumerationLabels__EnumerationLabelAssignment_2 )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==RULE_ID) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalMetaDsl.g:7347:3: rule__EnumerationLabels__EnumerationLabelAssignment_2
            	    {
            	    pushFollow(FOLLOW_65);
            	    rule__EnumerationLabels__EnumerationLabelAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);

             after(grammarAccess.getEnumerationLabelsAccess().getEnumerationLabelAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__Group__2__Impl"


    // $ANTLR start "rule__EnumerationLabels__Group__3"
    // InternalMetaDsl.g:7355:1: rule__EnumerationLabels__Group__3 : rule__EnumerationLabels__Group__3__Impl ;
    public final void rule__EnumerationLabels__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7359:1: ( rule__EnumerationLabels__Group__3__Impl )
            // InternalMetaDsl.g:7360:2: rule__EnumerationLabels__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationLabels__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__Group__3"


    // $ANTLR start "rule__EnumerationLabels__Group__3__Impl"
    // InternalMetaDsl.g:7366:1: rule__EnumerationLabels__Group__3__Impl : ( '}' ) ;
    public final void rule__EnumerationLabels__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7370:1: ( ( '}' ) )
            // InternalMetaDsl.g:7371:1: ( '}' )
            {
            // InternalMetaDsl.g:7371:1: ( '}' )
            // InternalMetaDsl.g:7372:2: '}'
            {
             before(grammarAccess.getEnumerationLabelsAccess().getRightCurlyBracketKeyword_3()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getEnumerationLabelsAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__Group__3__Impl"


    // $ANTLR start "rule__EnumerationLabel__Group__0"
    // InternalMetaDsl.g:7382:1: rule__EnumerationLabel__Group__0 : rule__EnumerationLabel__Group__0__Impl rule__EnumerationLabel__Group__1 ;
    public final void rule__EnumerationLabel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7386:1: ( rule__EnumerationLabel__Group__0__Impl rule__EnumerationLabel__Group__1 )
            // InternalMetaDsl.g:7387:2: rule__EnumerationLabel__Group__0__Impl rule__EnumerationLabel__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EnumerationLabel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationLabel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__0"


    // $ANTLR start "rule__EnumerationLabel__Group__0__Impl"
    // InternalMetaDsl.g:7394:1: rule__EnumerationLabel__Group__0__Impl : ( ( rule__EnumerationLabel__EnuMetadataRowAssignment_0 ) ) ;
    public final void rule__EnumerationLabel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7398:1: ( ( ( rule__EnumerationLabel__EnuMetadataRowAssignment_0 ) ) )
            // InternalMetaDsl.g:7399:1: ( ( rule__EnumerationLabel__EnuMetadataRowAssignment_0 ) )
            {
            // InternalMetaDsl.g:7399:1: ( ( rule__EnumerationLabel__EnuMetadataRowAssignment_0 ) )
            // InternalMetaDsl.g:7400:2: ( rule__EnumerationLabel__EnuMetadataRowAssignment_0 )
            {
             before(grammarAccess.getEnumerationLabelAccess().getEnuMetadataRowAssignment_0()); 
            // InternalMetaDsl.g:7401:2: ( rule__EnumerationLabel__EnuMetadataRowAssignment_0 )
            // InternalMetaDsl.g:7401:3: rule__EnumerationLabel__EnuMetadataRowAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationLabel__EnuMetadataRowAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationLabelAccess().getEnuMetadataRowAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__0__Impl"


    // $ANTLR start "rule__EnumerationLabel__Group__1"
    // InternalMetaDsl.g:7409:1: rule__EnumerationLabel__Group__1 : rule__EnumerationLabel__Group__1__Impl rule__EnumerationLabel__Group__2 ;
    public final void rule__EnumerationLabel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7413:1: ( rule__EnumerationLabel__Group__1__Impl rule__EnumerationLabel__Group__2 )
            // InternalMetaDsl.g:7414:2: rule__EnumerationLabel__Group__1__Impl rule__EnumerationLabel__Group__2
            {
            pushFollow(FOLLOW_57);
            rule__EnumerationLabel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationLabel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__1"


    // $ANTLR start "rule__EnumerationLabel__Group__1__Impl"
    // InternalMetaDsl.g:7421:1: rule__EnumerationLabel__Group__1__Impl : ( '{' ) ;
    public final void rule__EnumerationLabel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7425:1: ( ( '{' ) )
            // InternalMetaDsl.g:7426:1: ( '{' )
            {
            // InternalMetaDsl.g:7426:1: ( '{' )
            // InternalMetaDsl.g:7427:2: '{'
            {
             before(grammarAccess.getEnumerationLabelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEnumerationLabelAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__1__Impl"


    // $ANTLR start "rule__EnumerationLabel__Group__2"
    // InternalMetaDsl.g:7436:1: rule__EnumerationLabel__Group__2 : rule__EnumerationLabel__Group__2__Impl rule__EnumerationLabel__Group__3 ;
    public final void rule__EnumerationLabel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7440:1: ( rule__EnumerationLabel__Group__2__Impl rule__EnumerationLabel__Group__3 )
            // InternalMetaDsl.g:7441:2: rule__EnumerationLabel__Group__2__Impl rule__EnumerationLabel__Group__3
            {
            pushFollow(FOLLOW_57);
            rule__EnumerationLabel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationLabel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__2"


    // $ANTLR start "rule__EnumerationLabel__Group__2__Impl"
    // InternalMetaDsl.g:7448:1: rule__EnumerationLabel__Group__2__Impl : ( ( rule__EnumerationLabel__TypeAssignment_2 )? ) ;
    public final void rule__EnumerationLabel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7452:1: ( ( ( rule__EnumerationLabel__TypeAssignment_2 )? ) )
            // InternalMetaDsl.g:7453:1: ( ( rule__EnumerationLabel__TypeAssignment_2 )? )
            {
            // InternalMetaDsl.g:7453:1: ( ( rule__EnumerationLabel__TypeAssignment_2 )? )
            // InternalMetaDsl.g:7454:2: ( rule__EnumerationLabel__TypeAssignment_2 )?
            {
             before(grammarAccess.getEnumerationLabelAccess().getTypeAssignment_2()); 
            // InternalMetaDsl.g:7455:2: ( rule__EnumerationLabel__TypeAssignment_2 )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( ((LA87_0>=23 && LA87_0<=24)) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalMetaDsl.g:7455:3: rule__EnumerationLabel__TypeAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__EnumerationLabel__TypeAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumerationLabelAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__2__Impl"


    // $ANTLR start "rule__EnumerationLabel__Group__3"
    // InternalMetaDsl.g:7463:1: rule__EnumerationLabel__Group__3 : rule__EnumerationLabel__Group__3__Impl rule__EnumerationLabel__Group__4 ;
    public final void rule__EnumerationLabel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7467:1: ( rule__EnumerationLabel__Group__3__Impl rule__EnumerationLabel__Group__4 )
            // InternalMetaDsl.g:7468:2: rule__EnumerationLabel__Group__3__Impl rule__EnumerationLabel__Group__4
            {
            pushFollow(FOLLOW_57);
            rule__EnumerationLabel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationLabel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__3"


    // $ANTLR start "rule__EnumerationLabel__Group__3__Impl"
    // InternalMetaDsl.g:7475:1: rule__EnumerationLabel__Group__3__Impl : ( ( rule__EnumerationLabel__LabelsAssignment_3 )* ) ;
    public final void rule__EnumerationLabel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7479:1: ( ( ( rule__EnumerationLabel__LabelsAssignment_3 )* ) )
            // InternalMetaDsl.g:7480:1: ( ( rule__EnumerationLabel__LabelsAssignment_3 )* )
            {
            // InternalMetaDsl.g:7480:1: ( ( rule__EnumerationLabel__LabelsAssignment_3 )* )
            // InternalMetaDsl.g:7481:2: ( rule__EnumerationLabel__LabelsAssignment_3 )*
            {
             before(grammarAccess.getEnumerationLabelAccess().getLabelsAssignment_3()); 
            // InternalMetaDsl.g:7482:2: ( rule__EnumerationLabel__LabelsAssignment_3 )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==RULE_STRING||LA88_0==RULE_ID) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalMetaDsl.g:7482:3: rule__EnumerationLabel__LabelsAssignment_3
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__EnumerationLabel__LabelsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

             after(grammarAccess.getEnumerationLabelAccess().getLabelsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__3__Impl"


    // $ANTLR start "rule__EnumerationLabel__Group__4"
    // InternalMetaDsl.g:7490:1: rule__EnumerationLabel__Group__4 : rule__EnumerationLabel__Group__4__Impl ;
    public final void rule__EnumerationLabel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7494:1: ( rule__EnumerationLabel__Group__4__Impl )
            // InternalMetaDsl.g:7495:2: rule__EnumerationLabel__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationLabel__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__4"


    // $ANTLR start "rule__EnumerationLabel__Group__4__Impl"
    // InternalMetaDsl.g:7501:1: rule__EnumerationLabel__Group__4__Impl : ( '}' ) ;
    public final void rule__EnumerationLabel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7505:1: ( ( '}' ) )
            // InternalMetaDsl.g:7506:1: ( '}' )
            {
            // InternalMetaDsl.g:7506:1: ( '}' )
            // InternalMetaDsl.g:7507:2: '}'
            {
             before(grammarAccess.getEnumerationLabelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getEnumerationLabelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__Group__4__Impl"


    // $ANTLR start "rule__Label__Group__0"
    // InternalMetaDsl.g:7517:1: rule__Label__Group__0 : rule__Label__Group__0__Impl rule__Label__Group__1 ;
    public final void rule__Label__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7521:1: ( rule__Label__Group__0__Impl rule__Label__Group__1 )
            // InternalMetaDsl.g:7522:2: rule__Label__Group__0__Impl rule__Label__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__Label__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Label__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__0"


    // $ANTLR start "rule__Label__Group__0__Impl"
    // InternalMetaDsl.g:7529:1: rule__Label__Group__0__Impl : ( ( rule__Label__LangAssignment_0 )? ) ;
    public final void rule__Label__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7533:1: ( ( ( rule__Label__LangAssignment_0 )? ) )
            // InternalMetaDsl.g:7534:1: ( ( rule__Label__LangAssignment_0 )? )
            {
            // InternalMetaDsl.g:7534:1: ( ( rule__Label__LangAssignment_0 )? )
            // InternalMetaDsl.g:7535:2: ( rule__Label__LangAssignment_0 )?
            {
             before(grammarAccess.getLabelAccess().getLangAssignment_0()); 
            // InternalMetaDsl.g:7536:2: ( rule__Label__LangAssignment_0 )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_ID) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalMetaDsl.g:7536:3: rule__Label__LangAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Label__LangAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLabelAccess().getLangAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__0__Impl"


    // $ANTLR start "rule__Label__Group__1"
    // InternalMetaDsl.g:7544:1: rule__Label__Group__1 : rule__Label__Group__1__Impl ;
    public final void rule__Label__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7548:1: ( rule__Label__Group__1__Impl )
            // InternalMetaDsl.g:7549:2: rule__Label__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Label__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__1"


    // $ANTLR start "rule__Label__Group__1__Impl"
    // InternalMetaDsl.g:7555:1: rule__Label__Group__1__Impl : ( ( rule__Label__LabelTextAssignment_1 ) ) ;
    public final void rule__Label__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7559:1: ( ( ( rule__Label__LabelTextAssignment_1 ) ) )
            // InternalMetaDsl.g:7560:1: ( ( rule__Label__LabelTextAssignment_1 ) )
            {
            // InternalMetaDsl.g:7560:1: ( ( rule__Label__LabelTextAssignment_1 ) )
            // InternalMetaDsl.g:7561:2: ( rule__Label__LabelTextAssignment_1 )
            {
             before(grammarAccess.getLabelAccess().getLabelTextAssignment_1()); 
            // InternalMetaDsl.g:7562:2: ( rule__Label__LabelTextAssignment_1 )
            // InternalMetaDsl.g:7562:3: rule__Label__LabelTextAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Label__LabelTextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLabelAccess().getLabelTextAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__1__Impl"


    // $ANTLR start "rule__DocumentationSection__Group__0"
    // InternalMetaDsl.g:7571:1: rule__DocumentationSection__Group__0 : rule__DocumentationSection__Group__0__Impl rule__DocumentationSection__Group__1 ;
    public final void rule__DocumentationSection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7575:1: ( rule__DocumentationSection__Group__0__Impl rule__DocumentationSection__Group__1 )
            // InternalMetaDsl.g:7576:2: rule__DocumentationSection__Group__0__Impl rule__DocumentationSection__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__DocumentationSection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DocumentationSection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__Group__0"


    // $ANTLR start "rule__DocumentationSection__Group__0__Impl"
    // InternalMetaDsl.g:7583:1: rule__DocumentationSection__Group__0__Impl : ( ( rule__DocumentationSection__NameAssignment_0 ) ) ;
    public final void rule__DocumentationSection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7587:1: ( ( ( rule__DocumentationSection__NameAssignment_0 ) ) )
            // InternalMetaDsl.g:7588:1: ( ( rule__DocumentationSection__NameAssignment_0 ) )
            {
            // InternalMetaDsl.g:7588:1: ( ( rule__DocumentationSection__NameAssignment_0 ) )
            // InternalMetaDsl.g:7589:2: ( rule__DocumentationSection__NameAssignment_0 )
            {
             before(grammarAccess.getDocumentationSectionAccess().getNameAssignment_0()); 
            // InternalMetaDsl.g:7590:2: ( rule__DocumentationSection__NameAssignment_0 )
            // InternalMetaDsl.g:7590:3: rule__DocumentationSection__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DocumentationSection__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationSectionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__Group__0__Impl"


    // $ANTLR start "rule__DocumentationSection__Group__1"
    // InternalMetaDsl.g:7598:1: rule__DocumentationSection__Group__1 : rule__DocumentationSection__Group__1__Impl rule__DocumentationSection__Group__2 ;
    public final void rule__DocumentationSection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7602:1: ( rule__DocumentationSection__Group__1__Impl rule__DocumentationSection__Group__2 )
            // InternalMetaDsl.g:7603:2: rule__DocumentationSection__Group__1__Impl rule__DocumentationSection__Group__2
            {
            pushFollow(FOLLOW_54);
            rule__DocumentationSection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DocumentationSection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__Group__1"


    // $ANTLR start "rule__DocumentationSection__Group__1__Impl"
    // InternalMetaDsl.g:7610:1: rule__DocumentationSection__Group__1__Impl : ( '{' ) ;
    public final void rule__DocumentationSection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7614:1: ( ( '{' ) )
            // InternalMetaDsl.g:7615:1: ( '{' )
            {
            // InternalMetaDsl.g:7615:1: ( '{' )
            // InternalMetaDsl.g:7616:2: '{'
            {
             before(grammarAccess.getDocumentationSectionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getDocumentationSectionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__Group__1__Impl"


    // $ANTLR start "rule__DocumentationSection__Group__2"
    // InternalMetaDsl.g:7625:1: rule__DocumentationSection__Group__2 : rule__DocumentationSection__Group__2__Impl rule__DocumentationSection__Group__3 ;
    public final void rule__DocumentationSection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7629:1: ( rule__DocumentationSection__Group__2__Impl rule__DocumentationSection__Group__3 )
            // InternalMetaDsl.g:7630:2: rule__DocumentationSection__Group__2__Impl rule__DocumentationSection__Group__3
            {
            pushFollow(FOLLOW_55);
            rule__DocumentationSection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DocumentationSection__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__Group__2"


    // $ANTLR start "rule__DocumentationSection__Group__2__Impl"
    // InternalMetaDsl.g:7637:1: rule__DocumentationSection__Group__2__Impl : ( ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 ) ) ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )* ) ) ;
    public final void rule__DocumentationSection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7641:1: ( ( ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 ) ) ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )* ) ) )
            // InternalMetaDsl.g:7642:1: ( ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 ) ) ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )* ) )
            {
            // InternalMetaDsl.g:7642:1: ( ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 ) ) ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )* ) )
            // InternalMetaDsl.g:7643:2: ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 ) ) ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )* )
            {
            // InternalMetaDsl.g:7643:2: ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 ) )
            // InternalMetaDsl.g:7644:3: ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )
            {
             before(grammarAccess.getDocumentationSectionAccess().getDocumentationBlocksAssignment_2()); 
            // InternalMetaDsl.g:7645:3: ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )
            // InternalMetaDsl.g:7645:4: rule__DocumentationSection__DocumentationBlocksAssignment_2
            {
            pushFollow(FOLLOW_56);
            rule__DocumentationSection__DocumentationBlocksAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationSectionAccess().getDocumentationBlocksAssignment_2()); 

            }

            // InternalMetaDsl.g:7648:2: ( ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )* )
            // InternalMetaDsl.g:7649:3: ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )*
            {
             before(grammarAccess.getDocumentationSectionAccess().getDocumentationBlocksAssignment_2()); 
            // InternalMetaDsl.g:7650:3: ( rule__DocumentationSection__DocumentationBlocksAssignment_2 )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==RULE_ID||LA90_0==25) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalMetaDsl.g:7650:4: rule__DocumentationSection__DocumentationBlocksAssignment_2
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__DocumentationSection__DocumentationBlocksAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);

             after(grammarAccess.getDocumentationSectionAccess().getDocumentationBlocksAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__Group__2__Impl"


    // $ANTLR start "rule__DocumentationSection__Group__3"
    // InternalMetaDsl.g:7659:1: rule__DocumentationSection__Group__3 : rule__DocumentationSection__Group__3__Impl ;
    public final void rule__DocumentationSection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7663:1: ( rule__DocumentationSection__Group__3__Impl )
            // InternalMetaDsl.g:7664:2: rule__DocumentationSection__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DocumentationSection__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__Group__3"


    // $ANTLR start "rule__DocumentationSection__Group__3__Impl"
    // InternalMetaDsl.g:7670:1: rule__DocumentationSection__Group__3__Impl : ( '}' ) ;
    public final void rule__DocumentationSection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7674:1: ( ( '}' ) )
            // InternalMetaDsl.g:7675:1: ( '}' )
            {
            // InternalMetaDsl.g:7675:1: ( '}' )
            // InternalMetaDsl.g:7676:2: '}'
            {
             before(grammarAccess.getDocumentationSectionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getDocumentationSectionAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__Group__3__Impl"


    // $ANTLR start "rule__DocumentationBlock__Group__0"
    // InternalMetaDsl.g:7686:1: rule__DocumentationBlock__Group__0 : rule__DocumentationBlock__Group__0__Impl rule__DocumentationBlock__Group__1 ;
    public final void rule__DocumentationBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7690:1: ( rule__DocumentationBlock__Group__0__Impl rule__DocumentationBlock__Group__1 )
            // InternalMetaDsl.g:7691:2: rule__DocumentationBlock__Group__0__Impl rule__DocumentationBlock__Group__1
            {
            pushFollow(FOLLOW_66);
            rule__DocumentationBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DocumentationBlock__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationBlock__Group__0"


    // $ANTLR start "rule__DocumentationBlock__Group__0__Impl"
    // InternalMetaDsl.g:7698:1: rule__DocumentationBlock__Group__0__Impl : ( ( rule__DocumentationBlock__Alternatives_0 ) ) ;
    public final void rule__DocumentationBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7702:1: ( ( ( rule__DocumentationBlock__Alternatives_0 ) ) )
            // InternalMetaDsl.g:7703:1: ( ( rule__DocumentationBlock__Alternatives_0 ) )
            {
            // InternalMetaDsl.g:7703:1: ( ( rule__DocumentationBlock__Alternatives_0 ) )
            // InternalMetaDsl.g:7704:2: ( rule__DocumentationBlock__Alternatives_0 )
            {
             before(grammarAccess.getDocumentationBlockAccess().getAlternatives_0()); 
            // InternalMetaDsl.g:7705:2: ( rule__DocumentationBlock__Alternatives_0 )
            // InternalMetaDsl.g:7705:3: rule__DocumentationBlock__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__DocumentationBlock__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationBlockAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationBlock__Group__0__Impl"


    // $ANTLR start "rule__DocumentationBlock__Group__1"
    // InternalMetaDsl.g:7713:1: rule__DocumentationBlock__Group__1 : rule__DocumentationBlock__Group__1__Impl ;
    public final void rule__DocumentationBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7717:1: ( rule__DocumentationBlock__Group__1__Impl )
            // InternalMetaDsl.g:7718:2: rule__DocumentationBlock__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DocumentationBlock__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationBlock__Group__1"


    // $ANTLR start "rule__DocumentationBlock__Group__1__Impl"
    // InternalMetaDsl.g:7724:1: rule__DocumentationBlock__Group__1__Impl : ( ( rule__DocumentationBlock__DocumentationTextAssignment_1 ) ) ;
    public final void rule__DocumentationBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7728:1: ( ( ( rule__DocumentationBlock__DocumentationTextAssignment_1 ) ) )
            // InternalMetaDsl.g:7729:1: ( ( rule__DocumentationBlock__DocumentationTextAssignment_1 ) )
            {
            // InternalMetaDsl.g:7729:1: ( ( rule__DocumentationBlock__DocumentationTextAssignment_1 ) )
            // InternalMetaDsl.g:7730:2: ( rule__DocumentationBlock__DocumentationTextAssignment_1 )
            {
             before(grammarAccess.getDocumentationBlockAccess().getDocumentationTextAssignment_1()); 
            // InternalMetaDsl.g:7731:2: ( rule__DocumentationBlock__DocumentationTextAssignment_1 )
            // InternalMetaDsl.g:7731:3: rule__DocumentationBlock__DocumentationTextAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DocumentationBlock__DocumentationTextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationBlockAccess().getDocumentationTextAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationBlock__Group__1__Impl"


    // $ANTLR start "rule__QuerySourceBlock__Group__0"
    // InternalMetaDsl.g:7740:1: rule__QuerySourceBlock__Group__0 : rule__QuerySourceBlock__Group__0__Impl rule__QuerySourceBlock__Group__1 ;
    public final void rule__QuerySourceBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7744:1: ( rule__QuerySourceBlock__Group__0__Impl rule__QuerySourceBlock__Group__1 )
            // InternalMetaDsl.g:7745:2: rule__QuerySourceBlock__Group__0__Impl rule__QuerySourceBlock__Group__1
            {
            pushFollow(FOLLOW_67);
            rule__QuerySourceBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuerySourceBlock__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySourceBlock__Group__0"


    // $ANTLR start "rule__QuerySourceBlock__Group__0__Impl"
    // InternalMetaDsl.g:7752:1: rule__QuerySourceBlock__Group__0__Impl : ( 'QUERYSOURCE' ) ;
    public final void rule__QuerySourceBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7756:1: ( ( 'QUERYSOURCE' ) )
            // InternalMetaDsl.g:7757:1: ( 'QUERYSOURCE' )
            {
            // InternalMetaDsl.g:7757:1: ( 'QUERYSOURCE' )
            // InternalMetaDsl.g:7758:2: 'QUERYSOURCE'
            {
             before(grammarAccess.getQuerySourceBlockAccess().getQUERYSOURCEKeyword_0()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getQuerySourceBlockAccess().getQUERYSOURCEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySourceBlock__Group__0__Impl"


    // $ANTLR start "rule__QuerySourceBlock__Group__1"
    // InternalMetaDsl.g:7767:1: rule__QuerySourceBlock__Group__1 : rule__QuerySourceBlock__Group__1__Impl ;
    public final void rule__QuerySourceBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7771:1: ( rule__QuerySourceBlock__Group__1__Impl )
            // InternalMetaDsl.g:7772:2: rule__QuerySourceBlock__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuerySourceBlock__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySourceBlock__Group__1"


    // $ANTLR start "rule__QuerySourceBlock__Group__1__Impl"
    // InternalMetaDsl.g:7778:1: rule__QuerySourceBlock__Group__1__Impl : ( ( rule__QuerySourceBlock__QuerySourceAssignment_1 ) ) ;
    public final void rule__QuerySourceBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7782:1: ( ( ( rule__QuerySourceBlock__QuerySourceAssignment_1 ) ) )
            // InternalMetaDsl.g:7783:1: ( ( rule__QuerySourceBlock__QuerySourceAssignment_1 ) )
            {
            // InternalMetaDsl.g:7783:1: ( ( rule__QuerySourceBlock__QuerySourceAssignment_1 ) )
            // InternalMetaDsl.g:7784:2: ( rule__QuerySourceBlock__QuerySourceAssignment_1 )
            {
             before(grammarAccess.getQuerySourceBlockAccess().getQuerySourceAssignment_1()); 
            // InternalMetaDsl.g:7785:2: ( rule__QuerySourceBlock__QuerySourceAssignment_1 )
            // InternalMetaDsl.g:7785:3: rule__QuerySourceBlock__QuerySourceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__QuerySourceBlock__QuerySourceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQuerySourceBlockAccess().getQuerySourceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySourceBlock__Group__1__Impl"


    // $ANTLR start "rule__SQLFunction__Group__0"
    // InternalMetaDsl.g:7794:1: rule__SQLFunction__Group__0 : rule__SQLFunction__Group__0__Impl rule__SQLFunction__Group__1 ;
    public final void rule__SQLFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7798:1: ( rule__SQLFunction__Group__0__Impl rule__SQLFunction__Group__1 )
            // InternalMetaDsl.g:7799:2: rule__SQLFunction__Group__0__Impl rule__SQLFunction__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__SQLFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SQLFunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__0"


    // $ANTLR start "rule__SQLFunction__Group__0__Impl"
    // InternalMetaDsl.g:7806:1: rule__SQLFunction__Group__0__Impl : ( 'FUNCTION' ) ;
    public final void rule__SQLFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7810:1: ( ( 'FUNCTION' ) )
            // InternalMetaDsl.g:7811:1: ( 'FUNCTION' )
            {
            // InternalMetaDsl.g:7811:1: ( 'FUNCTION' )
            // InternalMetaDsl.g:7812:2: 'FUNCTION'
            {
             before(grammarAccess.getSQLFunctionAccess().getFUNCTIONKeyword_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getSQLFunctionAccess().getFUNCTIONKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__0__Impl"


    // $ANTLR start "rule__SQLFunction__Group__1"
    // InternalMetaDsl.g:7821:1: rule__SQLFunction__Group__1 : rule__SQLFunction__Group__1__Impl rule__SQLFunction__Group__2 ;
    public final void rule__SQLFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7825:1: ( rule__SQLFunction__Group__1__Impl rule__SQLFunction__Group__2 )
            // InternalMetaDsl.g:7826:2: rule__SQLFunction__Group__1__Impl rule__SQLFunction__Group__2
            {
            pushFollow(FOLLOW_68);
            rule__SQLFunction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SQLFunction__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__1"


    // $ANTLR start "rule__SQLFunction__Group__1__Impl"
    // InternalMetaDsl.g:7833:1: rule__SQLFunction__Group__1__Impl : ( ( rule__SQLFunction__NameAssignment_1 ) ) ;
    public final void rule__SQLFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7837:1: ( ( ( rule__SQLFunction__NameAssignment_1 ) ) )
            // InternalMetaDsl.g:7838:1: ( ( rule__SQLFunction__NameAssignment_1 ) )
            {
            // InternalMetaDsl.g:7838:1: ( ( rule__SQLFunction__NameAssignment_1 ) )
            // InternalMetaDsl.g:7839:2: ( rule__SQLFunction__NameAssignment_1 )
            {
             before(grammarAccess.getSQLFunctionAccess().getNameAssignment_1()); 
            // InternalMetaDsl.g:7840:2: ( rule__SQLFunction__NameAssignment_1 )
            // InternalMetaDsl.g:7840:3: rule__SQLFunction__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SQLFunction__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSQLFunctionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__1__Impl"


    // $ANTLR start "rule__SQLFunction__Group__2"
    // InternalMetaDsl.g:7848:1: rule__SQLFunction__Group__2 : rule__SQLFunction__Group__2__Impl rule__SQLFunction__Group__3 ;
    public final void rule__SQLFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7852:1: ( rule__SQLFunction__Group__2__Impl rule__SQLFunction__Group__3 )
            // InternalMetaDsl.g:7853:2: rule__SQLFunction__Group__2__Impl rule__SQLFunction__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__SQLFunction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SQLFunction__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__2"


    // $ANTLR start "rule__SQLFunction__Group__2__Impl"
    // InternalMetaDsl.g:7860:1: rule__SQLFunction__Group__2__Impl : ( 'SQLFILE' ) ;
    public final void rule__SQLFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7864:1: ( ( 'SQLFILE' ) )
            // InternalMetaDsl.g:7865:1: ( 'SQLFILE' )
            {
            // InternalMetaDsl.g:7865:1: ( 'SQLFILE' )
            // InternalMetaDsl.g:7866:2: 'SQLFILE'
            {
             before(grammarAccess.getSQLFunctionAccess().getSQLFILEKeyword_2()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getSQLFunctionAccess().getSQLFILEKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__2__Impl"


    // $ANTLR start "rule__SQLFunction__Group__3"
    // InternalMetaDsl.g:7875:1: rule__SQLFunction__Group__3 : rule__SQLFunction__Group__3__Impl rule__SQLFunction__Group__4 ;
    public final void rule__SQLFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7879:1: ( rule__SQLFunction__Group__3__Impl rule__SQLFunction__Group__4 )
            // InternalMetaDsl.g:7880:2: rule__SQLFunction__Group__3__Impl rule__SQLFunction__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__SQLFunction__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SQLFunction__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__3"


    // $ANTLR start "rule__SQLFunction__Group__3__Impl"
    // InternalMetaDsl.g:7887:1: rule__SQLFunction__Group__3__Impl : ( ( rule__SQLFunction__SqlFileAssignment_3 ) ) ;
    public final void rule__SQLFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7891:1: ( ( ( rule__SQLFunction__SqlFileAssignment_3 ) ) )
            // InternalMetaDsl.g:7892:1: ( ( rule__SQLFunction__SqlFileAssignment_3 ) )
            {
            // InternalMetaDsl.g:7892:1: ( ( rule__SQLFunction__SqlFileAssignment_3 ) )
            // InternalMetaDsl.g:7893:2: ( rule__SQLFunction__SqlFileAssignment_3 )
            {
             before(grammarAccess.getSQLFunctionAccess().getSqlFileAssignment_3()); 
            // InternalMetaDsl.g:7894:2: ( rule__SQLFunction__SqlFileAssignment_3 )
            // InternalMetaDsl.g:7894:3: rule__SQLFunction__SqlFileAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__SQLFunction__SqlFileAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSQLFunctionAccess().getSqlFileAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__3__Impl"


    // $ANTLR start "rule__SQLFunction__Group__4"
    // InternalMetaDsl.g:7902:1: rule__SQLFunction__Group__4 : rule__SQLFunction__Group__4__Impl ;
    public final void rule__SQLFunction__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7906:1: ( rule__SQLFunction__Group__4__Impl )
            // InternalMetaDsl.g:7907:2: rule__SQLFunction__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SQLFunction__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__4"


    // $ANTLR start "rule__SQLFunction__Group__4__Impl"
    // InternalMetaDsl.g:7913:1: rule__SQLFunction__Group__4__Impl : ( ';' ) ;
    public final void rule__SQLFunction__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7917:1: ( ( ';' ) )
            // InternalMetaDsl.g:7918:1: ( ';' )
            {
            // InternalMetaDsl.g:7918:1: ( ';' )
            // InternalMetaDsl.g:7919:2: ';'
            {
             before(grammarAccess.getSQLFunctionAccess().getSemicolonKeyword_4()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getSQLFunctionAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__Group__4__Impl"


    // $ANTLR start "rule__SqlNative__Group__0"
    // InternalMetaDsl.g:7929:1: rule__SqlNative__Group__0 : rule__SqlNative__Group__0__Impl rule__SqlNative__Group__1 ;
    public final void rule__SqlNative__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7933:1: ( rule__SqlNative__Group__0__Impl rule__SqlNative__Group__1 )
            // InternalMetaDsl.g:7934:2: rule__SqlNative__Group__0__Impl rule__SqlNative__Group__1
            {
            pushFollow(FOLLOW_69);
            rule__SqlNative__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlNative__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__0"


    // $ANTLR start "rule__SqlNative__Group__0__Impl"
    // InternalMetaDsl.g:7941:1: rule__SqlNative__Group__0__Impl : ( 'SQLNATIVE' ) ;
    public final void rule__SqlNative__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7945:1: ( ( 'SQLNATIVE' ) )
            // InternalMetaDsl.g:7946:1: ( 'SQLNATIVE' )
            {
            // InternalMetaDsl.g:7946:1: ( 'SQLNATIVE' )
            // InternalMetaDsl.g:7947:2: 'SQLNATIVE'
            {
             before(grammarAccess.getSqlNativeAccess().getSQLNATIVEKeyword_0()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getSqlNativeAccess().getSQLNATIVEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__0__Impl"


    // $ANTLR start "rule__SqlNative__Group__1"
    // InternalMetaDsl.g:7956:1: rule__SqlNative__Group__1 : rule__SqlNative__Group__1__Impl rule__SqlNative__Group__2 ;
    public final void rule__SqlNative__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7960:1: ( rule__SqlNative__Group__1__Impl rule__SqlNative__Group__2 )
            // InternalMetaDsl.g:7961:2: rule__SqlNative__Group__1__Impl rule__SqlNative__Group__2
            {
            pushFollow(FOLLOW_69);
            rule__SqlNative__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlNative__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__1"


    // $ANTLR start "rule__SqlNative__Group__1__Impl"
    // InternalMetaDsl.g:7968:1: rule__SqlNative__Group__1__Impl : ( ( rule__SqlNative__Group_1__0 )? ) ;
    public final void rule__SqlNative__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7972:1: ( ( ( rule__SqlNative__Group_1__0 )? ) )
            // InternalMetaDsl.g:7973:1: ( ( rule__SqlNative__Group_1__0 )? )
            {
            // InternalMetaDsl.g:7973:1: ( ( rule__SqlNative__Group_1__0 )? )
            // InternalMetaDsl.g:7974:2: ( rule__SqlNative__Group_1__0 )?
            {
             before(grammarAccess.getSqlNativeAccess().getGroup_1()); 
            // InternalMetaDsl.g:7975:2: ( rule__SqlNative__Group_1__0 )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==79) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalMetaDsl.g:7975:3: rule__SqlNative__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SqlNative__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSqlNativeAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__1__Impl"


    // $ANTLR start "rule__SqlNative__Group__2"
    // InternalMetaDsl.g:7983:1: rule__SqlNative__Group__2 : rule__SqlNative__Group__2__Impl rule__SqlNative__Group__3 ;
    public final void rule__SqlNative__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7987:1: ( rule__SqlNative__Group__2__Impl rule__SqlNative__Group__3 )
            // InternalMetaDsl.g:7988:2: rule__SqlNative__Group__2__Impl rule__SqlNative__Group__3
            {
            pushFollow(FOLLOW_69);
            rule__SqlNative__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlNative__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__2"


    // $ANTLR start "rule__SqlNative__Group__2__Impl"
    // InternalMetaDsl.g:7995:1: rule__SqlNative__Group__2__Impl : ( ( rule__SqlNative__SqlPositionAssignment_2 )? ) ;
    public final void rule__SqlNative__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:7999:1: ( ( ( rule__SqlNative__SqlPositionAssignment_2 )? ) )
            // InternalMetaDsl.g:8000:1: ( ( rule__SqlNative__SqlPositionAssignment_2 )? )
            {
            // InternalMetaDsl.g:8000:1: ( ( rule__SqlNative__SqlPositionAssignment_2 )? )
            // InternalMetaDsl.g:8001:2: ( rule__SqlNative__SqlPositionAssignment_2 )?
            {
             before(grammarAccess.getSqlNativeAccess().getSqlPositionAssignment_2()); 
            // InternalMetaDsl.g:8002:2: ( rule__SqlNative__SqlPositionAssignment_2 )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=26 && LA92_0<=27)) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalMetaDsl.g:8002:3: rule__SqlNative__SqlPositionAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__SqlNative__SqlPositionAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSqlNativeAccess().getSqlPositionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__2__Impl"


    // $ANTLR start "rule__SqlNative__Group__3"
    // InternalMetaDsl.g:8010:1: rule__SqlNative__Group__3 : rule__SqlNative__Group__3__Impl rule__SqlNative__Group__4 ;
    public final void rule__SqlNative__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8014:1: ( rule__SqlNative__Group__3__Impl rule__SqlNative__Group__4 )
            // InternalMetaDsl.g:8015:2: rule__SqlNative__Group__3__Impl rule__SqlNative__Group__4
            {
            pushFollow(FOLLOW_70);
            rule__SqlNative__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlNative__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__3"


    // $ANTLR start "rule__SqlNative__Group__3__Impl"
    // InternalMetaDsl.g:8022:1: rule__SqlNative__Group__3__Impl : ( '{' ) ;
    public final void rule__SqlNative__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8026:1: ( ( '{' ) )
            // InternalMetaDsl.g:8027:1: ( '{' )
            {
            // InternalMetaDsl.g:8027:1: ( '{' )
            // InternalMetaDsl.g:8028:2: '{'
            {
             before(grammarAccess.getSqlNativeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getSqlNativeAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__3__Impl"


    // $ANTLR start "rule__SqlNative__Group__4"
    // InternalMetaDsl.g:8037:1: rule__SqlNative__Group__4 : rule__SqlNative__Group__4__Impl rule__SqlNative__Group__5 ;
    public final void rule__SqlNative__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8041:1: ( rule__SqlNative__Group__4__Impl rule__SqlNative__Group__5 )
            // InternalMetaDsl.g:8042:2: rule__SqlNative__Group__4__Impl rule__SqlNative__Group__5
            {
            pushFollow(FOLLOW_70);
            rule__SqlNative__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlNative__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__4"


    // $ANTLR start "rule__SqlNative__Group__4__Impl"
    // InternalMetaDsl.g:8049:1: rule__SqlNative__Group__4__Impl : ( ( rule__SqlNative__SqlNativeBlocksAssignment_4 )* ) ;
    public final void rule__SqlNative__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8053:1: ( ( ( rule__SqlNative__SqlNativeBlocksAssignment_4 )* ) )
            // InternalMetaDsl.g:8054:1: ( ( rule__SqlNative__SqlNativeBlocksAssignment_4 )* )
            {
            // InternalMetaDsl.g:8054:1: ( ( rule__SqlNative__SqlNativeBlocksAssignment_4 )* )
            // InternalMetaDsl.g:8055:2: ( rule__SqlNative__SqlNativeBlocksAssignment_4 )*
            {
             before(grammarAccess.getSqlNativeAccess().getSqlNativeBlocksAssignment_4()); 
            // InternalMetaDsl.g:8056:2: ( rule__SqlNative__SqlNativeBlocksAssignment_4 )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==80) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalMetaDsl.g:8056:3: rule__SqlNative__SqlNativeBlocksAssignment_4
            	    {
            	    pushFollow(FOLLOW_71);
            	    rule__SqlNative__SqlNativeBlocksAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

             after(grammarAccess.getSqlNativeAccess().getSqlNativeBlocksAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__4__Impl"


    // $ANTLR start "rule__SqlNative__Group__5"
    // InternalMetaDsl.g:8064:1: rule__SqlNative__Group__5 : rule__SqlNative__Group__5__Impl ;
    public final void rule__SqlNative__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8068:1: ( rule__SqlNative__Group__5__Impl )
            // InternalMetaDsl.g:8069:2: rule__SqlNative__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SqlNative__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__5"


    // $ANTLR start "rule__SqlNative__Group__5__Impl"
    // InternalMetaDsl.g:8075:1: rule__SqlNative__Group__5__Impl : ( '}' ) ;
    public final void rule__SqlNative__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8079:1: ( ( '}' ) )
            // InternalMetaDsl.g:8080:1: ( '}' )
            {
            // InternalMetaDsl.g:8080:1: ( '}' )
            // InternalMetaDsl.g:8081:2: '}'
            {
             before(grammarAccess.getSqlNativeAccess().getRightCurlyBracketKeyword_5()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getSqlNativeAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group__5__Impl"


    // $ANTLR start "rule__SqlNative__Group_1__0"
    // InternalMetaDsl.g:8091:1: rule__SqlNative__Group_1__0 : rule__SqlNative__Group_1__0__Impl rule__SqlNative__Group_1__1 ;
    public final void rule__SqlNative__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8095:1: ( rule__SqlNative__Group_1__0__Impl rule__SqlNative__Group_1__1 )
            // InternalMetaDsl.g:8096:2: rule__SqlNative__Group_1__0__Impl rule__SqlNative__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__SqlNative__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlNative__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group_1__0"


    // $ANTLR start "rule__SqlNative__Group_1__0__Impl"
    // InternalMetaDsl.g:8103:1: rule__SqlNative__Group_1__0__Impl : ( 'ID' ) ;
    public final void rule__SqlNative__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8107:1: ( ( 'ID' ) )
            // InternalMetaDsl.g:8108:1: ( 'ID' )
            {
            // InternalMetaDsl.g:8108:1: ( 'ID' )
            // InternalMetaDsl.g:8109:2: 'ID'
            {
             before(grammarAccess.getSqlNativeAccess().getIDKeyword_1_0()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getSqlNativeAccess().getIDKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group_1__0__Impl"


    // $ANTLR start "rule__SqlNative__Group_1__1"
    // InternalMetaDsl.g:8118:1: rule__SqlNative__Group_1__1 : rule__SqlNative__Group_1__1__Impl ;
    public final void rule__SqlNative__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8122:1: ( rule__SqlNative__Group_1__1__Impl )
            // InternalMetaDsl.g:8123:2: rule__SqlNative__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SqlNative__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group_1__1"


    // $ANTLR start "rule__SqlNative__Group_1__1__Impl"
    // InternalMetaDsl.g:8129:1: rule__SqlNative__Group_1__1__Impl : ( ( rule__SqlNative__NameAssignment_1_1 ) ) ;
    public final void rule__SqlNative__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8133:1: ( ( ( rule__SqlNative__NameAssignment_1_1 ) ) )
            // InternalMetaDsl.g:8134:1: ( ( rule__SqlNative__NameAssignment_1_1 ) )
            {
            // InternalMetaDsl.g:8134:1: ( ( rule__SqlNative__NameAssignment_1_1 ) )
            // InternalMetaDsl.g:8135:2: ( rule__SqlNative__NameAssignment_1_1 )
            {
             before(grammarAccess.getSqlNativeAccess().getNameAssignment_1_1()); 
            // InternalMetaDsl.g:8136:2: ( rule__SqlNative__NameAssignment_1_1 )
            // InternalMetaDsl.g:8136:3: rule__SqlNative__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__SqlNative__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSqlNativeAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__Group_1__1__Impl"


    // $ANTLR start "rule__SqlNativeBlock__Group__0"
    // InternalMetaDsl.g:8145:1: rule__SqlNativeBlock__Group__0 : rule__SqlNativeBlock__Group__0__Impl rule__SqlNativeBlock__Group__1 ;
    public final void rule__SqlNativeBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8149:1: ( rule__SqlNativeBlock__Group__0__Impl rule__SqlNativeBlock__Group__1 )
            // InternalMetaDsl.g:8150:2: rule__SqlNativeBlock__Group__0__Impl rule__SqlNativeBlock__Group__1
            {
            pushFollow(FOLLOW_72);
            rule__SqlNativeBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__Group__0"


    // $ANTLR start "rule__SqlNativeBlock__Group__0__Impl"
    // InternalMetaDsl.g:8157:1: rule__SqlNativeBlock__Group__0__Impl : ( ( rule__SqlNativeBlock__Group_0__0 ) ) ;
    public final void rule__SqlNativeBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8161:1: ( ( ( rule__SqlNativeBlock__Group_0__0 ) ) )
            // InternalMetaDsl.g:8162:1: ( ( rule__SqlNativeBlock__Group_0__0 ) )
            {
            // InternalMetaDsl.g:8162:1: ( ( rule__SqlNativeBlock__Group_0__0 ) )
            // InternalMetaDsl.g:8163:2: ( rule__SqlNativeBlock__Group_0__0 )
            {
             before(grammarAccess.getSqlNativeBlockAccess().getGroup_0()); 
            // InternalMetaDsl.g:8164:2: ( rule__SqlNativeBlock__Group_0__0 )
            // InternalMetaDsl.g:8164:3: rule__SqlNativeBlock__Group_0__0
            {
            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__Group_0__0();

            state._fsp--;


            }

             after(grammarAccess.getSqlNativeBlockAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__Group__0__Impl"


    // $ANTLR start "rule__SqlNativeBlock__Group__1"
    // InternalMetaDsl.g:8172:1: rule__SqlNativeBlock__Group__1 : rule__SqlNativeBlock__Group__1__Impl ;
    public final void rule__SqlNativeBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8176:1: ( rule__SqlNativeBlock__Group__1__Impl )
            // InternalMetaDsl.g:8177:2: rule__SqlNativeBlock__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__Group__1"


    // $ANTLR start "rule__SqlNativeBlock__Group__1__Impl"
    // InternalMetaDsl.g:8183:1: rule__SqlNativeBlock__Group__1__Impl : ( ( rule__SqlNativeBlock__SqlBlockAssignment_1 ) ) ;
    public final void rule__SqlNativeBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8187:1: ( ( ( rule__SqlNativeBlock__SqlBlockAssignment_1 ) ) )
            // InternalMetaDsl.g:8188:1: ( ( rule__SqlNativeBlock__SqlBlockAssignment_1 ) )
            {
            // InternalMetaDsl.g:8188:1: ( ( rule__SqlNativeBlock__SqlBlockAssignment_1 ) )
            // InternalMetaDsl.g:8189:2: ( rule__SqlNativeBlock__SqlBlockAssignment_1 )
            {
             before(grammarAccess.getSqlNativeBlockAccess().getSqlBlockAssignment_1()); 
            // InternalMetaDsl.g:8190:2: ( rule__SqlNativeBlock__SqlBlockAssignment_1 )
            // InternalMetaDsl.g:8190:3: rule__SqlNativeBlock__SqlBlockAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__SqlBlockAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSqlNativeBlockAccess().getSqlBlockAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__Group__1__Impl"


    // $ANTLR start "rule__SqlNativeBlock__Group_0__0"
    // InternalMetaDsl.g:8199:1: rule__SqlNativeBlock__Group_0__0 : rule__SqlNativeBlock__Group_0__0__Impl rule__SqlNativeBlock__Group_0__1 ;
    public final void rule__SqlNativeBlock__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8203:1: ( rule__SqlNativeBlock__Group_0__0__Impl rule__SqlNativeBlock__Group_0__1 )
            // InternalMetaDsl.g:8204:2: rule__SqlNativeBlock__Group_0__0__Impl rule__SqlNativeBlock__Group_0__1
            {
            pushFollow(FOLLOW_73);
            rule__SqlNativeBlock__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__Group_0__0"


    // $ANTLR start "rule__SqlNativeBlock__Group_0__0__Impl"
    // InternalMetaDsl.g:8211:1: rule__SqlNativeBlock__Group_0__0__Impl : ( 'DBTYPE' ) ;
    public final void rule__SqlNativeBlock__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8215:1: ( ( 'DBTYPE' ) )
            // InternalMetaDsl.g:8216:1: ( 'DBTYPE' )
            {
            // InternalMetaDsl.g:8216:1: ( 'DBTYPE' )
            // InternalMetaDsl.g:8217:2: 'DBTYPE'
            {
             before(grammarAccess.getSqlNativeBlockAccess().getDBTYPEKeyword_0_0()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getSqlNativeBlockAccess().getDBTYPEKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__Group_0__0__Impl"


    // $ANTLR start "rule__SqlNativeBlock__Group_0__1"
    // InternalMetaDsl.g:8226:1: rule__SqlNativeBlock__Group_0__1 : rule__SqlNativeBlock__Group_0__1__Impl ;
    public final void rule__SqlNativeBlock__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8230:1: ( rule__SqlNativeBlock__Group_0__1__Impl )
            // InternalMetaDsl.g:8231:2: rule__SqlNativeBlock__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__Group_0__1"


    // $ANTLR start "rule__SqlNativeBlock__Group_0__1__Impl"
    // InternalMetaDsl.g:8237:1: rule__SqlNativeBlock__Group_0__1__Impl : ( ( rule__SqlNativeBlock__DbTypeAssignment_0_1 ) ) ;
    public final void rule__SqlNativeBlock__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8241:1: ( ( ( rule__SqlNativeBlock__DbTypeAssignment_0_1 ) ) )
            // InternalMetaDsl.g:8242:1: ( ( rule__SqlNativeBlock__DbTypeAssignment_0_1 ) )
            {
            // InternalMetaDsl.g:8242:1: ( ( rule__SqlNativeBlock__DbTypeAssignment_0_1 ) )
            // InternalMetaDsl.g:8243:2: ( rule__SqlNativeBlock__DbTypeAssignment_0_1 )
            {
             before(grammarAccess.getSqlNativeBlockAccess().getDbTypeAssignment_0_1()); 
            // InternalMetaDsl.g:8244:2: ( rule__SqlNativeBlock__DbTypeAssignment_0_1 )
            // InternalMetaDsl.g:8244:3: rule__SqlNativeBlock__DbTypeAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__DbTypeAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getSqlNativeBlockAccess().getDbTypeAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__Group_0__1__Impl"


    // $ANTLR start "rule__Model__EntitiesAssignment_0"
    // InternalMetaDsl.g:8253:1: rule__Model__EntitiesAssignment_0 : ( ruleEntity ) ;
    public final void rule__Model__EntitiesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8257:1: ( ( ruleEntity ) )
            // InternalMetaDsl.g:8258:2: ( ruleEntity )
            {
            // InternalMetaDsl.g:8258:2: ( ruleEntity )
            // InternalMetaDsl.g:8259:3: ruleEntity
            {
             before(grammarAccess.getModelAccess().getEntitiesEntityParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getModelAccess().getEntitiesEntityParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__EntitiesAssignment_0"


    // $ANTLR start "rule__Model__SequencesAssignment_1"
    // InternalMetaDsl.g:8268:1: rule__Model__SequencesAssignment_1 : ( ruleSequence ) ;
    public final void rule__Model__SequencesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8272:1: ( ( ruleSequence ) )
            // InternalMetaDsl.g:8273:2: ( ruleSequence )
            {
            // InternalMetaDsl.g:8273:2: ( ruleSequence )
            // InternalMetaDsl.g:8274:3: ruleSequence
            {
             before(grammarAccess.getModelAccess().getSequencesSequenceParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getModelAccess().getSequencesSequenceParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__SequencesAssignment_1"


    // $ANTLR start "rule__Model__ConfigurationAssignment_2"
    // InternalMetaDsl.g:8283:1: rule__Model__ConfigurationAssignment_2 : ( ruleConfiguration ) ;
    public final void rule__Model__ConfigurationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8287:1: ( ( ruleConfiguration ) )
            // InternalMetaDsl.g:8288:2: ( ruleConfiguration )
            {
            // InternalMetaDsl.g:8288:2: ( ruleConfiguration )
            // InternalMetaDsl.g:8289:3: ruleConfiguration
            {
             before(grammarAccess.getModelAccess().getConfigurationConfigurationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleConfiguration();

            state._fsp--;

             after(grammarAccess.getModelAccess().getConfigurationConfigurationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ConfigurationAssignment_2"


    // $ANTLR start "rule__Model__GeneralLabelSectionAssignment_3"
    // InternalMetaDsl.g:8298:1: rule__Model__GeneralLabelSectionAssignment_3 : ( ruleGeneralLabelSection ) ;
    public final void rule__Model__GeneralLabelSectionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8302:1: ( ( ruleGeneralLabelSection ) )
            // InternalMetaDsl.g:8303:2: ( ruleGeneralLabelSection )
            {
            // InternalMetaDsl.g:8303:2: ( ruleGeneralLabelSection )
            // InternalMetaDsl.g:8304:3: ruleGeneralLabelSection
            {
             before(grammarAccess.getModelAccess().getGeneralLabelSectionGeneralLabelSectionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleGeneralLabelSection();

            state._fsp--;

             after(grammarAccess.getModelAccess().getGeneralLabelSectionGeneralLabelSectionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__GeneralLabelSectionAssignment_3"


    // $ANTLR start "rule__Model__SqlNativesAssignment_4"
    // InternalMetaDsl.g:8313:1: rule__Model__SqlNativesAssignment_4 : ( ruleSqlNative ) ;
    public final void rule__Model__SqlNativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8317:1: ( ( ruleSqlNative ) )
            // InternalMetaDsl.g:8318:2: ( ruleSqlNative )
            {
            // InternalMetaDsl.g:8318:2: ( ruleSqlNative )
            // InternalMetaDsl.g:8319:3: ruleSqlNative
            {
             before(grammarAccess.getModelAccess().getSqlNativesSqlNativeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleSqlNative();

            state._fsp--;

             after(grammarAccess.getModelAccess().getSqlNativesSqlNativeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__SqlNativesAssignment_4"


    // $ANTLR start "rule__Model__MetadatasAssignment_5"
    // InternalMetaDsl.g:8328:1: rule__Model__MetadatasAssignment_5 : ( ruleMetadata ) ;
    public final void rule__Model__MetadatasAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8332:1: ( ( ruleMetadata ) )
            // InternalMetaDsl.g:8333:2: ( ruleMetadata )
            {
            // InternalMetaDsl.g:8333:2: ( ruleMetadata )
            // InternalMetaDsl.g:8334:3: ruleMetadata
            {
             before(grammarAccess.getModelAccess().getMetadatasMetadataParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleMetadata();

            state._fsp--;

             after(grammarAccess.getModelAccess().getMetadatasMetadataParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__MetadatasAssignment_5"


    // $ANTLR start "rule__Configuration__LanguagesAssignment_2"
    // InternalMetaDsl.g:8343:1: rule__Configuration__LanguagesAssignment_2 : ( ruleLanguage ) ;
    public final void rule__Configuration__LanguagesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8347:1: ( ( ruleLanguage ) )
            // InternalMetaDsl.g:8348:2: ( ruleLanguage )
            {
            // InternalMetaDsl.g:8348:2: ( ruleLanguage )
            // InternalMetaDsl.g:8349:3: ruleLanguage
            {
             before(grammarAccess.getConfigurationAccess().getLanguagesLanguageParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getLanguagesLanguageParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__LanguagesAssignment_2"


    // $ANTLR start "rule__Configuration__DataTypesAssignment_3"
    // InternalMetaDsl.g:8358:1: rule__Configuration__DataTypesAssignment_3 : ( ruleDataType ) ;
    public final void rule__Configuration__DataTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8362:1: ( ( ruleDataType ) )
            // InternalMetaDsl.g:8363:2: ( ruleDataType )
            {
            // InternalMetaDsl.g:8363:2: ( ruleDataType )
            // InternalMetaDsl.g:8364:3: ruleDataType
            {
             before(grammarAccess.getConfigurationAccess().getDataTypesDataTypeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getDataTypesDataTypeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__DataTypesAssignment_3"


    // $ANTLR start "rule__Configuration__ConstantsAssignment_4"
    // InternalMetaDsl.g:8373:1: rule__Configuration__ConstantsAssignment_4 : ( ruleConstant ) ;
    public final void rule__Configuration__ConstantsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8377:1: ( ( ruleConstant ) )
            // InternalMetaDsl.g:8378:2: ( ruleConstant )
            {
            // InternalMetaDsl.g:8378:2: ( ruleConstant )
            // InternalMetaDsl.g:8379:3: ruleConstant
            {
             before(grammarAccess.getConfigurationAccess().getConstantsConstantParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getConstantsConstantParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__ConstantsAssignment_4"


    // $ANTLR start "rule__Configuration__TableStereotypesAssignment_5"
    // InternalMetaDsl.g:8388:1: rule__Configuration__TableStereotypesAssignment_5 : ( ruleTableStereotype ) ;
    public final void rule__Configuration__TableStereotypesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8392:1: ( ( ruleTableStereotype ) )
            // InternalMetaDsl.g:8393:2: ( ruleTableStereotype )
            {
            // InternalMetaDsl.g:8393:2: ( ruleTableStereotype )
            // InternalMetaDsl.g:8394:3: ruleTableStereotype
            {
             before(grammarAccess.getConfigurationAccess().getTableStereotypesTableStereotypeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleTableStereotype();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getTableStereotypesTableStereotypeParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__TableStereotypesAssignment_5"


    // $ANTLR start "rule__Configuration__ColumnStereotypesAssignment_6"
    // InternalMetaDsl.g:8403:1: rule__Configuration__ColumnStereotypesAssignment_6 : ( ruleColumnStereotype ) ;
    public final void rule__Configuration__ColumnStereotypesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8407:1: ( ( ruleColumnStereotype ) )
            // InternalMetaDsl.g:8408:2: ( ruleColumnStereotype )
            {
            // InternalMetaDsl.g:8408:2: ( ruleColumnStereotype )
            // InternalMetaDsl.g:8409:3: ruleColumnStereotype
            {
             before(grammarAccess.getConfigurationAccess().getColumnStereotypesColumnStereotypeParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleColumnStereotype();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getColumnStereotypesColumnStereotypeParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__ColumnStereotypesAssignment_6"


    // $ANTLR start "rule__Configuration__PatternsAssignment_7"
    // InternalMetaDsl.g:8418:1: rule__Configuration__PatternsAssignment_7 : ( rulePattern ) ;
    public final void rule__Configuration__PatternsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8422:1: ( ( rulePattern ) )
            // InternalMetaDsl.g:8423:2: ( rulePattern )
            {
            // InternalMetaDsl.g:8423:2: ( rulePattern )
            // InternalMetaDsl.g:8424:3: rulePattern
            {
             before(grammarAccess.getConfigurationAccess().getPatternsPatternParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            rulePattern();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getPatternsPatternParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__PatternsAssignment_7"


    // $ANTLR start "rule__Configuration__DefaultPkGenerationStrategyAssignment_9"
    // InternalMetaDsl.g:8433:1: rule__Configuration__DefaultPkGenerationStrategyAssignment_9 : ( ( rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0 ) ) ;
    public final void rule__Configuration__DefaultPkGenerationStrategyAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8437:1: ( ( ( rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0 ) ) )
            // InternalMetaDsl.g:8438:2: ( ( rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0 ) )
            {
            // InternalMetaDsl.g:8438:2: ( ( rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0 ) )
            // InternalMetaDsl.g:8439:3: ( rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0 )
            {
             before(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyAlternatives_9_0()); 
            // InternalMetaDsl.g:8440:3: ( rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0 )
            // InternalMetaDsl.g:8440:4: rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__DefaultPkGenerationStrategyAlternatives_9_0();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyAlternatives_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__DefaultPkGenerationStrategyAssignment_9"


    // $ANTLR start "rule__Configuration__MtClassNameAssignment_10_1"
    // InternalMetaDsl.g:8448:1: rule__Configuration__MtClassNameAssignment_10_1 : ( RULE_ID ) ;
    public final void rule__Configuration__MtClassNameAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8452:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8453:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:8453:2: ( RULE_ID )
            // InternalMetaDsl.g:8454:3: RULE_ID
            {
             before(grammarAccess.getConfigurationAccess().getMtClassNameIDTerminalRuleCall_10_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConfigurationAccess().getMtClassNameIDTerminalRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__MtClassNameAssignment_10_1"


    // $ANTLR start "rule__Language__NameAssignment_1"
    // InternalMetaDsl.g:8463:1: rule__Language__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Language__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8467:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8468:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:8468:2: ( RULE_ID )
            // InternalMetaDsl.g:8469:3: RULE_ID
            {
             before(grammarAccess.getLanguageAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLanguageAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__NameAssignment_1"


    // $ANTLR start "rule__Constant__NameAssignment_1"
    // InternalMetaDsl.g:8478:1: rule__Constant__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constant__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8482:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8483:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:8483:2: ( RULE_ID )
            // InternalMetaDsl.g:8484:3: RULE_ID
            {
             before(grammarAccess.getConstantAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConstantAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__NameAssignment_1"


    // $ANTLR start "rule__Constant__ValueAssignment_2"
    // InternalMetaDsl.g:8493:1: rule__Constant__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Constant__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8497:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:8498:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:8498:2: ( RULE_STRING )
            // InternalMetaDsl.g:8499:3: RULE_STRING
            {
             before(grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__ValueAssignment_2"


    // $ANTLR start "rule__DataType__NameAssignment_1"
    // InternalMetaDsl.g:8508:1: rule__DataType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8512:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8513:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:8513:2: ( RULE_ID )
            // InternalMetaDsl.g:8514:3: RULE_ID
            {
             before(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__NameAssignment_1"


    // $ANTLR start "rule__DataType__DetailsAssignment_2"
    // InternalMetaDsl.g:8523:1: rule__DataType__DetailsAssignment_2 : ( ruleDataTypeDefinition ) ;
    public final void rule__DataType__DetailsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8527:1: ( ( ruleDataTypeDefinition ) )
            // InternalMetaDsl.g:8528:2: ( ruleDataTypeDefinition )
            {
            // InternalMetaDsl.g:8528:2: ( ruleDataTypeDefinition )
            // InternalMetaDsl.g:8529:3: ruleDataTypeDefinition
            {
             before(grammarAccess.getDataTypeAccess().getDetailsDataTypeDefinitionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDataTypeDefinition();

            state._fsp--;

             after(grammarAccess.getDataTypeAccess().getDetailsDataTypeDefinitionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__DetailsAssignment_2"


    // $ANTLR start "rule__DataTypeDetails__DbNativeTypeAssignment_1"
    // InternalMetaDsl.g:8538:1: rule__DataTypeDetails__DbNativeTypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataTypeDetails__DbNativeTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8542:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8543:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:8543:2: ( RULE_ID )
            // InternalMetaDsl.g:8544:3: RULE_ID
            {
             before(grammarAccess.getDataTypeDetailsAccess().getDbNativeTypeIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataTypeDetailsAccess().getDbNativeTypeIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__DbNativeTypeAssignment_1"


    // $ANTLR start "rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0"
    // InternalMetaDsl.g:8553:1: rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0 : ( ( 'WITHPRECISSIONANDSCALE' ) ) ;
    public final void rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8557:1: ( ( ( 'WITHPRECISSIONANDSCALE' ) ) )
            // InternalMetaDsl.g:8558:2: ( ( 'WITHPRECISSIONANDSCALE' ) )
            {
            // InternalMetaDsl.g:8558:2: ( ( 'WITHPRECISSIONANDSCALE' ) )
            // InternalMetaDsl.g:8559:3: ( 'WITHPRECISSIONANDSCALE' )
            {
             before(grammarAccess.getDataTypeDetailsAccess().getWithPrecissionAndScaleWITHPRECISSIONANDSCALEKeyword_2_0_0()); 
            // InternalMetaDsl.g:8560:3: ( 'WITHPRECISSIONANDSCALE' )
            // InternalMetaDsl.g:8561:4: 'WITHPRECISSIONANDSCALE'
            {
             before(grammarAccess.getDataTypeDetailsAccess().getWithPrecissionAndScaleWITHPRECISSIONANDSCALEKeyword_2_0_0()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getDataTypeDetailsAccess().getWithPrecissionAndScaleWITHPRECISSIONANDSCALEKeyword_2_0_0()); 

            }

             after(grammarAccess.getDataTypeDetailsAccess().getWithPrecissionAndScaleWITHPRECISSIONANDSCALEKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__WithPrecissionAndScaleAssignment_2_0"


    // $ANTLR start "rule__DataTypeDetails__WithLengthAssignment_2_1"
    // InternalMetaDsl.g:8572:1: rule__DataTypeDetails__WithLengthAssignment_2_1 : ( ( 'WITHLENGTH' ) ) ;
    public final void rule__DataTypeDetails__WithLengthAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8576:1: ( ( ( 'WITHLENGTH' ) ) )
            // InternalMetaDsl.g:8577:2: ( ( 'WITHLENGTH' ) )
            {
            // InternalMetaDsl.g:8577:2: ( ( 'WITHLENGTH' ) )
            // InternalMetaDsl.g:8578:3: ( 'WITHLENGTH' )
            {
             before(grammarAccess.getDataTypeDetailsAccess().getWithLengthWITHLENGTHKeyword_2_1_0()); 
            // InternalMetaDsl.g:8579:3: ( 'WITHLENGTH' )
            // InternalMetaDsl.g:8580:4: 'WITHLENGTH'
            {
             before(grammarAccess.getDataTypeDetailsAccess().getWithLengthWITHLENGTHKeyword_2_1_0()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getDataTypeDetailsAccess().getWithLengthWITHLENGTHKeyword_2_1_0()); 

            }

             after(grammarAccess.getDataTypeDetailsAccess().getWithLengthWITHLENGTHKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__WithLengthAssignment_2_1"


    // $ANTLR start "rule__DataTypeDetails__JavaTypeAssignment_4"
    // InternalMetaDsl.g:8591:1: rule__DataTypeDetails__JavaTypeAssignment_4 : ( ruleFQN ) ;
    public final void rule__DataTypeDetails__JavaTypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8595:1: ( ( ruleFQN ) )
            // InternalMetaDsl.g:8596:2: ( ruleFQN )
            {
            // InternalMetaDsl.g:8596:2: ( ruleFQN )
            // InternalMetaDsl.g:8597:3: ruleFQN
            {
             before(grammarAccess.getDataTypeDetailsAccess().getJavaTypeFQNParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getDataTypeDetailsAccess().getJavaTypeFQNParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeDetails__JavaTypeAssignment_4"


    // $ANTLR start "rule__SubTypeDataType__SubTypeOfAssignment_1"
    // InternalMetaDsl.g:8606:1: rule__SubTypeDataType__SubTypeOfAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubTypeDataType__SubTypeOfAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8610:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:8611:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:8611:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8612:3: ( RULE_ID )
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getSubTypeOfDataTypeCrossReference_1_0()); 
            // InternalMetaDsl.g:8613:3: ( RULE_ID )
            // InternalMetaDsl.g:8614:4: RULE_ID
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getSubTypeOfDataTypeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSubTypeDataTypeAccess().getSubTypeOfDataTypeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSubTypeDataTypeAccess().getSubTypeOfDataTypeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__SubTypeOfAssignment_1"


    // $ANTLR start "rule__SubTypeDataType__LengthAssignment_2_1_0"
    // InternalMetaDsl.g:8625:1: rule__SubTypeDataType__LengthAssignment_2_1_0 : ( RULE_NATURAL ) ;
    public final void rule__SubTypeDataType__LengthAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8629:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:8630:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:8630:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:8631:3: RULE_NATURAL
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getLengthNATURALTerminalRuleCall_2_1_0_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getSubTypeDataTypeAccess().getLengthNATURALTerminalRuleCall_2_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__LengthAssignment_2_1_0"


    // $ANTLR start "rule__SubTypeDataType__MaxlengthAssignment_2_1_1"
    // InternalMetaDsl.g:8640:1: rule__SubTypeDataType__MaxlengthAssignment_2_1_1 : ( ( 'MAX' ) ) ;
    public final void rule__SubTypeDataType__MaxlengthAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8644:1: ( ( ( 'MAX' ) ) )
            // InternalMetaDsl.g:8645:2: ( ( 'MAX' ) )
            {
            // InternalMetaDsl.g:8645:2: ( ( 'MAX' ) )
            // InternalMetaDsl.g:8646:3: ( 'MAX' )
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getMaxlengthMAXKeyword_2_1_1_0()); 
            // InternalMetaDsl.g:8647:3: ( 'MAX' )
            // InternalMetaDsl.g:8648:4: 'MAX'
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getMaxlengthMAXKeyword_2_1_1_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getSubTypeDataTypeAccess().getMaxlengthMAXKeyword_2_1_1_0()); 

            }

             after(grammarAccess.getSubTypeDataTypeAccess().getMaxlengthMAXKeyword_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__MaxlengthAssignment_2_1_1"


    // $ANTLR start "rule__SubTypeDataType__ScaleAssignment_2_2_1"
    // InternalMetaDsl.g:8659:1: rule__SubTypeDataType__ScaleAssignment_2_2_1 : ( RULE_NATURAL ) ;
    public final void rule__SubTypeDataType__ScaleAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8663:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:8664:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:8664:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:8665:3: RULE_NATURAL
            {
             before(grammarAccess.getSubTypeDataTypeAccess().getScaleNATURALTerminalRuleCall_2_2_1_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getSubTypeDataTypeAccess().getScaleNATURALTerminalRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubTypeDataType__ScaleAssignment_2_2_1"


    // $ANTLR start "rule__TableStereotype__NameAssignment_1"
    // InternalMetaDsl.g:8674:1: rule__TableStereotype__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TableStereotype__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8678:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8679:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:8679:2: ( RULE_ID )
            // InternalMetaDsl.g:8680:3: RULE_ID
            {
             before(grammarAccess.getTableStereotypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTableStereotypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableStereotype__NameAssignment_1"


    // $ANTLR start "rule__ColumnStereotype__NameAssignment_1"
    // InternalMetaDsl.g:8689:1: rule__ColumnStereotype__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ColumnStereotype__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8693:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8694:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:8694:2: ( RULE_ID )
            // InternalMetaDsl.g:8695:3: RULE_ID
            {
             before(grammarAccess.getColumnStereotypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getColumnStereotypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColumnStereotype__NameAssignment_1"


    // $ANTLR start "rule__Pattern__NameAssignment_1"
    // InternalMetaDsl.g:8704:1: rule__Pattern__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Pattern__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8708:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8709:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:8709:2: ( RULE_ID )
            // InternalMetaDsl.g:8710:3: RULE_ID
            {
             before(grammarAccess.getPatternAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPatternAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__NameAssignment_1"


    // $ANTLR start "rule__Pattern__AttributesAssignment_3"
    // InternalMetaDsl.g:8719:1: rule__Pattern__AttributesAssignment_3 : ( ruleAttribute ) ;
    public final void rule__Pattern__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8723:1: ( ( ruleAttribute ) )
            // InternalMetaDsl.g:8724:2: ( ruleAttribute )
            {
            // InternalMetaDsl.g:8724:2: ( ruleAttribute )
            // InternalMetaDsl.g:8725:3: ruleAttribute
            {
             before(grammarAccess.getPatternAccess().getAttributesAttributeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getPatternAccess().getAttributesAttributeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pattern__AttributesAssignment_3"


    // $ANTLR start "rule__Entity__FromSQLFileAssignment_0_1"
    // InternalMetaDsl.g:8734:1: rule__Entity__FromSQLFileAssignment_0_1 : ( RULE_STRING ) ;
    public final void rule__Entity__FromSQLFileAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8738:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:8739:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:8739:2: ( RULE_STRING )
            // InternalMetaDsl.g:8740:3: RULE_STRING
            {
             before(grammarAccess.getEntityAccess().getFromSQLFileSTRINGTerminalRuleCall_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getFromSQLFileSTRINGTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__FromSQLFileAssignment_0_1"


    // $ANTLR start "rule__Entity__SqlFileDependenciesAssignment_1"
    // InternalMetaDsl.g:8749:1: rule__Entity__SqlFileDependenciesAssignment_1 : ( ruleSqlFileDependency ) ;
    public final void rule__Entity__SqlFileDependenciesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8753:1: ( ( ruleSqlFileDependency ) )
            // InternalMetaDsl.g:8754:2: ( ruleSqlFileDependency )
            {
            // InternalMetaDsl.g:8754:2: ( ruleSqlFileDependency )
            // InternalMetaDsl.g:8755:3: ruleSqlFileDependency
            {
             before(grammarAccess.getEntityAccess().getSqlFileDependenciesSqlFileDependencyParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSqlFileDependency();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getSqlFileDependenciesSqlFileDependencyParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__SqlFileDependenciesAssignment_1"


    // $ANTLR start "rule__Entity__EntityTypeAssignment_2"
    // InternalMetaDsl.g:8764:1: rule__Entity__EntityTypeAssignment_2 : ( ( rule__Entity__EntityTypeAlternatives_2_0 ) ) ;
    public final void rule__Entity__EntityTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8768:1: ( ( ( rule__Entity__EntityTypeAlternatives_2_0 ) ) )
            // InternalMetaDsl.g:8769:2: ( ( rule__Entity__EntityTypeAlternatives_2_0 ) )
            {
            // InternalMetaDsl.g:8769:2: ( ( rule__Entity__EntityTypeAlternatives_2_0 ) )
            // InternalMetaDsl.g:8770:3: ( rule__Entity__EntityTypeAlternatives_2_0 )
            {
             before(grammarAccess.getEntityAccess().getEntityTypeAlternatives_2_0()); 
            // InternalMetaDsl.g:8771:3: ( rule__Entity__EntityTypeAlternatives_2_0 )
            // InternalMetaDsl.g:8771:4: rule__Entity__EntityTypeAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Entity__EntityTypeAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getEntityTypeAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__EntityTypeAssignment_2"


    // $ANTLR start "rule__Entity__NameAssignment_4"
    // InternalMetaDsl.g:8779:1: rule__Entity__NameAssignment_4 : ( ruleFQN ) ;
    public final void rule__Entity__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8783:1: ( ( ruleFQN ) )
            // InternalMetaDsl.g:8784:2: ( ruleFQN )
            {
            // InternalMetaDsl.g:8784:2: ( ruleFQN )
            // InternalMetaDsl.g:8785:3: ruleFQN
            {
             before(grammarAccess.getEntityAccess().getNameFQNParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getNameFQNParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__NameAssignment_4"


    // $ANTLR start "rule__Entity__ExtendsAssignment_5_1"
    // InternalMetaDsl.g:8794:1: rule__Entity__ExtendsAssignment_5_1 : ( ( ruleFQN ) ) ;
    public final void rule__Entity__ExtendsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8798:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:8799:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:8799:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:8800:3: ( ruleFQN )
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_5_1_0()); 
            // InternalMetaDsl.g:8801:3: ( ruleFQN )
            // InternalMetaDsl.g:8802:4: ruleFQN
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityFQNParserRuleCall_5_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getExtendsEntityFQNParserRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__ExtendsAssignment_5_1"


    // $ANTLR start "rule__Entity__PatternsAssignment_6_1"
    // InternalMetaDsl.g:8813:1: rule__Entity__PatternsAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__PatternsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8817:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:8818:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:8818:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8819:3: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getPatternsPatternCrossReference_6_1_0()); 
            // InternalMetaDsl.g:8820:3: ( RULE_ID )
            // InternalMetaDsl.g:8821:4: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getPatternsPatternIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getPatternsPatternIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getPatternsPatternCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__PatternsAssignment_6_1"


    // $ANTLR start "rule__Entity__PatternsAssignment_6_2_1"
    // InternalMetaDsl.g:8832:1: rule__Entity__PatternsAssignment_6_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__PatternsAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8836:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:8837:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:8837:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8838:3: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getPatternsPatternCrossReference_6_2_1_0()); 
            // InternalMetaDsl.g:8839:3: ( RULE_ID )
            // InternalMetaDsl.g:8840:4: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getPatternsPatternIDTerminalRuleCall_6_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getPatternsPatternIDTerminalRuleCall_6_2_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getPatternsPatternCrossReference_6_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__PatternsAssignment_6_2_1"


    // $ANTLR start "rule__Entity__StereotypesAssignment_7_1"
    // InternalMetaDsl.g:8851:1: rule__Entity__StereotypesAssignment_7_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__StereotypesAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8855:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:8856:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:8856:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8857:3: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getStereotypesTableStereotypeCrossReference_7_1_0()); 
            // InternalMetaDsl.g:8858:3: ( RULE_ID )
            // InternalMetaDsl.g:8859:4: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getStereotypesTableStereotypeIDTerminalRuleCall_7_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getStereotypesTableStereotypeIDTerminalRuleCall_7_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getStereotypesTableStereotypeCrossReference_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__StereotypesAssignment_7_1"


    // $ANTLR start "rule__Entity__StereotypesAssignment_7_2_1"
    // InternalMetaDsl.g:8870:1: rule__Entity__StereotypesAssignment_7_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__StereotypesAssignment_7_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8874:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:8875:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:8875:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:8876:3: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getStereotypesTableStereotypeCrossReference_7_2_1_0()); 
            // InternalMetaDsl.g:8877:3: ( RULE_ID )
            // InternalMetaDsl.g:8878:4: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getStereotypesTableStereotypeIDTerminalRuleCall_7_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getStereotypesTableStereotypeIDTerminalRuleCall_7_2_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getStereotypesTableStereotypeCrossReference_7_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__StereotypesAssignment_7_2_1"


    // $ANTLR start "rule__Entity__AttributesAssignment_9"
    // InternalMetaDsl.g:8889:1: rule__Entity__AttributesAssignment_9 : ( ruleAttribute ) ;
    public final void rule__Entity__AttributesAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8893:1: ( ( ruleAttribute ) )
            // InternalMetaDsl.g:8894:2: ( ruleAttribute )
            {
            // InternalMetaDsl.g:8894:2: ( ruleAttribute )
            // InternalMetaDsl.g:8895:3: ruleAttribute
            {
             before(grammarAccess.getEntityAccess().getAttributesAttributeParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getAttributesAttributeParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__AttributesAssignment_9"


    // $ANTLR start "rule__Entity__MetadataAssignment_10"
    // InternalMetaDsl.g:8904:1: rule__Entity__MetadataAssignment_10 : ( ruleMetadata ) ;
    public final void rule__Entity__MetadataAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8908:1: ( ( ruleMetadata ) )
            // InternalMetaDsl.g:8909:2: ( ruleMetadata )
            {
            // InternalMetaDsl.g:8909:2: ( ruleMetadata )
            // InternalMetaDsl.g:8910:3: ruleMetadata
            {
             before(grammarAccess.getEntityAccess().getMetadataMetadataParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleMetadata();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getMetadataMetadataParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__MetadataAssignment_10"


    // $ANTLR start "rule__Entity__EnuMetadataAssignment_11"
    // InternalMetaDsl.g:8919:1: rule__Entity__EnuMetadataAssignment_11 : ( ruleEnuMetadata ) ;
    public final void rule__Entity__EnuMetadataAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8923:1: ( ( ruleEnuMetadata ) )
            // InternalMetaDsl.g:8924:2: ( ruleEnuMetadata )
            {
            // InternalMetaDsl.g:8924:2: ( ruleEnuMetadata )
            // InternalMetaDsl.g:8925:3: ruleEnuMetadata
            {
             before(grammarAccess.getEntityAccess().getEnuMetadataEnuMetadataParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleEnuMetadata();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getEnuMetadataEnuMetadataParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__EnuMetadataAssignment_11"


    // $ANTLR start "rule__Entity__LabelSectionAssignment_12"
    // InternalMetaDsl.g:8934:1: rule__Entity__LabelSectionAssignment_12 : ( ruleLabelSection ) ;
    public final void rule__Entity__LabelSectionAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8938:1: ( ( ruleLabelSection ) )
            // InternalMetaDsl.g:8939:2: ( ruleLabelSection )
            {
            // InternalMetaDsl.g:8939:2: ( ruleLabelSection )
            // InternalMetaDsl.g:8940:3: ruleLabelSection
            {
             before(grammarAccess.getEntityAccess().getLabelSectionLabelSectionParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleLabelSection();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getLabelSectionLabelSectionParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__LabelSectionAssignment_12"


    // $ANTLR start "rule__Entity__EnumerationLabelsAssignment_13"
    // InternalMetaDsl.g:8949:1: rule__Entity__EnumerationLabelsAssignment_13 : ( ruleEnumerationLabels ) ;
    public final void rule__Entity__EnumerationLabelsAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8953:1: ( ( ruleEnumerationLabels ) )
            // InternalMetaDsl.g:8954:2: ( ruleEnumerationLabels )
            {
            // InternalMetaDsl.g:8954:2: ( ruleEnumerationLabels )
            // InternalMetaDsl.g:8955:3: ruleEnumerationLabels
            {
             before(grammarAccess.getEntityAccess().getEnumerationLabelsEnumerationLabelsParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumerationLabels();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getEnumerationLabelsEnumerationLabelsParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__EnumerationLabelsAssignment_13"


    // $ANTLR start "rule__Entity__DocumentationSectionAssignment_14"
    // InternalMetaDsl.g:8964:1: rule__Entity__DocumentationSectionAssignment_14 : ( ruleDocumentationSection ) ;
    public final void rule__Entity__DocumentationSectionAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8968:1: ( ( ruleDocumentationSection ) )
            // InternalMetaDsl.g:8969:2: ( ruleDocumentationSection )
            {
            // InternalMetaDsl.g:8969:2: ( ruleDocumentationSection )
            // InternalMetaDsl.g:8970:3: ruleDocumentationSection
            {
             before(grammarAccess.getEntityAccess().getDocumentationSectionDocumentationSectionParserRuleCall_14_0()); 
            pushFollow(FOLLOW_2);
            ruleDocumentationSection();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getDocumentationSectionDocumentationSectionParserRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__DocumentationSectionAssignment_14"


    // $ANTLR start "rule__Entity__QuerySourceBlockAssignment_15"
    // InternalMetaDsl.g:8979:1: rule__Entity__QuerySourceBlockAssignment_15 : ( ruleQuerySourceBlock ) ;
    public final void rule__Entity__QuerySourceBlockAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8983:1: ( ( ruleQuerySourceBlock ) )
            // InternalMetaDsl.g:8984:2: ( ruleQuerySourceBlock )
            {
            // InternalMetaDsl.g:8984:2: ( ruleQuerySourceBlock )
            // InternalMetaDsl.g:8985:3: ruleQuerySourceBlock
            {
             before(grammarAccess.getEntityAccess().getQuerySourceBlockQuerySourceBlockParserRuleCall_15_0()); 
            pushFollow(FOLLOW_2);
            ruleQuerySourceBlock();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getQuerySourceBlockQuerySourceBlockParserRuleCall_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__QuerySourceBlockAssignment_15"


    // $ANTLR start "rule__SqlFileDependency__SqlFileDependencyAssignment_1"
    // InternalMetaDsl.g:8994:1: rule__SqlFileDependency__SqlFileDependencyAssignment_1 : ( RULE_STRING ) ;
    public final void rule__SqlFileDependency__SqlFileDependencyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:8998:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:8999:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:8999:2: ( RULE_STRING )
            // InternalMetaDsl.g:9000:3: RULE_STRING
            {
             before(grammarAccess.getSqlFileDependencyAccess().getSqlFileDependencySTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSqlFileDependencyAccess().getSqlFileDependencySTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlFileDependency__SqlFileDependencyAssignment_1"


    // $ANTLR start "rule__Sequence__NameAssignment_1"
    // InternalMetaDsl.g:9009:1: rule__Sequence__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__Sequence__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9013:1: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9014:2: ( ruleFQN )
            {
            // InternalMetaDsl.g:9014:2: ( ruleFQN )
            // InternalMetaDsl.g:9015:3: ruleFQN
            {
             before(grammarAccess.getSequenceAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getSequenceAccess().getNameFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__NameAssignment_1"


    // $ANTLR start "rule__Sequence__StartWithAssignment_2_2"
    // InternalMetaDsl.g:9024:1: rule__Sequence__StartWithAssignment_2_2 : ( RULE_NATURAL ) ;
    public final void rule__Sequence__StartWithAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9028:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:9029:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:9029:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:9030:3: RULE_NATURAL
            {
             before(grammarAccess.getSequenceAccess().getStartWithNATURALTerminalRuleCall_2_2_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getStartWithNATURALTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__StartWithAssignment_2_2"


    // $ANTLR start "rule__Sequence__IncrementByAssignment_3_2"
    // InternalMetaDsl.g:9039:1: rule__Sequence__IncrementByAssignment_3_2 : ( RULE_NATURAL ) ;
    public final void rule__Sequence__IncrementByAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9043:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:9044:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:9044:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:9045:3: RULE_NATURAL
            {
             before(grammarAccess.getSequenceAccess().getIncrementByNATURALTerminalRuleCall_3_2_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getIncrementByNATURALTerminalRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__IncrementByAssignment_3_2"


    // $ANTLR start "rule__Sequence__MinValueAssignment_4_1"
    // InternalMetaDsl.g:9054:1: rule__Sequence__MinValueAssignment_4_1 : ( RULE_NATURAL ) ;
    public final void rule__Sequence__MinValueAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9058:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:9059:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:9059:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:9060:3: RULE_NATURAL
            {
             before(grammarAccess.getSequenceAccess().getMinValueNATURALTerminalRuleCall_4_1_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getMinValueNATURALTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__MinValueAssignment_4_1"


    // $ANTLR start "rule__Sequence__MaxValueAssignment_5_1"
    // InternalMetaDsl.g:9069:1: rule__Sequence__MaxValueAssignment_5_1 : ( RULE_NATURAL ) ;
    public final void rule__Sequence__MaxValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9073:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:9074:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:9074:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:9075:3: RULE_NATURAL
            {
             before(grammarAccess.getSequenceAccess().getMaxValueNATURALTerminalRuleCall_5_1_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getMaxValueNATURALTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__MaxValueAssignment_5_1"


    // $ANTLR start "rule__Sequence__CycleAssignment_6"
    // InternalMetaDsl.g:9084:1: rule__Sequence__CycleAssignment_6 : ( ( 'CYCLE' ) ) ;
    public final void rule__Sequence__CycleAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9088:1: ( ( ( 'CYCLE' ) ) )
            // InternalMetaDsl.g:9089:2: ( ( 'CYCLE' ) )
            {
            // InternalMetaDsl.g:9089:2: ( ( 'CYCLE' ) )
            // InternalMetaDsl.g:9090:3: ( 'CYCLE' )
            {
             before(grammarAccess.getSequenceAccess().getCycleCYCLEKeyword_6_0()); 
            // InternalMetaDsl.g:9091:3: ( 'CYCLE' )
            // InternalMetaDsl.g:9092:4: 'CYCLE'
            {
             before(grammarAccess.getSequenceAccess().getCycleCYCLEKeyword_6_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getCycleCYCLEKeyword_6_0()); 

            }

             after(grammarAccess.getSequenceAccess().getCycleCYCLEKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__CycleAssignment_6"


    // $ANTLR start "rule__Sequence__CacheAssignment_7_1"
    // InternalMetaDsl.g:9103:1: rule__Sequence__CacheAssignment_7_1 : ( RULE_NATURAL ) ;
    public final void rule__Sequence__CacheAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9107:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:9108:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:9108:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:9109:3: RULE_NATURAL
            {
             before(grammarAccess.getSequenceAccess().getCacheNATURALTerminalRuleCall_7_1_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getCacheNATURALTerminalRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__CacheAssignment_7_1"


    // $ANTLR start "rule__Attribute__UniqueAssignment_0"
    // InternalMetaDsl.g:9118:1: rule__Attribute__UniqueAssignment_0 : ( ( 'UQ' ) ) ;
    public final void rule__Attribute__UniqueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9122:1: ( ( ( 'UQ' ) ) )
            // InternalMetaDsl.g:9123:2: ( ( 'UQ' ) )
            {
            // InternalMetaDsl.g:9123:2: ( ( 'UQ' ) )
            // InternalMetaDsl.g:9124:3: ( 'UQ' )
            {
             before(grammarAccess.getAttributeAccess().getUniqueUQKeyword_0_0()); 
            // InternalMetaDsl.g:9125:3: ( 'UQ' )
            // InternalMetaDsl.g:9126:4: 'UQ'
            {
             before(grammarAccess.getAttributeAccess().getUniqueUQKeyword_0_0()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getUniqueUQKeyword_0_0()); 

            }

             after(grammarAccess.getAttributeAccess().getUniqueUQKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__UniqueAssignment_0"


    // $ANTLR start "rule__Attribute__PkAssignment_1"
    // InternalMetaDsl.g:9137:1: rule__Attribute__PkAssignment_1 : ( ( 'PK' ) ) ;
    public final void rule__Attribute__PkAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9141:1: ( ( ( 'PK' ) ) )
            // InternalMetaDsl.g:9142:2: ( ( 'PK' ) )
            {
            // InternalMetaDsl.g:9142:2: ( ( 'PK' ) )
            // InternalMetaDsl.g:9143:3: ( 'PK' )
            {
             before(grammarAccess.getAttributeAccess().getPkPKKeyword_1_0()); 
            // InternalMetaDsl.g:9144:3: ( 'PK' )
            // InternalMetaDsl.g:9145:4: 'PK'
            {
             before(grammarAccess.getAttributeAccess().getPkPKKeyword_1_0()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getPkPKKeyword_1_0()); 

            }

             after(grammarAccess.getAttributeAccess().getPkPKKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__PkAssignment_1"


    // $ANTLR start "rule__Attribute__NameAssignment_2"
    // InternalMetaDsl.g:9156:1: rule__Attribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9160:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:9161:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:9161:2: ( RULE_ID )
            // InternalMetaDsl.g:9162:3: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_2"


    // $ANTLR start "rule__Attribute__TypeAssignment_3"
    // InternalMetaDsl.g:9171:1: rule__Attribute__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9175:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:9176:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:9176:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:9177:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getTypeDataTypeCrossReference_3_0()); 
            // InternalMetaDsl.g:9178:3: ( RULE_ID )
            // InternalMetaDsl.g:9179:4: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getTypeDataTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getTypeDataTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getTypeDataTypeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__TypeAssignment_3"


    // $ANTLR start "rule__Attribute__LengthAssignment_4_1_0"
    // InternalMetaDsl.g:9190:1: rule__Attribute__LengthAssignment_4_1_0 : ( RULE_NATURAL ) ;
    public final void rule__Attribute__LengthAssignment_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9194:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:9195:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:9195:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:9196:3: RULE_NATURAL
            {
             before(grammarAccess.getAttributeAccess().getLengthNATURALTerminalRuleCall_4_1_0_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getLengthNATURALTerminalRuleCall_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__LengthAssignment_4_1_0"


    // $ANTLR start "rule__Attribute__MaxlengthAssignment_4_1_1"
    // InternalMetaDsl.g:9205:1: rule__Attribute__MaxlengthAssignment_4_1_1 : ( ( 'MAX' ) ) ;
    public final void rule__Attribute__MaxlengthAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9209:1: ( ( ( 'MAX' ) ) )
            // InternalMetaDsl.g:9210:2: ( ( 'MAX' ) )
            {
            // InternalMetaDsl.g:9210:2: ( ( 'MAX' ) )
            // InternalMetaDsl.g:9211:3: ( 'MAX' )
            {
             before(grammarAccess.getAttributeAccess().getMaxlengthMAXKeyword_4_1_1_0()); 
            // InternalMetaDsl.g:9212:3: ( 'MAX' )
            // InternalMetaDsl.g:9213:4: 'MAX'
            {
             before(grammarAccess.getAttributeAccess().getMaxlengthMAXKeyword_4_1_1_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getMaxlengthMAXKeyword_4_1_1_0()); 

            }

             after(grammarAccess.getAttributeAccess().getMaxlengthMAXKeyword_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__MaxlengthAssignment_4_1_1"


    // $ANTLR start "rule__Attribute__ScaleAssignment_4_2_1"
    // InternalMetaDsl.g:9224:1: rule__Attribute__ScaleAssignment_4_2_1 : ( RULE_NATURAL ) ;
    public final void rule__Attribute__ScaleAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9228:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:9229:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:9229:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:9230:3: RULE_NATURAL
            {
             before(grammarAccess.getAttributeAccess().getScaleNATURALTerminalRuleCall_4_2_1_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getScaleNATURALTerminalRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ScaleAssignment_4_2_1"


    // $ANTLR start "rule__Attribute__NotNullableAssignment_5"
    // InternalMetaDsl.g:9239:1: rule__Attribute__NotNullableAssignment_5 : ( ( 'NOTNULL' ) ) ;
    public final void rule__Attribute__NotNullableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9243:1: ( ( ( 'NOTNULL' ) ) )
            // InternalMetaDsl.g:9244:2: ( ( 'NOTNULL' ) )
            {
            // InternalMetaDsl.g:9244:2: ( ( 'NOTNULL' ) )
            // InternalMetaDsl.g:9245:3: ( 'NOTNULL' )
            {
             before(grammarAccess.getAttributeAccess().getNotNullableNOTNULLKeyword_5_0()); 
            // InternalMetaDsl.g:9246:3: ( 'NOTNULL' )
            // InternalMetaDsl.g:9247:4: 'NOTNULL'
            {
             before(grammarAccess.getAttributeAccess().getNotNullableNOTNULLKeyword_5_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNotNullableNOTNULLKeyword_5_0()); 

            }

             after(grammarAccess.getAttributeAccess().getNotNullableNOTNULLKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NotNullableAssignment_5"


    // $ANTLR start "rule__Attribute__SameAsAttributeAssignment_6_1"
    // InternalMetaDsl.g:9258:1: rule__Attribute__SameAsAttributeAssignment_6_1 : ( ( ruleFQN ) ) ;
    public final void rule__Attribute__SameAsAttributeAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9262:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9263:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9263:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9264:3: ( ruleFQN )
            {
             before(grammarAccess.getAttributeAccess().getSameAsAttributeAttributeCrossReference_6_1_0()); 
            // InternalMetaDsl.g:9265:3: ( ruleFQN )
            // InternalMetaDsl.g:9266:4: ruleFQN
            {
             before(grammarAccess.getAttributeAccess().getSameAsAttributeAttributeFQNParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getSameAsAttributeAttributeFQNParserRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getSameAsAttributeAttributeCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__SameAsAttributeAssignment_6_1"


    // $ANTLR start "rule__Attribute__FktoAssignment_7_1"
    // InternalMetaDsl.g:9277:1: rule__Attribute__FktoAssignment_7_1 : ( ( ruleFQN ) ) ;
    public final void rule__Attribute__FktoAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9281:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9282:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9282:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9283:3: ( ruleFQN )
            {
             before(grammarAccess.getAttributeAccess().getFktoEntityCrossReference_7_1_0()); 
            // InternalMetaDsl.g:9284:3: ( ruleFQN )
            // InternalMetaDsl.g:9285:4: ruleFQN
            {
             before(grammarAccess.getAttributeAccess().getFktoEntityFQNParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getFktoEntityFQNParserRuleCall_7_1_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getFktoEntityCrossReference_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__FktoAssignment_7_1"


    // $ANTLR start "rule__Attribute__MultiRefToAssignment_8_1"
    // InternalMetaDsl.g:9296:1: rule__Attribute__MultiRefToAssignment_8_1 : ( ( ruleFQN ) ) ;
    public final void rule__Attribute__MultiRefToAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9300:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9301:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9301:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9302:3: ( ruleFQN )
            {
             before(grammarAccess.getAttributeAccess().getMultiRefToEntityCrossReference_8_1_0()); 
            // InternalMetaDsl.g:9303:3: ( ruleFQN )
            // InternalMetaDsl.g:9304:4: ruleFQN
            {
             before(grammarAccess.getAttributeAccess().getMultiRefToEntityFQNParserRuleCall_8_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getMultiRefToEntityFQNParserRuleCall_8_1_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getMultiRefToEntityCrossReference_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__MultiRefToAssignment_8_1"


    // $ANTLR start "rule__Attribute__DefaultAssignment_9_1_0"
    // InternalMetaDsl.g:9315:1: rule__Attribute__DefaultAssignment_9_1_0 : ( RULE_STRING ) ;
    public final void rule__Attribute__DefaultAssignment_9_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9319:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:9320:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:9320:2: ( RULE_STRING )
            // InternalMetaDsl.g:9321:3: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getDefaultSTRINGTerminalRuleCall_9_1_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getDefaultSTRINGTerminalRuleCall_9_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__DefaultAssignment_9_1_0"


    // $ANTLR start "rule__Attribute__DefaultConstantAssignment_9_1_1"
    // InternalMetaDsl.g:9330:1: rule__Attribute__DefaultConstantAssignment_9_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__DefaultConstantAssignment_9_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9334:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:9335:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:9335:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:9336:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getDefaultConstantConstantCrossReference_9_1_1_0()); 
            // InternalMetaDsl.g:9337:3: ( RULE_ID )
            // InternalMetaDsl.g:9338:4: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getDefaultConstantConstantIDTerminalRuleCall_9_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getDefaultConstantConstantIDTerminalRuleCall_9_1_1_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getDefaultConstantConstantCrossReference_9_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__DefaultConstantAssignment_9_1_1"


    // $ANTLR start "rule__Attribute__TransientAssignment_10"
    // InternalMetaDsl.g:9349:1: rule__Attribute__TransientAssignment_10 : ( ( 'TRANSIENT' ) ) ;
    public final void rule__Attribute__TransientAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9353:1: ( ( ( 'TRANSIENT' ) ) )
            // InternalMetaDsl.g:9354:2: ( ( 'TRANSIENT' ) )
            {
            // InternalMetaDsl.g:9354:2: ( ( 'TRANSIENT' ) )
            // InternalMetaDsl.g:9355:3: ( 'TRANSIENT' )
            {
             before(grammarAccess.getAttributeAccess().getTransientTRANSIENTKeyword_10_0()); 
            // InternalMetaDsl.g:9356:3: ( 'TRANSIENT' )
            // InternalMetaDsl.g:9357:4: 'TRANSIENT'
            {
             before(grammarAccess.getAttributeAccess().getTransientTRANSIENTKeyword_10_0()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getTransientTRANSIENTKeyword_10_0()); 

            }

             after(grammarAccess.getAttributeAccess().getTransientTRANSIENTKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__TransientAssignment_10"


    // $ANTLR start "rule__Attribute__StereotypesAssignment_11_1"
    // InternalMetaDsl.g:9368:1: rule__Attribute__StereotypesAssignment_11_1 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__StereotypesAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9372:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:9373:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:9373:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:9374:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeCrossReference_11_1_0()); 
            // InternalMetaDsl.g:9375:3: ( RULE_ID )
            // InternalMetaDsl.g:9376:4: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeIDTerminalRuleCall_11_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeIDTerminalRuleCall_11_1_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeCrossReference_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__StereotypesAssignment_11_1"


    // $ANTLR start "rule__Attribute__StereotypesAssignment_11_2_1"
    // InternalMetaDsl.g:9387:1: rule__Attribute__StereotypesAssignment_11_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__StereotypesAssignment_11_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9391:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:9392:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:9392:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:9393:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeCrossReference_11_2_1_0()); 
            // InternalMetaDsl.g:9394:3: ( RULE_ID )
            // InternalMetaDsl.g:9395:4: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeIDTerminalRuleCall_11_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeIDTerminalRuleCall_11_2_1_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeCrossReference_11_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__StereotypesAssignment_11_2_1"


    // $ANTLR start "rule__Attribute__IdGeneratorAssignment_12"
    // InternalMetaDsl.g:9406:1: rule__Attribute__IdGeneratorAssignment_12 : ( ruleIdGenerator ) ;
    public final void rule__Attribute__IdGeneratorAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9410:1: ( ( ruleIdGenerator ) )
            // InternalMetaDsl.g:9411:2: ( ruleIdGenerator )
            {
            // InternalMetaDsl.g:9411:2: ( ruleIdGenerator )
            // InternalMetaDsl.g:9412:3: ruleIdGenerator
            {
             before(grammarAccess.getAttributeAccess().getIdGeneratorIdGeneratorParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleIdGenerator();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getIdGeneratorIdGeneratorParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__IdGeneratorAssignment_12"


    // $ANTLR start "rule__IdGenerator__AttributeAssignment_1"
    // InternalMetaDsl.g:9421:1: rule__IdGenerator__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__IdGenerator__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9425:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:9426:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:9426:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:9427:3: ( RULE_ID )
            {
             before(grammarAccess.getIdGeneratorAccess().getAttributeAttributeCrossReference_1_0()); 
            // InternalMetaDsl.g:9428:3: ( RULE_ID )
            // InternalMetaDsl.g:9429:4: RULE_ID
            {
             before(grammarAccess.getIdGeneratorAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getIdGeneratorAccess().getAttributeAttributeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getIdGeneratorAccess().getAttributeAttributeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGenerator__AttributeAssignment_1"


    // $ANTLR start "rule__IdGenerator__TypeBlockAssignment_2"
    // InternalMetaDsl.g:9440:1: rule__IdGenerator__TypeBlockAssignment_2 : ( ruleIdGeneratorTypeBlock ) ;
    public final void rule__IdGenerator__TypeBlockAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9444:1: ( ( ruleIdGeneratorTypeBlock ) )
            // InternalMetaDsl.g:9445:2: ( ruleIdGeneratorTypeBlock )
            {
            // InternalMetaDsl.g:9445:2: ( ruleIdGeneratorTypeBlock )
            // InternalMetaDsl.g:9446:3: ruleIdGeneratorTypeBlock
            {
             before(grammarAccess.getIdGeneratorAccess().getTypeBlockIdGeneratorTypeBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleIdGeneratorTypeBlock();

            state._fsp--;

             after(grammarAccess.getIdGeneratorAccess().getTypeBlockIdGeneratorTypeBlockParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGenerator__TypeBlockAssignment_2"


    // $ANTLR start "rule__IdGeneratorSimple__TypeAssignment_0_1"
    // InternalMetaDsl.g:9455:1: rule__IdGeneratorSimple__TypeAssignment_0_1 : ( ( 'BYRULE' ) ) ;
    public final void rule__IdGeneratorSimple__TypeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9459:1: ( ( ( 'BYRULE' ) ) )
            // InternalMetaDsl.g:9460:2: ( ( 'BYRULE' ) )
            {
            // InternalMetaDsl.g:9460:2: ( ( 'BYRULE' ) )
            // InternalMetaDsl.g:9461:3: ( 'BYRULE' )
            {
             before(grammarAccess.getIdGeneratorSimpleAccess().getTypeBYRULEKeyword_0_1_0()); 
            // InternalMetaDsl.g:9462:3: ( 'BYRULE' )
            // InternalMetaDsl.g:9463:4: 'BYRULE'
            {
             before(grammarAccess.getIdGeneratorSimpleAccess().getTypeBYRULEKeyword_0_1_0()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getIdGeneratorSimpleAccess().getTypeBYRULEKeyword_0_1_0()); 

            }

             after(grammarAccess.getIdGeneratorSimpleAccess().getTypeBYRULEKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSimple__TypeAssignment_0_1"


    // $ANTLR start "rule__IdGeneratorSequence__TypeAssignment_1"
    // InternalMetaDsl.g:9474:1: rule__IdGeneratorSequence__TypeAssignment_1 : ( ( 'SEQUENCE' ) ) ;
    public final void rule__IdGeneratorSequence__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9478:1: ( ( ( 'SEQUENCE' ) ) )
            // InternalMetaDsl.g:9479:2: ( ( 'SEQUENCE' ) )
            {
            // InternalMetaDsl.g:9479:2: ( ( 'SEQUENCE' ) )
            // InternalMetaDsl.g:9480:3: ( 'SEQUENCE' )
            {
             before(grammarAccess.getIdGeneratorSequenceAccess().getTypeSEQUENCEKeyword_1_0()); 
            // InternalMetaDsl.g:9481:3: ( 'SEQUENCE' )
            // InternalMetaDsl.g:9482:4: 'SEQUENCE'
            {
             before(grammarAccess.getIdGeneratorSequenceAccess().getTypeSEQUENCEKeyword_1_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getIdGeneratorSequenceAccess().getTypeSEQUENCEKeyword_1_0()); 

            }

             after(grammarAccess.getIdGeneratorSequenceAccess().getTypeSEQUENCEKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSequence__TypeAssignment_1"


    // $ANTLR start "rule__IdGeneratorSequence__SequenceAssignment_2"
    // InternalMetaDsl.g:9493:1: rule__IdGeneratorSequence__SequenceAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__IdGeneratorSequence__SequenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9497:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9498:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9498:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9499:3: ( ruleFQN )
            {
             before(grammarAccess.getIdGeneratorSequenceAccess().getSequenceSequenceCrossReference_2_0()); 
            // InternalMetaDsl.g:9500:3: ( ruleFQN )
            // InternalMetaDsl.g:9501:4: ruleFQN
            {
             before(grammarAccess.getIdGeneratorSequenceAccess().getSequenceSequenceFQNParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getIdGeneratorSequenceAccess().getSequenceSequenceFQNParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getIdGeneratorSequenceAccess().getSequenceSequenceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdGeneratorSequence__SequenceAssignment_2"


    // $ANTLR start "rule__EnuMetadata__EnuMetadataRowsAssignment_2"
    // InternalMetaDsl.g:9512:1: rule__EnuMetadata__EnuMetadataRowsAssignment_2 : ( ruleEnuMetadataRow ) ;
    public final void rule__EnuMetadata__EnuMetadataRowsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9516:1: ( ( ruleEnuMetadataRow ) )
            // InternalMetaDsl.g:9517:2: ( ruleEnuMetadataRow )
            {
            // InternalMetaDsl.g:9517:2: ( ruleEnuMetadataRow )
            // InternalMetaDsl.g:9518:3: ruleEnuMetadataRow
            {
             before(grammarAccess.getEnuMetadataAccess().getEnuMetadataRowsEnuMetadataRowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEnuMetadataRow();

            state._fsp--;

             after(grammarAccess.getEnuMetadataAccess().getEnuMetadataRowsEnuMetadataRowParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadata__EnuMetadataRowsAssignment_2"


    // $ANTLR start "rule__EnuMetadataRow__KeyAssignment_0"
    // InternalMetaDsl.g:9527:1: rule__EnuMetadataRow__KeyAssignment_0 : ( RULE_NATURAL ) ;
    public final void rule__EnuMetadataRow__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9531:1: ( ( RULE_NATURAL ) )
            // InternalMetaDsl.g:9532:2: ( RULE_NATURAL )
            {
            // InternalMetaDsl.g:9532:2: ( RULE_NATURAL )
            // InternalMetaDsl.g:9533:3: RULE_NATURAL
            {
             before(grammarAccess.getEnuMetadataRowAccess().getKeyNATURALTerminalRuleCall_0_0()); 
            match(input,RULE_NATURAL,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataRowAccess().getKeyNATURALTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__KeyAssignment_0"


    // $ANTLR start "rule__EnuMetadataRow__NameAssignment_2"
    // InternalMetaDsl.g:9542:1: rule__EnuMetadataRow__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnuMetadataRow__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9546:1: ( ( RULE_ID ) )
            // InternalMetaDsl.g:9547:2: ( RULE_ID )
            {
            // InternalMetaDsl.g:9547:2: ( RULE_ID )
            // InternalMetaDsl.g:9548:3: RULE_ID
            {
             before(grammarAccess.getEnuMetadataRowAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataRowAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__NameAssignment_2"


    // $ANTLR start "rule__EnuMetadataRow__DescriptionAssignment_4"
    // InternalMetaDsl.g:9557:1: rule__EnuMetadataRow__DescriptionAssignment_4 : ( RULE_STRING ) ;
    public final void rule__EnuMetadataRow__DescriptionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9561:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:9562:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:9562:2: ( RULE_STRING )
            // InternalMetaDsl.g:9563:3: RULE_STRING
            {
             before(grammarAccess.getEnuMetadataRowAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEnuMetadataRowAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__DescriptionAssignment_4"


    // $ANTLR start "rule__EnuMetadataRow__RowValuesAssignment_5_1"
    // InternalMetaDsl.g:9572:1: rule__EnuMetadataRow__RowValuesAssignment_5_1 : ( ruleMetadataRowCell ) ;
    public final void rule__EnuMetadataRow__RowValuesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9576:1: ( ( ruleMetadataRowCell ) )
            // InternalMetaDsl.g:9577:2: ( ruleMetadataRowCell )
            {
            // InternalMetaDsl.g:9577:2: ( ruleMetadataRowCell )
            // InternalMetaDsl.g:9578:3: ruleMetadataRowCell
            {
             before(grammarAccess.getEnuMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMetadataRowCell();

            state._fsp--;

             after(grammarAccess.getEnuMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnuMetadataRow__RowValuesAssignment_5_1"


    // $ANTLR start "rule__Metadata__NameAssignment_0"
    // InternalMetaDsl.g:9587:1: rule__Metadata__NameAssignment_0 : ( ( 'METADATA' ) ) ;
    public final void rule__Metadata__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9591:1: ( ( ( 'METADATA' ) ) )
            // InternalMetaDsl.g:9592:2: ( ( 'METADATA' ) )
            {
            // InternalMetaDsl.g:9592:2: ( ( 'METADATA' ) )
            // InternalMetaDsl.g:9593:3: ( 'METADATA' )
            {
             before(grammarAccess.getMetadataAccess().getNameMETADATAKeyword_0_0()); 
            // InternalMetaDsl.g:9594:3: ( 'METADATA' )
            // InternalMetaDsl.g:9595:4: 'METADATA'
            {
             before(grammarAccess.getMetadataAccess().getNameMETADATAKeyword_0_0()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getMetadataAccess().getNameMETADATAKeyword_0_0()); 

            }

             after(grammarAccess.getMetadataAccess().getNameMETADATAKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__NameAssignment_0"


    // $ANTLR start "rule__Metadata__EntityAssignment_1_1"
    // InternalMetaDsl.g:9606:1: rule__Metadata__EntityAssignment_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__Metadata__EntityAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9610:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9611:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9611:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9612:3: ( ruleFQN )
            {
             before(grammarAccess.getMetadataAccess().getEntityEntityCrossReference_1_1_0()); 
            // InternalMetaDsl.g:9613:3: ( ruleFQN )
            // InternalMetaDsl.g:9614:4: ruleFQN
            {
             before(grammarAccess.getMetadataAccess().getEntityEntityFQNParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getMetadataAccess().getEntityEntityFQNParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getMetadataAccess().getEntityEntityCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__EntityAssignment_1_1"


    // $ANTLR start "rule__Metadata__MetadataRowsAssignment_3"
    // InternalMetaDsl.g:9625:1: rule__Metadata__MetadataRowsAssignment_3 : ( ruleMetadataRow ) ;
    public final void rule__Metadata__MetadataRowsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9629:1: ( ( ruleMetadataRow ) )
            // InternalMetaDsl.g:9630:2: ( ruleMetadataRow )
            {
            // InternalMetaDsl.g:9630:2: ( ruleMetadataRow )
            // InternalMetaDsl.g:9631:3: ruleMetadataRow
            {
             before(grammarAccess.getMetadataAccess().getMetadataRowsMetadataRowParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMetadataRow();

            state._fsp--;

             after(grammarAccess.getMetadataAccess().getMetadataRowsMetadataRowParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Metadata__MetadataRowsAssignment_3"


    // $ANTLR start "rule__ShortCode__ShortCodeValueAssignment_1"
    // InternalMetaDsl.g:9640:1: rule__ShortCode__ShortCodeValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ShortCode__ShortCodeValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9644:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:9645:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:9645:2: ( RULE_STRING )
            // InternalMetaDsl.g:9646:3: RULE_STRING
            {
             before(grammarAccess.getShortCodeAccess().getShortCodeValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getShortCodeAccess().getShortCodeValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShortCode__ShortCodeValueAssignment_1"


    // $ANTLR start "rule__MetadataRow__RowValuesAssignment_0"
    // InternalMetaDsl.g:9655:1: rule__MetadataRow__RowValuesAssignment_0 : ( ruleMetadataRowCell ) ;
    public final void rule__MetadataRow__RowValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9659:1: ( ( ruleMetadataRowCell ) )
            // InternalMetaDsl.g:9660:2: ( ruleMetadataRowCell )
            {
            // InternalMetaDsl.g:9660:2: ( ruleMetadataRowCell )
            // InternalMetaDsl.g:9661:3: ruleMetadataRowCell
            {
             before(grammarAccess.getMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMetadataRowCell();

            state._fsp--;

             after(grammarAccess.getMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__RowValuesAssignment_0"


    // $ANTLR start "rule__MetadataRow__RowValuesAssignment_1_1"
    // InternalMetaDsl.g:9670:1: rule__MetadataRow__RowValuesAssignment_1_1 : ( ruleMetadataRowCell ) ;
    public final void rule__MetadataRow__RowValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9674:1: ( ( ruleMetadataRowCell ) )
            // InternalMetaDsl.g:9675:2: ( ruleMetadataRowCell )
            {
            // InternalMetaDsl.g:9675:2: ( ruleMetadataRowCell )
            // InternalMetaDsl.g:9676:3: ruleMetadataRowCell
            {
             before(grammarAccess.getMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMetadataRowCell();

            state._fsp--;

             after(grammarAccess.getMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRow__RowValuesAssignment_1_1"


    // $ANTLR start "rule__MetadataRowCell__StringValueAssignment_0"
    // InternalMetaDsl.g:9685:1: rule__MetadataRowCell__StringValueAssignment_0 : ( ( rule__MetadataRowCell__StringValueAlternatives_0_0 ) ) ;
    public final void rule__MetadataRowCell__StringValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9689:1: ( ( ( rule__MetadataRowCell__StringValueAlternatives_0_0 ) ) )
            // InternalMetaDsl.g:9690:2: ( ( rule__MetadataRowCell__StringValueAlternatives_0_0 ) )
            {
            // InternalMetaDsl.g:9690:2: ( ( rule__MetadataRowCell__StringValueAlternatives_0_0 ) )
            // InternalMetaDsl.g:9691:3: ( rule__MetadataRowCell__StringValueAlternatives_0_0 )
            {
             before(grammarAccess.getMetadataRowCellAccess().getStringValueAlternatives_0_0()); 
            // InternalMetaDsl.g:9692:3: ( rule__MetadataRowCell__StringValueAlternatives_0_0 )
            // InternalMetaDsl.g:9692:4: rule__MetadataRowCell__StringValueAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__MetadataRowCell__StringValueAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getMetadataRowCellAccess().getStringValueAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRowCell__StringValueAssignment_0"


    // $ANTLR start "rule__MetadataRowCell__ShortCodeAssignment_1"
    // InternalMetaDsl.g:9700:1: rule__MetadataRowCell__ShortCodeAssignment_1 : ( ruleShortCode ) ;
    public final void rule__MetadataRowCell__ShortCodeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9704:1: ( ( ruleShortCode ) )
            // InternalMetaDsl.g:9705:2: ( ruleShortCode )
            {
            // InternalMetaDsl.g:9705:2: ( ruleShortCode )
            // InternalMetaDsl.g:9706:3: ruleShortCode
            {
             before(grammarAccess.getMetadataRowCellAccess().getShortCodeShortCodeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleShortCode();

            state._fsp--;

             after(grammarAccess.getMetadataRowCellAccess().getShortCodeShortCodeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRowCell__ShortCodeAssignment_1"


    // $ANTLR start "rule__MetadataRowCell__IsNullAssignment_2"
    // InternalMetaDsl.g:9715:1: rule__MetadataRowCell__IsNullAssignment_2 : ( ( 'NULL' ) ) ;
    public final void rule__MetadataRowCell__IsNullAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9719:1: ( ( ( 'NULL' ) ) )
            // InternalMetaDsl.g:9720:2: ( ( 'NULL' ) )
            {
            // InternalMetaDsl.g:9720:2: ( ( 'NULL' ) )
            // InternalMetaDsl.g:9721:3: ( 'NULL' )
            {
             before(grammarAccess.getMetadataRowCellAccess().getIsNullNULLKeyword_2_0()); 
            // InternalMetaDsl.g:9722:3: ( 'NULL' )
            // InternalMetaDsl.g:9723:4: 'NULL'
            {
             before(grammarAccess.getMetadataRowCellAccess().getIsNullNULLKeyword_2_0()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getMetadataRowCellAccess().getIsNullNULLKeyword_2_0()); 

            }

             after(grammarAccess.getMetadataRowCellAccess().getIsNullNULLKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRowCell__IsNullAssignment_2"


    // $ANTLR start "rule__MetadataRowCell__IsDefaultAssignment_3"
    // InternalMetaDsl.g:9734:1: rule__MetadataRowCell__IsDefaultAssignment_3 : ( ( 'DEFAULT' ) ) ;
    public final void rule__MetadataRowCell__IsDefaultAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9738:1: ( ( ( 'DEFAULT' ) ) )
            // InternalMetaDsl.g:9739:2: ( ( 'DEFAULT' ) )
            {
            // InternalMetaDsl.g:9739:2: ( ( 'DEFAULT' ) )
            // InternalMetaDsl.g:9740:3: ( 'DEFAULT' )
            {
             before(grammarAccess.getMetadataRowCellAccess().getIsDefaultDEFAULTKeyword_3_0()); 
            // InternalMetaDsl.g:9741:3: ( 'DEFAULT' )
            // InternalMetaDsl.g:9742:4: 'DEFAULT'
            {
             before(grammarAccess.getMetadataRowCellAccess().getIsDefaultDEFAULTKeyword_3_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getMetadataRowCellAccess().getIsDefaultDEFAULTKeyword_3_0()); 

            }

             after(grammarAccess.getMetadataRowCellAccess().getIsDefaultDEFAULTKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetadataRowCell__IsDefaultAssignment_3"


    // $ANTLR start "rule__LabelSection__NameAssignment_0"
    // InternalMetaDsl.g:9753:1: rule__LabelSection__NameAssignment_0 : ( ( 'LABELS' ) ) ;
    public final void rule__LabelSection__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9757:1: ( ( ( 'LABELS' ) ) )
            // InternalMetaDsl.g:9758:2: ( ( 'LABELS' ) )
            {
            // InternalMetaDsl.g:9758:2: ( ( 'LABELS' ) )
            // InternalMetaDsl.g:9759:3: ( 'LABELS' )
            {
             before(grammarAccess.getLabelSectionAccess().getNameLABELSKeyword_0_0()); 
            // InternalMetaDsl.g:9760:3: ( 'LABELS' )
            // InternalMetaDsl.g:9761:4: 'LABELS'
            {
             before(grammarAccess.getLabelSectionAccess().getNameLABELSKeyword_0_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getLabelSectionAccess().getNameLABELSKeyword_0_0()); 

            }

             after(grammarAccess.getLabelSectionAccess().getNameLABELSKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__NameAssignment_0"


    // $ANTLR start "rule__LabelSection__LabelsAssignment_2"
    // InternalMetaDsl.g:9772:1: rule__LabelSection__LabelsAssignment_2 : ( ruleLabelBlock ) ;
    public final void rule__LabelSection__LabelsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9776:1: ( ( ruleLabelBlock ) )
            // InternalMetaDsl.g:9777:2: ( ruleLabelBlock )
            {
            // InternalMetaDsl.g:9777:2: ( ruleLabelBlock )
            // InternalMetaDsl.g:9778:3: ruleLabelBlock
            {
             before(grammarAccess.getLabelSectionAccess().getLabelsLabelBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLabelBlock();

            state._fsp--;

             after(grammarAccess.getLabelSectionAccess().getLabelsLabelBlockParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelSection__LabelsAssignment_2"


    // $ANTLR start "rule__LabelBlock__EntityAssignment_1_0"
    // InternalMetaDsl.g:9787:1: rule__LabelBlock__EntityAssignment_1_0 : ( ( 'ENTITY' ) ) ;
    public final void rule__LabelBlock__EntityAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9791:1: ( ( ( 'ENTITY' ) ) )
            // InternalMetaDsl.g:9792:2: ( ( 'ENTITY' ) )
            {
            // InternalMetaDsl.g:9792:2: ( ( 'ENTITY' ) )
            // InternalMetaDsl.g:9793:3: ( 'ENTITY' )
            {
             before(grammarAccess.getLabelBlockAccess().getEntityENTITYKeyword_1_0_0()); 
            // InternalMetaDsl.g:9794:3: ( 'ENTITY' )
            // InternalMetaDsl.g:9795:4: 'ENTITY'
            {
             before(grammarAccess.getLabelBlockAccess().getEntityENTITYKeyword_1_0_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getLabelBlockAccess().getEntityENTITYKeyword_1_0_0()); 

            }

             after(grammarAccess.getLabelBlockAccess().getEntityENTITYKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__EntityAssignment_1_0"


    // $ANTLR start "rule__LabelBlock__AttributeAssignment_1_1"
    // InternalMetaDsl.g:9806:1: rule__LabelBlock__AttributeAssignment_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__LabelBlock__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9810:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9811:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9811:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9812:3: ( ruleFQN )
            {
             before(grammarAccess.getLabelBlockAccess().getAttributeAttributeCrossReference_1_1_0()); 
            // InternalMetaDsl.g:9813:3: ( ruleFQN )
            // InternalMetaDsl.g:9814:4: ruleFQN
            {
             before(grammarAccess.getLabelBlockAccess().getAttributeAttributeFQNParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getLabelBlockAccess().getAttributeAttributeFQNParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getLabelBlockAccess().getAttributeAttributeCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__AttributeAssignment_1_1"


    // $ANTLR start "rule__LabelBlock__TypeAssignment_3"
    // InternalMetaDsl.g:9825:1: rule__LabelBlock__TypeAssignment_3 : ( ( rule__LabelBlock__TypeAlternatives_3_0 ) ) ;
    public final void rule__LabelBlock__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9829:1: ( ( ( rule__LabelBlock__TypeAlternatives_3_0 ) ) )
            // InternalMetaDsl.g:9830:2: ( ( rule__LabelBlock__TypeAlternatives_3_0 ) )
            {
            // InternalMetaDsl.g:9830:2: ( ( rule__LabelBlock__TypeAlternatives_3_0 ) )
            // InternalMetaDsl.g:9831:3: ( rule__LabelBlock__TypeAlternatives_3_0 )
            {
             before(grammarAccess.getLabelBlockAccess().getTypeAlternatives_3_0()); 
            // InternalMetaDsl.g:9832:3: ( rule__LabelBlock__TypeAlternatives_3_0 )
            // InternalMetaDsl.g:9832:4: rule__LabelBlock__TypeAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__LabelBlock__TypeAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getLabelBlockAccess().getTypeAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__TypeAssignment_3"


    // $ANTLR start "rule__LabelBlock__LabelsAssignment_4"
    // InternalMetaDsl.g:9840:1: rule__LabelBlock__LabelsAssignment_4 : ( ruleLabel ) ;
    public final void rule__LabelBlock__LabelsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9844:1: ( ( ruleLabel ) )
            // InternalMetaDsl.g:9845:2: ( ruleLabel )
            {
            // InternalMetaDsl.g:9845:2: ( ruleLabel )
            // InternalMetaDsl.g:9846:3: ruleLabel
            {
             before(grammarAccess.getLabelBlockAccess().getLabelsLabelParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleLabel();

            state._fsp--;

             after(grammarAccess.getLabelBlockAccess().getLabelsLabelParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LabelBlock__LabelsAssignment_4"


    // $ANTLR start "rule__GeneralLabelSection__NameAssignment_0"
    // InternalMetaDsl.g:9855:1: rule__GeneralLabelSection__NameAssignment_0 : ( ( 'LABELS' ) ) ;
    public final void rule__GeneralLabelSection__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9859:1: ( ( ( 'LABELS' ) ) )
            // InternalMetaDsl.g:9860:2: ( ( 'LABELS' ) )
            {
            // InternalMetaDsl.g:9860:2: ( ( 'LABELS' ) )
            // InternalMetaDsl.g:9861:3: ( 'LABELS' )
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getNameLABELSKeyword_0_0()); 
            // InternalMetaDsl.g:9862:3: ( 'LABELS' )
            // InternalMetaDsl.g:9863:4: 'LABELS'
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getNameLABELSKeyword_0_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getGeneralLabelSectionAccess().getNameLABELSKeyword_0_0()); 

            }

             after(grammarAccess.getGeneralLabelSectionAccess().getNameLABELSKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__NameAssignment_0"


    // $ANTLR start "rule__GeneralLabelSection__KeyLabelAssignment_2"
    // InternalMetaDsl.g:9874:1: rule__GeneralLabelSection__KeyLabelAssignment_2 : ( ruleKeyLabel ) ;
    public final void rule__GeneralLabelSection__KeyLabelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9878:1: ( ( ruleKeyLabel ) )
            // InternalMetaDsl.g:9879:2: ( ruleKeyLabel )
            {
            // InternalMetaDsl.g:9879:2: ( ruleKeyLabel )
            // InternalMetaDsl.g:9880:3: ruleKeyLabel
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getKeyLabelKeyLabelParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyLabel();

            state._fsp--;

             after(grammarAccess.getGeneralLabelSectionAccess().getKeyLabelKeyLabelParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__KeyLabelAssignment_2"


    // $ANTLR start "rule__GeneralLabelSection__OverrideLabelBlockAssignment_3"
    // InternalMetaDsl.g:9889:1: rule__GeneralLabelSection__OverrideLabelBlockAssignment_3 : ( ruleOverrideLabelBlock ) ;
    public final void rule__GeneralLabelSection__OverrideLabelBlockAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9893:1: ( ( ruleOverrideLabelBlock ) )
            // InternalMetaDsl.g:9894:2: ( ruleOverrideLabelBlock )
            {
            // InternalMetaDsl.g:9894:2: ( ruleOverrideLabelBlock )
            // InternalMetaDsl.g:9895:3: ruleOverrideLabelBlock
            {
             before(grammarAccess.getGeneralLabelSectionAccess().getOverrideLabelBlockOverrideLabelBlockParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleOverrideLabelBlock();

            state._fsp--;

             after(grammarAccess.getGeneralLabelSectionAccess().getOverrideLabelBlockOverrideLabelBlockParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneralLabelSection__OverrideLabelBlockAssignment_3"


    // $ANTLR start "rule__KeyLabel__KeyAssignment_1"
    // InternalMetaDsl.g:9904:1: rule__KeyLabel__KeyAssignment_1 : ( ruleFQN ) ;
    public final void rule__KeyLabel__KeyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9908:1: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9909:2: ( ruleFQN )
            {
            // InternalMetaDsl.g:9909:2: ( ruleFQN )
            // InternalMetaDsl.g:9910:3: ruleFQN
            {
             before(grammarAccess.getKeyLabelAccess().getKeyFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getKeyLabelAccess().getKeyFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__KeyAssignment_1"


    // $ANTLR start "rule__KeyLabel__LabelsAssignment_3"
    // InternalMetaDsl.g:9919:1: rule__KeyLabel__LabelsAssignment_3 : ( ruleLabel ) ;
    public final void rule__KeyLabel__LabelsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9923:1: ( ( ruleLabel ) )
            // InternalMetaDsl.g:9924:2: ( ruleLabel )
            {
            // InternalMetaDsl.g:9924:2: ( ruleLabel )
            // InternalMetaDsl.g:9925:3: ruleLabel
            {
             before(grammarAccess.getKeyLabelAccess().getLabelsLabelParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLabel();

            state._fsp--;

             after(grammarAccess.getKeyLabelAccess().getLabelsLabelParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyLabel__LabelsAssignment_3"


    // $ANTLR start "rule__OverrideLabelBlock__AttributeAssignment_1_0_1"
    // InternalMetaDsl.g:9934:1: rule__OverrideLabelBlock__AttributeAssignment_1_0_1 : ( ( ruleFQN ) ) ;
    public final void rule__OverrideLabelBlock__AttributeAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9938:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9939:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9939:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9940:3: ( ruleFQN )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getAttributeAttributeCrossReference_1_0_1_0()); 
            // InternalMetaDsl.g:9941:3: ( ruleFQN )
            // InternalMetaDsl.g:9942:4: ruleFQN
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getAttributeAttributeFQNParserRuleCall_1_0_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getOverrideLabelBlockAccess().getAttributeAttributeFQNParserRuleCall_1_0_1_0_1()); 

            }

             after(grammarAccess.getOverrideLabelBlockAccess().getAttributeAttributeCrossReference_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__AttributeAssignment_1_0_1"


    // $ANTLR start "rule__OverrideLabelBlock__EntityAssignment_1_1_1"
    // InternalMetaDsl.g:9953:1: rule__OverrideLabelBlock__EntityAssignment_1_1_1 : ( ( ruleFQN ) ) ;
    public final void rule__OverrideLabelBlock__EntityAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9957:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9958:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9958:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9959:3: ( ruleFQN )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getEntityEntityCrossReference_1_1_1_0()); 
            // InternalMetaDsl.g:9960:3: ( ruleFQN )
            // InternalMetaDsl.g:9961:4: ruleFQN
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getEntityEntityFQNParserRuleCall_1_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getOverrideLabelBlockAccess().getEntityEntityFQNParserRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getOverrideLabelBlockAccess().getEntityEntityCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__EntityAssignment_1_1_1"


    // $ANTLR start "rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1"
    // InternalMetaDsl.g:9972:1: rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1 : ( ( ruleFQN ) ) ;
    public final void rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9976:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:9977:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:9977:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:9978:3: ( ruleFQN )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getEnuMetadataRowEnuMetadataRowCrossReference_1_2_1_0()); 
            // InternalMetaDsl.g:9979:3: ( ruleFQN )
            // InternalMetaDsl.g:9980:4: ruleFQN
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getEnuMetadataRowEnuMetadataRowFQNParserRuleCall_1_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getOverrideLabelBlockAccess().getEnuMetadataRowEnuMetadataRowFQNParserRuleCall_1_2_1_0_1()); 

            }

             after(grammarAccess.getOverrideLabelBlockAccess().getEnuMetadataRowEnuMetadataRowCrossReference_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__EnuMetadataRowAssignment_1_2_1"


    // $ANTLR start "rule__OverrideLabelBlock__TypeAssignment_3"
    // InternalMetaDsl.g:9991:1: rule__OverrideLabelBlock__TypeAssignment_3 : ( ( rule__OverrideLabelBlock__TypeAlternatives_3_0 ) ) ;
    public final void rule__OverrideLabelBlock__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:9995:1: ( ( ( rule__OverrideLabelBlock__TypeAlternatives_3_0 ) ) )
            // InternalMetaDsl.g:9996:2: ( ( rule__OverrideLabelBlock__TypeAlternatives_3_0 ) )
            {
            // InternalMetaDsl.g:9996:2: ( ( rule__OverrideLabelBlock__TypeAlternatives_3_0 ) )
            // InternalMetaDsl.g:9997:3: ( rule__OverrideLabelBlock__TypeAlternatives_3_0 )
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getTypeAlternatives_3_0()); 
            // InternalMetaDsl.g:9998:3: ( rule__OverrideLabelBlock__TypeAlternatives_3_0 )
            // InternalMetaDsl.g:9998:4: rule__OverrideLabelBlock__TypeAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__OverrideLabelBlock__TypeAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getOverrideLabelBlockAccess().getTypeAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__TypeAssignment_3"


    // $ANTLR start "rule__OverrideLabelBlock__LabelsAssignment_4"
    // InternalMetaDsl.g:10006:1: rule__OverrideLabelBlock__LabelsAssignment_4 : ( ruleLabel ) ;
    public final void rule__OverrideLabelBlock__LabelsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10010:1: ( ( ruleLabel ) )
            // InternalMetaDsl.g:10011:2: ( ruleLabel )
            {
            // InternalMetaDsl.g:10011:2: ( ruleLabel )
            // InternalMetaDsl.g:10012:3: ruleLabel
            {
             before(grammarAccess.getOverrideLabelBlockAccess().getLabelsLabelParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleLabel();

            state._fsp--;

             after(grammarAccess.getOverrideLabelBlockAccess().getLabelsLabelParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OverrideLabelBlock__LabelsAssignment_4"


    // $ANTLR start "rule__EnumerationLabels__EnumerationLabelAssignment_2"
    // InternalMetaDsl.g:10021:1: rule__EnumerationLabels__EnumerationLabelAssignment_2 : ( ruleEnumerationLabel ) ;
    public final void rule__EnumerationLabels__EnumerationLabelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10025:1: ( ( ruleEnumerationLabel ) )
            // InternalMetaDsl.g:10026:2: ( ruleEnumerationLabel )
            {
            // InternalMetaDsl.g:10026:2: ( ruleEnumerationLabel )
            // InternalMetaDsl.g:10027:3: ruleEnumerationLabel
            {
             before(grammarAccess.getEnumerationLabelsAccess().getEnumerationLabelEnumerationLabelParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumerationLabel();

            state._fsp--;

             after(grammarAccess.getEnumerationLabelsAccess().getEnumerationLabelEnumerationLabelParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabels__EnumerationLabelAssignment_2"


    // $ANTLR start "rule__EnumerationLabel__EnuMetadataRowAssignment_0"
    // InternalMetaDsl.g:10036:1: rule__EnumerationLabel__EnuMetadataRowAssignment_0 : ( ( ruleFQN ) ) ;
    public final void rule__EnumerationLabel__EnuMetadataRowAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10040:1: ( ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:10041:2: ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:10041:2: ( ( ruleFQN ) )
            // InternalMetaDsl.g:10042:3: ( ruleFQN )
            {
             before(grammarAccess.getEnumerationLabelAccess().getEnuMetadataRowEnuMetadataRowCrossReference_0_0()); 
            // InternalMetaDsl.g:10043:3: ( ruleFQN )
            // InternalMetaDsl.g:10044:4: ruleFQN
            {
             before(grammarAccess.getEnumerationLabelAccess().getEnuMetadataRowEnuMetadataRowFQNParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getEnumerationLabelAccess().getEnuMetadataRowEnuMetadataRowFQNParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getEnumerationLabelAccess().getEnuMetadataRowEnuMetadataRowCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__EnuMetadataRowAssignment_0"


    // $ANTLR start "rule__EnumerationLabel__TypeAssignment_2"
    // InternalMetaDsl.g:10055:1: rule__EnumerationLabel__TypeAssignment_2 : ( ( rule__EnumerationLabel__TypeAlternatives_2_0 ) ) ;
    public final void rule__EnumerationLabel__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10059:1: ( ( ( rule__EnumerationLabel__TypeAlternatives_2_0 ) ) )
            // InternalMetaDsl.g:10060:2: ( ( rule__EnumerationLabel__TypeAlternatives_2_0 ) )
            {
            // InternalMetaDsl.g:10060:2: ( ( rule__EnumerationLabel__TypeAlternatives_2_0 ) )
            // InternalMetaDsl.g:10061:3: ( rule__EnumerationLabel__TypeAlternatives_2_0 )
            {
             before(grammarAccess.getEnumerationLabelAccess().getTypeAlternatives_2_0()); 
            // InternalMetaDsl.g:10062:3: ( rule__EnumerationLabel__TypeAlternatives_2_0 )
            // InternalMetaDsl.g:10062:4: rule__EnumerationLabel__TypeAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationLabel__TypeAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationLabelAccess().getTypeAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__TypeAssignment_2"


    // $ANTLR start "rule__EnumerationLabel__LabelsAssignment_3"
    // InternalMetaDsl.g:10070:1: rule__EnumerationLabel__LabelsAssignment_3 : ( ruleLabel ) ;
    public final void rule__EnumerationLabel__LabelsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10074:1: ( ( ruleLabel ) )
            // InternalMetaDsl.g:10075:2: ( ruleLabel )
            {
            // InternalMetaDsl.g:10075:2: ( ruleLabel )
            // InternalMetaDsl.g:10076:3: ruleLabel
            {
             before(grammarAccess.getEnumerationLabelAccess().getLabelsLabelParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLabel();

            state._fsp--;

             after(grammarAccess.getEnumerationLabelAccess().getLabelsLabelParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationLabel__LabelsAssignment_3"


    // $ANTLR start "rule__Label__LangAssignment_0"
    // InternalMetaDsl.g:10085:1: rule__Label__LangAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Label__LangAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10089:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:10090:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:10090:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:10091:3: ( RULE_ID )
            {
             before(grammarAccess.getLabelAccess().getLangLanguageCrossReference_0_0()); 
            // InternalMetaDsl.g:10092:3: ( RULE_ID )
            // InternalMetaDsl.g:10093:4: RULE_ID
            {
             before(grammarAccess.getLabelAccess().getLangLanguageIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLabelAccess().getLangLanguageIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getLabelAccess().getLangLanguageCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__LangAssignment_0"


    // $ANTLR start "rule__Label__LabelTextAssignment_1"
    // InternalMetaDsl.g:10104:1: rule__Label__LabelTextAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Label__LabelTextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10108:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:10109:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:10109:2: ( RULE_STRING )
            // InternalMetaDsl.g:10110:3: RULE_STRING
            {
             before(grammarAccess.getLabelAccess().getLabelTextSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getLabelAccess().getLabelTextSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__LabelTextAssignment_1"


    // $ANTLR start "rule__DocumentationSection__NameAssignment_0"
    // InternalMetaDsl.g:10119:1: rule__DocumentationSection__NameAssignment_0 : ( ( 'DOCUMENTATION' ) ) ;
    public final void rule__DocumentationSection__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10123:1: ( ( ( 'DOCUMENTATION' ) ) )
            // InternalMetaDsl.g:10124:2: ( ( 'DOCUMENTATION' ) )
            {
            // InternalMetaDsl.g:10124:2: ( ( 'DOCUMENTATION' ) )
            // InternalMetaDsl.g:10125:3: ( 'DOCUMENTATION' )
            {
             before(grammarAccess.getDocumentationSectionAccess().getNameDOCUMENTATIONKeyword_0_0()); 
            // InternalMetaDsl.g:10126:3: ( 'DOCUMENTATION' )
            // InternalMetaDsl.g:10127:4: 'DOCUMENTATION'
            {
             before(grammarAccess.getDocumentationSectionAccess().getNameDOCUMENTATIONKeyword_0_0()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getDocumentationSectionAccess().getNameDOCUMENTATIONKeyword_0_0()); 

            }

             after(grammarAccess.getDocumentationSectionAccess().getNameDOCUMENTATIONKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__NameAssignment_0"


    // $ANTLR start "rule__DocumentationSection__DocumentationBlocksAssignment_2"
    // InternalMetaDsl.g:10138:1: rule__DocumentationSection__DocumentationBlocksAssignment_2 : ( ruleDocumentationBlock ) ;
    public final void rule__DocumentationSection__DocumentationBlocksAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10142:1: ( ( ruleDocumentationBlock ) )
            // InternalMetaDsl.g:10143:2: ( ruleDocumentationBlock )
            {
            // InternalMetaDsl.g:10143:2: ( ruleDocumentationBlock )
            // InternalMetaDsl.g:10144:3: ruleDocumentationBlock
            {
             before(grammarAccess.getDocumentationSectionAccess().getDocumentationBlocksDocumentationBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDocumentationBlock();

            state._fsp--;

             after(grammarAccess.getDocumentationSectionAccess().getDocumentationBlocksDocumentationBlockParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationSection__DocumentationBlocksAssignment_2"


    // $ANTLR start "rule__DocumentationBlock__AttributeAssignment_0_1"
    // InternalMetaDsl.g:10153:1: rule__DocumentationBlock__AttributeAssignment_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__DocumentationBlock__AttributeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10157:1: ( ( ( RULE_ID ) ) )
            // InternalMetaDsl.g:10158:2: ( ( RULE_ID ) )
            {
            // InternalMetaDsl.g:10158:2: ( ( RULE_ID ) )
            // InternalMetaDsl.g:10159:3: ( RULE_ID )
            {
             before(grammarAccess.getDocumentationBlockAccess().getAttributeAttributeCrossReference_0_1_0()); 
            // InternalMetaDsl.g:10160:3: ( RULE_ID )
            // InternalMetaDsl.g:10161:4: RULE_ID
            {
             before(grammarAccess.getDocumentationBlockAccess().getAttributeAttributeIDTerminalRuleCall_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDocumentationBlockAccess().getAttributeAttributeIDTerminalRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getDocumentationBlockAccess().getAttributeAttributeCrossReference_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationBlock__AttributeAssignment_0_1"


    // $ANTLR start "rule__DocumentationBlock__DocumentationTextAssignment_1"
    // InternalMetaDsl.g:10172:1: rule__DocumentationBlock__DocumentationTextAssignment_1 : ( ( rule__DocumentationBlock__DocumentationTextAlternatives_1_0 ) ) ;
    public final void rule__DocumentationBlock__DocumentationTextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10176:1: ( ( ( rule__DocumentationBlock__DocumentationTextAlternatives_1_0 ) ) )
            // InternalMetaDsl.g:10177:2: ( ( rule__DocumentationBlock__DocumentationTextAlternatives_1_0 ) )
            {
            // InternalMetaDsl.g:10177:2: ( ( rule__DocumentationBlock__DocumentationTextAlternatives_1_0 ) )
            // InternalMetaDsl.g:10178:3: ( rule__DocumentationBlock__DocumentationTextAlternatives_1_0 )
            {
             before(grammarAccess.getDocumentationBlockAccess().getDocumentationTextAlternatives_1_0()); 
            // InternalMetaDsl.g:10179:3: ( rule__DocumentationBlock__DocumentationTextAlternatives_1_0 )
            // InternalMetaDsl.g:10179:4: rule__DocumentationBlock__DocumentationTextAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__DocumentationBlock__DocumentationTextAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationBlockAccess().getDocumentationTextAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DocumentationBlock__DocumentationTextAssignment_1"


    // $ANTLR start "rule__QuerySourceBlock__QuerySourceAssignment_1"
    // InternalMetaDsl.g:10187:1: rule__QuerySourceBlock__QuerySourceAssignment_1 : ( RULE_ML_STRING ) ;
    public final void rule__QuerySourceBlock__QuerySourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10191:1: ( ( RULE_ML_STRING ) )
            // InternalMetaDsl.g:10192:2: ( RULE_ML_STRING )
            {
            // InternalMetaDsl.g:10192:2: ( RULE_ML_STRING )
            // InternalMetaDsl.g:10193:3: RULE_ML_STRING
            {
             before(grammarAccess.getQuerySourceBlockAccess().getQuerySourceML_STRINGTerminalRuleCall_1_0()); 
            match(input,RULE_ML_STRING,FOLLOW_2); 
             after(grammarAccess.getQuerySourceBlockAccess().getQuerySourceML_STRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuerySourceBlock__QuerySourceAssignment_1"


    // $ANTLR start "rule__SQLFunction__NameAssignment_1"
    // InternalMetaDsl.g:10202:1: rule__SQLFunction__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__SQLFunction__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10206:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:10207:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:10207:2: ( RULE_STRING )
            // InternalMetaDsl.g:10208:3: RULE_STRING
            {
             before(grammarAccess.getSQLFunctionAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSQLFunctionAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__NameAssignment_1"


    // $ANTLR start "rule__SQLFunction__SqlFileAssignment_3"
    // InternalMetaDsl.g:10217:1: rule__SQLFunction__SqlFileAssignment_3 : ( RULE_STRING ) ;
    public final void rule__SQLFunction__SqlFileAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10221:1: ( ( RULE_STRING ) )
            // InternalMetaDsl.g:10222:2: ( RULE_STRING )
            {
            // InternalMetaDsl.g:10222:2: ( RULE_STRING )
            // InternalMetaDsl.g:10223:3: RULE_STRING
            {
             before(grammarAccess.getSQLFunctionAccess().getSqlFileSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSQLFunctionAccess().getSqlFileSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SQLFunction__SqlFileAssignment_3"


    // $ANTLR start "rule__SqlNative__NameAssignment_1_1"
    // InternalMetaDsl.g:10232:1: rule__SqlNative__NameAssignment_1_1 : ( ruleFQN ) ;
    public final void rule__SqlNative__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10236:1: ( ( ruleFQN ) )
            // InternalMetaDsl.g:10237:2: ( ruleFQN )
            {
            // InternalMetaDsl.g:10237:2: ( ruleFQN )
            // InternalMetaDsl.g:10238:3: ruleFQN
            {
             before(grammarAccess.getSqlNativeAccess().getNameFQNParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getSqlNativeAccess().getNameFQNParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__NameAssignment_1_1"


    // $ANTLR start "rule__SqlNative__SqlPositionAssignment_2"
    // InternalMetaDsl.g:10247:1: rule__SqlNative__SqlPositionAssignment_2 : ( ( rule__SqlNative__SqlPositionAlternatives_2_0 ) ) ;
    public final void rule__SqlNative__SqlPositionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10251:1: ( ( ( rule__SqlNative__SqlPositionAlternatives_2_0 ) ) )
            // InternalMetaDsl.g:10252:2: ( ( rule__SqlNative__SqlPositionAlternatives_2_0 ) )
            {
            // InternalMetaDsl.g:10252:2: ( ( rule__SqlNative__SqlPositionAlternatives_2_0 ) )
            // InternalMetaDsl.g:10253:3: ( rule__SqlNative__SqlPositionAlternatives_2_0 )
            {
             before(grammarAccess.getSqlNativeAccess().getSqlPositionAlternatives_2_0()); 
            // InternalMetaDsl.g:10254:3: ( rule__SqlNative__SqlPositionAlternatives_2_0 )
            // InternalMetaDsl.g:10254:4: rule__SqlNative__SqlPositionAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__SqlNative__SqlPositionAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getSqlNativeAccess().getSqlPositionAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__SqlPositionAssignment_2"


    // $ANTLR start "rule__SqlNative__SqlNativeBlocksAssignment_4"
    // InternalMetaDsl.g:10262:1: rule__SqlNative__SqlNativeBlocksAssignment_4 : ( ruleSqlNativeBlock ) ;
    public final void rule__SqlNative__SqlNativeBlocksAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10266:1: ( ( ruleSqlNativeBlock ) )
            // InternalMetaDsl.g:10267:2: ( ruleSqlNativeBlock )
            {
            // InternalMetaDsl.g:10267:2: ( ruleSqlNativeBlock )
            // InternalMetaDsl.g:10268:3: ruleSqlNativeBlock
            {
             before(grammarAccess.getSqlNativeAccess().getSqlNativeBlocksSqlNativeBlockParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleSqlNativeBlock();

            state._fsp--;

             after(grammarAccess.getSqlNativeAccess().getSqlNativeBlocksSqlNativeBlockParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNative__SqlNativeBlocksAssignment_4"


    // $ANTLR start "rule__SqlNativeBlock__DbTypeAssignment_0_1"
    // InternalMetaDsl.g:10277:1: rule__SqlNativeBlock__DbTypeAssignment_0_1 : ( ( rule__SqlNativeBlock__DbTypeAlternatives_0_1_0 ) ) ;
    public final void rule__SqlNativeBlock__DbTypeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10281:1: ( ( ( rule__SqlNativeBlock__DbTypeAlternatives_0_1_0 ) ) )
            // InternalMetaDsl.g:10282:2: ( ( rule__SqlNativeBlock__DbTypeAlternatives_0_1_0 ) )
            {
            // InternalMetaDsl.g:10282:2: ( ( rule__SqlNativeBlock__DbTypeAlternatives_0_1_0 ) )
            // InternalMetaDsl.g:10283:3: ( rule__SqlNativeBlock__DbTypeAlternatives_0_1_0 )
            {
             before(grammarAccess.getSqlNativeBlockAccess().getDbTypeAlternatives_0_1_0()); 
            // InternalMetaDsl.g:10284:3: ( rule__SqlNativeBlock__DbTypeAlternatives_0_1_0 )
            // InternalMetaDsl.g:10284:4: rule__SqlNativeBlock__DbTypeAlternatives_0_1_0
            {
            pushFollow(FOLLOW_2);
            rule__SqlNativeBlock__DbTypeAlternatives_0_1_0();

            state._fsp--;


            }

             after(grammarAccess.getSqlNativeBlockAccess().getDbTypeAlternatives_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__DbTypeAssignment_0_1"


    // $ANTLR start "rule__SqlNativeBlock__SqlBlockAssignment_1"
    // InternalMetaDsl.g:10292:1: rule__SqlNativeBlock__SqlBlockAssignment_1 : ( RULE_ML_SQLBLOCK ) ;
    public final void rule__SqlNativeBlock__SqlBlockAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMetaDsl.g:10296:1: ( ( RULE_ML_SQLBLOCK ) )
            // InternalMetaDsl.g:10297:2: ( RULE_ML_SQLBLOCK )
            {
            // InternalMetaDsl.g:10297:2: ( RULE_ML_SQLBLOCK )
            // InternalMetaDsl.g:10298:3: RULE_ML_SQLBLOCK
            {
             before(grammarAccess.getSqlNativeBlockAccess().getSqlBlockML_SQLBLOCKTerminalRuleCall_1_0()); 
            match(input,RULE_ML_SQLBLOCK,FOLLOW_2); 
             after(grammarAccess.getSqlNativeBlockAccess().getSqlBlockML_SQLBLOCKTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SqlNativeBlock__SqlBlockAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000400010000L,0x0000000014004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x01200000021C0002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000E021000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000280000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000100000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000040L,0x0000000000080000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000200L,0x0000000000600000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000202L,0x0000000000600000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x01200000021C0000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00C8000800000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000000200L,0x0000000034600C10L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xEA00000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000200L,0x0000000000600000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0080400200000000L,0x000000000180000FL});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000638000L,0x0000000002000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0001010000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00000002000000F0L,0x0000000008000040L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000800000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x00000022000000F0L,0x0000000008000040L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x00000002000000F2L,0x0000000008000040L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000002000200L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000002000202L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000002001800210L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000212L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000002002000000L,0x0000000000000380L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000002000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000002000000210L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x000000080C000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000002000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x00000003F0000000L});

}