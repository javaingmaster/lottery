package upteam.lottery.infra.util.aop;

import upteam.lottery.infra.constant.IdentifyChar;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 周廷宇
 *
 * <p>check identify code</p>
 */
public class IdentifyCodeInterceptor implements HandlerInterceptor {
    private static final Logger logger = Logger.getLogger(IdentifyCodeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String rightCode = (String) (session.getAttribute(IdentifyChar.KEY_IN_SESSION));
        String code = request.getParameter("identifyCode");
        logger.info("code you input as follow");
        logger.info(code);
        logger.info("right code is as follow:");
        logger.info(rightCode);

        if (code == null || code.trim().isEmpty()) {
            response.sendError(400, "you need input an identify code");
            return false;
        }
        if (!code.equals(rightCode)) {
            response.sendError(400, "you need check the identify code");
            return false;
        }
        return true;
    }
}
