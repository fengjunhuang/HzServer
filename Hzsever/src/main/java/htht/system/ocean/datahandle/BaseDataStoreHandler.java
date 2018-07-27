package htht.system.ocean.datahandle;

public abstract class BaseDataStoreHandler implements IDataStoreHandler {
    /**
     * 数据预处理(解压等)
     */
    protected abstract void onPreHandle();

    /**
     * 数据解析
     */
    protected abstract void onDataParse();

    /**
     * 数据库是否已经存在这条数据
     * @return
     */
    protected abstract boolean isDataExistInDB();

    /**
     * 旧数据的处理
     */
    protected abstract void oldDataHandle();

    /**
     * 数据源的处理
     */
    protected abstract void sourceDataHandle();

    /**
     * 数据入库
     */
    protected abstract void onDataStore();

}
