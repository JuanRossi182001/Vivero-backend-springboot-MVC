/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.controller;


import com.ViveroAbuelaAlbina.vivero.DAO.IAdminDAO;
import com.ViveroAbuelaAlbina.vivero.model.Administrador;
import com.ViveroAbuelaAlbina.vivero.model.Cliente;
import com.ViveroAbuelaAlbina.vivero.service.IAdminService;
import com.ViveroAbuelaAlbina.vivero.service.IClienteService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clienteController {
    
    @Autowired
    private IClienteService cliserv;
    
    @Autowired
    private IAdminService adminserv;
    
    // end point para traer lista clientes
    @GetMapping ("/cliente/traer")
    public List<Cliente> traerClientes(){
        return cliserv.getClientes();
    }
    
    
    // end point para guardar cliente
    @PostMapping ("cliente/guardar")
    public String guardarCliente(@RequestBody Cliente cli){
        cliserv.guardarCliente(cli);
        return "el cliente se guardo con exito";
    }
    
    
    // end point para eliminar cliente
    @DeleteMapping ("/cliente/borrar/{id}")
    public String borrarCliente(@PathVariable Long id){
        cliserv.eleminarCliente(id);
        return "El cliente fue eliminado con exito";
    }
    
    
    // end point para encontrar cliente
    @GetMapping ("/cliente/encontrar/{id}")
    public Cliente encontrarCliente(@PathVariable Long id){
       return cliserv.encontrarCliente(id);
        
    }
    
    
     // end point modificar cliente 
    //cabe reacalcar que para modificar el cliente tengo que ponerle la misma id que tenia 
    @PutMapping("/cliente/modificar")
    public Cliente modificarCliente(@RequestBody Cliente cli){
        cliserv.modificarCliente(cli);
        return cliserv.encontrarCliente(cli.getCliente_id());
    }
    
    
    @PostMapping ("/cliente/login")
    public String autenticar(@RequestParam (required=false, name="username") String username,
                             @RequestParam (required=false, name="password") String password, HttpSession session){
         Cliente cli = cliserv.autenticarCliente(username, password);
         Administrador admin = adminserv.autenticarAdmin(username, password);

    if (cli != null) {
        // Autenticación exitosa, guardar cliente en la sesión
        session.setAttribute("cliente", cli);
        return "redirect:/index.html";
    } else if (admin != null) {
        // El usuario es un admin, redirigir a admin.html
        session.setAttribute("admin", admin);
        return "redirect:/admin.html";
    } else {
         return "Usuario o contraseña incorrectos";
    }
        
        
    }
    
 
       
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
    // Invalidar la sesión actual
    HttpSession session = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }
    
    // Redirigir al usuario a la página de inicio de sesión
    return "redirect:/login.html";
}

    
    
}// class end
