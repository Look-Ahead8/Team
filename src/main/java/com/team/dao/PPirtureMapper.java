package com.team.dao;

import com.team.bean.PPirture;
import com.team.bean.PPirtureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PPirtureMapper {
    long countByExample(PPirtureExample example);

    int deleteByExample(PPirtureExample example);

    int deleteByPrimaryKey(Integer ppId);

    int deleteByProjectId(Integer projectId);
    
    int insert(PPirture record);

    int insertSelective(PPirture record);

    List<PPirture> selectByExample(PPirtureExample example);

    PPirture selectByPrimaryKey(Integer ppId);

    List<PPirture> selectImgPath(Integer projectId);
    
    int updateByExampleSelective(@Param("record") PPirture record, @Param("example") PPirtureExample example);

    int updateByExample(@Param("record") PPirture record, @Param("example") PPirtureExample example);

    int updateByPrimaryKeySelective(PPirture record);

    int updateByPrimaryKey(PPirture record);
}