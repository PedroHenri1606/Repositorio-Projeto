package controller;

import DAO.DAOFaculdade;
import model.Faculdade;
import java.util.List;

public class FaculdadeController {

    public List<Faculdade> listarFaculdade() {
        DAOFaculdade daoFaculdade = new DAOFaculdade();
        return daoFaculdade.listarFaculdade();
    }

    public void criarTabelaFaculdade() {
        DAOFaculdade daoFaculdade = new DAOFaculdade();
        daoFaculdade.criarTabelaFaculdade();
    }

    public Faculdade selecionaFaculdade(int id) {
        DAOFaculdade daoFaculdade = new DAOFaculdade();
        return daoFaculdade.determinaFaculdade(id);
    }
}