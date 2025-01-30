public class Funcionarios {

    public String nome;
    public double salario;

    public Funcionarios(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }


    public double calcularSalario() {
        return salario;
    }

}
