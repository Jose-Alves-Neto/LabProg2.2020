package controle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	
	Aluno a1, a2, a3;
	
	@BeforeEach
	void startTest() {
		a1 = new Aluno("119210150", "Jose", "Computação");
		a2 = new Aluno("119210001", "Jose", "Agronomia");
		a3 = new Aluno("119210150", "PacMan", "Gastronomia");
	}

	@Test
	void testEquals() {
		assertTrue(a1.equals(a3));
		assertFalse(a1.equals(a2));
	}
	
	void testHashCode() {
		assertTrue(a1.hashCode() == a3.hashCode());
		assertFalse(a1.hashCode() == a2.hashCode());
	}

}
