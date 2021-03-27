/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import Personas.clsPersona;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SATELLITE
 */
public class clsConexion {
    
    public Connection conexion;
    private final String servidor_conexion = "jdbc:mysql://127.0.0.1/sorteo";
    static private final String usuario = "root";
    static private final String clave = "";
    private final String enlistar="SELECT*FROM personas";
    
    
    public void AbrirConexion()
    {
        try
        {
            conexion = (Connection) DriverManager.getConnection(servidor_conexion, usuario, clave);
            System.out.println("Conexion exitosa");
            
        }
        catch(SQLException ex)
        {
           System.out.println("Error: "+ex.getMessage());
        }
    }
    
    public void CerrarConexion()
    {
        try
        {
            conexion.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
    
    public clsPersona buscar (String correlativo)
    {
        clsPersona nombre = new clsPersona();
        
        try
        {
            AbrirConexion();
            String criterio = "select * from personas where id_persona = "+correlativo;
            Statement s = (Statement)conexion.createStatement();
            ResultSet rs = s.executeQuery(criterio);
            
            while(rs.next())
            {
                nombre.setNombre_persona(rs.getString("nombre_persona"));
            }
            
            CerrarConexion();
        }
        catch(SQLException ex)
        {
            System.out.println("error: "+ex.getMessage());
        }
        return nombre;
    }
            
}
