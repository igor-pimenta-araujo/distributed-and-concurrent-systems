public class Deposito {
    private int items = 0;
    private final int capacidade = 10;

    public int retirar() {
        if (items > 0) {
            items--;
            System.out.println("Caixa retirada: Sobram " + items + " caixas");
            return 1;
        }
        return 0;
    }

    public int colocar() {
        if (items < capacidade) {
            items++;
            System.out.println("Caixa armazenada: Passaram a ser " + items + "caixas");
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Deposito dep = new Deposito();
        Produtor produtor = new Produtor(dep, 2);
        Consumidor consumidor = new Consumidor(dep, 1);
        
        Thread tProdutor = new Thread(produtor);
        Thread tConsumidor = new Thread(consumidor);

        tProdutor.start();
        tConsumidor.start();

        try{
            tProdutor.join();
            tConsumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Execução do main da classe Deposito terminada!");
    }
}