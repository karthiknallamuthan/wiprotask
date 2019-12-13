package com.wipro.task.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CanadaBaseModel {

    @SerializedName("rows")
    @Expose
    private List<CanadaDetailModel> canadaDetailModels = null;

    @SerializedName("title")
    private String title;

    public List<CanadaDetailModel> getCanadaDetailModels() {
        return canadaDetailModels;
    }

    public void setCanadaDetailModels(List<CanadaDetailModel> canadaDetailModels) {
        this.canadaDetailModels = canadaDetailModels;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
