package controller;

import DAO.idDAO;

public class IdBairroController {
    idDAO x = new idDAO();
    public String determinarID() {
        String tmp1 = Integer.toString(x.determinarID());
        return tmp1;
    }
}
