
package edu.egg.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
@SQLDelete (sql="UPDATE usuario SET alta=False Where id=?")
@Entity
public class Autor {
    @Id
    @GeneratedValue(generator = "uuid")                       //String
    @GenericGenerator(name = "uuid", strategy = "uuid2")      //String

    private String id;
    private String nombre;
    private Boolean alta;

    public Autor() {
    }

    public Autor(String id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
}
