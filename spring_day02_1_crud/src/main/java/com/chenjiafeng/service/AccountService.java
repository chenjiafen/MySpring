package com.chenjiafeng.service;

import com.chenjiafeng.domian.Account;

import java.util.List;

/**
 * @author tyler.chen
 * @date 2019/12/5 23:04
 */
public interface AccountService {

    /**
     * 查询全部
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据id查询
     * @return
     */
    public Account findById(Integer id);


    /**
     *保存账户
     * @param account
     */
    public void save(Account account);

    /**
     * 更新账户
     * @param account
     */
    public void update(Account account);


    /**
     * 根据id删除
     * @param id
     */

    public void del(Integer id);
}
