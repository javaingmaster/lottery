package upteam.lottery.infra.mapper;

import upteam.lottery.domain.entity.Rule;
import upteam.lottery.infra.tkmapper.TkMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface RuleMapper extends TkMapper<Rule> {
    /**
     * get rule by an activity id
     *
     * @param activityId
     * @return
     */
    public Rule listOneByActivityId(int activityId);

    /**
     * get users in a rule
     *
     * @param ruleId
     * @return a list of user id
     */
    public List<Integer> listUsersInOneRule(int ruleId);
}
