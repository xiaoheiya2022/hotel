package com.qingge.springboot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Room;
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
 * @since 2022-05-09
 */
public interface RoomMapper extends BaseMapper<Room> {

    @Select("select  * from  room where room_no like concat('%', #{roomNo} ,'%') ")
    Page<Room> findPage(Page<Room> page, @Param("roomNo")String roomNo);

    @Update("update room set state =1 where room_no=#{id}")
    void ok(Integer id);

    @Update("update room set state =0 where room_no=#{id}")
    void cancel(Integer id);

    @Update("update room set state =0 where room_no=#{id}")
    void updateState(Integer id);
//    @Update("update room set state =0 where room_no=#{id}")
//    void outRoom(Integer id);
}
