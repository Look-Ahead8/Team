package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.Award;
import com.team.dao.AwardMapper;

@Service
public class AwardService {

	@Autowired
	private AwardMapper awardMapper;
	
	public void saveAward(Award award) {
		awardMapper.insertSelective(award);
	}
	
	public void deleteAward(Integer awardId) {
		awardMapper.deleteByPrimaryKey(awardId);
	}
	
	public List<Award> selectAll() {
		return awardMapper.selectAll();
	}
	
	public void updateAward(Award award) {
		awardMapper.updateByPrimaryKey(award);
	}
	
	public Award selectOneAward(Award award) {
		return awardMapper.selectOne(award.getAwardId());
	}
}
