package htht.system.ocean.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import htht.system.ocean.core.Result;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.util.List;

public class RestFulServiceUtil {




    public  static<T> T getRest(String url, List<NameValuePair> params, Class<T> clazz){
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);

        UrlEncodedFormEntity uefEntity;

        try{
            uefEntity = new UrlEncodedFormEntity(params, "UTF-8");
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            String json= EntityUtils.toString(entity, "UTF-8");
            int code= response.getStatusLine().getStatusCode();
            JSONObject jsonObject =JSON.parseObject(json);

            if(code==200 ||code ==204){
            T t=    JSON.parseObject(json,clazz);
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
