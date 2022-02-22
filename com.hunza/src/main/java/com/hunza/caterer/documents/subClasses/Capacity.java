package com.hunza.caterer.documents.subClasses;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class Capacity {
    @NotBlank(message = "minimumGuests should not be blank") @Positive(message = "minimumGuests should not be positive")
    private int minimumGuests;

    // maximumGuests >= minimumGuests
    @NotBlank(message = "maximumGuests should not be blank") @Positive(message = "maximumGuests should not be positive")
    private int maximumGuests;

    public int getMinimumGuests() {
        return minimumGuests;
    }

    public void setMinimumGuests(int minimumGuests) {
        this.minimumGuests = minimumGuests;
    }

    public int getMaximumGuests() {
        return maximumGuests;
    }

    public void setMaximumGuests(int maximumGuests) {
        this.maximumGuests = maximumGuests;
    }
}
