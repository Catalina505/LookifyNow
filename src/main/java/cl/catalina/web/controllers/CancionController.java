package cl.catalina.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.catalina.web.models.Cancion;
import cl.catalina.web.services.CancionService;

@Controller
public class CancionController {
	
	private final CancionService canSer;

	public CancionController(CancionService canSer) {
		this.canSer = canSer;
	}
	
	@RequestMapping("/")
	public String index(Model model){
		return "index.jsp";
	}
	
	@RequestMapping("/inicio")
	public String home (Model model) {
		List<Cancion> canciones = canSer.allCanciones();
		model.addAttribute("canciones", canciones);
		return "lista.jsp";
	}
	
	@RequestMapping("/crear")
	public String crearCancion(Model model) {
		return "nuevo.jsp";
	}
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	 public String create(@Valid Cancion cancion1, @RequestParam(value="titulo") String titulo, @RequestParam(value="artista") String artista, @RequestParam(value="clasificacion") int clas, BindingResult bd) {
	     Cancion cancion = new Cancion (titulo, artista, clas);
		 Map<String, Object> respuesta = new HashMap<>();
	     if (bd.hasErrors()) {
	    	 respuesta.put("error", "Error al crear la cancion");
	         return "redirect:/crear";
	     } else {
	         canSer.crearCancion(cancion);
	         respuesta.put("respuesta", "Canción creada con éxito");
	         return "redirect:/inicio";
	     }
	 }
	
	@RequestMapping("/ver/{id}")
	public String verCancion(@PathVariable("id") Long id, Model model) {
		Cancion cancion = canSer.infoCancion(id);
		model.addAttribute("cancion", cancion);
		return "informacion.jsp";
	}
	
	@RequestMapping("/{id}/borrar/borrar")
	public String borrarCancion (@PathVariable("id")Long id) {
		canSer.eliminarCancion(id);
		return "redirect:/inicio";
	}
	
	@RequestMapping("/edit")
	public String editarCancion(Model model) {
		return "edit.jsp";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	public String editar(@PathVariable("id") Long id, @RequestParam(value="titulo") String titulo, @RequestParam(value="artista") String artista, @RequestParam(value="clasificacion") int clas, Model model) {
		canSer.editarCancion(id, titulo, artista, clas);
		model.addAttribute("cancion");
		return "redirect:/inicio";
	}
	
	@RequestMapping(value="/buscar", method = RequestMethod.POST)
	public String buscarArtista (@RequestParam(value="buscar") String buscar, Model model) {
		List<Cancion> cancion = canSer.buscar(buscar);
		model.addAttribute("nombre", buscar);
		model.addAttribute("cancion", cancion);
		return "/buscar.jsp";
	}
	
	@RequestMapping("/topTen")
	public String clasificaciones (Model model) {
		List<Cancion> cancion = canSer.clasificacion();
		model.addAttribute("cancion", cancion);
		return "clasificacion.jsp";
	}
}
