package upteam.lottery.infra.util.aop;


import upteam.lottery.infra.util.interfaces.Permission;
import upteam.lottery.infra.util.jwt.JwtUtil;
import upteam.lottery.infra.util.jwt.TokenMessage;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import upteam.lottery.infra.util.other.AnnotationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author 周廷宇
 *
 * <p>authority controller</p>
 */
public class AuthorityInterceptor implements HandlerInterceptor {
    private static final Logger logger = Logger.getLogger(AuthorityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Permission permission = (Permission) AnnotationUtil.getAnnotation(handlerMethod, Permission.class);
        int level = permission.level();
        String token = request.getHeader("Authorization");

        //public interfaces
        if (level == 1) {
            if (token == null || token.trim().isEmpty()) {
                request.setAttribute("hasToken", false);
            } else {
                TokenMessage tokenMessage = JwtUtil.parseToken(token);
                request.setAttribute("userId", tokenMessage.getUserId());
                request.setAttribute("userName", tokenMessage.getUserName());
                request.setAttribute("hasToken", true);
            }
            return true;
        }

        //check the authority in token
        if (token == null || token.trim().isEmpty()) {
            logger.info("token is null");
            response.sendError(401, "sorry! you haven't the authority of api: " + request.getRequestURI());
            return false;
        }

        TokenMessage tokenMessage = JwtUtil.parseToken(token);

        if (tokenMessage.getUserAuthority() >= level) {
            if (tokenMessage.getExpiresDate().after(new Date())) {
                request.setAttribute("userId", tokenMessage.getUserId());
                request.setAttribute("userName", tokenMessage.getUserName());
                logger.info("right authority");
                return true;
            } else {
                logger.info("token is out of date");
                response.sendError(401, "sorry! your token is out of date, try to login again!");
                return false;
            }
        } else {
            logger.info("level in token is not high enough");
            response.sendError(401, "sorry! you haven't the authority of api: " + request.getRequestURI());
            return false;
        }
    }

}
