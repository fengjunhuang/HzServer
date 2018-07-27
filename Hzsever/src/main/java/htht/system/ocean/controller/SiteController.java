package htht.system.ocean.controller;

import com.alibaba.fastjson.JSON;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.Discharge;
import htht.system.ocean.model.ShpesImgData;
import htht.system.ocean.model.SiteModel;
import htht.system.ocean.model.ZhanWeiShuJu;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/site")

public class SiteController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @ApiOperation(value = "更新Site", notes="{name:\"GD051\"}" +
            "   private String name; //站位名字\n" +
            "    private  Long\tdetectionDate;\n" +
            "    private  int zid;\n" +
            "\n" +
            "\n" +
            "    private String hydrogen;  //硝酸盐-氮（mg/L）\n" +
            "    private String  ammoniaAndNitrogen;  //氨-氮（mg/L）\n" +
            "    private String  Santocel;//硅酸盐(mg/L）\n" +
            "    private String    dissolvedOxygen; //溶解氧（mg/L）\n" +
            "    private String  suspendedMatter;  //悬浮物\n" +
            "    private String  nitrite;    //亚硝酸盐-氮（mg/L）\n" +
            "    private String chlorophyl; //叶绿素-a（µg/L）\n" +
            "    private String  totalNitroge; //总氮(mg/L）\n" +
            "    private String phosphorus;// 总磷(mg/L）\n" +
            "    private String  phosphoric;//磷酸盐（mg/L）\n" +
            "    private  String chemicalOxygen;  //化学需氧量(mg/L)\n" +
            "    private  String id;")
    @PostMapping("/getSiteById")
    public Result add(@RequestBody @Validated String jsonParams) {
        SiteModel siteModel = JSON.parseObject(jsonParams, SiteModel.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(siteModel.getName()));
List<SiteModel> siteModels= mongoTemplate.find(query,SiteModel.class);
//       for(SiteModel bean: siteModels){
//
//           if(bean.getTotalNitroge().equals("—")){
//                bean.setTotalNitroge(null);
//           }
//           if(bean.getChemicalOxygen().equals("—")){
//               bean.setChemicalOxygen(null);
//
//           }
//           if(bean.getPhosphoric().equals("—")){
//               bean.setPhosphoric(null);
//
//           }
//           if(bean.getDissolvedOxygen().equals("—")){
//               bean.setDissolvedOxygen(null);
//
//           }if(bean.getNitrite().equals("—")){
//               bean.setNitrite(null);
//
//           }if(bean.getSantocel().equals("—")){
//               bean.setSantocel(null);
//
//           }
//           if(bean.getSuspendedMatter().equals("—")){
//               bean.setSuspendedMatter(null);
//
//           }
//           if(bean.getPhosphorus().equals("—")){
//               bean.setPhosphorus(null);
//
//           }


//       }


        return ResultGenerator.genSuccessResult( siteModels);
    }
    @ApiOperation(value = "排污口",notes = "{name :\"C5N018\"}\n" +
            "private String cadmium; //镉(mg/L)\n" +
            "private  String chrome; //铬(mg/L)\n" +
            "private  String   mercury;//汞(mg/L)\n" +
            "private  String    chemicalOxygen ;       //化学耗氧量(mg/L)\n" +
            "private  String        lead;      //铅(mg/L)\n" +
            "private   String      \tarsenic ;//砷(mg/L)\n" +
            "private  String     suspendedMatter;//悬浮物(mg/L)\n" +
            "private   Long\tdetectionDate;\n" +
            "private  String  name;\n" +
            "private  String  totalNitroge;           //总氮(mg/L)\n" +
            " private String  phosphorus;//  总磷(mg/L)\n" +
            "    private  String  id;\n")
    @PostMapping("/getDischargeByid")
    public Result getDischargeByid(@RequestBody @Validated String jsonParams) {
        Discharge discharge = JSON.parseObject(jsonParams, Discharge.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(discharge.getName()));
        List<Discharge> siteModels= mongoTemplate.find(query,Discharge.class);
//       for(SiteModel bean: siteModels){
//
//           if(bean.getTotalNitroge().equals("—")){
//                bean.setTotalNitroge(null);
//           }
//           if(bean.getChemicalOxygen().equals("—")){
//               bean.setChemicalOxygen(null);
//
//           }
//           if(bean.getPhosphoric().equals("—")){
//               bean.setPhosphoric(null);
//
//           }
//           if(bean.getDissolvedOxygen().equals("—")){
//               bean.setDissolvedOxygen(null);
//
//           }if(bean.getNitrite().equals("—")){
//               bean.setNitrite(null);
//
//           }if(bean.getSantocel().equals("—")){
//               bean.setSantocel(null);
//
//           }
//           if(bean.getSuspendedMatter().equals("—")){
//               bean.setSuspendedMatter(null);
//
//           }
//           if(bean.getPhosphorus().equals("—")){
//               bean.setPhosphorus(null);
//
//           }


//       }


        return ResultGenerator.genSuccessResult( siteModels);
    }

}
