/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.it.clientapp.doctor;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
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
    @RolesAllowed({"admin", "user"})
    @ClientHeaderParam(name = "Authorization", value = "{getToken}")
    public Response getAllDoctors();

    @GET
    @Path("/searchBySpecialization/{specialization}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @ClientHeaderParam(name = "Authorization", value = "{getToken}")
    public Response searchBySpecialization(@PathParam("specialization") String specialization);

    default String getToken() {
        Config config = ConfigProvider.getConfig();
        String token = "Bearer " + config.getValue("jwt", String.class);;
        return token;
    }
}
