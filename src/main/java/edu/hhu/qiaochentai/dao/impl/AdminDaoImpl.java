package edu.hhu.qiaochentai.dao.impl;

import edu.hhu.qiaochentai.dao.AdminDao;
import edu.hhu.qiaochentai.entity.Admin;
import edu.hhu.qiaochentai.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class AdminDaoImpl implements AdminDao {
    private QueryRunner queryRunner =new QueryRunner(JDBCUtil.getDruidDataSource());
    @Override
    public Admin selectByAccountAndPassword(String account, String password){
        String sql=" select id,name,account,password "+
                " from t_admin " +
                " where account=? and password =? ; ";
        Admin admin=null;
        try {
            admin=queryRunner.query(sql,new BeanHandler<>(Admin.class),account,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
}
