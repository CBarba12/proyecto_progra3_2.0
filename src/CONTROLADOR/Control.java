/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import VISTA.*;
import MODELO.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.events.MouseEvent;

public class Control implements ActionListener, MouseListener {

    public AdministraModelos modelo;
    public INTERFAZ vista;

    public Control(AdministraModelos m, INTERFAZ v) {
        modelo = m;
        vista = v;

        mostrar();
        vista.getTabla1().setModel(modelo.getModeloTipoInstrumento());
        vista.getTabla2Instrumentos().setModel(modelo.getModeloInstrumento());
        vista.getTabla3Calibraciones().setModel(modelo.getModeloCalibracion());
        vista.getTabla4Mediciones().setModel(modelo.getModeloMedicion());

        //eventos   
        //----------------------tIPO DE INSTRUMENTO----------------
        this.vista.getBtnGuardarTI().addActionListener(this);
        this.vista.getBtnBuscarTI().addActionListener(this);
        this.vista.getBtnLimpiarTI().addActionListener(this);
        this.vista.getBtnBorrarTI().addActionListener(this);
        this.vista.getTabla1().addMouseListener(this);

        // ------------------------INSTRUMENTO----------------------
        this.vista.getBtnGuardarInstrumentos().addActionListener(this);
        this.vista.getBtnlimpiarInstrumentos().addActionListener(this);
        this.vista.getBtnBorrarInstrumentos().addActionListener(this);
        this.vista.getTabla2Instrumentos().addMouseListener(this);
        this.vista.getBtnBuscarInstrumentos().addActionListener(this);

        // ------------------------Calibraciones----------------------
        this.vista.getBtnGuardarCalibracion().addActionListener(this);
        this.vista.getTabla3Calibraciones().addMouseListener(this);
        this.vista.getBtnLimpiarCalibracion().addActionListener(this);
        this.vista.getBtnBorrarCalibracion().addActionListener(this);
        this.vista.getBtnBuscarCalibracion().addActionListener(this);

    }

    public void mostrar() {
        vista.setVisible(true);
    }

    public void ocultar() {
        vista.setVisible(false);
    }

    //---Evento Action Performed---
    @Override
    public void actionPerformed(ActionEvent e) {
        //--Eventos de tipo de instrumentos
        if (e.getSource().equals(vista.getBtnGuardarTI())) {
            guardarTipoInstrumentos();
        }
        if (e.getSource().equals(vista.getBtnLimpiarTI())) {
            limpiarTipoInstrumentos();
        }
        if (e.getSource().equals(vista.getBtnBorrarTI())) {
            borrarTipoInstrumentos();
        }
        if (e.getSource().equals(vista.getBtnBuscarTI())) {
            buscarTipoInstrumento();
        }

        //--Eventos de instrumentos
        if (e.getSource().equals(vista.getBtnGuardarInstrumentos())) {
            this.guardarInstrumento();
        }
        if (e.getSource().equals(vista.getBtnlimpiarInstrumentos())) {
            this.limpiarInstrumento();
        }
        if (e.getSource().equals(vista.getBtnBorrarInstrumentos())) {
            this.borrarInstrumento();
        }
        if (e.getSource().equals(vista.getBtnBuscarInstrumentos())) {
            this.buscarInstrumento();
        }

        //-----------------------------evento de calibraciones  
        //--Eventos de calibracion
        if (e.getSource().equals(vista.getBtnLimpiarCalibracion())) {
            //limpiarCalibracion();
        }

    }

    //---Evento Mouse Clicked---
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getSource().equals(vista.getTabla1())) {
            clickTablaTipoInstrumentos(e);
        }
        if (e.getSource().equals(vista.getTabla2Instrumentos())) {
            clickTablaInstrumento(e);
        }

    }

    //---METODOS TIPO DE INSTRUMENTO---
    public void guardarTipoInstrumentos() {

        if (vista.getTabla1().getSelectedRow() >= 0) {
            // Seleccionar una fila existente para editar
            int selectedRow = vista.getTabla1().getSelectedRow();
            // Modificar los valores de la fila seleccionada
            vista.getTabla1().setValueAt(vista.getJtxtCodigo().getText(), selectedRow, 0);
            vista.getTabla1().setValueAt(vista.getJtxtNombre().getText(), selectedRow, 1);
            vista.getTabla1().setValueAt(vista.getJtxtUnidad().getText(), selectedRow, 2);

            for (int i = 0; i < modelo.getArrayTI().getCantidad(); i++) {
                if (vista.getJtxtCodigo().getText().equals(modelo.getArrayTI().getElemento(i).getCodigoInstrumento())) {
                    modelo.getArrayTI().getElemento(i).setNombreInstrumento(vista.getJtxtNombre().getText());
                    modelo.getArrayTI().getElemento(i).setUnidadInstrumento(vista.getJtxtUnidad().getText());
                }
            }

        } else {
            // No se seleccionó ninguna fila, agregar un nuevo registro

            String codigo = vista.getJtxtCodigo().getText();
            String nombre = vista.getJtxtNombre().getText();
            String unidad = vista.getJtxtUnidad().getText();

            Object[] columna = new Object[modelo.getModeloTipoInstrumento().getColumnCount()];

            columna[0] = codigo;
            columna[1] = nombre;
            columna[2] = unidad;
            modelo.getModeloTipoInstrumento().addRow(columna);
            //modelo.getModeloTipoInstrumento().setModel(vista.getModeloTipos());

            boolean validador = true;

            for (int i = 0; i < modelo.getArrayTI().getCantidad(); i++) {

                if (modelo.getArrayTI().getArrayList().get(i).getCodigoInstrumento().equals(codigo)) {
                    modelo.getArrayTI().getArrayList().get(i).setCodigoInstrumento(codigo);
                    modelo.getArrayTI().getArrayList().get(i).setNombreInstrumento(nombre);
                    modelo.getArrayTI().getArrayList().get(i).setUnidadInstrumento(unidad);
                    validador = false;
                }
                validador = true;
            }
            if (validador == true) {
                TipoInstrumentos p = new TipoInstrumentos(codigo, nombre, unidad);
                modelo.insertarTipoInstrumento(p);
            }
        }


        actualizarJComboBoxInstrumentos();

    }

    public void limpiarTipoInstrumentos() {
        vista.getJtxtCodigo().setText("");
        vista.getJtxtNombre().setText("");
        vista.getJtxtUnidad().setText("");
        vista.getTabla1().clearSelection();
        vista.getBtnBorrarTI().setEnabled(false);
        vista.getJtxtCodigo().setEnabled(true);
    }

    public void borrarTipoInstrumentos() {
        String aux;
        int pos;
        if (vista.getTabla1().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes elegir la fila a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            aux = vista.getJtxtNombre().getText();
            int linea = vista.getTabla1().getSelectedRow();
            modelo.getModeloTI().removeRow(linea);            //vista.getModeloTipos().removeRow(linea);
            pos = modelo.getArrayTI().retornaPos(aux);
            modelo.getArrayTI().eliminarElemento(pos);
            vista.getBtnBorrarTI().setEnabled(false);
            vista.getJtxtCodigo().setEnabled(true);
            actualizarJComboBoxInstrumentos();
            //borrarJComboBoxInstrumento(aux);
        }
    }

    
    
//    public void borrarJComboBoxInstrumento(String s) {
//        int total;
//        String item;
//        total = vista.getjCBTipoInstrumentos().getItemCount();
//        for (int i = 0; i < total; i++) {
//            item = vista.getjCBTipoInstrumentos().getItemAt(i);
//            if (s.equals(item)) {
//                vista.getjCBTipoInstrumentos().removeItemAt(i);
//                vista.getjCBTipoInstrumentos().repaint();
//            }
//        }
//
//    }
    public void actualizarJComboBoxInstrumentos() {
        int total;
        total = vista.getjCBTipoInstrumentos().getItemCount();

        for (int i = total; i > 0; i--) {
            vista.getjCBTipoInstrumentos().removeItemAt(i - 1);
        }

        for (int i = 0; i < modelo.getArrayTI().getCantidad(); i++) {
            vista.getjCBTipoInstrumentos().addItem(modelo.getArrayTI().getElemento(i).getCodigoInstrumento());
        }
        vista.getjCBTipoInstrumentos().repaint();
    }
    
    

    public void clickTablaTipoInstrumentos(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 1) { // Detectar un solo clic
            vista.getBtnBorrarTI().setEnabled(true);
            int selectedRow = vista.getTabla1().getSelectedRow();
            if (selectedRow >= 0) {
                String codigo = (String) vista.getTabla1().getValueAt(selectedRow, 0);
                String nombre = (String) vista.getTabla1().getValueAt(selectedRow, 1);
                String unidad = (String) vista.getTabla1().getValueAt(selectedRow, 2);
                vista.getJtxtCodigo().setText(codigo);
                vista.getJtxtNombre().setText(nombre);
                vista.getJtxtUnidad().setText(unidad);
                vista.getJtxtCodigo().setEnabled(false);// Deshabilitar la edición del campo "Código"
            }
        }
    }

    public void buscarTipoInstrumento() {

        String cadena;
        boolean bandera;
        bandera = false;
        System.out.println("hola");
        for (int i = 0; i < vista.getTabla1().getRowCount(); i++) {
            cadena = (String) vista.getTabla1().getValueAt(i, 1);

            if (cadena.equals(vista.getJtxtBusquedaNombre().getText())) {
                vista.getTabla1().changeSelection(i, 0, false, false);
                int selectedRow = vista.getTabla1().getSelectedRow();
                // Modificar los valores de la fila seleccionada
                String codigo = (String) vista.getTabla1().getValueAt(selectedRow, 0);
                String nombre = (String) vista.getTabla1().getValueAt(selectedRow, 1);
                String unidad = (String) vista.getTabla1().getValueAt(selectedRow, 2);
                vista.getJtxtCodigo().setText(codigo);
                vista.getJtxtNombre().setText(nombre);
                vista.getJtxtUnidad().setText(unidad);
                vista.getJtxtCodigo().setEnabled(false);// Deshabilitar la edición del campo "Código"      
                vista.getJtxtBusquedaNombre().setText("");

                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            JOptionPane.showMessageDialog(null, "Este registro no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            vista.getJtxtBusquedaNombre().setText("");

        }
    }

    
    
    
    //---METODOS INSTRUMENTO---
    public void guardarInstrumento() {

        String seleccion;
        int seleccion_2;
        if (vista.getTabla2Instrumentos().getSelectedRow() >= 0) {
            // Seleccionar una fila existente para editar
            int selectedRow = vista.getTabla2Instrumentos().getSelectedRow();
            // Modificar los valores de la fila seleccionada
            vista.getTabla2Instrumentos().setValueAt(vista.getJtxtNumSerie().getText(), selectedRow, 0);
            vista.getTabla2Instrumentos().setValueAt(vista.getJtxtDescripcion().getText(), selectedRow, 1);
            vista.getTabla2Instrumentos().setValueAt(vista.getJtxtMinimo().getText(), selectedRow, 2);
            vista.getTabla2Instrumentos().setValueAt(vista.getJtxtMaximo().getText(), selectedRow, 3);
            vista.getTabla2Instrumentos().setValueAt(vista.getJtxtTolerancia().getText(), selectedRow, 4);

//            seleccion = (String) vista.getjCBTipoInstrumentos().getSelectedItem();
            seleccion_2 =  vista.getjCBTipoInstrumentos().getSelectedIndex();
            
            Instrumento p = new Instrumento(vista.getJtxtNumSerie().getText(), vista.getJtxtDescripcion().getText(), vista.getJtxtMinimo().getText(), vista.getJtxtMaximo().getText(), vista.getJtxtTolerancia().getText(), modelo.getArrayTI().getElemento(seleccion_2));
           modelo.getArrayI().getArrayList().add(p);
//            modelo.insertarInstrumento(p);
        } else {
            // No se seleccionó ninguna fila, agregar un nuevo registro

            String serie = vista.getJtxtNumSerie().getText();
            String descripcion = vista.getJtxtDescripcion().getText();
            String minimo = vista.getJtxtMinimo().getText();
            String maximo = vista.getJtxtMaximo().getText();
            String tolerancia = vista.getJtxtTolerancia().getText();

            Object[] columna = new Object[modelo.getModeloInstrumento().getColumnCount()];

            columna[0] = serie;
            columna[1] = descripcion;
            columna[2] = minimo;
            columna[3] = maximo;
            columna[4] = tolerancia;

//            seleccion = (String) vista.getjCBTipoInstrumentos().getSelectedItem();
            
            seleccion_2 =  vista.getjCBTipoInstrumentos().getSelectedIndex();
            Instrumento p = new Instrumento(serie, descripcion, minimo, maximo, tolerancia, modelo.getArrayTI().getElemento(seleccion_2));
            modelo.getArrayI().getArrayList().add(p);
            
//            modelo.insertarInstrumento(p);
            
            
            
            modelo.getModeloInstrumento().addRow(columna);
            //vista.getModeloTabla2().addRow(columna);
            
            vista.getTabla2Instrumentos().setModel(modelo.getModeloInstrumento());

        }
    }

    public void limpiarInstrumento() {
        vista.getJtxtNumSerie().setText("");
        vista.getJtxtDescripcion().setText("");
        vista.getJtxtMinimo().setText("");
        vista.getJtxtMaximo().setText("");
        vista.getJtxtTolerancia().setText("");
        vista.getTabla2Instrumentos().clearSelection();
        vista.getBtnBorrarInstrumentos().setEnabled(false);
        vista.getJtxtNumSerie().setEnabled(true);
    }

    public void borrarInstrumento() {

        if (vista.getTabla2Instrumentos().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debes elegir la fila a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            int linea = vista.getTabla2Instrumentos().getSelectedRow();
            modelo.getModeloInstrumento().removeRow(linea);
            //vista.getModeloTabla2().removeRow(linea);
            vista.getBtnBorrarInstrumentos().setEnabled(false);
            vista.getJtxtNumSerie().setEnabled(true);
            vista.getJlblInfoInstrumento().setText("");

        }
    }

    public void clickTablaInstrumento(java.awt.event.MouseEvent evt) {
        Random random = new Random();
        int rangoMinimo = 01;
        int rangoMaximo = 10000;
        int numeroAutogenerado = random.nextInt(rangoMaximo - rangoMinimo + 1) + rangoMinimo;
        if (evt.getClickCount() == 1) { // Detectar un solo clic
            vista.getBtnBorrarInstrumentos().setEnabled(true);
            int selectedRow = vista.getTabla2Instrumentos().getSelectedRow();
            if (selectedRow >= 0) {
                String serie = (String) vista.getTabla2Instrumentos().getValueAt(selectedRow, 0);
                String descripcion = (String) vista.getTabla2Instrumentos().getValueAt(selectedRow, 1);
                String minimo = (String) vista.getTabla2Instrumentos().getValueAt(selectedRow, 2);
                String maximo = (String) vista.getTabla2Instrumentos().getValueAt(selectedRow, 3);
                String tolerancia = (String) vista.getTabla2Instrumentos().getValueAt(selectedRow, 4);
                vista.getJtxtNumSerie().setText(serie);
                vista.getJtxtDescripcion().setText(descripcion);
                vista.getJtxtMinimo().setText(minimo);
                vista.getJtxtMaximo().setText(maximo);
                vista.getJtxtTolerancia().setText(tolerancia);
                vista.getJlblInfoInstrumento().setText(serie + "-" + " " + descripcion + " " + "(" + minimo + "-" + maximo + " Grados Celcius" + ")");
                vista.getJtxtNumCalibracion().setText(String.valueOf(numeroAutogenerado));
            }

        }

    }

    public void buscarInstrumento() {

        String cadena;
        boolean bandera;
        bandera = false;

        for (int i = 0; i < vista.getTabla2Instrumentos().getRowCount(); i++) {
            cadena = (String) vista.getTabla2Instrumentos().getValueAt(i, 1);

            if (cadena.equals(vista.getJtxtBusq_DescripcionInstrumentos().getText())) {
                vista.getTabla2Instrumentos().changeSelection(i, 0, false, false);
                vista.getJtxtBusq_DescripcionInstrumentos().setText("");
                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            JOptionPane.showMessageDialog(null, "Este registro no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            vista.getJtxtBusq_DescripcionInstrumentos().setText("");

        }
    }

    
    
    
    
    
    
    //---------------METODOS DE CALIBRACION--------------
//    public void guardarCalibracion() {
//
//        if (vista.getTabla3Calibraciones().getSelectedRow() >= 0) {
//            // Seleccionar una fila existente para editar
//            int selectedRow = vista.getTabla3Calibraciones().getSelectedRow();
//            // Modificar los valores de la fila seleccionada
//
//            vista.getTabla3Calibraciones().setValueAt(vista.getJtxtNumCalibracion(), selectedRow, 0);
//            vista.getTabla3Calibraciones().setValueAt(vista.getJtxtFecha().getText(), selectedRow, 1);
//            vista.getTabla3Calibraciones().setValueAt(vista.getJtxtMedicionesCalibracion().getText(), selectedRow, 2);
//
//        } else {
//            // No se seleccionó ninguna fila, agregar un nuevo registro
//            String numero = vista.getJtxtNumCalibracion().getText();
//            String mediciones = vista.getJtxtMedicionesCalibracion().getText();
//            String fecha = vista.getJtxtFecha().getText();
//            Object[] columna = new Object[vista.getModeloTabla3().getColumnCount()];
//            columna[0] = numero;
//            columna[1] = fecha;
//            columna[2] = mediciones;
//            vista.getModeloTabla3().addRow(columna);
//            vista.getTabla3Calibraciones().setModel(vista.getModeloTabla3());
//
//        }
//    }
//
//    public void limpiarCalibracion() {
//        vista.getJtxtNumCalibracion().setText("");
//        vista.getJtxtMedicionesCalibracion().setText("");
//        vista.getJtxtFecha().setText("");
//        vista.getJtxtNumBusqCalib().setText("");
//        vista.getTabla3Calibraciones().clearSelection();
//        vista.getBtnBorrarInstrumentos().setEnabled(false);
//        vista.getJtxtNumSerie().setEnabled(true);
//        DefaultTableModel modelo = (DefaultTableModel) vista.getTabla4Mediciones().getModel();
//        modelo.setRowCount(0);
//
//    }
//
//    public void borrarCalibracion() {
//
//        if (vista.getTabla3Calibraciones().getSelectedRow() == -1) {
//            JOptionPane.showMessageDialog(null, "Debes elegir la fila a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
//        } else {
//
//            int linea = vista.getTabla3Calibraciones().getSelectedRow();
//            vista.getModeloTabla3().removeRow(linea);
//            vista.getBtnBorrarCalibracion().setEnabled(false);
//            DefaultTableModel modelo = (DefaultTableModel) vista.getTabla4Mediciones().getModel();
//            modelo.setRowCount(0);
//        }
//    }
//
//    public void clickTablaCalibracion(java.awt.event.MouseEvent evt) {
//        String mediciones;
//        if (evt.getClickCount() == 1) { // Detectar un solo clic
//            vista.getBtnBorrarCalibracion().setEnabled(true);
//            vista.getTabla4Mediciones().setEnabled(true);
//            int selectedRow = vista.getTabla3Calibraciones().getSelectedRow();
//            if (selectedRow >= 0) {
//                String numero = (String) vista.getTabla3Calibraciones().getValueAt(selectedRow, 0);
//                String fecha = (String) vista.getTabla3Calibraciones().getValueAt(selectedRow, 1);
//                mediciones = String.valueOf(vista.getTabla3Calibraciones().getValueAt(selectedRow, 2));
//
//                vista.getJtxtNumCalibracion().setText(numero);
//                vista.getJtxtNumCalibracion().setEnabled(false);
//                vista.getJtxtFecha().setText(fecha);
//                vista.getJtxtFecha().setEnabled(false);
//                vista.getJtxtMedicionesCalibracion().setText(mediciones);
//                vista.getJtxtMedicionesCalibracion().setEnabled(false);
//                int med = Integer.parseInt(mediciones);
//                insertarTabla4(med);
//            }
//
//        }
//
//    }
//
//    public void insertarTabla4(int numMed) {
//        vista.getModeloTabla4().setRowCount(0);
//        for (int i = 0; i < numMed; i++) {
//            Object[] columna = new Object[vista.getModeloTabla4().getColumnCount()];
//            columna[0] = i + 1;
//            vista.getModeloTabla4().addRow(columna);
//        }
//        vista.getTabla4Mediciones().setModel(vista.getModeloTabla4());
//    }
//
//    public void buscarCalibracion() {
//
//        String cadena;
//        boolean bandera;
//        bandera = false;
//
//        for (int i = 0; i < vista.getTabla3Calibraciones().getRowCount(); i++) {
//            cadena = (String) vista.getTabla3Calibraciones().getValueAt(i, 0);
//
//            if (cadena.equals(vista.getJtxtNumBusqCalib().getText())) {
//                vista.getTabla3Calibraciones().changeSelection(i, 0, false, false);
//                vista.getJtxtNumBusqCalib().setText("");
//                bandera = true;
//                break;
//            }
//        }
//        if (bandera == false) {
//            JOptionPane.showMessageDialog(null, "Este registro no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
//            vista.getJtxtNumBusqCalib().setText("");
//
//        }
//    }
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

}