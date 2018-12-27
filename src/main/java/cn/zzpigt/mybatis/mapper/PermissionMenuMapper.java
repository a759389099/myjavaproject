package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.PermissionMenu;
import cn.zzpigt.bean.PermissionMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMenuMapper {
    int countByExample(PermissionMenuExample example);

    int deleteByExample(PermissionMenuExample example);

    int insert(PermissionMenu record);

    int insertSelective(PermissionMenu record);

    List<PermissionMenu> selectByExample(PermissionMenuExample example);

    int updateByExampleSelective(@Param("record") PermissionMenu record, @Param("example") PermissionMenuExample example);

    int updateByExample(@Param("record") PermissionMenu record, @Param("example") PermissionMenuExample example);
}