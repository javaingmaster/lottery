package upteam.lottery.infra.util.exception;

/**
 * @author zty
 *
 * <p>double same user</p>
 */
public class SerUserAlreadyExistException extends RuntimeException {
    public SerUserAlreadyExistException() {
    }

    public SerUserAlreadyExistException(String message) {
        super(message);
    }

    public SerUserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerUserAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public SerUserAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
