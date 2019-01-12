package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_user")
public class User extends BaseEntity {
    private static final long serialVersionUID = 2684642429918408713L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name")
    @NotNull
    private String userName;

    @Column(name = "user_password")
    @NotNull
    private String userPassword;

    @Column(name = "user_role")
    @NotNull
    private Integer userRole;

    @Column(name = "user_token")
    private String userToken;

    @Column(name = "user_gender")
    private Integer userGender;

    @Column(name = "user_ratio")
    private Double userRatio;

    public User() {
    }

    public User(String name) {
        this.userName = name;
    }

    public User(Integer UserRole) {
        this.userRole = userRole;
    }

    public User(@NotNull String userName, @NotNull String userPassword, @NotNull Integer userRole) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Double getUserRatio() {
        return userRatio;
    }

    public void setUserRatio(Double userRatio) {
        this.userRatio = userRatio;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRole=" + userRole;
    }
}
