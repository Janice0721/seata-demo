package com.xuzheng.storageservice.controller;

import com.xuzheng.storageservice.common.Response;
import com.xuzheng.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author janice
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    @Autowired
    private StorageService storageService;


    /**
     * 扣减库存
     * @param code 商品编号
     * @param count 要扣减的数量
     * @return 无
     */
    @PutMapping("/{code}/{count}")
    public Response<String> deduct(@PathVariable("code") String code, @PathVariable("count") Integer count){
        Response<String> response = storageService.deduct(code, count);
        return response;
    }
}
