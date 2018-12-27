package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.Affair;
import cn.zzpigt.bean.AffairExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AffairMapper {
    int countByExample(AffairExample example);

    int deleteByExample(AffairExample example);

    int deleteByPrimaryKey(Integer affairid);

    int insert(Affair record);

    int insertSelective(Affair record);

    List<Affair> selectByExampleWithBLOBs(AffairExample example);

    List<Affair> selectByExample(AffairExample example);

    Affair selectByPrimaryKey(Integer affairid);

    int updateByExampleSelective(@Param("record") Affair record, @Param("example") AffairExample example);

    int updateByExampleWithBLOBs(@Param("record") Affair record, @Param("example") AffairExample example);

    int updateByExample(@Param("record") Affair record, @Param("example") AffairExample example);

    int updateByPrimaryKeySelective(Affair record);

    int updateByPrimaryKeyWithBLOBs(Affair record);

    int updateByPrimaryKey(Affair record);
}