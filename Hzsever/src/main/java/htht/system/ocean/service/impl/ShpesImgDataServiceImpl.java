package htht.system.ocean.service.impl;

import htht.system.ocean.dao.ShpesImgDataMapper;
import htht.system.ocean.model.ShpesImgData;
import htht.system.ocean.service.ShpesImgDataService;
import htht.system.ocean.core.AbstractService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/23.
 */
@Service
@Transactional
public class ShpesImgDataServiceImpl extends AbstractService<ShpesImgData> implements ShpesImgDataService {
    @Resource
    private ShpesImgDataMapper shpesImgDataMapper;


    @Override
    public int createImg(ShpesImgData shpesImgData) {
        return shpesImgDataMapper.createImg(shpesImgData);
    }

    @Override
    public int updateShpDescribe(Long branchId, String shpDescribe, Long shpChildId) {
        return  shpesImgDataMapper.updateShpDescribe(branchId,shpDescribe,shpChildId);
    }

    @Override
    public int updateShpImg(Long branchId, String imgPath, Long shpChildId) {
        return shpesImgDataMapper.updateShpImg(shpChildId,imgPath,branchId);
    }

    @Override
    public List<ShpesImgData> queryShpesChBybranchId(Long branchId,Long shpChildId) {
       List<ShpesImgData> shpesImgData= shpesImgDataMapper.queryShpesChBybranchId(branchId,shpChildId);
        if(shpesImgData!=null&&!shpesImgData.isEmpty()){
            return  shpesImgDataMapper.queryShpesChBybranchId(branchId,shpChildId);
        }
        return  null;
    }
}




