package com.atguigu.system.mapper;

import com.atguigu.model.system.SysMenu;
import com.atguigu.model.system.SysRoleMenu;
import com.atguigu.model.system.SysUserRole;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author wrystart
 * @Version
 * @Date 2023/10/12 15:08
 */
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {


}
