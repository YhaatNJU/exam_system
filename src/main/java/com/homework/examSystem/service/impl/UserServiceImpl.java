package com.homework.examSystem.service.impl;

import com.homework.examSystem.dao.UserDao;
import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.entity.Role;
import com.homework.examSystem.entity.User;
import com.homework.examSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yha
 * @decription 用户管理服务实现类
 * @create 2017-11-19 14:37
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    private PasswordHelper passwordHelper = new PasswordHelper();

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
        passwordHelper.encryptPassword(user);
        Long id = userDao.createUser(user);
        user.setId(id);
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public User findById(Long userId) {
        return userDao.findById(userId);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        if (user == null)
            return;
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        if (roleIds == null || roleIds.length == 0)
            return;
        for (Long roleId : roleIds){
            if (userDao.findUserRole(userId, roleId) == null)
                userDao.correlationRole(userId, roleId);
        }

    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        if (roleIds == null || roleIds.length == 0)
            return;
        for (Long roleId : roleIds){
            userDao.uncorrelationRole(userId, roleId);
        }
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        return new HashSet<>(userDao.findRoles(username));
    }

    @Override
    public Set<String> findPermissions(String username) {
        return new HashSet<>(userDao.findPermissions(username));
    }

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }

    @Override
    public List<Role> findRolesByUserId(Long userId) {
        return userDao.findRolesByUserId(userId);
    }

    @Override
    public List<Permission> findPermissionsByUserId(Long userId) {
        return userDao.findPermissionsByUserId(userId);
    }
}
