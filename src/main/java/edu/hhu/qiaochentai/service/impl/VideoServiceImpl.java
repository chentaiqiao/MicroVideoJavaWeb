package edu.hhu.qiaochentai.service.impl;

import edu.hhu.qiaochentai.dao.VideoDao;
import edu.hhu.qiaochentai.dao.impl.VideoDaoImpl;
import edu.hhu.qiaochentai.entity.Video;
import edu.hhu.qiaochentai.service.VideoService;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    private VideoDao videoDao=new VideoDaoImpl();

    @Override
    public void add(Video video) {
        videoDao.insert(video);

    }

    @Override
    public void remove(int id) {
        videoDao.deleteById(id);
    }

    @Override
    public Video queryById(int id) {
        return videoDao.selectById(id);
    }

    @Override
    public void modify(Video video) {
        videoDao.update(video);
    }

    @Override
    public List<Video> queryAll() {

        return videoDao.selectAll();
    }
}
