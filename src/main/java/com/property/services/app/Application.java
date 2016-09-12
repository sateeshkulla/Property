package com.property.services.app;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.property.services.api.PropertyApiImpl;
import com.property.services.filters.AuthenticationFilter;

/**
 * 
 * @author skulla
 *
 */
public class Application extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public Application() {
        System.out.println("Registering resources..");
        register(AuthenticationFilter.class);
        register(PropertyApiImpl.class);
        register(RolesAllowedDynamicFeature.class);
    }
}

