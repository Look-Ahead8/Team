package com.team.dao;

import com.team.bean.Life;
import com.team.bean.LifeExample;
import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface LifeMapper {
    long countByExample(LifeExample example);

    int deleteByExample(LifeExample example);

    int deleteByPrimaryKey(Integer lifeId);

    int insert(Life record);

    int insertSelective(Life record);
    
    int insertone(Life record);
    
    int selectlifeId();

    List<Life> selectByExample(LifeExample example);

    List<Life> selectByPrimaryKey(Integer lifeId);

    List<Life> selectBymId(Integer mId);
    
    List<Life> selectAll();
    
    Life selectOne(Integer lifeId);
    
    int updateByExampleSelective(@Param("record") Life record, @Param("example") LifeExample example);

    int updateByExample(@Param("record") Life record, @Param("example") LifeExample example);

    int updateByPrimaryKeySelective(Life record);

    int updateByPrimaryKey(Life record);
}