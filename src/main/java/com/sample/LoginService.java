/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;

/**
 *
 * @author ryo_shindo
 */
@Dependent
public interface LoginService {
    
    @Transactional
    public boolean authenticate(String userId, String password);
   
    public void selectLoginInfo(String userId);
    
}
