package htht.system.ocean.controller;

import com.alibaba.fastjson.JSON;
import htht.system.ocean.model.Config;
import htht.system.ocean.util.ImgUtil;
import org.springframework.http.HttpRequest;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/imgService")
public class ImgController {
     private  String jsonStr="{\n" +
             "    \"file\": \"qwer.jpg\",\n" +
             "    \"extent\": {\n" +
             "        \"xmax\": 12759128.351418851,\n" +
             "        \"xmin\": 12739575.959081242,\n" +
             "        \"ymax\": 2576555.640332572,\n" +
             "        \"ymin\": 2567803.5469767842\n" +
             "    }\n" +
             "}";
    private  String jsonStr1="{\n" +
            "    \"file\": \"timg.jpg\",\n" +
            "    \"extent\": {\n" +
            "        \"xmax\": 12770377.007934019,\n" +
            "        \"xmin\": 12748351.651432648,\n" +
            "        \"ymax\": 2600668.196759002,\n" +
            "        \"ymin\": 2581003.0528166355\n" +
            "    }\n" +
            "}";
    @RequestMapping(value="/getImage", method= RequestMethod.GET,headers = "Accept=image/png")
    public  byte[] getImage(HttpServletResponse response,@RequestParam(value="xMax", required=false) Float xMax, @RequestParam(value="yMax", required=false) Float yMax
            , @RequestParam(value="yMin", required=false) Float yMin, @RequestParam(value = "xMin",required = false )Float xMin , @RequestParam(value = "w",required = false )Float w
            , @RequestParam(value = "h",required = false )Float h

    ) throws IOException


    {


 return  ImgUtil.createImg(12918742.20078851f,2750308.1944788327f,12619512.5760356f,2451078.569725922f,2048f,2048f, JSON.parseObject(jsonStr,Config.class));
//     return  login;

    }


    //生成验证码图片
    @RequestMapping("/GraphicsImage.do") //对应/user/valicode.do请求
    public void valicode(HttpServletResponse response,float xMax,float yMax,float xMin,float yMin,float w,float h) throws Exception{
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        response.setContentType("image/png");


        OutputStream stream = response.getOutputStream();
        Config config=  JSON.parseObject(jsonStr,Config.class);

        stream.write(  ImgUtil.createImg(xMax,yMax,xMin,yMin,w,h, config));
        stream.flush();
        stream.close();

    }

    //生成验证码图片
    @RequestMapping("/GraphicsImage1.do") //对应/user/valicode.do请求
    public void valicode1(HttpServletResponse response,HttpServletRequest request,float xMax,float yMax,float xMin,float yMin,float w,float h) throws Exception{
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        response.setContentType("image/png");


        OutputStream stream = response.getOutputStream();


      Config config=  JSON.parseObject(jsonStr1,Config.class);

        stream.write(  ImgUtil.createImg(xMax,yMax,xMin,yMin,w,h,config));
        stream.flush();
        stream.close();

    }
}
