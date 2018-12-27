package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.Attendduty;
import cn.zzpigt.bean.AttenddutyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttenddutyMapper {
    int countByExample(AttenddutyExample example);

    int deleteByExample(AttenddutyExample example);

    int insert(Attendduty record);

    int insertSelective(Attendduty record);

    List<Attendduty> selectByExample(AttenddutyExample example);

    int updateByExampleSelective(@Param("record") Attendduty record, @Param("example") AttenddutyExample example);

    int updateByExample(@Param("record") Attendduty record, @Param("example") AttenddutyExample example);
}