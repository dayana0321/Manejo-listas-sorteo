/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

/**
 *
 * @author SATELLITE
 */
public class clsPersona {
    private int id_persona;
    private String nombre_persona;
    
    public clsPersona()
    {
        
    }

    /**
     * @return the id_persona
     */
    public int getId_persona() {
        return id_persona;
    }

    /**
     * @param id_persona the id_persona to set
     */
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    /**
     * @return the nombre_persona
     */
    public String getNombre_persona() {
        return nombre_persona;
    }

    /**
     * @param nombre_persona the nombre_persona to set
     */
    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }
}
