package htht.system.ocean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.MultipartConfigElement;
import java.io.FileNotFoundException;

@EnableTransactionManagement
@ServletComponentScan
@SpringBootApplication
public class Application {
    private final static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws FileNotFoundException


    {
//        String  ipAddress ="http://192.168.1.247:8888/";
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
////            params.add(new BasicNameValuePair("userName", "Sun"));
//       String url =ipAddress+"branch/list";
//        getRest(url,params);
        logger.info("logback 成功了");
        logger.error("logback 成功了");
      SpringApplication.run(Application.class, args);

    }

//
//    public  static String getRest(String url,List<NameValuePair> params){
//        // 创建默认的httpClient实例.
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        // 创建httppost
//        HttpPost httppost = new HttpPost(url);
//
//        UrlEncodedFormEntity uefEntity;
//
//        try{
//            uefEntity = new UrlEncodedFormEntity(params, "UTF-8");
//            httppost.setEntity(uefEntity);
//            CloseableHttpResponse response = httpclient.execute(httppost);
//            HttpEntity entity = response.getEntity();
//            String json= EntityUtils.toString(entity, "UTF-8");
//            int code= response.getStatusLine().getStatusCode();
//            if(code==200 ||code ==204){
//                return json;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return "";
//    }
/*
        // 为了支持中文路径，请添加下面这句代码


        String fileName = "D:\\新建文件夹\\等高线\\LNDELV7.shp";
        // 读取影像数据
        gdal.SetConfigOption("GDAL_FILENAME_IS_UTF8", "YES");
        // 为了使属性表字段支持中文
        gdal.SetConfigOption("SHAPE_ENCODING", "");
        gdal.AllRegister();
        ogr.RegisterAll();

       Driver oDerive = ogr.GetDriverByName("ESRI Shapefile");
        DataSource ds=   oDerive.Open(fileName,1);
     *//*   DataSource ds = ogr.Open(fileName,1);
	        Dataset dataset = gdal.Open(fileName, gdalconstConstants.GA_ReadOnly);*//*
        if(ds == null) {
            System.err.println("GDALOpen failed - " + gdal.GetLastErrorNo());
            System.err.println(gdal.GetLastErrorMsg());

            System.exit(1);
        }
*//*
	        Driver driver = dataset.GetDriver();
	        System.out.println("Driver: " + driver.getShortName() + "/" + driver.getLongName());

	        // 读取影像信息
	        int xSize = dataset.getRasterXSize();
	        int ySzie = dataset.getRasterYSize();
	        int nBandCount = dataset.getRasterCount();
	        System.out.println("Size is " + xSize + ", " + ySzie + ", " + nBandCount);

	        Band band = dataset.GetRasterBand(1);
	        int type = band.GetRasterDataType();
	        // type为1，代表的是Eight bit unsigned integer
	        System.out.println(type);

	        dataset.delete();*//*

	        gdal.GDALDestroyDriverManager();

        System.out.println("打开文件成功！");
        org.gdal.ogr.Driver dv = ogr.GetDriverByName("GeoJSON");
        if (dv == null) {
            System.out.println("打开驱动失败！");
            return;
        }
        System.out.println("打开驱动成功！");
        String fileName1 = "D:\\新建文件夹\\等高线\\LNDELV7.geojson";
      DataSource dataSource=  dv.CopyDataSource(ds, fileName1);

      if(dataSource==null){
          System.err.println("GDALOpen failed - " + gdal.GetLastErrorNo());
          System.err.println(gdal.GetLastErrorMsg());
      }else {
          System.out.println("转换成功！");
      }


    }*/



    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("1024MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("1024MB");
        return factory.createMultipartConfig();
    }
}

