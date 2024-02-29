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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comments extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    // look into comments for KanBan board and make necessary changes, not going to thread comments, for activity stream use a separate comment
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    private UUID issueId; // for project boards use UUID instead of long

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;

    @ManyToOne
    @JoinColumn(name = "base_issueId")
    private BaseIssue baseIssue;

}
