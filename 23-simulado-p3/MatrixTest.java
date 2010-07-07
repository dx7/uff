import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {
	
	// to run:
	// javac -cp ../junit.jar:. MatrixTest.java; java -cp ../junit.jar:. org.junit.runner.JUnitCore MatrixTest
  
	@Test
	public void testSum1() {
	  int[][] expected = {{ 1, 1 }, { 1, 1 }};
 	  int[][] term1 = {{ 0, 0 }, { 0, 0 }};
	  int[][] term2 = {{ 1, 1 }, { 1, 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.plus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}	
	
	@Test
	public void testSum2() {
	  int[][] expected = {{ 10, 1 }, { 1, 10 }};
 	  int[][] term1 = {{ 10, 0 }, { 0, 10 }};
	  int[][] term2 = {{ 0, 1 }, { 1, 0 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.plus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}
	
	@Test // linhas diferentes
	public void testSum3() {
	  int[][] expected = null;
 	  int[][] term1 = {{ 0, 0 }};
	  int[][] term2 = {{ 1, 1 }, { 1, 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.plus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}
	
	@Test // colunas diferentes
	public void testSum4() {
	  int[][] expected = null;
 	  int[][] term1 = {{ 0, 9 }, { 0 }};
	  int[][] term2 = {{ 1, 1 }, { 1, 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.plus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}
	
	@Test // não quadrada
	public void testSum5() {
	  int[][] expected = {{ 1 }, { 1 }};
 	  int[][] term1 = {{ 0 }, { 0 }};
	  int[][] term2 = {{ 1 }, { 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.plus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}
	
	@Test // irregular
	public void testSum6() {
	  int[][] expected = {{ 1, 1 }, { 1 }};
 	  int[][] term1 = {{ 0, 0 }, { 0 }};
	  int[][] term2 = {{ 1, 1 }, { 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.plus(term2);
		
    assertArrayEquals(expected, result);
    assertArrayEquals(term1, m.values);
	}
	
	/* SUBTRACTION */
	
	@Test
	public void testSubtraction1() {
	  int[][] expected = {{ -1, -1 }, { -1, -1 }};
 	  int[][] term1 = {{ 0, 0 }, { 0, 0 }};
	  int[][] term2 = {{ 1, 1 }, { 1, 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.minus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}	
	
	@Test
	public void testSubtraction2() {
	  int[][] expected = {{ 10, -1 }, { -1, 10 }};
 	  int[][] term1 = {{ 10, 0 }, { 0, 10 }};
	  int[][] term2 = {{ 0, 1 }, { 1, 0 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.minus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}
	
	@Test // linhas diferentes
	public void testSubtraction3() {
	  int[][] expected = null;
 	  int[][] term1 = {{ 0, 0 }};
	  int[][] term2 = {{ 1, 1 }, { 1, 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.minus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}
	
	@Test // colunas diferentes
	public void testSubtraction4() {
	  int[][] expected = null;
 	  int[][] term1 = {{ 0, 9 }, { 0 }};
	  int[][] term2 = {{ 1, 1 }, { 1, 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.minus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}
	
	@Test // não quadrada
	public void testSubtraction5() {
	  int[][] expected = {{ -1 }, { -1 }};
 	  int[][] term1 = {{ 0 }, { 0 }};
	  int[][] term2 = {{ 1 }, { 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.minus(term2);
		
		assertArrayEquals(expected, result);
		assertArrayEquals(term1, m.values);
	}
	
	@Test // irregular
	public void testSubtraction6() {
	  int[][] expected = {{ -1, -1 }, { -1 }};
 	  int[][] term1 = {{ 0, 0 }, { 0 }};
	  int[][] term2 = {{ 1, 1 }, { 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.minus(term2);
		
    assertArrayEquals(expected, result);
    assertArrayEquals(term1, m.values);
	}
	
	@Test // irregular
	public void testSubtraction7() {
	  int[][] expected = {{ -1 }, { -1, -1 }};
 	  int[][] term1 = {{ 0 }, { 0, 0 }};
	  int[][] term2 = {{ 1 }, { 1, 1 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.minus(term2);
		
    assertArrayEquals(expected, result);
    assertArrayEquals(term1, m.values);
	}
	
	@Test
	public void testMultiplication1() {
	  int[][] expected = {{ 5, 6 }, { 4, 6 }};
 	  int[][] term1 = {{ 1, 2 }, { 2, 1 }};
	  int[][] term2 = {{ 1, 2 }, { 2, 2 }};
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.times(term2);
		
    assertArrayEquals(expected, result);
    assertArrayEquals(term1, m.values);
	}
	
	@Test // escalar
	public void testMultiplication2() {
	  int[][] expected = {{ 2, 4 }, { 4, 2 }};
 	  int[][] term1 = {{ 1, 2 }, { 2, 1 }};
	  int term2 = 2;
	  
		Matrix m = new Matrix(term1);
		
		int[][] result = m.times(term2);
		
    assertArrayEquals(expected, result);
    assertArrayEquals(term1, m.values);
	}
}