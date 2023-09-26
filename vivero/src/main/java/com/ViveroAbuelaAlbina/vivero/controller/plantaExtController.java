/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.controller;

import com.ViveroAbuelaAlbina.vivero.model.PlantaExt;
import com.ViveroAbuelaAlbina.vivero.service.IPlantaExtService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class plantaExtController {
    
    @Autowired
    private IPlantaExtService plantaserv;
    
    @GetMapping ("/plantasExt/traer")
    public List<PlantaExt> mostrarStockExt(){
        return plantaserv.mostrarStockExt();
    }
    
    @PostMapping ("/plantasExt/guardar")
    public String guardarPlantaExt (@RequestBody PlantaExt planta){
        plantaserv.guardarExt(planta);
        return "La planta se guardo con exito";
    }
    
    @DeleteMapping ("/plantasExt/borrar/{id}")
    public String eliminarPlantaExt(@PathVariable Long id){
        plantaserv.eliminarExt(id);
        return "La planta se elimino con exito";
    }
    
    @GetMapping ("/plantasExt/encontrar/{id}")
    public PlantaExt encontrarPlantExt (@PathVariable Long id){
        PlantaExt pla =plantaserv.ecnontrarPlantaExt(id);
        return pla;
    }
    
    @PutMapping ("/plantasExt/editar")
    public void modificarPlantaExt(@RequestBody PlantaExt planta){
        plantaserv.modificarExt(planta);
    }
    
    @PutMapping ("/plantasExt/editarPrecio/{id_modificar}")
    public PlantaExt modificarPrecioExt(@PathVariable Long id_modificar,
                                        @RequestParam(required = false, name = "precio")Double NuevoPrecio){
         // envio id original (para buscar)
        //envio nuevos datos para modificar
        plantaserv.modificarPrecioExt(id_modificar, NuevoPrecio);
        
         // busco la planta editada para mostrarla en la response
         PlantaExt pla = plantaserv.ecnontrarPlantaExt(id_modificar);
         
         // Si NuevoPrecio es nulo, establece un valor predeterminado antes de devolverlo
        if (NuevoPrecio == null) {
            pla.setPrecio(0.0); // Establece un valor predeterminado o realiza el manejo adecuado
        }
        
         //retorna la planta modificada
        return pla;
        
    }
    
    @PutMapping ("/plantasExt/editarCantidad/{id_modificar}")
    public PlantaExt modificarCantidadExt(@PathVariable Long id_modificar,
                                          @RequestParam (required = false , name = "cantidad") int NuevaCantidad){
        // envio id original (para buscar)
        //envio nuevos datos para modificar
        plantaserv.modificarCantidadExt(id_modificar, NuevaCantidad);
        
        // busco la planta editada para mostrarla en la response
        PlantaExt pla = plantaserv.ecnontrarPlantaExt(id_modificar);
        
        //retorna la planta modificada
        return pla;
    }
    
    
            
    
}// class end
