
import UsuarioView;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("cadastrar usuario usuario - 1");
            System.out.println("login - 2");
            System.out.print("opcao: ");
            int escolha = Integer.parseInt(scan.nextLine());
            UsuarioView vuser = new UsuarioView();
            switch (escolha) {
                case 1:
                    vuser.cadastroUsuario();
                    break;
                case 2:
                    vuser.realizarlogin();
                    break;

            }
        }
    }
}
