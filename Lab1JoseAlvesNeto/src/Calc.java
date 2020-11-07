import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sinal = sc.nextLine();
		if (sinal.equals("+")) {
			double n1 = sc.nextDouble();
			double n2 = sc.nextDouble();
			System.out.print("RESULTADO: " + (n1 + n2));
		} else if (sinal.equals("-")) {
			double n1 = sc.nextDouble();
			double n2 = sc.nextDouble();
			System.out.print("RESULTADO: " + (n1 - n2));
		} else if (sinal.equals("*")) {
			double n1 = sc.nextDouble();
			double n2 = sc.nextDouble();
			System.out.print("RESULTADO: " + (n1 * n2));
		} else if (sinal.equals("/")) {
			double n1 = sc.nextDouble();
			double n2 = sc.nextDouble();
			if ((int)n2 == 0) {
				System.out.print("ERRO");
			} else {
				System.out.print("RESULTADO: " + (n1 / n2));
			}
		} else {
			System.out.print("ENTRADA INVALIDA");
		}
		sc.close();
	}
}
