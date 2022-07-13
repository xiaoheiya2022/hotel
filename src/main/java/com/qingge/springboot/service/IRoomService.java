package com.qingge.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Room;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2022-05-09
 */
public interface IRoomService extends IService<Room> {

    Page<Room> findPage(Page<Room> page , String roomNo);

    void ok(Integer id);

    void updateState(Integer id);

//    void outRoom(Integer id);
}
