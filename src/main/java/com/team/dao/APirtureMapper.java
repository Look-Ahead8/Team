package com.team.dao;

import com.team.bean.APirture;
import com.team.bean.APirtureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface APirtureMapper {
    long countByExample(APirtureExample example);

    int deleteByExample(APirtureExample example);

    int deleteByPrimaryKey(Integer apId);

    void deleteByAwardId(Integer awardId);
    
    int insert(APirture record);

    int insertSelective(APirture record);

    List<APirture> selectByExample(APirtureExample example);

    List<APirture> selectImgPath(Integer awardId);
    
    APirture selectByPrimaryKey(Integer apId);

    int updateByExampleSelective(@Param("record") APirture record, @Param("example") APirtureExample example);

    int updateByExample(@Param("record") APirture record, @Param("example") APirtureExample example);

    int updateByPrimaryKeySelective(APirture record);

    int updateByPrimaryKey(APirture record);
}