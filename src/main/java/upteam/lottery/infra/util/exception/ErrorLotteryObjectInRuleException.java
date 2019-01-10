package upteam.lottery.infra.util.exception;

/**
 * @author 周廷宇
 * the lottery object in rule is not 0 or 1
 */
public class ErrorLotteryObjectInRuleException extends RuntimeException {
    public ErrorLotteryObjectInRuleException() {
    }

    public ErrorLotteryObjectInRuleException(String message) {
        super(message);
    }

    public ErrorLotteryObjectInRuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorLotteryObjectInRuleException(Throwable cause) {
        super(cause);
    }

    public ErrorLotteryObjectInRuleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
