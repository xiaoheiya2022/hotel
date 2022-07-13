package com.qingge.springboot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Quit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2022-05-09
 */
public interface QuitMapper extends BaseMapper<Quit> {

    @Select("select * from quit")
    List<Quit> findPage(Page<Quit> page);

    @Delete("delete from quit where id_user=#{id}")
    void removeId(Integer id);

    @Insert("insert into quit (id,nick_name,email,phone,create_time,note,id_user) values (id,nick_name,email,phone,create_time,note,id_user)")
    Quit addLeave(Quit quit);

    @Select("select count(*) from quit where id_user=#{id}")
    int getState(Integer id);
}
