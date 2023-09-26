
package com.ViveroAbuelaAlbina.vivero.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ReservaDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private Long citaID;
    private String dia;
    private int fecha;
    private String mes;
    private String horario;
    private String ClienteNombre;
    private Long ClienteID;

    public ReservaDTO() {
    }

    public ReservaDTO(Long id, Long citaID, String dia, int fecha, String mes, String horario, String ClienteNombre, Long ClienteID) {
        this.id = id;
        this.citaID = citaID;
        this.dia = dia;
        this.fecha = fecha;
        this.mes = mes;
        this.horario = horario;
        this.ClienteNombre = ClienteNombre;
        this.ClienteID = ClienteID;
    }
    
    
    
}
