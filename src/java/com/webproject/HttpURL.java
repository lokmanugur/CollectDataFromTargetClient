/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class HttpURL {
    private final URL url;
    private final HttpURLConnection httpURLConnection;
    private Map<String,List<String>> hdrMap;
    private Set<String> hdrField;

    public Map<String, List<String>> getHdrMap() {
        return hdrMap=httpURLConnection.getHeaderFields();
    }

    public Set<String> getHdrField() {
        return hdrField=hdrMap.keySet();
    }
    public HttpURL(String URLAdress) throws IOException {
        this.url = new URL(URLAdress);
        this.httpURLConnection = (HttpURLConnection)url.openConnection();
    }
    public String getRequestMethod(){
        return httpURLConnection.getRequestMethod();
    }
    public int getResponseCode() throws IOException{
        return httpURLConnection.getResponseCode();
    }
    public String getResponseMessage() throws IOException{
        return httpURLConnection.getResponseMessage();
    }
    
}
