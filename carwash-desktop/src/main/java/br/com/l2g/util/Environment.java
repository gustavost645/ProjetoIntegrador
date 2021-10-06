/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.util;

/**
 *
 * @author Gustavo Steinhoefel
 */
public enum Environment {

    DEV("http://127.0.0.1:8889/api/v1/"),
    PROD("http://127.0.0.1:8888/api/v1/");
    
    private final String url;

    private Environment(String url) {
        this.url = url;
    }
        
    public String url(){
        return url;
    }
}
