package com.qingge.springboot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingge.springboot.entity.Reserve;
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
public interface ReserveMapper extends BaseMapper<Reserve> {

    Page<Reserve> findPage(Page<Reserve> page, @Param("phone") String phone,@Param("nickName") String nickName);

    @Select("select * from reserve where id_user=#{id}")
    Page<Reserve> pageUser(Page<Reserve> objectPage, Integer id);

    @Update("update reserve set state=2 where id=#{id}")
    void updateState(Integer id);
    @Update("update reserve set state=0 where id=#{id}")
    void cancel(Integer id);
}
