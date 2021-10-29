
package edu.egg.demo.Servicios;

import edu.egg.demo.Repositorios.LibroRepositorio;
import edu.egg.demo.entidades.Autor;
import edu.egg.demo.entidades.Editorial;
import edu.egg.demo.entidades.Libro;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService {
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares) {
        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
 //       libro.setAutor();
 //       libro.setEditorial(editorial);
        libro.setAlta(true);

        libroRepositorio.save(libro);
    }
  
  @Transactional
    public void modificarLibro(String id,Long isbn, String titulo, Integer anio, Integer ejemplares) {
        libroRepositorio.modificar(id,isbn,titulo,anio,ejemplares);
    }
    
  @Transactional(readOnly = true)
    public List<Libro> buscarTodos() {
        return libroRepositorio.findAll();
    }
    
    
  @Transactional(readOnly = true)
    public Libro buscarLibroPorId(String id) {
        Optional<Libro> libroOptional = libroRepositorio.findById(id);
        return libroOptional.orElse(null);
    }  
    
    
  @Transactional
    public void eliminarLibro(String id) {
        libroRepositorio.deleteById(id);
    }
    
}
