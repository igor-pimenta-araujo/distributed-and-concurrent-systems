public class Deadlock {
    
    static class Amigo {

        private final String nome;

        public Amigo(String nome) {
            this.nome = nome;
        }

        public String getnome() {
            return this.nome;
        }

        public synchronized void virarDeCostas(Amigo amigo) {
            System.out.format("%s: %s"
                    + "  virou de costas para mim!%n",
                    this.nome, amigo.getnome());
            amigo.desvirar(this);
        }

        public synchronized void desvirar(Amigo amigo) {
            System.out.format("%s: %s"
                    + " está de bem comigo!%n",
                    this.nome, amigo.getnome());
        }
    }

    public static void main(String[] args) {
        final Amigo joao =
                new Amigo("João");
        final Amigo maria =
                new Amigo("Maria");
        new Thread(new Runnable() {

            public void run() {
                joao.virarDeCostas(maria);
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                maria.virarDeCostas(joao);
            }
        }).start();
    }
}
