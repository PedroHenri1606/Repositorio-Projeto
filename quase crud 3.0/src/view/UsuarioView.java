package view;

import controller.BairroController;
import controller.UsuarioController;
import controller.idUsuarioController;
import controller.CursoController;

import model.UsuarioModel;

import java.util.Scanner;

public class UsuarioView {
    UsuarioController cal = new UsuarioController();
    idUsuarioController idsuario = new idUsuarioController();

    BairroController bairroController = new BairroController();
    BairroView bairroView = new BairroView();

    CursoController cursoController = new CursoController();
    CursoView cursoView = new CursoView();

    CorridaView corridaview = new CorridaView();

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
            String curso1;
            String destino;
            String id;
            this.espaco();
            System.out.println("==============================================");
            System.out.println("\n   [Realizando Cadastro de usuario]\n");
            System.out.println("==============================================");
            System.out.print(" Nome do usuario: ");
            nome = scan.nextLine();
            System.out.print(" Senha do usuario: ");
            senha = scan.nextLine();
            System.out.print(" Digite o seu email: ");
            email = scan.nextLine();
            System.out.println("==============================================");
            bairro1 = this.escolhendoBairro();
            curso1 = this.escolhendoCurso();
            System.out.print(" Destino do usuario: ");
            destino = scan.nextLine();
            id = idsuario.usuarioID();
            UsuarioModel al = new UsuarioModel(nome, senha, bairro1, destino, email, id, curso1);
            if (cal.verificar(email)) {
                cal.realizarCadastro(al);
                break;
            }
        }

    }


    public String escolhendoBairro() {
        Scanner scan = new Scanner(System.in);
        String bairro1 = "";
        while (true) {
            bairroView.visualizar();
            System.out.println("==============================================");
            System.out.println("\n          [Escolha uma opção] \n");
            System.out.println("       [1] - Cadastrar novo bairro");
            System.out.println("       [2] - Escolher um Bairro");
            System.out.println("==============================================");
            System.out.print(" Opção: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1:
                    bairroView.cadastrarBairro();
                    break;
                case 2:
                    System.out.println("==============================================");
                    System.out.print("\n [Informe o bairro a partir da posição: ");
                    bairro1 = bairroView.escolherBairro(Integer.parseInt(scan.nextLine()));
                    return bairro1;
            }
        }
    }

    public String escolhendoCurso() {
        Scanner scan = new Scanner(System.in);
        String curso = "";
        while (true) {
            cursoView.visualizar();
            System.out.println("==============================================");
            System.out.println("\n          [Escolha uma opção] \n");
            System.out.println("       [1] - Cadastrar novo curso");
            System.out.println("       [2] - Escolher um curso");
            System.out.println("==============================================");
            System.out.print(" Opção: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1:
                    bairroView.cadastrarBairro();
                    break;
                case 2:
                    System.out.println("==============================================");
                    System.out.print("\n [Informe o bairro a partir da posição: ");
                    curso = cursoView.escolherCurso(Integer.parseInt(scan.nextLine()));
                    return curso;
            }
        }
    }

    public void realizarlogin() {
        this.espaco();
        Scanner scan = new Scanner(System.in);
        String tmp1;
        String tmp2;
        System.out.println("============================================");
        System.out.println("           [Realizando Login]");
        System.out.print(" [Nome]: ");
        tmp1 = scan.nextLine();
        System.out.print(" [Senha]: ");
        tmp2 = scan.nextLine();
        System.out.println("==============================================");
        if (cal.realizarLogin(tmp1, tmp2)) {
            this.menu();
            return;
        } else {
            System.out.println("==============================================");
            System.out.println("      [Usuario ou senha incorreta!!:(]        ");
            System.out.println("==============================================");
        }
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("==============================================");
            System.out.println(" Ola: " + cal.getMeuNome() + "]\n");
            System.out.println(" [1] - Visualizar colegas de carona ");
            System.out.println(" [2] - Criar corrida");
            System.out.println(" [3] - Visualizar minhas corridas");
            System.out.println(" [4] configuracoes");
            System.out.println(" [5] sair");
            int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");

            switch (escolha) {
                case 1:
                    cal.visualizarUsuarios();
                    break;
                case 2:
                    corridaview.cadastrarCorrida(cal.getMeuID());
                    break;
                case 3:
                    corridaview.visualizar(cal.getMeuID());
                    break;
                case 4:
                    this.configuracoes();
                    break;
                case 5:
                    return;
            }
        }
    }

    public void configuracoes() {
        //as opcoes de modificacao
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[modificar dados]");
            System.out.println("[1] nome de usuario");
            System.out.println("[2] senha");
            System.out.println("[3] sair");
            int escolha = Integer.parseInt(scanner.nextLine());
            switch (escolha) {
                case 1:
                    this.modificarNome();
                    break;
                case 2:
                    this.modificarSenha();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void modificarNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("[senha atual]: ");
        String senhaAtual = scanner.nextLine();
        if (senhaAtual.equals(cal.getMinhaSenha())) {
            System.out.println("\n\n");
            System.out.println("[senha correta ]");
            System.out.print("[novo nome] = ");
            cal.setMeuNome(scanner.nextLine());
        } else {
            System.out.println("[senha incorreta]");
        }

    }

    public void modificarSenha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("senha atual: ");
        String senhaAtual = scanner.nextLine();
        if (senhaAtual.equals(cal.getMinhaSenha())) {
            System.out.println("\n\n");
            System.out.println("[senha correta]");
            System.out.print("[nova senha] = ");
            cal.setMinhaSenha(scanner.nextLine());
        } else {
            System.out.println("[senha incorreta]");
        }

    }

    public void espaco() {
        for (int i = 0; i < 15; i++) {
            System.out.println("");
        }
    }

    public void verificar(String email) {

    }
}
