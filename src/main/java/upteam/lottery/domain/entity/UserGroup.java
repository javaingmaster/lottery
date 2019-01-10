package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author 周廷宇
 */
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userGroupId;

    @Column(name = "user_id")
    @NotNull
    private Integer userId;

    @Column(name = "group_id")
    @NotNull
    private Integer groupId;

    public UserGroup() {
    }

    public UserGroup(@NotNull Integer userId, @NotNull Integer groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "UserGroupMapper{" +
                "userGroupId=" + userGroupId +
                ", userId=" + userId +
                ", groupId=" + groupId +
                '}';
    }
}
