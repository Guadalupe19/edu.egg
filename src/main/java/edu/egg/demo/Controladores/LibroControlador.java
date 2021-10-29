
package edu.egg.demo.Controladores;

import edu.egg.demo.Servicios.LibroService;
import edu.egg.demo.entidades.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping ("/libros")
public class LibroControlador {
    @Autowired
    private LibroService libroService;
    
    
 @GetMapping
   public ModelAndView mostrarTodos(){
        ModelAndView nav= new ModelAndView("libros");
        nav.addObject ("libros", libroService.buscarTodos());
        return nav;
    }
   
   
   @GetMapping ("/crear")
    public ModelAndView crearLibro(){
        ModelAndView nav= new ModelAndView ("libro-formulario");
        nav.addObject("libro", new Libro());
        nav.addObject("title", "Crear Libro");
        nav.addObject("action", "guardar");
        return nav;
    }
    
    
   @GetMapping ("/editar/{id}")
    public ModelAndView editarLibro(@PathVariable String id){
      ModelAndView nav= new ModelAndView ("libro-formulario");  
      nav.addObject("libro", libroService.buscarLibroPorId(id));
      nav.addObject("title", "Editar Libro");
      nav.addObject("action", "modificar");
      return nav;
    }
    
    
    
  @PostMapping ("/guardar")
    public RedirectView guardar(@RequestParam Long isbn,@RequestParam String titulo,@RequestParam Integer anio,@RequestParam Integer ejemplares){
        libroService.crearLibro(isbn,titulo,anio,ejemplares);
        return new RedirectView("/libros");
    }
    
  
  @PostMapping ("/modificar")
    public RedirectView modificar(@RequestParam String id,@RequestParam Long isbn,@RequestParam String titulo,@RequestParam Integer anio,@RequestParam Integer ejemplares ){
        libroService.modificarLibro(id,isbn,titulo,anio,ejemplares);
        return new RedirectView("/libros");
    }
    
    
  @PostMapping ("/eliminar/{id}")
    public RedirectView eliminar(@RequestParam String id){
        libroService.eliminarLibro(id);
        return new RedirectView("/libros");
    }
    
    
    
    
}
