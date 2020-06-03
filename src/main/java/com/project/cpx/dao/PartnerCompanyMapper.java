package com.project.cpx.dao;

import com.project.cpx.entity.PartnerCompany;

public interface PartnerCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PartnerCompany record);

    int insertSelective(PartnerCompany record);

    PartnerCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PartnerCompany record);

    int updateByPrimaryKey(PartnerCompany record);
}