package htht.system.ocean.model;

import javax.persistence.*;

@Table(name = "UIM_ISSUE_ROLE")
public class UimIssueRole {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "MEMO")
    private String memo;

    @Column(name = "ORDER_NUM")
    private Short orderNum;

    @Column(name = "ISLOCK")
    private Short islock;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
     * @return MEMO
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
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

    /**
     * @return ISLOCK
     */
    public Short getIslock() {
        return islock;
    }

    /**
     * @param islock
     */
    public void setIslock(Short islock) {
        this.islock = islock;
    }
}