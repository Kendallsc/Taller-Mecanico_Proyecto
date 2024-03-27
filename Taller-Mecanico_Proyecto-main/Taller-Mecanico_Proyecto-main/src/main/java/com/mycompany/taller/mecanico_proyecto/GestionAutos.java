/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.mecanico_proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jsolo
 */
public class GestionAutos {
    ConexionBD conexion = new ConexionBD();

    public void consultarAutos() {
        try {
            //Abrimos la conexión
            conexion.setConexion();
            //Definimos la consulta
            conexion.setConsulta("SELECT * FROM GestionAutos");
            //Obtenemos los resultados
            ResultSet resultado = conexion.getResultado();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String modelo = resultado.getString("modelo");
                String placa = resultado.getString("placa");
                boolean marchamo = resultado.getBoolean("marchamo");
                boolean rtv = resultado.getBoolean("rtv");
                boolean golpes = resultado.getBoolean("golpes");
                String notasAdicionales = resultado.getString("notas_adicionales");

                System.out.println("ID: " + id + " - Modelo: " + modelo + " - Placa: " + placa + " - Marchamo: " + marchamo + " - RTV: " + rtv + " - Golpes: " + golpes + " - Notas adicionales: " + notasAdicionales);
            }

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertarAuto(String modelo, String placa, boolean marchamo, boolean rtv, boolean golpes, String notasAdicionales) {
        try {
            conexion.setConexion();
            conexion.setConsulta("INSERT INTO GestionAutos (modelo, placa, marchamo, rtv, golpes, notas_adicionales) VALUES (?, ?, ?, ?, ?, ?)");
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
            conexion.setConsulta("UPDATE GestionAutos SET modelo = ?, placa = ?, marchamo = ?, rtv = ?, golpes = ?, notas_adicionales = ? WHERE id = ?");
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
            conexion.setConsulta("DELETE FROM GestionAutos WHERE id = ?");
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



