package upteam.lottery.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upteam.lottery.app.service.UserService;
import upteam.lottery.domain.entity.User;
import upteam.lottery.infra.mapper.UserMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.selectAll();
    }
}
