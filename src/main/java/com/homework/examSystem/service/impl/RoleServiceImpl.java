package com.homework.examSystem.service.impl;

import com.homework.examSystem.dao.RoleDao;
import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.entity.Role;
import com.homework.examSystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yha
 * @decription 角色管理服务实现类
 * @create 2017-11-19 17:24
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role createRole(Role role) {
        Long id = roleDao.createRole(role);
        role.setId(id);
        return role;
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        if (permissionIds == null || permissionIds.length == 0)
            return;
        for (Long permissionId : permissionIds)
            if (roleDao.findRolePermission(roleId, permissionId) == null)
                roleDao.correlationPermissions(roleId, permissionId);
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        if (permissionIds == null || permissionIds.length == 0)
            return;
        for (Long permissionId : permissionIds){
            roleDao.uncorrelationPermissions(roleId, permissionId);
        }
    }

    @Override
    public List<Role> findRoles() {
        return roleDao.findRoles();
    }

    @Override
    public List<Permission> findPermissions(Long roleId) {
        return roleDao.findPermissions(roleId);
    }

    @Override
    public Role findById(Long roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }
}
