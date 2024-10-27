package com.jgji.selfassessment.domain.activity.application;

import com.jgji.selfassessment.domain.activity.ActivityCommandRepository;
import com.jgji.selfassessment.domain.activity.domain.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ActivityCommandService {

    private final ActivityCommandRepository activityCommandRepository;

    @Transactional(rollbackFor = Exception.class)
    public Activity save(Activity activity) {
        return activityCommandRepository.save(activity);
    }

}
