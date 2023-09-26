/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.dto.ReservaDTO;
import java.util.List;


public interface IReservaService {
    
    
    public List<ReservaDTO> mostrarReservas();
    
    public void guardarReserva(ReservaDTO reserva);
    
    public void EliminarReserva(Long reservaID);
}
