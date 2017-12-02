package com.homework.examSystem.service;


import com.homework.examSystem.entity.Permission;

import java.util.List;

/**
 * @author yha
 * @decription 权限管理操作接口
 * @create 2017-11-19 14:25
 **/
public interface PermissionService {

    /**
     * 创建权限
     * @param permission
     * @return
     */
    Permission createPermission(Permission permission);

    /**
     * 删除权限
     * @param permissionId
     */
    void deletePermission(Long permissionId);

    /**
     * 查找系统中的所有权限
     * @return
     */
    List<Permission> findPermissions();

    /**
     * 根据权限ID查找权限
     * @param permissionId
     * @return
     */
    Permission findById(Long permissionId);

    /**
     * 修改权限
     * @param permission
     */
    void update(Permission permission);
}
