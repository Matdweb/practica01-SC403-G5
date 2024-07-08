/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.controller;

import com.example.domain.Arbol;
import lombok.extern.slf4j.Slf4j;
import com.example.service.ArbolService;
import com.example.service.impl.FirebaseStorageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    
   @PostMapping("/actualizar")
    public String arbolActualizar(Arbol arbol) {
        Arbol arbolExistente = arbolService.getArbol(arbol);
        if (arbolExistente != null) {
            
            arbolExistente.setNombreComun(arbol.getNombreComun());
            arbolExistente.setNombreCientifico(arbol.getNombreCientifico());
            arbolExistente.setRutaImagen(arbol.getRutaImagen());
            arbolExistente.setTipoFlor(arbol.getTipoFlor());
            arbolExistente.setDurezaMadera(arbol.getDurezaMadera());
            arbolExistente.setAlturaPromedio(arbol.getAlturaPromedio());
            
            arbolService.save(arbolExistente);
        }
        return "redirect:/arbol/listado";
    }
    
    @Autowired
private FirebaseStorageImpl firebaseStorageService;
    
    @PostMapping (" /guardarImagen")
    public String arbolGuardarImagen (Arbol arbol,
    @RequestParam("imagenFile") MultipartFile imagenFile){
    if (!imagenFile.isEmpty()) {
    arbolService.save (arbol);
    arbol.setRutaImagen (
    firebaseStorageService. cargaImagen (
    imagenFile,
    "arbol", arbol.getIdArbol()));
    }
            arbolService.save(arbol);
            return "redirect:/arbol/listado";
    
    }

        @GetMapping("/eliminar/imagen/{idArbol}")
    public String arbolEliminarImagen(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    
}