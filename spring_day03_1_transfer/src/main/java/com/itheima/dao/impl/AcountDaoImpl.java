package com.itheima.dao.impl;

import com.itheima.domain.Account;
import com.itheima.dao.AcountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * 数据库持久层
 *
 * @author tyler.chen
 * @date 2019/12/12 22:46
 */

@Repository // 只要标记了，扫描了该包，对象就会创建
public class AcountDaoImpl implements AcountDao {

    @Autowired
    QueryRunner queryRunner;

    /**
     * 查用户
     *
     * @param fromName
     * @return
     */
    @Override
    public Account findByName(String fromName) {

        String sql = "select * from account where name = ?";
        try {
            return queryRunner.query(sql ,new BeanHandler<>(Account.class),fromName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新账户的钱
     *
     * @param fromAccount
     */
    @Override
    public void update(Account fromAccount) {

        String sql = "update account set money=? where name=? ";
        try {
            queryRunner.update(sql,fromAccount.getMoney(),fromAccount.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
