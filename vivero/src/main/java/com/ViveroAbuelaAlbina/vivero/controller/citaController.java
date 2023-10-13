/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.controller;

import com.ViveroAbuelaAlbina.vivero.dto.ReservaDTO;
import com.ViveroAbuelaAlbina.vivero.model.Cita;
import com.ViveroAbuelaAlbina.vivero.model.Cliente;
import com.ViveroAbuelaAlbina.vivero.service.ICitaService;
import com.ViveroAbuelaAlbina.vivero.service.IClienteService;
import com.ViveroAbuelaAlbina.vivero.service.IReservaService;
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
public class citaController {
    
    @Autowired
    private ICitaService citaserv;
    
    @Autowired
    private IReservaService reseserv;
    
    @Autowired 
    private IClienteService cliserv;
    
    @GetMapping ("/citas/traer")
    public List<Cita> mostrarCitas(){
        return citaserv.mostrarCitas();
    }
    
    @PostMapping ("/citas/guardar")
    public String guardarCita(@RequestBody Cita cita){
        citaserv.guardarCita(cita);
        return "La cita se guardo con exito";
    }
    
    @DeleteMapping ("/citas/borrar/{id}")
    public String borrarCita(@PathVariable Long id){
        citaserv.eliminarCita(id);
        return "La cita se elimino con exito";
    }
    
    @GetMapping ("/citas/encontrar/{id}")
    public Cita encontrarCita(@PathVariable Long id){
        Cita ci = citaserv.encontrarCita(id);
        return ci;
    }
    
    @PutMapping ("/citas/editar")
    public String modificarCita(@RequestBody Cita cita){
        citaserv.modificarCita(cita);
        return "La cita se modifico con exito";
    }
    
    @PutMapping ("/citas/editarHorario/{id_modificar}")
    public Cita modificarHorario(@PathVariable Long id_modificar,
                                    @RequestParam (required = false , name ="horario")String NuevoHorario){
        citaserv.modificarHorario(id_modificar, NuevoHorario);
        
        Cita ci = citaserv.encontrarCita(id_modificar);
        
        ci.setHorario(NuevoHorario);
        return ci;
        
    }
    
    @PutMapping ("/citas/editarDia/{id_modificar}")
    public Cita modificarDia(@PathVariable Long id_modificar,
                                    @RequestParam (required = false , name ="dia")String NuevoDia){
        citaserv.modificarDia(id_modificar, NuevoDia);
        
         Cita ci = citaserv.encontrarCita(id_modificar);
         
         ci.setDia(NuevoDia);
         
         return ci;
        
    }
    
    @PutMapping ("/citas/editarFecha/{id_modificar}")
    public Cita modificarFecha(@PathVariable Long id_modificar,
                                    @RequestParam (required = false , name ="fecha")int NuevaFecha){
        citaserv.modificarFecha(id_modificar, NuevaFecha);
        
         Cita ci = citaserv.encontrarCita(id_modificar);
         
        ci.setFecha(NuevaFecha);
         
         return ci;
        
    }
    
    
    @PutMapping ("/citas/editarMes/{id_modificar}")
    public Cita modificarMes(@PathVariable Long id_modificar,
                                    @RequestParam (required = false , name ="mes")String NuevoMes){
        citaserv.modificarMes(id_modificar, NuevoMes);
        
         Cita ci = citaserv.encontrarCita(id_modificar);
         
         ci.setMes(NuevoMes);
         
         return ci;
        
    }
    
    
    @PostMapping ("/citas/reserva/{clienteID}/{citaID}")
    public ReservaDTO reservarCitaCliente(@PathVariable Long clienteID,
                                          @PathVariable Long citaID){
        
        Cliente cli = cliserv.encontrarCliente(clienteID);
        Cita ci = citaserv.encontrarCita(citaID);
        
        if (cli != null && ci != null) {
            cli.setUnaCita(ci);
        }
        
        ReservaDTO reserva = new ReservaDTO();
        reserva.setCitaID(ci.getCita_id());
        reserva.setClienteID(cli.getCliente_id());
        reserva.setClienteNombre(cli.getUsername());
        reserva.setDia(ci.getDia());
        reserva.setFecha(ci.getFecha());
        reserva.setHorario(ci.getHorario());
        reserva.setMes(ci.getMes());
        
        reseserv.guardarReserva(reserva);
        
        return reserva;
    }
    
     @GetMapping("/citas/reserva/traer")
     public List<ReservaDTO> mostrarCitasPendientes(){
         return reseserv.mostrarReservas();
     }
    
    
}
