
package edu.egg.demo.Servicios;

import edu.egg.demo.Repositorios.EditorialRepositorio;
import edu.egg.demo.entidades.Editorial;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    
   @Transactional
    public void crearEditorial (String nombre){
        Editorial editorial=new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(true);
        editorialRepositorio.save(editorial);
    }
    
   @Transactional(readOnly = true)
    public Editorial buscarEditorialPorId (String id){
        Optional<Editorial>editorialOptional= editorialRepositorio.findById(id);
        return editorialOptional.orElse(null);
    }
    
   @Transactional(readOnly = true)
    public List<Editorial> buscarEditoriales(){
        return editorialRepositorio.findAll();
    }
    
   @Transactional
    public void modificarEditorial (String id,String nombre){
        editorialRepositorio.modificarEditorial(id,nombre);
    }
    
   @Transactional
    public void eliminarEditorial (String id){
        editorialRepositorio.eliminarEditorial(id);
    }
}
