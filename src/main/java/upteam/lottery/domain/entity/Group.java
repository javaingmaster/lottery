package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    @Column(name = "group_name")
    @NotNull
    private String groupName;

    @Column(name = "group_captain")
    private Integer groupCaptain;

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

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
