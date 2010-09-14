import java.util.Scanner;
import java.io.*;

class Selecao implements Serializable {
	String nome;
	int jogos, vitorias, empates, derrotas, gols, golsRecebidos;
	static Selecao[] tabela = new Selecao[32];
	
	Selecao(String n) {
		nome = n;
	}
	
	public String toString() {
		return nome + "\t\t " + jogos + "\t " + vitorias + "\t " + empates + "\t " + derrotas + "\t " + gols + "\t " + golsRecebidos;
	}
	
	static void salvar() throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objetos.bin"));
		
		for (Selecao selecao: tabela) out.writeObject(selecao);
		
		out.close();
	}
	
	static void recuperar() throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("objetos.bin"));
		
		tabela = new Selecao[32];
		
		for (int i = 0; i < tabela.length; i++) tabela[i] = (Selecao) in.readObject();
		
		in.close();
	}
	
	static void carregarResultados(String nomeArquivo) throws Exception {
		Scanner arquivo = new Scanner(new File(nomeArquivo));
		
		while (arquivo.hasNextLine()) {
			String[] resultadoSelecaoA = { arquivo.nextLine(), arquivo.nextLine() };
			String[] resultadoSelecaoB = { arquivo.nextLine(), arquivo.nextLine() };
			
			Selecao selecaoA = buscar(resultadoSelecaoA[0]);
			Selecao selecaoB = buscar(resultadoSelecaoB[0]);
			
			selecaoA.jogos++;
			selecaoB.jogos++;
			
			if (selecaoA != null && selecaoB != null) {
				selecaoA.gols += Integer.parseInt(resultadoSelecaoA[1]);
				selecaoA.golsRecebidos += Integer.parseInt(resultadoSelecaoB[1]);
				
				selecaoB.gols += Integer.parseInt(resultadoSelecaoB[1]);
				selecaoB.golsRecebidos += Integer.parseInt(resultadoSelecaoA[1]);
				
				if (Integer.parseInt(resultadoSelecaoA[1]) == Integer.parseInt(resultadoSelecaoB[1])) {
					selecaoA.empates++;
					selecaoB.empates++;
				} else if (Integer.parseInt(resultadoSelecaoA[1]) > Integer.parseInt(resultadoSelecaoB[1])) {
					selecaoA.vitorias++;
					selecaoB.derrotas++;
				} else {
					selecaoA.derrotas++;
					selecaoB.vitorias++;
				}
			}
		}
	}
	
	static Selecao buscar(String nome) {
		for (Selecao s: Selecao.tabela) {
			if (s.nome.equals(nome)) return s;
		}
		
		return null;
	}
	
	static void carregarSelecoes(String nomeArquivo) throws Exception {
		Scanner arquivo = new Scanner(new File(nomeArquivo));
		
		for (int i = 0; i < 32 && arquivo.hasNextLine(); i++) tabela[i] = new Selecao(arquivo.nextLine());
		
		arquivo.close();
	}
	
	static void mostrarSelecoes() {
		for (Selecao s: Selecao.tabela) System.out.println(s + "\t");
	}
}