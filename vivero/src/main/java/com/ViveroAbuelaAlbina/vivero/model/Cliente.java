/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {
     @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long cliente_id;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private int edad;
    @OneToOne
    @JoinColumn(name="unaCita",referencedColumnName="cita_id")
    private Cita unaCita;

    public Cliente() {
    }

    public Cliente(Long cliente_id, String nombre, String apellido, String username, String password, int edad, Cita unaCita) {
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.edad = edad;
        this.unaCita = unaCita;
    }

    
   

   
   
    
    
    
    
}
