package com.songshu.snt.stwms.core.dao;

import com.songshu.snt.stwms.core.DO.ReplenishRecord;

public interface ReplenishRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ReplenishRecord record);

    int insertSelective(ReplenishRecord record);

    ReplenishRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ReplenishRecord record);

    int updateByPrimaryKey(ReplenishRecord record);
}