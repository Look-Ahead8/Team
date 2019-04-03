package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.Announcement;
import com.team.dao.AnnouncementMapper;

@Service
public class AnnouncementService {
	@Autowired
	private AnnouncementMapper announcementMapper;

	public void saveAnnouncement(Announcement announcement) {
		announcementMapper.insertSelecetive(announcement);
	}
	
	public Announcement selectAnnouncementNew() {
		return announcementMapper.selectnew();
	}
	 
	public List<Announcement> selectAll(){
		return announcementMapper.selectAll();
	}
	
	public void deleteAnnouncement(Announcement announcement) {
		announcementMapper.deleteAnnouncement(announcement.getAnnouncementId());
	}

}
