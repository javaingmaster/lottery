package upteam.lottery.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upteam.lottery.app.service.ActivityService;
import upteam.lottery.domain.entity.Activity;
import upteam.lottery.domain.repository.ActivityRepository;
import upteam.lottery.infra.mapper.ActivityMapper;

import java.util.List;

/**
 * @author 周廷宇
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Activity create(Activity activity) {
        activityRepository.save(activity);
        return activity;
    }

    @Override
    public List<Activity> listAll() {
        return activityMapper.selectAll();
    }
}
