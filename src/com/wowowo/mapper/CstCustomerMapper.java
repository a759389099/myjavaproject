package com.wowowo.mapper;

import com.wowowo.bean.CountInfo;
import com.wowowo.bean.CstCustomer;
import com.wowowo.bean.CstCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CstCustomerMapper {
    int countByExample(CstCustomerExample example);

    int deleteByExample(CstCustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(CstCustomer record);

    int insertSelective(CstCustomer record);

    List<CstCustomer> selectByExample(CstCustomerExample example);

    CstCustomer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByExample(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByPrimaryKeySelective(CstCustomer record);

    int updateByPrimaryKey(CstCustomer record);

	List<CountInfo> groupBySource();

	List<CountInfo> groupByIndustry();
}