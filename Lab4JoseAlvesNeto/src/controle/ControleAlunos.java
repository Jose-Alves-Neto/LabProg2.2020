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
				"Opção>\r\n");
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
			System.out.print("Opção inválida");
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
	 * Recebe as informações sobre o aluno e cadastra ele no repositório.
	 * @param repAluno O repositório
	 * @param sc Scanner responsável por receber as informações do usuário
	 */
	public static void cadastraAluno(RepAluno repAluno, Scanner sc) {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		
		if (repAluno.cadastraAluno(matricula, nome, curso)) {
			System.out.println("CADASTRO REALIZADO");
		} else {
			System.out.print("MATRÍCULA JÁ CADASTRADA");
		}
	}
	
	/**
	 * Imprime para o usuário dados sobre o aluno pesquisado.
	 * @param repAluno Repositório de alunos
	 * @param sc Scanner responsável por receber as informações do usuário
	 */
	public static void exibeAluno(RepAluno repAluno, Scanner sc) {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		
		if (repAluno.getAluno(matricula) == null) {
			System.out.print("Aluno não cadastrado");
		} else {
			System.out.println("Aluno: " + repAluno.getAluno(matricula));
		}
	}
	
	/**
	 * Cria um grupo com um tema e adiciona ao repositório de grupos.
	 * @param repGrupo O repositório de grupos
	 * @param sc Scanner que recebe as informações do usuário
	 */
	public static void criaGrupo(RepGrupo repGrupo, Scanner sc) {
		System.out.print("Nome do grupo: ");
		String nome = sc.nextLine();
		
		if (repGrupo.adicionaGrupo(nome)) {
			System.out.println("GRUPO CADASTRADO");
		} else {
			System.out.println("GRUPO JÁ CADASTRADO");
		}
	}
	
	/**
	 * Aloca um aluno do repositório em um grupo do repositório.
	 * @param repAluno Repositório de alunos
	 * @param repGrupo Repositório de grupos
	 * @param sc Scanner resposánvel pela interação com o usuário
	 */
	public static void alocaAluno(RepAluno repAluno, RepGrupo repGrupo, Scanner sc) {
		System.out.print("Nome do grupo: ");
		String nome = sc.nextLine();
		
		System.out.print("Matricula do aluno: ");
		String matricula = sc.nextLine();
		
		if (repGrupo.getGrupo(nome) == null) {
			System.out.println("Grupo não cadastrado");
		} else if (repAluno.getAluno(matricula) == null) {
			System.out.println("Aluno Não Cadastrado!");
		} else {
			repGrupo.alocarGrupo(repAluno.getAluno(matricula), nome);
			System.out.println("Aluno Alocado!");
			
		}
	}
	
	/**
	 * Imprime todos os alunos alocados de um grupo.
	 * @param repGrupo Repositório de grupos
	 * @param sc Scanner resposánvel pela interação com o usuário
	 */
	public static void imprimeGrupo(RepGrupo repGrupo, Scanner sc) {
		System.out.print("Nome do grupo: ");
		String nome = sc.nextLine();
		
		Grupo gp = repGrupo.getGrupo(nome);
		
		if (gp == null) {
			System.out.println("Grupo não cadastrado");
		} else {
			System.out.println("--- " + gp.getNome() + " ---");
			for (int i = 0; i < gp.size(); i++) {
				System.out.println("* " + gp.getAluno(i).toString());
			}
		}
	}

	/**
	 * Cadastra o aluno que respondeu a questão em sala.
	 * @param repAluno Repositório de alunos
	 * @param repRes Repositório de respostas
	 * @param sc
	 */
	public static void cadastraResposta(RepAluno repAluno, RepRespostas repRes, Scanner sc) {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		
		if (repRes.cadastraAluno(repAluno.getAluno(matricula))) {
			System.out.print("Aluno registrado!");
		} else {
			System.out.print("Aluno não cadastrado!");
		}
	}
	
	/**
	 * Imprime todos os alunos que responderam as questões
	 * @param repRes Repositório de alunos que respoderam
	 * @param sc Scanner responsável pela interação com o usuário
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
