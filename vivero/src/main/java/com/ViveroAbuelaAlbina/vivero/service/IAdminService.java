/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.model.Administrador;


public interface IAdminService {
    
    
    public Administrador autenticarAdmin(String username, String password);
}
