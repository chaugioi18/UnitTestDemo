package vn.mila.example.base;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 10:52 AM
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -128216908108589678L;

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
