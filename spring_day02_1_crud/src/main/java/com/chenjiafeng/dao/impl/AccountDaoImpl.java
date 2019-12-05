package com.chenjiafeng.dao.impl;

import com.chenjiafeng.dao.AccountDao;
import com.chenjiafeng.domian.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author tyler.chen
 * @date 2019/12/5 23:12
 */

/**
 * dbutil 操作数据库
 * 入口：QueryRunnerd对象
 */
public class AccountDaoImpl implements AccountDao {

    public AccountDaoImpl() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springtest");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setUser("root");
        dataSource.setPassword("root");
        queryRunner = new QueryRunner(dataSource);
    }


    QueryRunner queryRunner;

    /**
     * 查询账户所有信息
     *
     * @return
     */
    public List<Account> findAll() {


        String sql = "select * from account";
        try {
            List<Account> accountList = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 根据id查询账户
     *
     * @param id
     * @return
     */

    public Account findById(Integer id) {

        String sql = "select * from account where id=?";
        try {
            Account account = queryRunner.query(sql, new BeanHandler<Account>(Account.class), id);
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增账户信息
     *
     * @param account
     */
    public void save(Account account) {

        String sql = "insert into account values (null,?,?)";
        try {
            queryRunner.update(sql, account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 更新账户信息
     *
     * @param account
     */
    public void update(Account account) {
        String sql = "update account set name=? ,money=? where id=?";
        try {
            queryRunner.update(sql,account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除账户信息
     *
     * @param id
     */
    public void del(Integer id) {
        String sql="delete from account where id=?";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
