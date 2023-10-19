
public class FolhaPagamento implements Folha {
	private ControlePessoal controlePessoal;

	public FolhaPagamento(ControlePessoal controlePessoal) {
		this.controlePessoal = controlePessoal;
	}

	@Override
	public void adicionarSalarioInicialFuncionarios(double salarioBase) {

		Empregado[] empregados = controlePessoal.getListaEmpregados();

		for (int i = 0; i < empregados.length; i++) {
			if (empregados[i].getTipoEmpregado() == Empregado.BALCONISTA) {
				empregados[i].setSalario((salarioBase * 0.25) + salarioBase);
			} else if (empregados[i].getTipoEmpregado() == Empregado.GERENTE) {
				empregados[i].setSalario((salarioBase * 0.45) + salarioBase);
			} else if (empregados[i].getTipoEmpregado() == Empregado.VENDEDOR) {
				empregados[i].setSalario((salarioBase * 0.35) + salarioBase);
			}
		}
	}

	@Override
	public void aplicarAumentoEmpregados(double percentual) {
		Empregado[] empregados = controlePessoal.getListaEmpregados();
		
		for (int i = 0; i < empregados.length; i++) {
			double salario = empregados[i].getSalario();
			empregados[i].setSalario((salario * (percentual / 100)) + salario);
		}
	}
}
