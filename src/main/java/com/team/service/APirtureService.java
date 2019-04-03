package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.APirture;
import com.team.dao.APirtureMapper;

@Service
public class APirtureService {

	@Autowired
	private APirtureMapper aPirtureMapper;
	
	public void saveAPirture(APirture aPirture) {
		aPirtureMapper.insertSelective(aPirture);
	}
	
	public List<APirture> selectImaPath(Integer awardId){
		return aPirtureMapper.selectImgPath(awardId);
	}
	
	public void deleteAPirture(Integer awardId) {
		aPirtureMapper.deleteByAwardId(awardId);
	}
}
