package cl.catalina.web.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import cl.catalina.web.models.Cancion;

public interface CancionRepository extends CrudRepository<Cancion, Long> {
	
	List<Cancion> findAll(Sort sort);
	
	List<Cancion> findAll();

	List<Cancion> findByartista(String name);
	
	List<Cancion> findAllByOrderByClasificacionDesc();
}
