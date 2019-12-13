package com.wipro.task.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.wipro.task.model.CanadaDetailModel;
import com.wipro.task.repository.CanadaRepository;

import java.util.List;

public class CanadaViewModel extends AndroidViewModel {
    private CanadaRepository canadaRepository;

    public CanadaViewModel(@NonNull Application application) {
        super(application);
        canadaRepository = new CanadaRepository(application);
    }

    public LiveData<List<CanadaDetailModel>> getCListLiveData(){
        return canadaRepository.getMutableLiveData();
    }
}
