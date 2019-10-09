/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cadastroCliente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author david
 */
public class CadastroClienteController implements Initializable {

    @FXML
    private JFXTextField TextFieldID;
    @FXML
    private JFXTextField TextFieldNome;
    @FXML
    private JFXTextField TextFieldCPF;
    @FXML
    private JFXTextField TextFieldTelefone;
    @FXML
    private JFXTextField TextFieldRua;
    @FXML
    private JFXTextField TextFieldBairro;
    @FXML
    private JFXTextField TextFieldNumero;
    @FXML
    private JFXTextField TextFieldComplemento;
    @FXML
    private JFXButton ButtonAdicionar;
    @FXML
    private JFXButton ButtonGerenciar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AdicionarCliente(ActionEvent event) {
    }

    @FXML
    private void Gerenciar(ActionEvent event) {
    }
    
}
