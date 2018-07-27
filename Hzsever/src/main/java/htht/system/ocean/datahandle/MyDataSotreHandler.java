package htht.system.ocean.datahandle;


import java.io.InputStream;

import htht.system.ocean.util.SuperLogger;

public class MyDataSotreHandler extends BaseDataStoreHandler {
    @Override
    protected void onPreHandle() {

    }

    @Override
    protected void onDataParse() {

    }

    @Override
    protected boolean isDataExistInDB() {
        return false;
    }

    @Override
    protected void oldDataHandle() {

    }

    @Override
    protected void sourceDataHandle() {

    }

    @Override
    protected void onDataStore() {

    }

    @Override
    public void onStore(String filePath) {
        SuperLogger.e(filePath);
    }

    @Override
    public void onStore(InputStream inputStream) {

    }
}
