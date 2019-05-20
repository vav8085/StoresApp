package storelocator.br.com.storelocator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import storelocator.br.com.storelocator.R;
import storelocator.br.com.storelocator.network.response.Store;

public class StoreDetailsActivity extends AppCompatActivity {
    private Store storeData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StoresDetailsFragment storesDetailsFragment = new StoresDetailsFragment();
        attachFragment(R.id.view_fragment_store_details,storesDetailsFragment,StoresDetailsFragment.TAG);
        storeData = (Store) getIntent().getSerializableExtra(StoresFragment.STORE_DATA_FROM_LIST);
        getSupportActionBar().setTitle(storeData.getName());
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void attachFragment(int container, Fragment fragment, String tag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container,fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
