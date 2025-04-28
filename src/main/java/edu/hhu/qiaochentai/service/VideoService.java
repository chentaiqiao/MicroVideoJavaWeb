package edu.hhu.qiaochentai.service;
import edu.hhu.qiaochentai.entity.Video;

import java.util.List;

public interface VideoService {

    void add(Video video);

    void remove(int id);

    Video queryById(int id);

    void modify(Video video);

    List<Video> queryAll();
}
