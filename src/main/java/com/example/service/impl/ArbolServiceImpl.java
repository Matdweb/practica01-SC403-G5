/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.service.impl;

import com.example.dao.ArbolDao;
import com.example.domain.Arbol;
import com.example.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 *
 * @author Lenovo
 */
@Service
public class ArbolServiceImpl implements ArbolService {
    @Autowired
    private ArbolDao arbolDao;

    @Override
    @Transactional(readOnly=true)
    public List<Arbol> getArbolData(boolean activos) {
        var lista=arbolDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }


    @Override
    @Transactional(readOnly=true)
    public Arbol getArbol(Arbol arbol) {
    return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Arbol arbol) {
        arbolDao.save(arbol); 
    }
    
    
    @Override
    @Transactional
    public void delete(Arbol arbol){
        arbolDao.delete(arbol);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Arbol getArbolImage(Arbol arbol) {
    return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }
    
    @Override
    @Transactional
    public void saveImage(Arbol arbol) {
        arbolDao.save(arbol);  // guardar modificar id()arbol
    }
    
    @Override
    @Transactional
    public void deleteImage(Arbol arbol){
        arbolDao.delete(arbol);
    }
    
}
