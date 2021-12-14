package controller;

import dao.FaculdadeDAO;
import model.Faculdade;

public class FaculdadeController {

    public void criarTabelaFaculdade(){FaculdadeDAO faculdadeDAO = new FaculdadeDAO(); faculdadeDAO.criarTabelaFaculdade();}
    public Faculdade adicionarFaculdade(Faculdade faculdade){ FaculdadeDAO faculdadeDAO = new FaculdadeDAO(); return faculdadeDAO.cadastrarFaculdade(faculdade);}
}
