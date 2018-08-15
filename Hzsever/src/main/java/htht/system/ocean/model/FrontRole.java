package htht.system.ocean.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "FRONT_ROLE")
public class FrontRole {
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
    private Long isDefault;

    /**
     * @return ROLE_ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return ROLE_NAME
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * @return GMT_MODIFIED
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return USER_ID_CREATE
     */
    public String getUserIdCreate() {
        return userIdCreate;
    }

    /**
     * @param userIdCreate
     */
    public void setUserIdCreate(String userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    /**
     * @return PERMISSIONS
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * @param permissions
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    /**
     * @return IS_DEFAULT
     */
    public Long getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault
     */
    public void setIsDefault(Long isDefault) {
        this.isDefault = isDefault;
    }
}