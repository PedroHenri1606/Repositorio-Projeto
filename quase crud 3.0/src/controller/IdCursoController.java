package controller;

import DAO.IdCursoDAO;

public class IdCursoController {
    IdCursoDAO x = new IdCursoDAO();
    public String determinarID(){
        String tmp1 = Integer.toString(x.determinarID());
        return tmp1;
    }
}
