/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raquel
 */
public class ModeloTipoInstrumento {
    private  DefaultTableModel modeloTipoInstrumento;

    ModeloTipoInstrumento(){
        modeloTipoInstrumento = new DefaultTableModel();
        // Se define las columnas
        String cabeceras[] = {"Codigo", "Nombre", "Unidad"};
        modeloTipoInstrumento.setColumnIdentifiers(cabeceras);

    }
}
