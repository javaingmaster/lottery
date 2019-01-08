package upteam.lottery.domain.repository;

import upteam.lottery.domain.entity.Activity;
import upteam.lottery.domain.entity.Page;

import java.util.List;

/**
 * @author 周廷宇
 */
public interface ActivityRepository {
    /**
     * add an activity
     *
     * @param activity
     * @return
     */
    public Activity save(Activity activity);


    /**
     * select by params or page
     *
     * @param activity
     * @param page
     * @return
     */
    public List<Activity> list(Activity activity, Page page);

    /**
     * list all activities
     *
     * @return
     */
    public List<Activity> listAll();
}
