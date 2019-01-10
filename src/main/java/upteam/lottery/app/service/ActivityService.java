package upteam.lottery.app.service;

import upteam.lottery.domain.entity.Activity;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface ActivityService {
    /**
     * create an activity
     *
     * @param activity
     * @return
     */
    public Activity create(Activity activity);

    /**
     * list all activities
     *
     * @return
     */
    public List<Activity> listAll();

}
