package com.xuzheng.storageservice.service;

import com.xuzheng.storageservice.common.Response;
import org.springframework.stereotype.Service;

/**
 * @author Janice
 */
public interface StorageService{

    /**
     * 扣除存储数量
     */
    Response<String> deduct(String commodityCode, int count);
}