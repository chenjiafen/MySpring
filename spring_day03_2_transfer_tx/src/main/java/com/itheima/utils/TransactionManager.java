package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务管理器
 * @author 黑马程序员
 * @Company http://www.ithiema.com *
 * @Version 1.0
 */
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtil connectionUtil;

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    //开启事务
    public void beginTransaction() {
        //从当前线程上获取连接，实现开启事务
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public void commit() {
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //回滚事务
    public void rollback() {
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //释放连接
    public void release() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(true);
            //关闭连接（还回池中）
            connectionUtil.getThreadConnection().close();
            //解绑线程：把连接和线程解绑
            connectionUtil.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
