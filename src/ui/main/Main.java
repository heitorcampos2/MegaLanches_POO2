package ui.main;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.JPAUtil;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        JPAUtil.getGerenciador();
        Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));

        Scene scene = new Scene(root);
        //icone na janela
        stage.getIcons().add(new Image("ui/imagens/icones-02.png"));

        //Abrir maximizado
        stage.setMaximized(true);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
