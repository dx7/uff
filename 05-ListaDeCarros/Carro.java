import java.io.Serializable;

class Carro implements Serializable {
  public String marca, cor, modelo, chassi, placa;
  public int ano, potencia, km;
  
  public Carro(String mo, String ma, int a) {
    modelo = mo;
    marca = ma;
    ano = a;
  }
  
  public String toString() {
    return modelo + " " + marca + " " + ano;
  }
}