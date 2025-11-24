-- Generated Script file for DEFAULT !!!
-- Generated at Sun Oct 03 20:23:32 CEST 2021 
CREATE SCHEMA testrunner
; -- Generated Statement 

CREATE SCHEMA audit
; -- Generated Statement 

CREATE SCHEMA config
; -- Generated Statement 

CREATE SCHEMA common
; -- Generated Statement 

CREATE SCHEMA label
; -- Generated Statement 

CREATE SEQUENCE audit.Seq_InputSource_inputSourceId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE audit.Seq_InputUser_inputUserId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE audit.Seq_InputUserGroup_inputUserGroupId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE audit.Seq_UserGroup_userGroupId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE config.Seq_AppDataType_appDataTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE config.Seq_AppInfo_appInfoId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE config.Seq_AppInfoTree_appInfoTreeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE config.Seq_PostingDate_postingDateId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE common.Seq_FileGroup_fileGroupId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE common.Seq_StorageFile_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE common.Seq_StorageFilePk_storageFileId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE config.Seq_DatagridSetting_dataGridSettingId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE config.Seq_Enulocale_enuLocaleId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE label.Seq_MTlabel_mtLabelId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE testrunner.Seq_EventDefFolder_eventdeffolderUuid START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE testrunner.Seq_EventDefinition_eventDefinitionUuid START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE testrunner.Seq_Folder_folderUuid START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE testrunner.Seq_Test_testUuid START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE testrunner.Seq_EventStatus_eventStatusId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE testrunner.Seq_EventType_eventTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE testrunner.Seq_Operator_operatorId START WITH 1000
; -- Generated Statement 

CREATE TABLE audit.InputSource(
	inputSourceId INT,
	shortCode VARCHAR(16) NOT NULL ,
	description VARCHAR(64) NOT NULL 
,CONSTRAINT PK_audit_InputSource PRIMARY KEY (inputSourceId))
; -- Generated Statement 

CREATE TABLE audit.InputUser(
	inputUserId INT,
	loginName VARCHAR(64) NOT NULL ,
	passwd VARCHAR(256),
	fullName VARCHAR(128),
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL ,
	email VARCHAR(64)
,CONSTRAINT PK_audit_InputUser PRIMARY KEY (inputUserId))
; -- Generated Statement 

CREATE TABLE audit.InputUserGroup(
	inputUserGroupId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_audit_InputUserGroup PRIMARY KEY (inputUserGroupId))
; -- Generated Statement 

CREATE TABLE audit.UserGroup(
	userGroupId INT NOT NULL ,
	inputUserGroupId INT NOT NULL ,
	userId INT NOT NULL ,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_audit_UserGroup PRIMARY KEY (userGroupId))
; -- Generated Statement 

CREATE TABLE config.AppDataType(
	appDataTypeId INT,
	shortCode VARCHAR(16) NOT NULL ,
	description VARCHAR(32) NOT NULL 
,CONSTRAINT PK_config_AppDataType PRIMARY KEY (appDataTypeId))
; -- Generated Statement 

CREATE TABLE config.AppInfo(
	appInfoId VARCHAR(130) NOT NULL ,
	sKey VARCHAR(250) NOT NULL ,
	type INT,
	sValue VARCHAR(8000),
	inputUserGroupId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_config_AppInfo PRIMARY KEY (appInfoId))
; -- Generated Statement 

CREATE TABLE config.AppInfoTree(
	appInfoTreeId VARCHAR(130) NOT NULL ,
	parentAppInfoTreeId VARCHAR(130),
	description VARCHAR(256),
	appInfoId VARCHAR(130)
,CONSTRAINT PK_config_AppInfoTree PRIMARY KEY (appInfoTreeId))
; -- Generated Statement 

CREATE TABLE config.PostingDate(
	postingDateId INT,
	postingDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
	lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL 
,CONSTRAINT PK_config_PostingDate PRIMARY KEY (postingDateId))
; -- Generated Statement 

CREATE TABLE common.FileGroup(
	fileGroupId INT,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_common_FileGroup PRIMARY KEY (fileGroupId))
; -- Generated Statement 

CREATE TABLE common.StorageFile(
	storageFileId INT NOT NULL ,
	location VARCHAR(256) NOT NULL ,
	provider VARCHAR(70),
	mimeType VARCHAR(70) NOT NULL ,
	fileName VARCHAR(255) NOT NULL ,
	fileGroupId INT NOT NULL ,
	originalFileName VARCHAR(255),
	tags VARCHAR(255),
	description VARCHAR(255),
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL ,
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL 
,CONSTRAINT PK_common_StorageFile PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE common.StorageFilePk(
	storageFileId INT
,CONSTRAINT PK_common_StorageFilePk PRIMARY KEY (storageFileId))
; -- Generated Statement 

CREATE TABLE config.DatagridSetting(
	dataGridSettingId VARCHAR(130) NOT NULL ,
	searchName VARCHAR(250) NOT NULL ,
	data VARCHAR NOT NULL ,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputUserGroupId INT NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_config_DatagridSetting PRIMARY KEY (dataGridSettingId))
; -- Generated Statement 

CREATE TABLE config.Enulocale(
	enuLocaleId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_config_Enulocale PRIMARY KEY (enuLocaleId))
; -- Generated Statement 

CREATE TABLE label.MTlabel(
	mtLabelId VARCHAR(130),
	shortCode VARCHAR(65),
	screen VARCHAR(65),
	en_US VARCHAR(65),
	es_ES VARCHAR(65)
,CONSTRAINT PK_label_MTlabel PRIMARY KEY (mtLabelId))
; -- Generated Statement 

CREATE TABLE testrunner.EventDefFolder(
	eventdeffolderUuid VARCHAR(130) NOT NULL ,
	parentfolderUuid VARCHAR(130),
	description VARCHAR(255),
	eventDefinitionUuid VARCHAR(130)
,CONSTRAINT PK_testrunner_EventDefFolder PRIMARY KEY (eventdeffolderUuid))
; -- Generated Statement 

CREATE TABLE testrunner.EventDefinition(
	eventDefinitionUuid VARCHAR(130),
	eventTypeId VARCHAR(130) NOT NULL ,
	eventName VARCHAR(64) NOT NULL ,
	description VARCHAR(255),
	eventDefinition VARCHAR,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_testrunner_EventDefinition PRIMARY KEY (eventDefinitionUuid))
; -- Generated Statement 

CREATE TABLE testrunner.Folder(
	folderUuid VARCHAR(130) NOT NULL ,
	parentfolderUuid VARCHAR(130),
	description VARCHAR(255),
	testUuid VARCHAR(130)
,CONSTRAINT PK_testrunner_Folder PRIMARY KEY (folderUuid))
; -- Generated Statement 

CREATE TABLE testrunner.Test(
	testUuid VARCHAR(130) NOT NULL ,
	testname VARCHAR(64) NOT NULL ,
	description VARCHAR(255),
	keywords VARCHAR(255),
	events VARCHAR,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL ,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL 
,CONSTRAINT PK_testrunner_Test PRIMARY KEY (testUuid))
; -- Generated Statement 

CREATE TABLE testrunner.EventStatus(
	eventStatusId INT,
	shortCode VARCHAR(16) NOT NULL ,
	description VARCHAR(32) NOT NULL 
,CONSTRAINT PK_testrunner_EventStatus PRIMARY KEY (eventStatusId))
; -- Generated Statement 

CREATE TABLE testrunner.EventType(
	eventTypeId VARCHAR(130),
	shortCode VARCHAR(16),
	description VARCHAR(255)
,CONSTRAINT PK_testrunner_EventType PRIMARY KEY (eventTypeId))
; -- Generated Statement 

CREATE TABLE testrunner.Operator(
	operatorId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_testrunner_Operator PRIMARY KEY (operatorId))
; -- Generated Statement 

insert into audit.InputSource(inputSourceId,shortCode,description) values 
('1','SYSTEM','System source')
,('2','APP','Back Office Application')

; -- Generated Statement 

insert into audit.InputUser(inputUserId,loginName,passwd,fullName,created,inputSourceId,email) values 
('1','system user',NULL,NULL,getPostingDate(),1,NULL)
,('2','sa','jjsoft',NULL,getPostingDate(),1,NULL)

; -- Generated Statement 

insert into audit.InputUserGroup(inputUserGroupId,shortCode,description) values 
('1','SYSTEM','System Group')
,('2','SA','Admin Group')
,('3','USER','User Group')
,('4','REST','Rest Group')
,('5','TR_Group','Test Runner Group')

; -- Generated Statement 

insert into audit.UserGroup(userGroupId,inputUserGroupId,userId,created,inputUserId,inputSourceId) values 
('1','1','1',getPostingDate(),1,1)
,('2','2','2',getPostingDate(),1,1)

; -- Generated Statement 

insert into config.AppDataType(appDataTypeId,shortCode,description) values 
(1,'TEXT','Text')
,(2,'INTEGER','Integer')
,(3,'BOOLEAN','Boolean')
,(4,'DATE','Date')
,(5,'DECIMAL','Decimal')

; -- Generated Statement 

insert into config.AppInfoTree(appInfoTreeId,parentAppInfoTreeId,description,appInfoId) values 
('1',NULL,'c:',NULL)

; -- Generated Statement 

insert into config.PostingDate(postingDateId,postingDate,lastUpdated) values 
('1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)

; -- Generated Statement 

insert into config.DatagridSetting(dataGridSettingId,searchName,data,created,inputUserGroupId,inputUserId,inputSourceId) values 
('60780dea-0a63-421a-a629-43a85675aabc','MTlabel','{
  "dataTableName" : "label.MTlabel",
  "aSName" : "MTlabel",
  "columnConfigurations" : [ {
    "name" : "mtLabelId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "shortCode",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "screen",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "en_US",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "es_ES",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "mtLabelId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "ID #"
  }, {
    "name" : "shortCode",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Código"
  }, {
    "name" : "screen",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Pantalla"
  }, {
    "name" : "en_US",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Ingles"
  }, {
    "name" : "es_ES",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Español"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "mtLabelId"
  }, {
    "hidden" : false,
    "operator" : "LIKE",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "shortCode"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "screen"
  }, {
    "hidden" : false,
    "operator" : "LIKE",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "en_US"
  }, {
    "hidden" : false,
    "operator" : "LIKE",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "es_ES"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "mtLabelId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "shortCode"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "screen"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "en_US"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "es_ES"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "mtLabelId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-8",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "shortCode"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "screen"
  }, {
    "hidden" : false,
    "newLine" : true,
    "sClass" : "col-md-8",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "en_US"
  }, {
    "hidden" : false,
    "newLine" : true,
    "sClass" : "col-md-8",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "es_ES"
  } ]
}',getPostingDate(),'1',1,1)
,('2','DatagridSetting','{
  "dataTableName" : "config.DatagridSetting",
  "aSName" : "config.DatagridSetting",
  "columnConfigurations" : [ {
    "name" : "dataGridSettingId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "searchName",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "data",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "created",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputUserGroupId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputUserId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputSourceId",
    "hidden" : true,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "dataGridSettingId",
    "asc" : false,
    "active" : false,
    "hidden" : true,
    "label" : "dataGridSettingId"
  }, {
    "name" : "searchName",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "searchName"
  }, {
    "name" : "data",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "data"
  }, {
    "name" : "created",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "created"
  }, {
    "name" : "inputUserGroupId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "inputUserGroupId"
  }, {
    "name" : "inputUserId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "inputUserId"
  }, {
    "name" : "inputSourceId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "inputSourceId"
  } ],
  "filterConfigurations" : [ {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "dataGridSettingId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "searchName"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "data"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserGroupId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "dataGridSettingId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "searchName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "data"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserGroupId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "dataGridSettingId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint", "com.jsantos.custom.constraints.JsonSettingAction"],
    "available" : true,
    "active" : true,
    "name" : "searchName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "data"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "inputUserGroupId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  } ]
}',getPostingDate(),'1',1,1)
,('3','StorageFileTmp','{
  "dataTableName" : "common.StorageFile",
  "aSName" : "StorageFileTmp",
  "columnConfigurations" : [ {
    "name" : "storageFileId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "url",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "mimeType",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "fileName",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "fileGroupId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "originalFileName",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "tags",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "description",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "created",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputUserId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputSourceId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "revisionId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "startDate",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "endDate",
    "hidden" : true,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "storageFileId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "storageFileId"
  }, {
    "name" : "url",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "url"
  }, {
    "name" : "mimeType",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "mimeType"
  }, {
    "name" : "fileName",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "fileName"
  }, {
    "name" : "fileGroupId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "fileGroupId"
  }, {
    "name" : "originalFileName",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "originalFileName"
  }, {
    "name" : "tags",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "tags"
  }, {
    "name" : "description",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "description"
  }, {
    "name" : "created",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "created"
  }, {
    "name" : "inputUserId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "inputUserId"
  }, {
    "name" : "inputSourceId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "inputSourceId"
  }, {
    "name" : "revisionId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "revisionId"
  }, {
    "name" : "startDate",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "startDate"
  }, {
    "name" : "endDate",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "endDate"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "storageFileId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "url"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "mimeType"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "fileName"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "fileGroupId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "originalFileName"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "tags"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "revisionId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "startDate"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "endDate"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "storageFileId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "url"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "mimeType"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "fileName"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "fileGroupId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "originalFileName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "tags"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "revisionId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "startDate"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "endDate"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "storageFileId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "url"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "mimeType"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "fileName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "fileGroupId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "originalFileName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "tags"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "revisionId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "startDate"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "endDate"
  } ]
}',getPostingDate(),'1',1,1)
,('4','Fileshow','{
  "dataTableName" : "common.Fileshow",
  "aSName" : "Fileshow",
  "columnConfigurations" : [ {
    "name" : "fileGroupId",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "fileGroupId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "fileGroupId"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "fileGroupId"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "fileGroupId"
  } ],
  "editConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "fileGroupId"
  } ]
}',getPostingDate(),'1',1,1)
,('5','UserGroup','{
  "dataTableName" : "audit.UserGroup",
  "aSName" : "audit.UserGroup",
  "columnConfigurations" : [ {
    "name" : "userGroupId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputUserGroupId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "userId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "created",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputUserId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputSourceId",
    "hidden" : true,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "userGroupId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "UserGroup.userGroupId"
  }, {
    "name" : "inputUserGroupId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Grupo Usuario"
  }, {
    "name" : "userId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "UserGroup.userId"
  }, {
    "name" : "created",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Creado"
  }, {
    "name" : "inputUserId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Usuario"
  }, {
    "name" : "inputSourceId",
    "asc" : false,
    "active" : false,
    "hidden" : true,
    "label" : "UserGroup.inputSourceId"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "userGroupId"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserGroupId"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "userId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "userGroupId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserGroupId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "userId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "userGroupId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "inputUserGroupId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "userId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "created"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  } ]
}',getPostingDate(),'1',1,1)

; -- Generated Statement 

insert into config.Enulocale(enuLocaleId,shortCode,description) values 
(3082,'es_ES','Spanish (International)')
,(1033,'en_US','English (USA)')
,(1036,'fr_FR','France (International)')

; -- Generated Statement 

insert into label.MTlabel(mtLabelId,shortCode,screen,en_US,es_ES) values 
('1','cancel','general','Cancel','Cancelar')
,('2','close','general','Close','Cerrar')
,('3','create','general','Create','Crear')
,('4','ok','general','Ok','Ok')
,('5','dashboard_all','dashboard','ALL','TODOS')
,('6','delete','general','Delete','Borrar')
,('7','detail','general','Detail','Detalle')
,('8','edit','general','Edit','Editar')
,('9','editscreen_add_paramenter','editscreen','Add Parameter','Añade Parametro')
,('10','editscreen_add_parameters','editscreen','Add Parameters (+)','Añade Parametros (+)')
,('11','editscreen_cancel','editscreen','Cancel','Cancelar')
,('12','editscreen_label_name','editscreen','Label Name','Nombre de la Etiqueta')
,('13','editscreen_reset_parameters','editscreen','Reset Parameters','Reinicia Parametros')
,('14','editscreen_save','editscreen','Save','Guardar')
,('15','email','editscreen','Email','Email')
,('16','emails','editscreen','Emails','Emails')
,('85','reset','general','Reset','reinicia')
,('86','save','general','Save','Guardar')
,('87','standardlistscreen_filter','standardlistscreen','Filter','Filtro')
,('88','standardlistscreen_list','standardlistscreen','List','Lista')
,('89','standardlistscreen_search','standardlistscreen','Search','Buscar')
,('90','to','filter','To','A')
,('78','modify','general','Modify','Modifica')
,('79','new','general','New','Nuevo')
,('80','pagination_format','payment','Show {0} Rows','{0} Filas/Pag_')
,('17','feedback','editscreen','Feedback','Deshacer')
,('18','file_attach_document','file','Attach Documents (+)','Adjunta Documentos (+)')
,('19','filter_collapse','filter','Collapse','Collapse')
,('20','filter_open','filter','Open','Open')
,('21','filter_configure_columns','filter','Configure Columns','Configure Columns')
,('22','filter_configure_edit_json','filter','Json Conf','Json Configuration')
,('23','filter_configure_detail_columns','filter','configure detail Columns','configure detail Columns')
,('24','filter_configure_edit_columns','filter','configure edit Columns','configure edit Columns')
,('25','filter_configure_filter','filter','Configure Filter','Configure Filter')
,('26','filter_configure_seleccion','filter','Configure "Order By selection"','Configure "Order By selection"')
,('27','filter_configure_permissions','filter','Permissions','Permisos')
,('28','filter_configure_labels','filter','Labels','Etiquetas')
,('29','filter_detail','filter','Configuration Detail Screen','Configuration Detalle')
,('30','filter_Edit','filter',' Configuration Edit Screen',' Configuration Editor')
,('31','filter_filter','filter','Filter','Filter')
,('32','filter_filter_description','filter','Filter Description','Filter Description')
,('33','filter_filter_name','filter','Filter name','Filter name')
,('34','filter_orderby','filter','Configuration  "Order By" results','Configuration ordenación')
,('35','filter_reset_filter','filter','Reset Filter','Reset Filter')
,('36','filter_save','filter','Save','Save')
,('37','filter_select','filter','Configuration Columns Shown','Configuration Columnas')
,('38','from','filter','From','Desde')
,('123','documentation','file','Docs','Documentos')
,('124','filter_configure_metadata','general','Download Data','Descarga Datos')
,('191','filter_configure_folder_json','general','Configure Folder','Configura Carpeta')
,('192','filter_configure_item_json','general','Configure Item','Configura Objeto')
,('40','login_Forgot_Password','login','Forgot Password?','Olvidastes el password?')
,('41','login_Password','login','Password','Password')
,('42','login_Register_Now','login','Register Now!','Regístrate ahora!')
,('43','login_Remember_Me','login','Remember Me','Recuérdame')
,('44','login_SIGN_IN','login','SIGN IN','Entrar')
,('45','login_Sign_in_to_start_your_session','login','Sign in to start your session','Inicia tu Sesión')
,('46','login_Username','login','User name','Nombre de usuario')
,('47','mainscreen_Dashboard','mainscreen','Dashboard','Panel Inicial')
,('48','mainscreen_Datagrid','mainscreen','Json Conf','Json Conf')
,('77','make_payment','payment','Make Payment','Hacer Pagos')
,('81','pass','pass','Pass','Pass')
,('82','passes','pass','Passes','Passes')
,('83','payment','pass','Payment','Pago')
,('84','phone','pass','Phone number','Numero de Telefono')
,('92','number','HPhoneNumber','Number','Número Tlf')
,('93','extension','HPhoneNumber','Ext','Extensión')
,('94','MTlabel','MTlabel','Labels','Etiquetas')
,('95','MTlabel.en_US','MTlabel','English','Ingles')
,('96','MTlabel.es_ES','MTlabel','Spanish','Español')
,('97','MTlabel.screen','MTlabel','Screen','Pantalla')
,('98','MTlabel.mtLabelId','MTlabel','ID #','ID #')
,('99','MTlabel.shortCode','MTlabel','Short Code','Código')
,('100','DatagridSetting','DatagridSetting','Json Conf.','Json Conf.')
,('101','data','DatagridSetting','Data','data')
,('102','searchName','DatagridSetting','Screen','Pantalla')
,('103','DatagridSetting.inputUserGroupId','DatagridSetting','User Group','Grupo Usuario')
,('104','DatagridSetting.dataGridSettingId','DatagridSetting','ID #','# ID')
,('39','history','history','History','Historia')
,('125','paymentMethodId','Payment','Payment Method ','Metodo de Pago')
,('126','paymentTypeClassId','Payment','Payment Type','Tipo Pago')
,('127','invoiceid','Invoice','Invoice','factura')
,('128','url','General','URL','URL')
,('129','created','General','Created','Creado')
,('130','amountDue','Invoice','Amount Due','Cantidad')
,('134','description','Test','Description','Descripción')
,('135','keywords','Test','Keywords','Etiqueta')
,('137','parameters','event','Parameters','Parametros')
,('138','deleted','eventDefinition','Deleted','Eliminado')
,('147','shortCode','eventType','Short Code','Etiqueta')
,('148','owner','Test','Owner','Creado por')
,('156','url','EventDefinition','End Point URL','End Point URL')
,('157','json','Event','Json','Json')
,('167','fullName','VUserMultiGroup','Full Name','Nombre')
,('168','passwd','VUserMultiGroup','Password','Password')
,('169','userGroups','VUserMultiGroup','User Groups','Grupos')
,('170','loginName','VUserMultiGroup','Login Name','Login')
,('171','inputUserId','VUserMultiGroup','InputUser #','# Usuario')
,('172','inputSourceId','VUserMultiGroup','InputSource #','# Origen')
,('173','created','VUserMultiGroup','Created','Creado')
,('174','eventTypeId','EventDefinition','Event Type #','# Typo')
,('175','EventDefinition.eventName','EventDefinition','Event Name','Name')
,('176','EventDefinition.ulr','EventDefinition','Url Rest','Url Rest')
,('177','Folder.parentfolderUuid','Folder','Root Folder','Carpeta Padre')
,('178','Folder.folderUuid','Folder','Folder','Carpeta')
,('179','EventDefinition.folderUuid','EventDefinition','Folder','Carpeta')
,('180','Test.events','Test','Events','Eventos')
,('181','Test.folderUuid','Test','Folder','Carpeta')
,('182','Test.keywords','Test','Keywords','Etiquetas')
,('183','TestEvent.eventName','TestEvent','Event name','Nombre evento')
,('184','TestEvent.eventDefinitionUuid','TestEvent','Event Def #','# Def Event')
,('185','selected','TestEvent','Is Selected','Seleccionado')
,('186','TrParameter','TrParameter','Parameters','Parametros')
,('187','TrParameter.trParameterTypeId','TrParameter','Type #','# Tipo')
,('188','TrParameter.value','TrParameter','Value','valor')
,('189','TrParameter.label','TrParameter','label','Etiqueta')
,('190','TestEvent.httpMethod','TestEvent','Http Method','HTTP Metodo')
,('50','mainscreen_Event','mainscreen','Event','Evento')
,('51','mainscreen_EventDefFolder','mainscreen','Event Def Folder','Carpeta Def Evento ')
,('52','mainscreen_EventDefinition','mainscreen','Event Definition','Definicion de Evento')
,('53','mainscreen_EventType','mainscreen','Event Type','Tipo Evento')
,('56','mainscreen_Find_EventDefinition','mainscreen','Find Event Definition','Find Event Definition')
,('57','mainscreen_Find_Test','mainscreen','Find Test','Find Test')
,('58','mainscreen_Find_User','mainscreen','Find User','Buscar Usuario')
,('59','mainscreen_Folder','mainscreen','Folder','carpeta')
,('67','mainscreen_Test','mainscreen','Test','Test')
,('68','mainscreen_test_number','mainscreen','Test #','Test #')
,('49','mainscreen_Design','mainscreen','Design','Diseño')
,('54','mainscreen_exit_to_app','mainscreen','exit to app','salir de la Aplicacion')
,('55','mainscreen_examples','mainscreen','Examples','Ejemplos')
,('60','mainscreen_Forms','mainscreen','Forms','Formularios')
,('61','mainscreen_Form_Elements','mainscreen','Form Elements','Elementos de formularios')
,('62','mainscreen_Home','mainscreen','Home','Inicio')
,('63','mainscreen_Icons','mainscreen','Icons','Icons')
,('64','mainscreen_Layout','mainscreen','Layout','Layout')
,('65','mainscreen_Profile_page','mainscreen','Profile page','Perfíl')
,('66','mainscreen_System_Administration','mainscreen','System Administration','Administración')
,('69','mainscreen_Typography','mainscreen','Typography','Tipografía')
,('70','mainscreen_User','mainscreen','User','Usuario')
,('71','mainscreen_UserGroup','mainscreen','User Group','Grupo Usuario')
,('72','mainscreen_Permission','mainscreen','Permissions','Permisos')
,('73','mainscreen_Permissions_Permission','mainscreen','Permissions','Permisos')
,('74','mainscreen_Permissions_Rol','mainscreen','Rols','Roles')
,('75','mainscreen_Label','mainscreen','Label','Etiqueta')
,('76','mainscreen_Permissions_UserGroupRol','mainscreen','User Groups','Grupo Usuario')
,('105','VinputUser','VinputUser','Users','Usuarios')
,('106','inputUserGroupId','VinputUser','User Group','Grupo Usuario')
,('107','VinputUser.fullName','VinputUser','Name','Nombre')
,('108','VinputUser.inputUserId','VinputUser','ID #','# ID')
,('109','VinputUser.passwd','VinputUser','Password','Contraseña')
,('110','VinputUser.loginName','VinputUser','Login Name','Login')
,('111','VinputUser.created','VinputUser','Created','Creado')
,('112','VgroupRol','VgroupRol','User Groups','Grupos Usuarios')
,('113','VgroupRol.description','VgroupRol','Group Description','Descripción grupo')
,('114','VgroupRol.rols','VgroupRol','Rols','Roles')
,('115','VPermissionRol','VPermissionRol','Permissions','Permisos')
,('116','VPermissionRol.description','VPermissionRol','Description','Descripción')
,('117','VPermissionRol.permissionId','VPermissionRol','Permission #','# Permiso')
,('118','VPermissionRol.permissionTypeId','VPermissionRol','Permission type','Tipo Permiso')
,('119','VPermissionRol.rols','VPermissionRol','Rols','Roles')
,('120','VPermissionRol.shortCode','VPermissionRol','Short Code','Etiqueta')
,('121','VPermissionRol.permissionValueId','VPermissionRol','Value #','# Valor')
,('122','VgroupRol.shortCode','VgroupRol','Short Code','Etiqueta')
,('149','VUserMultiGroup','VUserMultiGroup','Users','Usuarios')
,('150','fullName','VUserMultiGroup','Full Name','Nombre Completo')
,('151','loginName','VUserMultiGroup','Login','Login')
,('152','userGroups','VUserMultiGroup','User Groups','Grupos')
,('153','rolId','UserGroupRol','Roll #','# Roll')
,('154','permissionId','VRolLink','Permission #','# Permiso')
,('155','userId','UserGroup','User #','# Usuario')
,('APP1000','mainscreen_AppInfo','mainscreen','App Info values','Valores de Configuración')

; -- Generated Statement 

insert into testrunner.EventDefFolder(eventdeffolderUuid,parentfolderUuid,description,eventDefinitionUuid) values 
('0',NULL,'.',NULL)
,('2','0','Input Files',NULL)
,('3','0','Checks',NULL)
,('4','0','System',NULL)
,('REST','4','REST',NULL)
,('cf8e47d2-5859-4a7a-8fd8-637ad2aae4ad','REST',NULL,'4c035182-361c-4db9-9e96-8fee1a5300de')
,('f35dae7d-11c2-4ddf-9423-96f85bc2d5db','REST',NULL,'ba02d76a-3d98-467b-a2e5-09a784893c58')
,('e50f4276-7b61-49b7-b56e-ba97311d0c00','REST',NULL,'1fff2521-8a4d-43cd-a4aa-bc0af122ea46')
,('75a33fe6-d22d-48ab-a19d-3b158ab8fd5f','REST',NULL,'346f9ee3-610d-4e59-9f15-b4e24d5950b4')
,('4a302b1f-742b-45f0-ba43-4cf4691e34fe','REST',NULL,'ed26e7e8-4a25-4d21-a429-d67ff3f65f76')

; -- Generated Statement 

insert into testrunner.EventDefinition(eventDefinitionUuid,eventTypeId,eventName,description,eventDefinition,created,inputUserId,inputSourceId) values 
('4c035182-361c-4db9-9e96-8fee1a5300de','REST_SERVICE','Get Table by PK','Get Table by PK','[ {
  "eventTypeId" : "REST_SERVICE",
  "eventName" : "Get Table by PK",
  "description" : "Get Table by PK",
  "selected" : 1,
  "url" : "/rest/api/mt/table/{tableName}/get/{pK}",
  "httpMethod" : 1,
  "parameters" : [ {
    "label" : "pK",
    "trParameterTypeId" : 2,
    "value" : ""
  }, {
    "label" : "tableName",
    "trParameterTypeId" : 1,
    "value" : ""
  } ]
} ]',getPostingDate(),1,1)
,('ba02d76a-3d98-467b-a2e5-09a784893c58','REST_SERVICE','put Table','put Table','[ {
  "eventTypeId" : "REST_SERVICE",
  "eventName" : "put Table",
  "description" : "put Table",
  "selected" : 1,
  "url" : "/rest/api/mt/table/{tableName}/put/{pK}",
  "httpMethod" : 2,
  "parameters" : [ {
    "label" : "pK",
    "trParameterTypeId" : 2,
    "value" : ""
  }, {
    "label" : "tableName",
    "trParameterTypeId" : 1,
    "value" : ""
  } ]
} ]',getPostingDate(),1,1)
,('1fff2521-8a4d-43cd-a4aa-bc0af122ea46','REST_SERVICE','Delete Table','Delete Table','[ {
  "eventTypeId" : "REST_SERVICE",
  "eventName" : "Delete Table",
  "description" : "Delete Table",
  "selected" : 1,
  "url" : "/rest/api/table/{tableName}/delete/{pK}",
  "httpMethod" : 4,
  "parameters" : [ {
    "label" : "pK",
    "trParameterTypeId" : 2,
    "value" : ""
  }, {
    "label" : "tableName",
    "trParameterTypeId" : 1,
    "value" : ""
  } ]
} ]',getPostingDate(),1,1)
,('346f9ee3-610d-4e59-9f15-b4e24d5950b4','REST_SERVICE','Create Table','Create Table','[ {
  "eventTypeId" : "REST_SERVICE",
  "eventName" : "Create Table",
  "description" : "Create Table",
  "selected" : 1,
  "url" : "/rest/api/table/{tableName}/insert",
  "httpMethod" : 3,
  "parameters" : [ {
    "label" : "tableName",
    "trParameterTypeId" : 1,
    "value" : ""
  } ]
} ]',getPostingDate(),1,1)
,('ed26e7e8-4a25-4d21-a429-d67ff3f65f76','REST_SERVICE','Search Table','Search Table','[ {
  "eventTypeId" : "REST_SERVICE",
  "eventName" : "Search Table",
  "description" : "Search Table",
  "selected" : 1,
  "url" : "/rest/api/search/table/{tableName}?page={page}&size={size}&orderBy={orderBy}",
  "httpMethod" : 3,
  "parameters" : [ {
    "label" : "tableName",
    "trParameterTypeId" : 1,
    "value" : ""
  }, {
    "label" : "page",
    "trParameterTypeId" : 2,
    "value" : "0"
  }, {
    "label" : "size",
    "trParameterTypeId" : 2,
    "value" : "15"
  }, {
    "label" : "orderBy",
    "trParameterTypeId" : 1,
    "value" : ""
  } ],
  "json" : "{\"and\":[{\"parameters\":[{\"fieldName\":\"bookid\",\"operator\":\"EQUAL\",\"values\":[1]}]}]}"
} ]',getPostingDate(),1,1)

; -- Generated Statement 

insert into testrunner.Folder(folderUuid,parentfolderUuid,description,testUuid) values 
('1',NULL,'c:',NULL)
,('2','1','Tester',NULL)
,('3','1','Developers',NULL)
,('4','3','System',NULL)

; -- Generated Statement 

insert into testrunner.EventStatus(eventStatusId,shortCode,description) values 
(1,'NEW','None')
,(2,'WAITING','Waiting')
,(3,'PROCESSING','Processing')
,(4,'ERROR','Error')
,(5,'DONE','Done')

; -- Generated Statement 

insert into testrunner.Operator(operatorId,shortCode,description) values 
(1,'EQUAL','EQUAL')
,(2,'NOT_EQUAL','NOT EQUAL')
,(3,'LT','LOWER THAN')
,(4,'LE','LOWER OR EQUAL')
,(5,'GE','GREATER OR EQUAL')
,(6,'GT','GREATER THAN')
,(7,'IN','IN')
,(8,'NOT_IN','NOT IN')
,(9,'BETWEEN','BETWEEN')
,(10,'LIKE','LIKE')
,(11,'ILIKE','ILIKE')
,(12,'_NULL','NULL')
,(13,'NOT_NULL','NOT NULL')
,(14,'CHECK','CHECK')

; -- Generated Statement 

insert into config.DatagridSetting(dataGridSettingId,searchName,data,created,inputUserGroupId,inputUserId,inputSourceId) values 
('646eef22-6f36-4984-a804-ac07ff9378a3','AddParameterDefinition','{
  "dataTableName" : "testrunner.AddParameterDefinition",
  "aSName" : "AddParameterDefinition",
  "columnConfigurations" : [ {
    "name" : "eventTypeId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "eventName",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "description",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "parameters",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "eventDefinitionUuid",
    "hidden" : true,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "eventTypeId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "eventDefinition.eventTypeId"
  }, {
    "name" : "eventName",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "eventDefinition.eventName"
  }, {
    "name" : "description",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Descripción"
  }, {
    "name" : "parameters",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Parametros"
  }, {
    "name" : "eventDefinitionUuid",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "eventDefinition.eventDefinitionUuid"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventName"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventTypeId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "parameters"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventDefinitionUuid"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventTypeId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "newLine" : true,
    "sClass" : "col-md-12",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "parameters"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventDefinitionUuid"
  } ],
  "editConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "eventName"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "eventTypeId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-8",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "newLine" : true,
    "sClass" : "col-md-12",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "parameters"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "eventDefinitionUuid"
  } ]
}',getPostingDate(),'1',1,1)

; -- Generated Statement 

insert into audit.InputUser(inputUserId,loginName,passwd,fullName,created,inputSourceId,email) values 
('3','dmartin','16902eb285c866dcebf9b359c15ff3c3','David Martin',getPostingDate(),1,'raulito.ripoll@gmail.com')
,('4','jsantos','16902eb285c866dcebf9b359c15ff3c3','Javier Santos',getPostingDate(),1,NULL)

; -- Generated Statement 

insert into audit.UserGroup(userGroupId,inputUserGroupId,userId,created,inputUserId,inputSourceId) values 
('3','3','4',getPostingDate(),1,1)
,('4','3','3',getPostingDate(),1,1)
,('5','2','3',getPostingDate(),1,1)
,('6','5','2',getPostingDate(),1,1)

; -- Generated Statement 

insert into config.AppInfoTree(appInfoTreeId,parentAppInfoTreeId,description,appInfoId) values 
('FILE_FOLDER','1','Folder Info',NULL)
,('FILE_LOG','FILE_FOLDER',NULL,'FILE_LOG')
,('FILE_TMP','FILE_FOLDER',NULL,'FILE_TMP')
,('FILE_DOCEXAMPLE','FILE_FOLDER',NULL,'FILE_DOCEXAMPLE')
,('FILE_PATH','FILE_FOLDER',NULL,'FILE_PATH')

; -- Generated Statement 

insert into config.AppInfo(appInfoId,sKey,type,sValue,inputUserGroupId) values 
('FILE_LOG','LOG','1','logs/',1)
,('FILE_TMP','TMP','1','tmp/',1)
,('FILE_DOCEXAMPLE','DOCEXAMPLE','1','example/input/documents/',1)
,('FILE_PATH','PATH','1','',1)

; -- Generated Statement 

insert into config.AppInfoTree(appInfoTreeId,parentAppInfoTreeId,description,appInfoId) values 
('TESTRUNNER','1','Test Runner',NULL)
,('App_Url','TESTRUNNER',NULL,'APP_API_URL')
,('Job_Url','TESTRUNNER',NULL,'JOB_API_URL')
,('testRunner_Url','TESTRUNNER',NULL,'TESTRUNNER_API_URL')
,('sendEmailwhenError','TESTRUNNER',NULL,'sendEmailwhenError')

; -- Generated Statement 

insert into config.AppInfo(appInfoId,sKey,type,sValue,inputUserGroupId) values 
('TESTRUNNER_API_URL','TESTRUNNER_API_URL','1','Http://localHost:8081',1)
,('APP_API_URL','APP_API_URL','1','Http://localHost:8081',1)
,('JOB_API_URL','JOB_API_URL','1','Http://localHost:8081',1)
,('sendEmailwhenError','Send Email When Error','3','true',1)

; -- Generated Statement 

insert into config.DatagridSetting(dataGridSettingId,searchName,data,created,inputUserGroupId,inputUserId,inputSourceId) values 
('58123dfa-6225-4524-870d-368bd41f8559','Folder','{
  "dataTableName" : "testrunner.Folder",
  "aSName" : "Folder",
  "columnConfigurations" : [ {
    "name" : "folderUuid",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "parentfolderUuid",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "description",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "folderUuid",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Carpeta"
  }, {
    "name" : "parentfolderUuid",
    "asc" : false,
    "active" : true,
    "hidden" : false,
    "label" : "# Carpeta Padre"
  }, {
    "name" : "description",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Descripción"
  } ],
  "filterConfigurations" : [ {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "folderUuid"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "parentfolderUuid"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "folderUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "parentfolderUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "folderUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "parentfolderUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "description"
  } ]
}',getPostingDate(),'1',1,1)
,('9','EventType','{
  "dataTableName" : "testrunner.EventType",
  "aSName" : "EventType",
  "columnConfigurations" : [ {
    "name" : "eventTypeId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "shortCode",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "description",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "eventTypeId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "eventType.eventTypeId"
  }, {
    "name" : "shortCode",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Etiqueta"
  }, {
    "name" : "description",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Descripción"
  } ],
  "filterConfigurations" : [ {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventTypeId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "shortCode"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventTypeId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "shortCode"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ ],
    "active" : true,
    "name" : "eventTypeId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "shortCode"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "description"
  } ]
}',getPostingDate(),'1',1,1)
,('12','TestTree','{
  "dataTableName" : "testrunner.TestTree",
  "aSName" : "TestTree",
  "columnConfigurations" : [ {
    "name" : "testUuid",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "testname",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "description",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "FOLDERPATH",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "keywords",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "events",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputUserId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputSourceId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "created",
    "hidden" : true,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "testUuid",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "test"
  }, {
    "name" : "FOLDERPATH",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Carpeta"
  }, {
    "name" : "testname",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Nombre Test"
  }, {
    "name" : "description",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Descripción"
  }, {
    "name" : "keywords",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Etiqueta"
  }, {
    "name" : "events",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "test.events"
  }, {
    "name" : "inputUserId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "test.inputUserId"
  }, {
    "name" : "inputSourceId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "test.inputSourceId"
  }, {
    "name" : "created",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Creado"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testUuid"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "FOLDERPATH"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testname"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "keywords"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "events"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testname"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "keywords"
  }, {
    "hidden" : false,
    "newLine" : true,
    "sClass" : "col-md-12",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "events"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "testUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "testname"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "keywords"
  }, {
    "hidden" : false,
    "newLine" : true,
    "sClass" : "col-md-12",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "events"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "created"
  } ]
}',getPostingDate(),'1',1,1)
,('1dfbea9b-63b6-4af6-ac3b-474845513d8c','StoreValuesTest','{
  "dataTableName" : "testrunner.StoreValuesTest",
  "aSName" : "StoreValuesTest",
  "columnConfigurations" : [ {
    "name" : "storeValuestestId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "testRunner_Api_Url",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "App_Api_Url",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "Job_Api_Url",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "storeValuesEvents",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "storeValuestestId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesTest.storeValuestestId"
  }, {
    "name" : "testRunner_Api_Url",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesTest.testRunner_Api_Url"
  }, {
    "name" : "App_Api_Url",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesTest.App_Api_Url"
  }, {
    "name" : "Job_Api_Url",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesTest.Job_Api_Url"
  }, {
    "name" : "storeValuesEvents",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesTest.storeValuesEvents"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "storeValuestestId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testRunner_Api_Url"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "App_Api_Url"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "Job_Api_Url"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "storeValuesEvents"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "storeValuestestId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testRunner_Api_Url"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "App_Api_Url"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "Job_Api_Url"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-12",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "storeValuesEvents"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ ],
    "active" : true,
    "name" : "storeValuestestId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "testRunner_Api_Url"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "App_Api_Url"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "Job_Api_Url"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-12",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ ],
    "active" : true,
    "name" : "storeValuesEvents"
  } ]
}',getPostingDate(),'1',1,1)
,('dd7a9428-45b7-4620-97c1-25fc6ae1357e','StoreValuesEvent','{
  "dataTableName" : "testrunner.StoreValuesEvent",
  "aSName" : "StoreValuesEvent",
  "columnConfigurations" : [ {
    "name" : "storeValuesEventid",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "eventName",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "status",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "data",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "log",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "storeValuesEventid",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesEvent.storeValuesEventid"
  }, {
    "name" : "eventName",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesEvent.eventName"
  }, {
    "name" : "data",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesEvent.data"
  }, {
    "name" : "log",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesEvent.log"
  }, {
    "name" : "status",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "StoreValuesEvent.status"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "storeValuesEventid"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventName"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "data"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "log"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "status"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "storeValuesEventid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "data"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "log"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "status"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "storeValuesEventid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "eventName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "active" : true,
    "name" : "data"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ ],
    "active" : true,
    "name" : "log"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "available" : true,
    "constraints" : [ ],
    "active" : true,
    "name" : "status"
  } ]
}',getPostingDate(),'1',1,1)
,('d74a236d-dcdd-498a-ba77-23cc2038237e','EventDefFolder','{
  "dataTableName" : "testrunner.EventDefFolder",
  "aSName" : "EventDefFolder",
  "columnConfigurations" : [ {
    "name" : "eventdeffolderUuid",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "parentfolderUuid",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "description",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "parentfolderUuid",
    "asc" : false,
    "active" : true,
    "hidden" : false,
    "label" : "# Carpeta Padre"
  }, {
    "name" : "eventdeffolderUuid",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Carpeta Def Evento"
  }, {
    "name" : "description",
    "asc" : false,
    "active" : true,
    "hidden" : false,
    "label" : "Descripción"
  } ],
  "filterConfigurations" : [ {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventdeffolderUuid"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "parentfolderUuid"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "eventdeffolderUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "parentfolderUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "eventdeffolderUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "parentfolderUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "description"
  } ]
}',getPostingDate(),'1',1,1)
,('4b2aedf2-5ec3-4d27-8aee-421df8741292','Test','{
  "dataTableName" : "testrunner.Test",
  "aSName" : "Test",
  "columnConfigurations" : [ {
    "name" : "testUuid",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "testname",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "description",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "keywords",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "events",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputUserId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputSourceId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "created",
    "hidden" : true,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "testUuid",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Test"
  }, {
    "name" : "testname",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Nombre Test"
  }, {
    "name" : "description",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Descripción"
  }, {
    "name" : "keywords",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Etiquetas"
  }, {
    "name" : "events",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Eventos"
  }, {
    "name" : "inputUserId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Test.inputUserId"
  }, {
    "name" : "inputSourceId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Test.inputSourceId"
  }, {
    "name" : "created",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Creado"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testUuid"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testname"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "keywords"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "events"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "testname"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "keywords"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "events"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "created"
  } ],
  "editConfigurations" : [ {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "testUuid"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "testname"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "description"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "keywords"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-12",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "events"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "inputSourceId"
  }, {
    "hidden" : true,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "created"
  } ]
}',getPostingDate(),'1',1,1)
,('c253a9a2-e0ad-4b4e-9b38-8720eecd9d73','EventDefinition','{
  "dataTableName": "testrunner.EventDefinition",
  "aSName": "EventDefinition",
  "columnConfigurations": [
    {
      "name": "eventDefinitionUuid",
      "hidden": true,
      "available": true,
      "active": true
    },
    {
      "name": "eventTypeId",
      "hidden": false,
      "available": true,
      "active": true
    },
    {
      "name": "eventName",
      "hidden": false,
      "available": true,
      "active": true
    },
    {
      "name": "description",
      "hidden": false,
      "available": true,
      "active": true
    },
    {
      "name": "eventDefinition",
      "hidden": true,
      "available": true,
      "active": true
    },
    {
      "name": "created",
      "hidden": true,
      "available": true,
      "active": true
    },
    {
      "name": "inputUserId",
      "hidden": true,
      "available": true,
      "active": true
    },
    {
      "name": "inputSourceId",
      "hidden": true,
      "available": true,
      "active": true
    }
  ],
  "orderByConfigurations": [
    {
      "name": "eventDefinitionUuid",
      "asc": false,
      "active": false,
      "hidden": false,
      "label": "EventDefinition.eventDefinitionUuid"
    },
    {
      "name": "eventTypeId",
      "asc": false,
      "active": false,
      "hidden": false,
      "label": "# Typo"
    },
    {
      "name": "eventName",
      "asc": false,
      "active": false,
      "hidden": false,
      "label": "Name"
    },
    {
      "name": "description",
      "asc": false,
      "active": false,
      "hidden": false,
      "label": "Descripción"
    },
    {
      "name": "eventDefinition",
      "asc": false,
      "active": false,
      "hidden": false,
      "label": "EventDefinition.eventDefinition"
    },
    {
      "name": "created",
      "asc": false,
      "active": false,
      "hidden": false,
      "label": "Creado"
    },
    {
      "name": "inputUserId",
      "asc": false,
      "active": false,
      "hidden": false,
      "label": "EventDefinition.inputUserId"
    },
    {
      "name": "inputSourceId",
      "asc": false,
      "active": false,
      "hidden": false,
      "label": "EventDefinition.inputSourceId"
    }
  ],
  "filterConfigurations": [
    {
      "hidden": false,
      "operator": "EQUAL",
      "required": false,
      "available": true,
      "active": true,
      "name": "eventDefinitionUuid"
    },
    {
      "hidden": false,
      "operator": "EQUAL",
      "required": false,
      "available": true,
      "active": true,
      "name": "eventTypeId"
    },
    {
      "hidden": false,
      "operator": "EQUAL",
      "required": false,
      "available": true,
      "active": true,
      "name": "eventName"
    },
    {
      "hidden": false,
      "operator": "EQUAL",
      "required": false,
      "available": true,
      "active": true,
      "name": "description"
    },
    {
      "hidden": false,
      "operator": "EQUAL",
      "required": false,
      "available": true,
      "active": true,
      "name": "eventDefinition"
    },
    {
      "hidden": true,
      "operator": "EQUAL",
      "required": false,
      "available": true,
      "active": true,
      "name": "created"
    },
    {
      "hidden": true,
      "operator": "EQUAL",
      "required": false,
      "available": true,
      "active": true,
      "name": "inputUserId"
    },
    {
      "hidden": true,
      "operator": "EQUAL",
      "required": false,
      "available": true,
      "active": true,
      "name": "inputSourceId"
    }
  ],
  "detailScreenConfigurations": [
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "available": true,
      "active": true,
      "name": "eventDefinitionUuid"
    },
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "available": true,
      "active": true,
      "name": "eventTypeId"
    },
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "available": true,
      "active": true,
      "name": "eventName"
    },
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "available": true,
      "active": true,
      "name": "description"
    },
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "available": true,
      "active": true,
      "name": "eventDefinition"
    },
    {
      "hidden": true,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "available": true,
      "active": true,
      "name": "created"
    },
    {
      "hidden": true,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "available": true,
      "active": true,
      "name": "inputUserId"
    },
    {
      "hidden": true,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "available": true,
      "active": true,
      "name": "inputSourceId"
    }
  ],
  "editConfigurations": [
    {
      "hidden": true,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "actions": [
        {
          "action": "visibility",
          "objetives": [],
          "values": []
        }
      ],
      "constraints": [
        "com.jsantos.custom.constraints.DefaultMTConstraint"
      ],
      "available": true,
      "active": true,
      "name": "eventDefinitionUuid"
    },
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-4",
      "required": true,
      "actions": [
        {
          "action": "visibility",
          "objetives": [],
          "values": []
        }
      ],
      "constraints": [
        "com.jsantos.custom.constraints.DefaultMTConstraint"
      ],
      "available": true,
      "active": true,
      "name": "eventTypeId"
    },
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-4",
      "required": true,
      "actions": [
        {
          "action": "visibility",
          "objetives": [],
          "values": []
        }
      ],
      "constraints": [
        "com.jsantos.custom.constraints.DefaultMTConstraint"
      ],
      "available": true,
      "active": true,
      "name": "eventName"
    },
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "actions": [
        {
          "action": "visibility",
          "objetives": [],
          "values": []
        }
      ],
      "constraints": [
        "com.jsantos.custom.constraints.DefaultMTConstraint"
      ],
      "available": true,
      "active": true,
      "name": "description"
    },
    {
      "hidden": false,
      "newLine": false,
      "sClass": "col-md-12",
      "required": false,
      "actions": [
        {
          "action": "visibility",
          "objetives": [],
          "values": []
        }
      ],
      "constraints": [],
      "available": true,
      "active": true,
      "name": "eventDefinition"
    },
    {
      "hidden": true,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "actions": [
        {
          "action": "visibility",
          "objetives": [],
          "values": []
        }
      ],
      "constraints": [
        "com.jsantos.custom.constraints.DefaultMTConstraint"
      ],
      "available": true,
      "active": true,
      "name": "created"
    },
    {
      "hidden": true,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "actions": [
        {
          "action": "visibility",
          "objetives": [],
          "values": []
        }
      ],
      "constraints": [
        "com.jsantos.custom.constraints.DefaultMTConstraint"
      ],
      "available": true,
      "active": true,
      "name": "inputUserId"
    },
    {
      "hidden": true,
      "newLine": false,
      "sClass": "col-md-4",
      "required": false,
      "actions": [
        {
          "action": "visibility",
          "objetives": [],
          "values": []
        }
      ],
      "constraints": [
        "com.jsantos.custom.constraints.DefaultMTConstraint"
      ],
      "available": true,
      "active": true,
      "name": "inputSourceId"
    }
  ]
}',getPostingDate(),'1',1,1)

; -- Generated Statement 

insert into label.MTlabel(mtLabelId,shortCode,screen,en_US,es_ES) values 
('TEST131','mainscreen_TestRunner','mainscreen','Test Runner','Test Runner')
,('TEST132','testUuid','Test','Test','Test')
,('TEST133','testname','Test','Test Name','Nombre Test')
,('TEST136','eventUuid','event','Event #','# Evento')
,('TEST139','EventDefinition','eventDefinition','Event Definition','Definición evento')
,('TEST140','httpMethod','eventDefinition','Http Method','Http Metodo')
,('TEST141','folderUuid','EventDefinition','Folder #','# Carpeta')
,('TEST142','eventdefinitionUuid','EventDefinition','Event definition #','# Definicion Evento')
,('TEST143','eventtypeUuid','EventDefinition','Event Type #','# Tipo Evento')
,('TEST144','eventDefFolder','EventDefFolder','Event Def Folder','Carpeta Definicion Evento')
,('TEST145','parentfolderUuid','EventDefFolder','Parent Folder #','# Carpeta Padre')
,('TEST146','eventdeffolderUuid','EventDefFolder','Event Def Folder #','Carpeta Def Evento')
,('TEST91','InputUser.fullName','InputUser','Full Name','Nombre Completo')
,('TEST1000','StoreValuesTest','StoreValuesTest','Test Results','Resultado Test')
,('TEST1003','storeValuesEvents','StoreValuesTest','Result','Resultado')
,('TEST1005','StoreValuesEvent','StoreValuesEvent','Event Results','Resultado Eventos')
,('TEST1006','StoreValuesEvent.data','StoreValuesEvent','Result','Resultado')
,('TEST1007','eventName','StoreValuesEvent','Event Name','Nombre Evento')
,('TEST1008','StoreValuesEvent.log','StoreValuesEvent','Log','Log')
,('TEST1009','status','StoreValuesEvent','Status','Estado')
,('TEST1010','TestTree','TestTree','Test','Test')
,('TEST1011','TestTree.testname','TestTree','Test Name','Nombre Test')
,('TEST1012','TestTree.events','TestTree','Events','Eventos')
,('TEST1013','eventTypeId','TestEvent','Event Type #','# Tipo Evento')
,('TEST1014','mainscreen_TestTree','mainscreen','Test Tree','Arbol de Tests')
,('TEST1015','mainscreen_eventDefTree','mainscreen','Event Def. Tree','Definición Eventos')
,('TEST1016','CheckParameterItem','CheckParameterItem','Check Parameter Item','Parametro a Chequear')
,('TEST1017','CheckParameterItem.checkValue','CheckParameterItem','Check Value','Valor a Comparar')
,('TEST1018','CheckParameterItem.checkValueTypeId','CheckParameterItem','Check Value Type','Tipo del valor a Comparar')
,('TEST1019','CheckParameterItem.operator','CheckParameterItem','Operator','Operador')
,('TEST1020','value','CheckParameterItem','Value','Valor')
,('TEST1021','mainscreen_TestSearch','mainscreen','Search Test','Buscar Test')
,('TEST1022','StoreValuesTest.app_Api_Url','StoreValuesTest','App Api URL','App Api URL')
,('TEST1023','StoreValuesTest.testRunner_Api_Url','StoreValuesTest','TestRunner Api URL','TestRunner Api URL')
,('TEST1024','StoreValuesTest.job_Api_Url','StoreValuesTest','Job Api URL','Job Api URL')
,('3b4a2d7c-0eec-458c-89a0-8f65c25f850a','RunTestEventDefinition.testId','RunTestEventDefinition','Test #','# Test')
,('46145c01-9ab7-4b13-95b1-538349d83d88','RunTestEventDefinition.repetitionNumber','RunTestEventDefinition','Repetition Number','Numero Repeticiones')
,('3d8b7633-2379-49e8-992f-b434e7df6853','FOLDERPATH','SEARCHTEST','Folder Path','Carpeta')

; -- Generated Statement 

insert into testrunner.Test(testUuid,testname,description,keywords,events,inputUserId,inputSourceId,created) values 
('REST','TEST','','','[ {
  "eventTypeId" : "ADD_PARAMETERS",
  "eventName" : "adding pK",
  "description" : "this parameter should be use as $.pK",
  "selected" : 1,
  "parameters" : [ {
    "label" : "pK",
    "trParameterTypeId" : 2,
    "value" : "1"
  } ]
}, {
  "eventDefinitionUuid" : "1",
  "eventTypeId" : "REST_SERVICE",
  "eventName" : "get book 1",
  "description" : "Get Table by PK",
  "selected" : 1,
  "url" : "/rest/api/mt/table/{tableName}/get/{pK}",
  "httpMethod" : 1,
  "parameters" : [ {
    "label" : "pK",
    "trParameterTypeId" : 1,
    "value" : "$.pK"
  }, {
    "label" : "tableName",
    "trParameterTypeId" : 2,
    "value" : "BOOK"
  } ]
}, {
  "eventDefinitionUuid" : "5",
  "eventTypeId" : "REST_SERVICE",
  "eventName" : "Search Table",
  "description" : "Search Table",
  "selected" : 1,
  "url" : "/rest/api/search/table/{tableName}?page={page}&size={size}&orderBy={orderBy}",
  "httpMethod" : 3,
  "parameters" : [ {
    "label" : "tableName",
    "trParameterTypeId" : 2,
    "value" : "author"
  }, {
    "label" : "page",
    "trParameterTypeId" : 1,
    "value" : "0"
  }, {
    "label" : "size",
    "trParameterTypeId" : 1,
    "value" : "10"
  }, {
    "label" : "orderBy",
    "trParameterTypeId" : 2,
    "value" : ""
  } ],
  "json" : "{\"and\":[{\"parameters\":[{\"fieldName\":\"fullName\",\"operator\":\"LIKE\",\"values\":[\"$.fullName\"]}]}]}"

} ]',1,1,getPostingDate())

; -- Generated Statement 

insert into testrunner.Folder(folderUuid,parentfolderUuid,description,testUuid) values 
('5','3',NULL,'REST')

; -- Generated Statement 

insert into testrunner.Test(testUuid,testname,description,keywords,events,inputUserId,inputSourceId,created) values 
('JSONEXAMPLE','Get Json Example','','','[ {
  "eventDefinitionUuid" : "1",
  "eventTypeId" : "REST_SERVICE",
  "eventName" : "Reset Db",
  "description" : "Reset Db",
  "selected" : 1,
  "url" : "/rest/api/development/system/reset-db",
  "httpMethod" : 1,
  "parameters" : [ {
    "label" : "tableName",
    "trParameterTypeId" : 2,
    "value" : "$.tableName"
  } ]
} ]',1,1,getPostingDate())

; -- Generated Statement 

insert into testrunner.Folder(folderUuid,parentfolderUuid,description,testUuid) values 
('6','2',NULL,'JSONEXAMPLE')

; -- Generated Statement 

ALTER TABLE audit.InputUser ADD CONSTRAINT FK_audit_InputUser_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE audit.UserGroup ADD CONSTRAINT FK_audit_UserGroup_inputUserGroupId FOREIGN KEY(inputUserGroupId)  REFERENCES audit.InputUserGroup(inputUserGroupId)
; -- Generated Statement 

ALTER TABLE audit.UserGroup ADD CONSTRAINT FK_audit_UserGroup_userId FOREIGN KEY(userId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE audit.UserGroup ADD CONSTRAINT FK_audit_UserGroup_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE audit.UserGroup ADD CONSTRAINT FK_audit_UserGroup_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE config.AppInfo ADD CONSTRAINT FK_config_AppInfo_type FOREIGN KEY(type)  REFERENCES config.AppDataType(appDataTypeId)
; -- Generated Statement 

ALTER TABLE config.AppInfo ADD CONSTRAINT FK_config_AppInfo_inputUserGroupId FOREIGN KEY(inputUserGroupId)  REFERENCES audit.InputUserGroup(inputUserGroupId)
; -- Generated Statement 

ALTER TABLE config.AppInfoTree ADD CONSTRAINT FK_config_AppInfoTree_parentAppInfoTreeId FOREIGN KEY(parentAppInfoTreeId)  REFERENCES config.AppInfoTree(appInfoTreeId)
; -- Generated Statement 

ALTER TABLE config.AppInfoTree ADD CONSTRAINT FK_config_AppInfoTree_appInfoId FOREIGN KEY(appInfoId)  REFERENCES config.AppInfo(appInfoId)
; -- Generated Statement 

ALTER TABLE common.FileGroup ADD CONSTRAINT FK_common_FileGroup_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE common.FileGroup ADD CONSTRAINT FK_common_FileGroup_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE common.StorageFile ADD CONSTRAINT FK_common_StorageFile_storageFileId FOREIGN KEY(storageFileId)  REFERENCES common.StorageFilePk(storageFileId)
; -- Generated Statement 

ALTER TABLE common.StorageFile ADD CONSTRAINT FK_common_StorageFile_fileGroupId FOREIGN KEY(fileGroupId)  REFERENCES common.FileGroup(fileGroupId)
; -- Generated Statement 

ALTER TABLE common.StorageFile ADD CONSTRAINT FK_common_StorageFile_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE common.StorageFile ADD CONSTRAINT FK_common_StorageFile_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE config.DatagridSetting ADD CONSTRAINT FK_config_DatagridSetting_inputUserGroupId FOREIGN KEY(inputUserGroupId)  REFERENCES audit.InputUserGroup(inputUserGroupId)
; -- Generated Statement 

ALTER TABLE config.DatagridSetting ADD CONSTRAINT FK_config_DatagridSetting_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE config.DatagridSetting ADD CONSTRAINT FK_config_DatagridSetting_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE testrunner.EventDefFolder ADD CONSTRAINT FK_testrunner_EventDefFolder_parentfolderUuid FOREIGN KEY(parentfolderUuid)  REFERENCES testrunner.EventDefFolder(eventdeffolderUuid)
; -- Generated Statement 

ALTER TABLE testrunner.EventDefFolder ADD CONSTRAINT FK_testrunner_EventDefFolder_eventDefinitionUuid FOREIGN KEY(eventDefinitionUuid)  REFERENCES testrunner.EventDefinition(eventDefinitionUuid)
; -- Generated Statement 

ALTER TABLE testrunner.EventDefinition ADD CONSTRAINT FK_testrunner_EventDefinition_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE testrunner.EventDefinition ADD CONSTRAINT FK_testrunner_EventDefinition_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE testrunner.Folder ADD CONSTRAINT FK_testrunner_Folder_parentfolderUuid FOREIGN KEY(parentfolderUuid)  REFERENCES testrunner.Folder(folderUuid)
; -- Generated Statement 

ALTER TABLE testrunner.Folder ADD CONSTRAINT FK_testrunner_Folder_testUuid FOREIGN KEY(testUuid)  REFERENCES testrunner.Test(testUuid)
; -- Generated Statement 

ALTER TABLE testrunner.Test ADD CONSTRAINT FK_testrunner_Test_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE testrunner.Test ADD CONSTRAINT FK_testrunner_Test_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-audit/src/main/resources/metadata/audit/view/VUserMultiGroup.sql ---------------
create view audit.VUserMultiGroup as
select 
iu.* 
,'' userGroups
from 
audit.InputUser iu

--- End of Dependency file: /poyake-audit/src/main/resources/metadata/audit/view/VUserMultiGroup.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-audit/src/main/resources/metadata/audit/view/VinputUser.sql ---------------
create view audit.VinputUser as
select 
iu.* 
,ug.inputUserGroupId
from 
audit.InputUser iu
join audit.UserGroup ug on ug.userId=iu.inputUserId

--- End of Dependency file: /poyake-audit/src/main/resources/metadata/audit/view/VinputUser.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-audit/src/main/resources/metadata/audit/view/VinputUserMulti.sql ---------------
create view audit.VinputUserMulti as
select 
iu.* ,
'' as usergroups
from 
audit.InputUser iu
--- End of Dependency file: /poyake-audit/src/main/resources/metadata/audit/view/VinputUserMulti.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-audit/src/main/resources/metadata/audit/view/VuserGroup.sql ---------------
create view audit.VuserGroup as
select 
ug.* 
,iu.loginname
,iu.fullName
,eiug.shortCode groupName 
,eiug.description groupDescription
from 
audit.UserGroup ug
join audit.InputUser iu on ug.userId=iu.inputUserId
join audit.InputUserGroup eiug on eiug.inputUserGroupId=ug.inputUserGroupId
--- End of Dependency file: /poyake-audit/src/main/resources/metadata/audit/view/VuserGroup.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-file/src/main/resources/metadata/common/view/File.sql ---------------
create view common.Fileshow as 
select fileGroupId from common.FileGroup
--- End of Dependency file: /poyake-file/src/main/resources/metadata/common/view/File.sql

; -- Generated Statement 


; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-testrunner/src/main/resources/metadata/testrunner/view/TestTree.sql ---------------
CREATE  VIEW testrunner.TestTree AS
SELECT
    t.*,
    testrunner.GETFOLDERPATH(f.FOLDERUuid) AS FOLDERPATH
FROM testrunner.test t  
left join  testrunner.folder f on t.testUuid=f.testUuid; 


--- End of Dependency file: /poyake-testrunner/src/main/resources/metadata/testrunner/view/TestTree.sql

; -- Generated Statement 


; -- Generated Statement 


; -- Generated Statement 


; -- Generated Statement 


; -- Generated Statement 


; -- Generated Statement 


; -- Generated Statement 

