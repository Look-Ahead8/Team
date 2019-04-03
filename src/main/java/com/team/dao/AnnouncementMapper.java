package com.team.dao;

import java.util.List;

import com.team.bean.Announcement;

public interface AnnouncementMapper {

	void insertSelecetive(Announcement announcement);
	
	Announcement selectnew();
	
	List<Announcement> selectAll();
	
	void deleteAnnouncement(Integer announcementId);
}
