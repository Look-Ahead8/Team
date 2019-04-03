package com.team.bean;

public class PPirture {
    private Integer ppId;

    private Integer projectId;

    private String pirturePath;

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getPirturePath() {
        return pirturePath;
    }

    public void setPirturePath(String pirturePath) {
        this.pirturePath = pirturePath == null ? null : pirturePath.trim();
    }
}