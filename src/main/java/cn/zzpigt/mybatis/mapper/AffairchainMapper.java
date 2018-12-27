package cn.zzpigt.mybatis.mapper;

import cn.zzpigt.bean.Affairchain;
import cn.zzpigt.bean.AffairchainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AffairchainMapper {
    int countByExample(AffairchainExample example);

    int deleteByExample(AffairchainExample example);

    int deleteByPrimaryKey(Integer affairchainid);

    int insert(Affairchain record);

    int insertSelective(Affairchain record);

    List<Affairchain> selectByExample(AffairchainExample example);

    Affairchain selectByPrimaryKey(Integer affairchainid);

    int updateByExampleSelective(@Param("record") Affairchain record, @Param("example") AffairchainExample example);

    int updateByExample(@Param("record") Affairchain record, @Param("example") AffairchainExample example);

    int updateByPrimaryKeySelective(Affairchain record);

    int updateByPrimaryKey(Affairchain record);
}