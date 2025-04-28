package edu.hhu.qiaochentai.service.impl;

import edu.hhu.qiaochentai.dao.WatchVideoDao;
import edu.hhu.qiaochentai.dao.impl.WatchVideoDaoImpl;
import edu.hhu.qiaochentai.entity.Video;
import edu.hhu.qiaochentai.entity.WatchVideo;
import edu.hhu.qiaochentai.service.WatchVideoService;
import java.util.List;

public class WatchVideoServiceImpl implements WatchVideoService {
    private WatchVideoDao watchVideoDao=new WatchVideoDaoImpl();


    @Override
    public void remove(int id) {
        watchVideoDao.deleteById(id);
    }

    @Override
    public List<WatchVideo> queryAll() {

        return watchVideoDao.selectAll();
    }
}
