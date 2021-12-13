package controller;

import DAO.DaoCarroNome;
import model.CarroNome;
import java.util.List;

public class CarroNomeController {

    public void criarTabelaCarroNome(){DaoCarroNome daoCarroNome = new DaoCarroNome(); daoCarroNome.criarTabelaCarroNome(); }
    public CarroNome adicionar (CarroNome carroNome){DaoCarroNome daoCarroNome = new DaoCarroNome(); return daoCarroNome.adicionar(carroNome);}
    public List<CarroNome> listar(){DaoCarroNome daoCarroNome = new DaoCarroNome(); return daoCarroNome.listar();}
    public CarroNome retornarNome(long id){ DaoCarroNome daoCarroNome = new DaoCarroNome();return daoCarroNome.retornarNome(id);}
    public CarroNome selecionarNome(int id){DaoCarroNome daoCarroNome = new DaoCarroNome(); return daoCarroNome.determinaCurso(id);}
}
