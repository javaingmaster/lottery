package upteam.lottery.infra.mapper;

import upteam.lottery.domain.entity.Group;
import upteam.lottery.domain.entity.Rule;
import upteam.lottery.domain.entity.User;
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
    public List<User> listUsersInOneRule(int ruleId);

    /**
     * list groups in rule
     *
     * @param ruleId
     * @return
     */
    public List<Group> listGroupsInRule(int ruleId);
}
