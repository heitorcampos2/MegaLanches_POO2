/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.fazPedido;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dados.entidades.Cliente;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.ClienteServico;
import servicos.FazPedidoServico;

/**
 * FXML Controller class
 *
 * @author HeiThor
 */
public class FazPedidoController implements Initializable {

    @FXML
    private JFXTextField textFieldPesquisar;
    @FXML
    private TableView<Cliente> tabela;
 //Atributo para representar o servico
    private FazPedidoServico servico = new FazPedidoServico();
    private ClienteServico ClienteServico = new ClienteServico();
    //private ProdutoServico ProdutoServico = new ProdutoServico();
    private ObservableList<Cliente> dados = 
            FXCollections.observableArrayList();
    //criando um atributo que vai armazenar o Cliente que foi selecionado na tabela
     private Cliente selecionado;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colNome;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //configurar tabela
        configurarTabela();
        //carregar a lista de Clientes na tabela
        listarClientesNaTabela();
    
    }    
    private void configurarTabela(){
        //dixer onde a coluna vai pegar o valor para
        //exibir, basta dizer o nome do metodo get que 
        //deve ser chamado para cada coluna
        //a String entre parenteses e o nome do 
       //atributo que vc deseja chamar o get (qause sempre)
        
        colId.setCellValueFactory(new PropertyValueFactory("id_cliente"));
        colNome.setCellValueFactory(new PropertyValueFactory("nome"));
        
    }//configurarTabela
    
     private void listarClientesNaTabela(){
        
        //limpar quaisquer dados anteriores
        
        dados.clear();
        //solicitando a camada de servoços a lista de Clientes
        List<Cliente> Cliente = ClienteServico.listar();
        
        //transformar a lista de Clientes no formato que a tabela
        //do javaFX aceita
        dados = FXCollections.observableArrayList(Cliente);
        //jogando os dados na tabela
        
        tabela.setItems(dados);
 
        }
    @FXML
    private void PesquisarCliente(ActionEvent event) {
           //limpar quaisquer dados anteriores
        
        dados.clear();
        //pegar nome da pessoa q deseja pesquisar
        String nome = textFieldPesquisar.getText();
        
        //solicitando a camada de serviços a lista de Clientes
        List<Cliente> Cliente = ClienteServico.listarPeloNomeCliente(nome);
        
        //transformar a lista de Clientes no formato que a tabela
        //do javaFX aceita
        dados = FXCollections.observableArrayList(Cliente);
        //jogando os dados na tabela
        
        tabela.setItems(dados);
    }

    
}
