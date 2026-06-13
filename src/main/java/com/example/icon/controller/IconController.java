package com.example.icon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.icon.common.Result;
import com.example.icon.entity.Icontype;
import com.example.icon.mapper.IcontypeMapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.icon.service.IIconService;
import com.example.icon.entity.Icon;

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
@RequestMapping("/icon")
public class IconController {
@Resource
private IIconService iconService;
@Resource
private IcontypeMapper icontypeMapper;
//新增/更新数据
@PostMapping
public boolean save(@RequestBody Icon icon){ //RequestBody把前台传过来的json对象转为Java对象
        return iconService.saveOrUpdate(icon);
        }
//删除数据
@DeleteMapping("/{id}")
public Boolean delete(@PathVariable Integer id) {
        return iconService.removeById(id);
        }
//批量删除
@PostMapping("/del/batch")
public boolean deletebatch(@RequestBody List<Integer> ids){
        return iconService.removeByIds(ids);
        }
//查询所有数据
@GetMapping
public List<Icon> findAll() {
        return iconService.list();
        }
//根据id查询
@GetMapping("/{id}")
public Icon findOne(@PathVariable Integer id) {
        return iconService.getById(id);
        }
//分页查询
@GetMapping("/page")
public Page<Icon> findPage(@RequestParam Integer pageNum,
@RequestParam Integer pageSize){
        return iconService.page(new Page<>(pageNum, pageSize));
        }
        //获取类型
        @GetMapping("/iconType")
        public Result getIconType(){
                QueryWrapper<Icontype> queryWrapper = new QueryWrapper<>();
                return Result.success(icontypeMapper.selectList(null));
}
        //根据类型id筛选
        @GetMapping("/getIcons/{typeId}")
        public Result findIcons(@PathVariable Integer typeId){
                List<Icon> icons= iconService.list(new QueryWrapper<Icon>().eq("typeId",typeId));
                Map<String,Object> map = new HashMap<>();
                map.put("message",icons);
                return Result.success(map);
        }
}
