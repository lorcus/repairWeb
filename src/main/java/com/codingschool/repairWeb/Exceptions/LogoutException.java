package com.codingschool.repairWeb.Exceptions;

import org.springframework.security.core.AuthenticationException;

public class LogoutException extends AuthenticationException {

    public LogoutException(String msg, Throwable t) {
        super(msg, t);
    }

    public LogoutException(String msg) {
        super(msg);
    }

}
