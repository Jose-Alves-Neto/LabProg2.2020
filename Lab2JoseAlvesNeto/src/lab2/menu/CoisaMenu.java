package lab2.menu;

import java.util.Scanner;

import lab2.Aluno;

/**
 * Vers�o 1.0, tentativa de cria��o do menu.
 * @author Jos� Alves de Figueiredo Neto - 199210150
 */
public class CoisaMenu {

	private static Aluno aluno;
	private static String NOME;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		login(sc);
		while (true) {
			menu();
			String in = sc.nextLine();
			if (in.equals("5")) {
				break;
			}
			
			if (in.equals("1")) {
				laboratorio(sc);
			} else if (in.equals("2")) {
				disciplinas(sc);
			} else if (in.equals("3")) {
				cantina(sc);
			} else if (in.equals("4")) {
				saude(sc);
			} else {
				System.out.println("Entrada inv�lida...");
			}
			verifica(sc);
		}
		
		
		sc.close();
	}
	
	private static void login(Scanner sc) {
		System.out.print("Por favor informe seu nome: ");
		String nome = sc.nextLine();
		aluno = new Aluno();
		NOME = nome;
		System.out.println("Bem-vindo " + NOME);
	}
	
	private static void menu() {
		System.out.println("1. Conta Laborat�rios");
		System.out.println("2. M�terias");
		System.out.println("3. Conta Cantina");
		System.out.println("4. Sa�de");
		System.out.println("5. Cancel");
	}
	
	private static void laboratorio(Scanner sc) {
		while (true) {
			System.out.println("1. Cadastrar conta");
			System.out.println("2. Consumir espa�o");
			System.out.println("3. Liberar espa�o");
			System.out.println("4. Verificar conta");
			System.out.println("5. Voltar");
			
			String in = sc.nextLine();
			if (in.equals("1")) {
				System.out.print("Nome do laborat�rio: ");
				String nome = sc.nextLine();
				System.out.print("Cota m�xima (padr�o 2000Mb): ");
				String cota = sc.nextLine();
				if (cota.equals("")) {
					aluno.cadastraLaboratorio(nome);
				} else {
					aluno.cadastraLaboratorio(nome, Integer.parseInt(cota));
				}
			} else if (in.equals("2")) {
				System.out.print("Nome do laborat�rio: ");
				String nome = sc.nextLine();
				System.out.print("Espa�o consumido: ");
				int mbytes = sc.nextInt();
				aluno.consomeEspa�o(nome, mbytes);
			} else if (in.equals("3")) {
				System.out.print("Nome do laborat�rio: ");
				String nome = sc.nextLine();
				System.out.print("Espa�o liberado: ");
				String mbytes = sc.nextLine();
				aluno.liberaEspa�o(nome, Integer.parseInt(mbytes));
			} else if (in.equals("4")) {
				System.out.print("Nome do laborat�rio: ");
				String nome = sc.nextLine();
				System.out.println(aluno.atingiuCota(nome));
			} else if (in.equals("5")) {
				break;
			} else {
				System.out.println("Entrada inv�lida...");
			}
			verifica(sc);
		}
	}
	
	private static void disciplinas(Scanner sc) {
		while (true) {
			System.out.println("1. Cadastrar m�teria");
			System.out.println("2. Cadastrar horas");
			System.out.println("3. Cadastrar nota");
			System.out.println("4. Verificar estado");
			System.out.println("5. Voltar");
			
			String in = sc.nextLine();
			if (in.equals("1")) {
				System.out.print("Nome do m�teria: ");
				String nome = sc.nextLine();
				System.out.print("N�mero de nota (padr�o: 4): ");
				String notas = sc.nextLine();
				if (notas.equals("")) {
					aluno.cadastraDisciplina(nome);
				} else {
					aluno.cadastraDisciplina(nome, Integer.parseInt(notas));
				} 
			} else if (in.equals("2")) {
				System.out.print("Nome do m�teria: ");
				String nome = sc.nextLine();
				System.out.print("N�mero de horas: ");
				String horas = sc.nextLine();
				aluno.cadastraHoras(nome, Integer.parseInt(horas));
			} else if (in.equals("3")) {
				System.out.print("Nome do m�teria: ");
				String nome = sc.nextLine();
				System.out.print("N�mero da prova: ");
				String prova = sc.nextLine();
				System.out.print("Nota: ");
				String nota = sc.nextLine();
				aluno.cadastraNotas(nome, Integer.parseInt(prova), Double.parseDouble(nota));
			} else if (in.equals("4")) {
				System.out.print("Nome do m�teria: ");
				String nome = sc.nextLine();
				System.out.println(aluno.aprovado(nome));
			} else if (in.equals("5")) {
				break;
			} else {
				System.out.println("Entrada inv�lida...");
			}
			verifica(sc);
		}
		
	}
	
	private static void cantina(Scanner sc) {
		while (true) {
			System.out.println("1. Cadastrar cantina");
			System.out.println("2. Cadastrar lanche");
			System.out.println("3. Pagar conta");
			System.out.println("4. Falta pagar");
			System.out.println("5. Voltar");
			
			String in = sc.nextLine();
			if (in.equals("1")) {
				System.out.print("Nome da cantina: ");
				String nome = sc.nextLine();
				aluno.cadastraCantina(nome);
			} else if (in.equals("2")) {
				System.out.print("Nome da cantina: ");
				String nome = sc.nextLine();
				System.out.print("Quantidade de itens comprados: ");
				String qtd = sc.nextLine();
				System.out.print("Valor gasto: ");
				String valor = sc.nextLine();
				aluno.cadastraLanche(nome, Integer.parseInt(qtd), Integer.parseInt(valor));
			} else if (in.equals("3")) {
				System.out.print("Nome da cantina: ");
				String nome = sc.nextLine();
				System.out.print("Valor a ser pago: ");
				String valor = sc.nextLine();
				aluno.pagarConta(nome, Integer.parseInt(valor));
			} else if (in.equals("4")) {
				System.out.print("Nome da cantina: ");
				String nome = sc.nextLine();
				System.out.println(aluno.faltaPaga(nome));
			} else if (in.equals("5")) {
				break;
			} else {
				System.out.println("Entrada inv�lida...");
			}
			verifica(sc);
		}
	}
	
	private static void saude(Scanner sc) {
		while(true) {
			System.out.println("1. Definir sa�de mental");
			System.out.println("2. Definir sa�de f�sica");
			System.out.println("3. Definir um emoji");
			System.out.println("4. Estado geral");
			System.out.println("5. Voltar");
		
			String in = sc.nextLine();
		
			if(in.equals("1")) {
				System.out.print("Estado mental: ");
				String saudeMental = sc.nextLine();
				aluno.defineSaudeMental(saudeMental);
			} else if(in.equals("2")) {
				System.out.print("Estado f�sico: ");
				String saudeFisico = sc.nextLine();
				aluno.defineSaudeMental(saudeFisico);
			} else if(in.equals("3")) {
				System.out.print("Definir emoji: ");
				String emoji = sc.nextLine();
				aluno.defineSaudeMental(emoji);
			} else if(in.equals("4")) {
				System.out.println(aluno.getStatusGeral());
			} else if(in.equals("5")) {
				break;
			} else {
				System.out.println("Entrada inv�lida...");
			}
			verifica(sc);
		}
	}
	
	private static void verifica(Scanner sc) {
		System.out.println("Aperte enter para continuar...");
		sc.nextLine();
	}
}
