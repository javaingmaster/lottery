package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author 周廷宇
 */
@Table(name = "rule_object")
public class RuleObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ruleObjectId;

    @Column(name = "rule_id")
    @NotNull
    private Integer ruleId;

    @Column(name = "lottery_object_id")
    private Integer lotteryObjectId;

    @Column(name = "object_ratio")
    private Double objectRatio;

    public RuleObject() {
    }

    public RuleObject(@NotNull Integer ruleId, Integer lotteryObjectId, Double objectRatio) {
        this.ruleId = ruleId;
        this.lotteryObjectId = lotteryObjectId;
        this.objectRatio = objectRatio;
    }

    public Integer getRuleObjectId() {
        return ruleObjectId;
    }

    public void setRuleObjectId(Integer ruleObjectId) {
        this.ruleObjectId = ruleObjectId;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getLotteryObjectId() {
        return lotteryObjectId;
    }

    public void setLotteryObjectId(Integer lotteryObjectId) {
        this.lotteryObjectId = lotteryObjectId;
    }

    public Double getObjectRatio() {
        return objectRatio;
    }

    public void setObjectRatio(Double objectRatio) {
        this.objectRatio = objectRatio;
    }

    @Override
    public String toString() {
        return "RuleObject{" +
                "ruleObjectId=" + ruleObjectId +
                ", ruleId=" + ruleId +
                ", lotteryObjectId=" + lotteryObjectId +
                ", objectRatio=" + objectRatio +
                '}';
    }
}
