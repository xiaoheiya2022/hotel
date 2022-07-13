package com.qingge.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.IRoomService;
import com.qingge.springboot.entity.Room;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tao
 * @since 2022-05-09
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Resource
    private IRoomService roomService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Room room) {
        room.setState(0);
        roomService.saveOrUpdate(room);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        roomService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        roomService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(roomService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(roomService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                           @RequestParam String roomNo) {
//        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByAsc("id");
        Page<Room> page =roomService.findPage(new Page<>(pageNum, pageSize), roomNo);
        return Result.success(page);
    }

    @PostMapping ("/ok/{id}")
    public Result ok(@PathVariable Integer id) {
        roomService.ok(id);
        return Result.success();
    }
    @GetMapping("/getRoom")
    public Result getRoom(@RequestParam String classify,@RequestParam Integer pageNum,
                          @RequestParam Integer pageSize) {
        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",0);
        queryWrapper.eq("classify", classify);
        return Result.success(roomService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @PostMapping ("/updateState/{id}")
    public Result updateState(@PathVariable Integer id) {
        roomService.updateState(id);
        return Result.success();
    }
//    @PostMapping ("/updateState/{id}")
//    public Result outRoom(@PathVariable Integer id) {
//
//        return Result.success(roomService.outRoom(id));
//    }

}

