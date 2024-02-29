package com.gamedoora.model.dto;

import com.gamedoora.model.dao.ActivityType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class IssueHistoryDTO {

    private ActivityType activityType;

    private Date startDate;
}
