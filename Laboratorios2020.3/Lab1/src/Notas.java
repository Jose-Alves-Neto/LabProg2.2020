/**
 * Laboratorio de programação 2
 * 
 * @author José Alves de Figueiredo Neto - 119210150 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Notas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> notas = new ArrayList<Integer>();
		int media = 0;
		while (true) {
			String in = sc.nextLine();
			if (in.equals("-")) {
				break;
			}
			notas.add(Integer.parseInt(in.split(" ")[1]));
			media += (Integer.parseInt(in.split(" ")[1]));
		}
		media /= notas.size();
		
		System.out.print( "maior: "    + Maior(notas) 
						+ "\nmenor: "  + Menor(notas)
						+ "\nmedia: "  + media
						+ "\nacima: "  + Acima(notas)
						+ "\nabaixo: " + Abaixo(notas));
		
		sc.close();
	}
	
	public static int Maior(ArrayList<Integer> notas) {
		int maior = notas.get(0);
		for (int i = 0; i < notas.size(); i ++) {
			if (notas.get(i) > maior) {
				maior = notas.get(i);
			}
		}
		return maior;
	}
	
	public static int Menor(ArrayList<Integer> notas) {
		int menor = notas.get(0);
		for (int i = 0; i < notas.size(); i ++) {
			if (notas.get(i) < menor) {
				menor = notas.get(i);
			}
		}
		return menor;
	}
	
	public static int Acima(ArrayList<Integer> notas) {
		int acima = 0;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i) >= 700) {
				acima += 1;
			}
		}
		return acima;
	}
		
	public static int Abaixo(ArrayList<Integer> notas) {
		int abaixo = 0;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i) < 700) {
				abaixo += 1;
			}
		}
		return abaixo;
	}
}
