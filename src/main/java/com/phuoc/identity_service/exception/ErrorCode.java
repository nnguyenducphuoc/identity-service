package com.phuoc.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1002, "User already existed"),
    USER_NOT_EXISTED(1005, "User is not existed"),
    INVALID_KEY(1001, "Invalid message key"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
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
