package com.homework.examSystem.service;


import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.entity.Role;

import java.util.List;

/**
 * @author yha
 * @decription 角色管理服务接口
 * @create 2017-11-19 14:27
 **/
public interface RoleService {

    /**
     * 创建角色
     * @param role
     * @return
     */
    Role createRole(Role role);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间的对应关系
     * @param roleId
     * @param permissionIds
     */
    void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间的对应关系
     * @param roleId
     * @param permissionIds
     */
    void uncorrelationPermissions(Long roleId, Long... permissionIds);

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
