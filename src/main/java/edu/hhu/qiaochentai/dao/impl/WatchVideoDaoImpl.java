package edu.hhu.qiaochentai.dao.impl;


import edu.hhu.qiaochentai.dao.WatchVideoDao;

import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.entity.WatchVideo;
import edu.hhu.qiaochentai.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class WatchVideoDaoImpl implements WatchVideoDao {

    QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDruidDataSource());
    @Override
    public List<WatchVideo> selectAll() {

        String sql=" select t_watch.id as id,user_id,video_id,nick_name as user_name,name as video_name  from  t_watch,t_video,t_user  where t_watch.user_id=t_user.id and t_watch.video_id=t_video.id; ";
        //String sql=" select id,user_id,video_id from t_watch; ";
        List<WatchVideo> watchList=null;

        try {
            watchList= queryRunner.query(sql,new BeanListHandler<>(WatchVideo.class));
            System.out.println(watchList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return watchList;








    }

    @Override
    public void deleteById(int id) {
        String sql=" delete from t_watch where user_id=?; ";

        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
