package com.hunza.caterer.documents.subClasses;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Location {

    //Only alphabets
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String city;

    @NotNull
    @NotBlank
    private String Street;

    //Optional
    private String postalCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
