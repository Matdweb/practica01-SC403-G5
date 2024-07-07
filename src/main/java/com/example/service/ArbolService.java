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
}
