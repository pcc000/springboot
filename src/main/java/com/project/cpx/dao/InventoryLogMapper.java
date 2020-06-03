package com.project.cpx.dao;

import com.project.cpx.entity.InventoryLog;

public interface InventoryLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InventoryLog record);

    int insertSelective(InventoryLog record);

    InventoryLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InventoryLog record);

    int updateByPrimaryKey(InventoryLog record);
}