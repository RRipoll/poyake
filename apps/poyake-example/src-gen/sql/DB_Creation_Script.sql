-- Generated Script file for DEFAULT !!!
-- Generated at Sun Oct 03 20:23:27 CEST 2021 
CREATE SCHEMA example
; -- Generated Statement 

CREATE SCHEMA audit
; -- Generated Statement 

CREATE SCHEMA config
; -- Generated Statement 

CREATE SCHEMA label
; -- Generated Statement 

CREATE SEQUENCE example.Seq_Author_authorId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE example.Seq_Book_bookId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE example.Seq_BookAuthor_bookAuthorId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE example.Seq_Genre_genreId START WITH 1000
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

CREATE SEQUENCE config.Seq_DatagridSetting_dataGridSettingId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE config.Seq_Enulocale_enuLocaleId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE label.Seq_MTlabel_mtLabelId START WITH 1000
; -- Generated Statement 

CREATE TABLE example.Author(
	authorId INT,
	fullName VARCHAR(256) NOT NULL ,
	note VARCHAR(8000)
,CONSTRAINT PK_example_Author PRIMARY KEY (authorId))
; -- Generated Statement 

CREATE TABLE example.Book(
	bookId INT,
	title VARCHAR(256) NOT NULL ,
	authorId INT NOT NULL ,
	description VARCHAR(300),
	doc INT,
	genreId INT
,CONSTRAINT PK_example_Book PRIMARY KEY (bookId))
; -- Generated Statement 

CREATE TABLE example.BookAuthor(
	bookAuthorId INT,
	bookId INT NOT NULL ,
	authorId INT NOT NULL 
,CONSTRAINT PK_example_BookAuthor PRIMARY KEY (bookAuthorId))
; -- Generated Statement 

CREATE TABLE example.Genre(
	genreId INT NOT NULL ,
	shortCode VARCHAR(16) NOT NULL ,
	description VARCHAR(32) NOT NULL 
,CONSTRAINT PK_example_Genre PRIMARY KEY (genreId))
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

insert into example.Author(authorId,fullName,note) values 
('1','Cervantes','')
,('2','Vargas Llosa','')
,('3','Raúl','')
,('4','Javier','')

; -- Generated Statement 

insert into example.Book(bookId,title,authorId,description,doc,genreId) values 
('1','El Quijote','1',NULL,NULL,'1')
,('2','Novelas Ejemplares','1',NULL,NULL,'1')
,('3','La ciudad y los Perros','2',NULL,NULL,'1')

; -- Generated Statement 

insert into example.Genre(genreId,shortCode,description) values 
(1,'SF','Science Fiction')

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

insert into config.DatagridSetting(dataGridSettingId,searchName,data,created,inputUserGroupId,inputUserId,inputSourceId) values 
('6','VBook','{
  "dataTableName" : "example.VBook",
  "aSName" : "VBook",
  "columnConfigurations" : [ {
    "name" : "bookId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "title",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "authorId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "description",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "doc",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "otherAuthor",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "bookId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "VBook.bookId"
  }, {
    "name" : "title",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Title"
  }, {
    "name" : "authorId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Author #"
  }, {
    "name" : "description",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Description"
  }, {
    "name" : "doc",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Docs"
  }, {
    "name" : "otherAuthor",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Other Autors"
  } ],
  "filterConfigurations" : [ {
    "hidden" : true,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "bookId"
  }, {
    "hidden" : false,
    "operator" : "LIKE",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "title"
  }, {
    "hidden" : true,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "authorId"
  }, {
    "hidden" : false,
    "operator" : "LIKE",
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
    "name" : "doc"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "otherAuthor"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "bookId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-6",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "title"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "authorId"
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
    "sClass" : "col-md-12",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "doc"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-12",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "otherAuthor"
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
    "name" : "bookId"
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
    "name" : "title"
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
    "name" : "authorId"
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
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "description"
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
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "otherAuthor"
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
    "name" : "doc"
  } ]
}',getPostingDate(),'1',1,1)
,('7','Author','{
  "dataTableName" : "example.Author",
  "aSName" : "Author",
  "columnConfigurations" : [ {
    "name" : "authorId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "fullName",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "note",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "authorId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Author #"
  }, {
    "name" : "fullName",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Full Name"
  }, {
    "name" : "note",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Author.note"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "authorId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "fullName"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "note"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "authorId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "fullName"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "note"
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
    "name" : "authorId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-12",
    "required" : true,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "fullName"
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
    "constraints" : [ "com.jsantos.custom.constraints.DefaultMTConstraint" ],
    "available" : true,
    "active" : true,
    "name" : "note"
  } ]
}',getPostingDate(),'1',1,1)

; -- Generated Statement 

insert into label.MTlabel(mtLabelId,shortCode,screen,en_US,es_ES) values 
('158','Book.bookId','Book','Book #','# Libro')
,('159','authorId','author','Author #','# Autor')
,('160','otherAuthor','VBook','Other Autors','Otros Autores')
,('161','title','VBook','Title','Titulo')
,('162','doc','VBook','Docs','Documentos')
,('163','VBook','VBook','Books','Libros')
,('164','mainscreen_book','mainscreen','Book','Libro')
,('165','mainscreen_author','mainscreen','Author','Autor')
,('166','Author.fileGroup','Author','File','Archivo')

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

ALTER TABLE example.Book ADD CONSTRAINT FK_example_Book_authorId FOREIGN KEY(authorId)  REFERENCES example.Author(authorId)
; -- Generated Statement 

ALTER TABLE example.Book ADD CONSTRAINT FK_example_Book_genreId FOREIGN KEY(genreId)  REFERENCES example.Genre(genreId)
; -- Generated Statement 

ALTER TABLE example.BookAuthor ADD CONSTRAINT FK_example_BookAuthor_bookId FOREIGN KEY(bookId)  REFERENCES example.Book(bookId)
; -- Generated Statement 

ALTER TABLE example.BookAuthor ADD CONSTRAINT FK_example_BookAuthor_authorId FOREIGN KEY(authorId)  REFERENCES example.Author(authorId)
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

ALTER TABLE config.DatagridSetting ADD CONSTRAINT FK_config_DatagridSetting_inputUserGroupId FOREIGN KEY(inputUserGroupId)  REFERENCES audit.InputUserGroup(inputUserGroupId)
; -- Generated Statement 

ALTER TABLE config.DatagridSetting ADD CONSTRAINT FK_config_DatagridSetting_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE config.DatagridSetting ADD CONSTRAINT FK_config_DatagridSetting_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

--- Start Dependency file: /poyake-example/src/main/resources/metadata/example/view/VBook.sql ---------------
create view example.VBook as
select
b.*,
'' otherAuthor
from 
example.Book b
--- End of Dependency file: /poyake-example/src/main/resources/metadata/example/view/VBook.sql

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

