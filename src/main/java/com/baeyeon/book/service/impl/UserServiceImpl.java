package com.baeyeon.book.service.impl;

import com.baeyeon.book.dao.UserDao;
import com.baeyeon.book.dao.impl.UserDaoImpl;
import com.baeyeon.book.pojo.User;
import com.baeyeon.book.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {

        if (userDao.queryUserByUsername(username) == null){
            //等于null，说明没查到，表示可用
            return false;
        }
        return true;
    }
}
