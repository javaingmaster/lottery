package upteam.lottery.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import upteam.lottery.app.service.UserService;
import upteam.lottery.domain.entity.User;
import upteam.lottery.infra.util.interfaces.Permission;
import upteam.lottery.infra.util.jwt.ValidatorUtil;
import upteam.lottery.infra.util.result.Results;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.transform.Result;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 周廷宇
 */
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

    @ApiOperation("list users by role")
    @GetMapping("/{userRole}")
    public Object listUsersByRole(@PathVariable(value = "userRole", required = true) Integer userRole) {
        logger.info("get users by role");
        return Results.success(userService.listUsersByRole(userRole));
    }

    @ApiOperation("select user by name")
    @GetMapping("/name/{name}")
    public Object selectUserByName(@PathVariable(value = "name", required = true) String name) {
        logger.info("get user by name");
        return Results.success(userService.listUsersByName(name));
    }

    @ApiOperation("registry")
    @PostMapping
    public Object registry(@RequestBody User user) {
        logger.info("registry");
        return Results.created(userService.save(user));
    }

    @ApiOperation("update a user")
    @PutMapping
    public Object update(@RequestBody User user) {
        logger.info("update a user");
        return userService.update(user);
    }

    @ApiOperation("check image code")
    @GetMapping("/code/{code}")
    public Object checkIdentifyCode(@PathVariable(value = "code", required = true) String code, HttpSession httpSession) {
        logger.info("check code");
        return userService.checkCode(code, httpSession);
    }

    @ApiOperation("login")
    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest request) {
        logger.info("login");
        return Results.success(userService.login(user, request));
    }

    @GetMapping(value = "/identify", produces = {"image/png"})
    @ApiOperation("get identify image")
    public void getIdentifyImage(HttpSession session, HttpServletResponse response) {
        logger.info("get identify image");
        userService.getIdentifyCode(session, response);
    }
}
