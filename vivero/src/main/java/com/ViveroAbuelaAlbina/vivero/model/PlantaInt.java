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
public class PlantaInt {
     @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long plantaint_id;
    private String nombre;
    private String nombreC;
    private Double precio;
    private String altura;
    private int cantidad;

    public PlantaInt() {
    }

    public PlantaInt(Long plantaint_id, String nombre, String nombreC, Double precio, String altura, int cantidad) {
        this.plantaint_id = plantaint_id;
        this.nombre = nombre;
        this.nombreC = nombreC;
        this.precio = precio;
        this.altura = altura;
        this.cantidad = cantidad;
    }

    
   

   

    
    
    
}
