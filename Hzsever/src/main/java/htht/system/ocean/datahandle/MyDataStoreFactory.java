package htht.system.ocean.datahandle;

public class MyDataStoreFactory implements IDataStoreFactory {

    @Override
    public IDataStoreHandler createDataStoreHandler() {
        return new MyDataSotreHandler();
    }
}
