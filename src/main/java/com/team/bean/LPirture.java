package com.team.bean;



public class LPirture {
    private Integer lpId;

    private Integer lifeId;

    private String pirturePath;
    
    
    public Integer getLpId() {
        return lpId;
    }

    public void setLpId(Integer lpId) {
        this.lpId = lpId;
    }

    public Integer getLifeId() {
        return lifeId;
    }

    public void setLifeId(Integer lifeId) {
        this.lifeId = lifeId;
    }

    public String getPirturePath() {
        return pirturePath;
    }

    public void setPirturePath(String pirturePath) {
        this.pirturePath = pirturePath == null ? null : pirturePath.trim();
    }

    
}