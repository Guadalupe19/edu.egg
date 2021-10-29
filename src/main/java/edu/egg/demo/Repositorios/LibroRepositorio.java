
package edu.egg.demo.Repositorios;

import edu.egg.demo.entidades.Editorial;
import edu.egg.demo.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository <Libro, String>{
    
 @Modifying
   @Query("UPDATE Libro u SET u.isbn = :isbn, u.titulo = :titulo,u.anio = :anio,u.ejemplares = :ejemplares WHERE u.id= :id")
    void modificar(@Param("id") String id,@Param("isbn") Long isbn, @Param("titulo") String titulo, @Param("anio") Integer anio, @Param("ejemplares") Integer ejemplares);

 @Modifying
   @Query("UPDATE Libro a SET a.alta = false WHERE a.id = :id")
    void eliminarLibro(@Param("id") String id);
    
}
