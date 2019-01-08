package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_rule")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rule_id;

    @Column(name = "lottery_object")
    @NotNull
    private Integer lotteryObject;

    @Column(name = "if_back")
    @NotNull
    private Integer ifBack;

    private List<Prize> prizes;
    private List<Group> groups;
    private List<User> users;

    public Rule() {
    }

    public Rule(@NotNull Integer lotteryObject, @NotNull Integer ifBack) {
        this.lotteryObject = lotteryObject;
        this.ifBack = ifBack;
    }

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public Integer getLotteryObject() {
        return lotteryObject;
    }

    public void setLotteryObject(Integer lotteryObject) {
        this.lotteryObject = lotteryObject;
    }

    public Integer getIfBack() {
        return ifBack;
    }

    public void setIfBack(Integer ifBack) {
        this.ifBack = ifBack;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "rule_id=" + rule_id +
                ", lotteryObject=" + lotteryObject +
                ", ifBack=" + ifBack +
                '}';
    }
}
