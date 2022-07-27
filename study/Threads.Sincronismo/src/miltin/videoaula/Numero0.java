package miltin.videoaula;

public class Numero0 {

	private int numero;

	Numero0(int numero) {
		this.numero = numero;
	}

	public synchronized int get(String idThread) {
		System.out.println("Consumidor " + idThread + "\t consumiu: \t" + this.numero);
		return this.numero;
	}

	public synchronized void produzir(String idThread, int valor) {
		this.numero = valor;
		System.out.println("Produtor " + idThread + "\t produziu: \t" + valor);
	}

}
