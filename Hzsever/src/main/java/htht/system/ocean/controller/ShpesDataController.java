package htht.system.ocean.controller;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.Branch;
import htht.system.ocean.model.ShpesData;
import htht.system.ocean.model.ShpesDataCustom;
import htht.system.ocean.service.ShpesDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/12.
 */
@RestController
@RequestMapping("/shpes/data")
public class ShpesDataController {
    @Resource
    private ShpesDataService shpesDataService;

    @PostMapping("/add")
    public Result add(ShpesData shpesData) {
        shpesDataService.insert(shpesData);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
//        shpesDataService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "更新shpdata", notes="{tbranchId :9162, displayfield :\".....\",color :\"....\"}")
    @PostMapping("/update")
    public Result update(@RequestBody @Validated String jsonParams) {
        ShpesData shpesData= JSON.parseObject(jsonParams, ShpesData.class);
        ShpesData aa=    shpesDataService.findBy("tbranchId",shpesData.getTbranchId());
        shpesData.setShpId(aa.getShpId());

        if( shpesDataService.update(shpesData)!=0){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genParameterFailResult();
        }

    }

/*
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
//        ShpesData shpesData = shpesDataService.findById(id);
        return ResultGenerator.genSuccessResult(shpesData);
    }
*/

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ShpesData> list = shpesDataService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "通过BrandId查询SHP", notes = "{\n" +
            " \"branchId\":1139,\n" +
            "  \"isBringGeoJson\" :true\n" +
            "}")
    @PostMapping("/queryBranchById")
    public @ResponseBody
    Result queryBranchByUuid(@RequestBody @Validated String jsonParams) {

        Branch branch= JSON.parseObject(jsonParams, Branch.class);
        Boolean isBringGeoJson=  JSON.parseObject(jsonParams).getBoolean("isBringGeoJson");

        ShpesData shpesData=null;
        shpesData= shpesDataService.findBy("tbranchId",branch.getBranchId());

        if(shpesData!=null) {
            ShpesDataCustom shpesDataCustom = new ShpesDataCustom();
            shpesDataCustom.setGeoData(JSON.parseObject(shpesData.getGeoJson()));
            shpesData.setGeoJson(null);
            shpesDataCustom.setShpesData(shpesData);

            if (shpesData != null) {
                if (!isBringGeoJson) {
                    shpesDataCustom.setGeoData(null);
                }
                return ResultGenerator.genSuccessResult(shpesDataCustom);
            } else {
                return ResultGenerator.genSuccessResult(null);
            }
        }else {
            return ResultGenerator.genFailResult("不存在");
        }






    }
}
