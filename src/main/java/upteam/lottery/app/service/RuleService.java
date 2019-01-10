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
}
