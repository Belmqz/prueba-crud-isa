/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.usuariosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author goret
 */
public class conexion {
    
    String strConexionDB="jdbc:sqlite:C:/Users/goret/OneDrive/Documentos/NetBeansProjects/CRUD/datos.db";
    Connection conn= null;
    
    public conexion(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn= DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexion establecida");
        }catch (Exception e){
            
            System.out.print("Error de conexión"+e);
        }
    }
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        
        try{
            PreparedStatement pstm= conn.prepareStatement (strSentenciaSQL);
            pstm.execute();
            return 1;
            
        }catch (SQLException e){
            System.out.print(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try{
            PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta= pstm.executeQuery();
            return respuesta;
            
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
            
    }
}
