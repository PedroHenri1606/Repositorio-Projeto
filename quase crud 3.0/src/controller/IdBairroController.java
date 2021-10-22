package controller;

import DAO.IdBairroDAO;

public class IdBairroController {
    IdBairroDAO x = new IdBairroDAO();
    public String determinarID() {
        String tmp1 = Integer.toString(x.determinarID());
        return tmp1;
    }
}
