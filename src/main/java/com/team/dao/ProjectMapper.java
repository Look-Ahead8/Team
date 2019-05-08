package com.team.dao;

import com.team.bean.Project;
import com.team.bean.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    long countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(Project record);

    int insertSelective(Project record);

    int selectprojectId();
    
    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Integer projectId);

    List<Project> selectAll();
    
    Project selectOne(Integer projectId);
    
    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}