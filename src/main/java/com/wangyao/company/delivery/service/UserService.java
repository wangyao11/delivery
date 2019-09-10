package com.wangyao.company.delivery.service;

import com.wangyao.company.delivery.dao.UserDao;
import com.wangyao.company.delivery.form.UserForm;
import com.wangyao.company.delivery.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> list(UserForm userForm) {
        return userDao.listByForm(userForm);
    }

    public int counts(UserForm userForm) {
        return userDao.countByForm(userForm);
    }

    public int countByName(String name) {
        return userDao.countByName(name);
    }

    public int countByAccount(String account) {
        return userDao.countByAccount(account);
    }

    public int add(User user){
        return userDao.insert(user);
    }
}
