package upteam.lottery.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import upteam.lottery.app.service.LotteryService;
import upteam.lottery.domain.entity.User;
import upteam.lottery.infra.util.result.Results;

/**
 * @author 周廷宇
 */
@RestController
@Api("lottery controller")
@RequestMapping("/lottery")
public class LotteryController {
    private static final Logger logger = Logger.getLogger(LotteryController.class);

    @Autowired
    private LotteryService lotteryService;

    /**
     * enter a lottery activity
     *
     * @param activityId
     * @return
     */
    @ApiOperation("enter an activity")
    @GetMapping("/entry")
    public Object enterActivity(@RequestBody User user, Integer activityId) {
        logger.info("enter check");
        return Results.success(lotteryService.isAccess(activityId, user));
    }

    /**
     * do lottery
     *
     * @param user
     * @param activityId
     * @return
     */
    @ApiOperation("do lottery")
    @PostMapping
    public Object doLottery(@RequestBody User user, Integer activityId) {
        logger.info("do a lottery");
        return Results.success(lotteryService.doLottery(activityId, user));
    }
}
