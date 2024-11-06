package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {

    private String nombre;
    private Collection<Vehiculo> listaVehiculos;
    private Collection<Cliente> clientes;
    private Collection<Reserva> reservas;

    public Empresa(String nombre) {
        this.nombre = nombre;
        reservas = new LinkedList<>(); 
        listaVehiculos= new LinkedList<>();
        clientes= new LinkedList<>();
        
    }
    public Collection<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    public void setListaVehiculos(Collection<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Collection<Vehiculo> getVehiculos() {
        return listaVehiculos;
    }
    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }
    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + ", vehiculos=" + listaVehiculos + "]";
    }
    
    public Collection<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
   
    public void inicializarData(){
        Cliente cliente1 = new Cliente("Juan", "Perez");
        clientes.add(cliente1);

        cliente1= new Cliente("Pedro", "Nieto");
        clientes.add(cliente1);

    }

    public Collection<Vehiculo>obtenerListaVehiculo(){
        Auto auto = new Auto(26,2016,"Mazda",5,5,5); 
        listaVehiculos.add(auto);  
        return listaVehiculos;

    }
    public Collection<Reserva> obtenerListaReservas(){
        Reserva reserva = new Reserva(null, null, nombre, nombre, 0) ;
        reservas.add(reserva);  
        return reservas;

    }
    public Collection<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }
   
}
