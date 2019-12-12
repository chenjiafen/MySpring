package com.itheima.service;

/**
 * @author tyler.chen
 * @date 2019/12/12 22:18
 */
public interface AccountService {
    /**
     *
     * @param fromName  从哪个账户转出
     * @param toName 转到哪个账户
     * @param money 转多少钱
     */

    public void transfer(String fromName, String toName ,Float money);
}
