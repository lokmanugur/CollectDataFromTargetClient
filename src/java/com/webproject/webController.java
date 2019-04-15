/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class webController {
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String controller(ModelMap model){
        model.addAttribute("message","Domian Info");
    return "index";
    }
    
    @RequestMapping(params={"submit"},method=RequestMethod.POST)
    public String getDomain(ModelMap model,@RequestParam(value="domain_name",required = true) String domain_name)throws IOException{
                WhoIs whois=new WhoIs();
                model.addAttribute("message",whois.getWhois(domain_name));
    return "index";
    }
}
