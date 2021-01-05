package com.ruthiandchana.travelproject2.UI;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.ruthiandchana.travelproject2.Entities.Travel;
import com.ruthiandchana.travelproject2.Repository.ITravelRepository;
import com.ruthiandchana.travelproject2.Repository.TravelRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    ITravelRepository repository;
    private MutableLiveData<List<Travel>> mutableLiveData = new MutableLiveData<>();
    public MainViewModel(Application p) {
    super(p);
        repository =  TravelRepository.getInstance(p);

        ITravelRepository.NotifyToTravelListListener notifyToTravelListListener = new ITravelRepository.NotifyToTravelListListener() {
            @Override
            public void onTravelsChanged() {
                List<Travel> travelList =repository.getAllTravels();
                mutableLiveData.setValue(travelList);
            }
        };
        repository.setNotifyToTravelListListener(notifyToTravelListListener);
    }
    void addTravel(Travel travel)
    {
        repository.addTravel(travel);
    }
    void updateTravel(Travel travel)
    {
        repository.updateTravel(travel);
    }
    MutableLiveData<List<Travel>> getAllTravels()
    {
        return mutableLiveData;
    }
    MutableLiveData<Boolean> getIsSuccess()
    {
       return repository.getIsSuccess();
    }
}
