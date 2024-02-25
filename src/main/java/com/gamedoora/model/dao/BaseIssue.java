package com.gamedoora.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "base_issue")
public class BaseIssue {

    @Id
    @GeneratedValue
    @Column(name = "base_issueId", nullable = false)
    private UUID issueId;

    private IssueType issueType;

    private ActivityType activityType;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "storyPoints") // might be used in future
    private String storyPoints;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "assignee")
    private String assignee;

    private Priority priority;

    @OneToMany(mappedBy = "baseIssue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> comments;

    @OneToMany(mappedBy = "baseIssue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IssueHistory> history;
    // add api for get comment and history

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
}
