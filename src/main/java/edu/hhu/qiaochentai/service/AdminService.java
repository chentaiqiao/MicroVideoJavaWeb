package edu.hhu.qiaochentai.service;

import edu.hhu.qiaochentai.entity.Admin;

public interface AdminService {
    Admin login(String account, String password);
}
