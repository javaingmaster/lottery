package upteam.lottery.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upteam.lottery.app.service.PrizeService;
import upteam.lottery.domain.entity.Prize;
import upteam.lottery.infra.mapper.PrizeMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
@Service
public class PrizeServiceImpl implements PrizeService {
    @Autowired
    private PrizeMapper prizeMapper;

    @Override
    public List<Prize> listPrizeByRuleId(Integer ruleId) {
        return prizeMapper.listPrizeByRuleId(ruleId);
    }
}
