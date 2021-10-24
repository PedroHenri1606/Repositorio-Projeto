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
    public boolean verificar(String email) {
        if(user.verificarEmail(email)) {
            return true;
        } else {
            return false;
        }
    }
    public String getMeuNome() {
        return user.getMeuNome();
    }
    public String getMeuID() {
        return user.getMeuID();
    }
    public void setMeuNome(String novoNome) {
        user.setMeuNome(novoNome);
    }
    public String getmeuEmail() {
        return user.getMeuEmail();
    }
    public void visualizarUsuarios() {
        user.visualizarUsuariosProximos();
    }
}
