package com.xuzheng.orderservice.controller;


import com.xuzheng.orderservice.pojo.Order;
import com.xuzheng.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author janice
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private  OrderService orderService;


    @PostMapping
    public ResponseEntity<Long> createOrder(Order order){
        Long orderId = orderService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }
}
