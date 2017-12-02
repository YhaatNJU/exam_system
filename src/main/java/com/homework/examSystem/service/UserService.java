package com.homework.examSystem.service;


import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.entity.Role;
import com.homework.examSystem.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @author yha
 * @decription 用户管理服务接口
 * @create 2017-11-19 14:31
 **/
public interface UserService {

    /**
     * 创建用户
     * @param user
     * @return
     */
    User createUser(User user);

    /**
     * 根据用户ID删除用户
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    void changePassword(Long userId, String newPassword);

    /**
     * 添加用户-角色对应关系
     * @param userId
     * @param roleIds
     */
    void correlationRoles(Long userId, Long... roleIds);

    /**
     * 移除用户-角色对应关系
     * @param userId
     * @param roleIds
     */
    void uncorrelationRoles(Long userId, Long... roleIds);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    User findById(Long userId);

    /**
     * 根据用户名查找其拥有的角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);

    /**
     * 返回所有用户列表
     * @return
     */
    List<User> findUsers();

    /**
     * 根据用户ID查找角色列表
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(Long userId);

    /**
     * 根据用户ID查找角色权限
     * @param userId
     * @return
     */
    List<Permission> findPermissionsByUserId(Long userId);
}
