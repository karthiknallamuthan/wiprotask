package com.wipro.task.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.wipro.task.model.CanadaBaseModel;
import com.wipro.task.model.CanadaDetailModel;
import com.wipro.task.network.ApiService;
import com.wipro.task.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CanadaRepository {

    private static final String TAG = "CanadaRepository";
    private ArrayList<CanadaDetailModel> canadaDetailModelArrayList = new ArrayList<>();
    private MutableLiveData<List<CanadaDetailModel>> caListMutableLiveData = new MutableLiveData<>();
    private Application application;
    public CanadaRepository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<CanadaDetailModel>> getMutableLiveData(){
        final ApiService apiService = RetrofitClient.getService();
        Call<CanadaBaseModel> call = apiService.getCanadaDetail();

        call.enqueue(new Callback<CanadaBaseModel>() {
            @Override
            public void onResponse(Call<CanadaBaseModel> call, Response<CanadaBaseModel> response) {
                CanadaBaseModel canadaBaseModel = response.body();
                if (canadaBaseModel!=null && canadaBaseModel.getCanadaDetailModels()!=null){
                    canadaDetailModelArrayList = (ArrayList<CanadaDetailModel>) canadaBaseModel.getCanadaDetailModels();
                    caListMutableLiveData.setValue(canadaDetailModelArrayList);
                }
            }

            @Override
            public void onFailure(Call<CanadaBaseModel> call, Throwable t) {

            }
        });
        return caListMutableLiveData;

    }
}
