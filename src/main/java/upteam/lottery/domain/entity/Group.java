package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_group")
public class Group implements Serializable {

    private static final long serialVersionUID = -6183115376203466717L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    @Column(name = "group_name")
    @NotNull
    private String groupName;

    @Column(name = "group_captain")
    private Integer groupCaptain;

    @Column(name = "group_ratio")
    private Double groupRatio;

    private List<User> numbers;

    public Group() {
    }

    public Group(@NotNull String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupCaptain() {
        return groupCaptain;
    }

    public void setGroupCaptain(Integer groupCaptain) {
        this.groupCaptain = groupCaptain;
    }

    public List<User> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<User> numbers) {
        this.numbers = numbers;
    }

    public Double getGroupRatio() {
        return groupRatio;
    }

    public void setGroupRatio(Double groupRatio) {
        this.groupRatio = groupRatio;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
