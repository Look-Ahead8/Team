package com.team.bean;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Life {
    private Integer lifeId;

    private Integer mId;
    @NotBlank(message="内容不可以为空")
    private String context;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date lifeDate;

    private List<LPirture> lPirture;
    
    public Integer getLifeId() {
        return lifeId;
    }

    public void setLifeId(Integer lifeId) {
        this.lifeId = lifeId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Date getLifeDate() {
        return lifeDate;
    }

    public void setLifeDate(Date lifeDate) {
        this.lifeDate = lifeDate;
    }

	public List<LPirture> getlPirture() {
		return lPirture;
	}

	public void setlPirture(List<LPirture> lPirture) {
		this.lPirture = lPirture;
	}

	
    
}