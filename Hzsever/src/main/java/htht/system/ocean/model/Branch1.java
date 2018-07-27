package htht.system.ocean.model;

import java.util.Date;
import javax.persistence.*;

public class Branch1 {
    @Id
    @Column(name = "BRANCH_ID")
    private String branchId;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "CONTENT_ID")
    private String contentId;

    @Column(name = "NODE_TYPE")
    private Short nodeType;

    @Column(name = "CREATE_DEPT_ID")
    private Short createDeptId;

    @Column(name = "CHECK_DEPT_IDS")
    private Short checkDeptIds;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "GEO_JSON")
    private String geoJson;

    /**
     * @return BRANCH_ID
     */
    public String getBranchId() {
        return branchId;
    }

    /**
     * @param branchId
     */
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    /**
     * @return PARENT_ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    /**
     * @return BRANCH_NAME
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * @return CONTENT_ID
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * @param contentId
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    /**
     * @return NODE_TYPE
     */
    public Short getNodeType() {
        return nodeType;
    }

    /**
     * @param nodeType
     */
    public void setNodeType(Short nodeType) {
        this.nodeType = nodeType;
    }

    /**
     * @return CREATE_DEPT_ID
     */
    public Short getCreateDeptId() {
        return createDeptId;
    }

    /**
     * @param createDeptId
     */
    public void setCreateDeptId(Short createDeptId) {
        this.createDeptId = createDeptId;
    }

    /**
     * @return CHECK_DEPT_IDS
     */
    public Short getCheckDeptIds() {
        return checkDeptIds;
    }

    /**
     * @param checkDeptIds
     */
    public void setCheckDeptIds(Short checkDeptIds) {
        this.checkDeptIds = checkDeptIds;
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
     * @return GEO_JSON
     */
    public String getGeoJson() {
        return geoJson;
    }

    /**
     * @param geoJson
     */
    public void setGeoJson(String geoJson) {
        this.geoJson = geoJson;
    }
}