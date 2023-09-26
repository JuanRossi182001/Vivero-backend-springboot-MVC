/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.DAO.IPlantaIntDAO;
import com.ViveroAbuelaAlbina.vivero.model.PlantaInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantaIntService implements IPlantaIntService {
    @Autowired
    private IPlantaIntDAO plantaIntDAO;
    
    
    @Override
    public List<PlantaInt> mostrarStockInt() {
      List<PlantaInt> plantasint =plantaIntDAO.findAll();
      return plantasint;
    }

    @Override
    public void guardarInt(PlantaInt planta) {
       plantaIntDAO.save(planta);
    }

    @Override
    public void eliminarInt(Long id) {
        plantaIntDAO.deleteById(id);
    }

    @Override
    public PlantaInt encontrarPlantaint(Long id) {
      PlantaInt pla = plantaIntDAO.findById(id).orElse(null);
       return pla;
    }

    @Override
    public void modificarInt(PlantaInt planta) {
      this.guardarInt(planta);
    }

    @Override
    public void modificarPrecioInt(Long idOriginal, double NuevoPrecio) {
       PlantaInt pla= this.encontrarPlantaint(idOriginal);
       pla.setPrecio(NuevoPrecio);
       this.guardarInt(pla);
    }

    @Override
    public void modificarCantidadint(Long idOriginal, int NuevaCantidad) {
       PlantaInt pla= this.encontrarPlantaint(idOriginal);
       pla.setCantidad(NuevaCantidad);
       this.guardarInt(pla);
    }

  
    
}
