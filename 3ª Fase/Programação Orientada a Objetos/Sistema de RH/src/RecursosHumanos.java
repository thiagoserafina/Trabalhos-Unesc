import java.util.ArrayList;

public class RecursosHumanos implements ControlePessoal {

	private ArrayList<Empregado> empregadosList = new ArrayList<Empregado>();

	public RecursosHumanos() {

	}

	@Override
	public void contratar(Empregado empregado) {
		empregadosList.add(empregado);
	}

	@Override
	public void demitir(Empregado empregado) {
		empregadosList.remove(empregado);
	}

	@Override
	public Empregado[] getListaEmpregados() {
		Empregado[] empregado = new Empregado[empregadosList.size()];
		empregadosList.toArray(empregado);

		return empregado;
	}

	@Override
	public void imprimirListaFuncionarios() {
		Empregado[] empregados = getListaEmpregados();

		for (int i = 0; i < empregados.length; i++) {
			System.out.println("Código: " + empregados[i].getCodigo() + "\nNome: " + empregados[i].getNome()
					+ "\nSalário: R$" + empregados[i].getSalario() + "\n");
		}
	}
}
