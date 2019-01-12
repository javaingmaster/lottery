package upteam.lottery.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upteam.lottery.app.service.PrizeService;
import upteam.lottery.domain.entity.Prize;
import upteam.lottery.infra.mapper.PrizeMapper;
import upteam.lottery.infra.util.result.Results;

/**
 * @author 周廷宇
 */
@Api("prize controller")
@RestController
@RequestMapping("/prizes")
public class PrizeController {
    private static final Logger logger = Logger.getLogger(PrizeController.class);

    @Autowired
    private PrizeService prizeService;
    @Autowired
    private PrizeMapper prizeMapper;

    @ApiOperation("list prizes")
    @GetMapping
    public Object listAllPrizes() {
        return Results.success(prizeMapper.selectAll());
    }

    @ApiOperation("create prizes")
    @PostMapping
    public Object create(@RequestBody Prize prize) {
        return Results.success(prizeService.save(prize));
    }
}
