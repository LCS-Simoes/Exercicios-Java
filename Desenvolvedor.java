public class Desenvolvedor extends Funcionarios{

    public Desenvolvedor(String nome, double salario){
        super(nome, salario);
    }

    @Override
    public double calcularSalario(){
        return salario * 1.10;
    }


}
