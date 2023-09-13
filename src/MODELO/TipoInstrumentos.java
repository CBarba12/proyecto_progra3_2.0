/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.ArrayList;

/**
 *
 * @author Raquel
 */
public class TipoInstrumentos {
    private String codigoInstrumento;
    private String nombreInstrumento;
    private String unidadInstrumento;


    public TipoInstrumentos() {
            
    }

    public TipoInstrumentos(String codigoInstrumento, String nombreInstrumento, String unidadInstrumento) {
        this.codigoInstrumento = codigoInstrumento;
        this.nombreInstrumento = nombreInstrumento;
        this.unidadInstrumento = unidadInstrumento;   
    }

    public String getCodigoInstrumento() {
        return codigoInstrumento;
    }

    public void setCodigoInstrumento(String codigoInstrumento) {
        this.codigoInstrumento = codigoInstrumento;
    }

    public String getNombreInstrumento() {
        return nombreInstrumento;
    }

    public void setNombreInstrumento(String nombreInstrumento) {
        this.nombreInstrumento = nombreInstrumento;
    }

    public String getUnidadInstrumento() {
        return unidadInstrumento;
    }

    public void setUnidadInstrumento(String unidadInstrumento) {
        this.unidadInstrumento = unidadInstrumento;
    }
    

    
    
    
}
