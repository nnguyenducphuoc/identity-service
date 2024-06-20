package com.phuoc.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User already existed"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),;

    private int code;
    private String message;

    ErrorCode (int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
