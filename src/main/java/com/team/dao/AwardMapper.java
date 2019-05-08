package com.team.dao;

import com.team.bean.Award;
import com.team.bean.AwardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwardMapper {
    long countByExample(AwardExample example);

    int deleteByExample(AwardExample example);

    int deleteByPrimaryKey(Integer awardId);

    int insert(Award record);

    int insertSelective(Award record);

    List<Award> selectByExample(AwardExample example);

    Award selectByPrimaryKey(Integer awardId);

    List<Award> selectAll();
    
    Award selectOne(Integer awardId);
    
    int updateByExampleSelective(@Param("record") Award record, @Param("example") AwardExample example);

    int updateByExample(@Param("record") Award record, @Param("example") AwardExample example);

    int updateByPrimaryKeySelective(Award record);

    int updateByPrimaryKey(Award record);

	int selectawardId();
}