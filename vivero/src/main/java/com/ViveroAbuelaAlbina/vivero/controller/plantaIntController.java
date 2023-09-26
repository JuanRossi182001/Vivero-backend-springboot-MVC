/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.controller;

import com.ViveroAbuelaAlbina.vivero.model.PlantaInt;
import com.ViveroAbuelaAlbina.vivero.service.IPlantaIntService;
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
public class plantaIntController {
    
    @Autowired  
    private IPlantaIntService plantaserv;
    
    
    @GetMapping ("/plantasInt/traer")
    public List<PlantaInt> mostrarStockInt(){
      return plantaserv.mostrarStockInt();
    }
    
    @PostMapping ("/plantasInt/guardar")
    public String guardarPlantaInt(@RequestBody PlantaInt pla){
    plantaserv.guardarInt(pla);
    return "La planta se guardo con exito";
    }
    
    @DeleteMapping ("/plantasInt/borrar/{id}") 
    public String eliminarPlantaInt(@PathVariable Long id){
        plantaserv.eliminarInt(id);
        return "La planta se elimino con exito";
    }
    
    @GetMapping ("/plantasInt/encontrar/{id}")
     public PlantaInt ecnontrarPlantaInt(@PathVariable Long id){
       return plantaserv.encontrarPlantaint(id);
    }
    
    @PutMapping ("/plantasInt/editar")
    public void modificarPlantaInt(@RequestBody PlantaInt pla){ 
       plantaserv.modificarInt(pla);
    }
   
    @PutMapping("/plantasInt/editarPrecio/{id_modificar}")
    public PlantaInt modificarPrecioInt(@PathVariable Long id_modificar,
            @RequestParam(required = false, name = "precio") Double NuevoPrecio) {
        // envio id original (para buscar)
        //envio nuevos datos para modificar
        plantaserv.modificarPrecioInt(id_modificar, NuevoPrecio);

        // busco la planta editada para mostrarla en la response
        PlantaInt pla = plantaserv.encontrarPlantaint(id_modificar);

        // Si NuevoPrecio es nulo, establece un valor predeterminado antes de devolverlo
        if (NuevoPrecio == null) {
            pla.setPrecio(0.0); // Establece un valor predeterminado o realiza el manejo adecuado
        }

        //retorna la nueva persona
        return pla;

    }
    
    @PutMapping ("/plantasInt/editarCantidad/{id_modificar}")
    public PlantaInt modificarCantidadInt(@PathVariable Long id_modificar,
                                           @RequestParam (required=false, name="cantidad") int NuevaCantidad){
        
         // envio id original (para buscar)
        //envio nuevos datos para modificar
        plantaserv.modificarCantidadint(id_modificar, NuevaCantidad);
        
         // busco la planta editada para mostrarla en la response
        PlantaInt pla=plantaserv.encontrarPlantaint(id_modificar);
        
        return pla;
        
    }
    
    
    
}//class end 
