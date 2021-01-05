package com.ruthiandchana.travelproject2.Data;

import com.ruthiandchana.travelproject2.Entities.Travel;

import java.util.List;

public interface IHistoryDataSource {
    public void addTravel(Travel p);

    public void addTravel(List<Travel> travelList);

    public void editTravel(Travel p);

    public void deleteTravel(Travel p);

    public void clearTable();
}
