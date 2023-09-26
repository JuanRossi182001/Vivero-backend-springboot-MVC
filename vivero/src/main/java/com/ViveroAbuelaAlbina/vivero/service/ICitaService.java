/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.model.Cita;
import java.util.List;

public interface ICitaService {
    
    public void guardarCita(Cita cita);
    
    public List<Cita> mostrarCitas();
    
    public void eliminarCita(Long id);
    
    public Cita encontrarCita(Long id);
    
    public void modificarCita(Cita cita);
    
    public void modificarHorario(Long idOriginal, String NuevoHorario);
    
    public void modificarDia(Long idOriginal, String NuevoDia);
    
    public void modificarFecha(Long idOriginal, int NuevaFecha);
    
    public void modificarMes(Long idOrignial, String NuevoMes);
        
    
    
}
