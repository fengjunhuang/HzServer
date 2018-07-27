package htht.system.ocean.controller;
import com.alibaba.fastjson.JSON;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.Branch;
import htht.system.ocean.model.ModelsData;
import htht.system.ocean.model.ShpesData;
import htht.system.ocean.model.ShpesDataCustom;
import htht.system.ocean.service.BranchService;
import htht.system.ocean.service.ModelsDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import htht.system.ocean.util.ObjectUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
* Created by CodeGenerator on 2018/05/03.
*/
@RestController
@RequestMapping("/models/data")
public class ModelsDataController {
    @Resource
    private ModelsDataService modelsDataService;
    @Resource
    private BranchService branchService;
    @ApiOperation(value = "通过BrandId查询model", notes = "{ \"branchId\":1139 }")
    @PostMapping("/queryModelByBranchId")
    public @ResponseBody
    @Transactional
    Result queryModelData(
                             @RequestBody @Validated String jsonParams) throws IllegalAccessException {

        Branch branch= JSON.parseObject(jsonParams, Branch.class);


        ModelsData modelsData=null;
        modelsData= modelsDataService.findBy("branchId",branch.getBranchId());
      String json=modelsData.toString();
      Branch branch1=      branchService.findById(branch.getBranchId());
        HashMap<String, Object> map=    (HashMap<String, Object>) (ObjectUtils.objectToMap( modelsData)) ;
        map.put("branchName",branch1.getBranchName());
        if(modelsData!=null) {
            return  ResultGenerator.genSuccessResult(map);

        }else {
            return   ResultGenerator.genParameterFailResult();
        }
    }








//    @PostMapping("/add")
//    public Result add(ModelsData modelsData) {
//        modelsDataService.save(modelsData);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        modelsDataService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
@ApiOperation(value = "更新 ModelsData", notes = "{\"modelId\":9302,\"subjectId\":null,\"branchId\":1584,\"lon\":114.722899,\n" +
        "\"lat\":22.591305,\"height\":50.0,\"scale\":1.0,\"xangle\":0.0,\"modelsName\":\"bridge\",\"yangle\":0.0,\n\"" +
        "filePath\":\"objModel/1525425996596bridge.zip/bridge\"}")

    @PostMapping("/update")
    public Result update(@RequestBody @Validated String jsonParams) {
        ModelsData modelsData= JSON.parseObject(jsonParams,  ModelsData.class);
        modelsDataService.update(modelsData);
        return ResultGenerator.genSuccessResult();

    }



}
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        ModelsData modelsData = modelsDataService.findById(id);
//        return ResultGenerator.genSuccessResult(modelsData);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<ModelsData> list = modelsDataService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

