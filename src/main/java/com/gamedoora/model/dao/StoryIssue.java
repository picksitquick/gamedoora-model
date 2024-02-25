package com.gamedoora.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StoryIssue extends BaseIssue{
    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    @OneToMany(mappedBy = "storyIssue")
    private Set<KanBan> kanBan;
}
