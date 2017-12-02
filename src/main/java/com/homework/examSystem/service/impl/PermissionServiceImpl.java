package com.homework.examSystem.service.impl;

import com.homework.examSystem.dao.PermissionDao;
import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yha
 * @decription 权限管理服务实现类
 * @create 2017-11-19 17:26
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission createPermission(Permission permission) {
        Long id = permissionDao.createPermission(permission);
        permission.setId(id);
        return permission;
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }

    @Override
    public List<Permission> findPermissions() {
        return permissionDao.findPermissions();
    }

    @Override
    public Permission findById(Long permissionId) {
        return permissionDao.findById(permissionId);
    }

    @Override
    public void update(Permission permission) {
        permissionDao.update(permission);
    }
}
