package com.example.icon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jony
 * @since 2025-04-07
 */
@Getter
@Setter
  @ApiModel(value = "Icon对象", description = "")
public class Icon implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    @TableField("iconName")
    private String iconName;

    @TableField("typeId")
    private Integer typeId;

    private String picture;


}
