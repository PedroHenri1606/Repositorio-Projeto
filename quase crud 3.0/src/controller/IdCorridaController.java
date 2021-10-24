package controller;

import DAO.IdCorridaDAO;

public class IdCorridaController {
    IdCorridaDAO x = new IdCorridaDAO();

    public String determinarID(){
        String tmp1 = Integer.toString(x.determinarID());
                return tmp1;
    }
}
