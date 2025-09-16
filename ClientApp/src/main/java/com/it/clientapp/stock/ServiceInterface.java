/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.it.clientapp.stock;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author Aditya Pathak R
 */
@RegisterRestClient(configKey = "clkey")
public interface ServiceInterface {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get();
    
    @GET
    @Path("/getAllDoctors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctors();
}
