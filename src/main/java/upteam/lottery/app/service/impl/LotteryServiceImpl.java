package upteam.lottery.app.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upteam.lottery.app.service.LotteryService;
import upteam.lottery.app.service.PrizeService;
import upteam.lottery.domain.entity.*;
import upteam.lottery.domain.repository.RuleRepository;
import upteam.lottery.infra.constant.AuthorityConstant;
import upteam.lottery.infra.mapper.RecordMapper;
import upteam.lottery.infra.mapper.RuleObjectMapper;
import upteam.lottery.infra.mapper.RulePrizeMapper;
import upteam.lottery.infra.util.exception.CannotAccessException;
import upteam.lottery.infra.util.exception.ErrorLotteryObjectInRuleException;
import upteam.lottery.infra.util.other.LotteryUtil;
import upteam.lottery.infra.util.other.ObjectTransferUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周廷宇
 */
@Service
public class LotteryServiceImpl implements LotteryService {
    private static final Logger logger = Logger.getLogger(LotteryServiceImpl.class);

    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private PrizeService prizeService;
    @Autowired
    private RuleObjectMapper ruleObjectMapper;
    @Autowired
    private RulePrizeMapper rulePrizeMapper;
    @Autowired
    private RecordMapper recordMapper;

    @Transactional
    @Override
    public Object isAccess(Integer activityId, User user) {
        Rule rule = ruleRepository.selectOneByActivityId(activityId);

        if (rule.getIfPublic() == 0) {
            if (user != null && user.getUserRole() > AuthorityConstant.USER) {
                return prizeService.listPrizeByRuleId(rule.getRule_id());
            } else {
                throw new CannotAccessException("only admin can enter this activity");
            }
        } else {
            List<User> usersInRule = ruleRepository.listUsersInRule(rule.getRule_id());
            List<Integer> users = ObjectTransferUtil.userToInt(usersInRule);

            if (users != null && users.size() > 0 && users.contains(user.getUserId())) {
                logger.info("enter a public activity");
                return prizeService.listPrizeByRuleId(rule.getRule_id());
            } else {
                logger.info("you are not in the lottery tables");
                throw new CannotAccessException("you are not added in this activity");
            }
        }
    }

    @Transactional
    @Override
    public Object doLottery(Integer activityId, User user) {
        Rule rule = ruleRepository.selectOneByActivityId(activityId);
        List<Record> records = null;
        List<RuleObject> ruleObjects = ruleObjectMapper.listRuleObject(rule.getRule_id());
        List<RulePrize> rulePrizes = rulePrizeMapper.listRulePrize(rule.getRule_id());

        if (rule.getIfPublic() == 0) {
            //lottery by admin
            if (rule.getIfBack() == 0) {
                records = LotteryUtil.unrepeatableLottery(rule, ruleObjects, rulePrizes);
            } else {
                records = LotteryUtil.repeatableLottery(rule, ruleObjects, rulePrizes);
            }
            if (records.size() == 0) {
                logger.info("no records");
                return null;
            }
            return recordMapper.saveRecords(records, "lottery_record_w");
        } else {
            //user lottery
            if (rule.getIfBack() == 0) {
                records = LotteryUtil.personalUnrepeatableLottery(rule, ruleObjects, rulePrizes);
            } else {
                records = LotteryUtil.personalRepeatableLottery(rule, ruleObjects, rulePrizes);
            }
            if (records.size() == 0) {
                logger.info("no personal record");
                return null;
            }
            return recordMapper.saveRecords(records, "lottery_record_w");
        }
    }
}
