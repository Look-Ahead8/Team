package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.Member;
import com.team.dao.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public void saveMember(Member member) {
		memberMapper.insertSelective(member);
	}
	
	public void updateMember(Member member) {
		memberMapper.updateByPrimaryKeySelective(member);
	}
	
	public List<Member> selectMember(){
		return memberMapper.selectAll();
	}
	
	public Member selectOneMember(Integer mId) {
		return memberMapper.selectByPrimaryKey(mId);
	}
}
