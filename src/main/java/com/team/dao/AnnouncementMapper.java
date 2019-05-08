package com.team.dao;

import java.util.List;

import com.team.bean.Announcement;

public interface AnnouncementMapper {

	int insertSelective(Announcement announcement);
	
	Announcement selectnew();
	
	List<Announcement> selectAll();
	
	
	void deleteAnnouncement(Integer announcementId);
}
