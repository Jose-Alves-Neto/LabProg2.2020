/**
 * Laboratio de programação 2
 * 
 * @author José Alves de Figueiredo Neto - 119210150
 */
import java.util.Scanner;

public class Wally {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String[] names = sc.nextLine().split(" ");
			String newName = "?";
			if (names[0].equals("wally")) {
				break;
				}
		
			for (int i = 0; i < names.length; i++) {
				if (names[i].length() == 5) {
					newName = names[i];
				}
			System.out.print(newName);	
		}
		sc.close();
		}
		
	}
}
