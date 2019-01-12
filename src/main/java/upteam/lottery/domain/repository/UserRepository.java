package upteam.lottery.domain.repository;

import upteam.lottery.domain.entity.User;

/**
 * @author 周廷宇
 */
public interface UserRepository {
    /**
     * <p>add</p>
     *
     * @param user
     * @return
     */
    public User create(User user);
}
