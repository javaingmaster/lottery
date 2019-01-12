package upteam.lottery.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upteam.lottery.app.service.RuleService;
import upteam.lottery.domain.entity.*;
import upteam.lottery.domain.repository.RuleRepository;
import upteam.lottery.infra.mapper.RuleMapper;
import upteam.lottery.infra.mapper.RulePrizeMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private RuleMapper ruleMapper;
    @Autowired
    private RulePrizeMapper rulePrizeMapper;

    @Transactional
    @Override
    public Rule create(Rule rule) {
        ruleMapper.insert(rule);
        ruleRepository.createRulePrize(rule);
        ruleRepository.createRuleObject(rule);
        return rule;
    }

    @Override
    public List<Rule> listAll() {
        return ruleMapper.selectAll();
    }

    @Transactional(rollbackFor = RuntimeException.class, readOnly = true)
    @Override
    public Rule queryOne(Integer ruleId) {
        Rule rule = ruleMapper.selectByPrimaryKey(ruleId);
        List<Prize> rulePrizes = rulePrizeMapper.listRulePrizeAsPrize(ruleId);
        if (rule.getLotteryObject() == 0) {
            List<User> users = ruleRepository.listUsersInRule(ruleId);
            rule.setPrizes(rulePrizes);
            rule.setUsers(users);
            return rule;
        } else {
            List<Group> groups = ruleRepository.listGroupsInRule(ruleId);
            rule.setPrizes(rulePrizes);
            rule.setGroups(groups);
            return rule;
        }
    }

    @Override
    public Object updateOneRule(Rule rule) {
        return ruleMapper.updateByPrimaryKeySelective(rule);
    }
}
