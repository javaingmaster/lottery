package upteam.lottery.infra.mapper;

import upteam.lottery.domain.entity.Prize;
import upteam.lottery.domain.entity.RulePrize;
import upteam.lottery.infra.tkmapper.TkMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface RulePrizeMapper extends TkMapper<RulePrize> {
    /**
     * list rule prize and ratio
     *
     * @param ruleId
     * @return
     */
    public List<RulePrize> listRulePrize(Integer ruleId);

    /**
     * list rule prize and ratio as prize entity
     *
     * @param ruleId
     * @return
     */
    public List<Prize> listRulePrizeAsPrize(Integer ruleId);
}
