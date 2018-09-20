package htht.system.ocean.web;

import com.alibaba.fastjson.JSON;
import htht.system.ocean.configurer.Constant;
import htht.system.ocean.configurer.UploadProperties;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.*;
import htht.system.ocean.service.*;
import htht.system.ocean.util.FileUtil;
import htht.system.ocean.util.GdalUtil;
import htht.system.ocean.util.ZipUtil;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

/**
 * 文件上传的Controller
 *
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 */
@Controller
public class FileUploadController {
    /*    private Logger log = LoggerFactory.getLogger(FileUploadUtil.class);*/
    @Resource
    private ShpesImgDataService shpesImgDataService;
    @Resource
    private ResourceLoader resourceLoader;
    @Resource
    private UploadProperties uploadProperties;
    @Resource
    private BranchService branchService;
    @Resource
    private ShpesDataService shpesDataService;
    @Resource
    ModelsDataService  modelsDataService;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Resource
    private FileDataService fileDataService;

    //跳转到上传文件的页面
    @RequestMapping(value = "/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    // 访问路径为：http://ip:port/upload
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "/fileupload";
    }

    // 访问路径为：http://ip:port/upload/batch
    @RequestMapping(value = "/upload/batch", method = RequestMethod.GET)
    public String batchUpload() {
        return "/mutifileupload";
    }

    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file
     * @return
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequiresPermissions({"上传"})
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。

                String fileName = file.getName();
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename() + "/" + fileName)));

                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }


/*    *//**
     * 上传压缩文件
     *//*
    @RequestMapping("/uploadPushContent.do")
    @ResponseBody
    public Object uploadPushContent(MultipartFile pushContent, HttpSession session, HttpServletRequest request){
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        if(pushContent == null){
            jsonMap.put(Constant.SUCCESS,false);
            jsonMap.put(Constant.ERROR_MSG,"上传文件不能为空");
        }else{
            //获取存储文件的目录
            //String path = session.getServletContext().getRealPath("/upload");
            String path = Constant.UPLOAD_FILE_PATH;
            try {
                String saveFileName = UploadUtil.resolveCompressUploadFile(request, pushContent, path);
                String url = Constant.URL_PRE_FILE+saveFileName+"/"+"index.html";
                System.out.println("urlFile"+url);
                jsonMap.put(Constant.SUCCESS,true);
                jsonMap.put("url",url);
            } catch (Exception e) {
                jsonMap.put(Constant.SUCCESS,false);
                jsonMap.put(Constant.ERROR_MSG,e.getMessage());
                e.printStackTrace();
            }
        }

        return jsonMap;
    }*/


    /**
     * 实现文件上传
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "F:/test";
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "true";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }

    class  UploadReturnData{
        private  List<Branch> branchList;
        private  List<String> faildBranchNameList;

        public List<Branch> getBranchList() {
            return branchList;
        }

        public void setBranchList(List<Branch> branchList) {
            this.branchList = branchList;
        }

        public List<String> getFaildBranchNameList() {
            return faildBranchNameList;
        }

        public void setFaildBranchNameList(List<String> faildBranchNameList) {
            this.faildBranchNameList = faildBranchNameList;
        }
    }
    /**
     * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @Transactional
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    public @ResponseBody
    Result batchUpload(HttpServletRequest request, Long parentId,Long nodeType,Double lon ,Double lat,Double height ) throws FileNotFoundException {
        List<MultipartFile> files = new ArrayList<MultipartFile>();

        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter = multiRequest.getFileNames();
        ServletContext servletContext = request.getSession().getServletContext();
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        File f = new File(Constant.UPLOADPATH);
        if (!f.exists()) {
            f.mkdirs();
        }
        // 获取multiRequest 中所有的文件名
        while (iter.hasNext()) {
            // 适配名字重复的文件
            List<MultipartFile> fileRows = multiRequest
                    .getFiles(iter.next().toString());
            if (fileRows != null && fileRows.size() != 0) {
                for (MultipartFile file : fileRows) {
                    if (file != null && !file.isEmpty()) {
                        files.add(file);
                    }
                }

            }
        }
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        UploadReturnData data =new UploadReturnData();

        List<Branch> succesBranch =new ArrayList<>();
        List<String> failBranch =new ArrayList<>();
        data.setBranchList(succesBranch);
        data.setFaildBranchNameList(failBranch);
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            Branch branch = new Branch();

            ShpesData shpesData =new ShpesData();
            String fileName= file.getOriginalFilename().substring(0,file.getOriginalFilename() .lastIndexOf("."));
            String extent= file.getOriginalFilename().substring(file.getOriginalFilename() .lastIndexOf(".")+1,file.getOriginalFilename().length());
            if (!file.isEmpty()) {
                try {

                    byte[] bytes = file.getBytes();

                    stream = new BufferedOutputStream(new FileOutputStream(new File(Constant.UPLOADPATH + file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                    try {
                        File zipFile = new File(Constant.ZIPPATH + file.getOriginalFilename());
                        if (!zipFile.exists()) {
                            zipFile.mkdirs();
                        }
                        String sysMile=System.currentTimeMillis()+"";
                        String zipPath=Constant.ZIPPATH + sysMile;
                        branch.setBranchName( fileName);

                        branch.setCreateTime(new Date(System.currentTimeMillis()));
                        branch.setParentId(parentId);
                        List<Branch> list = branchService.queryByNameAndPranentId(parentId, branch.getBranchName());
                        if(nodeType!=3) {
                            ZipUtil.upzipFile(Constant.UPLOADPATH + file.getOriginalFilename(), zipPath + file.getOriginalFilename());
                            //读取
                            File[]  mfiles=  FileUtil.listAllShp(new File(zipPath+ file.getOriginalFilename()));
                            File[]  mfiles1=  FileUtil.listAllObj(new File(zipPath+ file.getOriginalFilename()));
                            if(mfiles.length==1|| mfiles1.length==1){



                                branch.setZipPath(zipPath+ file.getOriginalFilename());

                                if(nodeType.longValue()==1L){

                                    HashMap<String,Object> hashMap=    GdalUtil.toGonson(mfiles[0].getPath(),file.getOriginalFilename());
                                    if( !hashMap.isEmpty()){


                                        shpesData.setShpName(fileName);
                                        shpesData.setGeoJson((String) hashMap.get("geoJson"));
                                        shpesData.setTbranchId(branch.getBranchId());
                                        shpesData.setShpType((String) hashMap.get("type"));
                                        shpesData.setFields((String) hashMap.get("properties"));
                                        shpesData.setWhether3d((Integer) hashMap.get("whether3d"));
                                        shpesData.setDisplayType((String) hashMap.get("displayType"));
                                        shpesData.setColor("rgba(255,255,255,1)");
                                        if(shpesData.getFields().contains(",")) {
                                            shpesData.setDisplayfield(shpesData.getFields().substring(0, shpesData.getFields().indexOf(",")));
                                        }else {
                                            shpesData.setDisplayfield(shpesData.getFields());
                                        }

                                        branch.setContentId(shpesData.getShpId());

                                        branch.setNodeType(1L);

                                /*branch.setGeoJson(geostr);*/

                                        if(list.size()==0&&FileUtil.listAllShp(new File(zipPath+ file.getOriginalFilename())).length==1){
                                            long a=  System.currentTimeMillis();
                                            branchService.createUser(branch);
                                            shpesData.setTbranchId(branch.getBranchId());
                                            shpesDataService.insert(shpesData);
                                            System.out.println( System.currentTimeMillis()-a+" ORCLE耗时");
                                            long b =  System.currentTimeMillis();
                                            Document doc = Document.parse(shpesData.getGeoJson());
                                            Object object= doc.get("");

//                                            mongoTemplate.insert(doc,branch.getBranchId()+"");
                                            System.out.println( System.currentTimeMillis()-b+" mongoTemplate耗时");



                                            succesBranch.add(branch);
                                        }else {

                                            failBranch.add(fileName);
                                        }

                                    }else {
                                        failBranch.add(fileName);
//                                return  ResultGenerator.genSuccessResult( file.getOriginalFilename()+"文件存在错误" );
                                    }
                                }else  if((nodeType.longValue()==2L)){
                                    ModelsData modelsData =new ModelsData();
                                    modelsData.setHeight(height);
                                    modelsData.setLat(lat);
                                    modelsData.setLon(lon);
                                    branch.setContentId(modelsData.getModelId());


                                    branch.setNodeType(2L);
                                    if(list.size()==0&&FileUtil.listAllObj(new File(zipPath+ file.getOriginalFilename())).length==1){

                                        branchService.createUser(branch);
                                        modelsData.setFilePath("objModel/"+sysMile+file.getOriginalFilename());
                                        modelsData.setBranchId(branch.getBranchId());
                                        modelsData.setModelsName(branch.getBranchName());
                                        modelsData.setModelId(branch.getBranchId());

                                        modelsDataService.save(modelsData);
                                        succesBranch.add(branch);
                                    }else {

                                        failBranch.add(fileName);
                                    }
                                }
                                else {
                                    failBranch.add(fileName);
                                }
                            }else {

                                failBranch.add(fileName);
                            }
                        }else {
                            if (list.size()==0){

                                branch.setNodeType(3L);
                                branch.setZipPath(Constant.UPLOADPATH + file.getOriginalFilename());
                                branchService.createUser(branch);
                                FileData fileData=new FileData();
                                fileData.setFileName(branch.getBranchName());
                                fileData.setBranchId(branch.getBranchId());
                                fileData.setUpdateTime(new Date(System.currentTimeMillis()));
                                fileData.setFileExtention(extent);
                                fileData.setFileSize(file.getSize());

                                fileDataService.save(fileData);

                                succesBranch.add(branch);

                            }else {
                                failBranch.add(fileName);
                            }
                        }



                    } catch (Exception e) {
                        e.printStackTrace();
                        branchService.deleteById(branch.getBranchId());
                        shpesDataService.deleteById(shpesData.getShpId());

                        failBranch.add(fileName);
//                        return ResultGenerator.genFailResult("解压失败,请上传zip格式文件");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    stream = null;
                    failBranch.add(fileName);
                    return ResultGenerator.genFailResult("上传失败");
                }finally {

                }
            } else {
                failBranch.add(fileName);
//                return ResultGenerator.genFailResult("上传失败，因为文件未空");
              /*  return "You failed to upload " + i + " because the file was empty.";*/
            }
        }

//        FileUtil.deleteDirectory(Constant.UPLOADPATH);
        return ResultGenerator.genSuccessResult(data);


    }

    public  void saveShp(GeoModelPoint geoModelPoint,String fileName){
        Branch branch = new Branch();
        branch.setBranchName( fileName);

        branch.setCreateTime(new Date(System.currentTimeMillis()));
        branch.setParentId(1000l);
        ShpesData shpesData =new ShpesData();
        shpesData.setShpName(fileName);
        shpesData.setGeoJson(JSON.toJSONString(geoModelPoint));
        shpesData.setTbranchId(branch.getBranchId());
        shpesData.setShpType("Point");
        shpesData.setFields("name,Id");
        shpesData.setWhether3d(0);
        shpesData.setDisplayType("p3d");
        shpesData.setColor("rgba(255,255,255,1)");

        branchService.createUser(branch);
        shpesData.setTbranchId(branch.getBranchId());
        shpesDataService.insert(shpesData);
    }
    @Transactional
    @RequestMapping("/upload/imge")
//    @PostMapping(value ="/upload/imge",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    @ResponseBody
    public  Result upload( @RequestParam("file")  @ApiParam(value="上传文件",required = true) MultipartFile[]  files, HttpServletRequest request, Long shpChildId, Long branchId) {

        // 获取文件存放路径
        String basePath = uploadProperties.getBasePath();
        String location =System.currentTimeMillis() + "/";
        // 判断文件夹是否存在，不存在则
        File targetFile = new File(basePath + location);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        List<ShpesImgData> shpesS=new ArrayList<>();


        for(MultipartFile file : files) {

            String contentType = file.getContentType();
            String fileName = file.getOriginalFilename();
            ShpesImgData shpesImgData =new ShpesImgData();
            try {
                // java7中新增特性
                // ATOMIC_MOVE	原子性的复制
                // COPY_ATTRIBUTES	将源文件的文件属性信息复制到目标文件中
                // REPLACE_EXISTING	替换已存在的文件
                Files.copy(file.getInputStream(), Paths.get(uploadProperties.getBasePath() + location, fileName), StandardCopyOption.REPLACE_EXISTING);
                shpesImgData.setImgPath("img/" + location + file.getOriginalFilename());
                shpesImgData.setShpChildId(shpChildId);
                shpesImgData.setBranchId(branchId);
                ShpesImgData shpesImgData1=   shpesImgDataService.queryShpesChBybranchId(branchId, shpChildId).get(0);
                if (shpesImgData1 == null) {
                    shpesImgDataService.createImg(shpesImgData);
                } else{
                    shpesImgData1.setImgPath("img/" + location + file.getOriginalFilename());
                    shpesImgData=shpesImgData1;
                    shpesImgDataService.updateShpImg(shpesImgData.getBranchId(), shpesImgData.getImgPath(), shpesImgData.getShpChildId());
                }

                shpesS.add(shpesImgData1);


//                rs.setContentType(contentType);
//                rs.setFileName(fileName);
//                rs.setUrl(Base64Util.encodeData(location + fileName) + fileName.substring(fileName.lastIndexOf(".")));
//                rs.setType("success");
//                log.info(JSON.toJSONString(rs));
            } catch (Exception e) {
                e.printStackTrace();
//                rs.setType("fail");
//                rs.setMsg("文件上传失败！");
//                log.error("上传文件失败，" + e);

                return  ResultGenerator.genParameterFailResult();
            }
//            list.add(rs);
        }

//        shpesImgDataService.save(shpesS);
        //返回json
        return  ResultGenerator.genSuccessResult(shpesS.get(0));
    }

//    /**
//     * @Title: getFile
//     * @Description: TODO(获取图片)
//     * @param url
//     * @param filename
//     * @return ResponseEntity<?>    返回类型
////     */
//    @GetMapping("/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<?> getFile(@PathVariable String filename) {
//        try {
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(uploadProperties.getBasePath() + filename)));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.notFound().build();
//        }
//    }




}