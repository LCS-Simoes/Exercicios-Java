import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Design extends Application {
    protected TextField tela;
    protected Calculos calculos; // Instância da classe Calculos

    @Override
    public void start(Stage primaryStage) {
        calculos = new Calculos(); // Inicializa a instância de Calculos
        tela = new TextField();
        tela.setEditable(false);

        // Criando o design
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(7.5);
        grid.setHgap(7.5);

        // Adicionando os botões
        String[] botoesLabel = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        int i = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                Button botao = new Button(botoesLabel[i]);
                botao.setMinSize(60, 60);
                botao.setOnAction(e -> handleButtonClick(botao.getText()));
                grid.add(botao, k, j);
                i++;
            }
        }

        grid.add(tela, 0, 4, 4, 1);

        // Configurando cena
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para cliques
    private void handleButtonClick(String value) {
        switch (value) {
            case "C":
                tela.clear(); // Limpa a tela
                break;
            case "=":
                String input = tela.getText().trim(); // Remove espaços em branco
                String result = calculos.calculadora(input); // Chama a calculadora
                tela.setText(result); // Exibe o resultado na tela
                break;
            default:
                tela.appendText(value + " "); // Mostra o valor na tela
                break;
        }
    }
}
