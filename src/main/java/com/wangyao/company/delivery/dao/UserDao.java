package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.form.UserForm;
import com.wangyao.company.delivery.model.User;
import com.wangyao.company.delivery.dao.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Repository
public class UserDao {

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public List<User> getByAll(User user){
        return userMapper.getByAll(user);
    }

    public int countByAccount(String account) {
        return userMapper.countByAccount(account);
    }

    public int countByName(String name) {
        return userMapper.countByName(name);
    }
    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public List<User> listByForm(UserForm userForm) {
        return userMapper.listByForm(userForm);
    }

    public int countByForm(UserForm userForm) {
        return userMapper.countByForm(userForm);
    }

    public User getByAccountAndPassword(String account, String password){
        return userMapper.getByAccountAndPassword(account, password);
    }
}
