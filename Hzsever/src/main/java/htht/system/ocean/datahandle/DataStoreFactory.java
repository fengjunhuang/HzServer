package htht.system.ocean.datahandle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class DataStoreFactory{
    private static final String FILE_PATH = "src/main/resources/config/datahandler.properties";

    private DataStoreFactory(){}
    private static Map<String, IDataStoreHandler> handlerPool = new HashMap<>();
    
    private static final String PACKAGE_NAME="com.piesat.project.datahandle.";

    private static IDataStoreHandler createDataStoreHandler(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!clazzName.startsWith("com")){
            clazzName = PACKAGE_NAME +clazzName;
        }
        Class<?> clazz = Class.forName(clazzName);
        return (IDataStoreHandler) clazz.newInstance();
    }

    public static void initPool() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);
            Properties props = new Properties();
            props.load(fis);
            for (String name : props.stringPropertyNames()) {
                handlerPool.put(name, createDataStoreHandler(props.getProperty(name)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("resource文件夹中没有发现datahandler.properties");
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    public static IDataStoreHandler get(String typeName) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        IDataStoreHandler dataStoreHandler = handlerPool.get(typeName);
//        if (dataStoreHandler ==null){
//            dataStoreHandler = createDataStoreHandler(clazzName);
//            handlerPool.put(clazzName,dataStoreHandler);
//            SuperLogger.e("还没有"+clazzName+"的对象，现在创建一个");
//        }
        return dataStoreHandler;
    }
}
