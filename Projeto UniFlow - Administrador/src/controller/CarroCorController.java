package controller;

import dao.CarroCorDAO;
import model.CarroCor;

public class CarroCorController {

    public void criarTabelaCarroCor(){CarroCorDAO carroCorDAO = new CarroCorDAO(); carroCorDAO.criarTabelaCarroCor();}
    public CarroCor adicionarCor(CarroCor carroCor){ CarroCorDAO carroCorDAO = new CarroCorDAO(); return carroCorDAO.adicionar(carroCor);}
}
