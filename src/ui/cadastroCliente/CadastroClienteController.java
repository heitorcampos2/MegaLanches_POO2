package ui.cadastroCliente;

import com.jfoenix.controls.JFXTextField;
import dados.entidades.Cliente;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.ClienteServico;

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

    //Atributo para representar o servico
    private ClienteServico servico = new ClienteServico();
    @FXML
    private TableView<Cliente> tabela;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colNome;
    @FXML
    private TableColumn colCpf;
    @FXML
    private TableColumn ColRua;
    @FXML
    private TableColumn ColNumero;
    @FXML
    private TableColumn colBairro;
    @FXML
    private TableColumn colComplemento;
    @FXML
    private TableColumn colTelefone;

    //atributo que representa os dados para a tabela
    private ObservableList<Cliente> dados
            = FXCollections.observableArrayList();
    //criando um atributo que vai armazenar o Cliente que foi selecionado na tabela
    private Cliente selecionado;

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

    @FXML
    private void adicionar(ActionEvent event) {

        //verificar se está vazio
        if (TextFieldID.getText().isEmpty()) {//inserindo
            //Pega os dados do fomulário
            //e cria um objeto Cliente

            //pegando os dados do formulario
            Cliente a = new Cliente(TextFieldNome.getText(),
                    TextFieldCPF.getText(), TextFieldTelefone.getText(),
                    TextFieldRua.getText(), TextFieldComplemento.getText(), TextFieldBairro.getText(),
                    TextFieldNumero.getText());

            //mandar o Cliente para a camada de servicos
            servico.adicionar(a);

            //chama o metodo para atualizar a tabela
            listarClientesNaTabela();

            //Exibindo mensagem
            mensagem("Cliente salvo com sucesso!");

            //Limpando o formulario
            TextFieldID.setText("");
            TextFieldNome.setText("");
            TextFieldCPF.setText("");
            TextFieldTelefone.setText("");
            TextFieldRua.setText("");
            TextFieldBairro.setText("");
            TextFieldNumero.setText("");
            TextFieldComplemento.setText("");

        } else {
            //atualizando o Cliente

            //pegando a resposta da confirmação do usuario
            Optional<ButtonType> btn
                    = mensagemDeConfirmacao("Deseja mesmo salvar as alterações?", "EDITAR");
            //se o botão OK foi pressionado
            if (btn.get() == ButtonType.OK) {
                //pegar os novos dados do frmulario e atualizar o meu cliente
                selecionado.setNome(TextFieldNome.getText());
                selecionado.setCpf(TextFieldCPF.getText());
                selecionado.setRua(TextFieldRua.getText());
                selecionado.setNumero(TextFieldNumero.getText());
                selecionado.setBairro(TextFieldBairro.getText());
                selecionado.setComplemento(TextFieldComplemento.getText());
                selecionado.setTelefone(TextFieldTelefone.getText());

                //mandando para a camada de servico salvar as alterações
                servico.editar(selecionado);

                //chama o metodo para atualizar a tabela
                listarClientesNaTabela();

                //exibir mensagem
                mensagem("Cliente atualizado com sucesso.");

                //Limpando o formulario
                TextFieldID.setText("");
                TextFieldNome.setText("");
                TextFieldCPF.setText("");
                TextFieldTelefone.setText("");
                TextFieldRua.setText("");
                TextFieldBairro.setText("");
                TextFieldNumero.setText("");
                TextFieldComplemento.setText("");

            }
        }
    }

    public void mensagem(String m) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sucesso!"); //título
        alerta.setHeaderText(null); //cabeçalho (opcional)
        alerta.setContentText(m);// conteudo
        alerta.showAndWait(); //mostrando o alerta

    }

    //exibe uma mensagem de erro
    public void mensagemErro(String m) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("SUCESSO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }

    //exibe uma mensagem de confirmação
    private Optional<ButtonType> mensagemDeConfirmacao(String mensagem, String titulo) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);

        return alerta.showAndWait();
    }

    //fazendo configuração das colunas da tabela
    private void configurarTabela() {
        //dixer onde a coluna vai pegar o valor para
        //exibir, basta dizer o nome do metodo get que 
        //deve ser chamado para cada coluna
        //a String entre parenteses e o nome do 
        //atributo que vc deseja chamar o get (qause sempre)

        colId.setCellValueFactory(new PropertyValueFactory("id_cliente"));
        colNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        ColRua.setCellValueFactory(new PropertyValueFactory("rua"));
        ColNumero.setCellValueFactory(new PropertyValueFactory("numero"));
        colBairro.setCellValueFactory(new PropertyValueFactory("bairro"));
        colComplemento.setCellValueFactory(new PropertyValueFactory("complemento"));
        colTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));

    }//configurarTabela

    //responsavel por carregar a lista de Clientes na tabela
    private void listarClientesNaTabela() {

        //limpar quaisquer dados anteriores
        dados.clear();
        //solicitando a camada de servoços a lista de Clientes
        List<Cliente> Cliente = servico.listar();

        //transformar a lista de Clientes no formato que a tabela
        //do javaFX aceita
        dados = FXCollections.observableArrayList(Cliente);
        //jogando os dados na tabela

        tabela.setItems(dados);

    }

    @FXML
    private void editar(ActionEvent event) {

        //pegar o cliente que foi selecionado na tabela
        selecionado = tabela.getSelectionModel().getSelectedItem();

        //se tem algum cliente selecionado
        if (selecionado != null) {//se tem cliente selecionado
            //pegar os dados do cliente e jogar nos campos do formulario         
            TextFieldID.setText(String.valueOf(selecionado.getId_cliente()));
            TextFieldNome.setText(String.valueOf(selecionado.getNome()));
            TextFieldCPF.setText(String.valueOf(selecionado.getCpf()));
            TextFieldRua.setText(String.valueOf(selecionado.getRua()));
            TextFieldNumero.setText(String.valueOf(selecionado.getNumero()));
            TextFieldBairro.setText(String.valueOf(selecionado.getBairro()));
            TextFieldComplemento.setText(String.valueOf(selecionado.getComplemento()));
            TextFieldTelefone.setText(String.valueOf(selecionado.getTelefone()));

        } else {
            mensagemErro("Selecione um Cliente.");

        }

    }

    @FXML
    private void excluir(ActionEvent event) {

        // pegar o Cliente que foi selecionado na tabela
        selecionado = tabela.getSelectionModel().getSelectedItem();

        if (selecionado != null) {//existe cliente selecionado

            //pegando resposta de confirmação do usuario
            Optional<ButtonType> btn
                    = mensagemDeConfirmacao("Deseja mesmo remover o Cliente?", "EXCLUIR");
            //se o botão OK foi pressionado
            if (btn.get() == ButtonType.OK) {
                //mandar para a camada de servico excluir
                servico.excluir(selecionado);

                //chama o metodo para atualizar a tabela
                listarClientesNaTabela();

                //Exibindo mensagem
                mensagem("Cliente removido com sucesso!");

            }
        } else {
                mensagemErro("Selecione um Cliente.");

            }
    }
}
