package com.atguigu.system.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description
 * @Author wrystart
 * @Version
 * @Date 2023/10/10 15:01
 */
public interface SysRoleService extends IService<SysRole> {

    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);
}
