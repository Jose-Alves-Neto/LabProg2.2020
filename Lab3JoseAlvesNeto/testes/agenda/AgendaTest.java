package agenda;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Agenda agenda;
	private Agenda agenda2;
	private Agenda agenda3;
	
	private String[] tele1 = {"(83) 9999-9999", "+55 (83) 8888-8888", "+2 (84) 7777-7777"};
	private String[] tele2 = {"(83) 1111-1111", "(83) 2222-2222", "3333-3333"};
	private String[] tele3 = {"+55 3333-3333", "(84) 4444-4444", "+2 (14) 999549999"};
	
	private String[] tipo1 = {"escola", "trabalho", ""};
	private String[] tipo2 = {"trabalho", "celular", "escola"};
	private String[] tipo3 = {"escola", "escola", "escola"};
	
	private int[] prior1 = {3, 1};
	private int[] prior2 = {1, 1};
	private int[] prior3 = {2, 3};
	
	
	@BeforeEach
	public void iniciaTest() {
		agenda = new Agenda();
		agenda2 = new Agenda();
		agenda3 = new Agenda();
		
		agenda.cadastraContato(40, "Mateus", "Gaudencio", tele1, tipo1, prior3, 2);
		agenda.cadastraContato(50, "Livia", "Sampaio", tele2, tipo1, prior2, 5);
		
		agenda2.cadastraContato(40, "Nazareno", "Andrade", tele3, tipo3, prior1, 5);
		agenda2.cadastraContato(50, "Fabio", "Morais", tele1, tipo1, prior1, 1);
		
		agenda3.cadastraContato(40, "Mateus", "Gaudencio", tele3, tipo2, prior2, 2);
		agenda3.cadastraContato(50, "Livia", "Sampaio", tele1, tipo1, prior1, 3);
	}
	
	@Test
	void testCadastraContato() {
		assertFalse(agenda.cadastraContato(0, "Doom", "Guy", tele1, tipo1, prior1, 5));
		assertTrue(agenda.cadastraContato(1, "Pac", "Man", tele2, tipo2, prior2, 5));
		assertTrue(agenda.cadastraContato(100, "Ash", "Ketchum", tele2, tipo3, prior3, 5));
		assertFalse(agenda.cadastraContato(101, "Samus", "Aram", tele3, tipo3, prior1, 5));
	}

	@Test
	void testEquals() {
		assertFalse(agenda.equals(agenda2));
		assertTrue(agenda.equals(agenda3));
	}
	
}
