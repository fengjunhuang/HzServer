package htht.system.ocean.controller;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.MenuData;
import htht.system.ocean.service.MenuDataService;
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
@RequestMapping("/menu/data")
public class MenuDataController {
    @Resource
    private MenuDataService menuDataService;

    @PostMapping("/add")
    public Result add(MenuData menuData) {
        menuDataService.save(menuData);
        return ResultGenerator.genSuccessResult();
    }

//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        menuDataService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(MenuData menuData) {
//        menuDataService.update(menuData);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        MenuData menuData = menuDataService.findById(id);
//        return ResultGenerator.genSuccessResult(menuData);
//    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MenuData> list = menuDataService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
