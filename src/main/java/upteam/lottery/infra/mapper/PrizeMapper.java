package upteam.lottery.infra.mapper;

import upteam.lottery.domain.entity.Prize;
import upteam.lottery.domain.entity.RuleObject;
import upteam.lottery.domain.entity.RulePrize;
import upteam.lottery.infra.tkmapper.TkMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface PrizeMapper extends TkMapper<Prize> {
    /**
     * list prizes of a activity by rule id
     *
     * @param ruleId
     * @return
     */
    public List<Prize> listPrizeByRuleId(Integer ruleId);
}
