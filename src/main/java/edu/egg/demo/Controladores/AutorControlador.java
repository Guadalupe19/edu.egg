
package edu.egg.demo.Controladores;

import edu.egg.demo.Servicios.AutorService;
import edu.egg.demo.entidades.Autor;
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
@RequestMapping ("/autores")
public class AutorControlador {
    
    @Autowired
    private AutorService autorService;
    
    
    @GetMapping
    public ModelAndView mostrarTodos(){
        ModelAndView nav= new ModelAndView("autores");
        nav.addObject ("autores", autorService.buscarAutores());
        return nav;
    }
    
    @GetMapping ("/crear")
    public ModelAndView crearAutor(){
        ModelAndView nav= new ModelAndView ("autor-formulario");
        nav.addObject("autor", new Autor());
        nav.addObject("title", "Crear Autor");
        nav.addObject("action", "guardar");
        return nav;
    }
    
    @GetMapping ("/editar/{id}")
    public ModelAndView editarAutor(@PathVariable String id){
      ModelAndView nav= new ModelAndView ("autor-formulario");  
      nav.addObject("autor", autorService.buscarAutorPorId(id));
      nav.addObject("title", "Editar Autor");
      nav.addObject("action", "modificar");
      return nav;
    }
    
    
    
    @PostMapping ("/guardar")
    public RedirectView guardar(@RequestParam String nombre){
        autorService.crearAutor(nombre);
        return new RedirectView("/autores");
    }
    
    @PostMapping ("/modificar")
    public RedirectView modificar(@RequestParam String id,@RequestParam String nombre ){
        autorService.modificarAutor(id, nombre);
        return new RedirectView("/autores");
    }
    
    @PostMapping ("/eliminar/{i}]")
    public RedirectView eliminar(@RequestParam String id){
        autorService.eliminarAutor(id);
        return new RedirectView("/autores");
    }
}
