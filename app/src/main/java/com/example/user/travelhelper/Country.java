package com.example.user.travelhelper;

import java.io.Serializable;

/**
 * Created by User on 3/25/2017.
 */

public class Country implements Serializable {
    String title;
    String photo;

    public Country(String title, String photo) {
        this.title = title;
        this.photo = photo;
    }


}
