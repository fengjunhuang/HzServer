package htht.system.ocean.system.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.system.back.model.ErrorBean;
import htht.system.ocean.system.back.service.ExceptionService;

@Controller
@RequestMapping(value = "/exception")
public class ExceptionController {
    @Autowired
    ExceptionService mExceptionService;

    @ResponseBody
    @GetMapping(value = "/getAllException")
    public Result getAllException(){
        List<ErrorBean> beanList = mExceptionService.findAll();
        return ResultGenerator.genSuccessResult(beanList);
    }

}
