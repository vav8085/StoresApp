package storelocator.br.com.storelocator.network.datasources;

import java.util.HashMap;

import storelocator.br.com.storelocator.MyApplication;
import storelocator.br.com.storelocator.R;
import storelocator.br.com.storelocator.network.serviceBuilder.MyResponse;
import storelocator.br.com.storelocator.network.serviceBuilder.NetworkObserver;
import storelocator.br.com.storelocator.network.serviceBuilder.Repo;
import storelocator.br.com.storelocator.network.response.StoreResponse;

public class StoresNetworkDataSource implements StoresDataSource {
    private static final String URL = MyApplication.getInstance().getString(R.string.url_store);
    private StoresNetworkDataSource() {}
    /**
     * This method will return a new instance of the StoreNetworkDatasource
     *
     * @return
     */
    public static StoresNetworkDataSource newInstance() {
        return new StoresNetworkDataSource();
    }

    public void fetchStoreData(NetworkObserver<MyResponse> observer){
        Repo.newInstance()
                .setContext(MyApplication.getInstance())
                .setHeader(new HashMap<String, String>())
                .setObserver(observer)
                .setUrl(URL)
                .setMyResponseClass(StoreResponse.class)
                .setRequestTypeGET()
                .callService();
    }

}
