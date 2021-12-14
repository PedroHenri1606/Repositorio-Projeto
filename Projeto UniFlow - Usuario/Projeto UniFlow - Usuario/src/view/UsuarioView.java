package view;

import controller.*;
import model.*;
import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class UsuarioView {

    public String menuInicioExibir() {
            String[] escolhas = {"1", "2"};
            String menuTexto = "[1] - Realizar Login\n[2] - Cadastrar Usuário";
            return (String) JOptionPane.showInputDialog(null, "              Bem Vindo\n\n" + menuTexto, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
        }

        public void menuInicio(){

        while(true){
            String opcao = menuInicioExibir();

            switch (opcao) {
                case "1" -> this.realizarlogin();
                case "2" -> this.cadastroUsuario();
            }
        }
    }

    public void cadastroUsuario() {

        Usuario usuarioModel = new Usuario();
        BairroController bairroController = new BairroController();
        FaculdadeController faculdadeController = new FaculdadeController();
        CursoController cursoController = new CursoController();

        String nome = JOptionPane.showInputDialog(null,"      Realizando Cadastro de Usuario\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        usuarioModel.setNome(nome);
        String sobrenome = JOptionPane.showInputDialog(null,"      Realizando Cadastro de Usuario\n\n"+"Sobrenome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        usuarioModel.setSobrenome(sobrenome);
        String email = JOptionPane.showInputDialog(null,"      Realizando Cadastro de Usuario\n\n"+"Email: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        usuarioModel.setEmail(email);
        String senha = JOptionPane.showInputDialog(null,"      Realizando Cadastro de Usuario\n\n"+"Senha: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        usuarioModel.setSenha(senha);

        int id=0;
        id = this.escolhendoBairro(id);
        usuarioModel.setBairro(bairroController.selecionaBairro(id));

        int id2=0;
        id2 = this.escolhendoCurso(id2);
        usuarioModel.setCurso(cursoController.selecionaCurso(id2));

        int id3=0;
        id3 = this.escolhendoFaculdade(id3);
        usuarioModel.setDestino(faculdadeController.selecionaFaculdade(id3));

        usuarioModel.setSexo(this.escolherSexo());
        usuarioModel.setEscolha(this.escolha());

        UsuarioController usuarioController = new UsuarioController();
        usuarioController.realizarCadastro(usuarioModel);

        Usuario user = usuarioController.determinarUsuario(usuarioModel.getEmail(),usuarioModel.getSenha());

        CarroView carroView = new CarroView();
        if (usuarioModel.getEscolha() == 1) {
            usuarioModel.setCarro(carroView.cadastrarCarro( user));
        }
    }

    public int escolhendoBairro(int id) {

        BairroView bairroView = new BairroView();
        List<Bairro> list;
        list = bairroView.visualizar();
        String[] object = new String[list.size()];
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        int i = 0;

        try{
            for(Bairro bairro: list){
                object[i] = (bairro.getId() + "|" + bairro.getNome());

                i++;
            }

            Object selectionObjetec = JOptionPane.showInputDialog(frame,"Escolha um Bairro:","UniFlow",JOptionPane.QUESTION_MESSAGE,null,object,object[0]);
            String tmp = selectionObjetec.toString();
            StringTokenizer st = new StringTokenizer(tmp);
            id = Integer.valueOf(st.nextToken("|"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public int escolhendoCurso(int id2) {

        CursoView cursoView = new CursoView();
        List<Curso> list;
        list = cursoView.listar();
        String[] object = new String[list.size()];
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        int i = 0;

        try{
            for(Curso curso: list){
                object[i] = (curso.getId() + "|" + curso.getNome());

                i++;
            }

            Object selectionObjetec = JOptionPane.showInputDialog(frame,"Escolha um Curso:","UniFlow",JOptionPane.QUESTION_MESSAGE,null,object,object[0]);
            String tmp = selectionObjetec.toString();
            StringTokenizer st = new StringTokenizer(tmp);
            id2 = Integer.valueOf(st.nextToken("|"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return id2;
    }

    public int escolhendoFaculdade(int id3) {

        FaculdadeView faculdadeView = new FaculdadeView();
        List<Faculdade> list;
        list = faculdadeView.listarFaculdades();
        String[] object = new String[list.size()];
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        int i = 0;

        try{
            for(Faculdade faculdade: list){
                object[i] = (faculdade.getIdFaculdade() + "|" + faculdade.getNome());

                i++;
            }

            Object selectionObjetec = JOptionPane.showInputDialog(frame,"Escolha uma Faculdade:","UniFlow",JOptionPane.QUESTION_MESSAGE,null,object,object[0]);
            String tmp = selectionObjetec.toString();
            StringTokenizer st = new StringTokenizer(tmp);
            id3 = Integer.valueOf(st.nextToken("|"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return id3;
    }

    public String escolhaExibir(){
        String[] escolhas = {"1", "2"};
        String menuEscolha = "[1] - Motorista\n[2] - Passageiro";
        return (String) JOptionPane.showInputDialog(null, "         Selecione uma opção\n\n" + menuEscolha, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public int escolha() {

        while(true){
            String opcao = escolhaExibir();

            switch (opcao) {
                case "1" : return 1;
                case "2" : return 2;
            }
        }
    }

    public String escolherSexoExibir(){
        String[] escolhas = {"1", "2"};
        String menuSexo = "[1] - Homem\n[2] - Mulher";
        return (String) JOptionPane.showInputDialog(null, "         Selecione o seu Sexo\n\n" + menuSexo, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public long escolherSexo(){
        while(true){
            String opcao = escolherSexoExibir();

            switch (opcao) {
                case "1" : return 1;
                case "2" : return 2;
            }
        }
    }

    public void realizarlogin() {

        String email = JOptionPane.showInputDialog("Login\n Email: ");
        String senha = JOptionPane.showInputDialog("Login\n Senha: ");

        UsuarioController usuarioController = new UsuarioController();
        CarroController carroController = new CarroController();

        if (usuarioController.realizarLogin(email, senha)) {
            Usuario usuarioAtual = usuarioController.determinarUsuario(email, senha);
            Carro carroAtual = carroController.determinarCarro(usuarioAtual.getIdUsuario());
            if(usuarioAtual.getEscolha() == 1) {
                this.menuMotorista(usuarioAtual,carroAtual);
            } else{
                this.menuPassageiro(usuarioAtual, carroAtual);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Usuario ou senha incorreta!");
        }
    }

    public String menuMotoristaExibir(Usuario userAtual) {
        String[] escolhas = {"1", "2", "3", "4"};
        String menuMotorista = "Bem Vindo: " + userAtual.getNome()+ "\n"+"[1] - Menu Corridas\n[2] - Historico de Corridas\n[3] - Configurações\n[4] - Sair";
        return (String) JOptionPane.showInputDialog(null, menuMotorista, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public void menuMotorista(Usuario userAtual, Carro carroAtual) {

        CorridaView corridaview = new CorridaView();

        while (true) {
            String  opcao = menuMotoristaExibir(userAtual);

            switch (opcao) {
                case "1" ->  this.menuCorrida(userAtual, carroAtual);
                case "2" ->  corridaview.visualizarMinhasCorrida(userAtual, carroAtual);
                case "3" ->  this.configuracoes(userAtual);
                case "4" ->  { return;}
            }
        }
    }

    public String menuCorridaPassageiroExibir(){

        String[] escolhas = {"1", "2", "3"};
        String menuCorridaPassageiro = "[1] - Escolher Corrida\n[2] - Visualizar Usuarios próximos\n[3] - Voltar";
        return (String) JOptionPane.showInputDialog(null, menuCorridaPassageiro, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public void menuCorridaPassageiro(Usuario userAtual){

        CorridaView corridaview = new CorridaView();

        while (true) {
            String opcao = menuCorridaPassageiroExibir();

            switch (opcao) {
                case "1":
                    corridaview.visualizarCorridasPendentes();
                    corridaview.escolherCorridaPassageiro(userAtual);
                    break;
                case "2":
                    this.visualizarUsuariosProximos(userAtual);
                    break;
                case "3":
                    return;
            }
        }
    }

    public String menuPassageiroExibir(Usuario userAtual){

        String[] escolhas = {"1", "2", "3","4"};
        String menuPassageiro = "Bem Vindo: " + userAtual.getNome()+ "\n"+"[1] - Menu Corridas\n[2] - Historico de Corridas\n[3] - Configurações\n[4] - Sair";
        return (String) JOptionPane.showInputDialog(null, menuPassageiro, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public void menuPassageiro(Usuario userAtual, Carro carroAtual) {

        CorridaView corridaview = new CorridaView();

        while (true) {
            String opcao = menuPassageiroExibir(userAtual);

            switch (opcao) {
                case "1" ->  this.menuCorridaPassageiro(userAtual);
                case "2" ->  corridaview.visualizarMinhasCorrida(userAtual,carroAtual);
                case "3" ->  this.configuracoes(userAtual);
                case "4" ->  { return;}
            }
        }
    }

    public String menuCorridaExibir(){

        String[] escolhas = {"1", "2", "3","4"};
        String menuCorrida = "[1] - Criar Corrida\n[2] - Visualizar Usuarios próximos\n[3] - Historico de Corridas\n[4]- Voltar";
        return (String) JOptionPane.showInputDialog(null, menuCorrida, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public void menuCorrida(Usuario userAtual, Carro carroAtual) {

        CorridaView corridaview = new CorridaView();

        while (true) {
            String opcao = menuCorridaExibir();

            switch (opcao) {
                case "1" -> corridaview.cadastrarCorrida(userAtual);
                case "2" -> this.visualizarUsuariosProximos(userAtual);
                case "3" -> corridaview.escolherCorrida(userAtual, carroAtual);
                case "4" -> {return;}
            }
        }
    }


    public void visualizarUsuariosProximos(Usuario usuario) {

        UsuarioController usuarioController = new UsuarioController();

        List<Usuario> list = usuarioController.visualizarUsuarios(usuario);
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String output = "";

            for (Usuario usuario1 : list) {
                String tmp = "NOME : " + usuario1.getNome() + " | EMAIL: " + usuario1.getEmail();
                output += tmp + " \n\n";
            }
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum Usuario encontrado!", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(frame, output);
        }
    }

    public String configuracoesExibir(){

        String[] escolhas = {"1", "2", "3"};
        String menuConfiguracoes = "[1] - Nome de Usuario\n[2] - Senha\n[3] - Sair";
        return (String) JOptionPane.showInputDialog(null, menuConfiguracoes, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public void configuracoes(Usuario usuarioAtual) {

        while (true) {
            String opcao = configuracoesExibir();
            switch (opcao) {
                case "1" -> { usuarioAtual = this.modificarnome(usuarioAtual); this.salvarAlteracoes(usuarioAtual);}
                case "2" -> { usuarioAtual = this.modificarSenha(usuarioAtual); this.salvarAlteracoes(usuarioAtual);}
                case "3" -> { return; }
            }
        }
    }

    public void salvarAlteracoes(Usuario usuario) {
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.editarDados(usuario);
    }

    public Usuario modificarSenha(Usuario usuarioAtual) {

        if (validar(usuarioAtual)) {
            String senha = JOptionPane.showInputDialog(null,"      Alterar Senha\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
            usuarioAtual.setSenha(senha);
        }
        return usuarioAtual;
    }

    public Usuario modificarnome(Usuario usuarioAtual) {

        if (validar(usuarioAtual)) {
            String nome= JOptionPane.showInputDialog(null,"      Alterar Nome\n\n"+"Senha: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
            usuarioAtual.setNome(nome);
        }
        return usuarioAtual;
    }

    public boolean validar(Usuario usuarioAtual) {

        String senha = JOptionPane.showInputDialog(null,"      Validando Senha\n\n"+"Senha: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        if (usuarioAtual.getSenha().equals(senha)) {
            return usuarioAtual.getSenha().equals(senha);
        } else {
            JOptionPane.showMessageDialog(null,"Senha Incorreta!","UniFlow",JOptionPane.INFORMATION_MESSAGE);
            return usuarioAtual.getSenha().equals(senha);
        }
    }

}

