package com.homework.examSystem.web.controller.sys;

import com.homework.examSystem.entity.Permission;
import com.homework.examSystem.service.PermissionService;
import com.homework.examSystem.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author yha
 * @decription 权限管理控制器
 * @create 2017-12-02 10:35
 **/
@RequiresRoles("admin")
@RequestMapping("/permission")
@Controller
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @ModelAttribute
    public Permission get(@RequestParam(required = false) Long permissionId){
        if (permissionId == null)
            return new Permission();
        return permissionService.findById(permissionId);
    }

    /**
     * 权限管理总界面
     * @param model
     * @return
     */
    @RequestMapping("/permissions")
    public String permissions(Model model){
        List<Permission> permissions = permissionService.findPermissions();
        model.addAttribute("permissions", permissions);

        return "/sys/permissions";
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @RequestMapping("/add")
    public String addPermission(Permission permission){
        permissionService.createPermission(permission);

        return "redirect:/permission/permissions";
    }

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    @RequestMapping("/delete")
    public String deletePermission(@RequestParam Long permissionId){
        permissionService.deletePermission(permissionId);

        return "redirect:/permission/permissions";
    }

    /**
     * 获取权限详情界面
     * @param permissionId
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String detail(@RequestParam Long permissionId, Model model){
        Permission permission = permissionService.findById(permissionId);
        model.addAttribute("permission", permission);
        return "/sys/permissionEdit";
    }

    /**
     * 更新权限
     * @param permission
     * @param attributes
     * @return
     */
    @RequestMapping("/update")
    public String updatePermission(Permission permission, RedirectAttributes attributes){
        permissionService.update(permission);
        attributes.addAttribute("permissionId", permission.getId());
        return "redirect:/permission/detail";
    }

}
