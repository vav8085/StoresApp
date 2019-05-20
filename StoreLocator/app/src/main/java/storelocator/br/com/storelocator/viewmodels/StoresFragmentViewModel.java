package storelocator.br.com.storelocator.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.volley.VolleyError;

import java.util.List;

import storelocator.br.com.storelocator.R;
import storelocator.br.com.storelocator.network.repositories.StoresRepository;
import storelocator.br.com.storelocator.network.response.Store;
import storelocator.br.com.storelocator.network.response.StoreResponse;
import storelocator.br.com.storelocator.network.serviceBuilder.MyResponse;
import storelocator.br.com.storelocator.network.serviceBuilder.NetworkObserver;

public class StoresFragmentViewModel extends ViewModel{
    private StoresRepository storesRepository;
    MutableLiveData<List<Store>> storesData;
    MutableLiveData<Exception> errorData;
    MutableLiveData<Boolean> shimmer;
    public StoresFragmentViewModel() {
        super();
        storesRepository = StoresRepository.getInstance();
        storesData = new MutableLiveData<>();
        errorData = new MutableLiveData<>();
        shimmer = new MutableLiveData<>();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void loadStoresData() {
        shimmer.postValue(true);
        storesRepository.fetchStoreData(new NetworkObserver<MyResponse>() {
            @Override
            public void onSuccess(MyResponse response) {
                storesData.postValue(((StoreResponse) response).getStores());
                shimmer.postValue(false);
            }

            @Override
            public void onFailure(VolleyError e) {
                errorData.postValue(e);
                shimmer.postValue(false);
            }
        });
    }

    public LiveData<List<Store>> getStoresData() {
        return storesData;
    }

    public LiveData<Exception> getErrorData() {
        return errorData;
    }

    public LiveData<Boolean> getShimmer() {
        return shimmer;
    }
}
