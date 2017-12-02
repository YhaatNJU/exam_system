package com.homework.examSystem.dao;


import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.entity.Role;
import com.homework.examSystem.entity.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yha
 * @decription 角色管理数据访问接口
 * @create 2017-11-19 14:41
 **/
@Repository
public interface RoleDao {

    /**
     * 创建角色
     * @param r
     * @return
     */
    Long createRole(Role r);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间的对应关系
     * @param roleId
     * @param permissionId
     */
    void correlationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * 检查是否存在相同的对应关系
     * @param roleId
     * @param permissionId
     * @return
     */
    RolePermission findRolePermission(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * 移除角色-权限之间的对应关系
     * @param roleId
     * @param permissionId
     */
    void uncorrelationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * 查找系统中的所有权限
     * @return
     */
    List<Role> findRoles();

    /**
     * 查找角色对应的所有权限
     * @param roleId
     * @return
     */
    List<Permission> findPermissions(Long roleId);

    /**
     * 根据角色ID查找角色
     * @param roleId
     * @return
     */
    Role findById(Long roleId);

    /**
     * 修改角色信息
     * @param role
     */
    void updateRole(Role role);
}
