package upteam.lottery.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upteam.lottery.app.service.RuleService;
import upteam.lottery.domain.entity.Rule;
import upteam.lottery.domain.entity.RulePrize;
import upteam.lottery.domain.repository.RuleRepository;
import upteam.lottery.infra.mapper.RuleMapper;

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
}
