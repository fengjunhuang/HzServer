package htht.system.ocean.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SHPES_IMG_DATA")
public class ShpesImgData {
    @Id
    @Column(name = "IMG_ID")
    private Long imgId;

    @Column(name = "SHP_CHILD_ID")
    private Long shpChildId;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    @Column(name = "IMG_PATH")
    private String imgPath;
    @Column(name ="BRANCH_ID")
    private  long branchId;


    public String getShpDescribe() {
        return shpDescribe;
    }

    public void setShpDescribe(String shpDescribe) {
        this.shpDescribe = shpDescribe;
    }

    @Column(name = "SHP_DESCRIBE")


    private String shpDescribe;

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }



    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Long getShpChildId() {

        return shpChildId;
    }

    public void setShpChildId(Long shpChildId) {
        this.shpChildId = shpChildId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}