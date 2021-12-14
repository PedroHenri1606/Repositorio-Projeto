package view;

import controller.UsuarioController;
import model.Usuario;

import javax.swing.*;

public class UsuarioView {


    public void login() {

        UsuarioView usuarioView = new UsuarioView();
        Usuario userAtual;

        String codigoAcesso = JOptionPane.showInputDialog(null, "      Login\n\n" + "Codigo de Acesso: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);
        String senha = JOptionPane.showInputDialog(null, "      Login\n\n" + "Senha: ", "UniFlow", JOptionPane.INFORMATION_MESSAGE);

        UsuarioController usuarioController = new UsuarioController();

        if (usuarioController.sistemaDeSeguranca()) {
            if (usuarioController.login(Long.parseLong(codigoAcesso), senha)){
                userAtual = usuarioController.determinarUsuarioAtual(Long.parseLong(codigoAcesso),senha);
                this.menu(userAtual);
            } else {
                usuarioView.cadastrarUsuario();
            }
        }
    }

    public void cadastrarUsuario(){

        Usuario usuario = new Usuario();

        String nome =   JOptionPane.showInputDialog(null,"      CADASTRO ADMIN\n\n"+"Nome: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        String codigo = JOptionPane.showInputDialog(null,"      CADASTRO ADMIN\n\n"+"Codigo: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);
        String senha =  JOptionPane.showInputDialog(null,"      CADASTRO ADMIN\n\n"+"Senha: ","UniFlow",JOptionPane.INFORMATION_MESSAGE);

        usuario.setNome(nome);
        usuario.setCodigoAcesso(Long.parseLong(codigo));
        usuario.setSenha(senha);

        UsuarioController usuarioController = new UsuarioController();
        usuarioController.adicionarUsuario(usuario);
    }

    public String menuExibir(Usuario usuario){
        String[] escolhas = {"1","2","3","4","5","6"};
        String menuTexto = "[1] - Adicionar Bairro\n[2] - Adicionar Curso\n[3] - Adicionar Faculdade\n[4] - Adicionar Fabricante\n[5] - Adicionar Modelo de Veiculo\n[6] - Adicionar Cor de Veiculo";
        return (String) JOptionPane.showInputDialog(null, "  Bem Vindo: " + usuario.getNome()+"\n\n" + menuTexto, "UniFlow", JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);
    }

    public void menu(Usuario usuario) {

        BairroView bairroView = new BairroView();
        CursoView cursoView = new CursoView();
        FaculdadeView faculdadeView = new FaculdadeView();
        FabricanteView fabricanteView = new FabricanteView();
        CarroNomeView carroNomeView = new CarroNomeView();
        CarroCorView carroCorView = new CarroCorView();

        while (true) {
            String opcao = menuExibir(usuario);

            switch (opcao) {
                case "1" -> bairroView.adicionarBairro();
                case "2" -> cursoView.adicionarCurso();
                case "3" -> faculdadeView.adicionarFaculdade();
                case "4" -> fabricanteView.adicionarFabricante();
                case "5" -> carroNomeView.adicionarNomeCarro();
                case "6" -> carroCorView.adicionarCorCarro();
            }
        }
    }
}
