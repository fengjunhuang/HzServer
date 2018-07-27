package htht.system.ocean.model;



import java.util.Date;
import javax.persistence.*;

@Table(name = "FILE_DATA")
public class FileData {

   @Id
    @Column(name = "BRANCH_ID")
    private Long branchId;

    @Column(name = "FILE_EXTENTION")
    private String fileExtention;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_SIZE")
    private Long fileSize;



    /**
     * @return BRANCH_ID
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * @param branchId
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * @return FILE_EXTENTION
     */
    public String getFileExtention() {
        return fileExtention;
    }

    /**
     * @param fileExtention
     */
    public void setFileExtention(String fileExtention) {
        this.fileExtention = fileExtention;
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
     * @return FILE_NAME
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return FILE_SIZE
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}