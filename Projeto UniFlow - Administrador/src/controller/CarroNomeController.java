package controller;

import dao.NomeCarroDAO;
import model.CarroNome;

public class CarroNomeController {

    public void criarTabelaCarroNome(){NomeCarroDAO nomeCarroDAO = new NomeCarroDAO(); nomeCarroDAO.criarTabelaCarroNome();}
    public CarroNome adicionarNome(CarroNome carroNome){ NomeCarroDAO nomeCarroDAO = new NomeCarroDAO(); return nomeCarroDAO.adicionar(carroNome);}
}
