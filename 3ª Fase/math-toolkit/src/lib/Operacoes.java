package lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Operacoes {
	public static float AplicaDesconto(float a, float b) {
		return a - (a * (b / 100));
	}

	public static float AplicaAcrecimo(float a, float b) {
		return a + (a * (b / 100));
	}

	public static float Amostragem(float a, float b) {
		return (a * b) / 100;
	}

	public static float Amostragem2(float a, float b) {
		return (b / a) * 100;
	}

	public static float DescontoAplicado(float a, float b) {
		return ((a - b) / a) * 100;
	}

	public static float VariacaoDelta(float a, float b) {
		return (b / a - 1) * 100;
	}

	public static float ValorOriginal(float a, float b) {
		return (a * 100 / (100 - b));
	}

	public static float RegraDeTres(float a, float b, float r1) {
		return (b * r1) / a;
	}

	public static String GeradorDeSenhas(boolean usaUpperCase, boolean usaLowerCase, boolean usaNumbers,
			boolean usaSymbols, int tam) {

		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvxyz";
		String symbols = "@$#!&-+?";
		String numbers = "0123456789";

		StringBuilder senha = new StringBuilder(tam);
		Random random = new Random();

		List<String> charCategories = new ArrayList<>(4);
		if (usaUpperCase == true) {
			charCategories.add(upperCase);
		}
		if (usaLowerCase == true) {
			charCategories.add(lowerCase);
		}
		if (usaNumbers == true) {
			charCategories.add(numbers);
		}
		if (usaSymbols == true) {
			charCategories.add(symbols);
		}

		for (int i = 0; i < tam; i++) {
			String charCategory = charCategories.get(random.nextInt(charCategories.size()));
			int posicao = random.nextInt(charCategory.length());
			senha.append(charCategory.charAt(posicao));
		}

		return new String(senha);
	}

}
