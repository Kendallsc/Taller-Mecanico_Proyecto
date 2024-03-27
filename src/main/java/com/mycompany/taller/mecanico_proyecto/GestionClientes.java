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
public class GestionClientes {
    
    
    ConexionBD conexion = new ConexionBD();
    ResultSet resultado = null;

    public String[] consultarClientesPorId(int idConsulta, String nombreConsulta) {
        
        String usuario[] = new String[3];

        try {
            conexion.setConexion();
            conexion.setConsulta("SELECT idCliente, nombre, telefono from clientes where idCliente = " + idConsulta + " AND nombre= '" + nombreConsulta + "'");
            resultado = conexion.getResultado();
            
            while (resultado.next()) {
                int idCliente = resultado.getInt("idCliente");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");

                usuario[0] = String.valueOf(idCliente);
                usuario[1] = nombre;
                usuario[2] = telefono;
            }
            return usuario;

        } catch (SQLException e) {
            e.printStackTrace();
            return usuario;
        }
    }

    public void insertarCliente(int idCliente, String nombre, String telefono) {

        try {
            conexion.setConexion();
            conexion.setConsulta("INSERT INTO clientes (idCliente, nombre, telefono) VALUES (?,?,?)");
            conexion.getConsulta().setString(1, String.valueOf(idCliente));
            conexion.getConsulta().setString(2, nombre);
            conexion.getConsulta().setString(3, telefono);

            if (conexion.getConsulta().executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente Guardado!", "Agregar Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el Cliente!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
