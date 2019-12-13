package com.wipro.task.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import com.wipro.task.R;
import com.wipro.task.adapter.CanadaDetailAdapter;
import com.wipro.task.model.CanadaDetailModel;
import com.wipro.task.viewmodel.CanadaViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private CanadaViewModel canadaViewModel;
    CanadaDetailAdapter canadaDetailAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializationViews();
        canadaViewModel = ViewModelProviders.of(this).get(CanadaViewModel.class);
        getCanadaList();
    }

    private void getCanadaList() {
        swipeRefresh.setRefreshing(true);
        canadaViewModel.getCListLiveData().observe(this, new Observer<List<CanadaDetailModel>>() {
            @Override
            public void onChanged(List<CanadaDetailModel> canadaDetailModels) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(canadaDetailModels);
            }
        });
    }
    private void prepareRecyclerView(List<CanadaDetailModel> canadaDetailModelList) {
        canadaDetailAdapter = new CanadaDetailAdapter(canadaDetailModelList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(canadaDetailAdapter);
        canadaDetailAdapter.notifyDataSetChanged();

    }

    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.recyclerView);
    }
}
