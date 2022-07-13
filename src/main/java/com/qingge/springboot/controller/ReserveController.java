package com.qingge.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.IReserveService;
import com.qingge.springboot.entity.Reserve;

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
@RequestMapping("/reserve")
public class ReserveController {

    @Resource
    private IReserveService reserveService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Reserve reserve) {
        Date a =new Date();
        reserve.setCreateTime(a);
        reserve.setState(1);
        reserveService.saveOrUpdate(reserve);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        reserveService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        reserveService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(reserveService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(reserveService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam String phone, @RequestParam String nickName
                               ) {
//        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");
        return Result.success(reserveService.findPage(new Page<>(pageNum, pageSize), phone,nickName));
    }
    @GetMapping("/pageUser/{id}")
    public Result pageUser(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @PathVariable Integer  id
    ) {
//        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");
        return Result.success(reserveService.pageUser(new Page<>(pageNum, pageSize),id));
    }
    @PostMapping("/updateState/{id}")
    public Result updateState(@PathVariable Integer  id) {
        reserveService.updateState(id);
        return Result.success();
    }
    @PostMapping("/cancel/{id}")
    public Result cancel(@PathVariable Integer  id) {
        reserveService.cancel(id);
        return Result.success();
    }

}

