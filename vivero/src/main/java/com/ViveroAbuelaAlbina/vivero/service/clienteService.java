/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ViveroAbuelaAlbina.vivero.service;



import com.ViveroAbuelaAlbina.vivero.DAO.IClienteDAO;
import com.ViveroAbuelaAlbina.vivero.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // le indico al framework que esta clase es de tipo servicio
// implemento la interfaz para traer todos los metodos creador para darles la logica
public class clienteService implements IClienteService {
     //inyecto la dependencia 
    /*
    es importante que generemos la inyección de dependencias entre clienteService y clienteDao, 
    dado que PersonaDao será la clase encargada de proporcionarnos los datos.
    */
     @Autowired
    private IClienteDAO clienteDao;

    @Override
    public List<Cliente> getClientes() {
        // lo que hago aca es crear una lista personas y mediante el DAO (o repository)
        // utilizo un metodo de JPA (findAll) que salen de el extends jparepository que utilice en la clase IClienteDao
       List<Cliente> listaClientes = clienteDao.findAll();
       return listaClientes;
        
    }

    @Override
    public void guardarCliente(Cliente cli) {
          /*
        aca utilizo otra funcion de jpa que es save, para que me guarde en la BD
        */
        clienteDao.save(cli);
    }
 

    @Override
    public void eleminarCliente(Long id) {
          /*
        aca utilizo otra funcion de jpa para borrar ese objeto de la BD
        */
        clienteDao.deleteById(id);
    }

    @Override
    public Cliente encontrarCliente(Long id) {
         /*
        utilizaremos nuestro objeto DAO (o repository) y el método JPA findById(),
        en donde recibiremos como parámetro la id de la persona a buscar/traer de la siguiente manera:
        */
       Cliente cli = clienteDao.findById(id).orElse(null);
       return cli;
    }
    
    
     @Override
    public void modificarCliente(Cliente cli) {
       this.guardarCliente(cli);
    }
    
    
    
    
    
    
    
    
     /*
    Con la implementación de cada uno de los métodos en nuestra clase PersonaService, 
    se tiene la lógica de negocio lista para llevar a cabo un CRUD completo.

    Ahora, es necesario configurar el Controller para poder recibir las solicitudes y 
    llevar a cabo cada una de estas operaciones CRUD.
    */


    @Override
    public Cliente autenticarCliente(String username, String password) {
       return clienteDao.findByUsernameAndPassword(username, password);
       
       
    }

   
    
}
