package com.songshu.snt.stwms.core.dao;

import com.songshu.snt.stwms.core.DO.sku;
import com.songshu.snt.stwms.core.DO.skuWithBLOBs;

public interface skuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(skuWithBLOBs record);

    int insertSelective(skuWithBLOBs record);

    skuWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(skuWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(skuWithBLOBs record);

    int updateByPrimaryKey(sku record);
}