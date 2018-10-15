package htht.system.ocean.controller;

import com.alibaba.fastjson.JSON;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.model.Hzdmdz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Hzdmdz")
public class HzdmdzController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/GetHzdmdzById")
    public Result getHzdmdzById(@RequestBody @Validated String jsonParams) {
        Query query = new Query();
        Hzdmdz discharge = JSON.parseObject(jsonParams, Hzdmdz.class);
        query.addCriteria(Criteria.where("fId").is(discharge.getfId()));
        List<Hzdmdz> siteModels= mongoTemplate.find(query,Hzdmdz.class);


        return ResultGenerator.genSuccessResult( siteModels);
    }

}
