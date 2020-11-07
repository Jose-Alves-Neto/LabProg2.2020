package controle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTest {

	Grupo g1, g2, g3;
	Aluno a1, a2, a3;
	
	@BeforeEach
	void startTest() {
		g1 = new Grupo("FMCC2");
		g2 = new Grupo("Prog2");
		g3 = new Grupo("fmcc2");
		
		a1 = new Aluno("119210150", "Jose", "Computação");
		a2 = new Aluno("119210001", "Jose", "Agronomia");
		a3 = new Aluno("119210150", "PacMan", "Gastronomia");
	}
	
	@Test
	void testAlocaAluno() {
		assertTrue(g1.alocarAluno(a1) && g2.alocarAluno(a2));
		assertTrue(g1.alocarAluno(a3));
	}
	
	void testEquals() {
		assertFalse(g1.equals(g2));
		assertTrue(g1.equals(g3));
	}

}
