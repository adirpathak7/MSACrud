package com.it.serverapp.config;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.ApplicationPath;
import org.eclipse.microprofile.auth.LoginConfig;

@LoginConfig(authMethod = "MP-JWT")
@RolesAllowed("Admin")
@SuppressWarnings({"EmptyClass", "SuppressionAnnotation"})
@ApplicationPath("rest")
public class BootStrap extends jakarta.ws.rs.core.Application {
}
