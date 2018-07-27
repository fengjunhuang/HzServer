package htht.system.ocean.service;
import htht.system.ocean.model.ShpesImgData;
import htht.system.ocean.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/23.
 */
public interface ShpesImgDataService extends Service<ShpesImgData> {

   public int createImg(ShpesImgData shpesImgData);
   public int updateShpDescribe(Long branchId, String shpDescribe, Long shpChildId);
   public int updateShpImg(Long branchId, String imgPath, Long shpChildId);
   public List<ShpesImgData> queryShpesChBybranchId(Long branchId, Long shpChildId);
}
