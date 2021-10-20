package controller;

import DAO.DaoUsuario;
import model.UsuarioModel;

public class UsuarioController {
    DaoUsuario user = new DaoUsuario();
    public void carregar() {
        user.carregar();
    }
    public void realizarCadastro(UsuarioModel al) {
        user.adicionar(al);
    }
    public boolean realizarLogin(String tmp1, String tmp2) {
        return user.login(tmp1, tmp2);
    }
    public boolean validacao(String email) {//
        if(user.validar(email)) {
            return true;
        } else {
            return false;
        }
    }
    public void visualizarUsuarios() {
        user.visualizarUsuariosProximos();
    }
}
