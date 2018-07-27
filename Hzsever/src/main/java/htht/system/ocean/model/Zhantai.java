package htht.system.ocean.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Zhantai {


    /**
     * 经度 : 115.008102777778
     * 纬度 : 22.6189277777778
     * 监测站位 : GD051
     */

    private double 经度;
    private double 纬度;
    private String 监测站位;
    @JSONField(name="longitude")
    public double get经度() {
        return 经度;
    }

    public void set经度(double 经度) {
        this.经度 = 经度;
    }
    @JSONField(name="latitude")
    public double get纬度() {
        return 纬度;
    }

    public void set纬度(double 纬度) {
        this.纬度 = 纬度;
    }
    @JSONField(name="jczw")
    public String get监测站位() {
        return 监测站位;
    }

    public void set监测站位(String 监测站位) {
        this.监测站位 = 监测站位;
    }
}
