
package storelocator.br.com.storelocator.network.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import storelocator.br.com.storelocator.network.serviceBuilder.MyResponse;

public class StoreResponse implements MyResponse {

    @SerializedName("stores")
    @Expose
    private List<Store> stores = null;

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

}
