package com.wipro.task.network;

import com.wipro.task.model.CanadaBaseModel;
import com.wipro.task.model.CanadaDetailModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("2iodh4vg0eortkl/facts.json")
    Call<CanadaBaseModel> getCanadaDetail();
}
