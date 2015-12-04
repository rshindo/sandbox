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
public class HogeServiceImpl implements HogeService {

    @Override
    public String getMessage() {
        return "hogehoge!";
    }
    
    
    
}
