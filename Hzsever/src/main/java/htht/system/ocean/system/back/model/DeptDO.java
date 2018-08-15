package htht.system.ocean.system.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "SYS_DEPT")
public class DeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "DEPT_ID")
	private Long deptId;
	@Column(name = "PARENT_ID")
	private Long parentId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ORDER_NUM")
	private String orderNum;
	@Column(name = "DEL_FLAG")
	private String delFlag;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long departmentId) {
		this.deptId = departmentId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DeptDO{" +
				"departmentId=" + deptId +
				", parentId=" + parentId +
				", name='" + name + '\'' +
				'}';
	}
}
