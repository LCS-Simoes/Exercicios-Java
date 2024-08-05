public class Calculos {
    public String calculadora(String input) {
        try {
            // Dividir a entrada usando espaço como delimitador
            String[] tokens = input.split(" ");
            if (tokens.length == 3) {
                double num1 = Double.parseDouble(tokens[0]); // Passa o parâmetro para double
                String operador = tokens[1];
                double num2 = Double.parseDouble(tokens[2]); // Passa o parâmetro para double
                return Operadores(num1, operador, num2);
            } else {
                return "[ERRO] Entrada inválida";
            }

        } catch (NumberFormatException e) {
            return "[ERRO] número inválido";
        } catch (Exception erro) {
            return "Erro: " + erro.getMessage();
        }
    }

    private String Operadores(double num1, String operador, double num2) {
        switch (operador) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            case "/":
                if (num2 == 0) {
                    return "[ERRO] Impossível dividir por zero";
                }
                return String.valueOf(num1 / num2);
            default:
                return "[ERRO] Operador inválido";
        }
    }
}
