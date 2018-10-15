package htht.system.ocean.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Hzdmdz {

    @JSONField(name="NAME")
private  String name;
    @JSONField(name="SIPNAME")
private  String sipName;
    @JSONField(name="ALIAS")
private  String alias;
    @JSONField(name="LON")

private  String  lon;
    @JSONField(name=" LAT")

private  String  lat;
    @JSONField(name=" EAST")
private  String east;
    @JSONField(name = "NORTH")
private  String north;
    @JSONField(name = "CLASID")
private  String  clasid;
    @JSONField(name = "ADDNAME")
private String   addname;
    @JSONField(name = "CODE")
private String code;
    @JSONField(name = "PIC")
private  String pic;
    @JSONField(name = "DECS")
private  String  decs;
    @JSONField(name = "ENTIID")
private  String  entiid;
    @JSONField(name = "COLDATE")
private  String  coldate;
    @JSONField(name = "NAMEDATE")
private  String  nameDate;
    @JSONField(name = "ENDDATE")
private  String endDate;
    @JSONField(name = "POSTCODE")
private  String   postCode;
    @JSONField(name = "WEIGHT")
private  String    weight;
    @JSONField(name = "DATASOURCE")
private  String  datasource;

    @JSONField(name = "EDIT")
private  String   edit;
    @JSONField(name = "EDIT_REASO")
    private  String editReaso;

    @JSONField(name = "SW_POI_ID")
    private String swPoiId;
    @JSONField(name="FID")
    private  double fId;
    @JSONField(name = "FID_HZ_JTC")
    private String  fidHzJtc;
    @JSONField(name = "PROVINCE")
    private String  province;
    @JSONField(name = "CITY")
    private  String city;
    @JSONField(name = "DISTRICT")
    private  String district;
    @JSONField(name = "TOWN")
    private String town;
    @JSONField(name = "VILLAGE")
    private  String  villAge;
    @JSONField(name = "STREET")
    private  String street;


    public double getfId() {
        return fId;
    }

    public void setfId(double fId) {
        this.fId = fId;
    }

    public String getFidHzJtc() {
        return fidHzJtc;
    }

    public void setFidHzJtc(String fidHzJtc) {
        this.fidHzJtc = fidHzJtc;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillAge() {
        return villAge;
    }

    public void setVillAge(String villAge) {
        this.villAge = villAge;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoorpn() {
        return doorpn;
    }

    public void setDoorpn(String doorpn) {
        this.doorpn = doorpn;
    }

    public String getAddCode() {
        return addCode;
    }

    public void setAddCode(String addCode) {
        this.addCode = addCode;
    }

    @JSONField(name = "DOORPN")

    private  String  doorpn;
    @JSONField(name = "ADDCODE")
    private  String addCode;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSipName() {
        return sipName;
    }

    public void setSipName(String sipName) {
        this.sipName = sipName;
    }

    public String getAlias() {
        return alias;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    public String getEast() {
        return east;
    }

    public String getNorth() {
        return north;
    }

    public String getClasid() {
        return clasid;
    }

    public String getAddname() {
        return addname;
    }

    public String getCode() {
        return code;
    }

    public String getPic() {
        return pic;
    }

    public String getDecs() {
        return decs;
    }

    public String getEntiid() {
        return entiid;
    }

    public String getColdate() {
        return coldate;
    }

    public String getNameDate() {
        return nameDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getWeight() {
        return weight;
    }

    public String getDatasource() {
        return datasource;
    }

    public String getEdit() {
        return edit;
    }

    public String getEditReaso() {
        return editReaso;
    }

    public void setEditReaso(String editReaso) {
        this.editReaso = editReaso;
    }

    public String getSwPoiId() {
        return swPoiId;
    }

    public void setSwPoiId(String swPoiId) {
        this.swPoiId = swPoiId;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public void setClasid(String clasid) {
        this.clasid = clasid;
    }

    public void setAddname(String addname) {
        this.addname = addname;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public void setEntiid(String entiid) {
        this.entiid = entiid;
    }

    public void setColdate(String coldate) {
        this.coldate = coldate;
    }

    public void setNameDate(String nameDate) {
        this.nameDate = nameDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }
}
