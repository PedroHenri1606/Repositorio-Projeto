package view;

import controller.UsuarioController;
import controller.idUsuarioController;
import model.UsuarioModel;


import java.util.List;
import java.util.Scanner;

public class UsuarioView {
    UsuarioController cal = new UsuarioController();
    idUsuarioController idsuario = new idUsuarioController();
    BairroView bairroView = new BairroView();
    CursoView cursoView = new CursoView();
    CorridaView corridaview = new CorridaView();

    public void carregarDados() {
        cal.carregar();
    }

    public void cadastroUsuario() {
        this.espaco();
        Scanner scan = new Scanner(System.in);
        while (true) {
            UsuarioModel usuarioModel = new UsuarioModel();
            this.espaco();
            System.out.println("==============================================");
            System.out.println("\n   [Realizando Cadastro de usuario]\n");
            System.out.println("==============================================");
            System.out.print(" [Nome do usuario]: ");
            usuarioModel.setNome(scan.nextLine());

            System.out.print(" [Senha do usuario]: ");
            usuarioModel.setSenha(scan.nextLine());
            System.out.print(" [Digite o seu email]: ");
            usuarioModel.setEmail(scan.nextLine());
            System.out.println("==============================================");
            usuarioModel.setBairro(this.escolhendoBairro());
            usuarioModel.setCurso(this.escolhendoCurso());
            System.out.print(" [Destino do usuario]: ");
            usuarioModel.setDestino(scan.nextLine());
            usuarioModel.setId(idsuario.usuarioID());
            if (cal.verificar(usuarioModel.getEmail())) {
                cal.realizarCadastro(usuarioModel);
                break;
            }
        }

    }


    public String escolhendoBairro() {
        Scanner scan = new Scanner(System.in);
        String bairro1;
        System.out.println("\n\n\n");
        System.out.println("********[processo de escolha de bairro]**********");
        while (true) {
            System.out.println("==============================================");
            bairroView.visualizar();
            System.out.println("==============================================");
            System.out.println("==============================================");
            System.out.println("\n          [Escolha uma opção] \n");
            System.out.println("       [1] - Cadastrar novo bairro");
            System.out.println("       [2] - Escolher um Bairro");
            System.out.println("==============================================");
            System.out.print(" [escolha uma duas opcoes acima!!!]: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1 -> bairroView.cadastrarBairro();
                case 2 -> {
                    System.out.println("==============================================");
                    System.out.print("\n [bairro escolhido]: ");
                    bairro1 = bairroView.escolherBairro(Integer.parseInt(scan.nextLine()));
                    System.out.println("\n\n");
                    return bairro1;
                }
            }
        }
    }

    public String escolhendoCurso() {
        Scanner scan = new Scanner(System.in);
        String curso;
        while (true) {
            System.out.println("********[processo de escolha de curso]**********");
            System.out.println("==============================================");
            cursoView.visualizar();
            System.out.println("==============================================");
            System.out.println("==============================================");
            System.out.println("\n          [Escolha uma opção] \n");
            System.out.println("       [1] - Cadastrar novo curso");
            System.out.println("       [2] - Escolher um curso\n");
            System.out.println("==============================================");
            System.out.print(" [escolha uma duas opcoes acima!!!]: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1 -> cursoView.cadastrarCurso();
                case 2 -> {
                    System.out.println("==============================================\n");
                    System.out.print("[curso escolhido]: ");
                    curso = cursoView.escolherCurso(Integer.parseInt(scan.nextLine()));
                    System.out.println("\n\n");
                    return curso;
                }
            }
        }
    }

    public void realizarlogin() {
        this.espaco();
        Scanner scan = new Scanner(System.in);
        String tmp1, tmp2;
        System.out.println("============================================");
        System.out.println("           [Realizando Login]");
        System.out.print(" [Email]: ");
        tmp1 = scan.nextLine();
        System.out.print(" [Senha]: ");
        tmp2 = scan.nextLine();
        System.out.println("==============================================");
        if (cal.realizarLogin(tmp1, tmp2)) {
            this.menu();
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
            System.out.println(" Ola: " + cal.getMeuNome() + "\n");
            System.out.println(" [1] - Visualizar colegas de carona ");
            System.out.println(" [2] - Criar corrida");
            System.out.println(" [3] - Visualizar minhas corridas");
            System.out.println(" [4] - configuracoes");
            System.out.println(" [5] - sair");
            System.out.println("==============================================");
            int escolha = Integer.parseInt(scan.nextLine());

            switch (escolha) {
                case 1:
                    this.visualizarUsuariosProximos();
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

    public void visualizarUsuariosProximos() {
        List<UsuarioModel> aux = cal.visualizarUsuarios();
        for (UsuarioModel usuarioModel : aux) {
            System.out.println("Nome: " + usuarioModel.getNome());
        }


    }

    public void configuracoes() {
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
            System.out.println();
        }
    }
}
