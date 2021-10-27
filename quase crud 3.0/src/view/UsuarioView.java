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

    BairroController bairro = new BairroController();
    BairroView bairroView = new BairroView();

    CursoController curso = new CursoController();
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
            String bairro1 = "";
            String curso1 = "";
            String destino;
            String id = "";
            this.espaco();
            System.out.println("==============================================");
            System.out.println("\n   [Realizando Cadastro de usuario]\n");
            System.out.println("==============================================");
            System.out.print(" Nome do usuario: ");    nome = scan.nextLine();
            System.out.print(" Senha do usuario: ");   senha = scan.nextLine();
            System.out.print(" Digite o seu email: "); email = scan.nextLine();
            System.out.println("==============================================");
            int escolha = 0;
            while (escolha != 2) {
                System.out.println("");
                escolha = this.escolher(escolha);
                if (escolha == 1) {
                    bairroView.cadastrarBairro();
                } else if (escolha == 2) {
                    System.out.println("==============================================");
                    bairro.visualizar();
                    System.out.print("\n [Informe o bairro a partir da posição: ");
                    bairro1 = bairro.escolherBairro(Integer.parseInt(scan.nextLine()));
                    System.out.println("==============================================");
                }
                System.out.println("\n");
                 if (escolha == 3){
                    cursoView.cadastrarCurso();
                } else if (escolha == 4){
                    System.out.println("==============================================");
                    bairro.visualizar();
                    System.out.print("\n [Informe o curso a partir da posição: ");
                    curso1 = curso.escolherCursoText(Integer.parseInt(scan.nextLine()));
                    System.out.println("==============================================");
                }
            }

            System.out.print(" [Destino do usuario: "); destino = scan.nextLine();

            id = idsuario.usuarioID();
            UsuarioModel al = new UsuarioModel(nome, senha, bairro1, destino, email, id);
            if(cal.verificar(email)){
                cal.realizarCadastro(al);
                break;
            }
        }

    }

    public int escolher(int escolha) {
        Scanner scan = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.println("\n          [Escolha uma opção] \n");
        System.out.println("       [1] - Cadastrar novo bairro");
        System.out.println("       [2] - Escolher um Bairro");
        System.out.println("       [3] - Cadastrar um Curso");
        System.out.println("       [4] - Escolher um Curso");
        System.out.println("==============================================");
        //bairro.visualizar();
        System.out.print(" [Opção: ");
        escolha = Integer.parseInt(scan.nextLine());
        return escolha;
    }

    public void realizarlogin() {
        this.espaco();
        Scanner scan = new Scanner(System.in);
        String tmp1;
        String tmp2;
        System.out.println("============================================");
        System.out.println("           [Realizando Login]");
        System.out.print  (" Nome: ");
        tmp1 = scan.nextLine();
        System.out.print  (" Senha: ");
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
            System.out.println("  Ola: " + cal.getMeuNome() +"\n");
            System.out.println(" [1] - Visualizar colegas de carona ");
            System.out.println(" [2] - Criar corrida");
            System.out.println(" [3] - Visualizar minhas corridas");
            System.out.println(" [4] - Sair");
            System.out.println("==============================================");
            int escolha = Integer.parseInt(scan.nextLine());

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
                    return;
            }
        }
    }
    public void configuracoes() {
        //as opcoes de modificacao
        //escolha o que vai modificar
        //digite a senha
        //
    }
    public void espaco() {
        for (int i = 0; i < 15; i++) {
            System.out.println("");
        }
    }

    public void verificar(String email) {

    }
}
