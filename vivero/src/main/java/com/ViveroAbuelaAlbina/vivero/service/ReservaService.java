/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.DAO.IReservaDAO;
import com.ViveroAbuelaAlbina.vivero.dto.ReservaDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService implements IReservaService {
    
    @Autowired
    private IReservaDAO reDao;

    @Override
    public List<ReservaDTO> mostrarReservas() {
        List<ReservaDTO> listaReservas =  reDao.findAll();
        return listaReservas;
    }

    @Override
    public void guardarReserva(ReservaDTO reserva) {
        reDao.save(reserva);
    }

    @Override
    public void EliminarReserva(Long reservaID) {
        reDao.deleteById(reservaID);
    }
    
}
