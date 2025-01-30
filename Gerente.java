public class Gerente extends  Funcionarios {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularSalario() {
        return salario * 1.20;
    }
}
