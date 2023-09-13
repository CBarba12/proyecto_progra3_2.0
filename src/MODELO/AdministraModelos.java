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
public class AdministraModelos {

    private DefaultTableModel modeloTI;
    private DefaultTableModel modeloI;
    private DefaultTableModel modeloCal;
    private DefaultTableModel modeloMed;
    
    
    private ArrayTipoInstrumento arrayTI;
    private ArrayInstrumentos arrayI;
    private ArrayCalibraciones arrayC;
    private ArrayMediciones arrayM;

    //--------------------------------------------------------------------

    public AdministraModelos() {
        modeloTI = new DefaultTableModel();
        arrayTI = new ArrayTipoInstrumento(); // el array lista se carga automaticamente con algunos
        modeloI = new DefaultTableModel();
        arrayI = new ArrayInstrumentos();
        modeloCal = new DefaultTableModel();
        arrayC = new ArrayCalibraciones();
        modeloMed = new DefaultTableModel();
        arrayM = new ArrayMediciones();

        //datos por defecto
        darFormatoModelos();
        inicializarModelos(); // los modelo se cargan aqui
    }
    //--------------------------------------------------------------------

    public void darFormatoModelos() {
        //Modelo tipo instrumentos
        modeloTI.addColumn("Codigo");
        modeloTI.addColumn("Nombre");
        modeloTI.addColumn("Unidad");
        
        //Modelo instrumento
        modeloI.addColumn("No. Serie");
        modeloI.addColumn("Descripcion");
        modeloI.addColumn("Minimo");
        modeloI.addColumn("Maximoo");
        modeloI.addColumn("Tolerancia");
        //Modelo Calibraciones        
        modeloCal.addColumn("Número");
        modeloCal.addColumn("Fecha");
        modeloCal.addColumn("Mediciones");
        //Modelo Mediciones
        modeloMed.addColumn("Medida");
        modeloMed.addColumn("Referencia");
        modeloMed.addColumn("Lectura");
    }

//------------------------------------------------------TIPO DE INSTRUMENTO-----------------------------------
    public void insertarTipoInstrumento(TipoInstrumentos ti) {
        arrayTI.insertarTipoInstrumento(ti);
        //insertarFilaModeloTipoInstrumento(arrayTI.retornaFila(arrayTI.getCantidad() - 1));
    }

    public void insertarInstrumento(Instrumento ti) {
        arrayI.insertarInstrumento(ti);
        insertarFilaModeloInstrumento(arrayI.retornaFila(arrayI.getCantidad() ));
    }

    public void insertarCalibraciones(Calibracion ti) {
        arrayC.insertarCalibracion(ti);
        insertarFilaModeloCalibracion(arrayC.retornaFila(arrayC.getCantidad() - 1));
    }
    public void insertarMediciones(Medicion m) {
        arrayM.insertarMedicion(m);
        insertarFilaModeloMedicion(arrayM.retornaFila(arrayM.getCantidad() - 1));
    }
    //-----------------------------------------------TIPO DE INSTRUMENTO---------------------------------------------------------

    public void insertarFilaModeloTipoInstrumento(Object[] filaAux) {
        modeloTI.addRow(filaAux);
    }
    public void insertarFilaModeloInstrumento(Object[] filaAux) {
        modeloI.addRow(filaAux);
    }
    public void insertarFilaModeloCalibracion(Object[] filaAux) {
        modeloCal.addRow(filaAux);
    }
    public void insertarFilaModeloMedicion(Object[] filaAux) {
        modeloMed.addRow(filaAux);
    }
    //--------------------------------------------------------------------------------------------------------  

    public void borrarRegistroTipoInstrumento(int linea) {
        modeloTI.removeRow(linea);
        arrayTI.eliminarElemento(linea);
    }
    public void borrarRegistroInstrumento(int linea) {
        modeloI.removeRow(linea);
        arrayI.eliminarElemento(linea);
    }
    public void borrarRegistroCalibracion(int linea) {
        modeloCal.removeRow(linea);
        arrayC.eliminarElemento(linea);
    }
    public void borrarRegistroMedicion(int linea) {
        modeloMed.removeRow(linea);
        arrayM.eliminarElemento(linea);
    }

    //--------------------------------------------------------------

    public void inicializarModelos() {
        for (int i = 0; i < arrayTI.getCantidad(); i++) {
            Object[] filAux = arrayTI.retornaFila(i);  // le pido una fila a miArray
            modeloTI.addRow(filAux);
        }
        for (int i = 0; i < arrayI.getCantidad(); i++) {
            Object[] filAux = arrayI.retornaFila(i);  // le pido una fila a miArray
            modeloI.addRow(filAux);
        }
        for (int i = 0; i < arrayC.getCantidad(); i++) {
            Object[] filAux = arrayC.retornaFila(i);  // le pido una fila a miArray
            modeloCal.addRow(filAux);
        }
        for (int i = 0; i < arrayM.getCantidad(); i++) {
            Object[] filAux = arrayM.retornaFila(i);  // le pido una fila a miArray
            modeloMed.addRow(filAux);
        }

    }

//-----------------------------------------------------------------------
    public DefaultTableModel getModeloTipoInstrumento() {
        return modeloTI;
    }
    public DefaultTableModel getModeloInstrumento() {
        return modeloI;
    }
     public DefaultTableModel getModeloCalibracion() {
        return modeloCal;
    }
      public DefaultTableModel getModeloMedicion() {
        return modeloMed;
    }

    public DefaultTableModel getModeloTI() {
        return modeloTI;
    }

    public void setModeloTI(DefaultTableModel modeloTI) {
        this.modeloTI = modeloTI;
    }

    public DefaultTableModel getModeloI() {
        return modeloI;
    }

    public void setModeloI(DefaultTableModel modeloI) {
        this.modeloI = modeloI;
    }

    public DefaultTableModel getModeloCal() {
        return modeloCal;
    }

    public void setModeloCal(DefaultTableModel modeloCal) {
        this.modeloCal = modeloCal;
    }

    public DefaultTableModel getModeloMed() {
        return modeloMed;
    }

    public void setModeloMed(DefaultTableModel modeloMed) {
        this.modeloMed = modeloMed;
    }

    public ArrayInstrumentos getArrayI() {
        return arrayI;
    }

    public void setArrayI(ArrayInstrumentos arrayI) {
        this.arrayI = arrayI;
    }

    public ArrayCalibraciones getArrayC() {
        return arrayC;
    }

    public void setArrayC(ArrayCalibraciones arrayC) {
        this.arrayC = arrayC;
    }

    public ArrayMediciones getArrayM() {
        return arrayM;
    }

    public void setArrayM(ArrayMediciones arrayM) {
        this.arrayM = arrayM;
    }
     
    public ArrayTipoInstrumento getArrayTI() {
        return arrayTI;
    }

    public ArrayInstrumentos getArrayInstrumento() {
        return arrayI;
    }

    public ArrayCalibraciones getArrayCalibraciones() {
        return arrayC;
    }

    public ArrayMediciones getArrayMediciones() {
        return arrayM;
    }
    
    //Metodos
    
}
