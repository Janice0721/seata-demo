package com.xuzheng.accountservice.service;

import com.xuzheng.accountservice.common.Response;
import org.springframework.stereotype.Service;

/**
 * @author Janice
 */
@Service
public interface AccountService {
    public Response<String> debit(String userId, Integer money);

}
