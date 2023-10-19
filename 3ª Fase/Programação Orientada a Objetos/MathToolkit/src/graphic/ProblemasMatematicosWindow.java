package graphic;

import lib.Operacoes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class ProblemasMatematicosWindow extends JFrame {
	private JPanel jPanel1;
		private JLabel label1_1;
		private JLabel label1_2;
		private JLabel label1_3;
		private JTextField txf1_1;
		private JTextField txf1_2;
		private JTextField txf1_3;
		private JButton btnCalcular1;

	private JPanel jPanel2;
		private JLabel label2_1;
		private JLabel label2_2;
		private JLabel label2_3;
		private JTextField txf2_1;
		private JTextField txf2_2;
		private JTextField txf2_3;
		private JButton btnCalcular2;

	private JPanel jPanel3;
		private JLabel label3_1;
		private JLabel label3_2;
		private JLabel label3_3;
		private JTextField txf3_1;
		private JTextField txf3_2;
		private JTextField txf3_3;
		private JButton btnCalcular3;

	private JPanel jPanel4;
		private JLabel label4_1;
		private JLabel label4_2;
		private JLabel label4_3;
		private JTextField txf4_1;
		private JTextField txf4_2;
		private JTextField txf4_3;
		private JButton btnCalcular4;

	private JPanel jPanel5;
		private JLabel label5_1;
		private JLabel label5_2;
		private JLabel label5_3;
		private JTextField txf5_1;
		private JTextField txf5_2;
		private JTextField txf5_3;
		private JButton btnCalcular5;

	private JPanel jPanel6;
		private JLabel label6_1;
		private JLabel label6_2;
		private JLabel label6_3;
		private JTextField txf6_1;
		private JTextField txf6_2;
		private JTextField txf6_3;
		private JButton btnCalcular6;

	private JPanel jPanel7;
		private JLabel label7_1;
		private JLabel label7_2;
		private JLabel label7_3;
		private JTextField txf7_1;
		private JTextField txf7_2;
		private JTextField txf7_3;
		private JButton btnCalcular7;

	private JPanel jPanel8;
		private JLabel label8_1;
		private JLabel label8_2;
		private JLabel label8_3;
		private JLabel label8_4;
		private JTextField txf8_1;
		private JTextField txf8_2;
		private JTextField txf8_3;
		private JTextField txf8_4;
		private JButton btnCalcular8;

	private JPanel jPanel9;
		private JLabel label9_1;
		private JLabel label9_2;
		private JLabel label9_3;
		private JLabel label9_4;
		private JLabel label9_5;
		private JTextField txfSenha;
		private JButton btnGerar;
		private JCheckBox chkUppercase;
		private JCheckBox chkLowercase;
		private JCheckBox chkNumbers;
		private JCheckBox chkSymbols;
		private JSpinner spnTamanho;

	public ProblemasMatematicosWindow() {
		setTitle("Math Toolkit");
		setSize(1200, 600);
		setLayout(null);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				fecharJanela();
			}
		});

		componentesCriar();
		setVisible(true);
	}

	private void componentesCriar() {
		jPanel1 = new JPanel();
		jPanel1.setLayout(null);
		jPanel1.setBounds(10, 10, 250, 150);
		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Aplicar desconto % num valor"));

			label1_1 = new JLabel("Valor inicial R$ (a)");
			label1_1.setBounds(10, 20, 130, 25);
			label1_1.setForeground(Color.red);
			jPanel1.add(label1_1);

			txf1_1 = new JTextField();
			txf1_1.setBounds(140, 20, 100, 25);
			jPanel1.add(txf1_1);

			label1_2 = new JLabel("% desconto (b)");
			label1_2.setBounds(10, 50, 130, 25);
			label1_2.setForeground(Color.blue);
			jPanel1.add(label1_2);

			txf1_2 = new JTextField();
			txf1_2.setBounds(140, 50, 100, 25);
			jPanel1.add(txf1_2);

			label1_3 = new JLabel("Resultado");
			label1_3.setBounds(10, 80, 130, 25);
			jPanel1.add(label1_3);

			txf1_3 = new JTextField();
			txf1_3.setBounds(140, 80, 100, 25);
			txf1_3.setEditable(false);
			jPanel1.add(txf1_3);

			btnCalcular1 = new JButton(new AbstractAction("Calcular") {

				@Override
				public void actionPerformed(ActionEvent e) {
					float res = 0;

					res = Operacoes.AplicaDesconto(Float.parseFloat(txf1_1.getText()),
							Float.parseFloat(txf1_2.getText()));
					txf1_3.setText("R$ " + Float.toString(res));
				}
			});

			btnCalcular1.setBounds(75, 110, 100, 25);
			jPanel1.add(btnCalcular1);

			getContentPane().add(jPanel1);

		jPanel2 = new JPanel();
		jPanel2.setLayout(null);
		jPanel2.setBounds(270, 10, 250, 150);
		jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Incrementar % a um valor"));

			label2_1 = new JLabel("Valor inicial R$ (a)");
			label2_1.setBounds(10, 20, 130, 25);
			label2_1.setForeground(Color.red);
			jPanel2.add(label2_1);

			txf2_1 = new JTextField();
			txf2_1.setBounds(140, 20, 100, 25);
			jPanel2.add(txf2_1);

			label2_2 = new JLabel("% acréscimo (b)");
			label2_2.setBounds(10, 50, 130, 25);
			label2_2.setForeground(Color.blue);
			jPanel2.add(label2_2);

			txf2_2 = new JTextField();
			txf2_2.setBounds(140, 50, 100, 25);
			jPanel2.add(txf2_2);

			label2_3 = new JLabel("Resultado");
			label2_3.setBounds(10, 80, 130, 25);
			jPanel2.add(label2_3);

			txf2_3 = new JTextField();
			txf2_3.setBounds(140, 80, 100, 25);
			txf2_3.setEditable(false);
			jPanel2.add(txf2_3);

			btnCalcular2 = new JButton(new AbstractAction("Calcular") {

				@Override
				public void actionPerformed(ActionEvent e) {
					float res = 0;

					res = Operacoes.AplicaAcrecimo(Float.parseFloat(txf2_1.getText()),
							Float.parseFloat(txf2_2.getText()));
					txf2_3.setText("R$ " + Float.toString(res));
				}
			});

			btnCalcular2.setBounds(75, 110, 100, 25);
			jPanel2.add(btnCalcular2);

			getContentPane().add(jPanel2);

		jPanel3 = new JPanel();
		jPanel3.setLayout(null);
		jPanel3.setBounds(530, 10, 325, 150);
		jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Amostragem - Quanto X% representa de Y"));

			label3_1 = new JLabel("Total (a)");
			label3_1.setBounds(50, 20, 130, 25);
			label3_1.setForeground(Color.red);
			jPanel3.add(label3_1);

			txf3_1 = new JTextField();
			txf3_1.setBounds(180, 20, 100, 25);
			jPanel3.add(txf3_1);

			label3_2 = new JLabel("Porcentagem (b)");
			label3_2.setBounds(50, 50, 130, 25);
			label3_2.setForeground(Color.blue);
			jPanel3.add(label3_2);

			txf3_2 = new JTextField();
			txf3_2.setBounds(180, 50, 100, 25);
			jPanel3.add(txf3_2);

			label3_3 = new JLabel("Corresponde a");
			label3_3.setBounds(50, 80, 130, 25);
			jPanel3.add(label3_3);

			txf3_3 = new JTextField();
			txf3_3.setBounds(180, 80, 100, 25);
			txf3_3.setEditable(false);
			jPanel3.add(txf3_3);

			btnCalcular3 = new JButton(new AbstractAction("Calcular") {

				@Override
				public void actionPerformed(ActionEvent e) {
					float res = 0;

					res = Operacoes.Amostragem(Float.parseFloat(txf3_1.getText()),
							Float.parseFloat(txf3_2.getText()));
					txf3_3.setText(Float.toString(res));
				}
			});

			btnCalcular3.setBounds(105, 110, 100, 25);
			jPanel3.add(btnCalcular3);

			getContentPane().add(jPanel3);

		jPanel4 = new JPanel();
		jPanel4.setLayout(null);
		jPanel4.setBounds(865, 10, 325, 150);
		jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Amostragem 2 - Quanto X representa de Y"));

			label4_1 = new JLabel("Total (a)");
			label4_1.setBounds(50, 20, 130, 25);
			label4_1.setForeground(Color.red);
			jPanel4.add(label4_1);

			txf4_1 = new JTextField();
			txf4_1.setBounds(180, 20, 100, 25);
			jPanel4.add(txf4_1);

			label4_2 = new JLabel("Parte (b)");
			label4_2.setBounds(50, 50, 130, 25);
			label4_2.setForeground(Color.blue);
			jPanel4.add(label4_2);

			txf4_2 = new JTextField();
			txf4_2.setBounds(180, 50, 100, 25);
			jPanel4.add(txf4_2);

			label4_3 = new JLabel("Corresponde a %");
			label4_3.setBounds(50, 80, 130, 25);
			jPanel4.add(label4_3);

			txf4_3 = new JTextField();
			txf4_3.setBounds(180, 80, 100, 25);
			txf4_3.setEditable(false);
			jPanel4.add(txf4_3);

			btnCalcular4 = new JButton(new AbstractAction("Calcular") {

				@Override
				public void actionPerformed(ActionEvent e) {
					float res = 0;

					res = Operacoes.Amostragem2(Float.parseFloat(txf4_1.getText()),
							Float.parseFloat(txf4_2.getText()));
					txf4_3.setText(Float.toString(res) + "%");
				}
			});

			btnCalcular4.setBounds(105, 110, 100, 25);
			jPanel4.add(btnCalcular4);

			getContentPane().add(jPanel4);

		jPanel5 = new JPanel();
		jPanel5.setLayout(null);
		jPanel5.setBounds(10, 170, 325, 150);
		jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Valor era A paguei B, qual foi o desconto%?"));

			label5_1 = new JLabel("Valor original (a)");
			label5_1.setBounds(30, 20, 150, 25);
			label5_1.setForeground(Color.red);
			jPanel5.add(label5_1);

			txf5_1 = new JTextField();
			txf5_1.setBounds(180, 20, 100, 25);
			jPanel5.add(txf5_1);

			label5_2 = new JLabel("Valor c/desconto (b)");
			label5_2.setBounds(30, 50, 150, 25);
			label5_2.setForeground(Color.blue);
			jPanel5.add(label5_2);

			txf5_2 = new JTextField();
			txf5_2.setBounds(180, 50, 100, 25);
			jPanel5.add(txf5_2);

			label5_3 = new JLabel("% Desconto");
			label5_3.setBounds(30, 80, 150, 25);
			jPanel5.add(label5_3);

			txf5_3 = new JTextField();
			txf5_3.setBounds(180, 80, 100, 25);
			txf5_3.setEditable(false);
			jPanel5.add(txf5_3);

			btnCalcular5 = new JButton(new AbstractAction("Calcular") {

				@Override
				public void actionPerformed(ActionEvent e) {
					float res = 0;

					res = Operacoes.DescontoAplicado(Float.parseFloat(txf5_1.getText()),
							Float.parseFloat(txf5_2.getText()));
					txf5_3.setText(Float.toString(res) + "%");
				}
			});

			btnCalcular5.setBounds(105, 110, 100, 25);
			jPanel5.add(btnCalcular5);

			getContentPane().add(jPanel5);

		jPanel6 = new JPanel();
		jPanel6.setLayout(null);
		jPanel6.setBounds(345, 170, 325, 150);
		jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Variação Delta - diferença % entre valores"));

			label6_1 = new JLabel("Valor inicial (a)");
			label6_1.setBounds(30, 20, 150, 25);
			label6_1.setForeground(Color.red);
			jPanel6.add(label6_1);

			txf6_1 = new JTextField();
			txf6_1.setBounds(180, 20, 100, 25);
			jPanel6.add(txf6_1);

			label6_2 = new JLabel("Valor final (b)");
			label6_2.setBounds(30, 50, 150, 25);
			label6_2.setForeground(Color.blue);
			jPanel6.add(label6_2);

			txf6_2 = new JTextField();
			txf6_2.setBounds(180, 50, 100, 25);
			jPanel6.add(txf6_2);

			label6_3 = new JLabel("Diferença %");
			label6_3.setBounds(30, 80, 150, 25);
			jPanel6.add(label6_3);

			txf6_3 = new JTextField();
			txf6_3.setBounds(180, 80, 100, 25);
			txf6_3.setEditable(false);
			jPanel6.add(txf6_3);

			btnCalcular6 = new JButton(new AbstractAction("Calcular") {

				@Override
				public void actionPerformed(ActionEvent e) {
					float res = 0;

					res = Operacoes.VariacaoDelta(Float.parseFloat(txf6_1.getText()),
							Float.parseFloat(txf6_2.getText()));
					txf6_3.setText(Float.toString(res) + "%");
				}
			});

			btnCalcular6.setBounds(105, 110, 100, 25);
			jPanel6.add(btnCalcular6);

			getContentPane().add(jPanel6);

		jPanel7 = new JPanel();
		jPanel7.setLayout(null);
		jPanel7.setBounds(680, 170, 250, 150);
		jPanel7.setBorder(BorderFactory.createTitledBorder(null, "Qual era o valor original?"));

			label7_1 = new JLabel("Valor final R$ (a)");
			label7_1.setBounds(10, 20, 150, 25);
			label7_1.setForeground(Color.red);
			jPanel7.add(label7_1);

			txf7_1 = new JTextField();
			txf7_1.setBounds(140, 20, 100, 25);
			jPanel7.add(txf7_1);

			label7_2 = new JLabel("% desconto (b)");
			label7_2.setBounds(10, 50, 150, 25);
			label7_2.setForeground(Color.blue);
			jPanel7.add(label7_2);

			txf7_2 = new JTextField();
			txf7_2.setBounds(140, 50, 100, 25);
			jPanel7.add(txf7_2);

			label7_3 = new JLabel("Valor inicial");
			label7_3.setBounds(10, 80, 150, 25);
			jPanel7.add(label7_3);

			txf7_3 = new JTextField();
			txf7_3.setBounds(140, 80, 100, 25);
			txf7_3.setEditable(false);
			jPanel7.add(txf7_3);

			btnCalcular7 = new JButton(new AbstractAction("Calcular") {

				@Override
				public void actionPerformed(ActionEvent e) {
					float res = 0;

					res = Operacoes.ValorOriginal(Float.parseFloat(txf7_1.getText()),
							Float.parseFloat(txf7_2.getText()));
					txf7_3.setText("R$ "+ Float.toString(res));
				}
			});

			btnCalcular7.setBounds(75, 110, 100, 25);
			jPanel7.add(btnCalcular7);

			getContentPane().add(jPanel7);

		jPanel8 = new JPanel();
		jPanel8.setLayout(null);
		jPanel8.setBounds(10, 330, 310, 150);
		jPanel8.setBorder(BorderFactory.createTitledBorder(null, "Regra de três"));

			label8_1 = new JLabel("a:");
			label8_1.setBounds(10, 30, 15, 25);
			label8_1.setForeground(Color.red);
			jPanel8.add(label8_1);

			txf8_1 = new JTextField();
			txf8_1.setBounds(35, 30, 100, 25);
			jPanel8.add(txf8_1);

			label8_2 = new JLabel("b:");
			label8_2.setBounds(10, 60, 15, 25);
			label8_2.setForeground(Color.blue);
			jPanel8.add(label8_2);

			txf8_2 = new JTextField();
			txf8_2.setBounds(35, 60, 100, 25);
			jPanel8.add(txf8_2);

			label8_3 = new JLabel("= r1:");
			label8_3.setBounds(145, 30, 35, 25);
			label8_3.setForeground(new Color(0, 102, 0));
			jPanel8.add(label8_3);

			txf8_3 = new JTextField();
			txf8_3.setBounds(190, 30, 100, 25);
			jPanel8.add(txf8_3);

			label8_4 = new JLabel("= r2:");
			label8_4.setBounds(145, 60, 35, 25);
			jPanel8.add(label8_4);

			txf8_4 = new JTextField();
			txf8_4.setBounds(190, 60, 100, 25);
			txf8_4.setEditable(false);
			jPanel8.add(txf8_4);

			btnCalcular8 = new JButton(new AbstractAction("Calcular") {

				@Override
				public void actionPerformed(ActionEvent e) {
					float res = 0;

					res = Operacoes.RegraDeTres(Float.parseFloat(txf8_1.getText()),
							Float.parseFloat(txf8_2.getText()), Float.parseFloat(txf8_3.getText()));
					txf8_4.setText(Float.toString(res));
				}
			});

			btnCalcular8.setBounds(105, 110, 100, 25);
			jPanel8.add(btnCalcular8);

			getContentPane().add(jPanel8);

		jPanel9 = new JPanel();
		jPanel9.setLayout(null);
		jPanel9.setBounds(330, 330, 310, 150);
		jPanel9.setBorder(BorderFactory.createTitledBorder(null, "Gerador de Senha"));

			chkUppercase = new JCheckBox();
			chkUppercase.setBounds(20, 20, 20, 20);
			jPanel9.add(chkUppercase);

			label9_1 = new JLabel("Maiúsculas");
			label9_1.setBounds(50, 17, 80, 25);
			jPanel9.add(label9_1);

			chkLowercase = new JCheckBox();
			chkLowercase.setBounds(140, 20, 20, 20);
			jPanel9.add(chkLowercase);

			label9_2 = new JLabel("Minúsculas");
			label9_2.setBounds(170, 17, 80, 25);
			jPanel9.add(label9_2);

			chkNumbers = new JCheckBox();
			chkNumbers.setBounds(20, 50, 20, 20);
			jPanel9.add(chkNumbers);

			label9_3 = new JLabel("Números");
			label9_3.setBounds(50, 47, 80, 25);
			jPanel9.add(label9_3);

			chkSymbols = new JCheckBox();
			chkSymbols.setBounds(140, 50, 20, 20);
			jPanel9.add(chkSymbols);

			label9_4 = new JLabel("Símbolos");
			label9_4.setBounds(170, 47, 80, 25);
			jPanel9.add(label9_4);

			label9_5 = new JLabel("Tamanho");
			label9_5.setBounds(50, 75, 80, 25);
			jPanel9.add(label9_5);

			spnTamanho = new JSpinner();
			spnTamanho.setBounds(140, 75, 80, 25);
			jPanel9.add(spnTamanho);

			txfSenha = new JTextField();
			txfSenha.setBounds(10, 110, 205, 25);
			txfSenha.setEditable(false);
			jPanel9.add(txfSenha);

			btnGerar = new JButton(new AbstractAction("Gerar") {

				@Override
				public void actionPerformed(ActionEvent e) {
					if ((Integer)spnTamanho.getValue() <= 0){
						
						txfSenha.setForeground(Color.red);
						txfSenha.setText("Insira o tamanho da senha");

					} else if (chkUppercase.isSelected() == false
							&& chkLowercase.isSelected() == false
							&& chkNumbers.isSelected() == false
							&& chkSymbols.isSelected() == false){

						txfSenha.setForeground(Color.red);
						txfSenha.setText("Marque pelo menos uma opção");

					} else {

						String senha = Operacoes.GeradorDeSenhas(chkUppercase.isSelected(),
								chkLowercase.isSelected(), chkNumbers.isSelected(),
								chkSymbols.isSelected(), (Integer)spnTamanho.getValue());
					
					txfSenha.setForeground(Color.black);
					txfSenha.setText(senha);

					}
				}
			});

			btnGerar.setBounds(225, 110, 75, 25);
			jPanel9.add(btnGerar);

			getContentPane().add(jPanel9);
	}

	private void fecharJanela() {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair do sistema",
				JOptionPane.YES_NO_OPTION);
		if (opcao == JOptionPane.YES_OPTION) {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			System.exit(0);
		} else {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}

	public static void main(String[] args) {
		new ProblemasMatematicosWindow();
	}
}