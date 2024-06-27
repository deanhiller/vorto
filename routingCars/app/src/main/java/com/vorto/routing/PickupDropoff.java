package com.vorto.routing;

public class PickupDropoff {
    private int loadNumber;
    private GeoLocation pickup;
    private GeoLocation dropoff;

    public int getLoadNumber() {
        return loadNumber;
    }

    public void setLoadNumber(int loadNumber) {
        this.loadNumber = loadNumber;
    }

    public GeoLocation getPickup() {
        return pickup;
    }

    public void setPickup(GeoLocation pickup) {
        this.pickup = pickup;
    }

    public GeoLocation getDropoff() {
        return dropoff;
    }

    public void setDropoff(GeoLocation dropoff) {
        this.dropoff = dropoff;
    }

    @Override
    public String toString() {
        return "Location{" +
                "loadNumber=" + loadNumber +
                ", pickup=" + pickup +
                ", dropoff=" + dropoff +
                '}';
    }
}
