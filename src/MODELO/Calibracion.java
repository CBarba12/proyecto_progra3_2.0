/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Raquel
 */
public class Calibracion {
    private String numero;
    private String fecha;
    private String mediciones;
    private Instrumento instrumento;
    

    public Calibracion() {
    }

    public Calibracion(String numero, String fecha, String mediciones) {
        this.numero = numero;
        this.fecha = fecha;
        this.mediciones = mediciones;
       // this.instrumento = instrumento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMediciones() {
        return mediciones;
    }

    public void setMediciones(String mediciones) {
        this.mediciones = mediciones;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public String toString() {
        return "Calibracion{" + "numero=" + numero + ", fecha=" + fecha + ", mediciones=" + mediciones + ", instrumento=" + instrumento + '}';
    }
    
    
    
}
