package com.homework.examSystem.web.controller.sys;

import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.entity.Role;
import com.homework.examSystem.entity.User;
import com.homework.examSystem.service.PermissionService;
import com.homework.examSystem.service.RoleService;
import com.homework.examSystem.service.UserService;
import com.homework.examSystem.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yha
 * @decription 用户相关Controller
 * @create 2017-11-10 16:57
 **/
@RequestMapping("/user")
@RequiresRoles("admin")
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @ModelAttribute
    public User get(@RequestParam(required = false) Long userId){
        if (userId == null)
            return new User();
        return userService.findById(userId);
    }


    @RequestMapping("/test")
    @RequiresRoles("user")
    public String test(){
        return "welcome";
    }

    /**
     * 添加用户
     * @param request
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public String addUser(HttpServletRequest request, RedirectAttributes attributes, Model model, User user){
        userService.createUser(user);

        return "redirect:/user/users";
    }

    @RequestMapping("/users")
    public String userManage(Model model){
        model.addAttribute("users", userService.findUsers());
        return "/sys/users";
    }

    /**
     * 删除用户
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam String userId, Model model){
        userService.deleteUser(Long.parseLong(userId));

        return "redirect:/user/users";
    }

    /**
     * 获取用户修改信息
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String userDetail(@RequestParam String userId, Model model){
        User user = userService.findById(Long.parseLong(userId));
        model.addAttribute("user", user);
        List<Role> roles = userService.findRolesByUserId(Long.parseLong(userId));
        model.addAttribute("roles", roles);
        List<Permission> permissions = userService.findPermissionsByUserId(Long.parseLong(userId));
        model.addAttribute("permissions", permissions);
        List<Role> allRoles = roleService.findRoles();
        List<Role> noRoles = new ArrayList<>();
        if (noRoles != null){
            for (Role r : allRoles){
                if (!roles.contains(r))
                    noRoles.add(r);
            }
        }
        model.addAttribute("noRoles", noRoles);
        return "/sys/userEdit";
    }

    /**
     * 修改用户除角色和权限外的信息
     * 现在只能修改密码
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String editUser(User user, Model model, RedirectAttributes attributes){

        userService.changePassword(user.getId(), user.getPassword());

        attributes.addAttribute("userId", user.getId());

        return "redirect:/user/detail";
    }

    /**
     * 删除用户角色
     * @param userId
     * @param roleId
     * @param model
     * @return
     */
    @RequestMapping("deleteRole")
    public String deleteRole(@RequestParam Long userId, @RequestParam Long roleId, Model model, RedirectAttributes attributes){
        userService.uncorrelationRoles(userId, roleId);

        attributes.addAttribute("userId", userId);
        return "redirect:/user/detail";
    }

    /**
     * 添加用户角色
     * @param userId
     * @param roleId
     * @param model
     * @param attributes
     * @return
     */
    @RequestMapping("/addRole")
    public String addRole(@RequestParam Long userId, @RequestParam Long roleId, Model model, RedirectAttributes attributes){
        userService.correlationRoles(userId, roleId);

        attributes.addAttribute("userId", userId);
        return "redirect:/user/detail";

    }
}
