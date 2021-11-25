package view;

import controller.UsuarioController;
import model.Bairro;
import model.Curso;
import model.Usuario;


import java.util.List;
import java.util.Scanner;

public class UsuarioView {
    UsuarioController usuarioController = new UsuarioController();
    BairroView bairroView = new BairroView();
    CursoView cursoView = new CursoView();
    CorridaView corridaview = new CorridaView();
    Scanner scan = new Scanner(System.in);


    public void cadastroUsuario() {
        this.espaco();
        Scanner scan = new Scanner(System.in);
        while (true) {
            Usuario usuarioModel = new Usuario();
            this.espaco();
            System.out.println("==============================================");
            System.out.println("\n   [Realizando Cadastro de usuario]\n");
            System.out.println("==============================================");

            System.out.print(" [Nome do usuario]: ");
            usuarioModel.setNome(scan.nextLine());
            System.out.print("[sobrenome]: ");
            usuarioModel.setSobrenome(scan.nextLine());
            System.out.print(" [Senha do usuario]: ");
            usuarioModel.setSenha(scan.nextLine());
            System.out.print(" [Digite o seu email]: ");
            usuarioModel.setEmail(scan.nextLine());
            usuarioModel.setBairro(this.escolhendoBairro());
            usuarioModel.setCurso(this.escolhendoCurso());
            System.out.print("[Destino do usuario]: ");
            usuarioModel.setDestino(scan.nextLine());
            usuarioController.realizarCadastro(usuarioModel);
            break;
        }

    }


    public Bairro escolhendoBairro() {
        long idBairro;
        while (true) {
            System.out.println("\n\n\n");
            System.out.println("********[processo de escolha de bairro]**********");
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
                    return this.escolherBairro();
                }
            }
        }
    }
    public Bairro escolherBairro() {
        long idCurso;
        List<Bairro> bairros = bairroView.visualizar();
        System.out.println("==============================================\n");
        System.out.print("[digite o id do bairro escolhido]: ");
        idCurso = Long.parseLong(scan.nextLine());
        for (int i = 0; i< bairros.size(); i++) {
            if (Long.parseLong(bairros.get(i).getId()) == idCurso) {
                return bairros.get(i);
            }
        }
        System.out.println("\n\n");
        return null;
    }
    public Curso escolhendoCurso() {
        while (true) {
            System.out.println("********[processo de escolha de curso]**********");
            System.out.println("==============================================");
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
                    return this.escolherCurso();
                }
            }
        }
    }

    public Curso escolherCurso() {
        long idCurso;
        List<Curso> cursos = cursoView.visualizar();
        System.out.println("==============================================\n");
        System.out.print("[digite o id do curso escolhido]: ");
        idCurso = Long.parseLong(scan.nextLine());
        for (int i = 0; i< cursos.size(); i++) {
            if (Long.parseLong(cursos.get(i).getId()) == idCurso) {
                return cursos.get(i);
            }
        }
        System.out.println("\n\n");
        return null;
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
        if (usuarioController.realizarLogin(tmp1, tmp2)) {
            Usuario usuarioAtual = usuarioController.determinarUsuario(tmp1, tmp2);
            this.menu(usuarioAtual);
        } else {
            System.out.println("==============================================");
            System.out.println("      [Usuario ou senha incorreta!!:(]        ");
            System.out.println("==============================================");
        }
    }

    public void menu(Usuario userAtual) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("==============================================");
            System.out.println("usuario atual: " + userAtual.getNome());
            System.out.println(" [1] - Visualizar colegas de carona ");
            System.out.println(" [2] - Criar corrida");
            System.out.println(" [3] - Visualizar minhas corridas");
            System.out.println(" [4] - selecionar Corrida");
            System.out.println(" [5] - configuracoes");
            System.out.println(" [6] - sair");
            System.out.println("==============================================");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1:
                    this.visualizarUsuariosProximos(userAtual);
                    break;
                case 2:
                    corridaview.cadastrarCorrida(userAtual);
                    break;
                case 3:
                    corridaview.visualizarCorrida(userAtual);
                    break;
                case 4:
                    corridaview.escolherCorrida(userAtual);
                    break;
                case 5:
                    this.configuracoes(userAtual);
                    break;
                case 6:
                    return;
            }
        }
    }

    public void visualizarUsuariosProximos(Usuario usuario) {
        List<Usuario> usuarios = usuarioController.visualizarUsuarios(usuario);
        for (Usuario usuario1 : usuarios) {
            System.out.println("nome: " + usuario1.getNome() + " email: " + usuario1.getEmail());
        }
    }

    public void linhaDupla() {
        System.out.println("==============================================");
    }

    public void configuracoes(Usuario usuarioAtual) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            this.linhaDupla();
           // System.out.println(usuarioAtual.toString());
            System.out.println("[modificar dados]");
            System.out.println("[1] nome de usuario");
            System.out.println("[2] senha");
            System.out.println("[3] sair");
            System.out.print("digite: ");
            int escolha = Integer.parseInt(scanner.nextLine());
            this.linhaDupla();
            switch (escolha) {
                case 1 -> {
                    usuarioAtual = this.modificarnome(usuarioAtual);
                    this.salvarAlteracoes(usuarioAtual);
                }
                case 2 -> {
                    usuarioAtual = this.modificarSenha(usuarioAtual);
                    this.salvarAlteracoes(usuarioAtual);
                }
                case 3 -> {
                    return;
                }
            }
        }
    }

    public void salvarAlteracoes(Usuario usuario) {
        usuarioController.editarDados(usuario);
    }

    public Usuario modificarSenha(Usuario usuarioAtual) {
        if (validar(usuarioAtual)) {
            System.out.println("digite uma nova senha: ");
            usuarioAtual.setSenha(scan.nextLine());
        }
        return usuarioAtual;
    }

    public Usuario modificarnome(Usuario usuarioAtual) {
        if (validar(usuarioAtual)) {
            System.out.println("digite um novo nome: ");
            usuarioAtual.setNome(scan.nextLine());
        }
        return usuarioAtual;
    }

    public boolean validar(Usuario usuarioAtual) {
        System.out.println("digite a senha atual: ");
        String senha = scan.nextLine();
        if (usuarioAtual.getSenha().equals(senha)) {
            return usuarioAtual.getSenha().equals(senha);
        } else {
            System.out.println("tente novamente");
            return usuarioAtual.getSenha().equals(senha);
        }
    }

    public void espaco() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }
}
