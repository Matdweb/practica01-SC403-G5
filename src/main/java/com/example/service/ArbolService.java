/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.example.service;
import com.example.domain.Arbol;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public interface ArbolService {
    public List<Arbol> getArbolData(boolean activos);
    
    // Se obtiene un arbol, a partir del id de un categoria
    public Arbol getArbol(Arbol arbol);
    
    // Se inserta un nuevo arbol si el id del categoria esta vacío
    // Se actualiza un arbol si el id del categoria NO esta vacío
    public void save(Arbol arbol);
    
    // Se elimina el arbol que tiene el id pasado por parámetro
    public void delete(Arbol arbol);
    
      // Se obtiene un arbol, a partir del id de un categoria
    public Arbol getArbolImage(Arbol arbol);
    
     // Se inserta un nuevo arbol si el id del categoria esta vacío
    // Se actualiza un arbol si el id del categoria NO esta vacío
    public void saveImage(Arbol arbol);
    
    // Se elimina el arbol que tiene el id pasado por parámetro
    public void deleteImage(Arbol arbol);
}
