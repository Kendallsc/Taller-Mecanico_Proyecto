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

        while (opcion != 7) {
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
                case 3: // Insertar Auto
                String modelo = JOptionPane.showInputDialog("Ingrese el modelo del auto:");
                String placa = JOptionPane.showInputDialog("Ingrese la placa del auto:");
                boolean marchamo = JOptionPane.showInputDialog("¿El auto tiene el marchamo al día? (true/false)").equalsIgnoreCase("true");
                boolean rtv = JOptionPane.showInputDialog("¿El auto tiene el RTV al día? (true/false)").equalsIgnoreCase("true");
                boolean golpes = JOptionPane.showInputDialog("¿El auto tiene golpes? (true/false)").equalsIgnoreCase("true");
                String notas = JOptionPane.showInputDialog("Ingrese notas adicionales:");
                taller.insertarAuto(modelo, placa, marchamo, rtv, golpes, notas);
                break;

                case 4: // Modificar Auto
                int idModificar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del auto a modificar:"));
                // Aquí deberías recuperar los datos actuales del auto para mostrarlos al usuario y permitir modificarlos
                // Por simplicidad, omitiré este paso y asumiré que el usuario proporcionará todos los datos
                String modeloMod = JOptionPane.showInputDialog("Ingrese el nuevo modelo del auto:");
                String placaMod = JOptionPane.showInputDialog("Ingrese la nueva placa del auto:");
                boolean marchamoMod = JOptionPane.showInputDialog("¿El auto tiene el nuevo marchamo al día? (true/false)").equalsIgnoreCase("true");
                boolean rtvMod = JOptionPane.showInputDialog("¿El auto tiene el nuevo RTV al día? (true/false)").equalsIgnoreCase("true");
                boolean golpesMod = JOptionPane.showInputDialog("¿El auto tiene nuevos golpes? (true/false)").equalsIgnoreCase("true");
                String notasMod = JOptionPane.showInputDialog("Ingrese las nuevas notas adicionales:");
                taller.modificarAuto(idModificar, modeloMod, placaMod, marchamoMod, rtvMod, golpesMod, notasMod);
                break;

                case 5: // Eliminar Auto
                int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del auto a eliminar:"));
                taller.eliminarAuto(idEliminar);
                break;

                case 6: // Consultar Autos
                taller.consultarAutos();
                break;


                 case 7:
                 System.exit(0);
                 default:
                 JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
}
