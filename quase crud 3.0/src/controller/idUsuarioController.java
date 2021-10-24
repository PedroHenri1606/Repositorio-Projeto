package controller;

import DAO.idUsuarioDAO;

public class idUsuarioController {
    idUsuarioDAO aux = new idUsuarioDAO();
    public String usuarioID() {
        String tmp1 = Integer.toString(aux.usuarioID());
        return tmp1;
    }
}
