package upteam.lottery.api.controller.handler;

import upteam.lottery.infra.util.exception.CannotAccessException;
import upteam.lottery.infra.util.exception.ErrorLotteryObjectInRuleException;
import upteam.lottery.infra.util.exception.SerUserAlreadyExistException;
import upteam.lottery.infra.util.result.Results;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import upteam.lottery.infra.util.result.Results;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zty
 *
 * <p>global exception processor</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String BAD_REQUEST_NOTE = " bad request caused: ";
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * <p>registry the same user for twice</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = SerUserAlreadyExistException.class)
    @ResponseBody
    public Object userAlreadyExist(HttpServletRequest req, SerUserAlreadyExistException e) throws SerUserAlreadyExistException {
        logger.info("throw SerUserAlreadyExistException exception");
        return Results.invalid(req.getRequestURI() + BAD_REQUEST_NOTE + e.getMessage());
    }

    /**
     * <p>lottery object error</p>
     */
    @ExceptionHandler(value = CannotAccessException.class)
    @ResponseBody
    public Object cannotAccessExceptionError(HttpServletRequest req, Exception e) {
        logger.info("throw CannotAccessException exception: " + e.getClass());
        return Results.error(req.getRequestURI() + " CannotAccessException " + e.getMessage());
    }

    /**
     * <p>lottery object error</p>
     */
    @ExceptionHandler(value = ErrorLotteryObjectInRuleException.class)
    @ResponseBody
    public Object lotteryObjectInRuleError(HttpServletRequest req, Exception e) {
        logger.info("throw ErrorLotteryObjectInRuleException exception: " + e.getClass());
        return Results.error(req.getRequestURI() + " ErrorLotteryObjectInRuleException " + e.getMessage());
    }

    /**
     * <p>unknown error</p>
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object scheduleError(HttpServletRequest req, Exception e) {
        logger.info("throw Exception exception: " + e.getClass());
        return Results.error(req.getRequestURI() + " server unknown error " + e.getMessage());
    }

}

