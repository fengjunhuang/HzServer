package htht.system.ocean.system.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "SYS_ROLE")
public class RoleDO {
    @Id
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "GMT_CREATE")
    private Date gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date gmtModified;

    @Column(name = "ROLE_SIGN")
    private String roleSign;

    @Column(name = "USER_ID_CREATE")
    private String userIdCreate;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(String userIdCreate) {
        this.userIdCreate = userIdCreate;
    }
}
