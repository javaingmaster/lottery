package upteam.lottery.app.service;

import upteam.lottery.domain.entity.Rule;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface RuleService {
    /**
     * create a rule
     *
     * @param rule
     * @return
     */
    public Rule create(Rule rule);

    /**
     * list all rules
     *
     * @return
     */
    public List<Rule> listAll();

    /**
     * query a rule and its details
     *
     * @param ruleId
     * @return
     */
    public Rule queryOne(Integer ruleId);

    /**
     * update a rule
     *
     * @param rule
     * @return
     */
    public Object updateOneRule(Rule rule);
}
