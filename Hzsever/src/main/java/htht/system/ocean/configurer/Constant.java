package htht.system.ocean.configurer;

import org.apache.poi.xssf.streaming.SXSSFCell;

public class Constant {

    public  static  String  FLAG_YES ="成功";
    public  static  String  FLAG_NO="失败";
    public  static   String  UPLOADPATH="D:\\upload\\";
    public  static   String  ZIPPATH="D:\\upload\\zip\\";
    public  static   String  IMG="D:/upload/img/";
    public  static   String  GRAPHICSIMAGE="D:\\GraphicsImage\\";
    public  static   String  DISCHARGE="/img/pic/";
    public static String TIDEBASEURL="http://192.168.15.3:1201/webapi/api/v1/ocean/tide/";
    public static String BOUYASEURL="http://192.168.15.3:1201/webapi/api/v1/ocean/buoy/";
    public static String BOUYList= "http://192.168.15.3:1201/webapi/api/v1/basic/data?key=";
    public static String BOUYBASELIST= "http://192.168.15.3:1201/webapi/api/v1/ocean/buoy/list";
    public static String  BOUY ="http://192.168.15.3:1201/webapi/api/v1/ocean/buoy";
    public static String  TIDE ="http://192.168.15.3:1201/webapi/api/v1/ocean/tide/foreast/huiz";
    public static String  BOUYCURE ="http://192.168.15.3:1201/webapi/api/v1/ocean/buoy";
    //获取潮汐站基本信息
    public  static  String  base ="base?";
    //获取潮汐站列表
    public  static  String  list="list?";
    public  static  String basic="basic?";
    public static String  getBaseTide(String id,boolean ull_visible){

        return TIDEBASEURL+base+"id="+id+"&"+"null_visible="+ull_visible;


    }
    //获取潮汐站列表
    public static String  getTideList(boolean ull_visible){

        return   TIDEBASEURL+list+"null_visible="+ull_visible;


    }
////获取浮标列表
//    public  static  String  getBuoyList(boolean ull_visible, String hour_ingeter){
//
//        return    BOUYASEURL+list+"null_visible="+ull_visible;
//    }
//查询浮标基本信息
    public  static   String getBaseBuoy(String id){
        return   BOUYASEURL+basic+"id="+id;

    }
    //获取海洋浮标实时数据列表
    public  static   String getBaseBasic(String begin_time ,String end_time){

        return   BOUYList+"select_comapi_ocean_buoy_inflist"+"&"+"begin_time="+begin_time+"end_time="+end_time;

    }
    //获取海洋浮标实时数据列表
    public  static   String getBuoyCure(String id){

        return   BOUY+"?id="+id+"&extra=surface_salt%2Cwave%2Cwave_direction%2Ctemperature%2Cpressure%2Cflow_rate%2Csurface_flow%2Cwind_speed%2Cwind_power%2Cwind_direction_value%2Cwind_direction%2Csurface_water_temperature&null_visible=true";

    }
//    // 获取逐时浮标（曲线数据）
//    public static  String  getOceanBuoy(String begin_time ,String end_time,String id){
//
//    }



    public  static   String getLastBuoy(String id){

        return   BOUYList+"select_comapi_bouy_forecast"+"&id="+id;

    }

}
