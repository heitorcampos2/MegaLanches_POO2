package ui.cadastroProduto;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dados.entidades.Produto;
import java.math.BigDecimal;
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
import servicos.ProdutoServico;

public class CadastroProdutoController implements Initializable {

    @FXML
    private JFXTextField TextFieldNomeProduto;
    @FXML
    private JFXTextField TextFieldPrecoProduto;
    @FXML
    private JFXTextArea TextAreaIngredientes;
    @FXML
    private JFXTextField TextFieldID;
    //Atributo para representar o servico
    private ProdutoServico servico = new ProdutoServico();
    @FXML
    private TableView<Produto> tabela;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colProduto;
    @FXML
    private TableColumn colValor;
    @FXML
    private TableColumn colIngredientes;

    //atributo que representa os dados para a tabela
    private ObservableList<Produto> dados
            = FXCollections.observableArrayList();
    //criando um atributo que vai armazenar o Produto que foi selecionado na tabela
    private Produto selecionado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //configurar tabela
        configurarTabela();
        //carregar a lista de Produtos na tabela
        listarProdutosNaTabela();

    }

    @FXML
    private void adicionar(ActionEvent event) {

        //verificar se está vazio
        if (TextFieldID.getText().isEmpty()) {//inserindo
            //Pega os dados do fomulário
            //e cria um objeto Produto

            //pegando os dados do formulario
            Produto a = new Produto(TextFieldNomeProduto.getText(),
                    new BigDecimal(TextFieldPrecoProduto.getText()), TextAreaIngredientes.getText());

            //mandar o Produto para a camada de servicos
            servico.adicionar(a);

            //chama o metodo para atualizar a tabela
            listarProdutosNaTabela();

            //Exibindo mensagem
            mensagem("Produto salvo com sucesso!");

            //Limpando o formulario
            TextFieldNomeProduto.setText("");
            TextFieldPrecoProduto.setText("");
            TextAreaIngredientes.setText("");
        } else {
            //atualizando o Produto

            //pegando a resposta da confirmação do usuario
            Optional<ButtonType> btn
                    = mensagemDeConfirmacao("Deseja mesmo salvar as alterações?", "EDITAR");
            //se o botão OK foi pressionado
            if (btn.get() == ButtonType.OK) {
                //pegar os novos dados do frmulario e atualizar o meu produto
                selecionado.setNome_p(TextFieldNomeProduto.getText());
                selecionado.setPreco_un(new BigDecimal(TextFieldPrecoProduto.getText()));
                selecionado.setIngredientes(TextAreaIngredientes.getText());

                //mandando para a camada de servico salvar as alterações
                servico.editar(selecionado);

                //chama o metodo para atualizar a tabela
                listarProdutosNaTabela();

                //exibir mensagem
                mensagem("Produto atualizado com sucesso.");

                //Limpando o formulario
                TextFieldID.setText("");
                TextFieldNomeProduto.setText("");
                TextFieldPrecoProduto.setText("");
                TextAreaIngredientes.setText("");

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

        colId.setCellValueFactory(new PropertyValueFactory("id_produto"));
        colProduto.setCellValueFactory(new PropertyValueFactory("nome_p"));
        colValor.setCellValueFactory(new PropertyValueFactory("preco_un"));
        colIngredientes.setCellValueFactory(new PropertyValueFactory("ingredientes"));

    }//configurarTabela

    //responsavel por carregar a lista de Produtos na tabela
    private void listarProdutosNaTabela() {

        //limpar quaisquer dados anteriores
        dados.clear();
        //solicitando a camada de servoços a lista de Produtos
        List<Produto> Produto = servico.listarProdutosNaTabela();

        //transformar a lista de Produtos no formato que a tabela
        //do javaFX aceita
        dados = FXCollections.observableArrayList(Produto);
        //jogando os dados na tabela

        tabela.setItems(dados);

    }

    @FXML
    private void editar(ActionEvent event) {

        //pegar o produto que foi selecionado na tabela
        selecionado = tabela.getSelectionModel().getSelectedItem();

        //se tem algum produto selecionado
        if (selecionado != null) {//se tem produto selecionado
            //pegar os dados do produto e jogar nos campos do formulario
            TextFieldID.setText(String.valueOf(selecionado.getId_produto()));
            TextFieldNomeProduto.setText(String.valueOf(selecionado.getNome_p()));
            TextFieldPrecoProduto.setText(selecionado.getPreco_un().toString());

            TextAreaIngredientes.setText(selecionado.getIngredientes());

        } else {
            mensagemErro("Selecione um Produto.");

        }

    }

    @FXML
    private void excluir(ActionEvent event) {

        // pegar o Produto que foi selecionado na tabela
        selecionado = tabela.getSelectionModel().getSelectedItem();

        if (selecionado != null) {//existe produto selecionado

            //pegando resposta de confirmação do usuario
            Optional<ButtonType> btn
                    = mensagemDeConfirmacao("Deseja mesmo excluir o Produto?", "EXCLUIR");
            //se o botão OK foi pressionado
            if (btn.get() == ButtonType.OK) {
                //mandar para a camada de servico excluir
                servico.excluir(selecionado);

                //chama o metodo para atualizar a tabela
                listarProdutosNaTabela();

                //Exibindo mensagem
                mensagem("Produto excluido com sucesso!");

            } else {
                mensagemErro("Selecione um Produto.");

            }
        }
    }
}
