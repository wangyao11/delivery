package com.wangyao.company.delivery.dao.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import com.wangyao.company.delivery.form.UserForm;
import com.wangyao.company.delivery.model.User;

import java.util.List;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    List<User> getByAll(User user);

    int countByAccount(@Param("account")String account);

	int countByName(@Param("name")String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> listByForm(UserForm userForm);

    int countByForm(UserForm userForm);

    User getByAccountAndPassword(@Param("account")String account,@Param("password")String password);
}