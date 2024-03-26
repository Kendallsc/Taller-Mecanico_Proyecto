/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.mecanico_proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.IDN;
import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class ArchivosClientes {

    public static void agregar(int id, String nombre, String telefono) {
        try {

            DataOutputStream archivo = new DataOutputStream(new FileOutputStream("clientes.txt", true));

            archivo.writeUTF(String.valueOf(id));
            archivo.writeUTF(nombre);
            archivo.writeUTF(telefono);
            archivo.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static boolean buscar(int id, String nombre, String telefono) {
        String idEncontrado, nombreEncontrado, telefonoEncontrado;
        boolean encontrado = false;
        boolean proximo = true;
        try {
            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("clientes.txt"));
            try {
                while (proximo) {
                    idEncontrado = archivoLectura.readUTF();
                    nombreEncontrado = archivoLectura.readUTF();
                    telefonoEncontrado = archivoLectura.readUTF();
                    if (idEncontrado.equals(String.valueOf(id)) && nombreEncontrado.equals(nombre)) {
                        encontrado = true;
                        proximo = false;
                    }
                }

            } catch (EOFException e) {
                archivoLectura.close();
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al localizar el archivo: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            //Todo lo que puede salir mal, va en este catch
            JOptionPane.showMessageDialog(null, "Los archivos tienen errores de lectura/escritura: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrado;
    }
}
