package com.homework.examSystem.entity;

import java.io.Serializable;

/**
 * @author yha
 * @decription 权限实体类
 * @create 2017-11-19 14:19
 **/
public class Permission implements Serializable {


    private Long id;
    /**
     * 权限名称，比如：user:create
     */
    private String name;
    /**
     * 权限描述
     */
    private String description;
    /**
     * 是否可用，不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;

    public Permission() {
    }

    public Permission(String name, String description, Boolean available) {
        this.name = name;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
