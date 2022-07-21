public class RecursoDesprotegido {
    public static void main(String[] args) {

        Tela recurso = new Tela(); // Criação do recurso a ser compartilhado
        // ** Criando as threads

        UserSemControle usSem01 = new UserSemControle("Usuario 01", recurso);
        UserSemControle usSem02 = new UserSemControle("Usuario 02", recurso);
        UserSemControle usSem03 = new UserSemControle("Usuario 03", recurso);
        UserSemControle usSem04 = new UserSemControle("Usuario 04", recurso);
        // ** Executando as threads

        usSem04.start();
        usSem01.start();
        usSem03.start();
        usSem02.start();
    }
}