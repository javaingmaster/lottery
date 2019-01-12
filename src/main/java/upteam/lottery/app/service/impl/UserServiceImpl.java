package upteam.lottery.app.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upteam.lottery.app.service.UserService;
import upteam.lottery.domain.entity.User;
import upteam.lottery.domain.repository.UserRepository;
import upteam.lottery.infra.constant.AuthorityConstant;
import upteam.lottery.infra.mapper.UserMapper;
import upteam.lottery.infra.util.exception.SerUserAlreadyExistException;
import upteam.lottery.infra.util.jwt.JwtUtil;
import upteam.lottery.infra.util.jwt.ValidatorUtil;
import upteam.lottery.infra.util.result.Results;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author 周廷宇
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> listUsersByRole(Integer userRole) {
        User user = new User(userRole);
        return userMapper.select(user);
    }

    @Override
    public User listUsersByName(String userName) {
        User user = new User(userName);
        return userMapper.selectOne(user);
    }

    @Override
    public User save(User user) {
        if (listUsersByName(user.getUserName()) != null) {
            throw new SerUserAlreadyExistException(" user already exists ");
        }
        return userRepository.create(user);
    }

    @Override
    public Object login(User user, HttpServletRequest request) {
        logger.info("enter in login service");
        String username = user.getUserName();
        User userInDatabase = listUsersByName(username);
        if (null != userInDatabase) {
            if (DigestUtils.md5Hex(user.getUserPassword() + AuthorityConstant.SALT).equals(userInDatabase.getUserPassword())) {
                String token = processToken(userInDatabase, request);
                if (token != null) {
                    logger.info(token);
                    userInDatabase.setUserToken(token);
                    update(userInDatabase);
                }
                return Results.success(userInDatabase);
            }
            return Results.success(" cannot match password when login ");
        }
        return Results.success(" cannot match user name when login ");
    }

    private String processToken(User user, HttpServletRequest request) {
        if ((request.getAttribute(AuthorityConstant.HAS_TOKEN)) == null) {
            return JwtUtil.createToken(user);
        }
        return null;
    }

    @Override
    public User update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public Object checkCode(String code, HttpSession httpSession) {
        String realCode = (String) httpSession.getAttribute("identifyCode");
        if (code != null && code.equals(realCode)) {
            return 1;
        }
        return 0;
    }

    @Override
    public void getIdentifyCode(HttpSession session, HttpServletResponse response) {
        response.setContentType("image/png");
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();

            Object[] objects = ValidatorUtil.createIdentifyImage();
            BufferedImage bufferedImage = (BufferedImage) objects[0];
            Object rightCode = objects[1];
            session.setAttribute("identifyCode", rightCode);

            ImageIO.write(bufferedImage, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
