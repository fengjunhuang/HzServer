package htht.system.ocean.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "SHPES_DATA")
public class ShpesData {
    @Id
    @Column(name = "SHP_ID")
    private Long shpId;

    @Column(name = "SHP_NAME")
    private String shpName;

    @Column(name = "SHP_TYPE")
    private String shpType;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name = "FILE_IDS")
    private String fields;

    @Column(name = "DISPLAY_FILE")
    private String displayfield;

    @Column(name = "COLOR")
    private String color;
    @Column(name = "SUBJECT_ID")

    private  Long subjectId;

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    @Column(name = "CRATE_TIME")

    private Date crateTime;

    @Column(name = "CREATE_USER_ID")
    private Long createUserId;
    @Column(name ="WHETHER3D")
    private Integer whether3d;
    @Column(name = "ICON_TYPE")
    private String iconType;
    public Integer getWhether3d() {
        return whether3d;
    }

    public void setWhether3d(Integer whether3d) {
        this.whether3d = whether3d;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    @Column(name ="DISPLAY_TYPE")
    private String displayType;

    public Long getTbranchId() {
        return tbranchId;
}

    public void setTbranchId(Long tbranchId) {
        this.tbranchId = tbranchId;
    }

    @Column(name = "GEO_JSON")
    private String geoJson;

    @Column(name ="TBRANCH_ID")
    private Long tbranchId;

    public Long getShpId() {
        return shpId;
    }

    public void setShpId(Long shpId) {
        this.shpId = shpId;
    }


    /**
     * @return SHP_NAME
     */

    public String getShpName() {
        return shpName;
    }

    /**
     * @param shpName
     */
    public void setShpName(String shpName) {
        this.shpName = shpName;
    }

    /**
     * @return SHP_TYPE
     */
    public String getShpType() {
        return shpType;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getDisplayfield() {
        return displayfield;
    }

    public void setDisplayfield(String displayfield) {
        this.displayfield = displayfield;
    }

    /**
     * @param shpType
     */

    public void setShpType(String shpType) {
        this.shpType = shpType;
    }


    /**
     * @return COLOR
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return CRATE_TIME
     */
    public Date getCrateTime() {
        return crateTime;
    }

    /**
     * @param crateTime
     */
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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