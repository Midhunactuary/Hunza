package com.hunza.caterer.dto;

import com.hunza.caterer.documents.Caterer;
import com.hunza.caterer.documents.subClasses.Capacity;
import com.hunza.caterer.documents.subClasses.ContactInfo;
import com.hunza.caterer.documents.subClasses.Location;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CatererCreateDTO {

    @NotNull @NotBlank
    private String name;

    private Location location;

    private Capacity capacity;

    private ContactInfo contactInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }


}
