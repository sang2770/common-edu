package com.sang.commonmodel.error;

public enum AuthorizationError implements ResponseError {

    ACCESS_DENIED(40300001, "Access Denied"),
    NOT_SUPPORTED_AUTHENTICATION(40300002, "Your authentication has not been supported yet"),
    ;

    private final Integer code;
    private final String message;

    AuthorizationError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getStatus() {
        return 403;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
