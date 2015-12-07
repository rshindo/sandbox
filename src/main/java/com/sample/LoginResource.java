/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import java.net.HttpCookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 *
 * @author ryo_shindo
 */
@Path("login")
public class LoginResource {
    
    
    @POST
    public Response authenticate(@FormParam("userId") String userId,
            @FormParam("password") String password,
            @Context HttpServletRequest request) {
        
        //一度セッションを破棄する
        request.getSession().invalidate();
        
        String jsessionId = request.getSession().getId();
        return Response.ok("ok",MediaType.TEXT_PLAIN)
                .cookie(new NewCookie("JSESSIONID", jsessionId))
                .build();
        
    }
    
}
