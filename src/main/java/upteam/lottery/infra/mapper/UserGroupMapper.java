package upteam.lottery.infra.mapper;

import upteam.lottery.domain.entity.User;
import upteam.lottery.domain.entity.UserGroup;
import upteam.lottery.infra.tkmapper.TkMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface UserGroupMapper extends TkMapper<UserGroup> {
    /**
     * list users in group
     *
     * @param groupId
     * @return
     */
    List<User> listUsersInGroup(Integer groupId);
}
