package htht.system.ocean.system.back.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import htht.system.ocean.core.AbstractService;
import htht.system.ocean.dao.ExceptionMapper;
import htht.system.ocean.system.back.model.ErrorBean;
import htht.system.ocean.system.back.service.ExceptionService;

@Service
public class ExceptionServiceImpl extends AbstractService<ErrorBean> implements ExceptionService {
    @Resource
    ExceptionMapper mExceptionMapper;

}
