package com.qingge.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.IQuitService;
import com.qingge.springboot.entity.Quit;

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
@RequestMapping("/leave")
public class QuitController {

    @Resource
    private IQuitService leaveService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Quit quit) {
        Date a=new Date();
        quit.setCreateTime(a);
        quit.setState(0);
        leaveService.saveOrUpdate(quit);
        return Result.success();
    }
    @PostMapping("addLeave")
    public Result addLeave(@RequestBody Quit quit) {
        leaveService.addLeave(quit);
        return Result.success();
    }
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        leaveService.removeId(id);
        return Result.success();
    }
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        leaveService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(leaveService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(leaveService.getById(id));
    }

    @GetMapping("/get/{id}")
    public Result getState(@PathVariable Integer id) {
        return Result.success(leaveService.getState(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
        return Result.success(leaveService.findPage(new Page<>(pageNum, pageSize)));
    }


//    @PostMapping("/leaveCancel/{id}")
//    public Result leaveCancel(@PathVariable Integer id) {
//        leaveService.leaveCancel(id);
//        return Result.success();
//    }
}

