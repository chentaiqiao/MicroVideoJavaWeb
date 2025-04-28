package edu.hhu.qiaochentai.service;

import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.entity.Video;

import java.util.List;

public interface UserService {
    void add(User user);
    void remove(int id);

    User queryById(int id);

    void modify(User user);

    List<User> queryAll();

    User login(String account, String password);
}
