
public class ContaCorrente implements Conta {
	private String numeroConta;
	private double saldo;

	public ContaCorrente(String numeroConta, double valor) {
		this.numeroConta = numeroConta;
		this.saldo = valor;
	}

	@Override
	public String getNumeroConta() {
		return numeroConta;
	}

	@Override
	public double getSaldo() {
		return saldo;
	}

	@Override
	public void credita(double valor) {
		saldo = valor + getSaldo();		
	}

	@Override
	public void debita(double valor) {
		saldo = valor - getSaldo();	
	}
}
