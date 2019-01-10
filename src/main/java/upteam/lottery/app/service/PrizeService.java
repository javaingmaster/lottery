package upteam.lottery.app.service;

import upteam.lottery.domain.entity.Prize;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface PrizeService {
    /**
     * list prizes of a activity by rule id
     *
     * @param ruleId
     * @return
     */
    public List<Prize> listPrizeByRuleId(Integer ruleId);
}
