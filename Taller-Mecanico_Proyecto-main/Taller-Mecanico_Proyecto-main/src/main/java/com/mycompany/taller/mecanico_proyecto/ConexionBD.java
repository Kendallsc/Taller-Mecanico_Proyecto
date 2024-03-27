/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.mecanico_proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kendall
 */
public class ConexionBD {
    
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    
    String url = "jdbc:mysql://localhost:3306/taleer_mecanico";
    String user = "root";
    String password = "63165011j";
    
    
    public void setConsulta(String sql){
        
        try {
            this.consulta =  conexion.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public PreparedStatement getConsulta(){
        return consulta;
    }
    
    public ResultSet getResultado(){
        
        try {
            return consulta.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public void setConexion(){
    
        try {
            this.conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void cerrarConexion(){
        
        if(resultado != null){
            try {
                resultado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if(consulta != null){
            try {
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if(conexion != null){
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
