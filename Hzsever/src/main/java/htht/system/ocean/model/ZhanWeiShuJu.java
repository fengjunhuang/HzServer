package htht.system.ocean.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

public class ZhanWeiShuJu {


    /**
     * 监测日期 : 1401206400000
     * 化学需氧量(mg/L) : 0.76
     */
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    private long 监测日期;
    private  int zid;

    private double _$MgL218; // FIXME check this code




    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    @JSONField(name="jcsj")
    public long get监测日期() {
        return 监测日期;
    }

    public void set监测日期(long 监测日期) {
        this.监测日期 = 监测日期;
    }

    public double get_$MgL218() {
        return _$MgL218;
    }
    @JSONField(name="化学需氧量(mg/L)")
    public void set_$MgL218(double _$MgL218) {
        this._$MgL218 = _$MgL218;
    }


}
