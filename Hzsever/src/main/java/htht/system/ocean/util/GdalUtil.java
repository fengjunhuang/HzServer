package htht.system.ocean.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import htht.system.ocean.configurer.Constant;
import org.gdal.gdal.Dataset;

import org.gdal.gdal.gdal;
import org.gdal.gdalconst.gdalconstConstants;
import org.gdal.ogr.DataSource;
import org.gdal.ogr.Driver;
import org.gdal.ogr.ogr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GdalUtil {

    public static HashMap<String, Object> toGonson(String fileName, String branchName) {


        // 读取影像数据
        gdal.SetConfigOption("GDAL_FILENAME_IS_UTF8", "YES");
        // 为了使属性表字段支持中文
        gdal.SetConfigOption("SHAPE_ENCODING", "");
        gdal.AllRegister();
        ogr.RegisterAll();
        File file = new File(fileName);
        Driver oDerive = ogr.GetDriverByName("ESRI Shapefile");
        DataSource ds = oDerive.Open(fileName, 1);

        Dataset dataset = gdal.Open(fileName, gdalconstConstants.GA_ReadOnly);
        if (ds == null) {
            System.err.println("GDALOpen failed - " + gdal.GetLastErrorNo());
            System.err.println(gdal.GetLastErrorMsg());

            System.exit(1);
        }

        org.gdal.ogr.Driver dv = ogr.GetDriverByName("GeoJSON");
        if (dv == null) {
            System.out.println("打开驱动失败！");
            return null;
        }
        System.out.println("打开驱动成功！");

        String fileName1 = Constant.UPLOADPATH + System.currentTimeMillis()+branchName + ".geojosn";

        DataSource dataSource = dv.CopyDataSource(ds, fileName1);

        if (dataSource == null) {
            System.err.println("GDALOpen failed - " + gdal.GetLastErrorNo());
            System.err.println(gdal.GetLastErrorMsg());
        } else {
            System.out.println("转换成功！");
        }
        String str = ReadFileUtil.readFileByLines(fileName1);
        HashMap<String,Object> map=getGeoReturn(str);
        map.put("geoJson",str);
        map.put("fileName",fileName1);

        return  map;
    }


    public static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }


            br.close();
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        String ss = result.toString();
        return result.toString();
    }

    public static void main(String[] args) {
//        File file = new File("D:\\upload\\zip\\海域界线.zip\\海域界线\\界线.shp");
        gdal.GetLastErrorMsg();
    }

    public static HashMap<String, Object> getGeoReturn(String s) {

        JSONObject jsonObject = JSON.parseObject(s);
        JSONArray jsonObject1 = (JSONArray) jsonObject.getJSONArray("features");
        JSONObject jsonObject2 = ((JSONObject) (jsonObject1.get(0))).getJSONObject("properties");
        String type = (((JSONObject) (jsonObject1.getJSONObject(0).getJSONObject("geometry"))).getString("type"));

     JSONArray coordinates= (((JSONObject) (jsonObject1.getJSONObject(0).getJSONObject("geometry"))).getJSONArray("coordinates"));

       List<Double> list= getdisPlaylist(type,coordinates);
       try {

       }catch (Exception e){

       }
       Integer WHETHER3D =0;
       if(list.size()==2){
           WHETHER3D=0;
       }else {
           WHETHER3D=1;
       }
        Set<String> strings = jsonObject2.keySet();
        String properties = "";

        for (String str : strings) {
            properties = properties+","+str ;
        }
        String ss = properties.substring(1, properties.length() );
        HashMap<String, Object> map = new HashMap<>();
        map.put("properties", ss);
        map.put("type", type);
        map.put("whether3d",WHETHER3D);
        map.put("displayType", getdisPlayType(type,WHETHER3D));

        return map;


    }



    public static String getdisPlayType(String type,Integer WHETHER3D ){
        switch (type) {
            case "Point":
                if(WHETHER3D==0){
                    return "p2d";
                }else {
                    return "p3d" ;
                }


            case "MultiPoint":
                if(WHETHER3D==0){
                    return "p2d";
                }else {
                    return "p3d" ;
                }


            case "LineString":
                if(WHETHER3D==0){
                    return "l2d";
                }else {
                    return "l3d" ;
                }


            case "MultiLineString":
                if(WHETHER3D==0){
                    return "l2d";
                }else {
                    return "l3d" ;
                }

            case "Polygon":
                if(WHETHER3D==0){
                    return "g2d";
                }else {
                    return "g3d" ;
                }


            case "MultiPolygon":
                if(WHETHER3D==0){
                    return "g2d";
                }else {
                    return "g3d" ;
                }


        }
        return "未知类型";
    }
    public static List<Double> getdisPlaylist(String type,JSONArray coordinates){
        List<Double> list=null;
        switch (type) {

            case "Point":

     list=coordinates.toJavaList(Double.class);
                break;
            case "MultiPoint":
                list=coordinates.toJavaList(Double.class);
                break;

            case "LineString":
                list= (List<Double>) coordinates.get(0);
                break;
            case "MultiLineString":
                list= (List<Double>) coordinates.get(0);
                break;
            case "Polygon":

               list= ((List<List<Double>>) coordinates.get(0)).get(0);
                break;

            case "MultiPolygon":

                list= ((List<List<Double>>) coordinates.get(0)).get(0);
                break;

        }
        return list;
    }
}
