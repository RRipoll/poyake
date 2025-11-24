package com.jsantos.metadata.plugin.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.jsantos.metadata.plugin.services.MetaDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMetaDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NATURAL", "RULE_DOUBLE", "RULE_NEGATIVEINT", "RULE_ML_STRING", "RULE_ML_SQLBLOCK", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'CONFIGURATION'", "'{'", "'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY'", "'NONE'", "'SEQUENCE'", "'IDENTITY'", "'MTCLASSNAME'", "'}'", "'LANG'", "';'", "'CONSTANT'", "'DATATYPE'", "'SQLNATIVETYPE'", "'WITHPRECISSIONANDSCALE'", "'WITHLENGTH'", "'JAVATYPE'", "'SUBTYPEOF'", "'('", "'MAX'", "','", "')'", "'TABLESTEREOTYPE'", "'COLUMNSTEREOTYPE'", "'PATTERN'", "'.'", "'FROMSQLFILE'", "'TABLE'", "'VIEW'", "'SQLQUERY'", "'ENTITY'", "'EXTENDS'", "'STEREOTYPES'", "'SQLFILEDEPENDENCY'", "'START'", "'WITH'", "'INCREMENT'", "'BY'", "'MINVALUE'", "'MAXVALUE'", "'CYCLE'", "'CACHE'", "'UQ'", "'PK'", "'NOTNULL'", "'SAMEAS'", "'FKTO'", "'MULTIREFTO'", "'DEFAULT'", "'TRANSIENT'", "'IDGENERATOR'", "'BYRULE'", "'GUID'", "'APPLICATION'", "'ENUMETADATA'", "'METADATA'", "'FOR'", "'SHORTCODE'", "'NULL'", "'LABELS'", "'SHORTLABEL'", "'LONGLABEL'", "'KEY'", "'ATTRIBUTE'", "'ENUMERATIONITEM'", "'ENULABELS'", "'DOCUMENTATION'", "'QUERYSOURCE'", "'FUNCTION'", "'SQLFILE'", "'SQLNATIVE'", "'ID'", "'FILESTART'", "'FILEEND'", "'DBTYPE'", "'H2'", "'POSTGRESQL'", "'MYSQL'", "'SQLSERVER'", "'ORACLE'"
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


        public InternalMetaDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMetaDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMetaDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMetaDsl.g"; }



     	private MetaDslGrammarAccess grammarAccess;

        public InternalMetaDslParser(TokenStream input, MetaDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MetaDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMetaDsl.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMetaDsl.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalMetaDsl.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMetaDsl.g:71:1: ruleModel returns [EObject current=null] : ( ( (lv_entities_0_0= ruleEntity ) )* ( (lv_sequences_1_0= ruleSequence ) )* ( (lv_configuration_2_0= ruleConfiguration ) )? ( (lv_generalLabelSection_3_0= ruleGeneralLabelSection ) )? ( (lv_sqlNatives_4_0= ruleSqlNative ) )* ( (lv_metadatas_5_0= ruleMetadata ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_entities_0_0 = null;

        EObject lv_sequences_1_0 = null;

        EObject lv_configuration_2_0 = null;

        EObject lv_generalLabelSection_3_0 = null;

        EObject lv_sqlNatives_4_0 = null;

        EObject lv_metadatas_5_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:77:2: ( ( ( (lv_entities_0_0= ruleEntity ) )* ( (lv_sequences_1_0= ruleSequence ) )* ( (lv_configuration_2_0= ruleConfiguration ) )? ( (lv_generalLabelSection_3_0= ruleGeneralLabelSection ) )? ( (lv_sqlNatives_4_0= ruleSqlNative ) )* ( (lv_metadatas_5_0= ruleMetadata ) )* ) )
            // InternalMetaDsl.g:78:2: ( ( (lv_entities_0_0= ruleEntity ) )* ( (lv_sequences_1_0= ruleSequence ) )* ( (lv_configuration_2_0= ruleConfiguration ) )? ( (lv_generalLabelSection_3_0= ruleGeneralLabelSection ) )? ( (lv_sqlNatives_4_0= ruleSqlNative ) )* ( (lv_metadatas_5_0= ruleMetadata ) )* )
            {
            // InternalMetaDsl.g:78:2: ( ( (lv_entities_0_0= ruleEntity ) )* ( (lv_sequences_1_0= ruleSequence ) )* ( (lv_configuration_2_0= ruleConfiguration ) )? ( (lv_generalLabelSection_3_0= ruleGeneralLabelSection ) )? ( (lv_sqlNatives_4_0= ruleSqlNative ) )* ( (lv_metadatas_5_0= ruleMetadata ) )* )
            // InternalMetaDsl.g:79:3: ( (lv_entities_0_0= ruleEntity ) )* ( (lv_sequences_1_0= ruleSequence ) )* ( (lv_configuration_2_0= ruleConfiguration ) )? ( (lv_generalLabelSection_3_0= ruleGeneralLabelSection ) )? ( (lv_sqlNatives_4_0= ruleSqlNative ) )* ( (lv_metadatas_5_0= ruleMetadata ) )*
            {
            // InternalMetaDsl.g:79:3: ( (lv_entities_0_0= ruleEntity ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=40 && LA1_0<=44)||LA1_0==47) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMetaDsl.g:80:4: (lv_entities_0_0= ruleEntity )
            	    {
            	    // InternalMetaDsl.g:80:4: (lv_entities_0_0= ruleEntity )
            	    // InternalMetaDsl.g:81:5: lv_entities_0_0= ruleEntity
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getEntitiesEntityParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_entities_0_0=ruleEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"entities",
            	    						lv_entities_0_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Entity");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalMetaDsl.g:98:3: ( (lv_sequences_1_0= ruleSequence ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMetaDsl.g:99:4: (lv_sequences_1_0= ruleSequence )
            	    {
            	    // InternalMetaDsl.g:99:4: (lv_sequences_1_0= ruleSequence )
            	    // InternalMetaDsl.g:100:5: lv_sequences_1_0= ruleSequence
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getSequencesSequenceParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_sequences_1_0=ruleSequence();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sequences",
            	    						lv_sequences_1_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Sequence");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalMetaDsl.g:117:3: ( (lv_configuration_2_0= ruleConfiguration ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalMetaDsl.g:118:4: (lv_configuration_2_0= ruleConfiguration )
                    {
                    // InternalMetaDsl.g:118:4: (lv_configuration_2_0= ruleConfiguration )
                    // InternalMetaDsl.g:119:5: lv_configuration_2_0= ruleConfiguration
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getConfigurationConfigurationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_5);
                    lv_configuration_2_0=ruleConfiguration();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"configuration",
                    						lv_configuration_2_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.Configuration");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:136:3: ( (lv_generalLabelSection_3_0= ruleGeneralLabelSection ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==73) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMetaDsl.g:137:4: (lv_generalLabelSection_3_0= ruleGeneralLabelSection )
                    {
                    // InternalMetaDsl.g:137:4: (lv_generalLabelSection_3_0= ruleGeneralLabelSection )
                    // InternalMetaDsl.g:138:5: lv_generalLabelSection_3_0= ruleGeneralLabelSection
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getGeneralLabelSectionGeneralLabelSectionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_6);
                    lv_generalLabelSection_3_0=ruleGeneralLabelSection();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"generalLabelSection",
                    						lv_generalLabelSection_3_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.GeneralLabelSection");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:155:3: ( (lv_sqlNatives_4_0= ruleSqlNative ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==84) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMetaDsl.g:156:4: (lv_sqlNatives_4_0= ruleSqlNative )
            	    {
            	    // InternalMetaDsl.g:156:4: (lv_sqlNatives_4_0= ruleSqlNative )
            	    // InternalMetaDsl.g:157:5: lv_sqlNatives_4_0= ruleSqlNative
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getSqlNativesSqlNativeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_sqlNatives_4_0=ruleSqlNative();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sqlNatives",
            	    						lv_sqlNatives_4_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.SqlNative");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalMetaDsl.g:174:3: ( (lv_metadatas_5_0= ruleMetadata ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==69) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMetaDsl.g:175:4: (lv_metadatas_5_0= ruleMetadata )
            	    {
            	    // InternalMetaDsl.g:175:4: (lv_metadatas_5_0= ruleMetadata )
            	    // InternalMetaDsl.g:176:5: lv_metadatas_5_0= ruleMetadata
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getMetadatasMetadataParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_metadatas_5_0=ruleMetadata();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"metadatas",
            	    						lv_metadatas_5_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Metadata");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleConfiguration"
    // InternalMetaDsl.g:197:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // InternalMetaDsl.g:197:54: (iv_ruleConfiguration= ruleConfiguration EOF )
            // InternalMetaDsl.g:198:2: iv_ruleConfiguration= ruleConfiguration EOF
            {
             newCompositeNode(grammarAccess.getConfigurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfiguration=ruleConfiguration();

            state._fsp--;

             current =iv_ruleConfiguration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // InternalMetaDsl.g:204:1: ruleConfiguration returns [EObject current=null] : (otherlv_0= 'CONFIGURATION' otherlv_1= '{' ( (lv_languages_2_0= ruleLanguage ) )+ ( (lv_dataTypes_3_0= ruleDataType ) )+ ( (lv_constants_4_0= ruleConstant ) )* ( (lv_tableStereotypes_5_0= ruleTableStereotype ) )* ( (lv_columnStereotypes_6_0= ruleColumnStereotype ) )* ( (lv_patterns_7_0= rulePattern ) )* otherlv_8= 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' ( ( (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' ) ) ) (otherlv_10= 'MTCLASSNAME' ( (lv_mtClassName_11_0= RULE_ID ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_8=null;
        Token lv_defaultPkGenerationStrategy_9_1=null;
        Token lv_defaultPkGenerationStrategy_9_2=null;
        Token lv_defaultPkGenerationStrategy_9_3=null;
        Token otherlv_10=null;
        Token lv_mtClassName_11_0=null;
        Token otherlv_12=null;
        EObject lv_languages_2_0 = null;

        EObject lv_dataTypes_3_0 = null;

        EObject lv_constants_4_0 = null;

        EObject lv_tableStereotypes_5_0 = null;

        EObject lv_columnStereotypes_6_0 = null;

        EObject lv_patterns_7_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:210:2: ( (otherlv_0= 'CONFIGURATION' otherlv_1= '{' ( (lv_languages_2_0= ruleLanguage ) )+ ( (lv_dataTypes_3_0= ruleDataType ) )+ ( (lv_constants_4_0= ruleConstant ) )* ( (lv_tableStereotypes_5_0= ruleTableStereotype ) )* ( (lv_columnStereotypes_6_0= ruleColumnStereotype ) )* ( (lv_patterns_7_0= rulePattern ) )* otherlv_8= 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' ( ( (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' ) ) ) (otherlv_10= 'MTCLASSNAME' ( (lv_mtClassName_11_0= RULE_ID ) ) )? otherlv_12= '}' ) )
            // InternalMetaDsl.g:211:2: (otherlv_0= 'CONFIGURATION' otherlv_1= '{' ( (lv_languages_2_0= ruleLanguage ) )+ ( (lv_dataTypes_3_0= ruleDataType ) )+ ( (lv_constants_4_0= ruleConstant ) )* ( (lv_tableStereotypes_5_0= ruleTableStereotype ) )* ( (lv_columnStereotypes_6_0= ruleColumnStereotype ) )* ( (lv_patterns_7_0= rulePattern ) )* otherlv_8= 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' ( ( (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' ) ) ) (otherlv_10= 'MTCLASSNAME' ( (lv_mtClassName_11_0= RULE_ID ) ) )? otherlv_12= '}' )
            {
            // InternalMetaDsl.g:211:2: (otherlv_0= 'CONFIGURATION' otherlv_1= '{' ( (lv_languages_2_0= ruleLanguage ) )+ ( (lv_dataTypes_3_0= ruleDataType ) )+ ( (lv_constants_4_0= ruleConstant ) )* ( (lv_tableStereotypes_5_0= ruleTableStereotype ) )* ( (lv_columnStereotypes_6_0= ruleColumnStereotype ) )* ( (lv_patterns_7_0= rulePattern ) )* otherlv_8= 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' ( ( (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' ) ) ) (otherlv_10= 'MTCLASSNAME' ( (lv_mtClassName_11_0= RULE_ID ) ) )? otherlv_12= '}' )
            // InternalMetaDsl.g:212:3: otherlv_0= 'CONFIGURATION' otherlv_1= '{' ( (lv_languages_2_0= ruleLanguage ) )+ ( (lv_dataTypes_3_0= ruleDataType ) )+ ( (lv_constants_4_0= ruleConstant ) )* ( (lv_tableStereotypes_5_0= ruleTableStereotype ) )* ( (lv_columnStereotypes_6_0= ruleColumnStereotype ) )* ( (lv_patterns_7_0= rulePattern ) )* otherlv_8= 'DEFAULT_PRIMARY_KEY_GENERATION_STRATEGY' ( ( (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' ) ) ) (otherlv_10= 'MTCLASSNAME' ( (lv_mtClassName_11_0= RULE_ID ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getConfigurationAccess().getCONFIGURATIONKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMetaDsl.g:220:3: ( (lv_languages_2_0= ruleLanguage ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMetaDsl.g:221:4: (lv_languages_2_0= ruleLanguage )
            	    {
            	    // InternalMetaDsl.g:221:4: (lv_languages_2_0= ruleLanguage )
            	    // InternalMetaDsl.g:222:5: lv_languages_2_0= ruleLanguage
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationAccess().getLanguagesLanguageParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_languages_2_0=ruleLanguage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"languages",
            	    						lv_languages_2_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Language");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


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

            // InternalMetaDsl.g:239:3: ( (lv_dataTypes_3_0= ruleDataType ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==26) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMetaDsl.g:240:4: (lv_dataTypes_3_0= ruleDataType )
            	    {
            	    // InternalMetaDsl.g:240:4: (lv_dataTypes_3_0= ruleDataType )
            	    // InternalMetaDsl.g:241:5: lv_dataTypes_3_0= ruleDataType
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationAccess().getDataTypesDataTypeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_dataTypes_3_0=ruleDataType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"dataTypes",
            	    						lv_dataTypes_3_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.DataType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // InternalMetaDsl.g:258:3: ( (lv_constants_4_0= ruleConstant ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMetaDsl.g:259:4: (lv_constants_4_0= ruleConstant )
            	    {
            	    // InternalMetaDsl.g:259:4: (lv_constants_4_0= ruleConstant )
            	    // InternalMetaDsl.g:260:5: lv_constants_4_0= ruleConstant
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationAccess().getConstantsConstantParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_constants_4_0=ruleConstant();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constants",
            	    						lv_constants_4_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Constant");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalMetaDsl.g:277:3: ( (lv_tableStereotypes_5_0= ruleTableStereotype ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==36) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMetaDsl.g:278:4: (lv_tableStereotypes_5_0= ruleTableStereotype )
            	    {
            	    // InternalMetaDsl.g:278:4: (lv_tableStereotypes_5_0= ruleTableStereotype )
            	    // InternalMetaDsl.g:279:5: lv_tableStereotypes_5_0= ruleTableStereotype
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationAccess().getTableStereotypesTableStereotypeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_tableStereotypes_5_0=ruleTableStereotype();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tableStereotypes",
            	    						lv_tableStereotypes_5_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.TableStereotype");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalMetaDsl.g:296:3: ( (lv_columnStereotypes_6_0= ruleColumnStereotype ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==37) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMetaDsl.g:297:4: (lv_columnStereotypes_6_0= ruleColumnStereotype )
            	    {
            	    // InternalMetaDsl.g:297:4: (lv_columnStereotypes_6_0= ruleColumnStereotype )
            	    // InternalMetaDsl.g:298:5: lv_columnStereotypes_6_0= ruleColumnStereotype
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationAccess().getColumnStereotypesColumnStereotypeParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_columnStereotypes_6_0=ruleColumnStereotype();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"columnStereotypes",
            	    						lv_columnStereotypes_6_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.ColumnStereotype");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalMetaDsl.g:315:3: ( (lv_patterns_7_0= rulePattern ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==38) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMetaDsl.g:316:4: (lv_patterns_7_0= rulePattern )
            	    {
            	    // InternalMetaDsl.g:316:4: (lv_patterns_7_0= rulePattern )
            	    // InternalMetaDsl.g:317:5: lv_patterns_7_0= rulePattern
            	    {

            	    					newCompositeNode(grammarAccess.getConfigurationAccess().getPatternsPatternParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_patterns_7_0=rulePattern();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"patterns",
            	    						lv_patterns_7_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Pattern");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_16); 

            			newLeafNode(otherlv_8, grammarAccess.getConfigurationAccess().getDEFAULT_PRIMARY_KEY_GENERATION_STRATEGYKeyword_8());
            		
            // InternalMetaDsl.g:338:3: ( ( (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' ) ) )
            // InternalMetaDsl.g:339:4: ( (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' ) )
            {
            // InternalMetaDsl.g:339:4: ( (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' ) )
            // InternalMetaDsl.g:340:5: (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' )
            {
            // InternalMetaDsl.g:340:5: (lv_defaultPkGenerationStrategy_9_1= 'NONE' | lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE' | lv_defaultPkGenerationStrategy_9_3= 'IDENTITY' )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt13=1;
                }
                break;
            case 19:
                {
                alt13=2;
                }
                break;
            case 20:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalMetaDsl.g:341:6: lv_defaultPkGenerationStrategy_9_1= 'NONE'
                    {
                    lv_defaultPkGenerationStrategy_9_1=(Token)match(input,18,FOLLOW_17); 

                    						newLeafNode(lv_defaultPkGenerationStrategy_9_1, grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyNONEKeyword_9_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "defaultPkGenerationStrategy", lv_defaultPkGenerationStrategy_9_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:352:6: lv_defaultPkGenerationStrategy_9_2= 'SEQUENCE'
                    {
                    lv_defaultPkGenerationStrategy_9_2=(Token)match(input,19,FOLLOW_17); 

                    						newLeafNode(lv_defaultPkGenerationStrategy_9_2, grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategySEQUENCEKeyword_9_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "defaultPkGenerationStrategy", lv_defaultPkGenerationStrategy_9_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:363:6: lv_defaultPkGenerationStrategy_9_3= 'IDENTITY'
                    {
                    lv_defaultPkGenerationStrategy_9_3=(Token)match(input,20,FOLLOW_17); 

                    						newLeafNode(lv_defaultPkGenerationStrategy_9_3, grammarAccess.getConfigurationAccess().getDefaultPkGenerationStrategyIDENTITYKeyword_9_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConfigurationRule());
                    						}
                    						setWithLastConsumed(current, "defaultPkGenerationStrategy", lv_defaultPkGenerationStrategy_9_3, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalMetaDsl.g:376:3: (otherlv_10= 'MTCLASSNAME' ( (lv_mtClassName_11_0= RULE_ID ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMetaDsl.g:377:4: otherlv_10= 'MTCLASSNAME' ( (lv_mtClassName_11_0= RULE_ID ) )
                    {
                    otherlv_10=(Token)match(input,21,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getConfigurationAccess().getMTCLASSNAMEKeyword_10_0());
                    			
                    // InternalMetaDsl.g:381:4: ( (lv_mtClassName_11_0= RULE_ID ) )
                    // InternalMetaDsl.g:382:5: (lv_mtClassName_11_0= RULE_ID )
                    {
                    // InternalMetaDsl.g:382:5: (lv_mtClassName_11_0= RULE_ID )
                    // InternalMetaDsl.g:383:6: lv_mtClassName_11_0= RULE_ID
                    {
                    lv_mtClassName_11_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    						newLeafNode(lv_mtClassName_11_0, grammarAccess.getConfigurationAccess().getMtClassNameIDTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConfigurationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"mtClassName",
                    							lv_mtClassName_11_0,
                    							"com.jsantos.metadata.plugin.MetaDsl.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getConfigurationAccess().getRightCurlyBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleLanguage"
    // InternalMetaDsl.g:408:1: entryRuleLanguage returns [EObject current=null] : iv_ruleLanguage= ruleLanguage EOF ;
    public final EObject entryRuleLanguage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguage = null;


        try {
            // InternalMetaDsl.g:408:49: (iv_ruleLanguage= ruleLanguage EOF )
            // InternalMetaDsl.g:409:2: iv_ruleLanguage= ruleLanguage EOF
            {
             newCompositeNode(grammarAccess.getLanguageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLanguage=ruleLanguage();

            state._fsp--;

             current =iv_ruleLanguage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLanguage"


    // $ANTLR start "ruleLanguage"
    // InternalMetaDsl.g:415:1: ruleLanguage returns [EObject current=null] : (otherlv_0= 'LANG' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleLanguage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:421:2: ( (otherlv_0= 'LANG' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalMetaDsl.g:422:2: (otherlv_0= 'LANG' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalMetaDsl.g:422:2: (otherlv_0= 'LANG' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalMetaDsl.g:423:3: otherlv_0= 'LANG' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getLanguageAccess().getLANGKeyword_0());
            		
            // InternalMetaDsl.g:427:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMetaDsl.g:428:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMetaDsl.g:428:4: (lv_name_1_0= RULE_ID )
            // InternalMetaDsl.g:429:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLanguageAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLanguageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getLanguageAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLanguage"


    // $ANTLR start "entryRuleConstant"
    // InternalMetaDsl.g:453:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalMetaDsl.g:453:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalMetaDsl.g:454:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalMetaDsl.g:460:1: ruleConstant returns [EObject current=null] : (otherlv_0= 'CONSTANT' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:466:2: ( (otherlv_0= 'CONSTANT' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalMetaDsl.g:467:2: (otherlv_0= 'CONSTANT' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalMetaDsl.g:467:2: (otherlv_0= 'CONSTANT' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalMetaDsl.g:468:3: otherlv_0= 'CONSTANT' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getConstantAccess().getCONSTANTKeyword_0());
            		
            // InternalMetaDsl.g:472:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMetaDsl.g:473:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMetaDsl.g:473:4: (lv_name_1_0= RULE_ID )
            // InternalMetaDsl.g:474:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConstantAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            // InternalMetaDsl.g:490:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalMetaDsl.g:491:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalMetaDsl.g:491:4: (lv_value_2_0= RULE_STRING )
            // InternalMetaDsl.g:492:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"com.jsantos.metadata.plugin.MetaDsl.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleDataType"
    // InternalMetaDsl.g:512:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalMetaDsl.g:512:49: (iv_ruleDataType= ruleDataType EOF )
            // InternalMetaDsl.g:513:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalMetaDsl.g:519:1: ruleDataType returns [EObject current=null] : (otherlv_0= 'DATATYPE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_details_2_0= ruleDataTypeDefinition ) ) otherlv_3= ';' ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_details_2_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:525:2: ( (otherlv_0= 'DATATYPE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_details_2_0= ruleDataTypeDefinition ) ) otherlv_3= ';' ) )
            // InternalMetaDsl.g:526:2: (otherlv_0= 'DATATYPE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_details_2_0= ruleDataTypeDefinition ) ) otherlv_3= ';' )
            {
            // InternalMetaDsl.g:526:2: (otherlv_0= 'DATATYPE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_details_2_0= ruleDataTypeDefinition ) ) otherlv_3= ';' )
            // InternalMetaDsl.g:527:3: otherlv_0= 'DATATYPE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_details_2_0= ruleDataTypeDefinition ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getDataTypeAccess().getDATATYPEKeyword_0());
            		
            // InternalMetaDsl.g:531:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMetaDsl.g:532:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMetaDsl.g:532:4: (lv_name_1_0= RULE_ID )
            // InternalMetaDsl.g:533:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            // InternalMetaDsl.g:549:3: ( (lv_details_2_0= ruleDataTypeDefinition ) )
            // InternalMetaDsl.g:550:4: (lv_details_2_0= ruleDataTypeDefinition )
            {
            // InternalMetaDsl.g:550:4: (lv_details_2_0= ruleDataTypeDefinition )
            // InternalMetaDsl.g:551:5: lv_details_2_0= ruleDataTypeDefinition
            {

            					newCompositeNode(grammarAccess.getDataTypeAccess().getDetailsDataTypeDefinitionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_20);
            lv_details_2_0=ruleDataTypeDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataTypeRule());
            					}
            					set(
            						current,
            						"details",
            						lv_details_2_0,
            						"com.jsantos.metadata.plugin.MetaDsl.DataTypeDefinition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getDataTypeAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleDataTypeDefinition"
    // InternalMetaDsl.g:576:1: entryRuleDataTypeDefinition returns [EObject current=null] : iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF ;
    public final EObject entryRuleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinition = null;


        try {
            // InternalMetaDsl.g:576:59: (iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF )
            // InternalMetaDsl.g:577:2: iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF
            {
             newCompositeNode(grammarAccess.getDataTypeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeDefinition=ruleDataTypeDefinition();

            state._fsp--;

             current =iv_ruleDataTypeDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTypeDefinition"


    // $ANTLR start "ruleDataTypeDefinition"
    // InternalMetaDsl.g:583:1: ruleDataTypeDefinition returns [EObject current=null] : (this_DataTypeDetails_0= ruleDataTypeDetails | this_SubTypeDataType_1= ruleSubTypeDataType ) ;
    public final EObject ruleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeDetails_0 = null;

        EObject this_SubTypeDataType_1 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:589:2: ( (this_DataTypeDetails_0= ruleDataTypeDetails | this_SubTypeDataType_1= ruleSubTypeDataType ) )
            // InternalMetaDsl.g:590:2: (this_DataTypeDetails_0= ruleDataTypeDetails | this_SubTypeDataType_1= ruleSubTypeDataType )
            {
            // InternalMetaDsl.g:590:2: (this_DataTypeDetails_0= ruleDataTypeDetails | this_SubTypeDataType_1= ruleSubTypeDataType )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            else if ( (LA15_0==31) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalMetaDsl.g:591:3: this_DataTypeDetails_0= ruleDataTypeDetails
                    {

                    			newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getDataTypeDetailsParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataTypeDetails_0=ruleDataTypeDetails();

                    state._fsp--;


                    			current = this_DataTypeDetails_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:600:3: this_SubTypeDataType_1= ruleSubTypeDataType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getSubTypeDataTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubTypeDataType_1=ruleSubTypeDataType();

                    state._fsp--;


                    			current = this_SubTypeDataType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTypeDefinition"


    // $ANTLR start "entryRuleDataTypeDetails"
    // InternalMetaDsl.g:612:1: entryRuleDataTypeDetails returns [EObject current=null] : iv_ruleDataTypeDetails= ruleDataTypeDetails EOF ;
    public final EObject entryRuleDataTypeDetails() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDetails = null;


        try {
            // InternalMetaDsl.g:612:56: (iv_ruleDataTypeDetails= ruleDataTypeDetails EOF )
            // InternalMetaDsl.g:613:2: iv_ruleDataTypeDetails= ruleDataTypeDetails EOF
            {
             newCompositeNode(grammarAccess.getDataTypeDetailsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeDetails=ruleDataTypeDetails();

            state._fsp--;

             current =iv_ruleDataTypeDetails; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTypeDetails"


    // $ANTLR start "ruleDataTypeDetails"
    // InternalMetaDsl.g:619:1: ruleDataTypeDetails returns [EObject current=null] : (otherlv_0= 'SQLNATIVETYPE' ( (lv_dbNativeType_1_0= RULE_ID ) ) ( ( (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' ) ) | ( (lv_withLength_3_0= 'WITHLENGTH' ) ) )? otherlv_4= 'JAVATYPE' ( (lv_javaType_5_0= ruleFQN ) ) ) ;
    public final EObject ruleDataTypeDetails() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_dbNativeType_1_0=null;
        Token lv_withPrecissionAndScale_2_0=null;
        Token lv_withLength_3_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_javaType_5_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:625:2: ( (otherlv_0= 'SQLNATIVETYPE' ( (lv_dbNativeType_1_0= RULE_ID ) ) ( ( (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' ) ) | ( (lv_withLength_3_0= 'WITHLENGTH' ) ) )? otherlv_4= 'JAVATYPE' ( (lv_javaType_5_0= ruleFQN ) ) ) )
            // InternalMetaDsl.g:626:2: (otherlv_0= 'SQLNATIVETYPE' ( (lv_dbNativeType_1_0= RULE_ID ) ) ( ( (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' ) ) | ( (lv_withLength_3_0= 'WITHLENGTH' ) ) )? otherlv_4= 'JAVATYPE' ( (lv_javaType_5_0= ruleFQN ) ) )
            {
            // InternalMetaDsl.g:626:2: (otherlv_0= 'SQLNATIVETYPE' ( (lv_dbNativeType_1_0= RULE_ID ) ) ( ( (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' ) ) | ( (lv_withLength_3_0= 'WITHLENGTH' ) ) )? otherlv_4= 'JAVATYPE' ( (lv_javaType_5_0= ruleFQN ) ) )
            // InternalMetaDsl.g:627:3: otherlv_0= 'SQLNATIVETYPE' ( (lv_dbNativeType_1_0= RULE_ID ) ) ( ( (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' ) ) | ( (lv_withLength_3_0= 'WITHLENGTH' ) ) )? otherlv_4= 'JAVATYPE' ( (lv_javaType_5_0= ruleFQN ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getDataTypeDetailsAccess().getSQLNATIVETYPEKeyword_0());
            		
            // InternalMetaDsl.g:631:3: ( (lv_dbNativeType_1_0= RULE_ID ) )
            // InternalMetaDsl.g:632:4: (lv_dbNativeType_1_0= RULE_ID )
            {
            // InternalMetaDsl.g:632:4: (lv_dbNativeType_1_0= RULE_ID )
            // InternalMetaDsl.g:633:5: lv_dbNativeType_1_0= RULE_ID
            {
            lv_dbNativeType_1_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_dbNativeType_1_0, grammarAccess.getDataTypeDetailsAccess().getDbNativeTypeIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataTypeDetailsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"dbNativeType",
            						lv_dbNativeType_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            // InternalMetaDsl.g:649:3: ( ( (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' ) ) | ( (lv_withLength_3_0= 'WITHLENGTH' ) ) )?
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            else if ( (LA16_0==29) ) {
                alt16=2;
            }
            switch (alt16) {
                case 1 :
                    // InternalMetaDsl.g:650:4: ( (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' ) )
                    {
                    // InternalMetaDsl.g:650:4: ( (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' ) )
                    // InternalMetaDsl.g:651:5: (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' )
                    {
                    // InternalMetaDsl.g:651:5: (lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE' )
                    // InternalMetaDsl.g:652:6: lv_withPrecissionAndScale_2_0= 'WITHPRECISSIONANDSCALE'
                    {
                    lv_withPrecissionAndScale_2_0=(Token)match(input,28,FOLLOW_24); 

                    						newLeafNode(lv_withPrecissionAndScale_2_0, grammarAccess.getDataTypeDetailsAccess().getWithPrecissionAndScaleWITHPRECISSIONANDSCALEKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataTypeDetailsRule());
                    						}
                    						setWithLastConsumed(current, "withPrecissionAndScale", true, "WITHPRECISSIONANDSCALE");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:665:4: ( (lv_withLength_3_0= 'WITHLENGTH' ) )
                    {
                    // InternalMetaDsl.g:665:4: ( (lv_withLength_3_0= 'WITHLENGTH' ) )
                    // InternalMetaDsl.g:666:5: (lv_withLength_3_0= 'WITHLENGTH' )
                    {
                    // InternalMetaDsl.g:666:5: (lv_withLength_3_0= 'WITHLENGTH' )
                    // InternalMetaDsl.g:667:6: lv_withLength_3_0= 'WITHLENGTH'
                    {
                    lv_withLength_3_0=(Token)match(input,29,FOLLOW_24); 

                    						newLeafNode(lv_withLength_3_0, grammarAccess.getDataTypeDetailsAccess().getWithLengthWITHLENGTHKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataTypeDetailsRule());
                    						}
                    						setWithLastConsumed(current, "withLength", true, "WITHLENGTH");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,30,FOLLOW_18); 

            			newLeafNode(otherlv_4, grammarAccess.getDataTypeDetailsAccess().getJAVATYPEKeyword_3());
            		
            // InternalMetaDsl.g:684:3: ( (lv_javaType_5_0= ruleFQN ) )
            // InternalMetaDsl.g:685:4: (lv_javaType_5_0= ruleFQN )
            {
            // InternalMetaDsl.g:685:4: (lv_javaType_5_0= ruleFQN )
            // InternalMetaDsl.g:686:5: lv_javaType_5_0= ruleFQN
            {

            					newCompositeNode(grammarAccess.getDataTypeDetailsAccess().getJavaTypeFQNParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_javaType_5_0=ruleFQN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataTypeDetailsRule());
            					}
            					set(
            						current,
            						"javaType",
            						lv_javaType_5_0,
            						"com.jsantos.metadata.plugin.MetaDsl.FQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTypeDetails"


    // $ANTLR start "entryRuleSubTypeDataType"
    // InternalMetaDsl.g:707:1: entryRuleSubTypeDataType returns [EObject current=null] : iv_ruleSubTypeDataType= ruleSubTypeDataType EOF ;
    public final EObject entryRuleSubTypeDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubTypeDataType = null;


        try {
            // InternalMetaDsl.g:707:56: (iv_ruleSubTypeDataType= ruleSubTypeDataType EOF )
            // InternalMetaDsl.g:708:2: iv_ruleSubTypeDataType= ruleSubTypeDataType EOF
            {
             newCompositeNode(grammarAccess.getSubTypeDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubTypeDataType=ruleSubTypeDataType();

            state._fsp--;

             current =iv_ruleSubTypeDataType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubTypeDataType"


    // $ANTLR start "ruleSubTypeDataType"
    // InternalMetaDsl.g:714:1: ruleSubTypeDataType returns [EObject current=null] : (otherlv_0= 'SUBTYPEOF' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_length_3_0= RULE_NATURAL ) ) | ( (lv_maxlength_4_0= 'MAX' ) ) ) (otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) ) )? otherlv_7= ')' )? ) ;
    public final EObject ruleSubTypeDataType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_length_3_0=null;
        Token lv_maxlength_4_0=null;
        Token otherlv_5=null;
        Token lv_scale_6_0=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:720:2: ( (otherlv_0= 'SUBTYPEOF' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_length_3_0= RULE_NATURAL ) ) | ( (lv_maxlength_4_0= 'MAX' ) ) ) (otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) ) )? otherlv_7= ')' )? ) )
            // InternalMetaDsl.g:721:2: (otherlv_0= 'SUBTYPEOF' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_length_3_0= RULE_NATURAL ) ) | ( (lv_maxlength_4_0= 'MAX' ) ) ) (otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) ) )? otherlv_7= ')' )? )
            {
            // InternalMetaDsl.g:721:2: (otherlv_0= 'SUBTYPEOF' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_length_3_0= RULE_NATURAL ) ) | ( (lv_maxlength_4_0= 'MAX' ) ) ) (otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) ) )? otherlv_7= ')' )? )
            // InternalMetaDsl.g:722:3: otherlv_0= 'SUBTYPEOF' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_length_3_0= RULE_NATURAL ) ) | ( (lv_maxlength_4_0= 'MAX' ) ) ) (otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) ) )? otherlv_7= ')' )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getSubTypeDataTypeAccess().getSUBTYPEOFKeyword_0());
            		
            // InternalMetaDsl.g:726:3: ( (otherlv_1= RULE_ID ) )
            // InternalMetaDsl.g:727:4: (otherlv_1= RULE_ID )
            {
            // InternalMetaDsl.g:727:4: (otherlv_1= RULE_ID )
            // InternalMetaDsl.g:728:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubTypeDataTypeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_1, grammarAccess.getSubTypeDataTypeAccess().getSubTypeOfDataTypeCrossReference_1_0());
            				

            }


            }

            // InternalMetaDsl.g:739:3: (otherlv_2= '(' ( ( (lv_length_3_0= RULE_NATURAL ) ) | ( (lv_maxlength_4_0= 'MAX' ) ) ) (otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) ) )? otherlv_7= ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMetaDsl.g:740:4: otherlv_2= '(' ( ( (lv_length_3_0= RULE_NATURAL ) ) | ( (lv_maxlength_4_0= 'MAX' ) ) ) (otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) ) )? otherlv_7= ')'
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_26); 

                    				newLeafNode(otherlv_2, grammarAccess.getSubTypeDataTypeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalMetaDsl.g:744:4: ( ( (lv_length_3_0= RULE_NATURAL ) ) | ( (lv_maxlength_4_0= 'MAX' ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_NATURAL) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==33) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalMetaDsl.g:745:5: ( (lv_length_3_0= RULE_NATURAL ) )
                            {
                            // InternalMetaDsl.g:745:5: ( (lv_length_3_0= RULE_NATURAL ) )
                            // InternalMetaDsl.g:746:6: (lv_length_3_0= RULE_NATURAL )
                            {
                            // InternalMetaDsl.g:746:6: (lv_length_3_0= RULE_NATURAL )
                            // InternalMetaDsl.g:747:7: lv_length_3_0= RULE_NATURAL
                            {
                            lv_length_3_0=(Token)match(input,RULE_NATURAL,FOLLOW_27); 

                            							newLeafNode(lv_length_3_0, grammarAccess.getSubTypeDataTypeAccess().getLengthNATURALTerminalRuleCall_2_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSubTypeDataTypeRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"length",
                            								lv_length_3_0,
                            								"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:764:5: ( (lv_maxlength_4_0= 'MAX' ) )
                            {
                            // InternalMetaDsl.g:764:5: ( (lv_maxlength_4_0= 'MAX' ) )
                            // InternalMetaDsl.g:765:6: (lv_maxlength_4_0= 'MAX' )
                            {
                            // InternalMetaDsl.g:765:6: (lv_maxlength_4_0= 'MAX' )
                            // InternalMetaDsl.g:766:7: lv_maxlength_4_0= 'MAX'
                            {
                            lv_maxlength_4_0=(Token)match(input,33,FOLLOW_27); 

                            							newLeafNode(lv_maxlength_4_0, grammarAccess.getSubTypeDataTypeAccess().getMaxlengthMAXKeyword_2_1_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSubTypeDataTypeRule());
                            							}
                            							setWithLastConsumed(current, "maxlength", true, "MAX");
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMetaDsl.g:779:4: (otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==34) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalMetaDsl.g:780:5: otherlv_5= ',' ( (lv_scale_6_0= RULE_NATURAL ) )
                            {
                            otherlv_5=(Token)match(input,34,FOLLOW_28); 

                            					newLeafNode(otherlv_5, grammarAccess.getSubTypeDataTypeAccess().getCommaKeyword_2_2_0());
                            				
                            // InternalMetaDsl.g:784:5: ( (lv_scale_6_0= RULE_NATURAL ) )
                            // InternalMetaDsl.g:785:6: (lv_scale_6_0= RULE_NATURAL )
                            {
                            // InternalMetaDsl.g:785:6: (lv_scale_6_0= RULE_NATURAL )
                            // InternalMetaDsl.g:786:7: lv_scale_6_0= RULE_NATURAL
                            {
                            lv_scale_6_0=(Token)match(input,RULE_NATURAL,FOLLOW_29); 

                            							newLeafNode(lv_scale_6_0, grammarAccess.getSubTypeDataTypeAccess().getScaleNATURALTerminalRuleCall_2_2_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSubTypeDataTypeRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"scale",
                            								lv_scale_6_0,
                            								"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,35,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getSubTypeDataTypeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubTypeDataType"


    // $ANTLR start "entryRuleTableStereotype"
    // InternalMetaDsl.g:812:1: entryRuleTableStereotype returns [EObject current=null] : iv_ruleTableStereotype= ruleTableStereotype EOF ;
    public final EObject entryRuleTableStereotype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableStereotype = null;


        try {
            // InternalMetaDsl.g:812:56: (iv_ruleTableStereotype= ruleTableStereotype EOF )
            // InternalMetaDsl.g:813:2: iv_ruleTableStereotype= ruleTableStereotype EOF
            {
             newCompositeNode(grammarAccess.getTableStereotypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTableStereotype=ruleTableStereotype();

            state._fsp--;

             current =iv_ruleTableStereotype; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTableStereotype"


    // $ANTLR start "ruleTableStereotype"
    // InternalMetaDsl.g:819:1: ruleTableStereotype returns [EObject current=null] : (otherlv_0= 'TABLESTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleTableStereotype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:825:2: ( (otherlv_0= 'TABLESTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalMetaDsl.g:826:2: (otherlv_0= 'TABLESTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalMetaDsl.g:826:2: (otherlv_0= 'TABLESTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalMetaDsl.g:827:3: otherlv_0= 'TABLESTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getTableStereotypeAccess().getTABLESTEREOTYPEKeyword_0());
            		
            // InternalMetaDsl.g:831:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMetaDsl.g:832:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMetaDsl.g:832:4: (lv_name_1_0= RULE_ID )
            // InternalMetaDsl.g:833:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTableStereotypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTableStereotypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getTableStereotypeAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTableStereotype"


    // $ANTLR start "entryRuleColumnStereotype"
    // InternalMetaDsl.g:857:1: entryRuleColumnStereotype returns [EObject current=null] : iv_ruleColumnStereotype= ruleColumnStereotype EOF ;
    public final EObject entryRuleColumnStereotype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumnStereotype = null;


        try {
            // InternalMetaDsl.g:857:57: (iv_ruleColumnStereotype= ruleColumnStereotype EOF )
            // InternalMetaDsl.g:858:2: iv_ruleColumnStereotype= ruleColumnStereotype EOF
            {
             newCompositeNode(grammarAccess.getColumnStereotypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumnStereotype=ruleColumnStereotype();

            state._fsp--;

             current =iv_ruleColumnStereotype; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColumnStereotype"


    // $ANTLR start "ruleColumnStereotype"
    // InternalMetaDsl.g:864:1: ruleColumnStereotype returns [EObject current=null] : (otherlv_0= 'COLUMNSTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleColumnStereotype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:870:2: ( (otherlv_0= 'COLUMNSTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalMetaDsl.g:871:2: (otherlv_0= 'COLUMNSTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalMetaDsl.g:871:2: (otherlv_0= 'COLUMNSTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalMetaDsl.g:872:3: otherlv_0= 'COLUMNSTEREOTYPE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getColumnStereotypeAccess().getCOLUMNSTEREOTYPEKeyword_0());
            		
            // InternalMetaDsl.g:876:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMetaDsl.g:877:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMetaDsl.g:877:4: (lv_name_1_0= RULE_ID )
            // InternalMetaDsl.g:878:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_1_0, grammarAccess.getColumnStereotypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getColumnStereotypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getColumnStereotypeAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColumnStereotype"


    // $ANTLR start "entryRulePattern"
    // InternalMetaDsl.g:902:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalMetaDsl.g:902:48: (iv_rulePattern= rulePattern EOF )
            // InternalMetaDsl.g:903:2: iv_rulePattern= rulePattern EOF
            {
             newCompositeNode(grammarAccess.getPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;

             current =iv_rulePattern; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalMetaDsl.g:909:1: rulePattern returns [EObject current=null] : (otherlv_0= 'PATTERN' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:915:2: ( (otherlv_0= 'PATTERN' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) )
            // InternalMetaDsl.g:916:2: (otherlv_0= 'PATTERN' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            {
            // InternalMetaDsl.g:916:2: (otherlv_0= 'PATTERN' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            // InternalMetaDsl.g:917:3: otherlv_0= 'PATTERN' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getPatternAccess().getPATTERNKeyword_0());
            		
            // InternalMetaDsl.g:921:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMetaDsl.g:922:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMetaDsl.g:922:4: (lv_name_1_0= RULE_ID )
            // InternalMetaDsl.g:923:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPatternAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getPatternAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMetaDsl.g:943:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID||(LA20_0>=56 && LA20_0<=57)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMetaDsl.g:944:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalMetaDsl.g:944:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalMetaDsl.g:945:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getPatternAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_30);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPatternRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPatternAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleFQN"
    // InternalMetaDsl.g:970:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalMetaDsl.g:970:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalMetaDsl.g:971:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalMetaDsl.g:977:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:983:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMetaDsl.g:984:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMetaDsl.g:984:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMetaDsl.g:985:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalMetaDsl.g:992:3: (kw= '.' this_ID_2= RULE_ID )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==39) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMetaDsl.g:993:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,39,FOLLOW_18); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_31); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleEntity"
    // InternalMetaDsl.g:1010:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalMetaDsl.g:1010:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalMetaDsl.g:1011:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalMetaDsl.g:1017:1: ruleEntity returns [EObject current=null] : ( (otherlv_0= 'FROMSQLFILE' ( (lv_fromSQLFile_1_0= RULE_STRING ) ) )? ( (lv_sqlFileDependencies_2_0= ruleSqlFileDependency ) )* ( ( (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' ) ) )? otherlv_4= 'ENTITY' ( (lv_name_5_0= ruleFQN ) ) (otherlv_6= 'EXTENDS' ( ( ruleFQN ) ) )? (otherlv_8= 'PATTERN' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )? )? (otherlv_12= 'STEREOTYPES' ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )? )? otherlv_16= '{' ( (lv_attributes_17_0= ruleAttribute ) )* ( (lv_metadata_18_0= ruleMetadata ) )? ( (lv_enuMetadata_19_0= ruleEnuMetadata ) )? ( (lv_labelSection_20_0= ruleLabelSection ) )? ( (lv_enumerationLabels_21_0= ruleEnumerationLabels ) )? ( (lv_documentationSection_22_0= ruleDocumentationSection ) )? ( (lv_querySourceBlock_23_0= ruleQuerySourceBlock ) )? otherlv_24= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fromSQLFile_1_0=null;
        Token lv_entityType_3_1=null;
        Token lv_entityType_3_2=null;
        Token lv_entityType_3_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_24=null;
        EObject lv_sqlFileDependencies_2_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_attributes_17_0 = null;

        EObject lv_metadata_18_0 = null;

        EObject lv_enuMetadata_19_0 = null;

        EObject lv_labelSection_20_0 = null;

        EObject lv_enumerationLabels_21_0 = null;

        EObject lv_documentationSection_22_0 = null;

        EObject lv_querySourceBlock_23_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:1023:2: ( ( (otherlv_0= 'FROMSQLFILE' ( (lv_fromSQLFile_1_0= RULE_STRING ) ) )? ( (lv_sqlFileDependencies_2_0= ruleSqlFileDependency ) )* ( ( (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' ) ) )? otherlv_4= 'ENTITY' ( (lv_name_5_0= ruleFQN ) ) (otherlv_6= 'EXTENDS' ( ( ruleFQN ) ) )? (otherlv_8= 'PATTERN' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )? )? (otherlv_12= 'STEREOTYPES' ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )? )? otherlv_16= '{' ( (lv_attributes_17_0= ruleAttribute ) )* ( (lv_metadata_18_0= ruleMetadata ) )? ( (lv_enuMetadata_19_0= ruleEnuMetadata ) )? ( (lv_labelSection_20_0= ruleLabelSection ) )? ( (lv_enumerationLabels_21_0= ruleEnumerationLabels ) )? ( (lv_documentationSection_22_0= ruleDocumentationSection ) )? ( (lv_querySourceBlock_23_0= ruleQuerySourceBlock ) )? otherlv_24= '}' ) )
            // InternalMetaDsl.g:1024:2: ( (otherlv_0= 'FROMSQLFILE' ( (lv_fromSQLFile_1_0= RULE_STRING ) ) )? ( (lv_sqlFileDependencies_2_0= ruleSqlFileDependency ) )* ( ( (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' ) ) )? otherlv_4= 'ENTITY' ( (lv_name_5_0= ruleFQN ) ) (otherlv_6= 'EXTENDS' ( ( ruleFQN ) ) )? (otherlv_8= 'PATTERN' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )? )? (otherlv_12= 'STEREOTYPES' ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )? )? otherlv_16= '{' ( (lv_attributes_17_0= ruleAttribute ) )* ( (lv_metadata_18_0= ruleMetadata ) )? ( (lv_enuMetadata_19_0= ruleEnuMetadata ) )? ( (lv_labelSection_20_0= ruleLabelSection ) )? ( (lv_enumerationLabels_21_0= ruleEnumerationLabels ) )? ( (lv_documentationSection_22_0= ruleDocumentationSection ) )? ( (lv_querySourceBlock_23_0= ruleQuerySourceBlock ) )? otherlv_24= '}' )
            {
            // InternalMetaDsl.g:1024:2: ( (otherlv_0= 'FROMSQLFILE' ( (lv_fromSQLFile_1_0= RULE_STRING ) ) )? ( (lv_sqlFileDependencies_2_0= ruleSqlFileDependency ) )* ( ( (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' ) ) )? otherlv_4= 'ENTITY' ( (lv_name_5_0= ruleFQN ) ) (otherlv_6= 'EXTENDS' ( ( ruleFQN ) ) )? (otherlv_8= 'PATTERN' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )? )? (otherlv_12= 'STEREOTYPES' ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )? )? otherlv_16= '{' ( (lv_attributes_17_0= ruleAttribute ) )* ( (lv_metadata_18_0= ruleMetadata ) )? ( (lv_enuMetadata_19_0= ruleEnuMetadata ) )? ( (lv_labelSection_20_0= ruleLabelSection ) )? ( (lv_enumerationLabels_21_0= ruleEnumerationLabels ) )? ( (lv_documentationSection_22_0= ruleDocumentationSection ) )? ( (lv_querySourceBlock_23_0= ruleQuerySourceBlock ) )? otherlv_24= '}' )
            // InternalMetaDsl.g:1025:3: (otherlv_0= 'FROMSQLFILE' ( (lv_fromSQLFile_1_0= RULE_STRING ) ) )? ( (lv_sqlFileDependencies_2_0= ruleSqlFileDependency ) )* ( ( (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' ) ) )? otherlv_4= 'ENTITY' ( (lv_name_5_0= ruleFQN ) ) (otherlv_6= 'EXTENDS' ( ( ruleFQN ) ) )? (otherlv_8= 'PATTERN' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )? )? (otherlv_12= 'STEREOTYPES' ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )? )? otherlv_16= '{' ( (lv_attributes_17_0= ruleAttribute ) )* ( (lv_metadata_18_0= ruleMetadata ) )? ( (lv_enuMetadata_19_0= ruleEnuMetadata ) )? ( (lv_labelSection_20_0= ruleLabelSection ) )? ( (lv_enumerationLabels_21_0= ruleEnumerationLabels ) )? ( (lv_documentationSection_22_0= ruleDocumentationSection ) )? ( (lv_querySourceBlock_23_0= ruleQuerySourceBlock ) )? otherlv_24= '}'
            {
            // InternalMetaDsl.g:1025:3: (otherlv_0= 'FROMSQLFILE' ( (lv_fromSQLFile_1_0= RULE_STRING ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMetaDsl.g:1026:4: otherlv_0= 'FROMSQLFILE' ( (lv_fromSQLFile_1_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,40,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getFROMSQLFILEKeyword_0_0());
                    			
                    // InternalMetaDsl.g:1030:4: ( (lv_fromSQLFile_1_0= RULE_STRING ) )
                    // InternalMetaDsl.g:1031:5: (lv_fromSQLFile_1_0= RULE_STRING )
                    {
                    // InternalMetaDsl.g:1031:5: (lv_fromSQLFile_1_0= RULE_STRING )
                    // InternalMetaDsl.g:1032:6: lv_fromSQLFile_1_0= RULE_STRING
                    {
                    lv_fromSQLFile_1_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

                    						newLeafNode(lv_fromSQLFile_1_0, grammarAccess.getEntityAccess().getFromSQLFileSTRINGTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEntityRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"fromSQLFile",
                    							lv_fromSQLFile_1_0,
                    							"com.jsantos.metadata.plugin.MetaDsl.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1049:3: ( (lv_sqlFileDependencies_2_0= ruleSqlFileDependency ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==47) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalMetaDsl.g:1050:4: (lv_sqlFileDependencies_2_0= ruleSqlFileDependency )
            	    {
            	    // InternalMetaDsl.g:1050:4: (lv_sqlFileDependencies_2_0= ruleSqlFileDependency )
            	    // InternalMetaDsl.g:1051:5: lv_sqlFileDependencies_2_0= ruleSqlFileDependency
            	    {

            	    					newCompositeNode(grammarAccess.getEntityAccess().getSqlFileDependenciesSqlFileDependencyParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_sqlFileDependencies_2_0=ruleSqlFileDependency();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sqlFileDependencies",
            	    						lv_sqlFileDependencies_2_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.SqlFileDependency");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // InternalMetaDsl.g:1068:3: ( ( (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=41 && LA25_0<=43)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMetaDsl.g:1069:4: ( (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' ) )
                    {
                    // InternalMetaDsl.g:1069:4: ( (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' ) )
                    // InternalMetaDsl.g:1070:5: (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' )
                    {
                    // InternalMetaDsl.g:1070:5: (lv_entityType_3_1= 'TABLE' | lv_entityType_3_2= 'VIEW' | lv_entityType_3_3= 'SQLQUERY' )
                    int alt24=3;
                    switch ( input.LA(1) ) {
                    case 41:
                        {
                        alt24=1;
                        }
                        break;
                    case 42:
                        {
                        alt24=2;
                        }
                        break;
                    case 43:
                        {
                        alt24=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // InternalMetaDsl.g:1071:6: lv_entityType_3_1= 'TABLE'
                            {
                            lv_entityType_3_1=(Token)match(input,41,FOLLOW_33); 

                            						newLeafNode(lv_entityType_3_1, grammarAccess.getEntityAccess().getEntityTypeTABLEKeyword_2_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getEntityRule());
                            						}
                            						setWithLastConsumed(current, "entityType", lv_entityType_3_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:1082:6: lv_entityType_3_2= 'VIEW'
                            {
                            lv_entityType_3_2=(Token)match(input,42,FOLLOW_33); 

                            						newLeafNode(lv_entityType_3_2, grammarAccess.getEntityAccess().getEntityTypeVIEWKeyword_2_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getEntityRule());
                            						}
                            						setWithLastConsumed(current, "entityType", lv_entityType_3_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalMetaDsl.g:1093:6: lv_entityType_3_3= 'SQLQUERY'
                            {
                            lv_entityType_3_3=(Token)match(input,43,FOLLOW_33); 

                            						newLeafNode(lv_entityType_3_3, grammarAccess.getEntityAccess().getEntityTypeSQLQUERYKeyword_2_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getEntityRule());
                            						}
                            						setWithLastConsumed(current, "entityType", lv_entityType_3_3, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,44,FOLLOW_18); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getENTITYKeyword_3());
            		
            // InternalMetaDsl.g:1110:3: ( (lv_name_5_0= ruleFQN ) )
            // InternalMetaDsl.g:1111:4: (lv_name_5_0= ruleFQN )
            {
            // InternalMetaDsl.g:1111:4: (lv_name_5_0= ruleFQN )
            // InternalMetaDsl.g:1112:5: lv_name_5_0= ruleFQN
            {

            					newCompositeNode(grammarAccess.getEntityAccess().getNameFQNParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_34);
            lv_name_5_0=ruleFQN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_5_0,
            						"com.jsantos.metadata.plugin.MetaDsl.FQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMetaDsl.g:1129:3: (otherlv_6= 'EXTENDS' ( ( ruleFQN ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==45) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMetaDsl.g:1130:4: otherlv_6= 'EXTENDS' ( ( ruleFQN ) )
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getEntityAccess().getEXTENDSKeyword_5_0());
                    			
                    // InternalMetaDsl.g:1134:4: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:1135:5: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:1135:5: ( ruleFQN )
                    // InternalMetaDsl.g:1136:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEntityRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_35);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1151:3: (otherlv_8= 'PATTERN' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )? )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==38) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMetaDsl.g:1152:4: otherlv_8= 'PATTERN' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )?
                    {
                    otherlv_8=(Token)match(input,38,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getEntityAccess().getPATTERNKeyword_6_0());
                    			
                    // InternalMetaDsl.g:1156:4: ( (otherlv_9= RULE_ID ) )
                    // InternalMetaDsl.g:1157:5: (otherlv_9= RULE_ID )
                    {
                    // InternalMetaDsl.g:1157:5: (otherlv_9= RULE_ID )
                    // InternalMetaDsl.g:1158:6: otherlv_9= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEntityRule());
                    						}
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_9, grammarAccess.getEntityAccess().getPatternsPatternCrossReference_6_1_0());
                    					

                    }


                    }

                    // InternalMetaDsl.g:1169:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==34) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalMetaDsl.g:1170:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                            {
                            otherlv_10=(Token)match(input,34,FOLLOW_18); 

                            					newLeafNode(otherlv_10, grammarAccess.getEntityAccess().getCommaKeyword_6_2_0());
                            				
                            // InternalMetaDsl.g:1174:5: ( (otherlv_11= RULE_ID ) )
                            // InternalMetaDsl.g:1175:6: (otherlv_11= RULE_ID )
                            {
                            // InternalMetaDsl.g:1175:6: (otherlv_11= RULE_ID )
                            // InternalMetaDsl.g:1176:7: otherlv_11= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getEntityRule());
                            							}
                            						
                            otherlv_11=(Token)match(input,RULE_ID,FOLLOW_37); 

                            							newLeafNode(otherlv_11, grammarAccess.getEntityAccess().getPatternsPatternCrossReference_6_2_1_0());
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1189:3: (otherlv_12= 'STEREOTYPES' ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )? )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==46) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMetaDsl.g:1190:4: otherlv_12= 'STEREOTYPES' ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )?
                    {
                    otherlv_12=(Token)match(input,46,FOLLOW_18); 

                    				newLeafNode(otherlv_12, grammarAccess.getEntityAccess().getSTEREOTYPESKeyword_7_0());
                    			
                    // InternalMetaDsl.g:1194:4: ( (otherlv_13= RULE_ID ) )
                    // InternalMetaDsl.g:1195:5: (otherlv_13= RULE_ID )
                    {
                    // InternalMetaDsl.g:1195:5: (otherlv_13= RULE_ID )
                    // InternalMetaDsl.g:1196:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEntityRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_38); 

                    						newLeafNode(otherlv_13, grammarAccess.getEntityAccess().getStereotypesTableStereotypeCrossReference_7_1_0());
                    					

                    }


                    }

                    // InternalMetaDsl.g:1207:4: (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==34) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalMetaDsl.g:1208:5: otherlv_14= ',' ( (otherlv_15= RULE_ID ) )
                            {
                            otherlv_14=(Token)match(input,34,FOLLOW_18); 

                            					newLeafNode(otherlv_14, grammarAccess.getEntityAccess().getCommaKeyword_7_2_0());
                            				
                            // InternalMetaDsl.g:1212:5: ( (otherlv_15= RULE_ID ) )
                            // InternalMetaDsl.g:1213:6: (otherlv_15= RULE_ID )
                            {
                            // InternalMetaDsl.g:1213:6: (otherlv_15= RULE_ID )
                            // InternalMetaDsl.g:1214:7: otherlv_15= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getEntityRule());
                            							}
                            						
                            otherlv_15=(Token)match(input,RULE_ID,FOLLOW_8); 

                            							newLeafNode(otherlv_15, grammarAccess.getEntityAccess().getStereotypesTableStereotypeCrossReference_7_2_1_0());
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,16,FOLLOW_39); 

            			newLeafNode(otherlv_16, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalMetaDsl.g:1231:3: ( (lv_attributes_17_0= ruleAttribute ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID||(LA31_0>=56 && LA31_0<=57)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMetaDsl.g:1232:4: (lv_attributes_17_0= ruleAttribute )
            	    {
            	    // InternalMetaDsl.g:1232:4: (lv_attributes_17_0= ruleAttribute )
            	    // InternalMetaDsl.g:1233:5: lv_attributes_17_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getEntityAccess().getAttributesAttributeParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_39);
            	    lv_attributes_17_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_17_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            // InternalMetaDsl.g:1250:3: ( (lv_metadata_18_0= ruleMetadata ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==69) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMetaDsl.g:1251:4: (lv_metadata_18_0= ruleMetadata )
                    {
                    // InternalMetaDsl.g:1251:4: (lv_metadata_18_0= ruleMetadata )
                    // InternalMetaDsl.g:1252:5: lv_metadata_18_0= ruleMetadata
                    {

                    					newCompositeNode(grammarAccess.getEntityAccess().getMetadataMetadataParserRuleCall_10_0());
                    				
                    pushFollow(FOLLOW_40);
                    lv_metadata_18_0=ruleMetadata();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEntityRule());
                    					}
                    					set(
                    						current,
                    						"metadata",
                    						lv_metadata_18_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.Metadata");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1269:3: ( (lv_enuMetadata_19_0= ruleEnuMetadata ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==68) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMetaDsl.g:1270:4: (lv_enuMetadata_19_0= ruleEnuMetadata )
                    {
                    // InternalMetaDsl.g:1270:4: (lv_enuMetadata_19_0= ruleEnuMetadata )
                    // InternalMetaDsl.g:1271:5: lv_enuMetadata_19_0= ruleEnuMetadata
                    {

                    					newCompositeNode(grammarAccess.getEntityAccess().getEnuMetadataEnuMetadataParserRuleCall_11_0());
                    				
                    pushFollow(FOLLOW_41);
                    lv_enuMetadata_19_0=ruleEnuMetadata();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEntityRule());
                    					}
                    					set(
                    						current,
                    						"enuMetadata",
                    						lv_enuMetadata_19_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.EnuMetadata");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1288:3: ( (lv_labelSection_20_0= ruleLabelSection ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==73) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMetaDsl.g:1289:4: (lv_labelSection_20_0= ruleLabelSection )
                    {
                    // InternalMetaDsl.g:1289:4: (lv_labelSection_20_0= ruleLabelSection )
                    // InternalMetaDsl.g:1290:5: lv_labelSection_20_0= ruleLabelSection
                    {

                    					newCompositeNode(grammarAccess.getEntityAccess().getLabelSectionLabelSectionParserRuleCall_12_0());
                    				
                    pushFollow(FOLLOW_42);
                    lv_labelSection_20_0=ruleLabelSection();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEntityRule());
                    					}
                    					set(
                    						current,
                    						"labelSection",
                    						lv_labelSection_20_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.LabelSection");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1307:3: ( (lv_enumerationLabels_21_0= ruleEnumerationLabels ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==79) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMetaDsl.g:1308:4: (lv_enumerationLabels_21_0= ruleEnumerationLabels )
                    {
                    // InternalMetaDsl.g:1308:4: (lv_enumerationLabels_21_0= ruleEnumerationLabels )
                    // InternalMetaDsl.g:1309:5: lv_enumerationLabels_21_0= ruleEnumerationLabels
                    {

                    					newCompositeNode(grammarAccess.getEntityAccess().getEnumerationLabelsEnumerationLabelsParserRuleCall_13_0());
                    				
                    pushFollow(FOLLOW_43);
                    lv_enumerationLabels_21_0=ruleEnumerationLabels();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEntityRule());
                    					}
                    					set(
                    						current,
                    						"enumerationLabels",
                    						lv_enumerationLabels_21_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.EnumerationLabels");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1326:3: ( (lv_documentationSection_22_0= ruleDocumentationSection ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==80) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMetaDsl.g:1327:4: (lv_documentationSection_22_0= ruleDocumentationSection )
                    {
                    // InternalMetaDsl.g:1327:4: (lv_documentationSection_22_0= ruleDocumentationSection )
                    // InternalMetaDsl.g:1328:5: lv_documentationSection_22_0= ruleDocumentationSection
                    {

                    					newCompositeNode(grammarAccess.getEntityAccess().getDocumentationSectionDocumentationSectionParserRuleCall_14_0());
                    				
                    pushFollow(FOLLOW_44);
                    lv_documentationSection_22_0=ruleDocumentationSection();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEntityRule());
                    					}
                    					set(
                    						current,
                    						"documentationSection",
                    						lv_documentationSection_22_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.DocumentationSection");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1345:3: ( (lv_querySourceBlock_23_0= ruleQuerySourceBlock ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==81) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMetaDsl.g:1346:4: (lv_querySourceBlock_23_0= ruleQuerySourceBlock )
                    {
                    // InternalMetaDsl.g:1346:4: (lv_querySourceBlock_23_0= ruleQuerySourceBlock )
                    // InternalMetaDsl.g:1347:5: lv_querySourceBlock_23_0= ruleQuerySourceBlock
                    {

                    					newCompositeNode(grammarAccess.getEntityAccess().getQuerySourceBlockQuerySourceBlockParserRuleCall_15_0());
                    				
                    pushFollow(FOLLOW_19);
                    lv_querySourceBlock_23_0=ruleQuerySourceBlock();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEntityRule());
                    					}
                    					set(
                    						current,
                    						"querySourceBlock",
                    						lv_querySourceBlock_23_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.QuerySourceBlock");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_24=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_24, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_16());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleSqlFileDependency"
    // InternalMetaDsl.g:1372:1: entryRuleSqlFileDependency returns [EObject current=null] : iv_ruleSqlFileDependency= ruleSqlFileDependency EOF ;
    public final EObject entryRuleSqlFileDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSqlFileDependency = null;


        try {
            // InternalMetaDsl.g:1372:58: (iv_ruleSqlFileDependency= ruleSqlFileDependency EOF )
            // InternalMetaDsl.g:1373:2: iv_ruleSqlFileDependency= ruleSqlFileDependency EOF
            {
             newCompositeNode(grammarAccess.getSqlFileDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSqlFileDependency=ruleSqlFileDependency();

            state._fsp--;

             current =iv_ruleSqlFileDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSqlFileDependency"


    // $ANTLR start "ruleSqlFileDependency"
    // InternalMetaDsl.g:1379:1: ruleSqlFileDependency returns [EObject current=null] : (otherlv_0= 'SQLFILEDEPENDENCY' ( (lv_sqlFileDependency_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleSqlFileDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_sqlFileDependency_1_0=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:1385:2: ( (otherlv_0= 'SQLFILEDEPENDENCY' ( (lv_sqlFileDependency_1_0= RULE_STRING ) ) ) )
            // InternalMetaDsl.g:1386:2: (otherlv_0= 'SQLFILEDEPENDENCY' ( (lv_sqlFileDependency_1_0= RULE_STRING ) ) )
            {
            // InternalMetaDsl.g:1386:2: (otherlv_0= 'SQLFILEDEPENDENCY' ( (lv_sqlFileDependency_1_0= RULE_STRING ) ) )
            // InternalMetaDsl.g:1387:3: otherlv_0= 'SQLFILEDEPENDENCY' ( (lv_sqlFileDependency_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getSqlFileDependencyAccess().getSQLFILEDEPENDENCYKeyword_0());
            		
            // InternalMetaDsl.g:1391:3: ( (lv_sqlFileDependency_1_0= RULE_STRING ) )
            // InternalMetaDsl.g:1392:4: (lv_sqlFileDependency_1_0= RULE_STRING )
            {
            // InternalMetaDsl.g:1392:4: (lv_sqlFileDependency_1_0= RULE_STRING )
            // InternalMetaDsl.g:1393:5: lv_sqlFileDependency_1_0= RULE_STRING
            {
            lv_sqlFileDependency_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_sqlFileDependency_1_0, grammarAccess.getSqlFileDependencyAccess().getSqlFileDependencySTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSqlFileDependencyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"sqlFileDependency",
            						lv_sqlFileDependency_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSqlFileDependency"


    // $ANTLR start "entryRuleSequence"
    // InternalMetaDsl.g:1413:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // InternalMetaDsl.g:1413:49: (iv_ruleSequence= ruleSequence EOF )
            // InternalMetaDsl.g:1414:2: iv_ruleSequence= ruleSequence EOF
            {
             newCompositeNode(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // InternalMetaDsl.g:1420:1: ruleSequence returns [EObject current=null] : (otherlv_0= 'SEQUENCE' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'START' otherlv_3= 'WITH' ( (lv_startWith_4_0= RULE_NATURAL ) ) )? (otherlv_5= 'INCREMENT' otherlv_6= 'BY' ( (lv_incrementBy_7_0= RULE_NATURAL ) ) )? (otherlv_8= 'MINVALUE' ( (lv_minValue_9_0= RULE_NATURAL ) ) )? (otherlv_10= 'MAXVALUE' ( (lv_maxValue_11_0= RULE_NATURAL ) ) )? ( (lv_cycle_12_0= 'CYCLE' ) )? (otherlv_13= 'CACHE' ( (lv_cache_14_0= RULE_NATURAL ) ) )? ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_startWith_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_incrementBy_7_0=null;
        Token otherlv_8=null;
        Token lv_minValue_9_0=null;
        Token otherlv_10=null;
        Token lv_maxValue_11_0=null;
        Token lv_cycle_12_0=null;
        Token otherlv_13=null;
        Token lv_cache_14_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:1426:2: ( (otherlv_0= 'SEQUENCE' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'START' otherlv_3= 'WITH' ( (lv_startWith_4_0= RULE_NATURAL ) ) )? (otherlv_5= 'INCREMENT' otherlv_6= 'BY' ( (lv_incrementBy_7_0= RULE_NATURAL ) ) )? (otherlv_8= 'MINVALUE' ( (lv_minValue_9_0= RULE_NATURAL ) ) )? (otherlv_10= 'MAXVALUE' ( (lv_maxValue_11_0= RULE_NATURAL ) ) )? ( (lv_cycle_12_0= 'CYCLE' ) )? (otherlv_13= 'CACHE' ( (lv_cache_14_0= RULE_NATURAL ) ) )? ) )
            // InternalMetaDsl.g:1427:2: (otherlv_0= 'SEQUENCE' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'START' otherlv_3= 'WITH' ( (lv_startWith_4_0= RULE_NATURAL ) ) )? (otherlv_5= 'INCREMENT' otherlv_6= 'BY' ( (lv_incrementBy_7_0= RULE_NATURAL ) ) )? (otherlv_8= 'MINVALUE' ( (lv_minValue_9_0= RULE_NATURAL ) ) )? (otherlv_10= 'MAXVALUE' ( (lv_maxValue_11_0= RULE_NATURAL ) ) )? ( (lv_cycle_12_0= 'CYCLE' ) )? (otherlv_13= 'CACHE' ( (lv_cache_14_0= RULE_NATURAL ) ) )? )
            {
            // InternalMetaDsl.g:1427:2: (otherlv_0= 'SEQUENCE' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'START' otherlv_3= 'WITH' ( (lv_startWith_4_0= RULE_NATURAL ) ) )? (otherlv_5= 'INCREMENT' otherlv_6= 'BY' ( (lv_incrementBy_7_0= RULE_NATURAL ) ) )? (otherlv_8= 'MINVALUE' ( (lv_minValue_9_0= RULE_NATURAL ) ) )? (otherlv_10= 'MAXVALUE' ( (lv_maxValue_11_0= RULE_NATURAL ) ) )? ( (lv_cycle_12_0= 'CYCLE' ) )? (otherlv_13= 'CACHE' ( (lv_cache_14_0= RULE_NATURAL ) ) )? )
            // InternalMetaDsl.g:1428:3: otherlv_0= 'SEQUENCE' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'START' otherlv_3= 'WITH' ( (lv_startWith_4_0= RULE_NATURAL ) ) )? (otherlv_5= 'INCREMENT' otherlv_6= 'BY' ( (lv_incrementBy_7_0= RULE_NATURAL ) ) )? (otherlv_8= 'MINVALUE' ( (lv_minValue_9_0= RULE_NATURAL ) ) )? (otherlv_10= 'MAXVALUE' ( (lv_maxValue_11_0= RULE_NATURAL ) ) )? ( (lv_cycle_12_0= 'CYCLE' ) )? (otherlv_13= 'CACHE' ( (lv_cache_14_0= RULE_NATURAL ) ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getSequenceAccess().getSEQUENCEKeyword_0());
            		
            // InternalMetaDsl.g:1432:3: ( (lv_name_1_0= ruleFQN ) )
            // InternalMetaDsl.g:1433:4: (lv_name_1_0= ruleFQN )
            {
            // InternalMetaDsl.g:1433:4: (lv_name_1_0= ruleFQN )
            // InternalMetaDsl.g:1434:5: lv_name_1_0= ruleFQN
            {

            					newCompositeNode(grammarAccess.getSequenceAccess().getNameFQNParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_45);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSequenceRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.FQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMetaDsl.g:1451:3: (otherlv_2= 'START' otherlv_3= 'WITH' ( (lv_startWith_4_0= RULE_NATURAL ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==48) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalMetaDsl.g:1452:4: otherlv_2= 'START' otherlv_3= 'WITH' ( (lv_startWith_4_0= RULE_NATURAL ) )
                    {
                    otherlv_2=(Token)match(input,48,FOLLOW_46); 

                    				newLeafNode(otherlv_2, grammarAccess.getSequenceAccess().getSTARTKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,49,FOLLOW_28); 

                    				newLeafNode(otherlv_3, grammarAccess.getSequenceAccess().getWITHKeyword_2_1());
                    			
                    // InternalMetaDsl.g:1460:4: ( (lv_startWith_4_0= RULE_NATURAL ) )
                    // InternalMetaDsl.g:1461:5: (lv_startWith_4_0= RULE_NATURAL )
                    {
                    // InternalMetaDsl.g:1461:5: (lv_startWith_4_0= RULE_NATURAL )
                    // InternalMetaDsl.g:1462:6: lv_startWith_4_0= RULE_NATURAL
                    {
                    lv_startWith_4_0=(Token)match(input,RULE_NATURAL,FOLLOW_47); 

                    						newLeafNode(lv_startWith_4_0, grammarAccess.getSequenceAccess().getStartWithNATURALTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSequenceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"startWith",
                    							lv_startWith_4_0,
                    							"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1479:3: (otherlv_5= 'INCREMENT' otherlv_6= 'BY' ( (lv_incrementBy_7_0= RULE_NATURAL ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==50) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMetaDsl.g:1480:4: otherlv_5= 'INCREMENT' otherlv_6= 'BY' ( (lv_incrementBy_7_0= RULE_NATURAL ) )
                    {
                    otherlv_5=(Token)match(input,50,FOLLOW_48); 

                    				newLeafNode(otherlv_5, grammarAccess.getSequenceAccess().getINCREMENTKeyword_3_0());
                    			
                    otherlv_6=(Token)match(input,51,FOLLOW_28); 

                    				newLeafNode(otherlv_6, grammarAccess.getSequenceAccess().getBYKeyword_3_1());
                    			
                    // InternalMetaDsl.g:1488:4: ( (lv_incrementBy_7_0= RULE_NATURAL ) )
                    // InternalMetaDsl.g:1489:5: (lv_incrementBy_7_0= RULE_NATURAL )
                    {
                    // InternalMetaDsl.g:1489:5: (lv_incrementBy_7_0= RULE_NATURAL )
                    // InternalMetaDsl.g:1490:6: lv_incrementBy_7_0= RULE_NATURAL
                    {
                    lv_incrementBy_7_0=(Token)match(input,RULE_NATURAL,FOLLOW_49); 

                    						newLeafNode(lv_incrementBy_7_0, grammarAccess.getSequenceAccess().getIncrementByNATURALTerminalRuleCall_3_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSequenceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"incrementBy",
                    							lv_incrementBy_7_0,
                    							"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1507:3: (otherlv_8= 'MINVALUE' ( (lv_minValue_9_0= RULE_NATURAL ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==52) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalMetaDsl.g:1508:4: otherlv_8= 'MINVALUE' ( (lv_minValue_9_0= RULE_NATURAL ) )
                    {
                    otherlv_8=(Token)match(input,52,FOLLOW_28); 

                    				newLeafNode(otherlv_8, grammarAccess.getSequenceAccess().getMINVALUEKeyword_4_0());
                    			
                    // InternalMetaDsl.g:1512:4: ( (lv_minValue_9_0= RULE_NATURAL ) )
                    // InternalMetaDsl.g:1513:5: (lv_minValue_9_0= RULE_NATURAL )
                    {
                    // InternalMetaDsl.g:1513:5: (lv_minValue_9_0= RULE_NATURAL )
                    // InternalMetaDsl.g:1514:6: lv_minValue_9_0= RULE_NATURAL
                    {
                    lv_minValue_9_0=(Token)match(input,RULE_NATURAL,FOLLOW_50); 

                    						newLeafNode(lv_minValue_9_0, grammarAccess.getSequenceAccess().getMinValueNATURALTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSequenceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minValue",
                    							lv_minValue_9_0,
                    							"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1531:3: (otherlv_10= 'MAXVALUE' ( (lv_maxValue_11_0= RULE_NATURAL ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==53) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalMetaDsl.g:1532:4: otherlv_10= 'MAXVALUE' ( (lv_maxValue_11_0= RULE_NATURAL ) )
                    {
                    otherlv_10=(Token)match(input,53,FOLLOW_28); 

                    				newLeafNode(otherlv_10, grammarAccess.getSequenceAccess().getMAXVALUEKeyword_5_0());
                    			
                    // InternalMetaDsl.g:1536:4: ( (lv_maxValue_11_0= RULE_NATURAL ) )
                    // InternalMetaDsl.g:1537:5: (lv_maxValue_11_0= RULE_NATURAL )
                    {
                    // InternalMetaDsl.g:1537:5: (lv_maxValue_11_0= RULE_NATURAL )
                    // InternalMetaDsl.g:1538:6: lv_maxValue_11_0= RULE_NATURAL
                    {
                    lv_maxValue_11_0=(Token)match(input,RULE_NATURAL,FOLLOW_51); 

                    						newLeafNode(lv_maxValue_11_0, grammarAccess.getSequenceAccess().getMaxValueNATURALTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSequenceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"maxValue",
                    							lv_maxValue_11_0,
                    							"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1555:3: ( (lv_cycle_12_0= 'CYCLE' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==54) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMetaDsl.g:1556:4: (lv_cycle_12_0= 'CYCLE' )
                    {
                    // InternalMetaDsl.g:1556:4: (lv_cycle_12_0= 'CYCLE' )
                    // InternalMetaDsl.g:1557:5: lv_cycle_12_0= 'CYCLE'
                    {
                    lv_cycle_12_0=(Token)match(input,54,FOLLOW_52); 

                    					newLeafNode(lv_cycle_12_0, grammarAccess.getSequenceAccess().getCycleCYCLEKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSequenceRule());
                    					}
                    					setWithLastConsumed(current, "cycle", true, "CYCLE");
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1569:3: (otherlv_13= 'CACHE' ( (lv_cache_14_0= RULE_NATURAL ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==55) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalMetaDsl.g:1570:4: otherlv_13= 'CACHE' ( (lv_cache_14_0= RULE_NATURAL ) )
                    {
                    otherlv_13=(Token)match(input,55,FOLLOW_28); 

                    				newLeafNode(otherlv_13, grammarAccess.getSequenceAccess().getCACHEKeyword_7_0());
                    			
                    // InternalMetaDsl.g:1574:4: ( (lv_cache_14_0= RULE_NATURAL ) )
                    // InternalMetaDsl.g:1575:5: (lv_cache_14_0= RULE_NATURAL )
                    {
                    // InternalMetaDsl.g:1575:5: (lv_cache_14_0= RULE_NATURAL )
                    // InternalMetaDsl.g:1576:6: lv_cache_14_0= RULE_NATURAL
                    {
                    lv_cache_14_0=(Token)match(input,RULE_NATURAL,FOLLOW_2); 

                    						newLeafNode(lv_cache_14_0, grammarAccess.getSequenceAccess().getCacheNATURALTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSequenceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cache",
                    							lv_cache_14_0,
                    							"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleAttribute"
    // InternalMetaDsl.g:1597:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalMetaDsl.g:1597:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalMetaDsl.g:1598:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalMetaDsl.g:1604:1: ruleAttribute returns [EObject current=null] : ( ( (lv_unique_0_0= 'UQ' ) )? ( (lv_pk_1_0= 'PK' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_length_5_0= RULE_NATURAL ) ) | ( (lv_maxlength_6_0= 'MAX' ) ) ) (otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) ) )? otherlv_9= ')' )? ( (lv_notNullable_10_0= 'NOTNULL' ) )? (otherlv_11= 'SAMEAS' ( ( ruleFQN ) ) )? (otherlv_13= 'FKTO' ( ( ruleFQN ) ) )? (otherlv_15= 'MULTIREFTO' ( ( ruleFQN ) ) )? (otherlv_17= 'DEFAULT' ( ( (lv_default_18_0= RULE_STRING ) ) | ( (otherlv_19= RULE_ID ) ) ) )? ( (lv_transient_20_0= 'TRANSIENT' ) )? (otherlv_21= 'STEREOTYPES' ( (otherlv_22= RULE_ID ) ) (otherlv_23= ',' ( (otherlv_24= RULE_ID ) ) )? )? ( (lv_idGenerator_25_0= ruleIdGenerator ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_unique_0_0=null;
        Token lv_pk_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_length_5_0=null;
        Token lv_maxlength_6_0=null;
        Token otherlv_7=null;
        Token lv_scale_8_0=null;
        Token otherlv_9=null;
        Token lv_notNullable_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token lv_default_18_0=null;
        Token otherlv_19=null;
        Token lv_transient_20_0=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        EObject lv_idGenerator_25_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:1610:2: ( ( ( (lv_unique_0_0= 'UQ' ) )? ( (lv_pk_1_0= 'PK' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_length_5_0= RULE_NATURAL ) ) | ( (lv_maxlength_6_0= 'MAX' ) ) ) (otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) ) )? otherlv_9= ')' )? ( (lv_notNullable_10_0= 'NOTNULL' ) )? (otherlv_11= 'SAMEAS' ( ( ruleFQN ) ) )? (otherlv_13= 'FKTO' ( ( ruleFQN ) ) )? (otherlv_15= 'MULTIREFTO' ( ( ruleFQN ) ) )? (otherlv_17= 'DEFAULT' ( ( (lv_default_18_0= RULE_STRING ) ) | ( (otherlv_19= RULE_ID ) ) ) )? ( (lv_transient_20_0= 'TRANSIENT' ) )? (otherlv_21= 'STEREOTYPES' ( (otherlv_22= RULE_ID ) ) (otherlv_23= ',' ( (otherlv_24= RULE_ID ) ) )? )? ( (lv_idGenerator_25_0= ruleIdGenerator ) )? ) )
            // InternalMetaDsl.g:1611:2: ( ( (lv_unique_0_0= 'UQ' ) )? ( (lv_pk_1_0= 'PK' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_length_5_0= RULE_NATURAL ) ) | ( (lv_maxlength_6_0= 'MAX' ) ) ) (otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) ) )? otherlv_9= ')' )? ( (lv_notNullable_10_0= 'NOTNULL' ) )? (otherlv_11= 'SAMEAS' ( ( ruleFQN ) ) )? (otherlv_13= 'FKTO' ( ( ruleFQN ) ) )? (otherlv_15= 'MULTIREFTO' ( ( ruleFQN ) ) )? (otherlv_17= 'DEFAULT' ( ( (lv_default_18_0= RULE_STRING ) ) | ( (otherlv_19= RULE_ID ) ) ) )? ( (lv_transient_20_0= 'TRANSIENT' ) )? (otherlv_21= 'STEREOTYPES' ( (otherlv_22= RULE_ID ) ) (otherlv_23= ',' ( (otherlv_24= RULE_ID ) ) )? )? ( (lv_idGenerator_25_0= ruleIdGenerator ) )? )
            {
            // InternalMetaDsl.g:1611:2: ( ( (lv_unique_0_0= 'UQ' ) )? ( (lv_pk_1_0= 'PK' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_length_5_0= RULE_NATURAL ) ) | ( (lv_maxlength_6_0= 'MAX' ) ) ) (otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) ) )? otherlv_9= ')' )? ( (lv_notNullable_10_0= 'NOTNULL' ) )? (otherlv_11= 'SAMEAS' ( ( ruleFQN ) ) )? (otherlv_13= 'FKTO' ( ( ruleFQN ) ) )? (otherlv_15= 'MULTIREFTO' ( ( ruleFQN ) ) )? (otherlv_17= 'DEFAULT' ( ( (lv_default_18_0= RULE_STRING ) ) | ( (otherlv_19= RULE_ID ) ) ) )? ( (lv_transient_20_0= 'TRANSIENT' ) )? (otherlv_21= 'STEREOTYPES' ( (otherlv_22= RULE_ID ) ) (otherlv_23= ',' ( (otherlv_24= RULE_ID ) ) )? )? ( (lv_idGenerator_25_0= ruleIdGenerator ) )? )
            // InternalMetaDsl.g:1612:3: ( (lv_unique_0_0= 'UQ' ) )? ( (lv_pk_1_0= 'PK' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_length_5_0= RULE_NATURAL ) ) | ( (lv_maxlength_6_0= 'MAX' ) ) ) (otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) ) )? otherlv_9= ')' )? ( (lv_notNullable_10_0= 'NOTNULL' ) )? (otherlv_11= 'SAMEAS' ( ( ruleFQN ) ) )? (otherlv_13= 'FKTO' ( ( ruleFQN ) ) )? (otherlv_15= 'MULTIREFTO' ( ( ruleFQN ) ) )? (otherlv_17= 'DEFAULT' ( ( (lv_default_18_0= RULE_STRING ) ) | ( (otherlv_19= RULE_ID ) ) ) )? ( (lv_transient_20_0= 'TRANSIENT' ) )? (otherlv_21= 'STEREOTYPES' ( (otherlv_22= RULE_ID ) ) (otherlv_23= ',' ( (otherlv_24= RULE_ID ) ) )? )? ( (lv_idGenerator_25_0= ruleIdGenerator ) )?
            {
            // InternalMetaDsl.g:1612:3: ( (lv_unique_0_0= 'UQ' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==56) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalMetaDsl.g:1613:4: (lv_unique_0_0= 'UQ' )
                    {
                    // InternalMetaDsl.g:1613:4: (lv_unique_0_0= 'UQ' )
                    // InternalMetaDsl.g:1614:5: lv_unique_0_0= 'UQ'
                    {
                    lv_unique_0_0=(Token)match(input,56,FOLLOW_53); 

                    					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUQKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", true, "UQ");
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1626:3: ( (lv_pk_1_0= 'PK' ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==57) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMetaDsl.g:1627:4: (lv_pk_1_0= 'PK' )
                    {
                    // InternalMetaDsl.g:1627:4: (lv_pk_1_0= 'PK' )
                    // InternalMetaDsl.g:1628:5: lv_pk_1_0= 'PK'
                    {
                    lv_pk_1_0=(Token)match(input,57,FOLLOW_18); 

                    					newLeafNode(lv_pk_1_0, grammarAccess.getAttributeAccess().getPkPKKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "pk", true, "PK");
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1640:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMetaDsl.g:1641:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMetaDsl.g:1641:4: (lv_name_2_0= RULE_ID )
            // InternalMetaDsl.g:1642:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_2_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            // InternalMetaDsl.g:1658:3: ( (otherlv_3= RULE_ID ) )
            // InternalMetaDsl.g:1659:4: (otherlv_3= RULE_ID )
            {
            // InternalMetaDsl.g:1659:4: (otherlv_3= RULE_ID )
            // InternalMetaDsl.g:1660:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_54); 

            					newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getTypeDataTypeCrossReference_3_0());
            				

            }


            }

            // InternalMetaDsl.g:1671:3: (otherlv_4= '(' ( ( (lv_length_5_0= RULE_NATURAL ) ) | ( (lv_maxlength_6_0= 'MAX' ) ) ) (otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) ) )? otherlv_9= ')' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==32) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalMetaDsl.g:1672:4: otherlv_4= '(' ( ( (lv_length_5_0= RULE_NATURAL ) ) | ( (lv_maxlength_6_0= 'MAX' ) ) ) (otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) ) )? otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_26); 

                    				newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalMetaDsl.g:1676:4: ( ( (lv_length_5_0= RULE_NATURAL ) ) | ( (lv_maxlength_6_0= 'MAX' ) ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==RULE_NATURAL) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==33) ) {
                        alt46=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalMetaDsl.g:1677:5: ( (lv_length_5_0= RULE_NATURAL ) )
                            {
                            // InternalMetaDsl.g:1677:5: ( (lv_length_5_0= RULE_NATURAL ) )
                            // InternalMetaDsl.g:1678:6: (lv_length_5_0= RULE_NATURAL )
                            {
                            // InternalMetaDsl.g:1678:6: (lv_length_5_0= RULE_NATURAL )
                            // InternalMetaDsl.g:1679:7: lv_length_5_0= RULE_NATURAL
                            {
                            lv_length_5_0=(Token)match(input,RULE_NATURAL,FOLLOW_27); 

                            							newLeafNode(lv_length_5_0, grammarAccess.getAttributeAccess().getLengthNATURALTerminalRuleCall_4_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getAttributeRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"length",
                            								lv_length_5_0,
                            								"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:1696:5: ( (lv_maxlength_6_0= 'MAX' ) )
                            {
                            // InternalMetaDsl.g:1696:5: ( (lv_maxlength_6_0= 'MAX' ) )
                            // InternalMetaDsl.g:1697:6: (lv_maxlength_6_0= 'MAX' )
                            {
                            // InternalMetaDsl.g:1697:6: (lv_maxlength_6_0= 'MAX' )
                            // InternalMetaDsl.g:1698:7: lv_maxlength_6_0= 'MAX'
                            {
                            lv_maxlength_6_0=(Token)match(input,33,FOLLOW_27); 

                            							newLeafNode(lv_maxlength_6_0, grammarAccess.getAttributeAccess().getMaxlengthMAXKeyword_4_1_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getAttributeRule());
                            							}
                            							setWithLastConsumed(current, "maxlength", true, "MAX");
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMetaDsl.g:1711:4: (otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==34) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalMetaDsl.g:1712:5: otherlv_7= ',' ( (lv_scale_8_0= RULE_NATURAL ) )
                            {
                            otherlv_7=(Token)match(input,34,FOLLOW_28); 

                            					newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getCommaKeyword_4_2_0());
                            				
                            // InternalMetaDsl.g:1716:5: ( (lv_scale_8_0= RULE_NATURAL ) )
                            // InternalMetaDsl.g:1717:6: (lv_scale_8_0= RULE_NATURAL )
                            {
                            // InternalMetaDsl.g:1717:6: (lv_scale_8_0= RULE_NATURAL )
                            // InternalMetaDsl.g:1718:7: lv_scale_8_0= RULE_NATURAL
                            {
                            lv_scale_8_0=(Token)match(input,RULE_NATURAL,FOLLOW_29); 

                            							newLeafNode(lv_scale_8_0, grammarAccess.getAttributeAccess().getScaleNATURALTerminalRuleCall_4_2_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getAttributeRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"scale",
                            								lv_scale_8_0,
                            								"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,35,FOLLOW_55); 

                    				newLeafNode(otherlv_9, grammarAccess.getAttributeAccess().getRightParenthesisKeyword_4_3());
                    			

                    }
                    break;

            }

            // InternalMetaDsl.g:1740:3: ( (lv_notNullable_10_0= 'NOTNULL' ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==58) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalMetaDsl.g:1741:4: (lv_notNullable_10_0= 'NOTNULL' )
                    {
                    // InternalMetaDsl.g:1741:4: (lv_notNullable_10_0= 'NOTNULL' )
                    // InternalMetaDsl.g:1742:5: lv_notNullable_10_0= 'NOTNULL'
                    {
                    lv_notNullable_10_0=(Token)match(input,58,FOLLOW_56); 

                    					newLeafNode(lv_notNullable_10_0, grammarAccess.getAttributeAccess().getNotNullableNOTNULLKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notNullable", true, "NOTNULL");
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1754:3: (otherlv_11= 'SAMEAS' ( ( ruleFQN ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==59) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalMetaDsl.g:1755:4: otherlv_11= 'SAMEAS' ( ( ruleFQN ) )
                    {
                    otherlv_11=(Token)match(input,59,FOLLOW_18); 

                    				newLeafNode(otherlv_11, grammarAccess.getAttributeAccess().getSAMEASKeyword_6_0());
                    			
                    // InternalMetaDsl.g:1759:4: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:1760:5: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:1760:5: ( ruleFQN )
                    // InternalMetaDsl.g:1761:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getSameAsAttributeAttributeCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_57);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1776:3: (otherlv_13= 'FKTO' ( ( ruleFQN ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==60) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalMetaDsl.g:1777:4: otherlv_13= 'FKTO' ( ( ruleFQN ) )
                    {
                    otherlv_13=(Token)match(input,60,FOLLOW_18); 

                    				newLeafNode(otherlv_13, grammarAccess.getAttributeAccess().getFKTOKeyword_7_0());
                    			
                    // InternalMetaDsl.g:1781:4: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:1782:5: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:1782:5: ( ruleFQN )
                    // InternalMetaDsl.g:1783:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getFktoEntityCrossReference_7_1_0());
                    					
                    pushFollow(FOLLOW_58);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1798:3: (otherlv_15= 'MULTIREFTO' ( ( ruleFQN ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==61) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMetaDsl.g:1799:4: otherlv_15= 'MULTIREFTO' ( ( ruleFQN ) )
                    {
                    otherlv_15=(Token)match(input,61,FOLLOW_18); 

                    				newLeafNode(otherlv_15, grammarAccess.getAttributeAccess().getMULTIREFTOKeyword_8_0());
                    			
                    // InternalMetaDsl.g:1803:4: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:1804:5: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:1804:5: ( ruleFQN )
                    // InternalMetaDsl.g:1805:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getMultiRefToEntityCrossReference_8_1_0());
                    					
                    pushFollow(FOLLOW_59);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1820:3: (otherlv_17= 'DEFAULT' ( ( (lv_default_18_0= RULE_STRING ) ) | ( (otherlv_19= RULE_ID ) ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==62) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMetaDsl.g:1821:4: otherlv_17= 'DEFAULT' ( ( (lv_default_18_0= RULE_STRING ) ) | ( (otherlv_19= RULE_ID ) ) )
                    {
                    otherlv_17=(Token)match(input,62,FOLLOW_60); 

                    				newLeafNode(otherlv_17, grammarAccess.getAttributeAccess().getDEFAULTKeyword_9_0());
                    			
                    // InternalMetaDsl.g:1825:4: ( ( (lv_default_18_0= RULE_STRING ) ) | ( (otherlv_19= RULE_ID ) ) )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==RULE_STRING) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==RULE_ID) ) {
                        alt53=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalMetaDsl.g:1826:5: ( (lv_default_18_0= RULE_STRING ) )
                            {
                            // InternalMetaDsl.g:1826:5: ( (lv_default_18_0= RULE_STRING ) )
                            // InternalMetaDsl.g:1827:6: (lv_default_18_0= RULE_STRING )
                            {
                            // InternalMetaDsl.g:1827:6: (lv_default_18_0= RULE_STRING )
                            // InternalMetaDsl.g:1828:7: lv_default_18_0= RULE_STRING
                            {
                            lv_default_18_0=(Token)match(input,RULE_STRING,FOLLOW_61); 

                            							newLeafNode(lv_default_18_0, grammarAccess.getAttributeAccess().getDefaultSTRINGTerminalRuleCall_9_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getAttributeRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"default",
                            								lv_default_18_0,
                            								"com.jsantos.metadata.plugin.MetaDsl.STRING");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:1845:5: ( (otherlv_19= RULE_ID ) )
                            {
                            // InternalMetaDsl.g:1845:5: ( (otherlv_19= RULE_ID ) )
                            // InternalMetaDsl.g:1846:6: (otherlv_19= RULE_ID )
                            {
                            // InternalMetaDsl.g:1846:6: (otherlv_19= RULE_ID )
                            // InternalMetaDsl.g:1847:7: otherlv_19= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getAttributeRule());
                            							}
                            						
                            otherlv_19=(Token)match(input,RULE_ID,FOLLOW_61); 

                            							newLeafNode(otherlv_19, grammarAccess.getAttributeAccess().getDefaultConstantConstantCrossReference_9_1_1_0());
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1860:3: ( (lv_transient_20_0= 'TRANSIENT' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==63) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalMetaDsl.g:1861:4: (lv_transient_20_0= 'TRANSIENT' )
                    {
                    // InternalMetaDsl.g:1861:4: (lv_transient_20_0= 'TRANSIENT' )
                    // InternalMetaDsl.g:1862:5: lv_transient_20_0= 'TRANSIENT'
                    {
                    lv_transient_20_0=(Token)match(input,63,FOLLOW_62); 

                    					newLeafNode(lv_transient_20_0, grammarAccess.getAttributeAccess().getTransientTRANSIENTKeyword_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "transient", true, "TRANSIENT");
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1874:3: (otherlv_21= 'STEREOTYPES' ( (otherlv_22= RULE_ID ) ) (otherlv_23= ',' ( (otherlv_24= RULE_ID ) ) )? )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==46) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalMetaDsl.g:1875:4: otherlv_21= 'STEREOTYPES' ( (otherlv_22= RULE_ID ) ) (otherlv_23= ',' ( (otherlv_24= RULE_ID ) ) )?
                    {
                    otherlv_21=(Token)match(input,46,FOLLOW_18); 

                    				newLeafNode(otherlv_21, grammarAccess.getAttributeAccess().getSTEREOTYPESKeyword_11_0());
                    			
                    // InternalMetaDsl.g:1879:4: ( (otherlv_22= RULE_ID ) )
                    // InternalMetaDsl.g:1880:5: (otherlv_22= RULE_ID )
                    {
                    // InternalMetaDsl.g:1880:5: (otherlv_22= RULE_ID )
                    // InternalMetaDsl.g:1881:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_63); 

                    						newLeafNode(otherlv_22, grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeCrossReference_11_1_0());
                    					

                    }


                    }

                    // InternalMetaDsl.g:1892:4: (otherlv_23= ',' ( (otherlv_24= RULE_ID ) ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==34) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // InternalMetaDsl.g:1893:5: otherlv_23= ',' ( (otherlv_24= RULE_ID ) )
                            {
                            otherlv_23=(Token)match(input,34,FOLLOW_18); 

                            					newLeafNode(otherlv_23, grammarAccess.getAttributeAccess().getCommaKeyword_11_2_0());
                            				
                            // InternalMetaDsl.g:1897:5: ( (otherlv_24= RULE_ID ) )
                            // InternalMetaDsl.g:1898:6: (otherlv_24= RULE_ID )
                            {
                            // InternalMetaDsl.g:1898:6: (otherlv_24= RULE_ID )
                            // InternalMetaDsl.g:1899:7: otherlv_24= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getAttributeRule());
                            							}
                            						
                            otherlv_24=(Token)match(input,RULE_ID,FOLLOW_64); 

                            							newLeafNode(otherlv_24, grammarAccess.getAttributeAccess().getStereotypesColumnStereotypeCrossReference_11_2_1_0());
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:1912:3: ( (lv_idGenerator_25_0= ruleIdGenerator ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==64) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalMetaDsl.g:1913:4: (lv_idGenerator_25_0= ruleIdGenerator )
                    {
                    // InternalMetaDsl.g:1913:4: (lv_idGenerator_25_0= ruleIdGenerator )
                    // InternalMetaDsl.g:1914:5: lv_idGenerator_25_0= ruleIdGenerator
                    {

                    					newCompositeNode(grammarAccess.getAttributeAccess().getIdGeneratorIdGeneratorParserRuleCall_12_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_idGenerator_25_0=ruleIdGenerator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getAttributeRule());
                    					}
                    					set(
                    						current,
                    						"idGenerator",
                    						lv_idGenerator_25_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.IdGenerator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleIdGenerator"
    // InternalMetaDsl.g:1935:1: entryRuleIdGenerator returns [EObject current=null] : iv_ruleIdGenerator= ruleIdGenerator EOF ;
    public final EObject entryRuleIdGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdGenerator = null;


        try {
            // InternalMetaDsl.g:1935:52: (iv_ruleIdGenerator= ruleIdGenerator EOF )
            // InternalMetaDsl.g:1936:2: iv_ruleIdGenerator= ruleIdGenerator EOF
            {
             newCompositeNode(grammarAccess.getIdGeneratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdGenerator=ruleIdGenerator();

            state._fsp--;

             current =iv_ruleIdGenerator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdGenerator"


    // $ANTLR start "ruleIdGenerator"
    // InternalMetaDsl.g:1942:1: ruleIdGenerator returns [EObject current=null] : (otherlv_0= 'IDGENERATOR' ( (otherlv_1= RULE_ID ) ) ( (lv_typeBlock_2_0= ruleIdGeneratorTypeBlock ) ) ) ;
    public final EObject ruleIdGenerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_typeBlock_2_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:1948:2: ( (otherlv_0= 'IDGENERATOR' ( (otherlv_1= RULE_ID ) ) ( (lv_typeBlock_2_0= ruleIdGeneratorTypeBlock ) ) ) )
            // InternalMetaDsl.g:1949:2: (otherlv_0= 'IDGENERATOR' ( (otherlv_1= RULE_ID ) ) ( (lv_typeBlock_2_0= ruleIdGeneratorTypeBlock ) ) )
            {
            // InternalMetaDsl.g:1949:2: (otherlv_0= 'IDGENERATOR' ( (otherlv_1= RULE_ID ) ) ( (lv_typeBlock_2_0= ruleIdGeneratorTypeBlock ) ) )
            // InternalMetaDsl.g:1950:3: otherlv_0= 'IDGENERATOR' ( (otherlv_1= RULE_ID ) ) ( (lv_typeBlock_2_0= ruleIdGeneratorTypeBlock ) )
            {
            otherlv_0=(Token)match(input,64,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getIdGeneratorAccess().getIDGENERATORKeyword_0());
            		
            // InternalMetaDsl.g:1954:3: ( (otherlv_1= RULE_ID ) )
            // InternalMetaDsl.g:1955:4: (otherlv_1= RULE_ID )
            {
            // InternalMetaDsl.g:1955:4: (otherlv_1= RULE_ID )
            // InternalMetaDsl.g:1956:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIdGeneratorRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_65); 

            					newLeafNode(otherlv_1, grammarAccess.getIdGeneratorAccess().getAttributeAttributeCrossReference_1_0());
            				

            }


            }

            // InternalMetaDsl.g:1967:3: ( (lv_typeBlock_2_0= ruleIdGeneratorTypeBlock ) )
            // InternalMetaDsl.g:1968:4: (lv_typeBlock_2_0= ruleIdGeneratorTypeBlock )
            {
            // InternalMetaDsl.g:1968:4: (lv_typeBlock_2_0= ruleIdGeneratorTypeBlock )
            // InternalMetaDsl.g:1969:5: lv_typeBlock_2_0= ruleIdGeneratorTypeBlock
            {

            					newCompositeNode(grammarAccess.getIdGeneratorAccess().getTypeBlockIdGeneratorTypeBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_typeBlock_2_0=ruleIdGeneratorTypeBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIdGeneratorRule());
            					}
            					set(
            						current,
            						"typeBlock",
            						lv_typeBlock_2_0,
            						"com.jsantos.metadata.plugin.MetaDsl.IdGeneratorTypeBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdGenerator"


    // $ANTLR start "entryRuleIdGeneratorTypeBlock"
    // InternalMetaDsl.g:1990:1: entryRuleIdGeneratorTypeBlock returns [EObject current=null] : iv_ruleIdGeneratorTypeBlock= ruleIdGeneratorTypeBlock EOF ;
    public final EObject entryRuleIdGeneratorTypeBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdGeneratorTypeBlock = null;


        try {
            // InternalMetaDsl.g:1990:61: (iv_ruleIdGeneratorTypeBlock= ruleIdGeneratorTypeBlock EOF )
            // InternalMetaDsl.g:1991:2: iv_ruleIdGeneratorTypeBlock= ruleIdGeneratorTypeBlock EOF
            {
             newCompositeNode(grammarAccess.getIdGeneratorTypeBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdGeneratorTypeBlock=ruleIdGeneratorTypeBlock();

            state._fsp--;

             current =iv_ruleIdGeneratorTypeBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdGeneratorTypeBlock"


    // $ANTLR start "ruleIdGeneratorTypeBlock"
    // InternalMetaDsl.g:1997:1: ruleIdGeneratorTypeBlock returns [EObject current=null] : (this_IdGeneratorSimple_0= ruleIdGeneratorSimple | this_IdGeneratorSequence_1= ruleIdGeneratorSequence ) ;
    public final EObject ruleIdGeneratorTypeBlock() throws RecognitionException {
        EObject current = null;

        EObject this_IdGeneratorSimple_0 = null;

        EObject this_IdGeneratorSequence_1 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2003:2: ( (this_IdGeneratorSimple_0= ruleIdGeneratorSimple | this_IdGeneratorSequence_1= ruleIdGeneratorSequence ) )
            // InternalMetaDsl.g:2004:2: (this_IdGeneratorSimple_0= ruleIdGeneratorSimple | this_IdGeneratorSequence_1= ruleIdGeneratorSequence )
            {
            // InternalMetaDsl.g:2004:2: (this_IdGeneratorSimple_0= ruleIdGeneratorSimple | this_IdGeneratorSequence_1= ruleIdGeneratorSequence )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==18||LA59_0==20||(LA59_0>=65 && LA59_0<=67)) ) {
                alt59=1;
            }
            else if ( (LA59_0==19) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalMetaDsl.g:2005:3: this_IdGeneratorSimple_0= ruleIdGeneratorSimple
                    {

                    			newCompositeNode(grammarAccess.getIdGeneratorTypeBlockAccess().getIdGeneratorSimpleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IdGeneratorSimple_0=ruleIdGeneratorSimple();

                    state._fsp--;


                    			current = this_IdGeneratorSimple_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:2014:3: this_IdGeneratorSequence_1= ruleIdGeneratorSequence
                    {

                    			newCompositeNode(grammarAccess.getIdGeneratorTypeBlockAccess().getIdGeneratorSequenceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_IdGeneratorSequence_1=ruleIdGeneratorSequence();

                    state._fsp--;


                    			current = this_IdGeneratorSequence_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdGeneratorTypeBlock"


    // $ANTLR start "entryRuleIdGeneratorSimple"
    // InternalMetaDsl.g:2026:1: entryRuleIdGeneratorSimple returns [EObject current=null] : iv_ruleIdGeneratorSimple= ruleIdGeneratorSimple EOF ;
    public final EObject entryRuleIdGeneratorSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdGeneratorSimple = null;


        try {
            // InternalMetaDsl.g:2026:58: (iv_ruleIdGeneratorSimple= ruleIdGeneratorSimple EOF )
            // InternalMetaDsl.g:2027:2: iv_ruleIdGeneratorSimple= ruleIdGeneratorSimple EOF
            {
             newCompositeNode(grammarAccess.getIdGeneratorSimpleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdGeneratorSimple=ruleIdGeneratorSimple();

            state._fsp--;

             current =iv_ruleIdGeneratorSimple; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdGeneratorSimple"


    // $ANTLR start "ruleIdGeneratorSimple"
    // InternalMetaDsl.g:2033:1: ruleIdGeneratorSimple returns [EObject current=null] : ( ( () ( (lv_type_1_0= 'BYRULE' ) ) ) | otherlv_2= 'GUID' | otherlv_3= 'IDENTITY' | otherlv_4= 'NONE' | otherlv_5= 'APPLICATION' ) ;
    public final EObject ruleIdGeneratorSimple() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:2039:2: ( ( ( () ( (lv_type_1_0= 'BYRULE' ) ) ) | otherlv_2= 'GUID' | otherlv_3= 'IDENTITY' | otherlv_4= 'NONE' | otherlv_5= 'APPLICATION' ) )
            // InternalMetaDsl.g:2040:2: ( ( () ( (lv_type_1_0= 'BYRULE' ) ) ) | otherlv_2= 'GUID' | otherlv_3= 'IDENTITY' | otherlv_4= 'NONE' | otherlv_5= 'APPLICATION' )
            {
            // InternalMetaDsl.g:2040:2: ( ( () ( (lv_type_1_0= 'BYRULE' ) ) ) | otherlv_2= 'GUID' | otherlv_3= 'IDENTITY' | otherlv_4= 'NONE' | otherlv_5= 'APPLICATION' )
            int alt60=5;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt60=1;
                }
                break;
            case 66:
                {
                alt60=2;
                }
                break;
            case 20:
                {
                alt60=3;
                }
                break;
            case 18:
                {
                alt60=4;
                }
                break;
            case 67:
                {
                alt60=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalMetaDsl.g:2041:3: ( () ( (lv_type_1_0= 'BYRULE' ) ) )
                    {
                    // InternalMetaDsl.g:2041:3: ( () ( (lv_type_1_0= 'BYRULE' ) ) )
                    // InternalMetaDsl.g:2042:4: () ( (lv_type_1_0= 'BYRULE' ) )
                    {
                    // InternalMetaDsl.g:2042:4: ()
                    // InternalMetaDsl.g:2043:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getIdGeneratorSimpleAccess().getIdGeneratorSimpleAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMetaDsl.g:2049:4: ( (lv_type_1_0= 'BYRULE' ) )
                    // InternalMetaDsl.g:2050:5: (lv_type_1_0= 'BYRULE' )
                    {
                    // InternalMetaDsl.g:2050:5: (lv_type_1_0= 'BYRULE' )
                    // InternalMetaDsl.g:2051:6: lv_type_1_0= 'BYRULE'
                    {
                    lv_type_1_0=(Token)match(input,65,FOLLOW_2); 

                    						newLeafNode(lv_type_1_0, grammarAccess.getIdGeneratorSimpleAccess().getTypeBYRULEKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIdGeneratorSimpleRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_1_0, "BYRULE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:2065:3: otherlv_2= 'GUID'
                    {
                    otherlv_2=(Token)match(input,66,FOLLOW_2); 

                    			newLeafNode(otherlv_2, grammarAccess.getIdGeneratorSimpleAccess().getGUIDKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:2070:3: otherlv_3= 'IDENTITY'
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_2); 

                    			newLeafNode(otherlv_3, grammarAccess.getIdGeneratorSimpleAccess().getIDENTITYKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMetaDsl.g:2075:3: otherlv_4= 'NONE'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_2); 

                    			newLeafNode(otherlv_4, grammarAccess.getIdGeneratorSimpleAccess().getNONEKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMetaDsl.g:2080:3: otherlv_5= 'APPLICATION'
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_2); 

                    			newLeafNode(otherlv_5, grammarAccess.getIdGeneratorSimpleAccess().getAPPLICATIONKeyword_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdGeneratorSimple"


    // $ANTLR start "entryRuleIdGeneratorSequence"
    // InternalMetaDsl.g:2088:1: entryRuleIdGeneratorSequence returns [EObject current=null] : iv_ruleIdGeneratorSequence= ruleIdGeneratorSequence EOF ;
    public final EObject entryRuleIdGeneratorSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdGeneratorSequence = null;


        try {
            // InternalMetaDsl.g:2088:60: (iv_ruleIdGeneratorSequence= ruleIdGeneratorSequence EOF )
            // InternalMetaDsl.g:2089:2: iv_ruleIdGeneratorSequence= ruleIdGeneratorSequence EOF
            {
             newCompositeNode(grammarAccess.getIdGeneratorSequenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdGeneratorSequence=ruleIdGeneratorSequence();

            state._fsp--;

             current =iv_ruleIdGeneratorSequence; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdGeneratorSequence"


    // $ANTLR start "ruleIdGeneratorSequence"
    // InternalMetaDsl.g:2095:1: ruleIdGeneratorSequence returns [EObject current=null] : ( () ( (lv_type_1_0= 'SEQUENCE' ) ) ( ( ruleFQN ) ) ) ;
    public final EObject ruleIdGeneratorSequence() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:2101:2: ( ( () ( (lv_type_1_0= 'SEQUENCE' ) ) ( ( ruleFQN ) ) ) )
            // InternalMetaDsl.g:2102:2: ( () ( (lv_type_1_0= 'SEQUENCE' ) ) ( ( ruleFQN ) ) )
            {
            // InternalMetaDsl.g:2102:2: ( () ( (lv_type_1_0= 'SEQUENCE' ) ) ( ( ruleFQN ) ) )
            // InternalMetaDsl.g:2103:3: () ( (lv_type_1_0= 'SEQUENCE' ) ) ( ( ruleFQN ) )
            {
            // InternalMetaDsl.g:2103:3: ()
            // InternalMetaDsl.g:2104:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIdGeneratorSequenceAccess().getIdGeneratorSequenceAction_0(),
            					current);
            			

            }

            // InternalMetaDsl.g:2110:3: ( (lv_type_1_0= 'SEQUENCE' ) )
            // InternalMetaDsl.g:2111:4: (lv_type_1_0= 'SEQUENCE' )
            {
            // InternalMetaDsl.g:2111:4: (lv_type_1_0= 'SEQUENCE' )
            // InternalMetaDsl.g:2112:5: lv_type_1_0= 'SEQUENCE'
            {
            lv_type_1_0=(Token)match(input,19,FOLLOW_18); 

            					newLeafNode(lv_type_1_0, grammarAccess.getIdGeneratorSequenceAccess().getTypeSEQUENCEKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIdGeneratorSequenceRule());
            					}
            					setWithLastConsumed(current, "type", lv_type_1_0, "SEQUENCE");
            				

            }


            }

            // InternalMetaDsl.g:2124:3: ( ( ruleFQN ) )
            // InternalMetaDsl.g:2125:4: ( ruleFQN )
            {
            // InternalMetaDsl.g:2125:4: ( ruleFQN )
            // InternalMetaDsl.g:2126:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIdGeneratorSequenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getIdGeneratorSequenceAccess().getSequenceSequenceCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdGeneratorSequence"


    // $ANTLR start "entryRuleEnuMetadata"
    // InternalMetaDsl.g:2144:1: entryRuleEnuMetadata returns [EObject current=null] : iv_ruleEnuMetadata= ruleEnuMetadata EOF ;
    public final EObject entryRuleEnuMetadata() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnuMetadata = null;


        try {
            // InternalMetaDsl.g:2144:52: (iv_ruleEnuMetadata= ruleEnuMetadata EOF )
            // InternalMetaDsl.g:2145:2: iv_ruleEnuMetadata= ruleEnuMetadata EOF
            {
             newCompositeNode(grammarAccess.getEnuMetadataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnuMetadata=ruleEnuMetadata();

            state._fsp--;

             current =iv_ruleEnuMetadata; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnuMetadata"


    // $ANTLR start "ruleEnuMetadata"
    // InternalMetaDsl.g:2151:1: ruleEnuMetadata returns [EObject current=null] : (otherlv_0= 'ENUMETADATA' otherlv_1= '{' ( (lv_enuMetadataRows_2_0= ruleEnuMetadataRow ) )* otherlv_3= '}' ) ;
    public final EObject ruleEnuMetadata() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_enuMetadataRows_2_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2157:2: ( (otherlv_0= 'ENUMETADATA' otherlv_1= '{' ( (lv_enuMetadataRows_2_0= ruleEnuMetadataRow ) )* otherlv_3= '}' ) )
            // InternalMetaDsl.g:2158:2: (otherlv_0= 'ENUMETADATA' otherlv_1= '{' ( (lv_enuMetadataRows_2_0= ruleEnuMetadataRow ) )* otherlv_3= '}' )
            {
            // InternalMetaDsl.g:2158:2: (otherlv_0= 'ENUMETADATA' otherlv_1= '{' ( (lv_enuMetadataRows_2_0= ruleEnuMetadataRow ) )* otherlv_3= '}' )
            // InternalMetaDsl.g:2159:3: otherlv_0= 'ENUMETADATA' otherlv_1= '{' ( (lv_enuMetadataRows_2_0= ruleEnuMetadataRow ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getEnuMetadataAccess().getENUMETADATAKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_66); 

            			newLeafNode(otherlv_1, grammarAccess.getEnuMetadataAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMetaDsl.g:2167:3: ( (lv_enuMetadataRows_2_0= ruleEnuMetadataRow ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_NATURAL) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalMetaDsl.g:2168:4: (lv_enuMetadataRows_2_0= ruleEnuMetadataRow )
            	    {
            	    // InternalMetaDsl.g:2168:4: (lv_enuMetadataRows_2_0= ruleEnuMetadataRow )
            	    // InternalMetaDsl.g:2169:5: lv_enuMetadataRows_2_0= ruleEnuMetadataRow
            	    {

            	    					newCompositeNode(grammarAccess.getEnuMetadataAccess().getEnuMetadataRowsEnuMetadataRowParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_66);
            	    lv_enuMetadataRows_2_0=ruleEnuMetadataRow();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEnuMetadataRule());
            	    					}
            	    					add(
            	    						current,
            	    						"enuMetadataRows",
            	    						lv_enuMetadataRows_2_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.EnuMetadataRow");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getEnuMetadataAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnuMetadata"


    // $ANTLR start "entryRuleEnuMetadataRow"
    // InternalMetaDsl.g:2194:1: entryRuleEnuMetadataRow returns [EObject current=null] : iv_ruleEnuMetadataRow= ruleEnuMetadataRow EOF ;
    public final EObject entryRuleEnuMetadataRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnuMetadataRow = null;


        try {
            // InternalMetaDsl.g:2194:55: (iv_ruleEnuMetadataRow= ruleEnuMetadataRow EOF )
            // InternalMetaDsl.g:2195:2: iv_ruleEnuMetadataRow= ruleEnuMetadataRow EOF
            {
             newCompositeNode(grammarAccess.getEnuMetadataRowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnuMetadataRow=ruleEnuMetadataRow();

            state._fsp--;

             current =iv_ruleEnuMetadataRow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnuMetadataRow"


    // $ANTLR start "ruleEnuMetadataRow"
    // InternalMetaDsl.g:2201:1: ruleEnuMetadataRow returns [EObject current=null] : ( ( (lv_key_0_0= RULE_NATURAL ) ) otherlv_1= ',' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_description_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_rowValues_6_0= ruleMetadataRowCell ) ) )* otherlv_7= ';' ) ;
    public final EObject ruleEnuMetadataRow() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_description_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_rowValues_6_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2207:2: ( ( ( (lv_key_0_0= RULE_NATURAL ) ) otherlv_1= ',' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_description_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_rowValues_6_0= ruleMetadataRowCell ) ) )* otherlv_7= ';' ) )
            // InternalMetaDsl.g:2208:2: ( ( (lv_key_0_0= RULE_NATURAL ) ) otherlv_1= ',' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_description_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_rowValues_6_0= ruleMetadataRowCell ) ) )* otherlv_7= ';' )
            {
            // InternalMetaDsl.g:2208:2: ( ( (lv_key_0_0= RULE_NATURAL ) ) otherlv_1= ',' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_description_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_rowValues_6_0= ruleMetadataRowCell ) ) )* otherlv_7= ';' )
            // InternalMetaDsl.g:2209:3: ( (lv_key_0_0= RULE_NATURAL ) ) otherlv_1= ',' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_description_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_rowValues_6_0= ruleMetadataRowCell ) ) )* otherlv_7= ';'
            {
            // InternalMetaDsl.g:2209:3: ( (lv_key_0_0= RULE_NATURAL ) )
            // InternalMetaDsl.g:2210:4: (lv_key_0_0= RULE_NATURAL )
            {
            // InternalMetaDsl.g:2210:4: (lv_key_0_0= RULE_NATURAL )
            // InternalMetaDsl.g:2211:5: lv_key_0_0= RULE_NATURAL
            {
            lv_key_0_0=(Token)match(input,RULE_NATURAL,FOLLOW_67); 

            					newLeafNode(lv_key_0_0, grammarAccess.getEnuMetadataRowAccess().getKeyNATURALTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnuMetadataRowRule());
            					}
            					setWithLastConsumed(
            						current,
            						"key",
            						lv_key_0_0,
            						"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
            				

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_1());
            		
            // InternalMetaDsl.g:2231:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMetaDsl.g:2232:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMetaDsl.g:2232:4: (lv_name_2_0= RULE_ID )
            // InternalMetaDsl.g:2233:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_67); 

            					newLeafNode(lv_name_2_0, grammarAccess.getEnuMetadataRowAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnuMetadataRowRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,34,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_3());
            		
            // InternalMetaDsl.g:2253:3: ( (lv_description_4_0= RULE_STRING ) )
            // InternalMetaDsl.g:2254:4: (lv_description_4_0= RULE_STRING )
            {
            // InternalMetaDsl.g:2254:4: (lv_description_4_0= RULE_STRING )
            // InternalMetaDsl.g:2255:5: lv_description_4_0= RULE_STRING
            {
            lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_68); 

            					newLeafNode(lv_description_4_0, grammarAccess.getEnuMetadataRowAccess().getDescriptionSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnuMetadataRowRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_4_0,
            						"com.jsantos.metadata.plugin.MetaDsl.STRING");
            				

            }


            }

            // InternalMetaDsl.g:2271:3: (otherlv_5= ',' ( (lv_rowValues_6_0= ruleMetadataRowCell ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==34) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalMetaDsl.g:2272:4: otherlv_5= ',' ( (lv_rowValues_6_0= ruleMetadataRowCell ) )
            	    {
            	    otherlv_5=(Token)match(input,34,FOLLOW_69); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEnuMetadataRowAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMetaDsl.g:2276:4: ( (lv_rowValues_6_0= ruleMetadataRowCell ) )
            	    // InternalMetaDsl.g:2277:5: (lv_rowValues_6_0= ruleMetadataRowCell )
            	    {
            	    // InternalMetaDsl.g:2277:5: (lv_rowValues_6_0= ruleMetadataRowCell )
            	    // InternalMetaDsl.g:2278:6: lv_rowValues_6_0= ruleMetadataRowCell
            	    {

            	    						newCompositeNode(grammarAccess.getEnuMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_68);
            	    lv_rowValues_6_0=ruleMetadataRowCell();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnuMetadataRowRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rowValues",
            	    							lv_rowValues_6_0,
            	    							"com.jsantos.metadata.plugin.MetaDsl.MetadataRowCell");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_7=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEnuMetadataRowAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnuMetadataRow"


    // $ANTLR start "entryRuleMetadata"
    // InternalMetaDsl.g:2304:1: entryRuleMetadata returns [EObject current=null] : iv_ruleMetadata= ruleMetadata EOF ;
    public final EObject entryRuleMetadata() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetadata = null;


        try {
            // InternalMetaDsl.g:2304:49: (iv_ruleMetadata= ruleMetadata EOF )
            // InternalMetaDsl.g:2305:2: iv_ruleMetadata= ruleMetadata EOF
            {
             newCompositeNode(grammarAccess.getMetadataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetadata=ruleMetadata();

            state._fsp--;

             current =iv_ruleMetadata; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetadata"


    // $ANTLR start "ruleMetadata"
    // InternalMetaDsl.g:2311:1: ruleMetadata returns [EObject current=null] : ( ( (lv_name_0_0= 'METADATA' ) ) (otherlv_1= 'FOR' ( ( ruleFQN ) ) )? otherlv_3= '{' ( (lv_metadataRows_4_0= ruleMetadataRow ) )* otherlv_5= '}' ) ;
    public final EObject ruleMetadata() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_metadataRows_4_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2317:2: ( ( ( (lv_name_0_0= 'METADATA' ) ) (otherlv_1= 'FOR' ( ( ruleFQN ) ) )? otherlv_3= '{' ( (lv_metadataRows_4_0= ruleMetadataRow ) )* otherlv_5= '}' ) )
            // InternalMetaDsl.g:2318:2: ( ( (lv_name_0_0= 'METADATA' ) ) (otherlv_1= 'FOR' ( ( ruleFQN ) ) )? otherlv_3= '{' ( (lv_metadataRows_4_0= ruleMetadataRow ) )* otherlv_5= '}' )
            {
            // InternalMetaDsl.g:2318:2: ( ( (lv_name_0_0= 'METADATA' ) ) (otherlv_1= 'FOR' ( ( ruleFQN ) ) )? otherlv_3= '{' ( (lv_metadataRows_4_0= ruleMetadataRow ) )* otherlv_5= '}' )
            // InternalMetaDsl.g:2319:3: ( (lv_name_0_0= 'METADATA' ) ) (otherlv_1= 'FOR' ( ( ruleFQN ) ) )? otherlv_3= '{' ( (lv_metadataRows_4_0= ruleMetadataRow ) )* otherlv_5= '}'
            {
            // InternalMetaDsl.g:2319:3: ( (lv_name_0_0= 'METADATA' ) )
            // InternalMetaDsl.g:2320:4: (lv_name_0_0= 'METADATA' )
            {
            // InternalMetaDsl.g:2320:4: (lv_name_0_0= 'METADATA' )
            // InternalMetaDsl.g:2321:5: lv_name_0_0= 'METADATA'
            {
            lv_name_0_0=(Token)match(input,69,FOLLOW_70); 

            					newLeafNode(lv_name_0_0, grammarAccess.getMetadataAccess().getNameMETADATAKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMetadataRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "METADATA");
            				

            }


            }

            // InternalMetaDsl.g:2333:3: (otherlv_1= 'FOR' ( ( ruleFQN ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==70) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalMetaDsl.g:2334:4: otherlv_1= 'FOR' ( ( ruleFQN ) )
                    {
                    otherlv_1=(Token)match(input,70,FOLLOW_18); 

                    				newLeafNode(otherlv_1, grammarAccess.getMetadataAccess().getFORKeyword_1_0());
                    			
                    // InternalMetaDsl.g:2338:4: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:2339:5: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:2339:5: ( ruleFQN )
                    // InternalMetaDsl.g:2340:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMetadataRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getMetadataAccess().getEntityEntityCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,16,FOLLOW_71); 

            			newLeafNode(otherlv_3, grammarAccess.getMetadataAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMetaDsl.g:2359:3: ( (lv_metadataRows_4_0= ruleMetadataRow ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0>=RULE_STRING && LA64_0<=RULE_NEGATIVEINT)||LA64_0==62||(LA64_0>=71 && LA64_0<=72)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalMetaDsl.g:2360:4: (lv_metadataRows_4_0= ruleMetadataRow )
            	    {
            	    // InternalMetaDsl.g:2360:4: (lv_metadataRows_4_0= ruleMetadataRow )
            	    // InternalMetaDsl.g:2361:5: lv_metadataRows_4_0= ruleMetadataRow
            	    {

            	    					newCompositeNode(grammarAccess.getMetadataAccess().getMetadataRowsMetadataRowParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_71);
            	    lv_metadataRows_4_0=ruleMetadataRow();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMetadataRule());
            	    					}
            	    					add(
            	    						current,
            	    						"metadataRows",
            	    						lv_metadataRows_4_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.MetadataRow");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getMetadataAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetadata"


    // $ANTLR start "entryRuleShortCode"
    // InternalMetaDsl.g:2386:1: entryRuleShortCode returns [EObject current=null] : iv_ruleShortCode= ruleShortCode EOF ;
    public final EObject entryRuleShortCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShortCode = null;


        try {
            // InternalMetaDsl.g:2386:50: (iv_ruleShortCode= ruleShortCode EOF )
            // InternalMetaDsl.g:2387:2: iv_ruleShortCode= ruleShortCode EOF
            {
             newCompositeNode(grammarAccess.getShortCodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleShortCode=ruleShortCode();

            state._fsp--;

             current =iv_ruleShortCode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShortCode"


    // $ANTLR start "ruleShortCode"
    // InternalMetaDsl.g:2393:1: ruleShortCode returns [EObject current=null] : (otherlv_0= 'SHORTCODE' ( (lv_shortCodeValue_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleShortCode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_shortCodeValue_1_0=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:2399:2: ( (otherlv_0= 'SHORTCODE' ( (lv_shortCodeValue_1_0= RULE_STRING ) ) ) )
            // InternalMetaDsl.g:2400:2: (otherlv_0= 'SHORTCODE' ( (lv_shortCodeValue_1_0= RULE_STRING ) ) )
            {
            // InternalMetaDsl.g:2400:2: (otherlv_0= 'SHORTCODE' ( (lv_shortCodeValue_1_0= RULE_STRING ) ) )
            // InternalMetaDsl.g:2401:3: otherlv_0= 'SHORTCODE' ( (lv_shortCodeValue_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getShortCodeAccess().getSHORTCODEKeyword_0());
            		
            // InternalMetaDsl.g:2405:3: ( (lv_shortCodeValue_1_0= RULE_STRING ) )
            // InternalMetaDsl.g:2406:4: (lv_shortCodeValue_1_0= RULE_STRING )
            {
            // InternalMetaDsl.g:2406:4: (lv_shortCodeValue_1_0= RULE_STRING )
            // InternalMetaDsl.g:2407:5: lv_shortCodeValue_1_0= RULE_STRING
            {
            lv_shortCodeValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_shortCodeValue_1_0, grammarAccess.getShortCodeAccess().getShortCodeValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getShortCodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"shortCodeValue",
            						lv_shortCodeValue_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShortCode"


    // $ANTLR start "entryRuleMetadataRow"
    // InternalMetaDsl.g:2427:1: entryRuleMetadataRow returns [EObject current=null] : iv_ruleMetadataRow= ruleMetadataRow EOF ;
    public final EObject entryRuleMetadataRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetadataRow = null;


        try {
            // InternalMetaDsl.g:2427:52: (iv_ruleMetadataRow= ruleMetadataRow EOF )
            // InternalMetaDsl.g:2428:2: iv_ruleMetadataRow= ruleMetadataRow EOF
            {
             newCompositeNode(grammarAccess.getMetadataRowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetadataRow=ruleMetadataRow();

            state._fsp--;

             current =iv_ruleMetadataRow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetadataRow"


    // $ANTLR start "ruleMetadataRow"
    // InternalMetaDsl.g:2434:1: ruleMetadataRow returns [EObject current=null] : ( ( (lv_rowValues_0_0= ruleMetadataRowCell ) ) (otherlv_1= ',' ( (lv_rowValues_2_0= ruleMetadataRowCell ) ) )* otherlv_3= ';' ) ;
    public final EObject ruleMetadataRow() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_rowValues_0_0 = null;

        EObject lv_rowValues_2_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2440:2: ( ( ( (lv_rowValues_0_0= ruleMetadataRowCell ) ) (otherlv_1= ',' ( (lv_rowValues_2_0= ruleMetadataRowCell ) ) )* otherlv_3= ';' ) )
            // InternalMetaDsl.g:2441:2: ( ( (lv_rowValues_0_0= ruleMetadataRowCell ) ) (otherlv_1= ',' ( (lv_rowValues_2_0= ruleMetadataRowCell ) ) )* otherlv_3= ';' )
            {
            // InternalMetaDsl.g:2441:2: ( ( (lv_rowValues_0_0= ruleMetadataRowCell ) ) (otherlv_1= ',' ( (lv_rowValues_2_0= ruleMetadataRowCell ) ) )* otherlv_3= ';' )
            // InternalMetaDsl.g:2442:3: ( (lv_rowValues_0_0= ruleMetadataRowCell ) ) (otherlv_1= ',' ( (lv_rowValues_2_0= ruleMetadataRowCell ) ) )* otherlv_3= ';'
            {
            // InternalMetaDsl.g:2442:3: ( (lv_rowValues_0_0= ruleMetadataRowCell ) )
            // InternalMetaDsl.g:2443:4: (lv_rowValues_0_0= ruleMetadataRowCell )
            {
            // InternalMetaDsl.g:2443:4: (lv_rowValues_0_0= ruleMetadataRowCell )
            // InternalMetaDsl.g:2444:5: lv_rowValues_0_0= ruleMetadataRowCell
            {

            					newCompositeNode(grammarAccess.getMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_68);
            lv_rowValues_0_0=ruleMetadataRowCell();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMetadataRowRule());
            					}
            					add(
            						current,
            						"rowValues",
            						lv_rowValues_0_0,
            						"com.jsantos.metadata.plugin.MetaDsl.MetadataRowCell");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMetaDsl.g:2461:3: (otherlv_1= ',' ( (lv_rowValues_2_0= ruleMetadataRowCell ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==34) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalMetaDsl.g:2462:4: otherlv_1= ',' ( (lv_rowValues_2_0= ruleMetadataRowCell ) )
            	    {
            	    otherlv_1=(Token)match(input,34,FOLLOW_69); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMetadataRowAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMetaDsl.g:2466:4: ( (lv_rowValues_2_0= ruleMetadataRowCell ) )
            	    // InternalMetaDsl.g:2467:5: (lv_rowValues_2_0= ruleMetadataRowCell )
            	    {
            	    // InternalMetaDsl.g:2467:5: (lv_rowValues_2_0= ruleMetadataRowCell )
            	    // InternalMetaDsl.g:2468:6: lv_rowValues_2_0= ruleMetadataRowCell
            	    {

            	    						newCompositeNode(grammarAccess.getMetadataRowAccess().getRowValuesMetadataRowCellParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_68);
            	    lv_rowValues_2_0=ruleMetadataRowCell();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMetadataRowRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rowValues",
            	    							lv_rowValues_2_0,
            	    							"com.jsantos.metadata.plugin.MetaDsl.MetadataRowCell");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMetadataRowAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetadataRow"


    // $ANTLR start "entryRuleMetadataRowCell"
    // InternalMetaDsl.g:2494:1: entryRuleMetadataRowCell returns [EObject current=null] : iv_ruleMetadataRowCell= ruleMetadataRowCell EOF ;
    public final EObject entryRuleMetadataRowCell() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetadataRowCell = null;


        try {
            // InternalMetaDsl.g:2494:56: (iv_ruleMetadataRowCell= ruleMetadataRowCell EOF )
            // InternalMetaDsl.g:2495:2: iv_ruleMetadataRowCell= ruleMetadataRowCell EOF
            {
             newCompositeNode(grammarAccess.getMetadataRowCellRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetadataRowCell=ruleMetadataRowCell();

            state._fsp--;

             current =iv_ruleMetadataRowCell; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetadataRowCell"


    // $ANTLR start "ruleMetadataRowCell"
    // InternalMetaDsl.g:2501:1: ruleMetadataRowCell returns [EObject current=null] : ( ( ( (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT ) ) ) | ( (lv_shortCode_1_0= ruleShortCode ) ) | ( (lv_isNull_2_0= 'NULL' ) ) | ( (lv_isDefault_3_0= 'DEFAULT' ) ) ) ;
    public final EObject ruleMetadataRowCell() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_1=null;
        Token lv_stringValue_0_2=null;
        Token lv_stringValue_0_3=null;
        Token lv_stringValue_0_4=null;
        Token lv_isNull_2_0=null;
        Token lv_isDefault_3_0=null;
        EObject lv_shortCode_1_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2507:2: ( ( ( ( (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT ) ) ) | ( (lv_shortCode_1_0= ruleShortCode ) ) | ( (lv_isNull_2_0= 'NULL' ) ) | ( (lv_isDefault_3_0= 'DEFAULT' ) ) ) )
            // InternalMetaDsl.g:2508:2: ( ( ( (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT ) ) ) | ( (lv_shortCode_1_0= ruleShortCode ) ) | ( (lv_isNull_2_0= 'NULL' ) ) | ( (lv_isDefault_3_0= 'DEFAULT' ) ) )
            {
            // InternalMetaDsl.g:2508:2: ( ( ( (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT ) ) ) | ( (lv_shortCode_1_0= ruleShortCode ) ) | ( (lv_isNull_2_0= 'NULL' ) ) | ( (lv_isDefault_3_0= 'DEFAULT' ) ) )
            int alt67=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_NATURAL:
            case RULE_DOUBLE:
            case RULE_NEGATIVEINT:
                {
                alt67=1;
                }
                break;
            case 71:
                {
                alt67=2;
                }
                break;
            case 72:
                {
                alt67=3;
                }
                break;
            case 62:
                {
                alt67=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalMetaDsl.g:2509:3: ( ( (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT ) ) )
                    {
                    // InternalMetaDsl.g:2509:3: ( ( (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT ) ) )
                    // InternalMetaDsl.g:2510:4: ( (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT ) )
                    {
                    // InternalMetaDsl.g:2510:4: ( (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT ) )
                    // InternalMetaDsl.g:2511:5: (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT )
                    {
                    // InternalMetaDsl.g:2511:5: (lv_stringValue_0_1= RULE_STRING | lv_stringValue_0_2= RULE_DOUBLE | lv_stringValue_0_3= RULE_NATURAL | lv_stringValue_0_4= RULE_NEGATIVEINT )
                    int alt66=4;
                    switch ( input.LA(1) ) {
                    case RULE_STRING:
                        {
                        alt66=1;
                        }
                        break;
                    case RULE_DOUBLE:
                        {
                        alt66=2;
                        }
                        break;
                    case RULE_NATURAL:
                        {
                        alt66=3;
                        }
                        break;
                    case RULE_NEGATIVEINT:
                        {
                        alt66=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 66, 0, input);

                        throw nvae;
                    }

                    switch (alt66) {
                        case 1 :
                            // InternalMetaDsl.g:2512:6: lv_stringValue_0_1= RULE_STRING
                            {
                            lv_stringValue_0_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                            						newLeafNode(lv_stringValue_0_1, grammarAccess.getMetadataRowCellAccess().getStringValueSTRINGTerminalRuleCall_0_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getMetadataRowCellRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"stringValue",
                            							lv_stringValue_0_1,
                            							"com.jsantos.metadata.plugin.MetaDsl.STRING");
                            					

                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:2527:6: lv_stringValue_0_2= RULE_DOUBLE
                            {
                            lv_stringValue_0_2=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                            						newLeafNode(lv_stringValue_0_2, grammarAccess.getMetadataRowCellAccess().getStringValueDOUBLETerminalRuleCall_0_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getMetadataRowCellRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"stringValue",
                            							lv_stringValue_0_2,
                            							"com.jsantos.metadata.plugin.MetaDsl.DOUBLE");
                            					

                            }
                            break;
                        case 3 :
                            // InternalMetaDsl.g:2542:6: lv_stringValue_0_3= RULE_NATURAL
                            {
                            lv_stringValue_0_3=(Token)match(input,RULE_NATURAL,FOLLOW_2); 

                            						newLeafNode(lv_stringValue_0_3, grammarAccess.getMetadataRowCellAccess().getStringValueNATURALTerminalRuleCall_0_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getMetadataRowCellRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"stringValue",
                            							lv_stringValue_0_3,
                            							"com.jsantos.metadata.plugin.MetaDsl.NATURAL");
                            					

                            }
                            break;
                        case 4 :
                            // InternalMetaDsl.g:2557:6: lv_stringValue_0_4= RULE_NEGATIVEINT
                            {
                            lv_stringValue_0_4=(Token)match(input,RULE_NEGATIVEINT,FOLLOW_2); 

                            						newLeafNode(lv_stringValue_0_4, grammarAccess.getMetadataRowCellAccess().getStringValueNEGATIVEINTTerminalRuleCall_0_0_3());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getMetadataRowCellRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"stringValue",
                            							lv_stringValue_0_4,
                            							"com.jsantos.metadata.plugin.MetaDsl.NEGATIVEINT");
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:2575:3: ( (lv_shortCode_1_0= ruleShortCode ) )
                    {
                    // InternalMetaDsl.g:2575:3: ( (lv_shortCode_1_0= ruleShortCode ) )
                    // InternalMetaDsl.g:2576:4: (lv_shortCode_1_0= ruleShortCode )
                    {
                    // InternalMetaDsl.g:2576:4: (lv_shortCode_1_0= ruleShortCode )
                    // InternalMetaDsl.g:2577:5: lv_shortCode_1_0= ruleShortCode
                    {

                    					newCompositeNode(grammarAccess.getMetadataRowCellAccess().getShortCodeShortCodeParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_shortCode_1_0=ruleShortCode();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMetadataRowCellRule());
                    					}
                    					set(
                    						current,
                    						"shortCode",
                    						lv_shortCode_1_0,
                    						"com.jsantos.metadata.plugin.MetaDsl.ShortCode");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:2595:3: ( (lv_isNull_2_0= 'NULL' ) )
                    {
                    // InternalMetaDsl.g:2595:3: ( (lv_isNull_2_0= 'NULL' ) )
                    // InternalMetaDsl.g:2596:4: (lv_isNull_2_0= 'NULL' )
                    {
                    // InternalMetaDsl.g:2596:4: (lv_isNull_2_0= 'NULL' )
                    // InternalMetaDsl.g:2597:5: lv_isNull_2_0= 'NULL'
                    {
                    lv_isNull_2_0=(Token)match(input,72,FOLLOW_2); 

                    					newLeafNode(lv_isNull_2_0, grammarAccess.getMetadataRowCellAccess().getIsNullNULLKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetadataRowCellRule());
                    					}
                    					setWithLastConsumed(current, "isNull", true, "NULL");
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMetaDsl.g:2610:3: ( (lv_isDefault_3_0= 'DEFAULT' ) )
                    {
                    // InternalMetaDsl.g:2610:3: ( (lv_isDefault_3_0= 'DEFAULT' ) )
                    // InternalMetaDsl.g:2611:4: (lv_isDefault_3_0= 'DEFAULT' )
                    {
                    // InternalMetaDsl.g:2611:4: (lv_isDefault_3_0= 'DEFAULT' )
                    // InternalMetaDsl.g:2612:5: lv_isDefault_3_0= 'DEFAULT'
                    {
                    lv_isDefault_3_0=(Token)match(input,62,FOLLOW_2); 

                    					newLeafNode(lv_isDefault_3_0, grammarAccess.getMetadataRowCellAccess().getIsDefaultDEFAULTKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetadataRowCellRule());
                    					}
                    					setWithLastConsumed(current, "isDefault", true, "DEFAULT");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetadataRowCell"


    // $ANTLR start "entryRuleLabelSection"
    // InternalMetaDsl.g:2628:1: entryRuleLabelSection returns [EObject current=null] : iv_ruleLabelSection= ruleLabelSection EOF ;
    public final EObject entryRuleLabelSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabelSection = null;


        try {
            // InternalMetaDsl.g:2628:53: (iv_ruleLabelSection= ruleLabelSection EOF )
            // InternalMetaDsl.g:2629:2: iv_ruleLabelSection= ruleLabelSection EOF
            {
             newCompositeNode(grammarAccess.getLabelSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLabelSection=ruleLabelSection();

            state._fsp--;

             current =iv_ruleLabelSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLabelSection"


    // $ANTLR start "ruleLabelSection"
    // InternalMetaDsl.g:2635:1: ruleLabelSection returns [EObject current=null] : ( ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_labels_2_0= ruleLabelBlock ) )+ otherlv_3= '}' ) ;
    public final EObject ruleLabelSection() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_labels_2_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2641:2: ( ( ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_labels_2_0= ruleLabelBlock ) )+ otherlv_3= '}' ) )
            // InternalMetaDsl.g:2642:2: ( ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_labels_2_0= ruleLabelBlock ) )+ otherlv_3= '}' )
            {
            // InternalMetaDsl.g:2642:2: ( ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_labels_2_0= ruleLabelBlock ) )+ otherlv_3= '}' )
            // InternalMetaDsl.g:2643:3: ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_labels_2_0= ruleLabelBlock ) )+ otherlv_3= '}'
            {
            // InternalMetaDsl.g:2643:3: ( (lv_name_0_0= 'LABELS' ) )
            // InternalMetaDsl.g:2644:4: (lv_name_0_0= 'LABELS' )
            {
            // InternalMetaDsl.g:2644:4: (lv_name_0_0= 'LABELS' )
            // InternalMetaDsl.g:2645:5: lv_name_0_0= 'LABELS'
            {
            lv_name_0_0=(Token)match(input,73,FOLLOW_8); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLabelSectionAccess().getNameLABELSKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLabelSectionRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "LABELS");
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_72); 

            			newLeafNode(otherlv_1, grammarAccess.getLabelSectionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMetaDsl.g:2661:3: ( (lv_labels_2_0= ruleLabelBlock ) )+
            int cnt68=0;
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_ID||LA68_0==44) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalMetaDsl.g:2662:4: (lv_labels_2_0= ruleLabelBlock )
            	    {
            	    // InternalMetaDsl.g:2662:4: (lv_labels_2_0= ruleLabelBlock )
            	    // InternalMetaDsl.g:2663:5: lv_labels_2_0= ruleLabelBlock
            	    {

            	    					newCompositeNode(grammarAccess.getLabelSectionAccess().getLabelsLabelBlockParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_73);
            	    lv_labels_2_0=ruleLabelBlock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLabelSectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"labels",
            	    						lv_labels_2_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.LabelBlock");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt68 >= 1 ) break loop68;
                        EarlyExitException eee =
                            new EarlyExitException(68, input);
                        throw eee;
                }
                cnt68++;
            } while (true);

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getLabelSectionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLabelSection"


    // $ANTLR start "entryRuleLabelBlock"
    // InternalMetaDsl.g:2688:1: entryRuleLabelBlock returns [EObject current=null] : iv_ruleLabelBlock= ruleLabelBlock EOF ;
    public final EObject entryRuleLabelBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabelBlock = null;


        try {
            // InternalMetaDsl.g:2688:51: (iv_ruleLabelBlock= ruleLabelBlock EOF )
            // InternalMetaDsl.g:2689:2: iv_ruleLabelBlock= ruleLabelBlock EOF
            {
             newCompositeNode(grammarAccess.getLabelBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLabelBlock=ruleLabelBlock();

            state._fsp--;

             current =iv_ruleLabelBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLabelBlock"


    // $ANTLR start "ruleLabelBlock"
    // InternalMetaDsl.g:2695:1: ruleLabelBlock returns [EObject current=null] : ( () ( ( (lv_entity_1_0= 'ENTITY' ) ) | ( ( ruleFQN ) ) ) otherlv_3= '{' ( ( (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' ) ) )? ( (lv_labels_5_0= ruleLabel ) )* otherlv_6= '}' ) ;
    public final EObject ruleLabelBlock() throws RecognitionException {
        EObject current = null;

        Token lv_entity_1_0=null;
        Token otherlv_3=null;
        Token lv_type_4_1=null;
        Token lv_type_4_2=null;
        Token otherlv_6=null;
        EObject lv_labels_5_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2701:2: ( ( () ( ( (lv_entity_1_0= 'ENTITY' ) ) | ( ( ruleFQN ) ) ) otherlv_3= '{' ( ( (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' ) ) )? ( (lv_labels_5_0= ruleLabel ) )* otherlv_6= '}' ) )
            // InternalMetaDsl.g:2702:2: ( () ( ( (lv_entity_1_0= 'ENTITY' ) ) | ( ( ruleFQN ) ) ) otherlv_3= '{' ( ( (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' ) ) )? ( (lv_labels_5_0= ruleLabel ) )* otherlv_6= '}' )
            {
            // InternalMetaDsl.g:2702:2: ( () ( ( (lv_entity_1_0= 'ENTITY' ) ) | ( ( ruleFQN ) ) ) otherlv_3= '{' ( ( (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' ) ) )? ( (lv_labels_5_0= ruleLabel ) )* otherlv_6= '}' )
            // InternalMetaDsl.g:2703:3: () ( ( (lv_entity_1_0= 'ENTITY' ) ) | ( ( ruleFQN ) ) ) otherlv_3= '{' ( ( (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' ) ) )? ( (lv_labels_5_0= ruleLabel ) )* otherlv_6= '}'
            {
            // InternalMetaDsl.g:2703:3: ()
            // InternalMetaDsl.g:2704:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLabelBlockAccess().getLabelBlockAction_0(),
            					current);
            			

            }

            // InternalMetaDsl.g:2710:3: ( ( (lv_entity_1_0= 'ENTITY' ) ) | ( ( ruleFQN ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==44) ) {
                alt69=1;
            }
            else if ( (LA69_0==RULE_ID) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalMetaDsl.g:2711:4: ( (lv_entity_1_0= 'ENTITY' ) )
                    {
                    // InternalMetaDsl.g:2711:4: ( (lv_entity_1_0= 'ENTITY' ) )
                    // InternalMetaDsl.g:2712:5: (lv_entity_1_0= 'ENTITY' )
                    {
                    // InternalMetaDsl.g:2712:5: (lv_entity_1_0= 'ENTITY' )
                    // InternalMetaDsl.g:2713:6: lv_entity_1_0= 'ENTITY'
                    {
                    lv_entity_1_0=(Token)match(input,44,FOLLOW_8); 

                    						newLeafNode(lv_entity_1_0, grammarAccess.getLabelBlockAccess().getEntityENTITYKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLabelBlockRule());
                    						}
                    						setWithLastConsumed(current, "entity", true, "ENTITY");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:2726:4: ( ( ruleFQN ) )
                    {
                    // InternalMetaDsl.g:2726:4: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:2727:5: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:2727:5: ( ruleFQN )
                    // InternalMetaDsl.g:2728:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLabelBlockRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getLabelBlockAccess().getAttributeAttributeCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,16,FOLLOW_74); 

            			newLeafNode(otherlv_3, grammarAccess.getLabelBlockAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMetaDsl.g:2747:3: ( ( (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=74 && LA71_0<=75)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalMetaDsl.g:2748:4: ( (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' ) )
                    {
                    // InternalMetaDsl.g:2748:4: ( (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' ) )
                    // InternalMetaDsl.g:2749:5: (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' )
                    {
                    // InternalMetaDsl.g:2749:5: (lv_type_4_1= 'SHORTLABEL' | lv_type_4_2= 'LONGLABEL' )
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==74) ) {
                        alt70=1;
                    }
                    else if ( (LA70_0==75) ) {
                        alt70=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }
                    switch (alt70) {
                        case 1 :
                            // InternalMetaDsl.g:2750:6: lv_type_4_1= 'SHORTLABEL'
                            {
                            lv_type_4_1=(Token)match(input,74,FOLLOW_75); 

                            						newLeafNode(lv_type_4_1, grammarAccess.getLabelBlockAccess().getTypeSHORTLABELKeyword_3_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getLabelBlockRule());
                            						}
                            						setWithLastConsumed(current, "type", lv_type_4_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:2761:6: lv_type_4_2= 'LONGLABEL'
                            {
                            lv_type_4_2=(Token)match(input,75,FOLLOW_75); 

                            						newLeafNode(lv_type_4_2, grammarAccess.getLabelBlockAccess().getTypeLONGLABELKeyword_3_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getLabelBlockRule());
                            						}
                            						setWithLastConsumed(current, "type", lv_type_4_2, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:2774:3: ( (lv_labels_5_0= ruleLabel ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0>=RULE_ID && LA72_0<=RULE_STRING)) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalMetaDsl.g:2775:4: (lv_labels_5_0= ruleLabel )
            	    {
            	    // InternalMetaDsl.g:2775:4: (lv_labels_5_0= ruleLabel )
            	    // InternalMetaDsl.g:2776:5: lv_labels_5_0= ruleLabel
            	    {

            	    					newCompositeNode(grammarAccess.getLabelBlockAccess().getLabelsLabelParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_75);
            	    lv_labels_5_0=ruleLabel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLabelBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"labels",
            	    						lv_labels_5_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Label");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            otherlv_6=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getLabelBlockAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLabelBlock"


    // $ANTLR start "entryRuleGeneralLabelSection"
    // InternalMetaDsl.g:2801:1: entryRuleGeneralLabelSection returns [EObject current=null] : iv_ruleGeneralLabelSection= ruleGeneralLabelSection EOF ;
    public final EObject entryRuleGeneralLabelSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralLabelSection = null;


        try {
            // InternalMetaDsl.g:2801:60: (iv_ruleGeneralLabelSection= ruleGeneralLabelSection EOF )
            // InternalMetaDsl.g:2802:2: iv_ruleGeneralLabelSection= ruleGeneralLabelSection EOF
            {
             newCompositeNode(grammarAccess.getGeneralLabelSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneralLabelSection=ruleGeneralLabelSection();

            state._fsp--;

             current =iv_ruleGeneralLabelSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneralLabelSection"


    // $ANTLR start "ruleGeneralLabelSection"
    // InternalMetaDsl.g:2808:1: ruleGeneralLabelSection returns [EObject current=null] : ( ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_keyLabel_2_0= ruleKeyLabel ) )* ( (lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock ) )* otherlv_4= '}' ) ;
    public final EObject ruleGeneralLabelSection() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_keyLabel_2_0 = null;

        EObject lv_overrideLabelBlock_3_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2814:2: ( ( ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_keyLabel_2_0= ruleKeyLabel ) )* ( (lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock ) )* otherlv_4= '}' ) )
            // InternalMetaDsl.g:2815:2: ( ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_keyLabel_2_0= ruleKeyLabel ) )* ( (lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock ) )* otherlv_4= '}' )
            {
            // InternalMetaDsl.g:2815:2: ( ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_keyLabel_2_0= ruleKeyLabel ) )* ( (lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock ) )* otherlv_4= '}' )
            // InternalMetaDsl.g:2816:3: ( (lv_name_0_0= 'LABELS' ) ) otherlv_1= '{' ( (lv_keyLabel_2_0= ruleKeyLabel ) )* ( (lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock ) )* otherlv_4= '}'
            {
            // InternalMetaDsl.g:2816:3: ( (lv_name_0_0= 'LABELS' ) )
            // InternalMetaDsl.g:2817:4: (lv_name_0_0= 'LABELS' )
            {
            // InternalMetaDsl.g:2817:4: (lv_name_0_0= 'LABELS' )
            // InternalMetaDsl.g:2818:5: lv_name_0_0= 'LABELS'
            {
            lv_name_0_0=(Token)match(input,73,FOLLOW_8); 

            					newLeafNode(lv_name_0_0, grammarAccess.getGeneralLabelSectionAccess().getNameLABELSKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneralLabelSectionRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "LABELS");
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_76); 

            			newLeafNode(otherlv_1, grammarAccess.getGeneralLabelSectionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMetaDsl.g:2834:3: ( (lv_keyLabel_2_0= ruleKeyLabel ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==76) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalMetaDsl.g:2835:4: (lv_keyLabel_2_0= ruleKeyLabel )
            	    {
            	    // InternalMetaDsl.g:2835:4: (lv_keyLabel_2_0= ruleKeyLabel )
            	    // InternalMetaDsl.g:2836:5: lv_keyLabel_2_0= ruleKeyLabel
            	    {

            	    					newCompositeNode(grammarAccess.getGeneralLabelSectionAccess().getKeyLabelKeyLabelParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_76);
            	    lv_keyLabel_2_0=ruleKeyLabel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGeneralLabelSectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"keyLabel",
            	    						lv_keyLabel_2_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.KeyLabel");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            // InternalMetaDsl.g:2853:3: ( (lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==44||(LA74_0>=77 && LA74_0<=78)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalMetaDsl.g:2854:4: (lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock )
            	    {
            	    // InternalMetaDsl.g:2854:4: (lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock )
            	    // InternalMetaDsl.g:2855:5: lv_overrideLabelBlock_3_0= ruleOverrideLabelBlock
            	    {

            	    					newCompositeNode(grammarAccess.getGeneralLabelSectionAccess().getOverrideLabelBlockOverrideLabelBlockParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_77);
            	    lv_overrideLabelBlock_3_0=ruleOverrideLabelBlock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGeneralLabelSectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"overrideLabelBlock",
            	    						lv_overrideLabelBlock_3_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.OverrideLabelBlock");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGeneralLabelSectionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneralLabelSection"


    // $ANTLR start "entryRuleKeyLabel"
    // InternalMetaDsl.g:2880:1: entryRuleKeyLabel returns [EObject current=null] : iv_ruleKeyLabel= ruleKeyLabel EOF ;
    public final EObject entryRuleKeyLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyLabel = null;


        try {
            // InternalMetaDsl.g:2880:49: (iv_ruleKeyLabel= ruleKeyLabel EOF )
            // InternalMetaDsl.g:2881:2: iv_ruleKeyLabel= ruleKeyLabel EOF
            {
             newCompositeNode(grammarAccess.getKeyLabelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeyLabel=ruleKeyLabel();

            state._fsp--;

             current =iv_ruleKeyLabel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyLabel"


    // $ANTLR start "ruleKeyLabel"
    // InternalMetaDsl.g:2887:1: ruleKeyLabel returns [EObject current=null] : (otherlv_0= 'KEY' ( (lv_key_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}' ) ;
    public final EObject ruleKeyLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        EObject lv_labels_3_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2893:2: ( (otherlv_0= 'KEY' ( (lv_key_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}' ) )
            // InternalMetaDsl.g:2894:2: (otherlv_0= 'KEY' ( (lv_key_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}' )
            {
            // InternalMetaDsl.g:2894:2: (otherlv_0= 'KEY' ( (lv_key_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}' )
            // InternalMetaDsl.g:2895:3: otherlv_0= 'KEY' ( (lv_key_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getKeyLabelAccess().getKEYKeyword_0());
            		
            // InternalMetaDsl.g:2899:3: ( (lv_key_1_0= ruleFQN ) )
            // InternalMetaDsl.g:2900:4: (lv_key_1_0= ruleFQN )
            {
            // InternalMetaDsl.g:2900:4: (lv_key_1_0= ruleFQN )
            // InternalMetaDsl.g:2901:5: lv_key_1_0= ruleFQN
            {

            					newCompositeNode(grammarAccess.getKeyLabelAccess().getKeyFQNParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
            lv_key_1_0=ruleFQN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getKeyLabelRule());
            					}
            					set(
            						current,
            						"key",
            						lv_key_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.FQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_75); 

            			newLeafNode(otherlv_2, grammarAccess.getKeyLabelAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMetaDsl.g:2922:3: ( (lv_labels_3_0= ruleLabel ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( ((LA75_0>=RULE_ID && LA75_0<=RULE_STRING)) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalMetaDsl.g:2923:4: (lv_labels_3_0= ruleLabel )
            	    {
            	    // InternalMetaDsl.g:2923:4: (lv_labels_3_0= ruleLabel )
            	    // InternalMetaDsl.g:2924:5: lv_labels_3_0= ruleLabel
            	    {

            	    					newCompositeNode(grammarAccess.getKeyLabelAccess().getLabelsLabelParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_75);
            	    lv_labels_3_0=ruleLabel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getKeyLabelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"labels",
            	    						lv_labels_3_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Label");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getKeyLabelAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyLabel"


    // $ANTLR start "entryRuleOverrideLabelBlock"
    // InternalMetaDsl.g:2949:1: entryRuleOverrideLabelBlock returns [EObject current=null] : iv_ruleOverrideLabelBlock= ruleOverrideLabelBlock EOF ;
    public final EObject entryRuleOverrideLabelBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverrideLabelBlock = null;


        try {
            // InternalMetaDsl.g:2949:59: (iv_ruleOverrideLabelBlock= ruleOverrideLabelBlock EOF )
            // InternalMetaDsl.g:2950:2: iv_ruleOverrideLabelBlock= ruleOverrideLabelBlock EOF
            {
             newCompositeNode(grammarAccess.getOverrideLabelBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOverrideLabelBlock=ruleOverrideLabelBlock();

            state._fsp--;

             current =iv_ruleOverrideLabelBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOverrideLabelBlock"


    // $ANTLR start "ruleOverrideLabelBlock"
    // InternalMetaDsl.g:2956:1: ruleOverrideLabelBlock returns [EObject current=null] : ( () ( (otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) ) ) | (otherlv_3= 'ENTITY' ( ( ruleFQN ) ) ) | (otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) ) ) ) otherlv_7= '{' ( ( (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' ) ) )? ( (lv_labels_9_0= ruleLabel ) )* otherlv_10= '}' ) ;
    public final EObject ruleOverrideLabelBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_type_8_1=null;
        Token lv_type_8_2=null;
        Token otherlv_10=null;
        EObject lv_labels_9_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:2962:2: ( ( () ( (otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) ) ) | (otherlv_3= 'ENTITY' ( ( ruleFQN ) ) ) | (otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) ) ) ) otherlv_7= '{' ( ( (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' ) ) )? ( (lv_labels_9_0= ruleLabel ) )* otherlv_10= '}' ) )
            // InternalMetaDsl.g:2963:2: ( () ( (otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) ) ) | (otherlv_3= 'ENTITY' ( ( ruleFQN ) ) ) | (otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) ) ) ) otherlv_7= '{' ( ( (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' ) ) )? ( (lv_labels_9_0= ruleLabel ) )* otherlv_10= '}' )
            {
            // InternalMetaDsl.g:2963:2: ( () ( (otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) ) ) | (otherlv_3= 'ENTITY' ( ( ruleFQN ) ) ) | (otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) ) ) ) otherlv_7= '{' ( ( (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' ) ) )? ( (lv_labels_9_0= ruleLabel ) )* otherlv_10= '}' )
            // InternalMetaDsl.g:2964:3: () ( (otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) ) ) | (otherlv_3= 'ENTITY' ( ( ruleFQN ) ) ) | (otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) ) ) ) otherlv_7= '{' ( ( (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' ) ) )? ( (lv_labels_9_0= ruleLabel ) )* otherlv_10= '}'
            {
            // InternalMetaDsl.g:2964:3: ()
            // InternalMetaDsl.g:2965:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOverrideLabelBlockAccess().getOverrideLabelBlockAction_0(),
            					current);
            			

            }

            // InternalMetaDsl.g:2971:3: ( (otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) ) ) | (otherlv_3= 'ENTITY' ( ( ruleFQN ) ) ) | (otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) ) ) )
            int alt76=3;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt76=1;
                }
                break;
            case 44:
                {
                alt76=2;
                }
                break;
            case 78:
                {
                alt76=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // InternalMetaDsl.g:2972:4: (otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) ) )
                    {
                    // InternalMetaDsl.g:2972:4: (otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) ) )
                    // InternalMetaDsl.g:2973:5: otherlv_1= 'ATTRIBUTE' ( ( ruleFQN ) )
                    {
                    otherlv_1=(Token)match(input,77,FOLLOW_18); 

                    					newLeafNode(otherlv_1, grammarAccess.getOverrideLabelBlockAccess().getATTRIBUTEKeyword_1_0_0());
                    				
                    // InternalMetaDsl.g:2977:5: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:2978:6: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:2978:6: ( ruleFQN )
                    // InternalMetaDsl.g:2979:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOverrideLabelBlockRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getOverrideLabelBlockAccess().getAttributeAttributeCrossReference_1_0_1_0());
                    						
                    pushFollow(FOLLOW_8);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:2995:4: (otherlv_3= 'ENTITY' ( ( ruleFQN ) ) )
                    {
                    // InternalMetaDsl.g:2995:4: (otherlv_3= 'ENTITY' ( ( ruleFQN ) ) )
                    // InternalMetaDsl.g:2996:5: otherlv_3= 'ENTITY' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,44,FOLLOW_18); 

                    					newLeafNode(otherlv_3, grammarAccess.getOverrideLabelBlockAccess().getENTITYKeyword_1_1_0());
                    				
                    // InternalMetaDsl.g:3000:5: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:3001:6: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:3001:6: ( ruleFQN )
                    // InternalMetaDsl.g:3002:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOverrideLabelBlockRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getOverrideLabelBlockAccess().getEntityEntityCrossReference_1_1_1_0());
                    						
                    pushFollow(FOLLOW_8);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:3018:4: (otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) ) )
                    {
                    // InternalMetaDsl.g:3018:4: (otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) ) )
                    // InternalMetaDsl.g:3019:5: otherlv_5= 'ENUMERATIONITEM' ( ( ruleFQN ) )
                    {
                    otherlv_5=(Token)match(input,78,FOLLOW_18); 

                    					newLeafNode(otherlv_5, grammarAccess.getOverrideLabelBlockAccess().getENUMERATIONITEMKeyword_1_2_0());
                    				
                    // InternalMetaDsl.g:3023:5: ( ( ruleFQN ) )
                    // InternalMetaDsl.g:3024:6: ( ruleFQN )
                    {
                    // InternalMetaDsl.g:3024:6: ( ruleFQN )
                    // InternalMetaDsl.g:3025:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOverrideLabelBlockRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getOverrideLabelBlockAccess().getEnuMetadataRowEnuMetadataRowCrossReference_1_2_1_0());
                    						
                    pushFollow(FOLLOW_8);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_74); 

            			newLeafNode(otherlv_7, grammarAccess.getOverrideLabelBlockAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMetaDsl.g:3045:3: ( ( (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=74 && LA78_0<=75)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalMetaDsl.g:3046:4: ( (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' ) )
                    {
                    // InternalMetaDsl.g:3046:4: ( (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' ) )
                    // InternalMetaDsl.g:3047:5: (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' )
                    {
                    // InternalMetaDsl.g:3047:5: (lv_type_8_1= 'SHORTLABEL' | lv_type_8_2= 'LONGLABEL' )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==74) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==75) ) {
                        alt77=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalMetaDsl.g:3048:6: lv_type_8_1= 'SHORTLABEL'
                            {
                            lv_type_8_1=(Token)match(input,74,FOLLOW_75); 

                            						newLeafNode(lv_type_8_1, grammarAccess.getOverrideLabelBlockAccess().getTypeSHORTLABELKeyword_3_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getOverrideLabelBlockRule());
                            						}
                            						setWithLastConsumed(current, "type", lv_type_8_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:3059:6: lv_type_8_2= 'LONGLABEL'
                            {
                            lv_type_8_2=(Token)match(input,75,FOLLOW_75); 

                            						newLeafNode(lv_type_8_2, grammarAccess.getOverrideLabelBlockAccess().getTypeLONGLABELKeyword_3_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getOverrideLabelBlockRule());
                            						}
                            						setWithLastConsumed(current, "type", lv_type_8_2, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:3072:3: ( (lv_labels_9_0= ruleLabel ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( ((LA79_0>=RULE_ID && LA79_0<=RULE_STRING)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalMetaDsl.g:3073:4: (lv_labels_9_0= ruleLabel )
            	    {
            	    // InternalMetaDsl.g:3073:4: (lv_labels_9_0= ruleLabel )
            	    // InternalMetaDsl.g:3074:5: lv_labels_9_0= ruleLabel
            	    {

            	    					newCompositeNode(grammarAccess.getOverrideLabelBlockAccess().getLabelsLabelParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_75);
            	    lv_labels_9_0=ruleLabel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOverrideLabelBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"labels",
            	    						lv_labels_9_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Label");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

            otherlv_10=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getOverrideLabelBlockAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOverrideLabelBlock"


    // $ANTLR start "entryRuleEnumerationLabels"
    // InternalMetaDsl.g:3099:1: entryRuleEnumerationLabels returns [EObject current=null] : iv_ruleEnumerationLabels= ruleEnumerationLabels EOF ;
    public final EObject entryRuleEnumerationLabels() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLabels = null;


        try {
            // InternalMetaDsl.g:3099:58: (iv_ruleEnumerationLabels= ruleEnumerationLabels EOF )
            // InternalMetaDsl.g:3100:2: iv_ruleEnumerationLabels= ruleEnumerationLabels EOF
            {
             newCompositeNode(grammarAccess.getEnumerationLabelsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumerationLabels=ruleEnumerationLabels();

            state._fsp--;

             current =iv_ruleEnumerationLabels; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationLabels"


    // $ANTLR start "ruleEnumerationLabels"
    // InternalMetaDsl.g:3106:1: ruleEnumerationLabels returns [EObject current=null] : (otherlv_0= 'ENULABELS' otherlv_1= '{' ( (lv_enumerationLabel_2_0= ruleEnumerationLabel ) )* otherlv_3= '}' ) ;
    public final EObject ruleEnumerationLabels() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_enumerationLabel_2_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:3112:2: ( (otherlv_0= 'ENULABELS' otherlv_1= '{' ( (lv_enumerationLabel_2_0= ruleEnumerationLabel ) )* otherlv_3= '}' ) )
            // InternalMetaDsl.g:3113:2: (otherlv_0= 'ENULABELS' otherlv_1= '{' ( (lv_enumerationLabel_2_0= ruleEnumerationLabel ) )* otherlv_3= '}' )
            {
            // InternalMetaDsl.g:3113:2: (otherlv_0= 'ENULABELS' otherlv_1= '{' ( (lv_enumerationLabel_2_0= ruleEnumerationLabel ) )* otherlv_3= '}' )
            // InternalMetaDsl.g:3114:3: otherlv_0= 'ENULABELS' otherlv_1= '{' ( (lv_enumerationLabel_2_0= ruleEnumerationLabel ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,79,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationLabelsAccess().getENULABELSKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_78); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumerationLabelsAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMetaDsl.g:3122:3: ( (lv_enumerationLabel_2_0= ruleEnumerationLabel ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==RULE_ID) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalMetaDsl.g:3123:4: (lv_enumerationLabel_2_0= ruleEnumerationLabel )
            	    {
            	    // InternalMetaDsl.g:3123:4: (lv_enumerationLabel_2_0= ruleEnumerationLabel )
            	    // InternalMetaDsl.g:3124:5: lv_enumerationLabel_2_0= ruleEnumerationLabel
            	    {

            	    					newCompositeNode(grammarAccess.getEnumerationLabelsAccess().getEnumerationLabelEnumerationLabelParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_78);
            	    lv_enumerationLabel_2_0=ruleEnumerationLabel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEnumerationLabelsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"enumerationLabel",
            	    						lv_enumerationLabel_2_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.EnumerationLabel");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getEnumerationLabelsAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationLabels"


    // $ANTLR start "entryRuleEnumerationLabel"
    // InternalMetaDsl.g:3149:1: entryRuleEnumerationLabel returns [EObject current=null] : iv_ruleEnumerationLabel= ruleEnumerationLabel EOF ;
    public final EObject entryRuleEnumerationLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLabel = null;


        try {
            // InternalMetaDsl.g:3149:57: (iv_ruleEnumerationLabel= ruleEnumerationLabel EOF )
            // InternalMetaDsl.g:3150:2: iv_ruleEnumerationLabel= ruleEnumerationLabel EOF
            {
             newCompositeNode(grammarAccess.getEnumerationLabelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumerationLabel=ruleEnumerationLabel();

            state._fsp--;

             current =iv_ruleEnumerationLabel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationLabel"


    // $ANTLR start "ruleEnumerationLabel"
    // InternalMetaDsl.g:3156:1: ruleEnumerationLabel returns [EObject current=null] : ( ( ( ruleFQN ) ) otherlv_1= '{' ( ( (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' ) ) )? ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}' ) ;
    public final EObject ruleEnumerationLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_type_2_1=null;
        Token lv_type_2_2=null;
        Token otherlv_4=null;
        EObject lv_labels_3_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:3162:2: ( ( ( ( ruleFQN ) ) otherlv_1= '{' ( ( (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' ) ) )? ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}' ) )
            // InternalMetaDsl.g:3163:2: ( ( ( ruleFQN ) ) otherlv_1= '{' ( ( (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' ) ) )? ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}' )
            {
            // InternalMetaDsl.g:3163:2: ( ( ( ruleFQN ) ) otherlv_1= '{' ( ( (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' ) ) )? ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}' )
            // InternalMetaDsl.g:3164:3: ( ( ruleFQN ) ) otherlv_1= '{' ( ( (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' ) ) )? ( (lv_labels_3_0= ruleLabel ) )* otherlv_4= '}'
            {
            // InternalMetaDsl.g:3164:3: ( ( ruleFQN ) )
            // InternalMetaDsl.g:3165:4: ( ruleFQN )
            {
            // InternalMetaDsl.g:3165:4: ( ruleFQN )
            // InternalMetaDsl.g:3166:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationLabelRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEnumerationLabelAccess().getEnuMetadataRowEnuMetadataRowCrossReference_0_0());
            				
            pushFollow(FOLLOW_8);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_74); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumerationLabelAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMetaDsl.g:3184:3: ( ( (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=74 && LA82_0<=75)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalMetaDsl.g:3185:4: ( (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' ) )
                    {
                    // InternalMetaDsl.g:3185:4: ( (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' ) )
                    // InternalMetaDsl.g:3186:5: (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' )
                    {
                    // InternalMetaDsl.g:3186:5: (lv_type_2_1= 'SHORTLABEL' | lv_type_2_2= 'LONGLABEL' )
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==74) ) {
                        alt81=1;
                    }
                    else if ( (LA81_0==75) ) {
                        alt81=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 81, 0, input);

                        throw nvae;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalMetaDsl.g:3187:6: lv_type_2_1= 'SHORTLABEL'
                            {
                            lv_type_2_1=(Token)match(input,74,FOLLOW_75); 

                            						newLeafNode(lv_type_2_1, grammarAccess.getEnumerationLabelAccess().getTypeSHORTLABELKeyword_2_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getEnumerationLabelRule());
                            						}
                            						setWithLastConsumed(current, "type", lv_type_2_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:3198:6: lv_type_2_2= 'LONGLABEL'
                            {
                            lv_type_2_2=(Token)match(input,75,FOLLOW_75); 

                            						newLeafNode(lv_type_2_2, grammarAccess.getEnumerationLabelAccess().getTypeLONGLABELKeyword_2_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getEnumerationLabelRule());
                            						}
                            						setWithLastConsumed(current, "type", lv_type_2_2, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:3211:3: ( (lv_labels_3_0= ruleLabel ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( ((LA83_0>=RULE_ID && LA83_0<=RULE_STRING)) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalMetaDsl.g:3212:4: (lv_labels_3_0= ruleLabel )
            	    {
            	    // InternalMetaDsl.g:3212:4: (lv_labels_3_0= ruleLabel )
            	    // InternalMetaDsl.g:3213:5: lv_labels_3_0= ruleLabel
            	    {

            	    					newCompositeNode(grammarAccess.getEnumerationLabelAccess().getLabelsLabelParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_75);
            	    lv_labels_3_0=ruleLabel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEnumerationLabelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"labels",
            	    						lv_labels_3_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.Label");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumerationLabelAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationLabel"


    // $ANTLR start "entryRuleLabel"
    // InternalMetaDsl.g:3238:1: entryRuleLabel returns [EObject current=null] : iv_ruleLabel= ruleLabel EOF ;
    public final EObject entryRuleLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabel = null;


        try {
            // InternalMetaDsl.g:3238:46: (iv_ruleLabel= ruleLabel EOF )
            // InternalMetaDsl.g:3239:2: iv_ruleLabel= ruleLabel EOF
            {
             newCompositeNode(grammarAccess.getLabelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLabel=ruleLabel();

            state._fsp--;

             current =iv_ruleLabel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLabel"


    // $ANTLR start "ruleLabel"
    // InternalMetaDsl.g:3245:1: ruleLabel returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) )? ( (lv_labelText_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_labelText_1_0=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:3251:2: ( ( ( (otherlv_0= RULE_ID ) )? ( (lv_labelText_1_0= RULE_STRING ) ) ) )
            // InternalMetaDsl.g:3252:2: ( ( (otherlv_0= RULE_ID ) )? ( (lv_labelText_1_0= RULE_STRING ) ) )
            {
            // InternalMetaDsl.g:3252:2: ( ( (otherlv_0= RULE_ID ) )? ( (lv_labelText_1_0= RULE_STRING ) ) )
            // InternalMetaDsl.g:3253:3: ( (otherlv_0= RULE_ID ) )? ( (lv_labelText_1_0= RULE_STRING ) )
            {
            // InternalMetaDsl.g:3253:3: ( (otherlv_0= RULE_ID ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_ID) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalMetaDsl.g:3254:4: (otherlv_0= RULE_ID )
                    {
                    // InternalMetaDsl.g:3254:4: (otherlv_0= RULE_ID )
                    // InternalMetaDsl.g:3255:5: otherlv_0= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLabelRule());
                    					}
                    				
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_21); 

                    					newLeafNode(otherlv_0, grammarAccess.getLabelAccess().getLangLanguageCrossReference_0_0());
                    				

                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:3266:3: ( (lv_labelText_1_0= RULE_STRING ) )
            // InternalMetaDsl.g:3267:4: (lv_labelText_1_0= RULE_STRING )
            {
            // InternalMetaDsl.g:3267:4: (lv_labelText_1_0= RULE_STRING )
            // InternalMetaDsl.g:3268:5: lv_labelText_1_0= RULE_STRING
            {
            lv_labelText_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_labelText_1_0, grammarAccess.getLabelAccess().getLabelTextSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLabelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"labelText",
            						lv_labelText_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLabel"


    // $ANTLR start "entryRuleDocumentationSection"
    // InternalMetaDsl.g:3288:1: entryRuleDocumentationSection returns [EObject current=null] : iv_ruleDocumentationSection= ruleDocumentationSection EOF ;
    public final EObject entryRuleDocumentationSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentationSection = null;


        try {
            // InternalMetaDsl.g:3288:61: (iv_ruleDocumentationSection= ruleDocumentationSection EOF )
            // InternalMetaDsl.g:3289:2: iv_ruleDocumentationSection= ruleDocumentationSection EOF
            {
             newCompositeNode(grammarAccess.getDocumentationSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocumentationSection=ruleDocumentationSection();

            state._fsp--;

             current =iv_ruleDocumentationSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocumentationSection"


    // $ANTLR start "ruleDocumentationSection"
    // InternalMetaDsl.g:3295:1: ruleDocumentationSection returns [EObject current=null] : ( ( (lv_name_0_0= 'DOCUMENTATION' ) ) otherlv_1= '{' ( (lv_documentationBlocks_2_0= ruleDocumentationBlock ) )+ otherlv_3= '}' ) ;
    public final EObject ruleDocumentationSection() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_documentationBlocks_2_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:3301:2: ( ( ( (lv_name_0_0= 'DOCUMENTATION' ) ) otherlv_1= '{' ( (lv_documentationBlocks_2_0= ruleDocumentationBlock ) )+ otherlv_3= '}' ) )
            // InternalMetaDsl.g:3302:2: ( ( (lv_name_0_0= 'DOCUMENTATION' ) ) otherlv_1= '{' ( (lv_documentationBlocks_2_0= ruleDocumentationBlock ) )+ otherlv_3= '}' )
            {
            // InternalMetaDsl.g:3302:2: ( ( (lv_name_0_0= 'DOCUMENTATION' ) ) otherlv_1= '{' ( (lv_documentationBlocks_2_0= ruleDocumentationBlock ) )+ otherlv_3= '}' )
            // InternalMetaDsl.g:3303:3: ( (lv_name_0_0= 'DOCUMENTATION' ) ) otherlv_1= '{' ( (lv_documentationBlocks_2_0= ruleDocumentationBlock ) )+ otherlv_3= '}'
            {
            // InternalMetaDsl.g:3303:3: ( (lv_name_0_0= 'DOCUMENTATION' ) )
            // InternalMetaDsl.g:3304:4: (lv_name_0_0= 'DOCUMENTATION' )
            {
            // InternalMetaDsl.g:3304:4: (lv_name_0_0= 'DOCUMENTATION' )
            // InternalMetaDsl.g:3305:5: lv_name_0_0= 'DOCUMENTATION'
            {
            lv_name_0_0=(Token)match(input,80,FOLLOW_8); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDocumentationSectionAccess().getNameDOCUMENTATIONKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDocumentationSectionRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "DOCUMENTATION");
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_72); 

            			newLeafNode(otherlv_1, grammarAccess.getDocumentationSectionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMetaDsl.g:3321:3: ( (lv_documentationBlocks_2_0= ruleDocumentationBlock ) )+
            int cnt85=0;
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==RULE_ID||LA85_0==44) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalMetaDsl.g:3322:4: (lv_documentationBlocks_2_0= ruleDocumentationBlock )
            	    {
            	    // InternalMetaDsl.g:3322:4: (lv_documentationBlocks_2_0= ruleDocumentationBlock )
            	    // InternalMetaDsl.g:3323:5: lv_documentationBlocks_2_0= ruleDocumentationBlock
            	    {

            	    					newCompositeNode(grammarAccess.getDocumentationSectionAccess().getDocumentationBlocksDocumentationBlockParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_73);
            	    lv_documentationBlocks_2_0=ruleDocumentationBlock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDocumentationSectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"documentationBlocks",
            	    						lv_documentationBlocks_2_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.DocumentationBlock");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt85 >= 1 ) break loop85;
                        EarlyExitException eee =
                            new EarlyExitException(85, input);
                        throw eee;
                }
                cnt85++;
            } while (true);

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getDocumentationSectionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocumentationSection"


    // $ANTLR start "entryRuleDocumentationBlock"
    // InternalMetaDsl.g:3348:1: entryRuleDocumentationBlock returns [EObject current=null] : iv_ruleDocumentationBlock= ruleDocumentationBlock EOF ;
    public final EObject entryRuleDocumentationBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentationBlock = null;


        try {
            // InternalMetaDsl.g:3348:59: (iv_ruleDocumentationBlock= ruleDocumentationBlock EOF )
            // InternalMetaDsl.g:3349:2: iv_ruleDocumentationBlock= ruleDocumentationBlock EOF
            {
             newCompositeNode(grammarAccess.getDocumentationBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocumentationBlock=ruleDocumentationBlock();

            state._fsp--;

             current =iv_ruleDocumentationBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocumentationBlock"


    // $ANTLR start "ruleDocumentationBlock"
    // InternalMetaDsl.g:3355:1: ruleDocumentationBlock returns [EObject current=null] : ( (otherlv_0= 'ENTITY' | ( (otherlv_1= RULE_ID ) ) ) ( ( (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING ) ) ) ) ;
    public final EObject ruleDocumentationBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_documentationText_2_1=null;
        Token lv_documentationText_2_2=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:3361:2: ( ( (otherlv_0= 'ENTITY' | ( (otherlv_1= RULE_ID ) ) ) ( ( (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING ) ) ) ) )
            // InternalMetaDsl.g:3362:2: ( (otherlv_0= 'ENTITY' | ( (otherlv_1= RULE_ID ) ) ) ( ( (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING ) ) ) )
            {
            // InternalMetaDsl.g:3362:2: ( (otherlv_0= 'ENTITY' | ( (otherlv_1= RULE_ID ) ) ) ( ( (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING ) ) ) )
            // InternalMetaDsl.g:3363:3: (otherlv_0= 'ENTITY' | ( (otherlv_1= RULE_ID ) ) ) ( ( (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING ) ) )
            {
            // InternalMetaDsl.g:3363:3: (otherlv_0= 'ENTITY' | ( (otherlv_1= RULE_ID ) ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==44) ) {
                alt86=1;
            }
            else if ( (LA86_0==RULE_ID) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalMetaDsl.g:3364:4: otherlv_0= 'ENTITY'
                    {
                    otherlv_0=(Token)match(input,44,FOLLOW_79); 

                    				newLeafNode(otherlv_0, grammarAccess.getDocumentationBlockAccess().getENTITYKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:3369:4: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalMetaDsl.g:3369:4: ( (otherlv_1= RULE_ID ) )
                    // InternalMetaDsl.g:3370:5: (otherlv_1= RULE_ID )
                    {
                    // InternalMetaDsl.g:3370:5: (otherlv_1= RULE_ID )
                    // InternalMetaDsl.g:3371:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDocumentationBlockRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_79); 

                    						newLeafNode(otherlv_1, grammarAccess.getDocumentationBlockAccess().getAttributeAttributeCrossReference_0_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:3383:3: ( ( (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING ) ) )
            // InternalMetaDsl.g:3384:4: ( (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING ) )
            {
            // InternalMetaDsl.g:3384:4: ( (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING ) )
            // InternalMetaDsl.g:3385:5: (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING )
            {
            // InternalMetaDsl.g:3385:5: (lv_documentationText_2_1= RULE_ML_STRING | lv_documentationText_2_2= RULE_STRING )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_ML_STRING) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_STRING) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalMetaDsl.g:3386:6: lv_documentationText_2_1= RULE_ML_STRING
                    {
                    lv_documentationText_2_1=(Token)match(input,RULE_ML_STRING,FOLLOW_2); 

                    						newLeafNode(lv_documentationText_2_1, grammarAccess.getDocumentationBlockAccess().getDocumentationTextML_STRINGTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDocumentationBlockRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"documentationText",
                    							lv_documentationText_2_1,
                    							"com.jsantos.metadata.plugin.MetaDsl.ML_STRING");
                    					

                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:3401:6: lv_documentationText_2_2= RULE_STRING
                    {
                    lv_documentationText_2_2=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_documentationText_2_2, grammarAccess.getDocumentationBlockAccess().getDocumentationTextSTRINGTerminalRuleCall_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDocumentationBlockRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"documentationText",
                    							lv_documentationText_2_2,
                    							"com.jsantos.metadata.plugin.MetaDsl.STRING");
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocumentationBlock"


    // $ANTLR start "entryRuleQuerySourceBlock"
    // InternalMetaDsl.g:3422:1: entryRuleQuerySourceBlock returns [EObject current=null] : iv_ruleQuerySourceBlock= ruleQuerySourceBlock EOF ;
    public final EObject entryRuleQuerySourceBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuerySourceBlock = null;


        try {
            // InternalMetaDsl.g:3422:57: (iv_ruleQuerySourceBlock= ruleQuerySourceBlock EOF )
            // InternalMetaDsl.g:3423:2: iv_ruleQuerySourceBlock= ruleQuerySourceBlock EOF
            {
             newCompositeNode(grammarAccess.getQuerySourceBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuerySourceBlock=ruleQuerySourceBlock();

            state._fsp--;

             current =iv_ruleQuerySourceBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuerySourceBlock"


    // $ANTLR start "ruleQuerySourceBlock"
    // InternalMetaDsl.g:3429:1: ruleQuerySourceBlock returns [EObject current=null] : (otherlv_0= 'QUERYSOURCE' ( (lv_querySource_1_0= RULE_ML_STRING ) ) ) ;
    public final EObject ruleQuerySourceBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_querySource_1_0=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:3435:2: ( (otherlv_0= 'QUERYSOURCE' ( (lv_querySource_1_0= RULE_ML_STRING ) ) ) )
            // InternalMetaDsl.g:3436:2: (otherlv_0= 'QUERYSOURCE' ( (lv_querySource_1_0= RULE_ML_STRING ) ) )
            {
            // InternalMetaDsl.g:3436:2: (otherlv_0= 'QUERYSOURCE' ( (lv_querySource_1_0= RULE_ML_STRING ) ) )
            // InternalMetaDsl.g:3437:3: otherlv_0= 'QUERYSOURCE' ( (lv_querySource_1_0= RULE_ML_STRING ) )
            {
            otherlv_0=(Token)match(input,81,FOLLOW_80); 

            			newLeafNode(otherlv_0, grammarAccess.getQuerySourceBlockAccess().getQUERYSOURCEKeyword_0());
            		
            // InternalMetaDsl.g:3441:3: ( (lv_querySource_1_0= RULE_ML_STRING ) )
            // InternalMetaDsl.g:3442:4: (lv_querySource_1_0= RULE_ML_STRING )
            {
            // InternalMetaDsl.g:3442:4: (lv_querySource_1_0= RULE_ML_STRING )
            // InternalMetaDsl.g:3443:5: lv_querySource_1_0= RULE_ML_STRING
            {
            lv_querySource_1_0=(Token)match(input,RULE_ML_STRING,FOLLOW_2); 

            					newLeafNode(lv_querySource_1_0, grammarAccess.getQuerySourceBlockAccess().getQuerySourceML_STRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuerySourceBlockRule());
            					}
            					setWithLastConsumed(
            						current,
            						"querySource",
            						lv_querySource_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ML_STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuerySourceBlock"


    // $ANTLR start "entryRuleSQLFunction"
    // InternalMetaDsl.g:3463:1: entryRuleSQLFunction returns [EObject current=null] : iv_ruleSQLFunction= ruleSQLFunction EOF ;
    public final EObject entryRuleSQLFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSQLFunction = null;


        try {
            // InternalMetaDsl.g:3463:52: (iv_ruleSQLFunction= ruleSQLFunction EOF )
            // InternalMetaDsl.g:3464:2: iv_ruleSQLFunction= ruleSQLFunction EOF
            {
             newCompositeNode(grammarAccess.getSQLFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSQLFunction=ruleSQLFunction();

            state._fsp--;

             current =iv_ruleSQLFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSQLFunction"


    // $ANTLR start "ruleSQLFunction"
    // InternalMetaDsl.g:3470:1: ruleSQLFunction returns [EObject current=null] : (otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'SQLFILE' ( (lv_sqlFile_3_0= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleSQLFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_sqlFile_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:3476:2: ( (otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'SQLFILE' ( (lv_sqlFile_3_0= RULE_STRING ) ) otherlv_4= ';' ) )
            // InternalMetaDsl.g:3477:2: (otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'SQLFILE' ( (lv_sqlFile_3_0= RULE_STRING ) ) otherlv_4= ';' )
            {
            // InternalMetaDsl.g:3477:2: (otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'SQLFILE' ( (lv_sqlFile_3_0= RULE_STRING ) ) otherlv_4= ';' )
            // InternalMetaDsl.g:3478:3: otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'SQLFILE' ( (lv_sqlFile_3_0= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getSQLFunctionAccess().getFUNCTIONKeyword_0());
            		
            // InternalMetaDsl.g:3482:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalMetaDsl.g:3483:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalMetaDsl.g:3483:4: (lv_name_1_0= RULE_STRING )
            // InternalMetaDsl.g:3484:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_81); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSQLFunctionAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSQLFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.jsantos.metadata.plugin.MetaDsl.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,83,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSQLFunctionAccess().getSQLFILEKeyword_2());
            		
            // InternalMetaDsl.g:3504:3: ( (lv_sqlFile_3_0= RULE_STRING ) )
            // InternalMetaDsl.g:3505:4: (lv_sqlFile_3_0= RULE_STRING )
            {
            // InternalMetaDsl.g:3505:4: (lv_sqlFile_3_0= RULE_STRING )
            // InternalMetaDsl.g:3506:5: lv_sqlFile_3_0= RULE_STRING
            {
            lv_sqlFile_3_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            					newLeafNode(lv_sqlFile_3_0, grammarAccess.getSQLFunctionAccess().getSqlFileSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSQLFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"sqlFile",
            						lv_sqlFile_3_0,
            						"com.jsantos.metadata.plugin.MetaDsl.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSQLFunctionAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSQLFunction"


    // $ANTLR start "entryRuleSqlNative"
    // InternalMetaDsl.g:3530:1: entryRuleSqlNative returns [EObject current=null] : iv_ruleSqlNative= ruleSqlNative EOF ;
    public final EObject entryRuleSqlNative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSqlNative = null;


        try {
            // InternalMetaDsl.g:3530:50: (iv_ruleSqlNative= ruleSqlNative EOF )
            // InternalMetaDsl.g:3531:2: iv_ruleSqlNative= ruleSqlNative EOF
            {
             newCompositeNode(grammarAccess.getSqlNativeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSqlNative=ruleSqlNative();

            state._fsp--;

             current =iv_ruleSqlNative; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSqlNative"


    // $ANTLR start "ruleSqlNative"
    // InternalMetaDsl.g:3537:1: ruleSqlNative returns [EObject current=null] : (otherlv_0= 'SQLNATIVE' (otherlv_1= 'ID' ( (lv_name_2_0= ruleFQN ) ) )? ( ( (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' ) ) )? otherlv_4= '{' ( (lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock ) )* otherlv_6= '}' ) ;
    public final EObject ruleSqlNative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_sqlPosition_3_1=null;
        Token lv_sqlPosition_3_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_sqlNativeBlocks_5_0 = null;



        	enterRule();

        try {
            // InternalMetaDsl.g:3543:2: ( (otherlv_0= 'SQLNATIVE' (otherlv_1= 'ID' ( (lv_name_2_0= ruleFQN ) ) )? ( ( (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' ) ) )? otherlv_4= '{' ( (lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock ) )* otherlv_6= '}' ) )
            // InternalMetaDsl.g:3544:2: (otherlv_0= 'SQLNATIVE' (otherlv_1= 'ID' ( (lv_name_2_0= ruleFQN ) ) )? ( ( (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' ) ) )? otherlv_4= '{' ( (lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock ) )* otherlv_6= '}' )
            {
            // InternalMetaDsl.g:3544:2: (otherlv_0= 'SQLNATIVE' (otherlv_1= 'ID' ( (lv_name_2_0= ruleFQN ) ) )? ( ( (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' ) ) )? otherlv_4= '{' ( (lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock ) )* otherlv_6= '}' )
            // InternalMetaDsl.g:3545:3: otherlv_0= 'SQLNATIVE' (otherlv_1= 'ID' ( (lv_name_2_0= ruleFQN ) ) )? ( ( (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' ) ) )? otherlv_4= '{' ( (lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_82); 

            			newLeafNode(otherlv_0, grammarAccess.getSqlNativeAccess().getSQLNATIVEKeyword_0());
            		
            // InternalMetaDsl.g:3549:3: (otherlv_1= 'ID' ( (lv_name_2_0= ruleFQN ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==85) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalMetaDsl.g:3550:4: otherlv_1= 'ID' ( (lv_name_2_0= ruleFQN ) )
                    {
                    otherlv_1=(Token)match(input,85,FOLLOW_18); 

                    				newLeafNode(otherlv_1, grammarAccess.getSqlNativeAccess().getIDKeyword_1_0());
                    			
                    // InternalMetaDsl.g:3554:4: ( (lv_name_2_0= ruleFQN ) )
                    // InternalMetaDsl.g:3555:5: (lv_name_2_0= ruleFQN )
                    {
                    // InternalMetaDsl.g:3555:5: (lv_name_2_0= ruleFQN )
                    // InternalMetaDsl.g:3556:6: lv_name_2_0= ruleFQN
                    {

                    						newCompositeNode(grammarAccess.getSqlNativeAccess().getNameFQNParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_83);
                    lv_name_2_0=ruleFQN();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSqlNativeRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"com.jsantos.metadata.plugin.MetaDsl.FQN");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMetaDsl.g:3574:3: ( ( (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=86 && LA90_0<=87)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalMetaDsl.g:3575:4: ( (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' ) )
                    {
                    // InternalMetaDsl.g:3575:4: ( (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' ) )
                    // InternalMetaDsl.g:3576:5: (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' )
                    {
                    // InternalMetaDsl.g:3576:5: (lv_sqlPosition_3_1= 'FILESTART' | lv_sqlPosition_3_2= 'FILEEND' )
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==86) ) {
                        alt89=1;
                    }
                    else if ( (LA89_0==87) ) {
                        alt89=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 89, 0, input);

                        throw nvae;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalMetaDsl.g:3577:6: lv_sqlPosition_3_1= 'FILESTART'
                            {
                            lv_sqlPosition_3_1=(Token)match(input,86,FOLLOW_8); 

                            						newLeafNode(lv_sqlPosition_3_1, grammarAccess.getSqlNativeAccess().getSqlPositionFILESTARTKeyword_2_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getSqlNativeRule());
                            						}
                            						setWithLastConsumed(current, "sqlPosition", lv_sqlPosition_3_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalMetaDsl.g:3588:6: lv_sqlPosition_3_2= 'FILEEND'
                            {
                            lv_sqlPosition_3_2=(Token)match(input,87,FOLLOW_8); 

                            						newLeafNode(lv_sqlPosition_3_2, grammarAccess.getSqlNativeAccess().getSqlPositionFILEENDKeyword_2_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getSqlNativeRule());
                            						}
                            						setWithLastConsumed(current, "sqlPosition", lv_sqlPosition_3_2, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_84); 

            			newLeafNode(otherlv_4, grammarAccess.getSqlNativeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMetaDsl.g:3605:3: ( (lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==88) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalMetaDsl.g:3606:4: (lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock )
            	    {
            	    // InternalMetaDsl.g:3606:4: (lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock )
            	    // InternalMetaDsl.g:3607:5: lv_sqlNativeBlocks_5_0= ruleSqlNativeBlock
            	    {

            	    					newCompositeNode(grammarAccess.getSqlNativeAccess().getSqlNativeBlocksSqlNativeBlockParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_84);
            	    lv_sqlNativeBlocks_5_0=ruleSqlNativeBlock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSqlNativeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sqlNativeBlocks",
            	    						lv_sqlNativeBlocks_5_0,
            	    						"com.jsantos.metadata.plugin.MetaDsl.SqlNativeBlock");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);

            otherlv_6=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSqlNativeAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSqlNative"


    // $ANTLR start "entryRuleSqlNativeBlock"
    // InternalMetaDsl.g:3632:1: entryRuleSqlNativeBlock returns [EObject current=null] : iv_ruleSqlNativeBlock= ruleSqlNativeBlock EOF ;
    public final EObject entryRuleSqlNativeBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSqlNativeBlock = null;


        try {
            // InternalMetaDsl.g:3632:55: (iv_ruleSqlNativeBlock= ruleSqlNativeBlock EOF )
            // InternalMetaDsl.g:3633:2: iv_ruleSqlNativeBlock= ruleSqlNativeBlock EOF
            {
             newCompositeNode(grammarAccess.getSqlNativeBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSqlNativeBlock=ruleSqlNativeBlock();

            state._fsp--;

             current =iv_ruleSqlNativeBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSqlNativeBlock"


    // $ANTLR start "ruleSqlNativeBlock"
    // InternalMetaDsl.g:3639:1: ruleSqlNativeBlock returns [EObject current=null] : ( (otherlv_0= 'DBTYPE' ( ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) ) ) ) ( (lv_sqlBlock_2_0= RULE_ML_SQLBLOCK ) ) ) ;
    public final EObject ruleSqlNativeBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_dbType_1_1=null;
        Token lv_dbType_1_2=null;
        Token lv_dbType_1_3=null;
        Token lv_dbType_1_4=null;
        Token lv_dbType_1_5=null;
        Token lv_dbType_1_6=null;
        Token lv_sqlBlock_2_0=null;


        	enterRule();

        try {
            // InternalMetaDsl.g:3645:2: ( ( (otherlv_0= 'DBTYPE' ( ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) ) ) ) ( (lv_sqlBlock_2_0= RULE_ML_SQLBLOCK ) ) ) )
            // InternalMetaDsl.g:3646:2: ( (otherlv_0= 'DBTYPE' ( ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) ) ) ) ( (lv_sqlBlock_2_0= RULE_ML_SQLBLOCK ) ) )
            {
            // InternalMetaDsl.g:3646:2: ( (otherlv_0= 'DBTYPE' ( ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) ) ) ) ( (lv_sqlBlock_2_0= RULE_ML_SQLBLOCK ) ) )
            // InternalMetaDsl.g:3647:3: (otherlv_0= 'DBTYPE' ( ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) ) ) ) ( (lv_sqlBlock_2_0= RULE_ML_SQLBLOCK ) )
            {
            // InternalMetaDsl.g:3647:3: (otherlv_0= 'DBTYPE' ( ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) ) ) )
            // InternalMetaDsl.g:3648:4: otherlv_0= 'DBTYPE' ( ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) ) )
            {
            otherlv_0=(Token)match(input,88,FOLLOW_85); 

            				newLeafNode(otherlv_0, grammarAccess.getSqlNativeBlockAccess().getDBTYPEKeyword_0_0());
            			
            // InternalMetaDsl.g:3652:4: ( ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) ) )
            // InternalMetaDsl.g:3653:5: ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) )
            {
            // InternalMetaDsl.g:3653:5: ( (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' ) )
            // InternalMetaDsl.g:3654:6: (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' )
            {
            // InternalMetaDsl.g:3654:6: (lv_dbType_1_1= 'H2' | lv_dbType_1_2= 'POSTGRESQL' | lv_dbType_1_3= 'MYSQL' | lv_dbType_1_4= 'SQLSERVER' | lv_dbType_1_5= 'ORACLE' | lv_dbType_1_6= 'DEFAULT' )
            int alt92=6;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt92=1;
                }
                break;
            case 90:
                {
                alt92=2;
                }
                break;
            case 91:
                {
                alt92=3;
                }
                break;
            case 92:
                {
                alt92=4;
                }
                break;
            case 93:
                {
                alt92=5;
                }
                break;
            case 62:
                {
                alt92=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalMetaDsl.g:3655:7: lv_dbType_1_1= 'H2'
                    {
                    lv_dbType_1_1=(Token)match(input,89,FOLLOW_86); 

                    							newLeafNode(lv_dbType_1_1, grammarAccess.getSqlNativeBlockAccess().getDbTypeH2Keyword_0_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSqlNativeBlockRule());
                    							}
                    							setWithLastConsumed(current, "dbType", lv_dbType_1_1, null);
                    						

                    }
                    break;
                case 2 :
                    // InternalMetaDsl.g:3666:7: lv_dbType_1_2= 'POSTGRESQL'
                    {
                    lv_dbType_1_2=(Token)match(input,90,FOLLOW_86); 

                    							newLeafNode(lv_dbType_1_2, grammarAccess.getSqlNativeBlockAccess().getDbTypePOSTGRESQLKeyword_0_1_0_1());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSqlNativeBlockRule());
                    							}
                    							setWithLastConsumed(current, "dbType", lv_dbType_1_2, null);
                    						

                    }
                    break;
                case 3 :
                    // InternalMetaDsl.g:3677:7: lv_dbType_1_3= 'MYSQL'
                    {
                    lv_dbType_1_3=(Token)match(input,91,FOLLOW_86); 

                    							newLeafNode(lv_dbType_1_3, grammarAccess.getSqlNativeBlockAccess().getDbTypeMYSQLKeyword_0_1_0_2());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSqlNativeBlockRule());
                    							}
                    							setWithLastConsumed(current, "dbType", lv_dbType_1_3, null);
                    						

                    }
                    break;
                case 4 :
                    // InternalMetaDsl.g:3688:7: lv_dbType_1_4= 'SQLSERVER'
                    {
                    lv_dbType_1_4=(Token)match(input,92,FOLLOW_86); 

                    							newLeafNode(lv_dbType_1_4, grammarAccess.getSqlNativeBlockAccess().getDbTypeSQLSERVERKeyword_0_1_0_3());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSqlNativeBlockRule());
                    							}
                    							setWithLastConsumed(current, "dbType", lv_dbType_1_4, null);
                    						

                    }
                    break;
                case 5 :
                    // InternalMetaDsl.g:3699:7: lv_dbType_1_5= 'ORACLE'
                    {
                    lv_dbType_1_5=(Token)match(input,93,FOLLOW_86); 

                    							newLeafNode(lv_dbType_1_5, grammarAccess.getSqlNativeBlockAccess().getDbTypeORACLEKeyword_0_1_0_4());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSqlNativeBlockRule());
                    							}
                    							setWithLastConsumed(current, "dbType", lv_dbType_1_5, null);
                    						

                    }
                    break;
                case 6 :
                    // InternalMetaDsl.g:3710:7: lv_dbType_1_6= 'DEFAULT'
                    {
                    lv_dbType_1_6=(Token)match(input,62,FOLLOW_86); 

                    							newLeafNode(lv_dbType_1_6, grammarAccess.getSqlNativeBlockAccess().getDbTypeDEFAULTKeyword_0_1_0_5());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSqlNativeBlockRule());
                    							}
                    							setWithLastConsumed(current, "dbType", lv_dbType_1_6, null);
                    						

                    }
                    break;

            }


            }


            }


            }

            // InternalMetaDsl.g:3724:3: ( (lv_sqlBlock_2_0= RULE_ML_SQLBLOCK ) )
            // InternalMetaDsl.g:3725:4: (lv_sqlBlock_2_0= RULE_ML_SQLBLOCK )
            {
            // InternalMetaDsl.g:3725:4: (lv_sqlBlock_2_0= RULE_ML_SQLBLOCK )
            // InternalMetaDsl.g:3726:5: lv_sqlBlock_2_0= RULE_ML_SQLBLOCK
            {
            lv_sqlBlock_2_0=(Token)match(input,RULE_ML_SQLBLOCK,FOLLOW_2); 

            					newLeafNode(lv_sqlBlock_2_0, grammarAccess.getSqlNativeBlockAccess().getSqlBlockML_SQLBLOCKTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSqlNativeBlockRule());
            					}
            					setWithLastConsumed(
            						current,
            						"sqlBlock",
            						lv_sqlBlock_2_0,
            						"com.jsantos.metadata.plugin.MetaDsl.ML_SQLBLOCK");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSqlNativeBlock"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00009F0000088002L,0x0000000000100220L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000088002L,0x0000000000100220L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100220L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000007006020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000007002020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000007000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000006000020000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000004000020000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000088000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200000040L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0300000000400010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00009E0000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000604000010000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000404000010000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000400400010000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000400000010000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0300000000400010L,0x0000000000038230L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000400000L,0x0000000000038210L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000400000L,0x0000000000038200L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400000L,0x0000000000038000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000400000L,0x0000000000030000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000400000L,0x0000000000020000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00F5000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00F4000000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x00F0000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0200000000000010L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0xFC00400100000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0xFC00400000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0xF800400000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0xF000400000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0xE000400000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0xC000400000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x8000400000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000400000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x00000000001C0000L,0x000000000000000EL});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x40000000000001E0L,0x0000000000000180L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000040L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x40000000004001E0L,0x0000000000000180L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000100000000010L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000100000400010L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000400030L,0x0000000000000C00L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000400030L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000100000400000L,0x0000000000007000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000100000400000L,0x0000000000006000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000010000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000010000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000400000L,0x0000000001000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x4000000000000000L,0x000000003E000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000400L});

}