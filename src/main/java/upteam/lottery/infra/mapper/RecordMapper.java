package upteam.lottery.infra.mapper;

import org.apache.ibatis.annotations.Param;
import upteam.lottery.domain.entity.Page;
import upteam.lottery.domain.entity.Record;
import upteam.lottery.infra.tkmapper.TkMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface RecordMapper extends TkMapper<Record> {
    /**
     * list all records
     *
     * @param tableName
     * @return
     */
    public List<Record> listAllRecords(@Param("table") String tableName);

    /**
     * list records by page
     *
     * @param tableName
     * @param page
     * @return
     */
    public List<Record> listRecordsByPage(@Param("table") String tableName, @Param("page") Page page);

    /**
     * list records by activity id
     *
     * @param tableName
     * @param activityId
     * @return
     */
    public List<Record> listRecordsByActivityId(@Param("table") String tableName, @Param("activityId") Integer activityId);

    /**
     * save records
     *
     * @param list
     * @param tableName
     * @return
     */
    public List<Record> saveRecords(@Param("list") List<Record> list, @Param("table") String tableName);
}
