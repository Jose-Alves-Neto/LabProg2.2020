import java.util.Locale;
import java.util.Scanner;

public class Media {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		double n1 = sc.nextDouble();
		double n2 = sc.nextDouble();
		double media = (n1 + n2) / 2;
		if (media >= 7.0) {
			System.out.print("pass: True!");
		} else {
			System.out.print("pass: False!");
		}
		sc.close();
	}
}
