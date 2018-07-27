package htht.system.ocean.model;

import javax.persistence.Table;

@Table(name = "SHPES_DATA")
public class ShpesDataCustom {

    private ShpesData shpesData;

    private Object GeoData;

    public Object getGeoData() {
        return GeoData;
    }

    public void setGeoData(Object geoData) {
        GeoData = geoData;
    }

    public ShpesData getShpesData() {
        return shpesData;
    }

    public void setShpesData(ShpesData shpesData) {
        this.shpesData = shpesData;
    }
}