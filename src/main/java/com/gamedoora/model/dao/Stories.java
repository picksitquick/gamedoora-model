package com.gamedoora.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stories", uniqueConstraints = @UniqueConstraint(columnNames = {"state_id", "created_at"}))
public class Stories implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", table = "stories", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", table = "stories")
    private String name;
    @Basic
    @Column(name = "description", table = "stories")
    private String description;
    @Basic
    @Column(name = "start_date", table = "stories")
    private Integer startDate;
    @Basic
    @Column(name = "due_date", table = "stories")
    private Integer dueDate;
    @Basic(optional = false)
    @Column(name = "state_id", table = "stories", nullable = false)
    private int stateId;
    @Basic
    @Column(name = "position", table = "stories")
    private Integer position;
    @Lob
    @Basic
    @Column(name = "remarks", table = "stories", length = 65535)
    private String remarks;
    @Basic(optional = false)
    @Column(name = "created_at", table = "stories", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", table = "stories", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany
    private List<StoryUsers> storyUserses;
    @OneToMany
    private List<StudioStoryAssets> studioStoryAssetses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getDueDate() {
        return dueDate;
    }

    public void setDueDate(Integer dueDate) {
        this.dueDate = dueDate;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<StoryUsers> getStoryUserses() {
        if (storyUserses == null) {
            storyUserses = new ArrayList<>();
        }
        return storyUserses;
    }

    public void setStoryUserses(List<StoryUsers> storyUserses) {
        this.storyUserses = storyUserses;
    }

    public void addStoryUserse(StoryUsers storyUserse) {
        getStoryUserses().add(storyUserse);
    }

    public void removeStoryUserse(StoryUsers storyUserse) {
        getStoryUserses().remove(storyUserse);
    }

    public List<StudioStoryAssets> getStudioStoryAssetses() {
        if (studioStoryAssetses == null) {
            studioStoryAssetses = new ArrayList<>();
        }
        return studioStoryAssetses;
    }

    public void setStudioStoryAssetses(List<StudioStoryAssets> studioStoryAssetses) {
        this.studioStoryAssetses = studioStoryAssetses;
    }

    public void addStudioStoryAssetse(StudioStoryAssets studioStoryAssetse) {
        getStudioStoryAssetses().add(studioStoryAssetse);
    }

    public void removeStudioStoryAssetse(StudioStoryAssets studioStoryAssetse) {
        getStudioStoryAssetses().remove(studioStoryAssetse);
    }

}