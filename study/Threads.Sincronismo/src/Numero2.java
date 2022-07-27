

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Numero2 {
	private int numero;
	private boolean disponivel;
	private Lock trava = new ReentrantLock();
	private Condition condicao = trava.newCondition();

	Numero2(int numero) {
		this.numero = numero;
		this.disponivel = false;
	}

	public int consumir(String idThread) {
		try {
			trava.lock();
			while (this.disponivel == false) {
				try {
					// this.wait();
					condicao.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("  Consumidor " + idThread + "\t consumiu: \t" + this.numero);
			this.disponivel = false;
			// notifyAll();
			condicao.signalAll();
		} finally {
			trava.unlock();
			return this.numero;
		}
	}

	public synchronized void produzir(String idThread, int valor) {
		try {
			trava.lock();
			while (this.disponivel == true) {
				try {
					// this.wait();
					condicao.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.disponivel = true;
			this.numero = valor;
			// notifyAll();
			condicao.signalAll();
			System.out.println("Produtor " + idThread + "\t produziu: \t" + valor);

		} finally {
			trava.unlock();
		}

	}

}
