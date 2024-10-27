package com.jgji.selfassessment.domain.activity;

import com.jgji.selfassessment.domain.activity.domain.Activity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityCommandRepository {

    Activity save(Activity activity);
}
