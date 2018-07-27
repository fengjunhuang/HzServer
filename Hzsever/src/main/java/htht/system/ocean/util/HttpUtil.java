package htht.system.ocean.util;

import java.io.*;
import java.net.URI;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * @author 马弦
 * @date 2017年10月23日 下午2:49
 * HttpClient工具类
 */
public class HttpUtil {
	
	private static Logger logger = Logger.getLogger(HttpUtil.class);

	/**
	 * get请求
	 * @return
	 */
	public static String doGet(String url) {
        try {
        	HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
 
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                
                return strResult;
            }
        } 
        catch (IOException e) {
        	e.printStackTrace();
        }
        
        return null;
	}
	
	/**
	 * post请求(用于key-value格式的参数)
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, Map params){
		
		BufferedReader in = null;  
        try {  
            // 定义HttpClient  
            HttpClient client = new DefaultHttpClient();  
            // 实例化HTTP方法  
            HttpPost request = new HttpPost();  
            request.setURI(new URI(url));
            
            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>(); 
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
    			String name = (String) iter.next();
    			String value = String.valueOf(params.get(name));
    			nvps.add(new BasicNameValuePair(name, value));
    			
    			//System.out.println(name +"-"+value);
    		}
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));
            
            HttpResponse response = client.execute(request);  
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){	//请求成功
            	in = new BufferedReader(new InputStreamReader(response.getEntity()  
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");  
                String line = "";  
                String NL = System.getProperty("line.separator");  
                while ((line = in.readLine()) != null) {  
                    sb.append(line + NL);  
                }
                
                in.close();  
                
                return sb.toString();
            }
            else{	//
            	System.out.println("状态码：" + code);
            	return null;
            }
        }
        catch(Exception e){
        	e.printStackTrace();
        	
        	return null;
        }
	}
	
	/**
	 * post请求（用于请求json格式的参数）
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, String params) throws Exception {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);// 创建httpPost   
    	httpPost.setHeader("Accept", "application/json"); 
    	httpPost.setHeader("Content-Type", "application/json");
    	String charSet = "UTF-8";
    	StringEntity entity = new StringEntity(params, charSet);
    	httpPost.setEntity(entity);        
        CloseableHttpResponse response = null;
        
        try {
        	
        	response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
            	HttpEntity responseEntity = response.getEntity();
            	String jsonString = EntityUtils.toString(responseEntity);
            	return jsonString;
            }
            else{
				 logger.error("请求返回:"+state+"("+url+")");
			}
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return null;
	}
    /**
     * 封装HTTP GET方法
     * 有参数的Get请求
     * @param
     * @param
     * @return
     * @throws ClientProtocolException
     * @throws java.io.IOException
     */
    public static String get(String url, Map<String, String> paramMap) throws ClientProtocolException, IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet();
        List<NameValuePair> formparams = setHttpParams(paramMap);
        String param = URLEncodedUtils.format(formparams, "UTF-8");
        httpGet.setURI(URI.create(url + "?" + param));
        HttpResponse response = httpClient.execute(httpGet);
        String httpEntityContent = getHttpEntityContent(response);
        httpGet.abort();
        return httpEntityContent;
    }
    /**
     * 设置请求参数
     * @param
     * @return
     */
    private static List<NameValuePair> setHttpParams(Map<String, String> paramMap) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> set = paramMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return formparams;
    }

    /**
     * 获得响应HTTP实体内容
     * @param response
     * @return
     * @throws java.io.IOException
     * @throws java.io.UnsupportedEncodingException
     */
    private static String getHttpEntityContent(HttpResponse response) throws IOException, UnsupportedEncodingException {
        //通过HttpResponse 的getEntity()方法获取返回信息
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream is = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line + "\n");
                line = br.readLine();
            }
            br.close();
            is.close();
            return sb.toString();
        }
        return "";
    }
}
