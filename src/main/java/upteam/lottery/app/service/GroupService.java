package upteam.lottery.app.service;

import upteam.lottery.domain.entity.Group;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface GroupService {
    /**
     * list all groups
     *
     * @return
     */
    public List<Group> listAll();

    /**
     * create a group
     *
     * @param group
     * @return
     */
    public Group create(Group group);

    /**
     * @param groupId
     * @return
     */
    public Group queryById(Integer groupId);
}
