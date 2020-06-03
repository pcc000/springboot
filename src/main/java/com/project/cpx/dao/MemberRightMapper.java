package com.project.cpx.dao;

import com.project.cpx.entity.MemberRight;

public interface MemberRightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberRight record);

    int insertSelective(MemberRight record);

    MemberRight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberRight record);

    int updateByPrimaryKey(MemberRight record);
}