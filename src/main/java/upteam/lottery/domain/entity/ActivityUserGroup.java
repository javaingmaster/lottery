package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author 周廷宇
 */
@Table(name = "activity_user_group")
public class ActivityUserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer augId;

    @Column(name = "activity_id")
    @NotNull
    private Integer activityId;

    @Column(name = "user_id")
    @NotNull
    private Integer userId;

    @Column(name = "group_id")
    @NotNull
    private Integer groupId;

    public ActivityUserGroup() {
    }

    public ActivityUserGroup(@NotNull Integer activityId, @NotNull Integer userId, @NotNull Integer groupId) {
        this.activityId = activityId;
        this.userId = userId;
        this.groupId = groupId;
    }

    public Integer getAugId() {
        return augId;
    }

    public void setAugId(Integer augId) {
        this.augId = augId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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
        return "ActivityUserGroup{" +
                "augId=" + augId +
                ", activityId=" + activityId +
                ", userId=" + userId +
                ", groupId=" + groupId +
                '}';
    }
}
