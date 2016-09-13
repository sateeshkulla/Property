package com.property.services.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author skulla
 *
 */
@Document
public class Property {
    private String name;
    
    private Location location;
    
    private Owner owner;
    
    private PricingInfo pricing;
    
    private int bathNo;
    
    private int bedroomNo;
    
    private int areaLength;
    
    private String appliances;
    
    private Features features;

    private String availability;

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PricingInfo getPricing() {
        return pricing;
    }

    public void setPricing(PricingInfo pricing) {
        this.pricing = pricing;
    }

    public int getBathNo() {
        return bathNo;
    }

    public void setBathNo(int bathNo) {
        this.bathNo = bathNo;
    }

    public int getBedroomNo() {
        return bedroomNo;
    }

    public void setBedroomNo(int bedroomNo) {
        this.bedroomNo = bedroomNo;
    }

    public int getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(int areaLength) {
        this.areaLength = areaLength;
    }

    public String getAppliances() {
        return appliances;
    }

    public void setAppliances(String appliances) {
        this.appliances = appliances;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Property [name=" + name + ", location=" + location + ", owner=" + owner + ", pricing=" + pricing + ", bathNo=" + bathNo + ", bedroomNo="
                + bedroomNo + ", areaLength=" + areaLength + ", appliances=" + appliances + ", features=" + features + ", availability=" + availability + "]";
    }
}