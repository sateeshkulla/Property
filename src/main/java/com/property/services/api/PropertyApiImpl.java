package com.property.services.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.property.services.model.Property;

@Path("V1")
public class PropertyApiImpl implements PropertyAPI{
    
    @Autowired 
    private MongoTemplate mongoTemplate;
    
    private String collectionName = "assets";
    
    @GET
    @Path("/property")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Property> getAllProperty() {
       // System.out.println(mongoTemplate.findAll(Property.class, collectionName).get(0).getName());
        return mongoTemplate.findAll(Property.class, collectionName);
    }
    
    @GET
    @Path("/property/{propertyName}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Property getProperty(String name) {
        return null;
    }
    
    @POST
    @Path("/property")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProperty(Property property) {
        //System.out.println(mongoTemplate.getDb());
        //System.out.println(mongoTemplate.getDb().getCollectionNames().iterator().next());
        System.out.println(property.getName());
        mongoTemplate.insert(property, collectionName);
        return Response.ok("Created Property").build();
    }

    public void updateProperty(Property property) {
        
    }
    
    @DELETE
    @Path("/property/{propertyName}")
    public void deleteProperty(String name) {
        
    }

}
