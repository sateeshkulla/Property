package com.property.services.api;

import java.util.List;

import javax.ws.rs.core.Response;

import com.property.services.model.Property;

public interface PropertyAPI {
    
    List<Property> getAllProperty();
    
    Property getProperty(String name);
    
    Response addProperty(Property property);
    
    void updateProperty(Property property);
    
    void deleteProperty(String name);

}
