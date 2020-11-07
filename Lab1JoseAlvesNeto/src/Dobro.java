import java.util.Scanner;

public class Dobro {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Dobro: " + 2 * n + ", Triplo: " + 3 * n);
		sc.close();
	}
}
