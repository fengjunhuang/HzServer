package htht.system.ocean.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.system.front.model.UserDO;

@Repository
public interface FrontUserMapper extends Mapper<UserDO> {
    UserDO get(Long userId);

    List<UserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserDO user);

    int update(UserDO user);

    int remove(Long userId);

    int batchRemove(Long[] userIds);

    Long[] listAllDept();

    List<UserDO> getAllUser();
}
