/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ryo_shindo
 */
@SessionScoped
public class UserSession implements Serializable {
    
    private String userId;
    
    private String name;
    
    private Set<String> permissions;

    public UserSession() {
    }

    public UserSession(String userId, String name, Set<String> permissions) {
        this.userId = userId;
        this.name = name;
        this.permissions = permissions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
    
   
    
}
