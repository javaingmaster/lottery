package upteam.lottery.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upteam.lottery.app.service.GroupService;
import upteam.lottery.domain.entity.Group;
import upteam.lottery.domain.repository.GroupRepository;
import upteam.lottery.infra.mapper.GroupMapper;
import upteam.lottery.infra.mapper.UserGroupMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> listAll() {
        return groupMapper.selectAll();
    }

    @Override
    public Group create(Group group) {
        groupMapper.insert(group);
        groupRepository.create(group);
        return group;
    }
}
