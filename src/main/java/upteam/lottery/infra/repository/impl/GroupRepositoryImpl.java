package upteam.lottery.infra.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import upteam.lottery.domain.entity.Group;
import upteam.lottery.domain.entity.User;
import upteam.lottery.domain.entity.UserGroup;
import upteam.lottery.domain.repository.GroupRepository;
import upteam.lottery.infra.mapper.UserGroupMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周廷宇
 */
@Repository
public class GroupRepositoryImpl implements GroupRepository {
    @Autowired
    private UserGroupMapper userGroupMapper;

    @Override
    public void create(Group group) {
        List<UserGroup> list = new ArrayList<>();

        for (User item : group.getNumbers()) {
            list.add(new UserGroup(item.getUserId(), group.getGroupId()));
        }
        userGroupMapper.insertList(list);
    }
}
