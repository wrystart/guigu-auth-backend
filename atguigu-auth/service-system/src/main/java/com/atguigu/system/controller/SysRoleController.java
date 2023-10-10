package com.atguigu.system.controller;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.result.Result;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 角色管理
 * @Author wrystart
 * @Version
 * @Date 2023/10/10 14:57
 */

@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    //7 批量删除
    // 多个id值 [1,2,3]
    // json数组格式 --- java的list集合
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids) {
        boolean isSuccess = sysRoleService.removeByIds(ids);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //6 修改-最终修改
    @ApiOperation("最终修改")
    @PutMapping("update")
    public Result updateRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //5 修改-根据id查询
    @ApiOperation("根据id查询")
    @PutMapping("findRoleById/{id}")
    public Result findRoleById(@PathVariable("id") Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);

    }

    //4 添加
    //@RequestBody 不能使用get提交方式
    //传递json格式数据，把json格式数据封装到对象里面 {...}
    @ApiOperation("添加")
    @PostMapping("save")
    public Result saveRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.save(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //3 条件分页查询
    // page当前页 limit每页记录数
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page,
                                    @PathVariable Long limit,
                                    SysRoleQueryVo sysRoleQueryVo) {
        //创建page对象
        Page<SysRole> pageParam = new Page<>(page, limit);
        //调用service方法
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, sysRoleQueryVo);
        //返回
        return Result.ok(pageModel);

    }


    //2 逻辑删除接口
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}") //根据id进行删除
    public Result removeRole(@PathVariable("id") Long id) {
        //调用方法删除
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();

        }
    }

    //1 查询所有记录
    @ApiOperation("查询所有记录")
    @GetMapping("findAll")
    public Result findAllRole() {
        //调用service
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

}
