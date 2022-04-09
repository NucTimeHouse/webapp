package cn.episooo.service;

import cn.episooo.po.User;


public interface UserService {
    public User getUser(User user);
    boolean signUp(User user);
}
