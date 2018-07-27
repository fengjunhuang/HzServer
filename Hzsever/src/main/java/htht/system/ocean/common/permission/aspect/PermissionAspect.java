package htht.system.ocean.common.permission.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import htht.system.ocean.common.permission.annotation.NeedPermission;
import htht.system.ocean.dao.BranchMapper;
import htht.system.ocean.dao.SysUserMapper;
import htht.system.ocean.model.Branch;
import htht.system.ocean.system.back.model.R;
import htht.system.ocean.system.back.model.SysUserDO;
import htht.system.ocean.util.HttpContextUtils;
import htht.system.ocean.util.ShiroUtils;

@Aspect
@Component
public class PermissionAspect {

    @Autowired
    BranchMapper mBranchMapper;
    @Autowired
    SysUserMapper mSysUserMapper;

    @Pointcut("@annotation(htht.system.ocean.common.permission.annotation.NeedPermission)")
    public void permissionPointCut() {
    }

    @Around("permissionPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
//		Object[] args = Point.getArgs();//获取参数
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        Long userId = ShiroUtils.getUserId();
        SysUserDO sysUserDO = mSysUserMapper.selectByPrimaryKey(userId);
        long deptId = sysUserDO.getDeptId();
        String branchId = request.getParameter("branchId");
        Branch branch = mBranchMapper.selectByPrimaryKey(branchId);
        long createDeptId = branch.getCreateDeptId();
        boolean isEdit = isEdit(point);
        if (createDeptId == deptId) {
            return checkCurrentDept(point, isEdit);
        } else {
            return checkOtherDept(point, isEdit, deptId, branch);
        }
    }

    private Object checkOtherDept(ProceedingJoinPoint point, boolean isEdit, long deptId, Branch branch) throws Throwable {
        if (isEdit) {
            return R.error(300, "没有权限");
        }
        String checkDeptIds = branch.getCheckDeptIds();
        if (checkDeptIds == null || checkDeptIds.equals("")) {
            return R.error(300, "没有权限");
        } else {
            String[] ids = checkDeptIds.split(",");
            for (int i = 0; i < ids.length; i++) {
                long id = Long.parseLong(ids[i]);
                if (id == deptId) {
                    return point.proceed();
                }
            }
            return point.proceed();
        }
    }

    private Object checkCurrentDept(ProceedingJoinPoint point, boolean isEdit) throws Throwable {
        if (isEdit) {
            //TODO 检查用户的角色
            if (true) {
                return point.proceed();
            } else {
                return R.error(300, "没有权限");
            }
        } else {
            return point.proceed();
        }
    }

    private boolean isEdit(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        NeedPermission syslog = method.getAnnotation(NeedPermission.class);
        return syslog.value();
    }

}
