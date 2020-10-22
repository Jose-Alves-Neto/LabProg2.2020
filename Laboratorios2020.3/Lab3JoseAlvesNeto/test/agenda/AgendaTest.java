package agenda;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	
	private Agenda agenda;
	private String[] tele1 = {"9999-9999", "8888-8888", "7777-7777"},
					 tele2 = {"1111-1111", "2222-2222", "3333-3333"},
					 tele3 = {"3333-3333", "4444-4444",          ""};
	
	@BeforeEach
	public void iniciaTest() {
		agenda = new Agenda();
		agenda.cadastraContato(50, "Mateus", "Gaudencio", tele1, 1, 2);
	}
	
	@Test
	void testCadastraContato() {
		assertFalse(agenda.cadastraContato(0, "Doom", "Guy", tele1, 1, 2));
		assertTrue(agenda.cadastraContato(1, "Pac", "Man", tele2, 0, 2));
		assertTrue(agenda.cadastraContato(100, "Ash", "Ketchum", tele2, 2, 2));
		assertFalse(agenda.cadastraContato(101, "Samus", "Aram", tele3, 1, 0));
	}

}
