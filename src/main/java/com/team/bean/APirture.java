package com.team.bean;

public class APirture {
    private Integer apId;

    private Integer awardId;

    private String pirturePath;

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public Integer getAwardId() {
        return awardId;
    }

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    public String getPirturePath() {
        return pirturePath;
    }

    public void setPirturePath(String pirturePath) {
        this.pirturePath = pirturePath == null ? null : pirturePath.trim();
    }
}