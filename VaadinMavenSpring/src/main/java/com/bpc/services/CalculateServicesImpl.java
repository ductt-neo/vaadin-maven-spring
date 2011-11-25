/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpc.services;

import org.springframework.security.access.annotation.Secured;

/**
 *
 * @author do_th
 */
//@Service
public class CalculateServicesImpl implements CalculateServices {

    @Secured("ROLE_ADMIN")
    public Double addCalc(double a, double b) {
        return a + b;
    }
}
