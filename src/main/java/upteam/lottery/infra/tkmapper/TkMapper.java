package upteam.lottery.infra.tkmapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zty
 *
 * <p>public mapper</p>
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
