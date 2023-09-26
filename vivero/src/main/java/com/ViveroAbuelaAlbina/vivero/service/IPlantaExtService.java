/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.model.PlantaExt;
import java.util.List;



public interface IPlantaExtService {
    
    public List<PlantaExt> mostrarStockExt();
    
    public void guardarExt(PlantaExt planta);
    
    public void eliminarExt(Long id);
    
    public PlantaExt ecnontrarPlantaExt(Long id);
    
    public void modificarPrecioExt(Long idOriginal, Double NuevoPrecio);
    
    public void modificarCantidadExt(Long idOriginal, int NuevaCantidad);
    
    public void modificarExt(PlantaExt planta);
    
    
}
