package htht.system.ocean.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import htht.system.ocean.configurer.Constant;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.BuoyCure;
import htht.system.ocean.util.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buoy")
public class BouyController {


    @GetMapping("/list")
    public  Result getTideGauge() throws IOException {
        Map<String,String> map =new HashMap<>();
        map.put("ele_null_visible","true");
        map.put("station_type","buoy");
        map.put("hour_ingeter","all");
        String s=  HttpUtil.get(Constant.BOUYBASELIST,map);
        if(s==null){
            return ResultGenerator.genParameterFailResult();
        }
        JSONObject jsonObject = JSON.parseObject(s);


        return ResultGenerator.genSuccessResult(jsonObject.getJSONArray("data"));

    }

    @GetMapping("/getBase")
    public  Result getBase(String id){

        String s=  HttpUtil.doGet(Constant.getBaseBuoy(id));
        if(s==null){
            return ResultGenerator.genParameterFailResult();
        }

        JSONObject jsonObject = JSON.parseObject(s);


        return ResultGenerator.genSuccessResult(jsonObject);

    }
    @GetMapping("/getCurve")
    public  Result getBase(String id,String time) throws IOException {
        Map<String,String> map =new HashMap<>();
        map.put("id",id);
        map.put("time",time);
        map.put("extra","surface_salt%2Cwave%2Cwave_direction%2Ctemperature%2Cpressure%2Cflow_rate%2Csurface_flow%2Cwind_speed%2Cwind_power%2Cwind_direction_value%2Cwind_direction%2Csurface_water_temperature");
        map.put("null_visible","true");



        String s=  HttpUtil.doGet(Constant.getBuoyCure(id));
        if(s==null){
            return ResultGenerator.genParameterFailResult();
        }
        BuoyCure jsonObject = JSON.parseObject(s, BuoyCure.class);


        return ResultGenerator.genSuccessResult( jsonObject.getData());


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



