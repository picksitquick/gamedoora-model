package com.gamedoora.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studio_assets")
public class StudioAsset extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id" , nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    Studios studios;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;

    @Column(name = "uid")
    private String uid;

    @Column(name = "name")
    private String name;

    @Column(name = "context")
    private String context;

    @Column(name = "version" , columnDefinition = "INT DEFAULT 1")
    private int version;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "bucket_name" , length = 512)
    private String bucketName;

    @Column(name = "is_published" , columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isPublished;

    @Column(name = "is_uploaded" , columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isUploaded;

    @Column(name = "is_uploading" , columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isUploading;

    @Column(name = "is_deleted" , columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDeleted;

    @Column(name = "asset_file_size" , columnDefinition = "INT DEFAULT 0")
    private int assetFileSize;

    @Column(name = "asset_file_content_type" , length = 128)
    private String assetFileContentType;

    @Column(name = "asset_file_name" , length = 64)
    private String assetFileName;

    @Column(name = "asset_file_url" , length = 1024)
    private String assetFileUrl;

    @Column(name = "asset_file_updated_at")
    private Date assetFileUpdatedAt;

    @Column(name = "script_locked_by")
    private int scriptLockedBy;

    @Column(name = "script_locked_at")
    private Date scriptLockedAt;

    @Column(name = "asset_type" , columnDefinition = "VARCHAR(255)")
    @Comment(value = "document or image or audio or video.")
    private String assetType;

    /* ColumnDefinition syntax has been updated, using nullable=false doesn't seem to work consistently.*/

}


