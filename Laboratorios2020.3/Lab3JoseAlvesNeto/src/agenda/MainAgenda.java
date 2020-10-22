package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa � a maneira de lidar com poss�veis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo n�o encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usu�rio/a.
	 * 
	 * @param scanner Para captura da op��o do usu�rio.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print("\n-----\n" + 
						 "MENU\n" +
						 "(C)adastrar Contato\n" +
						 "(L)istar Contatos\n" +
						 "(E)xibir Contato\n" +
						 "(T)elefones preferidos\n" +
						 "(Z)aps\n" +
						 "(S)air\n" +
						 "\nOp��o> ");
		
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a op��o escolhida por quem est� usando o sistema.
	 * 
	 * @param opcao   Op��o digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "S":
			sai(agenda);
			break;
		case "T":
			listaPrior(agenda);
			break;
		case "Z":
			listaZap(agenda);
			break;
		default:
			System.out.println("Op��o inv�lida!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("Lista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}
	
	/**
	 * Imprime lista de telefones priorit�rios da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaPrior(Agenda agenda) {
		System.out.println("Lista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println();
			}
		}
	}
	
	/**
	 * Imprime lista de contatos para whatsapp da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaZap(Agenda agenda) {
		System.out.println("Lista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println();
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Qual contato> ");
		int posicao = scanner.nextInt();
		Contato contato = agenda.getContato(posicao);
		System.out.println("Dados do contato:\n" + formataContato(posicao, contato) +
						   "\n" + contato.exibe());
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informa��es do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner sc) {
		System.out.print("Posi��o na agenda> ");
		String posicao = sc.next();
		System.out.print("Nome> ");
		String nome = sc.next();
		System.out.print("Sobrenome> ");
		String sobrenome = sc.next();
		System.out.print("Nivel de amizade> ");
		String nivelAmi = sc.next();
		
		agenda.cadastraContato(Integer.parseInt(posicao), nome, sobrenome, Integer.parseInt(nivelAmi));
		cadastraTelefone(agenda, Integer.parseInt(posicao), 0, sc);
		cadastraTelefone(agenda, Integer.parseInt(posicao), 1, sc);
		cadastraTelefone(agenda, Integer.parseInt(posicao), 2, sc);
	}
	
	/**
	 * Cadastra um telefone ao contato da agenda.
	 * 
	 * @param agenda A agenda
	 * @param posC Posi��o do contato
	 * @param posT Telefone
	 * @param sc Scanner para pedir informa��es para o usu�rio
	 */
	public static void cadastraTelefone(Agenda agenda, int posC, int posT, Scanner sc) {
		System.out.print("C�digo do pa�s> ");
		String cod = sc.next();
		System.out.print("DDD> ");
		String ddd = sc.next();
		System.out.print("N�mero> ");
		String num = sc.next();
		System.out.print("Categoria (trabalho, celular, escola)> ");
		String local = sc.next();
		agenda.cadastraTel(posC, posT, cod, ddd, num, local);
	}

	/**
	 * L� uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo n�o exista ou n�o possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
	
	/**
	 * Formata um contato para impress�o na interface. 
	 * 
	 * @param posicao A posi��o do contato (que � exibida)/
	 * @param contatos O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + " - " + contato.toString();
	}
	
	/**
	 * Sai da aplica��o.
	 */
	private static void sai(Agenda agenda) {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}
}