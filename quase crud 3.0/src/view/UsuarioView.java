package view;

import controller.BairroController;
import controller.UsuarioController;
import model.UsuarioModel;

import java.util.Scanner;

public class UsuarioView {
    UsuarioController cal = new UsuarioController();
    BairroController bairro = new BairroController();
    public void carregarDados() {
        cal.carregar();
    }
    public void cadastroUsuario() {
        this.espaco();
        Scanner scan = new Scanner(System.in);

        while (true) {
            String nome;
            String senha;
            String email;
            String bairro1;
            String destino;
            System.out.println("realizando cadastro de usuario!!");
            System.out.println("");
            System.out.println("----------------------------------");
            System.out.print("nome do usuario: ");
            nome = scan.nextLine();
            System.out.print("senha do usuario: ");
            senha = scan.nextLine();
            System.out.print("digite o seu email: ");
            email = scan.nextLine();
            bairro.visualizar();
            System.out.print("digite qual bairro voce deseja a partir da posicao: ");
            bairro1 = bairro.escolherBairro(Integer.parseInt(scan.nextLine()));
            System.out.print("destino do usuario: ");
            destino = scan.nextLine();
            UsuarioModel al = new UsuarioModel(nome,senha,bairro1,destino,email);
            cal.verificar(email);
            cal.realizarCadastro(al);
            break;
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
    public void verificar(String email) {

    }
}
