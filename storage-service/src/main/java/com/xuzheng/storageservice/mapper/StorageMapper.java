package com.xuzheng.storageservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuzheng.storageservice.pojo.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author janice
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    /**
     * @param commodityCode
     * @param count
     * @return
     */
    @Update("update storage_tbl set `count` = `count` - #{count} where commodity_code = #{code}")
    int deduct(@Param("code") String commodityCode, @Param("count") int count);
}
