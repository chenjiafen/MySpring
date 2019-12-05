package com.chenjiafeng.service.impl;

import com.chenjiafeng.dao.AccountDao;
import com.chenjiafeng.dao.impl.AccountDaoImpl;
import com.chenjiafeng.domian.Account;
import com.chenjiafeng.service.AccountService;

import java.util.List;

/**
 * @author tyler.chen
 * @date 2019/12/5 23:17
 */


public class AccountServiceImpl implements AccountService {

    AccountDao accountDao = new AccountDaoImpl();

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public void save(Account account) {
        accountDao.save(account);

    }

    public void update(Account account) {
        accountDao.update(account);

    }

    public void del(Integer id) {
        accountDao.del(id);

    }
}
