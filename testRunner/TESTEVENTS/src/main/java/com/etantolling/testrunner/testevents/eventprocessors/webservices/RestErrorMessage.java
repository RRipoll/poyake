package com.etantolling.testrunner.testevents.eventprocessors.webservices;

public class RestErrorMessage {

    private String status;
    private int code;
    private String message;
    private String detailedMessage;
    private String exceptionMessage;

    public RestErrorMessage(String status, int code, String message, String detailedMessage, String exceptionMessage) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.detailedMessage = detailedMessage;
        this.exceptionMessage = exceptionMessage;
    }

    public RestErrorMessage() {
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public String toString() {
		return "RestErrorMessage [status=" + status + ", code=" + code + ", message=" + message + ", detailedMessage=" + detailedMessage + ", exceptionMessage="
				+ exceptionMessage + "]";
	}
}
