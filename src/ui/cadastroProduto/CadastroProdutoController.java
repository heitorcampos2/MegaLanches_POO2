/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cadastroProduto;

import com.jfoenix.controls.JFXTextArea;
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
public class CadastroProdutoController implements Initializable {

    @FXML
    private JFXTextField TextFieldNomeProduto;
    @FXML
    private JFXTextField TextFieldPrecoProduto;
    @FXML
    private JFXTextArea TextAreaIngredientes;
    @FXML
    private JFXTextField TextFieldID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ButtonAdicionar(ActionEvent event) {
    }

    @FXML
    private void Buttongerenciar(ActionEvent event) {
    }
    
}
