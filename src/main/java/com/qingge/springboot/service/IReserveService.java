package com.qingge.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Reserve;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2022-05-09
 */
public interface IReserveService extends IService<Reserve> {

    Page<Reserve>  findPage(Page<Reserve> Page, String phone, String nickName);

    Page<Reserve> pageUser(Page<Reserve> objectPage, Integer id);

    void updateState(Integer id);

    void cancel(Integer id);
}
