package com.homework.examSystem.web.controller.sys;

import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.entity.Role;
import com.homework.examSystem.service.PermissionService;
import com.homework.examSystem.service.RoleService;
import com.homework.examSystem.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yha
 * @decription 角色管理Controller
 * @create 2017-12-01 17:13
 **/
@RequiresRoles("admin")
@RequestMapping("/role")
@Controller
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @ModelAttribute
    public Role get(@RequestParam(required = false) Long roleId){
        if (roleId == null)
            return new Role();
        Role role = roleService.findById(roleId);
        return role;
    }

    /**
     * 进入角色管理界面
     * @param model
     * @return
     */
    @RequestMapping("/roles")
    public String getRoles(Model model){
        List<Role> roles = roleService.findRoles();
        model.addAttribute("roles", roles);

        return "/sys/roles";
    }

    /**
     * 添加系统角色
     * @param role
     * @return
     */
    @RequestMapping("/add")
    public String addRole(Role role){
        roleService.createRole(role);

        return "redirect:/role/roles";
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @RequestMapping("/delete")
    public String deleteRole(@RequestParam Long roleId){
        roleService.deleteRole(roleId);

        return "redirect:/role/roles";
    }

    /**
     * 进入角色修改界面
     * @param roleId
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String detail(@RequestParam Long roleId, Model model){

        Role role = roleService.findById(roleId);
        model.addAttribute("role", role);
        List<Permission> permissions = roleService.findPermissions(roleId);
        model.addAttribute("permissions", permissions);
        List<Permission> allPermissions = permissionService.findPermissions();
        List<Permission> noPermissions = new ArrayList<>();
        if (allPermissions != null){
            for (Permission p : allPermissions){
                if (!permissions.contains(p))
                    noPermissions.add(p);
            }
        }
        model.addAttribute("noPermissions", noPermissions);

        return "/sys/roleEdit";
    }

    /**
     * 修改角色出权限相关的信息
     * @param role
     * @param attributes
     * @return
     */
    @RequestMapping("/edit")
    public String editRole(Role role, RedirectAttributes attributes){
        roleService.updateRole(role);

        attributes.addAttribute("roleId", role.getId());

        return "redirect:/role/detail";
    }

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionId
     * @param attributes
     * @return
     */
    @RequestMapping("/addPermission")
    public String addPermission(@RequestParam Long roleId, @RequestParam Long permissionId, RedirectAttributes attributes){
        roleService.correlationPermissions(roleId, permissionId);

        attributes.addAttribute("roleId", roleId);

        return "redirect:/role/detail";
    }

    /**
     * 删除角色权限
     * @param roleId
     * @param permissionId
     * @param attributes
     * @return
     */
    @RequestMapping("/deletePermission")
    public String deletePermission(@RequestParam Long roleId, @RequestParam Long permissionId, RedirectAttributes attributes){
        roleService.uncorrelationPermissions(roleId, permissionId);

        attributes.addAttribute("roleId", roleId);

        return "redirect:/role/detail";
    }


}
