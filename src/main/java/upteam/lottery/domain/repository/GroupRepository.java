package upteam.lottery.domain.repository;

import upteam.lottery.domain.entity.Group;

/**
 * @author 周廷宇
 */
public interface GroupRepository {
    /**
     * create a group
     */
    public void create(Group group);
}
