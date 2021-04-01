package com.eprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDari implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean actived;
    private String ville;
    private String email;
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy="users", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<GiftPoints> giftPoints = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy="users", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Basket> baskets = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy="users", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Command> commands = new ArrayList<>();

    public String getVille() {
        return ville;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public List<GiftPoints> getGiftPoints() {
        return giftPoints;
    }

    public void setGiftPoints(List<GiftPoints> giftPoints) {
        this.giftPoints = giftPoints;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
