package com.telerikacademy.beertag.models;

import java.io.Serializable;

public class BeerRatingId implements Serializable {
    private int user;
    private int beer;

    public BeerRatingId() {
    }

    public BeerRatingId(int user, int beer) {
        this.user = user;
        this.beer = beer;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getBeer() {
        return beer;
    }

    public void setBeer(int beer) {
        this.beer = beer;
    }

}