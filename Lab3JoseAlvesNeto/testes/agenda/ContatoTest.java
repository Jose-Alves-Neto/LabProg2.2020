package agenda;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {
	
	Contato c1;
	Contato c2;
	Contato c3;
	
	private String[] tele1 = {"(83) 9999-9999", "+55 (83) 8888-8888", "+2 (84) 7777-7777"};
	private String[] tele2 = {"(83) 1111-1111", "(83) 2222-2222", "+20 (84) 3333-3333"};
	private String[] tele3 = {"+55 3333-3333", "(84) 4444-4444", "+2 (14) 999549999"};
	
	private String[] tipo1 = {"escola", "trabalho", ""};
	private String[] tipo2 = {"trabalho", "celular", "escola"};
	private String[] tipo3 = {"escola", "escola", "escola"};
	
	private int[] prior1 = {3, 1};
	private int[] prior2 = {1, 1};
	private int[] prior3 = {2, 3};
	
	
	
	@BeforeEach
	public void iniciaTest() {
		c1 = new Contato("Mateus", "Gaudencio", tele1, tipo2, prior3);
		c2 = new Contato("Livia", "Sampaio", tele2, tipo1, prior2);
		c3 = new Contato("Mateus", "Gaudencio", tele3, tipo3, prior1);
	}
	
	@Test
	void testExibe() {
		System.out.println(c1.exibe());
		System.out.print(c2.exibe());
		assertTrue(c2.exibe().equals("Livia Sampaio\n" +
				"(83) 1111-1111 (telefone prioritário)\n" +
				"(83) 1111-1111 (zap)"));
	}

	@Test
	void testEquals() {
		assertTrue(c1.equals(c3));
		assertFalse(c2.equals(c1));
	}

}
