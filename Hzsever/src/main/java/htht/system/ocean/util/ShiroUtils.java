package htht.system.ocean.util;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import htht.system.ocean.system.front.model.UserDO;

public class ShiroUtils {
    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    public static UserDO getUser() {
        return (UserDO) getSubjct().getPrincipal();
    }

    public static Long getUserId() {
        return getUser().getUserId();
    }

    public static void logout() {
        getSubjct().logout();
    }
}
