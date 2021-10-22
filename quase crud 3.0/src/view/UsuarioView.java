package view;

import controller.BairroController;
import controller.UsuarioController;
import model.UsuarioModel;

import java.util.Scanner;

public class UsuarioView {
    UsuarioController cal = new UsuarioController();
    BairroController bairro = new BairroController();
    BairroView bairroView = new BairroView();

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
            String bairro1 = "";
            String destino;
            this.espaco();
            System.out.println("----------------------------------------------");
            System.out.println("\n   [Realizando Cadastro de usuario]\n");
            System.out.println("----------------------------------------------");
            System.out.print(" Nome do usuario: ");    nome = scan.nextLine();
            System.out.print(" Senha do usuario: ");   senha = scan.nextLine();
            System.out.print(" Digite o seu email: "); email = scan.nextLine();
            int escolha = 0;
            while (escolha != 2) {
                System.out.println("");
                escolha = this.escolher(escolha);
                if (escolha == 1) {
                    bairroView.cadastrarBairro();
                } else if (escolha == 2) {
                    System.out.println("----------------------------------------------");
                    System.out.print("\n [Informe o bairro a partir da posição: ");
                    bairro1 = bairro.escolherBairro(Integer.parseInt(scan.nextLine()));
                    System.out.println("----------------------------------------------");
                }
                System.out.println("\n");
            }
            System.out.println("----------------------------------------------");
            System.out.print(" [Destino do usuario: "); destino = scan.nextLine();
            System.out.println("----------------------------------------------");
            UsuarioModel al = new UsuarioModel(nome, senha, bairro1, destino, email);

            if(cal.verificar(email)){
                cal.realizarCadastro(al);
                break;
            }
        }

    }

    public int escolher(int escolha) {
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("\n          [Escolha uma opção] \n");
        System.out.println("       [1] - Cadastrar novo bairro");
        System.out.println("       [2] - Escolher um bairro");
        System.out.println("----------------------------------------------");
        //bairro.visualizar();
        System.out.print(" Opção: ");
        escolha = Integer.parseInt(scan.nextLine());
        return escolha;
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
        if (cal.realizarLogin(tmp1, tmp2)) {
            cal.visualizarUsuarios();
        } else {
            System.out.println("usuario ou senha incorreta!!:(");
        }
    }

    public void espaco() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }

    public void verificar(String email) {

    }
}
