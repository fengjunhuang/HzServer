package htht.system.ocean.controller;

import htht.system.ocean.service.ShpesChildDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2018/04/23.
*/
@RestController
@RequestMapping("/shpes/child/data")
public class ShpesChildDataController {
    @Resource
   private ShpesChildDataService shpesChildDataService;
//
//    @PostMapping("/add")
//    public Result add(ShpesChildData shpesChildData) {
//        shpesChildDataService.save(shpesChildData);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestBody @Validated String jsonParams) {
//
//        shpesChildDataService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }

//    @PostMapping("/update")
//    public Result update(ShpesChildData shpesChildData) {
//        shpesChildDataService.update(shpesChildData);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        ShpesChildData shpesChildData = shpesChildDataService.findById(id);
//        return ResultGenerator.genSuccessResult(shpesChildData);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<ShpesChildData> list = shpesChildDataService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
