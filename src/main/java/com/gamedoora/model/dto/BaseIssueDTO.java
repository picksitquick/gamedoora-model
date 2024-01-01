package com.gamedoora.model.dto;

import com.gamedoora.model.dao.ActivityType;
import com.gamedoora.model.dao.IssueType;
import com.gamedoora.model.dao.Priority;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseIssueDTO {
    private IssueType issueType;

    private ActivityType activityType;

    private String title;

    private String description;

    private String storyPoints;

    private String issuer;

    private String assignee;

    private Priority priority;

    private Date startDate;
}
