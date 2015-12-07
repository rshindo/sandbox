/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ryo_shindo
 */
public class LoginServiceMock implements LoginService {
    
    @SessionScoped
    UserSession userSession;

    @Override
    public boolean authenticate(String userId, String password) {
        return true;
    }

    @Override
    public void selectLoginInfo(String userId) {
        userSession.setName("shindo");
        userSession.setUserId(userId);
        Set<String> permissions = new HashSet<>();
        permissions.add("events-r");
        permissions.add("participants-r");
        userSession.setPermissions(permissions);
    }
    
    
    
}
