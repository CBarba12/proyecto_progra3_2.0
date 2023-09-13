/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Raquel
 */
public class Instrumento {
    private String serie;
    private String descripcion;
    private String maximo;
    private String minimo;
    private String tolerancia;
    private TipoInstrumentos tipo;

    public Instrumento() {
    }

    public Instrumento(String serie, String descripcion, String maximo, String minimo, String tolerancia, TipoInstrumentos tipo) {
        this.serie = serie;
        this.descripcion = descripcion;
        this.maximo = maximo;
        this.minimo = minimo;
        this.tolerancia = tolerancia;
        this.tipo = tipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaximo() {
        return maximo;
    }

    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    public String getMinimo() {
        return minimo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    public String getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(String tolerancia) {
        this.tolerancia = tolerancia;
    }

    public TipoInstrumentos getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstrumentos tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Instrumento{" + "serie=" + serie + ", descripcion=" + descripcion + ", maximo=" + maximo + ", minimo=" + minimo + ", tolerancia=" + tolerancia + ", tipo=" + tipo + '}';
    }
    
    
    
}
