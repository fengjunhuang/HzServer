package htht.system.ocean.system.front.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Table(name = "FRONT_USER")
public class UserDO {
    private static final long serialVersionUID = 1L;

    @Column(name = "USER_ID")
    private Long userId;
    @Id
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_ALIAS")
    private String userAlias;
    @Column(name = "DEPT_ID")
    private Long deptId;
    @Column(name = "DEPT_NAME")
    private String deptName;
    @Column(name = "LOGIN_TIME")
    private Date loginTime;
    @Column(name = "PIC_ID")
    private Long picId;
    @Column(name = "STATUS")
    private Long status;
    @Column(name = "ROLE_ID")
    private Long roleId;
    @Column(name = "PASSWORD")
    private String password;

    @Transient
    private String roleName;

    @Transient
    private List<Long> roleIds;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }


}
