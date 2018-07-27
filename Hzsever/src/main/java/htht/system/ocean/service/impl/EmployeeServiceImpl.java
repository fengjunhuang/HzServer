package htht.system.ocean.service.impl;

import htht.system.ocean.dao.EmployeeMapper;
import htht.system.ocean.model.Employee;
import htht.system.ocean.service.EmployeeService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/03/22.
 */
@Service
@Transactional
public class EmployeeServiceImpl extends AbstractService<Employee> implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

}
