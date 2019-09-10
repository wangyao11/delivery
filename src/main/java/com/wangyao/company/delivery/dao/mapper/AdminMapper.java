package com.wangyao.company.delivery.dao.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.wangyao.company.delivery.model.Admin;

/**
 * @author wy
 * @date 2019/9/4 0004
 * @description:
 */
public interface AdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin getByAccountAndPassword(@Param("account")String account,@Param("password")String password);

}