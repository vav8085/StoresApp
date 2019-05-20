package storelocator.br.com.storelocator.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import storelocator.br.com.storelocator.R;
import storelocator.br.com.storelocator.observers.StoreSelectionListener;
import storelocator.br.com.storelocator.network.response.Store;

public class StoresRecyclerViewAdapter extends RecyclerView.Adapter<StoresRecyclerViewAdapter.StoresViewHolder> {
    private List<Store> storeList;
    private StoreSelectionListener listener;

    public StoresRecyclerViewAdapter(List<Store> storeList, StoreSelectionListener listener) {
        this.storeList = storeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_stores, parent, false);
        StoresViewHolder storesViewHolder = new StoresViewHolder(v);
        return storesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoresViewHolder storesViewHolder, int i) {
        storesViewHolder.storesName.setText(storeList.get(i).getName());
        Picasso.get()
                .load(storeList.get(i).getStoreLogoURL())
                .fit()
                .into(storesViewHolder.storeImage);
        storesViewHolder.storeAddress.setText(storeList.get(i).getAddress()+", "
                +storeList.get(i).getCity()+", "
                +storeList.get(i).getState()+", "
                +storeList.get(i).getZipcode()
                );
        storesViewHolder.storePhone.setText(storeList.get(i).getPhone());
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    public void setStoresData(List<Store> storesData) {
        storeList = storesData;
    }

    class StoresViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView storesName;
        ImageView storeImage;
        TextView storeAddress;
        TextView storePhone;
        public StoresViewHolder(@NonNull View itemView) {
            super(itemView);
            storesName = itemView.findViewById(R.id.textview_storeName);
            storeImage = itemView.findViewById(R.id.imageview_storeImage);
            storeAddress = itemView.findViewById(R.id.textview_storeAddress);
            storePhone = itemView.findViewById(R.id.textview_storePhone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onStoreSelected(storeList.get(getLayoutPosition()));
        }
    }
}
