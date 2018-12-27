package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.Affairmodel;
import cn.zzpigt.bean.AffairmodelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AffairmodelMapper {
    int countByExample(AffairmodelExample example);

    int deleteByExample(AffairmodelExample example);

    int deleteByPrimaryKey(Integer affairmodelid);

    int insert(Affairmodel record);

    int insertSelective(Affairmodel record);

    List<Affairmodel> selectByExample(AffairmodelExample example);

    Affairmodel selectByPrimaryKey(Integer affairmodelid);

    int updateByExampleSelective(@Param("record") Affairmodel record, @Param("example") AffairmodelExample example);

    int updateByExample(@Param("record") Affairmodel record, @Param("example") AffairmodelExample example);

    int updateByPrimaryKeySelective(Affairmodel record);

    int updateByPrimaryKey(Affairmodel record);
}