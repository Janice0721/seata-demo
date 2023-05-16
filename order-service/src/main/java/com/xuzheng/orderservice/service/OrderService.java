package com.xuzheng.orderservice.service;

import com.xuzheng.orderservice.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Janice
 */
public interface OrderService {

    /**
     * 创建订单
     */
    Long create(Order order);
}