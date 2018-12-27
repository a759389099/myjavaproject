package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.PermissionOperate;
import cn.zzpigt.bean.PermissionOperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionOperateMapper {
    int countByExample(PermissionOperateExample example);

    int deleteByExample(PermissionOperateExample example);

    int insert(PermissionOperate record);

    int insertSelective(PermissionOperate record);

    List<PermissionOperate> selectByExample(PermissionOperateExample example);

    int updateByExampleSelective(@Param("record") PermissionOperate record, @Param("example") PermissionOperateExample example);

    int updateByExample(@Param("record") PermissionOperate record, @Param("example") PermissionOperateExample example);
}