package edu.hhu.qiaochentai.service;
import edu.hhu.qiaochentai.entity.WatchVideo;

import java.util.List;

public interface WatchVideoService {


    void remove(int id);

    List<WatchVideo> queryAll();
}
