/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ryo_shindo
 */
@SessionScoped
public class SessionServiceImpl implements SessionService {
    
    private int count = 0;

    @Override
    public int getCount() {
        return count++;
    }
    
}
