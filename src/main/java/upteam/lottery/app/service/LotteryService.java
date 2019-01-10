package upteam.lottery.app.service;

import upteam.lottery.domain.entity.User;

/**
 * @author 周廷宇
 */
public interface LotteryService {

    /**
     * check if have a right to take part in the activity
     *
     * @return yes prize list / no 0
     */
    public Object isAccess(Integer activityId, User user);

    /**
     * do a lottery
     *
     * @param activityId
     * @param user
     * @return
     */
    public Object doLottery(Integer activityId, User user);
}
