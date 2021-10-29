
package edu.egg.demo.Repositorios;

import edu.egg.demo.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String>{
    @Modifying
    @Query("UPDATE Editorial a SET a.nombre = :nombre WHERE a.id = :id")
    void modificarEditorial(@Param("id") String id, @Param("nombre") String nombre);
    
    @Modifying
    @Query("UPDATE Editorial a SET a.alta = false WHERE a.id = :id")
    void eliminarEditorial(@Param("id") String id);
    
}
