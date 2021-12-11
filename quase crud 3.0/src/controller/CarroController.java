package controller;

import DAO.DaoCarro;
import model.Carro;

public class CarroController {

    DaoCarro daoCarro = new DaoCarro();

    public void criarTabelaCarro(){ daoCarro.criarTabelaCarro();}
    public Carro cadastrarCarro(Carro carro){ return daoCarro.adicionar(carro);}
    public Carro retornarDados(long id){ return daoCarro.retornarDados(id);}
    public Carro determinarCarro(long id){ return daoCarro.determinarCarro(id);}
    public Carro retornarDadosCorrida(long id){ return daoCarro.retornarDadosCorrida(id);}
}
