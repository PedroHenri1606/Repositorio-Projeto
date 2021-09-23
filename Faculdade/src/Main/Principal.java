package Main;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Cliente novoUsuario;
        novoUsuario = new Cliente();

        novoUsuario.nome = "Pedro Henrique";
        novoUsuario.email = "pedrohenri1606@gmail.com";
        novoUsuario.curso = "Eng.Software";
        novoUsuario.dataNascimento = "18";
        novoUsuario.login = false;


        if (novoUsuario.login == false) {
            novoUsuario.status();
            novoUsuario.conexao();
            novoUsuario.teste();
        }
        if (novoUsuario.login == true) {
            novoUsuario.telaInicio();
        }
    }
}