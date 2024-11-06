package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.VehiculoController;
import co.edu.uniquindio.poo.model.Caja;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReservaViewController {
    App app;
    private VehiculoController vehiculoController;
    private ObservableList<Reserva> reservaslList = FXCollections.observableArrayList();

    // Constructor
    Reserva selectedReserva;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="columnModelo"
    private TableColumn<Vehiculo, String> columnModelo; // Value injected by FXMLLoader

    @FXML // fx:id="btnReservar"
    private Button btnReservar; // Value injected by FXMLLoader

    @FXML // fx:id="columnNombreC"
    private TableColumn<Cliente, String> columnNombreC; // Value injected by FXMLLoader

    @FXML // fx:id="btnLimpiar"
    private Button btnLimpiar; // Value injected by FXMLLoader

    @FXML // fx:id="columnNpuertas"
    private TableColumn<Vehiculo,String> columnNpuertas; // Value injected by FXMLLoader

    @FXML // fx:id="labelCostoTotal"
    private Label labelCostoTotal; // Value injected by FXMLLoader

    @FXML // fx:id="columnMatricula"
    private TableColumn<Vehiculo, String> columnMatricula; // Value injected by FXMLLoader

    @FXML // fx:id="tblListVehiculo"
    private TableView<?> tblListVehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="comboVehiculos"
    private ComboBox<String> comboVehiculos; // Cambiado a String

    @FXML // fx:id="btnCalcularCosto"
    private Button btnCalcularCosto; // Value injected by FXMLLoader

    @FXML // fx:id="btnFechaFin"
    private DatePicker btnFechaFin; // Value injected by FXMLLoader
    
    @FXML // fx:id="columnDias"
    private TableColumn<?, ?> columnDias; // Value injected by FXMLLoader

    @FXML // fx:id="columnTransmision"
    private TableColumn<Caja,Caja> columnTransmision; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminar"
    private Button btnEliminar; // Value injected by FXMLLoader

    @FXML // fx:id="lblCostoTotal"
    private Label lblCostoTotal; // Value injected by FXMLLoader

    @FXML // fx:id="btnFechaInicio"
    private DatePicker btnFechaInicio; // Value injected by FXMLLoader

    @FXML // fx:id="columnVehiculo"
    private TableColumn<Vehiculo, String> columnVehiculo; // Value injected by FXMLLoader

    @FXML // fx:id="comboClientes"
    private ComboBox<String> comboClientes; // Cambiado a String

    @FXML // fx:id="columnMarca"
    private TableColumn<Vehiculo,String> columnMarca; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizar"
    private Button btnActualizar; // Value injected by FXMLLoader
        private List<Reserva> reservas;
                private TableView<?> tablaReservas;
            
                @FXML
                void agregarReservaAction(ActionEvent event) {
                    // Lógica para agregar la reserva
                    String clienteSeleccionado = comboClientes.getValue();
                    String vehiculoSeleccionado = comboVehiculos.getValue();
                    LocalDate fechaInicio = btnFechaInicio.getValue();
                    LocalDate fechaFin = btnFechaFin.getValue();
            
                    if (clienteSeleccionado == null || vehiculoSeleccionado == null || fechaInicio == null || fechaFin == null) {
                        System.out.println("Por favor, complete todos los campos.");
                        return;
                    }
            
                    // Aquí debes calcular el costo de la reserva basado en el vehículo seleccionado
                    double costo = calcularCosto(vehiculoSeleccionado, fechaInicio, fechaFin);
            
                    // Crear nueva reserva
                    Reserva nuevaReserva = new Reserva(fechaInicio, fechaFin, clienteSeleccionado, vehiculoSeleccionado, costo);
                    App.empresa.agregarReserva(nuevaReserva);
            
                    // Cargar reservas en la tabla
                    cargarReservasEnTabla();
                }
            
                private double calcularCosto(String vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
                    long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
                    double costoPorDia = 50.0; 
                    return dias * costoPorDia;
                }
            
                @FXML
                void actualizarVehiculoAction(ActionEvent event) {
                    // Lógica para actualizar el vehículo, si es necesario
                }
            
                @FXML
                void onCalcularCosto(ActionEvent event) {
                    // Lógica para calcular el costo y mostrarlo en lblCostoTotal
                    String vehiculoSeleccionado = comboVehiculos.getValue();
                    LocalDate fechaInicio = btnFechaInicio.getValue();
                    LocalDate fechaFin = btnFechaFin.getValue();
            
                    if (vehiculoSeleccionado != null && fechaInicio != null && fechaFin != null) {
                        double costo = calcularCosto(vehiculoSeleccionado, fechaInicio, fechaFin);
                        lblCostoTotal.setText(String.format("Costo Total: $%.2f", costo));
                    } else {
                        lblCostoTotal.setText("Por favor, complete todos los campos.");
                    }
                }
            
                @FXML
                void onLimpiar(ActionEvent event) {
                    // Lógica para limpiar los campos
                    comboClientes.getSelectionModel().clearSelection();
                    comboVehiculos.getSelectionModel().clearSelection();
                    btnFechaInicio.setValue(null);
                    btnFechaFin.setValue(null);
                    lblCostoTotal.setText("");
                }
            
                @FXML
                void onEliminar(ActionEvent event) {
                    // Obtén la reserva seleccionada de la tabla
                    Reserva reservaSeleccionada = (Reserva) tablaReservas.getSelectionModel().getSelectedItem();
    
            
            if (reservaSeleccionada != null) {
                reservas.remove(reservaSeleccionada);
        }
    }

    // Método para cargar reservas en la tabla
    private void cargarReservasEnTabla() {
        // Lógica para cargar reservas en la tabla
    }

    @FXML
    void initialize() {
        
       
                inicializarComboClientes();
                inicializarComboVehiculos();
            }
        
          
        
            private void inicializarComboClientes() {
        // Lista de clientes 
        List<String> clientes = Arrays.asList("Juan perez", "Santi", "Joan", "Luz");
        comboClientes.getItems().addAll(clientes); 
    }

    private void inicializarComboVehiculos() {
        // Lista de vehículos 
        List<String> vehiculos = Arrays.asList("Toyota Corolla", "Honda Civic", "Ford Focus", "Chevrolet Spark");
        comboVehiculos.getItems().addAll(vehiculos); 
    }
     

    

    


    public void setApp(App app) {
        this.app = app;
    }
}