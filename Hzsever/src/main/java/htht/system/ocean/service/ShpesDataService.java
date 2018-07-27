package htht.system.ocean.service;
import htht.system.ocean.model.Branch;
import htht.system.ocean.model.ShpesData;
import htht.system.ocean.core.Service;


/**
 * Created by CodeGenerator on 2018/04/12.
 */
public interface ShpesDataService extends Service<ShpesData> {
    int insert(ShpesData shpesData);
    int updateSujectId(ShpesData shpesData);
}
