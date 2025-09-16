package com.it.msaserver.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/example")
public class ExampleService {

    @GET
    public Response get() {
        return Response.ok("Hello, world!").build();
    }

}
