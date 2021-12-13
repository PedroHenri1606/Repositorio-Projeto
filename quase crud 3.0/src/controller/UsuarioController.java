package controller;

import DAO.DaoUsuario;
import model.Usuario;

import java.util.List;

public class UsuarioController {

    public void CriarTabelaUsuario() {DaoUsuario daoUsuario = new DaoUsuario();daoUsuario.criarTabelaUsuario();}
    public void realizarCadastro(Usuario al) { DaoUsuario daoUsuario = new DaoUsuario();daoUsuario.adicionar(al);}
    public boolean realizarLogin(String tmp1, String tmp2) {DaoUsuario daoUsuario = new DaoUsuario();return daoUsuario.login(tmp1, tmp2);}
    public Usuario determinarUsuario(String email, String senha) {DaoUsuario daoUsuario = new DaoUsuario();return daoUsuario.determinarUsuarioAtual(email, senha);}
    public void editarDados(Usuario usuario) {DaoUsuario daoUsuario = new DaoUsuario();daoUsuario.editar(usuario);}
    public List<Usuario> visualizarUsuarios(Usuario usuario) {DaoUsuario daoUsuario = new DaoUsuario();return daoUsuario.visualizarUsuariosProximos(usuario);}
    public Usuario retornarDado(long id){DaoUsuario daoUsuario = new DaoUsuario();return daoUsuario.retornaDados(id);}
}
