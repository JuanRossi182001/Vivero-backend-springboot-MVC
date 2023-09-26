/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.model.PlantaInt;
import java.util.List;

public interface IPlantaIntService {
    public List<PlantaInt> mostrarStockInt();
    
    public void guardarInt(PlantaInt planta);
    
    public void eliminarInt(Long id);
    
    public void modificarPrecioInt(Long idOriginal,double NuevoPrecio);
    
    public PlantaInt encontrarPlantaint(Long id);
    
    public void modificarCantidadint(Long idOriginal,int NuevaCantidad);
    
    public void modificarInt(PlantaInt planta);
}
