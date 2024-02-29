package com.gamedoora.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "kanban")
public class KanBan {

    @Id
    @GeneratedValue
    @Column(name = "boardId", nullable = false)
    private UUID boardId;

    @Column(name = "boardName", nullable = false)
    private String boardName;

    @ManyToMany(mappedBy = "kanBanSet")
    private Set<Users> users;

    @ManyToOne
    @JoinColumn(name = "story_issue_email_id")
    private StoryIssue storyIssue;
}
