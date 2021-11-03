package view;

import controller.UsuarioController;
import model.UsuarioModel;

import java.util.Scanner;

public class UsuarioView {
    UsuarioController cal = new UsuarioController();
    public void carregarDados() {
        cal.carregar();
    }
    public void cadastroUsuario() {
        this.espaco();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String tmp1;
            String tmp2;
            String tmp3;
            String tmp4;
            String tmp5;
            System.out.println("realizando cadastro de usuario!!");
            System.out.println("");
            System.out.println("----------------------------------");
            System.out.print("nome do usuario: ");
            tmp1 = scan.nextLine();
            System.out.print("senha do usuario: ");
            tmp2 = scan.nextLine();
            System.out.print("digite o seu email: ");
            tmp5 = scan.nextLine();
            System.out.print("bairro do usuario: ");
            tmp3 = scan.nextLine();
            System.out.print("destino do usuario: ");
            tmp4 = scan.nextLine();
            UsuarioModel al = new UsuarioModel(tmp1,tmp2,tmp3,tmp4,tmp5);
            boolean emailDisponivel = cal.validacao(tmp5);
            if(emailDisponivel) {
                cal.realizarCadastro(al);
                break;
            } else {
                this.espaco();
                System.out.println("email indisponivel!!");
            }
        }

    }
    public void realizarlogin() {
        this.espaco();
        Scanner scan = new Scanner(System.in);
        String tmp1;
        String tmp2;
        System.out.print("nome: ");
        tmp1 = scan.nextLine();
        System.out.print("senha: ");
        tmp2 = scan.nextLine();
        if(cal.realizarLogin(tmp1,tmp2)) {
            cal.visualizarUsuarios();
        } else {
            System.out.println("usuario ou senha incorreta!!:(");
        }
    }
    public void espaco() {
        for (int i = 0; i<30; i++) {
            System.out.println("");
        }
    }
}
