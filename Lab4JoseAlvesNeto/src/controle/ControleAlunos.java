package controle;

import java.util.Scanner;

public class ControleAlunos {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RepAluno repAluno = new RepAluno();
		RepGrupo repGrupo = new RepGrupo();
		RepRespostas repRes = new RepRespostas();
		
		while(true) {
			String escolha = menu(sc);
			opcao(escolha, repAluno, repGrupo, repRes, sc);
		}
	}
	
	public static String menu(Scanner sc) {
		System.out.print("(C)adastrar Aluno\r\n" + 
				"(E)xibir Aluno\r\n" + 
				"(N)ovo Grupo\r\n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos\r\n" + 
				"(R)egistrar Aluno que Respondeu\r\n" + 
				"(I)mprimir Alunos que Responderam\r\n" + 
				"(O)ra, vamos fechar o programa!\r\n" + 
				"\r\n" + 
				"Op��o>\r\n");
		return sc.next().toUpperCase();
	}
	
	public static void opcao(String escolha, RepAluno repAluno, RepGrupo repGrupo, RepRespostas repRes, Scanner sc) {
		switch (escolha) {
		case "C":
			cadastraAluno(repAluno, sc);
			break;
		case "E":
			exibeAluno(repAluno, sc);
			break;
		case "N":
			criaGrupo(repGrupo, sc);
			break;
		case "A":
			segundaEscolha(repAluno, repGrupo, sc);
			break;
		case "R":
			cadastraResposta(repAluno, repRes, sc);
			break;
		case "I":
			imprimeResposta(repRes, sc);
			break;
		case "O":
			sai();
			break;
		default:
			System.out.print("Op��o inv�lida");
			break;
		}
	}
	
	public static void segundaEscolha(RepAluno repAluno, RepGrupo repGrupo, Scanner sc) {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String escolha = sc.nextLine().toUpperCase();
		
		switch (escolha) {
			case "A":
				alocaAluno(repAluno, repGrupo, sc);
				break;
			case "I":
				imprimeGrupo(repGrupo, sc);
				break;
		}
	}
	
	/**
	 * Recebe as informa��es sobre o aluno e cadastra ele no reposit�rio.
	 * @param repAluno O reposit�rio
	 * @param sc Scanner respons�vel por receber as informa��es do usu�rio
	 */
	public static void cadastraAluno(RepAluno repAluno, Scanner sc) {
		System.out.print("Matr�cula: ");
		String matricula = sc.nextLine();
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		
		if (repAluno.cadastraAluno(matricula, nome, curso)) {
			System.out.println("CADASTRO REALIZADO");
		} else {
			System.out.print("MATR�CULA J� CADASTRADA");
		}
	}
	
	/**
	 * Imprime para o usu�rio dados sobre o aluno pesquisado.
	 * @param repAluno Reposit�rio de alunos
	 * @param sc Scanner respons�vel por receber as informa��es do usu�rio
	 */
	public static void exibeAluno(RepAluno repAluno, Scanner sc) {
		System.out.print("Matr�cula: ");
		String matricula = sc.nextLine();
		
		if (repAluno.getAluno(matricula) == null) {
			System.out.print("Aluno n�o cadastrado");
		} else {
			System.out.println("Aluno: " + repAluno.getAluno(matricula));
		}
	}
	
	/**
	 * Cria um grupo com um tema e adiciona ao reposit�rio de grupos.
	 * @param repGrupo O reposit�rio de grupos
	 * @param sc Scanner que recebe as informa��es do usu�rio
	 */
	public static void criaGrupo(RepGrupo repGrupo, Scanner sc) {
		System.out.print("Nome do grupo: ");
		String nome = sc.nextLine();
		
		if (repGrupo.adicionaGrupo(nome)) {
			System.out.println("GRUPO CADASTRADO");
		} else {
			System.out.println("GRUPO J� CADASTRADO");
		}
	}
	
	/**
	 * Aloca um aluno do reposit�rio em um grupo do reposit�rio.
	 * @param repAluno Reposit�rio de alunos
	 * @param repGrupo Reposit�rio de grupos
	 * @param sc Scanner respos�nvel pela intera��o com o usu�rio
	 */
	public static void alocaAluno(RepAluno repAluno, RepGrupo repGrupo, Scanner sc) {
		System.out.print("Nome do grupo: ");
		String nome = sc.nextLine();
		
		System.out.print("Matricula do aluno: ");
		String matricula = sc.nextLine();
		
		if (repGrupo.getGrupo(nome) == null) {
			System.out.println("Grupo n�o cadastrado");
		} else if (repAluno.getAluno(matricula) == null) {
			System.out.println("Aluno N�o Cadastrado!");
		} else {
			repGrupo.alocarGrupo(repAluno.getAluno(matricula), nome);
			System.out.println("Aluno Alocado!");
			
		}
	}
	
	/**
	 * Imprime todos os alunos alocados de um grupo.
	 * @param repGrupo Reposit�rio de grupos
	 * @param sc Scanner respos�nvel pela intera��o com o usu�rio
	 */
	public static void imprimeGrupo(RepGrupo repGrupo, Scanner sc) {
		System.out.print("Nome do grupo: ");
		String nome = sc.nextLine();
		
		Grupo gp = repGrupo.getGrupo(nome);
		
		if (gp == null) {
			System.out.println("Grupo n�o cadastrado");
		} else {
			System.out.println("--- " + gp.getNome() + " ---");
			for (int i = 0; i < gp.size(); i++) {
				System.out.println("* " + gp.getAluno(i).toString());
			}
		}
	}

	/**
	 * Cadastra o aluno que respondeu a quest�o em sala.
	 * @param repAluno Reposit�rio de alunos
	 * @param repRes Reposit�rio de respostas
	 * @param sc
	 */
	public static void cadastraResposta(RepAluno repAluno, RepRespostas repRes, Scanner sc) {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		
		if (repRes.cadastraAluno(repAluno.getAluno(matricula))) {
			System.out.print("Aluno registrado!");
		} else {
			System.out.print("Aluno n�o cadastrado!");
		}
	}
	
	/**
	 * Imprime todos os alunos que responderam as quest�es
	 * @param repRes Reposit�rio de alunos que respoderam
	 * @param sc Scanner respons�vel pela intera��o com o usu�rio
	 */
	public static void imprimeResposta(RepRespostas repRes, Scanner sc) {
		for (int pos = 0; pos < repRes.size(); pos++) {
			System.out.println(pos + ": " + repRes.getAluno(pos).toString());
		}
	}
	
	
	public static void sai() {
		System.exit(0);
	}
}
