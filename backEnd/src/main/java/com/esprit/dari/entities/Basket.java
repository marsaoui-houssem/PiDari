package com.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import  java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Basket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;
    private Integer quantity;

    @OneToMany(mappedBy="basket", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Furnitures> furnitures = new ArrayList<>();

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Furnitures> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furnitures> furnitures) {
        this.furnitures = furnitures;
    }
}
