/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpc.services;

import javax.jws.WebService;

/**
 *
 * @author do_th
 */
//@Service
@WebService(serviceName = "calculateService", endpointInterface = "com.bpc.services.CalculateWebServices")
public class CalculateWebServicesImpl implements CalculateWebServices{

    public Double addCalc(double a, double b) {
        return a + b;
    }
}
