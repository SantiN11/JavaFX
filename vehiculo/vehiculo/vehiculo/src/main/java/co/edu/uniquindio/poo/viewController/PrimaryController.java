package co.edu.uniquindio.poo.viewController;

 import java.net.URL;
 import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 
 public class PrimaryController {
      App app;
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
    
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="primaryButton"
     private Button primaryButton; // Value injected by FXMLLoader
 
     @FXML
     void onOpenCrudReserva(ActionEvent event) {
        app.onOpenCrudReserva();
     }
 

    public void setApp(App app) {
    this.app = app;
    }

    @FXML
    void initialize() {

  }
 }
 
