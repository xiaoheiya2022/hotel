package com.qingge.springboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Room;
import com.qingge.springboot.mapper.RoomMapper;
import com.qingge.springboot.service.IRoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tao
 * @since 2022-05-09
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements IRoomService {

    @Resource
    RoomMapper roomMapper;
    @Override
    public Page<Room> findPage(Page<Room> page, String roomNo) {
        return roomMapper.findPage(page,roomNo);
    }

    @Override
    public void ok(Integer id) {
        roomMapper.ok(id);
    }

    @Override
    public void updateState(Integer id) {
        roomMapper.updateState(id);
    }

//    @Override
//    public void outRoom(Integer id) {
//        roomMapper.outRoom(id);
//    }
}
