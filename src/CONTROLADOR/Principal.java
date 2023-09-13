/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CONTROLADOR;

import MODELO.AdministraModelos;
import VISTA.INTERFAZ;

/**
 *
 * @author Raquel
 */
public class Principal {

    public static void main(String[] args) {
        INTERFAZ v = new INTERFAZ();
        AdministraModelos m = new AdministraModelos();
        Control c = new Control(m, v);
        
        
    }

}
