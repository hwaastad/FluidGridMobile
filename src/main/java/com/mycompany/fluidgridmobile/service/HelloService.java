/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fluidgridmobile.service;

import com.mycompany.fluidgridmobile.ejb.BusinessBeanLocal;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.SecurityContext;

/**
 * REST Web Service
 *
 * @author helge
 */
@Path("hello")
@RequestScoped
@RolesAllowed("Admin")
public class HelloService {

    @EJB
    private BusinessBeanLocal businessBean;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloService
     */
    public HelloService() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.fluidgridmobile.service.HelloService
     *
     * @param context
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @RolesAllowed("Admin")
    public String getJson(@Context SecurityContext context) {
        System.out.println(context.getUserPrincipal());
        return businessBean.sayHello();
    }

    /**
     * PUT method for updating or creating an instance of HelloService
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
