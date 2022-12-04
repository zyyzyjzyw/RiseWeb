package com.tedu.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.java.entity.Role;
import com.tedu.java.entity.RoleExample;
import com.tedu.java.mapper.RoleMapper;
import com.tedu.java.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： zyy
 * @date： 2022/11/21 19:55
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
        // 调用PageHelper的静态方法开启分页功能
        PageHelper.startPage(pageNum,pageSize);
        // 执行查询
        List<Role> roles = roleMapper.selectRoleByKeyword(keyword);
        // 封装到PageInfo对象中
        return new PageInfo<>(roles);
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void removeRole(List<Integer> roleIdList) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andIdIn(roleIdList);
        roleMapper.deleteByExample(roleExample);
    }

    @Override
    public List<Role> getAssignedRole(Integer adminId) {

        return roleMapper.selectAssignedRole(adminId);
    }

    @Override
    public List<Role> getUnAssignedRole(Integer adminId) {
        return roleMapper.selectUnAssignedRole(adminId);
    }

    @Override
    public void saveAdminRoleList(Integer adminId, List<Integer> roleIdList) {
        //根据adminId删除旧的关联关系
        roleMapper.deleteRoleList(adminId);
        if(roleIdList!=null&&roleIdList.size()>0){
            roleMapper.saveAdminRoleList(adminId,roleIdList);
        }
    }
}
