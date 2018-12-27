package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.Operate;
import cn.zzpigt.bean.OperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateMapper {
    int countByExample(OperateExample example);

    int deleteByExample(OperateExample example);

    int deleteByPrimaryKey(Integer operateid);

    int insert(Operate record);

    int insertSelective(Operate record);

    List<Operate> selectByExample(OperateExample example);

    Operate selectByPrimaryKey(Integer operateid);

    int updateByExampleSelective(@Param("record") Operate record, @Param("example") OperateExample example);

    int updateByExample(@Param("record") Operate record, @Param("example") OperateExample example);

    int updateByPrimaryKeySelective(Operate record);

    int updateByPrimaryKey(Operate record);
}