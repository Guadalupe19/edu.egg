
package edu.egg.demo.Controladores;

import edu.egg.demo.Servicios.EditorialService;
import edu.egg.demo.entidades.Editorial;
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
@RequestMapping ("/editoriales")
public class EditorialControlador {
    
   @Autowired
    private EditorialService editorialService;
    
   @GetMapping
    public ModelAndView mostrarTodos(){
        ModelAndView nav= new ModelAndView("editoriales");
        nav.addObject ("editoriales", editorialService.buscarEditoriales());
        return nav;
    }
    
   @GetMapping ("/crear")
    public ModelAndView crearEditorial(){
        ModelAndView nav= new ModelAndView ("editorial-formulario");
        nav.addObject("editorial", new Editorial());
        nav.addObject("title", "Crear Editorial");
        nav.addObject("action", "guardar");
        return nav;
    }
    
   @GetMapping ("/editar/{id}")
    public ModelAndView editarEditorial(@PathVariable String id){
      ModelAndView nav= new ModelAndView ("editorial-formulario");  
      nav.addObject("editorial", editorialService.buscarEditorialPorId(id));
      nav.addObject("title", "Editar Editorial");
      nav.addObject("action", "modificar");
      return nav;
    }
    
   @PostMapping ("/guardar")
    public RedirectView guardar(@RequestParam String nombre){
        editorialService.crearEditorial(nombre);
        return new RedirectView("/editoriales");
    }
    
  @PostMapping ("/modificar")
    public RedirectView modificar(@RequestParam String id,@RequestParam String nombre ){
        editorialService.modificarEditorial(id, nombre);
        return new RedirectView("/editoriales");
    }
    
  @PostMapping ("/eliminar/{id}")
    public RedirectView eliminar(@RequestParam String id){
        editorialService.eliminarEditorial(id);
        return new RedirectView("/editoriales");
    }
}
