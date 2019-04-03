package com.team.dao;

import com.team.bean.LPirture;
import com.team.bean.LPirtureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LPirtureMapper {
    long countByExample(LPirtureExample example);

    int deleteByExample(LPirtureExample example);

    int deleteByPrimaryKey(Integer lpId);

    int deleteByLifeId(Integer lifeId);
    
    int insert(LPirture record);

    int insertSelective(LPirture record);

    List<LPirture> selectByExample(LPirtureExample example);

    LPirture selectByPrimaryKey(Integer lpId);

    List<LPirture> selectImgPath(Integer lifeId);
    
    List<LPirture> selectALL();
    
    int updateByExampleSelective(@Param("record") LPirture record, @Param("example") LPirtureExample example);

    int updateByExample(@Param("record") LPirture record, @Param("example") LPirtureExample example);

    int updateByPrimaryKeySelective(LPirture record);

    int updateByPrimaryKey(LPirture record);
}