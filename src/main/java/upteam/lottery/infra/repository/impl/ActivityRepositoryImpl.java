package upteam.lottery.infra.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import upteam.lottery.domain.entity.Activity;
import upteam.lottery.domain.entity.Page;
import upteam.lottery.domain.repository.ActivityRepository;
import upteam.lottery.infra.mapper.ActivityMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
@Repository
public class ActivityRepositoryImpl implements ActivityRepository {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> list(Activity activity, Page page) {
        return null;
    }

    @Override
    public List<Activity> listAll() {
        return activityMapper.selectAll();
    }

    @Override
    public Activity save(Activity activity) {
        activityMapper.insert(activity);
        return activity;
    }
}
