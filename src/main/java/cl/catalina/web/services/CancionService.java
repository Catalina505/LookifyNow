package cl.catalina.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cl.catalina.web.models.Cancion;
import cl.catalina.web.repositories.CancionRepository;
import cl.catalina.web.repositories.OrdenarRepository;

@Service
public class CancionService {
	private final CancionRepository canRep;
	private final OrdenarRepository orderRep;

	public CancionService(CancionRepository canRep, OrdenarRepository orderRep) {
		this.canRep = canRep;
		this.orderRep = orderRep;
	}
	
	public List<Cancion> allCanciones() {
		return canRep.findAll();
	}
	
	public Cancion crearCancion(Cancion cancion) {
		return canRep.save(cancion);
	}
	
	public Cancion infoCancion(Long id) {
	        Optional<Cancion> optional = canRep.findById(id);
	        if(optional.isPresent()) {
	            return optional.get();
	        } else {
	            return null;
	        }
	    }
	
	public List<Cancion> buscar(String buscar) {
		return canRep.findByartista(buscar);
	}
	
	public Cancion eliminarCancion(Long id) {
		canRep.deleteById(id);
		return null;
	}
	
	public Cancion editarCancion(Long id, String titulo, String artista, int clasificacion) {
		canRep.findById(id);
		Cancion cancion = new Cancion();
		cancion.setTitulo(titulo);
		cancion.setArtista(artista);
		cancion.setClasificacion(clasificacion);
		return canRep.save(cancion);
	}

	public Cancion editarCancion(Cancion cancion) {
		return canRep.save(cancion);
	}
	
	public List<Cancion> clasificacion(){
		List<Cancion> cancion = canRep.findAllByOrderByClasificacionDesc();
		return cancion;
	}
}
