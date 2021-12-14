package controller;

import DAO.DaoCarroFabricante;
import model.CarroFabricante;
import java.util.List;

public class CarroFabricanteController {

    public void criarTabelaCarroFabricante(){DaoCarroFabricante daoCarroFabricante = new DaoCarroFabricante(); daoCarroFabricante.criarTabelaCarroFabricante();}
    public List<CarroFabricante> listar(){DaoCarroFabricante daoCarroFabricante = new DaoCarroFabricante(); return daoCarroFabricante.listar();}
    public CarroFabricante retornarNome(long id){ DaoCarroFabricante daoCarroFabricante = new DaoCarroFabricante();return daoCarroFabricante.retornarNome(id);}
    public CarroFabricante selecionarFabricante(int id){ DaoCarroFabricante daoCarroFabricante = new DaoCarroFabricante();return daoCarroFabricante.determinaFabricante(id);}

}
