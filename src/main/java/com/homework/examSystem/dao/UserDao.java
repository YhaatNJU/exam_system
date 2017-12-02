package com.homework.examSystem.dao;


import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.entity.Role;
import com.homework.examSystem.entity.User;
import com.homework.examSystem.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author yha
 * @decription 用户管理数据访问接口
 * @create 2017-11-19 14:45
 **/
@Repository
public interface UserDao {

    /**
     * 创建用户
     * @param user
     * @return
     */
    Long createUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Long userId);


    /**
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    User findById(Long userId);
    /**
     * 添加用户-角色对应关系
     * @param userId
     * @param roleId
     */
    void correlationRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 移除用户-角色对应关系
     * @param userId
     * @param roleId
     */
    void uncorrelationRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 检查是否存在相同的用户角色关系
     * @param userId
     * @param roleId
     * @return
     */
    UserRole findUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    User findOne(Long userId);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    List<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    List<String> findPermissions(String username);

    /**
     * 查找用户列表
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
