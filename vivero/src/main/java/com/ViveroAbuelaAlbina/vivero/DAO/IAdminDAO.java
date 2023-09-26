/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.DAO;

import com.ViveroAbuelaAlbina.vivero.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminDAO extends JpaRepository<Administrador,Long> {
    
    Administrador findByUsernameAndPassword(String correo, String contraseña);
    
}
