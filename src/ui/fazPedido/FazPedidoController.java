/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.fazPedido;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author david
 */
public class FazPedidoController implements Initializable {

    @FXML
    private ToggleGroup select;
    @FXML
    private JFXTextField textFieldBuscar;
    @FXML
    private JFXButton buttonFazPedido;
    @FXML
    private JFXButton ButtonPesquisar;
    @FXML
    private JFXButton ButtonPesquisar1;
    @FXML
    private JFXTextField textFieldBuscar1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void FazerPedido(ActionEvent event) {
    }

    @FXML
    private void pesquisar(ActionEvent event) {
    }
    
}
