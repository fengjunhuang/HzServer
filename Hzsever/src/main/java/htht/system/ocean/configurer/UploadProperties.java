/**
 * Project Name:meatball-core
 * File Name:MeatballProperties.java
 * Package Name:com.meatball.component
 * Date:2017年10月14日下午2:54:03
 * Copyright (c) 2017, zhang.xiangyu@foxmail.com All Rights Reserved.
 */
package htht.system.ocean.configurer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Title: MeatballProperties.java
 * @Package com.meatball.component
 * @Description: TODO(读取自定义配置参数)
 * @author 張翔宇
 * @date 2017年10月14日 下午2:54:03
 * @version V1.0
 */
@Component
@ConfigurationProperties("upload")
public class UploadProperties {
    // 获取存放位置
    private Map<String, String> localtion;

    // 单个文件大小
    private String maxFileSize;

    // 单次上传总文件大小
    private String maxRequestSize;

    public Map<String, String> getLocaltion() {
        return localtion;
    }

    public void setLocaltion(Map<String, String> localtion) {
        this.localtion = localtion;
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getMaxRequestSize() {
        return maxRequestSize;
    }

    public void setMaxRequestSize(String maxRequestSize) {
        this.maxRequestSize = maxRequestSize;
    }

    public String getBasePath() {
        String location = "";
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")) {
            location = this.getLocaltion().get("windows");
        } else {
            location = this.getLocaltion().get("linux");
        }
        return location;
    }
}