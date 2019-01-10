package upteam.lottery.infra.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import upteam.lottery.domain.entity.*;
import upteam.lottery.domain.repository.RuleRepository;
import upteam.lottery.infra.mapper.RuleMapper;
import upteam.lottery.infra.mapper.RuleObjectMapper;
import upteam.lottery.infra.mapper.RulePrizeMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周廷宇
 */
@Repository
public class RuleRepositoryImpl implements RuleRepository {
    @Autowired
    private RulePrizeMapper rulePrizeMapper;
    @Autowired
    private RuleObjectMapper ruleObjectMapper;
    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public List<RulePrize> createRulePrize(Rule rule) {
        List<RulePrize> list = new ArrayList<>();
        for (Prize item : rule.getPrizes()) {
            list.add(new RulePrize(rule.getRule_id(), item.getPrizeId(), item.getPrizeRatio()));
        }
        rulePrizeMapper.insertList(list);
        return list;
    }

    @Override
    public List<RuleObject> createRuleObject(Rule rule) {
        List<RuleObject> list = new ArrayList<>();

        if (rule.getLotteryObject() == 0) {
            for (User item : rule.getUsers()) {
                list.add(new RuleObject(rule.getRule_id(), item.getUserId(), item.getUserRatio()));
            }
            ruleObjectMapper.insertList(list);
        } else if (rule.getLotteryObject() == 1) {
            for (Group item : rule.getGroups()) {
                list.add(new RuleObject(rule.getRule_id(), item.getGroupId(), item.getGroupRatio()));
            }
            ruleObjectMapper.insertList(list);
        }

        return list;
    }

    @Override
    public Rule selectOneByActivityId(Integer activityId) {
        return ruleMapper.listOneByActivityId(activityId);
    }

    @Override
    public List<Integer> listUsersInRule(Integer ruleId) {
        return ruleMapper.listUsersInOneRule(ruleId);
    }
}
