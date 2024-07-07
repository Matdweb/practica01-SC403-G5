/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import com.example.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Lenovo
 */
@Controller
@Slf4j
@RequestMapping("/arbol")
public class ArbolController {
    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var arbol = arbolService.getArbolData(false );
        model.addAttribute("arboles", arbol); 
        model.addAttribute("totalArboles", arbol.size());
        
    return "/arbol/listado";
    
    }
}
