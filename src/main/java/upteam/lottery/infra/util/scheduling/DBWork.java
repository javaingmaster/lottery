package upteam.lottery.infra.util.scheduling;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import upteam.lottery.domain.entity.Record;
import upteam.lottery.infra.constant.Scheduling;
import upteam.lottery.infra.mapper.RecordMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
@Component
public class DBWork {
    private static final Logger logger = Logger.getLogger(DBWork.class);

    @Autowired
    private RecordMapper recordMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    @Async
    @Scheduled(fixedRate = Scheduling.RECORD_FLUSH_TIME)
    public void flushRecordsToHistoryTable() {
        logger.info("execute flush records");
        List<Record> list = recordMapper.listAllRecords("lottery_record_w");
        if (list == null || list.size() == 0) {
            logger.info("no records in lottery_record_w");
        } else {
            logger.info(list.size() + "pieces records are flushed into lottery_record_r");
            recordMapper.saveRecords(list, "lottery_record_r");
        }
    }
}
