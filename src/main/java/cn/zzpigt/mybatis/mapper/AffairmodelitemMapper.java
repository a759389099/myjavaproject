package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.Affairmodelitem;
import cn.zzpigt.bean.AffairmodelitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AffairmodelitemMapper {
    int countByExample(AffairmodelitemExample example);

    int deleteByExample(AffairmodelitemExample example);

    int deleteByPrimaryKey(Integer modelitemid);

    int insert(Affairmodelitem record);

    int insertSelective(Affairmodelitem record);

    List<Affairmodelitem> selectByExample(AffairmodelitemExample example);

    Affairmodelitem selectByPrimaryKey(Integer modelitemid);

    int updateByExampleSelective(@Param("record") Affairmodelitem record, @Param("example") AffairmodelitemExample example);

    int updateByExample(@Param("record") Affairmodelitem record, @Param("example") AffairmodelitemExample example);

    int updateByPrimaryKeySelective(Affairmodelitem record);

    int updateByPrimaryKey(Affairmodelitem record);
}