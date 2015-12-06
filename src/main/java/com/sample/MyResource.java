/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import com.sample.form.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ryo_shindo
 */
@Path("myresource")
@RequestScoped
public class MyResource {
   
    @Inject
    HogeService hogeService;
    
    @Inject
    SessionService sessionService;
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Path("hoge")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return hogeService.getMessage();
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        return "count: " + sessionService.getCount();
    }
    
    @POST
    @Path("post")
    @Produces(MediaType.TEXT_PLAIN)
    public String post(@FormParam("value") String value) {
        return value;
    }
    
    @POST
    @Path("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String diplayUserInfo(@Valid @BeanParam User user) {
        return user.getUserId()+":"+user.getName()+":"+user.getAge();
    }
    
    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public User getJson(@QueryParam("userId") String userId,
            @QueryParam("password") String password,
            @QueryParam("age") Integer age) {
        
        User user = new User(userId, userId, age);
        return user;
    }
    
}
