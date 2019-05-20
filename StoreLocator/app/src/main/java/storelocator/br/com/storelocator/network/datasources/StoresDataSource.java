package storelocator.br.com.storelocator.network.datasources;

import storelocator.br.com.storelocator.network.serviceBuilder.MyResponse;
import storelocator.br.com.storelocator.network.serviceBuilder.NetworkObserver;

public interface StoresDataSource {
    void fetchStoreData(NetworkObserver<MyResponse> observer);
}
