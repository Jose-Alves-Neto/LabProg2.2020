package controle;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepAlunoTest {
	
	RepAluno repAluno;
	
	@BeforeEach
	void iniciaTeste() {
		repAluno = new RepAluno();
	}

	@Test
	void testeCadastraAluno() {
		assertTrue(repAluno.cadastraAluno("200", "PacMan", "Gastronomia"));
		assertTrue(repAluno.cadastraAluno("250", "PacMan", "Gastronomia"));
		assertFalse(repAluno.cadastraAluno("200", "Snake", "Ciências politicas"));
		assertTrue(repAluno.cadastraAluno("300", "Snake", "Ciências politicas"));
	}

}
