package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author 周廷宇
 */
@Table(name = "rule_prize")
public class RulePrize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rulePrizeId;

    @Column(name = "rule_id")
    @NotNull
    private Integer ruleId;

    @Column(name = "prize_id")
    private Integer prizeId;

    @Column(name = "prize_ratio")
    private Double prizeRatio;

    public RulePrize() {
    }

    public RulePrize(@NotNull Integer ruleId, Integer prizeId, Double prizeRatio) {
        this.ruleId = ruleId;
        this.prizeId = prizeId;
        this.prizeRatio = prizeRatio;
    }

    public Integer getRulePrizeId() {
        return rulePrizeId;
    }

    public void setRulePrizeId(Integer rulePrizeId) {
        this.rulePrizeId = rulePrizeId;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Double getPrizeRatio() {
        return prizeRatio;
    }

    public void setPrizeRatio(Double prizeRatio) {
        this.prizeRatio = prizeRatio;
    }

    @Override
    public String toString() {
        return "RulePrize{" +
                "rulePrizeId=" + rulePrizeId +
                ", ruleId=" + ruleId +
                ", prizeId=" + prizeId +
                ", prizeRatio=" + prizeRatio +
                '}';
    }
}
