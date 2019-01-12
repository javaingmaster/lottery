package upteam.lottery.domain.repository;

import io.swagger.models.auth.In;
import upteam.lottery.domain.entity.*;

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
    public List<User> listUsersInRule(Integer ruleId);

    /**
     * list groups in a rule
     *
     * @param ruleId
     * @return
     */
    public List<Group> listGroupsInRule(Integer ruleId);

    /**
     * delete rule object by id
     *
     * @param ruleObjectId
     * @return
     */
    public int deleteRuleObject(Integer ruleObjectId);

    /**
     * delete rule prize by id
     *
     * @param rulePrizeId
     * @return
     */
    public int deleteRulePrize(Integer rulePrizeId);
}
