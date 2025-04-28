package edu.hhu.qiaochentai.service.impl;

import edu.hhu.qiaochentai.dao.AdminDao;
import edu.hhu.qiaochentai.dao.impl.AdminDaoImpl;
import edu.hhu.qiaochentai.entity.Admin;
import edu.hhu.qiaochentai.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao=new AdminDaoImpl();

    @Override
    public Admin login(String account, String password) {
        return adminDao.selectByAccountAndPassword(account, password);
    }
}
