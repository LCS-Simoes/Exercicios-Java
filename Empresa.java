import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Funcionarios> funcionarios = new ArrayList<Funcionarios>();

    public void adicionarFuncionario(Funcionarios funcionario){
        funcionarios.add(funcionario);
    }

    public void exibirPagamentos(){
        System.out.println("~~~~~~~~~~~ FOLHA DE PAGAMENTO ~~~~~~~~~~~ ");
        for (Funcionarios funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - Salário R$" + funcionario.calcularSalario());
        }
    }
}
