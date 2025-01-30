public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        Funcionarios gerente = new Gerente("Alanis", 5500.20);
        Funcionarios dev = new Desenvolvedor("Lucas", 10000);
        Funcionarios funcionarioComum = new Funcionarios("Itallo", 3000);
        empresa.adicionarFuncionario(gerente);
        empresa.adicionarFuncionario(dev);
        empresa.adicionarFuncionario(funcionarioComum);
        empresa.exibirPagamentos();
    }
}