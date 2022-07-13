package com.qingge.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author tao
 * @since 2022-05-09
 */
@Getter
@Setter
  @ApiModel(value = "Room对象", description = "")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("房间名字")
      private String name;

      @ApiModelProperty("房间号")
      private String roomNo;

      @ApiModelProperty("价格")
      private Integer price;

      @ApiModelProperty("楼层")
      private String floor;

      @ApiModelProperty("分类")
      private String classify;

      @ApiModelProperty("描述")
      private String note;

      @ApiModelProperty("状态")
      private Integer state;

      @ApiModelProperty("图片展示")
      private String img;


}
