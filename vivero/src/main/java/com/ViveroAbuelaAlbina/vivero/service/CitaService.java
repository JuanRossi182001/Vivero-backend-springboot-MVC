/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.DAO.ICitaDAO;
import com.ViveroAbuelaAlbina.vivero.model.Cita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CitaService implements ICitaService {
    
    @Autowired
    private ICitaDAO citaDao;

    @Override
    public void guardarCita(Cita cita) {
       citaDao.save(cita);
    }

    @Override
    public List<Cita> mostrarCitas() {
       List<Cita> listaCitas = citaDao.findAll();
       return listaCitas;
       
    }

    @Override
    public void eliminarCita(Long id) {
        citaDao.deleteById(id);
    }


    @Override
    public void modificarCita(Cita cita) {
        this.guardarCita(cita);
      
    }

    @Override
    public void modificarHorario(Long idOriginal, String NuevoHorario) {
       Cita ci = this.encontrarCita(idOriginal);
       ci.setHorario(NuevoHorario);
       this.guardarCita(ci);
       
    }

    @Override
    public void modificarDia(Long idOriginal, String NuevoDia) {
        Cita ci = this.encontrarCita(idOriginal);
        ci.setDia(NuevoDia);
        this.guardarCita(ci);
       
    }

    @Override
    public void modificarFecha(Long idOriginal, int NuevaFecha) {
        Cita ci = this.encontrarCita(idOriginal);
        ci.setFecha(NuevaFecha);
        this.guardarCita(ci);
       
    }

    @Override
    public void modificarMes(Long idOriginal, String NuevoMes) {
         Cita ci = this.encontrarCita(idOriginal);
        ci.setMes(NuevoMes);
        this.guardarCita(ci);
       
    }

    @Override
    public Cita encontrarCita(Long id) {
      Cita ci = citaDao.findById(id).orElse(null);
      return ci;
    }
    
}
