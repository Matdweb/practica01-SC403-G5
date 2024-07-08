/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table (name="arbol")
public class Arbol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_arbol")

    private Long idArbol;
    private String nombreComun;
    private String nombreCientifico;
    private String rutaImagen;
    private String tipoFlor;
    private int durezaMadera;
    private float alturaPromedio;
    
    public Arbol(){
        
    }
    
}
