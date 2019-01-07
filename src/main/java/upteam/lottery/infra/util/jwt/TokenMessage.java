package upteam.lottery.infra.util.jwt;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zty
 * <p>token information</p>
 */
public class TokenMessage implements Serializable {
    private Date expiresDate;
    private Integer userId;
    private String userName;
    private Integer userAuthority;

    public TokenMessage() {
    }

    public Date getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Date expiresDate) {
        this.expiresDate = expiresDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(Integer userAuthority) {
        this.userAuthority = userAuthority;
    }

    @Override
    public String toString() {
        return "TokenMessage{" +
                "expiresDate=" + expiresDate +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAuthority=" + userAuthority +
                '}';
    }
}
