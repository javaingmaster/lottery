package upteam.lottery.app.service;

import org.springframework.web.multipart.MultipartFile;
import upteam.lottery.domain.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    /**
     * list users by role
     *
     * @param userRole
     * @return
     */
    public List<User> listUsersByRole(Integer userRole);

    /**
     * select user by name
     *
     * @param userName
     * @return
     */
    public User listUsersByName(String userName);

    /**
     * registry
     *
     * @param user
     * @return
     */
    public User save(User user);

    /**
     * <P>login</P>
     *
     * @param user
     * @param request
     * @return
     */
    public Object login(User user, HttpServletRequest request);

    /**
     * <p>update user</p>
     *
     * @param user
     * @return
     */
    public User update(User user);

    /**
     * check code
     * yes 1 / no 0
     *
     * @param code
     * @param httpSession
     * @return
     */
    public Object checkCode(String code, HttpSession httpSession);

    /**
     * return a image code
     *
     * @param httpSession
     * @param httpServletResponse
     */
    public void getIdentifyCode(HttpSession httpSession, HttpServletResponse httpServletResponse);
}
