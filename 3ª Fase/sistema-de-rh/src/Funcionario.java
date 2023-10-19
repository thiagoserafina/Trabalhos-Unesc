
public class Funcionario implements Empregado {

	private String codigo;
	private String nome;
	private double salario;
	private int tipoEmpregado;

	public Funcionario(String codigo, String nome, int tipoEmpregado) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipoEmpregado = tipoEmpregado;
	}

	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public double getSalario() {
		return salario;
	}

	@Override
	public int getTipoEmpregado() {
		return tipoEmpregado;
	}

	@Override
	public void setSalario(double salario) {
		this.salario = salario;
	}

}
