package upteam.lottery.infra.repository.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import upteam.lottery.domain.entity.User;
import upteam.lottery.domain.repository.UserRepository;
import upteam.lottery.infra.constant.AuthorityConstant;
import upteam.lottery.infra.mapper.UserMapper;

import java.util.Date;

/**
 * @author 周廷宇
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User create(User user) {
        String pwd = user.getUserPassword();
        user.setUserPassword(DigestUtils.md5Hex(pwd + AuthorityConstant.SALT));
        userMapper.insert(user);
        return user;
    }
}
