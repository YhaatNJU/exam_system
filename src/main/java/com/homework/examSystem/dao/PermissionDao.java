package com.homework.examSystem.dao;


import com.homework.examSystem.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yha
 * @decription 权限管理数据访问接口
 * @create 2017-11-19 14:39
 **/
@Repository
public interface PermissionDao {

    /**
     * 创建权限
     * @param p
     * @return
     */
    Long createPermission(Permission p);

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
    void update(Permission p);

}
