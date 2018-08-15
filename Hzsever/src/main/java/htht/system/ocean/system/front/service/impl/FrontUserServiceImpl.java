package htht.system.ocean.system.front.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import htht.system.ocean.core.AbstractService;
import htht.system.ocean.dao.DepartmentMapper;
import htht.system.ocean.dao.FrontUserMapper;
import htht.system.ocean.dao.FrontUserRoleMapper;
import htht.system.ocean.system.back.model.BuildTree;
import htht.system.ocean.system.back.model.DeptDO;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.back.service.UserService;
import htht.system.ocean.system.front.model.UserDO;
import htht.system.ocean.system.front.model.UserRoleDO;
import htht.system.ocean.system.front.service.FrontUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class FrontUserServiceImpl extends AbstractService<UserDO> implements FrontUserService {
    @Autowired
    FrontUserMapper userMapper;
    @Autowired
    FrontUserRoleMapper userRoleMapper;
    @Autowired
    DepartmentMapper deptMapper;
    //	@Autowired
//	private FileService sysFileService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional
    @Override
    public int addUser(UserDO userDO) {
        Long roleId = userDO.getRoleId();
        UserRoleDO roleDO = new UserRoleDO();
//                roleDO.setId(roleId);
        roleDO.setRoleId(roleId);
        roleDO.setUserId(userDO.getUserId());
        int index = userRoleMapper.insertSelective(roleDO);
        if (index <= 0) {
            throw new RuntimeException("用户角色添加失败");
        }
        int insert = userMapper.insertSelective(userDO);
        if (insert <= 0) {
            throw new RuntimeException("用户添加失败");
        }
        return insert;
    }

    @Override
    public PageInfo getAllUserByPage(Map<String, Object> params) {
        PageHelper.startPage(Integer.parseInt((String) params.get("offset")), Integer.parseInt((String) params.get("limit")));
        List<UserDO> list = userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    @Transactional
    public int updateUserInfo(UserDO userDO) {
        int update = userMapper.updateByPrimaryKey(userDO);
        return update;
    }

    @Transactional
    @Override
    public int batchremove(Long[] userIds) {
        int count = userMapper.batchRemove(userIds);
        userRoleMapper.batchRemoveByUserId(userIds);
        return count;
    }

    @Override
    public Tree<DeptDO> getTree() {
        List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
        List<DeptDO> depts = deptMapper.list(new HashMap<String, Object>(16));
        Long[] pDepts = deptMapper.listParentDept();
        Long[] uDepts = userMapper.listAllDept();
        Long[] allDepts = (Long[]) ArrayUtils.addAll(pDepts, uDepts);
        for (DeptDO dept : depts) {
            if (!ArrayUtils.contains(allDepts, dept.getDeptId())) {
                continue;
            }
            Tree<DeptDO> tree = new Tree<DeptDO>();
            tree.setId(dept.getDeptId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "dept");
            tree.setState(state);
            trees.add(tree);
        }
        List<UserDO> users = userMapper.list(new HashMap<String, Object>(16));
        for (UserDO user : users) {
            Tree<DeptDO> tree = new Tree<DeptDO>();
            tree.setId(user.getUserId().toString());
//            tree.setParentId(user.getDeptId().toString());
            tree.setText(user.getUserName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "user");
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DeptDO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public int updatePersonal(UserDO userDO) {
        return userMapper.update(userDO);
    }

    @Override
    public Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception {
//		String fileName = file.getOriginalFilename();
//		fileName = FileUtil.renameToUUID(fileName);
//		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
//		//获取图片后缀
//		String prefix = fileName.substring((fileName.lastIndexOf(".")+1));
//		String[] str=avatar_data.split(",");
//		//获取截取的x坐标
//		int x = (int)Math.floor(Double.parseDouble(str[0].split(":")[1]));
//		//获取截取的y坐标
//		int y = (int)Math.floor(Double.parseDouble(str[1].split(":")[1]));
//		//获取截取的高度
//		int h = (int)Math.floor(Double.parseDouble(str[2].split(":")[1]));
//		//获取截取的宽度
//		int w = (int)Math.floor(Double.parseDouble(str[3].split(":")[1]));
//		//获取旋转的角度
//		int r = Integer.parseInt(str[4].split(":")[1].replaceAll("}", ""));
//		try {
//			BufferedImage cutImage = ImageUtils.cutImage(file,x,y,w,h,prefix);
//			BufferedImage rotateImage = ImageUtils.rotateImage(cutImage, r);
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			boolean flag = ImageIO.write(rotateImage, prefix, out);
//			//转换后存入数据库
//			byte[] b = out.toByteArray();
//			FileUtil.uploadFile(b, bootdoConfig.getUploadPath(), fileName);
//		} catch (Exception e) {
//			throw  new Exception("图片裁剪错误！！");
//		}
//		Map<String, Object> result = new HashMap<>();
//		if(sysFileService.save(sysFile)>0){
//			UserDO userDO = new UserDO();
//			userDO.setUserId(userId);
//			userDO.setPicId(sysFile.getId());
//			if(userMapper.update(userDO)>0){
//				result.put("url",sysFile.getUrl());
//			}
//		}
//		return result;
        return null;
    }

    @Override
    public UserDO saveUserInfo(UserDO userDO) {
        int save = userMapper.save(userDO);
        if (save > 0) {
            return userDO;
        }
        return null;
    }

}
