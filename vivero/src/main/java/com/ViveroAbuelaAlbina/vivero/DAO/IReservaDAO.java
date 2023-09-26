/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.DAO;

import com.ViveroAbuelaAlbina.vivero.dto.ReservaDTO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IReservaDAO extends JpaRepository<ReservaDTO, Long> {
    
}
