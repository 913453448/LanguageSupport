package com.yasin.library.exception;

/**
 * Created by leo on 17/4/7.
 */

public class LanguageException extends Exception {
    public LanguageException(String message) {
        super(message);
    }

    public LanguageException(String message, Throwable cause) {
        super(message, cause);
    }

    public LanguageException(Throwable cause) {
        super(cause);
    }
}
