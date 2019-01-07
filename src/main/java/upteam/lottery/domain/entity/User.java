package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_user")
public class User extends BaseEntity{

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

    @NotNull
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "user_gender")
    private Integer userGender;

    public User(){}

    public User(@NotNull String userName, @NotNull String userPassword, @NotNull Integer userRole, @NotNull Integer groupId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.groupId = groupId;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRole=" + userRole +
                ", groupId=" + groupId +
                '}';
    }
}
