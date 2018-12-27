package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.UserAttend;
import cn.zzpigt.bean.UserAttendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAttendMapper {
    int countByExample(UserAttendExample example);

    int deleteByExample(UserAttendExample example);

    int insert(UserAttend record);

    int insertSelective(UserAttend record);

    List<UserAttend> selectByExample(UserAttendExample example);

    int updateByExampleSelective(@Param("record") UserAttend record, @Param("example") UserAttendExample example);

    int updateByExample(@Param("record") UserAttend record, @Param("example") UserAttendExample example);
}