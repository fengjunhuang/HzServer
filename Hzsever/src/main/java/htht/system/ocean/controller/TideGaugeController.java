package htht.system.ocean.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import htht.system.ocean.configurer.Constant;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.util.HttpUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tideGauge")
public class TideGaugeController {


    @GetMapping("/list")
    public  Result getTideGauge(){

        String s=  HttpUtil.doGet(Constant.getTideList(true));
        JSONObject jsonObject = JSON.parseObject(s);
        if(s==null){
            return ResultGenerator.genParameterFailResult();
        }

        return ResultGenerator.genSuccessResult(jsonObject.getJSONArray("data"));

    }

    @GetMapping("/getBase")
    public  Result getBase(String id){

        String s=  HttpUtil.doGet(Constant.getBaseTide(id,true));
        JSONObject jsonObject = JSON.parseObject(s);

        if(s==null){
            return ResultGenerator.genParameterFailResult();
        }
        return ResultGenerator.genSuccessResult(jsonObject.getJSONObject("data"));

    }

    @GetMapping("/getCurve")
    public  Result getCurve(String id,String time) throws IOException {
        Map<String,String> map =new HashMap<>();
        map.put("id",id);
        map.put("time",time);



        String s=  HttpUtil.get(Constant.TIDE,map);
        if(s==null){
            return ResultGenerator.genParameterFailResult();
        }
        JSONObject jsonObject = JSON.parseObject(s);


        return ResultGenerator.genSuccessResult(jsonObject);

    }


//    @GetMapping("/getBase")
//    public  Result getBase(String id){
//
//        String s=  HttpUtil.doGet(Constant.getBaseTide(id,true));
//        JSONObject jsonObject = JSON.parseObject(s);
//
//
//        return ResultGenerator.genSuccessResult(jsonObject.getJSONObject("data"));
//
//    }
}
//        HttpUtil.doGet()
//
//
//
//
//    }



