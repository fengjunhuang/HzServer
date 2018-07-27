package htht.system.ocean.model;

import javax.persistence.*;

@Table(name = "SHPES_CHILD_DATA")
public class ShpesChildData {
    @Id
    @Column(name = "SHP_CHILD_ID")
    private Short shpChildId;

    @Column(name = "BRANCH_ID")
    private Short branchId;

    @Column(name = "IMGPATHS")
    private String imgpaths;

    /**
     * @return SHP_CHILD_ID
     */
    public Short getShpChildId() {
        return shpChildId;
    }

    /**
     * @param shpChildId
     */
    public void setShpChildId(Short shpChildId) {
        this.shpChildId = shpChildId;
    }

    /**
     * @return BRANCH_ID
     */
    public Short getBranchId() {
        return branchId;
    }

    /**
     * @param branchId
     */
    public void setBranchId(Short branchId) {
        this.branchId = branchId;
    }

    /**
     * @return IMGPATHS
     */
    public String getImgpaths() {
        return imgpaths;
    }

    /**
     * @param imgpaths
     */
    public void setImgpaths(String imgpaths) {
        this.imgpaths = imgpaths;
    }
}