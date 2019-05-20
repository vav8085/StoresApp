package storelocator.br.com.storelocator.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import storelocator.br.com.storelocator.R;
import storelocator.br.com.storelocator.network.response.Store;

public class StoresDetailsFragment extends Fragment {
    public static final String TAG= StoresDetailsFragment.class.getSimpleName();
    private Store store;
    public void setStore(Store store){
        this.store = store;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.store_details_fragment, container, false);
        setRetainInstance(true);
        return rootView;
    }
}
