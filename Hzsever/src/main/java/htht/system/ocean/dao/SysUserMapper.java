package htht.system.ocean.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.system.back.model.SysUserDO;

@Repository
public interface SysUserMapper extends Mapper<SysUserDO> {
    SysUserDO get(Long userId);

    List<SysUserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(SysUserDO user);

    int update(SysUserDO user);

    int remove(Long userId);

    int batchRemove(Long[] userIds);

    Long[] listAllDept();
}
