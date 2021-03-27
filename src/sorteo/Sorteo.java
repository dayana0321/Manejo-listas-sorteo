/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteo;

import ConexionBD.clsConexion;
import Listas.clsListas;
import Personas.clsPersona;
import java.util.Scanner;

/**
 *
 * @author SATELLITE
 */
public class Sorteo {
    
    //Prueba para comprobar la conexión a la BD
    public static void buscar ()
    {
        Scanner s = new Scanner(System.in);
        String id;
        System.out.println("Ingrese el id a buscar");
        id= s.next();
        
        clsConexion conn= new clsConexion();
        
        clsPersona persona = new clsConexion().buscar(id);
        System.out.println("Nombre: "+ persona.getNombre_persona());
    }

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        clsConexion conn = new clsConexion();
        //buscar();
        clsListas listaNombres = new clsListas();
        listaNombres.insertarDatosLista();
        conn.AbrirConexion();
        conn.CerrarConexion();          
    }  
}
