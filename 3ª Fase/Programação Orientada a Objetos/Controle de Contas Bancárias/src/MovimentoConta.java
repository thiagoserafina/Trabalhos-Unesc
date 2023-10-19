
public class MovimentoConta {
	private Conta[] contas;

	public MovimentoConta(Conta[] contas) {		
		this.contas = contas;
	}

	public void MovimentaConta() {
		for (int i = 0; i < 3; i++) {
			contas[i].credita(200.0);
		}
	}

	public void imprimirSaldoContas() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Numero da Conta: "+contas[i].getNumeroConta()+"\nSaldo: "+contas[i].getSaldo()+"\n");
		} 
	}
}
