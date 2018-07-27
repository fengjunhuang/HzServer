package htht.system.ocean.system.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SYS_ROLE_MENU")
public class RoleMenuDO {
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "MENU_ID")
	private Long menuId;
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "RoleMenuDO{" +
				"id=" + id +
				", roleId=" + roleId +
				", menuId=" + menuId +
				'}';
	}
}
