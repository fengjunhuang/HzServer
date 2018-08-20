package htht.system.ocean.controller;
import com.alibaba.fastjson.JSON;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.Branch;
import htht.system.ocean.model.FileData;
import htht.system.ocean.service.FileDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/27.
*/
@RestController
@RequestMapping("/file/data")
public class FileDataController {
    @Resource
    private FileDataService fileDataService;

    @PostMapping("/add")
    public Result add(FileData fileData) {
        fileDataService.save(fileData);
        return ResultGenerator.genSuccessResult();
    }

//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        fileDataService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(FileData fileData) {
//        fileDataService.update(fileData);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        FileData fileData = fileDataService.findById(id);
//        return ResultGenerator.genSuccessResult(fileData);
//    }
@PostMapping("/getFileDataByBranchId")
    public Result detail( @RequestBody @Validated String jsonParams) {
      FileData data= JSON.parseObject(jsonParams, FileData.class);
        FileData fileData = fileDataService.findById(data.getBranchId());
        return ResultGenerator.genSuccessResult(fileData);
    }
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<FileData> list = fileDataService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
