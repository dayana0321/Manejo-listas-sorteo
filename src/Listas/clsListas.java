/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import ConexionBD.clsConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author SATELLITE
 */
public class clsListas {
    
    clsConexion conn = new clsConexion();
    String nombre, Ganadores;
    int CantGanadores;
    
    //Para ingresar datos 
    Scanner sc = new Scanner(System.in);
     
    //Declaración de listas para almacenar a las personas
    
    ArrayList<String> nombres = new ArrayList<String>();
    ArrayList<String> personasGanadoras = new ArrayList<String>();
    
    
    //<>
   public void insertarDatosLista ()
   {
       try
       {
           //Abrir conexion a la Base de Datos
          conn.AbrirConexion();
          String query = "select * from personas";
          Statement s = (Statement)conn.conexion.createStatement();
          ResultSet rs= s.executeQuery(query);
          
       
          while(rs.next())
          {
              nombre = rs.getString("nombre_persona");
              nombres.add(nombre);
          }
          
          //Para obtener las personas seleccionadas
          System.out.println("Ingrese el numero de 10 para mostrar a los ganadores");
          CantGanadores= sc.nextInt();
         
          while(personasGanadoras.size() !=10)
          {
              Collections.shuffle(nombres);
              Ganadores = nombres.get(CantGanadores);
              personasGanadoras.add(Ganadores);
              nombres.remove(Ganadores);
              
          }
         
          //Mostrar los datos
          
          System.out.println("***¡BIENVENIDOS AL SORTEO!***");
          
          System.out.println("\n**Nombres de todos los participantes:** "+nombres);
          
          //Utilizacion de la interfaz Collections
          Collections.sort(nombres);
          System.out.println("\n**Nombres de los participantes ordenados:** "+nombres);
          
          //Mostrar las personas ganadoras del sorteo
          System.out.println("\n**Personas Ganadoras del Sorteo**");
          Collections.sort(personasGanadoras);
          
          MostrarDatos(personasGanadoras);
          System.out.println();
          
          conn.CerrarConexion();
       }
       catch(SQLException ex)
       {
           System.out.println("Error: "+ex.getMessage());
       }
   }//end metodo
   
   
   public void MostrarDatos(Collection coleccion)
   {       
       Iterator iter = coleccion.iterator();
       
       while(iter.hasNext())
        {
            System.out.println("Nombre: "+iter.next());
        }  
   }//end mostrarDatos
}//end class
