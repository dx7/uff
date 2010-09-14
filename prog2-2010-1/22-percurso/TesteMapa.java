import org.junit.Test;
import static org.junit.Assert.*;

public class TesteMapa {
	
	// to run:
	// javac -cp ../junit.jar:. TesteMapa.java; java -cp ../junit.jar:. org.junit.runner.JUnitCore TesteMapa

	@Test
	public void testMenorCusto() {
		Mapa mapa = new Mapa();
		int[] esperado = {1, 1};
		int[] atual = mapa.menorCusto();
		
		assertArrayEquals(esperado, atual);
		assertEquals(true, true);
	}
	
	@Test
	public void testMenorCusto2() {
		Mapa mapa = new Mapa();
		int[] esperado = {1, 2};
		int[] atual = mapa.menorCusto();
		
		assertArrayEquals(esperado, atual);
		assertEquals(true, true);
	}
	
}