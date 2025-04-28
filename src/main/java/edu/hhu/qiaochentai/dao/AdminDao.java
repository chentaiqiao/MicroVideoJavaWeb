package edu.hhu.qiaochentai.dao;

import edu.hhu.qiaochentai.entity.Admin;

public interface AdminDao {
    Admin selectByAccountAndPassword(String account, String password);
}
