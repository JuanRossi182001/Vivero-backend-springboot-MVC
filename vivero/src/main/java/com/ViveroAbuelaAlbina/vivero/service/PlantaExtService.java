
package com.ViveroAbuelaAlbina.vivero.service;

import com.ViveroAbuelaAlbina.vivero.DAO.IPlantaExtDAO;
import com.ViveroAbuelaAlbina.vivero.model.PlantaExt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantaExtService implements IPlantaExtService{
     @Autowired
    private IPlantaExtDAO plantaExtDAO;

    @Override
    public List<PlantaExt> mostrarStockExt() {
       List<PlantaExt> plantasExt = plantaExtDAO.findAll();
       return plantasExt;
    }

    @Override
    public void guardarExt(PlantaExt planta) {
       plantaExtDAO.save(planta);
    }

    @Override
    public void eliminarExt(Long id) {
        plantaExtDAO.deleteById(id);
    }

    @Override
    public PlantaExt ecnontrarPlantaExt(Long id) {
       PlantaExt pla = plantaExtDAO.findById(id).orElse(null);
        return pla;
    }

    @Override
    public void modificarPrecioExt(Long idOriginal, Double NuevoPrecio) {
       PlantaExt pla =this.ecnontrarPlantaExt(idOriginal);
       pla.setPrecio(NuevoPrecio);
       this.guardarExt(pla);
    }

    @Override
    public void modificarCantidadExt(Long idOriginal, int NuevaCantidad) {
        PlantaExt pla=this.ecnontrarPlantaExt(idOriginal);
        pla.setCantidad(NuevaCantidad);
        this.guardarExt(pla);
    }

    @Override
    public void modificarExt(PlantaExt planta) {
       this.guardarExt(planta);
    }
    
}
