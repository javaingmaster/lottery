package upteam.lottery.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;;
import java.util.Date;
import java.util.List;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_activity")
public class Activity implements Serializable {
    private static final long serialVersionUID = -242981554568339060L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;

    @Column(name = "activity_name")
    @NotNull
    private String activityName;

    @Column(name = "activity_description")
    private String activityDescription;

    @Column(name = "activity_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityTime;

    @Column(name = "activity_rule")
    private Integer activityRule;

    public Activity() {
    }

    public Activity(@NotNull String activityName, Integer activityRule) {
        this.activityName = activityName;
        this.activityRule = activityRule;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Integer getActivityRule() {
        return activityRule;
    }

    public void setActivityRule(Integer activityRule) {
        this.activityRule = activityRule;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityName='" + activityName + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                ", activityTime=" + activityTime +
                '}';
    }
}
