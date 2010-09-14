public class Mapa {
	
	public Recurso[][] matriz = {
					{ new Recurso (1, 1), new Recurso (2, 1), new Recurso (1, 1) },
					{ new Recurso (2, 2), new Recurso (3, 4), new Recurso (2, 1) },
					{ new Recurso (1, 1), new Recurso (2, 2), new Recurso (1, 2) }
					};
	
	public int[] menorCusto() {
		int [] caminho = {1 , 1};
		return caminho;
	}
	
}