import java.io.EOFException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

/**
*
* @author Baiano
*/
public class Teste {

	public static void mostra(RandomAccessFile arq){
		String resp="";
		
		try{
			arq.seek(0);
			while(true)	resp+= arq.readInt()+" ";
		} catch(EOFException f){
			JOptionPane.showMessageDialog(null,resp);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null,"Falha na exibição");
		}
	}
	
	public static void ordena(RandomAccessFile arq) throws Exception{
		for(long i=1; i<(arq.length()-1/4) ; i++) metodoInsercao(arq, i);
	}
	
	public static void metodoInsercao(RandomAccessFile arq, long p) throws Exception{
		int aux;
		long j = 0;
		
		arq.seek(p*4);
		
		if (arq.getFilePointer() < arq.length()) { // verificando se ainda nao eh o fim do arquivo
		
			int daPos = arq.readInt();
			arq.seek(j*4);
			int daJ = arq.readInt();
		
			while((daJ<=daPos)&& (j<p)){
				j++;
				arq.seek(j*4);
				daJ=arq.readInt();
			}
		
			for(long i=p; i>j;i--){
				arq.seek((i-1)*4);
				aux=arq.readInt();
				arq.writeInt(aux);
			}
		
			arq.seek(j*4);
			arq.writeInt(daPos);
		}
	}
	
	public static void main(String[] args) {
		try{
			RandomAccessFile arquivo = new RandomAccessFile("teste","rw");
			
			arquivo.setLength(0);
			
			for(int i=0;i<7;i++) arquivo.writeInt((int)(1+Math.random()*11));
			
			mostra(arquivo);
			ordena(arquivo);
			mostra(arquivo);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}