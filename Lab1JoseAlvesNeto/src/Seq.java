import java.util.Scanner;

public class Seq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		if ((a > b) && (b > c) && (c > d)) {
			System.out.print("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		} else if ((a < b) && (b < c) && (c < d)) {
			System.out.print("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		} else {
			System.out.print("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
		sc.close();
	}
}
