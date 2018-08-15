package htht.system.ocean.system.front.service;


import com.github.pagehelper.PageInfo;
import htht.system.ocean.system.back.model.DeptDO;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.front.model.UserDO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public interface FrontUserService extends htht.system.ocean.core.Service<UserDO> {

	@Transactional
	int addUser(UserDO userDO);

    PageInfo getAllUserByPage(Map<String, Object> params);

    @Transactional
    int updateUserInfo(UserDO userDO);

    int batchremove(Long[] userIds);

	Tree<DeptDO> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(UserDO userDO);

	/**
	 * 更新个人图片
	 * @param file 图片
	 * @param avatar_data 裁剪信息
	 * @param userId 用户ID
	 * @throws Exception
	 */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception;

    UserDO saveUserInfo(UserDO userDO);
}
