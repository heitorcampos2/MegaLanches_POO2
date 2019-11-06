/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cadastroCliente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dados.entidades.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import servicos.ClienteServico;

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
    //atributo para representar o servico
    private ClienteServico servico = new ClienteServico();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AdicionarCliente(ActionEvent event) {
        
        //pegando os dados do formulario
        Cliente a = new Cliente (TextFieldNome.getText(),TextFieldCPF.getText(),
                  TextFieldTelefone.getText(),TextFieldRua.getText(),
                  TextFieldComplemento.getText(),TextFieldBairro.getText(),
                  TextFieldNumero.getText());
        
        //mandar o ator para a camada de servicos
        
        servico.Adicionar(a);
        
        //Exibindo mensagem
        mensagem("Cliente salvo com sucesso!");
        //Limpando o form
        
       TextFieldNome.setText("");
       TextFieldCPF.setText("");
                  TextFieldTelefone.setText("");
                  TextFieldRua.setText("");
                  TextFieldComplemento.setText("");
                  TextFieldBairro.setText("");
                  TextFieldNumero.setText("");
    }
    
    public void mensagem(String m ){
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sucesso!"); //título
        alerta.setHeaderText(null); //cabeçalho (opcional)
        alerta.setContentText(m);// conteudo
        alerta.showAndWait(); //mostrando o alerta
    
    
    }

    @FXML
    private void Gerenciar(ActionEvent event) {
    }
    
}
