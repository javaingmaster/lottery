package upteam.lottery.api.controller.handler;

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
     * <p>unknown error</p>
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object scheduleError(HttpServletRequest req, Exception e) {
        logger.info("throw Exception exception: " + e.getClass());
        return Results.error(req.getRequestURI() + " server unknown error " + e.getMessage());
    }

}

