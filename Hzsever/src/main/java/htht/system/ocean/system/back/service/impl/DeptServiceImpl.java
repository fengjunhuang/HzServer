package htht.system.ocean.system.back.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import htht.system.ocean.dao.DepartmentMapper;
import htht.system.ocean.system.back.model.BuildTree;
import htht.system.ocean.system.back.model.DeptDO;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.back.service.DeptService;


@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DepartmentMapper sysDeptMapper;

	@Override
	public DeptDO get(Long deptId){
		return sysDeptMapper.get(deptId);
	}

	@Override
	public List<DeptDO> list(Map<String, Object> map){
		List<DeptDO> deptDOS = sysDeptMapper.selectAll();
		return deptDOS;
	}

	@Override
	public int count(Map<String, Object> map){
		return sysDeptMapper.count(map);
	}

	@Override
	public int save(DeptDO sysDept){
		return sysDeptMapper.save(sysDept);
	}

	@Override
	public int update(DeptDO sysDept){
		return sysDeptMapper.updateByPrimaryKey(sysDept);
	}

	@Override
	public int remove(Long deptId){
		return sysDeptMapper.deleteByPrimaryKey(deptId);
	}

	@Override
	public int batchRemove(Long[] deptIds){
		return sysDeptMapper.batchRemove(deptIds);
	}

	@Override
	public Tree<DeptDO> getTree() {
		List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
		List<DeptDO> sysDepts = sysDeptMapper.selectAll();
		for (DeptDO sysDept : sysDepts) {
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(sysDept.getDeptId().toString());
			tree.setParentId(sysDept.getParentId().toString());
			tree.setText(sysDept.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public boolean checkDeptHasUser(Long deptId) {
		int result = sysDeptMapper.getDeptUserNumber(deptId);
		return result==0?true:false;
	}

}
