package controller;

import dao.FabricanteDAO;
import model.CarroFabricante;

public class FabricanteController {

    public void criarTabelaFabricante(){FabricanteDAO fabricanteDAO = new FabricanteDAO(); fabricanteDAO.criarTabelaCarroFabricante();}
    public CarroFabricante adicionarFabricante(CarroFabricante carroFabricante){ FabricanteDAO fabricanteDAO = new FabricanteDAO(); return fabricanteDAO.adicionar(carroFabricante);}
}
