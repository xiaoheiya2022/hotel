package com.qingge.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Quit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2022-05-09
 */
public interface IQuitService extends IService<Quit> {

    Page<Quit> findPage(Page<Quit> objectPage);

    void removeId(Integer id);

    void addLeave(Quit quit);

    int getState(Integer id);
//
//    void leaveCancel(Integer id);
}
