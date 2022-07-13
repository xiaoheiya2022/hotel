package com.qingge.springboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Quit;
import com.qingge.springboot.mapper.QuitMapper;
import com.qingge.springboot.service.IQuitService;
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
public class QuitServiceImpl extends ServiceImpl<QuitMapper, Quit> implements IQuitService {

    @Resource
    QuitMapper quitMapper;
    @Override
    public Page<Quit> findPage(Page<Quit> page) {
        return page.setRecords(quitMapper.findPage(page));
    }

    @Override
    public void removeId(Integer id) {
        quitMapper.removeId(id);
    }

    @Override
    public void addLeave(Quit quit) {
        quitMapper.addLeave(quit);
    }

    @Override
    public int getState(Integer id) {
        return quitMapper.getState(id);
    }

//    @Override
//    public void leaveCancel(Integer id) {
//        quitMapper.leaveCancel(id);
//    }
}
