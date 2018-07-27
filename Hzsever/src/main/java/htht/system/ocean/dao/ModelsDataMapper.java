package htht.system.ocean.dao;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.model.ModelsData;
import htht.system.ocean.model.ShpesData;

public interface ModelsDataMapper extends Mapper<ModelsData> {
    int updateSujectId(ModelsData modelsData);
}