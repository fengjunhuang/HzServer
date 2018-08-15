package htht.system.ocean.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import htht.system.ocean.configurer.Constant;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.Branch;
import htht.system.ocean.service.BranchService;
import htht.system.ocean.service.ShpesDataService;
import htht.system.ocean.util.FileUtil;
import htht.system.ocean.util.GdalUtil;
import htht.system.ocean.util.RestFulServiceUtil;
import htht.system.ocean.util.TextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Api(value = "分支相关接口")
/**
 * Created by CodeGenerator on 2018/04/03.
 */
@RestController
@RequestMapping("/branch")
public class BranchController {
    @Resource
    private BranchService branchService;
    @Resource
    private ShpesDataService shpesDataService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @ApiOperation(value = "创建文件分支", notes = "创建文件分支,需要传parentId,主分支默认未\"main\"\n" +
            "" + "NodeType 0 文件夹  1 shp 2 obj" +
            "")

    @ApiImplicitParam(name = "parentId", value = "父亲节点id", required = true, dataType = "String")

    @PostMapping("/createBranch")
    public Result add( @RequestBody @Validated String jsonParams) {


        Branch branch = JSON.parseObject(jsonParams, Branch.class);


        branch.setCreateTime(new Date(System.currentTimeMillis()));
        if (branch.getParentId() == null) {
            branch.setParentId(1000L);
        } else {

        }
        if (branch.getBranchName() != null) {
            List<Branch> list = branchService.queryByNameAndPranentId(branch.getParentId(), branch.getBranchName());
            if (list.isEmpty()) {
                branchService.createUser(branch);

                return ResultGenerator.genSuccessResult(branch);
            } else {
                return ResultGenerator.genParameterFailResult();
            }


        }

        return ResultGenerator.genParameterFailResult();

    }

    @ApiOperation(value = "通过BrandId删除文件", notes = "{\n" +
            "\n" +
            "branchId :\"7ea5b7fe68e04d5da5ec66bcfe88d8d3\"\n" +
            "\n" +
            "\n" +
            "   \n" +
            "}")
    @Transactional
    @PostMapping("/deleteBranchById")
    public Result deleteById(@RequestBody @Validated String jsonParams) {
        Branch branch = JSON.parseObject(jsonParams, Branch.class);
        int result = branchService.deleteById(branch.getBranchId());
        mongoTemplate.dropCollection(branch.getBranchId()+"");
//        FileUtil.deleteDirectory(  branch.getZipPath());
        if (result == 1) {
            //删除名录下的所有文件
            String ids = "";
            List<Branch> branches = branchService.findAll();
            List<Branch> mbranches=new ArrayList<>();
            for (Branch data : branches) {
                if (data.getParentId().equals(branch.getBranchId())) {
                    ids = ids + data.getBranchId() + ",";
                    mbranches.add(data);
                }
            }
            if (ids.length() > 1) {
                ids = ids.substring(0, ids.length() - 1);
                if (branchService.deleteByIds(ids) > 0) {
                    for(Branch data:mbranches){

                    }

                    return ResultGenerator.genSuccessResult();
                } else {
                    return ResultGenerator.genParameterFailResult();
                }
            } else {
                return ResultGenerator.genSuccessResult();
            }


        } else {
            return ResultGenerator.genParameterFailResult();
        }

    }




    @ApiOperation(value = "通过BrandId改变分支名称", notes = "{\n" +
            "\n" +
            "branchName :\"哈哈2222221哈aaa\",\n" +
            " branchId :1019,\n" +
            "parentId :1000\n" +
            "   \n" +
            "}\n")
    @PostMapping("/renameBranch")
    public Result update(@RequestBody @Validated String jsonParams) {

        List<Branch> datas = queryBranchByParentId(jsonParams);


        Branch branch = JSON.parseObject(jsonParams, Branch.class);

        for (Branch data : datas) {
            if (data.getBranchName().equals(branch.getBranchName())) {
                return ResultGenerator.genExsitFailResult();
            }
        }
        if (branchService.updateBranchName(branch.getBranchId(), branch.getBranchName()) != 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genParameterFailResult();
        }



    }





/*    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
 *//*       Branch branch = branchService.findById(id);*//*
        return ResultGenerator.genSuccessResult(branch);
    }*/

    @PostMapping("/queryBranchByParentId")
    public Result queryBranchByParentId(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestBody @Validated String jsonParams) {
        PageHelper.startPage(page, size);
        PageInfo pageInfo = null;
        try {
            pageInfo = new PageInfo(queryBranchByParentId(jsonParams));
        } catch (Exception e) {
            ResultGenerator.genParameterFailResult();
        }

        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Branch> list = branchService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @GetMapping("/list1")
    public Result list1(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {

        String  ipAddress ="http://192.168.1.247:8888/";
       List<NameValuePair> params = new ArrayList<NameValuePair>();
////            params.add(new BasicNameValuePair("userName", "Sun"));

      String url =ipAddress+"branch/list";
//        getRest(url,params);
//        Result result =new Result();
//
//        result.setData( R.replace("\\",""));


        return  ResultGenerator.genSuccessResult(RestFulServiceUtil.getRest(url,params,Result.class));


    }
    public static String replaceBlank(String str) {

        String dest = "";

        if (str != null) {

            Pattern p = Pattern.compile("\\s*|\t|\r|\n");

            Matcher m = p.matcher(str);

            dest = m.replaceAll("");

        }

        return dest;

    }

    public List<Branch> queryBranchByParentId(String jsonParams) {
        List<Branch> list = branchService.findAll();
        List<Branch> resultList = new ArrayList<>();

        Branch data = JSON.parseObject(jsonParams, Branch.class);
        for (Branch branch : list) {
            if (branch.getParentId() != null) {
                if (branch.getParentId().equals(data.getParentId())) {
                    resultList.add(branch);
                }
            }
        }

        return resultList;
    }

}
