/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class Utilitarios {
    
    public static void salvaTxt(String arquivo, String txt) {
        try {            
            FileWriter arq = new FileWriter(arquivo, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(txt+"\r\n");            
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String dataHora(){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        return date;
    }    
}
