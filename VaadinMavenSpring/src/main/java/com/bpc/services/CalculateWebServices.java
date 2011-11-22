/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpc.services;


import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author do_th
 */
@WebService
public interface CalculateWebServices {
    
    public Double addCalc(@WebParam(name="a") double a, @WebParam(name="b") double b);
}
