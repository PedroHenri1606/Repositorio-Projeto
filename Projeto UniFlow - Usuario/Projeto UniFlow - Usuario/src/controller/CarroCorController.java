package controller;

import DAO.DaoCarroCor;
import model.CarroCor;
import java.util.List;

public class CarroCorController {

    public void criarTabelaCarroCor(){DaoCarroCor daoCarroCor = new DaoCarroCor(); daoCarroCor.criarTabelaCarroCor();}
    public List<CarroCor> listar (){DaoCarroCor daoCarroCor = new DaoCarroCor(); return daoCarroCor.listar();}
    public CarroCor retornarCor(long id){DaoCarroCor daoCarroCor = new DaoCarroCor(); return daoCarroCor.retornarCor(id);}
    public CarroCor selecionarCor(int id){DaoCarroCor daoCarroCor = new DaoCarroCor(); return daoCarroCor.determinaCor(id);}
}
