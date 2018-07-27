package htht.system.ocean.service.impl;

import htht.system.ocean.dao.UimIssueRoleMapper;
import htht.system.ocean.model.UimIssueRole;
import htht.system.ocean.service.UimIssueRoleService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/03.
 */
@Service
@Transactional
public class UimIssueRoleServiceImpl extends AbstractService<UimIssueRole> implements UimIssueRoleService {
    @Resource
    private UimIssueRoleMapper uimIssueRoleMapper;

}
