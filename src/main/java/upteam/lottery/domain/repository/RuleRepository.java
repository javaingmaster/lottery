package upteam.lottery.domain.repository;

import io.swagger.models.auth.In;
import upteam.lottery.domain.entity.Rule;
import upteam.lottery.domain.entity.RuleObject;
import upteam.lottery.domain.entity.RulePrize;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface RuleRepository {
    /**
     * create details of  prize
     *
     * @param rule
     * @return
     */
    public List<RulePrize> createRulePrize(Rule rule);

    /**
     * create details of object
     *
     * @param rule
     * @return
     */
    public List<RuleObject> createRuleObject(Rule rule);

    /**
     * select one by activity id to check lottery type
     *
     * @return
     */
    public Rule selectOneByActivityId(Integer activityId);

    /**
     * list users in a rule
     *
     * @param ruleId
     * @return
     */
    public List<Integer> listUsersInRule(Integer ruleId);
}
