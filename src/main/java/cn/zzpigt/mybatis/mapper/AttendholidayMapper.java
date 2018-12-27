package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.Attendholiday;
import cn.zzpigt.bean.AttendholidayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendholidayMapper {
    int countByExample(AttendholidayExample example);

    int deleteByExample(AttendholidayExample example);

    int deleteByPrimaryKey(Integer holidayid);

    int insert(Attendholiday record);

    int insertSelective(Attendholiday record);

    List<Attendholiday> selectByExample(AttendholidayExample example);

    Attendholiday selectByPrimaryKey(Integer holidayid);

    int updateByExampleSelective(@Param("record") Attendholiday record, @Param("example") AttendholidayExample example);

    int updateByExample(@Param("record") Attendholiday record, @Param("example") AttendholidayExample example);

    int updateByPrimaryKeySelective(Attendholiday record);

    int updateByPrimaryKey(Attendholiday record);
}