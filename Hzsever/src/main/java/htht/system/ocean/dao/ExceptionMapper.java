package htht.system.ocean.dao;


import org.springframework.stereotype.Repository;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.system.back.model.ErrorBean;

@Repository
public interface ExceptionMapper extends Mapper<ErrorBean> {

}
