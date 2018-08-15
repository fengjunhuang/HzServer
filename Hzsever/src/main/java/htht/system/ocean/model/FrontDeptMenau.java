package htht.system.ocean.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "FRONT_DEPT_MENAU")
public class FrontDeptMenau {
    @Column(name = "MENU_ID")
    private Long menuId;

    @Column(name = "DEPT_ID")
    private Long deptId;
    @Id
    @Column(name = "ID")

    private Long id;

    @Column(name = "AUTH_ID")
    private Long authId;

    public int getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(int menuStatus) {
        this.menuStatus = menuStatus;
    }

    @Column(name = "CREATE_TIME")

    private Date createTime;
    @Column(name ="MENU_STATUS")
    private int menuStatus;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Column(name = "MENU_NAME")

    private  String menuName;
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
     * @return DEPT_ID
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return AUTH_ID
     */
    public Long getAuthId() {
        return authId;
    }

    /**
     * @param authId
     */
    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}