package com.qingge.springboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Reserve;
import com.qingge.springboot.mapper.ReserveMapper;
import com.qingge.springboot.service.IReserveService;
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
public class ReserveServiceImpl extends ServiceImpl<ReserveMapper, Reserve> implements IReserveService {

    @Resource
    ReserveMapper reserveMapper;
    @Override
    public Page<Reserve> findPage(Page<Reserve> Page, String phone, String nickName) {
        return reserveMapper.findPage(Page,phone,nickName);
    }

    @Override
    public Page<Reserve> pageUser(Page<Reserve> objectPage, Integer id) {
        return reserveMapper.pageUser(objectPage,id);
    }

    @Override
    public void updateState(Integer id) {
         reserveMapper.updateState(id);
    }

    @Override
    public void cancel(Integer id) {
        reserveMapper.cancel(id);
    }
}
