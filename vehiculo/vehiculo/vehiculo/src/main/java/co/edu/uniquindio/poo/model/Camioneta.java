package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo  {
    
    private double capacidadDeCarga;
    private int diasReserva;

   
    public Camioneta(int numeroDeMatricula, int modelo, String marca, int añoDeFabricacion, int precioBase,
            double capacidadDeCarga, int diasReserva) {
        super(numeroDeMatricula, modelo, marca, añoDeFabricacion, precioBase);
        this.capacidadDeCarga = capacidadDeCarga;
        this.diasReserva = diasReserva;
    }
    public double getCapacidadDeCarga() {
        return capacidadDeCarga;
    }
    public void setCapacidadDeCarga(double capacidadDeCarga) {
        this.capacidadDeCarga = capacidadDeCarga;
    }

    @Override
    public double calculoDecostoReserva(){
        double calculoDecostoReserva;
        if(capacidadDeCarga<=10){
            calculoDecostoReserva= precioBase+(precioBase*0.1)*diasReserva;
        }else{
            if(capacidadDeCarga>10 && capacidadDeCarga <=15){
                calculoDecostoReserva= precioBase+(precioBase*0.2)*diasReserva;
            }else{
                if(capacidadDeCarga>15){
                    calculoDecostoReserva= precioBase+(precioBase*0.3)*diasReserva;
                }else{
                    calculoDecostoReserva= precioBase*diasReserva;
                }
            }
        }
        return calculoDecostoReserva;
    }
}
