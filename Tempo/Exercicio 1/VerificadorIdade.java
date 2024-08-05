import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class VerificadorIdade extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Interface com os elementos gráficos
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        Label lblAno = new Label("Ano de Nascimento:");
        TextField txtAno = new TextField();
        Label lblSexo = new Label("Sexo:");
        ToggleGroup grupoSexo = new ToggleGroup();
        RadioButton radHomem = new RadioButton("Homem");
        radHomem.setToggleGroup(grupoSexo);
        RadioButton radMulher = new RadioButton("Mulher");
        radMulher.setToggleGroup(grupoSexo);

        Button btnVerificar = new Button("Verificar");
        Label lblResultado = new Label();

        btnVerificar.setOnAction(event -> {
            String textoAno = txtAno.getText();
            if (!textoAno.isEmpty() && textoAno.matches("\\d{4}")) {
                int anoAtual = LocalDate.now().getYear();
                int anoNascimento = Integer.parseInt(textoAno);
                int idade = anoAtual - anoNascimento;

                if (idade >= 0) {
                    String genero = "";
                    String imagemPath = "";

                    if (radHomem.isSelected()) {
                        genero = "Homem";
                        if (idade < 10) {
                            imagemPath = "./images/Bebe1.jpg";
                        } else if (idade < 21) {
                            imagemPath = "./images/HomemJovem.jpg";
                        } else if (idade < 50) {
                            imagemPath = "./images/AdultoMasc.jpg";
                        } else {
                            imagemPath = "./images/Idoso.jpg";
                        }
                    } else if (radMulher.isSelected()) {
                        genero = "Mulher";
                        if (idade < 10) {
                            imagemPath = "./images/Bebe2.jpg";
                        } else if (idade < 21) {
                            imagemPath = "./images/JovemMulher.jpg";
                        } else if (idade < 50) {
                            imagemPath = "./images/Adulta.jpg";
                        } else {
                            imagemPath = "./images/Idosa.jpg";
                        }
                    }

                    lblResultado.setText(String.format("Detectamos que você é um(a) %s com idade de %d anos.", genero, idade));

                    Image imagem = new Image(imagemPath);
                    ImageView imageView = new ImageView(imagem);
                    root.getChildren().add(imageView);
                } else {
                    lblResultado.setText("[ERRO] Verifique os dados e tente novamente!");
                }
            } else {
                lblResultado.setText("[ERRO] Verifique os dados e tente novamente!");
            }
        });

        root.getChildren().addAll(lblAno, txtAno, lblSexo, radHomem, radMulher, btnVerificar, lblResultado);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Verificador de Idade");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}