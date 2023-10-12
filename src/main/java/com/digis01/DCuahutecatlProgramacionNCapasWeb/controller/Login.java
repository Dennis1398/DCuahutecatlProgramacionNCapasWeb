/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DCuahutecatlProgramacionNCapasWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Login{
    
    @GetMapping("/")
	public String Login(@RequestParam(name="login", required=false, defaultValue="Digis01") String name, Model model) {
		model.addAttribute("name", name);
		return "login";
    

//	@GetMapping("/")
//	public String HolaMundo(@RequestParam(name="name", required=false, defaultValue="Digis01") String name, Model model) {
//		model.addAttribute("name", name);
//		return "HolaMundo";
                
        
//        @GetMapping("/login")
//        public String Login(@RequestParam(suma="login", required=false, defaultValue="Digis01") String name, Model model) {
//		model.addAttribute("login", login);
//		return "login";
//        
//        }
//        
        
	}
        
}