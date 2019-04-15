/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject;

import java.io.*;
import java.net.*;
/**
 *
 * @author Admin
 */
public class WhoIs {
private final String[] string = new String[0];
private String result;
    
    public String[] getWhois(String domainname) throws IOException{
            int value;
            
            Socket s = new Socket("whois.internic.net",43);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            String str=(string.length==0?domainname:string[0])+"\n";
            byte buffer[] = str.getBytes();
            out.write(buffer);
            while((value=in.read())!= -1){
                result+=String.valueOf((char)value);           
            }     
        return result.split(String.valueOf((char)10));
}
}
