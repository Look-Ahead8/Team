package com.team.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Announcement {
	private Integer announcementId;
	
	private Integer mId;
	@NotBlank(message="内容不可以为空")
	private String message;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT-5")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date announcementTime;

	public Integer getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getAnnouncementTime() {
		return announcementTime;
	}

	public void setAnnouncementTime(Date announcementTime) {
		this.announcementTime = announcementTime;
	}

	
}
