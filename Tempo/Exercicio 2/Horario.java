import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label; 
import java.util.Date;
import java.util.Calendar;

public class Horario extends Application {
    @Override
    public void start(Stage primaryStage){
        // Interface com elementos
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        String imagemPath = "";
        Date dataHoraAtual = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataHoraAtual);
        int hora = cal.get(Calendar.HOUR_OF_DAY);

        Label lblMensagem = new Label(); // Cria um Label para exibir a mensagem

        if(hora >= 0 && hora < 12){
            imagemPath = "./images/manha.jpg";
            lblMensagem.setText("Bom dia, são: " + hora + " horas"); // Define a mensagem de bom dia
        } else if (hora >= 12 && hora < 18){
            imagemPath = "./images/tarde.jpg";
            lblMensagem.setText("Boa tarde, são: " + hora + " horas"); 
        } else {
            imagemPath = "./images/noite.jpg";
            lblMensagem.setText("Boa noite, são: " + hora + " horas"); 
        }

        // Criando e configurando a ImageView para exibir a imagem
        Image imagem = new Image(imagemPath);
        ImageView imageView = new ImageView(imagem);

        // Redimensionando a imagem para ajustar dentro do ImageView
        imageView.setFitWidth(300); // Defina a largura desejada
        imageView.setFitHeight(200); // Defina a altura desejada
        imageView.setPreserveRatio(false); // Mantém a proporção da imagem ou não.

        // Adicionando os elementos ao VBox
        root.getChildren().add(imageView);
        root.getChildren().add(lblMensagem);

        // Criando a cena e mostrando a janela
        Scene scene = new Scene(root, 400, 300); // Defina o tamanho da cena conforme necessário
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exemplo de Mudança de Imagem com Horário");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
