package htht.system.ocean.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_BRANCH")
public class Branch {

    @Id
    @Column(name = "BRANCH_ID")
    private Long branchId;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "CONTENT_ID")
    private Long contentId;

    @Column(name = "NODE_TYPE")
    private  Long nodeType;

    @Column(name = "CREATE_DEPT_ID")
    private  Long createDeptId;

    @Column(name = "CHECK_DEPT_IDS")
    private  String checkDeptIds;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }


    @Column(name = "ICON_ID")
    private  String iconId;


    @Column(name = "PARENT_ID")
    private  Long parentId;

    public String getZipPath() {
        return zipPath;
    }

    public void setZipPath(String zipPath) {
        this.zipPath = zipPath;
    }

    @Column(name ="ZIP_PATH")

   private  String zipPath;

    /**
     * @return BRANCH_ID
     */
    public  Long getBranchId() {
        return branchId;
    }

    /**
     * @param branchId
     */
    public void setBranchId( Long branchId) {
        this.branchId = branchId;
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

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    /**
     * @return NODE_TYPE
     */
    public  Long getNodeType() {
        return nodeType;
    }

    /**
     * @param nodeType
     */
    public void setNodeType( Long nodeType) {
        this.nodeType = nodeType;
    }

    /**
     * @return CREATE_DEPT_ID
     */
    public  Long getCreateDeptId() {
        return createDeptId;
    }

    /**
     * @param createDeptId
     */
    public void setCreateDeptId( Long createDeptId) {
        this.createDeptId = createDeptId;
    }

    /**
     * @return CHECK_DEPT_IDS
     */
    public  String getCheckDeptIds() {
        return checkDeptIds;
    }

    /**
     * @param checkDeptIds
     */
    public void setCheckDeptIds( String checkDeptIds) {
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
     * @return PARENT_ID
     */
    public  Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId( Long parentId) {
        this.parentId = parentId;
    }
}