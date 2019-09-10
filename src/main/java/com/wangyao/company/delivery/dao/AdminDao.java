package com.wangyao.company.delivery.dao;

import com.wangyao.company.delivery.model.Admin;
import com.wangyao.company.delivery.dao.mapper.AdminMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
@Repository
public class AdminDao {

    @Resource
    private AdminMapper adminMapper;


    public int deleteByPrimaryKey(Long id) {
        return adminMapper.deleteByPrimaryKey(id);
    }


    public int insert(Admin record) {
        return adminMapper.insert(record);
    }


    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }


    public Admin selectByPrimaryKey(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    public Admin getByAccountAndPassword(String account,String password) {
        return adminMapper.getByAccountAndPassword(account, password);
    }
}

