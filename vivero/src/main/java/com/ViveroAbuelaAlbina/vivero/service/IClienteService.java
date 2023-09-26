/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;


import com.ViveroAbuelaAlbina.vivero.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public List<Cliente> getClientes();
    
    public void guardarCliente(Cliente cli);
   
    public void eleminarCliente(Long id);
    
    public Cliente encontrarCliente(Long id);
    
    public void modificarCliente(Cliente cli);
        
    public Cliente autenticarCliente(String username, String password);
    
    
     
}
