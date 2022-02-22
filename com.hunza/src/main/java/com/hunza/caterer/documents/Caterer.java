package com.hunza.caterer.documents;

import com.hunza.caterer.documents.subClasses.Capacity;
import com.hunza.caterer.documents.subClasses.ContactInfo;
import com.hunza.caterer.documents.subClasses.Location;
import com.hunza.caterer.dto.CatererCreateDTO;
import org.springframework.data.annotation.Id;


public class Caterer {

    @Id
    private String id;

    private String name;

    private Location location;

    private Capacity capacity;

    private ContactInfo contactInfo;

    public Caterer() {
    }

    public Caterer(String name, Location location,Capacity capacity,ContactInfo contactInfo) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.contactInfo = contactInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    static public Caterer mapDTOtoEntity(CatererCreateDTO catererCreateDTO){
        return new Caterer(catererCreateDTO.getName(), catererCreateDTO.getLocation(), catererCreateDTO.getCapacity(),catererCreateDTO.getContactInfo());
    }
}
