/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.mecanico_proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class GestionAutos {
    
    ConexionBD conexion = new ConexionBD();
    ResultSet resultado = null;

    
    public void consultarAutos() {

        try {
            conexion.setConexion();
            conexion.setConsulta("SELECT idAuto, modelo, placa, marchamo, rtvAlDia, golpes, notasAdicionales FROM auto");
            resultado = conexion.getResultado();
            
            while (resultado.next()) {
                int idAuto = resultado.getInt("idAuto");
                String modelo = resultado.getString("modelo");
                String placa = resultado.getString("placa");
                boolean marchamo = resultado.getBoolean("marchamo");
                boolean rtvAlDia = resultado.getBoolean("rtvAlDia");
                boolean golpes = resultado.getBoolean("golpes");
                String notasAdicionales = resultado.getString("notasAdicionales");

                System.out.println("ID: " + idAuto + " - Modelo: " + modelo + " - Placa: " + placa + " - Marchamo: " + marchamo + " - RTV: " + rtvAlDia + " - Golpes: " + golpes + " - Notas adicionales: " + notasAdicionales);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void consultarAutosPorPlaca(String placaConsultar) {

        try {
            conexion.setConexion();
            conexion.setConsulta("SELECT idAuto, modelo, placa, marchamo, rtvAlDia, golpes, notasAdicionales FROM auto where placa = '" + placaConsultar + "'");
            resultado = conexion.getResultado();
            
            while (resultado.next()) {
                int idAuto = resultado.getInt("idAuto");
                String modelo = resultado.getString("modelo");
                String placa = resultado.getString("placa");
                boolean marchamo = resultado.getBoolean("marchamo");
                boolean rtvAlDia = resultado.getBoolean("rtvAlDia");
                boolean golpes = resultado.getBoolean("golpes");
                String notasAdicionales = resultado.getString("notasAdicionales");

                System.out.println("ID: " + idAuto + " - Modelo: " + modelo + " - Placa: " + placa + " - Marchamo: " + marchamo + " - RTV: " + rtvAlDia + " - Golpes: " + golpes + " - Notas adicionales: " + notasAdicionales);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
     public void insertarAuto(String modelo, String placa, boolean marchamo, boolean rtv, boolean golpes, String notasAdicionales) {
        try {
            conexion.setConexion();
            conexion.setConsulta("INSERT INTO auto (modelo, placa, marchamo, rtvAlDia, golpes, notasAdicionales) VALUES (?, ?, ?, ?, ?, ?)");
            conexion.getConsulta().setString(1, modelo);
            conexion.getConsulta().setString(2, placa);
            conexion.getConsulta().setBoolean(3, marchamo);
            conexion.getConsulta().setBoolean(4, rtv);
            conexion.getConsulta().setBoolean(5, golpes);
            conexion.getConsulta().setString(6, notasAdicionales);

            if (conexion.getConsulta().executeUpdate() > 0) {
                System.out.println("Auto insertado correctamente!");
            } else {
                System.out.println("Error al insertar el auto.");
            }

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modificarAuto(int id, String modelo, String placa, boolean marchamo, boolean rtv, boolean golpes, String notasAdicionales) {
        try {
            conexion.setConexion();
            conexion.setConsulta("UPDATE auto SET modelo = ?, placa = ?, marchamo = ?, rtvAlDia = ?, golpes = ?, notas_adicionales = ? WHERE idAuto = ?");
            conexion.getConsulta().setString(1, modelo);
            conexion.getConsulta().setString(2, placa);
            conexion.getConsulta().setBoolean(3, marchamo);
            conexion.getConsulta().setBoolean(4, rtv);
            conexion.getConsulta().setBoolean(5, golpes);
            conexion.getConsulta().setString(6, notasAdicionales);
            conexion.getConsulta().setInt(7, id);

            if (conexion.getConsulta().executeUpdate() > 0) {
                System.out.println("Auto modificado correctamente!");
            } else {
                System.out.println("Error al modificar el auto.");
            }

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void eliminarAuto(int id) {
        try {
            conexion.setConexion();
            conexion.setConsulta("DELETE FROM auto WHERE idAuto = ?");
            conexion.getConsulta().setInt(1, id);

            if (conexion.getConsulta().executeUpdate() > 0) {
                System.out.println("Auto eliminado correctamente!");
            } else {
                System.out.println("Error al eliminar el auto.");
            }

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
