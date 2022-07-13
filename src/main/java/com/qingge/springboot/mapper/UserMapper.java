package com.qingge.springboot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.controller.dto.UserDTO;
import com.qingge.springboot.controller.dto.UserPasswordDTO;
import com.qingge.springboot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2022-01-26
 */
public interface UserMapper extends BaseMapper<User> {

    @Update("update sys_user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);

    Page<User> findPage(Page<User> page, @Param("username") String username, @Param("email") String email, @Param("address") String address);

    Page<User> findEmployee(Page<User> page, @Param("username")String username,  @Param("email")String email, @Param("phone")String phone);


    @Update("update  sys_user set state =2 where id=#{id}")
    int leaveDo(Integer id);
    @Update("update  sys_user set state =0 where id=#{id}")
    void cancelLeave(Integer id);
    @Update("update  sys_user set state =1 where id=#{id}")
    void addLeave(Integer id);
}
