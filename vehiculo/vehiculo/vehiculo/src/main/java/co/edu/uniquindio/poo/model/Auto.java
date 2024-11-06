package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {

    private int numeroDePuertas;
    
    public Auto (int numeroDeMatricula, int modelo, String marca, int añoDeFabricacion,  int numeroDePuertas, int precioBase){
        super(numeroDeMatricula, modelo, marca, añoDeFabricacion, precioBase);
        this.numeroDePuertas=numeroDePuertas;
    }
    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }
    public void setNumeroDePuertas(int numeroDePuertas) {
        this.numeroDePuertas = numeroDePuertas;
    }
    @Override
    public double calculoDecostoReserva() {
        // TODO Auto-generated method stub
        return 0;
    }
   

}
