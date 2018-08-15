package htht.system.ocean.web;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.FrontDeptMenau;
import htht.system.ocean.service.FrontDeptMenauService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/07/31.
*/
@RestController
@RequestMapping("/front/dept/menau")
public class FrontDeptMenauController {
    @Resource
    private FrontDeptMenauService frontDeptMenauService;

    @PostMapping("/add")
    public Result add(FrontDeptMenau frontDeptMenau) {
        frontDeptMenauService.save(frontDeptMenau);
        return ResultGenerator.genSuccessResult();
    }

//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        frontDeptMenauService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(FrontDeptMenau frontDeptMenau) {
//        frontDeptMenauService.update(frontDeptMenau);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        FrontDeptMenau frontDeptMenau = frontDeptMenauService.findById(id);
//        return ResultGenerator.genSuccessResult(frontDeptMenau);
//    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<FrontDeptMenau> list = frontDeptMenauService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
