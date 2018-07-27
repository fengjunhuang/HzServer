package htht.system.ocean.system.back.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SYS_MENU")
public class MenuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MENU_ID")
	private Long menuId;

	@Column(name = "PARENT_ID")
	private Long parentId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "URL")
	private String url;

	@Column(name = "PERMS")
	private String perms;

	@Column(name = "GMT_CREATE")
	private Date gmtCreate;

	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	@Column(name = "TYPE")
	private Short type;

	@Column(name = "ICON")
	private String icon;

	@Column(name = "ORDER_NUM")
	private Short orderNum;

	/**
	 * @return MENU_ID
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return PARENT_ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return NAME
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return PERMS
	 */
	public String getPerms() {
		return perms;
	}

	/**
	 * @param perms
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}

	/**
	 * @return GMT_CREATE
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * @param gmtCreate
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * @return UPDATE_TIME
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return TYPE
	 */
	public Short getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(Short type) {
		this.type = type;
	}

	/**
	 * @return ICON
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return ORDER_NUM
	 */
	public Short getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum
	 */
	public void setOrderNum(Short orderNum) {
		this.orderNum = orderNum;
	}
}
