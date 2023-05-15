/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casasrurales;

/**
 *
 * @author Gonza
 */
public class casaRurales {
    private String poblacion;
    private int numHabitacion;
    private String direccion;
    private double precio;
    private int codigo;
    private boolean esAlta;

    
    
    
    
    public casaRurales(String poblacion, int numHabitacion, String direccion, double precio, int codigo) {
        this.poblacion = poblacion;
        this.numHabitacion = numHabitacion;
        this.direccion = direccion;
        this.precio = precio;
        this.codigo = codigo;
        esAlta=true;
    }
    
    public boolean getEsAlta() {
        return esAlta;
    }

    public void setEsAlta(boolean esAlta) {
        this.esAlta = esAlta;
    }
    
    public int aCodigo(){
    return codigo;
    }
    
    
    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    
}
