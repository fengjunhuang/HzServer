package htht.system.ocean.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.BranchSubjects;
import htht.system.ocean.model.ModelsData;
import htht.system.ocean.model.NodeList;
import htht.system.ocean.model.ShpesData;
import htht.system.ocean.service.BranchService;
import htht.system.ocean.service.BranchSubjectsService;
import htht.system.ocean.service.ModelsDataService;
import htht.system.ocean.service.ShpesDataService;
import htht.system.ocean.util.ObjectUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
* Created by CodeGenerator on 2018/04/18.
*/
@RestController
@RequestMapping("/branch/subjects")
public class BranchSubjectsController {
    @Resource
    private BranchSubjectsService branchSubjectsService;
    @Resource
    private ShpesDataService shpesDataService;
    @Resource
    private ModelsDataService modelsDataService;
    @Resource
    BranchService branchService;
    @ApiOperation(value = "添加branchSubjects", notes = "{\"subName\" :\"1111\", \"nodeList\" :\"\",\"subParentId\" :1234}\n")
    @PostMapping("/add")
    public Result add(@RequestBody @Validated String jsonParams ) {
        BranchSubjects branchSubjects = JSON.parseObject(jsonParams,BranchSubjects.class);

        branchSubjects.setCreateTime(new Date(System.currentTimeMillis()));

      if(branchSubjectsService.create(branchSubjects)!=0){
          branchSubjects.setSubId(branchSubjects.getSubId()+1);

          return ResultGenerator.genSuccessResult(branchSubjects);
      }else {
          return ResultGenerator.genParameterFailResult();
      }


    }

    @ApiOperation(value = "删除BranchSubjects", notes = "{\"subId\" :\"1111\" }\n")

    @PostMapping("/delete")
    public Result delete(@RequestBody @Validated String jsonParams) {
        BranchSubjects branchSubjects = JSON.parseObject(jsonParams,BranchSubjects.class);

        if(branchSubjectsService.deleteById(branchSubjects.getSubId())!=0){

            return ResultGenerator.genSuccessResult();
        }else {

            return ResultGenerator.genParameterFailResult();
        }
    }
//    @ApiOperation(value = "更新BranchSubjects", notes = "{\"subId\" :1181，\"subName\" ：\"\",\"nodeList\" :\"\" }")
//    @PostMapping("/update")
//    public Result update(@RequestBody @Validated String jsonParams ) {
//        BranchSubjects branchSubjects = JSON.parseObject(jsonParams,BranchSubjects.class);
//
//        branchSubjectsService.findById(branchSubjects.getSubId());
//        if(  branchSubjectsService.update(branchSubjects)!=0){
//
//            return ResultGenerator.genSuccessResult();
//        }
//
//        return ResultGenerator.genParameterFailResult();
//    }
@Transactional
@ApiOperation(value = "更新BranchSubjects", notes = "{\"subId\" :1181，\"subName\" ：\"\",\"nodeList\" :\"\" }")
@PostMapping("/update")
public Result update(@RequestBody @Validated String jsonParams ) {
    BranchSubjects branchSubjects = JSON.parseObject(jsonParams,BranchSubjects.class);
    String ids=branchSubjects.getNodeList();
    NodeList nodeList =JSON.parseObject(branchSubjects.getNodeList(),NodeList.class);

  List<ShpesData> branchList =new ArrayList<>();
    List<ModelsData> modelhList =new ArrayList<>();
  for(Long s:nodeList.getModelListId()){
      ShpesData shpesData= new ShpesData();
      shpesData.setSubjectId(branchSubjects.getSubId());
      shpesData.setTbranchId(s);
      branchList.add(shpesData);
  }
  for(Long s:nodeList.getShpListId()){
      ModelsData modelsData =new ModelsData();
      modelsData.setSubjectId(branchSubjects.getSubId());
      modelsData.setBranchId(s);
      modelhList.add(modelsData);
  }
    for(ShpesData  shpesData:branchList){

        shpesDataService.updateSujectId(shpesData);

    }
    for(ModelsData modelsData:modelhList){

        modelsDataService.updateSujectId(modelsData);

    }


    if(  branchSubjectsService.update(branchSubjects)!=0){

        return ResultGenerator.genSuccessResult();
    }

    return ResultGenerator.genParameterFailResult();
}
    @ApiOperation(value = "查询BranchSubjects", notes = "{\"subId\" :1181 }")
    @PostMapping("/query")
    public Result detail(@RequestBody @Validated String jsonParams) {
       BranchSubjects branchSubjects = JSON.parseObject(jsonParams,BranchSubjects.class);


        return ResultGenerator.genSuccessResult(branchSubjects);
    }


    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);

        List<BranchSubjects> list = branchSubjectsService.findAll();
        List<HashMap<String,Object>> list1=new ArrayList<>();
        for(BranchSubjects branchSubjects :list){
            try {
                HashMap<String, Object>  map=    (HashMap<String, Object>) (ObjectUtils.objectToMap(branchSubjects)) ;
                Condition condition = new  Condition(ShpesData.class);
                condition.createCriteria().andEqualTo("subjectId", branchSubjects.getSubId());
                List<ShpesData> shpesDatas =shpesDataService.findByCondition(condition);
                for(ShpesData shpesData:shpesDatas){
                    shpesData.setGeoJson(null);
                }
                map.put("ShapeList", shpesDatas);
                list1.add(map);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        PageInfo pageInfo = new PageInfo(list1);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


   @PostMapping("/querySujectsListByparentId")
   public Result querySujectsListByparentId(@RequestBody @Validated String jsonParams) {
       BranchSubjects branchSubjects = JSON.parseObject(jsonParams,BranchSubjects.class);
       List<BranchSubjects> list = branchSubjectsService.findAll();
       List<BranchSubjects> list1=new ArrayList<>();
       for(BranchSubjects branchSubjects1 :list){
//           if (branchSubjects1.getParentId()== branchSubjects.getParentId()){
//               list1.add(branchSubjects1);
//           }
       }

         return ResultGenerator.genSuccessResult(list1);
   }

}
