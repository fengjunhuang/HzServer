package htht.system.ocean.model;

import com.alibaba.fastjson.annotation.JSONField;

public class SiteModel  {

    private String name; //站位名字
    private  Long	detectionDate;  //检测日期
    private  int zid;
    private  long 监测日期;

    private String hydrogen;  //硝酸盐-氮（mg/L）
    private String  ammoniaAndNitrogen;  //氨-氮（mg/L）
    private String  Santocel;//硅酸盐(mg/L）
    private String    dissolvedOxygen; //溶解氧（mg/L）
    private String  suspendedMatter;  //悬浮物
    private String  nitrite;    //亚硝酸盐-氮（mg/L）
    private String chlorophyl; //叶绿素-a（µg/L）
    private String  totalNitroge; //总氮(mg/L）
    private String phosphorus;// 总磷(mg/L）
    private String  phosphoric;//磷酸盐（mg/L）

    public void setDetectionDate(Long detectionDate) {
        this.detectionDate = detectionDate;
    }

    public long get监测日期() {
        return 监测日期;
    }

    public void set监测日期(long 监测日期) {
        this.监测日期 = 监测日期;
    }

    private  String chemicalOxygen;  //化学需氧量(mg/L)
    private  String id;


    public String getPhosphoric() {
        return phosphoric;
    }
    @JSONField(name="磷酸盐")
    public void setPhosphoric(String phosphoric) {
        this.phosphoric = phosphoric;
    }

    public String getHydrogen() {
        return hydrogen;
    }
    @JSONField(name="硝酸盐氮")
    public void setHydrogen(String hydrogen) {
        this.hydrogen = hydrogen;
    }

    public String getAmmoniaAndNitrogen() {
        return ammoniaAndNitrogen;
    }
    @JSONField(name="氨氮")
    public void setAmmoniaAndNitrogen(String ammoniaAndNitrogen) {
        this.ammoniaAndNitrogen = ammoniaAndNitrogen;
    }

    public String getSantocel() {
        return Santocel;
    }
    @JSONField(name="活性硅酸盐")
    public void setSantocel(String santocel) {
        Santocel = santocel;
    }

    public String getDissolvedOxygen() {
        return dissolvedOxygen;
    }
    @JSONField(name="溶解氧")
    public void setDissolvedOxygen(String dissolvedOxygen) {
        this.dissolvedOxygen = dissolvedOxygen;
    }


    public String getSuspendedMatter() {
        return suspendedMatter;
    }
    @JSONField(name="悬浮物")
    public void setSuspendedMatter(String suspendedMatter) {
        this.suspendedMatter = suspendedMatter;
    }

    public String getNitrite() {
        return nitrite;
    }
   @JSONField(name = "亚硝酸盐氮")
    public void setNitrite(String nitrite) {
        this.nitrite = nitrite;
    }

    public String getChlorophyl() {
        return chlorophyl;
    }
    @JSONField(name = "叶绿素")
    public void setChlorophyl(String chlorophyl) {
        this.chlorophyl = chlorophyl;
    }

    public String getTotalNitroge() {
        return totalNitroge;
    }
    @JSONField(name = "总氮")

    public void setTotalNitroge(String totalNitroge) {
        this.totalNitroge = totalNitroge;
    }

    public String getPhosphorus() {
        return phosphorus;
    }
    @JSONField(name = "总磷")
    public void setPhosphorus(String phosphorus) {
        this.phosphorus = phosphorus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(long detectionDate) {
        this.detectionDate = detectionDate;
    }

    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public String getChemicalOxygen() {
        return chemicalOxygen;
    }
@JSONField(name = "化学需氧量")
    public void setChemicalOxygen(String chemicalOxygen) {
        this.chemicalOxygen = chemicalOxygen;
    }
}
