package htht.system.ocean.dao;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.model.Branch;
import htht.system.ocean.model.ShpesData;

public interface ShpesDataMapper extends Mapper<ShpesData> {
   int insertshp(ShpesData shpesData);
   int updateSujectId(ShpesData shpesData);
}