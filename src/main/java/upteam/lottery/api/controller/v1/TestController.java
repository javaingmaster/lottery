package upteam.lottery.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("test!")
@RequestMapping("/test")
@Api("test controller")
public class TestController {
    private static final Logger logger = Logger.getLogger(TestController.class);

    @ApiOperation("test interfaces")
    @GetMapping("/test")
    public String test() {
        logger.info("test it!");
        return "hello";
    }
}
