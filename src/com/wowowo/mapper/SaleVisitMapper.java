package com.wowowo.mapper;

import com.wowowo.bean.SaleVisit;
import com.wowowo.bean.SaleVisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleVisitMapper {
    int countByExample(SaleVisitExample example);

    int deleteByExample(SaleVisitExample example);

    int deleteByPrimaryKey(Long visitId);

    int insert(SaleVisit record);

    int insertSelective(SaleVisit record);

    List<SaleVisit> selectByExample(SaleVisitExample example);

    SaleVisit selectByPrimaryKey(Long visitId);

    int updateByExampleSelective(@Param("record") SaleVisit record, @Param("example") SaleVisitExample example);

    int updateByExample(@Param("record") SaleVisit record, @Param("example") SaleVisitExample example);

    int updateByPrimaryKeySelective(SaleVisit record);

    int updateByPrimaryKey(SaleVisit record);
}