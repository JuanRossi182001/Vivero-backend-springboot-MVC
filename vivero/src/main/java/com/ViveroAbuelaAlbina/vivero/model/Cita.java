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
public class Cita {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long cita_id;
    private String dia;
    private int fecha;
    private String mes;
    private String horario;
    

    public Cita() {
    }

    public Cita(Long cita_id, String dia, int fecha, String mes, String horario) {
        this.cita_id = cita_id;
        this.dia = dia;
        this.fecha = fecha;
        this.mes = mes;
        this.horario = horario;
    }

  

  
    
}
