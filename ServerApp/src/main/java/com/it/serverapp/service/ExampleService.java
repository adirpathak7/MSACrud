package com.it.serverapp.service;

import com.it.serverapp.ejb.DoctorBean;
import com.it.serverapp.entity.Doctorsappointment;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/example")
public class ExampleService {

    @EJB
    DoctorBean doctorBean;

    @GET
    public String get() {
        return "Hello, world from server!";
    }

    @Path("/getAllDoctors")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("Admin")
    public Response getAllDoctors() {
        List<Doctorsappointment> list = doctorBean.getAllDoctor();
        return Response.ok(list).build();
    }

    @Path("/searchBySpecialization/{specialization}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("Admin")
    public Response searchBySpecialization(@PathParam("specialization") String specialization) {
        List<Doctorsappointment> list = doctorBean.getDoctorsBySpecialization(specialization);
        return Response.ok(list).build();
    }
}
