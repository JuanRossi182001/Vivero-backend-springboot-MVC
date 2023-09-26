/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class PlantaExt {
     @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long plantaext_id;
    private String nombre;
    private String nombreC;
    private double precio;
    private String tamanio;
    private int cantidad;

    public PlantaExt() {
    }

    public PlantaExt(Long plantaext_id, String nombre, String nombreC, double precio, String tamanio, int cantidad) {
        this.plantaext_id = plantaext_id;
        this.nombre = nombre;
        this.nombreC = nombreC;
        this.precio = precio;
        this.tamanio = tamanio;
        this.cantidad = cantidad;
    }

  
    
    
    
}
