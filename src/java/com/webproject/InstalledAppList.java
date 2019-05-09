/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Admin
 */

public class InstalledAppList {

  private static final String REGQUERY_UTIL = "reg query ";
  private static final String REGSTR_TOKEN = "REG_SZ";
  static String s = REGQUERY_UTIL + "HKEY_LOCAL_MACHINE\\Software"
                    + "\\Microsoft\\Windows\\CurrentVersion\\Uninstall";


public static String getCurrentUserPersonalFolderPath() {
    try {
      Process process = Runtime.getRuntime().exec(s);
      StreamReader reader = new StreamReader(process.getInputStream());

      reader.start();
      process.waitFor();
      reader.join();

      String result = reader.getResult();
      int p = result.indexOf(REGSTR_TOKEN);

      if (p == -1)
         return null;

      return result.substring(p + REGSTR_TOKEN.length()).trim();
    }
    catch (IOException | InterruptedException e) {
      return null;
    }
  }

  static class StreamReader extends Thread {
    private final InputStream is;
    private final StringWriter sw;

    StreamReader(InputStream is) {
      this.is = is;
      sw = new StringWriter();
    }

    @Override
    public void run() {
      try {
        int c;
        while ((c = is.read()) != -1)
          sw.write(c);
        }
        catch (IOException e) { e.printStackTrace(); }
      }

    String getResult() {
      return sw.toString();
    }
  }

  public static void getDisplayNameDword(String str){

      Set<String> set = new HashSet<>();

      String [] array = new String[500];

      array = str.split("\n");

      for(String i : array){

          set.add( getName(i.trim()) ); 

      }
      
      Iterator i = set.iterator();

      while(i.hasNext()){

          System.out.println( i.next() );

      }
  }

  private static String getName(String s){
  Process process = null;
  try {
            // Run reg query, then read output with StreamReader (internal class)
             process = Runtime.getRuntime().exec("reg query " + 
                    '"'+ s + "\" /v " + "DisplayName");

            StreamReader reader = new StreamReader(process.getInputStream());
            reader.start();
            process.waitFor();
            reader.join();

            // Parse out the value
            String[] parsed = reader.getResult().split(REGSTR_TOKEN);
            if (parsed.length > 1) {
            return  (parsed[parsed.length-1]).trim();
            }

       } catch (IOException | InterruptedException e) {
           e.printStackTrace();
       }
  return null;
  }
}
