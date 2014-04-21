/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.fluidgridmobile.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author helge
 */
@Stateless
public class BusinessBean implements BusinessBeanLocal {

    @Override
    public String sayHello() {
        return "Hello you";
    }

    
}
