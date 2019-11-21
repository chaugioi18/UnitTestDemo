package vn.mila.example.base;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 10:52 AM
 */
public class CommonException {

    public static class InvalidConfig extends BaseException {
        public InvalidConfig(String msg) {
            super(msg);
        }

        public InvalidConfig(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class NotFound extends BaseException {
        public NotFound(String msg) {
            super(msg);
        }

        public NotFound(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

}
