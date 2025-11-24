package com.etantolling.testrunner.testserver.rs.controller;

import org.springframework.http.HttpStatus;

public enum TollApiError {
	// @formatter:off
	/* Generic Errors */
	UNKNOWN_ERROR(0, "An unknown error has occurred."),  
	NOT_FOUND(1, HttpStatus.NOT_FOUND, "Resource not found"),  
	ENUMERATION_CANNOT_SET_DEFAULT_FALSE(2, "Enumeration cannot set default value to be false."),
	FILE_NOT_FOUND(3, "An error has occured due to file not found."),
	VALIDATION_ERROR(4, HttpStatus.BAD_REQUEST, "Validation error."),
	NULL_POINTER_EXCEPTION(5, "Null pointer exception."),
	RULE_NOT_FOUND(6, HttpStatus.NOT_FOUND, "Rule was not found."),
	PRE_COND_FAILED(7, "Pre Condition Failed"),
	POST_COND_FAILED(8, "Post Condition Failed"),
	NOT_IMPLEMENTED(9, "Not implemented."),
	NOT_UNIQUE(10, "Not unique."),
	IO_ERROR(11, "IO Error"),
	PARSING_ERROR(12, "Parsing Error"),
	
	/* Database Errors */
	DB_BAD_SQL(100, "A database error has occured due to bad sql."), 
	DB_BAD_METADATA(101, "A database error has occured due to bad metadata."),
	DB_WRONG_DATA(102, "Wrong Data in Db"),
	DB_ERROR(103, "Data conflict occurred while processing the request"),

	/* TOLL-REPORT Errors */
	REPORT_IO_ERROR(200, "I/O Error."), 
	REPORT_DATASOURCE_NOT_FOUND_ERROR(201, "Datasource not found for file extension."), 
	REPORT_INVALID_CONFIGURATION_ERROR(202, "Report Server is configured improperly."),
	REPORT_EXECUTION_ERROR(203, "Report Subscription could not be executed."),

	/* TOLL-SECURITY Errors */
	SECURITY_USER_DISABLED(300, HttpStatus.UNAUTHORIZED, "User disabled"), 
	SECURITY_INVALID_EFFECTIVE_START_DATE(301, "Invalid Effective Start Date"),
	SECURITY_UNAUTHORIZED(302, HttpStatus.UNAUTHORIZED, "Wrong username or password."),
	SECURITY_FORBIDDEN(303, HttpStatus.FORBIDDEN, "Access denied."),
	SECURITY_LDAP_EXCEPTION(304, HttpStatus.BAD_REQUEST, "LDAP exception."),
	SECURITY_FORBIDDEN_LOCATION(305, HttpStatus.FORBIDDEN, "Login to location forbidden"),
	/* Payment gateway errors */
	PGW_CC_NUMBER_NOT_VALID(400, "Credit card number is not valid."),
	PGW_ACH_NUMBER_NOT_VALID(401, "ACH number is not valid."),
	PGW_INCOMPLETE_RESPONSE(402, "The payment response data is incomplete."),
	PGW_ERROR(403, "An error has occurred in the payment gateway."),
	PGW_HTTP_ERROR(404, "An error was returned by the payment gateway."),

	/* Inventory tag */
	TAG_REQUEST_ALREADY_ASSIGNED(500, "The Tag Request is already assigned."),
	TAG_REQUEST_UNDER_PROCESSING(501, "The Tag Request is is under processing."),
	
	/* PrintHouse Errors */
	PRINTHOUSE_IO_ERROR(600, "I/O Error."),
	PRINTHOUSE_INVALID_CONFIGURATION_ERROR(601, "Print House is misconfigured."),
	
	JOB_ERROR(700, "Job error."),
	
	/*Roadside Transaction Processing Errors*/
	GENERAL_TRX_ERROR(701, "General Error. "),
	TOO_OLD_TRX_ERROR(702, "Trip Expired. "),
	DUPLICATE_TRX_ERROR(703, "Duplicate transaction previously received with responseCode "),
	INVALID_DATA_ERROR(704, "Invalid data in field "),
	UNKNOWN_PLAZA_ERROR(705, "Unknown plaza "),
	UNKNOWN_LANE_ERROR(706, "Unknown lane. "),
	MISSING_FIELD_ERROR(707, "Missing required field, "),
	XML_FORMAT_ERROR(708, "XML format error. "),
	ACK_INVALID_CODE(709, "Invalid Ack Request Code. "),
	ACK_INVALID_INTERFACE(710, "Invalid Ack Interface Name. "),
	ACK_INVALID_FACILITY(711, "Invalid Ack FacilityCode. "),
	ACK_INVALID_REQUEST(712, "Invalid Ack Request. "),
	
	/* Lockbox */
	LOCKBOX_IO_ERROR(800, "I/O Error."),
	LOCKBOX_INVALID_CONFIGURATION_ERROR(801, "Lockbox is misconfigured."),
	LOCKBOX_FILE_MISSING_ERROR(802, "Lockbox file is missing."),
	LOCKBOX_FILE_INVALID_ERROR(803, "Lockbox invalid file error."),
	
	/* Custom Fields */
	CUSTOM_FIELDS_LIMIT_EXCEEDED_ERROR(900, "Custom field limit has already reached");

	// @formatter:on

	private TollApiError(int code, HttpStatus httpStatus, String codeDescription) {
		this.code = code;
		this.httpStatus = httpStatus;
		this.codeDescription = codeDescription;
	}

	private final int code;
	private final HttpStatus httpStatus;
	private final String codeDescription;

	private TollApiError(int code, String codeDescription) {
		this.code = code;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.codeDescription = codeDescription;
	}

	@Override
	public String toString() {
		return "Name = " + this.name() + "; Code = " + code + "; HttpStatus = " + httpStatus + "; CodeDescription = " + codeDescription;
	}

	public int getCode() {
		return code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getCodeDescription() {
		return codeDescription;
	}
}