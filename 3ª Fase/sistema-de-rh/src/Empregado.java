
public interface Empregado {
	public static int BALCONISTA = 2;
	public static int GERENTE = 1;
	public static int VENDEDOR = 3;

	public String getCodigo();

	public String getNome();

	public double getSalario();

	public int getTipoEmpregado();

	public void setSalario(double salario);
}
