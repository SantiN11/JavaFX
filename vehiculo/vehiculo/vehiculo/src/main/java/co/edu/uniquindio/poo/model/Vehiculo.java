package co.edu.uniquindio.poo.model;

import java.util.Collection;

public abstract class Vehiculo {
    public int numeroDeMatricula;
    public int modelo;
    public String marca;
    public int añoDeFabricacion;
    public int precioBase;
    

    public Vehiculo(int numeroDeMatricula, int modelo, String marca, int añoDeFabricacion,  int precioBase){
        this.numeroDeMatricula= numeroDeMatricula;
        this.modelo=modelo;
        this.marca=marca;
        this.añoDeFabricacion=añoDeFabricacion;
        this.precioBase=precioBase;
    }
    public int getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }
    
    public int getNumeroDeMatricula() {
        return numeroDeMatricula;
    }
    public void setNumeroDeMatricula(int numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }
    public int getModelo() {
        return modelo;
    }
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAñoDeFabricacion() {
        return añoDeFabricacion;
    }
    public void setAñoDeFabricacion(int añoDeFabricacion) {
        this.añoDeFabricacion = añoDeFabricacion;
    }
    public abstract double calculoDecostoReserva();
    
    @Override
    public String toString() {
        return "vehiculo [numeroDeMatricula=" + numeroDeMatricula + ", modelo=" + modelo + ", marca=" + marca
                + ", añoDeFabricacion=" + añoDeFabricacion + ", diasReserva=" + ", precioBase="
                + precioBase + "]";
    }
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}