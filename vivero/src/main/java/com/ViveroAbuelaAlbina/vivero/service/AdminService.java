/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;


import com.ViveroAbuelaAlbina.vivero.DAO.IAdminDAO;
import com.ViveroAbuelaAlbina.vivero.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    
    @Autowired
    private IAdminDAO admindao;

    @Override
    public Administrador autenticarAdmin(String username, String password) {
       return admindao.findByUsernameAndPassword(username, password);
    }
    
}
