package storelocator.br.com.storelocator.observers;

import storelocator.br.com.storelocator.network.response.Store;

public interface StoreSelectionListener {
    void onStoreSelected(Store store);
}
