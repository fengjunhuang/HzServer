package htht.system.ocean.util;

import com.alibaba.fastjson.JSON;

public class CusJson<T> {

    public   T  tomodel(String str,Class<T> t)
    {
        T t1= JSON.parseObject(str, t);
        return t1;

    }
}
