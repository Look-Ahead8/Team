package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.Project;
import com.team.dao.ProjectMapper;

@Service
public class ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	public void saveProject(Project project) {
		projectMapper.insertSelective(project);
	}
	public int getprojectId() {
		return projectMapper.selectprojectId();
	}
	public void deleteProject(Integer projectId) {
		projectMapper.deleteByPrimaryKey(projectId);
	}
	
	public List<Project> selectAll() {
		return projectMapper.selectAll();
	}
	
	public Project selectOne(Project project) {
		return projectMapper.selectOne(project.getProjectId());
	}
	
	public void updateProject(Project project) {
		projectMapper.updateByPrimaryKeySelective(project);
	}
}
