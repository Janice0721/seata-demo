package com.xuzheng.storageservice.service.impl;

import com.xuzheng.storageservice.common.Response;
import com.xuzheng.storageservice.mapper.StorageMapper;
import com.xuzheng.storageservice.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author janice
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Transactional
    @Override
    public Response<String> deduct(String commodityCode, int count) {
        log.info("开始扣减库存");
        try {
            storageMapper.deduct(commodityCode, count);
        } catch (Exception e) {
            log.info("扣减库存失败");
            throw new RuntimeException("库存不足");
        }
        log.info("扣减库存成功");
        return new Response<>(200,"扣库存成功",null);
    }
}
