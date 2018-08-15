package htht.system.ocean.system.front.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "FRONT_ROLE")
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

    @Column(name = "USER_ID_CREATE")
    private String userIdCreate;

    @Transient
    private String permissions;

    @Column(name = "IS_DEFAULT")
    private Integer isDefault;

    @Transient
    private Boolean roleSign;

    @Transient
    private String permissionNames;

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    /*public String getPermissionNames() {
        if (permissionNames != null) {
            return permissionNames;
        } else {
            if (permissions != null) {
                String[] split = permissions.split(",");
                int length = split.length;
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < length; i++) {
                        int num = Integer.parseInt(split[i]);
                        if (num == MyConstants.Resource.上传) {
                            sb.append("上传");
                        } else if (num == MyConstants.Resource.剖面图) {
                            sb.append("剖面图");
                        } else if (num == MyConstants.Resource.海域管理界限) {
                            sb.append("海域管理界限");
                        } else if (num == MyConstants.Resource.行政区划) {
                            sb.append("行政区划");
                        }
                        if (i < length - 1) {
                            sb.append("、");
                        }
                    }
                    return permissionNames = sb.toString();
                }
            }
            return "没有任何权限";
        }
    }*/

    public void setPermissionNames(String permissionNames) {
        this.permissionNames = permissionNames;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

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

    public Boolean getRoleSign() {
        return roleSign;
    }

    public void setRoleSign( Boolean roleSign) {
        this.roleSign = roleSign;
    }

    public String getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(String userIdCreate) {
        this.userIdCreate = userIdCreate;
    }
}
