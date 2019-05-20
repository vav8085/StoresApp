package storelocator.br.com.storelocator.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import storelocator.br.com.storelocator.R;
import storelocator.br.com.storelocator.network.response.Store;
import storelocator.br.com.storelocator.observers.StoreSelectionListener;
import storelocator.br.com.storelocator.viewmodels.StoresFragmentViewModel;

public class StoresFragment extends Fragment implements StoreSelectionListener {
    public static final String TAG= StoresFragment.class.getSimpleName();
    public static final String STORE_DATA_FROM_LIST = "STORE_DATA_FROM_LIST";
    private RecyclerView recyclerView;
    private StoresRecyclerViewAdapter adapter;
    private StoresFragmentViewModel model;
    private ShimmerFrameLayout shimmerFrameLayout;
    private TextView noNetworkText;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        model = ViewModelProviders.of(this).get(StoresFragmentViewModel.class);
        View rootView = inflater.inflate(R.layout.stores_fragment, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView_stores_list);
        shimmerFrameLayout = rootView.findViewById(R.id.shimmer);
        noNetworkText = rootView.findViewById(R.id.textview_no_network);
        setRetainInstance(true);
        model.loadStoresData();
        registerObservers(model);
        return rootView;
    }

    private void registerObservers(StoresFragmentViewModel model) {
        model.getStoresData().observe(this, new Observer<List<Store>>() {
            @Override
            public void onChanged(@Nullable List<Store> storeList) {
                setupRecyclerView(storeList);
                noNetworkText.setVisibility(View.GONE);
            }
        });
        model.getErrorData().observe(this, new Observer<Exception>() {
            @Override
            public void onChanged(@Nullable Exception e) {
                recyclerView.setVisibility(View.GONE);
                noNetworkText.setVisibility(View.VISIBLE);

            }
        });
        model.getShimmer().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean) {
                    shimmerFrameLayout.startShimmer();
                    shimmerFrameLayout.setVisibility(View.VISIBLE);
                }
                else {
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setupRecyclerView(List<Store> storeList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new StoresRecyclerViewAdapter(storeList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStoreSelected(Store store) {
        Intent intent = new Intent(getActivity(),StoreDetailsActivity.class);
        intent.putExtra(STORE_DATA_FROM_LIST, store);
        getActivity().startActivity(intent);
    }
}
