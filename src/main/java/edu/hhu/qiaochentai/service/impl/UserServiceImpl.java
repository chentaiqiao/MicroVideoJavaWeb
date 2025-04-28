package edu.hhu.qiaochentai.service.impl;


import edu.hhu.qiaochentai.dao.impl.UserDaoImpl;

import edu.hhu.qiaochentai.entity.User;
import edu.hhu.qiaochentai.service.UserService;

import java.util.List;
import edu.hhu.qiaochentai.dao.UserDao;


import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public void add(User user) {
        userDao.insert(user);
    }

    @Override
    public void remove(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User queryById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public void modify(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> queryAll() {
        return userDao.selectAll();
    }

    @Override
    public User login(String account, String password) {
        return userDao.selectByAccountAndPassword(account, password);
    }
}
