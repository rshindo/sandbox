/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import javax.enterprise.context.Dependent;

/**
 *
 * @author ryo_shindo
 */
@Dependent
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean authenticate(String userId, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selectLoginInfo(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
