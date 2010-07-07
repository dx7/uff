class Tabela {
	
	public static void main(String[] args) throws Exception {
		Selecao.carregarSelecoes("selecoes.txt");
		Selecao.carregarResultados("resultados.txt");
		Selecao.salvar();
		Selecao.recuperar();
		Selecao.mostrarSelecoes();
	}
}