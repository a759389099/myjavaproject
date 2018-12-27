package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.Attendconfig;
import cn.zzpigt.bean.AttendconfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendconfigMapper {
    int countByExample(AttendconfigExample example);

    int deleteByExample(AttendconfigExample example);

    int deleteByPrimaryKey(Integer dutytype);

    int insert(Attendconfig record);

    int insertSelective(Attendconfig record);

    List<Attendconfig> selectByExample(AttendconfigExample example);

    Attendconfig selectByPrimaryKey(Integer dutytype);

    int updateByExampleSelective(@Param("record") Attendconfig record, @Param("example") AttendconfigExample example);

    int updateByExample(@Param("record") Attendconfig record, @Param("example") AttendconfigExample example);

    int updateByPrimaryKeySelective(Attendconfig record);

    int updateByPrimaryKey(Attendconfig record);
}