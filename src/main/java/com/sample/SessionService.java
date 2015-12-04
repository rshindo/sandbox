/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ryo_shindo
 */
@SessionScoped
public interface SessionService extends Serializable {
    
    public int getCount();
    
}
