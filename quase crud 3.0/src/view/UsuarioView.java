package view;

import DAO.DaoBairro;
import DAO.DaoCurso;
import controller.BairroController;
import controller.CursoController;
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
    Bairro bairro = new Bairro();

    public void menuInicio() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("==============================================");
            System.out.println("              Escolha uma opção             \n");
            System.out.println("        [1]- Realizar Login ");
            System.out.println("        [2]- Cadastrar novo Usuario");
            System.out.println("==============================================");
            System.out.print(" Opção: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1 -> this.realizarlogin();
                case 2 -> this.cadastroUsuario();
            }
        }
    }


    public void cadastroUsuario() {

        Scanner scan = new Scanner(System.in);
        while (true) {
            Usuario usuarioModel = new Usuario();

            System.out.println("==============================================");
            System.out.println("       Realizando Cadastro de usuario");
            System.out.println("==============================================");
            System.out.print("Nome: ");      usuarioModel.setNome(scan.nextLine());
            System.out.print("Sobrenome: "); usuarioModel.setSobrenome(scan.nextLine());
            System.out.print("Email: ");     usuarioModel.setEmail(scan.nextLine());
            System.out.print("Senha: ");     usuarioModel.setSenha(scan.nextLine());
            usuarioModel.setBairro(this.escolhendoBairro());
            usuarioModel.setCurso(this.escolhendoCurso());
            System.out.print("Destino: ");   usuarioModel.setDestino(scan.nextLine());
            usuarioController.realizarCadastro(usuarioModel);
            break;
        }

    }

    public Bairro escolhendoBairro() {
        while (true) {
            System.out.println("==============================================");
            bairroView.visualizar();
            System.out.println("==============================================");
            System.out.println("              Escolha uma opção             \n");
            System.out.println("       [1] - Cadastrar Bairro");
            System.out.println("       [2] - Escolher Bairro");
            System.out.println("==============================================");
            System.out.print  ("Opção: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1 -> bairroView.cadastrarBairro();
                case 2 -> {return this.escolherBairro();}
            }
        }
    }

    public Bairro escolherBairro() {
        Bairro bairro = new Bairro();
        BairroController bairroController = new BairroController();

        long idBairro;
        System.out.println("==============================================");
        System.out.print("Informe o ID do Bairro: ");
        idBairro = Long.parseLong(scan.nextLine());
        bairro.setNome(bairroController.escolherBairro(idBairro));
        bairro.setId(bairroController.escolherbairroID(idBairro));
        System.out.println("==============================================");
        return bairro;
    }


    public Curso escolhendoCurso() {
        while (true) {
            System.out.println("==============================================");
            cursoView.listar();
            System.out.println("==============================================");
            System.out.println("              Escolha uma opção             \n");
            System.out.println("       [1] - Cadastrar Curso");
            System.out.println("       [2] - Escolher Curso");
            System.out.println("==============================================");
            System.out.print  ("Opção: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1 -> cursoView.cadastrarCurso();
                case 2 -> {return this.escolherCurso();}
            }
        }
    }

    public Curso escolherCurso() {
        Curso curso = new Curso();
        CursoController cursoController = new CursoController();

        long idCurso;
        System.out.println("==============================================");
        System.out.print("Informe o ID do Curso: ");
        idCurso = Long.parseLong(scan.nextLine());
        curso.setNome(cursoController.escolherCurso(idCurso));
        curso.setId(cursoController.escolherCursoID(idCurso));
        System.out.println("==============================================");
        return curso;
    }

    public void realizarlogin() {

        Scanner scan = new Scanner(System.in);
        String tmp1, tmp2;
        System.out.println("==============================================");
        System.out.println("                  LOGIN                     ");
        System.out.println("==============================================");
        System.out.print("Email: ");
        tmp1 = scan.nextLine();
        System.out.print("Senha: ");
        tmp2 = scan.nextLine();

        if (usuarioController.realizarLogin(tmp1, tmp2)) {
            Usuario usuarioAtual = usuarioController.determinarUsuario(tmp1, tmp2);
            this.menu(usuarioAtual);
        } else {
            System.out.println("      Usuario ou senha incorreta!! :(        ");
            System.out.println("==============================================");
        }
    }

    public void menu(Usuario userAtual) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("==============================================");
            System.out.println(" Usuario: " + userAtual.getNome() + "\n");
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
            System.out.println("Nome: " + usuario1.getNome() + " |  Email: " + usuario1.getEmail());
        }
    }

    public void configuracoes(Usuario usuarioAtual) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("==============================================");
            System.out.println("               Modificar Dados                ");
            System.out.println("  [1] Nome de Usuario");
            System.out.println("  [2] Senha");
            System.out.println("  [3] Sair");
            System.out.println("==============================================");
            System.out.print  ("Opção: "); int escolha = Integer.parseInt(scanner.nextLine());
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
            System.out.println("Digite uma nova senha: ");
            usuarioAtual.setSenha(scan.nextLine());
        }
        return usuarioAtual;
    }

    public Usuario modificarnome(Usuario usuarioAtual) {
        if (validar(usuarioAtual)) {
            System.out.println("Digite um novo nome: ");
            usuarioAtual.setNome(scan.nextLine());
        }
        return usuarioAtual;
    }

    public boolean validar(Usuario usuarioAtual) {
        System.out.println("Digite a senha atual: ");
        String senha = scan.nextLine();
        if (usuarioAtual.getSenha().equals(senha)) {
            return usuarioAtual.getSenha().equals(senha);
        } else {
            System.out.println("tente novamente");
            return usuarioAtual.getSenha().equals(senha);
        }
    }

}

