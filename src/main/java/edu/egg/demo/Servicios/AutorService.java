
package edu.egg.demo.Servicios;

import edu.egg.demo.Repositorios.AutorRepositorio;
import edu.egg.demo.entidades.Autor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService {
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Transactional
    public void crearAutor (String nombre){
        Autor autor=new Autor();
        autor.setNombre(nombre);
        autor.setAlta(true);
        autorRepositorio.save(autor);
    }
    
    @Transactional(readOnly = true)
    public Autor buscarAutorPorId (String id){
        Optional<Autor>autorOptional= autorRepositorio.findById(id);
        return autorOptional.orElse(null);
    }
    
    @Transactional(readOnly = true)
    public List<Autor> buscarAutores(){
        return autorRepositorio.findAll();
    }
    
    @Transactional
    public void modificarAutor (String id,String nombre){
        
        autorRepositorio.modificarAutor(id,nombre);
        
    }
    
    @Transactional
    public void eliminarAutor (String id){
        autorRepositorio.eliminarAutor(id);
    }
    
}
