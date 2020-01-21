package com.lssjzmn.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TreesModel implements Serializable {

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     */
    private static final long serialVersionUID = 1L;
    private String id;//菜单树id
    private String name;//菜单树名称
    private String parentId;//菜单树父id
    private List<TreesModel> children;//子节点
    private String entityId; //实体类主键
    private boolean disabled;//是否禁用
    private Map<String, String> params;//参数
    private Object entity;//实体对象
    private String icon;//菜单图标
    private String title;//菜单名称
    private String href;//菜单路径


    public String getHref() {

        return href;
    }

    public void setHref(String href) {

        this.href = href;
    }

    public String getIcon() {

        return icon;
    }

    public void setIcon(String icon) {

        this.icon = icon;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public Object getEntity() {

        return entity;
    }

    public void setEntity(Object entity) {

        this.entity = entity;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getParentId() {

        return parentId;
    }

    public void setParentId(String parentId) {

        this.parentId = parentId;
    }

    public List<TreesModel> getChildren() {

        return children;
    }

    public void setChildren(List<TreesModel> children) {

        this.children = children;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

}
