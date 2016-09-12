package com.property.services.filters;

import java.io.IOException;

import javax.annotation.security.PermitAll;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;
import java.util.List;
import java.util.StringTokenizer;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Context
	private UriInfo uriInfo;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
			.entity("You cannot access this resource").build();
	private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
			.entity("Access blocked for all users !!").build();

	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("FILTER GOT CALLED.");
		// System.out.println(resourceInfo.getResourceMethod().getName());
		// System.out.println(uriInfo.getPath());
		// Implement for Authentication and Authorizations
		// throw new WebApplicationException(Response.Status.UNAUTHORIZED);

		Method method = resourceInfo.getResourceMethod();
		// Access allowed for all
		if (!method.isAnnotationPresent(PermitAll.class)) {

			// Get request headers
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();

			// Fetch authorization header
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

			// Get encoded username and password
			final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

			// Decode username and password
			String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));
			;

			// Split username and password tokens
			final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();

			// Verifying Username and password
			System.out.println("Authentication Details...");
			System.out.println(username);
			System.out.println(password);

		}

	}

}
