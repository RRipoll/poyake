-- Generated Script file for DEFAULT !!!
-- Generated at Sun Oct 03 20:23:29 CEST 2021 
CREATE SCHEMA acc
; -- Generated Statement 

CREATE SCHEMA crm
; -- Generated Statement 

CREATE SCHEMA cs
; -- Generated Statement 

CREATE SCHEMA inv
; -- Generated Statement 

CREATE SCHEMA multi
; -- Generated Statement 

CREATE SCHEMA payment
; -- Generated Statement 

CREATE SCHEMA tolling
; -- Generated Statement 

CREATE SCHEMA audit
; -- Generated Statement 

CREATE SCHEMA config
; -- Generated Statement 

CREATE SCHEMA common
; -- Generated Statement 

CREATE SCHEMA label
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_Allocation_allocationId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_Annotation_annotationId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_Balance_customerId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_EnuAnnotationType_annotationTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_EnuLedgerType_ledgerTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_EnuTransactionType_transactionTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_Ledger_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_LedgerInfo_ledgerInfoId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE acc.Seq_LedgerItem_ledgerItemId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_CustomerPk_customerId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_EmailAddressPk_emailAddressId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_EnuContactType_contactTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_EnuCountry_countryId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_EnuCustomerType_customerTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_EnuPhoneNumberType_phoneNumberTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_EnuStateProvince_stateProvinceId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_HCustomer_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_HEmailAddress_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_HPersonOrCompany_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_HPhoneNumber_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_HPostalAddress_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_PersonOrCompanyPk_personOrCompanyId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_PhoneNumberPK_phoneNumberId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_PostalAddressPk_postalAddressId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE crm.Seq_Turista_turistaId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE cs.Seq_CSCase_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE cs.Seq_CSCasePK_csCaseId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE cs.Seq_CustomerCase_customercaseId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE cs.Seq_EnuCasePriority_casePriorityId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE cs.Seq_EnuCaseStatus_caseStatusId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE cs.Seq_EnuCaseType_caseTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE inv.Seq_Invoice_invoiceId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE inv.Seq_InvoiceDocument_invoiceDocumentId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE multi.Seq_EnuRoomType_roomTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE multi.Seq_Home_homeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE multi.Seq_HomeLink_homeLinkId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE multi.Seq_RoomLink_roomLinkId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE multi.Seq_Street_streetId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE payment.Seq_EnuPaymentType_paymentTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE payment.Seq_EnuPaymentTypeClass_paymentTypeClassId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE payment.Seq_Payment_paymentId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE payment.Seq_PaymentMethod_paymentMethodId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_CustomerPass_customerPassId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_CustomerVehicle_customerVehicleId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_EnuLicensePlateJurisdiction_licensePlateJurisdictionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_EnuLicensePlateType_licensePlateType START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_EnuProblematicPlateReason_problematicPlateReason START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_EnuPromoType_enuPromoTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_EnuVehicleClass_vehicleClassId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_EnuVehicleClassType_vehicleClassTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_Gantry_gantryId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_LicensePlate_licensePlateId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_Pass_passId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_ProblematicPlate_problematicPlateId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_Promo_promoId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_Trip_tripId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_TripInfo_revisionId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_Vehicle_vehicleId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE tolling.Seq_VehicleInfo_revisionId START WITH 1000
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

CREATE SEQUENCE common.Seq_EnuTemplateType_enuTemplateTypeId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE common.Seq_Template_templateId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE config.Seq_Enulocale_enuLocaleId START WITH 1000
; -- Generated Statement 

CREATE SEQUENCE label.Seq_MTlabel_mtLabelId START WITH 1000
; -- Generated Statement 

CREATE TABLE acc.Allocation(
	allocationId INT,
	creditRevisionId INT NOT NULL ,
	debitRevisionId INT NOT NULL ,
	amount NUMERIC(8,2) NOT NULL ,
	startAnnotationId INT NOT NULL ,
	endAnnotationId INT
,CONSTRAINT PK_acc_Allocation PRIMARY KEY (allocationId))
; -- Generated Statement 

CREATE TABLE acc.Annotation(
	annotationId INT,
	annotationTypeId INT NOT NULL ,
	postingDate DATE DEFAULT getPostingDate() NOT NULL ,
	customerId INT NOT NULL 
,CONSTRAINT PK_acc_Annotation PRIMARY KEY (annotationId))
; -- Generated Statement 

CREATE TABLE acc.Balance(
	customerId INT NOT NULL ,
	balanceAmount NUMERIC(8,2) NOT NULL 
,CONSTRAINT PK_acc_Balance PRIMARY KEY (customerId))
; -- Generated Statement 

CREATE TABLE acc.Cancellation(
	cancelledRevisionId INT NOT NULL ,
	cancellingRevisionId INT NOT NULL 
,CONSTRAINT PK_acc_Cancellation PRIMARY KEY (cancelledRevisionId,cancellingRevisionId))
; -- Generated Statement 

CREATE TABLE acc.EnuAnnotationType(
	annotationTypeId INT,
	shortCode VARCHAR(16) NOT NULL ,
	description VARCHAR(32) NOT NULL 
,CONSTRAINT PK_acc_EnuAnnotationType PRIMARY KEY (annotationTypeId))
; -- Generated Statement 

CREATE TABLE acc.EnuLedgerType(
	ledgerTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(64)
,CONSTRAINT PK_acc_EnuLedgerType PRIMARY KEY (ledgerTypeId))
; -- Generated Statement 

CREATE TABLE acc.EnuTransactionType(
	transactionTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_acc_EnuTransactionType PRIMARY KEY (transactionTypeId))
; -- Generated Statement 

CREATE TABLE acc.Ledger(
	revisionId INT,
	ledgerItemId INT NOT NULL ,
	ledgerInfoId INT NOT NULL ,
	transactionTypeId INT NOT NULL ,
	ledgerTypeId INT NOT NULL ,
	annotationId INT NOT NULL ,
	amount NUMERIC(8,2) NOT NULL ,
	balance NUMERIC(8,2) NOT NULL 
,CONSTRAINT PK_acc_Ledger PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE acc.LedgerInfo(
	ledgerInfoId INT
,CONSTRAINT PK_acc_LedgerInfo PRIMARY KEY (ledgerInfoId))
; -- Generated Statement 

CREATE TABLE acc.LedgerItem(
	ledgerItemId INT
,CONSTRAINT PK_acc_LedgerItem PRIMARY KEY (ledgerItemId))
; -- Generated Statement 

CREATE TABLE acc.Repost(
	fromRevisionId INT NOT NULL ,
	toRevisionId INT NOT NULL 
,CONSTRAINT PK_acc_Repost PRIMARY KEY (fromRevisionId,toRevisionId))
; -- Generated Statement 

CREATE TABLE crm.CustomerPaymentMethod(
	customerId INT NOT NULL ,
	paymentMethodId INT NOT NULL ,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_crm_CustomerPaymentMethod PRIMARY KEY (customerId,paymentMethodId))
; -- Generated Statement 

CREATE TABLE crm.CustomerPk(
	customerId INT
,CONSTRAINT PK_crm_CustomerPk PRIMARY KEY (customerId))
; -- Generated Statement 

CREATE TABLE crm.CustomerSuplementaryContact(
	customerId INT,
	personOrCompanyId INT,
	contactTypeId INT
,CONSTRAINT PK_crm_CustomerSuplementaryContact PRIMARY KEY (customerId,personOrCompanyId))
; -- Generated Statement 

CREATE TABLE crm.EmailAddressPk(
	emailAddressId INT
,CONSTRAINT PK_crm_EmailAddressPk PRIMARY KEY (emailAddressId))
; -- Generated Statement 

CREATE TABLE crm.EnuContactType(
	contactTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_crm_EnuContactType PRIMARY KEY (contactTypeId))
; -- Generated Statement 

CREATE TABLE crm.EnuCountry(
	countryId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_crm_EnuCountry PRIMARY KEY (countryId))
; -- Generated Statement 

CREATE TABLE crm.EnuCustomerType(
	customerTypeId INT NOT NULL ,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_crm_EnuCustomerType PRIMARY KEY (customerTypeId))
; -- Generated Statement 

CREATE TABLE crm.EnuPhoneNumberType(
	phoneNumberTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_crm_EnuPhoneNumberType PRIMARY KEY (phoneNumberTypeId))
; -- Generated Statement 

CREATE TABLE crm.EnuStateProvince(
	stateProvinceId INT,
	shortCode VARCHAR(3),
	description VARCHAR(32),
	abbr VARCHAR(2),
	countryId INT NOT NULL 
,CONSTRAINT PK_crm_EnuStateProvince PRIMARY KEY (stateProvinceId))
; -- Generated Statement 

CREATE TABLE crm.HCustomer(
	customerId INT NOT NULL ,
	mainContactPersonOrCompanyId INT NOT NULL ,
	mailingPostalAddressId INT,
	shippingPostalAddressId INT,
	customerTypeId INT DEFAULT 1 NOT NULL ,
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_crm_HCustomer PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE crm.HEmailAddress(
	emailAddressId INT NOT NULL ,
	address VARCHAR(64) NOT NULL ,
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_crm_HEmailAddress PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE crm.HPersonOrCompany(
	personOrCompanyId INT,
	isCompany INT DEFAULT 0 NOT NULL ,
	salutation VARCHAR(6),
	firstName VARCHAR(64),
	middleName VARCHAR(64),
	lastNameOrCompanyName VARCHAR(64) NOT NULL ,
	suffix VARCHAR(6),
	designation VARCHAR(64),
	doingBusinessAs VARCHAR(128),
	phoneNumberId INT,
	emailAddressId INT,
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_crm_HPersonOrCompany PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE crm.HPhoneNumber(
	phoneNumberId INT,
	phoneTypeId INT DEFAULT 1 NOT NULL ,
	number VARCHAR(14),
	extension VARCHAR(10),
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_crm_HPhoneNumber PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE crm.HPostalAddress(
	postalAddressId INT,
	address1 VARCHAR(256),
	address2 VARCHAR(256),
	city VARCHAR(64),
	stateProvinceId INT NOT NULL ,
	postalCode VARCHAR(10),
	barcode VARCHAR(20),
	coordinates VARCHAR(64),
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_crm_HPostalAddress PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE crm.PersonOrCompanyPk(
	personOrCompanyId INT
,CONSTRAINT PK_crm_PersonOrCompanyPk PRIMARY KEY (personOrCompanyId))
; -- Generated Statement 

CREATE TABLE crm.PhoneNumberPK(
	phoneNumberId INT
,CONSTRAINT PK_crm_PhoneNumberPK PRIMARY KEY (phoneNumberId))
; -- Generated Statement 

CREATE TABLE crm.PostalAddressPk(
	postalAddressId INT
,CONSTRAINT PK_crm_PostalAddressPk PRIMARY KEY (postalAddressId))
; -- Generated Statement 

CREATE TABLE crm.Turista(
	turistaId INT,
	countryId INT
,CONSTRAINT PK_crm_Turista PRIMARY KEY (turistaId))
; -- Generated Statement 

CREATE TABLE cs.CSCase(
	csCaseId INT NOT NULL ,
	subject VARCHAR(1024) NOT NULL ,
	caseTypeId INT DEFAULT 1 NOT NULL ,
	caseStatusId INT DEFAULT 0 NOT NULL ,
	casePriorityId INT DEFAULT 1 NOT NULL ,
	manualReviewRequired INT DEFAULT 1 NOT NULL ,
	expectedStatusTransitionDate DATE,
	documentation INT,
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_cs_CSCase PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE cs.CSCasePK(
	csCaseId INT
,CONSTRAINT PK_cs_CSCasePK PRIMARY KEY (csCaseId))
; -- Generated Statement 

CREATE TABLE cs.CustomerCase(
	customercaseId INT,
	customerId INT NOT NULL ,
	csCaseId INT NOT NULL ,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_cs_CustomerCase PRIMARY KEY (customercaseId))
; -- Generated Statement 

CREATE TABLE cs.EnuCasePriority(
	casePriorityId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_cs_EnuCasePriority PRIMARY KEY (casePriorityId))
; -- Generated Statement 

CREATE TABLE cs.EnuCaseStatus(
	caseStatusId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_cs_EnuCaseStatus PRIMARY KEY (caseStatusId))
; -- Generated Statement 

CREATE TABLE cs.EnuCaseType(
	caseTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_cs_EnuCaseType PRIMARY KEY (caseTypeId))
; -- Generated Statement 

CREATE TABLE inv.Invoice(
	invoiceId INT,
	created DATE DEFAULT getPostingDate() NOT NULL ,
	customerId INT NOT NULL 
,CONSTRAINT PK_inv_Invoice PRIMARY KEY (invoiceId))
; -- Generated Statement 

CREATE TABLE inv.InvoiceDocument(
	invoiceDocumentId INT,
	invoiceId INT NOT NULL ,
	amountDue NUMERIC(8,2) DEFAULT 0 NOT NULL ,
	sentToPostalAddressRevisionId INT,
	fileGroupId INT
,CONSTRAINT PK_inv_InvoiceDocument PRIMARY KEY (invoiceDocumentId))
; -- Generated Statement 

CREATE TABLE inv.InvoiceLedgerItem(
	invoiceId INT NOT NULL ,
	ledgerItemId INT NOT NULL 
,CONSTRAINT PK_inv_InvoiceLedgerItem PRIMARY KEY (invoiceId,ledgerItemId))
; -- Generated Statement 

CREATE TABLE multi.EnuRoomType(
	roomTypeId INT,
	shortCode VARCHAR(16) NOT NULL ,
	description VARCHAR(32) NOT NULL 
,CONSTRAINT PK_multi_EnuRoomType PRIMARY KEY (roomTypeId))
; -- Generated Statement 

CREATE TABLE multi.Home(
	homeId INT,
	postingDate DATE DEFAULT getPostingDate() NOT NULL ,
	customerId INT NOT NULL ,
	name VARCHAR(255)
,CONSTRAINT PK_multi_Home PRIMARY KEY (homeId))
; -- Generated Statement 

CREATE TABLE multi.HomeLink(
	homeLinkId INT NOT NULL ,
	streetId INT NOT NULL ,
	homeId INT NOT NULL ,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_multi_HomeLink PRIMARY KEY (homeLinkId))
; -- Generated Statement 

CREATE TABLE multi.RoomLink(
	roomLinkId INT NOT NULL ,
	roomTypeId INT NOT NULL ,
	homeId INT NOT NULL ,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_multi_RoomLink PRIMARY KEY (roomLinkId))
; -- Generated Statement 

CREATE TABLE multi.Street(
	streetId INT,
	address VARCHAR(255) NOT NULL 
,CONSTRAINT PK_multi_Street PRIMARY KEY (streetId))
; -- Generated Statement 

CREATE TABLE payment.EnuPaymentType(
	paymentTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32),
	paymentTypeClassId INT NOT NULL 
,CONSTRAINT PK_payment_EnuPaymentType PRIMARY KEY (paymentTypeId))
; -- Generated Statement 

CREATE TABLE payment.EnuPaymentTypeClass(
	paymentTypeClassId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_payment_EnuPaymentTypeClass PRIMARY KEY (paymentTypeClassId))
; -- Generated Statement 

CREATE TABLE payment.Payment(
	paymentId INT,
	amount NUMERIC(8,2) NOT NULL ,
	paymentTypeId INT NOT NULL ,
	postingDate DATE DEFAULT getPostingDate(),
	ledgerInfoId INT
,CONSTRAINT PK_payment_Payment PRIMARY KEY (paymentId))
; -- Generated Statement 

CREATE TABLE payment.PaymentMethod(
	paymentMethodId INT,
	paymentTypeId INT NOT NULL ,
	ccNumber VARCHAR(16),
	accountNumber VARCHAR(32),
	checkNumber VARCHAR(32)
,CONSTRAINT PK_payment_PaymentMethod PRIMARY KEY (paymentMethodId))
; -- Generated Statement 

CREATE TABLE tolling.CustomerPass(
	customerPassId INT,
	customerId INT NOT NULL ,
	passId INT NOT NULL ,
	startEffectiveDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endEffectiveDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL 
,CONSTRAINT PK_tolling_CustomerPass PRIMARY KEY (customerPassId))
; -- Generated Statement 

CREATE TABLE tolling.CustomerVehicle(
	customerVehicleId INT,
	customerId INT NOT NULL ,
	vehicleId INT NOT NULL ,
	effectiveStartDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	effectiveEndDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL 
,CONSTRAINT PK_tolling_CustomerVehicle PRIMARY KEY (customerVehicleId))
; -- Generated Statement 

CREATE TABLE tolling.EnuLicensePlateJurisdiction(
	licensePlateJurisdictionId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32),
	stateOrProviceId INT,
	countryId INT NOT NULL 
,CONSTRAINT PK_tolling_EnuLicensePlateJurisdiction PRIMARY KEY (licensePlateJurisdictionId))
; -- Generated Statement 

CREATE TABLE tolling.EnuLicensePlateType(
	licensePlateType INT,
	shortCode VARCHAR(16),
	description VARCHAR(64)
,CONSTRAINT PK_tolling_EnuLicensePlateType PRIMARY KEY (licensePlateType))
; -- Generated Statement 

CREATE TABLE tolling.EnuProblematicPlateReason(
	problematicPlateReason INT NOT NULL ,
	shortCode VARCHAR(32),
	description VARCHAR(32)
,CONSTRAINT PK_tolling_EnuProblematicPlateReason PRIMARY KEY (problematicPlateReason))
; -- Generated Statement 

CREATE TABLE tolling.EnuPromoType(
	enuPromoTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(32)
,CONSTRAINT PK_tolling_EnuPromoType PRIMARY KEY (enuPromoTypeId))
; -- Generated Statement 

CREATE TABLE tolling.EnuVehicleClass(
	vehicleClassId INT,
	shortCode VARCHAR(16),
	description VARCHAR(128),
	vehicleClassTypeId INT,
	aigCode INT
,CONSTRAINT PK_tolling_EnuVehicleClass PRIMARY KEY (vehicleClassId))
; -- Generated Statement 

CREATE TABLE tolling.EnuVehicleClassType(
	vehicleClassTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(64)
,CONSTRAINT PK_tolling_EnuVehicleClassType PRIMARY KEY (vehicleClassTypeId))
; -- Generated Statement 

CREATE TABLE tolling.Gantry(
	gantryId INT,
	roadsideGantryUniqueId VARCHAR(128) NOT NULL ,
	description VARCHAR(32) NOT NULL 
,CONSTRAINT PK_tolling_Gantry PRIMARY KEY (gantryId))
; -- Generated Statement 

CREATE TABLE tolling.LicensePlate(
	licensePlateId INT,
	licencePlateJurisdictionId INT NOT NULL ,
	lpnumber VARCHAR(16) NOT NULL ,
	licensePlatetypeId INT NOT NULL 
,CONSTRAINT PK_tolling_LicensePlate PRIMARY KEY (licensePlateId))
; -- Generated Statement 

CREATE TABLE tolling.Pass(
	passId INT,
	fullPassNumber VARCHAR(128)
,CONSTRAINT PK_tolling_Pass PRIMARY KEY (passId))
; -- Generated Statement 

CREATE TABLE tolling.ProblematicPlate(
	problematicPlateId INT NOT NULL ,
	licensePlateId INT NOT NULL ,
	problematicPlateReasonId INT NOT NULL ,
	notes VARCHAR(512)
,CONSTRAINT PK_tolling_ProblematicPlate PRIMARY KEY (problematicPlateId))
; -- Generated Statement 

CREATE TABLE tolling.Promo(
	promoId INT,
	customerId INT NOT NULL ,
	promoTypeId INT NOT NULL 
,CONSTRAINT PK_tolling_Promo PRIMARY KEY (promoId))
; -- Generated Statement 

CREATE TABLE tolling.Trip(
	tripId INT,
	ledgerInfoId INT NOT NULL ,
	ledgerItemId INT NOT NULL 
,CONSTRAINT PK_tolling_Trip PRIMARY KEY (tripId))
; -- Generated Statement 

CREATE TABLE tolling.TripInfo(
	tripId INT NOT NULL ,
	fareAmount NUMERIC(8,2) NOT NULL ,
	laneExitDate DATE NOT NULL ,
	gantryId INT NOT NULL ,
	laneEntryDate DATE,
	licensePlateId INT,
	passId INT,
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_tolling_TripInfo PRIMARY KEY (revisionId))
; -- Generated Statement 

CREATE TABLE tolling.Vehicle(
	vehicleId INT
,CONSTRAINT PK_tolling_Vehicle PRIMARY KEY (vehicleId))
; -- Generated Statement 

CREATE TABLE tolling.VehicleInfo(
	vehicleId INT NOT NULL ,
	licensePlateId INT NOT NULL ,
	color VARCHAR(100),
	make VARCHAR(255),
	model VARCHAR(255),
	vehicleClassId INT,
	style VARCHAR(20),
	axles INT,
	modelYear INT,
	revisionId INT,
	startDate TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	endDate TIMESTAMP DEFAULT '2099-01-01' NOT NULL ,
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_tolling_VehicleInfo PRIMARY KEY (revisionId))
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

CREATE TABLE common.EnuTemplateType(
	enuTemplateTypeId INT,
	shortCode VARCHAR(16),
	description VARCHAR(255)
,CONSTRAINT PK_common_EnuTemplateType PRIMARY KEY (enuTemplateTypeId))
; -- Generated Statement 

CREATE TABLE common.Template(
	templateId INT,
	enuTemplateTypeId INT,
	enuLocaleId INT DEFAULT 3082,
	created TIMESTAMP DEFAULT getPostingDate() NOT NULL ,
	body VARCHAR(8000),
	inputUserId INT DEFAULT 1 NOT NULL ,
	inputSourceId INT DEFAULT 1 NOT NULL 
,CONSTRAINT PK_common_Template PRIMARY KEY (templateId))
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

insert into acc.EnuAnnotationType(annotationTypeId,shortCode,description) values 
(1,'NEWDEBIT','New Debit')
,(2,'NEWCREDIT','New Credit')
,(3,'DEBITCANCEL','Debit Cancellation')
,(4,'CREDITCANCEL','Credit Cancellation')
,(5,'DEBITADJUST','Debit Adjustment')
,(6,'CREDITADJUST','Credit Adjustment')
,(7,'DEBITREALLOC','Debit Reallocation')
,(8,'CREDITREALLOC','Credit Reallocation')
,(9,'DEBITTYPECHANGE','Debit Reclassification')

; -- Generated Statement 

insert into acc.EnuLedgerType(ledgerTypeId,shortCode,description) values 
(1,'DEBIT','Debit')
,(2,'CREDIT','Credit')
,(3,'DC','Debit Cancellation')
,(4,'CC','Credit Cancellation')
,(5,'DR','Debit Repost')
,(6,'CR','Credit Repost')

; -- Generated Statement 

insert into acc.EnuTransactionType(transactionTypeId,shortCode,description) values 
(1,'PAYMENT','Payment')
,(2,'TRIP','Trip')

; -- Generated Statement 

insert into crm.CustomerPk(customerId) values 
('1')
,('2')
,('3')

; -- Generated Statement 

insert into crm.EnuContactType(contactTypeId,shortCode,description) values 
(1,'SECONDARY','Secondary Contact')
,(2,'COMPANYCONTACT','Company Contact')

; -- Generated Statement 

insert into crm.EnuCountry(countryId,shortCode,description) values 
(0,'UNK','Unknown')
,(1,'US','USA')
,(2,'CA','Canada')
,(3,'MX','Mexico')
,(4,'SP','Spain')

; -- Generated Statement 

insert into crm.EnuCustomerType(customerTypeId,shortCode,description) values 
(0,'SYSTEM','System Internal Account')
,(1,'CUSTOMER','Customer')
,(3,'PROSPECT','Prospect')

; -- Generated Statement 

insert into crm.EnuPhoneNumberType(phoneNumberTypeId,shortCode,description) values 
(1,'HOME','Home')
,(2,'WORK','Work')
,(3,'MOBILE','Mobile')

; -- Generated Statement 

insert into crm.EnuStateProvince(stateProvinceId,shortCode,description,abbr,countryId) values 
(0,'xx','Unknown','xx','0')
,(1,'AL','Alabama','AL','1')
,(2,'AK','Alaska','AK','1')
,(3,'AZ','Arizona','AZ','1')
,(4,'AR','Arkansas','AR','1')
,(5,'CA','California','CA','1')
,(6,'CO','Colorado','CO','1')
,(7,'CT','Connecticut','CT','1')
,(8,'DE','Delaware','DE','1')
,(9,'FL','Florida','FL','1')
,(10,'GA','Georgia','GA','1')
,(11,'HI','Hawaii','HI','1')
,(12,'IDH','Idaho','ID','1')
,(13,'IL','Illinois','IL','1')
,(14,'IN','Indiana','IN','1')
,(15,'IA','Iowa','IA','1')
,(16,'KS','Kansas','KS','1')
,(17,'KY','Kentucky','KY','1')
,(18,'LA','Lousiana','LA','1')
,(19,'ME','Maine','ME','1')
,(20,'MD','Maryland','MD','1')
,(21,'MA','Massachusetts','MA','1')
,(22,'MI','Michigan','MI','1')
,(23,'MN','Minnesota','MN','1')
,(24,'MS','Mississippi','MS','1')
,(25,'MO','Missouri','MO','1')
,(26,'MT','Montana','MT','1')
,(27,'NE','Nebraska','NE','1')
,(28,'NV','Nevada','NV','1')
,(29,'NH','New Hampshire','NH','1')
,(30,'NJ','New Jersey','NJ','1')
,(31,'NM','New Mexico','NM','1')
,(32,'NY','New York','NY','1')
,(33,'NC','North Carolina','NC','1')
,(34,'ND','North Dakota','ND','1')
,(35,'OH','Ohio','OH','1')
,(36,'OK','Oklahoma','OK','1')
,(37,'OR','Oregon','OR','1')
,(38,'PA','Pennsylvania','PA','1')
,(39,'RI','Rhode Island','RI','1')
,(40,'SC','South Carolina','SC','1')
,(41,'SD','South Dakota','SD','1')
,(42,'TN','Tennessee','TN','1')
,(43,'TX','Texas','TX','1')
,(44,'UT','Utah','UT','1')
,(45,'VT','Vermont','VT','1')
,(46,'VA','Virginia','VA','1')
,(47,'WA','Washington','WA','1')
,(48,'WV','West Virginia','WV','1')
,(49,'WI','Wisconsin','WI','1')
,(50,'WY','Wyoming','WY','1')
,(51,'AB','Alberta','AB','2')
,(52,'BC','British Columbia','BC','2')
,(53,'MB','Manitoba','MB','2')
,(54,'NB','New Brunswick','NB','2')
,(55,'NL','Newfoundland and Labrador','NL','2')
,(56,'NS','Nova Scotia','NS','2')
,(57,'NT','Nortwest Territories','NT','2')
,(58,'NU','Nunavut','NU','2')
,(59,'ON','Ontario','ON','2')
,(60,'PE','Prince Edward Island','PE','2')
,(61,'QC','Quebec','QC','2')
,(62,'SK','Saskatchewan','SK','2')
,(63,'YT','Yukon','YT','2')
,(64,'AGU','Aguascalientes','AG','3')
,(65,'BCN','Baja California Norte','BC','3')
,(66,'BCS','Baja California Sur','BS','3')
,(67,'CAM','Campeche','CM','3')
,(68,'CHP','Chiapas','CS','3')
,(69,'CHH','Chihuahua','CH','3')
,(70,'COA','Coahuila','CO','3')
,(71,'COL','Colima','CL','3')
,(72,'CMX','Distrito Federal','DF','3')
,(73,'DUR','Durango','DG','3')
,(74,'GUA','Guanajuato','GT','3')
,(75,'GRO','Guerrero','GR','3')
,(76,'HID','Hidalgo','HG','3')
,(77,'JAL','Jalisco','JA','3')
,(78,'MEX','Mexico','MX','3')
,(79,'MIC','Michoacan','MI','3')
,(80,'MOR','Morelos','MO','3')
,(81,'NAY','Nayarit','NA','3')
,(82,'NLE','Nuevo Leon','NL','3')
,(83,'OAX','Oaxaca','OA','3')
,(84,'PUE','Puebla','PU','3')
,(85,'QUE','Queretaro','QT','3')
,(86,'ROO','Quintana Roo','QR','3')
,(87,'SLP','San Luis Potosi','SL','3')
,(88,'SIN','Sinaloa','SI','3')
,(89,'SON','Sonora','SO','3')
,(90,'TAB','Tabasco','TB','3')
,(91,'TAM','Tamaulipas','TM','3')
,(92,'TLA','Tiaxcala','TL','3')
,(93,'VER','Veracruz','VE','3')
,(94,'YUC','Yucatan','YU','3')
,(95,'ZA','Zacatecas','ZT','3')
,(96,'DC','Washington DC','DC','1')
,(97,'AS','American Samoa','AS','1')
,(98,'FM','Federated States of Micronesia','FM','1')
,(99,'GU','Guam','GU','1')
,(100,'MH','Marshal Islands','MH','1')
,(101,'MP','Northern Mariana Islands','MP','1')
,(102,'PW','Palau','PW','1')
,(103,'PR','Puerto Rico','PR','1')
,(104,'VI','Virgin Islands','VI','1')
,(105,'LB','Labrador','LB','2')
,(106,'PQ','Province du Quebec','PQ','2')
,(107,'US','US','US','1')
,(108,'AA','Armed Forces Americas','AA','1')
,(109,'AE','Armed Forces (Other;','AE','1')
,(110,'AP','Armed Forces Pacific','AP','1')
,(111,'II','International','II','4')
,(201,'MAD','Madrid','MA','4')
,(202,'SAL','Salamanca','SA','4')

; -- Generated Statement 

insert into crm.HCustomer(customerId,mainContactPersonOrCompanyId,mailingPostalAddressId,shippingPostalAddressId,customerTypeId,revisionId,startDate,endDate,inputUserId,inputSourceId) values 
('1','1',NULL,NULL,1,'1',getPostingDate(),'2099-01-01',1,1)
,('2','2',NULL,NULL,1,'2',getPostingDate(),'2099-01-01',1,1)
,('3','3','3','3',1,'3',getPostingDate(),'2099-01-01',1,1)

; -- Generated Statement 

insert into crm.HPersonOrCompany(personOrCompanyId,isCompany,salutation,firstName,middleName,lastNameOrCompanyName,suffix,designation,doingBusinessAs,phoneNumberId,emailAddressId,revisionId,startDate,endDate,inputUserId,inputSourceId) values 
('1',0,NULL,'Pepe',NULL,'Perez',NULL,'Mr',NULL,NULL,NULL,'1',getPostingDate(),'2099-01-01',1,1)
,('2',0,NULL,'Manuel',NULL,'González',NULL,'Mr',NULL,NULL,NULL,'2',getPostingDate(),'2099-01-01',1,1)
,('3',0,NULL,'John',NULL,'Doe',NULL,'Mr',NULL,NULL,NULL,'3',getPostingDate(),'2099-01-01',1,1)

; -- Generated Statement 

insert into crm.HPostalAddress(postalAddressId,address1,address2,city,stateProvinceId,postalCode,barcode,coordinates,revisionId,startDate,endDate,inputUserId,inputSourceId) values 
('3','1 Picadilly Sq','2G','New York','1','01010',NULL,NULL,'3',getPostingDate(),'2099-01-01',1,1)

; -- Generated Statement 

insert into crm.PersonOrCompanyPk(personOrCompanyId) values 
('1')
,('2')
,('3')

; -- Generated Statement 

insert into crm.PostalAddressPk(postalAddressId) values 
('1')
,('2')
,('3')

; -- Generated Statement 

insert into crm.Turista(turistaId,countryId) values 
('1',1)

; -- Generated Statement 

insert into cs.EnuCasePriority(casePriorityId,shortCode,description) values 
(1,'NORMAL','Normal')
,(2,'HIGH','High')

; -- Generated Statement 

insert into cs.EnuCaseStatus(caseStatusId,shortCode,description) values 
(0,'NEW','New')
,(1,'CLOSED','Closed')

; -- Generated Statement 

insert into cs.EnuCaseType(caseTypeId,shortCode,description) values 
(1,'GENERAL','General Enquiry')
,(2,'DISPUTE','Dispute')

; -- Generated Statement 

insert into multi.EnuRoomType(roomTypeId,shortCode,description) values 
(1,'KICHEN','KICHEN')
,(2,'DINER','DINNER')
,(3,'ROOM','ROOM')
,(4,'SERVICE','SERVICE')

; -- Generated Statement 

insert into multi.Home(homeId,postingDate,customerId,name) values 
('1',getPostingDate(),'1','primera')
,('2',getPostingDate(),'1','segunda')
,('3',getPostingDate(),'1','tercera')

; -- Generated Statement 

insert into multi.HomeLink(homeLinkId,streetId,homeId,created,inputUserId,inputSourceId) values 
('1','1','1',getPostingDate(),1,1)
,('2','2','2',getPostingDate(),1,1)
,('3','3','3',getPostingDate(),1,1)

; -- Generated Statement 

insert into multi.RoomLink(roomLinkId,roomTypeId,homeId,created,inputUserId,inputSourceId) values 
('1','1','1',getPostingDate(),1,1)
,('2','2','2',getPostingDate(),1,1)
,('3','3','3',getPostingDate(),1,1)

; -- Generated Statement 

insert into multi.Street(streetId,address) values 
('1','Antonio Concha')
,('2','Severiano')
,('3','Alcala')

; -- Generated Statement 

insert into payment.EnuPaymentType(paymentTypeId,shortCode,description,paymentTypeClassId) values 
(1,'VISA','Visa','1')
,(2,'MCARD','MasterCard','1')
,(3,'AMEX','American Express','1')
,(4,'DISC','Discovery','1')
,(5,'CASH','Cash','2')
,(6,'DIRECTDEBIT','Direct Debit','3')
,(7,'CHECK','Check','4')

; -- Generated Statement 

insert into payment.EnuPaymentTypeClass(paymentTypeClassId,shortCode,description) values 
(1,'CREDITCARD','Credit Card')
,(2,'CASH','Cash')
,(3,'DIRECTDEBIT','Direct Debit')
,(4,'CHECK','Check')

; -- Generated Statement 

insert into tolling.EnuLicensePlateJurisdiction(licensePlateJurisdictionId,shortCode,description,stateOrProviceId,countryId) values 
(0,'xx','Unknown','0','0')
,(1,'AL','Alabama','1','1')
,(2,'AK','Alaska','2','1')
,(3,'AZ','Arizona','3','1')
,(4,'AR','Arkansas','4','1')
,(5,'CA','California','5','1')
,(6,'CO','Colorado','6','1')
,(7,'CT','Connecticut','7','1')
,(8,'DE','Delaware','8','1')
,(9,'FL','Florida','9','1')
,(10,'GA','Georgia','10','1')
,(11,'HI','Hawaii','11','1')
,(12,'IDH','Idaho','12','1')
,(13,'IL','Illinois','13','1')
,(14,'IN','Indiana','14','1')
,(15,'IA','Iowa','15','1')
,(16,'KS','Kansas','16','1')
,(17,'KY','Kentucky','17','1')
,(18,'LA','Lousiana','18','1')
,(19,'ME','Maine','19','1')
,(20,'MD','Maryland','20','1')
,(21,'MA','Massachusetts','21','1')
,(22,'MI','Michigan','22','1')
,(23,'MN','Minnesota','23','1')
,(24,'MS','Mississippi','24','1')
,(25,'MO','Missouri','25','1')
,(26,'MT','Montana','26','1')
,(27,'NE','Nebraska','27','1')
,(28,'NV','Nevada','28','1')
,(29,'NH','New Hampshire','29','1')
,(30,'NJ','New Jersey','30','1')
,(31,'NM','New Mexico','31','1')
,(32,'NY','New York','32','1')
,(33,'NC','North Carolina','33','1')
,(34,'ND','North Dakota','34','1')
,(35,'OH','Ohio','35','1')
,(36,'OK','Oklahoma','36','1')
,(37,'OR','Oregon','37','1')
,(38,'PA','Pennsylvania','38','1')
,(39,'RI','Rhode Island','39','1')
,(40,'SC','South Carolina','40','1')
,(41,'SD','South Dakota','41','1')
,(42,'TN','Tennessee','42','1')
,(43,'TX','Texas','43','1')
,(44,'UT','Utah','44','1')
,(45,'VT','Vermont','45','1')
,(46,'VA','Virginia','46','1')
,(47,'WA','Washington','47','1')
,(48,'WV','West Virginia','48','1')
,(49,'WI','Wisconsin','49','1')
,(50,'WY','Wyoming','50','1')
,(51,'AB','Alberta','51','2')
,(52,'BC','British Columbia','52','2')
,(53,'MB','Manitoba','53','2')
,(54,'NB','New Brunswick','54','2')
,(55,'NL','Newfoundland and Labrador','55','2')
,(56,'NS','Nova Scotia','56','2')
,(57,'NT','Nortwest Territories','57','2')
,(58,'NU','Nunavut','58','2')
,(59,'ON','Ontario','59','2')
,(60,'PE','Prince Edward Island','60','2')
,(61,'QC','Quebec','61','2')
,(62,'SK','Saskatchewan','62','2')
,(63,'YT','Yukon','63','2')
,(64,'AGU','Aguascalientes','64','3')
,(65,'BCN','Baja California Norte','65','3')
,(66,'BCS','Baja California Sur','66','3')
,(67,'CAM','Campeche','67','3')
,(68,'CHP','Chiapas','68','3')
,(69,'CHH','Chihuahua','69','3')
,(70,'COA','Coahuila','70','3')
,(71,'COL','Colima','71','3')
,(72,'CMX','Distrito Federal','72','3')
,(73,'DUR','Durango','73','3')
,(74,'GUA','Guanajuato','74','3')
,(75,'GRO','Guerrero','75','3')
,(76,'HID','Hidalgo','76','3')
,(77,'JAL','Jalisco','77','3')
,(78,'MEX','Mexico','78','3')
,(79,'MIC','Michoacan','79','3')
,(80,'MOR','Morelos','80','3')
,(81,'NAY','Nayarit','81','3')
,(82,'NLE','Nuevo Leon','82','3')
,(83,'OAX','Oaxaca','83','3')
,(84,'PUE','Puebla','84','3')
,(85,'QUE','Queretaro','85','3')
,(86,'ROO','Quintana Roo','86','3')
,(87,'SLP','San Luis Potosi','87','3')
,(88,'SIN','Sinaloa','88','3')
,(89,'SON','Sonora','89','3')
,(90,'TAB','Tabasco','90','3')
,(91,'TAM','Tamaulipas','91','3')
,(92,'TLA','Tiaxcala','92','3')
,(93,'VER','Veracruz','93','3')
,(94,'YUC','Yucatan','94','3')
,(95,'ZAC','Zacatecas','95','3')
,(96,'DC','Washington DC','96','1')
,(97,'AS','American Samoa','97','1')
,(98,'FM','Federated States of Micronesia','98','1')
,(99,'GU','Guam','99','1')
,(100,'MH','Marshal Islands','100','1')
,(101,'MP','Northern Mariana Islands','101','1')
,(102,'PW','Palau','102','1')
,(103,'PR','Puerto Rico','103','1')
,(104,'VI','Virgin Islands','104','1')
,(105,'LB','Labrador','105','2')
,(106,'PQ','Province du Quebec','106','2')
,(108,'AA','Armed Forces Americas','108','1')
,(109,'AE','Armed Forces (Other;','109','1')
,(110,'AP','Armed Forces Pacific','110','1')
,(111,'II','International','111','4')
,(1000,'DHS','Department of Homeland Security',NULL,'1')
,(1001,'FD','Federal or Military',NULL,'1')
,(1002,'GSA','General Services Administration',NULL,'1')
,(1003,'DL','Diplomat ',NULL,'1')
,(1004,'FC','Foreign Consul',NULL,'1')
,(1005,'PUY','Puyallup',NULL,'1')
,(1006,'CLV','Colville',NULL,'1')
,(1007,'LUM','Lummi',NULL,'1')
,(1008,'SPK','Spokane Tribe',NULL,'1')
,(1009,'QIN','Quinault Indian Nation',NULL,'1')
,(1010,'MCK','Muckleshoot',NULL,'1')
,(1011,'TUL','Tulalip Tribes',NULL,'1')
,(1012,'YAK','Yakama Nation',NULL,'1')

; -- Generated Statement 

insert into tolling.EnuLicensePlateType(licensePlateType,shortCode,description) values 
(0,'UNK','Unknown')
,(1,'AGRI','Agriculture')
,(2,'AMBU','Ambulance')
,(3,'AMOT','Antique Motorcycle')
,(4,'ANTI','Antique')
,(5,'APRO','Apportioned Power Vehicle (Other3)')
,(6,'APTR','Apportioned Trailer')
,(8,'HPASS','Conservation Moose')
,(9,'CONEQ','Construction Equipment')
,(11,'FARM','Fam')
,(12,'FPOW','Former POW')
,(31,'APRO_DUP','Apportioned Power Vehicle (Other2)')
,(32,'COMM','Commercial')
,(33,'CPASS','Moose Conservation Passenger')
,(34,'DVETE','Disabled Veteran')
,(35,'HCAP','Handicap')
,(36,'IAPRO','Initial Apportioned Vehicle')
,(37,'ICOMM','Initial Commercial')
,(38,'ICPAS','Initial Moose Conservation Passenger')
,(39,'IDVET','Initial Disabled Veteran')
,(40,'IHCAP','Initial Handicap')
,(41,'IMOTO','Initial Motorcycle')
,(42,'IPASS','Initial Passenger')
,(43,'IVMOT','Initial Veteran Motorcycle')
,(44,'IVVET','Initial Regular Veteran')
,(45,'MOTO','Motorcycle')
,(46,'PASS','Passenger')
,(47,'RADPL','Automobile Dealer (other)')
,(49,'VMOTO','Veteran Motorcycle')
,(50,'VVETE','Regular Veteran Plate')
,(61,'ET_0061','Ambulance/Emergency')
,(62,'ET_0062','Authority Motorcycle (Other)')
,(63,'ET_0063','Authority (Other)')
,(64,'ET_0064','Bus (Other)')
,(65,'ET_0065','Camper')
,(66,'ET_0066','Livery')
,(67,'ET_0067','Municipal Vehicle')
,(69,'ET_0069','School Bus (Normal)')
,(71,'ET_0071','Semi-Trailer')
,(72,'ET_0072','State Motorcycle (Other)')
,(73,'ET_0073','State Vehicle (Other3)')
,(74,'ET_0074','Taxi (Other)')
,(75,'ET_0075','Trailer (Other)')
,(76,'ET_0076','Vanpool')
,(78,'ET_0078','Combination (Other)')
,(80,'ET_0080','Antique Auto')
,(81,'ET_0081','Black Bear Specialty Plate')
,(82,'ET_0082','Conservation Commercial')
,(83,'ET_0083','Conservation Disability')
,(84,'ET_0084','Conservation Passenger')
,(85,'ET_0085','Disability Special Veteran Plate')
,(86,'ET_0086','Fire Fighter')
,(87,'ET_0087','Lobster Specialty Plate')
,(88,'ET_0088','Purple Heart')
,(89,'ET_0089','Purple Heart Motorcycle')
,(90,'ET_0090','Conservation Motor home')
,(91,'ET_0091','Univ. of Maine System')
,(92,'ET_0092','Wabanaki')
,(93,'ET_0093','Disability Motor home')
,(97,'AUTH','Authority')
,(100,'BOATDEL','Boat Dealer')
,(102,'BUS','Bus')
,(104,'CAMP','Camper Trailer')
,(107,'COMB','Combination')
,(108,'CONSUL','Consulate General')
,(109,'DEALER','Dealer (other)')
,(110,'DEALVAN','Dealer Vanity')
,(111,'DELR','Dealer')
,(113,'FARMTRL','Farm Trailer')
,(115,'HMOTO','Handicapped Motorcycle')
,(128,'MVH','Municipal Vehicle (Other)')
,(129,'MVT','Municipal Motorcycle (Other)')
,(130,'NDEAL','New And Used Dealer')
,(131,'NGNH','Nation Guard')
,(132,'NPURP','Purple-Heart')
,(134,'OWNCONT','Owner Contractor')
,(137,'PHMOT','Purple Heart Motorcycle')
,(141,'REP','Repair')
,(142,'REPVAN','Repair Vanity')
,(143,'SBUS','School Normal')
,(144,'SBUSP','School Pupil')
,(149,'SPCPS','Moose Conservation Passenger')
,(150,'SPPAS','Initial Moose Conservation Passenger (Other)')
,(151,'STAND','Standard')
,(157,'TAXI','Taxi')
,(158,'TRAI','Trailer')
,(159,'TRCK','Truck')
,(160,'TRNS','Transporter')
,(161,'VLRMOT','Legion of Valor Motorcycle')
,(163,'ET_0163','Hearse')
,(164,'ET_0164','Antique Vanity')
,(165,'ET_0165','Former Pow Vanity')
,(166,'ET_0166','Handicapped Motorcycle Vanity')
,(167,'ET_0167','National Guard Vanity')
,(168,'ET_0168','Purple Hearth Vanity')
,(169,'ET_0169','Motorcycle Purple Hearth Vanity')
,(170,'ET_0170','Moose Park Vanity')
,(171,'ET_0171','State Park Vanity')
,(172,'ET_0172','Street Road Vanity')
,(173,'ET_0173','Trailer Vanity')
,(174,'ET_0174','National Guard')
,(175,'ET_0175','Pearl Harbor Survivor Vanity')
,(176,'ET_0176','Permanent State')
,(177,'ET_0177','Permanent City Town')
,(178,'ET_0178','Pearl Harbor Survivor')
,(179,'ET_0179','Commercial Special')
,(180,'ET_0180','Street Rod')
,(181,'ET_0181','Passenger Reserved')
,(182,'ET_0182','Passenger Special')
,(183,'ET_0183','Passenger Year of Manufacture')
,(184,'ET_0184','Commercial Reserved')
,(185,'ET_0185','Taxi Reserved')
,(186,'ET_0186','Trailer Reserved')
,(187,'ET_0187','Semi Trailer Reserved')
,(188,'ET_0188','Motorcycle Reserved')
,(189,'ET_0189','Motorcycle Special')
,(190,'ET_0190','Motorcycle Dealer (Other)')
,(191,'ET_0191','Ambulance Reserved')
,(192,'ET_0192','Camper Reserved')
,(193,'ET_0193','Camper Vanity')
,(194,'ET_0194','Bus Reserved')
,(195,'ET_0195','Bus Vanity')
,(196,'ET_0196','School Bus Reserved')
,(197,'ET_0197','Livery Reserved')
,(198,'ET_0198','Livery Vanity')
,(199,'ET_0199','Agriculture Commercial')
,(200,'ET_0200','Agriculture Farm Vehicle')
,(201,'ET_0201','Agriculture Passenger')
,(202,'ET_0202','Animal Welfare')
,(203,'ET_0203','Breast Cancer Support')
,(204,'ET_0204','Conservation Trailer')
,(205,'ET_0205','County Sheriff')
,(206,'ET_0206','Custom Vehicle')
,(207,'ET_0207','Disability Special Veteran')
,(208,'ET_0208','Gold Star')
,(209,'ET_0209','Lobster Commercial')
,(210,'ET_0210','Low Speed Vehicle')
,(211,'ET_0211','Motor Home')
,(212,'ET_0212','Medal of Honor')
,(213,'ET_0213','Special Equipment')
,(214,'ET_0214','Sportsman')
,(215,'ET_0215','Tractor')
,(216,'ET_0216','Support Troops')
,(217,'ET_0217','Commercial Tractor')
,(218,'ET_0218','Motorcycle Disabled Veteran')
,(219,'ET_0219','Camp Trailer')
,(220,'ET_0220','High Millage Vehicle')
,(221,'ET_0221','Factory')
,(222,'ET_0222','Classic Vehicle')
,(223,'ET_0223','General District Bus')
,(224,'ET_0224','US Senate/Congress')
,(225,'ET_0225','Volunteer Firefighter')
,(226,'ET_0226','State Service Bus')
,(227,'ET_0227','School Bus Livery')
,(228,'ET_0228','Wrecker')
,(229,'ET_0229','US Military/Services/Protect')
,(230,'ET_0230','Vanity Sports')
,(231,'ET_0231','Wold University Games')
,(232,'ET_0232','Jewish War Veterans of America')
,(233,'ET_0233','Marine Corps League')
,(234,'ET_0234','County Legislators')
,(235,'ET_0235','Board of Supervisors')
,(236,'ET_0236','Vanity')
,(237,'ET_0237','Court')
,(238,'ET_0238','NY Assembly')
,(239,'ET_0239','US Congress')
,(240,'ET_0240','US Senate')
,(241,'ET_0241','Hearse Special Registration')
,(242,'ET_0242','Court of Appeals')
,(243,'ET_0243','Commercial Special Purpose')
,(244,'ET_0244','NY Council')
,(245,'ET_0245','Appellate Term')
,(246,'ET_0246','Physician')
,(247,'ET_0247','Court of Claims')
,(248,'ET_0248','Congressional Medal of Honor')
,(249,'ET_0249','Supreme Court')
,(250,'ET_0250','County Clerk')
,(251,'ET_0251','Air National Guard')
,(252,'ET_0252','Army National Guard')
,(253,'ET_0253','Naval Militia')
,(254,'ET_0254','State National Guard')
,(255,'ET_0255','Ham Radio Operator')
,(256,'ET_0256','Birthplace of Baseball')
,(257,'ET_0257','Volunteer Ambulance')
,(258,'ET_0258','Survivors of the Shield')
,(259,'ET_0259','Transporter (Other)')
,(260,'ET_0260','Counties and Regions')
,(261,'ET_0261','Commercial Sports')
,(262,'ET_0262','State Official')
,(263,'ET_0263','Motorcycle Organizational')
,(264,'ET_0264','Trailer Light')
,(265,'ET_0265','Trailer Commercial Semi')
,(266,'ET_0266','EM - Political Subdivision')
,(267,'ET_0267','Public Service')
,(268,'ET_0268','Suburban')
,(269,'ET_0269','Jitney')
,(270,'ET_0270','State')
,(271,'ET_0271','City')
,(272,'ET_0272','Town')
,(273,'ET_0273','Police')
,(274,'ET_0274','State Police')
,(275,'ET_0275','House')
,(276,'ET_0276','Used Car Dealer')
,(277,'ET_0277','In-Transit')
,(278,'ET_0278','Bailee')
,(279,'ET_0279','Racer Tow')
,(280,'ET_0280','40 & 8')
,(281,'TEMP','Temporary')
,(282,'NONSTD','Non-Standard')
,(283,'FOURH','4-H')
,(284,'AF','Armed Forces-Air Force')
,(285,'AR','Armed Forces-Army')
,(286,'CG','Armed Forces-Coast Guard')
,(287,'MC','Armed Forces-Marine Corps')
,(288,'NG','Armed Forces-National Guard')
,(289,'NA','Armed Forces-Navy')
,(290,'CV','Collector Vehicle')
,(291,'CVA','Collector Vehicle Motorcycle')
,(292,'CWU','Collegiate-Central WA Univ Wildcat')
,(293,'EWU','Collegiate-Eastern WA Univ Eagle')
,(294,'GU','Collegiate-Gonzaga Univ Bulldog')
,(295,'SU','Collegiate-Seattle Univ Redhawk')
,(296,'GRN','Collegiate-The Evergreen State College Tree')
,(297,'UW','Collegiate-University of Washington Husky')
,(298,'WSU','Collegiate-WA State Univ Cougar')
,(299,'WWU','Collegiate-Western WA Univ Viking')
,(300,'DP','Disabled Parking')
,(301,'DPM','Disabled Parking Motorcycle')
,(302,'EW','Endangered Wildlife Orca')
,(303,'D','Exempt/city')
,(304,'C','Exempt/county')
,(305,'K','Exempt/DOT')
,(306,'I','Exempt Indian')
,(307,'M','Exempt motor pool')
,(308,'E','Exempt/state')
,(309,'SP','Exempt/WSP')
,(310,'WSP','Exempt/WSP patrol cars')
,(311,'EX','Exempt Motorcycle')
,(312,'Q','Farm Exempt Decals')
,(313,'FO','Foreign Organization')
,(314,'FPO','Former Prisoner Of War')
,(315,'HAM','HAM/MARS')
,(316,'MM','Helping Kids Speak')
,(317,'HCO','Honorary Consular')
,(318,'KS','Keep Kids Safe')
,(319,'LEM','Law Enforcement Memorial')
,(320,'WW','Motorcycle Trailer')
,(321,'MU','Music Matters')
,(322,'OFF','Off Road Decal')
,(323,'PF','Professional Firefighter')
,(324,'RS','Rideshare')
,(325,'SH','Seattle Seahawks')
,(326,'FC','Seattle Sounders FC')
,(327,'BK','Share the Road')
,(328,'SN','Ski & Ride')
,(329,'S','Snowmobile Decals')
,(330,'SD','Square Dancer')
,(331,'ST','Stadium Mariners')
,(332,'SF','State Flower')
,(333,'FFA','Washington Farmers and Ranchers')
,(334,'FS','Washington Fish')
,(335,'LH','Washington Lighthouses')
,(336,'NP','Washington National Parks Fund')
,(337,'PKR','Washington Parks & Recreation')
,(338,'WR','Washington State Wrestling')
,(339,'TN','Washington Tennis')
,(340,'WB','Washington Wildlife-Bear')
,(341,'WD','Washington Wildlife-Deer')
,(342,'WE','Washington Wildlife-Elk')
,(343,'PT','We Love Our Pets')
,(344,'WWE','Wild on Washington Eagle')
,(355,'AMR','Amateur Radio Operator')
,(356,'AVIA','Aviation')
,(358,'HORSELESS','Horseless Carriage')
,(359,'HORSELESS_M','Horseless Carriage Motocycle')
,(360,'WA_STEELHEAD','Washington Steelhead')
,(361,'WA_FREDHUTCH','Fred Hutchinson Cancer Research')
,(362,'WA_MARINERS','Washington Mariniers')
,(363,'WSUP','Collegiate-WA State Univ Cougar -- prefix (deprecated)')
,(364,'WSUS','Collegiate-WA State Univ Cougar-- suffix (deprecated) ')
,(371,'GSA_G10','Goods Services Administration-G10')
,(372,'GSA_G11','Goods Services Administration-G11')
,(373,'GSA_G13','Goods Services Administration-G13')
,(374,'GSA_G14','Goods Services Administration-G14')
,(375,'GSA_G20','Goods Services Administration-G20')
,(376,'GSA_G31','Goods Services Administration-G31')
,(377,'GSA_G32','Goods Services Administration-G32')
,(378,'GSA_G41','Goods Services Administration-G41')
,(379,'GSA_G42','Goods Services Administration-G42')
,(380,'GSA_G43','Goods Services Administration-G43')
,(381,'GSA_G61','Goods Services Administration-G61')
,(382,'GSA_G62','Goods Services Administration-G62')
,(383,'GSA_G63','Goods Services Administration-G63')
,(384,'GSA_G71','Goods Services Administration-G71')
,(385,'GSA_G82','Goods Services Administration-G82')
,(386,'GSA_G87','Goods Services Administration-G87')
,(387,'GSA_G90','Goods Services Administration-G90')
,(388,'GSA_N58','Goods Services Administration-N58')

; -- Generated Statement 

insert into tolling.EnuProblematicPlateReason(problematicPlateReason,shortCode,description) values 
(1,'OCRLOWSCORE','OCR Low Score')
,(2,'LOWCONTRAST','Low Contrast')

; -- Generated Statement 

insert into tolling.EnuPromoType(enuPromoTypeId,shortCode,description) values 
(1,'FREE','All Tolls Free')
,(2,'D20PC','20% discount on Monday')

; -- Generated Statement 

insert into tolling.EnuVehicleClass(vehicleClassId,shortCode,description,vehicleClassTypeId,aigCode) values 
(0,'UNKNOWN','Unknown Vehicle Class','1','0')
,(1,'CARXPORTER_591','Car transporter 3 axles (under 65 ;, dual tires','1','591')
,(2,'CARXPORTER_595','Car transporter 4 axles (under 65 ;, dual tires','1','595')
,(3,'CARXPORTER_599','Car transporter 5 axles (under 65 ;, dual tires','1','599')
,(4,'CARXPORTER_603','Car transporter 6 axles (under 65 ;, dual tires','1','603')
,(5,'CARXPORTER_607','Car transporter 7 axles (under 65 ;, dual tires','1','607')
,(6,'CARXPORTER_659','Car transporter 4 axles (over 65 ;, dual tires','1','659')
,(7,'CARXPORTER_663','Car transporter 5 axles (over 65 ;, dual tires','1','663')
,(8,'CARXPORTER_667','Car transporter 6 axles (over 65 ;, dual tires','1','667')
,(9,'CARXPORTER_671','Car transporter 7 axles (over 65 ;, dual tires','1','671')
,(10,'AUTOSUV_72','Auto/SUV 2 axles, 4 tires (up to 7,000 lbs.;','2','72')
,(11,'AUTOSUV_76','Auto/SUV 3 axles, 6 tires (up to 7,000 lbs.;','2','76')
,(12,'AUTOSUV_80','Auto/SUV 4 axles, 8 tires (up to 7,000 lbs.;','2','80')
,(13,'AUTOSUV_84','Auto/SUV 4 axles, 10 tires (up to 7,000 lbs.;','2','84')
,(14,'BUS_392','Bus 2 axles, 4 tires (up to 7,000 lbs.;','3','392')
,(15,'BUS_394','Bus 2 axles, 4 tires (over 7,000 lbs.;','3','394')
,(16,'BUS_393','Bus 2 axles, 6 tires (up to 7,000 lbs.;, dual tires','3','393')
,(17,'BUS_395','Bus 2 axles, 6 tires (over 7,000 lbs.;, dual tires','3','395')
,(18,'BUS_396','Bus 3 axles, 6 tires (up to 7,000 lbs.;','3','396')
,(19,'BUS_398','Bus 3 axles, 6 tires (over 7,000 lbs.;','3','398')
,(20,'BUS_397','Bus 3 axles, 8 or 10 tires (up to 7,000 lbs.;, dual tires','3','397')
,(21,'BUS_399','Bus 3 axles, 8 or 10 tires (over 7,000 lbs.;, dual tires','3','399')
,(22,'BUS_400','Bus 4 axles, 8 tires (up to 7,000 lbs.;','3','400')
,(23,'BUS_402','Bus 4 axles, 8 tires (over 7,000 lbs.;','3','402')
,(24,'BUS_401','Bus 4 axles, 10 or more tires (up to 7,000 lbs.;, dual tires','3','401')
,(25,'BUS_403','Bus 4 axles, 10 or more tires (over 7,000 lbs.;, dual tires','3','403')
,(26,'MINIBUS_328','MiniBus 2 axles, 4 tires (up to 7,000 lbs.;','4','328')
,(27,'MINIBUS_330','MiniBus 2 axles, 4 tires (over 7,000 lbs.;','4','330')
,(28,'MINIBUS_329','MiniBus 2 axles, 6 tires (up to 7,000 lbs.;, dual tires','4','329')
,(29,'MINIBUS_331','MiniBus 2 axles, 6 tires (over 7,000 lbs.;, dual tires','4','331')
,(30,'MINIBUS_332','MiniBus 3 axles, 6 tires (up to 7,000 lbs.;','4','332')
,(31,'MINIBUS_334','MiniBus 3 axles, 6 tires (over 7,000 lbs.;','4','334')
,(32,'MINIBUS_333','MiniBus 3 axles, 8 or 10 tires (up to 7,000 lbs.;, dual tires','4','333')
,(33,'MINIBUS_335','MiniBus 3 axles, 8 or 10 tires (over 7,000 lbs.;, dual tires','4','335')
,(34,'MOTORCYCLE_136','Motocycle 2 axles, 2 tires (up to 7,000 lbs.;','5','136')
,(35,'MOTORCYCLE_140','Motocycle 3 axles, 3 tires (includes trikes or a sidecar up to 7,000 lbs.;','5','140')
,(36,'MOTORCYCLE_144','Motocycle 4 axles, 4 or more tires (includes trikes or a sidecar up to 7,000 lbs.;','5','144')
,(37,'PASSVAN_264','Passenger van 2 axles, 4 tires (up to 7,000 lbs.;','12','264')
,(38,'PASSVAN_266','Passenger van 2 axles, 4 tires (over 7,000 lbs.;','12','266')
,(39,'PASSVAN_265','Passenger van 2 axles, 6 tires (up to 7,000 lbs.;, dual tires','12','265')
,(40,'PASSVAN_267','Passenger van 2 axles, 6 tires (over 7,000 lbs.;, dual tires','12','267')
,(41,'PASSVAN_268','Passenger van 3 axles, 6 tires (up to 7,000 lbs.;','12','268')
,(42,'PASSVAN_270','Passenger van 3 axles, 6 tires (over 7,000 lbs.;','12','270')
,(43,'PASSVAN_269','Passenger van 3 axles, 8 or 10 tires (up to 7,000 lbs.;, dual tires','12','269')
,(44,'PASSVAN_271','Passenger van 3 axles, 8 or 10 tires (over 7,000 lbs.;, dual tires','12','271')
,(45,'PICKUP_200','Pickup 2 axles, 4 tires (up to 7,000 lbs.;','6','200')
,(46,'PICKUP_202','Pickup 2 axles, 4 tires (over 7,000 lbs.;','6','202')
,(47,'PICKUP_201','Pickup 2 axles, 6 tires (up to 7,000 lbs.;, dual tires','6','201')
,(48,'PICKUP_203','Pickup 2 axles, 6 tires (over 7,000 lbs.;, dual tires','6','203')
,(49,'PICKUP_204','Pickup 3 axles, 6 tires (up to 7,000 lbs.;','6','204')
,(50,'PICKUP_206','Pickup 3 axles, 6 tires (over 7,000 lbs.;','6','206')
,(51,'PICKUP_205','Pickup 3 axles, 8 or 10 tires (up to 7,000 lbs.;, dual tires','6','205')
,(52,'PICKUP_207','Pickup 3 axles, 8 or 10 tires (over 7,000 lbs.;, dual tires','6','207')
,(53,'PICKUP_208','Pickup 4 axles, 8 or more tires (up to 7,000 lbs.;','6','208')
,(54,'PICKUP_210','Pickup 4 axles, 8 or more tires (over 7,000 lbs.;','6','210')
,(55,'PICKUP_209','Pickup 4 axles, 10 or more tires (up to 7,000 lbs.;, dual tires','6','209')
,(56,'PICKUP_211','Pickup 4 axles, 10 or more tires (over 7,000 lbs.;, dual tires','6','211')
,(57,'PICKUP_212','Pickup 5 axles, 10 tires (up to 7,000 lbs.;','6','212')
,(58,'PICKUP_214','Pickup 5 axles, 10 tires (over 7,000 lbs.;','6','214')
,(59,'PICKUP_213','Pickup 5 axles, 12 or more tires (up to 7,000 lbs.;, dual tires','6','213')
,(60,'PICKUP_215','Pickup 5 axles, 12 or more tires (over 7,000 lbs.;, dual tires','6','215')
,(61,'RV_456','Recreational Vechicle 2 axles, 4 tires (up to 7,000 lbs.;','7','456')
,(62,'RV_458','Recreational Vechicle 2 axles, 4 tires (over 7,000 lbs.;','7','458')
,(63,'RV_457','Recreational Vechicle 2 axles, 6 tires (up to 7,000 lbs.;, dual tires','7','457')
,(64,'RV_459','Recreational Vechicle 2 axles, 6 tires (over 7,000 lbs.;, dual tires','7','459')
,(65,'RV_460','Recreational Vechicle 3 axles, 6 tires (up to 7,000 lbs.;','7','460')
,(66,'RV_462','Recreational Vechicle 3 axles, 6 tires (over 7,000 lbs.;','7','462')
,(67,'RV_461','Recreational Vechicle 3 axles, 8 or 10 tires (up to 7,000 lbs.;, dual tires','7','461')
,(68,'RV_463','Recreational Vechicle 3 axles, 8 or 10 tires (over 7,000 lbs.;, dual tires','7','463')
,(69,'RV_464','Recreational Vechicle 4 axles, 8 tires (up to 7,000 lbs.;','7','464')
,(70,'RV_466','Recreational Vechicle 4 axles, 8 tires (over 7,000 lbs.;','7','466')
,(71,'RV_465','Recreational Vechicle 4 axles, 10 or more tires (up to 7,000 lbs.;, dual tires','7','465')
,(72,'RV_467','Recreational Vechicle 4 axles, 10 or more tires (over 7,000 lbs.;, dual tires','7','467')
,(73,'TANDEM_855','Tandem 5 axles, 2 trailers ea. (<28 1/2 ;, dual tires','8','855')
,(74,'TANDEM_859','Tandem 6 axles, 2 trailers ea. (<28 1/2 ;, dual tires','8','859')
,(75,'TANDEM_863','Tandem 7 axles, 2 trailers ea. (<28 1/2 ;, dual tires','8','863')
,(76,'TANDEM_867','Tandem 8 axles, 2 trailers ea. (<28 1/2 ;, dual tires','8','867')
,(77,'TANDEM_871','Tandem 9 axles, 2 trailers ea. (<28 1/2 ;, dual tires','8','871')
,(78,'TANDEM_875','Tandem 10 axles, 2 trailers ea. (<28 1/2 ;, dual tires','8','875')
,(79,'TANDEM_983','Tandem 5 axles, 1 trailer ea. (<28 1/2 ;, dual tires','8','983')
,(80,'TANDEM_987','Tandem 6 axles, 1 trailer ea. (<28 1/2 ;, dual tires','8','987')
,(81,'TANDEM_991','Tandem 7 axles, 1 trailer ea. (<28 1/2 ;, dual tires','8','991')
,(82,'TANDEM_995','Tandem 8 axles, 1 trailer ea. (<28 1/2 ;, dual tires','8','995')
,(83,'TANDEM_999','Tandem 9 axles, 1 trailer ea. (<28 1/2 ;, dual tires','8','999')
,(84,'TANDEM_1003','Tandem 10 axles, 1 trailer ea. (<28 1/2 ;, dual tires','8','1003')
,(85,'TANDEM_919','Tandem 5 axles, 2 trailers ea. (>28 1/2 ;, dual tires','8','919')
,(86,'TANDEM_923','Tandem 6 axles, 2 trailers ea. (>28 1/2 ;, dual tires','8','923')
,(87,'TANDEM_927','Tandem 7 axles, 2 trailers ea. (>28 1/2 ;, dual tires','8','927')
,(88,'TANDEM_931','Tandem 8 axles, 2 trailers ea. (>28 1/2 ;, dual tires','8','931')
,(89,'TANDEM_935','Tandem 9 axles, 2 trailers ea. (>28 1/2 ;, dual tires','8','935')
,(90,'TANDEM_939','Tandem 10 axles, 2 trailers ea. (>28 1/2 ;, dual tires','8','939')
,(91,'TRACTRLER_719','Tractor Trailer 3 axles (trailer less than or equal to 48 ;, dual tires','10','719')
,(92,'TRACTRLER_723','Tractor Trailer 4 axles (trailer less than or equal to 48 ;, dual tires','10','723')
,(93,'TRACTRLER_727','Tractor Trailer 5 axles (trailer less than or equal to 48 ;, dual tires','10','727')
,(94,'TRACTRLER_731','Tractor Trailer 6 axles (trailer less than or equal to 48 ;, dual tires','10','731')
,(95,'TRACTRLER_735','Tractor Trailer 7 axles (trailer less than or equal to 48 ;, dual tires','10','735')
,(96,'TRACTRLER_783','Tractor Trailer 3 axles (trailer over 48 ;, dual tires','10','783')
,(97,'TRACTRLER_787','Tractor Trailer 4 axles (trailer over 48 ;, dual tires','10','787')
,(98,'TRACTRLER_791','Tractor Trailer 5 axles (trailer over 48 ;, dual tires','10','791')
,(99,'TRACTRLER_795','Tractor Trailer 6 axles (trailer over 48 ;, dual tires','10','795')
,(100,'TRACTRLER_799','Tractor Trailer 7 axles (trailer over 48 ;, dual tires','10','799')
,(101,'MOBHOME_1103','Mobile Home 3 axles, dual tires','9','1103')
,(102,'MOBHOME_1107','Mobile Home 4 axles, dual tires','9','1107')
,(103,'MOBHOME_1111','Mobile Home 5 axles, dual tires','9','1111')
,(104,'MOBHOME_1115','Mobile Home 6 axles, dual tires','9','1115')
,(105,'MOBHOME_1119','Mobile Home 7 axles, dual tires','9','1119')
,(106,'MOBHOME_1123','Mobile Home 8 axles, dual tires','9','1123')
,(107,'MOBHOME_1127','Mobile Home 9 axles, dual tires','9','1127')
,(108,'MOBHOME_1131','Mobile Home 10 axles, dual tires','9','1131')
,(109,'TRUCKS_520','Truck 2 axles, 4 tires (up to 7,000 lbs.;','11','520')
,(110,'TRUCKS_522','Truck 2 axles, 4 tires (over 7,000 lbs.;','11','522')
,(111,'TRUCKS_521','Truck 2 axles, 6 tires (up to 7,000 lbs.;, dual tires','11','521')
,(112,'TRUCKS_523','Truck 2 axles, 6 tires (over 7,000 lbs.;, dual tires','11','523')
,(113,'TRUCKS_524','Truck 3 axles, 6 tires (up to 7,000 lbs.;','11','524')
,(114,'TRUCKS_526','Truck 3 axles, 6 tires (over 7,000 lbs.;','11','526')
,(115,'TRUCKS_525','Truck 3 axles, 8 or 10 tires (up to 7,000 lbs.;, dual tires','11','525')
,(116,'TRUCKS_527','Truck 3 axles, 8 or 10 tires (over 7,000 lbs.;, dual tires','11','527')
,(117,'TRUCKS_528','Truck 4 axles, 8 tires (up to 7,000 lbs.;','11','528')
,(118,'TRUCKS_530','Truck 4 axles, 8 tires (over 7,000 lbs.;','11','530')
,(119,'TRUCKS_529','Truck 4 axles, 10 or more tires (up to 7,000 lbs.;, dual tires','11','529')
,(120,'TRUCKS_531','Truck 4 axles, 10 or more tires (over 7,000 lbs.;, dual tires','11','531')
,(121,'TRUCKS_532','Truck 5 axles, 10 tires (up to 7,000 lbs.;','11','532')
,(122,'TRUCKS_534','Truck 5 axles, 10 tires (over 7,000 lbs.;','11','534')
,(123,'TRUCKS_533','Truck 5 axles, 12 or more tires (up to 7,000 lbs.;, dual tires','11','533')
,(124,'TRUCKS_535','Truck 5 axles, 12 or more tires (over 7,000 lbs.;, dual tires','11','535')
,(125,'TRUCKS_536','Truck 6 axles, 12 tires (up to 7,000 lbs.;','11','536')
,(126,'TRUCKS_538','Truck 6 axles, 12 tires (over 7,000 lbs.;','11','538')
,(127,'TRUCKS_537','Truck 6 axles, 14 or more tires (up to 7,000 lbs.;, dual tires','11','537')
,(128,'TRUCKS_539','Truck 6 axles, 14 or more tires (over 7,000 lbs.;, dual tires','11','539')
,(129,'TRUCKS_540','Truck 7 axles, 14 tires (up to 7,000 lbs.;','11','540')
,(130,'TRUCKS_542','Truck 7 axles, 14 tires (over 7,000 lbs.;','11','542')
,(131,'TRUCKS_541','Truck 7 axles, 16 or more tires (up to 7,000 lbs.;, dual tires','11','541')
,(132,'TRUCKS_543','Truck 7 axles, 16 or more tires (over 7,000 lbs.;, dual tires','11','543')

; -- Generated Statement 

insert into tolling.EnuVehicleClassType(vehicleClassTypeId,shortCode,description) values 
(1,'UNKNOWN','Unknown Vehicle Type')
,(2,'CARXPORTER','AUTO TRANSPORTER')
,(3,'AUTOSUV','AUTOMOBILE/SPORT UTILITY VEHICLE')
,(4,'BUS','BUSES')
,(5,'MINIBUS','MINIBUS/TEAM VAN/STRETCH LIMO S  Seating 10-15 passengers')
,(6,'MOTORCYCLE','MOTORCYCLE')
,(7,'PICKUP','PICK-UP TRUCK')
,(8,'RV','RECREATIONAL VEHICLE RV OR MOTOR HOME')
,(9,'TANDEM','TANDEM TRAILER COMBINATION  TRACTOR WITH 2 TRAILERS')
,(10,'MOBHOME','TRACTOR/MOBILE HOME COMBINATION')
,(11,'TRACTRLER','TRACTOR TRAILER COMBINATION')
,(12,'TRUCKS','TRUCKS')
,(13,'PASSVAN','PASSENGER/CARGO VAN  Seating 1-9 passengers')

; -- Generated Statement 

insert into tolling.Gantry(gantryId,roadsideGantryUniqueId,description) values 
('1','1','M40')
,('2','2','M50')

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

insert into common.EnuTemplateType(enuTemplateTypeId,shortCode,description) values 
(1,'TEST','template for testing')
,(2,'INV','template for Invoices')

; -- Generated Statement 

insert into common.Template(templateId,enuTemplateTypeId,enuLocaleId,created,body,inputUserId,inputSourceId) values 
('1','1',3082,getPostingDate(),'
<!DOCTYPE html><html lang="en"><head> <meta charset="utf-8" /> <title></title> <!-- Normalize defaults to 0, include @page --> <style> html, body { margin: 0; padding: 0; height: 100%; width: 100%; font-family: Arial, Helvetica, sans-serif; } @page { margin: 0; } </style></head><body> <!-- Each page is one div, with position: relative --> <div style="position: relative; height: 11in; page-break-after: always"> <!-- Inside each page, all element can use position: absolute --> <div style="position: absolute; top: 0.62in; left: 1.58in; width: 5.33in; height: 0.77in; overflow: hidden"> <img src="${templateBaseUri}/customer_communications_logo.png" style="width: 5.33in;" /> </div> <div style="position: absolute; top: 1.39in; left: 1.58in; width: 5.33in; height: 0.25in; overflow: hidden"> <div style="text-align: center; font-size: 10pt;font-weight: bold;font-style: italic;padding-top:0px;margin-top: 0px;">MyGoodToGo.com</div> </div> <div style="position: absolute; ${addressBlockDimension} overflow: hidden;font-size: 10pt;"> <div style="position: absolute;bottom: 0; left: 0;"> ${(primaryFirstName)!""} ${primaryLastName} <br /> ${address} <#if address2?has_content> <br /> ${address2} </#if> <br /> ${city}, ${state} ${zip} </div> </div> <div style="text-align: justify; position: absolute; top: 3.40in; left: 0.75in; width: 7in; height: 5in; overflow: hidden"> <div style="font-size: 10pt;"> <p>${letterDate}</p> <p align="right" style="margin-right: 100px;margin-top:25px;">Customer ID: ${customerAccountId}</p> <p style="margin-top:25px;">${templateSalutations} </p> <p>Your check #${checkNumber}</b> in the amount of ${checkAmount?string.currency} has been returned by your bank. You have been charged a ${nsfFee?string.currency} returned check fee.</p> <p>Should you need further assistance, please contact customer service or visit one of our customer service locations. Before speaking with a representative, have your Customer ID number ready to expedite service. </p> <p>We look forward to hearing from you and thank you for choosing <i>Good To Go!</i></p> <p style="margin-top:20px;">Sincerely, <br/>Your <i>Good To Go!</i> Customer Service Team</p> </div> </div> <div style="border-top: 0.25pt solid #757575;padding-top:15px; position: absolute;top: 9.7in;right:0.5in;bottom:0;left:0.5in;"> <div style="height:100%; width:100%; overflow: hidden; font-size: 10pt;"> <div style=""><b><i>Good To Go!</i> Customer Service Centers</b></div> <div style="float: left; width:25%; height:100%;font-size: 12px;"> <p> <b><i>Good To Go!</i></b> <br/> P.O Box 9814 <br/> Renton, WA 98507-9814 </p> </div> <div style="float: left; width:25%; height:100%;"> <p> Triton Towers <br/> 707 S. Grady Way <br/> Suite 100 <br/> Renton, WA 98057-9814 </p> </div> <div style="float: left; width:25%; height:100%;"> <p> 18910 28th Avenue West <br/> Suite 106 <br> Lynnwood, WA 98036 </p> </div> <div style="float: left; width:25%; height:100%;"> <p> 5801 Soundview Drive <br/> Suite 50A <br/> Gig Harbor, WA 98335<br/> <img style="margin-top:5px;" src="${(barcode)!""}" align="right"/> </p> </div> </div> </div> </div></body></html>
',1,1)
,('2','2',3082,getPostingDate(),'
<#ftl output_format="HTML"><html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></head><body lang="en-US" style="text-align: justify; font-family: Arial;"><#setting locale="en_US"><center><table width="100%" bgcolor="#fff" border="0" cellspacing="0" cellpadding="0"><tbody><tr><td><table bgcolor="#ffffff" border="0" cellspacing="0"	cellpadding="0" width="100%"><tbody><tr><td width="30%" style="aling: left"><table><tr><td style="vertical-align: bottom;"><div style="text-align: left; font-size: 0.8em; font-weight: normal; margin-left: 40px"">${(invoiceHeader.recipientName)!""}</div><div style="text-align: left; font-size: 0.8em; font-weight: normal; margin-left: 40px"">${(invoiceHeader.address1)!""}</div><div style="text-align: left; font-size: 0.8em; font-weight: normal; margin-left: 40px"">${(invoiceHeader.address2)!""}</div><div style="text-align: left; font-size: 0.8em; font-weight: normal; margin-left: 40px"">${(invoiceHeader.city)!""},${(invoiceHeader.state)!""} ${(invoiceHeader.postalCode)!""}</div></td></tr><tr><td><div style="text-align: left; font-size: 0.8em; font-weight: normal; margin-left: 40px">Invoice Date: ${(invoiceHeader.noticeDate)!""}</div></td></tr></table></td><td width="30%" style="aling: right"><table><tr><td><div style="text-align: left; font-size: 0.8em; font-weight: bold;">Customer	ID:</div></td><td><div style="font-size: 0.8em">${(invoiceHeader.customerId)!""}</div></td></tr><tr><td><div style="text-align: left; font-size: 0.8em; font-weight: bold;">Invoice #</div></td><td><div style="font-size: 0.8em">${(invoiceHeader.invoiceId)!""}</div></td></tr><tr><td><div style="text-align: left; font-size: 0.8em; font-weight: bold;">License Plate:</div></td><td><div style="font-size: 0.8em">${(invoiceHeader.lpnumber)!""}</div></td></tr><tr><td><div style="text-align: left; font-size: 0.8em; font-weight: bold;">Total Due:</div></td><td><div style="font-size: 0.8em">${(invoiceHeader.totalDue?string.currency)!""}</div></td></tr><tr><td><div style="text-align: left; font-size: 0.8em; font-weight: bold;">Due Date:</div></td><td><div style="font-size: 0.8em">${(invoiceHeader.dueDate)!""}</div></td></tr></table></td></tr></tbody></table></td></tr></tbody></table><table width="100%" bgcolor="#fff" border="0" cellspacing="0" cellpadding="0"><tbody><tr title="null" bgcolor="#fff"><td></td></tr></tbody></table><table width="100%" bgcolor="#fff" border="0" cellspacing="0" cellpadding="0"><body><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td width="100%" colspan="2"><div style="text-align: center; font-weight: bold;"></div></td></tr><tr><td>&nbsp;</td></tr><tr><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: bold; font-size: 0.8em">DATE</td><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: bold; font-size: 0.8em">TRANS	ID#</td><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: bold; font-size: 0.8em">PASS ID#</td><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: bold; font-size: 0.8em">LICENSE#</td><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: bold; font-size: 0.8em">TOTAL</td></tr><#list itemInvoiceDetails as itemInvoiceDetail><tr><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: normal; font-size: 0.8em">${(itemInvoiceDetail.laneExitDate)!""}</td><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: normal; font-size: 0.8em">${(itemInvoiceDetail.tripId)!""}</td><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: normal; font-size: 0.8em">${(itemInvoiceDetail.passId)!""}</td><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: normal; font-size: 0.8em">${(itemInvoiceDetail.lpnumber)!""}</td><td	style="border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center; font-weight: normal; font-size: 0.8em">${(itemInvoiceDetail.fareAmount?string.currency)!""}</td></tr></#list><tr><td align="right"><div style="font-weight: bold;"></div></td><td align="right"><div	style="font-size: 0.6em; font-weight: bold;">TOTAL BALANCE	DUE: ${(invoiceHeader.totalDue?string.currency)!""}</div></td></tr></body></table></center></body></html>
',1,1)

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
('eae710f8-dd57-4ea2-886a-8b30a56b8886','VCustomerHistory','{
  "dataTableName" : "crm.VCustomerHistory",
  "aSName" : "VCustomerHistory",
  "columnConfigurations" : [ {
    "name" : "startDate",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "objectType",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "action",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "inputUserId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "id",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "revisionId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "prevRevisionId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "mtTable",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "customerId",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "startDate",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Fecha Inicio"
  }, {
    "name" : "objectType",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "VCustomerHistory.objectType"
  }, {
    "name" : "action",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "VCustomerHistory.action"
  }, {
    "name" : "inputUserId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Usuario"
  }, {
    "name" : "id",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "VCustomerHistory.id"
  }, {
    "name" : "revisionId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "VCustomerHistory.revisionId"
  }, {
    "name" : "prevRevisionId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "VCustomerHistory.prevRevisionId"
  }, {
    "name" : "mtTable",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "VCustomerHistory.mtTable"
  }, {
    "name" : "customerId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Factura"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "startDate"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "objectType"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "action"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "id"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "revisionId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "prevRevisionId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "mtTable"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customerId"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "startDate"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "objectType"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "action"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "inputUserId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "id"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "revisionId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "prevRevisionId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "mtTable"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customerId"
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
    "name" : "startDate"
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
    "name" : "objectType"
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
    "name" : "action"
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
    "name" : "inputUserId"
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
    "name" : "id"
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
    "name" : "revisionId"
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
    "name" : "prevRevisionId"
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
    "name" : "mtTable"
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
    "name" : "customerId"
  } ]
}',getPostingDate(),'1',1,1)
,('3f879c5d-3d85-4eb0-9f6a-643f148a2c0e','VFindVehicle','{
  "dataTableName" : "tolling.VFindVehicle",
  "aSName" : "VFindVehicle",
  "columnConfigurations" : [ {
    "name" : "vehicleId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "shortCode",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "lpnumber",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "make",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "model",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "modelYear",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "color",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "axles",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "vehicleClassId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "customerId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "licensePlateId",
    "hidden" : true,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "vehicleId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Vehiculo"
  }, {
    "name" : "shortCode",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Etiqueta"
  }, {
    "name" : "lpnumber",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Matrícula"
  }, {
    "name" : "make",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "VFindVehicle.make"
  }, {
    "name" : "model",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Modelo"
  }, {
    "name" : "modelYear",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Año Modelo"
  }, {
    "name" : "color",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Color"
  }, {
    "name" : "axles",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Ejes"
  }, {
    "name" : "vehicleClassId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Clase Vehículo"
  }, {
    "name" : "customerId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Factura"
  }, {
    "name" : "licensePlateId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Matricula"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "vehicleId"
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
    "name" : "lpnumber"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "make"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "model"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "modelYear"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "color"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "axles"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "vehicleClassId"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customerId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "licensePlateId"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "vehicleId"
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
    "name" : "lpnumber"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "make"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "model"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "modelYear"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "color"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "axles"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "vehicleClassId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customerId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "licensePlateId"
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
    "name" : "vehicleId"
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
    "name" : "shortCode"
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
    "name" : "lpnumber"
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
    "name" : "make"
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
    "name" : "model"
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
    "name" : "modelYear"
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
    "name" : "color"
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
    "name" : "axles"
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
    "name" : "vehicleClassId"
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
    "name" : "customerId"
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
    "name" : "licensePlateId"
  } ]
}',getPostingDate(),'1',1,1)
,('a43aa8cc-0154-4756-918d-9533a6e4fec9','Promo','{
  "dataTableName" : "tolling.Promo",
  "aSName" : "Promo",
  "columnConfigurations" : [ {
    "name" : "promoId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "customerId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "promoTypeId",
    "hidden" : false,
    "available" : true,
    "active" : true
  } ],
  "orderByConfigurations" : [ {
    "name" : "promoId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Promo.promoId"
  }, {
    "name" : "customerId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Factura"
  }, {
    "name" : "promoTypeId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "Promo.promoTypeId"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "promoId"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customerId"
  }, {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "promoTypeId"
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "promoId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customerId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "promoTypeId"
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
    "name" : "promoId"
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
    "name" : "customerId"
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
    "name" : "promoTypeId"
  } ]
}',getPostingDate(),'1',1,1)
,('8d33abd5-50d4-4d6c-bb11-5567b34fb5d3','CustomerCase','{
  "dataTableName" : "cs.CustomerCase",
  "aSName" : "CustomerCase",
  "columnConfigurations" : [ {
    "name" : "customercaseId",
    "hidden" : true,
    "available" : true,
    "active" : true
  }, {
    "name" : "customerId",
    "hidden" : false,
    "available" : true,
    "active" : true
  }, {
    "name" : "csCaseId",
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
    "name" : "customercaseId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "CustomerCase.customercaseId"
  }, {
    "name" : "customerId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Factura"
  }, {
    "name" : "csCaseId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Caso"
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
    "label" : "# Usuario"
  }, {
    "name" : "inputSourceId",
    "asc" : false,
    "active" : false,
    "hidden" : false,
    "label" : "# Origen"
  } ],
  "filterConfigurations" : [ {
    "hidden" : false,
    "operator" : "EQUAL",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customercaseId"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customerId"
  }, {
    "hidden" : false,
    "operator" : "IN",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "csCaseId"
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
  } ],
  "detailScreenConfigurations" : [ {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customercaseId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "customerId"
  }, {
    "hidden" : false,
    "newLine" : false,
    "sClass" : "col-md-4",
    "required" : false,
    "available" : true,
    "active" : true,
    "name" : "csCaseId"
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
    "required" : false,
    "actions" : [ {
      "action" : "visibility",
      "objetives" : [ ],
      "values" : [ ]
    } ],
    "constraints" : [ ],
    "available" : true,
    "active" : true,
    "name" : "customercaseId"
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
    "name" : "customerId"
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
    "name" : "csCaseId"
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

insert into label.MTlabel(mtLabelId,shortCode,screen,en_US,es_ES) values 
('8da705c3-0971-4bf3-8204-59121e7fca28','lastInvoice','VCustomerSearch','Last Invoice','Última factura')
,('45c9811f-b57d-44d3-b96d-a49f5afbb620','customerId','VCustomerSearch','Customer ID','# Factura')
,('e0a92de1-7104-4c2f-9418-425327c280ac','lastNameOrCompanyName','VCustomerSearch','Name/Company','Nombre/compañía')
,('6701a622-7c9a-4028-88f9-9c9b4b2038ad','firstName','VCustomerSearch','First Name','Nombre')
,('0aafda76-28ec-423e-b5d4-c788cf1f58f3','address','VCustomerSearch','Address','Dirección')
,('c34cc02e-5964-4c48-95fd-67f3054e7dae','fullName','VCustomerSearch','Full Name','Nombre Completo')
,('0b27fefe-232e-4cb8-9267-43d0356f37fb','mailingAddress','VCustomerSearch','Mailing address','Dirección Correo')
,('d57d404b-8cd1-4f8d-9d4b-899254699b94','customerTypeId','VCustomerSearch','Customer Type','Tipo Cliente')
,('b4c08ae7-2d8f-41c2-b7e0-08bcc08c690f','VCustomerSearch','VCustomerSearch','Customer Search','Búsqueda Cliente')
,('2782cb1b-bb4c-461c-b0ad-1da48f0408fa','VehicleInfo','VehicleInfo','Vehicle Info','Info Vehículo')
,('48f48a75-c629-4e11-98da-9c7840867207','vehicleClassId','VehicleInfo','Vehicle Class','Clase Vehículo')
,('9626e5dd-f900-4226-8186-2db9d3e57f29','startDate','VehicleInfo','Start Date','Fecha Inicio')
,('cccceb40-d2c3-4acd-bd74-84f913ab63b0','vehicleId','VehicleInfo','Vehicle ID','# Vehiculo')
,('42b30a74-1c08-49c3-868a-76ae532dc4a1','style','VehicleInfo','Style','Estilo')
,('db6220b1-1059-4ffd-b68f-7a2087ebfe72','licensePlateId','VehicleInfo','License Plate ','Matricula')
,('47ea59d9-6af1-4f62-a129-8915cd285bcc','endDate','VehicleInfo','End Date','Fecha Final')
,('015a32e1-e257-4d7e-8118-0dc3f9c29cd1','color','VehicleInfo','Color','Color')
,('52446274-126a-4b52-aa4d-6f77406c830c','model','VehicleInfo','Model','Modelo')
,('d36f4f5a-0941-4f9f-8442-0519c5e4e4ce','axles','VehicleInfo','Axles','Ejes')
,('01dbe186-7640-4941-a84b-4d4dec008548','modelYear','VehicleInfo','Model Year','Año Modelo')
,('e3f6a675-0746-422c-8dd1-f8e2d163ef15','VehicleInfo.make','VehicleInfo','Make','Fabricante')
,('00c8b285-1074-4adc-9dbd-1c87ef020e13','ledgerItemId','VTransactionHistory','Ledger Item','Asiento')
,('e8fa8b86-832b-4012-83e5-0c262f5b6b46','transactionTypeId','VTransactionHistory','Transaction Type','Tipo Transacción')
,('3996418f-0dd1-4df6-94d5-a15aa82afbbe','VTransactionHistory','VTransactionHistory','transaction History','Historial Transacciones')
,('a43e985a-a751-4a2c-8daa-b22970c5e0dc','tripId','VTransactionHistory','Trip ID','# Viaje')
,('9e24b0d6-0ab2-4f6d-adac-9e163ecce474','amount','VTransactionHistory','Amount','Cantidad')
,('56a6cf79-c7d2-4780-8bcb-1b6b62d0fd6a','paymentId','VTransactionHistory','Payment ID','# Pago')
,('9b41504c-b2a5-44f0-a448-7769ef45cbf6','balance','VTransactionHistory','Balance','balance')
,('4104cd3e-7909-4d8b-96d5-e71177c3de32','objectType','VCustomerHistory','Object Type','Tipo')
,('d18adfd7-bf19-4ba1-a106-b23fceaf4792','action','VCustomerHistory','Action','Acción')
,('31a3c1aa-1a2f-403a-a526-0595bf0ab0c4','id','VCustomerHistory','History ID','# Historia')
,('d8463c50-fa45-4eea-8dc3-71832d3de3dd','mtTable','VCustomerHistory','Table','Tabla')
,('a4e3e84d-ff69-4c21-a474-8ae7c5d29ee9','VCustomerHistory','VCustomerHistory','Customer History','Historia Cliente')
,('4434ea51-c7da-45ba-b55d-30a7c7040cf2','casePriorityId','VDetailPageCaseList','Case Priority ID','# Caso')
,('fa05422b-9577-4fc2-a60f-6648f9c7ce63','caseStatusId','VDetailPageCaseList','Case Status','Estado')
,('4bbcbd09-2b28-4cea-b267-9f14fe7e26c2','caseTypeId','VDetailPageCaseList','Case Type','Tipo')
,('25d75158-fc02-4dd2-8c54-1577150e7c84','VDetailPageCaseList.csCaseId','VDetailPageCaseList','Case ID','# Caso')
,('575f1d52-2f4b-40c4-a4c7-913335327bda','subject','VDetailPageCaseList','Subject','Sujeto')
,('656bd66e-99cf-4841-b396-773e69d6d733','manualReviewRequired','VDetailPageCaseList','Manual Review','revisión Manual')
,('c60e97ec-8f69-4ee9-bd8d-9479e95d31bd','postalAddressId','HPostalAddress','Postal address','Direccion Postal')
,('8e50fb7c-13a2-48ee-8f95-80529f67a294','barcode','HPostalAddress','Bar Code','Código')
,('8ea7dc96-21f1-4f90-8678-ea0852f5c8b6','stateProvinceId','HPostalAddress','State','Estado')
,('8f528271-bec7-4ae3-8fc7-e4580a0ae910','address2','HPostalAddress','Address +','Direccion +')
,('8f245815-10d8-4b4d-8b4a-f0ed582abb55','city','HPostalAddress','City','Ciudad')
,('0bbd953a-c397-4136-9b9a-664dca4bc0be','address1','HPostalAddress','Address','Direccion')
,('cdd83c8c-f39d-40e4-8cc7-19293c77194c','HPostalAddress.coordinates','HPostalAddress','Coordinates','Coordenadas')
,('3a59a5aa-8b75-4076-8b26-0714c170d561','postalCode','HPostalAddress','Postal Code','Código Postal')
,('c53c0764-8f35-45ab-82c8-ea6c9a70a68a','phoneTypeId','HPhoneNumber','Type','Tipo')
,('75d0a354-767b-4cbf-9982-29576a87e7c9','lpNumber','lpnumber','License Plate','Matrícula')
,('721a27ad-f098-41b4-ae3e-faf4f4544bd6','licensePlateTypeId','licensePlatetypeId','Type','tipo')
,('d72f6e90-6837-4cef-a1c9-7de2cb0635af','licencePlateJurisdictionId','licencePlate','Jurisdiction','Jurisdicción')
,('9821dc1d-2084-4d6b-afbd-bf96ea26f70b','expectedStatusTransitionDate','CSCase','Expected Transaction Date','Fecha Expiración')
,('b6472d23-9479-4139-addc-03329a72c317','paymentTypeId','PaymentMethod','Payment Type','Tipo Pago')
,('35f71629-9d78-4533-b9c9-7fce62b3bf62','PaymentMethod','PaymentMethod','Payment Method','Método pago')
,('bb7763f5-b14e-4a63-8611-7f183aa44d34','accountNumber','PaymentMethod','Account Number','# Cliente')
,('5ae08c8b-4218-4899-acd9-ad6e0da3d8d5','ccNumber','PaymentMethod','CC Number','Número Cuenta')
,('c4558d68-d247-4649-bedc-a0e80036f1cb','checkNumber','PaymentMethod','Check Number','# Cheque')
,('5125dc91-a55f-4e1a-a0ae-6c284023656b','lastInvoice','VCustomerSearch','Last Invoice','Factura')
,('73ed76be-1892-4316-8b83-eb69a67dc6de','laneExitDate','VTripSearch','Exit Date','Salida linea')
,('c96474aa-6a3c-4df3-b985-8a78bf978c3c','fareAmount','VTripSearch','Fare amount','Cantidad')
,('b97f148d-e137-4056-b98d-6c138f1d3fdf','passId','VTripSearch','Pass ID','# Pass')
,('55388d91-659c-4d69-ac56-3977035119a0','laneEntryDate','VTripSearch','Entry Date','Entrada linea')
,('e4fc5ec3-aa5d-4a32-8a8f-c01bb0c10e6d','lpnumber','VTripSearch','LP Number','Matrícula')
,('37fe7135-8683-4aa3-8c2e-a15f6f7108b4','licensePlatetypeId','VTripSearch','LP Type','Tipo')
,('b84fec4e-2761-4fe8-b2a0-04bfbbc4a0ce','promoTypeId','Promo','Promo Type','Tipo')
,('ba235cad-5caf-4ab8-919c-bec54009e79b','customers','VCaseSearch','Customers','Clientes')
,('817b1fea-42e5-4fb2-a14c-4bbef3817c23','csCaseId','VCaseSearch','Case ID','# Caso')
,('6c9a1c2f-8222-4249-877f-a1382abacd33','CustomerCase','CustomerCase','Customer - Case','Cliente - Caso')
,('b125ec2b-3869-4638-9dbe-d3c62f2421dd','VCaseSearch','VCaseSearch','Case Search','Búsqueda Caso')
,('4e8f3092-dcb1-41dc-a300-7164c0872d8c','ProblematicPlate','ProblematicPlate','Problematic Plate','Matrícula Problematica')
,('bc033cc9-35a5-452a-a142-d7499f3ab99a','problematicPlateId','ProblematicPlate','Plate ID','# Matrícula')
,('27c81b56-603c-4c8a-b97a-fb934d907088','problematicPlateReasonId','ProblematicPlate','Reason','Razón')
,('3813a2f7-2b71-4e55-a4b3-a0cc91d21604','ProblematicPlate.notes','ProblematicPlate','Notes','Nota')
,('8cee4928-31ff-4eec-9b09-6942e8b54b70','effectiveEndDate','efectiveEndDate','End Date','Fecha Final')
,('9eae2af4-6c72-46ef-830d-8d40c8a973fa','effectiveStartDate','efectiveStartDate','Start Date','Fecha inicio')
,('016d8f57-d4e2-417c-9672-63f5a72e83ba','salutation','','Salutation','Sr/A')
,('b905df40-f8f7-496a-81a6-2586bc4b3b93','middleName','','Middle Name','Nombre 2')
,('ac63b7f5-d1f8-4fd5-8360-0fb3c4f74cf3','suffix','','Suffix','Sufijo')
,('8f765c60-763e-46d8-bbac-a263301bcd87','lastInvoiceId','VCustomerSearch','Last Invoice #','# Última Factura')

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

ALTER TABLE acc.Allocation ADD CONSTRAINT FK_acc_Allocation_creditRevisionId FOREIGN KEY(creditRevisionId)  REFERENCES acc.Ledger(revisionId)
; -- Generated Statement 

ALTER TABLE acc.Allocation ADD CONSTRAINT FK_acc_Allocation_debitRevisionId FOREIGN KEY(debitRevisionId)  REFERENCES acc.Ledger(revisionId)
; -- Generated Statement 

ALTER TABLE acc.Allocation ADD CONSTRAINT FK_acc_Allocation_startAnnotationId FOREIGN KEY(startAnnotationId)  REFERENCES acc.Annotation(annotationId)
; -- Generated Statement 

ALTER TABLE acc.Allocation ADD CONSTRAINT FK_acc_Allocation_endAnnotationId FOREIGN KEY(endAnnotationId)  REFERENCES acc.Annotation(annotationId)
; -- Generated Statement 

ALTER TABLE acc.Annotation ADD CONSTRAINT FK_acc_Annotation_annotationTypeId FOREIGN KEY(annotationTypeId)  REFERENCES acc.EnuAnnotationType(annotationTypeId)
; -- Generated Statement 

ALTER TABLE acc.Annotation ADD CONSTRAINT FK_acc_Annotation_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE acc.Balance ADD CONSTRAINT FK_acc_Balance_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE acc.Cancellation ADD CONSTRAINT FK_acc_Cancellation_cancelledRevisionId FOREIGN KEY(cancelledRevisionId)  REFERENCES acc.Ledger(revisionId)
; -- Generated Statement 

ALTER TABLE acc.Cancellation ADD CONSTRAINT FK_acc_Cancellation_cancellingRevisionId FOREIGN KEY(cancellingRevisionId)  REFERENCES acc.Ledger(revisionId)
; -- Generated Statement 

ALTER TABLE acc.Ledger ADD CONSTRAINT FK_acc_Ledger_ledgerItemId FOREIGN KEY(ledgerItemId)  REFERENCES acc.LedgerItem(ledgerItemId)
; -- Generated Statement 

ALTER TABLE acc.Ledger ADD CONSTRAINT FK_acc_Ledger_ledgerInfoId FOREIGN KEY(ledgerInfoId)  REFERENCES acc.LedgerInfo(ledgerInfoId)
; -- Generated Statement 

ALTER TABLE acc.Ledger ADD CONSTRAINT FK_acc_Ledger_transactionTypeId FOREIGN KEY(transactionTypeId)  REFERENCES acc.EnuTransactionType(transactionTypeId)
; -- Generated Statement 

ALTER TABLE acc.Ledger ADD CONSTRAINT FK_acc_Ledger_ledgerTypeId FOREIGN KEY(ledgerTypeId)  REFERENCES acc.EnuLedgerType(ledgerTypeId)
; -- Generated Statement 

ALTER TABLE acc.Ledger ADD CONSTRAINT FK_acc_Ledger_annotationId FOREIGN KEY(annotationId)  REFERENCES acc.Annotation(annotationId)
; -- Generated Statement 

ALTER TABLE acc.Repost ADD CONSTRAINT FK_acc_Repost_fromRevisionId FOREIGN KEY(fromRevisionId)  REFERENCES acc.Ledger(revisionId)
; -- Generated Statement 

ALTER TABLE acc.Repost ADD CONSTRAINT FK_acc_Repost_toRevisionId FOREIGN KEY(toRevisionId)  REFERENCES acc.Ledger(revisionId)
; -- Generated Statement 

ALTER TABLE crm.CustomerPaymentMethod ADD CONSTRAINT FK_crm_CustomerPaymentMethod_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE crm.CustomerPaymentMethod ADD CONSTRAINT FK_crm_CustomerPaymentMethod_paymentMethodId FOREIGN KEY(paymentMethodId)  REFERENCES payment.PaymentMethod(paymentMethodId)
; -- Generated Statement 

ALTER TABLE crm.CustomerPaymentMethod ADD CONSTRAINT FK_crm_CustomerPaymentMethod_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE crm.CustomerPaymentMethod ADD CONSTRAINT FK_crm_CustomerPaymentMethod_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE crm.CustomerSuplementaryContact ADD CONSTRAINT FK_crm_CustomerSuplementaryContact_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE crm.CustomerSuplementaryContact ADD CONSTRAINT FK_crm_CustomerSuplementaryContact_personOrCompanyId FOREIGN KEY(personOrCompanyId)  REFERENCES crm.PersonOrCompanyPk(personOrCompanyId)
; -- Generated Statement 

ALTER TABLE crm.CustomerSuplementaryContact ADD CONSTRAINT FK_crm_CustomerSuplementaryContact_contactTypeId FOREIGN KEY(contactTypeId)  REFERENCES crm.EnuContactType(contactTypeId)
; -- Generated Statement 

ALTER TABLE crm.EnuStateProvince ADD CONSTRAINT FK_crm_EnuStateProvince_countryId FOREIGN KEY(countryId)  REFERENCES crm.EnuCountry(countryId)
; -- Generated Statement 

ALTER TABLE crm.HCustomer ADD CONSTRAINT FK_crm_HCustomer_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE crm.HCustomer ADD CONSTRAINT FK_crm_HCustomer_mainContactPersonOrCompanyId FOREIGN KEY(mainContactPersonOrCompanyId)  REFERENCES crm.PersonOrCompanyPk(personOrCompanyId)
; -- Generated Statement 

ALTER TABLE crm.HCustomer ADD CONSTRAINT FK_crm_HCustomer_mailingPostalAddressId FOREIGN KEY(mailingPostalAddressId)  REFERENCES crm.PostalAddressPk(postalAddressId)
; -- Generated Statement 

ALTER TABLE crm.HCustomer ADD CONSTRAINT FK_crm_HCustomer_shippingPostalAddressId FOREIGN KEY(shippingPostalAddressId)  REFERENCES crm.PostalAddressPk(postalAddressId)
; -- Generated Statement 

ALTER TABLE crm.HCustomer ADD CONSTRAINT FK_crm_HCustomer_customerTypeId FOREIGN KEY(customerTypeId)  REFERENCES crm.EnuCustomerType(customerTypeId)
; -- Generated Statement 

ALTER TABLE crm.HCustomer ADD CONSTRAINT FK_crm_HCustomer_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE crm.HCustomer ADD CONSTRAINT FK_crm_HCustomer_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE crm.HEmailAddress ADD CONSTRAINT FK_crm_HEmailAddress_emailAddressId FOREIGN KEY(emailAddressId)  REFERENCES crm.EmailAddressPk(emailAddressId)
; -- Generated Statement 

ALTER TABLE crm.HEmailAddress ADD CONSTRAINT FK_crm_HEmailAddress_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE crm.HEmailAddress ADD CONSTRAINT FK_crm_HEmailAddress_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE crm.HPersonOrCompany ADD CONSTRAINT FK_crm_HPersonOrCompany_personOrCompanyId FOREIGN KEY(personOrCompanyId)  REFERENCES crm.PersonOrCompanyPk(personOrCompanyId)
; -- Generated Statement 

ALTER TABLE crm.HPersonOrCompany ADD CONSTRAINT FK_crm_HPersonOrCompany_phoneNumberId FOREIGN KEY(phoneNumberId)  REFERENCES crm.PhoneNumberPK(phoneNumberId)
; -- Generated Statement 

ALTER TABLE crm.HPersonOrCompany ADD CONSTRAINT FK_crm_HPersonOrCompany_emailAddressId FOREIGN KEY(emailAddressId)  REFERENCES crm.EmailAddressPk(emailAddressId)
; -- Generated Statement 

ALTER TABLE crm.HPersonOrCompany ADD CONSTRAINT FK_crm_HPersonOrCompany_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE crm.HPersonOrCompany ADD CONSTRAINT FK_crm_HPersonOrCompany_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE crm.HPhoneNumber ADD CONSTRAINT FK_crm_HPhoneNumber_phoneNumberId FOREIGN KEY(phoneNumberId)  REFERENCES crm.PhoneNumberPK(phoneNumberId)
; -- Generated Statement 

ALTER TABLE crm.HPhoneNumber ADD CONSTRAINT FK_crm_HPhoneNumber_phoneTypeId FOREIGN KEY(phoneTypeId)  REFERENCES crm.EnuPhoneNumberType(phoneNumberTypeId)
; -- Generated Statement 

ALTER TABLE crm.HPhoneNumber ADD CONSTRAINT FK_crm_HPhoneNumber_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE crm.HPhoneNumber ADD CONSTRAINT FK_crm_HPhoneNumber_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE crm.HPostalAddress ADD CONSTRAINT FK_crm_HPostalAddress_postalAddressId FOREIGN KEY(postalAddressId)  REFERENCES crm.PostalAddressPk(postalAddressId)
; -- Generated Statement 

ALTER TABLE crm.HPostalAddress ADD CONSTRAINT FK_crm_HPostalAddress_stateProvinceId FOREIGN KEY(stateProvinceId)  REFERENCES crm.EnuStateProvince(stateProvinceId)
; -- Generated Statement 

ALTER TABLE crm.HPostalAddress ADD CONSTRAINT FK_crm_HPostalAddress_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE crm.HPostalAddress ADD CONSTRAINT FK_crm_HPostalAddress_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE crm.Turista ADD CONSTRAINT FK_crm_Turista_countryId FOREIGN KEY(countryId)  REFERENCES crm.EnuCountry(countryId)
; -- Generated Statement 

ALTER TABLE cs.CSCase ADD CONSTRAINT FK_cs_CSCase_csCaseId FOREIGN KEY(csCaseId)  REFERENCES cs.CSCasePK(csCaseId)
; -- Generated Statement 

ALTER TABLE cs.CSCase ADD CONSTRAINT FK_cs_CSCase_caseTypeId FOREIGN KEY(caseTypeId)  REFERENCES cs.EnuCaseType(caseTypeId)
; -- Generated Statement 

ALTER TABLE cs.CSCase ADD CONSTRAINT FK_cs_CSCase_caseStatusId FOREIGN KEY(caseStatusId)  REFERENCES cs.EnuCaseStatus(caseStatusId)
; -- Generated Statement 

ALTER TABLE cs.CSCase ADD CONSTRAINT FK_cs_CSCase_casePriorityId FOREIGN KEY(casePriorityId)  REFERENCES cs.EnuCasePriority(casePriorityId)
; -- Generated Statement 

ALTER TABLE cs.CSCase ADD CONSTRAINT FK_cs_CSCase_documentation FOREIGN KEY(documentation)  REFERENCES common.FileGroup(fileGroupId)
; -- Generated Statement 

ALTER TABLE cs.CSCase ADD CONSTRAINT FK_cs_CSCase_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE cs.CSCase ADD CONSTRAINT FK_cs_CSCase_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE cs.CustomerCase ADD CONSTRAINT FK_cs_CustomerCase_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE cs.CustomerCase ADD CONSTRAINT FK_cs_CustomerCase_csCaseId FOREIGN KEY(csCaseId)  REFERENCES cs.CSCasePK(csCaseId)
; -- Generated Statement 

ALTER TABLE cs.CustomerCase ADD CONSTRAINT FK_cs_CustomerCase_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE cs.CustomerCase ADD CONSTRAINT FK_cs_CustomerCase_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE inv.Invoice ADD CONSTRAINT FK_inv_Invoice_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE inv.InvoiceDocument ADD CONSTRAINT FK_inv_InvoiceDocument_invoiceId FOREIGN KEY(invoiceId)  REFERENCES inv.Invoice(invoiceId)
; -- Generated Statement 

ALTER TABLE inv.InvoiceDocument ADD CONSTRAINT FK_inv_InvoiceDocument_sentToPostalAddressRevisionId FOREIGN KEY(sentToPostalAddressRevisionId)  REFERENCES crm.HPostalAddress(revisionId)
; -- Generated Statement 

ALTER TABLE inv.InvoiceDocument ADD CONSTRAINT FK_inv_InvoiceDocument_fileGroupId FOREIGN KEY(fileGroupId)  REFERENCES common.FileGroup(fileGroupId)
; -- Generated Statement 

ALTER TABLE inv.InvoiceLedgerItem ADD CONSTRAINT FK_inv_InvoiceLedgerItem_invoiceId FOREIGN KEY(invoiceId)  REFERENCES inv.Invoice(invoiceId)
; -- Generated Statement 

ALTER TABLE inv.InvoiceLedgerItem ADD CONSTRAINT FK_inv_InvoiceLedgerItem_ledgerItemId FOREIGN KEY(ledgerItemId)  REFERENCES acc.LedgerItem(ledgerItemId)
; -- Generated Statement 

ALTER TABLE multi.Home ADD CONSTRAINT FK_multi_Home_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE multi.HomeLink ADD CONSTRAINT FK_multi_HomeLink_streetId FOREIGN KEY(streetId)  REFERENCES multi.Street(streetId)
; -- Generated Statement 

ALTER TABLE multi.HomeLink ADD CONSTRAINT FK_multi_HomeLink_homeId FOREIGN KEY(homeId)  REFERENCES multi.Home(homeId)
; -- Generated Statement 

ALTER TABLE multi.HomeLink ADD CONSTRAINT FK_multi_HomeLink_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE multi.HomeLink ADD CONSTRAINT FK_multi_HomeLink_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE multi.RoomLink ADD CONSTRAINT FK_multi_RoomLink_roomTypeId FOREIGN KEY(roomTypeId)  REFERENCES multi.EnuRoomType(roomTypeId)
; -- Generated Statement 

ALTER TABLE multi.RoomLink ADD CONSTRAINT FK_multi_RoomLink_homeId FOREIGN KEY(homeId)  REFERENCES multi.Home(homeId)
; -- Generated Statement 

ALTER TABLE multi.RoomLink ADD CONSTRAINT FK_multi_RoomLink_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE multi.RoomLink ADD CONSTRAINT FK_multi_RoomLink_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE payment.EnuPaymentType ADD CONSTRAINT FK_payment_EnuPaymentType_paymentTypeClassId FOREIGN KEY(paymentTypeClassId)  REFERENCES payment.EnuPaymentTypeClass(paymentTypeClassId)
; -- Generated Statement 

ALTER TABLE payment.Payment ADD CONSTRAINT FK_payment_Payment_paymentTypeId FOREIGN KEY(paymentTypeId)  REFERENCES payment.EnuPaymentType(paymentTypeId)
; -- Generated Statement 

ALTER TABLE payment.Payment ADD CONSTRAINT FK_payment_Payment_ledgerInfoId FOREIGN KEY(ledgerInfoId)  REFERENCES acc.LedgerInfo(ledgerInfoId)
; -- Generated Statement 

ALTER TABLE payment.PaymentMethod ADD CONSTRAINT FK_payment_PaymentMethod_paymentTypeId FOREIGN KEY(paymentTypeId)  REFERENCES payment.EnuPaymentType(paymentTypeId)
; -- Generated Statement 

ALTER TABLE tolling.CustomerPass ADD CONSTRAINT FK_tolling_CustomerPass_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE tolling.CustomerPass ADD CONSTRAINT FK_tolling_CustomerPass_passId FOREIGN KEY(passId)  REFERENCES tolling.Pass(passId)
; -- Generated Statement 

ALTER TABLE tolling.CustomerVehicle ADD CONSTRAINT FK_tolling_CustomerVehicle_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE tolling.CustomerVehicle ADD CONSTRAINT FK_tolling_CustomerVehicle_vehicleId FOREIGN KEY(vehicleId)  REFERENCES tolling.Vehicle(vehicleId)
; -- Generated Statement 

ALTER TABLE tolling.EnuLicensePlateJurisdiction ADD CONSTRAINT FK_tolling_EnuLicensePlateJurisdiction_stateOrProviceId FOREIGN KEY(stateOrProviceId)  REFERENCES crm.EnuStateProvince(stateProvinceId)
; -- Generated Statement 

ALTER TABLE tolling.EnuLicensePlateJurisdiction ADD CONSTRAINT FK_tolling_EnuLicensePlateJurisdiction_countryId FOREIGN KEY(countryId)  REFERENCES crm.EnuCountry(countryId)
; -- Generated Statement 

ALTER TABLE tolling.EnuVehicleClass ADD CONSTRAINT FK_tolling_EnuVehicleClass_vehicleClassTypeId FOREIGN KEY(vehicleClassTypeId)  REFERENCES tolling.EnuVehicleClassType(vehicleClassTypeId)
; -- Generated Statement 

ALTER TABLE tolling.LicensePlate ADD CONSTRAINT FK_tolling_LicensePlate_licencePlateJurisdictionId FOREIGN KEY(licencePlateJurisdictionId)  REFERENCES tolling.EnuLicensePlateJurisdiction(licensePlateJurisdictionId)
; -- Generated Statement 

ALTER TABLE tolling.LicensePlate ADD CONSTRAINT FK_tolling_LicensePlate_licensePlatetypeId FOREIGN KEY(licensePlatetypeId)  REFERENCES tolling.EnuLicensePlateType(licensePlateType)
; -- Generated Statement 

ALTER TABLE tolling.ProblematicPlate ADD CONSTRAINT FK_tolling_ProblematicPlate_licensePlateId FOREIGN KEY(licensePlateId)  REFERENCES tolling.LicensePlate(licensePlateId)
; -- Generated Statement 

ALTER TABLE tolling.ProblematicPlate ADD CONSTRAINT FK_tolling_ProblematicPlate_problematicPlateReasonId FOREIGN KEY(problematicPlateReasonId)  REFERENCES tolling.EnuProblematicPlateReason(problematicPlateReason)
; -- Generated Statement 

ALTER TABLE tolling.Promo ADD CONSTRAINT FK_tolling_Promo_customerId FOREIGN KEY(customerId)  REFERENCES crm.CustomerPk(customerId)
; -- Generated Statement 

ALTER TABLE tolling.Promo ADD CONSTRAINT FK_tolling_Promo_promoTypeId FOREIGN KEY(promoTypeId)  REFERENCES tolling.EnuPromoType(enuPromoTypeId)
; -- Generated Statement 

ALTER TABLE tolling.Trip ADD CONSTRAINT FK_tolling_Trip_ledgerInfoId FOREIGN KEY(ledgerInfoId)  REFERENCES acc.LedgerInfo(ledgerInfoId)
; -- Generated Statement 

ALTER TABLE tolling.Trip ADD CONSTRAINT FK_tolling_Trip_ledgerItemId FOREIGN KEY(ledgerItemId)  REFERENCES acc.LedgerItem(ledgerItemId)
; -- Generated Statement 

ALTER TABLE tolling.TripInfo ADD CONSTRAINT FK_tolling_TripInfo_tripId FOREIGN KEY(tripId)  REFERENCES tolling.Trip(tripId)
; -- Generated Statement 

ALTER TABLE tolling.TripInfo ADD CONSTRAINT FK_tolling_TripInfo_gantryId FOREIGN KEY(gantryId)  REFERENCES tolling.Gantry(gantryId)
; -- Generated Statement 

ALTER TABLE tolling.TripInfo ADD CONSTRAINT FK_tolling_TripInfo_licensePlateId FOREIGN KEY(licensePlateId)  REFERENCES tolling.LicensePlate(licensePlateId)
; -- Generated Statement 

ALTER TABLE tolling.TripInfo ADD CONSTRAINT FK_tolling_TripInfo_passId FOREIGN KEY(passId)  REFERENCES tolling.Pass(passId)
; -- Generated Statement 

ALTER TABLE tolling.TripInfo ADD CONSTRAINT FK_tolling_TripInfo_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE tolling.TripInfo ADD CONSTRAINT FK_tolling_TripInfo_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

ALTER TABLE tolling.VehicleInfo ADD CONSTRAINT FK_tolling_VehicleInfo_vehicleId FOREIGN KEY(vehicleId)  REFERENCES tolling.Vehicle(vehicleId)
; -- Generated Statement 

ALTER TABLE tolling.VehicleInfo ADD CONSTRAINT FK_tolling_VehicleInfo_licensePlateId FOREIGN KEY(licensePlateId)  REFERENCES tolling.LicensePlate(licensePlateId)
; -- Generated Statement 

ALTER TABLE tolling.VehicleInfo ADD CONSTRAINT FK_tolling_VehicleInfo_vehicleClassId FOREIGN KEY(vehicleClassId)  REFERENCES tolling.EnuVehicleClass(vehicleClassId)
; -- Generated Statement 

ALTER TABLE tolling.VehicleInfo ADD CONSTRAINT FK_tolling_VehicleInfo_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE tolling.VehicleInfo ADD CONSTRAINT FK_tolling_VehicleInfo_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
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

ALTER TABLE common.Template ADD CONSTRAINT FK_common_Template_enuTemplateTypeId FOREIGN KEY(enuTemplateTypeId)  REFERENCES common.EnuTemplateType(enuTemplateTypeId)
; -- Generated Statement 

ALTER TABLE common.Template ADD CONSTRAINT FK_common_Template_enuLocaleId FOREIGN KEY(enuLocaleId)  REFERENCES config.Enulocale(enuLocaleId)
; -- Generated Statement 

ALTER TABLE common.Template ADD CONSTRAINT FK_common_Template_inputUserId FOREIGN KEY(inputUserId)  REFERENCES audit.InputUser(inputUserId)
; -- Generated Statement 

ALTER TABLE common.Template ADD CONSTRAINT FK_common_Template_inputSourceId FOREIGN KEY(inputSourceId)  REFERENCES audit.InputSource(inputSourceId)
; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VAccountBalance.sql ---------------
create view acc.VAccountBalance as 
select a.customerId, sum(amount) as balance from acc.Ledger l  join acc.Annotation a on a.annotationId =l.annotationId group by a.customerId 

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VAccountBalance.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VCurrentLedger.sql ---------------
create view acc.VCurrentLedger as
select 
	l.revisionId
	,l.ledgerItemId 
	,l.ledgerInfoId 
	,l.transactionTypeId 
	,l.ledgerTypeId 
	,l.annotationId 
	,l.amount 
	,l.balance 
from 
	acc.Ledger l
where
	l.ledgerTypeId in (1,2)
	and l.revisionId not in (select revisionId from acc.Cancellation c )

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VCurrentLedger.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VTransactionHistory.sql ---------------
create view acc.VTransactionHistory as
select
	ann.postingDate 
	,l.ledgerItemId
	,l.transactionTypeId
	,l.amount
	,l.balance
	,t.tripId
	,p.paymentId 
	,ann.customerId 
from 
	acc.Ledger l 
	join acc.Annotation ann on ann.annotationId =l.annotationId 
	left join tolling.Trip t on t.ledgerItemId=l.ledgerItemId
	left join payment.Payment p on p.ledgerInfoId=l.ledgerInfoId

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VTransactionHistory.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VTripPayment.sql ---------------
create view acc.VTripPayment as 
select
	t.tripId
	,p.paymentId
	,p.amount paymentAmount
	,a.amount allocatedAmount
	,p.postingDate 
from 
	acc.Allocation a
	join acc.VCurrentLedger l on a.creditRevisionId =l.revisionId
	join payment.Payment p on p.ledgerInfoId =l.ledgerInfoId 
	join acc.VCurrentLedger lTrip on lTrip.revisionId=a.debitRevisionId 
	join tolling.Trip t on t.ledgerItemId =lTrip.ledgerItemId

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VTripPayment.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VUnallocatedCredit.sql ---------------
create view acc.VUnallocatedCredit as 
select
	revisionId
	,fullAmount-allocated as unAllocated
	,fullAmount
	,ledgerItemId
	,customerId
from (
	select 
		l.revisionId
		,coalesce((select sum(abs(amount)) from acc.allocation where creditRevisionId =l.revisionId and endAnnotationId is null),0) as allocated
		,amount as fullAmount
		,l.ledgerItemId
		,ann.customerId 
	from 
		acc.ledger l 
		join acc.Annotation ann on l.annotationId =ann.annotationId 
	where 
		l.ledgerTypeId in (2,6)
		and not exists (select 1 from acc.Cancellation where cancelledRevisionId =l.revisionId) 
	) X where fullAmount>allocated
--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VUnallocatedCredit.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VUnpaidDebit.sql ---------------
create view acc.VUnpaidDebit as 
select
	revisionId
	,fullAmount-allocated as unAllocated
	,fullAmount
	,allocated
	,ledgerItemId
	,customerId
from (
	select 
		l.revisionId
		,coalesce((select sum(abs(amount)) from acc.allocation where debitRevisionId =l.revisionId and endAnnotationId is null),0) as allocated
		,amount as fullAmount
		,l.ledgerItemId
		,ann.customerId 
	from 
		acc.ledger l 
		join acc.Annotation ann on l.annotationId =ann.annotationId 
	where 
		l.ledgerTypeId in (1,5)
		and not exists (select 1 from acc.Cancellation where cancelledRevisionId =l.revisionId) 
	) X where -fullAmount>allocated

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/acc/view/VUnpaidDebit.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VCustomerHistory.sql ---------------
create view crm.VCustomerHistory as
select 
	thisRecord.startDate
	,'Phone Number' as objectType
	, case 
		when prevRecord.revisionId  is null then 'Created'
		when nextRecord.revisionId is null  and thisRecord.endDate<CURRENT_TIMESTAMP then 'Deleted'
		else 'Modified'
	 end as action
	,thisRecord.inputUserId 
	,thisRecord.phoneNumberId as id
	,thisRecord.revisionId
	,prevRecord.revisionId as prevRevisionId
	,'HPHONENUMBER' mtTable
	,c.customerId 
FROM 
	crm.HPhoneNumber thisRecord
	join crm.HPersonOrCompany p on p.phoneNumberId =thisRecord.phoneNumberId 
	join crm.HCustomer c on c.mainContactPersonOrCompanyId =p.personOrCompanyId 
	left join crm.HPhoneNumber prevRecord on prevRecord.endDate =thisRecord.startDate 
	left join crm.HPhoneNumber  nextRecord on nextRecord.startDate=thisRecord.endDate

union

select 
	thisRecord.startDate
	,'Email Address' as objectType
	, case 
		when prevRecord.revisionId  is null then 'Created'
		when nextRecord.revisionId is null  and thisRecord.endDate<CURRENT_TIMESTAMP then 'Deleted'
		else 'Modified'
	 end as Action
	,thisRecord.inputUserId 
	,thisRecord.emailAddressId as id
	,thisRecord.revisionId
	,prevRecord.revisionId as prevRevisionId
	,'HEMAILADDRESS' mtTable
	,c.customerId 
FROM 
	crm.HEmailAddress thisRecord
	join crm.HPersonOrCompany p on p.emailAddressId =thisRecord.emailAddressId 
	join crm.HCustomer c on c.mainContactPersonOrCompanyId =p.personOrCompanyId 
	left join crm.HEmailAddress prevRecord on prevRecord.endDate =thisRecord.startDate 
	left join crm.HEmailAddress  nextRecord on nextRecord.startDate=thisRecord.endDate 
	
union

select 
	thisRecord.startDate
	,'Postal Address' as objectType
	, case 
		when prevRecord.revisionId  is null then 'Created'
		when nextRecord.revisionId is null  and thisRecord.endDate<CURRENT_TIMESTAMP then 'Deleted'
		else 'Modified'
	 end as Action
	,thisRecord.inputUserId 
	,thisRecord.postalAddressId as id
	,thisRecord.revisionId
	,prevRecord.revisionId as prevRevisionId
	,'HPostalAddress' mtTable
	,c.customerId 
FROM 
	crm.HPostalAddress thisRecord
	join crm.HCustomer c on c.mailingPostalAddressId =thisRecord.postalAddressId 
	left join crm.HPostalAddress prevRecord on prevRecord.endDate =thisRecord.startDate 
	left join crm.HPostalAddress  nextRecord on nextRecord.startDate=thisRecord.endDate 

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VCustomerHistory.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VCustomerSearch.sql ---------------
create view crm.VCustomerSearch as
select 
	c.customerId
	,c.customerTypeId
	,coalesce(p.firstName || ' ','') || p.lastNameOrCompanyName as fullName
	,a.address1 || ' ' || coalesce(' ' || a.address2,'') || ' ' || a.city as mailingAddress
	,p.firstName
	,p.lastNameOrCompanyName
	,pn.number 
	,e.address
	,(
		select location 
		from common.StorageFile sf 
		join common.FileGroup fg on fg.fileGroupId=sf.fileGroupId
		join inv.InvoiceDocument id on id.filegroupid=fg.fileGroupId
		join inv.Invoice i on i.invoiceId=id.invoiceId and i.customerId=c.customerId
		order by i.created desc limit 1
	) lastInvoice
	,(
		select invoiceid from inv.invoice i
		where  i.customerId=c.customerId
		order by i.created desc limit 1
	) lastInvoiceId
from 
	crm.HCustomer c 
	join crm.HPersonOrCompany  p on p.personOrCompanyId=c.mainContactPersonOrCompanyId and current_timestamp >=p.startDate and p.endDate>current_timestamp and current_timestamp>=c.startDate and c.endDate>current_timestamp 
	left join crm.HPostalAddress a on a.postalAddressId=c.mailingPostalAddressId and current_timestamp>=a.startDate and a.endDate>current_timestamp
	left join crm.HPhoneNumber pn on pn.phoneNumberId = p.phoneNumberId 
	left join crm.HEmailAddress e on e.emailAddressId =p.emailAddressId 
	
	 

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VCustomerSearch.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VCustomerSearchEditor.sql ---------------
create view crm.VCustomerSearchEditor as
select 
	c.customerId
	,c.customerTypeId
	,coalesce(p.firstName || ' ','') || p.lastNameOrCompanyName as fullName
	,a.address1 || ' ' || coalesce(' ' || a.address2,'') || ' ' || a.city as mailingAddress
	,pn.number  as phonenumer
	,e.address as email
from 
	crm.HCustomer c 
	join crm.HPersonOrCompany  p on p.personOrCompanyId=c.mainContactPersonOrCompanyId and current_timestamp>=p.startDate and p.endDate>current_timestamp and current_timestamp>=c.startDate and c.endDate>current_timestamp 
	left join crm.HPostalAddress a on a.postalAddressId=c.mailingPostalAddressId and current_timestamp>=a.startDate and a.endDate>current_timestamp
	left join crm.HPhoneNumber pn on pn.phoneNumberId = p.phoneNumberId 
	left join crm.HEmailAddress e on e.emailAddressId =p.emailAddressId 

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VCustomerSearchEditor.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VDetailPageCaseList.sql ---------------
create view crm.VDetailPageCaseList as 
SELECT 
	c.csCaseId
	,c.subject
	,c.caseTypeId
	,c.caseStatusId
	,c.casePriorityId
	,c.manualReviewRequired
	,cu.customerId 
from 
	cs.cscase c
	join cs.CustomerCase cc on cc.csCaseId=c.csCaseId 
	join crm.HCustomer  cu on cc.customerId=cc.customerId
	
	
--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VDetailPageCaseList.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VDetailPageVehicleList.sql ---------------
create view crm.VDetailPageVehicleList as
select 
	v.vehicleId
	,lp.lpNumber
	,lp.licencePlateJurisdictionId 
	,licensePlateTypeId
	,v.vehicleClassId 
	,cv.customerId
from 
	tolling.licensePlate lp
	join tolling.VehicleInfo  v on v.licensePlateId =lp.licensePlateId 
	join tolling.CustomerVehicle cv on cv.vehicleId=v.vehicleId
--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/crm/view/VDetailPageVehicleList.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/cs/view/VCaseSearch.sql ---------------
create view cs.VCaseSearch as
select 
	c.csCaseId
	,c.subject
	,c.caseTypeId
	,c.caseStatusId
	,c.casePriorityId
	,c.startDate
	,c.inputUserId
	,c.manualReviewRequired
	,c.documentation
	,'' customers
from 
	cs.CSCase c 
where c.startDate<=getPostingDate() and c.endDate>getPostingDate()
	

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/cs/view/VCaseSearch.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/inv/view/VInvoiceableAccount.sql ---------------
create view inv.VInvoiceableAccount as
select 
	customerId
	,balance
from 
	acc.vaccountBalance ab 
	where 
		balance<0
		and not exists (select invoiceId from inv.Invoice where customerId =ab.customerId and created >dateadd(MONTH,-1,getPostingDate()))

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/inv/view/VInvoiceableAccount.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/inv/view/VdetailPageInvoiceList.sql ---------------
create view inv.VdetailPageInvoiceList as
select 
i.invoiceid
, i.created
, id.amountDue
, i.customerId
, fg.location
from inv.Invoice i 
JOIN inv.InvoiceDocument id on id.invoiceId=i.invoiceId
left join common.storageFile fg on fg.filegroupid=id.fileGroupId 

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/inv/view/VdetailPageInvoiceList.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/inv/view/VInvoiceHeader.sql ---------------
create view inv.VinvoiceHeader as 
select 
coalesce(p.firstName || ' ', '') || p.lastNameOrCompanyName as recipientName
,a.address1
,a.address2
,a.city
,a.postalCode
,esp.shortCode state
,i.created noticeDate
,i.created dueDate
,i.customerId 
,i.invoiceId 
,lp.lpnumber
,id.amountDue totalDue
from inv.Invoice i 
JOIN inv.InvoiceDocument id on id.invoiceId=i.invoiceId
--left join common.storageFile fg on fg.filegroupid=id.fileGroupId 
left join crm.HCustomer c on i.customerId=c.customerId
	left join crm.HPersonOrCompany  p on p.personOrCompanyId=c.mainContactPersonOrCompanyId and current_timestamp>=p.startDate and p.endDate>current_timestamp and current_timestamp>=c.startDate and c.endDate>current_timestamp 
	left join crm.HPostalAddress a on a.postalAddressId=c.mailingPostalAddressId and current_timestamp>=a.startDate and a.endDate>current_timestamp
	left join crm.HPhoneNumber pn on pn.phoneNumberId = p.phoneNumberId 
	left join crm.HEmailAddress e on e.emailAddressId =p.emailAddressId 
	left join crm.EnuStateProvince esp on esp.stateProvinceId=a.stateProvinceId
	left join tolling.CustomerVehicle cv on cv.customerId=i.customerId
	left join tolling.VehicleInfo vi on cv.vehicleId=vi.vehicleId
	left join tolling.LicensePlate lp on vi.licensePlateId =lp.licensePlateId

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/inv/view/VInvoiceHeader.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/inv/view/VitemInvoicedetail.sql ---------------
create view inv.VitemInvoiceDetail as
select 
	laneExitDate
	,t.tripId
	,ti.passId
	,lp.lpnumber 
	,ti.fareAmount 
	,cv.customerId
	,iit.invoiceId
from 
	inv.InvoiceLedgerItem iit
	join tolling.Trip t on iit.ledgerItemId=t.ledgerItemId
	join tolling.TripInfo ti on ti.tripid=t.tripid
	join tolling.LicensePlate lp on lp.licensePlateId =ti.licensePlateId 
	left join tolling.VehicleInfo vi on vi.licensePlateId=ti.licensePlateId 
	left join tolling.CustomerVehicle cv on cv.vehicleId=vi.vehicleId

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/inv/view/VitemInvoicedetail.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/VHomeLink.sql ---------------
create view multi.VHomeLink as
select 
rl.*,
h.name
from 
multi.homeLink rl
join multi.home h on rl.homeId=h.homeId
--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/VHomeLink.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/VStreet.sql ---------------
--//POSGRESSQL
--create view multi.VStreet as
--select 
--s.*
--,(select json_agg(row_to_json(rl)) from multi.VhomeLink rl where rl.streetId=s.streetId) as homes
--from 
--multi.street s

--//SQLSERVER
--create view multi.VStreet as
--select 
--s.* ,
--(select * from multi.VhomeLink rl where rl.streetId=s.streetId for json  Path
--) as homes
--from 
--multi.street s

--//H2
create view multi.VStreet as
select 
s.* ,
--(select * from multi.VhomeLink rl where rl.streetId=s.streetId for json  Path) 
'' as homes
from 
multi.street s

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/VStreet.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/VroomLink.sql ---------------
create view multi.VroomLink as
select 
rl.*,
enu.shortCode,
enu.description
from 
multi.roomLink rl
join multi.enuRoomType enu on rl.roomTypeId=enu.roomTypeId
--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/VroomLink.sql

; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/Vhome.sql ---------------

--//POSGRESSQL
--create view multi.Vhome as
--select 
--h.* ,
--(select json_agg(row_to_json(rl)) from multi.VroomLink rl where rl.homeId=h.homeId) as rooms
--from 
--multi.home h


--//SQLSERVER
--create view multi.Vhome as
--select 
--h.* ,
--(select * from multi.VroomLink rl where rl.homeId=h.homeId for json  Path) as rooms
--from 
--multi.home h

--//H2
create view multi.Vhome as
select 
h.* ,
--(select json_agg(row_to_json(rl)) from multi.VroomLink rl where rl.homeId=h.homeId) 
'' as rooms
from 
multi.home h

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/Vhome.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/VHome2.sql ---------------



--//POSGRESSQL
--create view multi.Vhome2 as
--select 
--h.* ,
--(select json_agg(row_to_json(rl)) from multi.roomLink rl where rl.homeId=h.homeId) as  room2s
--from 
--multi.home h


--//SQLSERVER
--create view multi.Vhome as
--select 
--h.* ,
--(select * from multi.roomLink rl where rl.homeId=h.homeId for json  Path) as  room2s
--from 
--multi.home h

--//H2
create view multi.Vhome2 as
select 
h.* ,
--(select json_agg(row_to_json(rl)) from multi.roomLink rl where rl.homeId=h.homeId) 
'' as  room2s
from 
multi.home h


--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/multi/view/VHome2.sql

; -- Generated Statement 


; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/payment/view/VPaymentMethods.sql ---------------
create view payment.VPaymentMethods as 
select 
	pm.paymentMethodId
	,pt.paymentTypeClassId
	,pm.paymentTypeId 
	,case 
		when ptc.shortCode='CREDITCARD' then pm.ccNumber 
		when ptc.shortCode='DIRECTDEBIT' then pm.accountNumber 
		when ptc.shortCode='CHECK' then pm.checkNumber 
		else null
	end as number
	,cpm.customerId 
from 
	payment.PaymentMethod pm 
	join payment.EnuPaymentType pt on pt.paymentTypeId =pm.paymentTypeId 
	join payment.enuPaymentTypeClass ptc on pt.paymentTypeClassId=ptc.paymentTypeClassId
	join crm.customerPaymentMethod cpm on cpm.paymentMethodId=pm.paymentMethodId
--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/payment/view/VPaymentMethods.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/tolling/view/VFindVehicle.sql ---------------
create view tolling.VFindVehicle as 
select 
	vi.vehicleId
	,j.shortCode
	,lp.lpnumber
	,vi.make 
	,vi.model 
	,vi.modelYear 
	,vi.color 
	,vi.axles 
	,vi.vehicleClassId 
	,cv.customerId
	,lp.licensePlateId
	
from 
	tolling.VehicleInfo vi
	join tolling.LicensePlate lp on vi.licensePlateId =lp.licensePlateId
	join tolling.EnuLicensePlateJurisdiction j on j.licensePlateJurisdictionId =lp.licencePlateJurisdictionId 
	join tolling.CustomerVehicle cv on cv.vehicleId=vi.vehicleId 

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/tolling/view/VFindVehicle.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/tolling/view/VProblematicPlate.sql ---------------
create view tolling.VProblematicPlate as 
select 
	pp.problematicPlateId
	,lp.licencePlateJurisdictionId
	,lp.lpnumber
	,cv.customerId
	,pp.problematicPlateReasonId
	,pp.notes
from 
	tolling.ProblematicPlate pp 
	join tolling.LicensePlate  lp on pp.licensePlateId=lp.licensePlateId
	join tolling.VehicleInfo vi on vi.licensePlateId=lp.licensePlateId
	join tolling.customerVehicle cv on vi.vehicleId=cv.vehicleId
	
	

--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/tolling/view/VProblematicPlate.sql

; -- Generated Statement 


; -- Generated Statement 

--- Start Dependency file: /poyake-roadrunner/src/main/resources/metadata/tolling/view/VTripSearch.sql ---------------
create view tolling.VTripSearch as 
select 
	tripId 
	,fareAmount 
	,laneEntryDate 
	,laneExitDate
	,lp.licencePlateJurisdictionId 
	,lp.lpnumber 
	,lp.licensePlatetypeId 
	,passId
from 
	tolling.TripInfo ti 
	join tolling.LicensePlate lp on lp.licensePlateId =ti.licensePlateId 
--- End of Dependency file: /poyake-roadrunner/src/main/resources/metadata/tolling/view/VTripSearch.sql

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

