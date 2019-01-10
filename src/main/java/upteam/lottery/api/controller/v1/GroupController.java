package upteam.lottery.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upteam.lottery.app.service.GroupService;
import upteam.lottery.domain.entity.Group;
import upteam.lottery.infra.util.result.Results;

/**
 * @author 周廷宇
 */
@RestController
@Api("group controller")
@RequestMapping("/groups")
public class GroupController {
    private static final Logger logger = Logger.getLogger(GroupController.class);

    @Autowired
    private GroupService groupService;

    @ApiOperation("list all groups")
    @GetMapping
    public Object listAllGroups() {
        logger.info("list all groups");
        return Results.success(groupService.listAll());
    }

    @ApiOperation("create a group")
    @PostMapping
    public Object create(@RequestBody Group group){
        logger.info("create a group");
        return Results.success(groupService.create(group));
    }
}
