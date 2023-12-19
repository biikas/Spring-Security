package com.bikash.springsecurity.activity.dto;

import com.bikash.springsecurity.dto.ModelBase;
import lombok.Data;

/**
 * @author Bikash Shah
 */
@Data
public class ActivityCreateRequest extends ModelBase {

    private String title;
    private String description;
    private String date;

}
