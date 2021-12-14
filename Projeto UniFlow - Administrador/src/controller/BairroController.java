package controller;

import dao.BairroDAO;
import model.Bairro;

public class BairroController {

    public void criarTabelaBairro(){BairroDAO bairroDAO = new BairroDAO(); bairroDAO.criaTabelaBairro();}
    public Bairro adicionarBairro(Bairro bairro){ BairroDAO bairroDAO = new BairroDAO(); return bairroDAO.adicionar(bairro);}
}
