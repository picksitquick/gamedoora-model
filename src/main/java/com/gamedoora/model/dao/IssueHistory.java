package com.gamedoora.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "issue history")
public class IssueHistory {

    @Id
    @Column(name = "emailId",nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "users_email_id")
    private Users users;

    private ActivityType activityType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "base_issueId")
    private BaseIssue baseIssue;
}
