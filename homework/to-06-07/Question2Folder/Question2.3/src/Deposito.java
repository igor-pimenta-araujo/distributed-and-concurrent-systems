public class Deposito {
    private int items = 0;
    private final int capacidade = 10;

    public synchronized int retirar() {
        if (items > 0) {
            items--;
            System.out.println("Caixa retirada: Sobram " + items + " caixas");
            return 1;
        }
        return 0;
    }

    public synchronized int colocar() {
        if (items < capacidade) {
            items++;
            System.out.println("Caixa armazenada: Passaram a ser " + items + " caixas");
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Deposito dep = new Deposito();
        Produtor produtor = new Produtor(dep, 1);
        Consumidor consumidor = new Consumidor(dep, 1);

        Thread tProdutor = new Thread(produtor);
        Thread tConsumidor = new Thread(consumidor);

        tProdutor.start();

        synchronized (tProdutor) {
            try {
                System.out.println("Aguardando o produtor terminar a produção");
                tProdutor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Total de items é igual a: " + dep.items);
            tProdutor.notifyAll();
        }

        tConsumidor.start();

        synchronized (tConsumidor) {
            try {
                System.out.println("Aguardando o consumidor terminar a consumação");
                tConsumidor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Total de items é igual a: " + dep.items);
        }

        System.out.println("Execução do main da classe Deposito terminada!");
    }
}