package edu.hhu.qiaochentai.dao;


import edu.hhu.qiaochentai.entity.WatchVideo;

import java.util.List;

public interface WatchVideoDao {
     List<WatchVideo> selectAll();


     void deleteById(int id);
}
