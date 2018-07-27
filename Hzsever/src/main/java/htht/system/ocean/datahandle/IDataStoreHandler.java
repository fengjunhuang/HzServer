package htht.system.ocean.datahandle;

import java.io.InputStream;

/**
 * 将解析后的数据存入数据库
 */
public interface IDataStoreHandler {

    void onStore(String filePath);

    void onStore(InputStream inputStream);
}
