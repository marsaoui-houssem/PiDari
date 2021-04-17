package com.eprit.dari.services;


import com.eprit.dari.entities.GiftPoints;

import java.util.List;

public interface IGiftPointsService {

    public Long transferGiftPoints(Long userDariId , int points);
    public void deleteGiftPointsById(Long giftPointsId);
    public List<GiftPoints> getAllGiftPoints();
    public Boolean verifCode(String code);

}
