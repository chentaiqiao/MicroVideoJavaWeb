package edu.hhu.qiaochentai.dao.impl;

import edu.hhu.qiaochentai.dao.VideoDao;

import edu.hhu.qiaochentai.entity.Video;
import edu.hhu.qiaochentai.entity.WatchVideo;
import edu.hhu.qiaochentai.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class VideoDaoImpl implements VideoDao {

    QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDruidDataSource());
    @Override
    public List<Video> selectAll() {

        String sql=" select id,name,author,type,create_time as createTime,time_length as timeLength,video_path as videoPath,cover_path as coverPath,description from t_video; ";
        List<Video> videoList=null;
        try {
            videoList=queryRunner.query(sql,new BeanListHandler<>(Video.class));
            System.out.println(videoList);
        } catch (SQLException e) {
            System.out.println("can not find shuju");
            e.printStackTrace();
        }
        return videoList;




    }

    @Override
    public void deleteById(int id) {
        String sql=" delete from t_video where id=?; ";

        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Video selectById(int id) {
        String sql=" select id,name,author,type,create_time as createTime,time_length as timeLength,video_path as videoPath,cover_path as coverPath,description from t_video "+
                   " where id=?; ";
        Video video=null;
        try {
            video = queryRunner.query(sql,new BeanHandler<>(Video.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return video;
    }

    @Override
    public void update(Video video) {
        String sql=" update t_video set name=?,author=?,type=?,create_time=?,time_length=?,description=? "+
                " where id=? ";
        Object[] paramArray = new Object[]{
                video.getName(),video.getAuthor(),video.getType(),video.getCreateTime(),
                video.getTimeLength(),video.getDescription(),video.getId()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insert(Video video) {
        String sql=" insert into t_video (name,author,type,create_time,time_length,video_path,cover_path,description) "+
                " values(?,?,?,?,?,?,?,?) ";
        Object[] paramArray = new Object[]{
                video.getName(),video.getAuthor(),video.getType(),video.getCreateTime(),
                video.getTimeLength(),video.getVideoPath(),video.getCoverPath(),video.getDescription()
        };
        try {
            queryRunner.update(sql,paramArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
