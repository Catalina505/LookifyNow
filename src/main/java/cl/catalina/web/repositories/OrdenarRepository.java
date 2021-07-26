package cl.catalina.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.catalina.web.models.Cancion;

public interface OrdenarRepository extends JpaRepository<Cancion, Long>{
	
	List<Cancion> OrderByClasificacionDesc();
}
