package htht.system.ocean.model;

import com.sun.xml.internal.bind.v2.runtime.Name;

import java.math.BigDecimal;
import javax.persistence.*;


public class ModelsData {

    @Id
    @Column(name = "MODEL_ID")

    private Long modelId;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name ="SUBJECT_ID" )
    private Long subjectId;
    @Column(name = "BRANCH_ID")
    private Long branchId;

    @Column(name = "LON")
    private Double lon;

    @Column(name = "LAT")
    private Double lat;

    public String getModelsName() {
        return modelsName;
    }

    public void setModelsName(String modelsName) {
        this.modelsName = modelsName;
    }

    @Column(name = "HEIGHT")
    private Double height;

    @Column(name = "SCALE")
    private Double scale;

    @Column(name = "XANGLE")
    private Double xangle;
    @Column(name = "MODELS_NAME")
    private  String modelsName;

    public Double getZangle() {
        return zangle;
    }

    public void setZangle(Double zangle) {
        this.zangle = zangle;
    }

    @Column(name = "ZANGLE")

    private  Double zangle;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"modelId\":")
                .append(modelId);
        sb.append(",\"subjectId\":")
                .append(subjectId);
        sb.append(",\"branchId\":")
                .append(branchId);
        sb.append(",\"lon\":")
                .append(lon);
        sb.append(",\"lat\":")
                .append(lat);
        sb.append(",\"height\":")
                .append(height);
        sb.append(",\"scale\":")
                .append(scale);
        sb.append(",\"xangle\":")
                .append(xangle);
        sb.append(",\"modelsName\":\"")
                .append(modelsName).append('\"');
        sb.append(",\"yangle\":")
                .append(yangle);
        sb.append(",\"filePath\":\"")
                .append(filePath).append('\"');
        sb.append('}');
        return sb.toString();
    }

    @Column(name = "YANGLE")

    private Double yangle;
    @Column(name = "FILE_PATH")
    private  String filePath;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }



    public Double getLon() {
        return lon;
    }

    /**
     * @param lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * @return LAT
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return HEIGHT
     */
    public Double getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * @return SCALE
     */
    public Double getScale() {
        return scale;
    }

    /**
     * @param scale
     */
    public void setScale(Double scale) {
        this.scale = scale;
    }

    /**
     * @return XANGLE
     */
    public Double getXangle() {
        return xangle;
    }

    /**
     * @param xangle
     */
    public void setXangle(Double xangle) {
        this.xangle = xangle;
    }

    /**
     * @return YANGLE
     */
    public Double getYangle() {
        return yangle;
    }

    /**
     * @param yangle
     */
    public void setYangle(Double yangle) {
        this.yangle = yangle;
    }
}