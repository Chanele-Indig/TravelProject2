package com.ruthiandchana.travelproject2.Repository;

import androidx.lifecycle.MutableLiveData;

import com.ruthiandchana.travelproject2.Data.ITravelDataSource;
import com.ruthiandchana.travelproject2.Entities.Travel;

import java.util.List;

public interface ITravelRepository {

    void addTravel(Travel travel);
    void updateTravel(Travel travel);
    List<Travel> getAllTravels();
    MutableLiveData<Boolean> getIsSuccess();
    interface NotifyToTravelListListener {
        void onTravelsChanged();
    }
    void setNotifyToTravelListListener(ITravelRepository.NotifyToTravelListListener l);
}
