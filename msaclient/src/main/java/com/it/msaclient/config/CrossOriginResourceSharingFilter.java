package com.it.msaclient.config;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

/**
 * Manages Access to calls from another origin.
 */
@Provider
public class CrossOriginResourceSharingFilter implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext response) {
        response.getHeaders()
                .putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders()
                .putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE, HEAD");
        response.getHeaders()
                .putSingle("Access-Control-Allow-Credentials", "true");
        response.getHeaders()
                .putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    }

}
