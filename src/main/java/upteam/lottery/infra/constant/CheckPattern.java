package upteam.lottery.infra.constant;

/**
 * @author 周廷宇
 *
 * <p>regex string</p>
 */
public class CheckPattern {
    /**
     * <p>phone</p>
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$";
    /**
     * <p>email</p>
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    /**
     * <p>number or english</p>
     */
    public static final String REGEX_USERNAME = "^[A-Za-z0-9]+$";
}
