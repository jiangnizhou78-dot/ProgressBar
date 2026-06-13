package com.example.icon.mapper;

import com.example.icon.entity.Icontype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jony
 * @since 2025-04-07
 */
public interface IcontypeMapper extends BaseMapper<Icontype> {
    public Icontype findByTypeId(String typeId);

}
