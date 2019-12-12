package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * @author tyler.chen
 * @date 2019/12/12 22:41
 */
public interface AcountDao {
    /**
     * 根据账户名查找账户
     * @param fromName
     * @return
     */
    Account findByName(String fromName);

    /**
     * 更新账户
     * @param fromAccount
     */
    void update(Account fromAccount);
}
