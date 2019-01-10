package upteam.lottery.app.service;

import upteam.lottery.domain.entity.User;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface UserService {
    /**
     * list all users
     *
     * @return
     */
    public List<User> listAll();
}
