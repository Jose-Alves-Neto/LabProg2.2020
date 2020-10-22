package agenda;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {
	
	private Contato c1;
	private Contato c2;
	private Contato c3;
	
	@BeforeEach
	public void inicia() {
		String[] tele1 = {"9999-9999", "8888-8888", "7777-7777"};
		String[] tele2 = {"1111-1111", "2222-2222", "3333-3333"};
		String[] tele3 = {"3333-3333", "4444-4444",          ""};
		
		c1 = new Contato("Pac", "Man", tele1, 0, 1);
		c2 = new Contato("Samus", "Aram", tele2, 2, 2);
		c3 = new Contato("Pac", "Man", tele3, 1, 2);
	}
	
	@Test
	public void testEquals() {
		assertFalse(c1.equals(c2) && c2.equals(c3));
		assertTrue(c1.equals(c3) && c3.equals(c1));
	}
	
	@Test
	public void testExibe() {
		assertTrue(c1.exibe().equals("Pac Man" +
				"\n9999-9999 (telefone prioritário)" +
				"\n8888-8888 (zap)"));
		assertTrue(c2.exibe().equals("Samus Aram" +
				"\n3333-3333 (telefone prioritário)" +
				"\n3333-3333 (zap)"));
		assertFalse(c3.exibe().equals("Pac Man" +
				"\n9999-9999 (telefone prioritário)" +
				"\n8888-8888 (zap)"));
	}

}
