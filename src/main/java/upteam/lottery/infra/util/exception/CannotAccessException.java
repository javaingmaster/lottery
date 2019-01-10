package upteam.lottery.infra.util.exception;

/**
 * @author 周廷宇
 */
public class CannotAccessException extends RuntimeException {
    public CannotAccessException() {
    }

    public CannotAccessException(String message) {
        super(message);
    }

    public CannotAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotAccessException(Throwable cause) {
        super(cause);
    }

    public CannotAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
