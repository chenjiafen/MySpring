package com.itheima.service.impl;

import com.itheima.dao.AcountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author tyler.chen
 * @date 2019/12/12 22:27
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AcountDao acountDao;

    @Override
    public void transfer(String fromName, String toName, Float money) {


        //1、要查询转出的账户
        Account fromAccount = acountDao.findByName(fromName);


        //2、查询转入的账户
        Account toAccout = acountDao.findByName(toName);


        //3、修改要转出的账户余额:假设余额充足
        fromAccount.setMoney(fromAccount.getMoney() - money);


        //4、修改要转入的账户余额
        toAccout.setMoney(toAccout.getMoney() + money);


        //5、持久化到数据库
        acountDao.update(fromAccount);

        acountDao.update(toAccout);
    }
}
