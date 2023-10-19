
public class TestaRh {

	public static void main(String[] args) {

		Empregado thiago = new Funcionario("3251", "Thiago", Empregado.BALCONISTA);
		Empregado marcelo = new Funcionario("3282", "Marcelo", Empregado.GERENTE);
		Empregado matheus = new Funcionario("3174", "Matheus", Empregado.VENDEDOR);

		ControlePessoal recursosHumanos = new RecursosHumanos();

		// Contratação

		recursosHumanos.contratar(thiago);
		recursosHumanos.contratar(marcelo);
		recursosHumanos.contratar(matheus);

		// Salario Base

		System.out.println("------------------------");
		System.out.println("Salario inicial");
		System.out.println("------------------------\n");

		Folha fp = new FolhaPagamento(recursosHumanos);
		fp.adicionarSalarioInicialFuncionarios(2000);
		recursosHumanos.imprimirListaFuncionarios();

		// Aumento

		System.out.println("------------------------");
		System.out.println("Salario aumentado");
		System.out.println("------------------------\n");

		fp.aplicarAumentoEmpregados(25);
		recursosHumanos.imprimirListaFuncionarios();

		// Demissão

		System.out.println("------------------------");
		System.out.println("Após demissão");
		System.out.println("------------------------\n");

		recursosHumanos.demitir(matheus);
		recursosHumanos.imprimirListaFuncionarios();

	}

}
