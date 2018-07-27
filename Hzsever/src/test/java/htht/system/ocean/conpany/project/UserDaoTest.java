package htht.system.ocean.conpany.project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import htht.system.ocean.dao.UserDaoImpl;
import htht.system.ocean.model.*;
import htht.system.ocean.service.BranchService;
import htht.system.ocean.service.ShpesDataService;
import htht.system.ocean.service.ShpesImgDataService;

import htht.system.ocean.util.FileUtil;
import org.bson.Document;
import org.gdal.gdal.gdal;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Distance;

import org.springframework.data.geo.GeoModule;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static htht.system.ocean.configurer.Constant.DISCHARGE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserDaoImpl userDao;
    @Resource
    private BranchService branchService;
    @Resource
    private ShpesDataService shpesDataService;
    @Resource
    private ShpesImgDataService shpesImgDataService;
    @Test
    public void testSaveUser() throws Exception {
//        UserEntity user=new UserEntity();
//
//        user.setUserName("小明");
//        user.setPassWord("fffooo123");
//        userDao.saveUser(user);
        gdal.GetLastErrorMsg();
    }

    @Test
    public void findUserByUserName(){
        Query query = new Query();
        query.addCriteria(Criteria.where("zid").is(7));
List<SiteModel> zhanWeiShuJus=        mongoTemplate.find(query,SiteModel.class);
System.out.println("");

    }

    @Test
public  void   saveImg(){
    File file =new File("D:\\upload\\img\\pic");


    for(File f :file.listFiles()){
        for(File cf:f.listFiles()) {
            ShpesImgData shpesImgData = new ShpesImgData();
            String[] ffff = cf.getPath().split("\\\\");

            String id = ffff[ffff.length - 2];
            shpesImgData.setImgId(Long.valueOf(id));
            shpesImgData.setImgPath(DISCHARGE + id+"/"+ffff[ffff.length - 1]);
            shpesImgData.setShpDescribe("排污口图片资源");
            shpesImgData.setBranchId(9545);
            shpesImgData.setShpChildId(Long.valueOf(id));
            String ffff1 = f.getPath();
            shpesImgDataService.createImg(shpesImgData);

        }
    }

}
    @Test
    public  void ruku(){
        File files =new File("C:\\海水质量");
//       saveSite(new File("C:\\惠州\\惠州项目数据（整理）6.26\\3海洋环境要素可视化数据\\陆源入海排污口"));
//      File fffff=new File("C:\\惠州\\惠州项目数据（整理）6.26\\3海洋环境要素可视化数据\\陆源入海排污口\\排污口_总氮");
        for(File temp:files.listFiles()){//Java5的新特性之一就是增强的for循环。

            if(temp.isDirectory()){
             tt(temp);
            }

        }
//        ff(fffff);
    }
    public  void saveSite(File file ){

        File[] files=   FileUtil.listAll(file);
        Excel2JSONHelper excelHelper =  Excel2JSONHelper.getExcel2JSONHelper();

        //dir文件，0代表是第一行为保存到数据库或者实体类的表头，一般为英文的字符串，2代表是第二种模板，

        JSONArray  zhanWei = excelHelper.readExcle(files[files.length-1], 0, 2);
        GeoModelPoint geoModule =new GeoModelPoint();
        geoModule.setType("FeatureCollection");
        List<Zhantai>zhantaisa=  zhanWei.toJavaList(Zhantai.class);
        ArrayList<  GeoModelPoint.FeaturesBean> featuresBeanList =new ArrayList<>();
        for(Zhantai zhantai :zhantaisa ){

            GeoModelPoint.FeaturesBean featuresBean =new  GeoModelPoint.FeaturesBean();
            featuresBean.setId(zhantaisa.indexOf(zhantai));
            GeoModelPoint.FeaturesBean.PropertiesBean  bean=  new   GeoModelPoint.FeaturesBean.PropertiesBean();
            GeoModelPoint.FeaturesBean.GeometryBean geometryBean=new GeoModelPoint.FeaturesBean.GeometryBean();
            featuresBean.setGeometry(geometryBean);
            bean.setName(zhantai.get监测站位());
            bean.setId(zhantaisa.indexOf(zhantai));
            featuresBean.setProperties(bean);
            featuresBean.getGeometry().setType("Point");

            List<Double> doubles =new ArrayList<>();

            doubles.add(zhantai.get经度());
            doubles.add(zhantai.get纬度());

            featuresBean.getGeometry().setCoordinates(doubles);
            featuresBeanList.add(featuresBean);
        }


        geoModule.setFeatures(featuresBeanList);
        saveShp(geoModule,file.getName());

    }

    @Test
    public void tt() {


        File[] files = FileUtil.listAll( new File("C:\\惠州项目数据（整理）6.26\\3海洋环境要素可视化数据\\海水质量\\海水质量_化学需氧量(COD)"));

                    Excel2JSONHelper excelHelper =  Excel2JSONHelper.getExcel2JSONHelper();

            //dir文件，0代表是第一行为保存到数据库或者实体类的表头，一般为英文的字符串，2代表是第二种模板，

            JSONArray  zhanWei = excelHelper.readExcle(files[files.length-1], 0, 2);
            GeoModelPoint geoModule =new GeoModelPoint();
            geoModule.setType("FeatureCollection");
            List<Zhantai>zhantaisa=  zhanWei.toJavaList(Zhantai.class);
            ArrayList<  GeoModelPoint.FeaturesBean> featuresBeanList =new ArrayList<>();
            for(Zhantai zhantai :zhantaisa ){

                GeoModelPoint.FeaturesBean featuresBean =new  GeoModelPoint.FeaturesBean();
                featuresBean.setId(zhantaisa.indexOf(zhantai));
                GeoModelPoint.FeaturesBean.PropertiesBean  bean=  new   GeoModelPoint.FeaturesBean.PropertiesBean();
                GeoModelPoint.FeaturesBean.GeometryBean geometryBean=new GeoModelPoint.FeaturesBean.GeometryBean();
                featuresBean.setGeometry(geometryBean);
                bean.setName(zhantai.get监测站位());
                bean.setId(zhantaisa.indexOf(zhantai));
            featuresBean.setProperties(bean);
            featuresBean.getGeometry().setType("Point");

             List<Double> doubles =new ArrayList<>();

            doubles.add(zhantai.get经度());
            doubles.add(zhantai.get纬度());

            featuresBean.getGeometry().setCoordinates(doubles);
            featuresBeanList.add(featuresBean);
        }


        geoModule.setFeatures(featuresBeanList);


        String aa= JSON.toJSONString(zhantaisa);
        for (int i = 1; i < files.length; i++) {
            JSONArray jsonArray = excelHelper.readExcle(files[i], 0, 2);
           String  S= jsonArray.toJSONString();

            System.out.println(jsonArray.toJSONString());
            if(i==files.length-1){


            }else {

               List<SiteModel> zhantais= jsonArray.toJavaList(SiteModel.class);

                for(SiteModel siteModel:zhantais) {
                    siteModel.setId((files[i].getName().replace(".xlsx", "")+(i))+"diji"+zhantais.indexOf(siteModel));
                    Query query = new Query();
                    query.addCriteria(Criteria.where("id").is(siteModel.getId()));

                SiteModel bean=    mongoTemplate.findOne(query,SiteModel.class);
          if(bean==null){
                        bean=new SiteModel();
                        bean.setId((files[i].getName().replace(".xlsx", "")+(i ))+"diji"+zhantais.indexOf(siteModel));
                    }

                    if(siteModel.getAmmoniaAndNitrogen()!=null){

                        bean.setAmmoniaAndNitrogen((siteModel.getAmmoniaAndNitrogen()));
                        System.out.println("bean.setAmmoniaAndNitrogen((siteModel.getAmmoniaAndNitrogen()));");
                    }
                    if(siteModel.getHydrogen()!=null){
                        bean.setHydrogen(siteModel.getHydrogen());
                        System.out.println("bean.setHydrogen(siteModel.getHydrogen());");
                    }
                    if(siteModel.getPhosphoric()!=null){
                        bean.setPhosphoric(siteModel.getPhosphoric());
                        System.out.println("bean.setPhosphoric(siteModel.getPhosphoric());");
                    }
                    if(siteModel.getChlorophyl()!=null){
                        bean.setChlorophyl(siteModel.getChlorophyl());
                        System.out.println("bean.setChlorophyl(siteModel.getChlorophyl());");
                    }
                    if(siteModel.getSantocel()!=null){
                        bean.setSantocel(siteModel.getSantocel());
                        System.out.println("bean.setSantocel(siteModel.getSantocel());");
                    }
                    if(siteModel.getChemicalOxygen()!=null){
                        bean.setChemicalOxygen(siteModel.getChemicalOxygen());
                        System.out.println("bean.setChemicalOxygen(siteModel.getChemicalOxygen());");
                    }
                    if(siteModel.getPhosphorus()!=null){
                        bean.setPhosphorus(siteModel.getPhosphorus());
                        System.out.println("   bean.setPhosphorus(siteModel.getPhosphorus());");
                    }
                    if(siteModel.getPhosphoric()!=null){
                        bean.setPhosphoric(siteModel.getPhosphoric());
                        System.out.println(" bean.setPhosphoric(siteModel.getPhosphoric());");
                    }
                    if(siteModel.getSuspendedMatter()!=null){
                        bean.setSuspendedMatter(siteModel.getSuspendedMatter());
                        System.out.println("bean.setSuspendedMatter(siteModel.getSuspendedMatter());");
                    }
                    if(siteModel.getNitrite()!=null){
                        bean.setNitrite(siteModel.getNitrite());
                        System.out.println("bean.setNitrite(siteModel.getNitrite())");
                    }
                    if(siteModel.getDissolvedOxygen()!=null){
                        bean.setDissolvedOxygen(siteModel.getDissolvedOxygen());
                        System.out.println("bean.setDissolvedOxygen");
                    }
                    if(siteModel.getTotalNitroge()!=null){
                        bean.setTotalNitroge(siteModel.getTotalNitroge());
                        System.out.println("  bean.setTotalNitroge(siteModel.getTotalNitroge());");
                    }
                    if(bean==null){

                    }
                  try{
//                    bean.setDetectionDate(siteModel.get监测日期());
                      bean.setName((files[i].getName().replace(".xlsx", "")));
                      bean.setZid(i - 1);



                      mongoTemplate.save(bean);


                  }catch (Exception e){
                        e.printStackTrace();
                        System.out.println(files[i].getName());

                  }


                }




            }

        }
    }


    @Test
    public void updateUser(){
        UserEntity user=new UserEntity();
        user.setId(2l);
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userDao.updateUser(user);

    }

    @Test
    public void deleteUserById(){
        userDao.deleteUserById(1l);
    }
//@Test
//    public  void saveGeoJson() throws IOException {
//    final String IP_ADDRESS = "127.0.0.1"; // 本机地址
//    final String DB_NAME = "test"; // 数据库名称
//    final String CEOLLECTION_NAM = "continents1"; // Collection名称
//
//    // 使用GeoTools读取ShapeFile文件
//    File shapeFile = new File("D:\\upload\\zip\\1528704701369海岛.zip\\海岛.shp");
//    ShapefileDataStore store = new ShapefileDataStore(shapeFile.toURI().toURL());
//    SimpleFeatureSource sfSource = store.getFeatureSource();
//    SimpleFeatureIterator sfIter = sfSource.getFeatures().features();
//    // 初始化mongodb
////    MongoClient client = new MongoClient(IP_ADDRESS);
////    MongoDatabase db = client.getDatabase(DB_NAME);
////    db.createCollection(COLLECTION_NAME);
////    MongoCollection<Document> coll = db.getCollection(COLLECTION_NAME);
//    // 从ShapeFile文件中遍历每一个Feature，然后将Feature转为GeoJSON字符串，最后将字符串插入到mongodb的Collection中
//
//    while (sfIter.hasNext()) {
//        SimpleFeature feature = (SimpleFeature) sfIter.next();
//        // Feature转GeoJSON
//
//        FeatureJSON fjson = new FeatureJSON();
//        StringWriter writer = new StringWriter();
//        fjson.writeFeature(feature, writer);
//        String sjson = writer.toString();
//        System.out.println(sjson);
//        // 插入到Collection中
//
//        Document doc = Document.parse(sjson);
//       Object object= doc.get("");
//        mongoTemplate.insert(doc,CEOLLECTION_NAM);
//
//
//    }
//
////spring 使用MongoOperations
//    Point location = new Point(-73.99171, 40.738868);
//    NearQuery query = NearQuery.near(location).maxDistance(new Distance(10, Metrics.MILES));
//
//
//    System.out.println("数据导入完毕！");
//}

    public  long saveShp(GeoModelPoint geoModelPoint,String fileName) {
        Branch branch = new Branch();
        branch.setBranchName(fileName);

        branch.setCreateTime(new Date(System.currentTimeMillis()));
        branch.setParentId(1000l);
        branch.setNodeType(1l);
        ShpesData shpesData = new ShpesData();
        shpesData.setShpName(fileName);
        shpesData.setGeoJson(JSON.toJSONString(geoModelPoint));
        shpesData.setTbranchId(branch.getBranchId());
        shpesData.setShpType("Point");
        shpesData.setFields("name,Id");
        shpesData.setDisplayType("name");
        shpesData.setWhether3d(0);
        shpesData.setDisplayType("p3d");
        shpesData.setColor("rgba(255,255,255,1)");

        branchService.createUser(branch);
        shpesData.setTbranchId(branch.getBranchId());
        shpesDataService.insert(shpesData);
        Document doc = Document.parse(shpesData.getGeoJson());
        mongoTemplate.insert(doc,branch.getBranchId()+"");
        return  branch.getBranchId();
    }
    public void tt(File file1) {


        File[] files = FileUtil.listAll( file1);

        Excel2JSONHelper excelHelper =  Excel2JSONHelper.getExcel2JSONHelper();

        //dir文件，0代表是第一行为保存到数据库或者实体类的表头，一般为英文的字符串，2代表是第二种模板，

        JSONArray  zhanWei = excelHelper.readExcle(files[files.length-1], 0, 2);
        GeoModelPoint geoModule =new GeoModelPoint();
        geoModule.setType("FeatureCollection");
        List<Zhantai>zhantaisa=  zhanWei.toJavaList(Zhantai.class);
        ArrayList<  GeoModelPoint.FeaturesBean> featuresBeanList =new ArrayList<>();
        for(Zhantai zhantai :zhantaisa ){

            GeoModelPoint.FeaturesBean featuresBean =new  GeoModelPoint.FeaturesBean();
            featuresBean.setId(zhantaisa.indexOf(zhantai));
            GeoModelPoint.FeaturesBean.PropertiesBean  bean=  new   GeoModelPoint.FeaturesBean.PropertiesBean();
            GeoModelPoint.FeaturesBean.GeometryBean geometryBean=new GeoModelPoint.FeaturesBean.GeometryBean();
            featuresBean.setGeometry(geometryBean);
            bean.setName(zhantai.get监测站位());
            bean.setId(zhantaisa.indexOf(zhantai));
            featuresBean.setProperties(bean);
            featuresBean.getGeometry().setType("Point");

            List<Double> doubles =new ArrayList<>();

            doubles.add(zhantai.get经度());
            doubles.add(zhantai.get纬度());

            featuresBean.getGeometry().setCoordinates(doubles);
            featuresBeanList.add(featuresBean);
        }


        geoModule.setFeatures(featuresBeanList);


        String aa= JSON.toJSONString(zhantaisa);
        for (int i = 1; i < files.length; i++) {
            JSONArray jsonArray = excelHelper.readExcle(files[i], 0, 2);
            String  S= jsonArray.toJSONString();

            System.out.println(jsonArray.toJSONString());
            if(i==files.length-1){


            }else {

                List<SiteModel> zhantais= jsonArray.toJavaList(SiteModel.class);

                for(SiteModel siteModel:zhantais) {
                    siteModel.setId((files[i].getName().replace(".xlsx", "")+(i))+"diji"+zhantais.indexOf(siteModel));
                    Query query = new Query();
                    query.addCriteria(Criteria.where("id").is(siteModel.getId()));

                    SiteModel bean=    mongoTemplate.findOne(query,SiteModel.class);
                    if(bean==null){
                        bean=new SiteModel();
                        bean.setId((files[i].getName().replace(".xlsx", "")+(i ))+"diji"+zhantais.indexOf(siteModel));
                    }
                    if(siteModel.getAmmoniaAndNitrogen()!=null){

                        if(isNumeric(siteModel.getAmmoniaAndNitrogen())){
                            bean.setAmmoniaAndNitrogen((siteModel.getAmmoniaAndNitrogen()));
                        }else {
                            bean.setAmmoniaAndNitrogen("-");
                        }

                        System.out.println("bean.setAmmoniaAndNitrogen((siteModel.getAmmoniaAndNitrogen()));");
                    }
                    if(siteModel.getHydrogen()!=null){
                        if(isNumeric(siteModel.getHydrogen())){
                        bean.setHydrogen(siteModel.getHydrogen());
                        System.out.println("bean.setHydrogen(siteModel.getHydrogen());");
                        }else {
                            bean.setHydrogen("-");
                        }
                    }
                    if(siteModel.getPhosphoric()!=null){
                        if(isNumeric(siteModel.getPhosphoric())){
                        bean.setPhosphoric(siteModel.getPhosphoric());
                        System.out.println("bean.setPhosphoric(siteModel.getPhosphoric());");
                        }else {
                            bean.setPhosphoric("-");
                        }
                    }
                    if(siteModel.getChlorophyl()!=null){
                        if(isNumeric(siteModel.getChlorophyl())){
                        bean.setChlorophyl(siteModel.getChlorophyl());
                        System.out.println("bean.setChlorophyl(siteModel.getChlorophyl());");
                        }else {
                            System.out.println("bean.setChlorophyl(siteModel.getChlorophyl());"+siteModel.getChlorophyl());
                            bean.setChlorophyl("-");
                        }
                    }
                    if(siteModel.getSantocel()!=null){
                        if(isNumeric(siteModel.getSantocel())){
                        bean.setSantocel(siteModel.getSantocel());
                        System.out.println("bean.setSantocel(siteModel.getSantocel());");
                        }else {
                            bean.setSantocel("-");
                        }
                    }
                    if(siteModel.getChemicalOxygen()!=null){
                        if(isNumeric(siteModel.getChemicalOxygen())){
                        bean.setChemicalOxygen(siteModel.getChemicalOxygen());
                        System.out.println("bean.setChemicalOxygen(siteModel.getChemicalOxygen());");
                        }else {
                            bean.setChemicalOxygen("-");
                        }
                    }
                    if(siteModel.getPhosphorus()!=null){
                        if(isNumeric(siteModel.getPhosphorus())){
                        bean.setPhosphorus(siteModel.getPhosphorus());
                        System.out.println("   bean.setPhosphorus(siteModel.getPhosphorus());");
                        }else {
                            bean.setPhosphorus("-");
                        }
                    }
                    if(siteModel.getPhosphoric()!=null){
                        if(isNumeric(siteModel.getPhosphoric())){
                        bean.setPhosphoric(siteModel.getPhosphoric());
                        System.out.println(" bean.setPhosphoric(siteModel.getPhosphoric());");
                        }else {
                            bean.setPhosphoric("-");
                        }
                    }
                    if(siteModel.getSuspendedMatter()!=null){
                        if(isNumeric(siteModel.getSuspendedMatter())){
                        bean.setSuspendedMatter(siteModel.getSuspendedMatter());
                        System.out.println("bean.setSuspendedMatter(siteModel.getSuspendedMatter());");
                        }else {
                            bean.setSuspendedMatter("-");
                        }
                    }
                    if(siteModel.getNitrite()!=null){
                        if(isNumeric(siteModel.getNitrite())){
                        bean.setNitrite(siteModel.getNitrite());
                        System.out.println("bean.setNitrite(siteModel.getNitrite())");
                        }else {
                            bean.setNitrite("-");
                        }
                    }
                    if(siteModel.getDissolvedOxygen()!=null){
                        bean.setDissolvedOxygen(siteModel.getDissolvedOxygen());
                        System.out.println("bean.setDissolvedOxygen");
                        if(isNumeric(siteModel.getDissolvedOxygen())){
                            bean.setDissolvedOxygen(siteModel.getDissolvedOxygen());

                        }else {
                            bean.setDissolvedOxygen("-");

                        }
                    }
                    if(siteModel.getTotalNitroge()!=null){

                        System.out.println("  bean.setTotalNitroge(siteModel.getTotalNitroge());"+siteModel.getTotalNitroge());
                        if(isNumeric(siteModel.getTotalNitroge())){
                            bean.setTotalNitroge(siteModel.getTotalNitroge());
                        }else {
                            bean.setTotalNitroge("-");
                        }
                    }
                    if(bean==null){

                    }
                    try{
                        bean.setDetectionDate(siteModel.get监测日期());
                        bean.setName((files[i].getName().replace(".xlsx", "")));
                        bean.setZid(i - 1);



                        mongoTemplate.save(bean);


                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println(files[i].getName());

                    }


                }




            }

        }
        Query query = new Query();
        query.addCriteria(Criteria.where("detectionDate").is(0));
        mongoTemplate.findAllAndRemove(query,SiteModel.class);
    }
    public void ff(File file1) {


        File[] files = FileUtil.listAll( file1);

        Excel2JSONHelper excelHelper =  Excel2JSONHelper.getExcel2JSONHelper();

        //dir文件，0代表是第一行为保存到数据库或者实体类的表头，一般为英文的字符串，2代表是第二种模板，

        JSONArray  zhanWei = excelHelper.readExcle(files[files.length-1], 0, 2);
        GeoModelPoint geoModule =new GeoModelPoint();
        geoModule.setType("FeatureCollection");
        List<Zhantai>zhantaisa=  zhanWei.toJavaList(Zhantai.class);
        ArrayList<  GeoModelPoint.FeaturesBean> featuresBeanList =new ArrayList<>();
        for(Zhantai zhantai :zhantaisa ){

            GeoModelPoint.FeaturesBean featuresBean =new  GeoModelPoint.FeaturesBean();
            featuresBean.setId(zhantaisa.indexOf(zhantai));
            GeoModelPoint.FeaturesBean.PropertiesBean  bean=  new   GeoModelPoint.FeaturesBean.PropertiesBean();
            GeoModelPoint.FeaturesBean.GeometryBean geometryBean=new GeoModelPoint.FeaturesBean.GeometryBean();
            featuresBean.setGeometry(geometryBean);
            bean.setName(zhantai.get监测站位());
            bean.setId(zhantaisa.indexOf(zhantai));
            featuresBean.setProperties(bean);
            featuresBean.getGeometry().setType("Point");

            List<Double> doubles =new ArrayList<>();

            doubles.add(zhantai.get经度());
            doubles.add(zhantai.get纬度());

            featuresBean.getGeometry().setCoordinates(doubles);
            featuresBeanList.add(featuresBean);
        }


        geoModule.setFeatures(featuresBeanList);


        String aa= JSON.toJSONString(zhantaisa);
        for (int i = 1; i < files.length; i++) {
            JSONArray jsonArray = excelHelper.readExcle(files[i], 0, 2);
            String  S= jsonArray.toJSONString();

            System.out.println(jsonArray.toJSONString());
            if(i==files.length-1){


            }else {

                List<Discharge> zhantais= jsonArray.toJavaList(Discharge.class);

                for(Discharge siteModel:zhantais) {
                    siteModel.setId((files[i].getName().replace(".xlsx", "")+(i))+"diji"+zhantais.indexOf(siteModel));
                    Query query = new Query();
                    query.addCriteria(Criteria.where("id").is(siteModel.getId()));

                    Discharge bean=    mongoTemplate.findOne(query,Discharge.class);
                    if(bean==null){
                        bean=new Discharge();
                        bean.setId((files[i].getName().replace(".xlsx", "")+(i ))+"diji"+zhantais.indexOf(siteModel));
                    }
                    if(siteModel.getArsenic()!=null){

                        if(isNumeric(siteModel.getArsenic())){
                            bean.setArsenic(siteModel.getArsenic());
                        }else {
                            bean.setArsenic("-");
                        }

                        System.out.println("bean.setAmmoniaAndNitrogen((siteModel.getAmmoniaAndNitrogen()));");
                    }
                    if(siteModel.getCadmium()!=null){
                        if(isNumeric(siteModel.getCadmium())){
                            bean.setCadmium(siteModel.getCadmium());
                            System.out.println("bean.setHydrogen(siteModel.getHydrogen());");
                        }else {
                            bean.setCadmium("-");
                        }
                    }
                    if(siteModel.getPhosphorus()!=null){
                        if(isNumeric(siteModel.getPhosphorus())){
                            bean.setPhosphorus(siteModel.getPhosphorus());
                            System.out.println("bean.setPhosphoric(siteModel.getPhosphoric());");
                        }else {
                            bean.setPhosphorus("-");
                        }
                    }
                    if(siteModel.getChrome()!=null){
                        if(isNumeric(siteModel.getChrome())){
                            bean.setChrome(siteModel.getChrome());
                            System.out.println("bean.setChlorophyl(siteModel.getChlorophyl());");
                        }else {
                            System.out.println("bean.setChlorophyl(siteModel.getChlorophyl());"+siteModel.getChrome());
                            bean.setChrome("-");
                        }
                    }
                    if(siteModel.getLead()!=null){
                        if(isNumeric(siteModel.getLead())){
                            bean.setLead(siteModel.getLead());
                            System.out.println("bean.setSantocel(siteModel.getSantocel());");
                        }else {
                            bean.setLead("-");
                        }
                    }
                    if(siteModel.getChemicalOxygen()!=null){
                        if(isNumeric(siteModel.getChemicalOxygen())){
                            bean.setChemicalOxygen(siteModel.getChemicalOxygen());
                            System.out.println("bean.setChemicalOxygen(siteModel.getChemicalOxygen());");
                        }else {
                            bean.setChemicalOxygen("-");
                        }
                    }
                    if(siteModel.getSuspendedMatter()!=null){
                        if(isNumeric(siteModel.getSuspendedMatter())){
                            bean.setSuspendedMatter(siteModel.getSuspendedMatter());
                            System.out.println("   bean.setPhosphorus(siteModel.getPhosphorus());");
                        }else {
                            bean.setPhosphorus("-");
                        }
                    }
                    if(siteModel.getTotalNitroge()!=null){
                        if(isNumeric(siteModel.getTotalNitroge())){
                            bean.setTotalNitroge(siteModel.getTotalNitroge());
                            System.out.println(" bean.setPhosphoric(siteModel.getPhosphoric());");
                        }else {
                            bean.setPhosphorus("-");
                        }
                    }

                    if(siteModel.getMercury()!=null){
                        if(isNumeric(siteModel.getMercury())){
                            bean.setMercury(siteModel.getMercury());
                            System.out.println("bean.setNitrite(siteModel.getNitrite())");
                        }else {
                            bean.setMercury("-");
                        }
                    }

                    if(siteModel.getLead()!=null){
                        bean.setLead(siteModel.getLead());
                        System.out.println("bean.setDissolvedOxygen");
                        if(isNumeric(siteModel.getLead())){
                            bean.setLead(siteModel.getLead());

                        }else {
                            bean.setLead("-");

                        }
                    }

                    if(bean==null){

                    }
                    try{

                        bean.setName((files[i].getName().replace(".xlsx", "")));




                        mongoTemplate.save(bean);


                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println(files[i].getName());

                    }


                }




            }

        }
        Query query = new Query();
        query.addCriteria(Criteria.where("detectionDate").is(0));
        mongoTemplate.findAllAndRemove(query,SiteModel.class);
    }

    public static boolean isNumeric(String str){
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(str);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }
    }