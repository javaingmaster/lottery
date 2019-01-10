package upteam.lottery.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upteam.lottery.app.service.ActivityService;
import upteam.lottery.domain.entity.Activity;
import upteam.lottery.infra.util.result.Results;

/**
 * @author 周廷宇
 */
@Api("activity controller")
@RestController
@RequestMapping("/activitys")
public class ActivityController {
    private static final Logger logger = Logger.getLogger(ActivityController.class);

    @Autowired
    private ActivityService activityService;

    @ApiOperation("create an activity")
    @PostMapping
    public Object create(@RequestBody Activity activity) {
        logger.info("create an activity");
        return Results.success(activityService.create(activity));
    }

    @ApiOperation("list all activities")
    @GetMapping
    public Object listAll() {
        logger.info("list all activities");
        return Results.success(activityService.listAll());
    }
}
