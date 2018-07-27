package htht.system.ocean.model;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

public class Discharge {
    @ApiModelProperty(value = "镉(mg/L)")
private String cadmium; //镉(mg/L)
private  String chrome; //铬(mg/L)
private  String   mercury;//汞(mg/L)
private  String    chemicalOxygen ;       //化学耗氧量(mg/L)
private  String        lead;      //铅(mg/L)
private   String      	arsenic ;//砷(mg/L)
private  String     suspendedMatter;//悬浮物(mg/L)
private   Long	detectionDate;    //监测时间
private  String  name;         //站点名字
private  String  totalNitroge;           //总氮(mg/L)
 private String  phosphorus;//  总磷(mg/L)
    private  String  id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDetectionDate() {

        return detectionDate;
    }

    public void setDetectionDate(Long detectionDate) {
        this.detectionDate = detectionDate;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getCadmium() {
        return cadmium;
    }
    @JSONField(name="镉")
    public void setCadmium(String cadmium) {
        this.cadmium = cadmium;
    }

    public String getChrome() {
        return chrome;
    }
    @JSONField(name="铬")
    public void setChrome(String chrome) {
        this.chrome = chrome;
    }

    public String getMercury() {
        return mercury;
    }
    @JSONField(name="汞")
    public void setMercury(String mercury) {
        this.mercury = mercury;
    }

    public String getChemicalOxygen() {
        return chemicalOxygen;
    }
    @JSONField(name="化学耗氧量")
    public void setChemicalOxygen(String chemicalOxygen) {
        this.chemicalOxygen = chemicalOxygen;
    }

    public String getLead() {
        return lead;
    }
    @JSONField(name="铅")
    public void setLead(String lead) {
        this.lead = lead;
    }


    public String getArsenic() {
        return arsenic;
    }
    @JSONField(name="砷")
    public void setArsenic(String arsenic) {
        this.arsenic = arsenic;
    }

    public String getSuspendedMatter() {
        return suspendedMatter;
    }
    @JSONField(name="悬浮物")
    public void setSuspendedMatter(String suspendedMatter) {
        this.suspendedMatter = suspendedMatter;
    }

    public String getTotalNitroge() {
        return totalNitroge;
    }
    @JSONField(name="总氮")
    public void setTotalNitroge(String totalNitroge) {
        this.totalNitroge = totalNitroge;
    }

    public String getPhosphorus() {
        return phosphorus;
    }
    @JSONField(name="总磷")
    public void setPhosphorus(String phosphorus) {
        this.phosphorus = phosphorus;
    }
}
