package com.xuzheng.accountservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuzheng.accountservice.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author Janice
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    @Update("update account_tbl set money = money - ${money} where user_id = #{userId}")
    int debit(@Param("userId") String userId, @Param("money") int money);
}
