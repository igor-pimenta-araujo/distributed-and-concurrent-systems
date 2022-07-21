public class App {
    public static void main(String[] args) throws Exception {
        Lebre lebre = new Lebre("Lebron");
        Lebre lebre2 = new Lebre("Lebretwo");
        Lebre lebre3 = new Lebre("Lebrethree");
        Lebre[] lebres = {lebre, lebre2, lebre3};


        lebre.start();
        lebre2.start();
        lebre3.start();

        lebre.join();
        lebre2.join();
        lebre3.join();

        bubbleSort(lebres);

        System.out.println("-------------------------");
        System.out.println("Classificação:");
        System.out.println("-------------------------");

        for (Lebre l : lebres) {
            System.out.println(l.nome + " pulou " + l.getMetrosPulados() + " metros e " + l.getQuantidadePulos() + " pulos");
        }      
    }

    private static void bubbleSort(Lebre vetor[]){
        boolean troca = true;
        Lebre aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i].getTempoExec() > vetor[i + 1].getTempoExec()) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
}
}
