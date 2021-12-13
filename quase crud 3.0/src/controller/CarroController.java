package controller;

import DAO.DaoCarro;
import model.Carro;

public class CarroController {

    public void criarTabelaCarro(){ DaoCarro daoCarro = new DaoCarro();daoCarro.criarTabelaCarro();}
    public Carro cadastrarCarro(Carro carro){ DaoCarro daoCarro = new DaoCarro();return daoCarro.adicionar(carro);}
    public Carro retornarDados(long id){DaoCarro daoCarro = new DaoCarro(); return daoCarro.retornarDados(id);}
    public Carro determinarCarro(long id){ DaoCarro daoCarro = new DaoCarro();return daoCarro.determinarCarro(id);}
    public Carro retornarDadosCorrida(long id){DaoCarro daoCarro = new DaoCarro(); return daoCarro.retornarDadosCorrida(id);}
}
