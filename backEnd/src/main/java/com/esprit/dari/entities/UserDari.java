package com.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class UserDari implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean activated = false;
    private String imageUrl;
    private String activationKey;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleDari> roleDaris =new ArrayList<>();

    public UserDari() {
    }

    public UserDari(Long userId, String username, String password, String firstName, String lastName, String email, boolean activated, String imageUrl, String activationKey, Collection<RoleDari> roleDaris) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.imageUrl = imageUrl;
        this.activationKey = activationKey;
        this.roleDaris = roleDaris;
    }

    public UserDari(Long userId, String username, String password, Collection<RoleDari> roleDaris) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roleDaris = roleDaris;
    }

    public UserDari(Long userId, String username, String password, String email, Collection<RoleDari> roleDaris) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleDaris = roleDaris;
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
    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public Collection<RoleDari> getRoleDaris() {
        return roleDaris;
    }

    public void setRoleDaris(Collection<RoleDari> roleDaris) {
        this.roleDaris = roleDaris;
    }
}
