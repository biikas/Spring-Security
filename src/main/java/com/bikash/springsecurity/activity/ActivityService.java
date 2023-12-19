package com.bikash.springsecurity.activity;

import com.bikash.springsecurity.activity.dto.ActivityCreateRequest;
import com.bikash.springsecurity.dto.ServerResponse;

public interface ActivityService {

    ServerResponse createNewActivity(ActivityCreateRequest activityCreateRequest);
}
