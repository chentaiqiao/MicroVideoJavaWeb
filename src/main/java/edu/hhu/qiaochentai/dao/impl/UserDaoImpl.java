package edu.hhu.qiaochentai.dao.impl;

import edu.hhu.qiaochentai.dao.UserDao;

import edu.hhu.qiaochentai.entity.Admin;
import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.entity.Video;
import edu.hhu.qiaochentai.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDruidDataSource());
    @Override
    public List<User> selectAll() {
        String sql=" select * from t_user; ";
        List<User> userList=null;
        try {
            userList=queryRunner.query(sql,new BeanListHandler<>(User.class));
            System.out.println(userList);
        } catch (SQLException e) {
            System.out.println("can not find shuju");
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void deleteById(int id) {
        String sql=" delete from t_user where id=?; ";

        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectById(int id) {
        String sql=" select * from t_user "+
                " where id=?; ";
        User user=null;
        try {
            user = queryRunner.query(sql,new BeanHandler<>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {

        String sql=" update t_user set nick_name=?,account=?,password=?,gender=?,birthday=?,phone=?,email=?,birthplace=?,description=? "+
                " where id=? ";
        Object[] paramArray = new Object[]{
                user.getNick_name(),user.getAccount(),user.getPassword(),user.getGender(),
                user.getBirthday(),user.getPhone(),user.getEmail(),user.getBirthplace(),
                user.getDescription(), user.getId()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void insert(User user) {

        String sql=" insert into t_user (nick_name,account,password,gender,birthday,phone,email,birthplace,head_pic,description) "+
                " values(?,?,?,?,?,?,?,?,?,?) ";
        Object[] paramArray = new Object[]{
                user.getNick_name(),user.getAccount(),user.getPassword(),user.getGender(),
                user.getBirthday(),user.getPhone(),user.getEmail(),user.getBirthplace(),
                user.getHead_pic(),user.getDescription(),
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User selectByAccountAndPassword(String account, String password) {
        String sql=" select * "+
                " from t_user " +
                " where account=? and password =? ; ";
        User user=null;
        try {
            user=queryRunner.query(sql,new BeanHandler<>(User.class),account,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
