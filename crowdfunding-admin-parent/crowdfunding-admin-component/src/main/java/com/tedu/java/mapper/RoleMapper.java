package com.tedu.java.mapper;

import com.tedu.java.entity.Role;
import com.tedu.java.entity.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    List<Role> selectRoleByKeyword(String keyword);

    List<Role> selectAssignedRole(Integer adminId);

    List<Role> selectUnAssignedRole(Integer adminId);

    void deleteRoleList(Integer adminId);

    void saveAdminRoleList(@Param("adminId") Integer adminId,@Param("roleIdList") List<Integer> roleIdList);
}