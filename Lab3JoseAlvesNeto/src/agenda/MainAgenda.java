package agenda;

import java.util.Scanner;

public class MainAgenda {
	
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		Scanner sc = new Scanner(System.in);
		String escolha;
		
		while(true) {
			escolha = menu(sc);
			comando(escolha, agenda, sc);
		}
		
	}
	
	/**
	 * Printa o menu de escolhas
	 * @param sc Scanner que recebe a entrada do usuário
	 * @return a escolha do usuário
	 */
	public static String menu(Scanner sc) {
		System.out.print("(C)adastrar Contato\n" + 
				"(E)xibir Contato\n" +
				"(L)istar Contatos\n" + 
				"(A)Procura Amizade" +
				"(N)Procurar Nome\n" +
				"(P)rocurar Contato\n"+
				"(T)elefones prioritarios\n" +
				"(Z)aps\n" +
				"(S)air\n" + 
				"\n" + 
				"Opção> ");
		return sc.nextLine().toUpperCase();
	}
	
	/**
	 * Checa o comando e continua a operação do menu
	 * @param opcao Opção escolhida
	 * @param agenda A agenda a ser feita a operação
	 * @param sc Scanner que recebe a entrada do usuário
	 */
	public static void comando(String opcao, Agenda agenda, Scanner sc) {
		switch (opcao) {
			case "C":
				cadastraContato(agenda, sc);
				break;
			case "L":
				listaContato(agenda, sc);
				break;
			case "A":
				procuraAmizade(agenda, sc);
				break;
			case "E":
				exibe(agenda, sc);
				break;
			case "N":
				procuraNome(agenda, sc);
				break;
			case "P":
				procuraContato(agenda, sc);
				break;
			case "T":
				listaPrioritarios(agenda);
				break;
			case "Z":
				listaZaps(agenda);
				break;
			case "S":
				sai(sc);
				break;
			default:
				System.out.print("Opção inválida");
		}
	}
	
	/**
	 * Operação que cadastra um contato na agenda
	 * @param agenda A agenda
	 * @param sc Scanner que recebe a entrada do usuário
	 */
	public static void cadastraContato(Agenda agenda, Scanner sc) {
		int[] prior = new int[2];
		String[] tipo = new String[3];
		String[] tele = new String[3];
		
		System.out.print("Posição> ");
		int pos = Integer.parseInt(sc.nextLine());
		
		System.out.print("Nome> ");
		String nome = sc.nextLine();
		
		System.out.print("Sobrenome> ");
		String sobrenome = sc.nextLine();
		
		System.out.print("Nivel de Amizade> ");
		int nivelAmi = Integer.parseInt(sc.nextLine());
		
		System.out.print("Telefone 1> ");
		tele[0] = sc.nextLine();
		System.out.print("Tipo do telefone 1> ");
		tipo[0] = sc.nextLine();
		
		System.out.print("Telefone 2> ");
		tele[1] = sc.nextLine();
		System.out.print("Tipo do telefone 2> ");
		tipo[1] = sc.nextLine();
		
		System.out.print("Telefone 3> ");
		tele[2] = sc.nextLine();
		System.out.print("Tipo do telefone 3> ");
		tipo[2] = sc.nextLine();
		
		System.out.print("Telefone prioritário> ");
		prior[0] = Integer.parseInt(sc.nextLine());
		System.out.print("Contato Whatsapp> ");
		prior[1] = Integer.parseInt(sc.nextLine());
		
		if (agenda.cadastraContato(pos, nome, sobrenome, tele, tipo, prior, nivelAmi)) {
			System.out.println("CADASTRO REALIZADO");
		} else {
			System.out.println("POSIÇÃO INVÁLIDA");
		}
		
	}

	/**
	 * Exibe um contato especificado pelo usuário
	 * @param agenda A agenda
	 * @param sc Scanner para interação com o usuário
	 */
	public static void exibe(Agenda agenda, Scanner sc) {
		System.out.print("Posição> ");
		int pos = Integer.parseInt(sc.nextLine());
		
		if (pos < 1 || pos > 100 || agenda.getContato(pos) == null) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else {
			System.out.println(pos + " - " + agenda.getContato(pos).exibe());
		}
	}
	
	/**
	 * Lista todos os contatos da agenda
	 * @param agenda A agenda
	 * @param sc Scanner que recebe a entrada do usuário
	 */
	public static void listaContato(Agenda agenda, Scanner sc) {
		for (int pos = 1; pos < agenda.size(); pos++) {
			if (agenda.getContato(pos) == null) {
				continue;
			} else {
				System.out.println(pos + " - " + agenda.getContato(pos));
			}
		}
	}
	
	/**
	 * Procura na agenda todos os contatos com o mesmo nome
	 * @param agenda A agenda
	 * @param sc Scanner que recebe a entrada do usuário
	 */
	public static void procuraNome(Agenda agenda, Scanner sc) {
		System.out.print("Nome a ser procurado> ");
		String nome = sc.nextLine();
		for (int pos = 1; pos < agenda.size(); pos++) {
			if (agenda.getContato(pos) == null) {
				continue;
			} else if (agenda.getContato(pos).getNome().equals(nome)) {
				System.out.println(pos + " " + agenda.getContato(pos).toString());
			}
		}
	}
	
	/**
	 * Procura um contato especifico na agenda
	 * @param agenda A agenda
	 * @param sc Scanner que recebe a entrada do usuário
	 */
	public static void procuraContato(Agenda agenda, Scanner sc) {
		System.out.print("Nome a ser procurado> ");
		String nome = sc.nextLine();
		System.out.print("Nome a ser procurado> ");
		String sobre = sc.nextLine();
		System.out.println(agenda.procuraContato(nome, sobre));
	}
	
	/**
	 * Procura na agenda usuários com o mesmo nivél de amizade
	 * @param agenda
	 * @param sc
	 */
	public static void procuraAmizade(Agenda agenda, Scanner sc) {
		System.out.print("Nivél de amizade> ");
		int nivel = Integer.parseInt(sc.nextLine());
		for (int pos = 1; pos < agenda.size(); pos++) {
			if (agenda.getContato(pos) == null) {
				continue;
			} else if (agenda.getContato(pos).getNivel() == nivel) {
				 System.out.print(pos + " " + agenda.getContato(pos).toString());
			}
		}
	}
	
	/**
	 * Lista os telefones prioritários da agenda
	 * @param agenda A agenda
	 */
	public static void listaPrioritarios(Agenda agenda) {
		for (int pos = 1; pos < agenda.size(); pos++) {
			if (agenda.getContato(pos) == null) {
				continue;
			} else {
				System.out.println(pos + " - " + agenda.getContato(pos).getTeleP().toString());
			}
		}
	}
	
	/**
	 * Lista todos os contatos de whatsapp da agenda
	 * @param agenda A agenda
	 */
	public static void listaZaps(Agenda agenda) {
		for (int pos = 1; pos < agenda.size(); pos++) {
			if (agenda.getContato(pos) == null) {
				continue;
			} else {
				System.out.println(pos + " - " + agenda.getContato(pos).getTeleZ().toString());
			}
		}
	}
	
	public static void sai(Scanner sc) {
		sc.close();
		System.exit(0);
	}

}
