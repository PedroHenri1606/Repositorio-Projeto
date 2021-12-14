package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

    public void criarTabelaUsuarioADM(){UsuarioDAO usuarioDAO = new UsuarioDAO(); usuarioDAO.criarTabelaADM();}
    public void adicionarUsuario(Usuario usuario){ UsuarioDAO usuarioDAO = new UsuarioDAO(); usuarioDAO.adicionarUsuario(usuario);}
    public boolean login(long codigo,String senha){ UsuarioDAO usuarioDAO = new UsuarioDAO(); return usuarioDAO.login(codigo,senha);}
    public Usuario determinarUsuarioAtual(long codigo, String senha){ UsuarioDAO usuarioDAO = new UsuarioDAO(); return usuarioDAO.determinarUsuarioAtual(codigo,senha);}
    public boolean sistemaDeSeguranca(){ UsuarioDAO usuarioDAO = new UsuarioDAO(); return usuarioDAO.sistemaDeSeguranca();}
}
