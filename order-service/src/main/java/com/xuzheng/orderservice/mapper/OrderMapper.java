package com.xuzheng.orderservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuzheng.orderservice.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author janice
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
