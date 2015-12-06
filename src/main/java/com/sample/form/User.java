/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.form;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ryo_shindo
 */
@XmlRootElement
public class User {
    
    @FormParam("userId")
    @NotEmpty
    private String userId;
    
    @FormParam("name")
    @NotEmpty
    private String name;
    
    @FormParam("age")
    private Integer age;

    public User() {
    }

    public User(String userId, String name, Integer age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof User) {
            User target = (User)obj;
            if(this.name.equals(target.getName()) &&
                    this.userId.equals(target.getUserId()) &&
                    this.age.equals(target.getAge())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", name=" + name + ", age=" + age + '}';
    }

    
    
    
}
