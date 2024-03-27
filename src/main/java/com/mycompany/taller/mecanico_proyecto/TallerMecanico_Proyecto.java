/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.taller.mecanico_proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class TallerMecanico_Proyecto {

    public static void main(String[] args) {

        int opcion = 0;
        TallerMecanico taller = new TallerMecanico();
        String id, nombre, telefono;

        while (opcion != 5) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Menú Principal:\n"
                    + "1 - Iniciar Sesion\n"
                    + "2 - Crear Usuario\n"
                    + "5 - Salir\n"
                    + "Digite una opción para continuar: "
            ));
            switch (opcion) {
                case 1:
                    id = JOptionPane.showInputDialog("Digite su id:");
                    nombre = JOptionPane.showInputDialog("Digite su nombre:");
                    taller.inicioSesion(Integer.parseInt(id), nombre);
                    
                    break;
                case 2:
                    id = JOptionPane.showInputDialog("Digite su id:");
                    nombre = JOptionPane.showInputDialog("Digite su nombre:");
                    telefono = JOptionPane.showInputDialog("Digite su telefono:");
                    
                    taller.crearCliente(Integer.parseInt(id), nombre, telefono);
                    break;
                case 5:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
