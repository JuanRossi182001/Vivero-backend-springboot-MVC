
package com.ViveroAbuelaAlbina.vivero.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Administrador {
    
     @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long cliente_id;
    private String username;
    private String password;

    public Administrador() {
    }

    public Administrador(Long cliente_id, String username, String password) {
        this.cliente_id = cliente_id;
        this.username = username;
        this.password = password;
    }
     
     
}
