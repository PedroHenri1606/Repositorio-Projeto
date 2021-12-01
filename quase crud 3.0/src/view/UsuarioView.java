package view;


import controller.UsuarioController;
import model.Bairro;
import model.Curso;
import model.Faculdade;
import model.Usuario;


import java.util.List;
import java.util.Scanner;

public class UsuarioView {
    UsuarioController usuarioController = new UsuarioController();
    BairroView bairroView = new BairroView();
    CursoView cursoView = new CursoView();
    CorridaView corridaview = new CorridaView();
    FaculdadeView faculdadeView = new FaculdadeView();
    Scanner scan = new Scanner(System.in);

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
        this.espaco();
        Scanner scan = new Scanner(System.in);

            Usuario usuarioModel = new Usuario();
            System.out.println("==============================================");
            System.out.println("       Realizando Cadastro de usuario         ");
            System.out.println("==============================================");
            System.out.print  (" Nome do usuario: ");    usuarioModel.setNome(scan.nextLine());
            System.out.print  (" Sobrenome: ");          usuarioModel.setSobrenome(scan.nextLine());
            System.out.print  (" Digite o seu Email: "); usuarioModel.setEmail(scan.nextLine());
            System.out.print  (" Senha do usuario: ");   usuarioModel.setSenha(scan.nextLine());
            usuarioModel.setBairro(this.escolhendoBairro());
            usuarioModel.setCurso(this.escolhendoCurso());
            usuarioModel.setDestino(this.escolhendoFaculdade());
            usuarioModel.setEscolha(this.escolha());
            usuarioController.realizarCadastro(usuarioModel);
        }


    public Faculdade escolhendoFaculdade() {
        while (true) {
            System.out.println("==============================================");
            faculdadeView.listarFaculdades();
            System.out.println("==============================================");
            System.out.println("              Escolha uma opção             \n");
            System.out.println("       [1] Cadastrar Faculdade");
            System.out.println("       [2] Selecionar Faculdade");
            System.out.println("==============================================");
            switch (Integer.parseInt(scan.nextLine())) {
                case 1 -> faculdadeView.cadastrar();
                case 2 ->{ return faculdadeView.selecionarFaculdade();}
            }
        }
    }

    public Bairro escolhendoBairro() {

        while (true) {
            System.out.println("==============================================");
            bairroView.visualizar();
            System.out.println("==============================================");
            System.out.println("            Escolha uma opção  \n");
            System.out.println("       [1] - Cadastrar novo bairro");
            System.out.println("       [2] - Escolher um Bairro");
            System.out.println("==============================================");
            System.out.print  ("Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> bairroView.cadastrarBairro();
                case 2 -> {return this.escolherBairro();}
            }
        }
    }

    public Bairro escolherBairro() {
        long idBairro;
        List<Bairro> bairros = bairroView.visualizar();
        System.out.println("==============================================");
        System.out.print  ("Informe bairro escolhido: "); idBairro = Long.parseLong(scan.nextLine());

        for (int i = 0; i< bairros.size(); i++) {
            if (bairros.get(i).getId() == idBairro) {
                return bairros.get(i);
            }
        }
        return null;
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
            System.out.print  (" Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> cursoView.cadastrarCurso();
                case 2 -> {return this.escolherCurso();}
            }
        }
    }

    public Curso escolherCurso() {

        long idCurso;
        List<Curso> cursos = cursoView.listar();
        System.out.println("==============================================");
        System.out.print  ("Informe o Id: "); idCurso = Long.parseLong(scan.nextLine());

        for (int i = 0; i< cursos.size(); i++) {
            if (cursos.get(i).getId() == idCurso) {
                return cursos.get(i);
            }
        }
        return null;
    }

    public long escolha() {

        long resposta = 0;

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("==============================================");
            System.out.println("Informe se deseja ser Motorista ou Passageiro");
            System.out.println("==============================================");
            System.out.println("      [1] - Motorista   [2] - Passageiro ");
            System.out.println("==============================================");
            System.out.print  (" Infome Opção: "); int opcao = scan.nextInt();
            System.out.println("==============================================");
            switch (opcao) {
                case 1 -> resposta = 1;
                case 2 -> resposta = 2;
            }
            return resposta;
        }
    }

    public void realizarlogin() {

        Scanner scan = new Scanner(System.in);
        String tmp1, tmp2;
        System.out.println("============================================");
        System.out.println("            Realizando Login");
        System.out.print  (" Email: "); tmp1 = scan.nextLine();
        System.out.print  (" Senha: "); tmp2 = scan.nextLine();

        if (usuarioController.realizarLogin(tmp1, tmp2)) {
            Usuario usuarioAtual = usuarioController.determinarUsuario(tmp1, tmp2);
            this.menu(usuarioAtual);
        } else {
            System.out.println("==============================================");
            System.out.println("       Usuario ou senha incorreta!!:(         ");
            System.out.println("==============================================");
        }
    }

    public void menu(Usuario userAtual) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("==============================================");
            System.out.println(" Bem Vindo: " + userAtual.getNome() + "\n");
            System.out.println(" [1] - Visualizar colegas de carona ");
            System.out.println(" [2] - Criar corrida");
            System.out.println(" [3] - Visualizar minhas corridas");
            System.out.println(" [4] - Selecionar Corrida");
            System.out.println(" [5] - Configuracoes");
            System.out.println(" [6] - Sair");
            System.out.println("==============================================");
            int escolha = Integer.parseInt(scan.nextLine());

            switch (escolha) {
                case 1 ->  this.visualizarUsuariosProximos(userAtual);
                case 2 ->  corridaview.cadastrarCorrida(userAtual);
                case 3 ->  corridaview.visualizarCorrida(userAtual);
                case 4 ->  corridaview.escolherCorrida(userAtual);
                case 5 -> this.configuracoes(userAtual);
                case 6 -> { return;}
            }
        }
    }

    public void visualizarUsuariosProximos(Usuario usuario) {
        List<Usuario> usuarios = usuarioController.visualizarUsuarios(usuario);
        for (Usuario usuario1 : usuarios) {
            System.out.println("Nome: " + usuario1.getNome() + " | Email: " + usuario1.getEmail());
        }
    }

    public void configuracoes(Usuario usuarioAtual) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==============================================");
            System.out.println("            Modificar Dados");
            System.out.println("==============================================");
            System.out.println("     [1] nome de usuario");
            System.out.println("     [2] senha");
            System.out.println("     [3] sair");
            System.out.println("==============================================");
            System.out.print  (" Informe opção: "); int escolha = Integer.parseInt(scanner.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> { usuarioAtual = this.modificarnome(usuarioAtual); this.salvarAlteracoes(usuarioAtual);}
                case 2 -> { usuarioAtual = this.modificarSenha(usuarioAtual); this.salvarAlteracoes(usuarioAtual);}
                case 3 -> { return; }
            }
        }
    }

    public void salvarAlteracoes(Usuario usuario) {usuarioController.editarDados(usuario);}

    public Usuario modificarSenha(Usuario usuarioAtual) {
        if (validar(usuarioAtual)) {
            System.out.println("Digite uma nova Senha: "); usuarioAtual.setSenha(scan.nextLine());
            System.out.println("==============================================");
        }
        return usuarioAtual;
    }

    public Usuario modificarnome(Usuario usuarioAtual) {
        if (validar(usuarioAtual)) {
            System.out.println("Digite um novo Nome: "); usuarioAtual.setNome(scan.nextLine());
            System.out.println("==============================================");
        }
        return usuarioAtual;
    }

    public boolean validar(Usuario usuarioAtual) {

        System.out.print("Digite a Senha Atual: "); String senha = scan.nextLine();
        System.out.println("==============================================");

        if (usuarioAtual.getSenha().equals(senha)) {
            return usuarioAtual.getSenha().equals(senha);
        } else {
            System.out.println("     -Senha invalida - Tente Novamente-");
            System.out.println("==============================================");
            return usuarioAtual.getSenha().equals(senha);
        }
    }

    public void espaco() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }
}

