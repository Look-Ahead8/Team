package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.Resume;
import com.team.dao.ResumeMapper;
@Service
public class ResumeService{
	@Autowired
	private ResumeMapper resumeMapper;
	
	public void saveResume(Resume resume) {
		resumeMapper.insertSelective(resume);
	}
	
	public List<Resume> selectResume() {
		List<Resume> list=resumeMapper.selectByExample(null);
		return list;
	}
	
	public Resume selectOneResume(Integer resumeId) {
		return resumeMapper.selectByPrimaryKey(resumeId);
	}
	
	public void deleteResume(Integer resumeId) {
		resumeMapper.deleteByPrimaryKey(resumeId);
	}
}