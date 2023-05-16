package com.xuzheng.accountservice.service.impl;

import com.xuzheng.accountservice.common.Response;
import com.xuzheng.accountservice.mapper.AccountMapper;
import com.xuzheng.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Janice
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public Response<String> debit(String userId, Integer money) {
        log.info(("开始扣款..."));
        try{
            accountMapper.debit(userId,money);
        }catch (Exception e){
            log.info("扣款失败...");
           throw new RuntimeException("余额不足");
        }
        log.info("扣款成功...");

        return new Response<String>(200,"扣款成功",null);
    }
}
