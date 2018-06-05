package com.ccttic.entity.employee;

public class ResMenu {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 菜单资源标识
     */
    private String resource;

    /**
     * 菜单资源中文名
     */
    private String label;

    /**
     * 父菜单资源标识
     */
    private String groupresource;

    /**
     * 菜单排序号
     */
    private Integer sortorder;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 菜单访问路径
     */
    private String path;

    /**
     * 资源类型（菜单or按钮）
     */
    private String ismenu;

    /**
     * 层级（菜单类型时）
     */
    private Integer hierarchy;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 菜单资源标识
     * @return resource 菜单资源标识
     */
    public String getResource() {
        return resource;
    }

    /**
     * 菜单资源标识
     * @param resource 菜单资源标识
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * 菜单资源中文名
     * @return label 菜单资源中文名
     */
    public String getLabel() {
        return label;
    }

    /**
     * 菜单资源中文名
     * @param label 菜单资源中文名
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 父菜单资源标识
     * @return groupResource 父菜单资源标识
     */
    public String getGroupresource() {
        return groupresource;
    }

    /**
     * 父菜单资源标识
     * @param groupresource 父菜单资源标识
     */
    public void setGroupresource(String groupresource) {
        this.groupresource = groupresource;
    }

    /**
     * 菜单排序号
     * @return sortOrder 菜单排序号
     */
    public Integer getSortorder() {
        return sortorder;
    }

    /**
     * 菜单排序号
     * @param sortorder 菜单排序号
     */
    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    /**
     * 菜单图标
     * @return icon 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 菜单描述
     * @return description 菜单描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 菜单描述
     * @param description 菜单描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 菜单访问路径
     * @return path 菜单访问路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 菜单访问路径
     * @param path 菜单访问路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 资源类型（菜单or按钮）
     * @return ismenu 资源类型（菜单or按钮）
     */
    public String getIsmenu() {
        return ismenu;
    }

    /**
     * 资源类型（菜单or按钮）
     * @param ismenu 资源类型（菜单or按钮）
     */
    public void setIsmenu(String ismenu) {
        this.ismenu = ismenu;
    }

    /**
     * 层级（菜单类型时）
     * @return hierarchy 层级（菜单类型时）
     */
    public Integer getHierarchy() {
        return hierarchy;
    }

    /**
     * 层级（菜单类型时）
     * @param hierarchy 层级（菜单类型时）
     */
    public void setHierarchy(Integer hierarchy) {
        this.hierarchy = hierarchy;
    }
}