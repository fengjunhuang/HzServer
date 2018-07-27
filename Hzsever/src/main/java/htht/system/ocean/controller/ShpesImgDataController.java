package htht.system.ocean.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.ShpesImgData;
import htht.system.ocean.service.ShpesImgDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* Created by CodeGenerator on 2018/04/23.
*/
@RestController
@RequestMapping("/shpes/img/data")
public class ShpesImgDataController {
    @Resource
    private ShpesImgDataService shpesImgDataService;

    @PostMapping("/add")
    public Result add(@RequestBody @Validated String jsonParams) {
 ShpesImgData  shpesImgData =JSON.parseObject(jsonParams, ShpesImgData.class);


        shpesImgDataService
                .createImg(shpesImgData);
        return ResultGenerator.genSuccessResult();
    }


    //
//    @PostMapping("/delete")
//    public Result delete(@RequestBody @Validated String jsonParams) {
//        ShpesImgData shpesImgData = JSON.parseObject(jsonParams,ShpesImgData.class);
//        if(shpesImgDataService.deleteById(shpesImgData.getImgId())>0){
//
//            return ResultGenerator.genSuccessResult();
//        }else {
//            return ResultGenerator.genParameterFailResult();
//        }
//
//    }
@PostMapping("/update")
public Result updateD(@RequestBody @Validated String jsonParams) {
    ShpesImgData data = JSON.parseObject(jsonParams,ShpesImgData.class);

   if(shpesImgDataService.updateShpDescribe(data.getShpChildId(),data.getShpDescribe(),data.getBranchId())>0){
       return ResultGenerator.genSuccessResult();
    } else {
       return ResultGenerator.genParameterFailResult();
   }
//}else {
//    return ResultGenerator.genParameterFailResult();
//
//if(shpesImgDataService.updateShpDescribe(data.getBranchId(),data.getShpDescribe())>0){
//    return ResultGenerator.genSuccessResult();
//}else {
//    return ResultGenerator.genParameterFailResult();
//
//}




}
    @ApiOperation(value = "获取站位图片",notes = "{\"shpChildId\":1}")
@PostMapping("/getDischargeImg")
public Result getDischargeImg(@RequestBody @Validated String jsonParams){
    ShpesImgData data = JSON.parseObject(jsonParams,ShpesImgData.class);
   List<ShpesImgData> shpesImgData= shpesImgDataService.queryShpesChBybranchId(9545l,data.getShpChildId());
    return ResultGenerator.genSuccessResult(shpesImgData);

}
    @PostMapping("/deleteShpByImgId")
    public Result deleteShpByImgId(@RequestBody @Validated String jsonParams) {
        ShpesImgData data = JSON.parseObject(jsonParams,ShpesImgData.class);

       ShpesImgData shpesImgData1 =shpesImgDataService.findById(data.getImgId());
        shpesImgData1.setImgPath("");
        shpesImgDataService.update( shpesImgData1);

        return ResultGenerator.genSuccessResult();
    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        ShpesImgData shpesImgData = shpesImgDataService.findById(id);
//        return ResultGenerator.genSuccessResult(shpesImgData);
//    }



    @PostMapping("/queryShpesChBybranchId")
    public Result list(@RequestBody @Validated String jsonParams) {
//        PageHelper.startPage(page, size);
        ShpesImgData shpesImgData = JSON.parseObject(jsonParams,ShpesImgData.class);
    ShpesImgData data=   shpesImgDataService.queryShpesChBybranchId(shpesImgData.getBranchId(),shpesImgData.getShpChildId()).get(0);
    if(data!=null){
        return ResultGenerator.genSuccessResult(data);
    }else {
        shpesImgDataService.createImg(shpesImgData);

        return ResultGenerator.genSuccessResult(data);
    }

    }
}
