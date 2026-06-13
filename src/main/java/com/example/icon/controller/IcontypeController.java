package com.example.icon.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.example.icon.service.IIcontypeService;
import com.example.icon.entity.Icontype;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jony
 * @since 2025-04-07
 */
@RestController
@RequestMapping("/icontype")
public class IcontypeController {
@Resource
private IIcontypeService icontypeService;
//新增/更新数据
@PostMapping
public boolean save(@RequestBody Icontype icontype){ //RequestBody把前台传过来的json对象转为Java对象
        return icontypeService.saveOrUpdate(icontype);
        }
//删除数据
@DeleteMapping("/{id}")
public Boolean delete(@PathVariable Integer id) {
        return icontypeService.removeById(id);
        }
//批量删除
@PostMapping("/del/batch")
public boolean deletebatch(@RequestBody List<Integer> ids){
        return icontypeService.removeByIds(ids);
        }
//查询所有数据
@GetMapping
public List<Icontype> findAll() {
        return icontypeService.list();
        }
//根据id查询
@GetMapping("/{id}")
public Icontype findOne(@PathVariable Integer id) {
        return icontypeService.getById(id);
        }
//分页查询
@GetMapping("/page")
public Page<Icontype> findPage(@RequestParam Integer pageNum,
@RequestParam Integer pageSize){
        return icontypeService.page(new Page<>(pageNum, pageSize));
        }
        //根据类型查询所有icon

}
