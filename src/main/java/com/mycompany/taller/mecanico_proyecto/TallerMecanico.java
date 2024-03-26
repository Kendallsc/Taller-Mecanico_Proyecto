/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.mecanico_proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class TallerMecanico {

    Cliente cliente;
    ArchivosClientes archivosClientes = new ArchivosClientes();

    public void crearCliente(int id, String nombre, String telefono) {
        try {

            cliente = new Cliente(id, nombre, telefono);

            archivosClientes.agregar(id, nombre, telefono);

            JOptionPane.showMessageDialog(null, "Cliente Guardado!", "Agregar Datos", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inicioSesion(int id, String nombre, String telefono) {

        try {

            boolean existeCliente = archivosClientes.buscar(id, nombre, telefono);

            if (existeCliente) {

                JOptionPane.showMessageDialog(null, "Inicio de Sesion exitoso puede continuar!", "Ingresando", JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(null, "No se encontro el usuario. Se cerrara la aplicacion!", "Inicio de Sesion Fallido", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
