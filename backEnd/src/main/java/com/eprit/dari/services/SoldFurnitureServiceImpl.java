package com.eprit.dari.services;

import com.eprit.dari.dao.SoldFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldFurnitureServiceImpl implements ISoldFurnitureService{

    @Autowired
    SoldFurnitureRepository soldFurnitureRepository;
}
