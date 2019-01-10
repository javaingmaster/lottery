package upteam.lottery.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upteam.lottery.app.service.RuleService;
import upteam.lottery.domain.entity.Rule;
import upteam.lottery.infra.util.interfaces.Permission;
import upteam.lottery.infra.util.result.Results;

/**
 * @author 周廷宇
 */
@Api("rule controller")
@RequestMapping("/rules")
@RestController
public class RuleController {
    private static final Logger logger = Logger.getLogger(RuleController.class);

    @Autowired
    private RuleService ruleService;

    @ApiOperation("create a lottery rule")
    @PostMapping
    public Object create(@RequestBody Rule rule) {
        logger.info("create a rule.");
        return Results.success(ruleService.create(rule));
    }

    @ApiOperation("list all rules")
    @GetMapping
    public Object list() {
        logger.info("list all rules");
        return Results.success(ruleService.listAll());
    }
}
