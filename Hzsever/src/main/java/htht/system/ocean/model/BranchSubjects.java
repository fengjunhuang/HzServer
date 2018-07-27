package htht.system.ocean.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "BRANCH_SUBJECTS")
public class BranchSubjects {
    @Id
    @Column(name = "SUB_ID")
    private Long subId;

    @Column(name = "SUB_NAME")
    private String subName;

    @Column(name = "NODE_LIST")
    private String nodeList;



    @Column(name = "CREATE_USERID")
    private String createUserid;

    @Column(name = "CREATE_TIME")
    private Date createTime;



    @Column(name="SUB_PARENT_ID")
    private  Long subParentId;

    public Long getSubParentId() {
        return subParentId;
    }

    public void setSubParentId(Long subParentId) {
        this.subParentId = subParentId;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    /**
     * @param subName
     */
    public void setSubName(String subName) {
        this.subName = subName;
    }

    /**
     * @return NODE_LIST
     */
    public String getNodeList() {
        return nodeList;
    }

    /**
     * @param nodeList
     */
    public void setNodeList(String nodeList) {
        this.nodeList = nodeList;
    }

    /**
     * @return CREATE_USERID
     */
    public String getCreateUserid() {
        return createUserid;
    }

    /**
     * @param createUserid
     */
    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
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