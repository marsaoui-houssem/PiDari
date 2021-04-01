package com.eprit.dari.services;

import com.eprit.dari.dao.BasketRepository;
import com.eprit.dari.dao.FurnitureRepository;
import com.eprit.dari.dao.UserDariRepository;
import com.eprit.dari.entities.Basket;
import com.eprit.dari.entities.Category;
import com.eprit.dari.entities.Furniture;
import com.eprit.dari.entities.UserDari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements IBasketService{

    @Autowired
    BasketRepository basketRepository;
    @Autowired
    FurnitureRepository furnitureRepository;
    @Autowired
    UserDariRepository userDariRepository;


    @Override
    public Long ajouterBasket(int quantity, Long userDariId, Long furnitureId) {
        Long basketID = 0L;
        Furniture furniture = furnitureRepository.findById(furnitureId).get();
        UserDari userDari = userDariRepository.findById(userDariId).get();
        if (verifierFournitureInBasket(userDariId , furnitureId) == false){
            Basket basket= new Basket();
            basket.setQuantity(quantity);
            basket.setFurnitures(furniture);
            basket.setUsers(userDari);
            basketRepository.save(basket);
            basketID = basket.getBasketId();
        } else if (verifierFournitureInBasket(userDariId , furnitureId) == true ){
            Basket basket = basketRepository.getBasketByUserDariAndFurnitureOne(userDariId , furniture);
            int quantitybasket = basket.getQuantity();
            basket.setQuantity(quantity + quantitybasket);
            basketRepository.save(basket);
            basketID = basket.getBasketId();
        }


        return basketID;
    }

    @Override
    public void deleteBasketById(Long basketId) {
        basketRepository.deleteById(basketId);
    }

    @Override
    public List<Basket> getAllBasket() {
        return (List<Basket>) basketRepository.findAll();
    }

    @Override
    public Boolean verifierFournitureInBasket(Long userDariId, Long furnitureId ) {
        Boolean verifFurniture = false;
        Furniture furniture = furnitureRepository.findById(furnitureId).get();
        UserDari userDari = userDariRepository.findById(userDariId).get();

        List<Basket> basketList = basketRepository.getBasketByUserDariAndFurniture(userDariId, furniture);
        for (Basket basket : basketList){
            if (basket.getFurnitures()==furniture){
                verifFurniture = true;
            }
        }
        return verifFurniture;
    }
}
