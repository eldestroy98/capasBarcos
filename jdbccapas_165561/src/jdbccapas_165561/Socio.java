/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas_165561;

/**
 *
 * @author lv1013
 */
public class Socio {
    private int id;
    private String nombre;
    private String dni;

    public Socio(int id, String dni, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Socio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setdni(String dni) {
        this.dni = dni;
    }
}
