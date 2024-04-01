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

    String cliente[];
    GestionClientes gestionClientes = new GestionClientes();
    GestionAutos gestionAutos = new GestionAutos();

    public void crearCliente(int id, String nombre, String telefono) {
        try {

            Cliente cliente = new Cliente(id, nombre, telefono);

            gestionClientes.insertarCliente(cliente.getIdCliente(), cliente.getNombre(), cliente.getTelefono());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inicioSesion(int id, String nombre) {

        try {
            
            cliente = new String[3];
            cliente = gestionClientes.consultarClientesPorId(id, nombre);
            
            if(cliente[0] != null && cliente[1] != null && cliente[2] != null){
                JOptionPane.showMessageDialog(null, "Inicio de Sesion exitoso puede continuar!  -  ID:" + cliente[0] + " - Nombre: " + cliente[1] + " - Telefono: " + cliente[2], "Ingresando", JOptionPane.INFORMATION_MESSAGE);
            }
            else {

                JOptionPane.showMessageDialog(null, "No se encontro el usuario. Se cerrara la aplicacion!", "Inicio de Sesion Fallido", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void consultarAuto(){
        
        try {
            gestionAutos.consultarAutos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
           
    }
    
    public void consultarAutoPorPlaca(String placaConsultar){
        
        try {
            gestionAutos.consultarAutosPorPlaca(placaConsultar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void insertarAuto(String modelo,String placa, boolean marchamo, boolean rtv, boolean golpes,String notasAdicionales){
  
        try {
            Auto auto = new Auto(modelo, placa, marchamo, rtv, golpes, notasAdicionales);
            
            gestionAutos.insertarAuto(auto.getModelo(), auto.getPlaca(), auto.getMarchamoAlDia(), auto.getRtvAlDia(), auto.getGolpes(), auto.getNotasAdicionales());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void editarAuto(int id, String modelo,String placa, boolean marchamo, boolean rtv, boolean golpes,String notasAdicionales){
                
        try {
            gestionAutos.modificarAuto(id, modelo, placa, marchamo, rtv, golpes, notasAdicionales);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
    }
    
    public void eliminarAuto(int id){
        
        try {
            gestionAutos.eliminarAuto(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
