package upteam.lottery.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upteam.lottery.app.service.UserService;
import upteam.lottery.infra.util.interfaces.Permission;
import upteam.lottery.infra.util.result.Results;

import javax.xml.transform.Result;

@RestController
@Api("user controller")
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation("get all users")
    public Object listAllUsers() {
        logger.info("get all users.");
        return Results.success(userService.listAll());
    }
}
