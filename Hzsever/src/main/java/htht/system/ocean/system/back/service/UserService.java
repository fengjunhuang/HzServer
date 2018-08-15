package htht.system.ocean.system.back.service;


import htht.system.ocean.system.back.model.DeptDO;
import htht.system.ocean.system.back.model.SysUserDO;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.back.model.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface UserService  {
	SysUserDO get(Long id);

	List<SysUserDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(SysUserDO user);

	int update(SysUserDO user);

	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	int resetPwd(UserVO userVO, SysUserDO userDO) throws Exception;
	int adminResetPwd(UserVO userVO) throws Exception;
	Tree<DeptDO> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(SysUserDO userDO);

	/**
	 * 更新个人图片
	 * @param file 图片
	 * @param avatar_data 裁剪信息
	 * @param userId 用户ID
	 * @throws Exception
	 */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception;
}
