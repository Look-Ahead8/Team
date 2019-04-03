package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.Life;
import com.team.bean.Member;
import com.team.dao.LifeMapper;

@Service
public class LifeService {
	@Autowired
	private LifeMapper lifeMapper;

	public int saveLife(Life life) {
		return lifeMapper.insertSelective(life);
	}
	public void deleteLife(Integer lifeId) {
		lifeMapper.deleteByPrimaryKey(lifeId);
	}
	public int selectBymId(Member member){
		List<Life> list=lifeMapper.selectBymId(member.getmId());
		return list.get(0).getLifeId();
	}
	public List<Life> selectAll(){
		List<Life> list =lifeMapper.selectAll();
		return list;
	}
	public void updateLife(Life life) {
		lifeMapper.updateByPrimaryKeySelective(life);
	}
	public Life selectOne(Life life) {
		return lifeMapper.selectOne(life.getLifeId());
	}
	/*
	 * 判断生活内容是否为空，为空返回true
	 */
	public boolean checkmessage(Life life) {
		if("".equals(life.getContext())) {
			return true;
		}
		else {
			return false;
		}
	}
}
