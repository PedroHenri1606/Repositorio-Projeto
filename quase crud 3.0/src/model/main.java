package model;

import view.BairroView;
import view.UsuarioView;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        UsuarioView vuser = new UsuarioView();
        BairroView vbairro = new BairroView();
        vbairro.carregarDados();
        vuser.carregarDados();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("cadastrar usuario usuario - 1");
            System.out.println("login - 2");
            System.out.print("opcao: ");
            int escolha = Integer.parseInt(scan.nextLine());
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
