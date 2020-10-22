/**
 * Laboratório de Programaçãso 2
 * 
 * @author José Alves de Figueiredo Neto - 119210150
 */
import java.util.Scanner;

public class Maior {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] in = sc.nextLine().split(" ");
		int media = media(in);
		System.out.print(maiores(in, media));
		sc.close();
	}

	public static int media(String[] numbers) {
		int media = 0;
		for (int i = 0; i < numbers.length; i++) {
			media += Integer.parseInt(numbers[i]);
		}
		return (media/numbers.length);
	}
	
	public static String maiores(String[] numbers, int media) {
		String teste = "";
		for (int j = 0; j < numbers.length; j++) {
			if (Integer.parseInt(numbers[j]) > media) {
				teste += numbers[j] + " ";
			}
		}
		return teste.trim();
	}
}
