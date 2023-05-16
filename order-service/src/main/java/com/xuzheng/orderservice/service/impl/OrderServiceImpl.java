package com.xuzheng.orderservice.service.impl;


import com.xuzheng.orderservice.client.AccountClient;
import com.xuzheng.orderservice.client.StorageClient;
import com.xuzheng.orderservice.mapper.OrderMapper;
import com.xuzheng.orderservice.pojo.Order;
import com.xuzheng.orderservice.service.OrderService;
import feign.FeignException;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author janice
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private  AccountClient accountClient;
    @Autowired
    private  StorageClient storageClient;
    @Autowired
    private  OrderMapper orderMapper;

    @Override
    @GlobalTransactional
    public Long create(Order order) {
        // 创建订单
        orderMapper.insert(order);
        try {
            // 扣库存
            storageClient.deduct(order.getCommodityCode(), order.getCount());
            // 扣款
            accountClient.debit(order.getUserId(), order.getMoney());
        } catch (FeignException e) {
            log.error("下单失败，原因:{}", e.contentUTF8());
            throw new RuntimeException(e.contentUTF8());
        }
        return order.getId();
    }
}
