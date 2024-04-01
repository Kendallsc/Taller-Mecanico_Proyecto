/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.mecanico_proyecto;

/**
 *
 * @author Kendall
 */
public class Auto {
    
    private String modelo;
    private String placa;
    private boolean marchamoAlDia;
    private boolean rtvAlDia;
    private boolean golpes;
    private String notasAdicionales;

    public Auto(String modelo, String placa, boolean marchamoAlDia, boolean rtvAlDia, boolean golpes, String notasAdicionales) {
        this.modelo = modelo;
        this.placa = placa;
        this.marchamoAlDia = marchamoAlDia;
        this.rtvAlDia = rtvAlDia;
        this.golpes = golpes;
        this.notasAdicionales = notasAdicionales;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean getMarchamoAlDia() {
        return marchamoAlDia;
    }

    public void setMarchamoAlDia(boolean marchamoAlDia) {
        this.marchamoAlDia = marchamoAlDia;
    }

    public boolean getRtvAlDia() {
        return rtvAlDia;
    }

    public void setRtvAlDia(boolean rtvAlDia) {
        this.rtvAlDia = rtvAlDia;
    }

    public boolean getGolpes() {
        return golpes;
    }

    public void setGolpes(boolean golpes) {
        this.golpes = golpes;
    }

    public String getNotasAdicionales() {
        return notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }
    
    public String toString(){
        
        String x = "Modelo: " + modelo + " - Placa: " + placa;
        
        if(marchamoAlDia){
            x += " - Marchamo al dia?: SI";
        }else{
            x += " - Marchamo al dia?: No";
        }
        
        if(rtvAlDia){
            x += " - RTV al dia?: SI";
        }else{
            x += " - RTV al dia?: No";
        }
        
        if(golpes){
            x += " - Posee golpes?: SI";
        }else{
            x += " - Posee golpes?: No";
        }
        
        if(notasAdicionales.equals("")){
            x += "\nNo Posee notas adicionales";
        }else{
            x += "\n" + notasAdicionales;
        }
        
        return "";
    }
    
}
