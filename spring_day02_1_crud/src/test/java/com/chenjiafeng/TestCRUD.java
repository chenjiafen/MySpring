package com.chenjiafeng;

import com.chenjiafeng.domian.Account;
import com.chenjiafeng.service.AccountService;
import com.chenjiafeng.service.impl.AccountServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author tyler.chen
 * @date 2019/12/5 23:52
 */
public class TestCRUD {

    @Test
    public void test01(){
        AccountService accountService=new AccountServiceImpl();
        List<Account> accountList= accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }

    }

    @Test
    public void test02(){
        AccountService accountService=new AccountServiceImpl();
        Account account= accountService.findById(1);

            System.out.println(account);
    }

    @Test
    public void test03(){
        Account account=new Account();
        account.setName("ddd");
        account.setMoney(111F);
        AccountService accountService=new AccountServiceImpl();
        accountService.save(account);


    }
    @Test
    public void test04(){
        Account account=new Account();
        account.setId(4);
        account.setName("eee");
        account.setMoney(122F);
        AccountService accountService=new AccountServiceImpl();
        accountService.update(account);


    }

    @Test
    public void test05(){

        AccountService accountService=new AccountServiceImpl();
        accountService.del(4);


    }
}
