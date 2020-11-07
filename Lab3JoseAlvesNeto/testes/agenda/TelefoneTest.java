package agenda;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelefoneTest {
	
	Telefone t1;
	Telefone t2;
	Telefone t3;
	
	@BeforeEach
	public void iniciaTeste() {
		t1 = new Telefone("+55", "(83)", "99544996");
		t1.setTipo("escola");
		t2 = new Telefone();
		t2.setTipo("tRaBaLhO");
		t3 = new Telefone();
		t3.setTipo("");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
