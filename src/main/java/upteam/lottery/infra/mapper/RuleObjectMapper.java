package upteam.lottery.infra.mapper;

import upteam.lottery.domain.entity.RuleObject;
import upteam.lottery.infra.tkmapper.TkMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface RuleObjectMapper extends TkMapper<RuleObject> {

    /**
     * list rule object and ratio
     *
     * @param ruleId
     * @return
     */
    public List<RuleObject> listRuleObject(Integer ruleId);
}
