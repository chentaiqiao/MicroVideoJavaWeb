package edu.hhu.qiaochentai.dao;

import edu.hhu.qiaochentai.entity.Video;

import java.util.List;

public interface VideoDao {
     List<Video> selectAll();

     void deleteById(int id);

     Video selectById(int id);

     void update(Video video);

     void insert(Video video);
}
