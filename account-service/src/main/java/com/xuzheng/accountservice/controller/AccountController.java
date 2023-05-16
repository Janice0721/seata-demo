package com.xuzheng.accountservice.controller;

import com.xuzheng.accountservice.common.Response;
import com.xuzheng.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jancie
 */
@RestController
@RequestMapping("account")
public class AccountController {

   @Autowired
   private AccountService accountService;

    @PutMapping("/{userId}/{money}")
    public Response<String> debit(@PathVariable("userId") String userId, @PathVariable("money") Integer money){
        Response<String> response= accountService.debit(userId, money);
        return response;
    }
}
