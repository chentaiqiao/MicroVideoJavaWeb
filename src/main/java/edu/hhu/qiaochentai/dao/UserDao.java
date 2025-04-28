package edu.hhu.qiaochentai.dao;

import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.entity.Video;

import java.util.List;

public interface UserDao {
    List<User> selectAll();

    void deleteById(int id);

    User selectById(int id);

    void update(User user);

    void insert(User user);

    User selectByAccountAndPassword(String account, String password);
}
